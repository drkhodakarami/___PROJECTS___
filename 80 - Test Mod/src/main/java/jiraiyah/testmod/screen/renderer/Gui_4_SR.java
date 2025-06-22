package jiraiyah.testmod.screen.renderer;

import jiraiyah.jigui.client.constants.*;
import jiraiyah.jigui.client.utils.ScreenHelper;
import jiraiyah.testmod.screen.handler.Gui_4_SH;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;

public class Gui_4_SR extends HandledScreen<Gui_4_SH>
{
    public Gui_4_SR(Gui_4_SH handler, PlayerInventory inventory, Text title)
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

        //region SLOT ICON
        ScreenHelper.drawTexture(context, SlotIconTextures.Icon.BACK.id(),
                                5, 5,
                                SlotIconTextures.Icon.BACK.u(), SlotIconTextures.Icon.BACK.v(),
                                SlotIconTextures.Icon.BACK.width(), SlotIconTextures.Icon.BACK.height(),
                                SlotIconTextures.Icon.BACK.textureWidth(), SlotIconTextures.Icon.BACK.textureHeight());

        ScreenHelper.drawTexture(context, SlotIconTextures.Icon.BELT.id(),
                                5, 16,
                                SlotIconTextures.Icon.BELT.u(), SlotIconTextures.Icon.BELT.v(),
                                SlotIconTextures.Icon.BELT.width(), SlotIconTextures.Icon.BELT.height(),
                                SlotIconTextures.Icon.BELT.textureWidth(), SlotIconTextures.Icon.BELT.textureHeight());

        ScreenHelper.drawTexture(context, SlotIconTextures.Icon.BODY.id(),
                                5, 28,
                                SlotIconTextures.Icon.BODY.u(), SlotIconTextures.Icon.BODY.v(),
                                SlotIconTextures.Icon.BODY.width(), SlotIconTextures.Icon.BODY.height(),
                                SlotIconTextures.Icon.BODY.textureWidth(), SlotIconTextures.Icon.BODY.textureHeight());

        ScreenHelper.drawTexture(context, SlotIconTextures.Icon.BRACELET.id(),
                                5, 42,
                                SlotIconTextures.Icon.BRACELET.u(), SlotIconTextures.Icon.BRACELET.v(),
                                SlotIconTextures.Icon.BRACELET.width(), SlotIconTextures.Icon.BRACELET.height(),
                                SlotIconTextures.Icon.BRACELET.textureWidth(), SlotIconTextures.Icon.BRACELET.textureHeight());

        ScreenHelper.drawTexture(context, SlotIconTextures.Icon.BUCKET.id(),
                                5, 57,
                                SlotIconTextures.Icon.BUCKET.u(), SlotIconTextures.Icon.BUCKET.v(),
                                SlotIconTextures.Icon.BUCKET.width(), SlotIconTextures.Icon.BUCKET.height(),
                                SlotIconTextures.Icon.BUCKET.textureWidth(), SlotIconTextures.Icon.BUCKET.textureHeight());

        ScreenHelper.drawTexture(context, SlotIconTextures.Icon.CHARM.id(),
                                5, 72,
                                SlotIconTextures.Icon.CHARM.u(), SlotIconTextures.Icon.CHARM.v(),
                                SlotIconTextures.Icon.CHARM.width(), SlotIconTextures.Icon.CHARM.height(),
                                SlotIconTextures.Icon.CHARM.textureWidth(), SlotIconTextures.Icon.CHARM.textureHeight());

        ScreenHelper.drawTexture(context, SlotIconTextures.Icon.COSMETIC.id(),
                                5, 84,
                                SlotIconTextures.Icon.COSMETIC.u(), SlotIconTextures.Icon.COSMETIC.v(),
                                SlotIconTextures.Icon.COSMETIC.width(), SlotIconTextures.Icon.COSMETIC.height(),
                                SlotIconTextures.Icon.COSMETIC.textureWidth(), SlotIconTextures.Icon.COSMETIC.textureHeight());

