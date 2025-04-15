package jiraiyah.jiralib.record;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;

import java.util.Objects;

// Author: turtywurty
// https://github.com/DaRealTurtyWurty/Industria
public record HandPayload(Hand hand) implements CustomPayload
{
    public static final Id<HandPayload> ID = new Id<>(Identifier.of("jiralib", "hand_payload"));

    public static final Codec<HandPayload> CODEC = RecordCodecBuilder.create(inst -> inst.group(
            Codec.STRING.xmap(str -> Objects.requireNonNull(Hand.valueOf(str)), Hand::name)
                        .fieldOf("hand").forGetter(HandPayload::hand)
    ).apply(inst, HandPayload::new));

    public static final PacketCodec<RegistryByteBuf, HandPayload> PACKET_CODEC =
            PacketCodec.tuple(PacketCodecs.STRING,
                              payload -> payload.hand().name(),
                              handStr -> new HandPayload(Hand.valueOf(handStr)));

    @Override
    public Id<? extends CustomPayload> getId()
    {
        return ID;
    }
}