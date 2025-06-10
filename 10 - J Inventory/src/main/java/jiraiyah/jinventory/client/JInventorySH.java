package jiraiyah.jinventory.client;

import jiraiyah.jibase.annotations.*;
import jiraiyah.jinventory.base.InventoryConnector;
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
import java.util.concurrent.atomic.AtomicInteger;

@Developer("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/drkhodakarami/___PROJECTS___")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")
public abstract class JInventorySH<T extends BlockEntity> extends ScreenHandler
{
    protected final T blockEntity;
    protected final ScreenHandlerContext context;
    protected final World world;
    protected final Block block;
    protected final PlayerInventory playerInventory;
    protected final InventoryConnector<?> inventory;

    public JInventorySH(ScreenHandlerType<?> type, int syncID, PlayerInventory playerInventory, InventoryConnector<?> inventory, BlockPosPayload payload, Class<T> blockEntityClass)
    {
        this(type, syncID, playerInventory, inventory, payload, new CachedBlockEntity<>(blockEntityClass));
    }

    public JInventorySH(ScreenHandlerType<?> type, int syncID, PlayerInventory playerInventory, InventoryConnector<?> inventory, BlockPosPayload payload, CachedBlockEntity<T> cachedBE)
    {
        this(type, syncID, playerInventory, inventory, cachedBE.apply(playerInventory, payload.pos()));
    }

    public JInventorySH(ScreenHandlerType<?> type, int syncId, PlayerInventory playerInventory, BlockPosPayload payload)
    {
        //noinspection unchecked
        this(type, syncId, playerInventory, null, (T) playerInventory.player.getWorld().getBlockEntity(payload.pos()));
    }

    public JInventorySH(ScreenHandlerType<?> type, int syncId, PlayerInventory playerInventory, InventoryConnector<?> inventory, T blockEntity)
    {
        super(type, syncId);
        this.world = playerInventory.player.getWorld();
        this.blockEntity = blockEntity;
        this.context = ScreenHandlerContext.create(this.world, this.blockEntity.getPos());
        this.playerInventory = playerInventory;
        this.block = this.world.getBlockState(this.blockEntity.getPos()).getBlock();
        this.inventory = inventory;
        this.inventory.checkSize(getInventorySize());
        this.addSlots(playerInventory);
        this.addPlayerSlots(playerInventory, this.getPlayerInventoryX(), this.getPlayerInventoryY());
        this.inventory.onOpen(playerInventory.player);
    }

    @Override
    public void onClosed(PlayerEntity player)
    {
        super.onClosed(player);
        this.inventory.onClose(player);
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int slotIndex) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = (Slot)this.slots.get(slotIndex);
        if (!slot.hasStack()) {
            return newStack;
        } else {
            ItemStack stackInSlot = slot.getStack();
            newStack = stackInSlot.copy();
            if (slotIndex < this.getInventorySize()) {
                if (!this.insertItem(stackInSlot, this.slots.size() - 9, this.slots.size(), true) && !this.insertItem(stackInSlot, this.slots.size() - 36, this.slots.size() - 9, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(stackInSlot, 0, this.getInventorySize(), false)) {
                return ItemStack.EMPTY;
            }

            if (stackInSlot.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }

            return newStack;
        }
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        boolean validBlock = false;

        for(Block block : this.getValidBlocks()) {
            if (canUse(this.context, player, block)) {
                validBlock = true;
                break;
            }
        }

        return validBlock;
    }

    public T getBlockEntity() {
        return this.blockEntity;
    }

    protected abstract void addSlots(PlayerInventory var1);

    protected int getInventorySize()
    {
        AtomicInteger total = new AtomicInteger();
        this.inventory.getInventories().forEach(inv -> total.addAndGet(inv.size()));
        return total.get();
    }

    protected abstract List<Block> getValidBlocks();

    protected abstract int getPlayerInventoryY();

    protected int getPlayerInventoryX() {
        return 8;
    }
}