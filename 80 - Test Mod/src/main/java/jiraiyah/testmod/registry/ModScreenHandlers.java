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
import jiraiyah.jibase.records.BlockPosPayload;
import jiraiyah.testmod.screen.handler.*;
import net.minecraft.screen.ScreenHandlerType;

import static jiraiyah.testmod.Main.JSCREEN;
import static jiraiyah.testmod.Main.LOGGER;

public class ModScreenHandlers
{
    public static ScreenHandlerType<Gui_1_SH> GUI_1;
    public static ScreenHandlerType<Gui_2_SH> GUI_2;
    public static ScreenHandlerType<Gui_3_SH> GUI_3;
    public static ScreenHandlerType<Gui_4_SH> GUI_4;
    public static ScreenHandlerType<Gui_5_SH> GUI_5;
    public static ScreenHandlerType<Gui_6_SH> GUI_6;
    public static ScreenHandlerType<Gui_7_SH> GUI_7;
    public static ScreenHandlerType<Gui_8_SH> GUI_8;
    public static ScreenHandlerType<Gui_9_SH> GUI_9;

    public ModScreenHandlers()
    {
        Exceptions.throwCtorAssertion();
    }

    public static void init()
    {
        LOGGER.logScreenHandlerInit();

        GUI_1 = JSCREEN.register("gui_1_sh", Gui_1_SH::new, BlockPosPayload.PACKET_CODEC);
        GUI_2 = JSCREEN.register("gui_2_sh", Gui_2_SH::new, BlockPosPayload.PACKET_CODEC);
        GUI_3 = JSCREEN.register("gui_3_sh", Gui_3_SH::new, BlockPosPayload.PACKET_CODEC);
        GUI_4 = JSCREEN.register("gui_4_sh", Gui_4_SH::new, BlockPosPayload.PACKET_CODEC);
        GUI_5 = JSCREEN.register("gui_5_sh", Gui_5_SH::new, BlockPosPayload.PACKET_CODEC);
        GUI_6 = JSCREEN.register("gui_6_sh", Gui_6_SH::new, BlockPosPayload.PACKET_CODEC);
        GUI_7 = JSCREEN.register("gui_7_sh", Gui_7_SH::new, BlockPosPayload.PACKET_CODEC);
        GUI_8 = JSCREEN.register("gui_8_sh", Gui_8_SH::new, BlockPosPayload.PACKET_CODEC);
        GUI_9 = JSCREEN.register("gui_9_sh", Gui_9_SH::new, BlockPosPayload.PACKET_CODEC);
    }
}