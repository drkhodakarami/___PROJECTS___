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

package jiraiyah.ultraio.be.goo;

import jiraiyah.jibase.interfaces.ITickLogic;
import jiraiyah.jibase.properties.BEProperties;
import jiraiyah.jibase.properties.BlockEntityFields;
import jiraiyah.jiralib.blockentity.TickableBE;
import jiraiyah.ultraio.registry.ModBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import jiraiyah.ultraio.block.goo.GooBase;

import static jiraiyah.ultraio.Main.CONFIGS;

public class StoneGooBombBE extends GooBaseBE<StoneGooBombBE>
{
    public StoneGooBombBE(BlockPos pos, BlockState state)
    {
        super(ModBlockEntities.STONE_GOO_BOMB, pos, state);
        this.properties.tickLogic(new TickLogic());
    }

    static class TickLogic implements ITickLogic<StoneGooBombBE, BlockEntityFields<StoneGooBombBE>>
    {

        @Override
        public void tick(BEProperties<StoneGooBombBE> properties)
        {
            StoneGooBombBE entity = properties.blockEntity();
            World world = entity.getWorld();
            BlockPos pos = entity.getPos();

            if(shouldNotTick(world, pos, true, CONFIGS.AIR_BOMB_GOO_CHANCE))
                return;

            entity.dropItems(world, entity);
            world.setBlockState(pos, Blocks.STONE.getDefaultState(), Block.NOTIFY_ALL);
        }
    }
}