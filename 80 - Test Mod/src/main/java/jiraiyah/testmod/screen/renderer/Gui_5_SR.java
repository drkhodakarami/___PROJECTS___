package jiraiyah.testmod.screen.renderer;

import jiraiyah.jigui.client.constants.ContainerBaseTextures;
import jiraiyah.jigui.client.enumerations.WidgetDirection;
import jiraiyah.jigui.client.enumerations.WidgetOrientation;
import jiraiyah.jigui.client.utils.ScreenHelper;
import jiraiyah.jigui.client.widgets.ProgressbarWidget;
import jiraiyah.testmod.screen.handler.Gui_5_SH;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.math.MathHelper;

public class Gui_5_SR extends HandledScreen<Gui_5_SH>
{
    long amount = 100;
    long capacity = 100;
    int frames = 0;

    public Gui_5_SR(Gui_5_SH handler, PlayerInventory inventory, Text title)
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

        addDrawable(new ProgressbarWidget.Builder(this.x + 5, this.y + 5)
                            .orientation(WidgetOrientation.HORIZONTAL)
                            .direction(WidgetDirection.LEFT_TO_RIGHT)
                            .useTubeProgress(false)
                            .amountSupplier(() -> amount)
                            .capacitySupplier(() -> capacity)
                            .build());

        addDrawable(new ProgressbarWidget.Builder(this.x + 35, this.y + 5)
                            .orientation(WidgetOrientation.HORIZONTAL)
                            .direction(WidgetDirection.LEFT_TO_RIGHT)
                            .useTubeProgress(true)
                            .amountSupplier(() -> amount)
                            .capacitySupplier(() -> capacity)
                            .build());

        addDrawable(new ProgressbarWidget.Builder(this.x + 68, this.y + 5)
                            .orientation(WidgetOrientation.HORIZONTAL)
                            .direction(WidgetDirection.LEFT_TO_RIGHT)
                            .useFireProgress()
                            .amountSupplier(() -> amount)
                            .capacitySupplier(() -> capacity)
                            .build());

        addDrawable(new ProgressbarWidget.Builder(this.x + 65, this.y + 20)
                            .orientation(WidgetOrientation.HORIZONTAL)
                            .direction(WidgetDirection.LEFT_TO_RIGHT)
                            .useBlazeProgress()
                            .amountSupplier(() -> amount)
                            .capacitySupplier(() -> capacity)
                            .build());

        addDrawable(new ProgressbarWidget.Builder(this.x + 65, this.y + 27)
                            .orientation(WidgetOrientation.HORIZONTAL)
                            .direction(WidgetDirection.LEFT_TO_RIGHT)
                            .useBlazeProgress(true)
                            .amountSupplier(() -> amount)
                            .capacitySupplier(() -> capacity)
                            .build());

        addDrawable(new ProgressbarWidget.Builder(this.x + 90, this.y + 5)
                            .orientation(WidgetOrientation.VERTICAL)
                            .direction(WidgetDirection.BOTTOM_TO_TOP)
                            .useBubbleProgress()
                            .amountSupplier(() -> amount)
                            .capacitySupplier(() -> capacity)
                            .build());

        addDrawable(new ProgressbarWidget.Builder(this.x + 105, this.y + 5)
                            .orientation(WidgetOrientation.VERTICAL)
                            .direction(WidgetDirection.TOP_TO_BOTTOM)
                            .useBubbleProgress()
                            .amountSupplier(() -> amount)
                            .capacitySupplier(() -> capacity)
                            .build());

        addDrawable(new ProgressbarWidget.Builder(this.x + 125, this.y + 20)
                            .orientation(WidgetOrientation.HORIZONTAL)
                            .direction(WidgetDirection.RIGHT_TO_LEFT)
                            .useBubbleProgress()
                            .amountSupplier(() -> amount)
                            .capacitySupplier(() -> capacity)
                            .build());

        addDrawable(new ProgressbarWidget.Builder(this.x + 125, this.y + 5)
                            .orientation(WidgetOrientation.HORIZONTAL)
                            .direction(WidgetDirection.LEFT_TO_RIGHT)
                            .useBubbleProgress()
                            .amountSupplier(() -> amount)
                            .capacitySupplier(() -> capacity)
                            .build());

        addDrawable(new ProgressbarWidget.Builder(this.x + 5, this.y + 45)
                            .orientation(WidgetOrientation.VERTICAL)
                            .direction(WidgetDirection.TOP_TO_BOTTOM)
                            .useArrowProgress(true)
                            .amountSupplier(() -> amount)
                            .capacitySupplier(() -> capacity)
                            .build());

        addDrawable(new ProgressbarWidget.Builder(this.x + 25, this.y + 45)
                            .orientation(WidgetOrientation.VERTICAL)
                            .direction(WidgetDirection.BOTTOM_TO_TOP)
                            .useArrowProgress(true)
                            .amountSupplier(() -> amount)
                            .capacitySupplier(() -> capacity)
                            .build());

        addDrawable(new ProgressbarWidget.Builder(this.x + 45, this.y + 47)
                            .orientation(WidgetOrientation.HORIZONTAL)
                            .direction(WidgetDirection.LEFT_TO_RIGHT)
                            .useArrowProgress(true)
                            .amountSupplier(() -> amount)
                            .capacitySupplier(() -> capacity)
                            .build());

        addDrawable(new ProgressbarWidget.Builder(this.x + 45, this.y + 57)
                            .orientation(WidgetOrientation.HORIZONTAL)
                            .direction(WidgetDirection.RIGHT_TO_LEFT)
                            .useArrowProgress(true)
                            .amountSupplier(() -> amount)
                            .capacitySupplier(() -> capacity)
                            .build());

        addDrawable(new ProgressbarWidget.Builder(this.x + 10, this.y + 74)
                            .orientation(WidgetOrientation.VERTICAL)
                            .direction(WidgetDirection.TOP_TO_BOTTOM)
                            .useArrowProgress(false)
                            .amountSupplier(() -> amount)
                            .capacitySupplier(() -> capacity)
                            .build());

        addDrawable(new ProgressbarWidget.Builder(this.x + 28, this.y + 74)
                            .orientation(WidgetOrientation.VERTICAL)
                            .direction(WidgetDirection.BOTTOM_TO_TOP)
                            .useArrowProgress(false)
                            .amountSupplier(() -> amount)
                            .capacitySupplier(() -> capacity)
                            .build());

        addDrawable(new ProgressbarWidget.Builder(this.x + 50, this.y + 74)
                            .orientation(WidgetOrientation.HORIZONTAL)
                            .direction(WidgetDirection.LEFT_TO_RIGHT)
                            .useArrowProgress(false)
                            .amountSupplier(() -> amount)
                            .capacitySupplier(() -> capacity)
                            .build());

        addDrawable(new ProgressbarWidget.Builder(this.x + 50, this.y + 87)
                            .orientation(WidgetOrientation.HORIZONTAL)
                            .direction(WidgetDirection.RIGHT_TO_LEFT)
                            .useArrowProgress(false)
                            .amountSupplier(() -> amount)
                            .capacitySupplier(() -> capacity)
                            .build());
    }

    @Override
    protected void drawBackground(DrawContext context, float deltaTicks, int mouseX, int mouseY)
    {
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
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float deltaTicks)
    {
        super.render(context, mouseX, mouseY, deltaTicks);
        frames++;
        amount = (int) (100 * MathHelper.abs(MathHelper.sin(frames / 150f)));
    }
}