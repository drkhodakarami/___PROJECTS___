package jiraiyah.jibase.interfaces;

import jiraiyah.jibase.annotations.*;

@Developer("TurtyWurty")
@ModifiedBy("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/DaRealTurtyWurty/Industria")
@Discord("https://discord.turtywurty.dev/")
@Youtube("https://www.youtube.com/@TurtyWurty")

@FunctionalInterface
public interface IComponentConsumer<T extends IComponent>
{
    void accept(T component);
}