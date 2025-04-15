package jiraiyah.jiralib.interfaces;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.world.World;

@FunctionalInterface
public interface IBETickerFactory<T extends BlockEntity>
{
    BlockEntityTicker<T> create(World world, BlockState state, BlockEntityType<?> type);
}