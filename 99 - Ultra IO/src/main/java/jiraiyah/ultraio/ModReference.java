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

package jiraiyah.ultraio;

import jiraiyah.jireference.JiReference;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.text.MutableText;

public class ModReference extends JiReference
{
    /**
     * Constructs a new `JiReference` instance with the specified mod ID.
     *
     * <p>This constructor initializes the `JiReference` object by setting the mod ID
     * and creating a `Logger` instance. The `Logger` is configured to use the mod ID
     * as a prefix for all log messages, ensuring that log entries are easily
     * identifiable and associated with this specific mod.</p>
     *
     * @param mod_ID The mod ID to be used for this instance. It is used for
     *               creating identifiers and logging messages specific to the mod.
     */
    public ModReference(String mod_ID)
    {
        super(mod_ID);
    }

    //region CONFIG DEFAULT VALUES
    public final int DCLR_DEFAULT_RADIUS = 128;

    public final int CITRINE_SWORD_DEFAULT_DURATION = 200;
    public final int COPPER_SWORD_DEFAULT_DURATION = 200;
    public final int SAPPHIRE_SWORD_DEFAULT_DURATION = 200;

    public final int EXCAVATOR_DEFAULT_MAX_DISTANCE = 8;
    public final int HAMMER_DEFAULT_MAX_DISTANCE = 8;

    public final int CITRINE_EXCAVATOR_DEFAULT_WIDTH = 5;
    public final int CITRINE_EXCAVATOR_DEFAULT_DEPTH = 1;
    public final int COPPER_EXCAVATOR_DEFAULT_WIDTH = 3;
    public final int COPPER_EXCAVATOR_DEFAULT_DEPTH = 1;
    public final int ENDERITE_EXCAVATOR_DEFAULT_WIDTH = 9;
    public final int ENDERITE_EXCAVATOR_DEFAULT_DEPTH = 1;
    public final int RUBY_EXCAVATOR_DEFAULT_WIDTH = 5;
    public final int RUBY_EXCAVATOR_DEFAULT_DEPTH = 1;
    public final int SAPPHIRE_EXCAVATOR_DEFAULT_WIDTH = 5;
    public final int SAPPHIRE_EXCAVATOR_DEFAULT_DEPTH = 1;
    public final int DIAMOND_EXCAVATOR_DEFAULT_WIDTH = 5;
    public final int DIAMOND_EXCAVATOR_DEFAULT_DEPTH = 1;
    public final int GOLD_EXCAVATOR_DEFAULT_WIDTH = 5;
    public final int GOLD_EXCAVATOR_DEFAULT_DEPTH = 1;
    public final int IRON_EXCAVATOR_DEFAULT_WIDTH = 5;
    public final int IRON_EXCAVATOR_DEFAULT_DEPTH = 1;
    public final int NETHERITE_EXCAVATOR_DEFAULT_WIDTH = 7;
    public final int NETHERITE_EXCAVATOR_DEFAULT_DEPTH = 1;
    public final int STONE_EXCAVATOR_DEFAULT_WIDTH = 3;
    public final int STONE_EXCAVATOR_DEFAULT_DEPTH = 1;
    public final int WOOD_EXCAVATOR_DEFAULT_WIDTH = 3;
    public final int WOOD_EXCAVATOR_DEFAULT_DEPTH = 1;

    public final int CITRINE_HAMMER_DEFAULT_WIDTH = 3;
    public final int CITRINE_HAMMER_DEFAULT_DEPTH = 2;
    public final int COPPER_HAMMER_DEFAULT_WIDTH = 3;
    public final int COPPER_HAMMER_DEFAULT_DEPTH = 2;
    public final int ENDERITE_HAMMER_DEFAULT_WIDTH = 5;
    public final int ENDERITE_HAMMER_DEFAULT_DEPTH = 5;
    public final int RUBY_HAMMER_DEFAULT_WIDTH = 5;
    public final int RUBY_HAMMER_DEFAULT_DEPTH = 2;
    public final int SAPPHIRE_HAMMER_DEFAULT_WIDTH = 5;
    public final int SAPPHIRE_HAMMER_DEFAULT_DEPTH = 2;
    public final int DIAMOND_HAMMER_DEFAULT_WIDTH = 5;
    public final int DIAMOND_HAMMER_DEFAULT_DEPTH = 2;
    public final int GOLD_HAMMER_DEFAULT_WIDTH = 5;
    public final int GOLD_HAMMER_DEFAULT_DEPTH = 1;
    public final int IRON_HAMMER_DEFAULT_WIDTH = 5;
    public final int IRON_HAMMER_DEFAULT_DEPTH = 1;
    public final int NETHERITE_HAMMER_DEFAULT_WIDTH = 5;
    public final int NETHERITE_HAMMER_DEFAULT_DEPTH = 3;
    public final int STONE_HAMMER_DEFAULT_WIDTH = 3;
    public final int STONE_HAMMER_DEFAULT_DEPTH = 1;
    public final int WOOD_HAMMER_DEFAULT_WIDTH = 3;
    public final int WOOD_HAMMER_DEFAULT_DEPTH = 1;

