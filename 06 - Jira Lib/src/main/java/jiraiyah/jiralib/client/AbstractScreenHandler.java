package jiraiyah.jiralib.client;

import jiraiyah.jibase.annotations.*;
import jiraiyah.jiralib.record.BlockPosPayload;
import jiraiyah.jiralib.util.CachedBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.Slot;
import net.minecraft.world.World;

import java.util.List;

@Developer("TurtyWurty")
@ModifiedBy("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/DaRealTurtyWurty/Industria")
@Discord("https://discord.turtywurty.dev/")
@Youtube("https://www.youtube.com/@TurtyWurty")

public abstract class AbstractScreenHandler <T extends BlockEntity> extends ScreenHandler
{
    protected final T blockEntity;
    protected final ScreenHandlerContext context;
    protected final World world;
    protected final Block block;
    protected final PlayerInventory playerInventory;

    public AbstractScreenHandler(ScreenHandlerType<?> type, int syncID, PlayerInventory playerInventory, BlockPosPayload payload, Class<T> blockEntityClass)
    {
        this(type, syncID, playerInventory, payload, new CachedBlockEntity<> (blockEntityClass));
    }

    public AbstractScreenHandler(ScreenHandlerType<?> type, int syncID, PlayerInventory playerInventory, BlockPosPayload payload, CachedBlockEntity<T> cachedBE)
    {
        this(type, syncID, playerInventory, cachedBE.apply(playerInventory, payload.pos()));
    }

    public AbstractScreenHandler(ScreenHandlerType<?> type, int syncId, PlayerInventory playerInventory, T blockEntity)
    {
        super(type, syncId);
        this.world = playerInventory.player.getWorld();
        this.blockEntity = blockEntity;
        this.context = ScreenHandlerContext.create(this.world, this.blockEntity.getPos());
        this.playerInventory = playerInventory;
        this.block = this.world.getBlockState(this.blockEntity.getPos()).getBlock();

        addSlots(playerInventory);
        addPlayerSlots(playerInventory, getPlayerInventoryX(), getPlayerInventoryY());
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int slotIndex)
    {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(slotIndex);
        if (!slot.hasStack())
            return newStack;

        ItemStack stackInSlot = slot.getStack();
        newStack = stackInSlot.copy();
        if(slotIndex < getInventorySize())
        {
            if(!insertItem(stackInSlot, this.slots.size() - 9, this.slots.size(), true))
                if(!insertItem(stackInSlot, this.slots.size() - 36, this.slots.size() - 9, false))
                    return ItemStack.EMPTY;
        }
        else
        {
            if(!insertItem(stackInSlot, 0, getInventorySize(), false))
                return ItemStack.EMPTY;
        }

        if(stackInSlot.isEmpty())
            slot.setStack(ItemStack.EMPTY);
        else
            slot.markDirty();

        return newStack;
    }

    @Override
    public boolean canUse(PlayerEntity player)
    {
        boolean validBlock = false;
        for (Block block : getValidBlocks())
        {
            if(canUse(this.context, player, block))
            {
                validBlock = true;
                break;
            }
        }
        return validBlock;
    }

    public T getBlockEntity()
    {
        return this.blockEntity;
    }

    protected abstract void addSlots(PlayerInventory playerInventory);
    protected abstract int getInventorySize();
    protected abstract List<Block> getValidBlocks();
    protected abstract int getPlayerInventoryY();

    protected int getPlayerInventoryX()
    {
        return 8;
    }
}