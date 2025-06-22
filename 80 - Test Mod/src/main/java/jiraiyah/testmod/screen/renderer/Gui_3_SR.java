package jiraiyah.testmod.screen.renderer;

import jiraiyah.jigui.client.constants.ContainerBaseTextures;
import jiraiyah.jigui.client.constants.ContainerTextures;
import jiraiyah.jigui.client.utils.ScreenHelper;
import jiraiyah.testmod.screen.handler.Gui_3_SH;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;

public class Gui_3_SR extends HandledScreen<Gui_3_SH>
{
    public Gui_3_SR(Gui_3_SH handler, PlayerInventory inventory, Text title)
    {
        super(handler, inventory, title);
    }

    @Override
    protected void init()
    {
        super.init();
        this.playerInventoryTitleY = 10_000;

        this.backgroundWidth = ContainerBaseTextures.Background.Generic.G_174_220.width();
        this.backgroundHeight = ContainerBaseTextures.Background.Generic.G_174_220.height();
        this.y = (this.height - this.backgroundHeight) / 2;
        this.x = (this.width - this.backgroundWidth) / 2;

        this.titleX = (this.backgroundWidth - this.textRenderer.getWidth(title)) / 2;
    }

    @Override
    protected void drawBackground(DrawContext context, float deltaTicks, int mouseX, int mouseY)
    {
        //ScreenHelper.drawTexture(context, TEXTURE, this.x, this.y, 0, 0, BACKGROUND_WIDTH, BACKGROUND_HEIGHT);

        ScreenHelper.drawTexture(context, ContainerBaseTextures.Background.Generic.G_174_220.id(),
                                this.x + ContainerBaseTextures.Background.Generic.G_174_220.x(),
                                this.y + ContainerBaseTextures.Background.Generic.G_174_220.y(),
                                ContainerBaseTextures.Background.Generic.G_174_220.u(),
                                ContainerBaseTextures.Background.Generic.G_174_220.v(),
                                ContainerBaseTextures.Background.Generic.G_174_220.width(),
                                ContainerBaseTextures.Background.Generic.G_174_220.height(),
                                ContainerBaseTextures.Background.Generic.G_174_220.textureWidth(),
                                ContainerBaseTextures.Background.Generic.G_174_220.textureHeight());
    }

