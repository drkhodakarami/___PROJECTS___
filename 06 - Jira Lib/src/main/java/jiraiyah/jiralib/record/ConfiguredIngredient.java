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

package jiraiyah.jiralib.record;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import jiraiyah.jibase.annotations.*;
import jiraiyah.jibase.utils.MathHelper;
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

@Developer("TurtyWurty")
@ModifiedBy("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/DaRealTurtyWurty/Industria")
@Discord("https://discord.turtywurty.dev/")
@Youtube("https://www.youtube.com/@TurtyWurty")

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

    //TODO: Explain Adding more ctor overloads
    @SuppressWarnings("deprecation")
    public ConfiguredIngredient(Item... items)
    {
        this(RegistryEntryList.of(Arrays.stream(items).map(Item::getRegistryEntry).toList()), StackDataPayload.create(1));
    }

    @SuppressWarnings("deprecation")
    public ConfiguredIngredient(int count, Item item)
    {
        this(RegistryEntryList.of(Arrays.stream(new Item[]{item}).map(Item::getRegistryEntry).toList()), StackDataPayload.create(count));
    }

    @SuppressWarnings("deprecation")
    public ConfiguredIngredient(Item item)
    {
        this(RegistryEntryList.of(Arrays.stream(new Item[]{item}).map(Item::getRegistryEntry).toList()), StackDataPayload.create(1));
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