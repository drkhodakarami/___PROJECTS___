package jiraiyah.jiregister;

import jiraiyah.jibase.annotations.*;
import jiraiyah.jibase.utils.BaseHelper;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;

import java.util.function.BiFunction;

@Developer("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/drkhodakarami/___PROJECTS___")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")

public class JiStatusEffectRegister
{
    private final String modId;

    public JiStatusEffectRegister(String modId)
    {
        this.modId = modId;
    }

    public RegistryEntry<StatusEffect> register(String name, StatusEffectCategory category, int color,
                                               BiFunction<StatusEffectCategory, Integer, StatusEffect> factory)
    {
        RegistryKey<StatusEffect> key = BaseHelper.getKey(this.modId, name, RegistryKeys.STATUS_EFFECT);
        StatusEffect effect = factory.apply(category, color);
        return Registry.registerReference(Registries.STATUS_EFFECT, key, effect);
    }
}