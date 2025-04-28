package jiraiyah.jibase.interfaces;

import jiraiyah.jibase.annotations.*;
import jiraiyah.jibase.enumerations.MappedDirection;
import net.minecraft.util.math.Direction;

import java.util.List;
import java.util.Map;

@Developer("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/drkhodakarami/___PROJECTS___")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")

public interface IStorageHandler<T>
{
    void addStorage(T storage);

    void addStorage(T storage, MappedDirection direction);

    void addStorage(T storage, Direction direction);

    List<T> getStorages();

    Map<MappedDirection, T> getSidedMap();

    T getStorage(MappedDirection side);

    T getStorage(Direction side);

    T getStorage(int index);
}