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

package jiraiyah.ultraio.config;

//import jiraiyah.config.Config;

import com.mojang.datafixers.util.Pair;
import jiraiyah.jiconfig.JiConfig;

import static jiraiyah.ultraio.Main.REFERENCE;

public class Configs extends JiConfig
{
    public int DCLR_RADIUS,
            CITRINE_SWORD_DURATION, COPPER_SWORD_DURATION, SAPPHIRE_SWORD_DURATION, EXCAVATOR_MAX_DISTANCE, HAMMER_MAX_DISTANCE,
            CITRINE_EXCAVATOR_WIDTH, CITRINE_EXCAVATOR_DEPTH, CITRINE_HAMMER_WIDTH, CITRINE_HAMMER_DEPTH, COPPER_EXCAVATOR_WIDTH, COPPER_EXCAVATOR_DEPTH,
            COPPER_HAMMER_WIDTH, COPPER_HAMMER_DEPTH, ENDERITE_EXCAVATOR_WIDTH, ENDERITE_EXCAVATOR_DEPTH, ENDERITE_HAMMER_WIDTH, ENDERITE_HAMMER_DEPTH,
            RUBY_EXCAVATOR_WIDTH, RUBY_EXCAVATOR_DEPTH, RUBY_HAMMER_WIDTH, RUBY_HAMMER_DEPTH, SAPPHIRE_EXCAVATOR_WIDTH, SAPPHIRE_EXCAVATOR_DEPTH,
            SAPPHIRE_HAMMER_WIDTH, SAPPHIRE_HAMMER_DEPTH, DIAMOND_EXCAVATOR_WIDTH, DIAMOND_EXCAVATOR_DEPTH, DIAMOND_HAMMER_WIDTH, DIAMOND_HAMMER_DEPTH,
            GOLD_EXCAVATOR_WIDTH, GOLD_EXCAVATOR_DEPTH, GOLD_HAMMER_WIDTH, GOLD_HAMMER_DEPTH, IRON_EXCAVATOR_WIDTH, IRON_EXCAVATOR_DEPTH,
            IRON_HAMMER_WIDTH, IRON_HAMMER_DEPTH, NETHERITE_EXCAVATOR_WIDTH, NETHERITE_EXCAVATOR_DEPTH, NETHERITE_HAMMER_WIDTH, NETHERITE_HAMMER_DEPTH,
            STONE_EXCAVATOR_WIDTH, STONE_EXCAVATOR_DEPTH, STONE_HAMMER_WIDTH, STONE_HAMMER_DEPTH, WOOD_EXCAVATOR_WIDTH, WOOD_EXCAVATOR_DEPTH,
            WOOD_HAMMER_WIDTH, WOOD_HAMMER_DEPTH,
            GOO_SPREAD_DISTANCE, LAVA_GOO_SPREAD_DISTANCE, WATER_GOO_SPREAD_DISTANCE,
            GOO_DESTROY_DISTANCE, LAVA_GOO_DESTROY_DISTANCE, WATER_GOO_DESTROY_DISTANCE,
            GOO_PUMP_DISTANCE, GOO_PUMP_DEPTH,
            AIR_BOMB_GOO_CHANCE, CHUNK_BOMB_GOO_CHANCE, LAVA_EATING_GOO_CHANCE, LAVA_GENERATING_GOO_CHANCE, STONE_BOMB_GOO_CHANCE,
            TOWERING_GOO_CHANCE, TUNNELING_GOO_CHANCE, WATER_EATING_GOO_CHANCE, WATER_GENERATING_GOO_CHANCE,
            LAVA_PUMP_GOO_COOLDOWN, WATER_PUMP_GOO_COOLDOWN;
    public double SAPPHIRE_SWORD_MULTIPLIER;

    public Configs(String mod_Id)
    {
        super(mod_Id);
    }

