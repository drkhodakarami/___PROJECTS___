package jiraiyah.ultraio;

import jiraiyah.ultraio.datagen.base.*;
import jiraiyah.ultraio.datagen.world.ModConfiguredFeatures;
import jiraiyah.ultraio.datagen.world.ModPlacedFeatures;
import jiraiyah.ultraio.datagen.world.ModWorldGenerator;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

import static jiraiyah.ultraio.Main.LOGGER;

public class DataGen implements DataGeneratorEntrypoint
{
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator)
	{
		LOGGER.logDatagen();

		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModBlockTagProvider::new);
		pack.addProvider(ModItemTagProvider::new);
		pack.addProvider(ModEntityTagProvider::new);
		pack.addProvider(ModLootTableProvider::new);
		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModRecipeProvider::new);
		pack.addProvider(ModWorldGenerator::new);
		pack.addProvider(ModEnLanguageProvider::new);
	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder)
	{
        LOGGER.logDatageFeatures();

		registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, ModPlacedFeatures::bootstrap);
	}
}