        ScreenHelper.drawTexture(context, SlotIconTextures.Icon.CURIO.id(),
                                5, 97,
                                SlotIconTextures.Icon.CURIO.u(), SlotIconTextures.Icon.CURIO.v(),
                                SlotIconTextures.Icon.CURIO.width(), SlotIconTextures.Icon.CURIO.height(),
                                SlotIconTextures.Icon.CURIO.textureWidth(), SlotIconTextures.Icon.CURIO.textureHeight());

        ScreenHelper.drawTexture(context, SlotIconTextures.Icon.HANDS.id(),
                                5, 112,
                                SlotIconTextures.Icon.HANDS.u(), SlotIconTextures.Icon.HANDS.v(),
                                SlotIconTextures.Icon.HANDS.width(), SlotIconTextures.Icon.HANDS.height(),
                                SlotIconTextures.Icon.HANDS.textureWidth(), SlotIconTextures.Icon.HANDS.textureHeight());

        ScreenHelper.drawTexture(context, SlotIconTextures.Icon.HEAD.id(),
                                22, 5,
                                SlotIconTextures.Icon.HEAD.u(), SlotIconTextures.Icon.HEAD.v(),
                                SlotIconTextures.Icon.HEAD.width(), SlotIconTextures.Icon.HEAD.height(),
                                SlotIconTextures.Icon.HEAD.textureWidth(), SlotIconTextures.Icon.HEAD.textureHeight());

        ScreenHelper.drawTexture(context, SlotIconTextures.Icon.NECKLACE.id(),
                                22, 18,
                                SlotIconTextures.Icon.NECKLACE.u(), SlotIconTextures.Icon.NECKLACE.v(),
                                SlotIconTextures.Icon.NECKLACE.width(), SlotIconTextures.Icon.NECKLACE.height(),
                                SlotIconTextures.Icon.NECKLACE.textureWidth(), SlotIconTextures.Icon.NECKLACE.textureHeight());

        ScreenHelper.drawTexture(context, SlotIconTextures.Icon.RING.id(),
                                22, 30,
                                SlotIconTextures.Icon.RING.u(), SlotIconTextures.Icon.RING.v(),
                                SlotIconTextures.Icon.RING.width(), SlotIconTextures.Icon.RING.height(),
                                SlotIconTextures.Icon.RING.textureWidth(), SlotIconTextures.Icon.RING.textureHeight());

        ScreenHelper.drawTexture(context, SlotIconTextures.Icon.TRASH_CAN.id(),
                                22, 44,
                                SlotIconTextures.Icon.BRACELET.u(), SlotIconTextures.Icon.TRASH_CAN.v(),
                                SlotIconTextures.Icon.TRASH_CAN.width(), SlotIconTextures.Icon.TRASH_CAN.height(),
                                SlotIconTextures.Icon.TRASH_CAN.textureWidth(), SlotIconTextures.Icon.TRASH_CAN.textureHeight());

        ScreenHelper.drawTexture(context, SlotIconTextures.Icon.BUTTLE.id(),
                                22, 58,
                                SlotIconTextures.Icon.BUTTLE.u(), SlotIconTextures.Icon.BUTTLE.v(),
                                SlotIconTextures.Icon.BUTTLE.width(), SlotIconTextures.Icon.BUTTLE.height(),
                                SlotIconTextures.Icon.BUTTLE.textureWidth(), SlotIconTextures.Icon.BUTTLE.textureHeight());

        ScreenHelper.drawTexture(context, SlotIconTextures.Icon.DUST.id(),
                                22, 72,
                                SlotIconTextures.Icon.DUST.u(), SlotIconTextures.Icon.DUST.v(),
                                SlotIconTextures.Icon.DUST.width(), SlotIconTextures.Icon.DUST.height(),
                                SlotIconTextures.Icon.DUST.textureWidth(), SlotIconTextures.Icon.DUST.textureHeight());

