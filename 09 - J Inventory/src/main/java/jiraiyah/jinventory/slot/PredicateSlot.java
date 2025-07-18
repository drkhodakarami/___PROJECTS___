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

package jiraiyah.jinventory.slot;

import jiraiyah.jibase.annotations.*;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;

import java.util.function.Predicate;

@SuppressWarnings("unused")
@Developer("TurtyWurty")
@ModifiedBy("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/DaRealTurtyWurty/Industria")
@Discord("https://discord.turtywurty.dev/")
@Youtube("https://www.youtube.com/@TurtyWurty")

public class PredicateSlot extends Slot
{
    private final Predicate<ItemStack> predicate;
    private int maxCount;

    public PredicateSlot(Inventory inventory, int index, int x, int y, Predicate<ItemStack> predicate)
    {
        super(inventory, index, x, y);
        this.predicate = predicate;
    }

    public PredicateSlot(Inventory inventory, int index, int x, int y, int maxCount, Predicate<ItemStack> predicate)
    {
        this(inventory, index, x, y, predicate);
        this.maxCount = maxCount;
    }

    public PredicateSlot(SimpleInventory inventory, int index, int x, int y)
    {
        this(inventory, index, x, y, stack -> inventory.isValid(index, stack));
    }

    public PredicateSlot(SimpleInventory inventory, int index, int x, int y, int maxCount)
    {
        this(inventory, index, x, y);
        this.maxCount = maxCount;
    }

    @Override
    public boolean canInsert(ItemStack stack)
    {
        if(maxCount == 0)
            return this.predicate.test(stack);
        return this.predicate.test(stack) && getStack().getCount() < maxCount;
    }
}