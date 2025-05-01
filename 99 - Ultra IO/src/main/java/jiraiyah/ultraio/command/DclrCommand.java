/***********************************************************************************
 * Copyright (c) 2025 Alireza Khodakarami (Jiraiyah)                               *
 * ------------------------------------------------------------------------------- *
 * MIT License                                                                     *
 * =============================================================================== *
 * Permission is hereby granted, free of charge, to any person obtaining a copy    *
 * of this software and associated documentation files (the "Software"), to deal   *
 * in the Software without restriction, including without limitation the rights    *
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell       *
 * copies of the Software, and to permit persons to whom the Software is           *
 * furnished to do so, subject to the following conditions:                        *
 * ------------------------------------------------------------------------------- *
 * The above copyright notice and this permission notice shall be included in all  *
 * copies or substantial portions of the Software.                                 *
 * ------------------------------------------------------------------------------- *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR      *
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,        *
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE     *
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER          *
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,   *
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE   *
 * SOFTWARE.                                                                       *
 ***********************************************************************************/

package jiraiyah.ultraio.command;

import com.mojang.brigadier.arguments.StringArgumentType;
import jiraiyah.ultraio.command.suggestion.DclrSuggestionProvider;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.command.CommandManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Objects;

import static jiraiyah.ultraio.Main.REFERENCE;
import static jiraiyah.ultraio.Main.CONFIGS;

public class DclrCommand
{
    public DclrCommand()
    {
        throw new AssertionError("This class should not be instantiated");
    }

    public static void init()
    {
        if (FabricLoader.getInstance().isDevelopmentEnvironment())
        {
            CommandRegistrationCallback.EVENT.register((((dispatcher, registryAccess, environment) ->
            {
                dispatcher.register(CommandManager.literal("dclr")
                                                  .then(CommandManager.argument("clear_operation_type", StringArgumentType.string())
                                                                      .suggests(new DclrSuggestionProvider())
                                                                      .executes(context ->
                                                                                {
                                                                                    String typ = StringArgumentType.getString(context, "clear_operation_type");
                                                                                    if (Objects.equals(typ, ""))
                                                                                        typ = "all";

                                                                                    if (!Objects.equals(typ, "ore") &&
                                                                                        !Objects.equals(typ, "block") &&
                                                                                        !Objects.equals(typ, "fluid") &&
                                                                                        !Objects.equals(typ, "all"))
                                                                                    {
                                                                                        context.getSource().sendFeedback(() ->
                                                                                                                                 REFERENCE.translate(REFERENCE.DCLR_ERROR_ID_NAME), false);
                                                                                    }
                                                                                    else
                                                                                    {
                                                                                        PlayerEntity player = context.getSource().getPlayer();

                                                                                        if (player != null)
                                                                                        {
                                                                                            MinecraftServer server = player.getServer();
                                                                                            BlockPos position = player.getBlockPos();

                                                                                            int minX = position.getX() - CONFIGS.DCLR_RADIUS;
                                                                                            int maxX = position.getX() + CONFIGS.DCLR_RADIUS;
                                                                                            int minZ = position.getZ() - CONFIGS.DCLR_RADIUS;
                                                                                            int maxZ = position.getZ() + CONFIGS.DCLR_RADIUS;

                                                                                            context.getSource().sendFeedback(() ->
                                                                                                                                     REFERENCE.translate(REFERENCE.DCLR_START_ID_NAME), false);

                                                                                            BlockState state;
                                                                                            String name;
                                                                                            BlockPos pos;

                                                                                            World world = player.getWorld();

                                                                                            for (int y = -64; y <= 128; y++)
                                                                                            {
                                                                                                for (int x = minX; x <= maxX; x++)
                                                                                                {
                                                                                                    for (int z = minZ; z <= maxZ; z++)
                                                                                                    {
                                                                                                        pos = new BlockPos(x, y, z);
                                                                                                        state = world.getBlockState(pos);
                                                                                                        // This is for getting the name of a block, I will keep it here for learning
                                                                                                        //name = Registries.BLOCK.getEntry(state.getBlock()).getKey().orElseThrow().getValue().getPath();
                                                                                                        if (x == minX || x == maxX || z == minZ || z == maxZ)
                                                                                                        {
                                                                                                            if (y <= 65 && state.isIn(REFERENCE.DCLR_FLUID_WHITELIST))
                                                                                                                world.setBlockState(pos, Blocks.OBSIDIAN.getDefaultState(), Block.NOTIFY_ALL);
                                                                                                            else if (state.isIn(REFERENCE.DCLR_FLUID_WHITELIST) &&
                                                                                                                     !state.isOf(Blocks.AIR))
                                                                                                                world.setBlockState(pos, Blocks.OBSIDIAN.getDefaultState(), Block.NOTIFY_ALL);
                                                                                                        }
                                                                                                        else if (minX < x && x < maxX &&
                                                                                                                 minZ < z && z < maxZ &&
                                                                                                                 blockInList(typ, state))
                                                                                                            world.setBlockState(pos, Blocks.AIR.getDefaultState(), Block.NOTIFY_ALL);
                                                                                                    }
                                                                                                }
                                                                                            }

                                                                                            context.getSource().sendFeedback(() ->
                                                                                                                                     REFERENCE.translate(REFERENCE.DCLR_END_ID_NAME), false);
                                                                                        }
                                                                                    }
                                                                                    return 1;
                                                                                })));
            })));
        }
    }

    private static boolean blockInList(String typ, BlockState state)
    {
        if(Objects.equals(typ, "ore"))
            return state.isIn(REFERENCE.DCLR_ORE_WHITELIST);
        if(Objects.equals(typ, "block"))
            return state.isIn(REFERENCE.DCLR_BLOCK_WHITELIST);
        if(Objects.equals(typ, "fluid"))
            return state.isIn(REFERENCE.DCLR_FLUID_WHITELIST);
        return state.isIn(REFERENCE.DCLR_BLOCK_WHITELIST) ||
               state.isIn(REFERENCE.DCLR_ORE_WHITELIST);
    }
}