        ScreenHelper.drawTexture(context, SlotIconTextures.Icon.ENERGY.id(),
                                22, 86,
                                SlotIconTextures.Icon.ENERGY.u(), SlotIconTextures.Icon.ENERGY.v(),
                                SlotIconTextures.Icon.ENERGY.width(), SlotIconTextures.Icon.ENERGY.height(),
                                SlotIconTextures.Icon.ENERGY.textureWidth(), SlotIconTextures.Icon.ENERGY.textureHeight());

        ScreenHelper.drawTexture(context, SlotIconTextures.Icon.FLUID.id(),
                                36, 86,
                                SlotIconTextures.Icon.FLUID.u(), SlotIconTextures.Icon.FLUID.v(),
                                SlotIconTextures.Icon.FLUID.width(), SlotIconTextures.Icon.FLUID.height(),
                                SlotIconTextures.Icon.FLUID.textureWidth(), SlotIconTextures.Icon.FLUID.textureHeight());

        ScreenHelper.drawTexture(context, SlotIconTextures.Icon.GAS.id(),
                                50, 86,
                                SlotIconTextures.Icon.GAS.u(), SlotIconTextures.Icon.GAS.v(),
                                SlotIconTextures.Icon.GAS.width(), SlotIconTextures.Icon.GAS.height(),
                                SlotIconTextures.Icon.GAS.textureWidth(), SlotIconTextures.Icon.GAS.textureHeight());

        ScreenHelper.drawTexture(context, SlotIconTextures.Icon.HEAT.id(),
                                64, 86,
                                SlotIconTextures.Icon.HEAT.u(), SlotIconTextures.Icon.HEAT.v(),
                                SlotIconTextures.Icon.HEAT.width(), SlotIconTextures.Icon.HEAT.height(),
                                SlotIconTextures.Icon.HEAT.textureWidth(), SlotIconTextures.Icon.HEAT.textureHeight());

        ScreenHelper.drawTexture(context, SlotIconTextures.Icon.ITEM.id(),
                                22, 100,
                                SlotIconTextures.Icon.ITEM.u(), SlotIconTextures.Icon.ITEM.v(),
                                SlotIconTextures.Icon.ITEM.width(), SlotIconTextures.Icon.ITEM.height(),
                                SlotIconTextures.Icon.ITEM.textureWidth(), SlotIconTextures.Icon.ITEM.textureHeight());

        ScreenHelper.drawTexture(context, SlotIconTextures.Icon.POWDER.id(),
                                36, 100,
                                SlotIconTextures.Icon.POWDER.u(), SlotIconTextures.Icon.POWDER.v(),
                                SlotIconTextures.Icon.POWDER.width(), SlotIconTextures.Icon.POWDER.height(),
                                SlotIconTextures.Icon.POWDER.textureWidth(), SlotIconTextures.Icon.POWDER.textureHeight());

        ScreenHelper.drawTexture(context, SlotIconTextures.Icon.STAT.id(),
                                50, 100,
                                SlotIconTextures.Icon.STAT.u(), SlotIconTextures.Icon.STAT.v(),
                                SlotIconTextures.Icon.STAT.width(), SlotIconTextures.Icon.STAT.height(),
                                SlotIconTextures.Icon.STAT.textureWidth(), SlotIconTextures.Icon.STAT.textureHeight());

        ScreenHelper.drawTexture(context, SlotIconTextures.Icon.UPGRADE.id(),
                                64, 100,
                                SlotIconTextures.Icon.UPGRADE.u(), SlotIconTextures.Icon.UPGRADE.v(),
                                SlotIconTextures.Icon.UPGRADE.width(), SlotIconTextures.Icon.UPGRADE.height(),
                                SlotIconTextures.Icon.UPGRADE.textureWidth(), SlotIconTextures.Icon.UPGRADE.textureHeight());
        //endregion

        ScreenHelper.drawTexture(context, SlotIconTextures.Slot.EMPTY_NORMAL.id(),
                                40, 5,
                                SlotIconTextures.Slot.EMPTY_NORMAL.u(), SlotIconTextures.Slot.EMPTY_NORMAL.v(),
                                SlotIconTextures.Slot.EMPTY_NORMAL.width(), SlotIconTextures.Slot.EMPTY_NORMAL.height(),
                                SlotIconTextures.Slot.EMPTY_NORMAL.textureWidth(), SlotIconTextures.Slot.EMPTY_NORMAL.textureHeight());