    @Override
    protected void createConfigs()
    {
        provider.addComment("===================================================================================================");
        provider.addComment("===============================             SWORDS SETTINGS             ===========================");
        provider.addComment("===================================================================================================");
        //provider.addComment("The effect duration for citrine sword.");
        provider.addPair(new Pair<>(ConfigKeys.CITRINE_SWORD_DURATION, REFERENCE.CITRINE_SWORD_DEFAULT_DURATION));

        //provider.addComment("The effect duration for copper sword.");
        provider.addPair(new Pair<>(ConfigKeys.COPPER_SWORD_DURATION, REFERENCE.COPPER_SWORD_DEFAULT_DURATION));

        //provider.addComment("The effect duration for sapphire sword.");
        provider.addPair(new Pair<>(ConfigKeys.SAPPHIRE_SWORD_DURATION, REFERENCE.SAPPHIRE_SWORD_DEFAULT_DURATION), false);
        //provider.addComment("The velocity multiplier for sapphire sword.");
        provider.addPair(new Pair<>(ConfigKeys.SAPPHIRE_SWORD_MULTIPLIER, REFERENCE.SAPPHIRE_SWORD_DEFAULT_MULTIPLIER));

        provider.addComment("===================================================================================================");
        provider.addComment("===============================         EXCAVATOR ITEM SETTINGS         ===========================");
        provider.addComment("===================================================================================================");

        provider.addComment("The max distance for all of the excavators.");
        provider.addPair(new Pair<>(ConfigKeys.EXCAVATOR_MAX_DISTANCE, REFERENCE.EXCAVATOR_DEFAULT_MAX_DISTANCE));

        provider.addComment("Width Value: If you set this as a number like 3, it means the excavator will break 3 by 3 blocks.");
        provider.addComment("Depth Value: If you set this as a number like 2, it means the excavator will break 2 blocks deep.");
        provider.addNewLine();

        provider.addPair(new Pair<>(ConfigKeys.CITRINE_EXCAVATOR_WIDTH, REFERENCE.CITRINE_EXCAVATOR_DEFAULT_WIDTH), false);
        provider.addPair(new Pair<>(ConfigKeys.CITRINE_EXCAVATOR_DEPTH, REFERENCE.CITRINE_EXCAVATOR_DEFAULT_DEPTH));

        provider.addPair(new Pair<>(ConfigKeys.COPPER_EXCAVATOR_WIDTH, REFERENCE.COPPER_EXCAVATOR_DEFAULT_WIDTH), false);
        provider.addPair(new Pair<>(ConfigKeys.COPPER_EXCAVATOR_DEPTH, REFERENCE.COPPER_EXCAVATOR_DEFAULT_DEPTH));

        provider.addPair(new Pair<>(ConfigKeys.ENDERITE_EXCAVATOR_WIDTH, REFERENCE.ENDERITE_EXCAVATOR_DEFAULT_WIDTH), false);
        provider.addPair(new Pair<>(ConfigKeys.ENDERITE_EXCAVATOR_DEPTH, REFERENCE.ENDERITE_EXCAVATOR_DEFAULT_DEPTH));

        provider.addPair(new Pair<>(ConfigKeys.RUBY_EXCAVATOR_WIDTH, REFERENCE.RUBY_EXCAVATOR_DEFAULT_WIDTH), false);
        provider.addPair(new Pair<>(ConfigKeys.RUBY_EXCAVATOR_DEPTH, REFERENCE.RUBY_EXCAVATOR_DEFAULT_DEPTH));

        provider.addPair(new Pair<>(ConfigKeys.SAPPHIRE_EXCAVATOR_WIDTH, REFERENCE.SAPPHIRE_EXCAVATOR_DEFAULT_WIDTH), false);
        provider.addPair(new Pair<>(ConfigKeys.SAPPHIRE_EXCAVATOR_DEPTH, REFERENCE.SAPPHIRE_EXCAVATOR_DEFAULT_DEPTH));

        provider.addPair(new Pair<>(ConfigKeys.DIAMOND_EXCAVATOR_WIDTH, REFERENCE.DIAMOND_EXCAVATOR_DEFAULT_WIDTH), false);
        provider.addPair(new Pair<>(ConfigKeys.DIAMOND_EXCAVATOR_DEPTH, REFERENCE.DIAMOND_EXCAVATOR_DEFAULT_DEPTH));

        provider.addPair(new Pair<>(ConfigKeys.GOLD_EXCAVATOR_WIDTH, REFERENCE.GOLD_EXCAVATOR_DEFAULT_WIDTH), false);
        provider.addPair(new Pair<>(ConfigKeys.GOLD_EXCAVATOR_DEPTH, REFERENCE.GOLD_EXCAVATOR_DEFAULT_DEPTH));

        provider.addPair(new Pair<>(ConfigKeys.IRON_EXCAVATOR_WIDTH, REFERENCE.IRON_EXCAVATOR_DEFAULT_WIDTH), false);
        provider.addPair(new Pair<>(ConfigKeys.IRON_EXCAVATOR_DEPTH, REFERENCE.IRON_EXCAVATOR_DEFAULT_DEPTH));

        provider.addPair(new Pair<>(ConfigKeys.NETHERITE_EXCAVATOR_WIDTH, REFERENCE.NETHERITE_EXCAVATOR_DEFAULT_WIDTH), false);
        provider.addPair(new Pair<>(ConfigKeys.NETHERITE_EXCAVATOR_DEPTH, REFERENCE.NETHERITE_EXCAVATOR_DEFAULT_DEPTH));

        provider.addPair(new Pair<>(ConfigKeys.STONE_EXCAVATOR_WIDTH, REFERENCE.STONE_EXCAVATOR_DEFAULT_WIDTH), false);
        provider.addPair(new Pair<>(ConfigKeys.STONE_EXCAVATOR_DEPTH, REFERENCE.STONE_EXCAVATOR_DEFAULT_DEPTH));

        provider.addPair(new Pair<>(ConfigKeys.WOOD_EXCAVATOR_WIDTH, REFERENCE.WOOD_EXCAVATOR_DEFAULT_WIDTH), false);
        provider.addPair(new Pair<>(ConfigKeys.WOOD_EXCAVATOR_DEPTH, REFERENCE.WOOD_EXCAVATOR_DEFAULT_DEPTH));

        provider.addComment("===================================================================================================");
        provider.addComment("===============================           HAMMER ITEM SETTINGS          ===========================");
        provider.addComment("===================================================================================================");

        provider.addComment("The max distance for all of the hammers.");
        provider.addPair(new Pair<>(ConfigKeys.HAMMER_MAX_DISTANCE, REFERENCE.HAMMER_DEFAULT_MAX_DISTANCE));

        provider.addComment("Width Value: If you set this as a number like 3, it means the hammer will break 3 by 3 blocks.");
        provider.addComment("Depth Value: If you set this as a number like 2, it means the hammer will break 2 blocks deep.");
        provider.addNewLine();

        provider.addPair(new Pair<>(ConfigKeys.CITRINE_HAMMER_WIDTH, REFERENCE.CITRINE_HAMMER_DEFAULT_WIDTH), false);
        provider.addPair(new Pair<>(ConfigKeys.CITRINE_HAMMER_DEPTH, REFERENCE.CITRINE_HAMMER_DEFAULT_DEPTH));

        provider.addPair(new Pair<>(ConfigKeys.COPPER_HAMMER_WIDTH, REFERENCE.COPPER_HAMMER_DEFAULT_WIDTH), false);
        provider.addPair(new Pair<>(ConfigKeys.COPPER_HAMMER_DEPTH, REFERENCE.COPPER_HAMMER_DEFAULT_DEPTH));

        provider.addPair(new Pair<>(ConfigKeys.ENDERITE_HAMMER_WIDTH, REFERENCE.ENDERITE_HAMMER_DEFAULT_WIDTH), false);
        provider.addPair(new Pair<>(ConfigKeys.ENDERITE_HAMMER_DEPTH, REFERENCE.ENDERITE_HAMMER_DEFAULT_DEPTH));

        provider.addPair(new Pair<>(ConfigKeys.RUBY_HAMMER_WIDTH, REFERENCE.RUBY_HAMMER_DEFAULT_WIDTH), false);
        provider.addPair(new Pair<>(ConfigKeys.RUBY_HAMMER_DEPTH, REFERENCE.RUBY_HAMMER_DEFAULT_DEPTH));

        provider.addPair(new Pair<>(ConfigKeys.SAPPHIRE_HAMMER_WIDTH, REFERENCE.SAPPHIRE_HAMMER_DEFAULT_WIDTH), false);
        provider.addPair(new Pair<>(ConfigKeys.SAPPHIRE_HAMMER_DEPTH, REFERENCE.SAPPHIRE_HAMMER_DEFAULT_DEPTH));

        provider.addPair(new Pair<>(ConfigKeys.DIAMOND_HAMMER_WIDTH, REFERENCE.DIAMOND_HAMMER_DEFAULT_WIDTH), false);
        provider.addPair(new Pair<>(ConfigKeys.DIAMOND_HAMMER_DEPTH, REFERENCE.DIAMOND_HAMMER_DEFAULT_DEPTH));

        provider.addPair(new Pair<>(ConfigKeys.GOLD_HAMMER_WIDTH, REFERENCE.GOLD_HAMMER_DEFAULT_WIDTH), false);
        provider.addPair(new Pair<>(ConfigKeys.GOLD_HAMMER_DEPTH, REFERENCE.GOLD_HAMMER_DEFAULT_DEPTH));

        provider.addPair(new Pair<>(ConfigKeys.IRON_HAMMER_WIDTH, REFERENCE.IRON_HAMMER_DEFAULT_WIDTH), false);
        provider.addPair(new Pair<>(ConfigKeys.IRON_HAMMER_DEPTH, REFERENCE.IRON_HAMMER_DEFAULT_DEPTH));

        provider.addPair(new Pair<>(ConfigKeys.NETHERITE_HAMMER_WIDTH, REFERENCE.NETHERITE_HAMMER_DEFAULT_WIDTH), false);
        provider.addPair(new Pair<>(ConfigKeys.NETHERITE_HAMMER_DEPTH, REFERENCE.NETHERITE_HAMMER_DEFAULT_DEPTH));

        provider.addPair(new Pair<>(ConfigKeys.STONE_HAMMER_WIDTH, REFERENCE.STONE_HAMMER_DEFAULT_WIDTH), false);
        provider.addPair(new Pair<>(ConfigKeys.STONE_HAMMER_DEPTH, REFERENCE.STONE_HAMMER_DEFAULT_DEPTH));

        provider.addPair(new Pair<>(ConfigKeys.WOOD_HAMMER_WIDTH, REFERENCE.WOOD_HAMMER_DEFAULT_WIDTH), false);
        provider.addPair(new Pair<>(ConfigKeys.WOOD_HAMMER_DEPTH, REFERENCE.WOOD_HAMMER_DEFAULT_DEPTH));

        provider.addComment("===================================================================================================");
        provider.addComment("===============================            GOO BLOCK SETTINGS           ===========================");
        provider.addComment("===================================================================================================");

        provider.addComment("The max distance for all goo blocks to spread / destroy in the world.");
        provider.addPair(new Pair<>(ConfigKeys.GOO_SPREAD_DISTANCE, REFERENCE.GOO_SPREAD_DISTANCE), false);
        provider.addPair(new Pair<>(ConfigKeys.LAVA_GOO_SPREAD_DISTANCE, REFERENCE.LAVA_GOO_SPREAD_DISTANCE), false);
        provider.addPair(new Pair<>(ConfigKeys.WATER_GOO_SPREAD_DISTANCE, REFERENCE.WATER_GOO_SPREAD_DISTANCE));
        provider.addPair(new Pair<>(ConfigKeys.GOO_DESTROY_DISTANCE, REFERENCE.GOO_DESTROY_DISTANCE), false);
        provider.addPair(new Pair<>(ConfigKeys.LAVA_GOO_DESTROY_DISTANCE, REFERENCE.LAVA_GOO_DESTROY_DISTANCE), false);
        provider.addPair(new Pair<>(ConfigKeys.WATER_GOO_DESTROY_DISTANCE, REFERENCE.WATER_GOO_DESTROY_DISTANCE));

        provider.addComment("The max distance and depth for lava and water pump goo blocks.");
        provider.addPair(new Pair<>(ConfigKeys.GOO_PUMP_DISTANCE, REFERENCE.GOO_PUMP_DISTANCE), false);
        provider.addPair(new Pair<>(ConfigKeys.GOO_PUMP_DEPTH, REFERENCE.GOO_PUMP_DEPTH));


        provider.addComment("The chance value to destroy the goo bomb in each tick the higher value means faster destruction.");
        provider.addPair(new Pair<>(ConfigKeys.AIR_BOMB_GOO_CHANCE, REFERENCE.AIR_BOMB_GOO_CHANCE), false);
        provider.addPair(new Pair<>(ConfigKeys.CHUNK_BOMB_GOO_CHANCE, REFERENCE.CHUNK_BOMB_GOO_CHANCE), false);
        provider.addPair(new Pair<>(ConfigKeys.LAVA_EATING_GOO_CHANCE, REFERENCE.LAVA_EATING_GOO_CHANCE), false);
        provider.addPair(new Pair<>(ConfigKeys.LAVA_GENERATING_GOO_CHANCE, REFERENCE.LAVA_GENERATING_GOO_CHANCE), false);
        provider.addPair(new Pair<>(ConfigKeys.STONE_BOMB_GOO_CHANCE, REFERENCE.STONE_BOMB_GOO_CHANCE), false);
        provider.addPair(new Pair<>(ConfigKeys.TOWERING_GOO_CHANCE, REFERENCE.TOWERING_GOO_CHANCE), false);
        provider.addPair(new Pair<>(ConfigKeys.TUNNELING_GOO_CHANCE, REFERENCE.TUNNELING_GOO_CHANCE), false);
        provider.addPair(new Pair<>(ConfigKeys.WATER_EATING_GOO_CHANCE, REFERENCE.WATER_EATING_GOO_CHANCE), false);
        provider.addPair(new Pair<>(ConfigKeys.WATER_GENERATING_GOO_CHANCE, REFERENCE.WATER_GENERATING_GOO_CHANCE));

        provider.addComment("The cooldown timer for goo pumps to work.");
        provider.addPair(new Pair<>(ConfigKeys.LAVA_PUMP_GOO_COOLDOWN, REFERENCE.LAVA_PUMP_GOO_COOLDOWN), false);
        provider.addPair(new Pair<>(ConfigKeys.WATER_PUMP_GOO_COOLDOWN, REFERENCE.WATER_PUMP_GOO_COOLDOWN));

        provider.addComment("===================================================================================================");
        provider.addComment("===============================            COMMANDS SETTINGS            ===========================");
        provider.addComment("===================================================================================================");
        provider.addComment("The radius for DCLR command, this will be the value for the command to expand on each side.");
        provider.addComment("The final dimension would be (radius * 2) + 1.");
        provider.addPair(new Pair<>(ConfigKeys.DCLR, REFERENCE.DCLR_DEFAULT_RADIUS), false, true);
    }