    public final double SAPPHIRE_SWORD_DEFAULT_MULTIPLIER = 5.0d;

    public final int GOO_SPREAD_DISTANCE = 256;
    public final int WATER_GOO_SPREAD_DISTANCE = 64;
    public final int LAVA_GOO_SPREAD_DISTANCE = 64;
    public final int GOO_DESTROY_DISTANCE = 256;
    public final int WATER_GOO_DESTROY_DISTANCE = 64;
    public final int LAVA_GOO_DESTROY_DISTANCE = 64;
    public final int GOO_PUMP_DISTANCE = 128;
    public final int GOO_PUMP_DEPTH = 64;
    public final int AIR_BOMB_GOO_CHANCE = 3;
    public final int CHUNK_BOMB_GOO_CHANCE = 2;
    public final int LAVA_EATING_GOO_CHANCE = 2;
    public final int LAVA_GENERATING_GOO_CHANCE = 4;
    public final int STONE_BOMB_GOO_CHANCE = 3;
    public final int TOWERING_GOO_CHANCE = 3;
    public final int TUNNELING_GOO_CHANCE = 3;
    public final int WATER_EATING_GOO_CHANCE = 10;
    public final int WATER_GENERATING_GOO_CHANCE = 5;
    public final int LAVA_PUMP_GOO_COOLDOWN = 20;
    public final int WATER_PUMP_GOO_COOLDOWN = 20;
    //endregion

    //region ITEM GROUP NAMES
    public final String BLOCK_ITEM_GROUP_NAME = "_1_block_group";
    public final String DECORATION_ITEM_GROUP_NAME = "_2_decoration_group";
    public final String INGREDIENT_ITEM_GROUP_NAME = "_7_ingredient_group";
    public final String MACHINE_ITEM_GROUP_NAME = "_3_machine_group";
    public final String TOOLS_ITEM_GROUP_NAME = "_5_tool_group";
    public final String ARMOR_ITEM_GROUP_NAME = "_6_armor_group";
    public final String MISC_ITEM_GROUP_NAME = "_8_misc_group";
    public final String STORAGE_ITEM_GROUP_NAME = "_4_storage_group";
    //endregion

    //region ITEM GROUP TITLES
    public final MutableText BLOCKS_TITLE = translate(BLOCK_ITEM_GROUP_NAME);
    public final MutableText DECORATIONS_TITLE = translate(DECORATION_ITEM_GROUP_NAME);
    public final MutableText INGREDIENT_TITLE = translate(INGREDIENT_ITEM_GROUP_NAME);
    public final MutableText MACHINES_TITLE = translate(MACHINE_ITEM_GROUP_NAME);
    public final MutableText TOOLS_TITLE = translate(TOOLS_ITEM_GROUP_NAME);
    public final MutableText ARMORS_TITLE = translate(ARMOR_ITEM_GROUP_NAME);
    public final MutableText MISC_TITLE = translate(MISC_ITEM_GROUP_NAME);
    public final MutableText STORAGE_TITLE = translate(STORAGE_ITEM_GROUP_NAME);
    //endregion

    //region BLOCK TAGS
    public final TagKey<Block> GEM_BLOCKS = createBlockCommonTag("gem_blocks");
    public final TagKey<Block> CITRINE_BLOCKS = createBlockCommonTag("citrine_blocks");
    public final TagKey<Block> RUBY_BLOCKS = createBlockCommonTag("ruby_blocks");
    public final TagKey<Block> SAPPHIRE_BLOCKS = createBlockCommonTag("sapphire_blocks");
    public final TagKey<Block> IS_MACHINE = createBlockCommonTag("machines");
    public final TagKey<Block> HAMMER_BLACKLIST = createBlockTag("hammer_blacklist");
    public final TagKey<Block> EXCAVATOR_BLACKLIST = createBlockTag("excavator_blacklist");
    public final TagKey<Block> INCORRECT_FOR_ENDERITE_TOOL = createBlockTag("incorrect_for_enderite_tool");
    public final TagKey<Block> GOO_BLACKLIST = createBlockTag("goo_blacklist");
    public final TagKey<Block> FLUID_TANKS = createBlockTag("fluid_tank");
    //endregion

    //region INGREDIENT TAGS
    public final TagKey<Item> CAST = createItemCommonTag("casts");
    public final TagKey<Item> RAW = createItemCommonTag("raws");
    public final TagKey<Item> WOOD_CAST = createItemCommonTag("wood_casts");
    public final TagKey<Item> GEAR = createItemCommonTag("gears");
    public final TagKey<Item> DUST = createItemCommonTag("dusts");
    public final TagKey<Item> INGOT = createItemCommonTag("ingots");
    public final TagKey<Item> PLATE = createItemCommonTag("plates");
    public final TagKey<Item> REINFORCED = createItemCommonTag("reinforced_plates");
    public final TagKey<Item> ROD = createItemCommonTag("rods");
    public final TagKey<Item> TOOL_HEAD = createItemCommonTag("tool_heads");
    public final TagKey<Item> ALLOY = createItemCommonTag("alloys");
    public final TagKey<Item> GEM = createItemCommonTag("gems");
    public final TagKey<Item> CITRINE_GEM = createItemCommonTag("citrine_gems");
    public final TagKey<Item> RUBY_GEM = createItemCommonTag("ruby_gems");
    public final TagKey<Item> SAPPHIRE_GEM = createItemCommonTag("sapphire_gems");
    //endregion

