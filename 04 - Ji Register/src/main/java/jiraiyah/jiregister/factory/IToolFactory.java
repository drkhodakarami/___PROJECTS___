package jiraiyah.jiregister.factory;

import net.minecraft.item.ToolMaterial;

public interface IToolFactory<U, R>
{
    R apply(ToolMaterial material, Float damage, float speed, U settings);
}