package jiraiyah.testmod.screen.renderer;

import jiraiyah.jigui.client.constants.*;
import jiraiyah.jigui.client.utils.ScreenHelper;
import jiraiyah.testmod.screen.handler.Gui_9_SH;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;

public class Gui_9_SR extends HandledScreen<Gui_9_SH>
{
    public Gui_9_SR(Gui_9_SH handler, PlayerInventory inventory, Text title)
    {
        super(handler, inventory, title);
    }

    @Override
    protected void init()
    {
        super.init();
        this.playerInventoryTitleY = 10_000;

        this.titleX = (this.backgroundWidth - this.textRenderer.getWidth(title)) / 2;
    }

    @Override
    protected void drawBackground(DrawContext context, float deltaTicks, int mouseX, int mouseY)
    {
       /* ScreenHelper.drawTexture(context, ContainerBaseTextures.Background.Generic.G_174_220.id(),
                                0 + ContainerBaseTextures.Background.Generic.G_174_220.x(),
                                0 + ContainerBaseTextures.Background.Generic.G_174_220.y(),
                                ContainerBaseTextures.Background.Generic.G_174_220.u(),
                                ContainerBaseTextures.Background.Generic.G_174_220.v(),
                                ContainerBaseTextures.Background.Generic.G_174_220.width(),
                                ContainerBaseTextures.Background.Generic.G_174_220.height(),
                                ContainerBaseTextures.Background.Generic.G_174_220.textureWidth(),
                                ContainerBaseTextures.Background.Generic.G_174_220.textureHeight());

        ScreenHelper.drawTexture(context, ContainerBaseTextures.Background.Generic.G_174_220.id(),
                                1 + ContainerBaseTextures.Background.Generic.G_174_220.width(), 1,
                                ContainerBaseTextures.Background.Generic.G_174_220.u(),
                                ContainerBaseTextures.Background.Generic.G_174_220.v(),
                                ContainerBaseTextures.Background.Generic.G_174_220.width(),
                                ContainerBaseTextures.Background.Generic.G_174_220.height(),
                                ContainerBaseTextures.Background.Generic.G_174_220.textureWidth(),
                                ContainerBaseTextures.Background.Generic.G_174_220.textureHeight());

        ScreenHelper.drawTexture(context, ContainerBaseTextures.Background.Generic.G_174_220.id(),
                                1 + ContainerBaseTextures.Background.Generic.G_174_220.width() * 2, 1,
                                ContainerBaseTextures.Background.Generic.G_174_220.u(),
                                ContainerBaseTextures.Background.Generic.G_174_220.v(),
                                ContainerBaseTextures.Background.Generic.G_174_220.width(),
                                ContainerBaseTextures.Background.Generic.G_174_220.height(),
                                ContainerBaseTextures.Background.Generic.G_174_220.textureWidth(),
                                ContainerBaseTextures.Background.Generic.G_174_220.textureHeight());*/

        ScreenHelper.drawBackground(context, 100, 20, this.width - 200, this.height - 40);
        ScreenHelper.drawPlayerInventory(context, 130, 137);

        ScreenHelper.drawTexture(context, SlotIconTextures.Slot.EMPTY_NORMAL.id(),
                                130, 44,
                                SlotIconTextures.Slot.EMPTY_NORMAL.u(), SlotIconTextures.Slot.EMPTY_NORMAL.v(),
                                SlotIconTextures.Slot.EMPTY_NORMAL.width(), SlotIconTextures.Slot.EMPTY_NORMAL.height(),
                                SlotIconTextures.Slot.EMPTY_NORMAL.textureWidth(),
                                SlotIconTextures.Slot.EMPTY_NORMAL.textureHeight());

        /*// 176 * 133
        int width = 176;
        int height = 166;
        int x = 120;
        int y = 30;

        int startX, startY, endX, endY;

        // 170 * 127
        startX = x + 3;
        startY = y + 3;
        endX = startX + width - 6;
        endY = startY + height - 6;

        context.fill(startX, startY, endX, endY, GuiColors.Background.PANEL);

        //top border
        startX = x + 4;
        startY = y + 1;
        endX = startX + width - 7;
        endY = startY + 2;
        context.fill(startX, startY, endX, endY, GuiColors.Background.BORDER_HIGHLIGHT);

        startX = x + 4;
        startY = y;
        endX = startX + width - 7;
        endY = startY + 1;

        context.fill(startX, startY, endX, endY, 0xFF000000);

        //bottom border

        startX = x + 3;
        startY = y + height - 3;
        endX = startX + width - 6;
        endY = startY + 2;
        context.fill(startX, startY, endX, endY, GuiColors.Background.BORDER_SHADOW);

        startX = x + 3;
        startY = y + height - 1;
        endX = startX + width - 6;
        endY = startY + 1;

        context.fill(startX, startY, endX, endY, 0xFF000000);

        //right border

        startX = x + width - 3;
        startY = y + 2;
        endX = startX + 2;
        endY = startY + height - 6;
        context.fill(startX, startY, endX, endY, GuiColors.Background.BORDER_SHADOW);

        startX = x + width - 1;
        startY = y + 4;
        endX = startX + 1;
        endY = startY + height - 7;

        context.fill(startX, startY, endX, endY, 0xFF000000);

        //left border

        startX = x + 1;
        startY = y + 4;
        endX = startX + 2;
        endY = startY + height - 7;
        context.fill(startX, startY, endX, endY, GuiColors.Background.BORDER_HIGHLIGHT);

        startX = x;
        startY = y + 4;
        endX = startX + 1;
        endY = startY + height - 7;

        context.fill(startX, startY, endX, endY, 0xFF000000);

        //top left cornet
        ScreenHelper.drawTexture(context, ContainerBaseTextures.Background.Slice.TOP_LEFT.id(),
                                x , y, 0, 0, 4, 4, 4, 4);

        //top right cornet
        ScreenHelper.drawTexture(context, ContainerBaseTextures.Background.Slice.TOP_RIGHT.id(),
                                x + width - 3, y, 0, 0, 4, 4, 4, 4);

        //bottom left cornet
        ScreenHelper.drawTexture(context, ContainerBaseTextures.Background.Slice.BOTTOM_LEFT.id(),
                                x - 1, y + height - 3, 0, 0, 4, 4, 4, 4);

        //bottom left cornet
        ScreenHelper.drawTexture(context, ContainerBaseTextures.Background.Slice.BOTTOM_RIGHT.id(),
                                x + width - 4, y + height - 4, 0, 0, 4, 4, 4, 4);*/


        /*ScreenHelper.drawTexture(context, VanillaTextures.HUD.Screen.Xp.BACKGROUND.id(),
                                5, 5,
                                VanillaTextures.HUD.Screen.Xp.BACKGROUND.u(), VanillaTextures.HUD.Screen.Xp.BACKGROUND.v(),
                                VanillaTextures.HUD.Screen.Xp.BACKGROUND.width(), VanillaTextures.HUD.Screen.Xp.BACKGROUND.height(),
                                VanillaTextures.HUD.Screen.Xp.BACKGROUND.textureWidth(), VanillaTextures.HUD.Screen.Xp.BACKGROUND.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.HUD.Screen.Xp.PROGRESS.id(),
                                5, 12,
                                VanillaTextures.HUD.Screen.Xp.PROGRESS.u(), VanillaTextures.HUD.Screen.Xp.PROGRESS.v(),
                                VanillaTextures.HUD.Screen.Xp.PROGRESS.width(), VanillaTextures.HUD.Screen.Xp.PROGRESS.height(),
                                VanillaTextures.HUD.Screen.Xp.PROGRESS.textureWidth(), VanillaTextures.HUD.Screen.Xp.PROGRESS.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.HUD.Screen.Hotbar.BACKGROUND.id(),
                                205, 5,
                                VanillaTextures.HUD.Screen.Hotbar.BACKGROUND.u(), VanillaTextures.HUD.Screen.Hotbar.BACKGROUND.v(),
                                VanillaTextures.HUD.Screen.Hotbar.BACKGROUND.width(), VanillaTextures.HUD.Screen.Hotbar.BACKGROUND.height(),
                                VanillaTextures.HUD.Screen.Hotbar.BACKGROUND.textureWidth(), VanillaTextures.HUD.Screen.Hotbar.BACKGROUND.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.BossBar.Background.BLUE.id(),
                                5, 39,
                                VanillaTextures.BossBar.Background.BLUE.u(), VanillaTextures.BossBar.Background.BLUE.v(),
                                VanillaTextures.BossBar.Background.BLUE.width(), VanillaTextures.BossBar.Background.BLUE.height(),
                                VanillaTextures.BossBar.Background.BLUE.textureWidth(), VanillaTextures.BossBar.Background.BLUE.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.BossBar.Background.GREEN.id(),
                                5, 48,
                                VanillaTextures.BossBar.Background.GREEN.u(), VanillaTextures.BossBar.Background.GREEN.v(),
                                VanillaTextures.BossBar.Background.GREEN.width(), VanillaTextures.BossBar.Background.GREEN.height(),
                                VanillaTextures.BossBar.Background.GREEN.textureWidth(), VanillaTextures.BossBar.Background.GREEN.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.BossBar.Background.NOTCH_6.id(),
                                5, 55,
                                VanillaTextures.BossBar.Background.NOTCH_6.u(), VanillaTextures.BossBar.Background.NOTCH_6.v(),
                                VanillaTextures.BossBar.Background.NOTCH_6.width(), VanillaTextures.BossBar.Background.NOTCH_6.height(),
                                VanillaTextures.BossBar.Background.NOTCH_6.textureWidth(), VanillaTextures.BossBar.Background.NOTCH_6.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.BossBar.Background.NOTCH_10.id(),
                                5, 62,
                                VanillaTextures.BossBar.Background.NOTCH_10.u(), VanillaTextures.BossBar.Background.NOTCH_10.v(),
                                VanillaTextures.BossBar.Background.NOTCH_10.width(), VanillaTextures.BossBar.Background.NOTCH_10.height(),
                                VanillaTextures.BossBar.Background.NOTCH_10.textureWidth(), VanillaTextures.BossBar.Background.NOTCH_10.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.BossBar.Background.NOTCH_12.id(),
                                5, 69,
                                VanillaTextures.BossBar.Background.NOTCH_12.u(), VanillaTextures.BossBar.Background.NOTCH_12.v(),
                                VanillaTextures.BossBar.Background.NOTCH_12.width(), VanillaTextures.BossBar.Background.NOTCH_12.height(),
                                VanillaTextures.BossBar.Background.NOTCH_12.textureWidth(), VanillaTextures.BossBar.Background.NOTCH_12.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.BossBar.Background.NOTCH_20.id(),
                                5, 78,
                                VanillaTextures.BossBar.Background.NOTCH_20.u(), VanillaTextures.BossBar.Background.NOTCH_20.v(),
                                VanillaTextures.BossBar.Background.NOTCH_20.width(), VanillaTextures.BossBar.Background.NOTCH_20.height(),
                                VanillaTextures.BossBar.Background.NOTCH_20.textureWidth(), VanillaTextures.BossBar.Background.NOTCH_20.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.BossBar.Background.PINK.id(),
                                5, 85,
                                VanillaTextures.BossBar.Background.PINK.u(), VanillaTextures.BossBar.Background.PINK.v(),
                                VanillaTextures.BossBar.Background.PINK.width(), VanillaTextures.BossBar.Background.PINK.height(),
                                VanillaTextures.BossBar.Background.PINK.textureWidth(), VanillaTextures.BossBar.Background.PINK.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.BossBar.Background.PURPLE.id(),
                                5, 92,
                                VanillaTextures.BossBar.Background.PURPLE.u(), VanillaTextures.BossBar.Background.PURPLE.v(),
                                VanillaTextures.BossBar.Background.PURPLE.width(), VanillaTextures.BossBar.Background.PURPLE.height(),
                                VanillaTextures.BossBar.Background.PURPLE.textureWidth(), VanillaTextures.BossBar.Background.PURPLE.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.BossBar.Background.RED.id(),
                                5, 99,
                                VanillaTextures.BossBar.Background.RED.u(), VanillaTextures.BossBar.Background.RED.v(),
                                VanillaTextures.BossBar.Background.RED.width(), VanillaTextures.BossBar.Background.RED.height(),
                                VanillaTextures.BossBar.Background.RED.textureWidth(), VanillaTextures.BossBar.Background.RED.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.BossBar.Background.WHITE.id(),
                                5, 108,
                                VanillaTextures.BossBar.Background.WHITE.u(), VanillaTextures.BossBar.Background.WHITE.v(),
                                VanillaTextures.BossBar.Background.WHITE.width(), VanillaTextures.BossBar.Background.WHITE.height(),
                                VanillaTextures.BossBar.Background.WHITE.textureWidth(), VanillaTextures.BossBar.Background.WHITE.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.BossBar.Background.YELLOW.id(),
                                5, 115,
                                VanillaTextures.BossBar.Background.YELLOW.u(), VanillaTextures.BossBar.Background.YELLOW.v(),
                                VanillaTextures.BossBar.Background.YELLOW.width(), VanillaTextures.BossBar.Background.YELLOW.height(),
                                VanillaTextures.BossBar.Background.YELLOW.textureWidth(), VanillaTextures.BossBar.Background.YELLOW.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.BossBar.Progress.BLUE.id(),
                                205, 39,
                                VanillaTextures.BossBar.Progress.BLUE.u(), VanillaTextures.BossBar.Progress.BLUE.v(),
                                VanillaTextures.BossBar.Progress.BLUE.width(), VanillaTextures.BossBar.Progress.BLUE.height(),
                                VanillaTextures.BossBar.Progress.BLUE.textureWidth(), VanillaTextures.BossBar.Progress.BLUE.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.BossBar.Progress.GREEN.id(),
                                205, 48,
                                VanillaTextures.BossBar.Progress.GREEN.u(), VanillaTextures.BossBar.Progress.GREEN.v(),
                                VanillaTextures.BossBar.Progress.GREEN.width(), VanillaTextures.BossBar.Progress.GREEN.height(),
                                VanillaTextures.BossBar.Progress.GREEN.textureWidth(), VanillaTextures.BossBar.Progress.GREEN.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.BossBar.Progress.NOTCH_6.id(),
                                205, 55,
                                VanillaTextures.BossBar.Progress.NOTCH_6.u(), VanillaTextures.BossBar.Progress.NOTCH_6.v(),
                                VanillaTextures.BossBar.Progress.NOTCH_6.width(), VanillaTextures.BossBar.Progress.NOTCH_6.height(),
                                VanillaTextures.BossBar.Progress.NOTCH_6.textureWidth(), VanillaTextures.BossBar.Progress.NOTCH_6.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.BossBar.Progress.NOTCH_10.id(),
                                205, 62,
                                VanillaTextures.BossBar.Progress.NOTCH_10.u(), VanillaTextures.BossBar.Progress.NOTCH_10.v(),
                                VanillaTextures.BossBar.Progress.NOTCH_10.width(), VanillaTextures.BossBar.Progress.NOTCH_10.height(),
                                VanillaTextures.BossBar.Progress.NOTCH_10.textureWidth(), VanillaTextures.BossBar.Progress.NOTCH_10.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.BossBar.Progress.NOTCH_12.id(),
                                205, 69,
                                VanillaTextures.BossBar.Progress.NOTCH_12.u(), VanillaTextures.BossBar.Progress.NOTCH_12.v(),
                                VanillaTextures.BossBar.Progress.NOTCH_12.width(), VanillaTextures.BossBar.Progress.NOTCH_12.height(),
                                VanillaTextures.BossBar.Progress.NOTCH_12.textureWidth(), VanillaTextures.BossBar.Progress.NOTCH_12.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.BossBar.Progress.NOTCH_20.id(),
                                205, 78,
                                VanillaTextures.BossBar.Progress.NOTCH_20.u(), VanillaTextures.BossBar.Progress.NOTCH_20.v(),
                                VanillaTextures.BossBar.Progress.NOTCH_20.width(), VanillaTextures.BossBar.Progress.NOTCH_20.height(),
                                VanillaTextures.BossBar.Progress.NOTCH_20.textureWidth(), VanillaTextures.BossBar.Progress.NOTCH_20.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.BossBar.Progress.PINK.id(),
                                205, 85,
                                VanillaTextures.BossBar.Progress.PINK.u(), VanillaTextures.BossBar.Progress.PINK.v(),
                                VanillaTextures.BossBar.Progress.PINK.width(), VanillaTextures.BossBar.Progress.PINK.height(),
                                VanillaTextures.BossBar.Progress.PINK.textureWidth(), VanillaTextures.BossBar.Progress.PINK.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.BossBar.Progress.PURPLE.id(),
                                205, 92,
                                VanillaTextures.BossBar.Progress.PURPLE.u(), VanillaTextures.BossBar.Progress.PURPLE.v(),
                                VanillaTextures.BossBar.Progress.PURPLE.width(), VanillaTextures.BossBar.Progress.PURPLE.height(),
                                VanillaTextures.BossBar.Progress.PURPLE.textureWidth(), VanillaTextures.BossBar.Progress.PURPLE.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.BossBar.Progress.RED.id(),
                                205, 99,
                                VanillaTextures.BossBar.Progress.RED.u(), VanillaTextures.BossBar.Progress.RED.v(),
                                VanillaTextures.BossBar.Progress.RED.width(), VanillaTextures.BossBar.Progress.RED.height(),
                                VanillaTextures.BossBar.Progress.RED.textureWidth(), VanillaTextures.BossBar.Progress.RED.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.BossBar.Progress.WHITE.id(),
                                205, 108,
                                VanillaTextures.BossBar.Progress.WHITE.u(), VanillaTextures.BossBar.Progress.WHITE.v(),
                                VanillaTextures.BossBar.Progress.WHITE.width(), VanillaTextures.BossBar.Progress.WHITE.height(),
                                VanillaTextures.BossBar.Progress.WHITE.textureWidth(), VanillaTextures.BossBar.Progress.WHITE.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.BossBar.Progress.YELLOW.id(),
                                205, 115,
                                VanillaTextures.BossBar.Progress.YELLOW.u(), VanillaTextures.BossBar.Progress.YELLOW.v(),
                                VanillaTextures.BossBar.Progress.YELLOW.width(), VanillaTextures.BossBar.Progress.YELLOW.height(),
                                VanillaTextures.BossBar.Progress.YELLOW.textureWidth(), VanillaTextures.BossBar.Progress.YELLOW.textureHeight());*/
    }

    @Override
    protected void drawForeground(DrawContext context, int mouseX, int mouseY)
    {
        super.drawForeground(context, mouseX, mouseY);


    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float deltaTicks)
    {
        super.render(context, mouseX, mouseY, deltaTicks);

        //ScreenHelper.drawTexture(context, TEXTURE, this.x + 83, this.y + 34, 184, 0, 16, 51); // DRAWING FLUID MARKERS
    }
}