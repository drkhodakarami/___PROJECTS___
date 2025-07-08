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
import jiraiyah.ultraio.registry.ModBlocks;
import jiraiyah.ultraio.registry.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

import static jiraiyah.ultraio.Main.REFERENCE;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider
{
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture)
    {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup)
    {
        Main.LOGGER.logItemTagDatagen();

        valueLookupBuilder(ItemTags.STONE_CRAFTING_MATERIALS);
        valueLookupBuilder(ItemTags.STONE_TOOL_MATERIALS);

        valueLookupBuilder(ItemTags.AXES)
                .add(ModItems.TOOL_CITRINE_AXE)
                .add(ModItems.TOOL_COPPER_AXE)
                .add(ModItems.TOOL_ENDERITE_AXE)
                .add(ModItems.TOOL_RUBY_AXE)
                .add(ModItems.TOOL_SAPPHIRE_AXE);

        valueLookupBuilder(ItemTags.HOES)
                .add(ModItems.TOOL_CITRINE_HOE)
                .add(ModItems.TOOL_COPPER_HOE)
                .add(ModItems.TOOL_ENDERITE_HOE)
                .add(ModItems.TOOL_RUBY_HOE)
                .add(ModItems.TOOL_SAPPHIRE_HOE);

        valueLookupBuilder(ItemTags.PICKAXES)
                .add(ModItems.TOOL_CITRINE_PICKAXE)
                .add(ModItems.TOOL_COPPER_PICKAXE)
                .add(ModItems.TOOL_ENDERITE_PICKAXE)
                .add(ModItems.TOOL_RUBY_PICKAXE)
                .add(ModItems.TOOL_SAPPHIRE_PICKAXE);

        valueLookupBuilder(ItemTags.SHOVELS)
                .add(ModItems.TOOL_CITRINE_SHOVEL)
                .add(ModItems.TOOL_COPPER_SHOVEL)
                .add(ModItems.TOOL_ENDERITE_SHOVEL)
                .add(ModItems.TOOL_RUBY_SHOVEL)
                .add(ModItems.TOOL_SAPPHIRE_SHOVEL);

        valueLookupBuilder(ItemTags.SWORDS)
                .add(ModItems.TOOL_CITRINE_SWORD)
                .add(ModItems.TOOL_COPPER_SWORD)
                .add(ModItems.TOOL_ENDERITE_SWORD)
                .add(ModItems.TOOL_RUBY_SWORD)
                .add(ModItems.TOOL_SAPPHIRE_SWORD);

        valueLookupBuilder(REFERENCE.HAMMERS)
                .add(ModItems.TOOL_CITRINE_HAMMER)
                .add(ModItems.TOOL_COPPER_HAMMER)
                .add(ModItems.TOOL_ENDERITE_HAMMER)
                .add(ModItems.TOOL_RUBY_HAMMER)
                .add(ModItems.TOOL_SAPPHIRE_HAMMER)
                .add(ModItems.TOOL_DIAMOND_HAMMER)
                .add(ModItems.TOOL_GOLD_HAMMER)
                .add(ModItems.TOOL_IRON_HAMMER)
                .add(ModItems.TOOL_NETHERITE_HAMMER)
                .add(ModItems.TOOL_STONE_HAMMER)
                .add(ModItems.TOOL_WOOD_HAMMER);
        
        valueLookupBuilder(REFERENCE.EXCAVATORS)
                .add(ModItems.TOOL_CITRINE_EXCAVATOR)
                .add(ModItems.TOOL_COPPER_EXCAVATOR)
                .add(ModItems.TOOL_ENDERITE_EXCAVATOR)
                .add(ModItems.TOOL_RUBY_EXCAVATOR)
                .add(ModItems.TOOL_SAPPHIRE_EXCAVATOR)
                .add(ModItems.TOOL_DIAMOND_EXCAVATOR)
                .add(ModItems.TOOL_GOLD_EXCAVATOR)
                .add(ModItems.TOOL_IRON_EXCAVATOR)
                .add(ModItems.TOOL_NETHERITE_EXCAVATOR)
                .add(ModItems.TOOL_STONE_EXCAVATOR)
                .add(ModItems.TOOL_WOOD_EXCAVATOR);
        
        valueLookupBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.ARMOR_AMETHYST_BOOTS)
                .add(ModItems.ARMOR_AMETHYST_LEGGINGS)
                .add(ModItems.ARMOR_AMETHYST_CHESTPLATE)
                .add(ModItems.ARMOR_AMETHYST_HELMET)

                .add(ModItems.ARMOR_CITRINE_BOOTS)
                .add(ModItems.ARMOR_CITRINE_LEGGINGS)
                .add(ModItems.ARMOR_CITRINE_CHESTPLATE)
                .add(ModItems.ARMOR_CITRINE_HELMET)

                .add(ModItems.ARMOR_COPPER_BOOTS)
                .add(ModItems.ARMOR_COPPER_LEGGINGS)
                .add(ModItems.ARMOR_COPPER_CHESTPLATE)
                .add(ModItems.ARMOR_COPPER_HELMET)

                .add(ModItems.ARMOR_EMERALD_BOOTS)
                .add(ModItems.ARMOR_EMERALD_LEGGINGS)
                .add(ModItems.ARMOR_EMERALD_CHESTPLATE)
                .add(ModItems.ARMOR_EMERALD_HELMET)

                .add(ModItems.ARMOR_ENDERITE_BOOTS)
                .add(ModItems.ARMOR_ENDERITE_LEGGINGS)
                .add(ModItems.ARMOR_ENDERITE_CHESTPLATE)
                .add(ModItems.ARMOR_ENDERITE_HELMET)

                .add(ModItems.ARMOR_RUBY_BOOTS)
                .add(ModItems.ARMOR_RUBY_LEGGINGS)
                .add(ModItems.ARMOR_RUBY_CHESTPLATE)
                .add(ModItems.ARMOR_RUBY_HELMET)

                .add(ModItems.ARMOR_SAPPHIRE_BOOTS)
                .add(ModItems.ARMOR_SAPPHIRE_LEGGINGS)
                .add(ModItems.ARMOR_SAPPHIRE_CHESTPLATE)
                .add(ModItems.ARMOR_SAPPHIRE_HELMET);

        valueLookupBuilder(ItemTags.HEAD_ARMOR)
                .add(ModItems.ARMOR_AMETHYST_HELMET)
                .add(ModItems.ARMOR_CITRINE_HELMET)
                .add(ModItems.ARMOR_COPPER_HELMET)
                .add(ModItems.ARMOR_EMERALD_HELMET)
                .add(ModItems.ARMOR_ENDERITE_HELMET)
                .add(ModItems.ARMOR_RUBY_HELMET)
                .add(ModItems.ARMOR_SAPPHIRE_HELMET);

        valueLookupBuilder(ItemTags.CHEST_ARMOR)
                .add(ModItems.ARMOR_AMETHYST_CHESTPLATE)
                .add(ModItems.ARMOR_CITRINE_CHESTPLATE)
                .add(ModItems.ARMOR_COPPER_CHESTPLATE)
                .add(ModItems.ARMOR_EMERALD_CHESTPLATE)
                .add(ModItems.ARMOR_ENDERITE_CHESTPLATE)
                .add(ModItems.ARMOR_RUBY_CHESTPLATE)
                .add(ModItems.ARMOR_SAPPHIRE_CHESTPLATE);

        valueLookupBuilder(ItemTags.LEG_ARMOR)
                .add(ModItems.ARMOR_AMETHYST_LEGGINGS)
                .add(ModItems.ARMOR_CITRINE_LEGGINGS)
                .add(ModItems.ARMOR_COPPER_LEGGINGS)
                .add(ModItems.ARMOR_EMERALD_LEGGINGS)
                .add(ModItems.ARMOR_ENDERITE_LEGGINGS)
                .add(ModItems.ARMOR_RUBY_LEGGINGS)
                .add(ModItems.ARMOR_SAPPHIRE_LEGGINGS);

        valueLookupBuilder(ItemTags.FOOT_ARMOR)
                .add(ModItems.ARMOR_AMETHYST_BOOTS)
                .add(ModItems.ARMOR_CITRINE_BOOTS)
                .add(ModItems.ARMOR_COPPER_BOOTS)
                .add(ModItems.ARMOR_EMERALD_BOOTS)
                .add(ModItems.ARMOR_ENDERITE_BOOTS)
                .add(ModItems.ARMOR_RUBY_BOOTS)
                .add(ModItems.ARMOR_SAPPHIRE_BOOTS);
        
        valueLookupBuilder(REFERENCE.AMETHYST_ARMOR_TYPE)
                .add(ModItems.ARMOR_AMETHYST_HELMET)
                .add(ModItems.ARMOR_AMETHYST_CHESTPLATE)
                .add(ModItems.ARMOR_AMETHYST_LEGGINGS)
                .add(ModItems.ARMOR_AMETHYST_BOOTS);
        
        valueLookupBuilder(REFERENCE.CITRINE_ARMOR_TYPE)
                .add(ModItems.ARMOR_CITRINE_HELMET)
                .add(ModItems.ARMOR_CITRINE_CHESTPLATE)
                .add(ModItems.ARMOR_CITRINE_LEGGINGS)
                .add(ModItems.ARMOR_CITRINE_BOOTS);
        
        valueLookupBuilder(REFERENCE.COPPER_ARMOR_TYPE)
                .add(ModItems.ARMOR_COPPER_HELMET)
                .add(ModItems.ARMOR_COPPER_CHESTPLATE)
                .add(ModItems.ARMOR_COPPER_LEGGINGS)
                .add(ModItems.ARMOR_COPPER_BOOTS);
        
        valueLookupBuilder(REFERENCE.EMERALD_ARMOR_TYPE)
                .add(ModItems.ARMOR_EMERALD_HELMET)
                .add(ModItems.ARMOR_EMERALD_CHESTPLATE)
                .add(ModItems.ARMOR_EMERALD_LEGGINGS)
                .add(ModItems.ARMOR_EMERALD_BOOTS);
        
        valueLookupBuilder(REFERENCE.ENDERITE_ARMOR_TYPE)
                .add(ModItems.ARMOR_ENDERITE_HELMET)
                .add(ModItems.ARMOR_ENDERITE_CHESTPLATE)
                .add(ModItems.ARMOR_ENDERITE_LEGGINGS)
                .add(ModItems.ARMOR_ENDERITE_BOOTS);
        
        valueLookupBuilder(REFERENCE.RUBY_ARMOR_TYPE)
                .add(ModItems.ARMOR_RUBY_HELMET)
                .add(ModItems.ARMOR_RUBY_CHESTPLATE)
                .add(ModItems.ARMOR_RUBY_LEGGINGS)
                .add(ModItems.ARMOR_RUBY_BOOTS);
        
        valueLookupBuilder(REFERENCE.SAPPHIRE_ARMOR_TYPE)
                .add(ModItems.ARMOR_SAPPHIRE_HELMET)
                .add(ModItems.ARMOR_SAPPHIRE_CHESTPLATE)
                .add(ModItems.ARMOR_SAPPHIRE_LEGGINGS)
                .add(ModItems.ARMOR_SAPPHIRE_BOOTS);

        valueLookupBuilder(REFERENCE.REPAIRS_AMETHYST_ARMOR)
                .add(ModItems.REINFORCED_AMETHYST);
        valueLookupBuilder(REFERENCE.REPAIRS_CITRINE_ARMOR)
                .add(ModItems.REINFORCED_CITRINE);
        valueLookupBuilder(REFERENCE.REPAIRS_COPPER_ARMOR)
                .add(ModItems.REINFORCED_COPPER);
        valueLookupBuilder(REFERENCE.REPAIRS_EMERALD_ARMOR)
                .add(ModItems.REINFORCED_EMERALD);
        valueLookupBuilder(REFERENCE.REPAIRS_ENDERITE_ARMOR)
                .add(ModItems.REINFORCED_ENDERITE);
        valueLookupBuilder(REFERENCE.REPAIRS_RUBY_ARMOR)
                .add(ModItems.REINFORCED_RUBY);
        valueLookupBuilder(REFERENCE.REPAIRS_SAPPHIRE_ARMOR)
                .add(ModItems.REINFORCED_SAPPHIRE);
        valueLookupBuilder(REFERENCE.REPAIRS_CITRINE_TOOL)
                .add(ModItems.PLATE_CITRINE);
        valueLookupBuilder(REFERENCE.REPAIRS_COPPER_TOOL)
                .add(ModItems.PLATE_COPPER);
        valueLookupBuilder(REFERENCE.REPAIRS_ENDERITE_TOOL)
                .add(ModItems.PLATE_ENDERITE);
        valueLookupBuilder(REFERENCE.REPAIRS_RUBY_TOOL)
                .add(ModItems.PLATE_RUBY);
        valueLookupBuilder(REFERENCE.REPAIRS_SAPPHIRE_TOOL)
                .add(ModItems.PLATE_SAPPHIRE);

        valueLookupBuilder(REFERENCE.CITRINE_GEM)
                .add(ModItems.GEM_CITRINE);

        valueLookupBuilder(REFERENCE.RUBY_GEM)
                .add(ModItems.GEM_RUBY);

        valueLookupBuilder(REFERENCE.SAPPHIRE_GEM)
                .add(ModItems.GEM_SAPPHIRE);

        valueLookupBuilder(ItemTags.COPPER_ORES)
                .add(ModBlocks.ORE_NETHER_COPPER.asItem());

        valueLookupBuilder(ItemTags.REDSTONE_ORES)
                .add(ModBlocks.ORE_NETHER_REDSTONE.asItem());

        valueLookupBuilder(ItemTags.LAPIS_ORES)
                .add(ModBlocks.ORE_NETHER_LAPIS.asItem());

        valueLookupBuilder(ItemTags.IRON_ORES)
                .add(ModBlocks.ORE_NETHER_IRON.asItem());

        valueLookupBuilder(ItemTags.DIAMOND_ORES)
                .add(ModBlocks.ORE_NETHER_DIAMOND.asItem());

        valueLookupBuilder(ItemTags.COAL_ORES)
                .add(ModBlocks.ORE_NETHER_COAL.asItem());

        valueLookupBuilder(REFERENCE.CAST)
                .add(ModItems.CAST_AXE)
                .add(ModItems.CAST_BINDING)
                .add(ModItems.CAST_EXCAVATOR)
                .add(ModItems.CAST_GEAR)
                .add(ModItems.CAST_GEM)
                .add(ModItems.CAST_HAMMER)
                .add(ModItems.CAST_HANDLE)
                .add(ModItems.CAST_HOE)
                .add(ModItems.CAST_INGOT)
                .add(ModItems.CAST_NUGGET)
                .add(ModItems.CAST_PICKAXE)
                .add(ModItems.CAST_PLATE)
                .add(ModItems.CAST_ROD)
                .add(ModItems.CAST_SHOVEL)
                .add(ModItems.CAST_SWORD)
                .add(ModItems.CAST_WIRE);

        valueLookupBuilder(REFERENCE.RAW)
                .add(ModItems.RAW_CITRINE)
                .add(ModItems.RAW_ENDERITE)
                .add(ModItems.RAW_QUARTZ)
                .add(ModItems.RAW_RUBY)
                .add(ModItems.RAW_SAPPHIRE);

        valueLookupBuilder(REFERENCE.WOOD_CAST)
                .add(ModItems.CAST_WOOD_INGOT)
                .add(ModItems.CAST_WOOD_PICKAXE);

        valueLookupBuilder(REFERENCE.GEAR)
                .add(ModItems.GEAR_COPPER)
                .add(ModItems.GEAR_DIAMOND)
                .add(ModItems.GEAR_EMERALD)
                .add(ModItems.GEAR_ENDERITE)
                .add(ModItems.GEAR_ENERGIZED)
                .add(ModItems.GEAR_GOLD)
                .add(ModItems.GEAR_IRON)
                .add(ModItems.GEAR_LAPIS)
                .add(ModItems.GEAR_NETHERITE)
                .add(ModItems.GEAR_OBSIDIAN)
                .add(ModItems.GEAR_PRISMARINE)
                .add(ModItems.GEAR_QUARTZ)
                .add(ModItems.GEAR_RUBY)
                .add(ModItems.GEAR_SAPPHIRE)
                .add(ModItems.GEAR_SHULKER)
                .add(ModItems.GEAR_STONE)
                .add(ModItems.GEAR_VIBRANT)
                .add(ModItems.GEAR_WOOD);

        valueLookupBuilder(REFERENCE.GEM)
                .add(ModItems.GEM_CITRINE)
                .add(ModItems.GEM_RUBY)
                .add(ModItems.GEM_SAPPHIRE)
                .add(Items.DIAMOND)
                .add(Items.EMERALD);

        valueLookupBuilder(REFERENCE.DUST)
                .add(ModItems.CRUSHED_SHULKER)
                .add(ModItems.DUST_CONDUCTIVE)
                .add(ModItems.DUST_COPPER)
                .add(ModItems.DUST_ENDERITE)
                .add(ModItems.DUST_ENERGETIC)
                .add(ModItems.DUST_GOLD)
                .add(ModItems.DUST_IRON)
                .add(ModItems.DUST_OBSIDIAN)
                .add(ModItems.DUST_PULSATING)
                .add(ModItems.DUST_RED_ALLOY)
                .add(ModItems.DUST_SOUL)
                .add(ModItems.DUST_VIBRANT)
                .add(ModItems.DUST_WITHERING);

        valueLookupBuilder(REFERENCE.INGOT)
                .add(ModItems.INGOT_ALLOY_CONDUCTIVE)
                .add(ModItems.INGOT_ALLOY_ENERGETIC)
                .add(ModItems.INGOT_ALLOY_PULSATING)
                .add(ModItems.INGOT_ALLOY_RED)
                .add(ModItems.INGOT_ALLOY_VIBRANT)
                .add(ModItems.RAW_ALLOY_ENDERITE)
                .add(ModItems.INGOT_ALLOY_ENDERITE)
                .add(ModItems.INGOT_ENDERITE);

        valueLookupBuilder(REFERENCE.ALLOY)
                .add(ModItems.INGOT_ALLOY_CONDUCTIVE)
                .add(ModItems.INGOT_ALLOY_ENERGETIC)
                .add(ModItems.INGOT_ALLOY_PULSATING)
                .add(ModItems.INGOT_ALLOY_RED)
                .add(ModItems.INGOT_ALLOY_VIBRANT);

        valueLookupBuilder(REFERENCE.PLATE)
                .add(ModItems.PLATE_AMETHYST)
                .add(ModItems.PLATE_CITRINE)
                .add(ModItems.PLATE_COPPER)
                .add(ModItems.PLATE_DIAMOND)
                .add(ModItems.PLATE_EMERALD)
                .add(ModItems.PLATE_ENDERITE)
                .add(ModItems.PLATE_GOLD)
                .add(ModItems.PLATE_IRON)
                .add(ModItems.PLATE_NETHERITE)
                .add(ModItems.PLATE_RUBY)
                .add(ModItems.PLATE_SAPPHIRE)
                .add(ModItems.PLATE_SHULKER)
                .add(ModItems.PLATE_STONE);

        valueLookupBuilder(REFERENCE.REINFORCED)
                .add(ModItems.REINFORCED_AMETHYST)
                .add(ModItems.REINFORCED_CITRINE)
                .add(ModItems.REINFORCED_COPPER)
                .add(ModItems.REINFORCED_DIAMOND)
                .add(ModItems.REINFORCED_EMERALD)
                .add(ModItems.REINFORCED_ENDERITE)
                .add(ModItems.REINFORCED_GOLD)
                .add(ModItems.REINFORCED_IRON)
                .add(ModItems.REINFORCED_NETHERITE)
                .add(ModItems.REINFORCED_RUBY)
                .add(ModItems.REINFORCED_SAPPHIRE)
                .add(ModItems.REINFORCED_SHULKER);

        valueLookupBuilder(REFERENCE.ROD)
                .add(ModItems.ROD_COPPER)
                .add(ModItems.ROD_ENDERITE)
                .add(ModItems.ROD_GLOWSTONE)
                .add(ModItems.ROD_GOLD)
                .add(ModItems.ROD_IRON)
                .add(ModItems.ROD_OBSIDIAN)
                .add(ModItems.ROD_REDSTONE)
                .add(ModItems.ROD_SHULKER);

        valueLookupBuilder(REFERENCE.TOOL_HEAD)
                .add(ModItems.HEAD_CITRINE_AXE)
                .add(ModItems.HEAD_CITRINE_HAMMER)
                .add(ModItems.HEAD_CITRINE_HOE)
                .add(ModItems.HEAD_CITRINE_PICKAXE)
                .add(ModItems.HEAD_CITRINE_SHOVEL)
                .add(ModItems.HEAD_CITRINE_SWORD)
                .add(ModItems.HEAD_COPPER_AXE)
                .add(ModItems.HEAD_COPPER_HAMMER)
                .add(ModItems.HEAD_COPPER_HOE)
                .add(ModItems.HEAD_COPPER_PICKAXE)
                .add(ModItems.HEAD_COPPER_SHOVEL)
                .add(ModItems.HEAD_COPPER_SWORD)
                .add(ModItems.HEAD_DIAMOND_AXE)
                .add(ModItems.HEAD_DIAMOND_HAMMER)
                .add(ModItems.HEAD_DIAMOND_HOE)
                .add(ModItems.HEAD_DIAMOND_PICKAXE)
                .add(ModItems.HEAD_DIAMOND_SHOVEL)
                .add(ModItems.HEAD_DIAMOND_SWORD)
                .add(ModItems.HEAD_ENDERITE_AXE)
                .add(ModItems.HEAD_ENDERITE_HAMMER)
                .add(ModItems.HEAD_ENDERITE_HOE)
                .add(ModItems.HEAD_ENDERITE_PICKAXE)
                .add(ModItems.HEAD_ENDERITE_SHOVEL)
                .add(ModItems.HEAD_ENDERITE_SWORD)
                .add(ModItems.HEAD_GOLD_AXE)
                .add(ModItems.HEAD_GOLD_HAMMER)
                .add(ModItems.HEAD_GOLD_HOE)
                .add(ModItems.HEAD_GOLD_PICKAXE)
                .add(ModItems.HEAD_GOLD_SHOVEL)
                .add(ModItems.HEAD_GOLD_SWORD)
                .add(ModItems.HEAD_IRON_AXE)
                .add(ModItems.HEAD_IRON_HAMMER)
                .add(ModItems.HEAD_IRON_HOE)
                .add(ModItems.HEAD_IRON_PICKAXE)
                .add(ModItems.HEAD_IRON_SHOVEL)
                .add(ModItems.HEAD_IRON_SWORD)
                .add(ModItems.HEAD_NETHERITE_AXE)
                .add(ModItems.HEAD_NETHERITE_HAMMER)
                .add(ModItems.HEAD_NETHERITE_HOE)
                .add(ModItems.HEAD_NETHERITE_PICKAXE)
                .add(ModItems.HEAD_NETHERITE_SHOVEL)
                .add(ModItems.HEAD_NETHERITE_SWORD)
                .add(ModItems.HEAD_RUBY_AXE)
                .add(ModItems.HEAD_RUBY_HAMMER)
                .add(ModItems.HEAD_RUBY_HOE)
                .add(ModItems.HEAD_RUBY_PICKAXE)
                .add(ModItems.HEAD_RUBY_SHOVEL)
                .add(ModItems.HEAD_RUBY_SWORD)
                .add(ModItems.HEAD_SAPPHIRE_AXE)
                .add(ModItems.HEAD_SAPPHIRE_HAMMER)
                .add(ModItems.HEAD_SAPPHIRE_HOE)
                .add(ModItems.HEAD_SAPPHIRE_PICKAXE)
                .add(ModItems.HEAD_SAPPHIRE_SHOVEL)
                .add(ModItems.HEAD_SAPPHIRE_SWORD)
                .add(ModItems.HEAD_STONE_HAMMER)
                .add(ModItems.HEAD_WOOD_HAMMER);

        valueLookupBuilder(REFERENCE.SMELTABLE)
                .add(ModItems.GEM_CITRINE)
                .add(ModItems.GEM_RUBY)
                .add(ModItems.GEM_SAPPHIRE)
                .add(Items.DIAMOND)
                .add(Items.EMERALD)
                .add(Items.PRISMARINE_SHARD)
                .add(Items.AMETHYST_SHARD)
                .add(Items.COPPER_INGOT)
                .add(ModItems.INGOT_ALLOY_ENDERITE)
                .add(Items.GLOWSTONE)
                .add(Items.GOLD_INGOT)
                .add(Items.IRON_INGOT)
                .add(Items.LAPIS_LAZULI)
                .add(Items.NETHERITE_INGOT)
                .add(Items.OBSIDIAN)
                .add(Items.QUARTZ)
                .add(ModBlocks.ORE_NETHER_COAL.asItem())
                .add(ModBlocks.ORE_NETHER_IRON.asItem())
                .add(ModBlocks.ORE_NETHER_LAPIS.asItem())
                .add(ModBlocks.ORE_NETHER_REDSTONE.asItem())
                .add(ModBlocks.ORE_NETHER_COPPER.asItem())
                .add(ModBlocks.ORE_NETHER_DIAMOND.asItem())
                .add(Items.RAW_COPPER)
                .add(Items.RAW_IRON)
                .add(Items.RAW_GOLD);

        valueLookupBuilder(REFERENCE.FLUID_BUCKET)
                .add(Items.LAVA_BUCKET)
                .add(Items.WATER_BUCKET)
                .add(Items.MILK_BUCKET)
                .add(Items.BUCKET);

        valueLookupBuilder(REFERENCE.MENDING_ONLY)
                .add(ModItems.ARMOR_AMETHYST_HELMET)
                .add(ModItems.ARMOR_AMETHYST_CHESTPLATE)
                .add(ModItems.ARMOR_AMETHYST_LEGGINGS)
                .add(ModItems.ARMOR_AMETHYST_BOOTS)
                .add(ModItems.ARMOR_CITRINE_HELMET)
                .add(ModItems.ARMOR_CITRINE_CHESTPLATE)
                .add(ModItems.ARMOR_CITRINE_LEGGINGS)
                .add(ModItems.ARMOR_CITRINE_BOOTS)
                .add(ModItems.ARMOR_COPPER_HELMET)
                .add(ModItems.ARMOR_COPPER_CHESTPLATE)
                .add(ModItems.ARMOR_COPPER_LEGGINGS)
                .add(ModItems.ARMOR_COPPER_BOOTS)
                .add(ModItems.ARMOR_EMERALD_HELMET)
                .add(ModItems.ARMOR_EMERALD_CHESTPLATE)
                .add(ModItems.ARMOR_EMERALD_LEGGINGS)
                .add(ModItems.ARMOR_EMERALD_BOOTS)
                .add(ModItems.ARMOR_ENDERITE_HELMET)
                .add(ModItems.ARMOR_ENDERITE_CHESTPLATE)
                .add(ModItems.ARMOR_ENDERITE_LEGGINGS)
                .add(ModItems.ARMOR_ENDERITE_BOOTS)
                .add(ModItems.ARMOR_RUBY_HELMET)
                .add(ModItems.ARMOR_RUBY_CHESTPLATE)
                .add(ModItems.ARMOR_RUBY_LEGGINGS)
                .add(ModItems.ARMOR_RUBY_BOOTS)
                .add(ModItems.ARMOR_SAPPHIRE_HELMET)
                .add(ModItems.ARMOR_SAPPHIRE_CHESTPLATE)
                .add(ModItems.ARMOR_SAPPHIRE_LEGGINGS)
                .add(ModItems.ARMOR_SAPPHIRE_BOOTS)
                .add(ModItems.TOOL_CITRINE_AXE)
                .add(ModItems.TOOL_COPPER_AXE)
                .add(ModItems.TOOL_ENDERITE_AXE)
                .add(ModItems.TOOL_RUBY_AXE)
                .add(ModItems.TOOL_SAPPHIRE_AXE)
                .add(ModItems.TOOL_CITRINE_HOE)
                .add(ModItems.TOOL_COPPER_HOE)
                .add(ModItems.TOOL_ENDERITE_HOE)
                .add(ModItems.TOOL_RUBY_HOE)
                .add(ModItems.TOOL_SAPPHIRE_HOE)
                .add(ModItems.TOOL_CITRINE_HAMMER)
                .add(ModItems.TOOL_COPPER_HAMMER)
                .add(ModItems.TOOL_DIAMOND_HAMMER)
                .add(ModItems.TOOL_ENDERITE_HAMMER)
                .add(ModItems.TOOL_GOLD_HAMMER)
                .add(ModItems.TOOL_IRON_HAMMER)
                .add(ModItems.TOOL_NETHERITE_HAMMER)
                .add(ModItems.TOOL_RUBY_HAMMER)
                .add(ModItems.TOOL_SAPPHIRE_HAMMER)
                .add(ModItems.TOOL_STONE_HAMMER)
                .add(ModItems.TOOL_WOOD_HAMMER)
                .add(ModItems.TOOL_CITRINE_PICKAXE)
                .add(ModItems.TOOL_COPPER_PICKAXE)
                .add(ModItems.TOOL_ENDERITE_PICKAXE)
                .add(ModItems.TOOL_RUBY_PICKAXE)
                .add(ModItems.TOOL_SAPPHIRE_PICKAXE)
                .add(ModItems.TOOL_CITRINE_SHOVEL)
                .add(ModItems.TOOL_COPPER_SHOVEL)
                .add(ModItems.TOOL_ENDERITE_SHOVEL)
                .add(ModItems.TOOL_RUBY_SHOVEL)
                .add(ModItems.TOOL_SAPPHIRE_SHOVEL)
                .add(ModItems.TOOL_CITRINE_SWORD)
                .add(ModItems.TOOL_COPPER_SWORD)
                .add(ModItems.TOOL_ENDERITE_SWORD)
                .add(ModItems.TOOL_RUBY_SWORD)
                .add(ModItems.TOOL_SAPPHIRE_SWORD);

        valueLookupBuilder(ItemTags.DURABILITY_ENCHANTABLE)
                .add(ModItems.ARMOR_AMETHYST_HELMET)
                .add(ModItems.ARMOR_AMETHYST_CHESTPLATE)
                .add(ModItems.ARMOR_AMETHYST_LEGGINGS)
                .add(ModItems.ARMOR_AMETHYST_BOOTS)
                .add(ModItems.ARMOR_CITRINE_HELMET)
                .add(ModItems.ARMOR_CITRINE_CHESTPLATE)
                .add(ModItems.ARMOR_CITRINE_LEGGINGS)
                .add(ModItems.ARMOR_CITRINE_BOOTS)
                .add(ModItems.ARMOR_COPPER_HELMET)
                .add(ModItems.ARMOR_COPPER_CHESTPLATE)
                .add(ModItems.ARMOR_COPPER_LEGGINGS)
                .add(ModItems.ARMOR_COPPER_BOOTS)
                .add(ModItems.ARMOR_EMERALD_HELMET)
                .add(ModItems.ARMOR_EMERALD_CHESTPLATE)
                .add(ModItems.ARMOR_EMERALD_LEGGINGS)
                .add(ModItems.ARMOR_EMERALD_BOOTS)
                .add(ModItems.ARMOR_ENDERITE_HELMET)
                .add(ModItems.ARMOR_ENDERITE_CHESTPLATE)
                .add(ModItems.ARMOR_ENDERITE_LEGGINGS)
                .add(ModItems.ARMOR_ENDERITE_BOOTS)
                .add(ModItems.ARMOR_RUBY_HELMET)
                .add(ModItems.ARMOR_RUBY_CHESTPLATE)
                .add(ModItems.ARMOR_RUBY_LEGGINGS)
                .add(ModItems.ARMOR_RUBY_BOOTS)
                .add(ModItems.ARMOR_SAPPHIRE_HELMET)
                .add(ModItems.ARMOR_SAPPHIRE_CHESTPLATE)
                .add(ModItems.ARMOR_SAPPHIRE_LEGGINGS)
                .add(ModItems.ARMOR_SAPPHIRE_BOOTS)
                .add(ModItems.TOOL_CITRINE_AXE)
                .add(ModItems.TOOL_CITRINE_EXCAVATOR)
                .add(ModItems.TOOL_CITRINE_HAMMER)
                .add(ModItems.TOOL_CITRINE_HOE)
                .add(ModItems.TOOL_CITRINE_PICKAXE)
                .add(ModItems.TOOL_CITRINE_SHOVEL)
                .add(ModItems.TOOL_CITRINE_SWORD)
                .add(ModItems.TOOL_COPPER_AXE)
                .add(ModItems.TOOL_COPPER_EXCAVATOR)
                .add(ModItems.TOOL_COPPER_HAMMER)
                .add(ModItems.TOOL_COPPER_HOE)
                .add(ModItems.TOOL_COPPER_PICKAXE)
                .add(ModItems.TOOL_COPPER_SHOVEL)
                .add(ModItems.TOOL_COPPER_SWORD)
                .add(ModItems.TOOL_ENDERITE_AXE)
                .add(ModItems.TOOL_ENDERITE_EXCAVATOR)
                .add(ModItems.TOOL_ENDERITE_HAMMER)
                .add(ModItems.TOOL_ENDERITE_HOE)
                .add(ModItems.TOOL_ENDERITE_PICKAXE)
                .add(ModItems.TOOL_ENDERITE_SHOVEL)
                .add(ModItems.TOOL_ENDERITE_SWORD)
                .add(ModItems.TOOL_RUBY_AXE)
                .add(ModItems.TOOL_RUBY_EXCAVATOR)
                .add(ModItems.TOOL_RUBY_HAMMER)
                .add(ModItems.TOOL_RUBY_HOE)
                .add(ModItems.TOOL_RUBY_PICKAXE)
                .add(ModItems.TOOL_RUBY_SHOVEL)
                .add(ModItems.TOOL_RUBY_SWORD)
                .add(ModItems.TOOL_SAPPHIRE_AXE)
                .add(ModItems.TOOL_SAPPHIRE_EXCAVATOR)
                .add(ModItems.TOOL_SAPPHIRE_HAMMER)
                .add(ModItems.TOOL_SAPPHIRE_HOE)
                .add(ModItems.TOOL_SAPPHIRE_PICKAXE)
                .add(ModItems.TOOL_SAPPHIRE_SHOVEL)
                .add(ModItems.TOOL_SAPPHIRE_SWORD)
                .add(ModItems.TOOL_DIAMOND_EXCAVATOR)
                .add(ModItems.TOOL_DIAMOND_HAMMER)
                .add(ModItems.TOOL_GOLD_EXCAVATOR)
                .add(ModItems.TOOL_GOLD_HAMMER)
                .add(ModItems.TOOL_IRON_EXCAVATOR)
                .add(ModItems.TOOL_IRON_HAMMER)
                .add(ModItems.TOOL_NETHERITE_EXCAVATOR)
                .add(ModItems.TOOL_NETHERITE_HAMMER)
                .add(ModItems.TOOL_STONE_EXCAVATOR)
                .add(ModItems.TOOL_STONE_HAMMER)
                .add(ModItems.TOOL_WOOD_EXCAVATOR)
                .add(ModItems.TOOL_WOOD_HAMMER);

        valueLookupBuilder(ItemTags.MINING_LOOT_ENCHANTABLE)
                .add(ModItems.TOOL_CITRINE_EXCAVATOR)
                .add(ModItems.TOOL_CITRINE_HAMMER)
                .add(ModItems.TOOL_CITRINE_PICKAXE)
                .add(ModItems.TOOL_CITRINE_SHOVEL)
                .add(ModItems.TOOL_COPPER_EXCAVATOR)
                .add(ModItems.TOOL_COPPER_HAMMER)
                .add(ModItems.TOOL_COPPER_PICKAXE)
                .add(ModItems.TOOL_COPPER_SHOVEL)
                .add(ModItems.TOOL_ENDERITE_EXCAVATOR)
                .add(ModItems.TOOL_ENDERITE_HAMMER)
                .add(ModItems.TOOL_ENDERITE_PICKAXE)
                .add(ModItems.TOOL_ENDERITE_SHOVEL)
                .add(ModItems.TOOL_RUBY_EXCAVATOR)
                .add(ModItems.TOOL_RUBY_HAMMER)
                .add(ModItems.TOOL_RUBY_PICKAXE)
                .add(ModItems.TOOL_RUBY_SHOVEL)
                .add(ModItems.TOOL_SAPPHIRE_EXCAVATOR)
                .add(ModItems.TOOL_SAPPHIRE_HAMMER)
                .add(ModItems.TOOL_SAPPHIRE_PICKAXE)
                .add(ModItems.TOOL_SAPPHIRE_SHOVEL)
                .add(ModItems.TOOL_DIAMOND_EXCAVATOR)
                .add(ModItems.TOOL_DIAMOND_HAMMER)
                .add(ModItems.TOOL_GOLD_EXCAVATOR)
                .add(ModItems.TOOL_GOLD_HAMMER)
                .add(ModItems.TOOL_IRON_EXCAVATOR)
                .add(ModItems.TOOL_IRON_HAMMER)
                .add(ModItems.TOOL_NETHERITE_EXCAVATOR)
                .add(ModItems.TOOL_NETHERITE_HAMMER)
                .add(ModItems.TOOL_STONE_EXCAVATOR)
                .add(ModItems.TOOL_STONE_HAMMER)
                .add(ModItems.TOOL_WOOD_EXCAVATOR)
                .add(ModItems.TOOL_WOOD_HAMMER);
    }
}