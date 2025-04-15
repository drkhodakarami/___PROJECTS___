package jiraiyah.jinventory;

import jiraiyah.jiralib.blockentity.UpdatableBE;
import net.minecraft.item.ItemStack;

import java.util.function.BiPredicate;

// Author: turtywurty
// https://github.com/DaRealTurtyWurty/Industria
public class OutputSimpleInventory extends PredicateSimpleInventory
{
    public OutputSimpleInventory(UpdatableBE blockEntity, int size)
    {
        super(blockEntity, size, (slotIndex, stack) -> false);
    }

    public OutputSimpleInventory(UpdatableBE blockEntity, ItemStack... items)
    {
        super(blockEntity, (slotIndex, stack) -> false, items);
    }
}