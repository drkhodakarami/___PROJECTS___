package jiraiyah.ultraio.registry;

import net.fabricmc.fabric.api.registry.FuelRegistryEvents;

import static jiraiyah.ultraio.Main.LOGGER;

public class ModFuels
{
    public ModFuels()
    {
        throw new AssertionError("This class should not be instantiated");
    }

    public static void init()
    {
        LOGGER.logFuelInit();

        FuelRegistryEvents.BUILD.register((builder, context) ->
                                          {
                                              builder.add(ModItems.HOT_COAL, context.baseSmeltTime() * 32); //6400
                                          });
    }
}