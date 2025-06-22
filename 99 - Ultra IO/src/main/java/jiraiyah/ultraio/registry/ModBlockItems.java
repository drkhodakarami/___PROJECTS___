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

package jiraiyah.ultraio.registry;

import jiraiyah.jibase.exceptions.Exceptions;
import jiraiyah.ultraio.blockitem.AngelBlockItem;
import net.minecraft.item.BlockItem;

import static jiraiyah.ultraio.Main.LOGGER;
import static jiraiyah.ultraio.Main.JBLOCK_ITEM;

public class ModBlockItems
{
    public static BlockItem
            ELEVATOR, ANGEL, ENDERITE, CARROT_BOX, POTATO_BOX,
            CITRINE, RUBY, SAPPHIRE, RAW_CITRINE,
            RAW_ENDERITE, RAW_QUARTZ, RAW_RUBY, RAW_SAPPHIRE,
            ORE_DEEP_CITRINE, ORE_DEEP_RUBY, ORE_DEEP_SAPPHIRE,
            ORE_END_CITRINE, ORE_END_ENDERITE, ORE_END_ENDERITE_CRACKED, ORE_END_RUBY, ORE_END_SAPPHIRE,
            ORE_NETHER_CITRINE, ORE_NETHER_RUBY, ORE_NETHER_SAPPHIRE, ORE_NETHER_COAL, ORE_NETHER_COPPER, ORE_NETHER_DIAMOND,
            ORE_NETHER_IRON, ORE_NETHER_LAPIS, ORE_NETHER_REDSTONE,
            ORE_WORLD_CITRINE, ORE_WORLD_RUBY, ORE_WORLD_SAPPHIRE,
            ORE_ENDERITE,
            CITRINE_STAIRS, ENDERITE_STAIRS, RUBY_STAIRS, SAPPHIRE_STAIRS,
            CITRINE_SLAB, ENDERITE_SLAB, RUBY_SLAB, SAPPHIRE_SLAB,
            CITRINE_BUTTON, ENDERITE_BUTTON, RUBY_BUTTON, SAPPHIRE_BUTTON,
            CITRINE_PRESSURE_PLATE, ENDERITE_PRESSURE_PLATE, RUBY_PRESSURE_PLATE, SAPPHIRE_PRESSURE_PLATE,
            CITRINE_FENCE, ENDERITE_FENCE, RUBY_FENCE, SAPPHIRE_FENCE,
            CITRINE_FENCE_GATE, ENDERITE_FENCE_GATE, RUBY_FENCE_GATE, SAPPHIRE_FENCE_GATE,
            CITRINE_WALL, ENDERITE_WALL, RUBY_WALL, SAPPHIRE_WALL,
            CITRINE_DOOR, ENDERITE_DOOR, RUBY_DOOR, SAPPHIRE_DOOR,
            CITRINE_TRAP_DOOR, ENDERITE_TRAP_DOOR, RUBY_TRAP_DOOR, SAPPHIRE_TRAP_DOOR,
            WATER_EATING_GOO, WATER_GENERATING_GOO, LAVA_EATING_GOO, LAVA_GENERATING_GOO, CHUNK_GOO, TOWERING_GOO,
            TUNNELING_GOO, BRIDGE_GOO, AIR_BOMB_GOO, CHUNK_BOMB_GOO, STONE_BOMB_GOO,
            REDSTONE_CLOCK, ALLOY_MIXER, CAST_PRESS, GEM_CLEANER, OVEN, PULVERIZER, SMELTER, ANIMAL_FEED,
            GENERATOR, BLOCK_BREAKER, BLOCK_PLACER, BUILDER, CHUNK_LOADER, ENDER_CHANTER, FLUID_PUMP,
            PRINTER, PROJECT_TABLE, TESSERACT, WOOD_STRIPPER, SOLAR_PANEL, MINER,
            CREATIVE_BANK, BATTERY_BANK;//,
            //LAVA_PUMP_GOO, WATER_PUMP_GOO;

    public ModBlockItems()
    {
        Exceptions.throwCtorAssertion();
    }

