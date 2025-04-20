package jiraiyah.jiralib.blockentity;

import jiraiyah.jibase.annotations.*;
import jiraiyah.jibase.interfaces.IUpdatable;
import jiraiyah.jibase.properties.BEProperties;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

@Developer("TurtyWurty")
@ModifiedBy("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/DaRealTurtyWurty/Industria")
@Discord("https://discord.turtywurty.dev/")
@Youtube("https://www.youtube.com/@TurtyWurty")

public abstract class UpdatableBE<T extends UpdatableBE<T>> extends BlockEntity implements IUpdatable
{
    protected boolean isDirty = false;
    protected boolean isDirtyClient = false;

    protected BEProperties<T> properties;

    @SuppressWarnings("unchecked")
    public UpdatableBE(BlockEntityType<T> type, BlockPos pos, BlockState state)
    {
        super(type, pos, state);
        properties = new BEProperties<>((T)this)
                .tickRate(0)
                .isSyncable(false)
                .waitEndTick(false);
        this.properties.fields().addField("isDirty", this.isDirty, blockEntity -> blockEntity.isDirty, ((blockEntity, value) -> blockEntity.isDirty = value));
        this.properties.fields().addField("isDirtyClient", this.isDirtyClient, blockEntity -> blockEntity.isDirtyClient, ((blockEntity, value) -> blockEntity.isDirtyClient = value));
    }

    @Override
    public boolean update()
    {
        this.isDirty = true;

        if(this.properties!= null && !this.properties.shouldWaitEndTick())
        {
            markDirty();

            if(this.world != null && !this.world.isClient)
                this.world.updateListeners(this.pos, getCachedState(), getCachedState(), Block.NOTIFY_ALL);
        }
        return true;
    }

    @Override
    public void onTickEnd()
    {
        if(this.isDirty)
        {
            this.isDirty = false;
            markDirty();
            if(this.world != null && !this.world.isClient)
                this.world.updateListeners(this.pos, getCachedState(), getCachedState(), Block.NOTIFY_ALL);
        }
    }

    @Override
    public @Nullable Packet<ClientPlayPacketListener> toUpdatePacket()
    {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup registries)
    {
        NbtCompound nbt = super.toInitialChunkDataNbt(registries);
        writeNbt(nbt, registries);
        return nbt;
    }

    protected void registerDefaultFields()
    {}
}