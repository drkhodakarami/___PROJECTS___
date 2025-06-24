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

package jiraiyah.jifluid.base;

import com.mojang.datafixers.util.Pair;
import jiraiyah.jibase.enumerations.MappedDirection;
import jiraiyah.jibase.interfaces.IStorageConnector;
import jiraiyah.jibase.interfaces.IStorageProvider;
import jiraiyah.jibase.records.FluidStackPayload;
import jiraiyah.jibase.utils.PosHelper;
import jiraiyah.jiralib.util.StorageConnector;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.fluid.base.SingleFluidStorage;
import net.fabricmc.fabric.api.transfer.v1.item.InventoryStorage;
import net.fabricmc.fabric.api.transfer.v1.storage.Storage;
import net.fabricmc.fabric.api.transfer.v1.storage.base.CombinedStorage;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.nbt.NbtOps;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.math.Direction;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class FluidConnector<T extends SingleFluidStorage> extends StorageConnector<T>
        implements IStorageConnector<FluidConnector<T>>, IStorageProvider<T>
{
    private final CombinedStorage<FluidVariant, T> combinedStorage = new CombinedStorage<>(this.storages);

    @Override
    public NbtList writeNbt(RegistryWrapper.WrapperLookup wrapperLookup)
    {
        var list = new NbtList();
        this.storages.forEach(storage -> {
            if(storage instanceof SingleFluidStorage singleFluidStorage)
            {
                NbtCompound nbt = new NbtCompound();
                nbt.putLong("Amount", singleFluidStorage.getAmount());
                nbt.put("Fluid", FluidVariant.CODEC.encode(singleFluidStorage.getResource(), NbtOps.INSTANCE, new NbtCompound()).getOrThrow());
                list.add(nbt);
            }
        });

        return list;
    }

    @Override
    public void readNbt(NbtList nbt, RegistryWrapper.WrapperLookup wrapperLookup)
    {
        for (int index = 0; index < nbt.size(); index++)
        {
            NbtCompound compound = nbt.getCompoundOrEmpty(index);
            T storage = this.storages.get(index);

            if(storage == null)
                continue;

            if(storage instanceof SingleFluidStorage singleFluidStorage)
            {
                singleFluidStorage.amount = compound.getLong("Amount", 0L);
                singleFluidStorage.variant = FluidVariant.CODEC.decode(NbtOps.INSTANCE, compound.get("Fluid"))
                        .map(Pair::getFirst)
                        .getOrThrow();
            }
            else
                throw new UnsupportedOperationException("Unsupported storage type: " + storage.getClass().getName());
        }
    }

    public CombinedStorage<FluidVariant, T> getCombinedStorage()
    {
        return combinedStorage;
    }

    public List<FluidStackPayload> getFluids()
    {
        List<FluidStackPayload> fluids = new ArrayList<>();
        this.storages.forEach(storage -> {
            storage.nonEmptyViews().forEach(fluidContainer -> {
                fluids.add(new FluidStackPayload(fluidContainer.getResource(), fluidContainer.getAmount()));
            });
        });
        return fluids;
    }

    public void addStorage(BlockEntity blockEntity, int size, BiFunction<BlockEntity, Integer, T> factory)
    {
        addStorage(factory.apply(blockEntity, size));
    }

    public void addStorage(BlockEntity blockEntity, int size, MappedDirection side, BiFunction<BlockEntity, Integer, T> factory)
    {
        addStorage(factory.apply(blockEntity, size), side);
    }

    public void addStorage(BlockEntity blockEntity, int size, Direction side, BiFunction<BlockEntity, Integer, T> factory)
    {
        addStorage(factory.apply(blockEntity, size), side);
    }

    public long getAmount(MappedDirection direction)
    {
        return getStorage(direction).getAmount();
    }

    public long getCapacity(MappedDirection direction)
    {
        return getStorage(direction).getCapacity();
    }

    public FluidVariant getVariant(MappedDirection direction)
    {
        return getStorage(direction).getResource();
    }

    public long getAmount(int index)
    {
        return getStorage(index).getAmount();
    }

    public long getCapacity(int index)
    {
        return getStorage(index).getCapacity();
    }

    public FluidVariant getVariant(int index)
    {
        return getStorage(index).getResource();
    }

    @Override
    public FluidConnector<T> getConnector()
    {
        return this;
    }

    @Override
    public T getStorageProvider(MappedDirection direction, Direction facing)
    {

        Direction side = PosHelper.relativeDirection(MappedDirection.toDirection(direction), facing);
        if(this.getSidedMap().containsKey(MappedDirection.fromDirection(side)))
            return getStorage(side);
        return null;
    }

    @Override
    public T getStorageProvider(Direction direction, Direction facing)
    {
        Direction side = PosHelper.relativeDirection(direction, facing);
        if(this.getSidedMap().containsKey(MappedDirection.fromDirection(side)))
            return getStorage(side);
        return null;
    }
}