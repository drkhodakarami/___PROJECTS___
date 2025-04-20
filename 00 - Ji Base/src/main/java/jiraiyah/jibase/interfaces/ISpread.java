package jiraiyah.jibase.interfaces;

import jiraiyah.jibase.annotations.*;
import net.fabricmc.fabric.api.transfer.v1.transaction.Transaction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Set;

@Developer("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/drkhodakarami/___PROJECTS___")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")

public interface ISpread<T, B>
{
    long simulateInsersion(T storage, long amount, Transaction outer);

    default void spread(World world, BlockPos pos, B storage)
    {
        spread(world, pos, storage, null);
    }

    default void spread(World world, BlockPos pos, B storage, Set<BlockPos> exceptions)
    {
        spread(world, pos, storage, exceptions, true);
    }

    default void spread(World world, BlockPos pos, B storage, boolean equalAmount)
    {
        spread(world, pos, storage, null, equalAmount);
    }

    void spread(World world, BlockPos pos, B storage, Set<BlockPos> exceptions, boolean equalAmount);
}