    public static void init()
    {
        LOGGER.logBlockItemInit();

        ANGEL = JBLOCK_ITEM.register(ModBlocks.ANGEL, AngelBlockItem::new);
        ELEVATOR = JBLOCK_ITEM.register(ModBlocks.ELEVATOR);

        CARROT_BOX = JBLOCK_ITEM.register(ModBlocks.CARROT_BOX);
        POTATO_BOX = JBLOCK_ITEM.register(ModBlocks.POTATO_BOX);

        //region GEM
        ENDERITE = JBLOCK_ITEM.register(ModBlocks.ENDERITE);
        CITRINE = JBLOCK_ITEM.register(ModBlocks.CITRINE);
        RUBY = JBLOCK_ITEM.register(ModBlocks.RUBY);
        SAPPHIRE = JBLOCK_ITEM.register(ModBlocks.SAPPHIRE);
        //endregion
        
        //region RAW
        RAW_CITRINE = JBLOCK_ITEM.register(ModBlocks.RAW_CITRINE);
        RAW_ENDERITE = JBLOCK_ITEM.register(ModBlocks.RAW_ENDERITE);
        RAW_QUARTZ = JBLOCK_ITEM.register(ModBlocks.RAW_QUARTZ);
        RAW_RUBY = JBLOCK_ITEM.register(ModBlocks.RAW_RUBY);
        RAW_SAPPHIRE = JBLOCK_ITEM.register(ModBlocks.RAW_SAPPHIRE);
        //endregion

        //region ORE
        ORE_DEEP_CITRINE = JBLOCK_ITEM.register(ModBlocks.ORE_DEEP_CITRINE);
        ORE_DEEP_RUBY = JBLOCK_ITEM.register(ModBlocks.ORE_DEEP_RUBY);
        ORE_DEEP_SAPPHIRE = JBLOCK_ITEM.register(ModBlocks.ORE_DEEP_SAPPHIRE);
        ORE_END_CITRINE = JBLOCK_ITEM.register(ModBlocks.ORE_END_CITRINE);
        ORE_END_ENDERITE_CRACKED = JBLOCK_ITEM.register(ModBlocks.ORE_END_ENDERITE_CRACKED);
        ORE_END_RUBY = JBLOCK_ITEM.register(ModBlocks.ORE_END_RUBY);
        ORE_END_SAPPHIRE = JBLOCK_ITEM.register(ModBlocks.ORE_END_SAPPHIRE);
        ORE_END_ENDERITE = JBLOCK_ITEM.register(ModBlocks.ORE_END_ENDERITE);
        ORE_NETHER_CITRINE = JBLOCK_ITEM.register(ModBlocks.ORE_NETHER_CITRINE);
        ORE_NETHER_RUBY = JBLOCK_ITEM.register(ModBlocks.ORE_NETHER_RUBY);
        ORE_NETHER_SAPPHIRE = JBLOCK_ITEM.register(ModBlocks.ORE_NETHER_SAPPHIRE);
        ORE_NETHER_COAL = JBLOCK_ITEM.register(ModBlocks.ORE_NETHER_COAL);
        ORE_NETHER_COPPER = JBLOCK_ITEM.register(ModBlocks.ORE_NETHER_COPPER);
        ORE_NETHER_DIAMOND = JBLOCK_ITEM.register(ModBlocks.ORE_NETHER_DIAMOND);
        ORE_NETHER_IRON = JBLOCK_ITEM.register(ModBlocks.ORE_NETHER_IRON);
        ORE_NETHER_LAPIS = JBLOCK_ITEM.register(ModBlocks.ORE_NETHER_LAPIS);
        ORE_NETHER_REDSTONE = JBLOCK_ITEM.register(ModBlocks.ORE_NETHER_REDSTONE);
        ORE_WORLD_CITRINE = JBLOCK_ITEM.register(ModBlocks.ORE_WORLD_CITRINE);
        ORE_WORLD_RUBY = JBLOCK_ITEM.register(ModBlocks.ORE_WORLD_RUBY);
        ORE_WORLD_SAPPHIRE = JBLOCK_ITEM.register(ModBlocks.ORE_WORLD_SAPPHIRE);
        ORE_ENDERITE = JBLOCK_ITEM.register(ModBlocks.ORE_ENDERITE);
        //endregion

        //region DECORATION
        CITRINE_STAIRS = JBLOCK_ITEM.register(ModBlocks.CITRINE_STAIRS);
        ENDERITE_STAIRS = JBLOCK_ITEM.register(ModBlocks.ENDERITE_STAIRS);
        RUBY_STAIRS = JBLOCK_ITEM.register(ModBlocks.RUBY_STAIRS);
        SAPPHIRE_STAIRS = JBLOCK_ITEM.register(ModBlocks.SAPPHIRE_STAIRS);
        CITRINE_SLAB = JBLOCK_ITEM.register(ModBlocks.CITRINE_SLAB);
        ENDERITE_SLAB = JBLOCK_ITEM.register(ModBlocks.ENDERITE_SLAB);
        RUBY_SLAB = JBLOCK_ITEM.register(ModBlocks.RUBY_SLAB);
        SAPPHIRE_SLAB = JBLOCK_ITEM.register(ModBlocks.SAPPHIRE_SLAB);
        CITRINE_BUTTON = JBLOCK_ITEM.register(ModBlocks.CITRINE_BUTTON);
        ENDERITE_BUTTON = JBLOCK_ITEM.register(ModBlocks.ENDERITE_BUTTON);
        RUBY_BUTTON = JBLOCK_ITEM.register(ModBlocks.RUBY_BUTTON);
        SAPPHIRE_BUTTON = JBLOCK_ITEM.register(ModBlocks.SAPPHIRE_BUTTON);
        CITRINE_PRESSURE_PLATE = JBLOCK_ITEM.register(ModBlocks.CITRINE_PRESSURE_PLATE);
        ENDERITE_PRESSURE_PLATE = JBLOCK_ITEM.register(ModBlocks.ENDERITE_PRESSURE_PLATE);
        RUBY_PRESSURE_PLATE = JBLOCK_ITEM.register(ModBlocks.RUBY_PRESSURE_PLATE);
        SAPPHIRE_PRESSURE_PLATE = JBLOCK_ITEM.register(ModBlocks.SAPPHIRE_PRESSURE_PLATE);
        CITRINE_FENCE = JBLOCK_ITEM.register(ModBlocks.CITRINE_FENCE);
        ENDERITE_FENCE = JBLOCK_ITEM.register(ModBlocks.ENDERITE_FENCE);
        RUBY_FENCE = JBLOCK_ITEM.register(ModBlocks.RUBY_FENCE);
        SAPPHIRE_FENCE = JBLOCK_ITEM.register(ModBlocks.SAPPHIRE_FENCE);
        CITRINE_FENCE_GATE = JBLOCK_ITEM.register(ModBlocks.CITRINE_FENCE_GATE);
        ENDERITE_FENCE_GATE = JBLOCK_ITEM.register(ModBlocks.ENDERITE_FENCE_GATE);
        RUBY_FENCE_GATE = JBLOCK_ITEM.register(ModBlocks.RUBY_FENCE_GATE);
        SAPPHIRE_FENCE_GATE = JBLOCK_ITEM.register(ModBlocks.SAPPHIRE_FENCE_GATE);
        CITRINE_WALL = JBLOCK_ITEM.register(ModBlocks.CITRINE_WALL);
        ENDERITE_WALL = JBLOCK_ITEM.register(ModBlocks.ENDERITE_WALL);
        RUBY_WALL = JBLOCK_ITEM.register(ModBlocks.RUBY_WALL);
        SAPPHIRE_WALL = JBLOCK_ITEM.register(ModBlocks.SAPPHIRE_WALL);
        CITRINE_DOOR = JBLOCK_ITEM.register(ModBlocks.CITRINE_DOOR);
        ENDERITE_DOOR = JBLOCK_ITEM.register(ModBlocks.ENDERITE_DOOR);
        RUBY_DOOR = JBLOCK_ITEM.register(ModBlocks.RUBY_DOOR);
        SAPPHIRE_DOOR = JBLOCK_ITEM.register(ModBlocks.SAPPHIRE_DOOR);
        CITRINE_TRAP_DOOR = JBLOCK_ITEM.register(ModBlocks.CITRINE_TRAP_DOOR);
        ENDERITE_TRAP_DOOR = JBLOCK_ITEM.register(ModBlocks.ENDERITE_TRAP_DOOR);
        RUBY_TRAP_DOOR = JBLOCK_ITEM.register(ModBlocks.RUBY_TRAP_DOOR);
        SAPPHIRE_TRAP_DOOR = JBLOCK_ITEM.register(ModBlocks.SAPPHIRE_TRAP_DOOR);
        //endregion

        //region GOO
        WATER_EATING_GOO = JBLOCK_ITEM.register(ModBlocks.WATER_EATING_GOO);
        WATER_GENERATING_GOO = JBLOCK_ITEM.register(ModBlocks.WATER_GENERATING_GOO);
        LAVA_EATING_GOO = JBLOCK_ITEM.register(ModBlocks.LAVA_EATING_GOO);
        LAVA_GENERATING_GOO = JBLOCK_ITEM.register(ModBlocks.LAVA_GENERATING_GOO);
        CHUNK_GOO = JBLOCK_ITEM.register(ModBlocks.CHUNK_GOO);
        TOWERING_GOO = JBLOCK_ITEM.register(ModBlocks.TOWERING_GOO);
        TUNNELING_GOO = JBLOCK_ITEM.register(ModBlocks.TUNNELING_GOO);
        BRIDGE_GOO = JBLOCK_ITEM.register(ModBlocks.BRIDGE_GOO);
        AIR_BOMB_GOO = JBLOCK_ITEM.register(ModBlocks.AIR_BOMB_GOO);
        CHUNK_BOMB_GOO = JBLOCK_ITEM.register(ModBlocks.CHUNK_BOMB_GOO);
        //LAVA_PUMP_GOO = JBLOCK_ITEM.register(ModBlocks.LAVA_PUMP_GOO);
        STONE_BOMB_GOO = JBLOCK_ITEM.register(ModBlocks.STONE_BOMB_GOO);
        //WATER_PUMP_GOO = JBLOCK_ITEM.register(ModBlocks.WATER_PUMP_GOO);
        //endregion

        //region MACHINE
        REDSTONE_CLOCK = JBLOCK_ITEM.register(ModBlocks.REDSTONE_CLOCK);
        ALLOY_MIXER = JBLOCK_ITEM.register(ModBlocks.ALLOY_MIXER);
        CAST_PRESS = JBLOCK_ITEM.register(ModBlocks.CAST_PRESS);
        GEM_CLEANER = JBLOCK_ITEM.register(ModBlocks.GEM_CLEANER);
        OVEN = JBLOCK_ITEM.register(ModBlocks.OVEN);
        PULVERIZER = JBLOCK_ITEM.register(ModBlocks.PULVERIZER);
        SMELTER = JBLOCK_ITEM.register(ModBlocks.SMELTER);
        ANIMAL_FEED = JBLOCK_ITEM.register(ModBlocks.ANIMAL_FEED);
        GENERATOR = JBLOCK_ITEM.register(ModBlocks.GENERATOR);
        BLOCK_BREAKER = JBLOCK_ITEM.register(ModBlocks.BLOCK_BREAKER);
        BLOCK_PLACER = JBLOCK_ITEM.register(ModBlocks.BLOCK_PLACER);
        BUILDER = JBLOCK_ITEM.register(ModBlocks.BUILDER);
        CHUNK_LOADER = JBLOCK_ITEM.register(ModBlocks.CHUNK_LOADER);
        ENDER_CHANTER = JBLOCK_ITEM.register(ModBlocks.ENDER_CHANTER);
        FLUID_PUMP = JBLOCK_ITEM.register(ModBlocks.FLUID_PUMP);
        PRINTER = JBLOCK_ITEM.register(ModBlocks.PRINTER);
        PROJECT_TABLE = JBLOCK_ITEM.register(ModBlocks.PROJECT_TABLE);
        TESSERACT = JBLOCK_ITEM.register(ModBlocks.TESSERACT);
        WOOD_STRIPPER = JBLOCK_ITEM.register(ModBlocks.WOOD_STRIPPER);
        SOLAR_PANEL = JBLOCK_ITEM.register(ModBlocks.SOLAR_PANEL);
        MINER = JBLOCK_ITEM.register(ModBlocks.MINER);
        //endregion

        CREATIVE_BANK = JBLOCK_ITEM.register(ModBlocks.CREATIVE_BANK);
        BATTERY_BANK = JBLOCK_ITEM.register(ModBlocks.BATTERY_BANK);
    }

    public static void setBlackList()
    {

    }
}