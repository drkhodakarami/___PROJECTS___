package jiraiyah.jibase.components;


import jiraiyah.jibase.annotations.*;
import jiraiyah.jibase.interfaces.IComponent;
import jiraiyah.jibase.interfaces.ISync;

@Developer("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/drkhodakarami/___PROJECTS___")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")

public class SyncedComponent implements IComponent
{
    private final ISync blockEntity;
    private boolean isDirty;

    public SyncedComponent(ISync blockEntity)
    {
        this.blockEntity = blockEntity;
    }

    public void sync()
    {
        if(this.isDirty)
        {
            this.isDirty = false;
            this.blockEntity.sync();
        }
    }
}