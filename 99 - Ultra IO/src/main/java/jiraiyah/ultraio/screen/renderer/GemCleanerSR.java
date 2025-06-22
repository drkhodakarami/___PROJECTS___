package jiraiyah.ultraio.screen.renderer;

import jiraiyah.jigui.constants.*;
import jiraiyah.jigui.enumerations.WidgetDirection;
import jiraiyah.jigui.enumerations.WidgetOrientation;
import jiraiyah.jigui.utils.ScreenHelper;
import jiraiyah.jigui.widgets.FluidWidget;
import jiraiyah.jigui.widgets.ProgressbarWidget;
import jiraiyah.jigui.widgets.TexturedIndicatorWidget;
import jiraiyah.jigui.screen.AbstractScreenRenderer;
import jiraiyah.ultraio.blockentity.machine.GemCleanerBE;
import jiraiyah.ultraio.screen.handler.GemCleanerSH;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.transaction.Transaction;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.fluid.Fluids;
import net.minecraft.text.Text;

public class GemCleanerSR extends AbstractScreenRenderer<GemCleanerBE, GemCleanerSH>
{
    public GemCleanerSR(GemCleanerSH handler, PlayerInventory inventory, Text title)
    {
        super(handler, inventory, title);
    }

    long energyCapacity = 10_000;
    long energyAmount = 3_000;
    long maxProgress = 200;
    long progress = 40;

    @Override
    protected void init()
    {
        super.init();

        try(Transaction transaction = Transaction.openOuter())
        {
            handler.getBlockEntity().getFluidStorage(null).insert(FluidVariant.of(Fluids.WATER), FluidConstants.BUCKET, transaction);
            transaction.commit();
        }

        addDrawable(new FluidWidget.Builder(this.x + 82 , this.y + 28)
                            .useDefaultValues(handler.getBlockEntity().getFluidStorage(null), () -> handler.getBlockEntity().getPos()).build());

        addDrawable(new TexturedIndicatorWidget.Builder(this.x + 153, this.y + 28)
                            .isEnergy()
                            .capacitySupplier(() -> energyCapacity)
                            .amountSupplier(() -> energyAmount)
                            .build());

        addDrawable(new ProgressbarWidget.Builder(this.x + 131, this.y + 46)
                            .amountSupplier(() -> progress)
                            .capacitySupplier(() -> maxProgress)
                            .orientation(WidgetOrientation.VERTICAL)
                            .direction(WidgetDirection.TOP_TO_BOTTOM)
                            .useArrowProgress(true)
                            .build());
    }

    @Override
    protected int getBackgroundHeight()
    {
        return 189;
    }

    @Override
    protected int getBackgroundWidth()
    {
        return 176;
    }

    @Override
    protected void drawBackground(DrawContext context, float deltaTicks, int mouseX, int mouseY)
    {
        super.drawBackground(context, deltaTicks, mouseX, mouseY);

        ScreenHelper.drawTexture(context, SlotIconTextures.SlotType.ENERGY_UPGRADE, this.x + 7, this.y + 27);
        ScreenHelper.drawTexture(context, SlotIconTextures.SlotType.SPEED_UPGRADE, this.x + 7, this.y + 53);
        ScreenHelper.drawTexture(context, SlotIconTextures.SlotType.FLUID_UPGRADE, this.x + 7, this.y + 79);
        ScreenHelper.drawTexture(context,SlotIconTextures.SlotType.BUCKET, this.x + 39, this.y + 17);
        ScreenHelper.drawTexture(context, SlotIconTextures.Slot.EMPTY_NORMAL, this.x + 39, this.y + 85);
        ScreenHelper.drawTexture(context, SlotIconTextures.Slot.EMPTY_NORMAL,this.x + 112, this.y + 28);
        ScreenHelper.drawTexture(context, SlotIconTextures.Slot.EMPTY_NORMAL, this.x + 112, this.y + 73);
        ScreenHelper.drawTexture(context, ContainerTextures.Connection.TUBE_TO_IO, this.x + 97, this.y + 44);
        ScreenHelper.drawTexture(context, ProgressBarTextures.Tube.Short.BACKGROUND, this.x + 56, this.y + 30);
        ScreenHelper.drawTexture(context, ArrowTextures.Small.ARROW_DOWN, this.x + 43, this.y + 58);
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
    }
}