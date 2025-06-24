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

package jiraiyah.jienergy.base;

import jiraiyah.jibase.enumerations.MappedDirection;
import jiraiyah.jibase.interfaces.IStorageConnector;
import jiraiyah.jibase.interfaces.IStorageProvider;
import jiraiyah.jibase.utils.PosHelper;
import jiraiyah.jiralib.util.StorageConnector;
import net.fabricmc.fabric.api.transfer.v1.transaction.Transaction;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.Nullable;
import team.reborn.energy.api.EnergyStorage;
import team.reborn.energy.api.base.SimpleEnergyStorage;

public class EnergyConnector<T extends EnergyStorage> extends StorageConnector<EnergyStorage>
        implements IStorageConnector<EnergyConnector<T>>, IStorageProvider<T>
{
    @Override
    public NbtList writeNbt(RegistryWrapper.WrapperLookup wrapperLookup)
    {
        NbtList list = new NbtList();
        for(EnergyStorage storage : storages)
        {
            NbtCompound nbt = new NbtCompound();
            nbt.putLong("Amount", storage.getAmount());
            list.add(nbt);
        }
        return list;
    }

    @Override
    public void readNbt(NbtList nbt, RegistryWrapper.WrapperLookup wrapperLookup)
    {
        for (int index = 0; index < nbt.size(); index++)
        {
            NbtCompound compound = nbt.getCompoundOrEmpty(index);
            EnergyStorage storage = this.storages.get(index);
            long amount = compound.getLong("Amount", 0L);
            long capacity = compound.getLong("Capacity", 0L);
            if(storage instanceof SimpleEnergyStorage simpleEnergyStorage)
                simpleEnergyStorage.amount = amount;
            else
            {
                try(Transaction transaction = Transaction.openOuter())
                {
                    long current = storage.getAmount();
                    if(current < amount)
                        storage.insert(amount - current, transaction);
                    else
                        storage.extract(current - amount, transaction);
                    transaction.commit();
                }
            }
        }
    }

    @Override
    public EnergyConnector<T> getConnector()
    {
        return this;
    }

    @SuppressWarnings("unchecked")
    @Override
    public @Nullable T getStorageProvider(MappedDirection direction, Direction facing)
    {
        Direction side = PosHelper.relativeDirection(MappedDirection.toDirection(direction), facing);
        if(this.getSidedMap().containsKey(MappedDirection.fromDirection(side)))
            return (T) getStorage(side);
        return null;
    }

    @SuppressWarnings("unchecked")
    public T getStorageProvider(Direction direction, Direction facing)
    {
        Direction side = PosHelper.relativeDirection(direction, facing);
        if(this.getSidedMap().containsKey(MappedDirection.fromDirection(side)))
            return (T) getStorage(side);
        return null;
    }

    public long getAmount(MappedDirection direction)
    {
        return getStorage(direction).getAmount();
    }

    public long getAmount(Direction direction)
    {
        return getStorage(direction).getAmount();
    }

    public long getAmount(int index)
    {
        return getStorage(index).getAmount();
    }

    public long getCapacity(MappedDirection direction)
    {
        return getStorage(direction).getCapacity();
    }

    public long getCapacity(Direction direction)
    {
        return getStorage(direction).getCapacity();
    }

    public long getCapacity(int index)
    {
        return getStorage(index).getCapacity();
    }
}