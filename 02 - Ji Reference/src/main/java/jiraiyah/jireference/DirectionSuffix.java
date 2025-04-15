package jiraiyah.jireference;

/**
 * The {@code DirectionSuffix} class provides a set of constants representing
 * suffixes for different directions. These constants can be used to append
 * direction-specific suffixes to strings, typically for naming or identification
 * purposes in applications that require directional context.
 * <p>
 * This class is not intended to be instantiated, as it only contains static
 * members and a private constructor that throws an {@code AssertionError}.
 */
@SuppressWarnings("unused")
public class DirectionSuffix
{
    /**
     * Suffix for the north direction.
     */
    public static final String NORTH = ".north";
    /**
     * Suffix for the south direction.
     */
    public static final String SOUTH = ".south";
    /**
     * Suffix for the west direction.
     */
    public static final String WEST = ".west";
    /**
     * Suffix for the east direction.
     */
    public static final String EAST = ".east";
    /**
     * Suffix for the top direction.
     */
    public static final String TOP = ".top";
    /**
     * Suffix for the bottom direction.
     */
    public static final String BOTTOM = ".bottom";
    /**
     * Suffix indicating no specific direction.
     */
    public static final String NO_DIRECTION = ".no.direction";

    /**
     * Private constructor to prevent instantiation of this utility class.
     * <p>
     * Throws an {@code AssertionError} if called, as this class is intended
     * to be used statically.
     */
    DirectionSuffix()
    {
        throw new AssertionError();
    }
}