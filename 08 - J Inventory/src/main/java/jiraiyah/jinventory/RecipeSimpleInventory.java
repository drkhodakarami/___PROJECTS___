package jiraiyah.jinventory;

import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.input.RecipeInput;

// Author: turtywurty
// https://github.com/DaRealTurtyWurty/Industria
public class RecipeSimpleInventory extends SimpleInventory implements RecipeInput
{
    public RecipeSimpleInventory(int size)
    {
        super(size);
    }

    public RecipeSimpleInventory(ItemStack... items)
    {
        super(items);
    }

    @Override
    public ItemStack getStackInSlot(int slotIndex)
    {
        return getStack(slotIndex);
    }
}