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
import jiraiyah.jibase.interfaces.IBEFactory;
import jiraiyah.jibase.interfaces.IBETickerFactory;
import jiraiyah.jibase.interfaces.ITick;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;

import java.util.function.Supplier;

@Developer("TurtyWurty")
@ModifiedBy("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/DaRealTurtyWurty/Industria")
@Discord("https://discord.turtywurty.dev/")
@Youtube("https://www.youtube.com/@TurtyWurty")

//TODO : Merge into BlockProperties
public class BlockPropertiesBE<T extends BlockEntity>
{
    private final Supplier<BlockEntityType<T>> blockEntityTypeSupplier;
    private boolean shouldTick = false;
    private IBEFactory<T> blockEntityFactory;
    private IBETickerFactory<T> blockEntityTicker = (world, state, type) -> ITick.createTicker(world);
    //private MultiblockProperties<T> multiblockProperties;
    private boolean rightClickToOpenGui = false;
    private boolean dropContentsOnBreak = false;

    public BlockPropertiesBE(Supplier<BlockEntityType<T>> blockEntityTypeSupplier)
    {
        this.blockEntityTypeSupplier = blockEntityTypeSupplier;
        this.blockEntityFactory = (pos, state) -> this.blockEntityTypeSupplier.get().instantiate(pos, state);
    }

    public Supplier<BlockEntityType<T>> getTypeSupplier()
    {
        return this.blockEntityTypeSupplier;
    }

    public BlockEntityType<T> getBlockEntityType()
    {
        return this.blockEntityTypeSupplier.get();
    }

    public boolean isTickable()
    {
        return this.shouldTick;
    }

    public IBEFactory<T> getBlockEntityFactory()
    {
        return this.blockEntityFactory;
    }

    public IBETickerFactory<T> getBlockEntityTicker()
    {
        return this.blockEntityTicker;
    }

    public boolean hasGUI()
    {
        return this.rightClickToOpenGui;
    }

    public boolean shouldDropContentsOnBreak()
    {
        return this.dropContentsOnBreak;
    }

    public BlockPropertiesBE<T> shouldTick()
    {
        return shouldTick(true);
    }

    public BlockPropertiesBE<T> shouldTick(boolean shouldTick)
    {
        this.shouldTick = shouldTick;
        return this;
    }

    public BlockPropertiesBE<T> blockEntityFactory(IBEFactory<T> blockEntityFactory)
    {
        this.blockEntityFactory = blockEntityFactory;
        return this;
    }

    public BlockPropertiesBE<T> blockEntityTickerFactory(IBETickerFactory<T> blockEntityTicker)
    {
        this.blockEntityTicker = blockEntityTicker;
        return this;
    }

    //public MultiblockProperties<T> multiblockProperties(MultiblockType<T> type) {
    //    return new MultiblockProperties<>(this, type);
    //}

    public BlockPropertiesBE<T> rightClickToOpenGui()
    {
        return rightClickToOpenGui(true);
    }

    public BlockPropertiesBE<T> rightClickToOpenGui(boolean rightClickToOpenGui)
    {
        this.rightClickToOpenGui = rightClickToOpenGui;
        return this;
    }

    public BlockPropertiesBE<T> dropContentsOnBreak()
    {
        return dropContentsOnBreak(true);
    }

    public BlockPropertiesBE<T> dropContentsOnBreak(boolean dropContentsOnBreak)
    {
        this.dropContentsOnBreak = dropContentsOnBreak;
        return this;
    }
}