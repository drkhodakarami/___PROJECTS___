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
import jiraiyah.testmod.screen.renderer.*;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

import static jiraiyah.testmod.Main.LOGGER;

public class ModScreenRenderers
{
    public ModScreenRenderers()
    {
        Exceptions.throwCtorAssertion();
    }

    public static void init()
    {
        LOGGER.logScreenRendererInit();

        HandledScreens.register(ModScreenHandlers.GUI_1, Gui_1_SR::new);
        HandledScreens.register(ModScreenHandlers.GUI_2, Gui_2_SR::new);
        HandledScreens.register(ModScreenHandlers.GUI_3, Gui_3_SR::new);
        HandledScreens.register(ModScreenHandlers.GUI_4, Gui_4_SR::new);
        HandledScreens.register(ModScreenHandlers.GUI_5, Gui_5_SR::new);
        HandledScreens.register(ModScreenHandlers.GUI_6, Gui_6_SR::new);
        HandledScreens.register(ModScreenHandlers.GUI_7, Gui_7_SR::new);
        HandledScreens.register(ModScreenHandlers.GUI_8, Gui_8_SR::new);
        HandledScreens.register(ModScreenHandlers.GUI_9, Gui_9_SR::new);
    }
}