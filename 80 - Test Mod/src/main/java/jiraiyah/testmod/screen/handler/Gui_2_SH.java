package jiraiyah.testmod.screen.handler;

import jiraiyah.jibase.records.BlockPosPayload;
import jiraiyah.jigui.client.AbstractScreenHandler;
import jiraiyah.testmod.blockentity.gui.GuiBE2;
import jiraiyah.testmod.registry.ModBlocks;
import jiraiyah.testmod.registry.ModScreenHandlers;
import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;

import java.util.List;

public class Gui_2_SH extends AbstractScreenHandler<GuiBE2>
{
    public Gui_2_SH(int syncId, PlayerInventory playerInventory, BlockPosPayload blockPosPayload)
    {
        this(syncId, playerInventory, (GuiBE2) playerInventory.player.getWorld().getBlockEntity(blockPosPayload.pos()));
    }

    public Gui_2_SH(int syncId, PlayerInventory playerInventory, GuiBE2 blockEntity)
    {
        super(ModScreenHandlers.GUI_2, syncId, playerInventory, blockEntity);
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
        return List.of(ModBlocks.GUI_2);
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