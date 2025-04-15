package jiraiyah.jiralib.blockentity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;

public abstract class NoScreenUpdatableEndTickBE extends NoScreenUpdatableBE
{

    public NoScreenUpdatableEndTickBE(BlockEntityType<?> type, BlockPos pos, BlockState state)
    {
        super(type, pos, state);
    }

    @Override
    public boolean shouldWaitEndTick()
    {
        return true;
    }
}