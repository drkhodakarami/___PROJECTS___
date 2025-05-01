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

package jiraiyah.jibase.properties;

import jiraiyah.jibase.annotations.*;
import jiraiyah.jibase.interfaces.ITickLogic;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.world.World;

@Developer("TurtyWurty")
@ModifiedBy("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/DaRealTurtyWurty/Industria")
@Discord("https://discord.turtywurty.dev/")
@Youtube("https://www.youtube.com/@TurtyWurty")

public class BEProperties<T extends BlockEntity>
{
    private final T blockEntity;
    private boolean shouldSync = false;
    private boolean shouldWaitEndTick = false;
    private int tickRate = 0;
    private ITickLogic<T, BlockEntityFields<T>> tickLogic;
    private final BlockEntityFields<T> fields = new BlockEntityFields<>();

    public BEProperties(T blockEntity)
    {
        this.blockEntity = blockEntity;
    }

    public BEProperties<T> tickRate(int tickRate)
    {
        if(tickRate < 0)
            throw new IllegalArgumentException("Tick rate must be greater than or equal to 0");
        this.tickRate = tickRate;
        return this;
    }

    public BEProperties<T> tickLogic(ITickLogic<T, BlockEntityFields<T>> tickLogic)
    {
        this.tickLogic = tickLogic;
        return this;
    }

    public BEProperties<T> isSyncable()
    {
        this.shouldSync = true;
        return this;
    }

    public BEProperties<T> isSyncable(boolean shouldSync)
    {
        this.shouldSync = shouldSync;
        return this;
    }

    public BEProperties<T> waitEndTick()
    {
        this.shouldWaitEndTick = true;
        return this;
    }
    public BEProperties<T> waitEndTick(boolean shouldSync)
    {
        this.shouldWaitEndTick = shouldSync;
        return this;
    }

    public boolean shouldSync()
    {
        return this.shouldSync;
    }

    public boolean shouldWaitEndTick()
    {
        return this.shouldWaitEndTick;
    }

    public boolean isClient()
    {
        return world() != null && world().isClient;
    }

    public World world()
    {
        return this.fields.containsField("world")
                ? this.fields.getField("world", World.class).getValue()
                : null;
    }

    public int tickRate()
    {
        return this.tickRate;
    }

    public BlockEntityFields<T> fields()
    {
        return this.fields;
    }

    public T blockEntity()
    {
        return this.blockEntity;
    }

    public ITickLogic<T, BlockEntityFields<T>> tickLogic()
    {
        return this.tickLogic;
    }
}