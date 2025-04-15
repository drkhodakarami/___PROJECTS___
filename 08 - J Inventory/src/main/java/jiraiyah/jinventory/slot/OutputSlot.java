package jiraiyah.jinventory.slot;

import net.minecraft.inventory.Inventory;

// Author: turtywurty
// https://github.com/DaRealTurtyWurty/Industria
public class OutputSlot extends PredicateSlot
{
    public OutputSlot(Inventory inventory, int index, int x, int y)
    {
        super(inventory, index, x, y, itemStack -> false);
    }
}