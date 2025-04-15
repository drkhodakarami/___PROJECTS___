package jiraiyah.jiralib.record;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import jiraiyah.jiralib.util.MathHelper;
import net.minecraft.component.ComponentChanges;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.display.SlotDisplay;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntryList;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

// Author: turtywurty
// https://github.com/DaRealTurtyWurty/Industria
public record ConfiguredIngredient(RegistryEntryList<Item> entries, StackDataPayload stackData)
{
    public static final Codec<ConfiguredIngredient> CODEC = Codec.lazyInitialized(() -> RecordCodecBuilder.create(
            inst -> inst.group(
                    Ingredient.ENTRIES_CODEC.fieldOf("ingredients").forGetter(ConfiguredIngredient::entries),
                    StackDataPayload.CODEC.optionalFieldOf("data", StackDataPayload.EMPTY).forGetter(ConfiguredIngredient::stackData)
            ).apply(inst, ConfiguredIngredient::new)
    ));

    public static final PacketCodec<RegistryByteBuf, ConfiguredIngredient> PACKET_CODEC = PacketCodec.tuple(
            PacketCodecs.registryEntryList(RegistryKeys.ITEM), ConfiguredIngredient::entries,
            StackDataPayload.PACKET_CODEC, ConfiguredIngredient::stackData,
            ConfiguredIngredient::new
    );

    public static final ConfiguredIngredient EMPTY = new ConfiguredIngredient(RegistryEntryList.of(), StackDataPayload.EMPTY);

    public ConfiguredIngredient(RegistryEntryList<Item> entries)
    {
        this(entries, StackDataPayload.create(1));
    }

    public ConfiguredIngredient(RegistryEntryList<Item> entries, int count)
    {
        this(entries, StackDataPayload.create(count));
    }

    @SuppressWarnings("deprecation")
    public ConfiguredIngredient(int count, Item... items)
    {
        this(RegistryEntryList.of(Arrays.stream(items).map(Item::getRegistryEntry).toList()), StackDataPayload.create(count));
    }

    public ConfiguredIngredient(RegistryEntryList<Item> entries, int count, ComponentChanges components)
    {
        this(entries, StackDataPayload.create(count, components));
    }

    public List<ItemStack> getMachingStacks()
    {
        return this.entries.stream().map(item -> new ItemStack(item, this.stackData.count(), this.stackData.components())).toList();
    }

    public boolean testForRecipe(ItemStack stack)
    {
        return test(stack, MathHelper.countLessThanOrEquals(stack.getCount()));
    }

    public boolean testForRecipeIgnoreComponents(ItemStack stack)
    {
        return this.entries.stream().anyMatch(item ->
                stack.getItem() == item.value() &&
                this.stackData.count() >= stack.getCount());
    }

    public boolean test(ItemStack stack, boolean matchCount, boolean matchComponents)
    {
        return this.entries.stream().anyMatch(item ->
                stack.getItem() == item.value() &&
                (!matchCount || stack.getCount() == this.stackData.count()) &&
                (!matchComponents || this.stackData.components().equals(stack.getComponentChanges())));
    }

    public boolean test(ItemStack stack)
    {
        return test(stack, true, true);
    }

    public boolean test(ItemStack stack, Predicate<Integer> countPredicate)
    {
        return this.entries.stream().anyMatch(item ->
                  stack.getItem() == item.value() &&
                  countPredicate.test(stackData.count()) &&
                  this.stackData.components().equals(stack.getComponentChanges()));
    }

    public SlotDisplay toDisplay()
    {
        if(isEmpty())
            return SlotDisplay.EmptySlotDisplay.INSTANCE;

        return new SlotDisplay.CompositeSlotDisplay(
                getMachingStacks().stream()
                        .map(SlotDisplay.StackSlotDisplay::new)
                        .map(SlotDisplay.class::cast)
                        .toList()
        );
    }

    public boolean isEmpty()
    {
        return this == EMPTY;
    }
}