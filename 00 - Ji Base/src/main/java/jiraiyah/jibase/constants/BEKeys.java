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

package jiraiyah.jibase.constants;

import jiraiyah.jibase.annotations.*;
import jiraiyah.jibase.exceptions.Exceptions;

@Developer("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/drkhodakarami/___PROJECTS___")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")

public class BEKeys
{
    public static final String ENERGY_AMOUNT = ".be.energy.amount";
    public static final String ENERGY_CAPACITY = ".be.energy.capacity";
    public static final String HAS_ENERGY = ".be.has.energy";
    public static final String FLUID_AMOUNT = ".be.fluid.amount";
    public static final String FLUID_CAPACITY = ".be.fluid.capacity";
    public static final String HAS_FLUID = ".be.has.fluid";
    public static final String PROGRESS_AMOUNT = ".be.progress.amount";
    public static final String PROGRESS_MAX = ".be.progress.max";
    public static final String COOLDOWN_AMOUNT = ".be.cooldown.amount";
    public static final String COOLDOWN_MAX = ".be.cooldown.max";
    public static final String BURN_AMOUNT = ".be.burn.amount";
    public static final String BURN_MAX = ".be.burn.max";
    public static final String HAS_INVENTORY = ".be.has.inventory";
    public static final String IS_DIRTY ="is.dirty";
    public static final String IS_DIRTY_CLIENT ="is.dirty.client";
    public static final String WORLD ="world";
    public static final String POS ="pos";
    public static final String CACHED_STATE ="cached.state";
    public static final String TICKS ="ticks";
    public static final String TICKS_CLIENT ="ticks.client";

    BEKeys()
    {
        Exceptions.throwCtorAssertion();
    }
}