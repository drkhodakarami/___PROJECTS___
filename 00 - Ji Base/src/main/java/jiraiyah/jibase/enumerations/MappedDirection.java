package jiraiyah.jibase.enumerations;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import jiraiyah.jibase.annotations.*;
import net.minecraft.util.Util;
import net.minecraft.util.math.Direction;

@Developer("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/drkhodakarami/___PROJECTS___")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")

public enum MappedDirection
{
    DOWN, UP, NORTH, SOUTH, WEST, EAST, NONE;

    static final BiMap<Direction, MappedDirection> biMap;

    static
    {
        biMap = Util.make(HashBiMap.create(), map ->
        {
            map.put(null, MappedDirection.NONE);
            map.put(Direction.DOWN, MappedDirection.DOWN);
            map.put(Direction.UP, MappedDirection.UP);
            map.put(Direction.NORTH, MappedDirection.NORTH);
            map.put(Direction.SOUTH, MappedDirection.SOUTH);
            map.put(Direction.EAST, MappedDirection.EAST);
            map.put(Direction.WEST, MappedDirection.WEST);
        });
    }

    public static MappedDirection fromDirection(Direction direction)
    {
        return biMap.get(direction);
    }

    public static Direction toDirection(MappedDirection direction)
    {
        return biMap.inverse().get(direction);
    }
}