package jiraiyah.jiralib.record;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import jiraiyah.jibase.annotations.*;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;

@Developer("TurtyWurty")
@ModifiedBy("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/DaRealTurtyWurty/Industria")
@Discord("https://discord.turtywurty.dev/")
@Youtube("https://www.youtube.com/@TurtyWurty")

public record ItemStackPayload(ItemStack stack) implements CustomPayload
{
    public static final Id<ItemStackPayload> ID = new Id<>(Identifier.of("jiralib", "item_stack_payload"));

    public static final Codec<ItemStackPayload> CODEC = RecordCodecBuilder.create(inst -> inst.group(
            ItemStack.CODEC.fieldOf("stack").forGetter(ItemStackPayload::stack)
    ).apply(inst, ItemStackPayload::new));

    public static final PacketCodec<RegistryByteBuf, ItemStackPayload> PACKET_CODEC =
            PacketCodec.tuple(ItemStack.PACKET_CODEC, ItemStackPayload::stack, ItemStackPayload::new);

    @Override
    public Id<? extends CustomPayload> getId()
    {
        return ID;
    }
}