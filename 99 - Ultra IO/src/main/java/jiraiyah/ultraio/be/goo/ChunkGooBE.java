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
import jiraiyah.ultraio.registry.ModBlockEntities;
import jiraiyah.ultraio.registry.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.chunk.WorldChunk;

import java.util.List;

public class ChunkGooBE extends GooBaseBE<ChunkGooBE>
{
    private WorldChunk originalChunk = null;

    public ChunkGooBE(BlockPos pos, BlockState state)
    {
        super(ModBlockEntities.CHUNK_GOO, pos, state);
        this.properties.tickLogic(new TickLogic());
    }

    public WorldChunk originalChunk()
    {
        if(originalChunk == null)
            setChunk();
        return originalChunk;
    }

    public void setChunk()
    {
        if(this.world != null)
            originalChunk = world.getWorldChunk(pos);
    }

    public void resetChunk()
    {
        originalChunk = null;
    }

    public static boolean isWithinChunk(World world, BlockPos pos, WorldChunk chunk)
    {
        return chunk.equals(world.getWorldChunk(pos));
    }

    static class TickLogic implements ITickLogic<ChunkGooBE, BlockEntityFields<ChunkGooBE>>
    {

        @Override
        public void tick(BEProperties<ChunkGooBE> properties)
        {
            ChunkGooBE entity = properties.blockEntity();
            World world = entity.getWorld();
            BlockPos pos = entity.getPos();

            if(shouldNotTick(world, pos))
                return;

            if(world.getBlockEntity(pos) instanceof ChunkGooBE be)
                be.resetChunk();

            for (int x = -32; x < 32; x++)
            {
                for (int z = -32; z < 32; z++)
                {
                    BlockPos flatPos = pos.west(x).north(z);
                    if(isWithinChunk(world, flatPos, entity.originalChunk()) &&
                       !world.getBlockState(flatPos).isOf(ModBlocks.TOWERING_GOO) &&
                       !world.getBlockState(flatPos).isOf(ModBlocks.CHUNK_GOO))
                            processBlock(world, flatPos, entity, ModBlocks.CHUNK_BOMB_GOO);
                }
            }

            List<ItemStack> items = entity.getBreakBlockItems(world, new Vec3d(pos.getX(), pos.getY(), pos.getZ()), entity);
            world.setBlockState(pos,
                                ModBlocks.CHUNK_BOMB_GOO.getDefaultState().with(Properties.POWERED, true),
                                Block.NOTIFY_ALL);
            if(world.getBlockEntity(pos) instanceof GooBaseBE<?> baseBE)
            {
                setPosition(baseBE, entity);
                baseBE.getDropItems().addAll(items);
            }
        }
    }
}