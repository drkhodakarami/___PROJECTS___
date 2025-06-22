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

package jiraiyah.ultraio.blockentity.goo;

import jiraiyah.jibase.interfaces.ITickLogic;
import jiraiyah.jibase.properties.BEProperties;
import jiraiyah.jibase.properties.BlockEntityFields;
import jiraiyah.ultraio.registry.ModBlockEntities;
import jiraiyah.ultraio.registry.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.WallTorchBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

import static jiraiyah.ultraio.Main.CONFIGS;

public class BridgeGooBE extends GooBaseBE<BridgeGooBE>
{
    public BridgeGooBE(BlockPos pos, BlockState state)
    {
        super(ModBlockEntities.BRIDGE_GOO, pos, state);
        this.properties.setTickLogic(new TickLogic());
    }

    static class TickLogic implements ITickLogic<BridgeGooBE, BlockEntityFields<BridgeGooBE>>
    {
        @Override
        public void tick(BEProperties<BridgeGooBE> properties)
        {
            BridgeGooBE entity = properties.blockEntity();
            World world = entity.getWorld();
            BlockPos pos = entity.getPos();

            if(shouldNotTick(world, pos))
                return;

            Direction facing = entity.properties.fields().getField("player.facing", Direction.class).getValue();
            BlockPos newPos;
            BlockPos temp;

            for (int z = 0; z < CONFIGS.GOO_SPREAD_DISTANCE; z++)
            {
                for (int x = -1; x < 2; x++)
                {
                    for (int y = 1; y < 4; y++)
                    {
                        newPos = pos.up(y);
                        if (facing == Direction.NORTH)
                        {
                            newPos = newPos.north(z);
                            newPos = newPos.east(x);
                        }
                        if (facing == Direction.SOUTH)
                        {
                            newPos = newPos.south(z);
                            newPos = newPos.west(x);
                        }
                        if (facing == Direction.EAST)
                        {
                            newPos = newPos.east(z);
                            newPos = newPos.south(x);
                        }
                        if (facing == Direction.WEST)
                        {
                            newPos = newPos.west(z);
                            newPos = newPos.north(x);
                        }
                        processBlock(world, newPos, entity, ModBlocks.AIR_BOMB_GOO);
                    }
                }

                if(facing == Direction.NORTH)
                {
                    newPos = pos.north(z);
                    for (int x = -1; x < 2; x++)
                    {
                        temp = newPos.east(x);
                        if(!world.getBlockState(temp).isOf(ModBlocks.BRIDGE_GOO))
                            processBlock(world, temp, entity, ModBlocks.STONE_BOMB_GOO);
                        processBlock(world, temp.up(4), entity, ModBlocks.STONE_BOMB_GOO);
                    }

                    newPos = pos.north(z).up();
                    temp = newPos.east(-2);
                    processBlock(world, temp, entity, ModBlocks.STONE_BOMB_GOO);
                    processBlock(world, temp.up(2), entity, ModBlocks.STONE_BOMB_GOO);

                    temp = newPos.east(2);
                    processBlock(world, temp, entity, ModBlocks.STONE_BOMB_GOO);
                    processBlock(world, temp.up(2), entity, ModBlocks.STONE_BOMB_GOO);

                    newPos = pos.north(z).up(2);
                    temp = newPos.east(-2);

                    if(z % 2 != 0)
                    {
                        processBlock(world, temp, entity, ModBlocks.AIR_BOMB_GOO);
                        processBlock(world, newPos.east(2), entity, ModBlocks.AIR_BOMB_GOO);
                    }
                    else
                    {
                        processBlock(world, temp, entity, ModBlocks.STONE_BOMB_GOO);
                        processBlock(world, newPos.east(2), entity, ModBlocks.STONE_BOMB_GOO);
                    }

                    temp = newPos.east(1);
                    if(z % 8 == 0)
                        world.setBlockState(temp, Blocks.WALL_TORCH.getDefaultState()
                                                                   .with(WallTorchBlock.FACING, Direction.WEST),
                                            Block.NOTIFY_ALL);
                }

                if(facing == Direction.SOUTH)
                {
                    newPos = pos.south(z);
                    for (int x = -1; x < 2; x++)
                    {
                        temp = newPos.west(x);
                        if(!world.getBlockState(temp).isOf(ModBlocks.BRIDGE_GOO))
                            processBlock(world, temp, entity, ModBlocks.STONE_BOMB_GOO);
                        processBlock(world, temp.up(4), entity, ModBlocks.STONE_BOMB_GOO);
                    }

                    newPos = pos.south(z).up();
                    temp = newPos.west(-2);
                    processBlock(world, temp, entity, ModBlocks.STONE_BOMB_GOO);
                    processBlock(world, temp.up(2), entity, ModBlocks.STONE_BOMB_GOO);

                    temp = newPos.west(2);
                    processBlock(world, temp, entity, ModBlocks.STONE_BOMB_GOO);
                    processBlock(world, temp.up(2), entity, ModBlocks.STONE_BOMB_GOO);

                    newPos = pos.south(z).up(2);
                    temp = newPos.west(-2);

                    if(z % 2 != 0)
                    {
                        processBlock(world, temp, entity, ModBlocks.AIR_BOMB_GOO);
                        processBlock(world, newPos.west(2), entity, ModBlocks.AIR_BOMB_GOO);
                    }
                    else
                    {
                        processBlock(world, temp, entity, ModBlocks.STONE_BOMB_GOO);
                        processBlock(world, newPos.west(2), entity, ModBlocks.STONE_BOMB_GOO);
                    }

                    temp = newPos.west(1);
                    if(z % 8 == 0)
                        world.setBlockState(temp, Blocks.WALL_TORCH.getDefaultState()
                                                                   .with(WallTorchBlock.FACING, Direction.EAST),
                                            Block.NOTIFY_ALL);
                }

                if(facing == Direction.EAST)
                {
                    newPos = pos.east(z);
                    for (int x = -1; x < 2; x++)
                    {
                        temp = newPos.south(x);
                        if(!world.getBlockState(temp).isOf(ModBlocks.BRIDGE_GOO))
                            processBlock(world, temp, entity, ModBlocks.STONE_BOMB_GOO);
                        processBlock(world, temp.up(4), entity, ModBlocks.STONE_BOMB_GOO);
                    }

                    newPos = pos.east(z).up();
                    temp = newPos.south(-2);
                    processBlock(world, temp, entity, ModBlocks.STONE_BOMB_GOO);
                    processBlock(world, temp.up(2), entity, ModBlocks.STONE_BOMB_GOO);

                    temp = newPos.south(2);
                    processBlock(world, temp, entity, ModBlocks.STONE_BOMB_GOO);
                    processBlock(world, temp.up(2), entity, ModBlocks.STONE_BOMB_GOO);

                    newPos = pos.east(z).up(2);
                    temp = newPos.south(-2);

                    if(z % 2 != 0)
                    {
                        processBlock(world, temp, entity, ModBlocks.AIR_BOMB_GOO);
                        processBlock(world, newPos.south(2), entity, ModBlocks.AIR_BOMB_GOO);
                    }
                    else
                    {
                        processBlock(world, temp, entity, ModBlocks.STONE_BOMB_GOO);
                        processBlock(world, newPos.south(2), entity, ModBlocks.STONE_BOMB_GOO);
                    }

                    temp = newPos.south(1);
                    if(z % 8 == 0)
                        world.setBlockState(temp, Blocks.WALL_TORCH.getDefaultState()
                                                                   .with(WallTorchBlock.FACING, Direction.NORTH),
                                            Block.NOTIFY_ALL);
                }

                if(facing == Direction.WEST)
                {
                    newPos = pos.west(z);
                    for (int x = -1; x < 2; x++)
                    {
                        temp = newPos.north(x);
                        if(!world.getBlockState(temp).isOf(ModBlocks.BRIDGE_GOO))
                            processBlock(world, temp, entity, ModBlocks.STONE_BOMB_GOO);
                        processBlock(world, temp.up(4), entity, ModBlocks.STONE_BOMB_GOO);
                    }

                    newPos = pos.west(z).up();
                    temp = newPos.north(-2);
                    processBlock(world, temp, entity, ModBlocks.STONE_BOMB_GOO);
                    processBlock(world, temp.up(2), entity, ModBlocks.STONE_BOMB_GOO);

                    temp = newPos.north(2);
                    processBlock(world, temp, entity, ModBlocks.STONE_BOMB_GOO);
                    processBlock(world, temp.up(2), entity, ModBlocks.STONE_BOMB_GOO);

                    newPos = pos.west(z).up(2);
                    temp = newPos.north(-2);

                    if(z % 2 != 0)
                    {
                        processBlock(world, temp, entity, ModBlocks.AIR_BOMB_GOO);
                        processBlock(world, newPos.north(2), entity, ModBlocks.AIR_BOMB_GOO);
                    }
                    else
                    {
                        processBlock(world, temp, entity, ModBlocks.STONE_BOMB_GOO);
                        processBlock(world, newPos.north(2), entity, ModBlocks.STONE_BOMB_GOO);
                    }

                    temp = newPos.north(1);
                    if(z % 8 == 0)
                        world.setBlockState(temp, Blocks.WALL_TORCH.getDefaultState()
                                                                   .with(WallTorchBlock.FACING, Direction.SOUTH),
                                            Block.NOTIFY_ALL);
                }
            }

            world.setBlockState(pos, Blocks.STONE.getDefaultState(), Block.NOTIFY_ALL);
        }
    }
}