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
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.minecraft.util.math.Direction;

@Developer("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/drkhodakarami/___PROJECTS___")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")

public class Constants
{
    public static int DEFAULT_OUTPUT_INDEX = 0;
    public static int DEFAULT_OUTPUT_SIZE = 1;
    public static Direction DEFAULT_OUTPUT_DIRECTION = Direction.DOWN;

    // Default fluid capacities in terms of buckets
    public static long DEFAULT_FLUID_TANK = FluidConstants.BUCKET * 10;
    public static long SMALL_FLUID_TANK = FluidConstants.BUCKET * 5;
    public static long MEDIUM_FLUID_TANK = FluidConstants.BUCKET * 25;
    public static long LARGE_FLUID_TANK = FluidConstants.BUCKET * 50;
    public static long XLARGE_FLUID_TANK = FluidConstants.BUCKET * 100;

    // Specific material-based fluid capacities
    public static long FLUID_TANK_WOOD = FluidConstants.BUCKET * 4;
    public static long FLUID_TANK_STONE = FluidConstants.BUCKET * 16;
    public static long FLUID_TANK_COPPER = FluidConstants.BUCKET * 36;
    public static long FLUID_TANK_IRON = FluidConstants.BUCKET * 64;
    public static long FLUID_TANK_OBSIDIAN = FluidConstants.BUCKET * 100;
    public static long FLUID_TANK_GOLD = FluidConstants.BUCKET * 144;
    public static long FLUID_TANK_DIAMOND = FluidConstants.BUCKET * 196;
    public static long FLUID_TANK_EMERALD = FluidConstants.BUCKET * 256;
    public static long FLUID_TANK_STAR = FluidConstants.BUCKET * 324;
    public static long FLUID_TANK_NETHERITE = FluidConstants.BUCKET * 432;
    public static long FLUID_TANK_END = FluidConstants.BUCKET * 540;

    // Conversion factor for milli-buckets (mB)
    public static long MILLI_BUCKET = FluidConstants.BUCKET / 1000;

    public static int DEFAULT_ENERGY_CAPACITY = 100_000;
    public static int DEFAULT_ENERGY_MAX_INSERT = 100;
    public static int DEFAULT_ENERGY_MAX_EXTRACT = 100;

    public Constants()
    {
        Exceptions.throwCtorAssertion();
    }
}