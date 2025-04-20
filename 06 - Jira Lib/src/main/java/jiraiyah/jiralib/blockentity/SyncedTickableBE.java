package jiraiyah.jiralib.blockentity;

import jiraiyah.jibase.annotations.*;
import jiraiyah.jibase.interfaces.ISyncedTick;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;

@Developer("TurtyWurty")
@ModifiedBy("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/DaRealTurtyWurty/Industria")
@Discord("https://discord.turtywurty.dev/")
@Youtube("https://www.youtube.com/@TurtyWurty")

public abstract class SyncedTickableBE<T extends SyncedTickableBE<T>> extends UpdatableBE<T> implements ISyncedTick
{
    private int ticks;
    private int clientTicks;

    public SyncedTickableBE(BlockEntityType<T> type, BlockPos pos, BlockState state)
    {
        super(type, pos, state);
        this.ticks = 0;
        this.clientTicks = 0;
    }

    @Override
    public void onTick()
    {
        if(this.ticks == 0)
            this.onInternalFirstTick();

        if(this.properties.tickRate() == 0 || (this.ticks % this.properties.tickRate() == 0))
            this.onInternalTick();

        this.ticks++;
    }

    @Override
    public void onTickClient()
    {
        if(this.clientTicks == 0)
            this.onInternalFirstTickClient();

        if(this.properties.tickRate() == 0 || (this.clientTicks % this.properties.tickRate() == 0))
            this.onInternalTickClient();

        this.clientTicks++;
    }

    @Override
    protected void registerDefaultFields()
    {
        super.registerDefaultFields();
        this.properties.fields().addField("world", this.world, SyncedTickableBE::getWorld, null);
        this.properties.fields().addField("pos", this.pos, SyncedTickableBE::getPos, null);
        this.properties.fields().addField("cachedState", getCachedState(), SyncedTickableBE::getCachedState, null);
        this.properties.fields().addField("ticks", this.ticks, SyncedTickableBE::getTicks, null);
        this.properties.fields().addField("clientTicks", this.clientTicks, SyncedTickableBE::getTicksClient, null);
    }

    @Override
    public boolean shouldSync()
    {
        return this.properties.shouldSync();
    }

    @Override
    public void sync(){}

    public int getTicks()
    {
        return this.ticks;
    }

    public int getTicksClient()
    {
        return this.clientTicks;
    }

    private void onInternalFirstTick()
    {
        registerDefaultFields();
        registerFields();
        onFirstTick();
    }

    protected void onFirstTick() {}
    protected void onFirstTickClient() {}
    protected void registerFields() {}

    private void onInternalFirstTickClient()
    {
        onFirstTickClient();
    }

    private void onInternalTick()
    {
        if(this.properties.tickLogic() != null)
            this.properties.tickLogic().tick(this.properties);
    }

    private void onInternalTickClient()
    {
        if(this.properties.tickLogic() != null)
            this.properties.tickLogic().tickClient(this.properties);
    }
}