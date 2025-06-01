package jiraiyah.ultraio.screen.renderer;

import jiraiyah.jibase.client.utils.MouseHelper;
import jiraiyah.jibase.client.utils.ScreenUtils;
import jiraiyah.ultraio.screen.handler.GemCleanerScreenHandler;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandler;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.texture.Sprite;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ColorHelper;
import net.minecraft.world.World;

import java.util.List;

import static jiraiyah.ultraio.Main.REFERENCE;

public class GemCleanerScreenRenderer extends HandledScreen<GemCleanerScreenHandler>
{
    private static final Identifier TEXTURE = REFERENCE.identifier("textures/gui/container/gem_cleaner.png");
    private static final int BACKGROUND_WIDTH = 176;
    private static final int BACKGROUND_HEIGHT = 189;

    public GemCleanerScreenRenderer(GemCleanerScreenHandler handler, PlayerInventory inventory, Text title)
    {
        super(handler, inventory, title);
    }

    @Override
    protected void init()
    {
        super.init();
        this.playerInventoryTitleY = 10_000;

        this.backgroundWidth = BACKGROUND_WIDTH;
        this.backgroundHeight = BACKGROUND_HEIGHT;

        this.titleX = (this.backgroundWidth - this.textRenderer.getWidth(title)) / 2;
    }

    @Override
    protected void drawBackground(DrawContext context, float deltaTicks, int mouseX, int mouseY)
    {
        ScreenUtils.drawTexture(context, TEXTURE, this.x, this.y, 0, 0, BACKGROUND_WIDTH, BACKGROUND_HEIGHT);
    }

    @Override
    protected void drawForeground(DrawContext context, int mouseX, int mouseY)
    {
        super.drawForeground(context, mouseX, mouseY);

        //TODO: Handle the progress
        ScreenUtils.drawTexture(context, TEXTURE, 131, 46, 176, 0, 8, 26); // DRAWING PROGRESS ARROW
        //TODO: Handle the energy
        ScreenUtils.drawTexture(context, TEXTURE, 154, 29, 200, 0, 14, 62); // DRAWING ENERGY BAR
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float deltaTicks)
    {
        super.render(context, mouseX, mouseY, deltaTicks);

        /*addDrawable(new FluidWidget.Builder(this.handler.getBlockEntity().getFluidTank())
                            .bound(this.x + 83, this.y + 29, 16, 62)
                            .posSupplier(() -> this.handler.getBlockEntity().getPos())
                            .build());*/

        //TODO: Handle the fluid
        Fluid fluid = Fluids.WATER;
        long amount = FluidConstants.BUCKET * 5;
        long capacity = FluidConstants.BUCKET * 10;
        int barHeight = 62;
        int fluidHeight = Math.round((float)amount / capacity * barHeight);

        FluidRenderHandler fluidRenderHandler = FluidRenderHandlerRegistry.INSTANCE.get(fluid);

        if(fluidRenderHandler != null && amount > 0)
        {
            BlockPos pos = this.handler.getBlockEntity().getPos();
            FluidState fluidState = fluid.getDefaultState();
            World world = MinecraftClient.getInstance().world;

            Sprite stillTexture = fluidRenderHandler.getFluidSprites(world, pos, fluidState)[0];
            int tintColor = fluidRenderHandler.getFluidColor(world, pos, fluidState);

            float red = (tintColor >> 16 & 0xFF) / 255.0f;
            float green = (tintColor >> 8 & 0xFF) / 255.0f;
            float blue = (tintColor & 0xFF) / 255.0f;

            ScreenUtils.renderTiledSprite(context, RenderLayer::getGuiTextured, stillTexture, this.x + 83, this.y + 29 + 62 - fluidHeight, 16, fluidHeight,
                                          ColorHelper.fromFloats(1.0F, red, green, blue));
        }

        ScreenUtils.drawTexture(context, TEXTURE, this.x + 83, this.y + 34, 184, 0, 16, 51); // DRAWING FLUID MARKERS

        //TODO: Handle the fluid tooltip
        drawToolTip(context, this.x + 83, this.y + 29, 16, 62, mouseX, mouseY, amount, capacity);
    }

    private void drawToolTip(DrawContext context, int x, int y, int width , int height, int mouseX, int mouseY, long amount, long capacity)
    {
        if(!MouseHelper.isMouseOver(mouseX, mouseY, x, y, width, height))
            return;

        List<Text> texts = List.of(
                Text.literal(((int) (((float) amount / FluidConstants.BUCKET) * 1000)) + " / " + ((int) (((float) capacity / FluidConstants.BUCKET) * 1000)) + " mB")
        );

        context.drawTooltip(textRenderer, texts, mouseX, mouseY);
    }
}