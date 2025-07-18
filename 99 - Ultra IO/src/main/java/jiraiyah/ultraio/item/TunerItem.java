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

import jiraiyah.jibase.records.CoordinateDataPayload;
import jiraiyah.jibase.utils.BaseHelper;
import jiraiyah.ultraio.registry.ModDataComponentTypes;
import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.network.packet.s2c.play.PositionFlag;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

import static jiraiyah.ultraio.Main.REFERENCE;

public class TunerItem extends Item
{
    public TunerItem(Settings settings)
    {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context)
    {
        @Nullable var data = context.getStack().get(ModDataComponentTypes.COORDINATE);

        if (data != null)
            return super.useOnBlock(context);

        BlockPos pos = context.getBlockPos();
        PlayerEntity player = context.getPlayer();

        if (player != null)
        {
            if (!player.isSneaking())
            {
                if (!context.getWorld().isClient())
                {
                    context.getStack().set(ModDataComponentTypes.COORDINATE,
                                           new CoordinateDataPayload(context.getBlockPos(), BaseHelper.getDimensionName(player.getWorld())));
                }
                else
                    outputCoordinatesToChat(pos, BaseHelper.getDimensionName(player.getWorld()), player);
            }
        }

        return super.useOnBlock(context);
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand)
    {
        if (!world.isClient())
        {
            @Nullable var data = user.getStackInHand(hand).get(ModDataComponentTypes.COORDINATE);

            if (user.isSneaking() && data != null)
                user.getStackInHand(hand).set(ModDataComponentTypes.COORDINATE, null);
        }
        return super.use(world, user, hand);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand)
    {
        @Nullable var data = stack.get(ModDataComponentTypes.COORDINATE);

        if (entity.isPlayer() ||
            data == null ||
            entity.getType().isIn(REFERENCE.TUNER_BLACKLIST))
            return ActionResult.FAIL;

        if (!user.isSneaking())
        {
            return useOnEntityResult(user, entity, data);
        }

        return super.useOnEntity(stack, user, entity, hand);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> textConsumer, TooltipType type)
    {
        @Nullable var data = stack.get(ModDataComponentTypes.COORDINATE);
        if (data != null)
        {
            BlockPos pos = data.pos();
            var dimension = data.dimension();
            //TODO: Use BaseHelepr
            var dimensionName = dimension.substring(dimension.indexOf(':') + 1).replace('_', ' ');
            textConsumer.accept(REFERENCE.translate(REFERENCE.TUNER_TOOLTIP_ID_NAME,
                                            pos.getX(), pos.getY(), pos.getZ(), dimensionName));
        }
    }

    @NotNull
    protected ActionResult useOnEntityResult(PlayerEntity user, LivingEntity entity, @Nullable CoordinateDataPayload data)
    {
        if (data == null)
            return ActionResult.PASS;

        BlockPos pos = data.pos();

        if (!user.getWorld().isClient())
        {
            var dimension = data.dimension();
            var userDimension = user.getWorld().getRegistryKey().getValue().toString();
            if (dimension.equalsIgnoreCase(userDimension))
            {
                if (entity.getWorld() instanceof ServerWorld sw)
                    entity.teleport(sw, entity.getX(), pos.getY() + 1, entity.getZ(),
                                    PositionFlag.VALUES, entity.getYaw(), entity.getPitch(), false);
                entity.refreshPositionAfterTeleport(pos.getX(), pos.getY() + 1, pos.getZ());
                return ActionResult.SUCCESS;
            }
            return ActionResult.FAIL;
        }

        var dimension = data.dimension();
        var userDimension = user.getWorld().getRegistryKey().getValue().toString();
        var dimensionName = dimension.substring(dimension.indexOf(':') + 1).replace('_', ' ');
        if (dimension.equalsIgnoreCase(userDimension))
        {
            user.sendMessage(REFERENCE.translate(REFERENCE.TUNER_TELEPORTED_ID_NAME,
                                                 pos.getX(), pos.getY(), pos.getZ(), dimensionName), false);
            return ActionResult.SUCCESS;
        }
        else
        {
            user.sendMessage(REFERENCE.translate(REFERENCE.TUNER_ERROR_ID_NAME, dimensionName), false);
            return ActionResult.FAIL;
        }
    }

    @Override
    public boolean hasGlint(ItemStack stack)
    {
        @Nullable var data = stack.get(ModDataComponentTypes.COORDINATE);
        return data != null;
    }

    protected void outputCoordinatesToChat(BlockPos pos, String dimension, PlayerEntity player)
    {
        player.sendMessage(REFERENCE.translate(REFERENCE.TUNER_TOOLTIP_ID_NAME,
                                               pos.getX(), pos.getY(), pos.getZ(), dimension), false);
    }
}