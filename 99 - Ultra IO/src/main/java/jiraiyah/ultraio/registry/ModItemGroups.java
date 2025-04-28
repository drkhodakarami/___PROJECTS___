package jiraiyah.ultraio.registry;

import jiraiyah.jibase.exceptions.Exceptions;
import jiraiyah.jibase.utils.BaseHelper;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

import static jiraiyah.ultraio.Main.ModID;
import static jiraiyah.ultraio.Main.REFERENCE;
import static jiraiyah.ultraio.Main.LOGGER;

public class ModItemGroups
{
    public static final RegistryKey<ItemGroup> BLOCKS_KEY = BaseHelper.getKey(ModID, REFERENCE.BLOCK_ITEM_GROUP_NAME, RegistryKeys.ITEM_GROUP);
    public static final RegistryKey<ItemGroup> INGREDIENTS_KEY = BaseHelper.getKey(ModID, REFERENCE.INGREDIENT_ITEM_GROUP_NAME, RegistryKeys.ITEM_GROUP);
    public static final RegistryKey<ItemGroup> MISC_KEY = BaseHelper.getKey(ModID, REFERENCE.MISC_ITEM_GROUP_NAME, RegistryKeys.ITEM_GROUP);
    public static final RegistryKey<ItemGroup> ARMORS_KEY = BaseHelper.getKey(ModID, REFERENCE.ARMOR_ITEM_GROUP_NAME, RegistryKeys.ITEM_GROUP);
    public static final RegistryKey<ItemGroup> DECORATION_KEY = BaseHelper.getKey(ModID, REFERENCE.DECORATION_ITEM_GROUP_NAME, RegistryKeys.ITEM_GROUP);
    public static final RegistryKey<ItemGroup> MACHINES_KEY = BaseHelper.getKey(ModID, REFERENCE.MACHINE_ITEM_GROUP_NAME, RegistryKeys.ITEM_GROUP);
    public static final RegistryKey<ItemGroup> STORAGE_KEY = BaseHelper.getKey(ModID, REFERENCE.STORAGE_ITEM_GROUP_NAME, RegistryKeys.ITEM_GROUP);
    public static final RegistryKey<ItemGroup> TOOLS_KEY = BaseHelper.getKey(ModID, REFERENCE.TOOLS_ITEM_GROUP_NAME, RegistryKeys.ITEM_GROUP);

    public static final ItemGroup BLOCKS = Registry.register(Registries.ITEM_GROUP,
                                                             BLOCKS_KEY,
                                                             FabricItemGroup.builder().displayName(REFERENCE.BLOCKS_TITLE)
                                                                            .icon(ModBlocks.CITRINE.asItem()::getDefaultStack)
                                                                            .entries((displayContext, entries) ->
                                                                                     {
                                                                                         entries.add(ModBlocks.ANGEL);
                                                                                         entries.add(ModBlocks.ELEVATOR);
                                                                                         entries.add(ModBlocks.CITRINE);
                                                                                         entries.add(ModBlocks.ENDERITE);
                                                                                         entries.add(ModBlocks.RUBY);
                                                                                         entries.add(ModBlocks.SAPPHIRE);
                                                                                         entries.add(ModBlocks.RAW_CITRINE);
                                                                                         entries.add(ModBlocks.RAW_ENDERITE);
                                                                                         entries.add(ModBlocks.RAW_QUARTZ);
                                                                                         entries.add(ModBlocks.RAW_RUBY);
                                                                                         entries.add(ModBlocks.RAW_SAPPHIRE);
                                                                                         entries.add(ModBlocks.CARROT_BOX);
                                                                                         entries.add(ModBlocks.POTATO_BOX);

                                                                                         entries.add(ModBlocks.ORE_ENDERITE);

                                                                                         entries.add(ModBlocks.ORE_DEEP_CITRINE);
                                                                                         entries.add(ModBlocks.ORE_DEEP_RUBY);
                                                                                         entries.add(ModBlocks.ORE_DEEP_SAPPHIRE);
                                                                                         entries.add(ModBlocks.ORE_END_CITRINE);
                                                                                         entries.add(ModBlocks.ORE_END_ENDERITE);
                                                                                         entries.add(ModBlocks.ORE_END_ENDERITE_CRACKED);
                                                                                         entries.add(ModBlocks.ORE_END_RUBY);
                                                                                         entries.add(ModBlocks.ORE_END_SAPPHIRE);
                                                                                         entries.add(ModBlocks.ORE_NETHER_CITRINE);
                                                                                         entries.add(ModBlocks.ORE_NETHER_COAL);
                                                                                         entries.add(ModBlocks.ORE_NETHER_COPPER);
                                                                                         entries.add(ModBlocks.ORE_NETHER_DIAMOND);
                                                                                         entries.add(ModBlocks.ORE_NETHER_IRON);
                                                                                         entries.add(ModBlocks.ORE_NETHER_LAPIS);
                                                                                         entries.add(ModBlocks.ORE_NETHER_REDSTONE);
                                                                                         entries.add(ModBlocks.ORE_NETHER_RUBY);
                                                                                         entries.add(ModBlocks.ORE_NETHER_SAPPHIRE);
                                                                                         entries.add(ModBlocks.ORE_WORLD_CITRINE);
                                                                                         entries.add(ModBlocks.ORE_WORLD_RUBY);
                                                                                         entries.add(ModBlocks.ORE_WORLD_SAPPHIRE);

                                                                                         entries.add(ModBlocks.BRIDGE_GOO);
                                                                                         entries.add(ModBlocks.CHUNK_GOO);
                                                                                         entries.add(ModBlocks.LAVA_EATING_GOO);
                                                                                         entries.add(ModBlocks.LAVA_GENERATING_GOO);
                                                                                         entries.add(ModBlocks.LAVA_PUMP_GOO);
                                                                                         entries.add(ModBlocks.TOWERING_GOO);
                                                                                         entries.add(ModBlocks.TUNNELING_GOO);
                                                                                         entries.add(ModBlocks.WATER_EATING_GOO);
                                                                                         entries.add(ModBlocks.WATER_GENERATING_GOO);
                                                                                         entries.add(ModBlocks.WATER_PUMP_GOO);
                                                                                     }).build());
    
