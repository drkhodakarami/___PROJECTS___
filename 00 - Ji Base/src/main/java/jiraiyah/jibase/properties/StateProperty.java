package jiraiyah.jibase.properties;

import jiraiyah.jibase.annotations.*;
import net.minecraft.state.property.Property;

@Developer("TurtyWurty")
@ModifiedBy("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/DaRealTurtyWurty/Industria")
@Discord("https://discord.turtywurty.dev/")
@Youtube("https://www.youtube.com/@TurtyWurty")

public class StateProperty<T extends Comparable<T>>
{
    private final Property<T> delegate;
    private T defaultValue;

    public StateProperty(Property<T> delegate, T defaultValue)
    {
        this.delegate = delegate;
        this.defaultValue = defaultValue;
    }

    public Property<T> delegate()
    {
        return this.delegate;
    }

    public T defaultValue()
    {
        return this.defaultValue;
    }

    public void setDefaultValue(T defaultValue)
    {
        this.defaultValue = defaultValue;
    }
}