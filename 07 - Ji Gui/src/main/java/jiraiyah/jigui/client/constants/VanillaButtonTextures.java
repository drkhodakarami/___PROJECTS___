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
public class VanillaButtonTextures
{
    public static final TextureData BOOK = new TextureData(0, 0, 0, 0, 20, 18, 20, 18,
                                                           Identifier.ofVanilla("textures/gui/sprites/recipe_book/button.png"));
    public static final TextureData BOOK_HIGHLIGHTED = new TextureData(0, 0, 0, 0, 20, 18, 20, 18,
                                                                       Identifier.ofVanilla("textures/gui/sprites/recipe_book/button_highlighted.png"));

    public static final TextureData PAGE_LEFT = new TextureData(0, 0, 1, 0, 11, 17, 12, 17,
                                                                Identifier.ofVanilla("textures/gui/sprites/recipe_book/page_backward.png"));
    public static final TextureData PAGE_LEFT_HIGHLIGHTED = new TextureData(0, 0, 1, 0, 11, 17, 12, 17,
                                                                            Identifier.ofVanilla("textures/gui/sprites/recipe_book/page_backward_highlighted.png"));
    public static final TextureData PAGE_RIGHT = new TextureData(0, 0, 0, 0, 11, 17, 12, 17,
                                                                 Identifier.ofVanilla("textures/gui/sprites/recipe_book_table/page_forward.png"));
    public static final TextureData PAGE_RIGHT_HIGHLIGHTED = new TextureData(0, 0, 0, 0, 11, 17, 12, 17,
                                                                             Identifier.ofVanilla("textures/gui/sprites/recipe_book/page_forward_highlighted.png"));

    public static final TextureData MOVE_DOWN = new TextureData(0, 0, 18, 20, 11, 7, 32, 32,
                                                                Identifier.ofVanilla("textures/gui/sprites/transferable_list/move_down.png"));
    public static final TextureData MOVE_DOWN_HIGHLIGHTED = new TextureData(0, 0, 18, 20, 11, 7, 32, 32,
                                                                            Identifier.ofVanilla("textures/gui/sprites/transferable_list/move_down_highlighted.png"));
    public static final TextureData MOVE_UP = new TextureData(0, 0, 18, 5, 11, 7, 32, 32,
                                                              Identifier.ofVanilla("textures/gui/sprites/transferable_list/move_up.png"));
    public static final TextureData MOVE_UP_HIGHLIGHTED = new TextureData(0, 0, 18, 5, 11, 7, 32, 32,
                                                                          Identifier.ofVanilla("textures/gui/sprites/transferable_list/move_up_highlighted.png"));

    public static final TextureData ALERT = new TextureData(0, 0, 0, 0, 20, 20, 20, 20,
                                                            Identifier.ofVanilla("textures/gui/sprites/social_interaction/report_button.png"));
    public static final TextureData ALERT_DISABLED = new TextureData(0, 0, 0, 0, 20, 20, 20, 20,
                                                                     Identifier.ofVanilla("textures/gui/sprites/social_interaction/report_button_disabled.png"));
    public static final TextureData ALERT_HIGHLIGHTED = new TextureData(0, 0, 0, 0, 20, 20, 20, 20,
                                                                        Identifier.ofVanilla("textures/gui/sprites/social_interaction/report_button_highlighted.png"));

    public static final TextureData CHECKBOX = new TextureData(0, 0, 0, 0, 20, 20, 20, 20,
                                                               Identifier.ofVanilla("textures/gui/sprites/widget/checkbox.png"));
    public static final TextureData CHECKBOX_HIGHLIGHTED = new TextureData(0, 0, 0, 0, 20, 20, 20, 20,
                                                                           Identifier.ofVanilla("textures/gui/sprites/widget/checkbox_highlighted.png"));
    public static final TextureData CHECKBOX_SELECTED = new TextureData(0, 0, 0, 0, 20, 20, 20, 20,
                                                                        Identifier.ofVanilla("textures/gui/sprites/widget/checkbox_selected.png"));
    public static final TextureData CHECKBOX_SELECTED_HIGHLIGHTED = new TextureData(0, 0, 0, 0, 20, 20, 20, 20,
                                                                                    Identifier.ofVanilla("textures/gui/sprites/widget/checkbox_selected_highlighted.png"));

    public static final TextureData CROSS = new TextureData(0, 0, 0, 0, 14, 14, 14, 14,
                                                            Identifier.ofVanilla("textures/gui/sprites/widget/cross_button.png"));
    public static final TextureData CROSS_HIGHLIGHTED = new TextureData(0, 0, 0, 0, 14, 14, 14, 14,
                                                                        Identifier.ofVanilla("textures/gui/sprites/widget/cross_button_highlighted.png"));

    public static final TextureData LOCK_CLOSE = new TextureData(0, 0, 0, 0, 20, 20, 20, 20,
                                                                 Identifier.ofVanilla("textures/gui/sprites/widget/locked_button.png"));
    public static final TextureData LOCK_CLOSE_DISABLED = new TextureData(0, 0, 0, 0, 20, 20, 20, 20,
                                                                          Identifier.ofVanilla("textures/gui/sprites/widget/locked_button_disabled.png"));
    public static final TextureData LOCK_CLOSE_HIGHLIGHTED = new TextureData(0, 0, 0, 0, 20, 20, 20, 20,
                                                                             Identifier.ofVanilla("textures/gui/sprites/widget/locked_button_highlighted.png"));

    public static final TextureData LOCK_OPEN = new TextureData(0, 0, 0, 0, 20, 20, 20, 20,
                                                                Identifier.ofVanilla("textures/gui/sprites/widget/unlocked_button.png"));
    public static final TextureData LOCK_OPEN_DISABLED = new TextureData(0, 0, 0, 0, 20, 20, 20, 20,
                                                                         Identifier.ofVanilla("textures/gui/sprites/widget/unlocked_button_disabled.png"));
    public static final TextureData LOCK_OPEN_HIGHLIGHTED = new TextureData(0, 0, 0, 0, 20, 20, 20, 20,
                                                                            Identifier.ofVanilla("textures/gui/sprites/widget/unlocked_button_highlighted.png"));

    public static final TextureData PAGE_BACKWARD = new TextureData(0, 0, 3, 2, 18, 10, 23, 13,
                                                                    Identifier.ofVanilla("textures/gui/sprites/widget/page_backward.png"));
    public static final TextureData PAGE_BACKWARD_HIGHLIGHTED = new TextureData(0, 0, 3, 2, 18, 10, 23, 13,
                                                                                Identifier.ofVanilla("textures/gui/sprites/widget/page_backward_highlighted.png"));
    public static final TextureData PAGE_FORWARD = new TextureData(0, 0, 3, 2, 18, 10, 23, 13,
                                                                   Identifier.ofVanilla("textures/gui/sprites/widget/page_forward.png"));
    public static final TextureData PAGE_FORWARD_HIGHLIGHTED = new TextureData(0, 0, 3, 2, 18, 10, 23, 13,
                                                                               Identifier.ofVanilla("textures/gui/sprites/widget/page_forward_highlighted.png"));
}