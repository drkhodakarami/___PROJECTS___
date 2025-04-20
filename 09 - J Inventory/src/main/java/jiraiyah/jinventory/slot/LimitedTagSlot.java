package jiraiyah.jinventory.slot;

import jiraiyah.jibase.annotations.*;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.registry.tag.TagKey;

@Developer("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/drkhodakarami/___PROJECTS___")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")

public class LimitedTagSlot extends PredicateSlot
{
    public LimitedTagSlot(Inventory inventory, int index, int x, int y, TagKey<Item> tagKey, TagKey<Item> limitTagKey)
    {
        super(inventory, index, x, y, itemStack -> itemStack.isIn(tagKey) && !itemStack.isIn(limitTagKey));
    }
}