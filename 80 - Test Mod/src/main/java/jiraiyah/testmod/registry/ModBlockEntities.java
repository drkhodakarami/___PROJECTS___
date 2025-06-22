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
import jiraiyah.testmod.blockentity.gui.*;
import net.minecraft.block.entity.BlockEntityType;

import static jiraiyah.testmod.Main.LOGGER;
import static jiraiyah.testmod.Main.JENTITY;

public class ModBlockEntities
{
    public static BlockEntityType<GuiBE1> GUI_1;
    public static BlockEntityType<GuiBE2> GUI_2;
    public static BlockEntityType<GuiBE3> GUI_3;
    public static BlockEntityType<GuiBE4> GUI_4;
    public static BlockEntityType<GuiBE5> GUI_5;
    public static BlockEntityType<GuiBE6> GUI_6;
    public static BlockEntityType<GuiBE7> GUI_7;
    public static BlockEntityType<GuiBE8> GUI_8;
    public static BlockEntityType<GuiBE9> GUI_9;

    public ModBlockEntities()
    {
        Exceptions.throwCtorAssertion();
    }

    public static void init()
    {
        LOGGER.logBlockEntityInit();

        GUI_1 = JENTITY.register("gui_1_be", ModBlocks.GUI_1, GuiBE1::new);
        GUI_2 = JENTITY.register("bridge_goo", ModBlocks.GUI_2, GuiBE2::new);
        GUI_3 = JENTITY.register("chunk_goo", ModBlocks.GUI_3, GuiBE3::new);
        GUI_4 = JENTITY.register("chunk_bomb_goo", ModBlocks.GUI_4, GuiBE4::new);
        GUI_5 = JENTITY.register("lava_eating_goo", ModBlocks.GUI_5, GuiBE5::new);
        GUI_6 = JENTITY.register("lava_generating_goo", ModBlocks.GUI_6, GuiBE6::new);
        GUI_7 = JENTITY.register("lava_pump_goo", ModBlocks.GUI_7, GuiBE7::new);
        GUI_8 = JENTITY.register("stone_bomb_goo", ModBlocks.GUI_8, GuiBE8::new);
        GUI_9 = JENTITY.register("towering_goo", ModBlocks.GUI_9, GuiBE9::new);

        //ItemStorage.SIDED.registerForBlockEntity(GemCleanerBE::getInventoryProvider, GEM_CLEANER);
    }
}