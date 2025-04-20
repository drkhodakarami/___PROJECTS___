package jiraiyah.jiralib.record;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import jiraiyah.jibase.annotations.*;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;

@Developer("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/drkhodakarami/___PROJECTS___")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")

public record FloatPayload(float value) implements CustomPayload
{
    public static final Id<FloatPayload> ID = new Id<>(Identifier.of("jiralib", "float_payload"));

    public static final Codec<FloatPayload> CODEC = RecordCodecBuilder.create(inst -> inst.group(
            Codec.FLOAT.fieldOf("value").forGetter(FloatPayload::value)
    ).apply(inst, FloatPayload::new));

    public static final PacketCodec<RegistryByteBuf, FloatPayload> PACKET_CODEC =
            PacketCodec.tuple(PacketCodecs.FLOAT, FloatPayload::value, FloatPayload::new);

    @Override
    public Id<? extends CustomPayload> getId()
    {
        return ID;
    }
}