    public static final ItemGroup INGREDIENTS = Registry.register(Registries.ITEM_GROUP,
                                                                  INGREDIENTS_KEY,
                                                                  FabricItemGroup.builder().displayName(REFERENCE.INGREDIENT_TITLE)
                                                                                 .icon(ModItems.UNSTABLE_GOO::getDefaultStack)
                                                                                 .entries((displayContext, entries) ->
                                                                                          {
                                                                                              entries.add(ModItems.GEM_CITRINE);
                                                                                              entries.add(ModItems.GEM_RUBY);
                                                                                              entries.add(ModItems.GEM_SAPPHIRE);


                                                                                              entries.add(ModItems.COOKED_EGG);
                                                                                              entries.add(ModItems.EGG_AND_BREAD);

                                                                                              entries.add(ModItems.HOT_COAL);

                                                                                              entries.add(ModItems.BINDING_STRING);
                                                                                              entries.add(ModItems.RUBBER);

                                                                                              entries.add(ModItems.UNSTABLE_GOO);
                                                                                              entries.add(ModItems.COMBUSTION_CORE);
                                                                                              entries.add(ModItems.THERMAL_CORE);

                                                                                              entries.add(ModItems.VOID_PLATE_ACTIVATOR);
                                                                                              entries.add(ModItems.VOID_PLATE_BASE);

                                                                                              entries.add(ModItems.ENDER_CHARM);
                                                                                              entries.add(ModItems.ENDERMAN_EYE);
                                                                                              entries.add(ModItems.ENDERMAN_HEART);
                                                                                              entries.add(ModItems.ENDERMAN_GLAND);

                                                                                              entries.add(ModItems.RAW_CITRINE);
                                                                                              entries.add(ModItems.RAW_ENDERITE);
                                                                                              entries.add(ModItems.RAW_QUARTZ);
                                                                                              entries.add(ModItems.RAW_RUBY);
                                                                                              entries.add(ModItems.RAW_SAPPHIRE);
                                                                                              entries.add(ModItems.RAW_RUBBER);

                                                                                              entries.add(ModItems.INGOT_ENDERITE);

                                                                                              entries.add(ModItems.CRUSHED_SHULKER);
                                                                                              entries.add(ModItems.DUST_CONDUCTIVE);
                                                                                              entries.add(ModItems.DUST_COPPER);
                                                                                              entries.add(ModItems.DUST_ENDERITE);
                                                                                              entries.add(ModItems.DUST_ENERGETIC);
                                                                                              entries.add(ModItems.DUST_GOLD);
                                                                                              entries.add(ModItems.DUST_IRON);
                                                                                              entries.add(ModItems.DUST_OBSIDIAN);
                                                                                              entries.add(ModItems.DUST_PULSATING);
                                                                                              entries.add(ModItems.DUST_RED_ALLOY);
                                                                                              entries.add(ModItems.DUST_SOUL);
                                                                                              entries.add(ModItems.DUST_VIBRANT);
                                                                                              entries.add(ModItems.DUST_WITHERING);
                                                                                              entries.add(ModItems.RAW_ALLOY_ENDERITE);

                                                                                              entries.add(ModItems.GEAR_COPPER);
                                                                                              entries.add(ModItems.GEAR_DIAMOND);
                                                                                              entries.add(ModItems.GEAR_EMERALD);
                                                                                              entries.add(ModItems.GEAR_ENDERITE);
                                                                                              entries.add(ModItems.GEAR_ENERGIZED);
                                                                                              entries.add(ModItems.GEAR_GOLD);
                                                                                              entries.add(ModItems.GEAR_IRON);
                                                                                              entries.add(ModItems.GEAR_LAPIS);
                                                                                              entries.add(ModItems.GEAR_NETHERITE);
                                                                                              entries.add(ModItems.GEAR_OBSIDIAN);
                                                                                              entries.add(ModItems.GEAR_PRISMARINE);
                                                                                              entries.add(ModItems.GEAR_QUARTZ);
                                                                                              entries.add(ModItems.GEAR_RUBY);
                                                                                              entries.add(ModItems.GEAR_SAPPHIRE);
                                                                                              entries.add(ModItems.GEAR_SHULKER);
                                                                                              entries.add(ModItems.GEAR_STONE);
                                                                                              entries.add(ModItems.GEAR_VIBRANT);
                                                                                              entries.add(ModItems.GEAR_WOOD);

                                                                                              entries.add(ModItems.INGOT_ALLOY_CONDUCTIVE);
                                                                                              entries.add(ModItems.INGOT_ALLOY_ENERGETIC);
                                                                                              entries.add(ModItems.INGOT_ALLOY_PULSATING);
                                                                                              entries.add(ModItems.INGOT_ALLOY_RED);
                                                                                              entries.add(ModItems.INGOT_ALLOY_VIBRANT);
                                                                                              entries.add(ModItems.INGOT_ALLOY_ENDERITE);

                                                                                              entries.add(ModItems.PLATE_AMETHYST);
                                                                                              entries.add(ModItems.PLATE_CITRINE);
                                                                                              entries.add(ModItems.PLATE_COPPER);
                                                                                              entries.add(ModItems.PLATE_DIAMOND);
                                                                                              entries.add(ModItems.PLATE_EMERALD);
                                                                                              entries.add(ModItems.PLATE_ENDERITE);
                                                                                              entries.add(ModItems.PLATE_GOLD);
                                                                                              entries.add(ModItems.PLATE_IRON);
                                                                                              entries.add(ModItems.PLATE_NETHERITE);
                                                                                              entries.add(ModItems.PLATE_RUBY);
                                                                                              entries.add(ModItems.PLATE_SAPPHIRE);
                                                                                              entries.add(ModItems.PLATE_SHULKER);
                                                                                              entries.add(ModItems.PLATE_STONE);

                                                                                              entries.add(ModItems.REINFORCED_AMETHYST);
                                                                                              entries.add(ModItems.REINFORCED_CITRINE);
                                                                                              entries.add(ModItems.REINFORCED_COPPER);
                                                                                              entries.add(ModItems.REINFORCED_DIAMOND);
                                                                                              entries.add(ModItems.REINFORCED_EMERALD);
                                                                                              entries.add(ModItems.REINFORCED_ENDERITE);
                                                                                              entries.add(ModItems.REINFORCED_GOLD);
                                                                                              entries.add(ModItems.REINFORCED_IRON);
                                                                                              entries.add(ModItems.REINFORCED_NETHERITE);
                                                                                              entries.add(ModItems.REINFORCED_RUBY);
                                                                                              entries.add(ModItems.REINFORCED_SAPPHIRE);
                                                                                              entries.add(ModItems.REINFORCED_SHULKER);

                                                                                              entries.add(ModItems.ROD_COPPER);
                                                                                              entries.add(ModItems.ROD_ENDERITE);
                                                                                              entries.add(ModItems.ROD_GLOWSTONE);
                                                                                              entries.add(ModItems.ROD_GOLD);
                                                                                              entries.add(ModItems.ROD_IRON);
                                                                                              entries.add(ModItems.ROD_OBSIDIAN);
                                                                                              entries.add(ModItems.ROD_REDSTONE);
                                                                                              entries.add(ModItems.ROD_SHULKER);

                                                                                              entries.add(ModItems.ITEM_FILTER);
                                                                                              entries.add(ModItems.SLOT_DISABLED);
                                                                                              entries.add(ModItems.NEED_SIGNAL);

                                                                                              entries.add(ModItems.VOID_PLATE);
                                                                                          }).build());
    
