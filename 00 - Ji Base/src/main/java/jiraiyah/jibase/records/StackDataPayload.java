/***********************************************************************************
 * Copyright (c) 2025 Alireza Khodakarami (Jiraiyah)                               *
 * ------------------------------------------------------------------------------- *
 * MIT License                                                                     *
 * =============================================================================== *
 * Permission is hereby granted, free of charge, to any person obtaining a copy    *
 * of this software and associated documentation files (the "Software"), to deal   *
 * in the Software without restriction, including without limitation the rights    *
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell       *
 * copies of the Software, and to permit persons to whom the Software is           *
 * furnished to do so, subject to the following conditions:                        *
 * ------------------------------------------------------------------------------- *
 * The above copyright notice and this permission notice shall be included in all  *
 * copies or substantial portions of the Software.                                 *
 * ------------------------------------------------------------------------------- *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR      *
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,        *
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE     *
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER          *
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,   *
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE   *
 * SOFTWARE.                                                                       *
 ***********************************************************************************/

package jiraiyah.jibase.records;

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