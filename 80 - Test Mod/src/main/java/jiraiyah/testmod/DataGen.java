package jiraiyah.testmod;

import jiraiyah.testmod.datagen.ModEnLanguageProvider;
import jiraiyah.testmod.datagen.ModModelProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

import static jiraiyah.testmod.Main.LOGGER;

public class DataGen implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator)
	{
		LOGGER.logDatagen();

		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModEnLanguageProvider::new);
	}
}