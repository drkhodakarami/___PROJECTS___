package jiraiyah.jiralib.block;

import jiraiyah.jiralib.interfaces.ITick;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public abstract class BlockWithITickBE extends Block implements BlockEntityProvider
{
    public BlockWithITickBE(Settings settings)
    {
        super(settings);
    }

    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type)
    {
        return ITick.createTicker(world);
    }
}