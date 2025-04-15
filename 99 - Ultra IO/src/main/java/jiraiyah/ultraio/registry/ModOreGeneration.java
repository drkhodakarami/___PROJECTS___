package jiraiyah.ultraio.registry;

import jiraiyah.jilogger.ExceptionHelper;
import jiraiyah.ultraio.datagen.world.ModPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;

import static jiraiyah.ultraio.Main.LOGGER;

public class ModOreGeneration
{
    public ModOreGeneration()
    {
        ExceptionHelper.throwCtorAssertion();
    }

    public static void init()
    {
        LOGGER.logOreGenerationInit();

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                                      GenerationStep.Feature.UNDERGROUND_ORES,
                                      ModPlacedFeatures.ORE_CITRINE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                                      GenerationStep.Feature.UNDERGROUND_ORES,
                                      ModPlacedFeatures.ORE_RUBY_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                                      GenerationStep.Feature.UNDERGROUND_ORES,
                                      ModPlacedFeatures.ORE_SAPPHIRE_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(),
                                      GenerationStep.Feature.UNDERGROUND_ORES,
                                      ModPlacedFeatures.ORE_NETHER_CITRINE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(),
                                      GenerationStep.Feature.UNDERGROUND_ORES,
                                      ModPlacedFeatures.ORE_NETHER_RUBY_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(),
                                      GenerationStep.Feature.UNDERGROUND_ORES,
                                      ModPlacedFeatures.ORE_NETHER_SAPPHIRE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(),
                                      GenerationStep.Feature.UNDERGROUND_ORES,
                                      ModPlacedFeatures.ORE_NETHER_COAL_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(),
                                      GenerationStep.Feature.UNDERGROUND_ORES,
                                      ModPlacedFeatures.ORE_NETHER_COPPER_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(),
                                      GenerationStep.Feature.UNDERGROUND_ORES,
                                      ModPlacedFeatures.ORE_NETHER_DIAMOND_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(),
                                      GenerationStep.Feature.UNDERGROUND_ORES,
                                      ModPlacedFeatures.ORE_NETHER_IRON_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(),
                                      GenerationStep.Feature.UNDERGROUND_ORES,
                                      ModPlacedFeatures.ORE_NETHER_LAPIS_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(),
                                      GenerationStep.Feature.UNDERGROUND_ORES,
                                      ModPlacedFeatures.ORE_NETHER_REDSTONE_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(),
                                      GenerationStep.Feature.UNDERGROUND_ORES,
                                      ModPlacedFeatures.ORE_END_CITRINE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(),
                                      GenerationStep.Feature.UNDERGROUND_ORES,
                                      ModPlacedFeatures.ORE_END_RUBY_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(),
                                      GenerationStep.Feature.UNDERGROUND_ORES,
                                      ModPlacedFeatures.ORE_END_SAPPHIRE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(),
                                      GenerationStep.Feature.UNDERGROUND_ORES,
                                      ModPlacedFeatures.ORE_END_ENDERITE_PLACED_KEY);
    }
}