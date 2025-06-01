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

import jiraiyah.jibase.utils.BaseHelper;
import net.fabricmc.fabric.api.gamerule.v1.CustomGameRuleCategory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.util.Identifier;
import net.minecraft.world.GameRules;

import static jiraiyah.ultraio.Main.ModID;
import static jiraiyah.ultraio.Main.REFERENCE;

public class Rules
{
    public static final Identifier GAME_RULE_ID = BaseHelper.identifier(ModID, "goo_rule");
    public static CustomGameRuleCategory GOO_RULE_CATEGORY;

    public static GameRules.Key<GameRules.BooleanRule> SPREAD;
    public static GameRules.Key<GameRules.BooleanRule> LAVA_PUMP_ACTIVE;
    public static GameRules.Key<GameRules.BooleanRule> WATER_PUMP_ACTIVE;

    public static void init()
    {
        GOO_RULE_CATEGORY = new CustomGameRuleCategory(GAME_RULE_ID, REFERENCE.translate("goo.category"));
        //SPREAD = GameRuleRegistry.register("gooSpread", GameRules.Category.UPDATES, GameRuleFactory.createBooleanRule(true));
        SPREAD = GameRuleRegistry.register("goo.spread", GOO_RULE_CATEGORY, GameRuleFactory.createBooleanRule(true));
        LAVA_PUMP_ACTIVE = GameRuleRegistry.register("lava.pump.goo.active", GOO_RULE_CATEGORY, GameRuleFactory.createBooleanRule(true));
        WATER_PUMP_ACTIVE = GameRuleRegistry.register("water.pump.goo.active", GOO_RULE_CATEGORY, GameRuleFactory.createBooleanRule(true));
    }
}