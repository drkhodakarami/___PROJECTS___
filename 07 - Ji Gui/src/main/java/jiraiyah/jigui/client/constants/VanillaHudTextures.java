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

package jiraiyah.jigui.client.constants;

import jiraiyah.jibase.annotations.*;
import jiraiyah.jigui.client.records.TextureData;
import net.minecraft.util.Identifier;

@Developer("Jiraiyah")
@CreatedAt("2025-04-18")
@ModifiedAt("2025-04-23")
@Repository("https://github.com/drkhodakarami/___PROJECTS___")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")
public class VanillaHudTextures
{
    public static final TextureData AIR = new TextureData(0, 0, 0, 0, 9, 9, 9, 9,
                                                          Identifier.ofVanilla("textures/gui/sprites/hud/air.png"));
    public static final TextureData AIR_BURSTING = new TextureData(0, 0, 0, 0, 9, 9, 9, 9,
                                                                   Identifier.ofVanilla("textures/gui/sprites/hud/air_bursting.png"));
    public static final TextureData AIR_EMPTY = new TextureData(0, 0, 0, 0, 9, 9, 9, 9,
                                                                Identifier.ofVanilla("textures/gui/sprites/hud/air_empty.png"));
    public static final TextureData ARMOR_EMPTY = new TextureData(0, 0, 0, 0, 9, 9, 9, 9,
                                                                  Identifier.ofVanilla("textures/gui/sprites/hud/armor_empty.png"));
    public static final TextureData ARMOR_FULL = new TextureData(0, 0, 0, 0, 9, 9, 9, 9,
                                                                 Identifier.ofVanilla("textures/gui/sprites/hud/armor_full.png"));
    public static final TextureData ARMOR_HALF = new TextureData(0, 0, 0, 0, 9, 9, 9, 9,
                                                                 Identifier.ofVanilla("textures/gui/sprites/hud/armor_half.png"));
    public static final TextureData CROSSHAIR = new TextureData(0, 0, 0, 0, 15, 15, 15, 15,
                                                                Identifier.ofVanilla("textures/gui/sprites/hud/crosshair.png"));
    public static final TextureData CROSSHAIR_ATTACK_BACKGROUND = new TextureData(0, 0, 0, 0, 16, 4, 16, 4,
                                                                                  Identifier.ofVanilla("textures/gui/sprites/hud/crosshair_attack_indicator_background.png"));
    public static final TextureData CROSSHAIR_ATTACK_FULL = new TextureData(0, 0, 0, 0, 16, 16, 16, 16,
                                                                            Identifier.ofVanilla("textures/gui/sprites/hud/crosshair_attack_indicator_full.png"));
    public static final TextureData CROSSHAIR_ATTACK_PROGRESS = new TextureData(0, 0, 0, 0, 16, 4, 16, 4,
                                                                                Identifier.ofVanilla("textures/gui/sprites/hud/crosshair_attack_indicator_progress.png"));
    public static final TextureData EFFECT_BACKGROUND = new TextureData(0, 0, 0, 0, 24, 24, 24, 24,
                                                                        Identifier.ofVanilla("textures/gui/sprites/hud/effect_background.png"));
    public static final TextureData EFFECT_BACKGROUND_AMBIENT = new TextureData(0, 0, 0, 0, 24, 24, 24, 24,
                                                                                Identifier.ofVanilla("textures/gui/sprites/hud/effect_background_ambient.png"));
    public static final TextureData XP_BACKGROUND = new TextureData(0, 0, 0, 0, 182, 5, 182, 5,
                                                                    Identifier.ofVanilla("textures/gui/sprites/hud/experience_bar_background.png"));
    public static final TextureData XP_BAR = new TextureData(0, 0, 0, 0, 182, 5, 182, 5,
                                                             Identifier.ofVanilla("textures/gui/sprites/hud/experience_bar_progress.png"));
    public static final TextureData FOOD_EMPTY = new TextureData(0, 0, 0, 0, 9, 9, 9, 9,
                                                                 Identifier.ofVanilla("textures/gui/sprites/hud/food_empty.png"));
    public static final TextureData FOOD_EMPTY_HUNGER = new TextureData(0, 0, 0, 0, 9, 9, 9, 9,
                                                                        Identifier.ofVanilla("textures/gui/sprites/hud/food_empty_hunger.png"));
    public static final TextureData FOOD_FULL = new TextureData(0, 0, 0, 0, 9, 9, 9, 9,
                                                                Identifier.ofVanilla("textures/gui/sprites/hud/food_full.png"));
    public static final TextureData FOOD_FULL_HUNGER = new TextureData(0, 0, 0, 0, 9, 9, 9, 9,
                                                                       Identifier.ofVanilla("textures/gui/sprites/hud/food_full_hunger.png"));
    public static final TextureData FOOD_HALF = new TextureData(0, 0, 0, 0, 9, 9, 9, 9,
                                                                Identifier.ofVanilla("textures/gui/sprites/hud/food_half.png"));
    public static final TextureData FOOD_HALF_HUNGER = new TextureData(0, 0, 0, 0, 9, 9, 9, 9,
                                                                       Identifier.ofVanilla("textures/gui/sprites/hud/food_half_hunger.png"));
    public static final TextureData HOTBAR = new TextureData(0, 0, 0, 0, 182, 22, 182, 22,
                                                             Identifier.ofVanilla("textures/gui/sprites/hud/hotbar.png"));
    public static final TextureData HOTBAR_ATTACK_BACKGROUND = new TextureData(0, 0, 0, 0, 18, 18, 18, 18,
                                                                               Identifier.ofVanilla("textures/gui/sprites/hud/hotbar_attack_indicator_background.png"));
    public static final TextureData HOTBAR_ATTACK_PROGRESS = new TextureData(0, 0, 0, 0, 18, 18, 18, 18,
                                                                             Identifier.ofVanilla("textures/gui/sprites/hud/hotbar_attack_indicator_progress.png"));
    public static final TextureData HOTBAR_OFFHAND_LEFT = new TextureData(0, 0, 0, 1, 22, 22, 29, 24,
                                                                          Identifier.ofVanilla("textures/gui/sprites/hud/hotbar_offhand_left.png"));
    public static final TextureData HOTBAR_OFFHAND_RIGHT = new TextureData(0, 0, 7, 1, 22, 22, 29, 24,
                                                                           Identifier.ofVanilla("textures/gui/sprites/hud/hotbar_offhand_right.png"));
    public static final TextureData HOTBAR_SELECTION = new TextureData(0, 0, 0, 0, 24, 23, 24, 23,
                                                                       Identifier.ofVanilla("textures/gui/sprites/hud/hotbar_selection.png"));
}