    public static final ItemGroup MISC = Registry.register(Registries.ITEM_GROUP,
                                                           MISC_KEY,
                                                           FabricItemGroup.builder().displayName(REFERENCE.MISC_TITLE)
                                                                          .icon(ModItems.CAST_AXE::getDefaultStack)
                                                                          .entries((displayContext, entries) ->
                                                                                   {
                                                                                       entries.add(ModItems.CAST_AXE);
                                                                                       entries.add(ModItems.CAST_BINDING);
                                                                                       entries.add(ModItems.CAST_EXCAVATOR);
                                                                                       entries.add(ModItems.CAST_GEAR);
                                                                                       entries.add(ModItems.CAST_GEM);
                                                                                       entries.add(ModItems.CAST_HAMMER);
                                                                                       entries.add(ModItems.CAST_HANDLE);
                                                                                       entries.add(ModItems.CAST_HOE);
                                                                                       entries.add(ModItems.CAST_INGOT);
                                                                                       entries.add(ModItems.CAST_NUGGET);
                                                                                       entries.add(ModItems.CAST_PICKAXE);
                                                                                       entries.add(ModItems.CAST_PLATE);
                                                                                       entries.add(ModItems.CAST_ROD);
                                                                                       entries.add(ModItems.CAST_SHOVEL);
                                                                                       entries.add(ModItems.CAST_SWORD);
                                                                                       entries.add(ModItems.CAST_WIRE);
                                                                                       entries.add(ModItems.CAST_WOOD_INGOT);
                                                                                       entries.add(ModItems.CAST_WOOD_PICKAXE);

                                                                                       entries.add(ModItems.HEAD_CITRINE_AXE);
                                                                                       entries.add(ModItems.HEAD_CITRINE_EXCAVATOR);
                                                                                       entries.add(ModItems.HEAD_CITRINE_HAMMER);
                                                                                       entries.add(ModItems.HEAD_CITRINE_HOE);
                                                                                       entries.add(ModItems.HEAD_CITRINE_PICKAXE);
                                                                                       entries.add(ModItems.HEAD_CITRINE_SHOVEL);
                                                                                       entries.add(ModItems.HEAD_CITRINE_SWORD);

                                                                                       entries.add(ModItems.HEAD_COPPER_AXE);
                                                                                       entries.add(ModItems.HEAD_COPPER_EXCAVATOR);
                                                                                       entries.add(ModItems.HEAD_COPPER_HAMMER);
                                                                                       entries.add(ModItems.HEAD_COPPER_HOE);
                                                                                       entries.add(ModItems.HEAD_COPPER_PICKAXE);
                                                                                       entries.add(ModItems.HEAD_COPPER_SHOVEL);
                                                                                       entries.add(ModItems.HEAD_COPPER_SWORD);

                                                                                       entries.add(ModItems.HEAD_DIAMOND_AXE);
                                                                                       entries.add(ModItems.HEAD_DIAMOND_EXCAVATOR);
                                                                                       entries.add(ModItems.HEAD_DIAMOND_HAMMER);
                                                                                       entries.add(ModItems.HEAD_DIAMOND_HOE);
                                                                                       entries.add(ModItems.HEAD_DIAMOND_PICKAXE);
                                                                                       entries.add(ModItems.HEAD_DIAMOND_SHOVEL);
                                                                                       entries.add(ModItems.HEAD_DIAMOND_SWORD);

                                                                                       entries.add(ModItems.HEAD_ENDERITE_AXE);
                                                                                       entries.add(ModItems.HEAD_ENDERITE_EXCAVATOR);
                                                                                       entries.add(ModItems.HEAD_ENDERITE_HAMMER);
                                                                                       entries.add(ModItems.HEAD_ENDERITE_HOE);
                                                                                       entries.add(ModItems.HEAD_ENDERITE_PICKAXE);
                                                                                       entries.add(ModItems.HEAD_ENDERITE_SHOVEL);
                                                                                       entries.add(ModItems.HEAD_ENDERITE_SWORD);

                                                                                       entries.add(ModItems.HEAD_GOLD_AXE);
                                                                                       entries.add(ModItems.HEAD_GOLD_EXCAVATOR);
                                                                                       entries.add(ModItems.HEAD_GOLD_HAMMER);
                                                                                       entries.add(ModItems.HEAD_GOLD_HOE);
                                                                                       entries.add(ModItems.HEAD_GOLD_PICKAXE);
                                                                                       entries.add(ModItems.HEAD_GOLD_SHOVEL);
                                                                                       entries.add(ModItems.HEAD_GOLD_SWORD);

                                                                                       entries.add(ModItems.HEAD_IRON_AXE);
                                                                                       entries.add(ModItems.HEAD_IRON_EXCAVATOR);
                                                                                       entries.add(ModItems.HEAD_IRON_HAMMER);
                                                                                       entries.add(ModItems.HEAD_IRON_HOE);
                                                                                       entries.add(ModItems.HEAD_IRON_PICKAXE);
                                                                                       entries.add(ModItems.HEAD_IRON_SHOVEL);
                                                                                       entries.add(ModItems.HEAD_IRON_SWORD);

                                                                                       entries.add(ModItems.HEAD_NETHERITE_AXE);
                                                                                       entries.add(ModItems.HEAD_NETHERITE_EXCAVATOR);
                                                                                       entries.add(ModItems.HEAD_NETHERITE_HAMMER);
                                                                                       entries.add(ModItems.HEAD_NETHERITE_HOE);
                                                                                       entries.add(ModItems.HEAD_NETHERITE_PICKAXE);
                                                                                       entries.add(ModItems.HEAD_NETHERITE_SHOVEL);
                                                                                       entries.add(ModItems.HEAD_NETHERITE_SWORD);

                                                                                       entries.add(ModItems.HEAD_RUBY_AXE);
                                                                                       entries.add(ModItems.HEAD_RUBY_EXCAVATOR);
                                                                                       entries.add(ModItems.HEAD_RUBY_HAMMER);
                                                                                       entries.add(ModItems.HEAD_RUBY_HOE);
                                                                                       entries.add(ModItems.HEAD_RUBY_PICKAXE);
                                                                                       entries.add(ModItems.HEAD_RUBY_SHOVEL);
                                                                                       entries.add(ModItems.HEAD_RUBY_SWORD);

                                                                                       entries.add(ModItems.HEAD_SAPPHIRE_AXE);
                                                                                       entries.add(ModItems.HEAD_SAPPHIRE_EXCAVATOR);
                                                                                       entries.add(ModItems.HEAD_SAPPHIRE_HAMMER);
                                                                                       entries.add(ModItems.HEAD_SAPPHIRE_HOE);
                                                                                       entries.add(ModItems.HEAD_SAPPHIRE_PICKAXE);
                                                                                       entries.add(ModItems.HEAD_SAPPHIRE_SHOVEL);
                                                                                       entries.add(ModItems.HEAD_SAPPHIRE_SWORD);

                                                                                       entries.add(ModItems.HEAD_STONE_HAMMER);
                                                                                       entries.add(ModItems.HEAD_STONE_EXCAVATOR);
                                                                                       entries.add(ModItems.HEAD_WOOD_EXCAVATOR);
                                                                                   }).build());
    public static ItemGroup ARMORS = Registry.register(Registries.ITEM_GROUP,
                                                       ARMORS_KEY,
                                                       FabricItemGroup.builder().displayName(REFERENCE.ARMORS_TITLE)
                                                                      .icon(ModItems.ARMOR_AMETHYST_HELMET::getDefaultStack)
                                                                      .entries((displayContext, entries) ->
                                                                               {
                                                                                   entries.add(ModItems.ARMOR_AMETHYST_HELMET);
                                                                                   entries.add(ModItems.ARMOR_AMETHYST_CHESTPLATE);
                                                                                   entries.add(ModItems.ARMOR_AMETHYST_LEGGINGS);
                                                                                   entries.add(ModItems.ARMOR_AMETHYST_BOOTS);

                                                                                   entries.add(ModItems.ARMOR_CITRINE_HELMET);
                                                                                   entries.add(ModItems.ARMOR_CITRINE_CHESTPLATE);
                                                                                   entries.add(ModItems.ARMOR_CITRINE_LEGGINGS);
                                                                                   entries.add(ModItems.ARMOR_CITRINE_BOOTS);

                                                                                   entries.add(ModItems.ARMOR_COPPER_HELMET);
                                                                                   entries.add(ModItems.ARMOR_COPPER_CHESTPLATE);
                                                                                   entries.add(ModItems.ARMOR_COPPER_LEGGINGS);
                                                                                   entries.add(ModItems.ARMOR_COPPER_BOOTS);

                                                                                   entries.add(ModItems.ARMOR_EMERALD_HELMET);
                                                                                   entries.add(ModItems.ARMOR_EMERALD_CHESTPLATE);
                                                                                   entries.add(ModItems.ARMOR_EMERALD_LEGGINGS);
                                                                                   entries.add(ModItems.ARMOR_EMERALD_BOOTS);

                                                                                   entries.add(ModItems.ARMOR_ENDERITE_HELMET);
                                                                                   entries.add(ModItems.ARMOR_ENDERITE_CHESTPLATE);
                                                                                   entries.add(ModItems.ARMOR_ENDERITE_LEGGINGS);
                                                                                   entries.add(ModItems.ARMOR_ENDERITE_BOOTS);

                                                                                   entries.add(ModItems.ARMOR_RUBY_HELMET);
                                                                                   entries.add(ModItems.ARMOR_RUBY_CHESTPLATE);
                                                                                   entries.add(ModItems.ARMOR_RUBY_LEGGINGS);
                                                                                   entries.add(ModItems.ARMOR_RUBY_BOOTS);

                                                                                   entries.add(ModItems.ARMOR_SAPPHIRE_HELMET);
                                                                                   entries.add(ModItems.ARMOR_SAPPHIRE_CHESTPLATE);
                                                                                   entries.add(ModItems.ARMOR_SAPPHIRE_LEGGINGS);
                                                                                   entries.add(ModItems.ARMOR_SAPPHIRE_BOOTS);
                                                                               }).build());

