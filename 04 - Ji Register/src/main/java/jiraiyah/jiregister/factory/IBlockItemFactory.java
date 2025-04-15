package jiraiyah.jiregister.factory;

import net.minecraft.block.Block;

public interface IBlockItemFactory<U, R>
{
    R apply(Block block, U settings);
}