package jiraiyah.jiralib.record;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

// Author: turtywurty
// https://github.com/DaRealTurtyWurty/Industria
public record BlockPosPayload(BlockPos pos) implements CustomPayload
{
    public static final Id<BlockPosPayload> ID = new Id<>(Identifier.of("jiralib", "block_pos_payload"));

    public static final Codec<BlockPosPayload> CODEC = RecordCodecBuilder.create(inst -> inst.group(
            BlockPos.CODEC.fieldOf("pos").forGetter(BlockPosPayload::pos)
    ).apply(inst, BlockPosPayload::new));

    public static final PacketCodec<RegistryByteBuf, BlockPosPayload> PACKET_CODEC =
            PacketCodec.tuple(BlockPos.PACKET_CODEC, BlockPosPayload::pos, BlockPosPayload::new);

    @Override
    public Id<? extends CustomPayload> getId()
    {
        return ID;
    }
}