        ScreenHelper.drawTexture(context, SlotIconTextures.Slot.EMPTY_HIGHLIGHT_BACK.id(),
                                36, 22,
                                SlotIconTextures.Slot.EMPTY_HIGHLIGHT_BACK.u(), SlotIconTextures.Slot.EMPTY_HIGHLIGHT_BACK.v(),
                                SlotIconTextures.Slot.EMPTY_HIGHLIGHT_BACK.width(), SlotIconTextures.Slot.EMPTY_HIGHLIGHT_BACK.height(),
                                SlotIconTextures.Slot.EMPTY_HIGHLIGHT_BACK.textureWidth(), SlotIconTextures.Slot.EMPTY_HIGHLIGHT_BACK.textureHeight());

        ScreenHelper.drawTexture(context, SlotIconTextures.Slot.EMPTY_HIGHLIGHT_FRONT.id(),
                                57, 22,
                                SlotIconTextures.Slot.EMPTY_HIGHLIGHT_FRONT.u(), SlotIconTextures.Slot.EMPTY_HIGHLIGHT_FRONT.v(),
                                SlotIconTextures.Slot.EMPTY_HIGHLIGHT_FRONT.width(), SlotIconTextures.Slot.EMPTY_HIGHLIGHT_FRONT.height(),
                                SlotIconTextures.Slot.EMPTY_HIGHLIGHT_FRONT.textureWidth(), SlotIconTextures.Slot.EMPTY_HIGHLIGHT_FRONT.textureHeight());

        ScreenHelper.drawTexture(context, SlotIconTextures.Slot.EMPTY_BIG.id(),
                                40, 53,
                                SlotIconTextures.Slot.EMPTY_BIG.u(), SlotIconTextures.Slot.EMPTY_BIG.v(),
                                SlotIconTextures.Slot.EMPTY_BIG.width(), SlotIconTextures.Slot.EMPTY_BIG.height(),
                                SlotIconTextures.Slot.EMPTY_BIG.textureWidth(), SlotIconTextures.Slot.EMPTY_BIG.textureHeight());

        ScreenHelper.drawTexture(context, SlotIconTextures.SlotType.AIR.id(),
                                60, 5,
                                SlotIconTextures.SlotType.AIR.u(), SlotIconTextures.SlotType.AIR.v(),
                                SlotIconTextures.SlotType.AIR.width(), SlotIconTextures.SlotType.AIR.height(),
                                SlotIconTextures.SlotType.AIR.textureWidth(), SlotIconTextures.SlotType.AIR.textureHeight());

        ScreenHelper.drawTexture(context, SlotIconTextures.SlotType.BUCKET.id(),
                                80, 5,
                                SlotIconTextures.SlotType.BUCKET.u(), SlotIconTextures.SlotType.BUCKET.v(),
                                SlotIconTextures.SlotType.BUCKET.width(), SlotIconTextures.SlotType.BUCKET.height(),
                                SlotIconTextures.SlotType.BUCKET.textureWidth(), SlotIconTextures.SlotType.BUCKET.textureHeight());

        ScreenHelper.drawTexture(context, SlotIconTextures.SlotType.CROSS.id(),
                                100, 5,
                                SlotIconTextures.SlotType.CROSS.u(), SlotIconTextures.SlotType.CROSS.v(),
                                SlotIconTextures.SlotType.CROSS.width(), SlotIconTextures.SlotType.CROSS.height(),
                                SlotIconTextures.SlotType.CROSS.textureWidth(), SlotIconTextures.SlotType.CROSS.textureHeight());

        ScreenHelper.drawTexture(context, SlotIconTextures.SlotType.DISABLED.id(),
                                120, 5,
                                SlotIconTextures.SlotType.DISABLED.u(), SlotIconTextures.SlotType.DISABLED.v(),
                                SlotIconTextures.SlotType.DISABLED.width(), SlotIconTextures.SlotType.DISABLED.height(),
                                SlotIconTextures.SlotType.DISABLED.textureWidth(), SlotIconTextures.SlotType.DISABLED.textureHeight());

