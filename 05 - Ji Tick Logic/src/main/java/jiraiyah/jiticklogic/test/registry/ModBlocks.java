package jiraiyah.jiticklogic.test.registry;

import jiraiyah.jiticklogic.test.block.*;
import net.minecraft.block.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

import java.util.function.Function;

import static jiraiyah.jiticklogic.test.Main.LOGGER;
import static jiraiyah.jiticklogic.test.Main.REFERENCE;

public class ModBlocks
{

    public static ChunkLoader CHUNK_LOADER;

    public ModBlocks()
    {
        throw new AssertionError("This class should not be instantiated");
    }

    public static void init()
    {
        LOGGER.logBlockInit();

        CHUNK_LOADER = register("chunk_loader", Blocks.IRON_BLOCK, ChunkLoader::new);
    }

    private static  <R extends Block> R register(String name, Block copyBlock, Function<AbstractBlock.Settings, R> factory)
    {
        RegistryKey<Block> key = getKey(name, RegistryKeys.BLOCK);
        R block = factory.apply(AbstractBlock.Settings.copy(copyBlock).registryKey(key));
        return Registry.register(Registries.BLOCK, key, block);
    }

    private static <T> RegistryKey<T> getKey(String name, RegistryKey<? extends Registry<T>> registryKey)
    {
        return RegistryKey.of(registryKey, REFERENCE.identifier(name));
    }
}