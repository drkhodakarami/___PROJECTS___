package jiraiyah.jiralib.record;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import jiraiyah.jibase.annotations.*;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.fluid.base.SingleFluidStorage;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

@Developer("TurtyWurty")
@ModifiedBy("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/DaRealTurtyWurty/Industria")
@Discord("https://discord.turtywurty.dev/")
@Youtube("https://www.youtube.com/@TurtyWurty")

public record FluidStackPayload(FluidVariant fluid, long amount) implements CustomPayload
{
    public static final Id<FluidStackPayload> ID = new Id<>(Identifier.of("jiralib", "fluid_stack_payload"));

    public static final FluidStackPayload EMPTY = new FluidStackPayload(FluidVariant.blank(), 0);

    public static final MapCodec<FluidStackPayload> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
            FluidVariant.CODEC.fieldOf("fluid").forGetter(FluidStackPayload::fluid),
            Codec.LONG.fieldOf("amount").forGetter(FluidStackPayload::amount)
    ).apply(inst, FluidStackPayload::new));

    public static final PacketCodec<RegistryByteBuf, FluidStackPayload> PACKET_CODEC =
            PacketCodec.tuple(FluidVariant.PACKET_CODEC, FluidStackPayload::fluid,
                              PacketCodecs.LONG, FluidStackPayload::amount,
                              FluidStackPayload::new);

    @Override
    public Id<? extends CustomPayload> getId()
    {
        return ID;
    }

    public boolean isEmpty()
    {
        return this.amount == 0 || this.fluid.isBlank();
    }

    public boolean matches(@Nullable FluidStackPayload stack)
    {
        if(this == EMPTY && stack == EMPTY)
            return true;
        return stack == null ? isEmpty() : this.fluid.equals(stack.fluid) && this.amount >= stack.amount();
    }

    public FluidStackPayload withAmount(long amount)
    {
        return amount <= 0 ? EMPTY : new FluidStackPayload(this.fluid, amount);
    }

    public boolean testForRecipe(FluidStackPayload stack)
    {
        return this.fluid.equals(stack.fluid()) && this.amount >= stack.amount();
    }

    public boolean testForRecipe(SingleFluidStorage fluidStorage)
    {
        if(fluidStorage == null)
            return false;

        return this.fluid.equals(fluidStorage.variant) && this.amount <= fluidStorage.amount;
    }

    public boolean testForRecipe(SingleFluidStorage fluidStorage, int amount)
    {
        if(fluidStorage == null)
            return false;

        return this.fluid.equals(fluidStorage.variant) && this.amount <= fluidStorage.amount && this.amount >= amount;
    }
}