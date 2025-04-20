package jiraiyah.jibase.interfaces;

import jiraiyah.jibase.annotations.*;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

@Developer("TurtyWurty")
@ModifiedBy("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/DaRealTurtyWurty/Industria")
@Discord("https://discord.turtywurty.dev/")
@Youtube("https://www.youtube.com/@TurtyWurty")

public interface ITick
{
    void tick();
    default void tickClient(){}

    static <T extends BlockEntity> BlockEntityTicker<T> createTicker(World world)
    {
        return !world.isClient
               ? (pworld, pos, state, entity) -> ((ITick) entity).tick()
               : (pworld, pos, state, entity) -> ((ITick) entity).tickClient();
    }

    default BlockState getState(World world, BlockPos pos)
    {
        return world != null ? world.getBlockState(pos) : null;
    }
}