package jiraiyah.jibase.interfaces;

import jiraiyah.jibase.annotations.*;

@Developer("TurtyWurty")
@ModifiedBy("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/DaRealTurtyWurty/Industria")
@Discord("https://discord.turtywurty.dev/")
@Youtube("https://www.youtube.com/@TurtyWurty")

public interface IUpdatable
{
    boolean update();
    void onTickEnd();

    default boolean updateClient()
    {
        return true;
    }
    default void onTickClientEnd(){}
}