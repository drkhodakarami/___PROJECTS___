package jiraiyah.ultraio.screen.handler;

import jiraiyah.jiralib.client.AbstractScreenHandler;
import jiraiyah.jiralib.record.BlockPosPayload;
import jiraiyah.ultraio.be.machine.GemCleanerBE;
import jiraiyah.ultraio.block.machine.GemCleaner;
import jiraiyah.ultraio.registry.ModBlocks;
import jiraiyah.ultraio.registry.ModScreenHandlers;
import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.slot.Slot;

import java.util.List;

import static jiraiyah.ultraio.Main.REFERENCE;

public class GemCleanerScreenHandler extends AbstractScreenHandler<GemCleanerBE>
{
    private SimpleInventory inventory;

    public GemCleanerScreenHandler(int syncId, PlayerInventory playerInventory, BlockPosPayload blockPosPayload)
    {
        this(syncId, playerInventory, (GemCleanerBE) playerInventory.player.getWorld().getBlockEntity(blockPosPayload.pos()));
    }

    public GemCleanerScreenHandler(int syncId, PlayerInventory playerInventory, GemCleanerBE blockEntity)
    {
        super(ModScreenHandlers.GEM_CLEANER, syncId, playerInventory, blockEntity);
        this.inventory.onOpen(playerInventory.player);
    }

    @Override
    public void onClosed(PlayerEntity player)
    {
        super.onClosed(player);
        this.inventory.onClose(player);
    }

    @Override
    protected void addSlots(PlayerInventory playerInventory)
    {
        this.inventory = blockEntity.getInventory();
        this.addSlot(new Slot(this.inventory, GemCleanerBE.GEM_INPUT_SLOT, 113, 29)
        {
            @Override
            public boolean canInsert(ItemStack stack)
            {
                return stack.isIn(REFERENCE.RUBY_GEM);
            }
        });
        this.addSlot(new Slot(this.inventory, GemCleanerBE.WATER_BUCKET_SLOT, 40, 18)
        {
            @Override
            public boolean canInsert(ItemStack stack)
            {
                return stack.isOf(Items.WATER_BUCKET);
            }
        });
        //this.addSlot(new Slot(this.inventory, GemCleanerBE.ENERGY_UPGRADE_SLOT, 8, 28));
        //this.addSlot(new Slot(this.inventory, GemCleanerBE.SPEED_UPGRADE_SLOT, 8, 53));
        //this.addSlot(new Slot(this.inventory, GemCleanerBE.FLUID_UPGRADE_SLOT, 8, 80));
        this.addSlot(new Slot(this.inventory, GemCleanerBE.OUTPUT_SLOT, 113, 74)
        {
            @Override
            public boolean canInsert(ItemStack stack)
            {
                return false;
            }
        });
        this.addSlot(new Slot(this.inventory, GemCleanerBE.EMPTY_BUCKET_SLOT, 40, 86)
        {
            @Override
            public boolean canInsert(ItemStack stack)
            {
                return false;
            }
        });
    }

    @Override
    protected int getInventorySize()
    {
        return GemCleanerBE.INVENTORY_SIZE;
    }

    @Override
    protected List<Block> getValidBlocks()
    {
        return List.of(ModBlocks.GEM_CLEANER);
    }

    @Override
    protected int getPlayerInventoryY()
    {
        return 107;
    }
}