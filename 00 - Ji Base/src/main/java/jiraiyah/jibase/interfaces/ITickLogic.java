package jiraiyah.jibase.interfaces;

import jiraiyah.jibase.annotations.*;
import jiraiyah.jibase.properties.BEProperties;
import jiraiyah.jibase.properties.BlockEntityFields;
import net.minecraft.block.entity.BlockEntity;

@Developer("TurtyWurty")
@ModifiedBy("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/DaRealTurtyWurty/Industria")
@Discord("https://discord.turtywurty.dev/")
@Youtube("https://www.youtube.com/@TurtyWurty")

public interface ITickLogic<T extends BlockEntity, U extends BlockEntityFields<T>>
{
    void tick(BEProperties<T> properties);

    void tickClient(BEProperties<T> properties);
}