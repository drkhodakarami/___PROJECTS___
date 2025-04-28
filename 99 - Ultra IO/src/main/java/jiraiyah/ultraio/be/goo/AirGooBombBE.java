package jiraiyah.ultraio.be.goo;

import jiraiyah.jibase.interfaces.ITickLogic;
import jiraiyah.jibase.properties.BEProperties;
import jiraiyah.jibase.properties.BlockEntityFields;
import jiraiyah.jiralib.blockentity.TickableBE;
import jiraiyah.ultraio.registry.ModBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class AirGooBombBE extends TickableBE<AirGooBombBE>
{
    public AirGooBombBE(BlockPos pos, BlockState state)
    {
        super(ModBlockEntities.AIR_GOO_BOMB, pos, state);
        //TODO: Explain why this works
        this.properties.tickLogic(new TickLogic());
    }

    //TODO: Make the tick logic not an inner class but an actual class of itself
    static class TickLogic implements ITickLogic<AirGooBombBE, BlockEntityFields<AirGooBombBE>>
    {

        @Override
        public void tick(BEProperties<AirGooBombBE> properties)
        {

        }

        @Override
        public void tickClient(BEProperties<AirGooBombBE> properties)
        {

        }
    }
}