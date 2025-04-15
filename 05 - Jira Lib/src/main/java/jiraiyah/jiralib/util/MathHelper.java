package jiraiyah.jiralib.util;

import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.world.World;

import java.util.function.Predicate;

public class MathHelper
{
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

    public static float getChance(int value)
    {
        return (100 - value) / 100f;
    }

    public static boolean getChance(World world, int value)
    {
        return world.getRandom().nextFloat() >= getChance(value);
    }
}