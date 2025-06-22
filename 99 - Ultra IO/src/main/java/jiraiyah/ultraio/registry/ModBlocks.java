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
import jiraiyah.ultraio.block.AngelBlock;
import jiraiyah.ultraio.block.Elevator;
import jiraiyah.ultraio.block.OreEndEnderite;
import jiraiyah.ultraio.block.goo.*;
import jiraiyah.ultraio.block.machine.*;
import jiraiyah.ultraio.block.storage.BatteryBank;
import jiraiyah.ultraio.block.storage.CreativeEnergyBank;
import jiraiyah.ultraio.block.storage.EnderiteShulker;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.sound.BlockSoundGroup;

import java.util.ArrayList;
import java.util.List;

import static jiraiyah.ultraio.Main.LOGGER;
import static jiraiyah.ultraio.Main.JBLOCK;

public class ModBlocks
{
    public static final List<Block> BLACK_LIST = new ArrayList<>();

    public static Block
            ENDERITE, CARROT_BOX, POTATO_BOX, CITRINE, RUBY, SAPPHIRE, ORE_ENDERITE,
            RAW_CITRINE, RAW_ENDERITE, RAW_QUARTZ, RAW_RUBY, RAW_SAPPHIRE, ORE_DEEP_CITRINE, ORE_DEEP_RUBY, ORE_DEEP_SAPPHIRE,
            ORE_END_CITRINE, ORE_END_ENDERITE_CRACKED, ORE_END_RUBY, ORE_END_SAPPHIRE,
            ORE_NETHER_CITRINE, ORE_NETHER_RUBY, ORE_NETHER_SAPPHIRE, ORE_NETHER_COAL, ORE_NETHER_COPPER, ORE_NETHER_DIAMOND,
            ORE_NETHER_IRON, ORE_NETHER_LAPIS, ORE_NETHER_REDSTONE, ORE_WORLD_CITRINE, ORE_WORLD_RUBY, ORE_WORLD_SAPPHIRE;

    public static FenceBlock CITRINE_FENCE, ENDERITE_FENCE, RUBY_FENCE, SAPPHIRE_FENCE;
    public static StairsBlock CITRINE_STAIRS, ENDERITE_STAIRS, RUBY_STAIRS, SAPPHIRE_STAIRS;
    public static SlabBlock CITRINE_SLAB, ENDERITE_SLAB, RUBY_SLAB, SAPPHIRE_SLAB;
    public static ButtonBlock CITRINE_BUTTON, ENDERITE_BUTTON, RUBY_BUTTON, SAPPHIRE_BUTTON;
    public static PressurePlateBlock CITRINE_PRESSURE_PLATE, ENDERITE_PRESSURE_PLATE, RUBY_PRESSURE_PLATE, SAPPHIRE_PRESSURE_PLATE;
    public static FenceGateBlock CITRINE_FENCE_GATE, ENDERITE_FENCE_GATE, RUBY_FENCE_GATE, SAPPHIRE_FENCE_GATE;
    public static WallBlock CITRINE_WALL, ENDERITE_WALL, RUBY_WALL, SAPPHIRE_WALL;
    public static DoorBlock CITRINE_DOOR, ENDERITE_DOOR, RUBY_DOOR, SAPPHIRE_DOOR;
    public static TrapdoorBlock CITRINE_TRAP_DOOR, ENDERITE_TRAP_DOOR, RUBY_TRAP_DOOR, SAPPHIRE_TRAP_DOOR;

    public static OreEndEnderite ORE_END_ENDERITE;
    public static Elevator ELEVATOR;
    public static AngelBlock ANGEL;

    public static WaterEatingGoo WATER_EATING_GOO;
    public static WaterGeneratingGoo WATER_GENERATING_GOO;
    public static LavaEatingGoo LAVA_EATING_GOO;
    public static LavaGeneratingGoo LAVA_GENERATING_GOO;
    public static ChunkGoo CHUNK_GOO;
    public static ToweringGoo TOWERING_GOO;
    public static TunnelingGoo TUNNELING_GOO;
    public static BridgeGoo BRIDGE_GOO;
    //public static LavaPumpGoo LAVA_PUMP_GOO;
    //public static WaterPumpGoo WATER_PUMP_GOO;
    public static AirGooBomb AIR_BOMB_GOO;
    public static ChunkGooBomb CHUNK_BOMB_GOO;
    public static StoneGooBomb STONE_BOMB_GOO;

