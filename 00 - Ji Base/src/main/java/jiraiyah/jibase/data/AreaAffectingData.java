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

package jiraiyah.jibase.data;

import jiraiyah.jibase.annotations.CreatedAt;
import jiraiyah.jibase.annotations.Developer;
import jiraiyah.jibase.annotations.Repository;
import jiraiyah.jibase.annotations.Youtube;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;

import java.util.Objects;

@SuppressWarnings("unused")
@Developer("Direwolf20")
@CreatedAt("2025-04-18")
@Repository("https://github.com/Direwolf20-MC/JustDireThings")
@Youtube("https://www.youtube.com/@direwolf20")
public class AreaAffectingData
{
    public double xRadius = 0;
    public double yRadius = 0;
    public double zRadius = 0;
    public int xOffset = 0;
    public int yOffset = 1;
    public int zOffset = 0;
    public boolean renderArea = false;
    public Box area;

    public AreaAffectingData() {

    }

    public AreaAffectingData(Direction facing)
    {
        xOffset = facing.getVector().getX();
        yOffset = facing.getVector().getY();
        zOffset = facing.getVector().getZ();
    }

    public AreaAffectingData(double xRadius, double yRadius, double zRadius, int xOffset, int yOffset, int zOffset)
    {
        this.xRadius = xRadius;
        this.yRadius = yRadius;
        this.zRadius = zRadius;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
        this.zOffset = zOffset;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        AreaAffectingData that = (AreaAffectingData) o;
        return xRadius == that.xRadius &&
               yRadius == that.yRadius &&
               zRadius == that.zRadius &&
               xOffset == that.xOffset &&
               yOffset == that.yOffset &&
               zOffset == that.zOffset &&
               renderArea == that.renderArea;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(xRadius, yRadius, zRadius, xOffset, yOffset, zOffset, renderArea);
    }
}