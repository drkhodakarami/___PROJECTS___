/***********************************************************************************
 * Copyright (c) 2025 Alireza Khodakarami (Jiraiyah)                               *
 * ------------------------------------------------------------------------------- *
 * MIT License                                                                     *
 * =============================================================================== *
 * Permission is hereby granted, free of charge, to any person obtaining a copy    *
 * of this software and associated documentation files (the "Software"), to deal   *
 * in the Software without restriction, including without limitation the rights    *
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell       *
 * copies of the Software, and to permit persons to whom the Software is           *
 * furnished to do so, subject to the following conditions:                        *
 * ------------------------------------------------------------------------------- *
 * The above copyright notice and this permission notice shall be included in all  *
 * copies or substantial portions of the Software.                                 *
 * ------------------------------------------------------------------------------- *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR      *
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,        *
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE     *
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER          *
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,   *
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE   *
 * SOFTWARE.                                                                       *
 ***********************************************************************************/

package jiraiyah.ultraio.datagen.base;

import jiraiyah.ultraio.Main;
import jiraiyah.ultraio.registry.ModBlockItems;
import jiraiyah.ultraio.registry.ModBlocks;
import jiraiyah.ultraio.registry.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.text.MutableText;
import net.minecraft.text.TranslatableTextContent;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

import static jiraiyah.ultraio.Main.REFERENCE;
import static jiraiyah.ultraio.Main.ModID;

