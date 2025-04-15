package jiraiyah.jinventory;

import jiraiyah.jinventory.record.PredicateInventoryStorage;
import jiraiyah.jiralib.util.MappedDirection;
import jiraiyah.jiralib.util.StorageConnector;
import net.fabricmc.fabric.api.transfer.v1.item.InventoryStorage;
import net.fabricmc.fabric.api.transfer.v1.item.ItemVariant;
import net.fabricmc.fabric.api.transfer.v1.storage.base.CombinedStorage;
import net.fabricmc.fabric.api.transfer.v1.storage.base.SingleSlotStorage;
import net.fabricmc.fabric.mixin.item.ItemAccessor;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtList;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import oshi.util.tuples.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class InventoryConnector<T extends SimpleInventory> extends StorageConnector<InventoryStorage>
{
    private final List<T> inventories = new ArrayList<>();
    private final List<Pair<MappedDirection, T>> sidedInventories = new ArrayList<>();

    private final CombinedStorage<ItemVariant, InventoryStorage> combinedStorage = new CombinedStorage<>(this.storages);

    public void addInventory(@NotNull T inventory) {
        addInventory(inventory, MappedDirection.NONE);
    }

    public void addInventory(@NotNull T inventory, MappedDirection side) {
        this.inventories.add(inventory);
        this.sidedInventories.add(new Pair<>(side, inventory));
        var storage = InventoryStorage.of(inventory, MappedDirection.toDirection(side));
        addStorage(storage, side);
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

    public void addInsertOnlyInventory(@NotNull T inventory, MappedDirection side) {
        addInsertOnlyInventory(inventory, side, () -> true);
    }

    public void addInsertOnlyInventory(@NotNull T inventory, MappedDirection side, Supplier<Boolean> canInsert) {
        addInventory(inventory, side, canInsert, () -> false);
    }

    public void addExtractOnlyInventory(@NotNull T inventory, MappedDirection side) {
        addInventory(inventory, side, () -> false, () -> true);
    }

    public void addExtractOnlyInventory(@NotNull T inventory, MappedDirection side, Supplier<Boolean> canExtract) {
        addInventory(inventory, side, () -> false, canExtract);
    }

    public List<T> getInventories()
    {
        return inventories;
    }

    public CombinedStorage<ItemVariant, InventoryStorage> getCombinedStorage()
    {
        return combinedStorage;
    }

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

    @Override
    public NbtList writeNbt(RegistryWrapper.WrapperLookup registryLookup)
    {
        return null;
    }

    @Override
    public void readNbt(NbtList nbt, RegistryWrapper.WrapperLookup registryLookup)
    {

    }
}