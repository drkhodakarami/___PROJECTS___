package jiraiyah.jiregister;

import jiraiyah.jibase.annotations.*;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

import java.util.function.UnaryOperator;

@Developer("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/drkhodakarami/___PROJECTS___")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")

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