public class ModEnLanguageProvider extends FabricLanguageProvider
{
    public ModEnLanguageProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup)
    {
        super(dataOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder builder)
    {
        Main.LOGGER.logEnLanguageDatagen();

        //region INGREDIENTS
        builder.add(ModItems.BINDING_STRING, "Binding String");
        builder.add(ModItems.UNSTABLE_GOO, "Unstable Goo Core");
        builder.add(ModItems.COMBUSTION_CORE, "Combustion Core");
        builder.add(ModItems.RAW_RUBBER, "Raw Rubber");
        builder.add(ModItems.RUBBER, "Rubber");
        builder.add(ModItems.VOID_PLATE_BASE, "Portal Frame");
        builder.add(ModItems.VOID_PLATE_ACTIVATOR, "Portal Activator");
        builder.add(ModItems.VOID_PLATE, "Portal Key");
        builder.add(ModItems.ENDER_CHARM, "Ender Charm");
        builder.add(ModItems.ENDERMAN_EYE, "Enderman Eye");
        builder.add(ModItems.ENDERMAN_HEART, "Enderman Heart");
        builder.add(ModItems.ENDERMAN_GLAND, "Enderman Gland");
        builder.add(ModItems.COOKED_EGG, "Cooked Egg");
        builder.add(ModItems.EGG_AND_BREAD, "Egg And Bread");
        builder.add(ModItems.HOT_COAL, "Hot Coal");
        builder.add(ModItems.THERMAL_CORE, "Thermal Energy Core");
        //endregion

        builder.add(ModItems.ITEM_FILTER, "Item Filter");
        builder.add(ModItems.SLOT_DISABLED, "Disable Slot");
        builder.add(ModItems.NEED_SIGNAL, "Need Signal Cartridge");

        //region CAST
        builder.add(ModItems.CAST_AXE, "Axe Head Cast");
        builder.add(ModItems.CAST_BINDING, "Binding String Cast");
        builder.add(ModItems.CAST_EXCAVATOR, "Excavator Head Cast");
        builder.add(ModItems.CAST_GEAR, "Gear Cast");
        builder.add(ModItems.CAST_GEM, "Gem Cast");
        builder.add(ModItems.CAST_HAMMER, "Hammer Head Cast");
        builder.add(ModItems.CAST_HANDLE, "Tool Handle Cast");
        builder.add(ModItems.CAST_HOE, "Hoe Cast");
        builder.add(ModItems.CAST_INGOT, "Ingot Cast");
        builder.add(ModItems.CAST_NUGGET, "Nugget Cast");
        builder.add(ModItems.CAST_PICKAXE, "Pickaxe Head Cast");
        builder.add(ModItems.CAST_PLATE, "Plate Cast");
        builder.add(ModItems.CAST_ROD, "Rod Cast");
        builder.add(ModItems.CAST_SHOVEL, "Shovel Head Cast");
        builder.add(ModItems.CAST_SWORD, "Sword Head Cast");
        builder.add(ModItems.CAST_WIRE, "Wire Cast");
        builder.add(ModItems.CAST_WOOD_INGOT, "Wooden Ingot Cast");
        builder.add(ModItems.CAST_WOOD_PICKAXE, "Wooden Pickaxe Head Cast");
        //endregion
        //region RAW
        builder.add(ModItems.RAW_CITRINE, "Raw Citrine");
        builder.add(ModItems.RAW_ENDERITE, "Raw Enderite");
        builder.add(ModItems.RAW_QUARTZ, "Raw Quartz");
        builder.add(ModItems.RAW_RUBY, "Raw Ruby");
        builder.add(ModItems.RAW_SAPPHIRE, "Raw Sapphire");
        //endregion
        //region GEM
        builder.add(ModItems.GEM_CITRINE, "Citrine Gem");
        builder.add(ModItems.GEM_RUBY, "Ruby Gem");
        builder.add(ModItems.GEM_SAPPHIRE, "Sapphire Gem");
        //endregion
        //region DUST
        builder.add(ModItems.CRUSHED_SHULKER, "Crushed Shulker Shell");
        builder.add(ModItems.DUST_CONDUCTIVE, "Conductive Dust");
        builder.add(ModItems.DUST_COPPER, "Copper Dust");
        builder.add(ModItems.DUST_ENDERITE, "Enderite Dust");
        builder.add(ModItems.DUST_ENERGETIC, "Energetic Dust");
        builder.add(ModItems.DUST_GOLD, "Gold Dust");
        builder.add(ModItems.DUST_IRON, "Iron Dust");
        builder.add(ModItems.DUST_OBSIDIAN, "Obsidian Dust");
        builder.add(ModItems.DUST_PULSATING, "Pulsating Dust");
        builder.add(ModItems.DUST_RED_ALLOY, "Red Alloy Dust");
        builder.add(ModItems.DUST_SOUL, "Soul Dust");
        builder.add(ModItems.DUST_VIBRANT, "Vibrant Dust");
        builder.add(ModItems.DUST_WITHERING, "Withering Dust");
        //endregion
        //region GEAR
        builder.add(ModItems.GEAR_COPPER, "Copper Gear");
        builder.add(ModItems.GEAR_DIAMOND, "Diamond Gear");
        builder.add(ModItems.GEAR_EMERALD, "Emerald Gear");
        builder.add(ModItems.GEAR_ENDERITE, "Enderite Gear");
        builder.add(ModItems.GEAR_ENERGIZED, "Energized Gear");
        builder.add(ModItems.GEAR_GOLD, "Gold Gear");
        builder.add(ModItems.GEAR_IRON, "Iron Gear");
        builder.add(ModItems.GEAR_LAPIS, "Lapis Gear");
        builder.add(ModItems.GEAR_NETHERITE, "Netherite Gear");
        builder.add(ModItems.GEAR_OBSIDIAN, "Obsidian Gear");
        builder.add(ModItems.GEAR_PRISMARINE, "Prismarine Gear");
        builder.add(ModItems.GEAR_QUARTZ, "Quartz Gear");
        builder.add(ModItems.GEAR_RUBY, "Ruby Gear");
        builder.add(ModItems.GEAR_SAPPHIRE, "Sapphire Gear");
        builder.add(ModItems.GEAR_SHULKER, "Shulker Shell Gear");
        builder.add(ModItems.GEAR_STONE, "Stone Gear");
        builder.add(ModItems.GEAR_VIBRANT, "Vibrant Gear");
        builder.add(ModItems.GEAR_WOOD, "Wood Gear");
        //endregion
        //region ALLOY
        builder.add(ModItems.INGOT_ALLOY_CONDUCTIVE, "Conductive Alloy");
        builder.add(ModItems.INGOT_ALLOY_ENERGETIC, "Energetic Alloy");
        builder.add(ModItems.INGOT_ALLOY_PULSATING, "Pulsating Alloy");
        builder.add(ModItems.INGOT_ALLOY_RED, "Red Alloy");
        builder.add(ModItems.INGOT_ALLOY_VIBRANT, "Vibrant Alloy");
        builder.add(ModItems.INGOT_ALLOY_ENDERITE, "Enderite Alloy");
        builder.add(ModItems.INGOT_ENDERITE, "Enderite Ingot");
        builder.add(ModItems.RAW_ALLOY_ENDERITE, "Raw Enderite Alloy");
        //endregion
        //region PLATE
        builder.add(ModItems.PLATE_AMETHYST, "Amethyst Plate");
        builder.add(ModItems.PLATE_CITRINE, "Citrine Plate");
        builder.add(ModItems.PLATE_COPPER, "Copper Plate");
        builder.add(ModItems.PLATE_DIAMOND, "Diamond Plate");
        builder.add(ModItems.PLATE_EMERALD, "Emerald Plate");
        builder.add(ModItems.PLATE_ENDERITE, "Enderite Plate");
        builder.add(ModItems.PLATE_GOLD, "Gold Plate");
        builder.add(ModItems.PLATE_IRON, "Iron Plate");
        builder.add(ModItems.PLATE_NETHERITE, "Netherite Plate");
        builder.add(ModItems.PLATE_RUBY, "Ruby Plate");
        builder.add(ModItems.PLATE_SAPPHIRE, "Sapphire Plate");
        builder.add(ModItems.PLATE_SHULKER, "Shulker Shell Plate");
        builder.add(ModItems.PLATE_STONE, "Stone Plate");
        //endregion
        //region REINFORCED PLATE
        builder.add(ModItems.REINFORCED_AMETHYST, "Reinforced Amethyst Plate");
        builder.add(ModItems.REINFORCED_CITRINE, "Reinforced Citrine Plate");
        builder.add(ModItems.REINFORCED_COPPER, "Reinforced Copper Plate");
        builder.add(ModItems.REINFORCED_DIAMOND, "Reinforced Diamond Plate");
        builder.add(ModItems.REINFORCED_EMERALD, "Reinforced Emerald Plate");
        builder.add(ModItems.REINFORCED_ENDERITE, "Reinforced Enderite Plate");
        builder.add(ModItems.REINFORCED_GOLD, "Reinforced Gold Plate");
        builder.add(ModItems.REINFORCED_IRON, "Reinforced Iron Plate");
        builder.add(ModItems.REINFORCED_NETHERITE, "Reinforced Netherite Plate");
        builder.add(ModItems.REINFORCED_RUBY, "Reinforced Ruby Plate");
        builder.add(ModItems.REINFORCED_SAPPHIRE, "Reinforced Sapphire Plate");
        builder.add(ModItems.REINFORCED_SHULKER, "Reinforced Shulker Shell Plate");
        //endregion
        //region ROD
        builder.add(ModItems.ROD_COPPER, "Copper Rod");
        builder.add(ModItems.ROD_ENDERITE, "Enderite Rod");
        builder.add(ModItems.ROD_GLOWSTONE, "Glowstone Rod");
        builder.add(ModItems.ROD_GOLD, "Gold Rod");
        builder.add(ModItems.ROD_IRON, "Iron Rod");
        builder.add(ModItems.ROD_OBSIDIAN, "Obsidian Rod");
        builder.add(ModItems.ROD_REDSTONE, "Redstone Rod");
        builder.add(ModItems.ROD_SHULKER, "Shulker Shell Rod");
        //endregion
        //region HEAD
        builder.add(ModItems.HEAD_CITRINE_AXE, "Citrine Axe Head");
        builder.add(ModItems.HEAD_CITRINE_EXCAVATOR, "Citrine Excavator Head");
        builder.add(ModItems.HEAD_CITRINE_HAMMER, "Citrine Hammer Head");
        builder.add(ModItems.HEAD_CITRINE_HOE, "Citrine Hoe Head");
        builder.add(ModItems.HEAD_CITRINE_PICKAXE, "Citrine Pickaxe Head");
        builder.add(ModItems.HEAD_CITRINE_SHOVEL, "Citrine Shovel Head");
        builder.add(ModItems.HEAD_CITRINE_SWORD, "Citrine Sword Head");
        builder.add(ModItems.HEAD_COPPER_AXE, "Copper Axe Head");
        builder.add(ModItems.HEAD_COPPER_EXCAVATOR, "Copper Excavator Head");
        builder.add(ModItems.HEAD_COPPER_HAMMER, "Copper Hammer Head");
        builder.add(ModItems.HEAD_COPPER_HOE, "Copper Hoe Head");
        builder.add(ModItems.HEAD_COPPER_PICKAXE, "Copper Pickaxe Head");
        builder.add(ModItems.HEAD_COPPER_SHOVEL, "Copper Shovel Head");
        builder.add(ModItems.HEAD_COPPER_SWORD, "Copper Sword Head");
        builder.add(ModItems.HEAD_DIAMOND_AXE, "Diamond Axe Head");
        builder.add(ModItems.HEAD_DIAMOND_EXCAVATOR, "Diamond Excavator Head");
        builder.add(ModItems.HEAD_DIAMOND_HAMMER, "Diamond Hammer Head");
        builder.add(ModItems.HEAD_DIAMOND_HOE, "Diamond Hoe Head");
        builder.add(ModItems.HEAD_DIAMOND_PICKAXE, "Diamond Pickaxe Head");
        builder.add(ModItems.HEAD_DIAMOND_SHOVEL, "Diamond Shovel Head");
        builder.add(ModItems.HEAD_DIAMOND_SWORD, "Diamond Sword Head");
        builder.add(ModItems.HEAD_ENDERITE_AXE, "Enderite Axe Head");
        builder.add(ModItems.HEAD_ENDERITE_EXCAVATOR, "Enderite Excavator Head");
        builder.add(ModItems.HEAD_ENDERITE_HAMMER, "Enderite Hammer Head");
        builder.add(ModItems.HEAD_ENDERITE_HOE, "Enderite Hoe Head");
        builder.add(ModItems.HEAD_ENDERITE_PICKAXE, "Enderite Pickaxe Head");
        builder.add(ModItems.HEAD_ENDERITE_SHOVEL, "Enderite Shovel Head");
        builder.add(ModItems.HEAD_ENDERITE_SWORD, "Enderite Sword Head");
        builder.add(ModItems.HEAD_GOLD_AXE, "Gold Axe Head");
        builder.add(ModItems.HEAD_GOLD_EXCAVATOR, "Gold Excavator Head");
        builder.add(ModItems.HEAD_GOLD_HAMMER, "Gold Hammer Head");
        builder.add(ModItems.HEAD_GOLD_HOE, "Gold Hoe Head");
        builder.add(ModItems.HEAD_GOLD_PICKAXE, "Gold Pickaxe Head");
        builder.add(ModItems.HEAD_GOLD_SHOVEL, "Gold Shovel Head");
        builder.add(ModItems.HEAD_GOLD_SWORD, "Gold Sword Head");
        builder.add(ModItems.HEAD_IRON_AXE, "Iron Axe Head");
        builder.add(ModItems.HEAD_IRON_EXCAVATOR, "Iron Excavator Head");
        builder.add(ModItems.HEAD_IRON_HAMMER, "Iron Hammer Head");
        builder.add(ModItems.HEAD_IRON_HOE, "Iron Hoe Head");
        builder.add(ModItems.HEAD_IRON_PICKAXE, "Iron Pickaxe Head");
        builder.add(ModItems.HEAD_IRON_SHOVEL, "Iron Shovel Head");
        builder.add(ModItems.HEAD_IRON_SWORD, "Iron Sword Head");
        builder.add(ModItems.HEAD_NETHERITE_AXE, "Netherite Axe Head");
        builder.add(ModItems.HEAD_NETHERITE_EXCAVATOR, "Netherite Excavator Head");
        builder.add(ModItems.HEAD_NETHERITE_HAMMER, "Netherite Hammer Head");
        builder.add(ModItems.HEAD_NETHERITE_HOE, "Netherite Hoe Head");
        builder.add(ModItems.HEAD_NETHERITE_PICKAXE, "Netherite Pickaxe Head");
        builder.add(ModItems.HEAD_NETHERITE_SHOVEL, "Netherite Shovel Head");
        builder.add(ModItems.HEAD_NETHERITE_SWORD, "Netherite Sword Head");
        builder.add(ModItems.HEAD_RUBY_AXE, "Ruby Axe Head");
        builder.add(ModItems.HEAD_RUBY_EXCAVATOR, "Ruby Excavator Head");
        builder.add(ModItems.HEAD_RUBY_HAMMER, "Ruby Hammer Head");
        builder.add(ModItems.HEAD_RUBY_HOE, "Ruby Hoe Head");
        builder.add(ModItems.HEAD_RUBY_PICKAXE, "Ruby Pickaxe Head");
        builder.add(ModItems.HEAD_RUBY_SHOVEL, "Ruby Shovel Head");
        builder.add(ModItems.HEAD_RUBY_SWORD, "Ruby Sword Head");
        builder.add(ModItems.HEAD_SAPPHIRE_AXE, "Sapphire Axe Head");
        builder.add(ModItems.HEAD_SAPPHIRE_EXCAVATOR, "Sapphire Excavator Head");
        builder.add(ModItems.HEAD_SAPPHIRE_HAMMER, "Sapphire Hammer Head");
        builder.add(ModItems.HEAD_SAPPHIRE_HOE, "Sapphire Hoe Head");
        builder.add(ModItems.HEAD_SAPPHIRE_PICKAXE, "Sapphire Pickaxe Head");
        builder.add(ModItems.HEAD_SAPPHIRE_SHOVEL, "Sapphire Shovel Head");
        builder.add(ModItems.HEAD_SAPPHIRE_SWORD, "Sapphire Sword Head");
        builder.add(ModItems.HEAD_STONE_HAMMER, "Stone Hammer Head");
        builder.add(ModItems.HEAD_STONE_EXCAVATOR, "Stone Excavator Head");
        builder.add(ModItems.HEAD_WOOD_HAMMER, "Wooden Hammer Head");
        builder.add(ModItems.HEAD_WOOD_EXCAVATOR, "Wooden Excavator Head");
        //endregion
        //region ARMOR
        builder.add(ModItems.ARMOR_AMETHYST_HELMET, "Amethyst Helmet");
        builder.add(ModItems.ARMOR_AMETHYST_CHESTPLATE, "Amethyst Chestplate");
        builder.add(ModItems.ARMOR_AMETHYST_LEGGINGS, "Amethyst Leggings");
        builder.add(ModItems.ARMOR_AMETHYST_BOOTS, "Amethyst Boots");
        builder.add(ModItems.ARMOR_CITRINE_HELMET, "Citrine Helmet");
        builder.add(ModItems.ARMOR_CITRINE_CHESTPLATE, "Citrine Chestplate");
        builder.add(ModItems.ARMOR_CITRINE_LEGGINGS, "Citrine Leggings");
        builder.add(ModItems.ARMOR_CITRINE_BOOTS, "Citrine Boots");
        builder.add(ModItems.ARMOR_COPPER_HELMET, "Copper Helmet");
        builder.add(ModItems.ARMOR_COPPER_CHESTPLATE, "Copper Chestplate");
        builder.add(ModItems.ARMOR_COPPER_LEGGINGS, "Copper Leggings");
        builder.add(ModItems.ARMOR_COPPER_BOOTS, "Copper Boots");
        builder.add(ModItems.ARMOR_EMERALD_HELMET, "Emerald Helmet");
        builder.add(ModItems.ARMOR_EMERALD_CHESTPLATE, "Emerald Chestplate");
        builder.add(ModItems.ARMOR_EMERALD_LEGGINGS, "Emerald Leggings");
        builder.add(ModItems.ARMOR_EMERALD_BOOTS, "Emerald Boots");
        builder.add(ModItems.ARMOR_ENDERITE_HELMET, "Enderite Helmet");
        builder.add(ModItems.ARMOR_ENDERITE_CHESTPLATE, "Enderite Chestplate");
        builder.add(ModItems.ARMOR_ENDERITE_LEGGINGS, "Enderite Leggings");
        builder.add(ModItems.ARMOR_ENDERITE_BOOTS, "Enderite Boots");
        builder.add(ModItems.ARMOR_RUBY_HELMET, "Ruby Helmet");
        builder.add(ModItems.ARMOR_RUBY_CHESTPLATE, "Ruby Chestplate");
        builder.add(ModItems.ARMOR_RUBY_LEGGINGS, "Ruby Leggings");
        builder.add(ModItems.ARMOR_RUBY_BOOTS, "Ruby Boots");
        builder.add(ModItems.ARMOR_SAPPHIRE_HELMET, "Sapphire Helmet");
        builder.add(ModItems.ARMOR_SAPPHIRE_CHESTPLATE, "Sapphire Chestplate");
        builder.add(ModItems.ARMOR_SAPPHIRE_LEGGINGS, "Sapphire Leggings");
        builder.add(ModItems.ARMOR_SAPPHIRE_BOOTS, "Sapphire Boots");
        //endregion
        //region TOOLS
        builder.add(ModItems.CHALICE_EMPTY, "Empty Chalice");
        builder.add(ModItems.CHALICE, "Chalice");
        builder.add(ModItems.PLAYER_TELEPORT, "Player Teleport");
        builder.add(ModItems.TUNER, "Tuner");
        builder.add(ModItems.ADVANCED_TUNER, "Advanced Tuner");
        builder.add(ModItems.TOOL_CITRINE_AXE, "Citrine Axe");
        builder.add(ModItems.TOOL_CITRINE_EXCAVATOR, "Citrine Excavator");
        builder.add(ModItems.TOOL_CITRINE_HAMMER, "Citrine Hammer");
        builder.add(ModItems.TOOL_CITRINE_HOE, "Citrine Hoe");
        builder.add(ModItems.TOOL_CITRINE_PICKAXE, "Citrine Pickaxe");
        builder.add(ModItems.TOOL_CITRINE_SHOVEL, "Citrine Shovel");
        builder.add(ModItems.TOOL_CITRINE_SWORD, "Citrine Sword");
        builder.add(ModItems.TOOL_COPPER_AXE, "Copper Axe");
        builder.add(ModItems.TOOL_COPPER_EXCAVATOR, "Copper Excavator");
        builder.add(ModItems.TOOL_COPPER_HAMMER, "Copper Hammer");
        builder.add(ModItems.TOOL_COPPER_HOE, "Copper Hoe");
        builder.add(ModItems.TOOL_COPPER_PICKAXE, "Copper Pickaxe");
        builder.add(ModItems.TOOL_COPPER_SHOVEL, "Copper Shovel");
        builder.add(ModItems.TOOL_COPPER_SWORD, "Copper Sword");
        builder.add(ModItems.TOOL_ENDERITE_AXE, "Enderite Axe");
        builder.add(ModItems.TOOL_ENDERITE_EXCAVATOR, "Enderite Excavator");
        builder.add(ModItems.TOOL_ENDERITE_HAMMER, "Enderite Hammer");
        builder.add(ModItems.TOOL_ENDERITE_HOE, "Enderite Hoe");
        builder.add(ModItems.TOOL_ENDERITE_PICKAXE, "Enderite Pickaxe");
        builder.add(ModItems.TOOL_ENDERITE_SHOVEL, "Enderite Shovel");
        builder.add(ModItems.TOOL_ENDERITE_SWORD, "Enderite Sword");
        builder.add(ModItems.TOOL_RUBY_AXE, "Ruby Axe");
        builder.add(ModItems.TOOL_RUBY_EXCAVATOR, "Ruby Excavator");
        builder.add(ModItems.TOOL_RUBY_HAMMER, "Ruby Hammer");
        builder.add(ModItems.TOOL_RUBY_HOE, "Ruby Hoe");
        builder.add(ModItems.TOOL_RUBY_PICKAXE, "Ruby Pickaxe");
        builder.add(ModItems.TOOL_RUBY_SHOVEL, "Ruby Shovel");
        builder.add(ModItems.TOOL_RUBY_SWORD, "Ruby Sword");
        builder.add(ModItems.TOOL_SAPPHIRE_AXE, "Sapphire Axe");
        builder.add(ModItems.TOOL_SAPPHIRE_EXCAVATOR, "Sapphire Excavator");
        builder.add(ModItems.TOOL_SAPPHIRE_HAMMER, "Sapphire Hammer");
        builder.add(ModItems.TOOL_SAPPHIRE_HOE, "Sapphire Hoe");
        builder.add(ModItems.TOOL_SAPPHIRE_PICKAXE, "Sapphire Pickaxe");
        builder.add(ModItems.TOOL_SAPPHIRE_SHOVEL, "Sapphire Shovel");
        builder.add(ModItems.TOOL_SAPPHIRE_SWORD, "Sapphire Sword");
        builder.add(ModItems.TOOL_DIAMOND_HAMMER, "Diamond Hammer");
        builder.add(ModItems.TOOL_DIAMOND_EXCAVATOR, "Diamond Excavator");
        builder.add(ModItems.TOOL_GOLD_HAMMER, "Gold Hammer");
        builder.add(ModItems.TOOL_GOLD_EXCAVATOR, "Gold Excavator");
        builder.add(ModItems.TOOL_IRON_HAMMER, "Iron Hammer");
        builder.add(ModItems.TOOL_IRON_EXCAVATOR, "Iron Excavator");
        builder.add(ModItems.TOOL_NETHERITE_HAMMER, "Netherite Hammer");
        builder.add(ModItems.TOOL_NETHERITE_EXCAVATOR, "Netherite Excavator");
        builder.add(ModItems.TOOL_STONE_HAMMER, "Stone Hammer");
        builder.add(ModItems.TOOL_STONE_EXCAVATOR, "Stone Excavator");
        builder.add(ModItems.TOOL_WOOD_HAMMER, "Wood Hammer");
        builder.add(ModItems.TOOL_WOOD_EXCAVATOR, "Wood Excavator");
        //endregion
        //region GEM BLOCK
        builder.add(ModBlocks.CITRINE, "Citrine Block");
        builder.add(ModBlocks.ENDERITE, "Enderite Block");
        builder.add(ModBlocks.RUBY, "Ruby Block");
        builder.add(ModBlocks.SAPPHIRE, "Sapphire Block");
        //endregion
        //region RAW BLOCK
        builder.add(ModBlocks.RAW_CITRINE, "Raw Citrine Block");
        builder.add(ModBlocks.RAW_ENDERITE, "Raw Enderite Block");
        builder.add(ModBlocks.RAW_QUARTZ, "Raw Quartz Block");
        builder.add(ModBlocks.RAW_RUBY, "Raw Ruby Block");
        builder.add(ModBlocks.RAW_SAPPHIRE, "Raw Sapphire Block");
        //endregion
        //region ORE
        builder.add(ModBlocks.ORE_DEEP_CITRINE, "Deep Citrine Ore");
        builder.add(ModBlocks.ORE_DEEP_RUBY, "Deep Ruby Ore");
        builder.add(ModBlocks.ORE_DEEP_SAPPHIRE, "Deep Sapphire Ore");

        builder.add(ModBlocks.ORE_END_CITRINE, "End Citrine Ore");
        builder.add(ModBlocks.ORE_END_ENDERITE, "End Enderite Ore");
        builder.add(ModBlocks.ORE_END_ENDERITE_CRACKED, "Cracked Enderite Ore");
        builder.add(ModBlocks.ORE_END_RUBY, "End Ruby Ore");
        builder.add(ModBlocks.ORE_END_SAPPHIRE, "end Sapphire Ore");

        builder.add(ModBlocks.ORE_NETHER_CITRINE, "Nether Citrine Ore");
        builder.add(ModBlocks.ORE_NETHER_RUBY, "Nether Ruby Ore");
        builder.add(ModBlocks.ORE_NETHER_SAPPHIRE, "Nether Sapphire Ore");
        builder.add(ModBlocks.ORE_NETHER_COAL, "Nether Coal Ore");
        builder.add(ModBlocks.ORE_NETHER_COPPER, "Nether Copper Ore");
        builder.add(ModBlocks.ORE_NETHER_DIAMOND, "Nether Diamond Ore");
        builder.add(ModBlocks.ORE_NETHER_IRON, "Nether Iron Ore");
        builder.add(ModBlocks.ORE_NETHER_LAPIS, "Nether Lapis Ore");
        builder.add(ModBlocks.ORE_NETHER_REDSTONE, "Nether Redstone Ore");

        builder.add(ModBlocks.ORE_WORLD_CITRINE, "Citrine Ore");
        builder.add(ModBlocks.ORE_WORLD_RUBY, "Ruby Ore");
        builder.add(ModBlocks.ORE_WORLD_SAPPHIRE, "Sapphire Ore");

        builder.add(ModBlocks.ORE_ENDERITE, "Enderite Ore");
        //endregion
        //region GOO
        builder.add(ModBlocks.WATER_EATING_GOO, "Water Eating Goo");
        builder.add(ModBlocks.WATER_GENERATING_GOO, "Water Generating Goo");
        builder.add(ModBlocks.LAVA_EATING_GOO, "Lava Eating Goo");
        builder.add(ModBlocks.LAVA_GENERATING_GOO, "Lava Generating Goo");
        builder.add(ModBlocks.CHUNK_GOO, "Chunk Goo");
        builder.add(ModBlocks.TOWERING_GOO, "Towering Goo");
        builder.add(ModBlocks.TUNNELING_GOO, "Tunneling Goo");
        builder.add(ModBlocks.BRIDGE_GOO, "Bridge Goo");

        //builder.add(ModBlocks.LAVA_PUMP_GOO, "Lava Pumping Goo");
        //builder.add(ModBlocks.WATER_PUMP_GOO, "Water Pumping Goo");

        builder.add(ModBlocks.AIR_BOMB_GOO, "Air Bomb Goo");
        builder.add(ModBlocks.CHUNK_BOMB_GOO, "Chunk Bomb Goo");
        builder.add(ModBlocks.STONE_BOMB_GOO, "Stone Bomb Goo");
        //endregion
        //region MACHINE
        builder.add(ModItems.BLUEPRINT_EMPTY, "Empty Blueprint");
        builder.add(ModItems.BLUEPRINT_PRINTED, "Printed Blueprint");
        builder.add(ModItems.WRENCH, "Wrench");

        builder.add(ModBlocks.REDSTONE_CLOCK, "Redstone Clock");
        builder.add(ModBlocks.ALLOY_MIXER, "Alloy Mixer");
        builder.add(ModBlocks.CAST_PRESS, "Cast Press");
        builder.add(ModBlocks.GEM_CLEANER, "Gem Cleaner");
        builder.add(ModBlocks.OVEN, "Oven");
        builder.add(ModBlocks.PULVERIZER, "Pulverizer");
        builder.add(ModBlocks.SMELTER, "Smelter");
        builder.add(ModBlocks.WOOD_STRIPPER, "Wood Stripper");
        builder.add(ModBlocks.ANIMAL_FEED, "Animal Feeder");
        builder.add(ModBlocks.BLOCK_BREAKER, "Block Breaker");
        builder.add(ModBlocks.BLOCK_PLACER, "Block Placer");
        builder.add(ModBlocks.BUILDER, "Schema Builder");
        builder.add(ModBlocks.PRINTER, "Schema Printer");
        builder.add(ModBlocks.ENDER_CHANTER, "Ender Chanter");
        builder.add(ModBlocks.PROJECT_TABLE, "Project Table");
        builder.add(ModBlocks.FLUID_PUMP, "Fluid Pump");
        builder.add(ModBlocks.CHUNK_LOADER, "Chunk Loader");
        builder.add(ModBlocks.TESSERACT, "Tesseract");
        builder.add(ModBlocks.GENERATOR, "Power Generator");
        builder.add(ModBlocks.SOLAR_PANEL, "Solar Panel Generator");
        builder.add(ModBlocks.MINER, "Miner");

        builder.add(ModItems.BACKPACK, "Backpack");
        builder.add(ModItems.ENDER_BACKPACK, "Ender Backpack");
        builder.add(ModBlocks.BATTERY_BANK, "Energy Bank");
        builder.add(ModBlocks.CREATIVE_BANK, "Creative Energy Bank");
        //endregion

        builder.add(ModBlockItems.ANGEL, "Angel Block");
        builder.add(ModBlocks.ELEVATOR, "Elevator");

        builder.add(ModBlocks.CARROT_BOX, "Box of Carrots");
        builder.add(ModBlocks.POTATO_BOX, "Box of Potatoes");

        //region DECORATION
        builder.add(ModBlocks.CITRINE_STAIRS, "Citrine Stairs");
        builder.add(ModBlocks.ENDERITE_STAIRS, "Enderite Stairs");
        builder.add(ModBlocks.RUBY_STAIRS, "Ruby Stairs");
        builder.add(ModBlocks.SAPPHIRE_STAIRS, "Sapphire Stairs");

        builder.add(ModBlocks.CITRINE_SLAB, "Citrine Slab");
        builder.add(ModBlocks.ENDERITE_SLAB, "Enderite Slab");
        builder.add(ModBlocks.RUBY_SLAB, "Ruby Slab");
        builder.add(ModBlocks.SAPPHIRE_SLAB, "Sapphire Slab");

        builder.add(ModBlocks.CITRINE_BUTTON, "Citrine Button");
        builder.add(ModBlocks.ENDERITE_BUTTON, "Enderite Button");
        builder.add(ModBlocks.RUBY_BUTTON, "Ruby Button");
        builder.add(ModBlocks.SAPPHIRE_BUTTON, "Sapphire Button");

        builder.add(ModBlocks.CITRINE_PRESSURE_PLATE, "Citrine Pressure Plate");
        builder.add(ModBlocks.ENDERITE_PRESSURE_PLATE, "Enderite Pressure Plate");
        builder.add(ModBlocks.RUBY_PRESSURE_PLATE, "Ruby Pressure Plate");
        builder.add(ModBlocks.SAPPHIRE_PRESSURE_PLATE, "Sapphire Pressure Plate");

        builder.add(ModBlocks.CITRINE_FENCE, "Citrine Fence");
        builder.add(ModBlocks.ENDERITE_FENCE, "Enderite Fence");
        builder.add(ModBlocks.RUBY_FENCE, "Ruby Fence");
        builder.add(ModBlocks.SAPPHIRE_FENCE, "Sapphire Fence");

        builder.add(ModBlocks.CITRINE_FENCE_GATE, "Citrine Fence Gate");
        builder.add(ModBlocks.ENDERITE_FENCE_GATE, "Enderite Fence Gate");
        builder.add(ModBlocks.RUBY_FENCE_GATE, "Ruby Fence Gate");
        builder.add(ModBlocks.SAPPHIRE_FENCE_GATE, "Sapphire Fence Gate");

        builder.add(ModBlocks.CITRINE_WALL, "Citrine Wall");
        builder.add(ModBlocks.ENDERITE_WALL, "Enderite Wall");
        builder.add(ModBlocks.RUBY_WALL, "Ruby Wall");
        builder.add(ModBlocks.SAPPHIRE_WALL, "Sapphire Wall");

        builder.add(ModBlocks.CITRINE_DOOR, "Citrine Door");
        builder.add(ModBlocks.ENDERITE_DOOR, "Enderite Door");
        builder.add(ModBlocks.RUBY_DOOR, "Ruby Door");
        builder.add(ModBlocks.SAPPHIRE_DOOR, "Sapphire Door");

        builder.add(ModBlocks.CITRINE_TRAP_DOOR, "Citrine Trap Door");
        builder.add(ModBlocks.ENDERITE_TRAP_DOOR, "Enderite Trap Door");
        builder.add(ModBlocks.RUBY_TRAP_DOOR, "Ruby Trap Door");
        builder.add(ModBlocks.SAPPHIRE_TRAP_DOOR, "Sapphire Trap Door");
        //endregion
        //region REFERENCE
        builder.add(REFERENCE.GEM_BLOCKS, "Gem Blocks");
        builder.add(REFERENCE.CITRINE_BLOCKS, "Citrine Blocks");
        builder.add(REFERENCE.RUBY_BLOCKS, "Ruby Blocks");
        builder.add(REFERENCE.SAPPHIRE_BLOCKS, "Sapphire Blocks");
        builder.add(REFERENCE.IS_MACHINE, "Is Machine");
        builder.add(REFERENCE.HAMMER_BLACKLIST, "Hammer Blacklist");
        builder.add(REFERENCE.EXCAVATOR_BLACKLIST, "Excavator Blacklist");
        builder.add(REFERENCE.INCORRECT_FOR_ENDERITE_TOOL, "Incorrect For Enderite Tool");
        builder.add(REFERENCE.GOO_BLACKLIST, "Goo Blacklist");
        builder.add(REFERENCE.FLUID_TANKS, "Fluid Tanks");

        builder.add(REFERENCE.FLUID_BUCKET, "Fluid Buckets");
        builder.add(REFERENCE.CAST, "Casts");
        builder.add(REFERENCE.RAW, "Raws");
        builder.add(REFERENCE.WOOD_CAST, "Wood Casts");
        builder.add(REFERENCE.GEAR, "Gears");
        builder.add(REFERENCE.DUST, "Dusts");
        builder.add(REFERENCE.INGOT, "Ingots");
        builder.add(REFERENCE.PLATE, "Plates");
        builder.add(REFERENCE.REINFORCED, "Reinforced Plates");
        builder.add(REFERENCE.ROD, "Rods");
        builder.add(REFERENCE.TOOL_HEAD, "Tool Heads");
        builder.add(REFERENCE.ALLOY, "Alloys");
        builder.add(REFERENCE.GEM, "Gems");
        builder.add(REFERENCE.HAMMERS, "Hammers");
        builder.add(REFERENCE.EXCAVATORS, "Excavators");
        builder.add(REFERENCE.MENDING_ONLY, "Mending Only");
        builder.add(REFERENCE.SMELTABLE, "Smeltables");
        builder.add(REFERENCE.REPAIRS_AMETHYST_ARMOR, "Amethyst Armor Repair Material");
        builder.add(REFERENCE.REPAIRS_CITRINE_ARMOR, "Citrine Armor Repair Material");
        builder.add(REFERENCE.REPAIRS_COPPER_ARMOR, "Copper Armor Repair Material");
        builder.add(REFERENCE.REPAIRS_RUBY_ARMOR, "Ruby Armor Repair Material");
        builder.add(REFERENCE.REPAIRS_SAPPHIRE_ARMOR, "Sapphire Armor Repair Material");
        builder.add(REFERENCE.REPAIRS_CITRINE_TOOL, "Citrine Tool Repair Material");
        builder.add(REFERENCE.REPAIRS_COPPER_TOOL, "Copper Tool Repair Material");
        builder.add(REFERENCE.REPAIRS_ENDERITE_TOOL, "Enderite Tool Repair Material");
        builder.add(REFERENCE.REPAIRS_RUBY_TOOL, "Ruby Tool Repair Material");
        builder.add(REFERENCE.REPAIRS_SAPPHIRE_TOOL, "Sapphire Tool Repair Material");
        builder.add(REFERENCE.REPAIRS_EMERALD_ARMOR, "Emerald Armor Repair Material");
        builder.add(REFERENCE.REPAIRS_ENDERITE_ARMOR, "Enderite Armor Repair Material");

        builder.add(REFERENCE.AMETHYST_ARMOR_TYPE, "Amethyst Armors");
        builder.add(REFERENCE.CITRINE_ARMOR_TYPE, "Citrine Armors");
        builder.add(REFERENCE.COPPER_ARMOR_TYPE, "Copper Armors");
        builder.add(REFERENCE.EMERALD_ARMOR_TYPE, "Emerald Armors");
        builder.add(REFERENCE.ENDERITE_ARMOR_TYPE, "Enderite Armors");
        builder.add(REFERENCE.RUBY_ARMOR_TYPE, "Ruby Armors");
        builder.add(REFERENCE.SAPPHIRE_ARMOR_TYPE, "Sapphire Armors");

        builder.add(REFERENCE.TUNER_BLACKLIST, "Tuner Blacklist");
        builder.add(REFERENCE.RUBY_SWORD_WHITELIST, "Ruby Sword Whitelist");

        builder.add(REFERENCE.identifier(REFERENCE.TUNER_TOOLTIP_ID_NAME), "Bound to position : (%d %d %d) - %d");
        builder.add(REFERENCE.identifier(REFERENCE.TELEPORTER_TOOLTIP_ID_NAME), "Bound to position : (%d %d %d) - %d");
        builder.add(REFERENCE.identifier(REFERENCE.TUNER_TELEPORTED_ID_NAME), "Teleported to : (%d %d %d) - %d");
        builder.add(REFERENCE.identifier(REFERENCE.TUNER_ERROR_ID_NAME), "Wrong dimension, your tuner bound to %d");
        builder.add(REFERENCE.identifier(REFERENCE.HAMMER_PARAM_TOOLTIP), "Size : %d * %d * %d");
        builder.add(REFERENCE.identifier(REFERENCE.EXCAVATOR_PARAM_TOOLTIP), "Size : %d * %d * %d");
        //endregion
        //region COMMANDS
        builder.add(REFERENCE.DCLR_BLOCK_WHITELIST, "DCLR Block Whitelist");
        builder.add(REFERENCE.DCLR_ORE_WHITELIST, "DCLR Ore Whitelist");
        builder.add(REFERENCE.DCLR_FLUID_WHITELIST, "DCLR Fluid Whitelist");

        builder.add(REFERENCE.identifier(REFERENCE.DCLR_ERROR_ID_NAME), "Wrong Type, it should be one of the choices: ore, block, fluid, all");
        builder.add(REFERENCE.identifier(REFERENCE.DCLR_START_ID_NAME), "Starting to Clean");
        builder.add(REFERENCE.identifier(REFERENCE.DCLR_END_ID_NAME), "Finished Cleaning");
        //endregion

        builder.add("effect." + ModID + ".flight", "Flight");
        builder.add(ModID + ".goo.category", "GOO");
        builder.add("gamerule.goo.spread", "Should Goo Spread");
        builder.add("gamerule.lava.pump.goo.active", "Should Lava Pump Goo Work");
        builder.add("gamerule.water.pump.goo.active", "Should Water Pump Goo Work");

        builder.add(ModID + ".container.gem.cleaner", "Gem Cleaner");

        //region FLUID TANKS
        builder.add(ModBlocks.FLUID_TANK_COPPER, "Copper Fluid Tank");
        builder.add(ModBlocks.FLUID_TANK_DIAMOND, "Diamond Fluid Tank");
        builder.add(ModBlocks.FLUID_TANK_EMERALD, "Emerald Fluid Tank");
        builder.add(ModBlocks.FLUID_TANK_ENDERITE, "Enderite Fluid Tank");
        builder.add(ModBlocks.FLUID_TANK_GOLD, "Gold Fluid Tank");
        builder.add(ModBlocks.FLUID_TANK_IRON, " Iron Fluid Tank");
        builder.add(ModBlocks.FLUID_TANK_NETHERITE, "Netherite Fluid Tank");
        builder.add(ModBlocks.FLUID_TANK_OBSIDIAN, "Obsidian Fluid Tank");
        builder.add(ModBlocks.FLUID_TANK_STAR, "Nether star Fluid Tank");
        builder.add(ModBlocks.FLUID_TANK_STONE, "Stone Fluid Tank");
        builder.add(ModBlocks.FLUID_TANK_WOOD, "Wooden Fluid Tank");
        //endregion

        //region TITLES
        addText(builder, REFERENCE.BLOCKS_TITLE, "Blocks");
        addText(builder, REFERENCE.INGREDIENT_TITLE, "Ingredients");
        addText(builder, REFERENCE.MACHINES_TITLE, "Machines");
        addText(builder, REFERENCE.TOOLS_TITLE, "Tools");
        addText(builder, REFERENCE.ARMORS_TITLE, "Armors");
        addText(builder, REFERENCE.MISC_TITLE, "Misc");
        addText(builder, REFERENCE.DECORATIONS_TITLE, "Decoration");
        addText(builder, REFERENCE.STORAGE_TITLE, "Storage");
        //endregion
    }

    private static void addText(@NotNull TranslationBuilder builder, @NotNull MutableText text, @NotNull String value)
    {
        builder.add(((TranslatableTextContent) text.getContent()).getKey(), value);
    }
}