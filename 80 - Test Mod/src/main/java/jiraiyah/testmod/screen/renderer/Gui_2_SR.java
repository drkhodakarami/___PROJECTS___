package jiraiyah.testmod.screen.renderer;

import jiraiyah.jigui.client.AbstractScreenRenderer;
import jiraiyah.jigui.client.constants.ContainerBaseTextures;
import jiraiyah.jigui.client.constants.FluidContainerTextures;
import jiraiyah.jigui.client.constants.GuiColors;
import jiraiyah.jigui.client.enumerations.WidgetDirection;
import jiraiyah.jigui.client.enumerations.WidgetOrientation;
import jiraiyah.jigui.client.utils.ScreenHelper;
import jiraiyah.jigui.client.widgets.ColorIndicatorWidget;
import jiraiyah.jigui.client.widgets.FluidWidget;
import jiraiyah.jigui.client.widgets.GradientIndicatorWidget;
import jiraiyah.jigui.client.widgets.TexturedIndicatorWidget;
import jiraiyah.testmod.blockentity.gui.GuiBE2;
import jiraiyah.testmod.screen.handler.Gui_2_SH;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.fluid.base.SingleFluidStorage;
import net.fabricmc.fabric.api.transfer.v1.transaction.Transaction;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.fluid.Fluids;
import net.minecraft.text.Text;
import net.minecraft.util.math.MathHelper;

public class Gui_2_SR extends AbstractScreenRenderer<GuiBE2, Gui_2_SH>
{
    public Gui_2_SR(Gui_2_SH handler, PlayerInventory inventory, Text title)
    {
        super(handler, inventory, title);
    }

    long amountG = 100;
    long capacityG = 100;
    long amountE = 100;
    long capacityE = 100;
    int frames = 0;

    SingleFluidStorage tank = new SingleFluidStorage()
    {
        @Override
        protected long getCapacity(FluidVariant fluidVariant)
        {
            return FluidConstants.BUCKET * 3;
        }
    };

    @Override
    protected void init()
    {
        super.init();

        try(Transaction transaction = Transaction.openOuter())
        {
            tank.insert(FluidVariant.of(Fluids.WATER), FluidConstants.BUCKET * 2, transaction);
            transaction.commit();
        }

        addDrawable(new FluidWidget.Builder(this.x + 5, this.y + 6).useDefaultValues(tank, () -> handler.getBlockEntity().getPos()).build());

        addDrawable(new GradientIndicatorWidget.Builder()
                            .colors(GuiColors.Indicator.DARKEST_PURPLE, GuiColors.Indicator.PURPLE)
                            .direction(WidgetDirection.BOTTOM_TO_TOP)
                            .orientation(WidgetOrientation.VERTICAL)
                            .amountSupplier(() -> amountG)
                            .capacitySupplier(() -> capacityG)
                            .fillRect(this.x + 26, this.y + 7, 16, 61)
                            .build());

        addDrawable(new TexturedIndicatorWidget.Builder(this.x + 46, this.y + 6)
                            .isEnergy()
                            .capacitySupplier(() -> capacityE)
                            .amountSupplier(() -> amountE)
                            .build());

        addDrawable(new GradientIndicatorWidget.Builder()
                            .colors(GuiColors.Indicator.GOLD, GuiColors.Indicator.CYAN)
                            .direction(WidgetDirection.TOP_TO_BOTTOM)
                            .orientation(WidgetOrientation.VERTICAL)
                            .amountSupplier(() -> amountG)
                            .capacitySupplier(() -> capacityG)
                            .fillRect(this.x + 66, this.y + 7, 16, 61)
                            .build());

        addDrawable(new ColorIndicatorWidget.Builder()
                            .color(GuiColors.Indicator.ORANGE)
                            .direction(WidgetDirection.BOTTOM_TO_TOP)
                            .orientation(WidgetOrientation.VERTICAL)
                            .amountSupplier(() -> amountG)
                            .capacitySupplier(() -> capacityG)
                            .fillRect(this.x + 86, this.y + 7, 16, 61)
                            .build());

        addDrawable(new ColorIndicatorWidget.Builder()
                            .color(GuiColors.Indicator.PINK)
                            .direction(WidgetDirection.TOP_TO_BOTTOM)
                            .orientation(WidgetOrientation.VERTICAL)
                            .amountSupplier(() -> amountG)
                            .capacitySupplier(() -> capacityG)
                            .fillRect(this.x + 106, this.y + 7, 16, 61)
                            .build());

        addDrawable(new GradientIndicatorWidget.Builder()
                            .colors(GuiColors.Indicator.DARKEST_PURPLE, GuiColors.Indicator.PURPLE)
                            .direction(WidgetDirection.LEFT_TO_RIGHT)
                            .orientation(WidgetOrientation.HORIZONTAL)
                            .amountSupplier(() -> amountG)
                            .capacitySupplier(() -> capacityG)
                            .fillRect(this.x + 5, this.y + 77, 61, 10)
                            .build());

        addDrawable(new GradientIndicatorWidget.Builder()
                            .colors(GuiColors.Indicator.GOLD, GuiColors.Indicator.CYAN)
                            .direction(WidgetDirection.RIGHT_TO_LEFT)
                            .orientation(WidgetOrientation.HORIZONTAL)
                            .amountSupplier(() -> amountG)
                            .capacitySupplier(() -> capacityG)
                            .fillRect(this.x + 5, this.y + 89, 61, 10)
                            .build());

        addDrawable(new ColorIndicatorWidget.Builder()
                            .color(GuiColors.Indicator.ORANGE)
                            .direction(WidgetDirection.LEFT_TO_RIGHT)
                            .orientation(WidgetOrientation.HORIZONTAL)
                            .amountSupplier(() -> amountG)
                            .capacitySupplier(() -> capacityG)
                            .fillRect(this.x + 70, this.y + 77, 61, 10)
                            .build());

        addDrawable(new ColorIndicatorWidget.Builder()
                            .color(GuiColors.Indicator.PINK)
                            .direction(WidgetDirection.RIGHT_TO_LEFT)
                            .orientation(WidgetOrientation.HORIZONTAL)
                            .amountSupplier(() -> amountG)
                            .capacitySupplier(() -> capacityG)
                            .fillRect(this.x + 70, this.y + 89, 61, 10)
                            .build());
    }

