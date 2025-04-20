package jiraiyah.jiregister.factory;

import jiraiyah.jibase.annotations.*;
import net.minecraft.item.ToolMaterial;

@Developer("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/drkhodakarami/___PROJECTS___")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")

public interface IToolFactory<U, R>
{
    R apply(ToolMaterial material, Float damage, float speed, U settings);
}