package jiraiyah.jiralib.interfaces;

// Author: turtywurty
// https://github.com/DaRealTurtyWurty/Industria
public interface ISyncedTick extends ITick, ISync
{
    void onTick();
    void onTickClient();

    @Override
    default void tick()
    {
        onTick();

        if(getSyncables() != null && !getSyncables().isEmpty())
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