    public static ItemGroup DECORATION = Registry.register(Registries.ITEM_GROUP,
                                                           DECORATION_KEY,
                                                           FabricItemGroup.builder().displayName(REFERENCE.DECORATIONS_TITLE)
                                                                          .icon(ModBlocks.RUBY_DOOR.asItem()::getDefaultStack)
                                                                          .entries((displayContext, entries) ->
                                                                                   {
                                                                                       entries.add(ModBlocks.CITRINE_BUTTON);
                                                                                       entries.add(ModBlocks.ENDERITE_BUTTON);
                                                                                       entries.add(ModBlocks.RUBY_BUTTON);
                                                                                       entries.add(ModBlocks.SAPPHIRE_BUTTON);

                                                                                       entries.add(ModBlocks.CITRINE_PRESSURE_PLATE);
                                                                                       entries.add(ModBlocks.ENDERITE_PRESSURE_PLATE);
                                                                                       entries.add(ModBlocks.RUBY_PRESSURE_PLATE);
                                                                                       entries.add(ModBlocks.SAPPHIRE_PRESSURE_PLATE);

                                                                                       entries.add(ModBlocks.CITRINE_DOOR);
                                                                                       entries.add(ModBlocks.ENDERITE_DOOR);
                                                                                       entries.add(ModBlocks.RUBY_DOOR);
                                                                                       entries.add(ModBlocks.SAPPHIRE_DOOR);

                                                                                       entries.add(ModBlocks.CITRINE_TRAP_DOOR);
                                                                                       entries.add(ModBlocks.ENDERITE_TRAP_DOOR);
                                                                                       entries.add(ModBlocks.RUBY_TRAP_DOOR);
                                                                                       entries.add(ModBlocks.SAPPHIRE_TRAP_DOOR);

                                                                                       entries.add(ModBlocks.CITRINE_FENCE);
                                                                                       entries.add(ModBlocks.ENDERITE_FENCE);
                                                                                       entries.add(ModBlocks.RUBY_FENCE);
                                                                                       entries.add(ModBlocks.SAPPHIRE_FENCE);

                                                                                       entries.add(ModBlocks.CITRINE_FENCE_GATE);
                                                                                       entries.add(ModBlocks.ENDERITE_FENCE_GATE);
                                                                                       entries.add(ModBlocks.RUBY_FENCE_GATE);
                                                                                       entries.add(ModBlocks.SAPPHIRE_FENCE_GATE);

                                                                                       entries.add(ModBlocks.CITRINE_WALL);
                                                                                       entries.add(ModBlocks.ENDERITE_WALL);
                                                                                       entries.add(ModBlocks.RUBY_WALL);
                                                                                       entries.add(ModBlocks.SAPPHIRE_WALL);

                                                                                       entries.add(ModBlocks.CITRINE_SLAB);
                                                                                       entries.add(ModBlocks.ENDERITE_SLAB);
                                                                                       entries.add(ModBlocks.RUBY_SLAB);
                                                                                       entries.add(ModBlocks.SAPPHIRE_SLAB);

                                                                                       entries.add(ModBlocks.CITRINE_STAIRS);
                                                                                       entries.add(ModBlocks.ENDERITE_STAIRS);
                                                                                       entries.add(ModBlocks.RUBY_STAIRS);
                                                                                       entries.add(ModBlocks.SAPPHIRE_STAIRS);
                                                                                   }).build());

