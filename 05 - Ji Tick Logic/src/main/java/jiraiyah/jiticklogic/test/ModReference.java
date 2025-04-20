package jiraiyah.jiticklogic.test;

import jiraiyah.jireference.JiReference;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.text.MutableText;

public class ModReference extends JiReference
{
    public ModReference(String mod_ID)
    {
        super(mod_ID);
    }

    public final String MACHINE_ITEM_GROUP_NAME = "_1_machine_group";
    public final MutableText MACHINES_TITLE = translate(MACHINE_ITEM_GROUP_NAME);
}