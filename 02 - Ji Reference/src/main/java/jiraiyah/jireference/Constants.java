package jiraiyah.jireference;

import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.minecraft.util.math.Direction;

@SuppressWarnings("unused")
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
}