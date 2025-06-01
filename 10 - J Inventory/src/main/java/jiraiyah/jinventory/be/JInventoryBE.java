package jiraiyah.jinventory.be;

import jiraiyah.jiralib.blockentity.SyncedBE;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;

public class JInventoryBE<T extends JInventoryBE<T>> extends SyncedBE<T>
{
    public JInventoryBE(BlockEntityType<T> type, BlockPos pos, BlockState state)
    {
        super(type, pos, state);
    }
}