package jiraiyah.jiregister;

import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class RegistryHelper
{
    public static <T> RegistryKey<T> getKey(String modID, String name, RegistryKey<? extends Registry<T>> registryKey)
    {
        return RegistryKey.of(registryKey, identifier(modID, name));
    }

    private static Identifier identifier(String modID, String path)
    {
        return Identifier.of(modID, path);
    }
}