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

public record DoublePayload(double value) implements CustomPayload
{
    public static final Id<DoublePayload> ID = new Id<>(Identifier.of("jiralib", "double_payload"));

    public static final Codec<DoublePayload> CODEC = RecordCodecBuilder.create(inst -> inst.group(
            Codec.DOUBLE.fieldOf("value").forGetter(DoublePayload::value)
    ).apply(inst, DoublePayload::new));

    public static final PacketCodec<RegistryByteBuf, DoublePayload> PACKET_CODEC =
            PacketCodec.tuple(PacketCodecs.DOUBLE, DoublePayload::value, DoublePayload::new);

    @Override
    public Id<? extends CustomPayload> getId()
    {
        return ID;
    }
}