package jiraiyah.ultraio.datagen.world;

import jiraiyah.jibase.exceptions.Exceptions;
import jiraiyah.jibase.utils.BaseHelper;
import jiraiyah.jiregister.WorldGenHelper;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;

import static jiraiyah.ultraio.Main.LOGGER;
import static jiraiyah.ultraio.Main.ModID;

public class ModPlacedFeatures
{
    public static final RegistryKey<PlacedFeature> ORE_CITRINE_PLACED_KEY = BaseHelper.getKey(ModID, "ore_citrine_placed", RegistryKeys.PLACED_FEATURE);
    public static final RegistryKey<PlacedFeature> ORE_RUBY_PLACED_KEY = BaseHelper.getKey(ModID, "ore_ruby_placed", RegistryKeys.PLACED_FEATURE);
    public static final RegistryKey<PlacedFeature> ORE_SAPPHIRE_PLACED_KEY = BaseHelper.getKey(ModID, "ore_sapphire_placed", RegistryKeys.PLACED_FEATURE);
    public static final RegistryKey<PlacedFeature> ORE_NETHER_CITRINE_PLACED_KEY = BaseHelper.getKey(ModID, "ore_nether_citrine_placed", RegistryKeys.PLACED_FEATURE);
    public static final RegistryKey<PlacedFeature> ORE_NETHER_RUBY_PLACED_KEY = BaseHelper.getKey(ModID, "ore_nether_ruby_placed", RegistryKeys.PLACED_FEATURE);
    public static final RegistryKey<PlacedFeature> ORE_NETHER_SAPPHIRE_PLACED_KEY = BaseHelper.getKey(ModID, "ore_nether_sapphire_placed", RegistryKeys.PLACED_FEATURE);
    public static final RegistryKey<PlacedFeature> ORE_NETHER_COAL_PLACED_KEY = BaseHelper.getKey(ModID, "ore_nether_coal_placed", RegistryKeys.PLACED_FEATURE);
    public static final RegistryKey<PlacedFeature> ORE_NETHER_COPPER_PLACED_KEY = BaseHelper.getKey(ModID, "ore_nether_copper_placed", RegistryKeys.PLACED_FEATURE);
    public static final RegistryKey<PlacedFeature> ORE_NETHER_DIAMOND_PLACED_KEY = BaseHelper.getKey(ModID, "ore_nether_diamond_placed", RegistryKeys.PLACED_FEATURE);
    public static final RegistryKey<PlacedFeature> ORE_NETHER_IRON_PLACED_KEY = BaseHelper.getKey(ModID, "ore_nether_iron_placed", RegistryKeys.PLACED_FEATURE);
    public static final RegistryKey<PlacedFeature> ORE_NETHER_LAPIS_PLACED_KEY = BaseHelper.getKey(ModID, "ore_nether_lapis_placed", RegistryKeys.PLACED_FEATURE);
    public static final RegistryKey<PlacedFeature> ORE_NETHER_REDSTONE_PLACED_KEY = BaseHelper.getKey(ModID, "ore_nether_redstone_placed", RegistryKeys.PLACED_FEATURE);
    public static final RegistryKey<PlacedFeature> ORE_END_CITRINE_PLACED_KEY = BaseHelper.getKey(ModID, "ore_end_citrine_placed", RegistryKeys.PLACED_FEATURE);
    public static final RegistryKey<PlacedFeature> ORE_END_RUBY_PLACED_KEY = BaseHelper.getKey(ModID, "ore_end_ruby_placed", RegistryKeys.PLACED_FEATURE);
    public static final RegistryKey<PlacedFeature> ORE_END_SAPPHIRE_PLACED_KEY = BaseHelper.getKey(ModID, "ore_end_sapphire_placed", RegistryKeys.PLACED_FEATURE);
    public static final RegistryKey<PlacedFeature> ORE_END_ENDERITE_PLACED_KEY = BaseHelper.getKey(ModID, "ore_end_enderite_placed", RegistryKeys.PLACED_FEATURE);

    public ModPlacedFeatures()
    {
        Exceptions.throwCtorAssertion();
    }