    public static RedstoneClock REDSTONE_CLOCK;
    public static AlloyMixer ALLOY_MIXER;
    public static CastPress CAST_PRESS;
    public static GemCleaner GEM_CLEANER;
    public static Oven OVEN;
    public static Pulverizer PULVERIZER;
    public static Smelter SMELTER;
    public static AnimalFeed ANIMAL_FEED;
    public static Generator GENERATOR;
    public static BlockBreaker BLOCK_BREAKER;
    public static BlockPlacer BLOCK_PLACER;
    public static BuilderBlock BUILDER;
    public static ChunkLoader CHUNK_LOADER;
    public static EnderChanter ENDER_CHANTER;
    public static FluidPump FLUID_PUMP;
    public static Printer PRINTER;
    public static ProjectTable PROJECT_TABLE;
    public static Tesseract TESSERACT;
    public static WoodStripper WOOD_STRIPPER;
    public static SolarPanel SOLAR_PANEL;
    public static Miner MINER;

    public static CreativeEnergyBank CREATIVE_BANK;
    public static BatteryBank BATTERY_BANK;
    public static EnderiteShulker ENDERITE_SHULKER;

    public ModBlocks()
    {
        Exceptions.throwCtorAssertion();
    }

    public static void init()
    {
        LOGGER.logBlockInit();

        ENDERITE = JBLOCK.register("block_enderite", Blocks.NETHERITE_BLOCK);

        CARROT_BOX = JBLOCK.register("carrot_box", Blocks.OAK_PLANKS);
        POTATO_BOX = JBLOCK.register("potato_box", Blocks.OAK_PLANKS);

        //region GEMS
        CITRINE = JBLOCK.register("block_citrine", Blocks.AMETHYST_BLOCK);
        RUBY = JBLOCK.register("block_ruby", Blocks.AMETHYST_BLOCK);
        SAPPHIRE = JBLOCK.register("block_sapphire", Blocks.AMETHYST_BLOCK);

        RAW_CITRINE = JBLOCK.register("block_raw_citrine", Blocks.STONE);
        RAW_ENDERITE = JBLOCK.register("block_raw_enderite", Blocks.STONE);
        RAW_QUARTZ = JBLOCK.register("block_raw_quartz", Blocks.STONE);
        RAW_RUBY = JBLOCK.register("block_raw_ruby", Blocks.STONE);
        RAW_SAPPHIRE = JBLOCK.register("block_raw_sapphire", Blocks.STONE);
        //endregion
        //region ORE
        ORE_DEEP_CITRINE = JBLOCK.register("ore_deep_citrine", Blocks.DEEPSLATE_IRON_ORE);
        ORE_DEEP_RUBY = JBLOCK.register("ore_deep_ruby", Blocks.DEEPSLATE_DIAMOND_ORE);
        ORE_DEEP_SAPPHIRE = JBLOCK.register("ore_deep_sapphire", Blocks.DEEPSLATE_DIAMOND_ORE);

        ORE_END_CITRINE = JBLOCK.register("ore_end_citrine", Blocks.END_STONE);
        ORE_END_ENDERITE = JBLOCK.register("ore_end_enderite", OreEndEnderite::new);
        ORE_END_ENDERITE_CRACKED = JBLOCK.register("ore_end_enderite_cracked", Blocks.END_STONE);
        ORE_END_RUBY = JBLOCK.register("ore_end_ruby", Blocks.END_STONE);
        ORE_END_SAPPHIRE = JBLOCK.register("ore_end_sapphire", Blocks.END_STONE);

        ORE_NETHER_CITRINE = JBLOCK.register("ore_nether_citrine", Blocks.NETHER_GOLD_ORE);
        ORE_NETHER_RUBY = JBLOCK.register("ore_nether_ruby", Blocks.NETHER_GOLD_ORE);
        ORE_NETHER_SAPPHIRE = JBLOCK.register("ore_nether_sapphire", Blocks.NETHER_GOLD_ORE);
        ORE_NETHER_COAL = JBLOCK.register("ore_nether_coal", Blocks.NETHER_QUARTZ_ORE);
        ORE_NETHER_COPPER = JBLOCK.register("ore_nether_copper", Blocks.NETHER_GOLD_ORE);
        ORE_NETHER_DIAMOND = JBLOCK.register("ore_nether_diamond", Blocks.NETHER_QUARTZ_ORE);
        ORE_NETHER_IRON = JBLOCK.register("ore_nether_iron", Blocks.NETHER_QUARTZ_ORE);
        ORE_NETHER_LAPIS = JBLOCK.register("ore_nether_lapis", Blocks.NETHER_GOLD_ORE);
        ORE_NETHER_REDSTONE = JBLOCK.register("ore_nether_redstone", Blocks.NETHER_GOLD_ORE);

        ORE_WORLD_CITRINE = JBLOCK.register("ore_world_citrine", Blocks.IRON_ORE);
        ORE_WORLD_RUBY = JBLOCK.register("ore_world_ruby", Blocks.IRON_ORE);
        ORE_WORLD_SAPPHIRE = JBLOCK.register("ore_world_sapphire", Blocks.IRON_ORE);

        ORE_ENDERITE = JBLOCK.register("ore_enderite", Blocks.ANCIENT_DEBRIS);
        //endregion

        ELEVATOR = JBLOCK.register("elevator", Blocks.GRAY_WOOL, Elevator::new);

        ANGEL = JBLOCK.register("block_angel",
                         AbstractBlock.Settings.copy(Blocks.WHITE_WOOL).strength(0.1f, 5000.0f),
                         AngelBlock::new);
        
        //region DECORATION
        CITRINE_STAIRS = JBLOCK.registerStair("block_citrine_stairs", ModBlocks.CITRINE, Blocks.AMETHYST_BLOCK);
        ENDERITE_STAIRS = JBLOCK.registerStair("block_enderite_stairs", ModBlocks.ENDERITE, Blocks.IRON_BLOCK);
        RUBY_STAIRS = JBLOCK.registerStair("block_ruby_stairs", ModBlocks.RUBY, Blocks.AMETHYST_BLOCK);
        SAPPHIRE_STAIRS = JBLOCK.registerStair("block_sapphire_stairs", ModBlocks.SAPPHIRE, Blocks.AMETHYST_BLOCK);

        CITRINE_SLAB = JBLOCK.registerSlab("block_citrine_slab", Blocks.AMETHYST_BLOCK);
        ENDERITE_SLAB = JBLOCK.registerSlab("block_enderite_slab", Blocks.IRON_BLOCK);
        RUBY_SLAB = JBLOCK.registerSlab("block_ruby_slab", Blocks.AMETHYST_BLOCK);
        SAPPHIRE_SLAB = JBLOCK.registerSlab("block_sapphire_slab", Blocks.AMETHYST_BLOCK);

        CITRINE_BUTTON = JBLOCK.registerButton("block_citrine_button", BlockSetType.IRON, 40, Blocks.AMETHYST_BLOCK);
        ENDERITE_BUTTON = JBLOCK.registerButton("block_enderite_button", BlockSetType.IRON, 40, Blocks.IRON_BLOCK);
        RUBY_BUTTON = JBLOCK.registerButton("block_ruby_button", BlockSetType.IRON, 40, Blocks.AMETHYST_BLOCK);
        SAPPHIRE_BUTTON = JBLOCK.registerButton("block_sapphire_button", BlockSetType.IRON, 40, Blocks.AMETHYST_BLOCK);

        CITRINE_PRESSURE_PLATE = JBLOCK.registerPressurePlate("block_citrine_pressure_plate", BlockSetType.IRON, Blocks.AMETHYST_BLOCK);
        ENDERITE_PRESSURE_PLATE = JBLOCK.registerPressurePlate("block_enderite_pressure_plate", BlockSetType.IRON, Blocks.IRON_BLOCK);
        RUBY_PRESSURE_PLATE = JBLOCK.registerPressurePlate("block_ruby_pressure_plate", BlockSetType.IRON, Blocks.AMETHYST_BLOCK);
        SAPPHIRE_PRESSURE_PLATE = JBLOCK.registerPressurePlate("block_sapphire_pressure_plate", BlockSetType.IRON, Blocks.AMETHYST_BLOCK);

        CITRINE_FENCE = JBLOCK.registerFence("block_citrine_fence", Blocks.AMETHYST_BLOCK);
        ENDERITE_FENCE = JBLOCK.registerFence("block_enderite_fence", Blocks.IRON_BLOCK);
        RUBY_FENCE = JBLOCK.registerFence("block_ruby_fence", Blocks.AMETHYST_BLOCK);
        SAPPHIRE_FENCE = JBLOCK.registerFence("block_sapphire_fence", Blocks.AMETHYST_BLOCK);

        CITRINE_FENCE_GATE = JBLOCK.registerFenceGate("block_citrine_fence_gate", WoodType.OAK, Blocks.AMETHYST_BLOCK);
        ENDERITE_FENCE_GATE = JBLOCK.registerFenceGate("block_enderite_fence_gate", WoodType.OAK, Blocks.IRON_BLOCK);
        RUBY_FENCE_GATE = JBLOCK.registerFenceGate("block_ruby_fence_gate", WoodType.OAK, Blocks.AMETHYST_BLOCK);
        SAPPHIRE_FENCE_GATE = JBLOCK.registerFenceGate("block_sapphire_fence_gate", WoodType.OAK, Blocks.AMETHYST_BLOCK);

        CITRINE_WALL = JBLOCK.registerWall("block_citrine_wall", Blocks.AMETHYST_BLOCK);
        ENDERITE_WALL = JBLOCK.registerWall("block_enderite_wall", Blocks.IRON_BLOCK);
        RUBY_WALL = JBLOCK.registerWall("block_ruby_wall", Blocks.AMETHYST_BLOCK);
        SAPPHIRE_WALL = JBLOCK.registerWall("block_sapphire_wall", Blocks.AMETHYST_BLOCK);

        CITRINE_DOOR = JBLOCK.registerDoor("block_citrine_door", BlockSetType.IRON, Blocks.IRON_DOOR);
        ENDERITE_DOOR = JBLOCK.registerDoor("block_enderite_door", BlockSetType.IRON, Blocks.IRON_DOOR);
        RUBY_DOOR = JBLOCK.registerDoor("block_ruby_door", BlockSetType.IRON, Blocks.IRON_DOOR);
        SAPPHIRE_DOOR = JBLOCK.registerDoor("block_sapphire_door", BlockSetType.IRON, Blocks.IRON_DOOR);

        CITRINE_TRAP_DOOR = JBLOCK.registerTrapdoor("block_citrine_trap_door", BlockSetType.IRON, Blocks.IRON_DOOR);
        ENDERITE_TRAP_DOOR = JBLOCK.registerTrapdoor("block_enderite_trap_door", BlockSetType.IRON, Blocks.IRON_DOOR);
        RUBY_TRAP_DOOR = JBLOCK.registerTrapdoor("block_ruby_trap_door", BlockSetType.IRON, Blocks.IRON_DOOR);
        SAPPHIRE_TRAP_DOOR = JBLOCK.registerTrapdoor("block_sapphire_trap_door", BlockSetType.IRON, Blocks.IRON_DOOR);
        //endregion
        //region GOO
        AbstractBlock.Settings gooSettings = AbstractBlock.Settings //Settings from gray wool
                .create()
                .mapColor(MapColor.GRAY)
                .instrument(NoteBlockInstrument.GUITAR)
                .strength(0.8F)
                .sounds(BlockSoundGroup.WOOL);//.burnable()
        WATER_EATING_GOO = JBLOCK.register("water_eating_goo", gooSettings, WaterEatingGoo::new);
        WATER_GENERATING_GOO = JBLOCK.register("water_generating_goo", gooSettings, WaterGeneratingGoo::new);
        LAVA_EATING_GOO = JBLOCK.register("lava_eating_goo", gooSettings, LavaEatingGoo::new);
        LAVA_GENERATING_GOO = JBLOCK.register("lava_generating_goo", gooSettings, LavaGeneratingGoo::new);
        CHUNK_GOO = JBLOCK.register("chunk_goo", gooSettings, ChunkGoo::new);
        TOWERING_GOO = JBLOCK.register("towering_goo", gooSettings, ToweringGoo::new);
        TUNNELING_GOO = JBLOCK.register("tunneling_goo", gooSettings, TunnelingGoo::new);
        BRIDGE_GOO = JBLOCK.register("bridge_goo", gooSettings, BridgeGoo::new);
        AIR_BOMB_GOO = JBLOCK.register("air_goo_bomb", gooSettings, AirGooBomb::new);
        CHUNK_BOMB_GOO = JBLOCK.register("chunk_goo_bomb", gooSettings, ChunkGooBomb::new);
        STONE_BOMB_GOO = JBLOCK.register("stone_goo_bomb", gooSettings, StoneGooBomb::new);
        //LAVA_PUMP_GOO = JBLOCK.register("lava_pump_goo", gooSettings, LavaPumpGoo::new);
        //WATER_PUMP_GOO = JBLOCK.register("water_pump_goo", gooSettings, WaterPumpGoo::new);
        //endregion
        //region MACHINE
        REDSTONE_CLOCK = JBLOCK.register("redstone_clock", Blocks.GRAY_WOOL, RedstoneClock::new);
        ALLOY_MIXER = JBLOCK.register("alloy_mixer", Blocks.IRON_BLOCK, AlloyMixer::new);
        BUILDER = JBLOCK.register("builder", Blocks.IRON_BLOCK, BuilderBlock::new);
        CAST_PRESS = JBLOCK.register("cast_press", Blocks.IRON_BLOCK, CastPress::new);
        GEM_CLEANER = JBLOCK.register("gem_cleaner", Blocks.IRON_BLOCK, GemCleaner::new);
        GENERATOR = JBLOCK.register("generator", Blocks.IRON_BLOCK, Generator::new);
        SOLAR_PANEL = JBLOCK.register("solar_panel", Blocks.IRON_BLOCK, SolarPanel::new);
        OVEN = JBLOCK.register("oven", Blocks.IRON_BLOCK, Oven::new);
        PULVERIZER = JBLOCK.register("pulverizer", Blocks.IRON_BLOCK, Pulverizer::new);
        SMELTER = JBLOCK.register("smelter", Blocks.IRON_BLOCK, Smelter::new);
        FLUID_PUMP = JBLOCK.register("fluid_pump", Blocks.IRON_BLOCK, FluidPump::new);
        BLOCK_BREAKER = JBLOCK.register("block_breaker", Blocks.IRON_BLOCK, BlockBreaker::new);
        BLOCK_PLACER = JBLOCK.register("block_placer", Blocks.IRON_BLOCK, BlockPlacer::new);
        WOOD_STRIPPER = JBLOCK.register("wood_stripper", Blocks.IRON_BLOCK, WoodStripper::new);
        ANIMAL_FEED = JBLOCK.register("animal_feed", Blocks.CRAFTING_TABLE, AnimalFeed::new);
        TESSERACT = JBLOCK.register("tesseract", Blocks.IRON_BLOCK, Tesseract::new);
        ENDER_CHANTER = JBLOCK.register("enderchanter", Blocks.ENCHANTING_TABLE, EnderChanter::new);
        PRINTER = JBLOCK.register("printer", Blocks.CRAFTING_TABLE, Printer::new);
        PROJECT_TABLE = JBLOCK.register("project_table", Blocks.CRAFTING_TABLE, ProjectTable::new);
        CHUNK_LOADER = JBLOCK.register("chunk_loader", Blocks.IRON_BLOCK, ChunkLoader::new);
        MINER = JBLOCK.register("miner", Blocks.IRON_BLOCK, Miner::new);
        //endregion

        CREATIVE_BANK = JBLOCK.register("creative_bank", Blocks.IRON_BLOCK, CreativeEnergyBank::new);
        BATTERY_BANK = JBLOCK.register("battery_bank", Blocks.IRON_BLOCK, BatteryBank::new);
        //TODO: Register ENDERITE_SHULKER
    }

    public static void setBlackList()
    {
        BLACK_LIST.add(AIR_BOMB_GOO);
        BLACK_LIST.add(CHUNK_BOMB_GOO);
        BLACK_LIST.add(STONE_BOMB_GOO);
    }
}