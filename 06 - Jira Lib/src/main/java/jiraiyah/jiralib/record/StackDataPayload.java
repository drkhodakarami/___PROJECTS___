package jiraiyah.jiralib.record;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import jiraiyah.jibase.annotations.*;
import net.minecraft.component.ComponentChanges;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;

@Developer("TurtyWurty")
@ModifiedBy("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/DaRealTurtyWurty/Industria")
@Discord("https://discord.turtywurty.dev/")
@Youtube("https://www.youtube.com/@TurtyWurty")

public record StackDataPayload(int count, ComponentChanges components) implements CustomPayload
{
    public static final Id<IntegerPayload> ID = new Id<>(Identifier.of("jiralib", "component_changes_stack_payload"));

    public static final Codec<StackDataPayload> CODEC = RecordCodecBuilder.create(inst -> inst.group(
            Codec.INT.fieldOf("count").forGetter(StackDataPayload::count),
            ComponentChanges.CODEC.fieldOf("components").forGetter(StackDataPayload::components)
    ).apply(inst, StackDataPayload::new));

    public static final PacketCodec<RegistryByteBuf, StackDataPayload> PACKET_CODEC =
            PacketCodec.tuple(PacketCodecs.INTEGER, StackDataPayload::count,
                              ComponentChanges.PACKET_CODEC, StackDataPayload::components,
                              StackDataPayload::new);

    public static StackDataPayload EMPTY = new StackDataPayload(1, ComponentChanges.EMPTY);

    public static StackDataPayload create(int count)
    {
        return new StackDataPayload(count, ComponentChanges.EMPTY);
    }

    public static StackDataPayload create(int count, ComponentChanges components)
    {
        return new StackDataPayload(count, components);
    }

    @Override
    public Id<? extends CustomPayload> getId()
    {
        return ID;
    }
}