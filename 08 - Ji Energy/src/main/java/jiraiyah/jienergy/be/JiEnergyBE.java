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

package jiraiyah.jienergy.be;

import jiraiyah.jibase.constants.BEKeys;
import jiraiyah.jibase.enumerations.MappedDirection;
import jiraiyah.jibase.records.BlockPosPayload;
import jiraiyah.jienergy.base.EnergyConnector;
import jiraiyah.jienergy.interfaces.IEnergyConnector;
import jiraiyah.jiralib.blockentity.JiScreenBE;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.state.property.Properties;
import net.minecraft.storage.ReadView;
import net.minecraft.storage.WriteView;
import net.minecraft.util.dynamic.Codecs;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import team.reborn.energy.api.EnergyStorage;

@SuppressWarnings("UnusedReturnValue")
public abstract class JiEnergyBE <T extends JiEnergyBE<T, B>, B extends EnergyStorage> extends JiScreenBE<T, BlockPosPayload>
        implements IEnergyConnector<B>
{
    protected final EnergyConnector<B> energyStorage;

    public JiEnergyBE(BlockEntityType<T> type, BlockPos pos, BlockState state)
    {
        super(type, pos, state);
        energyStorage = new EnergyConnector<>();
    }

    @Override
    public BlockPosPayload getScreenOpeningData(ServerPlayerEntity player)
    {
        return new BlockPosPayload(this.pos);
    }

    @Override
    public EnergyConnector<B> getEnergyConnector()
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
    public B getEnergyStorage(Direction direction)
    {
        if(world == null)
            return null;
        if(world.getBlockState(pos).getProperties().contains(Properties.FACING))
            return this.energyStorage.getStorageProvider(direction, world.getBlockState(pos).get(Properties.FACING));
        return (B) this.energyStorage.getStorage(direction);
    }

    public B getEnergyStorage(MappedDirection direction)
    {
        return getEnergyStorage(MappedDirection.toDirection(direction));
    }
}