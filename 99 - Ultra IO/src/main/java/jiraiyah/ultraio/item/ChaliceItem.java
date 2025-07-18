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

package jiraiyah.ultraio.item;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FluidFillable;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

public class ChaliceItem extends Item
{
    public ChaliceItem(Settings settings)
    {
        super(settings);
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand)
    {
        ItemStack itemStack = user.getStackInHand(hand);
        BlockHitResult blockHitResult = raycast(world, user, RaycastContext.FluidHandling.NONE);

        if (blockHitResult.getType() == HitResult.Type.MISS ||
            blockHitResult.getType() != HitResult.Type.BLOCK)
            //We didn't change the item in hand so this is enough for everywhere in this class
            return ActionResult.PASS;

        BlockPos origin = blockHitResult.getBlockPos();
        Direction direction = blockHitResult.getSide();
        BlockPos offset = origin.offset(direction);

        if (!world.canEntityModifyAt(user, origin) || !user.canPlaceOn(offset, direction, itemStack))
            return ActionResult.FAIL;

        BlockState originalBS = world.getBlockState(origin);
        BlockPos finalPos = originalBS.getBlock() instanceof FluidFillable ? origin : offset;

        if (this.placeFluid(user, world, finalPos, blockHitResult))
        {
            if (user instanceof ServerPlayerEntity)
                Criteria.PLACED_BLOCK.trigger((ServerPlayerEntity) user, finalPos, itemStack);
            user.incrementStat(Stats.USED.getOrCreateStat(this));
            return ActionResult.SUCCESS;
        }
        return ActionResult.FAIL;
    }

    private boolean placeFluid(@Nullable PlayerEntity player, World world, BlockPos pos, @Nullable BlockHitResult hitResult)
    {
        BlockState targetBS = world.getBlockState(pos);
        Block targetBlock = targetBS.getBlock();
        boolean canPlace = targetBS.canBucketPlace(Fluids.WATER);
        boolean placeInSpot = targetBS.isAir()
                              || canPlace
                              || targetBlock instanceof FluidFillable fluidFillable &&
                                 fluidFillable.canFillWithFluid(player, world, pos, targetBS, Fluids.WATER);

        if (!placeInSpot)
            return hitResult != null &&
                   this.placeFluid(player, world, hitResult.getBlockPos().offset(hitResult.getSide()),
                                   null);

        if (world.getDimension().ultrawarm())
        {
            int i = pos.getX();
            int j = pos.getY();
            int k = pos.getZ();
            world.playSound(player, pos, SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.BLOCKS,
                            0.5F, 2.6F + (world.random.nextFloat() - world.random.nextFloat()) * 0.8F);

            for (int l = 0; l < 8; l++)
                world.addParticleClient(ParticleTypes.LARGE_SMOKE,
                                        (double) i + Math.random(), (double) j + Math.random(), (double) k + Math.random(),
                                        0.0, 0.0, 0.0);

            return true;
        }

        if (targetBlock instanceof FluidFillable fluidFillable)
        {
            fluidFillable.tryFillWithFluid(world, pos, targetBS, Fluids.WATER.getStill(false));
            world.playSound(player, pos, SoundEvents.ITEM_BUCKET_EMPTY, SoundCategory.BLOCKS, 1.0F, 1.0F);
            world.emitGameEvent(player, GameEvent.FLUID_PLACE, pos);
            return true;
        }

        if (!world.isClient && canPlace && !world.getFluidState(pos).isEmpty())
            world.breakBlock(pos, true);

        if (!world.setBlockState(pos, Fluids.WATER.getDefaultState().getBlockState(), Block.NOTIFY_ALL_AND_REDRAW) &&
            !targetBS.getFluidState().isStill())
            return false;
        world.playSound(player, pos, SoundEvents.ITEM_BUCKET_EMPTY, SoundCategory.BLOCKS, 1.0F, 1.0F);
        world.emitGameEvent(player, GameEvent.FLUID_PLACE, pos);
        return true;
    }
}