package jiraiyah.jibase.constants;

import jiraiyah.jibase.annotations.*;

@Developer("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/drkhodakarami/___PROJECTS___")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")

public class BEKeys
{
    /**
     * Key for the amount of energy in a block entity.
     */
    public static final String ENERGY_AMOUNT = ".be.energy.amount";

    /**
     * Key for the energy capacity of a block entity.
     */
    public static final String ENERGY_CAPACITY = ".be.energy.capacity";

    /**
     * Key indicating whether a block entity has energy.
     */
    public static final String HAS_ENERGY = ".be.has.energy";

    /**
     * Key for the amount of fluid in a block entity.
     */
    public static final String FLUID_AMOUNT = ".be.fluid.amount";

    /**
     * Key for the fluid capacity of a block entity.
     */
    public static final String FLUID_CAPACITY = ".be.fluid.capacity";

    /**
     * Key indicating whether a block entity has fluid.
     */
    public static final String HAS_FLUID = ".be.has.fluid";

    /**
     * Key for the progress amount of a block entity.
     */
    public static final String PROGRESS_AMOUNT = ".be.progress.amount";

    /**
     * Key for the maximum progress of a block entity.
     */
    public static final String PROGRESS_MAX = ".be.progress.max";

    /**
     * Key for the cooldown amount of a block entity.
     */
    public static final String COOLDOWN_AMOUNT = ".be.cooldown.amount";

    /**
     * Key for the maximum cooldown of a block entity.
     */
    public static final String COOLDOWN_MAX = ".be.cooldown.max";

    /**
     * Key for the burn amount of a block entity.
     */
    public static final String BURN_AMOUNT = ".be.burn.amount";

    /**
     * Key for the maximum burn time of a block entity.
     */
    public static final String BURN_MAX = ".be.burn.max";

    /**
     * Key indicating whether a block entity has an inventory.
     */
    public static final String HAS_INVENTORY = ".be.has.inventory";

    public static final String IS_DIRTY ="is.dirty";

    public static final String IS_DIRTY_CLIENT ="is.dirty.client";

    public static final String WORLD ="world";

    public static final String POS ="pos";

    public static final String CACHED_STATE ="cached.state";

    public static final String TICKS ="ticks";

    public static final String TICKS_CLIENT ="ticks.client";

    /**
     * Private constructor to prevent instantiation of this utility class.
     */
    BEKeys()
    {
        throw new AssertionError();
    }
}