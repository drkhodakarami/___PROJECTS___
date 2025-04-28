package jiraiyah.jiralib.blockentity;

import jiraiyah.jibase.annotations.*;
import jiraiyah.jibase.interfaces.IBEScreen;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;

@Developer("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/drkhodakarami/___PROJECTS___")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")

public abstract class ScreenUpdatableBE<T extends ScreenUpdatableBE<T, B>, B> extends UpdatableBE<T> implements IBEScreen<B>
{
    public ScreenUpdatableBE(BlockEntityType<T> type, BlockPos pos, BlockState state)
    {
        super(type, pos, state);
    }

    @Override
    public abstract B getScreenOpeningData(ServerPlayerEntity serverPlayerEntity);
}