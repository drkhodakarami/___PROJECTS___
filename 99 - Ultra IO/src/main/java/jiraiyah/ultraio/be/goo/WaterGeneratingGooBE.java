package jiraiyah.ultraio.be.goo;

import jiraiyah.jibase.interfaces.ITickLogic;
import jiraiyah.jibase.properties.BEProperties;
import jiraiyah.jibase.properties.BlockEntityFields;
import jiraiyah.jiralib.blockentity.TickableBE;
import jiraiyah.ultraio.registry.ModBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class WaterGeneratingGooBE extends TickableBE<WaterGeneratingGooBE>
{
    public WaterGeneratingGooBE(BlockPos pos, BlockState state)
    {
        super(ModBlockEntities.WATER_GENERATING_GOO, pos, state);
        this.properties.tickLogic(new TickLogic());
    }

    //TODO: Make the tick logic not an inner class but an actual class of itself
    static class TickLogic implements ITickLogic<WaterGeneratingGooBE, BlockEntityFields<WaterGeneratingGooBE>>
    {

        @Override
        public void tick(BEProperties<WaterGeneratingGooBE> properties)
        {

        }

        @Override
        public void tickClient(BEProperties<WaterGeneratingGooBE> properties)
        {

        }
    }
}