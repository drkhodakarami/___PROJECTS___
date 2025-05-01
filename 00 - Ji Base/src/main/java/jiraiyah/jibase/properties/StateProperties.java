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
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Developer("TurtyWurty")
@ModifiedBy("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/DaRealTurtyWurty/Industria")
@Discord("https://discord.turtywurty.dev/")
@Youtube("https://www.youtube.com/@TurtyWurty")

public class StateProperties
{
    private final Map<String, StateProperty<?>> properties = new ConcurrentHashMap<>();

    public void addHorizontalFacing()
    {
        addProperty(new StateProperty<>(Properties.HORIZONTAL_FACING, Direction.NORTH));
    }

    public void addFacing()
    {
        addProperty(new StateProperty<>(Properties.FACING, Direction.NORTH));
    }

    public void addAxis()
    {
        addProperty(new StateProperty<>(Properties.AXIS, Direction.Axis.Y));
    }

    public void addEnabled()
    {
        addProperty(new StateProperty<>(Properties.ENABLED, true));
    }

    public void addLocked()
    {
        addProperty(new StateProperty<>(Properties.LOCKED, false));
    }

    public void addPowered()
    {
        addProperty(new StateProperty<>(Properties.POWERED, false));
    }

    public void addLit()
    {
        addProperty(new StateProperty<>(Properties.LIT, false));
    }

    public void addWaterlogged()
    {
        addProperty(new StateProperty<>(Properties.WATERLOGGED, false));
    }

    public <T extends Comparable<T>> void addProperty(StateProperty<T> property)
    {
        if (this.properties.containsKey(property.delegate().getName()))
            throw new IllegalArgumentException("Property with name: " + property.delegate().getName() + " already exists!");

        this.properties.put(property.delegate().getName(), property);
    }

    @SuppressWarnings("unchecked")
    public <T extends Comparable<T>> StateProperty<T> getProperty(String name, Class<T> type)
    {
        StateProperty<?> stateProperty = this.properties.get(name);
        if (stateProperty == null)
            throw new IllegalArgumentException("Property with name: " + name + " does not exist!");

        /*if(!type.isInstance(stateProperty.delegate().getType()))
            throw new IllegalArgumentException("Property with name: " + name + " is not of the correct type!");*/

        try
        {
            return (StateProperty<T>) stateProperty;
        }
        catch (ClassCastException e)
        {
            throw new IllegalArgumentException("Property with name: " + name + " is not of the correct type!");
        }
    }

    public <T extends Comparable<T>> Property<T> getProperty(Property<T> property)
    {
        String name = property.getName();
        return containsProperty(name) ? getProperty(name, property.getType()).delegate() : null;
    }

    public boolean containsProperty(String name)
    {
        return this.properties.containsKey(name);
    }

    public boolean containsProperty(Property<?> property)
    {
        return containsProperty(property.getName());
    }

    @SuppressWarnings("unchecked")
    public <T extends Comparable<T>> void setDefaultValue(String name, T value)
    {
        StateProperty<T> stateProperty = getProperty(name, (Class<T>) value.getClass());
        stateProperty.setDefaultValue(value);
    }

    private <T extends Comparable<T>> BlockState applyDefault(BlockState state, StateProperty<T> property)
    {
        return state.with(property.delegate(), property.defaultValue());
    }

    public @Nullable BlockState applyDefaults(@Nullable BlockState state)
    {
        if(state == null)
            return null;

        for (StateProperty<?> property : this.properties.values())
            state = applyDefault(state, property);

        return state;
    }

    public void addToBuilder(StateManager.Builder<Block, BlockState> builder)
    {
        for (StateProperty<?> property : this.properties.values())
            builder.add(property.delegate());
    }
}