    public static void bootstrap(Registerable<PlacedFeature> context)
    {
        LOGGER.logPlacedDatagenBootstrap();

        var lookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        //region OVERWORLD
        WorldGenHelper.registerPlacedFeature(context, ORE_CITRINE_PLACED_KEY, lookup.getOrThrow(ModConfiguredFeatures.ORE_CITRINE_KEY),
                                             WorldGenHelper.modifiersWithCount(2, // Veins per chunk
                                    HeightRangePlacementModifier.uniform(YOffset.aboveBottom(4), YOffset.aboveBottom(64))));

        WorldGenHelper.registerPlacedFeature(context, ORE_RUBY_PLACED_KEY, lookup.getOrThrow(ModConfiguredFeatures.ORE_RUBY_KEY),
                                             WorldGenHelper.modifiersWithCount(2, // Veins per chunk
                                    HeightRangePlacementModifier.uniform(YOffset.aboveBottom(4), YOffset.aboveBottom(64))));

        WorldGenHelper.registerPlacedFeature(context, ORE_SAPPHIRE_PLACED_KEY, lookup.getOrThrow(ModConfiguredFeatures.ORE_SAPPHIRE_KEY),
                                             WorldGenHelper.modifiersWithCount(2, // Veins per chunk
                                    HeightRangePlacementModifier.uniform(YOffset.aboveBottom(4), YOffset.aboveBottom(64))));
        //endregion

        //region NETHER
        WorldGenHelper.registerPlacedFeature(context, ORE_NETHER_CITRINE_PLACED_KEY, lookup.getOrThrow(ModConfiguredFeatures.ORE_NETHER_CITRINE_KEY),
                                             WorldGenHelper.modifiersWithCount(3, // Veins per chunk
                                    HeightRangePlacementModifier.uniform(YOffset.aboveBottom(32), YOffset.belowTop(5))));

        WorldGenHelper.registerPlacedFeature(context, ORE_NETHER_RUBY_PLACED_KEY, lookup.getOrThrow(ModConfiguredFeatures.ORE_NETHER_RUBY_KEY),
                                             WorldGenHelper.modifiersWithCount(3, // Veins per chunk
                                    HeightRangePlacementModifier.uniform(YOffset.aboveBottom(32), YOffset.belowTop(5))));

        WorldGenHelper.registerPlacedFeature(context, ORE_NETHER_SAPPHIRE_PLACED_KEY, lookup.getOrThrow(ModConfiguredFeatures.ORE_NETHER_SAPPHIRE_KEY),
                                             WorldGenHelper.modifiersWithCount(3, // Veins per chunk
                                    HeightRangePlacementModifier.uniform(YOffset.aboveBottom(32), YOffset.belowTop(5))));

        WorldGenHelper.registerPlacedFeature(context, ORE_NETHER_COAL_PLACED_KEY, lookup.getOrThrow(ModConfiguredFeatures.ORE_NETHER_COAL_KEY),
                                             WorldGenHelper.modifiersWithCount(16, // Veins per chunk
                                    HeightRangePlacementModifier.uniform(YOffset.aboveBottom(32), YOffset.belowTop(5))));

        WorldGenHelper.registerPlacedFeature(context, ORE_NETHER_COPPER_PLACED_KEY, lookup.getOrThrow(ModConfiguredFeatures.ORE_NETHER_COPPER_KEY),
                                             WorldGenHelper.modifiersWithCount(10, // Veins per chunk
                                    HeightRangePlacementModifier.uniform(YOffset.aboveBottom(32), YOffset.belowTop(5))));

        WorldGenHelper.registerPlacedFeature(context, ORE_NETHER_DIAMOND_PLACED_KEY, lookup.getOrThrow(ModConfiguredFeatures.ORE_NETHER_DIAMOND_KEY),
                                             WorldGenHelper.modifiersWithCount(4, // Veins per chunk
                                    HeightRangePlacementModifier.uniform(YOffset.aboveBottom(32), YOffset.aboveBottom(42))));

        WorldGenHelper.registerPlacedFeature(context, ORE_NETHER_IRON_PLACED_KEY, lookup.getOrThrow(ModConfiguredFeatures.ORE_NETHER_IRON_KEY),
                                             WorldGenHelper.modifiersWithCount(14, // Veins per chunk
                                    HeightRangePlacementModifier.uniform(YOffset.aboveBottom(32), YOffset.belowTop(5))));

        WorldGenHelper.registerPlacedFeature(context, ORE_NETHER_LAPIS_PLACED_KEY, lookup.getOrThrow(ModConfiguredFeatures.ORE_NETHER_LAPIS_KEY),
                                             WorldGenHelper.modifiersWithCount(10, // Veins per chunk
                                    HeightRangePlacementModifier.uniform(YOffset.aboveBottom(32), YOffset.belowTop(5))));

        WorldGenHelper.registerPlacedFeature(context, ORE_NETHER_REDSTONE_PLACED_KEY, lookup.getOrThrow(ModConfiguredFeatures.ORE_NETHER_REDSTONE_KEY),
                                             WorldGenHelper.modifiersWithCount(10, // Veins per chunk
                                    HeightRangePlacementModifier.uniform(YOffset.aboveBottom(32), YOffset.belowTop(5))));
        //endregion

        //region END
        WorldGenHelper.registerPlacedFeature(context, ORE_END_CITRINE_PLACED_KEY, lookup.getOrThrow(ModConfiguredFeatures.ORE_END_CITRINE_KEY),
                                             WorldGenHelper.modifiersWithCount(1, // Veins per chunk
                                    HeightRangePlacementModifier.uniform(YOffset.fixed(50), YOffset.fixed(65))));

        WorldGenHelper.registerPlacedFeature(context, ORE_END_RUBY_PLACED_KEY, lookup.getOrThrow(ModConfiguredFeatures.ORE_END_RUBY_KEY),
                                             WorldGenHelper.modifiersWithCount(1, // Veins per chunk
                                    HeightRangePlacementModifier.uniform(YOffset.fixed(50), YOffset.fixed(65))));

        WorldGenHelper.registerPlacedFeature(context, ORE_END_SAPPHIRE_PLACED_KEY, lookup.getOrThrow(ModConfiguredFeatures.ORE_END_SAPPHIRE_KEY),
                                             WorldGenHelper.modifiersWithCount(1, // Veins per chunk
                                    HeightRangePlacementModifier.uniform(YOffset.fixed(50), YOffset.fixed(65))));

        WorldGenHelper.registerPlacedFeature(context, ORE_END_ENDERITE_PLACED_KEY, lookup.getOrThrow(ModConfiguredFeatures.ORE_END_ENDERITE_KEY),
                                             WorldGenHelper.modifiersWithCount(3, // Veins per chunk
                                    HeightRangePlacementModifier.uniform(YOffset.fixed(50), YOffset.fixed(65))));
        //endregion
    }
}