    public static ItemGroup MACHINES = Registry.register(Registries.ITEM_GROUP,
                                                         MACHINES_KEY,
                                                         FabricItemGroup.builder().displayName(REFERENCE.MACHINES_TITLE)
                                                                        .icon(ModBlocks.CHUNK_LOADER.asItem()::getDefaultStack)
                                                                        .entries((displayContext, entries) ->
                                                                                 {
                                                                                     entries.add(ModBlocks.WOOD_STRIPPER);
                                                                                     entries.add(ModBlocks.CAST_PRESS);
                                                                                     entries.add(ModBlocks.SMELTER);
                                                                                     entries.add(ModBlocks.GEM_CLEANER);
                                                                                     entries.add(ModBlocks.PULVERIZER);
                                                                                     entries.add(ModBlocks.ALLOY_MIXER);
                                                                                     entries.add(ModBlocks.OVEN);
                                                                                     entries.add(ModBlocks.BLOCK_BREAKER);
                                                                                     entries.add(ModBlocks.BLOCK_PLACER);
                                                                                     entries.add(ModBlocks.FLUID_PUMP);
                                                                                     entries.add(ModBlocks.MINER);

                                                                                     entries.add(ModBlocks.GENERATOR);
                                                                                     entries.add(ModBlocks.SOLAR_PANEL);

                                                                                     entries.add(ModBlocks.CHUNK_LOADER);
                                                                                     entries.add(ModBlocks.REDSTONE_CLOCK);
                                                                                     entries.add(ModBlocks.ANIMAL_FEED);
                                                                                     entries.add(ModBlocks.TESSERACT);
                                                                                     entries.add(ModBlocks.ENDER_CHANTER);
                                                                                     entries.add(ModBlocks.PROJECT_TABLE);
                                                                                     entries.add(ModBlocks.PRINTER);
                                                                                     entries.add(ModBlocks.BUILDER);

                                                                                     entries.add(ModItems.BLUEPRINT_EMPTY);
                                                                                     entries.add(ModItems.WRENCH);
                                                                                 }).build());

