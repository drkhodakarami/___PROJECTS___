package jiraiyah.jinventory.slot;

import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.registry.tag.TagKey;

public class LimitedTagSlot extends PredicateSlot
{
    public LimitedTagSlot(Inventory inventory, int index, int x, int y, TagKey<Item> tagKey, TagKey<Item> limitTagKey)
    {
        super(inventory, index, x, y, itemStack -> itemStack.isIn(tagKey) && !itemStack.isIn(limitTagKey));
    }
}