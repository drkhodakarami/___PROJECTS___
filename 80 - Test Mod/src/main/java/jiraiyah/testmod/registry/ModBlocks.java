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

package jiraiyah.testmod.registry;

import jiraiyah.jibase.exceptions.Exceptions;
import jiraiyah.testmod.block.gui.*;
import net.minecraft.block.*;

import java.util.ArrayList;
import java.util.List;

import static jiraiyah.testmod.Main.LOGGER;
import static jiraiyah.testmod.Main.JBLOCK;

public class ModBlocks
{
    public static final List<Block> BLACK_LIST = new ArrayList<>();

    public static Gui1 GUI_1;
    public static Gui2 GUI_2;
    public static Gui3 GUI_3;
    public static Gui4 GUI_4;
    public static Gui5 GUI_5;
    public static Gui6 GUI_6;
    public static Gui7 GUI_7;
    public static Gui8 GUI_8;
    public static Gui9 GUI_9;

    public ModBlocks()
    {
        Exceptions.throwCtorAssertion();
    }

    public static void init()
    {
        LOGGER.logBlockInit();

        GUI_1 = JBLOCK.register("gui_1", Blocks.GRAY_WOOL, Gui1::new);
        GUI_2 = JBLOCK.register("gui_2", Blocks.GRAY_WOOL, Gui2::new);
        GUI_3 = JBLOCK.register("gui_3", Blocks.GRAY_WOOL, Gui3::new);
        GUI_4 = JBLOCK.register("gui_4", Blocks.GRAY_WOOL, Gui4::new);
        GUI_5 = JBLOCK.register("gui_5", Blocks.GRAY_WOOL, Gui5::new);
        GUI_6 = JBLOCK.register("gui_6", Blocks.GRAY_WOOL, Gui6::new);
        GUI_7 = JBLOCK.register("gui_7", Blocks.GRAY_WOOL, Gui7::new);
        GUI_8 = JBLOCK.register("gui_8", Blocks.GRAY_WOOL, Gui8::new);
        GUI_9 = JBLOCK.register("gui_9", Blocks.GRAY_WOOL, Gui9::new);
    }

    public static void setBlackList() {}
}