    //region TOOLS TAGS
    public final TagKey<Item> HAMMERS = createItemTag("hammers");
    public final TagKey<Item> EXCAVATORS = createItemTag("excavators");
    public final TagKey<Item> MENDING_ONLY = createItemTag("mending_only");
    //endregion

    public final TagKey<Item> FLUID_BUCKET = createItemCommonTag("fluid_buckets");
    public final TagKey<Item> SMELTABLE = createItemTag("smeltery");

    //region ARMOR TAGS
    public final TagKey<Item> REPAIRS_AMETHYST_ARMOR = createItemTag("repairs_amethyst_armor");
    public final TagKey<Item> REPAIRS_CITRINE_ARMOR = createItemTag("repairs_citrine_armor");
    public final TagKey<Item> REPAIRS_COPPER_ARMOR = createItemTag("repairs_copper_armor");
    public final TagKey<Item> REPAIRS_EMERALD_ARMOR = createItemTag("repairs_emerald_armor");
    public final TagKey<Item> REPAIRS_ENDERITE_ARMOR = createItemTag("repairs_enderite_armor");
    public final TagKey<Item> REPAIRS_RUBY_ARMOR = createItemTag("repairs_ruby_armor");
    public final TagKey<Item> REPAIRS_SAPPHIRE_ARMOR = createItemTag("repairs_sapphire_armor");
    public final TagKey<Item> REPAIRS_CITRINE_TOOL = createItemTag("repairs_citrine_tool");
    public final TagKey<Item> REPAIRS_COPPER_TOOL = createItemTag("repairs_copper_tool");
    public final TagKey<Item> REPAIRS_ENDERITE_TOOL = createItemTag("repairs_enderite_tool");
    public final TagKey<Item> REPAIRS_RUBY_TOOL = createItemTag("repairs_ruby_tool");
    public final TagKey<Item> REPAIRS_SAPPHIRE_TOOL = createItemTag("repairs_sapphire_tool");
    public final TagKey<Item> AMETHYST_ARMOR_TYPE = createItemTag("amethyst_armor_type");
    public final TagKey<Item> CITRINE_ARMOR_TYPE = createItemTag("citrine_armor_type");
    public final TagKey<Item> COPPER_ARMOR_TYPE = createItemTag("copper_armor_type");
    public final TagKey<Item> EMERALD_ARMOR_TYPE = createItemTag("emerald_armor_type");
    public final TagKey<Item> ENDERITE_ARMOR_TYPE = createItemTag("enderite_armor_type");
    public final TagKey<Item> RUBY_ARMOR_TYPE = createItemTag("ruby_armor_type");
    public final TagKey<Item> SAPPHIRE_ARMOR_TYPE = createItemTag("sapphire_armor_type");
    //endregion

    //region ENTITY TAGS
    public final TagKey<EntityType<?>> TUNER_BLACKLIST = createEntityTag("tuner_blacklist");
    public final TagKey<EntityType<?>> RUBY_SWORD_WHITELIST = createEntityTag("ruby_sword_whitelist");
    public final TagKey<EntityType<?>> ENDERITE_SWORD_BLACKLIST = createEntityTag("enderite_sword_blacklist");
    //endregion

    //region DCLR COMMAND
    public final String DCLR_ERROR_ID_NAME = "dclr.error";
    public final String DCLR_START_ID_NAME = "dclr.start";
    public final String DCLR_END_ID_NAME = "dclr.end";

    public final TagKey<Block> DCLR_ORE_WHITELIST = createBlockTag("dclr_ore_whitelist");
    public final TagKey<Block> DCLR_BLOCK_WHITELIST = createBlockTag("dclr_block_whitelist");
    public final TagKey<Block> DCLR_FLUID_WHITELIST = createBlockTag("dclr_fluid_whitelist");
    //endregion

    //region TOOL TOOLTIP
    public final String TUNER_TOOLTIP_ID_NAME = "tuner.tooltip";
    public final String TUNER_TELEPORTED_ID_NAME = "tuner.teleported";
    public final String TUNER_ERROR_ID_NAME = "tuner.error";
    public final String TELEPORTER_TOOLTIP_ID_NAME = "teleporter.tooltip";
    public final String HAMMER_PARAM_TOOLTIP = "hammer.tooltip";
    public final String EXCAVATOR_PARAM_TOOLTIP = "excavator.tooltip";
    //endregion
}