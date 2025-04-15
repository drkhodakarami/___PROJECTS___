package jiraiyah.jiralib.util;

import jiraiyah.jiralib.interfaces.INBTSerializable;
import net.minecraft.nbt.NbtList;
import net.minecraft.util.math.Direction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class StorageConnector<T> implements INBTSerializable<NbtList>
{
    protected final List<T> storages = new ArrayList<>(MappedDirection.values().length);
    protected final Map<MappedDirection, T> sidedMap = new HashMap<>(MappedDirection.values().length);

    public void addStorage(T storage)
    {
        addStorage(storage, MappedDirection.NONE);
    }

    public void addStorage(T storage, MappedDirection direction)
    {
        this.storages.add(storage);
        this.sidedMap.put(direction, storage);
    }

    public List<T> getStorages()
    {
        return this.storages;
    }

    public Map<MappedDirection, T> getSidedMap()
    {
        return this.sidedMap;
    }

    public T getStorage(MappedDirection side)
    {
        return this.sidedMap.get(side);
    }

    public T getStorage(Direction side)
    {
        return this.sidedMap.get(MappedDirection.fromDirection(side));
    }

    public T getStorage(int index)
    {
        return this.storages.get(index);
    }
}