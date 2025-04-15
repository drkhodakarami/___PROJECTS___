package jiraiyah.jinventory.slot;

import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.registry.tag.TagKey;

public class NotTaggedSlot extends PredicateSlot
{
    public NotTaggedSlot(Inventory inventory, int index, int x, int y, TagKey<Item>tagKey)
    {
        super(inventory, index, x, y, itemStack -> !itemStack.isIn(tagKey));
    }
}