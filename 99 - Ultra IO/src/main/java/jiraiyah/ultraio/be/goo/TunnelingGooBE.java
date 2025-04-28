package jiraiyah.ultraio.be.goo;

import jiraiyah.jibase.interfaces.ITickLogic;
import jiraiyah.jibase.properties.BEProperties;
import jiraiyah.jibase.properties.BlockEntityFields;
import jiraiyah.jiralib.blockentity.TickableBE;
import jiraiyah.ultraio.registry.ModBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class TunnelingGooBE extends TickableBE<TunnelingGooBE>
{
    public TunnelingGooBE(BlockPos pos, BlockState state)
    {
        super(ModBlockEntities.TUNNELING_GOO, pos, state);
        this.properties.tickLogic(new TickLogic());
    }

    //TODO: Make the tick logic not an inner class but an actual class of itself
    static class TickLogic implements ITickLogic<TunnelingGooBE, BlockEntityFields<TunnelingGooBE>>
    {

        @Override
        public void tick(BEProperties<TunnelingGooBE> properties)
        {

        }

        @Override
        public void tickClient(BEProperties<TunnelingGooBE> properties)
        {

        }
    }
}