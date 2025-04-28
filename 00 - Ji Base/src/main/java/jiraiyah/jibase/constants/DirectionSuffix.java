package jiraiyah.jibase.constants;

import jiraiyah.jibase.annotations.*;
import jiraiyah.jibase.exceptions.Exceptions;

@Developer("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/drkhodakarami/___PROJECTS___")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")

public class DirectionSuffix
{
    public static final String NORTH = ".north";
    public static final String SOUTH = ".south";
    public static final String WEST = ".west";
    public static final String EAST = ".east";
    public static final String TOP = ".top";
    public static final String BOTTOM = ".bottom";
    public static final String NO_DIRECTION = ".no.direction";

    DirectionSuffix()
    {
        Exceptions.throwCtorAssertion();
    }
}