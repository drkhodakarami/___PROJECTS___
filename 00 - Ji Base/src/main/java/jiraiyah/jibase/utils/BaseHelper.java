package jiraiyah.jibase.utils;

import org.jetbrains.annotations.NotNull;
import net.minecraft.util.Identifier;

public class BaseHelper
{
    public static Identifier identifier(String modID, @NotNull String path)
    {
        return Identifier.of(modID, path);
    }

    public static String getFluidName(Fluid fluid)
    {
        return Registries.FLUID.getId(fluid).getPath();
    }

    public static String getItemName(Item item)
    {
        return Registries.ITEM.getId(item).getPath();
    }

    public static String getItemName(ItemStack item)
    {
        return Registries.ITEM.getId(item.asItem()).getPath();
    }

    public static String getBlockName(Block block)
    {
        return Registries.BLOCK.getId(block).getPath();
    }
}