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
import jiraiyah.jibase.interfaces.IFieldGetter;
import jiraiyah.jibase.interfaces.IFieldSetter;
import net.minecraft.block.entity.BlockEntity;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
@Developer("TurtyWurty")
@ModifiedBy("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/DaRealTurtyWurty/Industria")
@Discord("https://discord.turtywurty.dev/")
@Youtube("https://www.youtube.com/@TurtyWurty")

public class BlockEntityFields<B extends BlockEntity>
{
    private final Map<String, BlockEntityField<?, B>> fields = new HashMap<>();

    public  <T> BlockEntityField<T, B> addField(String name, T defaultValue)
    {
        BlockEntityField<T, B> field = new BlockEntityField<>(defaultValue);
        this.fields.put(name, field);
        return field;
    }

    public <T> BlockEntityField<T, B> addField(String name, T defaultValue, IFieldGetter<T, B> getter, IFieldSetter<T, B> setter)
    {
        BlockEntityField<T, B> field = new BlockEntityField<>(defaultValue, getter, setter);
        this.fields.put(name, field);
        return field;
    }

    public boolean containsField(String name)
    {
        return this.fields.containsKey(name);
    }

    //region GET FIELD
    public <T> BlockEntityField<T, B> getField(String name, Class<T> type)
    {
        try
        {
            if(!containsField(name))
                throw new IllegalArgumentException("Field does not exist: " + name);

            BlockEntityField<?, B> field = this.fields.get(name);
            if(field == null)
                throw new IllegalArgumentException("Field does not exist: " + name);

            if(type.isInstance(field.getValue()))
                //noinspection unchecked
                return (BlockEntityField<T, B>) field;
            else
                throw new IllegalArgumentException("Field with name '" + name + "' is not of type " + type.getSimpleName());
        }
        catch (ClassCastException e)
        {
            throw new IllegalArgumentException("Field with name '" + name + "' is not of type " + type.getSimpleName());
        }
    }

    public <T> T getFieldValue(String name, Class<T> type, B blockEntity)
    {
        return getField(name, type).get(blockEntity);
    }

    public int getFieldValueInt(String name, B blockEntity)
    {
        return getFieldValue(name, Integer.class, blockEntity);
    }

    public long getFieldValueLong(String name, B blockEntity)
    {
        return getFieldValue(name, Long.class, blockEntity);
    }

    public float getFieldValueFloat(String name, B blockEntity)
    {
        return getFieldValue(name, Float.class, blockEntity);
    }

    public double getFieldValueDouble(String name, B blockEntity)
    {
        return getFieldValue(name, Double.class, blockEntity);
    }

    public boolean getFieldValueBoolean(String name, B blockEntity)
    {
        return getFieldValue(name, Boolean.class, blockEntity);
    }

    public String getFieldValueString(String name, B blockEntity)
    {
        return getFieldValue(name, String.class, blockEntity);
    }
    //endregion

    //region SET FIELD
    public <T> void setFieldValue(String name, Class<T> type, B blockEntity, T value)
    {
        getField(name, type).set(blockEntity, value);
    }

    public void setFieldValueInt(String name, B blockEntity, int value)
    {
        setFieldValue(name, Integer.class, blockEntity, value);
    }

    public void setFieldValueLong(String name, B blockEntity, long value)
    {
        setFieldValue(name, Long.class, blockEntity, value);
    }

    public void setFieldValueFloat(String name, B blockEntity, float value)
    {
        setFieldValue(name, Float.class, blockEntity, value);
    }

    public void setFieldValueDouble(String name, B blockEntity, double value)
    {
        setFieldValue(name, Double.class, blockEntity, value);
    }

    public void setFieldValueBoolean(String name, B blockEntity, boolean value)
    {
        setFieldValue(name, Boolean.class, blockEntity, value);
    }

    public void setFieldValueString(String name, B blockEntity, String value)
    {
        setFieldValue(name, String.class, blockEntity, value);
    }
    //endregion
}