package jiraiyah.ultraio.be.goo;

import jiraiyah.jibase.interfaces.ITickLogic;
import jiraiyah.jibase.properties.BEProperties;
import jiraiyah.jibase.properties.BlockEntityFields;
import jiraiyah.jiralib.blockentity.TickableBE;
import jiraiyah.ultraio.registry.ModBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class WaterPumpGooBE extends TickableBE<WaterPumpGooBE>
{
    public WaterPumpGooBE(BlockPos pos, BlockState state)
    {
        super(ModBlockEntities.WATER_PUMP_GOO, pos, state);
        this.properties.tickLogic(new TickLogic());
    }

    //TODO: Make the tick logic not an inner class but an actual class of itself
    static class TickLogic implements ITickLogic<WaterPumpGooBE, BlockEntityFields<WaterPumpGooBE>>
    {

        @Override
        public void tick(BEProperties<WaterPumpGooBE> properties)
        {

        }

        @Override
        public void tickClient(BEProperties<WaterPumpGooBE> properties)
        {

        }
    }
}