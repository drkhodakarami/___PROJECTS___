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