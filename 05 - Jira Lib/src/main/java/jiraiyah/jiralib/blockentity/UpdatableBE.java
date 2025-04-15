package jiraiyah.jiralib.blockentity;

import jiraiyah.jiralib.record.BlockPosPayload;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;

public abstract class UpdatableBE extends NoScreenUpdatableBE implements ExtendedScreenHandlerFactory<BlockPosPayload>
{
    public UpdatableBE(BlockEntityType<?> type, BlockPos pos, BlockState state)
    {
        super(type, pos, state);
    }

    @Override
    public BlockPosPayload getScreenOpeningData(ServerPlayerEntity serverPlayerEntity)
    {
        return new BlockPosPayload(this.pos);
    }
}