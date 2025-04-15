package jiraiyah.ultraio.registry;

import jiraiyah.jiralib.record.CoordinateDataPayload;
import net.minecraft.component.ComponentType;

import static jiraiyah.ultraio.Main.JCOMPONENT_TYPE;
import static jiraiyah.ultraio.Main.LOGGER;

public class ModDataComponentTypes
{
    public static ComponentType<CoordinateDataPayload> COORDINATE;

    public ModDataComponentTypes()
    {
        throw new AssertionError("This class should not be instantiated");
    }

    public static void init()
    {
        LOGGER.logDataComponentInit();
        COORDINATE = JCOMPONENT_TYPE.register("coordinates", builder -> builder.codec(CoordinateDataPayload.CODEC));
    }
}