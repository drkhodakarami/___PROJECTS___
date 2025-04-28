package jiraiyah.ultraio.registry;

import jiraiyah.jibase.exceptions.Exceptions;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;

import static jiraiyah.ultraio.Main.LOGGER;
import static jiraiyah.ultraio.Main.REFERENCE;

public class ModToolMaterials
{
    public static ToolMaterial CITRINE = new ToolMaterial(BlockTags.INCORRECT_FOR_IRON_TOOL, 1000, 10.0f, 3.0f, 22, REFERENCE.REPAIRS_CITRINE_TOOL);
    public static ToolMaterial COPPER = new ToolMaterial(BlockTags.INCORRECT_FOR_IRON_TOOL, 500, 6.0f, 1.0f, 14, REFERENCE.REPAIRS_COPPER_TOOL);
    public static ToolMaterial ENDERITE = new ToolMaterial(REFERENCE.INCORRECT_FOR_ENDERITE_TOOL, 3000, 24.0f, 15.0f, 32, REFERENCE.REPAIRS_ENDERITE_TOOL);
    public static ToolMaterial RUBY = new ToolMaterial(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 2000, 12.0f, 4.0f, 22, REFERENCE.REPAIRS_RUBY_TOOL);
    public static ToolMaterial SAPPHIRE = new ToolMaterial(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 2000, 12.0f, 4.0f, 22, REFERENCE.REPAIRS_SAPPHIRE_TOOL);

    public ModToolMaterials()
    {
        Exceptions.throwCtorAssertion();
    }

    public static void init()
    {
        LOGGER.logToolMaterialInit();
    }
}