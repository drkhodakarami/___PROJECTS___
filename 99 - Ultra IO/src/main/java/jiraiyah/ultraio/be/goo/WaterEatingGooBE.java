package jiraiyah.ultraio.be.goo;

import jiraiyah.jiralib.blockentity.NoScreenUpdatableBE;
import jiraiyah.jiralib.interfaces.ITick;
import jiraiyah.ultraio.registry.ModBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class WaterEatingGooBE extends NoScreenUpdatableBE implements ITick
{
    public WaterEatingGooBE(BlockPos pos, BlockState state)
    {
        super(ModBlockEntities.WATER_EATING_GOO, pos, state);
    }

    //TODO : Add Functionality
    @Override
    public void tick()
    {

    }

    @Override
    public void tickClient()
    {}
}