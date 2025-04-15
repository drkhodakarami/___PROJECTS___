package jiraiyah.ultraio.registry;

import jiraiyah.ultraio.command.DclrCommand;

import static jiraiyah.ultraio.Main.LOGGER;

public class ModCommands
{
    public ModCommands()
    {
        throw new AssertionError("This class should not be instantiated");
    }

    public static void init()
    {
        LOGGER.logCommandInit();

        DclrCommand.init();
    }
}