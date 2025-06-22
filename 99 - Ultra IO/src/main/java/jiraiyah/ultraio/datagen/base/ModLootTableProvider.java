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

import jiraiyah.jiregister.LootTableHelper;
import jiraiyah.jiregister.WorldGenHelper;
import jiraiyah.ultraio.Main;
import jiraiyah.ultraio.registry.ModBlocks;
import jiraiyah.ultraio.registry.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider
{
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup)
    {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate()
    {
        Main.LOGGER.logLootTableDatagen();

        //region GEMS
        addDrop(ModBlocks.CITRINE);
        addDrop(ModBlocks.ENDERITE);
        addDrop(ModBlocks.RUBY);
        addDrop(ModBlocks.SAPPHIRE);
        //endregion

        //region RAW
        addDrop(ModBlocks.RAW_CITRINE);
        addDrop(ModBlocks.RAW_ENDERITE);
        addDrop(ModBlocks.RAW_QUARTZ);
        addDrop(ModBlocks.RAW_RUBY);
        addDrop(ModBlocks.RAW_SAPPHIRE);
        //endregion

        //region ORE
        addDrop(ModBlocks.ORE_DEEP_CITRINE,
                LootTableHelper.addOreDrops(this, this.registries, ModBlocks.ORE_DEEP_CITRINE, ModItems.RAW_CITRINE, 2.0f, 3.0f));
        addDrop(ModBlocks.ORE_DEEP_RUBY,
                LootTableHelper.addOreDrops(this, this.registries, ModBlocks.ORE_DEEP_RUBY, ModItems.RAW_RUBY, 2.0f, 3.0f));
        addDrop(ModBlocks.ORE_DEEP_SAPPHIRE,
                LootTableHelper.addOreDrops(this, this.registries, ModBlocks.ORE_DEEP_SAPPHIRE, ModItems.RAW_SAPPHIRE, 2.0f, 3.0f));
        addDrop(ModBlocks.ORE_END_CITRINE,
                LootTableHelper.addOreDrops(this, this.registries, ModBlocks.ORE_END_CITRINE, ModItems.RAW_CITRINE));
        addDrop(ModBlocks.ORE_END_RUBY,
                LootTableHelper.addOreDrops(this, this.registries, ModBlocks.ORE_END_RUBY, ModItems.RAW_RUBY));
        addDrop(ModBlocks.ORE_END_SAPPHIRE,
                LootTableHelper.addOreDrops(this, this.registries, ModBlocks.ORE_END_SAPPHIRE, ModItems.RAW_SAPPHIRE));
        addDrop(ModBlocks.ORE_NETHER_CITRINE,
                LootTableHelper.addOreDrops(this, this.registries, ModBlocks.ORE_NETHER_CITRINE, ModItems.RAW_CITRINE, 2.0f, 4.0f));
        addDrop(ModBlocks.ORE_NETHER_COAL,
                LootTableHelper.addOreDrops(this, this.registries, ModBlocks.ORE_NETHER_COAL, Items.COAL, 2.0f, 6.0f));
        addDrop(ModBlocks.ORE_NETHER_COPPER,
                LootTableHelper.addOreDrops(this, this.registries, ModBlocks.ORE_NETHER_COPPER, Items.RAW_COPPER));
        addDrop(ModBlocks.ORE_NETHER_DIAMOND,
                LootTableHelper.addOreDrops(this, this.registries, ModBlocks.ORE_NETHER_DIAMOND, Items.DIAMOND, 1.0f, 1.0f));
        addDrop(ModBlocks.ORE_NETHER_IRON,
                LootTableHelper.addOreDrops(this, this.registries, ModBlocks.ORE_NETHER_IRON, Items.RAW_IRON));
        addDrop(ModBlocks.ORE_NETHER_LAPIS,
                LootTableHelper.addOreDrops(this, this.registries, ModBlocks.ORE_NETHER_LAPIS, Items.LAPIS_LAZULI, 2.0f, 4.0f));
        addDrop(ModBlocks.ORE_NETHER_REDSTONE,
                LootTableHelper.addOreDrops(this, this.registries, ModBlocks.ORE_NETHER_REDSTONE, Items.REDSTONE, 2.0f, 44.0f));
        addDrop(ModBlocks.ORE_NETHER_RUBY,
                LootTableHelper.addOreDrops(this, this.registries, ModBlocks.ORE_NETHER_RUBY, ModItems.RAW_RUBY, 2.0f, 4.0f));
        addDrop(ModBlocks.ORE_NETHER_SAPPHIRE,
                LootTableHelper.addOreDrops(this, this.registries, ModBlocks.ORE_NETHER_SAPPHIRE, ModItems.RAW_SAPPHIRE, 2.0f, 4.0f));
        addDrop(ModBlocks.ORE_WORLD_CITRINE,
                LootTableHelper.addOreDrops(this, this.registries, ModBlocks.ORE_WORLD_CITRINE, ModItems.RAW_CITRINE, 2.0f, 3.0f));
        addDrop(ModBlocks.ORE_WORLD_RUBY,
                LootTableHelper.addOreDrops(this, this.registries, ModBlocks.ORE_WORLD_RUBY, ModItems.RAW_RUBY, 2.0f, 3.0f));
        addDrop(ModBlocks.ORE_WORLD_SAPPHIRE,
                LootTableHelper.addOreDrops(this, this.registries, ModBlocks.ORE_WORLD_SAPPHIRE, ModItems.RAW_SAPPHIRE, 2.0f, 3.0f));
        addDrop(ModBlocks.ORE_ENDERITE,
                LootTableHelper.addOreDrops(this, this.registries, ModBlocks.ORE_ENDERITE, ModItems.RAW_ENDERITE, 1.0f, 2.0f));
        //endregion

        addDrop(ModBlocks.ORE_END_ENDERITE_CRACKED);
        addDrop(ModBlocks.CARROT_BOX);
        addDrop(ModBlocks.POTATO_BOX);
        addDrop(ModBlocks.ELEVATOR);

        //region DECORATION
        addDrop(ModBlocks.CITRINE_STAIRS);
        addDrop(ModBlocks.CITRINE_SLAB, slabDrops(ModBlocks.CITRINE_SLAB));
        addDrop(ModBlocks.CITRINE_BUTTON);
        addDrop(ModBlocks.CITRINE_PRESSURE_PLATE);
        addDrop(ModBlocks.CITRINE_FENCE);
        addDrop(ModBlocks.CITRINE_FENCE_GATE);
        addDrop(ModBlocks.CITRINE_WALL);
        addDrop(ModBlocks.CITRINE_DOOR, doorDrops(ModBlocks.CITRINE_DOOR));
        addDrop(ModBlocks.CITRINE_TRAP_DOOR);

        addDrop(ModBlocks.ENDERITE_STAIRS);
        addDrop(ModBlocks.ENDERITE_SLAB, slabDrops(ModBlocks.CITRINE_SLAB));
        addDrop(ModBlocks.ENDERITE_BUTTON);
        addDrop(ModBlocks.ENDERITE_PRESSURE_PLATE);
        addDrop(ModBlocks.ENDERITE_FENCE);
        addDrop(ModBlocks.ENDERITE_FENCE_GATE);
        addDrop(ModBlocks.ENDERITE_WALL);
        addDrop(ModBlocks.ENDERITE_DOOR, doorDrops(ModBlocks.CITRINE_DOOR));
        addDrop(ModBlocks.ENDERITE_TRAP_DOOR);

        addDrop(ModBlocks.RUBY_STAIRS);
        addDrop(ModBlocks.RUBY_SLAB, slabDrops(ModBlocks.CITRINE_SLAB));
        addDrop(ModBlocks.RUBY_BUTTON);
        addDrop(ModBlocks.RUBY_PRESSURE_PLATE);
        addDrop(ModBlocks.RUBY_FENCE);
        addDrop(ModBlocks.RUBY_FENCE_GATE);
        addDrop(ModBlocks.RUBY_WALL);
        addDrop(ModBlocks.RUBY_DOOR, doorDrops(ModBlocks.CITRINE_DOOR));
        addDrop(ModBlocks.RUBY_TRAP_DOOR);

        addDrop(ModBlocks.SAPPHIRE_STAIRS);
        addDrop(ModBlocks.SAPPHIRE_SLAB, slabDrops(ModBlocks.CITRINE_SLAB));
        addDrop(ModBlocks.SAPPHIRE_BUTTON);
        addDrop(ModBlocks.SAPPHIRE_PRESSURE_PLATE);
        addDrop(ModBlocks.SAPPHIRE_FENCE);
        addDrop(ModBlocks.SAPPHIRE_FENCE_GATE);
        addDrop(ModBlocks.SAPPHIRE_WALL);
        addDrop(ModBlocks.SAPPHIRE_DOOR, doorDrops(ModBlocks.CITRINE_DOOR));
        addDrop(ModBlocks.SAPPHIRE_TRAP_DOOR);
        //endregion
        //region GOO
        addDrop(ModBlocks.BRIDGE_GOO);
        addDrop(ModBlocks.CHUNK_GOO);
        addDrop(ModBlocks.LAVA_EATING_GOO);
        addDrop(ModBlocks.LAVA_GENERATING_GOO);
        //addDrop(ModBlocks.LAVA_PUMP_GOO);
        addDrop(ModBlocks.TOWERING_GOO);
        addDrop(ModBlocks.TUNNELING_GOO);
        addDrop(ModBlocks.WATER_GENERATING_GOO);
        //addDrop(ModBlocks.WATER_PUMP_GOO);
        //endregion
        //region MACHINE
        addDrop(ModBlocks.REDSTONE_CLOCK);
        addDrop(ModBlocks.ALLOY_MIXER);
        addDrop(ModBlocks.CAST_PRESS);
        addDrop(ModBlocks.GEM_CLEANER);
        addDrop(ModBlocks.OVEN);
        addDrop(ModBlocks.PULVERIZER);
        addDrop(ModBlocks.SMELTER);
        addDrop(ModBlocks.ANIMAL_FEED);
        addDrop(ModBlocks.GENERATOR);
        addDrop(ModBlocks.SOLAR_PANEL);
        addDrop(ModBlocks.BLOCK_BREAKER);
        addDrop(ModBlocks.BLOCK_PLACER);
        addDrop(ModBlocks.BUILDER);
        addDrop(ModBlocks.CHUNK_LOADER);
        addDrop(ModBlocks.ENDER_CHANTER);
        addDrop(ModBlocks.FLUID_PUMP);
        addDrop(ModBlocks.PRINTER);
        addDrop(ModBlocks.PROJECT_TABLE);
        addDrop(ModBlocks.TESSERACT);
        addDrop(ModBlocks.WOOD_STRIPPER);
        addDrop(ModBlocks.MINER);

        addDrop(ModBlocks.CREATIVE_BANK);
        addDrop(ModBlocks.BATTERY_BANK);
        //endregion
    }
}