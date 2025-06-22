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
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

import static jiraiyah.ultraio.Main.CONFIGS;

public class TunnelingGooBE extends GooBaseBE<TunnelingGooBE>
{
    public TunnelingGooBE(BlockPos pos, BlockState state)
    {
        super(ModBlockEntities.TUNNELING_GOO, pos, state);
        this.properties.setTickLogic(new TickLogic());
    }

    static class TickLogic implements ITickLogic<TunnelingGooBE, BlockEntityFields<TunnelingGooBE>>
    {
        @Override
        public void tick(BEProperties<TunnelingGooBE> properties)
        {
            TunnelingGooBE entity = properties.blockEntity();
            World world = entity.getWorld();
            BlockPos pos = entity.getPos();

            if(shouldNotTick(world, pos))
                return;

            Direction facing = entity.properties.fields().getField("player.facing", Direction.class).getValue();

            if(facing == null)
                return;

            BlockPos newPos;

            for (int x = -1; x < 2; x++)
            {
                for (int y = 1; y < 4; y++)
                {
                    for (int z = 0; z < CONFIGS.GOO_SPREAD_DISTANCE; z++)
                    {
                        newPos = pos.up(y);
                        if(facing == Direction.NORTH)
                        {
                            newPos = newPos.north(z);
                            newPos = newPos.east(x);
                        }
                        else if(facing == Direction.SOUTH)
                        {
                            newPos = newPos.south(z);
                            newPos = newPos.west(x);
                        }
                        else if(facing == Direction.EAST)
                        {
                            newPos = newPos.east(z);
                            newPos = newPos.south(x);
                        }
                        else if(facing == Direction.WEST)
                        {
                            newPos = newPos.west(z);
                            newPos = newPos.north(x);
                        }
                        processBlock(world, newPos, entity, ModBlocks.AIR_BOMB_GOO);
                    }
                }
            }

            entity.dropItems(world, entity);
            world.setBlockState(pos, Blocks.STONE.getDefaultState(), Block.NOTIFY_ALL);
        }
    }
}