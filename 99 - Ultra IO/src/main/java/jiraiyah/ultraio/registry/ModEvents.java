package jiraiyah.ultraio.registry;

import jiraiyah.jibase.exceptions.Exceptions;
import jiraiyah.ultraio.event.*;
import net.fabricmc.fabric.api.entity.event.v1.ServerEntityCombatEvents;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;

import static jiraiyah.ultraio.Main.LOGGER;

public class ModEvents
{
    public ModEvents()
    {
        Exceptions.throwCtorAssertion();
    }

    public static void init()
    {
        LOGGER.logEventInit();

        LootTableModifiers.init();
        ServerPlayerEquipChangeListener.register();
        PlayerBlockBreakEvents.BEFORE.register(new BeforePlayerBlockBreakListener());
        ServerEntityCombatEvents.AFTER_KILLED_OTHER_ENTITY.register(new KillingEntityListener());
        UseEntityCallbackListener.init();
    }
}