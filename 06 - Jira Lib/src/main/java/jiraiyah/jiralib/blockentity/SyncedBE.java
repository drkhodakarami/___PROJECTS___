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

package jiraiyah.jiralib.blockentity;

import jiraiyah.jibase.annotations.*;
import jiraiyah.jibase.interfaces.ISyncedTick;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;

@Developer("TurtyWurty")
@ModifiedBy("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/DaRealTurtyWurty/Industria")
@Discord("https://discord.turtywurty.dev/")
@Youtube("https://www.youtube.com/@TurtyWurty")

public abstract class SyncedBE<T extends SyncedBE<T>> extends UpdatableBE<T> implements ISyncedTick
{
    private int ticks;
    private int clientTicks;

    public SyncedBE(BlockEntityType<T> type, BlockPos pos, BlockState state)
    {
        super(type, pos, state);
        this.ticks = 0;
        this.clientTicks = 0;
    }

    @Override
    public void onTick()
    {
        if(this.ticks == 0)
            this.onInternalFirstTick();

        if(this.properties.tickRate() == 0 || (this.ticks % this.properties.tickRate() == 0))
            this.onInternalTick();

        this.ticks++;
    }

    @Override
    public void onTickClient()
    {
        if(this.clientTicks == 0)
            this.onInternalFirstTickClient();

        if(this.properties.tickRate() == 0 || (this.clientTicks % this.properties.tickRate() == 0))
            this.onInternalTickClient();

        this.clientTicks++;
    }

    @Override
    protected void registerDefaultFields()
    {
        super.registerDefaultFields();
        this.properties.fields().addField("world", this.world, SyncedBE::getWorld, null);
        this.properties.fields().addField("pos", this.pos, SyncedBE::getPos, null);
        this.properties.fields().addField("cachedState", getCachedState(), SyncedBE::getCachedState, null);
        this.properties.fields().addField("ticks", this.ticks, SyncedBE::getTicks, null);
        this.properties.fields().addField("clientTicks", this.clientTicks, SyncedBE::getTicksClient, null);
    }

    @Override
    public boolean shouldSync()
    {
        return this.properties.shouldSync();
    }

    @Override
    public void sync(){}

    public int getTicks()
    {
        return this.ticks;
    }

    public int getTicksClient()
    {
        return this.clientTicks;
    }

    private void onInternalFirstTick()
    {
        registerDefaultFields();
        registerFields();
        onFirstTick();
    }

    protected void onFirstTick() {}
    protected void onFirstTickClient() {}
    protected void registerFields() {}

    private void onInternalFirstTickClient()
    {
        onFirstTickClient();
    }

    private void onInternalTick()
    {
        if(this.properties.tickLogic() != null)
            this.properties.tickLogic().tick(this.properties);
    }

    private void onInternalTickClient()
    {
        if(this.properties.tickLogic() != null)
            this.properties.tickLogic().tickClient(this.properties);
    }
}