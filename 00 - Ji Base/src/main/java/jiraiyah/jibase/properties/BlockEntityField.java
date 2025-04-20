package jiraiyah.jibase.properties;

import jiraiyah.jibase.annotations.*;
import jiraiyah.jibase.interfaces.IFieldGetter;
import jiraiyah.jibase.interfaces.IFieldSetter;
import net.minecraft.block.entity.BlockEntity;
import org.jetbrains.annotations.Nullable;

@Developer("TurtyWurty")
@ModifiedBy("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/DaRealTurtyWurty/Industria")
@Discord("https://discord.turtywurty.dev/")
@Youtube("https://www.youtube.com/@TurtyWurty")

public class BlockEntityField<T, B extends BlockEntity>
{
    private final T value;
    private final @Nullable IFieldGetter<T, B> getter;
    private final @Nullable IFieldSetter<T, B> setter;

    //region CTOR
    public BlockEntityField(T value, @Nullable IFieldGetter<T, B> getter, @Nullable IFieldSetter<T, B> setter)
    {
        this.value = value;
        this.getter = getter;
        this.setter = setter;
    }

    public BlockEntityField(T value, @Nullable IFieldGetter<T, B> getter)
    {
        this(value, getter, null);
    }

    public BlockEntityField(T value, @Nullable IFieldSetter<T, B> setter)
    {
        this(value, null, setter);
    }

    public BlockEntityField(T value)
    {
        this(value, null, null);
    }
    //endregion

    public T getValue()
    {
        return this.value;
    }

    public @Nullable IFieldGetter<T, B> getGetter()
    {
        return this.getter;
    }

    public @Nullable IFieldSetter<T, B> getSetter()
    {
        return this.setter;
    }

    public T get(B blockEntity)
    {
        return this.getter != null ? this.getter.get(blockEntity) : this.value;
    }

    public void set(B blockEntity, T value)
    {
        if(this.setter != null)
            this.setter.set(blockEntity, value);
    }
}