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

import jiraiyah.jibase.utils.MathHelper;
import jiraiyah.jiralib.blockentity.JiBlockEntity;
import jiraiyah.ultraio.config.Rules;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

import static jiraiyah.ultraio.Main.REFERENCE;

public abstract class GooBaseBE <T extends GooBaseBE<T>> extends JiBlockEntity<T>
{
    public static final double SCATTER_DEVIATION = 0.11485000171139836;

    private final List<ItemStack> dropItems = new ArrayList<>();

    public GooBaseBE(BlockEntityType<T> type, BlockPos pos, BlockState state)
    {
        super(type, pos, state);
        this.properties
                .tick();
    }

    protected List<ItemStack> getDropItems()
    {
        return dropItems;
    }

    public void setPlayerPos(PlayerEntity player)
    {
        this.properties.fields().addField("player.pos", player.getPos());
        this.properties.fields().addField("player.facing", player.getHorizontalFacing());
        update();
    }

    public void setPlayerPos(Vec3d pos, Direction facing)
    {
        this.properties.fields().addField("player.pos", pos);
        this.properties.fields().addField("player.facing", facing);
        update();
    }

    protected static boolean processBlock(World world, BlockPos pos, GooBaseBE<?> entity, Block block)
    {
        if (world.getBlockState(pos).isIn(REFERENCE.GOO_BLACKLIST))
            return false;

        List<ItemStack> items = entity.getBreakBlockItems(world, new Vec3d(pos.getX(), pos.getY(), pos.getZ()), entity);

        world.setBlockState(pos, block.getDefaultState().with(Properties.POWERED, true), Block.NOTIFY_ALL);
        if(world.getBlockEntity(pos) instanceof GooBaseBE<?> baseBE)
        {
            setPosition(baseBE, entity);
            baseBE.getDropItems().addAll(items);
        }
        return true;
    }

    protected List<ItemStack> getBreakBlockItems(World world, Vec3d pos, GooBaseBE<?> entity)
    {
        BlockPos coordinates = new BlockPos((int)pos.x, (int)pos.y, (int)pos.z);
        return Block.getDroppedStacks(world.getBlockState(coordinates), (ServerWorld) world, coordinates, entity);
    }

    protected void dropItems(World world, GooBaseBE<?> entity)
    {
        if(entity.getDropItems().isEmpty())
            return;
        Vec3d origin = entity.properties.fields().getField("player.pos", Vec3d.class).getValue();
        entity.getDropItems().forEach(stack -> spawn(world, origin, stack, SCATTER_DEVIATION / 4.0));
    }

    protected static void spawn(World world, Vec3d pos, ItemStack stack)
    {
        spawn(world, pos, stack, SCATTER_DEVIATION);
    }

    //Took from ItemScatterer.spawn
    protected static void spawn(World world, Vec3d pos, ItemStack stack, double deviation)
    {
        while(!stack.isEmpty()) {
            ItemEntity itemEntity = new ItemEntity(world,
                                                   pos.x,
                                                   pos.y + 0.5,
                                                   pos.z,
                                                   stack.split(world.random.nextInt(21) + 10));
            itemEntity.setVelocity(world.random.nextTriangular(0.0F, deviation),
                                   world.random.nextTriangular(0.2, deviation),
                                   world.random.nextTriangular(0.0F, deviation));
            world.spawnEntity(itemEntity);
        }
    }

    protected static void setPosition(GooBaseBE<?> baseBE, GooBaseBE<?> entity)
    {
        baseBE.setPlayerPos(entity.properties.fields().getField("player.pos", Vec3d.class).getValue(),
                        entity.properties.fields().getField("player.facing", Direction.class).getValue());
    }

    protected static boolean shouldNotTick(World world, BlockPos pos, boolean shouldCheckChance, int chanceValue)
    {
        if(!(world instanceof ServerWorld sw))
            return true;

        BlockState state = world.getBlockState(pos);

        if(!sw.getGameRules().getBoolean(Rules.SPREAD) ||
           !(state != null && state.get(Properties.POWERED)))
            return true;

        if(shouldCheckChance)
        {
            return MathHelper.getChance(chanceValue);
        }

        return false;
    }

    protected static boolean shouldNotTick(World world, BlockPos pos)
    {
        return shouldNotTick(world, pos, false, 0);
    }
}