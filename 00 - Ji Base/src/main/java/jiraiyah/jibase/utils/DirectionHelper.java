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

import jiraiyah.jibase.annotations.CreatedAt;
import jiraiyah.jibase.annotations.Developer;
import jiraiyah.jibase.annotations.Repository;
import jiraiyah.jibase.annotations.Youtube;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;

@Developer("Direwolf20")
@CreatedAt("2025-04-18")
@Repository("https://github.com/Direwolf20-MC/JustDireThings")
@Youtube("https://www.youtube.com/@direwolf20")
public class DirectionHelper
{
    public static Direction getPrimaryDirection(Vec3d vec)
    {
        double absX = Math.abs(vec.x);
        double absY = Math.abs(vec.y);
        double absZ = Math.abs(vec.z);

        // Determine the largest magnitude component
        if (absX > absY && absX > absZ)
            return vec.x > 0 ? Direction.EAST : Direction.WEST;
        if (absY > absX && absY > absZ)
            return vec.y > 0 ? Direction.UP : Direction.DOWN;
        return vec.z > 0 ? Direction.SOUTH : Direction.NORTH;
    }

    public static Direction getFacingDirection(PlayerEntity player)
    {
        float yaw = player.getYaw();
        float pitch = player.getPitch();

        // Convert yaw to horizontal direction
        Direction horizontalDirection = Direction.fromHorizontalDegrees(yaw);

        // Adjust for vertical direction if necessary (e.g., UP or DOWN)
        if (pitch < -45)
            return Direction.UP;
        if (pitch > 45)
            return Direction.DOWN;
        return horizontalDirection;
    }
}