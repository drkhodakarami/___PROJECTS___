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

import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static jiraiyah.ultraio.Main.CONFIGS;
import static jiraiyah.ultraio.Main.REFERENCE;

public class HammerItem extends Item
{
    private int depth;
    private int radius;

    public HammerItem(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings)
    {
        super(settings.pickaxe(material, attackDamage, attackSpeed));
        this.depth = depth / 2;
        this.radius = radius - 1;
    }

    public HammerItem setDepth(int depth)
    {
        this.depth = depth / 2;
        return this;
    }

    public HammerItem setRadius(int depth)
    {
        this.radius = radius - 1;
        return this;
    }

    public int getDepth()
    {
        return this.depth;
    }

    public int getRadius()
    {
        return this.radius;
    }


    public static List<BlockPos> getAreaBlocks(BlockPos initialPos, int depth, int radius, ServerPlayerEntity player)
    {
        List<BlockPos> positions = new ArrayList<>();

        HitResult hit = player.raycast(CONFIGS.HAMMER_MAX_DISTANCE, 0, false);

        if (hit.getType() != HitResult.Type.BLOCK)
            return positions;

        BlockHitResult block = (BlockHitResult) hit;

        if (block.getSide() == Direction.DOWN || block.getSide() == Direction.UP)
        {
            for (int x = -radius; x <= radius; x++)
            {
                for (int z = -radius; z <= radius; z++)
                {
                    for (int y = 0; y <= depth; y++)
                    {
                        positions.add(new BlockPos(initialPos.getX() + x,
                                                   initialPos.getY() + (block.getSide() == Direction.DOWN ? y : -y),
                                                   initialPos.getZ() + z));
                    }
                }
            }
        }

        if (block.getSide() == Direction.NORTH || block.getSide() == Direction.SOUTH)
        {
            for (int x = -radius; x <= radius; x++)
            {
                for (int y = -radius; y <= radius; y++)
                {
                    for (int z = 0; z <= depth; z++)
                    {
                        positions.add(new BlockPos(initialPos.getX() + x,
                                                   initialPos.getY() + y,
                                                   initialPos.getZ() + (block.getSide() == Direction.NORTH ? z : -z)));
                    }
                }
            }
        }

        if (block.getSide() == Direction.EAST || block.getSide() == Direction.WEST)
        {
            for (int z = -radius; z <= radius; z++)
            {
                for (int y = -radius; y <= radius; y++)
                {
                    for (int x = 0; x <= depth; x++)
                    {
                        positions.add(new BlockPos(initialPos.getX() + (block.getSide() == Direction.WEST ? x : -x),
                                                   initialPos.getY() + y,
                                                   initialPos.getZ() + z));
                    }
                }
            }
        }

        return positions;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> textConsumer, TooltipType type)
    //public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type)
    {
        textConsumer.accept(REFERENCE.translate(REFERENCE.HAMMER_PARAM_TOOLTIP,
                                        this.radius * 2 + 1, this.radius * 2 + 1, this.depth + 1));
    }
}