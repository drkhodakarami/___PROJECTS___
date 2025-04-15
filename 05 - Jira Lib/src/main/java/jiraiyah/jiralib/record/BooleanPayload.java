package jiraiyah.jiralib.record;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public record BooleanPayload(boolean value) implements CustomPayload
{
    public static final Id<BooleanPayload> ID = new Id<>(Identifier.of("jiralib", "boolean_payload"));

    public static final Codec<BooleanPayload> CODEC = RecordCodecBuilder.create(inst -> inst.group(
            Codec.BOOL.fieldOf("value").forGetter(BooleanPayload::value)
    ).apply(inst, BooleanPayload::new));

    public static final PacketCodec<RegistryByteBuf, BooleanPayload> PACKET_CODEC =
            PacketCodec.tuple(PacketCodecs.BOOLEAN, BooleanPayload::value, BooleanPayload::new);

    @Override
    public Id<? extends CustomPayload> getId()
    {
        return ID;
    }
}