package jiraiyah.jiralib.util;

import jiraiyah.jiralib.interfaces.IBEFactory;
import jiraiyah.jiralib.interfaces.IBETickerFactory;
import jiraiyah.jiralib.interfaces.ITick;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;

import java.util.function.Supplier;

public class BlockBlockEntityProperties<T extends BlockEntity>
{
    private final Supplier<BlockEntityType<T>> blockEntityTypeSupplier;
    private boolean shouldTick = false;
    private IBEFactory<T> blockEntityFactory;
    private IBETickerFactory<T> blockEntityTicker = (world, state, type) -> ITick.createTicker(world);
    //private MultiblockProperties<T> multiblockProperties;
    private boolean rightClickToOpenGui = false;
    private boolean dropContentsOnBreak = false;

    public BlockBlockEntityProperties(Supplier<BlockEntityType<T>> blockEntityTypeSupplier) {
        this.blockEntityTypeSupplier = blockEntityTypeSupplier;
        this.blockEntityFactory = (pos, state) -> this.blockEntityTypeSupplier.get().instantiate(pos, state);
    }

    public BlockBlockEntityProperties<T> shouldTick() {
        return shouldTick(true);
    }

    public BlockBlockEntityProperties<T> shouldTick(boolean shouldTick) {
        this.shouldTick = shouldTick;
        return this;
    }

    public BlockBlockEntityProperties<T> blockEntityFactory(IBEFactory<T> blockEntityFactory) {
        this.blockEntityFactory = blockEntityFactory;
        return this;
    }

    public BlockBlockEntityProperties<T> blockEntityTickerFactory(IBETickerFactory<T> blockEntityTicker) {
        this.blockEntityTicker = blockEntityTicker;
        return this;
    }

    //public MultiblockProperties<T> multiblockProperties(MultiblockType<T> type) {
    //    return new MultiblockProperties<>(this, type);
    //}

    public BlockBlockEntityProperties<T> rightClickToOpenGui() {
        return rightClickToOpenGui(true);
    }

    public BlockBlockEntityProperties<T> rightClickToOpenGui(boolean rightClickToOpenGui) {
        this.rightClickToOpenGui = rightClickToOpenGui;
        return this;
    }

    public BlockBlockEntityProperties<T> dropContentsOnBreak() {
        return dropContentsOnBreak(true);
    }

    public BlockBlockEntityProperties<T> dropContentsOnBreak(boolean dropContentsOnBreak) {
        this.dropContentsOnBreak = dropContentsOnBreak;
        return this;
    }
}