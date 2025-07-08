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

package jiraiyah.jimachina;

import jiraiyah.jibase.constants.BEKeys;
import jiraiyah.jibase.enumerations.MappedDirection;
import jiraiyah.jienergy.base.EnergyConnector;
import jiraiyah.jienergy.interfaces.IEnergyConnector;
import jiraiyah.jifluid.be.JiFluidBE;
import net.fabricmc.fabric.api.transfer.v1.fluid.base.SingleFluidStorage;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.state.property.Properties;
import net.minecraft.storage.ReadView;
import net.minecraft.storage.WriteView;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import team.reborn.energy.api.EnergyStorage;

public abstract class JiMachineBE<T extends JiMachineBE<T, B, C, D>,
                         B extends SimpleInventory,
                         C extends SingleFluidStorage,
                         D extends EnergyStorage>
        extends JiFluidBE<T, B, C>
        implements IEnergyConnector<D>
{
    protected final EnergyConnector<D> energyStorage;

    public JiMachineBE(BlockEntityType<T> type, BlockPos pos, BlockState state)
    {
        super(type, pos, state);
        energyStorage = new EnergyConnector<>();
    }

    @Override
    public EnergyConnector<D> getEnergyConnector()
    {
        return this.energyStorage;
    }

    @Override
    protected void readData(ReadView view)
    {
        super.readData(view);
        energyStorage.readData(view);
    }

    @Override
    protected void writeData(WriteView view)
    {
        super.writeData(view);
        energyStorage.writeData(view);
    }

    @SuppressWarnings("unchecked")
    public D getEnergyStorage(Direction direction)
    {
        if(world == null)
            return null;
        if(world.getBlockState(pos).getProperties().contains(Properties.FACING))
            return this.energyStorage.getStorageProvider(direction, world.getBlockState(pos).get(Properties.FACING));
        return (D) this.energyStorage.getStorage(direction);
    }

    public D getEnergyStorage(MappedDirection direction)
    {
        return getEnergyStorage(MappedDirection.toDirection(direction));
    }
}