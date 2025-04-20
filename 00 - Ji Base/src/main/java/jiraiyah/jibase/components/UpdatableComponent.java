package jiraiyah.jibase.components;


import jiraiyah.jibase.annotations.*;
import jiraiyah.jibase.interfaces.IComponent;
import jiraiyah.jibase.interfaces.IUpdatable;

@Developer("TurtyWurty")
@ModifiedBy("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/DaRealTurtyWurty/Industria")
@Discord("https://discord.turtywurty.dev/")
@Youtube("https://www.youtube.com/@TurtyWurty")

public class UpdatableComponent implements IComponent
{
    private final IUpdatable blockEntity;
    private boolean isDirty;
    private boolean isDirtyClient;

    public UpdatableComponent(IUpdatable blockEntity)
    {
        this.blockEntity = blockEntity;
    }

    public void update()
    {
        if(this.isDirty)
            this.isDirty = !this.blockEntity.update();
    }

    public void updateClient()
    {
        if(this.isDirtyClient)
            this.isDirtyClient = !this.blockEntity.updateClient();
    }
}