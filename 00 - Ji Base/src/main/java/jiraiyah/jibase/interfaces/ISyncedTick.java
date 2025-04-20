package jiraiyah.jibase.interfaces;

import jiraiyah.jibase.annotations.*;

@Developer("TurtyWurty")
@ModifiedBy("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/DaRealTurtyWurty/Industria")
@Discord("https://discord.turtywurty.dev/")
@Youtube("https://www.youtube.com/@TurtyWurty")

public interface ISyncedTick extends ITick, ISync
{
    void onTick();
    void onTickClient();
    boolean shouldSync();

    @Override
    default void tick()
    {
        onTick();

        if(shouldSync() && getSyncables() != null && !getSyncables().isEmpty())
            getSyncables().forEach(ISync::sync);

        if(this instanceof IUpdatable updatable)
            updatable.onTickEnd();
    }

    @Override
    default void tickClient()
    {
        onTickClient();

        if(this instanceof IUpdatable updatable)
            updatable.onTickClientEnd();
    }
}