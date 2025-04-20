package jiraiyah.jinventory.slot;

import jiraiyah.jibase.annotations.*;
import net.minecraft.inventory.Inventory;

@Developer("TurtyWurty")
@ModifiedBy("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/DaRealTurtyWurty/Industria")
@Discord("https://discord.turtywurty.dev/")
@Youtube("https://www.youtube.com/@TurtyWurty")

public class OutputSlot extends PredicateSlot
{
    public OutputSlot(Inventory inventory, int index, int x, int y)
    {
        super(inventory, index, x, y, itemStack -> false);
    }
}