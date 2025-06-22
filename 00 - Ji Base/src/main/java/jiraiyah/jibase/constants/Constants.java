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

@SuppressWarnings("unused")
@Developer("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/drkhodakarami/___PROJECTS___")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")

public class Constants
{
    public static class Invevntory
    {
        public static int DEFAULT_OUTPUT_SIZE = 1;
        public static Direction DEFAULT_OUTPUT_DIRECTION = Direction.DOWN;
    }

    public static class Fluid
    {
        public static class ContainerCapacity
        {
            public static class SizeBased
            {
                // Default fluid capacities in terms of buckets
                public static long DEFAULT = FluidConstants.BUCKET * 20;
                public static long SMALL = FluidConstants.BUCKET * 10;
                public static long MEDIUM = FluidConstants.BUCKET * 50;
                public static long LARGE = FluidConstants.BUCKET * 100;
                public static long XLARGE = FluidConstants.BUCKET * 250;
            }

            public static class MaterialBased
            {
                // Specific material-based fluid capacities
                public static long WOOD = FluidConstants.BUCKET * 4;
                public static long STONE = FluidConstants.BUCKET * 16;
                public static long COPPER = FluidConstants.BUCKET * 40;
                public static long IRON = FluidConstants.BUCKET * 80;
                public static long GOLD = FluidConstants.BUCKET * 120;
                public static long OBSIDIAN = FluidConstants.BUCKET * 160;
                public static long DIAMOND = FluidConstants.BUCKET * 200;
                public static long EMERALD = FluidConstants.BUCKET * 280;
                public static long STAR = FluidConstants.BUCKET * 360;
                public static long NETHERITE = FluidConstants.BUCKET * 500;
                public static long END = FluidConstants.BUCKET * 800;
            }
        }

        // Conversion factor for milli-buckets (mB)
        public static long MILLI_BUCKET = FluidConstants.BUCKET / 1000;
    }

    public static class Energy
    {
        public static int DEFAULT_CAPACITY = 100_000;
        public static int DEFAULT_MAX_INSERT = 1000;
        public static int DEFAULT_MAX_EXTRACT = 1000;
        public static int DEFAULT_NORMAL_INSERT = 100;
        public static int DEFAULT_NORMAL_EXTRACT = 100;
    }

    public Constants()
    {
        Exceptions.throwCtorAssertion();
    }
}