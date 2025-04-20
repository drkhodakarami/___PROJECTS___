package jiraiyah.jibase.utils;

import jiraiyah.jibase.annotations.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.Nullable;

@Developer("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/drkhodakarami/___PROJECTS___")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")

public class PosHelper
{
    public static BlockPos[] positionNextTo(BlockPos pos)
    {
        return new BlockPos[]{pos.up(), pos.down(), pos.east(), pos.west(), pos.north(), pos.south()};
    }

    public static BlockPos[] positionSideTo(BlockPos pos)
    {
        return new BlockPos[]{pos.east(), pos.west(), pos.north(), pos.south()};
    }

    public static BlockPos[] positionSideBottom(BlockPos pos)
    {
        return new BlockPos[]{pos.down(), pos.east(), pos.west(), pos.north(), pos.south()};
    }

    public static BlockPos[] positionSideTop(BlockPos pos)
    {
        return new BlockPos[]{pos.up(), pos.east(), pos.west(), pos.north(), pos.south()};
    }

    public static BlockPos[] positionTopBottom(BlockPos pos)
    {
        return new BlockPos[]{pos.up(), pos.down()};
    }

    public static Direction left(Direction facing)
    {
        return switch (facing)
        {
            case NORTH -> Direction.WEST;
            case SOUTH -> Direction.EAST;
            case WEST -> Direction.SOUTH;
            case EAST -> Direction.NORTH;
            default -> facing;
        };
    }

    public static Direction right(Direction facing)
    {
        return switch (facing)
        {
            case NORTH -> Direction.EAST;
            case SOUTH -> Direction.WEST;
            case WEST -> Direction.NORTH;
            case EAST -> Direction.SOUTH;
            default -> facing;
        };
    }

    public static Direction front(Direction facing)
    {
        return switch (facing)
        {
            case NORTH -> Direction.SOUTH;
            case SOUTH -> Direction.NORTH;
            case WEST -> Direction.EAST;
            case EAST -> Direction.WEST;
            default -> facing;
        };
    }

    public static Direction back(Direction facing)
    {
        return switch (facing)
        {
            case NORTH -> Direction.NORTH;
            case SOUTH -> Direction.SOUTH;
            case WEST -> Direction.WEST;
            case EAST -> Direction.EAST;
            default -> facing;
        };
    }

    public static BlockPos left(BlockPos pos, Direction facing)
    {
        return pos.offset(left(facing));
    }

    public static BlockPos right(BlockPos pos, Direction facing)
    {
        return pos.offset(right(facing));
    }

    public static BlockPos front(BlockPos pos, Direction facing)
    {
        return pos.offset(front(facing));
    }

    public static BlockPos back(BlockPos pos, Direction facing)
    {
        return pos.offset(back(facing));
    }

    public static BlockPos top(BlockPos pos)
    {
        return pos.up();
    }

    public static BlockPos bottom(BlockPos pos)
    {
        return pos.down();
    }

    public static Direction relativeDirection(@Nullable Direction direction, @Nullable Direction facing)
    {
        if(direction == null)
            return null;
        if(facing == null)
            return direction;
        if(direction.getAxis().isVertical())
            return direction;

        Direction relative = direction;
        for (int i = 0; i < facing.ordinal(); i++)
            relative = relative.rotateYClockwise();
        return relative;
    }
}