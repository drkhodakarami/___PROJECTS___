package jiraiyah.jiralib.interfaces;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

// Author: turtywurty
// https://github.com/DaRealTurtyWurty/Industria
public interface ITick
{
    void tick();
    void tickClient();

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