package jiraiyah.jiralib.mixin;

import jiraiyah.jiralib.interfaces.BlockStateManagerAccessor;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.StateManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

//TODO: Explain the usage of mixin
@Mixin(Block.class)
public class BlockMixin implements BlockStateManagerAccessor
{
    //@Shadow is used to reference the stateManager field in the Block class
    @Shadow
    //@Mutable removes the final modifier, allowing the field to be updated
    @Mutable
    protected StateManager<Block, BlockState> stateManager;

    @Override
    public void setStateManager(StateManager<Block, BlockState> newStateManager)
    {
        this.stateManager = newStateManager;
    }
}