        ScreenHelper.drawTexture(context, SlotIconTextures.SlotType.ENERGY_UPGRADE.id(),
                                140, 5,
                                SlotIconTextures.SlotType.ENERGY_UPGRADE.u(), SlotIconTextures.SlotType.ENERGY_UPGRADE.v(),
                                SlotIconTextures.SlotType.ENERGY_UPGRADE.width(), SlotIconTextures.SlotType.ENERGY_UPGRADE.height(),
                                SlotIconTextures.SlotType.ENERGY_UPGRADE.textureWidth(), SlotIconTextures.SlotType.ENERGY_UPGRADE.textureHeight());

        ScreenHelper.drawTexture(context, SlotIconTextures.SlotType.FLUID_UPGRADE.id(),
                                100, 25,
                                SlotIconTextures.SlotType.FLUID_UPGRADE.u(), SlotIconTextures.SlotType.FLUID_UPGRADE.v(),
                                SlotIconTextures.SlotType.FLUID_UPGRADE.width(), SlotIconTextures.SlotType.FLUID_UPGRADE.height(),
                                SlotIconTextures.SlotType.FLUID_UPGRADE.textureWidth(), SlotIconTextures.SlotType.FLUID_UPGRADE.textureHeight());

        ScreenHelper.drawTexture(context, SlotIconTextures.SlotType.SPEED_UPGRADE.id(),
                                120, 25,
                                SlotIconTextures.SlotType.SPEED_UPGRADE.u(), SlotIconTextures.SlotType.SPEED_UPGRADE.v(),
                                SlotIconTextures.SlotType.SPEED_UPGRADE.width(), SlotIconTextures.SlotType.SPEED_UPGRADE.height(),
                                SlotIconTextures.SlotType.SPEED_UPGRADE.textureWidth(), SlotIconTextures.SlotType.SPEED_UPGRADE.textureHeight());

        ScreenHelper.drawTexture(context, SlotIconTextures.SlotType.TOXIC.id(),
                                140, 25,
                                SlotIconTextures.SlotType.TOXIC.u(), SlotIconTextures.SlotType.TOXIC.v(),
                                SlotIconTextures.SlotType.TOXIC.width(), SlotIconTextures.SlotType.TOXIC.height(),
                                SlotIconTextures.SlotType.TOXIC.textureWidth(), SlotIconTextures.SlotType.TOXIC.textureHeight());

        ScreenHelper.drawTexture(context, SlotIconTextures.SlotType.TRASH.id(),
                                80, 45,
                                SlotIconTextures.SlotType.TRASH.u(), SlotIconTextures.SlotType.TRASH.v(),
                                SlotIconTextures.SlotType.TRASH.width(), SlotIconTextures.SlotType.TRASH.height(),
                                SlotIconTextures.SlotType.TRASH.textureWidth(), SlotIconTextures.SlotType.TRASH.textureHeight());

        ScreenHelper.drawTexture(context, SlotIconTextures.SlotType.TRASH_RED.id(),
                                100, 45,
                                SlotIconTextures.SlotType.TRASH_RED.u(), SlotIconTextures.SlotType.TRASH_RED.v(),
                                SlotIconTextures.SlotType.TRASH_RED.width(), SlotIconTextures.SlotType.TRASH_RED.height(),
                                SlotIconTextures.SlotType.TRASH_RED.textureWidth(), SlotIconTextures.SlotType.TRASH_RED.textureHeight());


        ScreenHelper.drawTexture(context, ToggleButtonTextures.Normal.Off.NORMAL.id(),
                                80, 65,
                                ToggleButtonTextures.Normal.Off.NORMAL.u(), ToggleButtonTextures.Normal.Off.NORMAL.v(),
                                ToggleButtonTextures.Normal.Off.NORMAL.width(), ToggleButtonTextures.Normal.Off.NORMAL.height(),
                                ToggleButtonTextures.Normal.Off.NORMAL.textureWidth(), ToggleButtonTextures.Normal.Off.NORMAL.textureHeight());

