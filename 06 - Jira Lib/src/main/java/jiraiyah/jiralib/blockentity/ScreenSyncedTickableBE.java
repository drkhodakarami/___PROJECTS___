package jiraiyah.jiralib.blockentity;

import jiraiyah.jibase.annotations.*;
import jiraiyah.jibase.interfaces.IBEScreen;
import jiraiyah.jibase.interfaces.ISyncedTick;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;

@Developer("TurtyWurty")
@ModifiedBy("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/DaRealTurtyWurty/Industria")
@Discord("https://discord.turtywurty.dev/")
@Youtube("https://www.youtube.com/@TurtyWurty")

public abstract class ScreenSyncedTickableBE<T extends ScreenSyncedTickableBE<T, B>, B> extends SyncedTickableBE<T> implements ISyncedTick, IBEScreen<B>
{

    public ScreenSyncedTickableBE(BlockEntityType<T> type, BlockPos pos, BlockState state)
    {
        super(type, pos, state);
    }

    @Override
    public abstract B getScreenOpeningData(ServerPlayerEntity serverPlayerEntity);
}