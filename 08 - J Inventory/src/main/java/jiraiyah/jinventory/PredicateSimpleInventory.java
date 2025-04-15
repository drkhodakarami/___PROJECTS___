package jiraiyah.jinventory;

import jiraiyah.jiralib.blockentity.UpdatableBE;
import net.minecraft.item.ItemStack;

import java.util.function.BiPredicate;

// Author: turtywurty
// https://github.com/DaRealTurtyWurty/Industria
public class PredicateSimpleInventory extends SyncedSimpleInventory
{
    private final BiPredicate<ItemStack, Integer> predicate;

    public PredicateSimpleInventory(UpdatableBE blockEntity, int size, BiPredicate<ItemStack, Integer> predicate)
    {
        super(blockEntity, size);
        this.predicate = predicate;
    }

    public PredicateSimpleInventory(UpdatableBE blockEntity, BiPredicate<ItemStack, Integer> predicate, ItemStack... items)
    {
        super(blockEntity, items);
        this.predicate = predicate;
    }

    @Override
    public boolean isValid(int slotIndex, ItemStack stack)
    {
        return this.predicate.test(stack, slotIndex);
    }

    public BiPredicate<ItemStack, Integer> getPredicate()
    {
        return this.predicate;
    }

    //TODO: Check if we need the fluid and slurry code
}