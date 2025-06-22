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

package jiraiyah.jibase.utils;

import jiraiyah.jibase.annotations.*;
import jiraiyah.jibase.exceptions.Exceptions;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
@Developer("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/drkhodakarami/___PROJECTS___")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")

public class PosHelper
{
    public PosHelper()
    {
        Exceptions.throwCtorAssertion();
    }

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

    public static double getDistance(BlockPos pos, BlockPos origin)
    {
        return Math.sqrt(Math.pow(pos.getX() - origin.getX(), 2) + Math.pow(pos.getY() - origin.getY(), 2) + Math.pow(pos.getZ() - origin.getZ(), 2));
    }

    public static double getDistance(int x1, int y1, int z1 , int x2, int y2, int z2)
    {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2) + Math.pow(z1 - z2, 2));
    }

    public static double getDistance(int x1, int y1 , int x2, int y2)
    {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }

    public static double getDistance(float x1, float y1, float z1 , float x2, float y2, float z2)
    {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2) + Math.pow(z1 - z2, 2));
    }

    public static double getDistance(float x1, float y1 , float x2, float y2)
    {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }

    public static double getDistance(double x1, double y1, double z1 , double x2, double y2, double z2)
    {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2) + Math.pow(z1 - z2, 2));
    }

    public static double getDistance(double x1, double y1 , double x2, double y2)
    {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }
}