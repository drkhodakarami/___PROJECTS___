package jiraiyah.jiralib.record;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import jiraiyah.jiralib.network.ExtraPacketCodecs;
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


// Author: turtywurty
// https://github.com/DaRealTurtyWurty/Industria
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