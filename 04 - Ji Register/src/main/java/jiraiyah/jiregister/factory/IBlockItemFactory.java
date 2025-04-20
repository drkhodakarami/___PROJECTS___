package jiraiyah.jiregister.factory;

import jiraiyah.jibase.annotations.*;
import net.minecraft.block.Block;

@Developer("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/drkhodakarami/___PROJECTS___")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")

public interface IBlockItemFactory<U, R>
{
    R apply(Block block, U settings);
}