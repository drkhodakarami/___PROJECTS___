package jiraiyah.jiralib.blockentity;

import jiraiyah.jiralib.interfaces.IUpdatable;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
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

// Author: turtywurty
// https://github.com/DaRealTurtyWurty/Industria
public abstract class NoScreenUpdatableBE extends BlockEntity implements IUpdatable
{
    protected boolean isDirty = false;

    public NoScreenUpdatableBE(BlockEntityType<?> type, BlockPos pos, BlockState state)
    {
        super(type, pos, state);
    }


    @Override
    public void update()
    {
        this.isDirty = true;

        if(!shouldWaitEndTick())
        {
            markDirty();

            if(this.world != null && !this.world.isClient)
                this.world.updateListeners(this.pos, getCachedState(), getCachedState(), Block.NOTIFY_ALL);
        }
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
    public void onTickClientEnd()
    {}

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

    public boolean shouldWaitEndTick()
    {
        return false;
    }
}