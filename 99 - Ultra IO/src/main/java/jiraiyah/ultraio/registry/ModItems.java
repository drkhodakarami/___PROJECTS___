package jiraiyah.ultraio.registry;

import jiraiyah.jilogger.ExceptionHelper;
import jiraiyah.ultraio.item.*;
import net.minecraft.item.*;
import net.minecraft.item.equipment.EquipmentType;

import static jiraiyah.ultraio.Main.LOGGER;
import static jiraiyah.ultraio.Main.CONFIGS;
import static jiraiyah.ultraio.Main.JITEM;

public class ModItems
{
    public static Item
            GEM_CITRINE, GEM_RUBY, GEM_SAPPHIRE,
            RAW_CITRINE, RAW_ENDERITE, RAW_QUARTZ, RAW_RUBY, RAW_SAPPHIRE,
            CAST_BASE,
            CAST_AXE, CAST_BINDING, CAST_EXCAVATOR, CAST_GEAR, CAST_GEM, CAST_HAMMER, CAST_HANDLE, CAST_HOE, CAST_INGOT, CAST_NUGGET,
            CAST_PICKAXE, CAST_PLATE, CAST_ROD, CAST_SHOVEL, CAST_SWORD, CAST_WIRE, CAST_WOOD_INGOT, CAST_WOOD_PICKAXE,
            CRUSHED_SHULKER, DUST_CONDUCTIVE, DUST_COPPER, DUST_ENDERITE, DUST_ENERGETIC, DUST_GOLD, DUST_IRON, DUST_OBSIDIAN,
            DUST_PULSATING, DUST_RED_ALLOY, DUST_SOUL, DUST_VIBRANT, DUST_WITHERING,
            GEAR_COPPER, GEAR_DIAMOND, GEAR_EMERALD, GEAR_ENDERITE, GEAR_ENERGIZED, GEAR_GOLD, GEAR_IRON, GEAR_LAPIS,
            GEAR_NETHERITE, GEAR_OBSIDIAN, GEAR_PRISMARINE, GEAR_QUARTZ, GEAR_RUBY, GEAR_SAPPHIRE, GEAR_SHULKER, GEAR_STONE,
            GEAR_VIBRANT, GEAR_WOOD,
            INGOT_ALLOY_CONDUCTIVE, INGOT_ALLOY_ENERGETIC, INGOT_ALLOY_PULSATING, INGOT_ALLOY_RED, INGOT_ALLOY_VIBRANT,
            INGOT_ALLOY_ENDERITE, RAW_ALLOY_ENDERITE, INGOT_ENDERITE,
            PLATE_AMETHYST, PLATE_CITRINE, PLATE_COPPER, PLATE_DIAMOND, PLATE_EMERALD, PLATE_ENDERITE, PLATE_GOLD,
            PLATE_IRON, PLATE_NETHERITE, PLATE_RUBY, PLATE_SAPPHIRE, PLATE_SHULKER, PLATE_STONE,
            REINFORCED_AMETHYST, REINFORCED_CITRINE, REINFORCED_COPPER, REINFORCED_DIAMOND, REINFORCED_EMERALD, REINFORCED_ENDERITE,
            REINFORCED_GOLD, REINFORCED_IRON, REINFORCED_NETHERITE, REINFORCED_RUBY, REINFORCED_SAPPHIRE, REINFORCED_SHULKER,
            ROD_COPPER, ROD_ENDERITE, ROD_GLOWSTONE, ROD_GOLD, ROD_IRON, ROD_OBSIDIAN, ROD_REDSTONE, ROD_SHULKER,
            HEAD_CITRINE_AXE, HEAD_CITRINE_EXCAVATOR, HEAD_CITRINE_HAMMER, HEAD_CITRINE_HOE, HEAD_CITRINE_PICKAXE, HEAD_CITRINE_SHOVEL, HEAD_CITRINE_SWORD,
            HEAD_COPPER_AXE, HEAD_COPPER_EXCAVATOR, HEAD_COPPER_HAMMER, HEAD_COPPER_HOE, HEAD_COPPER_PICKAXE, HEAD_COPPER_SHOVEL, HEAD_COPPER_SWORD,
            HEAD_DIAMOND_AXE, HEAD_DIAMOND_EXCAVATOR, HEAD_DIAMOND_HAMMER, HEAD_DIAMOND_HOE, HEAD_DIAMOND_PICKAXE, HEAD_DIAMOND_SHOVEL, HEAD_DIAMOND_SWORD,
            HEAD_ENDERITE_AXE, HEAD_ENDERITE_EXCAVATOR, HEAD_ENDERITE_HAMMER, HEAD_ENDERITE_HOE, HEAD_ENDERITE_PICKAXE, HEAD_ENDERITE_SHOVEL, HEAD_ENDERITE_SWORD,
            HEAD_GOLD_AXE, HEAD_GOLD_EXCAVATOR, HEAD_GOLD_HAMMER, HEAD_GOLD_HOE, HEAD_GOLD_PICKAXE, HEAD_GOLD_SHOVEL, HEAD_GOLD_SWORD,
            HEAD_IRON_AXE, HEAD_IRON_EXCAVATOR, HEAD_IRON_HAMMER, HEAD_IRON_HOE, HEAD_IRON_PICKAXE, HEAD_IRON_SHOVEL, HEAD_IRON_SWORD,
            HEAD_NETHERITE_AXE, HEAD_NETHERITE_EXCAVATOR, HEAD_NETHERITE_HAMMER, HEAD_NETHERITE_HOE, HEAD_NETHERITE_PICKAXE, HEAD_NETHERITE_SHOVEL, HEAD_NETHERITE_SWORD,
            HEAD_RUBY_AXE, HEAD_RUBY_EXCAVATOR, HEAD_RUBY_HAMMER, HEAD_RUBY_HOE, HEAD_RUBY_PICKAXE, HEAD_RUBY_SHOVEL, HEAD_RUBY_SWORD,
            HEAD_SAPPHIRE_AXE, HEAD_SAPPHIRE_EXCAVATOR, HEAD_SAPPHIRE_HAMMER, HEAD_SAPPHIRE_HOE, HEAD_SAPPHIRE_PICKAXE, HEAD_SAPPHIRE_SHOVEL, HEAD_SAPPHIRE_SWORD,
            HEAD_STONE_HAMMER, HEAD_STONE_EXCAVATOR, HEAD_WOOD_HAMMER, HEAD_WOOD_EXCAVATOR,
            ENDER_CHARM, ENDERMAN_EYE, ENDERMAN_HEART, ENDERMAN_GLAND, THERMAL_CORE, HOT_COAL,
            COOKED_EGG, EGG_AND_BREAD, SLOT_DISABLED, NEED_SIGNAL, ITEM_FILTER,
            VOID_PLATE_BASE, VOID_PLATE_ACTIVATOR, VOID_PLATE, RUBBER, RAW_RUBBER, BINDING_STRING, UNSTABLE_GOO, COMBUSTION_CORE,
            ARMOR_AMETHYST_HELMET, ARMOR_AMETHYST_CHESTPLATE, ARMOR_AMETHYST_LEGGINGS, ARMOR_AMETHYST_BOOTS,
            ARMOR_CITRINE_HELMET, ARMOR_CITRINE_CHESTPLATE, ARMOR_CITRINE_LEGGINGS, ARMOR_CITRINE_BOOTS,
            ARMOR_COPPER_HELMET, ARMOR_COPPER_CHESTPLATE, ARMOR_COPPER_LEGGINGS, ARMOR_COPPER_BOOTS,
            ARMOR_EMERALD_HELMET, ARMOR_EMERALD_CHESTPLATE, ARMOR_EMERALD_LEGGINGS, ARMOR_EMERALD_BOOTS,
            ARMOR_ENDERITE_HELMET, ARMOR_ENDERITE_CHESTPLATE, ARMOR_ENDERITE_LEGGINGS, ARMOR_ENDERITE_BOOTS,
            ARMOR_RUBY_HELMET, ARMOR_RUBY_CHESTPLATE, ARMOR_RUBY_LEGGINGS, ARMOR_RUBY_BOOTS,
            ARMOR_SAPPHIRE_HELMET, ARMOR_SAPPHIRE_CHESTPLATE, ARMOR_SAPPHIRE_LEGGINGS, ARMOR_SAPPHIRE_BOOTS,
            BLUEPRINT_EMPTY,
            CHALICE_EMPTY,
            TOOL_CITRINE_PICKAXE, TOOL_COPPER_PICKAXE, TOOL_ENDERITE_PICKAXE, TOOL_RUBY_PICKAXE, TOOL_SAPPHIRE_PICKAXE,
            TOOL_CITRINE_AXE, TOOL_COPPER_AXE, TOOL_ENDERITE_AXE, TOOL_RUBY_AXE, TOOL_SAPPHIRE_AXE,
            TOOL_CITRINE_HOE, TOOL_COPPER_HOE, TOOL_ENDERITE_HOE, TOOL_RUBY_HOE, TOOL_SAPPHIRE_HOE,
            TOOL_CITRINE_SHOVEL, TOOL_COPPER_SHOVEL, TOOL_ENDERITE_SHOVEL, TOOL_RUBY_SHOVEL, TOOL_SAPPHIRE_SHOVEL;

