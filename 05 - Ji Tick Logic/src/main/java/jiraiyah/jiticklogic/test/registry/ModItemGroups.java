package jiraiyah.jiticklogic.test.registry;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import static jiraiyah.jiticklogic.test.Main.ModID;
import static jiraiyah.jiticklogic.test.Main.REFERENCE;
import static jiraiyah.jiticklogic.test.Main.LOGGER;

public class ModItemGroups
{
    public static final RegistryKey<ItemGroup> MACHINES_KEY = getKey(REFERENCE.MACHINE_ITEM_GROUP_NAME, RegistryKeys.ITEM_GROUP);

    public static ItemGroup MACHINES = Registry.register(Registries.ITEM_GROUP,
                                                         MACHINES_KEY,
                                                         FabricItemGroup.builder().displayName(REFERENCE.MACHINES_TITLE)
                                                                        .icon(ModBlocks.CHUNK_LOADER.asItem()::getDefaultStack)
                                                                        .entries((displayContext, entries) ->
                                                                                 {
                                                                                     entries.add(ModBlocks.CHUNK_LOADER);
                                                                                 }).build());

    public ModItemGroups()
    {
        throw new AssertionError("This class should not be instantiated");
    }

    public static void init()
    {
        LOGGER.logItemGroupInit();
    }

    private static <T> RegistryKey<T> getKey(String name, RegistryKey<? extends Registry<T>> registryKey)
    {
        return RegistryKey.of(registryKey, REFERENCE.identifier(name));
    }
}