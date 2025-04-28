package jiraiyah.ultraio.be.goo;

import jiraiyah.jibase.interfaces.ITickLogic;
import jiraiyah.jibase.properties.BEProperties;
import jiraiyah.jibase.properties.BlockEntityFields;
import jiraiyah.jiralib.blockentity.TickableBE;
import jiraiyah.ultraio.registry.ModBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class ChunkGooBombBE extends TickableBE<ChunkGooBombBE>
{
    public ChunkGooBombBE(BlockPos pos, BlockState state)
    {
        super(ModBlockEntities.CHUNK_GOO_BOMB, pos, state);
        this.properties.tickLogic(new TickLogic());
    }

    //TODO: Make the tick logic not an inner class but an actual class of itself
    static class TickLogic implements ITickLogic<ChunkGooBombBE, BlockEntityFields<ChunkGooBombBE>>
    {

        @Override
        public void tick(BEProperties<ChunkGooBombBE> properties)
        {

        }

        @Override
        public void tickClient(BEProperties<ChunkGooBombBE> properties)
        {

        }
    }
}