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
public class IndicatorLightTextures
{
    public static class Alarm
    {
        public static final TextureData BLACK =
                new TextureData(0, 0, 0, 0, 13, 13, 16, 16,
                                BaseHelper.identifier("jigui", "textures/gui/icon/alarm_black.png"));
        public static final TextureData BLUE =
                new TextureData(0, 0, 0, 0, 13, 13, 16, 16,
                                BaseHelper.identifier("jigui", "textures/gui/icon/alarm_blue.png"));
        public static final TextureData CYAN =
                new TextureData(0, 0, 0, 0, 13, 13, 16, 16,
                                BaseHelper.identifier("jigui", "textures/gui/icon/alarm_cyan.png"));
        public static final TextureData GRAY =
                new TextureData(0, 0, 0, 0, 13, 13, 16, 16,
                                BaseHelper.identifier("jigui", "textures/gui/icon/alarm_gray.png"));
        public static final TextureData GREEN =
                new TextureData(0, 0, 0, 0, 13, 13, 16, 16,
                                BaseHelper.identifier("jigui", "textures/gui/icon/alarm_green.png"));
        public static final TextureData ORANGE =
                new TextureData(0, 0, 0, 0, 13, 13, 16, 16,
                                BaseHelper.identifier("jigui", "textures/gui/icon/alarm_orange.png"));
        public static final TextureData PINK =
                new TextureData(0, 0, 0, 0, 13, 13, 16, 16,
                                BaseHelper.identifier("jigui", "textures/gui/icon/alarm_pink.png"));
        public static final TextureData PURPLE =
                new TextureData(0, 0, 0, 0, 13, 13, 16, 16,
                                BaseHelper.identifier("jigui", "textures/gui/icon/alarm_purple.png"));
        public static final TextureData RED =
                new TextureData(0, 0, 0, 0, 13, 13, 16, 16,
                                BaseHelper.identifier("jigui", "textures/gui/icon/alarm_red.png"));
        public static final TextureData WHITE =
                new TextureData(0, 0, 0, 0, 13, 13, 16, 16,
                                BaseHelper.identifier("jigui", "textures/gui/icon/alarm_white.png"));
        public static final TextureData YELLOW =
                new TextureData(0, 0, 0, 0, 13, 13, 16, 16,
                                BaseHelper.identifier("jigui", "textures/gui/icon/alarm_yellow.png"));
    }
}