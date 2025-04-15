package jiraiyah.jiralib.interfaces;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

@FunctionalInterface
public interface IBEFactory<T extends BlockEntity>
{
    T create(BlockPos pos, BlockState state);
}