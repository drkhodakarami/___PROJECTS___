package jiraiyah.ultraio.registry;

import jiraiyah.ultraio.effect.FlightEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.entry.RegistryEntry;

import static jiraiyah.ultraio.Main.JSTATUS_EFFECT;

public class ModEffects
{
    public static RegistryEntry<StatusEffect> FLIGHT_EFFECT;

    public ModEffects()
    {
        throw new AssertionError("This class should not be instantiated");
    }

    public static void init()
    {
        FLIGHT_EFFECT = JSTATUS_EFFECT.register("flight", StatusEffectCategory.BENEFICIAL, 0xFFFFFF, FlightEffect::new);
    }
}