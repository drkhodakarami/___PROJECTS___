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

package jiraiyah.jiticklogic.base;

import com.mojang.serialization.Codec;
import com.mojang.serialization.Dynamic;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtOps;

import static jiraiyah.jiticklogic.base.Blackboard.getCodec;

/**
 * Represents an entry in a blackboard, containing a type ID and its corresponding value.
 */
public record BlackboardEntry(String typeId, Object value)
{
    /**
     * Codec for serializing and deserializing {@link BlackboardEntry} instances.
     */
    public static final Codec<BlackboardEntry> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.STRING.fieldOf("type").forGetter(entry -> entry.typeId),
            Codec.PASSTHROUGH.fieldOf("value").forGetter(entry ->
                                                         {
                                                             NbtElement nbt = getCodec(entry.typeId).encodeStart(NbtOps.INSTANCE, entry.value).result().orElseThrow();
                                                             return new Dynamic<>(NbtOps.INSTANCE, nbt);
                                                         })
    ).apply(instance, (type, dyn) ->
    {
        Codec<Object> codec = getCodec(type);

        NbtElement nbt = (NbtElement) dyn.getValue();
        Object value = codec.parse(NbtOps.INSTANCE, nbt).result().orElse(null);

        return new BlackboardEntry(type, value);
    }));
}