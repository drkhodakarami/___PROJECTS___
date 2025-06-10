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

package jiraiyah.jibase.utils;

import jiraiyah.jibase.annotations.*;
import jiraiyah.jibase.exceptions.Exceptions;
import net.minecraft.world.World;

import java.util.Random;
import java.util.function.Predicate;

@Developer("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/drkhodakarami/___PROJECTS___")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")

public class MathHelper
{
    private static final Random rand = new Random();

    public MathHelper()
    {
        Exceptions.throwCtorAssertion();
    }

    public static double nextDouble(double min, double max) {
        return min + (max - min) * rand.nextDouble();
    }

    public static int nextInt(int min, int max) {
        return min + (max - min) * rand.nextInt();
    }

    public static float nextFloat(float min, float max) {
        return min + (max - min) * rand.nextFloat();
    }

    public static Predicate<Integer> countEquals(int value)
    {
        return count -> count == value;
    }
    public static Predicate<Integer> countLessThan(int value)
    {
        return count -> count < value;
    }

    public static Predicate<Integer> countLessThanOrEquals(int value)
    {
        return count -> count <= value;
    }

    public static Predicate<Integer> countGreaterThan(int value)
    {
        return count -> count > value;
    }

    public static Predicate<Integer> countGreaterThanOrEquals(int value)
    {
        return count -> count >= value;
    }

    public static Predicate<Float> countEquals(float value)
    {
        return count -> count == value;
    }
    public static Predicate<Float> countLessThan(float value)
    {
        return count -> count < value;
    }

    public static Predicate<Float> countLessThanOrEquals(float value)
    {
        return count -> count <= value;
    }

    public static Predicate<Float> countGreaterThan(float value)
    {
        return count -> count > value;
    }

    public static Predicate<Float> countGreaterThanOrEquals(float value)
    {
        return count -> count >= value;
    }

    public static Predicate<Double> countEquals(double value)
    {
        return count -> count == value;
    }
    public static Predicate<Double> countLessThan(double value)
    {
        return count -> count < value;
    }

    public static Predicate<Double> countLessThanOrEquals(double value)
    {
        return count -> count <= value;
    }

    public static Predicate<Double> countGreaterThan(double value)
    {
        return count -> count > value;
    }

    public static Predicate<Double> countGreaterThanOrEquals(double value)
    {
        return count -> count >= value;
    }

    public static float getReverseChance(int value)
    {
        return (100 - value) / 100f;
    }

    public static boolean getChance(int value)
    {
        return rand.nextFloat() >= getReverseChance(value);
    }
}