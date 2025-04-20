package jiraiyah.jinventory.slot;

import jiraiyah.jibase.annotations.*;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;

import java.util.function.Predicate;

@Developer("TurtyWurty")
@ModifiedBy("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/DaRealTurtyWurty/Industria")
@Discord("https://discord.turtywurty.dev/")
@Youtube("https://www.youtube.com/@TurtyWurty")

public class PredicateSlot extends Slot
{
    private final Predicate<ItemStack> predicate;

    public PredicateSlot(Inventory inventory, int index, int x, int y, Predicate<ItemStack> predicate)
    {
        super(inventory, index, x, y);
        this.predicate = predicate;
    }

    public PredicateSlot(SimpleInventory inventory, int index, int x, int y)
    {
        this(inventory, index, x, y, inventory::canInsert);
    }

    @Override
    public boolean canInsert(ItemStack stack)
    {
        return this.predicate.test(stack);
    }
}