package jiraiyah.jibase.interfaces;

import jiraiyah.jibase.annotations.*;
import jiraiyah.jibase.enumerations.MappedDirection;
import net.minecraft.util.math.Direction;

@Developer("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/drkhodakarami/___PROJECTS___")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")

public interface IStorageProvider<T>
{
    T getStorageProvider(MappedDirection direction);

    T getStorageProvider(Direction direction);
}