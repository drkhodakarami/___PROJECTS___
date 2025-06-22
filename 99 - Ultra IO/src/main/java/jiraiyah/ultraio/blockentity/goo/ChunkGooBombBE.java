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
import jiraiyah.jibase.utils.PosHelper;
import jiraiyah.ultraio.registry.ModBlockEntities;
import jiraiyah.ultraio.registry.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import static jiraiyah.ultraio.Main.CONFIGS;

public class ChunkGooBombBE extends GooBaseBE<ChunkGooBombBE>
{
    public ChunkGooBombBE(BlockPos pos, BlockState state)
    {
        super(ModBlockEntities.CHUNK_GOO_BOMB, pos, state);
        this.properties.setTickLogic(new TickLogic());
    }

    static class TickLogic implements ITickLogic<ChunkGooBombBE, BlockEntityFields<ChunkGooBombBE>>
    {

        @Override
        public void tick(BEProperties<ChunkGooBombBE> properties)
        {
            ChunkGooBombBE entity = properties.blockEntity();
            World world = entity.getWorld();
            BlockPos pos = entity.getPos();

            if(shouldNotTick(world, pos, true, CONFIGS.CHUNK_BOMB_GOO_CHANCE))
                return;

            BlockPos[] sides = PosHelper.positionSideBottom(pos);

            for (BlockPos side : sides)
            {
                if(world.getWorldChunk(pos).equals(world.getWorldChunk(side)))
                {
                    if (world.getBlockState(side).isOf(Blocks.LAVA) ||
                        world.getBlockState(side).isOf(Blocks.WATER))
                        world.setBlockState(side,
                                            Blocks.AIR.getDefaultState(),
                                            Block.NOTIFY_ALL);
                    continue;
                }
                if (world.getBlockState(side).isOf(Blocks.LAVA) ||
                    world.getBlockState(side).isOf(Blocks.WATER) ||
                    world.getBlockState(side).isOf(Blocks.AIR))
                    world.setBlockState(side,
                                        Blocks.STONE.getDefaultState(),
                                        Block.NOTIFY_ALL);
            }

            BlockPos newPos = PosHelper.bottom(pos);

            if(newPos.getY() >= world.getBottomY())
            {
                if(!processBlock(world, newPos, entity, ModBlocks.CHUNK_BOMB_GOO))
                    if (!processBlock(world, newPos.down(), entity, ModBlocks.CHUNK_BOMB_GOO))
                        if (!processBlock(world, newPos.down(2), entity, ModBlocks.CHUNK_BOMB_GOO))
                            if (!processBlock(world, newPos.down(3), entity, ModBlocks.CHUNK_BOMB_GOO))
                                if (!processBlock(world, newPos.down(4), entity, ModBlocks.CHUNK_BOMB_GOO))
                                    processBlock(world, newPos.down(5), entity, ModBlocks.CHUNK_BOMB_GOO);

                entity.dropItems(world, entity);
                world.setBlockState(pos, Blocks.AIR.getDefaultState(), Block.NOTIFY_ALL);
            }
        }
    }
}