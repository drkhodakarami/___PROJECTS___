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

package jiraiyah.ultraio.registry;

import jiraiyah.jibase.exceptions.Exceptions;
import jiraiyah.ultraio.event.*;
import net.fabricmc.fabric.api.entity.event.v1.ServerEntityCombatEvents;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;

import static jiraiyah.ultraio.Main.LOGGER;

public class ModEvents
{
    public ModEvents()
    {
        Exceptions.throwCtorAssertion();
    }

    public static void init()
    {
        LOGGER.logEventInit();

        LootTableModifiers.init();
        ServerPlayerEquipChangeListener.register();
        PlayerBlockBreakEvents.BEFORE.register(new BeforePlayerBlockBreakListener());
        ServerEntityCombatEvents.AFTER_KILLED_OTHER_ENTITY.register(new KillingEntityListener());
        UseEntityCallbackListener.init();
    }
}