        ScreenHelper.drawTexture(context, ToggleButtonTextures.Normal.On.NORMAL.id(),
                                114, 65,
                                ToggleButtonTextures.Normal.On.NORMAL.u(), ToggleButtonTextures.Normal.On.NORMAL.v(),
                                ToggleButtonTextures.Normal.On.NORMAL.width(), ToggleButtonTextures.Normal.On.NORMAL.height(),
                                ToggleButtonTextures.Normal.On.NORMAL.textureWidth(), ToggleButtonTextures.Normal.On.NORMAL.textureHeight());

        ScreenHelper.drawTexture(context, ToggleButtonTextures.Normal.Off.HOVERED.id(),
                                80, 85,
                                ToggleButtonTextures.Normal.Off.HOVERED.u(), ToggleButtonTextures.Normal.Off.HOVERED.v(),
                                ToggleButtonTextures.Normal.Off.HOVERED.width(), ToggleButtonTextures.Normal.Off.HOVERED.height(),
                                ToggleButtonTextures.Normal.Off.HOVERED.textureWidth(), ToggleButtonTextures.Normal.Off.HOVERED.textureHeight());

        ScreenHelper.drawTexture(context, ToggleButtonTextures.Normal.On.HOVERED.id(),
                                114, 85,
                                ToggleButtonTextures.Normal.On.HOVERED.u(), ToggleButtonTextures.Normal.On.HOVERED.v(),
                                ToggleButtonTextures.Normal.On.HOVERED.width(), ToggleButtonTextures.Normal.On.HOVERED.height(),
                                ToggleButtonTextures.Normal.On.HOVERED.textureWidth(), ToggleButtonTextures.Normal.On.HOVERED.textureHeight());

        ScreenHelper.drawTexture(context, ToggleButtonTextures.Colored.Off.NORMAL.id(),
                                30, 117,
                                ToggleButtonTextures.Colored.Off.NORMAL.u(), ToggleButtonTextures.Colored.Off.NORMAL.v(),
                                ToggleButtonTextures.Colored.Off.NORMAL.width(), ToggleButtonTextures.Colored.Off.NORMAL.height(),
                                ToggleButtonTextures.Colored.Off.NORMAL.textureWidth(), ToggleButtonTextures.Colored.Off.NORMAL.textureHeight());

        ScreenHelper.drawTexture(context, ToggleButtonTextures.Colored.On.NORMAL.id(),
                                64, 117,
                                ToggleButtonTextures.Colored.On.NORMAL.u(), ToggleButtonTextures.Colored.On.NORMAL.v(),
                                ToggleButtonTextures.Colored.On.NORMAL.width(), ToggleButtonTextures.Colored.On.NORMAL.height(),
                                ToggleButtonTextures.Colored.On.NORMAL.textureWidth(), ToggleButtonTextures.Colored.On.NORMAL.textureHeight());

        ScreenHelper.drawTexture(context, ToggleButtonTextures.Colored.Off.HOVERED.id(),
                                96, 117,
                                ToggleButtonTextures.Colored.Off.HOVERED.u(), ToggleButtonTextures.Colored.Off.HOVERED.v(),
                                ToggleButtonTextures.Colored.Off.HOVERED.width(), ToggleButtonTextures.Colored.Off.HOVERED.height(),
                                ToggleButtonTextures.Colored.Off.HOVERED.textureWidth(), ToggleButtonTextures.Colored.Off.HOVERED.textureHeight());

