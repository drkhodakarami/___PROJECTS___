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
import jiraiyah.jibase.utils.PosHelper;
import jiraiyah.jiralib.blockentity.TickableBE;
import jiraiyah.ultraio.block.goo.GooBase;
import jiraiyah.ultraio.registry.ModBlockEntities;
import jiraiyah.ultraio.registry.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import static jiraiyah.ultraio.Main.CONFIGS;

public class WaterGeneratingGooBE extends GooBaseBE<WaterGeneratingGooBE>
{
    private BlockPos originalPos;

    public WaterGeneratingGooBE(BlockPos pos, BlockState state)
    {
        super(ModBlockEntities.WATER_GENERATING_GOO, pos, state);
        this.properties.tickLogic(new TickLogic());
        originalPos = pos;
        this.properties.fields().addField("originPos", this.originalPos,
                                          blockEntity -> blockEntity.originalPos,
                                          (blockEntity, value) -> blockEntity.originalPos = value);
    }

    public void setOrigin(BlockPos pos)
    {
        originalPos = pos;
        update();
    }

    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registries)
    {
        super.readNbt(nbt, registries);
        originalPos = nbt.get("original.pos", BlockPos.CODEC).orElse(null);
    }

    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registries)
    {
        super.writeNbt(nbt, registries);
        nbt.put("original.pos", BlockPos.CODEC, originalPos);
    }

    static class TickLogic implements ITickLogic<WaterGeneratingGooBE, BlockEntityFields<WaterGeneratingGooBE>>
    {
        @Override
        public void tick(BEProperties<WaterGeneratingGooBE> properties)
        {
            WaterGeneratingGooBE entity = properties.blockEntity();
            BlockPos pos = entity.getPos();
            World world = entity.getWorld();

            if(shouldNotTick(world, pos, true, CONFIGS.WATER_GENERATING_GOO_CHANCE))
                return;

            if(getDistance(pos, entity.originalPos) > CONFIGS.WATER_GOO_SPREAD_DISTANCE)
            {
                world.setBlockState(pos, Blocks.AIR.getDefaultState(), Block.NOTIFY_ALL);
                return;
            }

            BlockPos[] sides = PosHelper.positionSideBottom(pos);

            for (BlockPos side : sides)
                if(world.getBlockState(side).isOf(Blocks.AIR))
                {
                    world.setBlockState(side,
                                        ModBlocks.WATER_GENERATING_GOO.getDefaultState()
                                                                      .with(Properties.POWERED, true), Block.NOTIFY_ALL);
                    if(world.getBlockEntity(side) instanceof WaterGeneratingGooBE be)
                        be.setOrigin(entity.originalPos);
                }

            world.setBlockState(pos, Blocks.WATER.getDefaultState(), Block.NOTIFY_ALL);
        }
    }
}