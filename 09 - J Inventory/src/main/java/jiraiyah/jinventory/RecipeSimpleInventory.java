package jiraiyah.jinventory;

import jiraiyah.jibase.annotations.*;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.input.RecipeInput;

@Developer("TurtyWurty")
@ModifiedBy("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/DaRealTurtyWurty/Industria")
@Discord("https://discord.turtywurty.dev/")
@Youtube("https://www.youtube.com/@TurtyWurty")

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