    public static ItemGroup STORAGE = Registry.register(Registries.ITEM_GROUP,
                                                        STORAGE_KEY,
                                                        FabricItemGroup.builder().displayName(REFERENCE.STORAGE_TITLE)
                                                                       .icon(ModItems.BACKPACK::getDefaultStack)
                                                                       .entries((displayContext, entries) ->
                                                                                {
                                                                                    entries.add(ModItems.BACKPACK);
                                                                                    entries.add(ModItems.ENDER_BACKPACK);
                                                                                    entries.add(ModBlocks.BATTERY_BANK);
                                                                                    entries.add(ModBlocks.CREATIVE_BANK);
                                                                                }).build());

    public static ItemGroup TOOLS = Registry.register(Registries.ITEM_GROUP,
                                                      TOOLS_KEY,
                                                      FabricItemGroup.builder().displayName(REFERENCE.TOOLS_TITLE)
                                                                     .icon(ModItems.PLAYER_TELEPORT::getDefaultStack)
                                                                     .entries((displayContext, entries) ->
                                                                              {
                                                                                  entries.add(ModItems.PLAYER_TELEPORT);
                                                                                  entries.add(ModItems.TUNER);
                                                                                  entries.add(ModItems.ADVANCED_TUNER);
                                                                                  entries.add(ModItems.CHALICE_EMPTY);
                                                                                  entries.add(ModItems.CHALICE);
                                                                                  entries.add(ModItems.TOOL_CITRINE_AXE);
                                                                                  entries.add(ModItems.TOOL_COPPER_AXE);
                                                                                  entries.add(ModItems.TOOL_ENDERITE_AXE);
                                                                                  entries.add(ModItems.TOOL_RUBY_AXE);
                                                                                  entries.add(ModItems.TOOL_SAPPHIRE_AXE);

                                                                                  entries.add(ModItems.TOOL_CITRINE_EXCAVATOR);
                                                                                  entries.add(ModItems.TOOL_COPPER_EXCAVATOR);
                                                                                  entries.add(ModItems.TOOL_DIAMOND_EXCAVATOR);
                                                                                  entries.add(ModItems.TOOL_ENDERITE_EXCAVATOR);
                                                                                  entries.add(ModItems.TOOL_GOLD_EXCAVATOR);
                                                                                  entries.add(ModItems.TOOL_IRON_EXCAVATOR);
                                                                                  entries.add(ModItems.TOOL_NETHERITE_EXCAVATOR);
                                                                                  entries.add(ModItems.TOOL_RUBY_EXCAVATOR);
                                                                                  entries.add(ModItems.TOOL_SAPPHIRE_EXCAVATOR);
                                                                                  entries.add(ModItems.TOOL_STONE_EXCAVATOR);
                                                                                  entries.add(ModItems.TOOL_WOOD_EXCAVATOR);

                                                                                  entries.add(ModItems.TOOL_CITRINE_HAMMER);
                                                                                  entries.add(ModItems.TOOL_COPPER_HAMMER);
                                                                                  entries.add(ModItems.TOOL_DIAMOND_HAMMER);
                                                                                  entries.add(ModItems.TOOL_ENDERITE_HAMMER);
                                                                                  entries.add(ModItems.TOOL_GOLD_HAMMER);
                                                                                  entries.add(ModItems.TOOL_IRON_HAMMER);
                                                                                  entries.add(ModItems.TOOL_NETHERITE_HAMMER);
                                                                                  entries.add(ModItems.TOOL_RUBY_HAMMER);
                                                                                  entries.add(ModItems.TOOL_SAPPHIRE_HAMMER);
                                                                                  entries.add(ModItems.TOOL_STONE_HAMMER);
                                                                                  entries.add(ModItems.TOOL_WOOD_HAMMER);

                                                                                  entries.add(ModItems.TOOL_CITRINE_HOE);
                                                                                  entries.add(ModItems.TOOL_COPPER_HOE);
                                                                                  entries.add(ModItems.TOOL_ENDERITE_HOE);
                                                                                  entries.add(ModItems.TOOL_RUBY_HOE);
                                                                                  entries.add(ModItems.TOOL_SAPPHIRE_HOE);

                                                                                  entries.add(ModItems.TOOL_CITRINE_PICKAXE);
                                                                                  entries.add(ModItems.TOOL_COPPER_PICKAXE);
                                                                                  entries.add(ModItems.TOOL_ENDERITE_PICKAXE);
                                                                                  entries.add(ModItems.TOOL_RUBY_PICKAXE);
                                                                                  entries.add(ModItems.TOOL_SAPPHIRE_PICKAXE);

                                                                                  entries.add(ModItems.TOOL_CITRINE_SHOVEL);
                                                                                  entries.add(ModItems.TOOL_COPPER_SHOVEL);
                                                                                  entries.add(ModItems.TOOL_ENDERITE_SHOVEL);
                                                                                  entries.add(ModItems.TOOL_RUBY_SHOVEL);
                                                                                  entries.add(ModItems.TOOL_SAPPHIRE_SHOVEL);

                                                                                  entries.add(ModItems.TOOL_CITRINE_SWORD);
                                                                                  entries.add(ModItems.TOOL_COPPER_SWORD);
                                                                                  entries.add(ModItems.TOOL_ENDERITE_SWORD);
                                                                                  entries.add(ModItems.TOOL_RUBY_SWORD);
                                                                                  entries.add(ModItems.TOOL_SAPPHIRE_SWORD);
                                                                              }).build());

    public ModItemGroups()
    {
        Exceptions.throwCtorAssertion();
    }

    public static void init()
    {
        LOGGER.logItemGroupInit();
    }
}