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
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.Blocks;
import net.minecraft.block.Block;

import static jiraiyah.ultraio.Main.CONFIGS;

public class ToweringGooBE extends GooBaseBE<ToweringGooBE>
{
    public ToweringGooBE(BlockPos pos, BlockState state)
    {
        super(ModBlockEntities.TOWERING_GOO, pos, state);
        this.properties.setTickLogic(new TickLogic());
    }

    static class TickLogic implements ITickLogic<ToweringGooBE, BlockEntityFields<ToweringGooBE>>
    {
        @Override
        public void tick(BEProperties<ToweringGooBE> properties)
        {
            ToweringGooBE entity = properties.blockEntity();
            World world = entity.getWorld();
            BlockPos pos = entity.getPos();

            if(shouldNotTick(world, pos, true, CONFIGS.AIR_BOMB_GOO_CHANCE))
                return;

            BlockPos[] sides = PosHelper.positionSideBottom(pos);

            for (BlockPos side : sides)
                if (world.getBlockState(side).isOf(Blocks.LAVA) ||
                    world.getBlockState(side).isOf(Blocks.WATER) ||
                    world.getBlockState(side).isOf(Blocks.AIR))
                    world.setBlockState(side,
                                        Blocks.STONE.getDefaultState(),
                                        Block.NOTIFY_ALL);

            BlockPos newPos = PosHelper.bottom(pos);

            if(newPos.getY() >= world.getBottomY())
            {
                if (!processBlock(world, newPos, entity, ModBlocks.TOWERING_GOO))
                    if (!processBlock(world, newPos.down(), entity, ModBlocks.TOWERING_GOO))
                        if (!processBlock(world, newPos.down(2), entity, ModBlocks.TOWERING_GOO))
                            if (!processBlock(world, newPos.down(3), entity, ModBlocks.TOWERING_GOO))
                                if (!processBlock(world, newPos.down(4), entity, ModBlocks.TOWERING_GOO))
                                    processBlock(world, newPos.down(5), entity, ModBlocks.TOWERING_GOO);

                entity.dropItems(world, entity);
                world.setBlockState(pos, Blocks.AIR.getDefaultState(), Block.NOTIFY_ALL);
            }
        }
    }
}