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

package jiraiyah.jinventory;

import jiraiyah.jibase.annotations.*;
import jiraiyah.jibase.enumerations.MappedDirection;
import jiraiyah.jinventory.record.PredicateInventoryStorage;
import jiraiyah.jiralib.blockentity.UpdatableBE;
import jiraiyah.jiralib.util.StorageConnector;
import net.fabricmc.fabric.api.transfer.v1.item.InventoryStorage;
import net.fabricmc.fabric.api.transfer.v1.item.ItemVariant;
import net.fabricmc.fabric.api.transfer.v1.storage.base.CombinedStorage;
import net.fabricmc.fabric.api.transfer.v1.storage.base.SingleSlotStorage;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import oshi.util.tuples.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

@Developer("TurtyWurty")
@ModifiedBy("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/DaRealTurtyWurty/Industria")
@Discord("https://discord.turtywurty.dev/")
@Youtube("https://www.youtube.com/@TurtyWurty")

public class InventoryConnector<T extends SimpleInventory> extends StorageConnector<InventoryStorage>
{
    private final List<T> inventories = new ArrayList<>();
    private final List<Pair<MappedDirection, T>> sidedInventories = new ArrayList<>();

    private final CombinedStorage<ItemVariant, InventoryStorage> combinedStorage = new CombinedStorage<>(this.storages);

    //region ADD INVENTORY
    public void addInventory(@NotNull T inventory) {
        addInventory(inventory, MappedDirection.NONE);
    }

    public void addInventory(@NotNull T inventory, MappedDirection side)
    {
        this.inventories.add(inventory);
        this.sidedInventories.add(new Pair<>(side, inventory));
        var storage = InventoryStorage.of(inventory, MappedDirection.toDirection(side));
        addStorage(storage, side);
    }

    public void addInventory(@NotNull T inventory, Direction side)
    {
        addInventory(inventory, MappedDirection.fromDirection(side));
    }

    public void addInventory(@NotNull T inventory, Supplier<Boolean> canInsert, Supplier<Boolean> canExtract) {
        addInventory(inventory, MappedDirection.NONE, canInsert, canExtract);
    }

    public void addInventory(@NotNull T inventory, MappedDirection side, Supplier<Boolean> canInsert, Supplier<Boolean> canExtract) {
        this.inventories.add(inventory);
        this.sidedInventories.add(new Pair<>(side, inventory));
        var storage = PredicateInventoryStorage.of(InventoryStorage.of(inventory, MappedDirection.toDirection(side)), canInsert, canExtract);
        addStorage(storage, side);
    }

    //TODO : Explain with use case example (recipe, simple)
    public void addInventory(int size, Function<Integer, T> factory)
    {
        addInventory(factory.apply(size));
    }

    //TODO : Explain with use case example (recipe, simple)
    public void addInventory(int size, MappedDirection side, Function<Integer, T> factory)
    {
        addInventory(factory.apply(size), side);
    }

    //TODO : Explain with use case example (recipe, simple)
    public void addInventory(int size, Direction side, Function<Integer, T> factory)
    {
        addInventory(factory.apply(size), side);
    }

    //TODO : Explain with use case example (recipe, simple)
    public void addInventory(Function<ItemStack[], T> factory, ItemStack... items)
    {
        addInventory(factory.apply(items));
    }

    //TODO : Explain with use case example (recipe, simple)
    public void addInventory(MappedDirection side, Function<ItemStack[], T> factory, ItemStack... items)
    {
        addInventory(factory.apply(items), side);
    }

    //TODO : Explain with use case example (recipe, simple)
    public void addInventory(Direction side, Function<ItemStack[], T> factory, ItemStack... items)
    {
        addInventory(factory.apply(items), side);
    }

    //TODO : Explain with use case example (Used for synced, output, predicate)
    public void addInventory(UpdatableBE<?> blockEntity, int size, BiFunction<UpdatableBE<?>, Integer, T> factory)
    {
        addInventory(factory.apply(blockEntity, size));
    }

    //TODO : Explain with use case example (Used for synced, output, predicate)
    public void addInventory(UpdatableBE<?> blockEntity, int size, MappedDirection side, BiFunction<UpdatableBE<?>, Integer, T> factory)
    {
        addInventory(factory.apply(blockEntity, size), side);
    }

    //TODO : Explain with use case example (Used for synced, output, predicate)
    public void addInventory(UpdatableBE<?> blockEntity, int size, Direction side, BiFunction<UpdatableBE<?>, Integer, T> factory)
    {
        addInventory(factory.apply(blockEntity, size), side);
    }

    //TODO : Explain with use case example (Used for synced, output, predicate)
    public void addInventory(UpdatableBE<?> blockEntity, BiFunction<UpdatableBE<?>, ItemStack[], T> factory, ItemStack... items)
    {
        addInventory(factory.apply(blockEntity, items));
    }

    //TODO : Explain with use case example (Used for synced, output, predicate)
    public void addInventory(UpdatableBE<?> blockEntity, MappedDirection side, BiFunction<UpdatableBE<?>, ItemStack[], T> factory, ItemStack... items)
    {
        addInventory(factory.apply(blockEntity, items), side);
    }

