package jiraiyah.jibase.interfaces;

import jiraiyah.jibase.annotations.*;

import java.util.List;

@Developer("TurtyWurty")
@ModifiedBy("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/DaRealTurtyWurty/Industria")
@Discord("https://discord.turtywurty.dev/")
@Youtube("https://www.youtube.com/@TurtyWurty")

public interface ISync
{
    void sync();

    default List<ISync> getSyncables()
    {
        return List.of();
    }
}