    public static BlueprintItem BLUEPRINT_PRINTED;
    public static WrenchItem WRENCH;

    public static BackpackItem BACKPACK;
    public static EnderBackpackItem ENDER_BACKPACK;

    public static ExcavatorItem TOOL_CITRINE_EXCAVATOR, TOOL_COPPER_EXCAVATOR, TOOL_ENDERITE_EXCAVATOR, TOOL_RUBY_EXCAVATOR, TOOL_SAPPHIRE_EXCAVATOR,
            TOOL_NETHERITE_EXCAVATOR, TOOL_DIAMOND_EXCAVATOR, TOOL_GOLD_EXCAVATOR, TOOL_IRON_EXCAVATOR, TOOL_STONE_EXCAVATOR, TOOL_WOOD_EXCAVATOR;
    public static HammerItem TOOL_CITRINE_HAMMER, TOOL_COPPER_HAMMER, TOOL_ENDERITE_HAMMER, TOOL_RUBY_HAMMER, TOOL_SAPPHIRE_HAMMER,
            TOOL_NETHERITE_HAMMER, TOOL_DIAMOND_HAMMER, TOOL_GOLD_HAMMER, TOOL_IRON_HAMMER, TOOL_STONE_HAMMER, TOOL_WOOD_HAMMER;

    public static CitrineSword TOOL_CITRINE_SWORD;
    public static CopperSword TOOL_COPPER_SWORD;
    public static EnderiteSword TOOL_ENDERITE_SWORD;
    public static RubySword TOOL_RUBY_SWORD;
    public static SapphireSword TOOL_SAPPHIRE_SWORD;

    public static TunerItem TUNER;
    public static AdvancedTuner ADVANCED_TUNER;
    public static PlayerTeleporter PLAYER_TELEPORT;
    public static ChaliceItem CHALICE;

    public ModItems()
    {
        ExceptionHelper.throwCtorAssertion();
    }

