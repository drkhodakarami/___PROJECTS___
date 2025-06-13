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
import jiraiyah.jibase.utils.BaseHelper;
import jiraiyah.jigui.client.records.TextureData;
import net.minecraft.util.Identifier;

@Developer("Jiraiyah")
@CreatedAt("2025-04-18")
@ModifiedAt("2025-04-23")
@Repository("https://github.com/drkhodakarami/___PROJECTS___")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")
public class ToggleButtonTextures
{
    public static class Normal
    {
        public static final TextureData OFF = new TextureData(0, 0, 0, 0, 32, 16, 32, 16,
                                                              BaseHelper.identifier("jigui", "textures/gui/widget/toggle_switch_off.png"));
        public static final TextureData ON = new TextureData(0, 0, 0, 0, 32, 16, 32, 16,
                                                             BaseHelper.identifier("jigui", "textures/gui/widget/toggle_switch_on.png"));
        public static final TextureData OFF_HOVERED = new TextureData(0, 0, 0, 0, 32, 16, 32, 16,
                                                                      BaseHelper.identifier("jigui", "textures/gui/widget/selected_toggle_switch_off.png"));
        public static final TextureData ON_HOVERED = new TextureData(0, 0, 0, 0, 32, 16, 32, 16,
                                                                     BaseHelper.identifier("jigui", "textures/gui/widget/selected_toggle_switch_on.png"));
    }

    public static class Colored
    {
        public static final TextureData OFF = new TextureData(0, 0, 0, 0, 32, 16, 32, 16,
                                                              BaseHelper.identifier("jigui", "textures/gui/widget/toggle_switch_green_on.png"));
        public static final TextureData ON = new TextureData(0, 0, 0, 0, 32, 16, 32, 16,
                                                             BaseHelper.identifier("jigui", "textures/gui/widget/toggle_switch_red_off.png"));
        public static final TextureData OFF_HOVERED = new TextureData(0, 0, 0, 0, 32, 16, 32, 16,
                                                                      BaseHelper.identifier("jigui", "textures/gui/widget/selected_toggle_switch_green_on.png"));
        public static final TextureData ON_HOVERED = new TextureData(0, 0, 0, 0, 32, 16, 32, 16,
                                                                     BaseHelper.identifier("jigui", "textures/gui/widget/selected_toggle_switch_red_off.png"));
    }
}