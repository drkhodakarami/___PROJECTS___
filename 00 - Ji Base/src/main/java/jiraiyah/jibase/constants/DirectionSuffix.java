package jiraiyah.jibase.constants;

import jiraiyah.jibase.annotations.*;

@Developer("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/drkhodakarami/___PROJECTS___")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")

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