    @Override
    protected void drawBackground(DrawContext context, float deltaTicks, int mouseX, int mouseY)
    {
        super.drawBackground(context, deltaTicks, mouseX, mouseY);

        ScreenHelper.drawTexture(context, FluidContainerTextures.Normal.BACKGROUND.id(),
                                this.x + 25, this.y + 6,
                                FluidContainerTextures.Normal.BACKGROUND.u(), FluidContainerTextures.Normal.BACKGROUND.v(),
                                FluidContainerTextures.Normal.BACKGROUND.width(), FluidContainerTextures.Normal.BACKGROUND.height(),
                                FluidContainerTextures.Normal.BACKGROUND.textureWidth(), FluidContainerTextures.Normal.BACKGROUND.textureHeight());

        ScreenHelper.drawTexture(context, FluidContainerTextures.Normal.BACKGROUND.id(),
                                this.x + 65, this.y + 6,
                                FluidContainerTextures.Normal.BACKGROUND.u(), FluidContainerTextures.Normal.BACKGROUND.v(),
                                FluidContainerTextures.Normal.BACKGROUND.width(), FluidContainerTextures.Normal.BACKGROUND.height(),
                                FluidContainerTextures.Normal.BACKGROUND.textureWidth(), FluidContainerTextures.Normal.BACKGROUND.textureHeight());

        ScreenHelper.drawTexture(context, FluidContainerTextures.Normal.BACKGROUND.id(),
                                this.x + 85, this.y + 6,
                                FluidContainerTextures.Normal.BACKGROUND.u(), FluidContainerTextures.Normal.BACKGROUND.v(),
                                FluidContainerTextures.Normal.BACKGROUND.width(), FluidContainerTextures.Normal.BACKGROUND.height(),
                                FluidContainerTextures.Normal.BACKGROUND.textureWidth(), FluidContainerTextures.Normal.BACKGROUND.textureHeight());

        ScreenHelper.drawTexture(context, FluidContainerTextures.Normal.BACKGROUND.id(),
                                this.x + 105, this.y + 6,
                                FluidContainerTextures.Normal.BACKGROUND.u(), FluidContainerTextures.Normal.BACKGROUND.v(),
                                FluidContainerTextures.Normal.BACKGROUND.width(), FluidContainerTextures.Normal.BACKGROUND.height(),
                                FluidContainerTextures.Normal.BACKGROUND.textureWidth(), FluidContainerTextures.Normal.BACKGROUND.textureHeight());
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float deltaTicks)
    {
        super.render(context, mouseX, mouseY, deltaTicks);

        frames++;
        tank.amount = (long) (FluidConstants.BUCKET * 3 * MathHelper.abs(MathHelper.sin(frames / 450f)));
        amountG = (int) (100 * MathHelper.abs(MathHelper.sin(frames / 150f)));
        amountE = (int) (100 * MathHelper.abs(MathHelper.sin(frames / 300f)));

        /*tank.amount = FluidConstants.BUCKET * 3;
        amountG = 100;
        amountE = 100;*/

        //ScreenHelper.drawTexture(context, TEXTURE, this.x + 83, this.y + 34, 184, 0, 16, 51); // DRAWING FLUID MARKERS
    }

    @Override
    protected int getBackgroundHeight()
    {
        return 220;
    }

    @Override
    protected int getBackgroundWidth()
    {
        return 174;
    }

    protected boolean shouldInventoryNameCentered()
    {
        return false;
    }

    protected boolean shouldDrawInventoryName()
    {
        return false;
    }

    protected boolean shouldContainNameCentered()
    {
        return true;
    }

    protected boolean shouldDrawContainerName()
    {
        return false;
    }
}