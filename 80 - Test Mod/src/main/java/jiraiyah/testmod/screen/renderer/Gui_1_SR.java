package jiraiyah.testmod.screen.renderer;

import jiraiyah.jigui.client.AbstractScreenRenderer;
import jiraiyah.jigui.client.constants.*;
import jiraiyah.jigui.client.utils.ScreenHelper;
import jiraiyah.testmod.blockentity.gui.GuiBE1;
import jiraiyah.testmod.screen.handler.Gui_1_SH;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;

public class Gui_1_SR extends AbstractScreenRenderer<GuiBE1, Gui_1_SH>
{
    public Gui_1_SR(Gui_1_SH handler, PlayerInventory inventory, Text title)
    {
        super(handler, inventory, title);
    }

    private int tick;

    @Override
    protected void init()
    {
        super.init();
        tick = 0;
    }

    @Override
    protected void drawForeground(DrawContext context, int mouseX, int mouseY)
    {
        super.drawForeground(context, mouseX, mouseY);

        tick++;

        if(tick == 100)
            tick = 0;

        //region Tabs
        //top
        ScreenHelper.drawTexture(context, TabTextures.Top.NORMAL.id(),
                                51 + TabTextures.Top.NORMAL.x(), 0 + TabTextures.Top.NORMAL.y() ,
                                TabTextures.Top.NORMAL.u(), TabTextures.Top.NORMAL.v(),
                                TabTextures.Top.NORMAL.width(), TabTextures.Top.NORMAL.height(),
                                TabTextures.Top.NORMAL.textureWidth(), TabTextures.Top.NORMAL.textureHeight());

        //TODO : Fix Y
        ScreenHelper.drawTexture(context, TabTextures.Top.SELECTED.id(),
                                71 + TabTextures.Top.SELECTED.x(), 0 + TabTextures.Top.SELECTED.y() + 1,
                                 TabTextures.Top.SELECTED.u(), TabTextures.Top.SELECTED.v(),
                                 TabTextures.Top.SELECTED.width(), TabTextures.Top.SELECTED.height(),
                                 TabTextures.Top.SELECTED.textureWidth(), TabTextures.Top.SELECTED.textureHeight());
        //left
        ScreenHelper.drawTexture(context, TabTextures.Left.NORMAL.id(),
                                0 + TabTextures.Left.NORMAL.x(), 51 + TabTextures.Left.NORMAL.y(),
                                TabTextures.Left.NORMAL.u(), TabTextures.Left.NORMAL.v(),
                                TabTextures.Left.NORMAL.width(), TabTextures.Left.NORMAL.height(),
                                TabTextures.Left.NORMAL.textureWidth(), TabTextures.Left.NORMAL.textureHeight());


        //TODO: Fix X
        ScreenHelper.drawTexture(context, TabTextures.Left.SELECTED.id(),
                                0 + TabTextures.Left.SELECTED.x() + 1, 51 + TabTextures.Left.SELECTED.y() + TabTextures.Left.SELECTED.height(),
                                TabTextures.Left.SELECTED.u(), TabTextures.Left.SELECTED.v(),
                                TabTextures.Left.SELECTED.width(), TabTextures.Left.SELECTED.height(),
                                TabTextures.Left.SELECTED.textureWidth(), TabTextures.Left.SELECTED.textureHeight());

        //right
        ScreenHelper.drawTexture(context, TabTextures.Right.NORMAL.id(),
                                0 + this.backgroundWidth + TabTextures.Right.NORMAL.x(), 51 + TabTextures.Right.NORMAL.y(),
                                TabTextures.Right.NORMAL.u(), TabTextures.Right.NORMAL.v(),
                                TabTextures.Right.NORMAL.width(), TabTextures.Right.NORMAL.height(),
                                TabTextures.Right.NORMAL.textureWidth(), TabTextures.Right.NORMAL.textureHeight());

        ScreenHelper.drawTexture(context, TabTextures.Right.SELECTED.id(),
                                0 + this.backgroundWidth + TabTextures.Right.SELECTED.x(), 51 + TabTextures.Right.SELECTED.y() + TabTextures.Right.SELECTED.height(),
                                TabTextures.Right.SELECTED.u(), TabTextures.Right.SELECTED.v(),
                                TabTextures.Right.SELECTED.width(), TabTextures.Right.SELECTED.height(),
                                TabTextures.Right.SELECTED.textureWidth(), TabTextures.Right.SELECTED.textureHeight());

        //bottom
        ScreenHelper.drawTexture(context, TabTextures.Bottom.NORMAL.id(),
                                51 + TabTextures.Bottom.NORMAL.x(), 0 + this.backgroundHeight + TabTextures.Bottom.NORMAL.y(),
                                TabTextures.Bottom.NORMAL.u(), TabTextures.Bottom.NORMAL.v(),
                                TabTextures.Bottom.NORMAL.width(), TabTextures.Bottom.NORMAL.height(),
                                TabTextures.Bottom.NORMAL.textureWidth(), TabTextures.Bottom.NORMAL.textureHeight());

        //TODO: Fix Y
        ScreenHelper.drawTexture(context, TabTextures.Bottom.SELECTED.id(),
                                51 + TabTextures.Bottom.SELECTED.x() + TabTextures.Bottom.SELECTED.width(), 0 - 1 + this.backgroundHeight + TabTextures.Bottom.SELECTED.y(),
                                TabTextures.Bottom.SELECTED.u(), TabTextures.Bottom.SELECTED.v(),
                                TabTextures.Bottom.SELECTED.width(), TabTextures.Bottom.SELECTED.height(),
                                TabTextures.Bottom.SELECTED.textureWidth(), TabTextures.Bottom.SELECTED.textureHeight());
        //endregion

        //region Arrows - HUD
        ScreenHelper.drawTexture(context, ArrowTextures.HUD.ARROW_DRAG.id(),
                                2, 1,
                                ArrowTextures.HUD.ARROW_DRAG.u(), ArrowTextures.HUD.ARROW_DRAG.v(),
                                ArrowTextures.HUD.ARROW_DRAG.width(), ArrowTextures.HUD.ARROW_DRAG.height(),
                                ArrowTextures.HUD.ARROW_DRAG.textureWidth(), ArrowTextures.HUD.ARROW_DRAG.textureHeight());

        ScreenHelper.drawTexture(context, ArrowTextures.HUD.ARROW_RESIZE_H.id(),
                                2, 25,
                                ArrowTextures.HUD.ARROW_RESIZE_H.u(), ArrowTextures.HUD.ARROW_RESIZE_H.v(),
                                ArrowTextures.HUD.ARROW_RESIZE_H.width(), ArrowTextures.HUD.ARROW_RESIZE_H.height(),
                                ArrowTextures.HUD.ARROW_RESIZE_H.textureWidth(), ArrowTextures.HUD.ARROW_RESIZE_H.textureHeight());

        ScreenHelper.drawTexture(context, ArrowTextures.HUD.ARROW_RESIZE_TL_BR.id(),
                                2, 45,
                                ArrowTextures.HUD.ARROW_RESIZE_TL_BR.u(), ArrowTextures.HUD.ARROW_RESIZE_TL_BR.v(),
                                ArrowTextures.HUD.ARROW_RESIZE_TL_BR.width(), ArrowTextures.HUD.ARROW_RESIZE_TL_BR.height(),
                                ArrowTextures.HUD.ARROW_RESIZE_TL_BR.textureWidth(), ArrowTextures.HUD.ARROW_RESIZE_TL_BR.textureHeight());

        ScreenHelper.drawTexture(context, ArrowTextures.HUD.ARROW_RESIZE_TR_BL.id(),
                                2, 75,
                                ArrowTextures.HUD.ARROW_RESIZE_TR_BL.u(), ArrowTextures.HUD.ARROW_RESIZE_TR_BL.v(),
                                ArrowTextures.HUD.ARROW_RESIZE_TR_BL.width(), ArrowTextures.HUD.ARROW_RESIZE_TR_BL.height(),
                                ArrowTextures.HUD.ARROW_RESIZE_TR_BL.textureWidth(), ArrowTextures.HUD.ARROW_RESIZE_TL_BR.textureHeight());

        ScreenHelper.drawTexture(context, ArrowTextures.HUD.ARROW_RESIZE_V.id(),
                                26, 1,
                                ArrowTextures.HUD.ARROW_RESIZE_V.u(), ArrowTextures.HUD.ARROW_RESIZE_V.v(),
                                ArrowTextures.HUD.ARROW_RESIZE_V.width(), ArrowTextures.HUD.ARROW_RESIZE_V.height(),
                                ArrowTextures.HUD.ARROW_RESIZE_V.textureWidth(), ArrowTextures.HUD.ARROW_RESIZE_V.textureHeight());
        //endregion

        //region Arrows - Small
        ScreenHelper.drawTexture(context, ArrowTextures.Small.ARROW_DOWN.id(),
                                2, 106,
                                ArrowTextures.Small.ARROW_DOWN.u(), ArrowTextures.Small.ARROW_DOWN.v(),
                                ArrowTextures.Small.ARROW_DOWN.width(), ArrowTextures.Small.ARROW_DOWN.height(),
                                ArrowTextures.Small.ARROW_DOWN.textureWidth(), 16);//ArrowTextures.Small.ARROW_DOWN.textureHeight());

        ScreenHelper.drawTexture(context, ArrowTextures.Small.ARROW_UP.id(),
                                2, 116,
                                ArrowTextures.Small.ARROW_UP.u(), ArrowTextures.Small.ARROW_UP.v(),
                                ArrowTextures.Small.ARROW_UP.width(), ArrowTextures.Small.ARROW_UP.height(),
                                ArrowTextures.Small.ARROW_UP.textureWidth(), 16);//ArrowTextures.Small.ARROW_DOWN.textureHeight());

        ScreenHelper.drawTexture(context, ArrowTextures.Small.ARROW_LEFT.id(),
                                12, 106,
                                ArrowTextures.Small.ARROW_LEFT.u(), ArrowTextures.Small.ARROW_LEFT.v(),
                                ArrowTextures.Small.ARROW_LEFT.width(), ArrowTextures.Small.ARROW_LEFT.height(),
                                ArrowTextures.Small.ARROW_LEFT.textureWidth(), 16);//ArrowTextures.Small.ARROW_DOWN.textureHeight());

        ScreenHelper.drawTexture(context, ArrowTextures.Small.ARROW_RIGHT.id(),
                                12, 116,
                                ArrowTextures.Small.ARROW_RIGHT.u(), ArrowTextures.Small.ARROW_RIGHT.v(),
                                ArrowTextures.Small.ARROW_RIGHT.width(), ArrowTextures.Small.ARROW_RIGHT.height(),
                                ArrowTextures.Small.ARROW_RIGHT.textureWidth(), 16);//ArrowTextures.Small.ARROW_DOWN.textureHeight());
        //endregion

        //region ALARM & DOT
        ScreenHelper.drawTexture(context, IndicatorLightTextures.Alarm.Off.BLACK.id(),
                                22, 106,
                                IndicatorLightTextures.Alarm.Off.BLACK.u(), IndicatorLightTextures.Alarm.Off.BLACK.v(),
                                IndicatorLightTextures.Alarm.Off.BLACK.width(), IndicatorLightTextures.Alarm.Off.BLACK.height(),
                                IndicatorLightTextures.Alarm.Off.BLACK.textureWidth(), IndicatorLightTextures.Alarm.Off.BLACK.textureHeight());

        if(tick % 50 >= 0 && tick % 50 <= 20)
            ScreenHelper.drawTexture(context, IndicatorLightTextures.Alarm.On.BLACK.id(),
                                    22, 106,
                                    IndicatorLightTextures.Alarm.On.BLACK.u(), IndicatorLightTextures.Alarm.On.BLACK.v(),
                                    IndicatorLightTextures.Alarm.On.BLACK.width(), IndicatorLightTextures.Alarm.On.BLACK.height(),
                                    IndicatorLightTextures.Alarm.On.BLACK.textureWidth(), IndicatorLightTextures.Alarm.On.BLACK.textureHeight());

        ScreenHelper.drawTexture(context, IndicatorLightTextures.Alarm.Off.BLUE.id(),
                                32, 106,
                                IndicatorLightTextures.Alarm.Off.BLUE.u(), IndicatorLightTextures.Alarm.Off.BLUE.v(),
                                IndicatorLightTextures.Alarm.Off.BLUE.width(), IndicatorLightTextures.Alarm.Off.BLUE.height(),
                                IndicatorLightTextures.Alarm.Off.BLUE.textureWidth(), IndicatorLightTextures.Alarm.Off.BLUE.textureHeight());

        if(tick % 50 >= 0 && tick % 50 <= 20)
            ScreenHelper.drawTexture(context, IndicatorLightTextures.Alarm.On.BLUE.id(),
                                    32, 106,
                                    IndicatorLightTextures.Alarm.On.BLUE.u(), IndicatorLightTextures.Alarm.On.BLUE.v(),
                                    IndicatorLightTextures.Alarm.On.BLUE.width(), IndicatorLightTextures.Alarm.On.BLUE.height(),
                                    IndicatorLightTextures.Alarm.On.BLUE.textureWidth(), IndicatorLightTextures.Alarm.On.BLUE.textureHeight());

        ScreenHelper.drawTexture(context, IndicatorLightTextures.Alarm.Off.BROWN.id(),
                                42, 106,
                                IndicatorLightTextures.Alarm.Off.BROWN.u(), IndicatorLightTextures.Alarm.Off.BROWN.v(),
                                IndicatorLightTextures.Alarm.Off.BROWN.width(), IndicatorLightTextures.Alarm.Off.BROWN.height(),
                                IndicatorLightTextures.Alarm.Off.BROWN.textureWidth(), IndicatorLightTextures.Alarm.Off.BROWN.textureHeight());

        if(tick % 50 >= 0 && tick % 50 <= 20)
            ScreenHelper.drawTexture(context, IndicatorLightTextures.Alarm.On.BROWN.id(),
                                    42, 106,
                                    IndicatorLightTextures.Alarm.On.BROWN.u(), IndicatorLightTextures.Alarm.On.BROWN.v(),
                                    IndicatorLightTextures.Alarm.On.BROWN.width(), IndicatorLightTextures.Alarm.On.BROWN.height(),
                                    IndicatorLightTextures.Alarm.On.BROWN.textureWidth(), IndicatorLightTextures.Alarm.On.BROWN.textureHeight());

        ScreenHelper.drawTexture(context, IndicatorLightTextures.Alarm.Off.CYAN.id(),
                                52, 106,
                                IndicatorLightTextures.Alarm.Off.CYAN.u(), IndicatorLightTextures.Alarm.Off.CYAN.v(),
                                IndicatorLightTextures.Alarm.Off.CYAN.width(), IndicatorLightTextures.Alarm.Off.CYAN.height(),
                                IndicatorLightTextures.Alarm.Off.CYAN.textureWidth(), IndicatorLightTextures.Alarm.Off.CYAN.textureHeight());

        if(tick % 50 >= 0 && tick % 50 <= 20)
            ScreenHelper.drawTexture(context, IndicatorLightTextures.Alarm.On.CYAN.id(),
                                    52, 106,
                                    IndicatorLightTextures.Alarm.On.CYAN.u(), IndicatorLightTextures.Alarm.On.CYAN.v(),
                                    IndicatorLightTextures.Alarm.On.CYAN.width(), IndicatorLightTextures.Alarm.On.CYAN.height(),
                                    IndicatorLightTextures.Alarm.On.CYAN.textureWidth(), IndicatorLightTextures.Alarm.On.CYAN.textureHeight());

        ScreenHelper.drawTexture(context, IndicatorLightTextures.Alarm.Off.GOLD.id(),
                                62, 106,
                                IndicatorLightTextures.Alarm.Off.GOLD.u(), IndicatorLightTextures.Alarm.Off.GOLD.v(),
                                IndicatorLightTextures.Alarm.Off.GOLD.width(), IndicatorLightTextures.Alarm.Off.GOLD.height(),
                                IndicatorLightTextures.Alarm.Off.GOLD.textureWidth(), IndicatorLightTextures.Alarm.Off.GOLD.textureHeight());

        if(tick % 50 >= 0 && tick % 50 <= 20)
            ScreenHelper.drawTexture(context, IndicatorLightTextures.Alarm.On.GOLD.id(),
                                    62, 106,
                                    IndicatorLightTextures.Alarm.On.GOLD.u(), IndicatorLightTextures.Alarm.On.GOLD.v(),
                                    IndicatorLightTextures.Alarm.On.GOLD.width(), IndicatorLightTextures.Alarm.On.GOLD.height(),
                                    IndicatorLightTextures.Alarm.On.GOLD.textureWidth(), IndicatorLightTextures.Alarm.On.GOLD.textureHeight());

        ScreenHelper.drawTexture(context, IndicatorLightTextures.Alarm.Off.GRAY.id(),
                                72, 106,
                                IndicatorLightTextures.Alarm.Off.GRAY.u(), IndicatorLightTextures.Alarm.Off.GRAY.v(),
                                IndicatorLightTextures.Alarm.Off.GRAY.width(), IndicatorLightTextures.Alarm.Off.GRAY.height(),
                                IndicatorLightTextures.Alarm.Off.GRAY.textureWidth(), IndicatorLightTextures.Alarm.Off.GRAY.textureHeight());

        if(tick % 50 >= 0 && tick % 50 <= 20)
            ScreenHelper.drawTexture(context, IndicatorLightTextures.Alarm.On.GRAY.id(),
                                    72, 106,
                                    IndicatorLightTextures.Alarm.On.GRAY.u(), IndicatorLightTextures.Alarm.On.GRAY.v(),
                                    IndicatorLightTextures.Alarm.On.GRAY.width(), IndicatorLightTextures.Alarm.On.GRAY.height(),
                                    IndicatorLightTextures.Alarm.On.GRAY.textureWidth(), IndicatorLightTextures.Alarm.On.GRAY.textureHeight());

        ScreenHelper.drawTexture(context, IndicatorLightTextures.Alarm.Off.GREEN.id(),
                                82, 106,
                                IndicatorLightTextures.Alarm.Off.GREEN.u(), IndicatorLightTextures.Alarm.Off.GREEN.v(),
                                IndicatorLightTextures.Alarm.Off.GREEN.width(), IndicatorLightTextures.Alarm.Off.GREEN.height(),
                                IndicatorLightTextures.Alarm.Off.GREEN.textureWidth(), IndicatorLightTextures.Alarm.Off.GREEN.textureHeight());

        if(tick % 50 >= 0 && tick % 50 <= 20)
            ScreenHelper.drawTexture(context, IndicatorLightTextures.Alarm.On.GREEN.id(),
                                    82, 106,
                                    IndicatorLightTextures.Alarm.On.GREEN.u(), IndicatorLightTextures.Alarm.On.GREEN.v(),
                                    IndicatorLightTextures.Alarm.On.GREEN.width(), IndicatorLightTextures.Alarm.On.GREEN.height(),
                                    IndicatorLightTextures.Alarm.On.GREEN.textureWidth(), IndicatorLightTextures.Alarm.On.GREEN.textureHeight());

        ScreenHelper.drawTexture(context, IndicatorLightTextures.Alarm.Off.LIGHT_BLUE.id(),
                                92, 106,
                                IndicatorLightTextures.Alarm.Off.LIGHT_BLUE.u(), IndicatorLightTextures.Alarm.Off.LIGHT_BLUE.v(),
                                IndicatorLightTextures.Alarm.Off.LIGHT_BLUE.width(), IndicatorLightTextures.Alarm.Off.LIGHT_BLUE.height(),
                                IndicatorLightTextures.Alarm.Off.LIGHT_BLUE.textureWidth(), IndicatorLightTextures.Alarm.Off.LIGHT_BLUE.textureHeight());

        if(tick % 50 >= 0 && tick % 50 <= 20)
            ScreenHelper.drawTexture(context, IndicatorLightTextures.Alarm.On.LIGHT_BLUE.id(),
                                    92, 106,
                                    IndicatorLightTextures.Alarm.On.LIGHT_BLUE.u(), IndicatorLightTextures.Alarm.On.LIGHT_BLUE.v(),
                                    IndicatorLightTextures.Alarm.On.LIGHT_BLUE.width(), IndicatorLightTextures.Alarm.On.LIGHT_BLUE.height(),
                                    IndicatorLightTextures.Alarm.On.LIGHT_BLUE.textureWidth(), IndicatorLightTextures.Alarm.On.LIGHT_BLUE.textureHeight());

        ScreenHelper.drawTexture(context, IndicatorLightTextures.Alarm.Off.LIGHT_GRAY.id(),
                                102, 106,
                                IndicatorLightTextures.Alarm.Off.LIGHT_GRAY.u(), IndicatorLightTextures.Alarm.Off.LIGHT_GRAY.v(),
                                IndicatorLightTextures.Alarm.Off.LIGHT_GRAY.width(), IndicatorLightTextures.Alarm.Off.LIGHT_GRAY.height(),
                                IndicatorLightTextures.Alarm.Off.LIGHT_GRAY.textureWidth(), IndicatorLightTextures.Alarm.Off.LIGHT_GRAY.textureHeight());

        if(tick % 50 >= 0 && tick % 50 <= 20)
            ScreenHelper.drawTexture(context, IndicatorLightTextures.Alarm.On.LIGHT_GRAY.id(),
                                    102, 106,
                                    IndicatorLightTextures.Alarm.On.LIGHT_GRAY.u(), IndicatorLightTextures.Alarm.On.LIGHT_GRAY.v(),
                                    IndicatorLightTextures.Alarm.On.LIGHT_GRAY.width(), IndicatorLightTextures.Alarm.On.LIGHT_GRAY.height(),
                                    IndicatorLightTextures.Alarm.On.LIGHT_GRAY.textureWidth(), IndicatorLightTextures.Alarm.On.LIGHT_GRAY.textureHeight());

        ScreenHelper.drawTexture(context, IndicatorLightTextures.Alarm.Off.LIME.id(),
                                112, 106,
                                IndicatorLightTextures.Alarm.Off.LIME.u(), IndicatorLightTextures.Alarm.Off.LIME.v(),
                                IndicatorLightTextures.Alarm.Off.LIME.width(), IndicatorLightTextures.Alarm.Off.LIME.height(),
                                IndicatorLightTextures.Alarm.Off.LIME.textureWidth(), IndicatorLightTextures.Alarm.Off.LIME.textureHeight());

        if(tick % 50 >= 0 && tick % 50 <= 20)
            ScreenHelper.drawTexture(context, IndicatorLightTextures.Alarm.On.LIME.id(),
                                    112, 106,
                                    IndicatorLightTextures.Alarm.On.LIME.u(), IndicatorLightTextures.Alarm.On.LIME.v(),
                                    IndicatorLightTextures.Alarm.On.LIME.width(), IndicatorLightTextures.Alarm.On.LIME.height(),
                                    IndicatorLightTextures.Alarm.On.LIME.textureWidth(), IndicatorLightTextures.Alarm.On.LIME.textureHeight());

        ScreenHelper.drawTexture(context, IndicatorLightTextures.Alarm.Off.MAGENTA.id(),
                                122, 106,
                                IndicatorLightTextures.Alarm.Off.MAGENTA.u(), IndicatorLightTextures.Alarm.Off.MAGENTA.v(),
                                IndicatorLightTextures.Alarm.Off.MAGENTA.width(), IndicatorLightTextures.Alarm.Off.MAGENTA.height(),
                                IndicatorLightTextures.Alarm.Off.MAGENTA.textureWidth(), IndicatorLightTextures.Alarm.Off.MAGENTA.textureHeight());

        if(tick % 50 >= 0 && tick % 50 <= 20)
            ScreenHelper.drawTexture(context, IndicatorLightTextures.Alarm.On.MAGENTA.id(),
                                    122, 106,
                                    IndicatorLightTextures.Alarm.On.MAGENTA.u(), IndicatorLightTextures.Alarm.On.MAGENTA.v(),
                                    IndicatorLightTextures.Alarm.On.MAGENTA.width(), IndicatorLightTextures.Alarm.On.MAGENTA.height(),
                                    IndicatorLightTextures.Alarm.On.MAGENTA.textureWidth(), IndicatorLightTextures.Alarm.On.MAGENTA.textureHeight());

        ScreenHelper.drawTexture(context, IndicatorLightTextures.Alarm.Off.OLIVE.id(),
                                132, 106,
                                IndicatorLightTextures.Alarm.Off.OLIVE.u(), IndicatorLightTextures.Alarm.Off.OLIVE.v(),
                                IndicatorLightTextures.Alarm.Off.OLIVE.width(), IndicatorLightTextures.Alarm.Off.OLIVE.height(),
                                IndicatorLightTextures.Alarm.Off.OLIVE.textureWidth(), IndicatorLightTextures.Alarm.Off.OLIVE.textureHeight());

        if(tick % 50 >= 0 && tick % 50 <= 20)
            ScreenHelper.drawTexture(context, IndicatorLightTextures.Alarm.On.OLIVE.id(),
                                    132, 106,
                                    IndicatorLightTextures.Alarm.On.OLIVE.u(), IndicatorLightTextures.Alarm.On.OLIVE.v(),
                                    IndicatorLightTextures.Alarm.On.OLIVE.width(), IndicatorLightTextures.Alarm.On.OLIVE.height(),
                                    IndicatorLightTextures.Alarm.On.OLIVE.textureWidth(), IndicatorLightTextures.Alarm.On.OLIVE.textureHeight());

        ScreenHelper.drawTexture(context, IndicatorLightTextures.Alarm.Off.ORANGE.id(),
                                142, 106,
                                IndicatorLightTextures.Alarm.Off.ORANGE.u(), IndicatorLightTextures.Alarm.Off.ORANGE.v(),
                                IndicatorLightTextures.Alarm.Off.ORANGE.width(), IndicatorLightTextures.Alarm.Off.ORANGE.height(),
                                IndicatorLightTextures.Alarm.Off.ORANGE.textureWidth(), IndicatorLightTextures.Alarm.Off.ORANGE.textureHeight());

        if(tick % 50 >= 0 && tick % 50 <= 20)
            ScreenHelper.drawTexture(context, IndicatorLightTextures.Alarm.On.ORANGE.id(),
                                    142, 106,
                                    IndicatorLightTextures.Alarm.On.ORANGE.u(), IndicatorLightTextures.Alarm.On.ORANGE.v(),
                                    IndicatorLightTextures.Alarm.On.ORANGE.width(), IndicatorLightTextures.Alarm.On.ORANGE.height(),
                                    IndicatorLightTextures.Alarm.On.ORANGE.textureWidth(), IndicatorLightTextures.Alarm.On.ORANGE.textureHeight());

        ScreenHelper.drawTexture(context, IndicatorLightTextures.Alarm.Off.PINK.id(),
                                152, 106,
                                IndicatorLightTextures.Alarm.Off.PINK.u(), IndicatorLightTextures.Alarm.Off.PINK.v(),
                                IndicatorLightTextures.Alarm.Off.PINK.width(), IndicatorLightTextures.Alarm.Off.PINK.height(),
                                IndicatorLightTextures.Alarm.Off.PINK.textureWidth(), IndicatorLightTextures.Alarm.Off.PINK.textureHeight());

        if(tick % 50 >= 0 && tick % 50 <= 20)
            ScreenHelper.drawTexture(context, IndicatorLightTextures.Alarm.On.PINK.id(),
                                    152, 106,
                                    IndicatorLightTextures.Alarm.On.PINK.u(), IndicatorLightTextures.Alarm.On.PINK.v(),
                                    IndicatorLightTextures.Alarm.On.PINK.width(), IndicatorLightTextures.Alarm.On.PINK.height(),
                                    IndicatorLightTextures.Alarm.On.PINK.textureWidth(), IndicatorLightTextures.Alarm.On.PINK.textureHeight());

        ScreenHelper.drawTexture(context, IndicatorLightTextures.Alarm.Off.PURPLE.id(),
                                22, 116,
                                IndicatorLightTextures.Alarm.Off.PURPLE.u(), IndicatorLightTextures.Alarm.Off.PURPLE.v(),
                                IndicatorLightTextures.Alarm.Off.PURPLE.width(), IndicatorLightTextures.Alarm.Off.PURPLE.height(),
                                IndicatorLightTextures.Alarm.Off.PURPLE.textureWidth(), IndicatorLightTextures.Alarm.Off.PURPLE.textureHeight());

        if(tick % 50 >= 0 && tick % 50 <= 20)
            ScreenHelper.drawTexture(context, IndicatorLightTextures.Alarm.On.PURPLE.id(),
                                    22, 116,
                                    IndicatorLightTextures.Alarm.On.PURPLE.u(), IndicatorLightTextures.Alarm.On.PURPLE.v(),
                                    IndicatorLightTextures.Alarm.On.PURPLE.width(), IndicatorLightTextures.Alarm.On.PURPLE.height(),
                                    IndicatorLightTextures.Alarm.On.PURPLE.textureWidth(), IndicatorLightTextures.Alarm.On.PURPLE.textureHeight());

        ScreenHelper.drawTexture(context, IndicatorLightTextures.Alarm.Off.RED.id(),
                                32, 116,
                                IndicatorLightTextures.Alarm.Off.RED.u(), IndicatorLightTextures.Alarm.Off.RED.v(),
                                IndicatorLightTextures.Alarm.Off.RED.width(), IndicatorLightTextures.Alarm.Off.RED.height(),
                                IndicatorLightTextures.Alarm.Off.RED.textureWidth(), IndicatorLightTextures.Alarm.Off.RED.textureHeight());

        if(tick % 50 >= 0 && tick % 50 <= 20)
            ScreenHelper.drawTexture(context, IndicatorLightTextures.Alarm.On.RED.id(),
                                    32, 116,
                                    IndicatorLightTextures.Alarm.On.RED.u(), IndicatorLightTextures.Alarm.On.RED.v(),
                                    IndicatorLightTextures.Alarm.On.RED.width(), IndicatorLightTextures.Alarm.On.RED.height(),
                                    IndicatorLightTextures.Alarm.On.RED.textureWidth(), IndicatorLightTextures.Alarm.On.RED.textureHeight());

        ScreenHelper.drawTexture(context, IndicatorLightTextures.Alarm.Off.SILVER.id(),
                                42, 116,
                                IndicatorLightTextures.Alarm.Off.SILVER.u(), IndicatorLightTextures.Alarm.Off.SILVER.v(),
                                IndicatorLightTextures.Alarm.Off.SILVER.width(), IndicatorLightTextures.Alarm.Off.SILVER.height(),
                                IndicatorLightTextures.Alarm.Off.SILVER.textureWidth(), IndicatorLightTextures.Alarm.Off.SILVER.textureHeight());

        if(tick % 50 >= 0 && tick % 50 <= 20)
            ScreenHelper.drawTexture(context, IndicatorLightTextures.Alarm.On.SILVER.id(),
                                    42, 116,
                                    IndicatorLightTextures.Alarm.On.SILVER.u(), IndicatorLightTextures.Alarm.On.SILVER.v(),
                                    IndicatorLightTextures.Alarm.On.SILVER.width(), IndicatorLightTextures.Alarm.On.SILVER.height(),
                                    IndicatorLightTextures.Alarm.On.SILVER.textureWidth(), IndicatorLightTextures.Alarm.On.SILVER.textureHeight());

        ScreenHelper.drawTexture(context, IndicatorLightTextures.Alarm.Off.WHITE.id(),
                                52, 116,
                                IndicatorLightTextures.Alarm.Off.WHITE.u(), IndicatorLightTextures.Alarm.Off.WHITE.v(),
                                IndicatorLightTextures.Alarm.Off.WHITE.width(), IndicatorLightTextures.Alarm.Off.WHITE.height(),
                                IndicatorLightTextures.Alarm.Off.WHITE.textureWidth(), IndicatorLightTextures.Alarm.Off.WHITE.textureHeight());

        if(tick % 50 >= 0 && tick % 50 <= 20)
            ScreenHelper.drawTexture(context, IndicatorLightTextures.Alarm.On.WHITE.id(),
                                    52, 116,
                                    IndicatorLightTextures.Alarm.On.WHITE.u(), IndicatorLightTextures.Alarm.On.WHITE.v(),
                                    IndicatorLightTextures.Alarm.On.WHITE.width(), IndicatorLightTextures.Alarm.On.WHITE.height(),
                                    IndicatorLightTextures.Alarm.On.WHITE.textureWidth(), IndicatorLightTextures.Alarm.On.WHITE.textureHeight());

        ScreenHelper.drawTexture(context, IndicatorLightTextures.Alarm.Off.YELLOW.id(),
                                62, 116,
                                IndicatorLightTextures.Alarm.Off.YELLOW.u(), IndicatorLightTextures.Alarm.Off.YELLOW.v(),
                                IndicatorLightTextures.Alarm.Off.YELLOW.width(), IndicatorLightTextures.Alarm.Off.YELLOW.height(),
                                IndicatorLightTextures.Alarm.Off.YELLOW.textureWidth(), IndicatorLightTextures.Alarm.Off.YELLOW.textureHeight());

        if(tick % 50 >= 0 && tick % 50 <= 20)
            ScreenHelper.drawTexture(context, IndicatorLightTextures.Alarm.On.YELLOW.id(),
                                    62, 116,
                                    IndicatorLightTextures.Alarm.On.YELLOW.u(), IndicatorLightTextures.Alarm.On.YELLOW.v(),
                                    IndicatorLightTextures.Alarm.On.YELLOW.width(), IndicatorLightTextures.Alarm.On.YELLOW.height(),
                                    IndicatorLightTextures.Alarm.On.YELLOW.textureWidth(), IndicatorLightTextures.Alarm.On.YELLOW.textureHeight());
        //endregion

        //region CONTAINER MODE
        ScreenHelper.drawTexture(context, ContainerTextures.ContainerMode.EXTRACT.id(),
                                55, 15,
                                ContainerTextures.ContainerMode.EXTRACT.u(), ContainerTextures.ContainerMode.EXTRACT.v(),
                                ContainerTextures.ContainerMode.EXTRACT.width(), ContainerTextures.ContainerMode.EXTRACT.height(),
                                ContainerTextures.ContainerMode.EXTRACT.textureWidth(), ContainerTextures.ContainerMode.EXTRACT.textureHeight());

        ScreenHelper.drawTexture(context, ContainerTextures.ContainerMode.FILL.id(),
                                72, 15,
                                ContainerTextures.ContainerMode.FILL.u(), ContainerTextures.ContainerMode.FILL.v(),
                                ContainerTextures.ContainerMode.FILL.width(), ContainerTextures.ContainerMode.FILL.height(),
                                ContainerTextures.ContainerMode.FILL.textureWidth(), ContainerTextures.ContainerMode.FILL.textureHeight());

        ScreenHelper.drawTexture(context, ContainerTextures.ContainerMode.LOCKED.id(),
                                55, 32,
                                ContainerTextures.ContainerMode.LOCKED.u(), ContainerTextures.ContainerMode.LOCKED.v(),
                                ContainerTextures.ContainerMode.LOCKED.width(), ContainerTextures.ContainerMode.LOCKED.height(),
                                ContainerTextures.ContainerMode.LOCKED.textureWidth(), ContainerTextures.ContainerMode.LOCKED.textureHeight());

        ScreenHelper.drawTexture(context, ContainerTextures.ContainerMode.IO.id(),
                                72, 32,
                                ContainerTextures.ContainerMode.IO.u(), ContainerTextures.ContainerMode.IO.v(),
                                ContainerTextures.ContainerMode.IO.width(), ContainerTextures.ContainerMode.IO.height(),
                                ContainerTextures.ContainerMode.IO.textureWidth(), ContainerTextures.ContainerMode.IO.textureHeight());
        //endregion

        //region LOCK
        ScreenHelper.drawTexture(context, ContainerTextures.Lock.OPEN.id(),
                                90, 15,
                                ContainerTextures.Lock.OPEN.u(), ContainerTextures.Lock.OPEN.v(),
                                ContainerTextures.Lock.OPEN.width(), ContainerTextures.Lock.OPEN.height(),
                                ContainerTextures.Lock.OPEN.textureWidth(), ContainerTextures.Lock.OPEN.textureHeight());

        ScreenHelper.drawTexture(context, ContainerTextures.Lock.CLOSE.id(),
                                90, 32,
                                ContainerTextures.Lock.CLOSE.u(), ContainerTextures.Lock.CLOSE.v(),
                                ContainerTextures.Lock.CLOSE.width(), ContainerTextures.Lock.CLOSE.height(),
                                ContainerTextures.Lock.CLOSE.textureWidth(), ContainerTextures.Lock.CLOSE.textureHeight());
        //endregion

        ScreenHelper.drawTexture(context, VanillaTextures.Buttons.Alert.NORMAL.id(),
                                106, 15,
                                VanillaTextures.Buttons.Alert.NORMAL.u(), VanillaTextures.Buttons.Alert.NORMAL.v(),
                                VanillaTextures.Buttons.Alert.NORMAL.width(), VanillaTextures.Buttons.Alert.NORMAL.height(),
                                VanillaTextures.Buttons.Alert.NORMAL.textureWidth(), VanillaTextures.Buttons.Alert.NORMAL.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Buttons.Alert.HIGHLIGHTED.id(),
                                128, 15,
                                VanillaTextures.Buttons.Alert.HIGHLIGHTED.u(), VanillaTextures.Buttons.Alert.HIGHLIGHTED.v(),
                                VanillaTextures.Buttons.Alert.HIGHLIGHTED.width(), VanillaTextures.Buttons.Alert.HIGHLIGHTED.height(),
                                VanillaTextures.Buttons.Alert.HIGHLIGHTED.textureWidth(), VanillaTextures.Buttons.Alert.HIGHLIGHTED.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Buttons.Alert.DISABLED.id(),
                                150, 15,
                                VanillaTextures.Buttons.Alert.DISABLED.u(), VanillaTextures.Buttons.Alert.DISABLED.v(),
                                VanillaTextures.Buttons.Alert.DISABLED.width(), VanillaTextures.Buttons.Alert.DISABLED.height(),
                                VanillaTextures.Buttons.Alert.DISABLED.textureWidth(), VanillaTextures.Buttons.Alert.DISABLED.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Buttons.Book.NORMAL.id(),
                                106, 37,
                                VanillaTextures.Buttons.Book.NORMAL.u(), VanillaTextures.Buttons.Book.NORMAL.v(),
                                VanillaTextures.Buttons.Book.NORMAL.width(), VanillaTextures.Buttons.Book.NORMAL.height(),
                                VanillaTextures.Buttons.Book.NORMAL.textureWidth(), VanillaTextures.Buttons.Book.NORMAL.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Buttons.Book.HIGHLIGHTED.id(),
                                128, 37,
                                VanillaTextures.Buttons.Book.HIGHLIGHTED.u(), VanillaTextures.Buttons.Book.HIGHLIGHTED.v(),
                                VanillaTextures.Buttons.Book.HIGHLIGHTED.width(), VanillaTextures.Buttons.Book.HIGHLIGHTED.height(),
                                VanillaTextures.Buttons.Book.HIGHLIGHTED.textureWidth(), VanillaTextures.Buttons.Book.HIGHLIGHTED.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Buttons.Checkbox.NORMAL.id(),
                                106, 59,
                                VanillaTextures.Buttons.Checkbox.NORMAL.u(), VanillaTextures.Buttons.Checkbox.NORMAL.v(),
                                VanillaTextures.Buttons.Checkbox.NORMAL.width(), VanillaTextures.Buttons.Checkbox.NORMAL.height(),
                                VanillaTextures.Buttons.Checkbox.NORMAL.textureWidth(), VanillaTextures.Buttons.Checkbox.NORMAL.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Buttons.Checkbox.HIGHLIGHTED.id(),
                                128, 59,
                                VanillaTextures.Buttons.Checkbox.HIGHLIGHTED.u(), VanillaTextures.Buttons.Checkbox.HIGHLIGHTED.v(),
                                VanillaTextures.Buttons.Checkbox.HIGHLIGHTED.width(), VanillaTextures.Buttons.Checkbox.HIGHLIGHTED.height(),
                                VanillaTextures.Buttons.Checkbox.HIGHLIGHTED.textureWidth(), VanillaTextures.Buttons.Checkbox.HIGHLIGHTED.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Buttons.Checkbox.SELECTED.id(),
                                150, 59,
                                VanillaTextures.Buttons.Checkbox.SELECTED.u(), VanillaTextures.Buttons.Checkbox.SELECTED.v(),
                                VanillaTextures.Buttons.Checkbox.SELECTED.width(), VanillaTextures.Buttons.Checkbox.SELECTED.height(),
                                VanillaTextures.Buttons.Checkbox.SELECTED.textureWidth(), VanillaTextures.Buttons.Checkbox.SELECTED.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Buttons.Checkbox.SELECTED_HIGHLIGHTED.id(),
                                150, 37,
                                VanillaTextures.Buttons.Checkbox.SELECTED_HIGHLIGHTED.u(), VanillaTextures.Buttons.Checkbox.SELECTED_HIGHLIGHTED.v(),
                                VanillaTextures.Buttons.Checkbox.SELECTED_HIGHLIGHTED.width(), VanillaTextures.Buttons.Checkbox.SELECTED_HIGHLIGHTED.height(),
                                VanillaTextures.Buttons.Checkbox.SELECTED_HIGHLIGHTED.textureWidth(), VanillaTextures.Buttons.Checkbox.SELECTED_HIGHLIGHTED.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Buttons.Cross.NORMAL.id(),
                                37, 35,
                                VanillaTextures.Buttons.Cross.NORMAL.u(), VanillaTextures.Buttons.Cross.NORMAL.v(),
                                VanillaTextures.Buttons.Cross.NORMAL.width(), VanillaTextures.Buttons.Cross.NORMAL.height(),
                                VanillaTextures.Buttons.Cross.NORMAL.textureWidth(), VanillaTextures.Buttons.Cross.NORMAL.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Buttons.Cross.HIGHLIGHTED.id(),
                                37, 50,
                                VanillaTextures.Buttons.Cross.HIGHLIGHTED.u(), VanillaTextures.Buttons.Cross.HIGHLIGHTED.v(),
                                VanillaTextures.Buttons.Cross.HIGHLIGHTED.width(), VanillaTextures.Buttons.Cross.HIGHLIGHTED.height(),
                                VanillaTextures.Buttons.Cross.HIGHLIGHTED.textureWidth(), VanillaTextures.Buttons.Cross.HIGHLIGHTED.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Buttons.Lock.Open.NORMAL.id(),
                                106, 81,
                                VanillaTextures.Buttons.Lock.Open.NORMAL.u(), VanillaTextures.Buttons.Lock.Open.NORMAL.v(),
                                VanillaTextures.Buttons.Lock.Open.NORMAL.width(), VanillaTextures.Buttons.Lock.Open.NORMAL.height(),
                                VanillaTextures.Buttons.Lock.Open.NORMAL.textureWidth(), VanillaTextures.Buttons.Lock.Open.NORMAL.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Buttons.Lock.Open.HIGHLIGHTED.id(),
                                128, 81,
                                VanillaTextures.Buttons.Lock.Open.HIGHLIGHTED.u(), VanillaTextures.Buttons.Lock.Open.HIGHLIGHTED.v(),
                                VanillaTextures.Buttons.Lock.Open.HIGHLIGHTED.width(), VanillaTextures.Buttons.Lock.Open.HIGHLIGHTED.height(),
                                VanillaTextures.Buttons.Lock.Open.HIGHLIGHTED.textureWidth(), VanillaTextures.Buttons.Lock.Open.HIGHLIGHTED.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Buttons.Lock.Open.DISABLED.id(),
                                150, 81,
                                VanillaTextures.Buttons.Lock.Open.DISABLED.u(), VanillaTextures.Buttons.Lock.Open.DISABLED.v(),
                                VanillaTextures.Buttons.Lock.Open.DISABLED.width(), VanillaTextures.Buttons.Lock.Open.DISABLED.height(),
                                VanillaTextures.Buttons.Lock.Open.DISABLED.textureWidth(), VanillaTextures.Buttons.Lock.Open.DISABLED.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Buttons.Lock.Close.NORMAL.id(),
                                40, 81,
                                VanillaTextures.Buttons.Lock.Close.NORMAL.u(), VanillaTextures.Buttons.Lock.Close.NORMAL.v(),
                                VanillaTextures.Buttons.Lock.Close.NORMAL.width(), VanillaTextures.Buttons.Lock.Close.NORMAL.height(),
                                VanillaTextures.Buttons.Lock.Close.NORMAL.textureWidth(), VanillaTextures.Buttons.Lock.Close.NORMAL.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Buttons.Lock.Close.HIGHLIGHTED.id(),
                                62, 81,
                                VanillaTextures.Buttons.Lock.Close.HIGHLIGHTED.u(), VanillaTextures.Buttons.Lock.Close.HIGHLIGHTED.v(),
                                VanillaTextures.Buttons.Lock.Close.HIGHLIGHTED.width(), VanillaTextures.Buttons.Lock.Close.HIGHLIGHTED.height(),
                                VanillaTextures.Buttons.Lock.Close.HIGHLIGHTED.textureWidth(), VanillaTextures.Buttons.Lock.Close.HIGHLIGHTED.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Buttons.Lock.Open.DISABLED.id(),
                                84, 81,
                                VanillaTextures.Buttons.Lock.Close.DISABLED.u(), VanillaTextures.Buttons.Lock.Close.DISABLED.v(),
                                VanillaTextures.Buttons.Lock.Close.DISABLED.width(), VanillaTextures.Buttons.Lock.Close.DISABLED.height(),
                                VanillaTextures.Buttons.Lock.Close.DISABLED.textureWidth(), VanillaTextures.Buttons.Lock.Close.DISABLED.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Buttons.Move.Up.NORMAL.id(),
                                55, 50,
                                VanillaTextures.Buttons.Move.Up.NORMAL.u(), VanillaTextures.Buttons.Move.Up.NORMAL.v(),
                                VanillaTextures.Buttons.Move.Up.NORMAL.width(), VanillaTextures.Buttons.Move.Up.NORMAL.height(),
                                VanillaTextures.Buttons.Move.Up.NORMAL.textureWidth(), VanillaTextures.Buttons.Move.Up.NORMAL.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Buttons.Move.Up.HIGHLIGHTED.id(),
                                67, 50,
                                VanillaTextures.Buttons.Move.Up.HIGHLIGHTED.u(), VanillaTextures.Buttons.Move.Up.HIGHLIGHTED.v(),
                                VanillaTextures.Buttons.Move.Up.HIGHLIGHTED.width(), VanillaTextures.Buttons.Move.Up.HIGHLIGHTED.height(),
                                VanillaTextures.Buttons.Move.Up.HIGHLIGHTED.textureWidth(), VanillaTextures.Buttons.Move.Up.HIGHLIGHTED.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Buttons.Move.Down.NORMAL.id(),
                                79, 50,
                                VanillaTextures.Buttons.Move.Down.NORMAL.u(), VanillaTextures.Buttons.Move.Down.NORMAL.v(),
                                VanillaTextures.Buttons.Move.Down.NORMAL.width(), VanillaTextures.Buttons.Move.Down.NORMAL.height(),
                                VanillaTextures.Buttons.Move.Down.NORMAL.textureWidth(), VanillaTextures.Buttons.Move.Down.NORMAL.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Buttons.Move.Down.HIGHLIGHTED.id(),
                                91, 50,
                                VanillaTextures.Buttons.Move.Down.HIGHLIGHTED.u(), VanillaTextures.Buttons.Move.Down.HIGHLIGHTED.v(),
                                VanillaTextures.Buttons.Move.Down.HIGHLIGHTED.width(), VanillaTextures.Buttons.Move.Down.HIGHLIGHTED.height(),
                                VanillaTextures.Buttons.Move.Down.HIGHLIGHTED.textureWidth(), VanillaTextures.Buttons.Move.Down.HIGHLIGHTED.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Buttons.Page.Left.NORMAL.id(),
                                93, 60,
                                VanillaTextures.Buttons.Page.Left.NORMAL.u(), VanillaTextures.Buttons.Page.Left.NORMAL.v(),
                                VanillaTextures.Buttons.Page.Left.NORMAL.width(), VanillaTextures.Buttons.Page.Left.NORMAL.height(),
                                VanillaTextures.Buttons.Page.Left.NORMAL.textureWidth(), VanillaTextures.Buttons.Page.Left.NORMAL.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Buttons.Page.Right.NORMAL.id(),
                                80, 60,
                                VanillaTextures.Buttons.Page.Right.NORMAL.u(), VanillaTextures.Buttons.Page.Right.NORMAL.v(),
                                VanillaTextures.Buttons.Page.Right.NORMAL.width(), VanillaTextures.Buttons.Page.Right.NORMAL.height(),
                                VanillaTextures.Buttons.Page.Right.NORMAL.textureWidth(), VanillaTextures.Buttons.Page.Right.NORMAL.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Buttons.Page.Left.HIGHLIGHTED.id(),
                                67, 60,
                                VanillaTextures.Buttons.Page.Left.HIGHLIGHTED.u(), VanillaTextures.Buttons.Page.Left.HIGHLIGHTED.v(),
                                VanillaTextures.Buttons.Page.Left.HIGHLIGHTED.width(), VanillaTextures.Buttons.Page.Left.HIGHLIGHTED.height(),
                                VanillaTextures.Buttons.Page.Left.HIGHLIGHTED.textureWidth(), VanillaTextures.Buttons.Page.Left.HIGHLIGHTED.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Buttons.Page.Right.NORMAL.id(),
                                54, 60,
                                VanillaTextures.Buttons.Page.Right.HIGHLIGHTED.u(), VanillaTextures.Buttons.Page.Right.HIGHLIGHTED.v(),
                                VanillaTextures.Buttons.Page.Right.HIGHLIGHTED.width(), VanillaTextures.Buttons.Page.Right.HIGHLIGHTED.height(),
                                VanillaTextures.Buttons.Page.Right.HIGHLIGHTED.textureWidth(), VanillaTextures.Buttons.Page.Right.HIGHLIGHTED.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Buttons.Page.Forward.NORMAL.id(),
                                85, 120,
                                VanillaTextures.Buttons.Page.Forward.NORMAL.u(), VanillaTextures.Buttons.Page.Forward.NORMAL.v(),
                                VanillaTextures.Buttons.Page.Forward.NORMAL.width(), VanillaTextures.Buttons.Page.Forward.NORMAL.height(),
                                VanillaTextures.Buttons.Page.Forward.NORMAL.textureWidth(), VanillaTextures.Buttons.Page.Forward.NORMAL.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Buttons.Page.Forward.HIGHLIGHTED.id(),
                                105, 120,
                                VanillaTextures.Buttons.Page.Forward.HIGHLIGHTED.u(), VanillaTextures.Buttons.Page.Forward.HIGHLIGHTED.v(),
                                VanillaTextures.Buttons.Page.Forward.HIGHLIGHTED.width(), VanillaTextures.Buttons.Page.Forward.HIGHLIGHTED.height(),
                                VanillaTextures.Buttons.Page.Forward.HIGHLIGHTED.textureWidth(), VanillaTextures.Buttons.Page.Forward.HIGHLIGHTED.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Buttons.Page.Backward.NORMAL.id(),
                                125, 120,
                                VanillaTextures.Buttons.Page.Backward.NORMAL.u(), VanillaTextures.Buttons.Page.Backward.NORMAL.v(),
                                VanillaTextures.Buttons.Page.Backward.NORMAL.width(), VanillaTextures.Buttons.Page.Backward.NORMAL.height(),
                                VanillaTextures.Buttons.Page.Backward.NORMAL.textureWidth(), VanillaTextures.Buttons.Page.Backward.NORMAL.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Buttons.Page.Backward.HIGHLIGHTED.id(),
                                145, 120,
                                VanillaTextures.Buttons.Page.Backward.HIGHLIGHTED.u(), VanillaTextures.Buttons.Page.Backward.HIGHLIGHTED.v(),
                                VanillaTextures.Buttons.Page.Backward.HIGHLIGHTED.width(), VanillaTextures.Buttons.Page.Backward.HIGHLIGHTED.height(),
                                VanillaTextures.Buttons.Page.Backward.HIGHLIGHTED.textureWidth(), VanillaTextures.Buttons.Page.Backward.HIGHLIGHTED.textureHeight());
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
}