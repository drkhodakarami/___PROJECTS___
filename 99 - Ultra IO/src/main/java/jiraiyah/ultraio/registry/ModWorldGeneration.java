package jiraiyah.ultraio.registry;

import static jiraiyah.ultraio.Main.LOGGER;

public class ModWorldGeneration
{
    public static void init()
    {
        LOGGER.logWorldGenerationInit();

        ModOreGeneration.init();
    }
}