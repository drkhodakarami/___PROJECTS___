package jiraiyah.ultraio.screen.handler;

import jiraiyah.jibase.records.BlockPosPayload;
import jiraiyah.jinventory.base.InventoryConnector;
import jiraiyah.jinventory.screen.JInventorySH;
import jiraiyah.ultraio.blockentity.machine.GemCleanerBE;
import jiraiyah.ultraio.registry.ModBlocks;
import jiraiyah.ultraio.registry.ModScreenHandlers;
import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.slot.Slot;

import java.util.List;

public class GemCleanerSH extends JInventorySH<GemCleanerBE>
{
    public GemCleanerSH(int syncId, PlayerInventory playerInventory, BlockPosPayload payload)
    {
        super(ModScreenHandlers.GEM_CLEANER, syncId, playerInventory, payload);
    }

    public GemCleanerSH(int syncId, PlayerInventory playerInventory, InventoryConnector<?> inventory, GemCleanerBE blockEntity)
    {
        super(ModScreenHandlers.GEM_CLEANER, syncId, playerInventory, inventory, blockEntity);
    }

    @Override
    public void onClosed(PlayerEntity player)
    {
        super.onClosed(player);
    }

    //@Override
    protected void addSlots()
    {
        this.addSlot(new Slot(inventory.getInventory(GemCleanerBE.INPUT_INVENTORY_INDEX), GemCleanerBE.GEM_INPUT_SLOT, 113, 29));
        this.addSlot(new Slot(inventory.getInventory(GemCleanerBE.INPUT_INVENTORY_INDEX), GemCleanerBE.WATER_BUCKET_SLOT, 40, 18));
        this.addSlot(new Slot(inventory.getInventory(GemCleanerBE.OUTPUT_INVENTORY_INDEX), GemCleanerBE.OUTPUT_SLOT, 113, 74));
        this.addSlot(new Slot(inventory.getInventory(GemCleanerBE.OUTPUT_INVENTORY_INDEX), GemCleanerBE.EMPTY_BUCKET_SLOT, 40, 86));
        this.addSlot(new Slot(inventory.getInventory(GemCleanerBE.UPGRADE_INPUT_INVENTORY_INDEX), GemCleanerBE.ENERGY_UPGRADE_SLOT, 8, 28));
        this.addSlot(new Slot(inventory.getInventory(GemCleanerBE.UPGRADE_INPUT_INVENTORY_INDEX), GemCleanerBE.SPEED_UPGRADE_SLOT, 8, 54));
        this.addSlot(new Slot(inventory.getInventory(GemCleanerBE.UPGRADE_INPUT_INVENTORY_INDEX), GemCleanerBE.FLUID_UPGRADE_SLOT, 8, 80));
    }

    @Override
    public int getInventorySize()
    {
        return GemCleanerBE.INVENTORY_SIZE;
    }

    @Override
    protected List<Block> getValidBlocks()
    {
        return List.of(ModBlocks.GEM_CLEANER);
    }

    @Override
    public int getPlayerInventoryY()
    {
        return 107;
    }
}