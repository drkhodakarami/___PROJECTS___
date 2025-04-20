package jiraiyah.jiticklogic.test.registry;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

import static jiraiyah.jiticklogic.test.Main.LOGGER;
import static jiraiyah.jiticklogic.test.Main.REFERENCE;

public class ModBlockItems
{
    public static BlockItem CHUNK_LOADER;

    public ModBlockItems()
    {
        throw new AssertionError("This class should not be instantiated");
    }

    public static void init()
    {
        LOGGER.logBlockItemInit();

        CHUNK_LOADER = register(ModBlocks.CHUNK_LOADER);
    }

    private static BlockItem register(Block block)
    {
        String name = Registries.BLOCK.getId(block).getPath();
        RegistryKey<Item> key = getKey(name, RegistryKeys.ITEM);
        return Registry.register(Registries.ITEM, key, new BlockItem(block,
                                                                     new Item.Settings()
                                                                             .useBlockPrefixedTranslationKey()
                                                                             .registryKey(key)));
    }

    private static <T> RegistryKey<T> getKey(String name, RegistryKey<? extends Registry<T>> registryKey)
    {
        return RegistryKey.of(registryKey, REFERENCE.identifier(name));
    }
}