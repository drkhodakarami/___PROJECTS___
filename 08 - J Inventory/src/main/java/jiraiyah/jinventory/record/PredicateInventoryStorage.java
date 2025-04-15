package jiraiyah.jinventory.record;

import com.google.common.collect.MapMaker;
import jiraiyah.jinventory.PredicateKey;
import net.fabricmc.fabric.api.transfer.v1.item.InventoryStorage;
import net.fabricmc.fabric.api.transfer.v1.item.ItemVariant;
import net.fabricmc.fabric.api.transfer.v1.storage.StorageView;
import net.fabricmc.fabric.api.transfer.v1.storage.base.SingleSlotStorage;
import net.fabricmc.fabric.api.transfer.v1.transaction.TransactionContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.UnmodifiableView;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Supplier;

// Author: turtywurty
// https://github.com/DaRealTurtyWurty/Industria
public record PredicateInventoryStorage(InventoryStorage storage, Supplier<Boolean> canInser, Supplier<Boolean> canExtract) implements InventoryStorage
{
    private static final ConcurrentMap<InventoryStorage, ConcurrentMap<PredicateKey, PredicateInventoryStorage>> CACHE = new MapMaker().weakKeys().makeMap();

    public static PredicateInventoryStorage of(InventoryStorage storage, Supplier<Boolean> canInser, Supplier<Boolean> canExtract)
    {
        ConcurrentMap<PredicateKey, PredicateInventoryStorage> inventoryCache = CACHE.computeIfAbsent(storage, k -> new MapMaker().makeMap());
        PredicateKey key = new PredicateKey(canInser, canExtract);
        return inventoryCache.computeIfAbsent(key, k -> new PredicateInventoryStorage(storage, canInser, canExtract));
    }

    @Override
    public @UnmodifiableView List<SingleSlotStorage<ItemVariant>> getSlots()
    {
        return this.storage.getSlots();
    }

    @Override
    public boolean supportsInsertion()
    {
        return this.storage.supportsInsertion() && this.canInser.get();
    }

    @Override
    public boolean supportsExtraction()
    {
        return this.storage.supportsExtraction() && this.canExtract.get();
    }

    @Override
    public long insert(ItemVariant resource, long maxAmount, TransactionContext transactionContext)
    {
        return storage.insert(resource, maxAmount, transactionContext);
    }

    @Override
    public long extract(ItemVariant resource, long maxAmount, TransactionContext transactionContext)
    {
        return storage.extract(resource, maxAmount, transactionContext);
    }

    @Override
    public @NotNull Iterator<StorageView<ItemVariant>> iterator()
    {
        return storage.iterator();
    }

    @Override
    public int getSlotCount()
    {
        return storage.getSlotCount();
    }

    @Override
    public SingleSlotStorage<ItemVariant> getSlot(int slotIndex)
    {
        return storage.getSlot(slotIndex);
    }

    @Override
    public boolean equals(Object obj)
    {
        return storage.equals(obj);
    }

    @Override
    public int hashCode()
    {
        return storage.hashCode();
    }

    @Override
    public String toString()
    {
        return "PredicateInventoryStorage[%s]".formatted(storage.toString());
    }

    @Override
    public Iterator<StorageView<ItemVariant>> nonEmptyIterator()
    {
        return storage.nonEmptyIterator();
    }

    @Override
    public Iterable<StorageView<ItemVariant>> nonEmptyViews()
    {
        return storage.nonEmptyViews();
    }

    @Override
    public long getVersion()
    {
        return storage.getVersion();
    }
}