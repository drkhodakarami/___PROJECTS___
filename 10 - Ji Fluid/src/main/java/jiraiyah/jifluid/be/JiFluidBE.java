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

package jiraiyah.jifluid.be;

import jiraiyah.jibase.constants.BEKeys;
import jiraiyah.jibase.enumerations.MappedDirection;
import jiraiyah.jifluid.base.FluidConnector;
import jiraiyah.jifluid.interfaces.IFluidConnector;
import jiraiyah.jinventory.be.JInventoryBE;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.fluid.base.SingleFluidStorage;
import net.fabricmc.fabric.api.transfer.v1.storage.Storage;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

public abstract class JiFluidBE<T extends JiFluidBE<T, B, C>, B extends SimpleInventory, C extends SingleFluidStorage> extends JInventoryBE<T, B>
    implements IFluidConnector<C>
{
    protected final FluidConnector<C> fluidStorage;

    public JiFluidBE(BlockEntityType<T> type, BlockPos pos, BlockState state)
    {
        super(type, pos, state);
        fluidStorage = new FluidConnector<>();
    }

    @Override
    public FluidConnector<C> getFluidConnector()
    {
        return fluidStorage;
    }

    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registries)
    {
        super.readNbt(nbt, registries);
        if(nbt.contains("fluid" + BEKeys.HAS_FLUID))
            nbt.getList("fluid" + BEKeys.HAS_FLUID)
                    .ifPresent(nbtElements -> fluidStorage.readNbt(nbtElements, registries));
    }

    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registries)
    {
        super.writeNbt(nbt, registries);
        nbt.put("fluid" + BEKeys.HAS_FLUID, fluidStorage.writeNbt(registries));
    }

    public Storage<FluidVariant> getFluidStorage(Direction direction)
    {
        if(world == null)
            return null;
        if(world.getBlockState(pos).getProperties().contains(Properties.FACING))
            return this.fluidStorage.getStorageProvider(direction, world.getBlockState(pos).get(Properties.FACING));
        return this.fluidStorage.getStorage(direction);
    }

    public Storage<FluidVariant> getFluidStorage(MappedDirection direction)
    {
        return getFluidStorage(MappedDirection.toDirection(direction));
    }
}