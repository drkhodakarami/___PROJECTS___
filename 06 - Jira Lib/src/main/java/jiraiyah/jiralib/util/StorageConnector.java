package jiraiyah.jiralib.util;

import jiraiyah.jibase.annotations.*;
import jiraiyah.jibase.enumerations.MappedDirection;
import jiraiyah.jibase.interfaces.INBTSerializable;
import jiraiyah.jibase.interfaces.IStorageHandler;
import net.minecraft.nbt.NbtList;
import net.minecraft.util.math.Direction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Developer("TurtyWurty")
@ModifiedBy("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/DaRealTurtyWurty/Industria")
@Discord("https://discord.turtywurty.dev/")
@Youtube("https://www.youtube.com/@TurtyWurty")

public abstract class StorageConnector<T> implements INBTSerializable<NbtList>, IStorageHandler<T>
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