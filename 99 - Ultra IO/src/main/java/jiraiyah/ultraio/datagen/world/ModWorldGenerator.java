package jiraiyah.ultraio.datagen.world;

import jiraiyah.ultraio.Main;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

import static jiraiyah.ultraio.Main.LOGGER;
import static jiraiyah.ultraio.Main.ModID;

public class ModWorldGenerator extends FabricDynamicRegistryProvider
{

    public ModWorldGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture)
    {
        super(output, registriesFuture);
    }

    @Override
    public String getName()
    {
        return ModID;
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup registries, Entries entries)
    {
        LOGGER.logWorldGeneratorDatagen();

        entries.addAll(registries.getOrThrow(RegistryKeys.CONFIGURED_FEATURE));
        entries.addAll(registries.getOrThrow(RegistryKeys.PLACED_FEATURE));
    }
}