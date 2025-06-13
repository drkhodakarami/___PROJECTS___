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
public class TabTextures
{
    public static final TextureData TOP_NORMAL = new TextureData(0, 0, 0, 0, 23, 20, 32, 32,
                                                                 BaseHelper.identifier("jigui", "textures/gui/container/tab_top_normal.png"));
    public static final TextureData TOP_SELECTED = new TextureData(0, -5, 0, 0, 23, 27, 32, 32,
                                                                   BaseHelper.identifier("jigui", "textures/gui/container/tab_top_selected.png"));
    public static final TextureData BOTTOM_NORMAL = new TextureData(0, 0, 0, 0, 23, 20, 32, 32,
                                                                    BaseHelper.identifier("jigui", "textures/gui/container/tab_bottom_normal.png"));
    public static final TextureData BOTTOM_SELECTED = new TextureData(0, -2, 0, 0, 23, 27, 32, 32,
                                                                      BaseHelper.identifier("jigui", "textures/gui/container/tab_bottom_selected.png"));
    public static final TextureData LEFT_NORMAL = new TextureData(0, 0, 0, 0, 20, 23, 32, 32,
                                                                  BaseHelper.identifier("jigui", "textures/gui/container/tab_left_normal.png"));
    public static final TextureData LEFT_SELECTED = new TextureData(-5, 0, 0, 0, 27, 23, 32, 32,
                                                                    BaseHelper.identifier("jigui", "textures/gui/container/tab_left_selected.png"));
    public static final TextureData RIGHT_NORMAL = new TextureData(0, 0, 0, 0, 20, 23, 32, 32,
                                                                   BaseHelper.identifier("jigui", "textures/gui/container/tab_right_normal.png"));
    public static final TextureData RIGHT_SELECTED = new TextureData(-2, 0, 0, 0, 27, 23, 32, 32,
                                                                     BaseHelper.identifier("jigui", "textures/gui/container/tab_right_selected.png"));
}