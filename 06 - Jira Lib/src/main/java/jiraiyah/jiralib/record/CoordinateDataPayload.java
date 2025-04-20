package jiraiyah.jiralib.record;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import jiraiyah.jibase.annotations.*;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

@Developer("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/drkhodakarami/___PROJECTS___")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")

public record CoordinateDataPayload(BlockPos pos, String dimension) implements CustomPayload
{
    public static final Id<CoordinateDataPayload> ID = new Id<>(Identifier.of("jiralib", "coordinate_data_payload"));

    public static final Codec<CoordinateDataPayload> CODEC = RecordCodecBuilder.create(inst -> inst.group(
            BlockPos.CODEC.fieldOf("pos").forGetter(CoordinateDataPayload::pos),
            Codec.STRING.fieldOf("dimension").forGetter(CoordinateDataPayload::dimension)
    ).apply(inst, CoordinateDataPayload::new));

    public static final PacketCodec<RegistryByteBuf, CoordinateDataPayload> PACKET_CODEC =
            PacketCodec.tuple(BlockPos.PACKET_CODEC, CoordinateDataPayload::pos,
                              PacketCodecs.STRING, CoordinateDataPayload::dimension,
                              CoordinateDataPayload::new);

    @Override
    public Id<? extends CustomPayload> getId()
    {
        return ID;
    }
}