    public static void init()
    {
        LOGGER.logItemInit();

        //region FOOD FUEL MISC
        BINDING_STRING = JITEM.register("binding_string", 16);
        UNSTABLE_GOO = JITEM.register("unstable_goo_core");
        COMBUSTION_CORE = JITEM.register("unstable_goo_base");
        RAW_RUBBER = JITEM.register("raw_rubber", 16);
        RUBBER = JITEM.register("rubber", 16);
        VOID_PLATE_BASE = JITEM.register("void_plate_base", 1);
        VOID_PLATE_ACTIVATOR = JITEM.register("void_plate_activator", 1);
        VOID_PLATE = JITEM.register("void_plate", 1);
        ENDER_CHARM = JITEM.register("ender_charm", 16);
        ENDERMAN_EYE = JITEM.register("enderman_eye", 16);
        ENDERMAN_HEART = JITEM.register("enderman_heart", 16);
        ENDERMAN_GLAND = JITEM.register("enderman_gland", 16);
        ITEM_FILTER = JITEM.register("item_filter", 16);
        SLOT_DISABLED = JITEM.register("slot_disabled", 16);
        NEED_SIGNAL = JITEM.register("need_signal", 16);
        COOKED_EGG = JITEM.registerSnackFood("cooked_egg", 16, 4, 0.55f);
        EGG_AND_BREAD = JITEM.registerSnackFood("egg_and_bread", 16, 11, 1.2f);
        HOT_COAL = JITEM.register("hot_coal");
        THERMAL_CORE = JITEM.register("thermal_core");
        //endregion
        //region GEMS
        GEM_CITRINE = JITEM.register("gem_citrine");
        GEM_RUBY = JITEM.register("gem_ruby");
        GEM_SAPPHIRE = JITEM.register("gem_sapphire");
        //endregion
        //region RAW
        RAW_CITRINE = JITEM.register("raw_citrine");
        RAW_ENDERITE = JITEM.register("raw_enderite");
        RAW_QUARTZ = JITEM.register("raw_quartz");
        RAW_RUBY = JITEM.register("raw_ruby");
        RAW_SAPPHIRE = JITEM.register("raw_sapphire");
        //endregion
        //region CAST
        CAST_BASE = JITEM.register("cast_base",1);
        CAST_AXE = JITEM.register("cast_axe", 1);
        CAST_BINDING = JITEM.register("cast_binding", 1);
        CAST_EXCAVATOR = JITEM.register("cast_excavator", 1);
        CAST_GEAR = JITEM.register("cast_gear", 1);
        CAST_GEM = JITEM.register("cast_gem", 1);
        CAST_HAMMER = JITEM.register("cast_hammer", 1);
        CAST_HANDLE = JITEM.register("cast_handle", 1);
        CAST_HOE = JITEM.register("cast_hoe", 1);
        CAST_INGOT = JITEM.register("cast_ingot", 1);
        CAST_NUGGET = JITEM.register("cast_nugget", 1);
        CAST_PICKAXE = JITEM.register("cast_pickaxe", 1);
        CAST_PLATE = JITEM.register("cast_plate", 1);
        CAST_ROD = JITEM.register("cast_rod", 1);
        CAST_SHOVEL = JITEM.register("cast_shovel", 1);
        CAST_SWORD = JITEM.register("cast_sword", 1);
        CAST_WIRE = JITEM.register("cast_wire", 1);
        CAST_WOOD_INGOT = JITEM.register("cast_wood_ingot", 1);
        CAST_WOOD_PICKAXE = JITEM.register("cast_wood_pickaxe", 1);
        //endregion
        //region DUST
        CRUSHED_SHULKER = JITEM.register("crushed_shulker_shell");
        DUST_CONDUCTIVE = JITEM.register("dust_conductive");
        DUST_COPPER = JITEM.register("dust_copper");
        DUST_ENDERITE = JITEM.register("dust_enderite");
        DUST_ENERGETIC = JITEM.register("dust_energetic");
        DUST_GOLD = JITEM.register("dust_gold");
        DUST_IRON = JITEM.register("dust_iron");
        DUST_OBSIDIAN = JITEM.register("dust_obsidian");
        DUST_PULSATING = JITEM.register("dust_pulsating");
        DUST_RED_ALLOY = JITEM.register("dust_red_alloy");
        DUST_SOUL = JITEM.register("dust_soul");
        DUST_VIBRANT = JITEM.register("dust_vibrant");
        DUST_WITHERING = JITEM.register("dust_withering");
        //endregion
        //region GEAR
        GEAR_COPPER = JITEM.register("gear_copper", 16);
        GEAR_DIAMOND = JITEM.register("gear_diamond", 16);
        GEAR_EMERALD = JITEM.register("gear_emerald", 16);
        GEAR_ENDERITE = JITEM.register("gear_enderite", 16);
        GEAR_ENERGIZED = JITEM.register("gear_energized", 16);
        GEAR_GOLD = JITEM.register("gear_gold", 16);
        GEAR_IRON = JITEM.register("gear_iron", 16);
        GEAR_LAPIS = JITEM.register("gear_lapis", 16);
        GEAR_NETHERITE = JITEM.register("gear_netherite", 16);
        GEAR_OBSIDIAN = JITEM.register("gear_obsidian", 16);
        GEAR_PRISMARINE = JITEM.register("gear_prismarine", 16);
        GEAR_QUARTZ = JITEM.register("gear_quartz", 16);
        GEAR_RUBY = JITEM.register("gear_ruby", 16);
        GEAR_SAPPHIRE = JITEM.register("gear_sapphire", 16);
        GEAR_SHULKER = JITEM.register("gear_shulker", 16);
        GEAR_STONE = JITEM.register("gear_stone", 16);
        GEAR_VIBRANT = JITEM.register("gear_vibrant", 16);
        GEAR_WOOD = JITEM.register("gear_wood", 16);
        //endregion
        //region INGOT - ALLOY
        INGOT_ALLOY_CONDUCTIVE = JITEM.register("ingot_alloy_conductive");
        INGOT_ALLOY_ENERGETIC = JITEM.register("ingot_alloy_energetic");
        INGOT_ALLOY_PULSATING = JITEM.register("ingot_alloy_pulsating");
        INGOT_ALLOY_RED = JITEM.register("ingot_alloy_red");
        INGOT_ALLOY_VIBRANT = JITEM.register("ingot_alloy_vibrant");
        INGOT_ALLOY_ENDERITE = JITEM.register("ingot_alloy_enderite");

        RAW_ALLOY_ENDERITE = JITEM.register("raw_alloy_enderite");

        INGOT_ENDERITE = JITEM.register("ingot_enderite");
        //endregion
        //region PLATE
        PLATE_AMETHYST = JITEM.register("plate_amethyst");
        PLATE_CITRINE = JITEM.register("plate_citrine");
        PLATE_COPPER = JITEM.register("plate_copper");
        PLATE_DIAMOND = JITEM.register("plate_diamond");
        PLATE_EMERALD = JITEM.register("plate_emerald");
        PLATE_ENDERITE = JITEM.register("plate_enderite");
        PLATE_GOLD = JITEM.register("plate_gold");
        PLATE_IRON = JITEM.register("plate_iron");
        PLATE_NETHERITE = JITEM.register("plate_netherite");
        PLATE_RUBY = JITEM.register("plate_ruby");
        PLATE_SAPPHIRE = JITEM.register("plate_sapphire");
        PLATE_SHULKER = JITEM.register("plate_shulker");
        PLATE_STONE = JITEM.register("plate_stone");
        //endregion
        //region REINFORCED
        REINFORCED_AMETHYST = JITEM.register("reinforced_amethyst", 16);
        REINFORCED_CITRINE = JITEM.register("reinforced_citrine", 16);
        REINFORCED_COPPER = JITEM.register("reinforced_copper", 16);
        REINFORCED_DIAMOND = JITEM.register("reinforced_diamond", 16);
        REINFORCED_EMERALD = JITEM.register("reinforced_emerald", 16);
        REINFORCED_ENDERITE = JITEM.register("reinforced_enderite", 16);
        REINFORCED_GOLD = JITEM.register("reinforced_gold", 16);
        REINFORCED_IRON = JITEM.register("reinforced_iron", 16);
        REINFORCED_NETHERITE = JITEM.register("reinforced_netherite", 16);
        REINFORCED_RUBY = JITEM.register("reinforced_ruby", 16);
        REINFORCED_SAPPHIRE = JITEM.register("reinforced_sapphire", 16);
        REINFORCED_SHULKER = JITEM.register("reinforced_shulker", 16);
        //endregion
        //region ROD
        ROD_COPPER = JITEM.register("rod_copper", 16);
        ROD_ENDERITE = JITEM.register("rod_enderite", 16);
        ROD_GLOWSTONE = JITEM.register("rod_glowstone", 16);
        ROD_GOLD = JITEM.register("rod_gold", 16);
        ROD_IRON = JITEM.register("rod_iron", 16);
        ROD_OBSIDIAN = JITEM.register("rod_obsidian", 16);
        ROD_REDSTONE = JITEM.register("rod_redstone", 16);
        ROD_SHULKER = JITEM.register("rod_shulker", 16);
        //endregion
        //region HEADS
        HEAD_CITRINE_AXE = JITEM.register("head_citrine_axe", 16);
        HEAD_CITRINE_EXCAVATOR = JITEM.register("head_citrine_excavator", 16);
        HEAD_CITRINE_HAMMER = JITEM.register("head_citrine_hammer", 16);
        HEAD_CITRINE_HOE = JITEM.register("head_citrine_hoe", 16);
        HEAD_CITRINE_PICKAXE = JITEM.register("head_citrine_pickaxe", 16);
        HEAD_CITRINE_SHOVEL = JITEM.register("head_citrine_shovel", 16);
        HEAD_CITRINE_SWORD = JITEM.register("head_citrine_sword", 16);

        HEAD_COPPER_AXE = JITEM.register("head_copper_axe", 16);
        HEAD_COPPER_EXCAVATOR = JITEM.register("head_copper_excavator", 16);
        HEAD_COPPER_HAMMER = JITEM.register("head_copper_hammer", 16);
        HEAD_COPPER_HOE = JITEM.register("head_copper_hoe", 16);
        HEAD_COPPER_PICKAXE = JITEM.register("head_copper_pickaxe", 16);
        HEAD_COPPER_SHOVEL = JITEM.register("head_copper_shovel", 16);
        HEAD_COPPER_SWORD = JITEM.register("head_copper_sword", 16);

        HEAD_DIAMOND_AXE = JITEM.register("head_diamond_axe", 16);
        HEAD_DIAMOND_EXCAVATOR = JITEM.register("head_diamond_excavator", 16);
        HEAD_DIAMOND_HAMMER = JITEM.register("head_diamond_hammer", 16);
        HEAD_DIAMOND_HOE = JITEM.register("head_diamond_hoe", 16);
        HEAD_DIAMOND_PICKAXE = JITEM.register("head_diamond_pickaxe", 16);
        HEAD_DIAMOND_SHOVEL = JITEM.register("head_diamond_shovel", 16);
        HEAD_DIAMOND_SWORD = JITEM.register("head_diamond_sword", 16);

        HEAD_ENDERITE_AXE = JITEM.register("head_enderite_axe", 16);
        HEAD_ENDERITE_EXCAVATOR = JITEM.register("head_enderite_excavator", 16);
        HEAD_ENDERITE_HAMMER = JITEM.register("head_enderite_hammer", 16);
        HEAD_ENDERITE_HOE = JITEM.register("head_enderite_hoe", 16);
        HEAD_ENDERITE_PICKAXE = JITEM.register("head_enderite_pickaxe", 16);
        HEAD_ENDERITE_SHOVEL = JITEM.register("head_enderite_shovel", 16);
        HEAD_ENDERITE_SWORD = JITEM.register("head_enderite_sword", 16);

        HEAD_GOLD_AXE = JITEM.register("head_gold_axe", 16);
        HEAD_GOLD_EXCAVATOR = JITEM.register("head_gold_excavator", 16);
        HEAD_GOLD_HAMMER = JITEM.register("head_gold_hammer", 16);
        HEAD_GOLD_HOE = JITEM.register("head_gold_hoe", 16);
        HEAD_GOLD_PICKAXE = JITEM.register("head_gold_pickaxe", 16);
        HEAD_GOLD_SHOVEL = JITEM.register("head_gold_shovel", 16);
        HEAD_GOLD_SWORD = JITEM.register("head_gold_sword", 16);

        HEAD_IRON_AXE = JITEM.register("head_iron_axe", 16);
        HEAD_IRON_EXCAVATOR = JITEM.register("head_iron_excavator", 16);
        HEAD_IRON_HAMMER = JITEM.register("head_iron_hammer", 16);
        HEAD_IRON_HOE = JITEM.register("head_iron_hoe", 16);
        HEAD_IRON_PICKAXE = JITEM.register("head_iron_pickaxe", 16);
        HEAD_IRON_SHOVEL = JITEM.register("head_iron_shovel", 16);
        HEAD_IRON_SWORD = JITEM.register("head_iron_sword", 16);

        HEAD_NETHERITE_AXE = JITEM.register("head_netherite_axe", 16);
        HEAD_NETHERITE_EXCAVATOR = JITEM.register("head_netherite_excavator", 16);
        HEAD_NETHERITE_HAMMER = JITEM.register("head_netherite_hammer", 16);
        HEAD_NETHERITE_HOE = JITEM.register("head_netherite_hoe", 16);
        HEAD_NETHERITE_PICKAXE = JITEM.register("head_netherite_pickaxe", 16);
        HEAD_NETHERITE_SHOVEL = JITEM.register("head_netherite_shovel", 16);
        HEAD_NETHERITE_SWORD = JITEM.register("head_netherite_sword", 16);

        HEAD_RUBY_AXE = JITEM.register("head_ruby_axe", 16);
        HEAD_RUBY_EXCAVATOR = JITEM.register("head_ruby_excavator", 16);
        HEAD_RUBY_HAMMER = JITEM.register("head_ruby_hammer", 16);
        HEAD_RUBY_HOE = JITEM.register("head_ruby_hoe", 16);
        HEAD_RUBY_PICKAXE = JITEM.register("head_ruby_pickaxe", 16);
        HEAD_RUBY_SHOVEL = JITEM.register("head_ruby_shovel", 16);
        HEAD_RUBY_SWORD = JITEM.register("head_ruby_sword", 16);

        HEAD_SAPPHIRE_AXE = JITEM.register("head_sapphire_axe", 16);
        HEAD_SAPPHIRE_EXCAVATOR = JITEM.register("head_sapphire_excavator", 16);
        HEAD_SAPPHIRE_HAMMER = JITEM.register("head_sapphire_hammer", 16);
        HEAD_SAPPHIRE_HOE = JITEM.register("head_sapphire_hoe", 16);
        HEAD_SAPPHIRE_PICKAXE = JITEM.register("head_sapphire_pickaxe", 16);
        HEAD_SAPPHIRE_SHOVEL = JITEM.register("head_sapphire_shovel", 16);
        HEAD_SAPPHIRE_SWORD = JITEM.register("head_sapphire_sword", 16);

        HEAD_STONE_HAMMER = JITEM.register("head_stone_hammer", 16);
        HEAD_STONE_EXCAVATOR = JITEM.register("head_stone_excavator", 16);
        HEAD_WOOD_HAMMER = JITEM.register("head_wood_hammer", 16);
        HEAD_WOOD_EXCAVATOR = JITEM.register("head_wood_excavator", 16);
        //endregion

        //region AMETHYST ARMOR
        ARMOR_AMETHYST_HELMET = JITEM.registerArmor("armor_amethyst_helmet", ModArmorMaterials.AMETHYST, EquipmentType.HELMET);
        ARMOR_AMETHYST_CHESTPLATE = JITEM.registerArmor("armor_amethyst_chestplate", ModArmorMaterials.AMETHYST, EquipmentType.CHESTPLATE);
        ARMOR_AMETHYST_LEGGINGS = JITEM.registerArmor("armor_amethyst_leggings", ModArmorMaterials.AMETHYST, EquipmentType.LEGGINGS);
        ARMOR_AMETHYST_BOOTS = JITEM.registerArmor("armor_amethyst_boots", ModArmorMaterials.AMETHYST, EquipmentType.BOOTS);
        //endregion
        //region CITRINE ARMOR
        ARMOR_CITRINE_HELMET = JITEM.registerArmor("armor_citrine_helmet", ModArmorMaterials.CITRINE, EquipmentType.HELMET);
        ARMOR_CITRINE_CHESTPLATE = JITEM.registerArmor("armor_citrine_chestplate", ModArmorMaterials.CITRINE, EquipmentType.CHESTPLATE);
        ARMOR_CITRINE_LEGGINGS = JITEM.registerArmor("armor_citrine_leggings", ModArmorMaterials.CITRINE, EquipmentType.LEGGINGS);
        ARMOR_CITRINE_BOOTS = JITEM.registerArmor("armor_citrine_boots", ModArmorMaterials.CITRINE, EquipmentType.BOOTS);
        //endregion
        //region COPPER ARMOR
        ARMOR_COPPER_HELMET = JITEM.registerArmor("armor_copper_helmet", ModArmorMaterials.COPPER, EquipmentType.HELMET);
        ARMOR_COPPER_CHESTPLATE = JITEM.registerArmor("armor_copper_chestplate", ModArmorMaterials.COPPER, EquipmentType.CHESTPLATE);
        ARMOR_COPPER_LEGGINGS = JITEM.registerArmor("armor_copper_leggings", ModArmorMaterials.COPPER, EquipmentType.LEGGINGS);
        ARMOR_COPPER_BOOTS = JITEM.registerArmor("armor_copper_boots", ModArmorMaterials.COPPER, EquipmentType.BOOTS);
        //endregion
        //region EMERALD ARMOR
        ARMOR_EMERALD_HELMET = JITEM.registerArmor("armor_emerald_helmet", ModArmorMaterials.EMERALD, EquipmentType.HELMET);
        ARMOR_EMERALD_CHESTPLATE = JITEM.registerArmor("armor_emerald_chestplate", ModArmorMaterials.EMERALD, EquipmentType.CHESTPLATE);
        ARMOR_EMERALD_LEGGINGS = JITEM.registerArmor("armor_emerald_leggings", ModArmorMaterials.EMERALD, EquipmentType.LEGGINGS);
        ARMOR_EMERALD_BOOTS = JITEM.registerArmor("armor_emerald_boots", ModArmorMaterials.EMERALD, EquipmentType.BOOTS);
        //endregion
        //region ENDERITE ARMOR
        ARMOR_ENDERITE_HELMET = JITEM.registerArmor("armor_enderite_helmet", ModArmorMaterials.ENDERITE, EquipmentType.HELMET);
        ARMOR_ENDERITE_CHESTPLATE = JITEM.registerArmor("armor_enderite_chestplate", ModArmorMaterials.ENDERITE, EquipmentType.CHESTPLATE);
        ARMOR_ENDERITE_LEGGINGS = JITEM.registerArmor("armor_enderite_leggings", ModArmorMaterials.ENDERITE, EquipmentType.LEGGINGS);
        ARMOR_ENDERITE_BOOTS = JITEM.registerArmor("armor_enderite_boots", ModArmorMaterials.ENDERITE, EquipmentType.BOOTS);
        //endregion
        //region RUBY ARMOR
        ARMOR_RUBY_HELMET = JITEM.registerArmor("armor_ruby_helmet", ModArmorMaterials.RUBY, EquipmentType.HELMET);
        ARMOR_RUBY_CHESTPLATE = JITEM.registerArmor("armor_ruby_chestplate", ModArmorMaterials.RUBY, EquipmentType.CHESTPLATE);
        ARMOR_RUBY_LEGGINGS = JITEM.registerArmor("armor_ruby_leggings", ModArmorMaterials.RUBY, EquipmentType.LEGGINGS);
        ARMOR_RUBY_BOOTS = JITEM.registerArmor("armor_ruby_boots", ModArmorMaterials.RUBY, EquipmentType.BOOTS);
        //endregion
        //region SAPPHIRE ARMOR
        ARMOR_SAPPHIRE_HELMET = JITEM.registerArmor("armor_sapphire_helmet", ModArmorMaterials.SAPPHIRE, EquipmentType.HELMET);
        ARMOR_SAPPHIRE_CHESTPLATE = JITEM.registerArmor("armor_sapphire_chestplate", ModArmorMaterials.SAPPHIRE, EquipmentType.CHESTPLATE);
        ARMOR_SAPPHIRE_LEGGINGS = JITEM.registerArmor("armor_sapphire_leggings", ModArmorMaterials.SAPPHIRE, EquipmentType.LEGGINGS);
        ARMOR_SAPPHIRE_BOOTS = JITEM.registerArmor("armor_sapphire_boots", ModArmorMaterials.SAPPHIRE, EquipmentType.BOOTS);
        //endregion

        //region TOOL
        //region CITRINE TOOLS
        TOOL_CITRINE_AXE = JITEM.registerAxe("tool_citrine_axe", ModToolMaterials.CITRINE, 0.0f, 0.0f);
        TOOL_CITRINE_HOE = JITEM.registerHoe("tool_citrine_hoe", ModToolMaterials.CITRINE, 0.0f, 0.0f);
        TOOL_CITRINE_PICKAXE = JITEM.registerPickaxe("tool_citrine_pickaxe", ModToolMaterials.CITRINE, 1.0f, -1.0f);
        TOOL_CITRINE_SHOVEL = JITEM.registerShovel("tool_citrine_shovel", ModToolMaterials.CITRINE, 0.0f, 0.0f);
        TOOL_CITRINE_SWORD = JITEM.registerTool("tool_citrine_sword", ModToolMaterials.CITRINE, 3.0f, -0.5f, CitrineSword::new);
        TOOL_CITRINE_EXCAVATOR = JITEM.registerTool("tool_citrine_excavator", ModToolMaterials.CITRINE, 0.0f, 0.0f, ExcavatorItem::new)
                .setDepth(CONFIGS.CITRINE_EXCAVATOR_DEPTH).setRadius(CONFIGS.CITRINE_EXCAVATOR_WIDTH);
        TOOL_CITRINE_HAMMER = JITEM.registerTool("tool_citrine_hammer", ModToolMaterials.CITRINE, 1.0f, -2.0f, HammerItem::new)
                .setDepth(CONFIGS.CITRINE_HAMMER_DEPTH).setRadius(CONFIGS.CITRINE_HAMMER_WIDTH);
        //endregion
        //region COPPER TOOLS
        TOOL_COPPER_AXE = JITEM.registerAxe("tool_copper_axe", ModToolMaterials.COPPER, 6.0f, -1.5f);
        TOOL_COPPER_HOE = JITEM.registerHoe("tool_copper_hoe", ModToolMaterials.COPPER, 0.0f, 0.0f);
        TOOL_COPPER_PICKAXE = JITEM.registerPickaxe("tool_copper_pickaxe", ModToolMaterials.COPPER, 1.0f, -1.0f);
        TOOL_COPPER_SHOVEL = JITEM.registerShovel("tool_copper_shovel", ModToolMaterials.COPPER, 0.0f, 0.0f);
        TOOL_COPPER_SWORD = JITEM.registerTool("tool_copper_sword", ModToolMaterials.COPPER, 3.0f, -2.4f, CopperSword::new);
        TOOL_COPPER_EXCAVATOR = JITEM.registerTool("tool_copper_excavator", ModToolMaterials.COPPER, 0.0f, 0.0f, ExcavatorItem::new)
                .setDepth(CONFIGS.COPPER_EXCAVATOR_DEPTH).setRadius(CONFIGS.COPPER_EXCAVATOR_WIDTH);
        TOOL_COPPER_HAMMER = JITEM.registerTool("tool_copper_hammer", ModToolMaterials.COPPER, 1.0f, -2.8f, HammerItem::new)
                .setDepth(CONFIGS.COPPER_HAMMER_DEPTH).setRadius(CONFIGS.COPPER_HAMMER_WIDTH);
        //endregion
        //region ENDERITE TOOLS
        TOOL_ENDERITE_AXE = JITEM.registerAxe("tool_enderite_axe", ModToolMaterials.ENDERITE, 20.0f, -2.5f);
        TOOL_ENDERITE_HOE = JITEM.registerHoe("tool_enderite_hoe", ModToolMaterials.ENDERITE, 0.0f, 0.0f);
        TOOL_ENDERITE_PICKAXE = JITEM.registerPickaxe("tool_enderite_pickaxe", ModToolMaterials.ENDERITE, 1.0f, -1.0f);
        TOOL_ENDERITE_SHOVEL = JITEM.registerShovel("tool_enderite_shovel", ModToolMaterials.ENDERITE, 0.0f, 0.0f);
        TOOL_ENDERITE_SWORD = JITEM.registerTool("tool_enderite_sword", ModToolMaterials.ENDERITE, 3.0f, 3.0f, EnderiteSword::new);
        TOOL_ENDERITE_EXCAVATOR = JITEM.registerTool("tool_enderite_excavator", ModToolMaterials.ENDERITE, 0.0f, 0.0f, ExcavatorItem::new)
                .setDepth(CONFIGS.ENDERITE_EXCAVATOR_DEPTH).setRadius(CONFIGS.ENDERITE_EXCAVATOR_WIDTH);
        TOOL_ENDERITE_HAMMER = JITEM.registerTool("tool_enderite_hammer", ModToolMaterials.ENDERITE, 1.0f, -2.8f, HammerItem::new)
                .setDepth(CONFIGS.ENDERITE_HAMMER_DEPTH).setRadius(CONFIGS.ENDERITE_HAMMER_WIDTH);

        //endregion
        //region RUBY TOOLS
        TOOL_RUBY_AXE = JITEM.registerAxe("tool_ruby_axe", ModToolMaterials.RUBY, 5.0f, -1.5f);
        TOOL_RUBY_HOE = JITEM.registerHoe("tool_ruby_hoe", ModToolMaterials.RUBY, 0.0f, 0.0f);
        TOOL_RUBY_PICKAXE = JITEM.registerPickaxe("tool_ruby_pickaxe", ModToolMaterials.RUBY, 1.0f, -1.0f);
        TOOL_RUBY_SHOVEL = JITEM.registerShovel("tool_ruby_shovel", ModToolMaterials.RUBY, 0.0f, 0.0f);
        TOOL_RUBY_SWORD = JITEM.registerTool("tool_ruby_sword", ModToolMaterials.RUBY, 4.0f, -0.5f, RubySword::new);
        TOOL_RUBY_EXCAVATOR = JITEM.registerTool("tool_ruby_excavator", ModToolMaterials.RUBY, 0.0f, 0.0f, ExcavatorItem::new)
                .setDepth(CONFIGS.RUBY_EXCAVATOR_DEPTH).setRadius(CONFIGS.RUBY_EXCAVATOR_WIDTH);
        TOOL_RUBY_HAMMER = JITEM.registerTool("tool_ruby_hammer", ModToolMaterials.RUBY, 1.0f, -2.8f, HammerItem::new)
                .setDepth(CONFIGS.RUBY_HAMMER_DEPTH).setRadius(CONFIGS.RUBY_HAMMER_WIDTH);
        //endregion
        //region SAPPHIRE TOOLS
        TOOL_SAPPHIRE_AXE = JITEM.registerAxe("tool_sapphire_axe", ModToolMaterials.SAPPHIRE, 5.0f, -1.5f);
        TOOL_SAPPHIRE_HOE = JITEM.registerHoe("tool_sapphire_hoe", ModToolMaterials.SAPPHIRE, 0.0f, 0.0f);
        TOOL_SAPPHIRE_PICKAXE = JITEM.registerPickaxe("tool_sapphire_pickaxe", ModToolMaterials.SAPPHIRE, 1.0f, -1.0f);
        TOOL_SAPPHIRE_SHOVEL = JITEM.registerShovel("tool_sapphire_shovel", ModToolMaterials.SAPPHIRE, 0.0f, 0.0f);
        TOOL_SAPPHIRE_SWORD = JITEM.registerTool("tool_sapphire_sword", ModToolMaterials.SAPPHIRE, 4.0f, -0.5f, SapphireSword::new);
        TOOL_SAPPHIRE_EXCAVATOR = JITEM.registerTool("tool_sapphire_excavator", ModToolMaterials.SAPPHIRE, 0.0f, 0.0f, ExcavatorItem::new)
                .setDepth(CONFIGS.SAPPHIRE_EXCAVATOR_DEPTH).setRadius(CONFIGS.SAPPHIRE_EXCAVATOR_WIDTH);
        TOOL_SAPPHIRE_HAMMER = JITEM.registerTool("tool_sapphire_hammer", ModToolMaterials.SAPPHIRE, 1.0f, -2.8f, HammerItem::new)
                .setDepth(CONFIGS.SAPPHIRE_HAMMER_DEPTH).setRadius(CONFIGS.SAPPHIRE_HAMMER_WIDTH);
        //endregion
        //region VANILLA HAMMERS
        TOOL_DIAMOND_EXCAVATOR = JITEM.registerTool("tool_diamond_excavator", ToolMaterial.DIAMOND, 0.0f, 0.0f, ExcavatorItem::new)
                .setDepth(CONFIGS.DIAMOND_EXCAVATOR_DEPTH).setRadius(CONFIGS.DIAMOND_EXCAVATOR_WIDTH);
        TOOL_DIAMOND_HAMMER = JITEM.registerTool("tool_diamond_hammer", ToolMaterial.DIAMOND, 1.0f, -2.8f, HammerItem::new)
                .setDepth(CONFIGS.DIAMOND_HAMMER_DEPTH).setRadius(CONFIGS.DIAMOND_HAMMER_WIDTH);
        TOOL_GOLD_EXCAVATOR = JITEM.registerTool("tool_gold_excavator", ToolMaterial.GOLD, 0.0f, 0.0f, ExcavatorItem::new)
                .setDepth(CONFIGS.GOLD_EXCAVATOR_DEPTH).setRadius(CONFIGS.GOLD_EXCAVATOR_WIDTH);
        TOOL_GOLD_HAMMER = JITEM.registerTool("tool_gold_hammer", ToolMaterial.GOLD, 1.0f, -2.8f, HammerItem::new)
                .setDepth(CONFIGS.GOLD_HAMMER_DEPTH).setRadius(CONFIGS.GOLD_HAMMER_WIDTH);
        TOOL_IRON_EXCAVATOR = JITEM.registerTool("tool_iron_excavator", ToolMaterial.IRON, 0.0f, 0.0f, ExcavatorItem::new)
                .setDepth(CONFIGS.IRON_EXCAVATOR_DEPTH).setRadius(CONFIGS.IRON_EXCAVATOR_WIDTH);
        TOOL_IRON_HAMMER = JITEM.registerTool("tool_iron_hammer", ToolMaterial.IRON, 1.0f, -2.8f, HammerItem::new)
                .setDepth(CONFIGS.IRON_HAMMER_DEPTH).setRadius(CONFIGS.IRON_HAMMER_WIDTH);
        TOOL_NETHERITE_EXCAVATOR = JITEM.registerTool("tool_netherite_excavator", ToolMaterial.NETHERITE, 0.0f, 0.0f, ExcavatorItem::new)
                .setDepth(CONFIGS.NETHERITE_EXCAVATOR_DEPTH).setRadius(CONFIGS.NETHERITE_EXCAVATOR_WIDTH);
        TOOL_NETHERITE_HAMMER = JITEM.registerTool("tool_netherite_hammer", ToolMaterial.NETHERITE, 1.0f, -2.8f, HammerItem::new)
                .setDepth(CONFIGS.NETHERITE_HAMMER_DEPTH).setRadius(CONFIGS.NETHERITE_HAMMER_WIDTH);
        TOOL_STONE_EXCAVATOR = JITEM.registerTool("tool_stone_excavator", ToolMaterial.STONE, 0.0f, 0.0f, ExcavatorItem::new)
                .setDepth(CONFIGS.STONE_EXCAVATOR_DEPTH).setRadius(CONFIGS.STONE_EXCAVATOR_WIDTH);
        TOOL_STONE_HAMMER = JITEM.registerTool("tool_stone_hammer", ToolMaterial.STONE, 1.0f, -2.8f, HammerItem::new)
                .setDepth(CONFIGS.STONE_HAMMER_DEPTH).setRadius(CONFIGS.STONE_HAMMER_WIDTH);
        TOOL_WOOD_EXCAVATOR = JITEM.registerTool("tool_wood_excavator", ToolMaterial.WOOD, 0.0f, 0.0f, ExcavatorItem::new)
                .setDepth(CONFIGS.WOOD_EXCAVATOR_DEPTH).setRadius(CONFIGS.WOOD_EXCAVATOR_WIDTH);
        TOOL_WOOD_HAMMER = JITEM.registerTool("tool_wood_hammer", ToolMaterial.WOOD, 1.0f, -2.8f, HammerItem::new)
                .setDepth(CONFIGS.WOOD_HAMMER_DEPTH).setRadius(CONFIGS.WOOD_HAMMER_WIDTH);
        //endregion

        PLAYER_TELEPORT = JITEM.register("tool_player_teleport", 1, PlayerTeleporter::new);
        TUNER = JITEM.register("tool_tuner", 1, TunerItem::new);
        ADVANCED_TUNER = JITEM.register("tool_tuner_advanced", 1, AdvancedTuner::new);

        CHALICE = JITEM.register("chalice", 1, ChaliceItem::new);
        CHALICE_EMPTY = JITEM.register("chalice_empty", 1);
        //endregion

        BLUEPRINT_EMPTY = JITEM.register("blueprint_empty", 1);
        BLUEPRINT_PRINTED = JITEM.register("blueprint_printed", 1, BlueprintItem::new);
        WRENCH = JITEM.register("tool_wrench", 1, WrenchItem::new);

        BACKPACK = JITEM.register("backpack", 1, BackpackItem::new);
        ENDER_BACKPACK = JITEM.register("ender_backpack", 1, EnderBackpackItem::new);
    }

    public static void setBlackList()
    {

    }
}