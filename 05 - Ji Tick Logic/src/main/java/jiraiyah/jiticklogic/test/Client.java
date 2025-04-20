package jiraiyah.jiticklogic.test;

import net.fabricmc.api.ClientModInitializer;

import static jiraiyah.jiticklogic.test.Main.LOGGER;

public class Client implements ClientModInitializer
{
    @Override
    public void onInitializeClient()
    {
        LOGGER.logClient();
    }
}