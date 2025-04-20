package jiraiyah.jinventory;

import jiraiyah.jibase.annotations.*;
import jiraiyah.jiralib.blockentity.UpdatableBE;
import net.minecraft.item.ItemStack;


@Developer("TurtyWurty")
@ModifiedBy("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/DaRealTurtyWurty/Industria")
@Discord("https://discord.turtywurty.dev/")
@Youtube("https://www.youtube.com/@TurtyWurty")

public class OutputSimpleInventory extends PredicateSimpleInventory
{
    public OutputSimpleInventory(UpdatableBE<?> blockEntity, int size)
    {
        super(blockEntity, size, (slotIndex, stack) -> false);
    }

    public OutputSimpleInventory(UpdatableBE<?> blockEntity, ItemStack... items)
    {
        super(blockEntity, (slotIndex, stack) -> false, items);
    }
}