package jiraiyah.jiralib.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractHorizontalFacingBlock extends HorizontalFacingBlock
{
    private final boolean faceOpposite;

    protected MapCodec<? extends AbstractHorizontalFacingBlock> CODEC;

    protected AbstractHorizontalFacingBlock(Settings settings, boolean faceOpposite)
    {
        super(settings);
        this.faceOpposite = faceOpposite;
        setDefaultState(getDefaultState().with(FACING, Direction.NORTH));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder)
    {
        super.appendProperties(builder);
        builder.add(FACING);
    }

    @Override
    public @Nullable BlockState getPlacementState(ItemPlacementContext ctx)
    {
        return this.getDefaultState().with(FACING, this.faceOpposite
                                                   ? ctx.getPlayerLookDirection().getOpposite()
                                                   : ctx.getPlayerLookDirection());
    }

    @Override
    protected MapCodec<? extends HorizontalFacingBlock> getCodec()
    {
        return CODEC;
    }
}