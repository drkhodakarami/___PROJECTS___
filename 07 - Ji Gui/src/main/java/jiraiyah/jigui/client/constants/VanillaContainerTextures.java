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
public class VanillaContainerTextures
{
    public static final TextureData BUTTON = new TextureData(0, 0, 0, 0, 22, 22, 22, 22,
                                                             Identifier.ofVanilla("textures/gui/sprites/container/beacon/button.png"));
    public static final TextureData BUTTON_DISABLED = new TextureData(0, 0, 0, 0, 22, 22, 22, 22,
                                                                      Identifier.ofVanilla("textures/gui/sprites/container/beacon/button_disabled.png"));
    public static final TextureData BUTTON_HIGHLIGHTED = new TextureData(0, 0, 0, 0, 22, 22, 22, 22,
                                                                         Identifier.ofVanilla("textures/gui/sprites/container/beacon/button_highlighted.png"));
    public static final TextureData BUTTON_SELECTED = new TextureData(0, 0, 0, 0, 22, 22, 22, 22,
                                                                      Identifier.ofVanilla("textures/gui/sprites/container/beacon/button_selected.png"));

    public static final TextureData CANCEL = new TextureData(0, 0, 2, 3, 13, 13, 18, 18,
                                                             Identifier.ofVanilla("textures/gui/sprites/container/beacon/cancel.png"));
    public static final TextureData CONFIRM = new TextureData(0, 0, 1, 4, 14, 12, 18, 18,
                                                              Identifier.ofVanilla("textures/gui/sprites/container/beacon/confirm.png"));

    public static final TextureData DOT_BLUE = new TextureData(0, 0, 0, 0, 6, 6, 6, 6,
                                                               Identifier.ofVanilla("textures/gui/sprites/container/bundle/bundle_progressbar_fill.png"));
    public static final TextureData DOT_RED = new TextureData(0, 0, 0, 0, 6, 6, 6, 6,
                                                              Identifier.ofVanilla("textures/gui/sprites/container/bundle/bundle_progressbar_full.png"));

    public static final TextureData REDSTONE_ARROW_OFF = new TextureData(0, 0, 0, 3, 16, 11, 16, 16,
                                                                         Identifier.ofVanilla("textures/gui/sprites/container/crafter/unpowered_redstone.png"));
    public static final TextureData REDSTONE_ARROW_ON = new TextureData(0, 0, 0, 3, 16, 11, 16, 16,
                                                                        Identifier.ofVanilla("textures/gui/sprites/container/crafter/powered_redstone.png"));

    public static final TextureData SCROLLER = new TextureData(0, 0, 0, 0, 12, 15, 12, 15,
                                                               Identifier.ofVanilla("textures/gui/sprites/container/creative_inventory/scroller.png"));
    public static final TextureData SCROLLER_DISABLED = new TextureData(0, 0, 0, 0, 12, 15, 12, 15,
                                                                        Identifier.ofVanilla("textures/gui/sprites/container/creative_inventory/scroller_disabled.png"));

    public static final TextureData XP_1 = new TextureData(0, 0, 3, 3, 12, 9, 16, 16,
                                                           Identifier.ofVanilla("textures/gui/sprites/container/enchanting_table/level_1.png"));
    public static final TextureData XP_2 = new TextureData(0, -1, 3, 2, 12, 11, 16, 16,
                                                           Identifier.ofVanilla("textures/gui/sprites/container/enchanting_table/level_2.png"));
    public static final TextureData XP_3 = new TextureData(-1, -1, 2, 2, 13, 11, 16, 16,
                                                           Identifier.ofVanilla("textures/gui/sprites/container/enchanting_table/level_3.png"));

    public static final TextureData XP_1_DISABLED = new TextureData(0, 0, 4, 3, 11, 9, 16, 16,
                                                                    Identifier.ofVanilla("textures/gui/sprites/container/enchanting_table/level_1_disabled.png"));
    public static final TextureData XP_2_DISABLED = new TextureData(0, 0, 4, 3, 11, 9, 16, 16,
                                                                    Identifier.ofVanilla("textures/gui/sprites/container/enchanting_table/level_2_disabled.png"));
    public static final TextureData XP_3_DISABLED = new TextureData(-1, 0, 3, 3, 12, 9, 16, 16,
                                                                    Identifier.ofVanilla("textures/gui/sprites/container/enchanting_table/level_3_disabled.png"));

    public static final TextureData EFFECT_BACKGROUND_SMALL = new TextureData(0, 0, 0, 0, 32, 32, 32, 32,
                                                                              Identifier.ofVanilla("textures/gui/sprites/container/inventory/effect_background_small.png"));
    public static final TextureData EFFECT_BACKGROUND_LARGE = new TextureData(0, 0, 0, 0, 120, 32, 120, 32,
                                                                              Identifier.ofVanilla("textures/gui/sprites/container/inventory/effect_background_large.png"));
}