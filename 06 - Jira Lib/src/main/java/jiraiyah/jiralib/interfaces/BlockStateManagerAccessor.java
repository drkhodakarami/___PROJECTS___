package jiraiyah.jiralib.interfaces;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.StateManager;

public interface BlockStateManagerAccessor
{
    void setStateManager(StateManager<Block, BlockState> newStateManager);
}