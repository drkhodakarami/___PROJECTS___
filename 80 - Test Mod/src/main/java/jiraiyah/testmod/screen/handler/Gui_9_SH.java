package jiraiyah.testmod.screen.handler;

import jiraiyah.jibase.records.BlockPosPayload;
import jiraiyah.jigui.client.AbstractScreenHandler;
import jiraiyah.testmod.blockentity.gui.GuiBE9;
import jiraiyah.testmod.registry.ModBlocks;
import jiraiyah.testmod.registry.ModScreenHandlers;
import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;

import java.util.List;

public class Gui_9_SH extends AbstractScreenHandler<GuiBE9>
{
    public Gui_9_SH(int syncId, PlayerInventory playerInventory, BlockPosPayload blockPosPayload)
    {
        this(syncId, playerInventory, (GuiBE9) playerInventory.player.getWorld().getBlockEntity(blockPosPayload.pos()));
    }

    public Gui_9_SH(int syncId, PlayerInventory playerInventory, GuiBE9 blockEntity)
    {
        super(ModScreenHandlers.GUI_9, syncId, playerInventory, blockEntity);
    }

    @Override
    public void onClosed(PlayerEntity player)
    {
        super.onClosed(player);
    }

    @Override
    public int getInventorySize()
    {
        return 0;
    }

    @Override
    protected List<Block> getValidBlocks()
    {
        return List.of(ModBlocks.GUI_9);
    }

    @Override
    protected boolean addPlayerInventory()
    {
        return false;
    }

    @Override
    public int getPlayerInventoryY()
    {
        return 136;
    }

    @Override
    public int getPlayerInventoryX()
    {
        return 7;
    }
}