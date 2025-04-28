package jiraiyah.jibase.constants;

import jiraiyah.jibase.annotations.*;
import jiraiyah.jibase.exceptions.Exceptions;

@Developer("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/drkhodakarami/___PROJECTS___")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")

public class BEKeys
{
    public static final String ENERGY_AMOUNT = ".be.energy.amount";
    public static final String ENERGY_CAPACITY = ".be.energy.capacity";
    public static final String HAS_ENERGY = ".be.has.energy";
    public static final String FLUID_AMOUNT = ".be.fluid.amount";
    public static final String FLUID_CAPACITY = ".be.fluid.capacity";
    public static final String HAS_FLUID = ".be.has.fluid";
    public static final String PROGRESS_AMOUNT = ".be.progress.amount";
    public static final String PROGRESS_MAX = ".be.progress.max";
    public static final String COOLDOWN_AMOUNT = ".be.cooldown.amount";
    public static final String COOLDOWN_MAX = ".be.cooldown.max";
    public static final String BURN_AMOUNT = ".be.burn.amount";
    public static final String BURN_MAX = ".be.burn.max";
    public static final String HAS_INVENTORY = ".be.has.inventory";
    public static final String IS_DIRTY ="is.dirty";
    public static final String IS_DIRTY_CLIENT ="is.dirty.client";
    public static final String WORLD ="world";
    public static final String POS ="pos";
    public static final String CACHED_STATE ="cached.state";
    public static final String TICKS ="ticks";
    public static final String TICKS_CLIENT ="ticks.client";

    BEKeys()
    {
        Exceptions.throwCtorAssertion();
    }
}