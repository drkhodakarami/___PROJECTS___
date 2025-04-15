package jiraiyah.jiregister;

import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

import java.util.function.UnaryOperator;

public class JiComponentTypeRegister
{
    private final String modId;

    public JiComponentTypeRegister(String modId)
    {
        this.modId = modId;
    }

    public <R> ComponentType<R> register(String name, UnaryOperator<ComponentType.Builder<R>> buildOperator)
    {
        RegistryKey<ComponentType<?>> key = RegistryHelper.getKey(this.modId, name, RegistryKeys.DATA_COMPONENT_TYPE);
        return Registry.register(Registries.DATA_COMPONENT_TYPE, key, buildOperator.apply(ComponentType.builder()).build());
    }
}