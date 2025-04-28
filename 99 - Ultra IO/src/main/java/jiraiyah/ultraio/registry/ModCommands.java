package jiraiyah.ultraio.registry;

import jiraiyah.jibase.exceptions.Exceptions;
import jiraiyah.ultraio.command.DclrCommand;

import static jiraiyah.ultraio.Main.LOGGER;

public class ModCommands
{
    public ModCommands()
    {
        Exceptions.throwCtorAssertion();
    }

    public static void init()
    {
        LOGGER.logCommandInit();

        DclrCommand.init();
    }
}