    @Override
    protected void assignConfigValues()
    {
        CITRINE_SWORD_DURATION = config.getOrDefault(ConfigKeys.CITRINE_SWORD_DURATION, REFERENCE.CITRINE_SWORD_DEFAULT_DURATION);
        COPPER_SWORD_DURATION = config.getOrDefault(ConfigKeys.COPPER_SWORD_DURATION, REFERENCE.COPPER_SWORD_DEFAULT_DURATION);
        SAPPHIRE_SWORD_DURATION = config.getOrDefault(ConfigKeys.SAPPHIRE_SWORD_DURATION, REFERENCE.SAPPHIRE_SWORD_DEFAULT_DURATION);
        SAPPHIRE_SWORD_MULTIPLIER = config.getOrDefault(ConfigKeys.SAPPHIRE_SWORD_MULTIPLIER, REFERENCE.SAPPHIRE_SWORD_DEFAULT_MULTIPLIER);
        EXCAVATOR_MAX_DISTANCE = config.getOrDefault(ConfigKeys.EXCAVATOR_MAX_DISTANCE, REFERENCE.EXCAVATOR_DEFAULT_MAX_DISTANCE);
        HAMMER_MAX_DISTANCE = config.getOrDefault(ConfigKeys.HAMMER_MAX_DISTANCE, REFERENCE.HAMMER_DEFAULT_MAX_DISTANCE);

        CITRINE_EXCAVATOR_WIDTH = config.getOrDefault(ConfigKeys.CITRINE_EXCAVATOR_WIDTH, REFERENCE.CITRINE_EXCAVATOR_DEFAULT_WIDTH);
        CITRINE_EXCAVATOR_DEPTH = config.getOrDefault(ConfigKeys.CITRINE_EXCAVATOR_DEPTH, REFERENCE.CITRINE_EXCAVATOR_DEFAULT_DEPTH);
        CITRINE_HAMMER_WIDTH = config.getOrDefault(ConfigKeys.CITRINE_HAMMER_WIDTH, REFERENCE.CITRINE_HAMMER_DEFAULT_WIDTH);
        CITRINE_HAMMER_DEPTH = config.getOrDefault(ConfigKeys.CITRINE_HAMMER_DEPTH, REFERENCE.CITRINE_HAMMER_DEFAULT_DEPTH);

        COPPER_EXCAVATOR_WIDTH = config.getOrDefault(ConfigKeys.COPPER_EXCAVATOR_WIDTH, REFERENCE.COPPER_EXCAVATOR_DEFAULT_WIDTH);
        COPPER_EXCAVATOR_DEPTH = config.getOrDefault(ConfigKeys.COPPER_EXCAVATOR_DEPTH, REFERENCE.COPPER_EXCAVATOR_DEFAULT_DEPTH);
        COPPER_HAMMER_WIDTH = config.getOrDefault(ConfigKeys.COPPER_HAMMER_WIDTH, REFERENCE.COPPER_HAMMER_DEFAULT_WIDTH);
        COPPER_HAMMER_DEPTH = config.getOrDefault(ConfigKeys.COPPER_HAMMER_DEPTH, REFERENCE.COPPER_HAMMER_DEFAULT_DEPTH);

        ENDERITE_EXCAVATOR_WIDTH = config.getOrDefault(ConfigKeys.ENDERITE_EXCAVATOR_WIDTH, REFERENCE.ENDERITE_EXCAVATOR_DEFAULT_WIDTH);
        ENDERITE_EXCAVATOR_DEPTH = config.getOrDefault(ConfigKeys.ENDERITE_EXCAVATOR_DEPTH, REFERENCE.ENDERITE_EXCAVATOR_DEFAULT_DEPTH);
        ENDERITE_HAMMER_WIDTH = config.getOrDefault(ConfigKeys.ENDERITE_HAMMER_WIDTH, REFERENCE.ENDERITE_HAMMER_DEFAULT_WIDTH);
        ENDERITE_HAMMER_DEPTH = config.getOrDefault(ConfigKeys.ENDERITE_HAMMER_DEPTH, REFERENCE.ENDERITE_HAMMER_DEFAULT_DEPTH);

        RUBY_EXCAVATOR_WIDTH = config.getOrDefault(ConfigKeys.RUBY_EXCAVATOR_WIDTH, REFERENCE.RUBY_EXCAVATOR_DEFAULT_WIDTH);
        RUBY_EXCAVATOR_DEPTH = config.getOrDefault(ConfigKeys.RUBY_EXCAVATOR_DEPTH, REFERENCE.RUBY_EXCAVATOR_DEFAULT_DEPTH);
        RUBY_HAMMER_WIDTH = config.getOrDefault(ConfigKeys.RUBY_HAMMER_WIDTH, REFERENCE.RUBY_HAMMER_DEFAULT_WIDTH);
        RUBY_HAMMER_DEPTH = config.getOrDefault(ConfigKeys.RUBY_HAMMER_DEPTH, REFERENCE.RUBY_HAMMER_DEFAULT_DEPTH);

        SAPPHIRE_EXCAVATOR_WIDTH = config.getOrDefault(ConfigKeys.SAPPHIRE_EXCAVATOR_WIDTH, REFERENCE.SAPPHIRE_EXCAVATOR_DEFAULT_WIDTH);
        SAPPHIRE_EXCAVATOR_DEPTH = config.getOrDefault(ConfigKeys.SAPPHIRE_EXCAVATOR_DEPTH, REFERENCE.SAPPHIRE_EXCAVATOR_DEFAULT_DEPTH);
        SAPPHIRE_HAMMER_WIDTH = config.getOrDefault(ConfigKeys.SAPPHIRE_HAMMER_WIDTH, REFERENCE.SAPPHIRE_HAMMER_DEFAULT_WIDTH);
        SAPPHIRE_HAMMER_DEPTH = config.getOrDefault(ConfigKeys.SAPPHIRE_HAMMER_DEPTH, REFERENCE.SAPPHIRE_HAMMER_DEFAULT_DEPTH);

        DIAMOND_EXCAVATOR_WIDTH = config.getOrDefault(ConfigKeys.DIAMOND_EXCAVATOR_WIDTH, REFERENCE.DIAMOND_EXCAVATOR_DEFAULT_WIDTH);
        DIAMOND_EXCAVATOR_DEPTH = config.getOrDefault(ConfigKeys.DIAMOND_EXCAVATOR_DEPTH, REFERENCE.DIAMOND_EXCAVATOR_DEFAULT_DEPTH);
        DIAMOND_HAMMER_WIDTH = config.getOrDefault(ConfigKeys.DIAMOND_HAMMER_WIDTH, REFERENCE.DIAMOND_HAMMER_DEFAULT_WIDTH);
        DIAMOND_HAMMER_DEPTH = config.getOrDefault(ConfigKeys.DIAMOND_HAMMER_DEPTH, REFERENCE.DIAMOND_HAMMER_DEFAULT_DEPTH);

        GOLD_EXCAVATOR_WIDTH = config.getOrDefault(ConfigKeys.GOLD_EXCAVATOR_WIDTH, REFERENCE.GOLD_EXCAVATOR_DEFAULT_WIDTH);
        GOLD_EXCAVATOR_DEPTH = config.getOrDefault(ConfigKeys.GOLD_EXCAVATOR_DEPTH, REFERENCE.GOLD_EXCAVATOR_DEFAULT_DEPTH);
        GOLD_HAMMER_WIDTH = config.getOrDefault(ConfigKeys.GOLD_HAMMER_WIDTH, REFERENCE.GOLD_HAMMER_DEFAULT_WIDTH);
        GOLD_HAMMER_DEPTH = config.getOrDefault(ConfigKeys.GOLD_HAMMER_DEPTH, REFERENCE.GOLD_HAMMER_DEFAULT_DEPTH);

        IRON_EXCAVATOR_WIDTH = config.getOrDefault(ConfigKeys.IRON_EXCAVATOR_WIDTH, REFERENCE.IRON_EXCAVATOR_DEFAULT_WIDTH);
        IRON_EXCAVATOR_DEPTH = config.getOrDefault(ConfigKeys.IRON_EXCAVATOR_DEPTH, REFERENCE.IRON_EXCAVATOR_DEFAULT_DEPTH);
        IRON_HAMMER_WIDTH = config.getOrDefault(ConfigKeys.IRON_HAMMER_WIDTH, REFERENCE.IRON_HAMMER_DEFAULT_WIDTH);
        IRON_HAMMER_DEPTH = config.getOrDefault(ConfigKeys.IRON_HAMMER_DEPTH, REFERENCE.IRON_HAMMER_DEFAULT_DEPTH);

        NETHERITE_EXCAVATOR_WIDTH = config.getOrDefault(ConfigKeys.NETHERITE_EXCAVATOR_WIDTH, REFERENCE.NETHERITE_EXCAVATOR_DEFAULT_WIDTH);
        NETHERITE_EXCAVATOR_DEPTH = config.getOrDefault(ConfigKeys.NETHERITE_EXCAVATOR_DEPTH, REFERENCE.NETHERITE_EXCAVATOR_DEFAULT_DEPTH);
        NETHERITE_HAMMER_WIDTH = config.getOrDefault(ConfigKeys.NETHERITE_HAMMER_WIDTH, REFERENCE.NETHERITE_HAMMER_DEFAULT_WIDTH);
        NETHERITE_HAMMER_DEPTH = config.getOrDefault(ConfigKeys.NETHERITE_HAMMER_DEPTH, REFERENCE.NETHERITE_HAMMER_DEFAULT_DEPTH);

        STONE_EXCAVATOR_WIDTH = config.getOrDefault(ConfigKeys.STONE_EXCAVATOR_WIDTH, REFERENCE.STONE_EXCAVATOR_DEFAULT_WIDTH);
        STONE_EXCAVATOR_DEPTH = config.getOrDefault(ConfigKeys.STONE_EXCAVATOR_DEPTH, REFERENCE.STONE_EXCAVATOR_DEFAULT_DEPTH);
        STONE_HAMMER_WIDTH = config.getOrDefault(ConfigKeys.STONE_HAMMER_WIDTH, REFERENCE.STONE_HAMMER_DEFAULT_WIDTH);
        STONE_HAMMER_DEPTH = config.getOrDefault(ConfigKeys.STONE_HAMMER_DEPTH, REFERENCE.STONE_HAMMER_DEFAULT_DEPTH);

        WOOD_EXCAVATOR_WIDTH = config.getOrDefault(ConfigKeys.WOOD_EXCAVATOR_WIDTH, REFERENCE.WOOD_EXCAVATOR_DEFAULT_WIDTH);
        WOOD_EXCAVATOR_DEPTH = config.getOrDefault(ConfigKeys.WOOD_EXCAVATOR_DEPTH, REFERENCE.WOOD_EXCAVATOR_DEFAULT_DEPTH);
        WOOD_HAMMER_WIDTH = config.getOrDefault(ConfigKeys.WOOD_HAMMER_WIDTH, REFERENCE.WOOD_HAMMER_DEFAULT_WIDTH);
        WOOD_HAMMER_DEPTH = config.getOrDefault(ConfigKeys.WOOD_HAMMER_DEPTH, REFERENCE.WOOD_HAMMER_DEFAULT_DEPTH);

        GOO_SPREAD_DISTANCE = config.getOrDefault(ConfigKeys.GOO_SPREAD_DISTANCE, REFERENCE.GOO_SPREAD_DISTANCE);
        LAVA_GOO_SPREAD_DISTANCE = config.getOrDefault(ConfigKeys.LAVA_GOO_SPREAD_DISTANCE, REFERENCE.LAVA_GOO_SPREAD_DISTANCE);
        WATER_GOO_SPREAD_DISTANCE = config.getOrDefault(ConfigKeys.WATER_GOO_SPREAD_DISTANCE, REFERENCE.WATER_GOO_SPREAD_DISTANCE);
        GOO_DESTROY_DISTANCE = config.getOrDefault(ConfigKeys.GOO_DESTROY_DISTANCE, REFERENCE.GOO_DESTROY_DISTANCE);
        LAVA_GOO_DESTROY_DISTANCE = config.getOrDefault(ConfigKeys.LAVA_GOO_DESTROY_DISTANCE, REFERENCE.LAVA_GOO_DESTROY_DISTANCE);
        WATER_GOO_DESTROY_DISTANCE = config.getOrDefault(ConfigKeys.WATER_GOO_DESTROY_DISTANCE, REFERENCE.WATER_GOO_DESTROY_DISTANCE);
        GOO_PUMP_DISTANCE = config.getOrDefault(ConfigKeys.GOO_PUMP_DISTANCE, REFERENCE.GOO_PUMP_DISTANCE);
        GOO_PUMP_DEPTH = config.getOrDefault(ConfigKeys.GOO_PUMP_DEPTH, REFERENCE.GOO_PUMP_DEPTH);
        AIR_BOMB_GOO_CHANCE = config.getOrDefault(ConfigKeys.AIR_BOMB_GOO_CHANCE, REFERENCE.AIR_BOMB_GOO_CHANCE);
        CHUNK_BOMB_GOO_CHANCE = config.getOrDefault(ConfigKeys.CHUNK_BOMB_GOO_CHANCE, REFERENCE.CHUNK_BOMB_GOO_CHANCE);
        LAVA_EATING_GOO_CHANCE = config.getOrDefault(ConfigKeys.LAVA_EATING_GOO_CHANCE, REFERENCE.LAVA_EATING_GOO_CHANCE);
        LAVA_GENERATING_GOO_CHANCE = config.getOrDefault(ConfigKeys.LAVA_GENERATING_GOO_CHANCE, REFERENCE.LAVA_GENERATING_GOO_CHANCE);
        STONE_BOMB_GOO_CHANCE = config.getOrDefault(ConfigKeys.STONE_BOMB_GOO_CHANCE, REFERENCE.STONE_BOMB_GOO_CHANCE);
        TOWERING_GOO_CHANCE = config.getOrDefault(ConfigKeys.TOWERING_GOO_CHANCE, REFERENCE.TOWERING_GOO_CHANCE);
        TUNNELING_GOO_CHANCE = config.getOrDefault(ConfigKeys.TUNNELING_GOO_CHANCE, REFERENCE.TUNNELING_GOO_CHANCE);
        WATER_EATING_GOO_CHANCE = config.getOrDefault(ConfigKeys.WATER_EATING_GOO_CHANCE, REFERENCE.WATER_EATING_GOO_CHANCE);
        WATER_GENERATING_GOO_CHANCE = config.getOrDefault(ConfigKeys.WATER_GENERATING_GOO_CHANCE, REFERENCE.WATER_GENERATING_GOO_CHANCE);
        LAVA_PUMP_GOO_COOLDOWN = config.getOrDefault(ConfigKeys.LAVA_PUMP_GOO_COOLDOWN, REFERENCE.LAVA_PUMP_GOO_COOLDOWN);
        WATER_PUMP_GOO_COOLDOWN = config.getOrDefault(ConfigKeys.WATER_PUMP_GOO_COOLDOWN, REFERENCE.WATER_PUMP_GOO_COOLDOWN);

        DCLR_RADIUS = config.getOrDefault(ConfigKeys.DCLR, REFERENCE.DCLR_DEFAULT_RADIUS);
    }
}