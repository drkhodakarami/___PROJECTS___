package jiraiyah.ultraio.registry;

import jiraiyah.jibase.exceptions.Exceptions;

import static jiraiyah.ultraio.Main.LOGGER;

public class ModWorldGeneration
{
    public ModWorldGeneration()
    {
        Exceptions.throwCtorAssertion();
    }

    public static void init()
    {
        LOGGER.logWorldGenerationInit();

        ModOreGeneration.init();
    }
}