        ScreenHelper.drawTexture(context, ToggleButtonTextures.Colored.On.HOVERED.id(),
                                130, 117,
                                ToggleButtonTextures.Colored.On.HOVERED.u(), ToggleButtonTextures.Colored.On.HOVERED.v(),
                                ToggleButtonTextures.Colored.On.HOVERED.width(), ToggleButtonTextures.Colored.On.HOVERED.height(),
                                ToggleButtonTextures.Colored.On.HOVERED.textureWidth(), ToggleButtonTextures.Colored.On.HOVERED.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Container.Dot.RED.id(),
                                70, 45,
                                VanillaTextures.Container.Dot.RED.u(), VanillaTextures.Container.Dot.RED.v(),
                                VanillaTextures.Container.Dot.RED.width(), VanillaTextures.Container.Dot.RED.height(),
                                VanillaTextures.Container.Dot.RED.textureWidth(), VanillaTextures.Container.Dot.RED.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Container.Dot.BLUE.id(),
                                70, 57,
                                VanillaTextures.Container.Dot.BLUE.u(), VanillaTextures.Container.Dot.BLUE.v(),
                                VanillaTextures.Container.Dot.BLUE.width(), VanillaTextures.Container.Dot.BLUE.height(),
                                VanillaTextures.Container.Dot.BLUE.textureWidth(), VanillaTextures.Container.Dot.BLUE.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Container.RedstoneArrow.OFF.id(),
                                80, 103,
                                VanillaTextures.Container.RedstoneArrow.OFF.u(), VanillaTextures.Container.RedstoneArrow.OFF.v(),
                                VanillaTextures.Container.RedstoneArrow.OFF.width(), VanillaTextures.Container.RedstoneArrow.OFF.height(),
                                VanillaTextures.Container.RedstoneArrow.OFF.textureWidth(), VanillaTextures.Container.RedstoneArrow.OFF.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Container.RedstoneArrow.ON.id(),
                                100, 103,
                                VanillaTextures.Container.RedstoneArrow.ON.u(), VanillaTextures.Container.RedstoneArrow.ON.v(),
                                VanillaTextures.Container.RedstoneArrow.ON.width(), VanillaTextures.Container.RedstoneArrow.ON.height(),
                                VanillaTextures.Container.RedstoneArrow.ON.textureWidth(), VanillaTextures.Container.RedstoneArrow.ON.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Container.Scroller.NORMAL.id(),
                                149, 100,
                                VanillaTextures.Container.Scroller.NORMAL.u(), VanillaTextures.Container.Scroller.NORMAL.v(),
                                VanillaTextures.Container.Scroller.NORMAL.width(), VanillaTextures.Container.Scroller.NORMAL.height(),
                                VanillaTextures.Container.Scroller.NORMAL.textureWidth(), VanillaTextures.Container.Scroller.NORMAL.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Container.Scroller.DISABLED.id(),
                                149, 83,
                                VanillaTextures.Container.Scroller.DISABLED.u(), VanillaTextures.Container.Scroller.DISABLED.v(),
                                VanillaTextures.Container.Scroller.DISABLED.width(), VanillaTextures.Container.Scroller.DISABLED.height(),
                                VanillaTextures.Container.Scroller.DISABLED.textureWidth(), VanillaTextures.Container.Scroller.DISABLED.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Container.Xp.Enabled.ONE.id(),
                                159, 5,
                                VanillaTextures.Container.Xp.Enabled.ONE.u(), VanillaTextures.Container.Xp.Enabled.ONE.v(),
                                VanillaTextures.Container.Xp.Enabled.ONE.width(), VanillaTextures.Container.Xp.Enabled.ONE.height(),
                                VanillaTextures.Container.Xp.Enabled.ONE.textureWidth(), VanillaTextures.Container.Xp.Enabled.ONE.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Container.Xp.Enabled.TWO.id(),
                                159, 17,
                                VanillaTextures.Container.Xp.Enabled.TWO.u(), VanillaTextures.Container.Xp.Enabled.TWO.v(),
                                VanillaTextures.Container.Xp.Enabled.TWO.width(), VanillaTextures.Container.Xp.Enabled.TWO.height(),
                                VanillaTextures.Container.Xp.Enabled.TWO.textureWidth(), VanillaTextures.Container.Xp.Enabled.TWO.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Container.Xp.Enabled.THREE.id(),
                                159, 29,
                                VanillaTextures.Container.Xp.Enabled.THREE.u(), VanillaTextures.Container.Xp.Enabled.THREE.v(),
                                VanillaTextures.Container.Xp.Enabled.THREE.width(), VanillaTextures.Container.Xp.Enabled.THREE.height(),
                                VanillaTextures.Container.Xp.Enabled.THREE.textureWidth(), VanillaTextures.Container.Xp.Enabled.THREE.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Container.Xp.Disabled.ONE.id(),
                                160, 41,
                                VanillaTextures.Container.Xp.Disabled.ONE.u(), VanillaTextures.Container.Xp.Disabled.ONE.v(),
                                VanillaTextures.Container.Xp.Disabled.ONE.width(), VanillaTextures.Container.Xp.Disabled.ONE.height(),
                                VanillaTextures.Container.Xp.Disabled.ONE.textureWidth(), VanillaTextures.Container.Xp.Disabled.ONE.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Container.Xp.Disabled.TWO.id(),
                                160, 53,
                                VanillaTextures.Container.Xp.Disabled.TWO.u(), VanillaTextures.Container.Xp.Disabled.TWO.v(),
                                VanillaTextures.Container.Xp.Disabled.TWO.width(), VanillaTextures.Container.Xp.Disabled.TWO.height(),
                                VanillaTextures.Container.Xp.Disabled.TWO.textureWidth(), VanillaTextures.Container.Xp.Disabled.TWO.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Container.Xp.Disabled.THREE.id(),
                                160, 65,
                                VanillaTextures.Container.Xp.Disabled.THREE.u(), VanillaTextures.Container.Xp.Disabled.THREE.v(),
                                VanillaTextures.Container.Xp.Disabled.THREE.width(), VanillaTextures.Container.Xp.Disabled.THREE.height(),
                                VanillaTextures.Container.Xp.Disabled.THREE.textureWidth(), VanillaTextures.Container.Xp.Disabled.THREE.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Container.CANCEL.id(),
                                142, 47,
                                VanillaTextures.Container.CANCEL.u(), VanillaTextures.Container.CANCEL.v(),
                                VanillaTextures.Container.CANCEL.width(), VanillaTextures.Container.CANCEL.height(),
                                VanillaTextures.Container.CANCEL.textureWidth(), VanillaTextures.Container.CANCEL.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Container.CONFIRM.id(),
                                122, 47,
                                VanillaTextures.Container.CONFIRM.u(), VanillaTextures.Container.CONFIRM.v(),
                                VanillaTextures.Container.CONFIRM.width(), VanillaTextures.Container.CONFIRM.height(),
                                VanillaTextures.Container.CONFIRM.textureWidth(), VanillaTextures.Container.CONFIRM.textureHeight());