    //TODO : Explain with use case example (Used for synced, output, predicate)
    public void addInventory(UpdatableBE<?> blockEntity, Direction side, BiFunction<UpdatableBE<?>, ItemStack[], T> factory, ItemStack... items)
    {
        addInventory(factory.apply(blockEntity, items), side);
    }
    //endregion

    //region ADD INSERT / EXTRACT ONLY
    //TODO: Add Insert Only and Extract Only overloads using factories above!!!!!
    public void addInsertOnlyInventory(@NotNull T inventory, MappedDirection side)
    {
        addInsertOnlyInventory(inventory, side, () -> true);
    }

    public void addInsertOnlyInventory(@NotNull T inventory, MappedDirection side, Supplier<Boolean> canInsert)
    {
        addInventory(inventory, side, canInsert, () -> false);
    }

    public void addExtractOnlyInventory(@NotNull T inventory, MappedDirection side)
    {
        addExtractOnlyInventory(inventory, side, () -> true);
    }

    public void addExtractOnlyInventory(@NotNull T inventory, MappedDirection side, Supplier<Boolean> canExtract)
    {
        addInventory(inventory, side, () -> false, canExtract);
    }

    //TODO: Add isert only and Extract only overloads using Direction
    //endregion

    public List<T> getInventories()
    {
        return inventories;
    }

    public CombinedStorage<ItemVariant, InventoryStorage> getCombinedStorage()
    {
        return combinedStorage;
    }

    //region GET INVENTORY
    public @Nullable T getInventory(int index)
    {
        return this.inventories.get(index);
    }

    public @Nullable T getInventory(MappedDirection side)
    {
        return this.inventories.get(this.storages.indexOf(getStorage(side)));
    }

    public @Nullable T getInventory(Direction side)
    {
        return this.inventories.get(this.storages.indexOf(getStorage(side)));
    }
    //endregion

    //region GET SLOT(S)
    public @Nullable SingleSlotStorage<ItemVariant> getSlot(int slotIndex, MappedDirection side)
    {
        return this.getStorage(side).getSlot(slotIndex);
    }

    public @Nullable SingleSlotStorage<ItemVariant> getSlot(int slotIndex, Direction side)
    {
        return this.getStorage(side).getSlot(slotIndex);
    }

    public @Nullable SingleSlotStorage<ItemVariant> getSlot(int slotIndex, int index)
    {
        return this.getStorage(index).getSlot(slotIndex);
    }

    public @Nullable List<SingleSlotStorage<ItemVariant>> getSlots(MappedDirection side)
    {
        return this.getStorage(side).getSlots();
    }

    public @Nullable List<SingleSlotStorage<ItemVariant>> getSlots(Direction side)
    {
        return this.getStorage(side).getSlots();
    }

    public @Nullable List<SingleSlotStorage<ItemVariant>> getSlots(int index)
    {
        return this.getStorage(index).getSlots();
    }
    //endregion

    public @NotNull List<ItemStack> getStacks()
    {
        List<ItemStack> stacks = new ArrayList<>();
        for (T inventory : this.inventories)
            for(int i = 0; i < inventory.size(); i++)
                stacks.add(inventory.getStack(i));
        return stacks;
    }

    public void checkSize(int size)
    {
        int invSize = this.inventories.stream().map(Inventory::size).reduce(0, Integer::sum);
        if( invSize != size)
            throw new IllegalArgumentException("Sie of inventories does not match the size provided: " + invSize + " => " + size);
    }

    public void onOpen(@NotNull PlayerEntity player)
    {
        this.inventories.forEach(inventory -> inventory.onOpen(player));
    }

    public void onClose(@NotNull PlayerEntity player)
    {
        this.inventories.forEach(inventory -> inventory.onClose(player));
    }

    public void dropContent(@NotNull World world, @NotNull BlockPos pos)
    {
        this.inventories.forEach(inventory -> ItemScatterer.spawn(world, pos, inventory));
    }

    public RecipeSimpleInventory getRecipeInventory()
    {
        return new RecipeSimpleInventory(getStacks().toArray(new ItemStack[0]));
    }

    public List<Pair<MappedDirection, T>> getSidedInventories()
    {
        return this.sidedInventories;
    }

    //region NBT
    @Override
    public NbtList writeNbt(RegistryWrapper.WrapperLookup registryLookup)
    {
        var nbt = new NbtList();
        this.inventories.forEach(inventory ->
                                 {
                                     NbtCompound inventoryNbt = new NbtCompound();
                                     nbt.add(Inventories.writeNbt(inventoryNbt, inventory.getHeldStacks(), registryLookup));
                                 });
        return nbt;
    }

    @Override
    public void readNbt(NbtList nbt, RegistryWrapper.WrapperLookup registryLookup)
    {
        for (int i = 0; i < nbt.size(); i++)
        {
            NbtCompound inventoryNbt = nbt.getCompoundOrEmpty(i); //TODO: The change in 1.21.5 nbt.getCompound became getCompoundOrEmpty
            if(inventoryNbt.isEmpty())//TODO: 1.21.5 Now we need to check to make sure nbtCompound is not empty!
                continue;
            SimpleInventory inventory = this.inventories.get(i);
            Inventories.readNbt(inventoryNbt, inventory.getHeldStacks(), registryLookup);
        }
    }
    //endregion

    //TODO : Implement in the storage connector!!!! (From IStorageHandler)
    @Override
    public void addStorage(InventoryStorage storage, Direction direction)
    {

    }
}