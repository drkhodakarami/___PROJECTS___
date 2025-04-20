package jiraiyah.jibase.components;

import jiraiyah.jibase.annotations.*;
import jiraiyah.jibase.interfaces.IComponent;
import jiraiyah.jibase.interfaces.IComponentConsumer;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

@Developer("TurtyWurty")
@ModifiedBy("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/DaRealTurtyWurty/Industria")
@Discord("https://discord.turtywurty.dev/")
@Youtube("https://www.youtube.com/@TurtyWurty")

public class ComponentContainer
{
    private final Map<Class<? extends IComponent>, IComponent> components = new HashMap<>();

    public <T extends IComponent> void addComponent(Class<T> clazz, T component)
    {
        this.components.put(clazz, component);
    }

    public <T extends IComponent> T getComponent(Class<T> clazz)
    {
        return clazz.cast(this.components.get(clazz));
    }

    public void removeComponent(Class<? extends IComponent> clazz)
    {
        this.components.remove(clazz);
    }

    public boolean hasComponent(Class<? extends IComponent> clazz)
    {
        return this.components.containsKey(clazz);
    }

    public void clear()
    {
        this.components.clear();
    }

    public Map<Class<? extends IComponent>, IComponent> getComponents()
    {
        return this.components;
    }

    public void forEach(IComponentConsumer<IComponent> consumer)
    {
        this.components.forEach((clazz, component) -> consumer.accept(component));
    }

    public Stream<IComponent> stream()
    {
        return this.components.values().stream();
    }
}