    @Override
    protected void drawForeground(DrawContext context, int mouseX, int mouseY)
    {
        super.drawForeground(context, mouseX, mouseY);

        //ScreenHelper.drawTexture(context, TEXTURE, 154, 29, 200, 0, 14, 62); // DRAWING ENERGY BAR
        /*ScreenHelper.drawTexture(context, ContainerTextures.IO.INPUT_1_OUTPUT_2.id(),
                                5, 5,
                                ContainerTextures.IO.INPUT_1_OUTPUT_2.u(), ContainerTextures.IO.INPUT_1_OUTPUT_2.v(),
                                ContainerTextures.IO.INPUT_1_OUTPUT_2.width(), ContainerTextures.IO.INPUT_1_OUTPUT_2.height(),
                                ContainerTextures.IO.INPUT_1_OUTPUT_2.textureWidth(), ContainerTextures.IO.INPUT_1_OUTPUT_2.textureHeight());
        ScreenHelper.drawTexture(context, ContainerTextures.IO.INPUT_1_OUTPUT_3.id(),
                                75, 5,
                                ContainerTextures.IO.INPUT_1_OUTPUT_3.u(), ContainerTextures.IO.INPUT_1_OUTPUT_3.v(),
                                ContainerTextures.IO.INPUT_1_OUTPUT_3.width(), ContainerTextures.IO.INPUT_1_OUTPUT_3.height(),
                                ContainerTextures.IO.INPUT_1_OUTPUT_3.textureWidth(), ContainerTextures.IO.INPUT_1_OUTPUT_3.textureHeight());*/

        /*ScreenHelper.drawTexture(context, ContainerTextures.IO.INPUT_2_OUTPUT_1.id(),
                                5, 5,
                                ContainerTextures.IO.INPUT_2_OUTPUT_1.u(), ContainerTextures.IO.INPUT_2_OUTPUT_1.v(),
                                ContainerTextures.IO.INPUT_2_OUTPUT_1.width(), ContainerTextures.IO.INPUT_2_OUTPUT_1.height(),
                                ContainerTextures.IO.INPUT_2_OUTPUT_1.textureWidth(), ContainerTextures.IO.INPUT_2_OUTPUT_1.textureHeight());
        ScreenHelper.drawTexture(context, ContainerTextures.IO.INPUT_2_OUTPUT_2.id(),
                                75, 5,
                                ContainerTextures.IO.INPUT_2_OUTPUT_2.u(), ContainerTextures.IO.INPUT_2_OUTPUT_2.v(),
                                ContainerTextures.IO.INPUT_2_OUTPUT_2.width(), ContainerTextures.IO.INPUT_2_OUTPUT_2.height(),
                                ContainerTextures.IO.INPUT_2_OUTPUT_2.textureWidth(), ContainerTextures.IO.INPUT_2_OUTPUT_2.textureHeight());*/

        ScreenHelper.drawTexture(context, ContainerTextures.IO.INPUT_3_OUTPUT_1.id(),
                                5, 5,
                                ContainerTextures.IO.INPUT_3_OUTPUT_1.u(), ContainerTextures.IO.INPUT_3_OUTPUT_1.v(),
                                ContainerTextures.IO.INPUT_3_OUTPUT_1.width(), ContainerTextures.IO.INPUT_3_OUTPUT_1.height(),
                                ContainerTextures.IO.INPUT_3_OUTPUT_1.textureWidth(), ContainerTextures.IO.INPUT_3_OUTPUT_1.textureHeight());
        ScreenHelper.drawTexture(context, ContainerTextures.IO.INPUT_3_OUTPUT_3.id(),
                                75, 5,
                                ContainerTextures.IO.INPUT_3_OUTPUT_3.u(), ContainerTextures.IO.INPUT_3_OUTPUT_3.v(),
                                ContainerTextures.IO.INPUT_3_OUTPUT_3.width(), ContainerTextures.IO.INPUT_3_OUTPUT_3.height(),
                                ContainerTextures.IO.INPUT_3_OUTPUT_3.textureWidth(), ContainerTextures.IO.INPUT_3_OUTPUT_3.textureHeight());

        //region CONTAINER CONNECTORS
        ScreenHelper.drawTexture(context, ContainerTextures.Connection.INPUT_3.id(),
                                5, 70,
                                ContainerTextures.Connection.INPUT_3.u(), ContainerTextures.Connection.INPUT_3.v(),
                                ContainerTextures.Connection.INPUT_3.width(), ContainerTextures.Connection.INPUT_3.height(),
                                ContainerTextures.Connection.INPUT_3.textureWidth(), ContainerTextures.Connection.INPUT_3.textureHeight());

        ScreenHelper.drawTexture(context, ContainerTextures.Connection.OUTPUT_3.id(),
                                35, 70,
                                ContainerTextures.Connection.OUTPUT_3.u(), ContainerTextures.Connection.OUTPUT_3.v(),
                                ContainerTextures.Connection.OUTPUT_3.width(), ContainerTextures.Connection.OUTPUT_3.height(),
                                ContainerTextures.Connection.OUTPUT_3.textureWidth(), ContainerTextures.Connection.OUTPUT_3.textureHeight());

        ScreenHelper.drawTexture(context, ContainerTextures.Connection.TUBE_TO_IO.id(),
                                67, 70,
                                ContainerTextures.Connection.TUBE_TO_IO.u(), ContainerTextures.Connection.TUBE_TO_IO.v(),
                                ContainerTextures.Connection.TUBE_TO_IO.width(), ContainerTextures.Connection.TUBE_TO_IO.height(),
                                ContainerTextures.Connection.TUBE_TO_IO.textureWidth(), ContainerTextures.Connection.TUBE_TO_IO.textureHeight());
        //endregion
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float deltaTicks)
    {
        super.render(context, mouseX, mouseY, deltaTicks);

        //ScreenHelper.drawTexture(context, TEXTURE, this.x + 83, this.y + 34, 184, 0, 16, 51); // DRAWING FLUID MARKERS
    }
}