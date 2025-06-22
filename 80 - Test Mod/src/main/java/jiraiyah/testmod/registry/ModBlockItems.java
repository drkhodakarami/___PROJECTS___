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
import net.minecraft.item.BlockItem;

import static jiraiyah.testmod.Main.LOGGER;
import static jiraiyah.testmod.Main.JBLOCK_ITEM;

public class ModBlockItems
{
    public static BlockItem
            GUI_1, GUI_2, GUI_3, GUI_4, GUI_5, GUI_6, GUI_7, GUI_8, GUI_9;

    public ModBlockItems()
    {
        Exceptions.throwCtorAssertion();
    }

    public static void init()
    {
        LOGGER.logBlockItemInit();

        GUI_1 = JBLOCK_ITEM.register(ModBlocks.GUI_1);
        GUI_2 = JBLOCK_ITEM.register(ModBlocks.GUI_2);
        GUI_3 = JBLOCK_ITEM.register(ModBlocks.GUI_3);
        GUI_4 = JBLOCK_ITEM.register(ModBlocks.GUI_4);
        GUI_5 = JBLOCK_ITEM.register(ModBlocks.GUI_5);
        GUI_6 = JBLOCK_ITEM.register(ModBlocks.GUI_6);
        GUI_7 = JBLOCK_ITEM.register(ModBlocks.GUI_7);
        GUI_8 = JBLOCK_ITEM.register(ModBlocks.GUI_8);
        GUI_9 = JBLOCK_ITEM.register(ModBlocks.GUI_9);
    }

    public static void setBlackList() {}
}