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

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import jiraiyah.jibase.annotations.*;
import jiraiyah.jibase.network.ExtraPacketCodecs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.recipe.display.SlotDisplay;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.floatprovider.ConstantFloatProvider;
import net.minecraft.util.math.floatprovider.FloatProvider;
import net.minecraft.util.math.floatprovider.FloatProviderType;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.intprovider.IntProviderType;
import net.minecraft.util.math.random.Random;

import java.util.stream.IntStream;

@SuppressWarnings("unused")
@Developer("TurtyWurty")
@ModifiedBy("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/DaRealTurtyWurty/Industria")
@Discord("https://discord.turtywurty.dev/")
@Youtube("https://www.youtube.com/@TurtyWurty")

public record OutputItemStackPayload(Item output, IntProvider count, FloatProvider chance) implements CustomPayload
{
    public static final Id<BlockPosPayload> ID = new Id<>(Identifier.of("jiralib", "output_item_stack_payload"));

    public static final ConstantFloatProvider DEFAULT_CHANCE = ConstantFloatProvider.create(1.0f);
    public static final OutputItemStackPayload EMPTY = new OutputItemStackPayload(ItemStack.EMPTY);

    public static final MapCodec<OutputItemStackPayload> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
            Registries.ITEM.getCodec().fieldOf("output").forGetter(OutputItemStackPayload::output),
            IntProvider.VALUE_CODEC.fieldOf("count").forGetter(OutputItemStackPayload::count),
            FloatProvider.VALUE_CODEC.fieldOf("chance").forGetter(OutputItemStackPayload::chance)
    ).apply(inst, OutputItemStackPayload::new));

    public static final PacketCodec<RegistryByteBuf, OutputItemStackPayload> PACKET_CODEC =
            PacketCodec.ofStatic(OutputItemStackPayload::encode, OutputItemStackPayload::decode);

    public OutputItemStackPayload
    {
        if(output == null)
            throw new IllegalArgumentException("Item can't be null");
        if(count == null)
            throw new IllegalArgumentException("Count can't be null");
        if(chance == null)
            throw new IllegalArgumentException("Chance can't be null");
    }

    public OutputItemStackPayload(Item output, int count, float chance)
    {
        this(output, ConstantIntProvider.create(count), ConstantFloatProvider.create(chance));
    }

    public OutputItemStackPayload(ItemStack stack)
    {
        this(stack.getItem(), ConstantIntProvider.create(stack.getCount()), DEFAULT_CHANCE);
    }

    public OutputItemStackPayload(Item output, IntProvider count, float chance)
    {
        this(output, count, ConstantFloatProvider.create(chance));
    }

    public OutputItemStackPayload(Item output, int count, FloatProvider chance)
    {
        this(output, ConstantIntProvider.create(count), chance);
    }

    public OutputItemStackPayload(Item output, int count)
    {
        this(output, ConstantIntProvider.create(count), DEFAULT_CHANCE);
    }

    public OutputItemStackPayload(Item output, IntProvider count)
    {
        this(output, count, DEFAULT_CHANCE);
    }

    public OutputItemStackPayload(Item output, float chance)
    {
        this(output, ConstantIntProvider.create(1), ConstantFloatProvider.create(chance));
    }

    public OutputItemStackPayload(Item output, FloatProvider chance)
    {
        this(output, ConstantIntProvider.create(1), chance);
    }

    public OutputItemStackPayload(Item output)
    {
        this(output, ConstantIntProvider.create(1), DEFAULT_CHANCE);
    }

    public OutputItemStackPayload(ItemStack stack, float chance)
    {
        this(stack.getItem(), ConstantIntProvider.create(stack.getCount()), ConstantFloatProvider.create(chance));
    }

    public OutputItemStackPayload(ItemStack stack, FloatProvider chance)
    {
        this(stack.getItem(), ConstantIntProvider.create(stack.getCount()), chance);
    }

    public ItemStack createStack(Random random)
    {
        return this.chance.get(random) < random.nextFloat()
               ? ItemStack.EMPTY
               : new ItemStack(this.output, this.count.get(random));
    }

    public SlotDisplay toDisplay()
    {
        return new SlotDisplay.CompositeSlotDisplay(
                IntStream.range(this.count.getMin(), this.count.getMax() + 1)
                        .mapToObj(c -> new ItemStack(this.output, c))
                        .map(SlotDisplay.StackSlotDisplay::new)
                        .map(SlotDisplay.class::cast)
                        .toList()
        );
    }

    private static void encode(RegistryByteBuf buf, OutputItemStackPayload stackPayload)
    {
        buf.writeRegistryKey(Registries.ITEM.getKey(stackPayload.output()).orElseThrow());

        Registries.INT_PROVIDER_TYPE.getKey(stackPayload.count().getType()).ifPresent(buf::writeRegistryKey);
        ExtraPacketCodecs.encode(buf, stackPayload.count());

        Registries.FLOAT_PROVIDER_TYPE.getKey(stackPayload.chance().getType()).ifPresent(buf::writeRegistryKey);
        ExtraPacketCodecs.encode(buf, stackPayload.chance());
    }

    private static OutputItemStackPayload decode(RegistryByteBuf buf)
    {
        Item item = Registries.ITEM.get(buf.readRegistryKey(RegistryKeys.ITEM));

        RegistryKey<IntProviderType<?>> countType = buf.readRegistryKey(RegistryKeys.INT_PROVIDER_TYPE);
        IntProviderType<?> countTypeInstance = Registries.INT_PROVIDER_TYPE.get(countType);
        IntProvider count = ExtraPacketCodecs.decode(buf, countTypeInstance);

        RegistryKey<FloatProviderType<?>> chanceType = buf.readRegistryKey(RegistryKeys.FLOAT_PROVIDER_TYPE);
        FloatProviderType<?> chanceTypeInstance = Registries.FLOAT_PROVIDER_TYPE.get(chanceType);
        FloatProvider chance = ExtraPacketCodecs.decode(buf, chanceTypeInstance);

        return new OutputItemStackPayload(item, count, chance);
    }

    @Override
    public Id<? extends CustomPayload> getId()
    {
        return ID;
    }
}