        ScreenHelper.drawTexture(context, VanillaTextures.Icon.Misc.SCROLL_LEFT.id(),
                                120, 103,
                                VanillaTextures.Icon.Misc.SCROLL_LEFT.u(), VanillaTextures.Icon.Misc.SCROLL_LEFT.v(),
                                VanillaTextures.Icon.Misc.SCROLL_LEFT.width(), VanillaTextures.Icon.Misc.SCROLL_LEFT.height(),
                                VanillaTextures.Icon.Misc.SCROLL_LEFT.textureWidth(), VanillaTextures.Icon.Misc.SCROLL_LEFT.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Icon.Misc.SCROLL_RIGHT.id(),
                                130, 103,
                                VanillaTextures.Icon.Misc.SCROLL_RIGHT.u(), VanillaTextures.Icon.Misc.SCROLL_RIGHT.v(),
                                VanillaTextures.Icon.Misc.SCROLL_RIGHT.width(), VanillaTextures.Icon.Misc.SCROLL_RIGHT.height(),
                                VanillaTextures.Icon.Misc.SCROLL_RIGHT.textureWidth(), VanillaTextures.Icon.Misc.SCROLL_RIGHT.textureHeight());
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float deltaTicks)
    {
        super.render(context, mouseX, mouseY, deltaTicks);

        //ScreenHelper.drawTexture(context, TEXTURE, this.x + 83, this.y + 34, 184, 0, 16, 51); // DRAWING FLUID MARKERS
    }
}