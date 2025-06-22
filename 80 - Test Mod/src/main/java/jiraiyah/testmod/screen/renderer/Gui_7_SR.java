package jiraiyah.testmod.screen.renderer;

import jiraiyah.jigui.client.constants.ContainerBaseTextures;
import jiraiyah.jigui.client.constants.VanillaTextures;
import jiraiyah.jigui.client.utils.ScreenHelper;
import jiraiyah.testmod.screen.handler.Gui_7_SH;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;

public class Gui_7_SR extends HandledScreen<Gui_7_SH>
{
    public Gui_7_SR(Gui_7_SH handler, PlayerInventory inventory, Text title)
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

        //region EFFECTS
        ScreenHelper.drawTexture(context, VanillaTextures.Effect.Icon.RAID_OMEN.id(),
                                5, 5,
                                VanillaTextures.Effect.Icon.RAID_OMEN.u(), VanillaTextures.Effect.Icon.RAID_OMEN.v(),
                                VanillaTextures.Effect.Icon.RAID_OMEN.width(), VanillaTextures.Effect.Icon.RAID_OMEN.height(),
                                VanillaTextures.Effect.Icon.RAID_OMEN.textureWidth(), VanillaTextures.Effect.Icon.RAID_OMEN.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Effect.Icon.REGENERATION.id(),
                                25, 5,
                                VanillaTextures.Effect.Icon.REGENERATION.u(), VanillaTextures.Effect.Icon.REGENERATION.v(),
                                VanillaTextures.Effect.Icon.REGENERATION.width(), VanillaTextures.Effect.Icon.REGENERATION.height(),
                                VanillaTextures.Effect.Icon.REGENERATION.textureWidth(), VanillaTextures.Effect.Icon.REGENERATION.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Effect.Icon.RESISTANCE.id(),
                                45, 5,
                                VanillaTextures.Effect.Icon.RESISTANCE.u(), VanillaTextures.Effect.Icon.RESISTANCE.v(),
                                VanillaTextures.Effect.Icon.RESISTANCE.width(), VanillaTextures.Effect.Icon.RESISTANCE.height(),
                                VanillaTextures.Effect.Icon.RESISTANCE.textureWidth(), VanillaTextures.Effect.Icon.RESISTANCE.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Effect.Icon.SATURATION.id(),
                                65, 5,
                                VanillaTextures.Effect.Icon.SATURATION.u(), VanillaTextures.Effect.Icon.SATURATION.v(),
                                VanillaTextures.Effect.Icon.SATURATION.width(), VanillaTextures.Effect.Icon.SATURATION.height(),
                                VanillaTextures.Effect.Icon.SATURATION.textureWidth(), VanillaTextures.Effect.Icon.SATURATION.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Effect.Icon.SLOW_FALLING.id(),
                                85, 5,
                                VanillaTextures.Effect.Icon.SLOW_FALLING.u(), VanillaTextures.Effect.Icon.SLOW_FALLING.v(),
                                VanillaTextures.Effect.Icon.SLOW_FALLING.width(), VanillaTextures.Effect.Icon.SLOW_FALLING.height(),
                                VanillaTextures.Effect.Icon.SLOW_FALLING.textureWidth(), VanillaTextures.Effect.Icon.SLOW_FALLING.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Effect.Icon.SLOWNESS.id(),
                                105, 5,
                                VanillaTextures.Effect.Icon.SLOWNESS.u(), VanillaTextures.Effect.Icon.SLOWNESS.v(),
                                VanillaTextures.Effect.Icon.SLOWNESS.width(), VanillaTextures.Effect.Icon.SLOWNESS.height(),
                                VanillaTextures.Effect.Icon.SLOWNESS.textureWidth(), VanillaTextures.Effect.Icon.SLOWNESS.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Effect.Icon.SPEED.id(),
                                125, 5,
                                VanillaTextures.Effect.Icon.SPEED.u(), VanillaTextures.Effect.Icon.SPEED.v(),
                                VanillaTextures.Effect.Icon.SPEED.width(), VanillaTextures.Effect.Icon.SPEED.height(),
                                VanillaTextures.Effect.Icon.SPEED.textureWidth(), VanillaTextures.Effect.Icon.SPEED.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Effect.Icon.STRENGTH.id(),
                                145, 5,
                                VanillaTextures.Effect.Icon.STRENGTH.u(), VanillaTextures.Effect.Icon.STRENGTH.v(),
                                VanillaTextures.Effect.Icon.STRENGTH.width(), VanillaTextures.Effect.Icon.STRENGTH.height(),
                                VanillaTextures.Effect.Icon.STRENGTH.textureWidth(), VanillaTextures.Effect.Icon.STRENGTH.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Effect.Icon.TRIAL_OMEN.id(),
                                5, 25,
                                VanillaTextures.Effect.Icon.TRIAL_OMEN.u(), VanillaTextures.Effect.Icon.TRIAL_OMEN.v(),
                                VanillaTextures.Effect.Icon.TRIAL_OMEN.width(), VanillaTextures.Effect.Icon.TRIAL_OMEN.height(),
                                VanillaTextures.Effect.Icon.TRIAL_OMEN.textureWidth(), VanillaTextures.Effect.Icon.TRIAL_OMEN.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Effect.Icon.UNLUCK.id(),
                                25, 25,
                                VanillaTextures.Effect.Icon.UNLUCK.u(), VanillaTextures.Effect.Icon.UNLUCK.v(),
                                VanillaTextures.Effect.Icon.UNLUCK.width(), VanillaTextures.Effect.Icon.UNLUCK.height(),
                                VanillaTextures.Effect.Icon.UNLUCK.textureWidth(), VanillaTextures.Effect.Icon.UNLUCK.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Effect.Icon.WATER_BREATHING.id(),
                                45, 25,
                                VanillaTextures.Effect.Icon.WATER_BREATHING.u(), VanillaTextures.Effect.Icon.WATER_BREATHING.v(),
                                VanillaTextures.Effect.Icon.WATER_BREATHING.width(), VanillaTextures.Effect.Icon.WATER_BREATHING.height(),
                                VanillaTextures.Effect.Icon.WATER_BREATHING.textureWidth(), VanillaTextures.Effect.Icon.WATER_BREATHING.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Effect.Icon.WEAKNESS.id(),
                                65, 25,
                                VanillaTextures.Effect.Icon.WEAKNESS.u(), VanillaTextures.Effect.Icon.WEAKNESS.v(),
                                VanillaTextures.Effect.Icon.WEAKNESS.width(), VanillaTextures.Effect.Icon.WEAKNESS.height(),
                                VanillaTextures.Effect.Icon.WEAKNESS.textureWidth(), VanillaTextures.Effect.Icon.WEAKNESS.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Effect.Icon.WEAVING.id(),
                                85, 25,
                                VanillaTextures.Effect.Icon.WEAVING.u(), VanillaTextures.Effect.Icon.WEAVING.v(),
                                VanillaTextures.Effect.Icon.WEAVING.width(), VanillaTextures.Effect.Icon.WEAVING.height(),
                                VanillaTextures.Effect.Icon.WEAVING.textureWidth(), VanillaTextures.Effect.Icon.WEAVING.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Effect.Icon.WIND_CHARGED.id(),
                                105, 25,
                                VanillaTextures.Effect.Icon.WIND_CHARGED.u(), VanillaTextures.Effect.Icon.WIND_CHARGED.v(),
                                VanillaTextures.Effect.Icon.WIND_CHARGED.width(), VanillaTextures.Effect.Icon.WIND_CHARGED.height(),
                                VanillaTextures.Effect.Icon.WIND_CHARGED.textureWidth(), VanillaTextures.Effect.Icon.WIND_CHARGED.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Effect.Icon.WITHER.id(),
                                125, 25,
                                VanillaTextures.Effect.Icon.WITHER.u(), VanillaTextures.Effect.Icon.WITHER.v(),
                                VanillaTextures.Effect.Icon.WITHER.width(), VanillaTextures.Effect.Icon.WITHER.height(),
                                VanillaTextures.Effect.Icon.WITHER.textureWidth(), VanillaTextures.Effect.Icon.WITHER.textureHeight());
        //endregion

        //region SLOT ICON
        ScreenHelper.drawTexture(context, VanillaTextures.Icon.Slot.AMETHYST_SHART.id(),
                                5, 45,
                                VanillaTextures.Icon.Slot.AMETHYST_SHART.u(), VanillaTextures.Icon.Slot.AMETHYST_SHART.v(),
                                VanillaTextures.Icon.Slot.AMETHYST_SHART.width(), VanillaTextures.Icon.Slot.AMETHYST_SHART.height(),
                                VanillaTextures.Icon.Slot.AMETHYST_SHART.textureWidth(), VanillaTextures.Icon.Slot.AMETHYST_SHART.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Icon.Slot.AXE.id(),
                                25, 45,
                                VanillaTextures.Icon.Slot.AXE.u(), VanillaTextures.Icon.Slot.AXE.v(),
                                VanillaTextures.Icon.Slot.AXE.width(), VanillaTextures.Icon.Slot.AXE.height(),
                                VanillaTextures.Icon.Slot.AXE.textureWidth(), VanillaTextures.Icon.Slot.AXE.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Icon.Slot.BANNER.id(),
                                45, 45,
                                VanillaTextures.Icon.Slot.BANNER.u(), VanillaTextures.Icon.Slot.BANNER.v(),
                                VanillaTextures.Icon.Slot.BANNER.width(), VanillaTextures.Icon.Slot.BANNER.height(),
                                VanillaTextures.Icon.Slot.BANNER.textureWidth(), VanillaTextures.Icon.Slot.BANNER.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Icon.Slot.BANNER_PATTERN.id(),
                                65, 45,
                                VanillaTextures.Icon.Slot.BANNER_PATTERN.u(), VanillaTextures.Icon.Slot.BANNER_PATTERN.v(),
                                VanillaTextures.Icon.Slot.BANNER_PATTERN.width(), VanillaTextures.Icon.Slot.BANNER_PATTERN.height(),
                                VanillaTextures.Icon.Slot.BANNER_PATTERN.textureWidth(), VanillaTextures.Icon.Slot.BANNER_PATTERN.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Icon.Slot.BOOTS.id(),
                                85, 45,
                                VanillaTextures.Icon.Slot.BOOTS.u(), VanillaTextures.Icon.Slot.BOOTS.v(),
                                VanillaTextures.Icon.Slot.BOOTS.width(), VanillaTextures.Icon.Slot.BOOTS.height(),
                                VanillaTextures.Icon.Slot.BOOTS.textureWidth(), VanillaTextures.Icon.Slot.BOOTS.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Icon.Slot.BREWING_FUEL.id(),
                                105, 45,
                                VanillaTextures.Icon.Slot.BREWING_FUEL.u(), VanillaTextures.Icon.Slot.BREWING_FUEL.v(),
                                VanillaTextures.Icon.Slot.BREWING_FUEL.width(), VanillaTextures.Icon.Slot.BREWING_FUEL.height(),
                                VanillaTextures.Icon.Slot.BREWING_FUEL.textureWidth(), VanillaTextures.Icon.Slot.BREWING_FUEL.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Icon.Slot.CHESTPLATE.id(),
                                125, 45,
                                VanillaTextures.Icon.Slot.CHESTPLATE.u(), VanillaTextures.Icon.Slot.CHESTPLATE.v(),
                                VanillaTextures.Icon.Slot.CHESTPLATE.width(), VanillaTextures.Icon.Slot.CHESTPLATE.height(),
                                VanillaTextures.Icon.Slot.CHESTPLATE.textureWidth(), VanillaTextures.Icon.Slot.CHESTPLATE.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Icon.Slot.DIAMOND.id(),
                                145, 45,
                                VanillaTextures.Icon.Slot.DIAMOND.u(), VanillaTextures.Icon.Slot.DIAMOND.v(),
                                VanillaTextures.Icon.Slot.DIAMOND.width(), VanillaTextures.Icon.Slot.DIAMOND.height(),
                                VanillaTextures.Icon.Slot.DIAMOND.textureWidth(), VanillaTextures.Icon.Slot.DIAMOND.textureHeight());



        ScreenHelper.drawTexture(context, VanillaTextures.Icon.Slot.DYE.id(),
                                5, 65,
                                VanillaTextures.Icon.Slot.DYE.u(), VanillaTextures.Icon.Slot.DYE.v(),
                                VanillaTextures.Icon.Slot.DYE.width(), VanillaTextures.Icon.Slot.DYE.height(),
                                VanillaTextures.Icon.Slot.DYE.textureWidth(), VanillaTextures.Icon.Slot.DYE.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Icon.Slot.EMERALD.id(),
                                25, 65,
                                VanillaTextures.Icon.Slot.EMERALD.u(), VanillaTextures.Icon.Slot.EMERALD.v(),
                                VanillaTextures.Icon.Slot.EMERALD.width(), VanillaTextures.Icon.Slot.EMERALD.height(),
                                VanillaTextures.Icon.Slot.EMERALD.textureWidth(), VanillaTextures.Icon.Slot.EMERALD.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Icon.Slot.HELMET.id(),
                                45, 65,
                                VanillaTextures.Icon.Slot.HELMET.u(), VanillaTextures.Icon.Slot.HELMET.v(),
                                VanillaTextures.Icon.Slot.HELMET.width(), VanillaTextures.Icon.Slot.HELMET.height(),
                                VanillaTextures.Icon.Slot.HELMET.textureWidth(), VanillaTextures.Icon.Slot.HELMET.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Icon.Slot.HOE.id(),
                                65, 65,
                                VanillaTextures.Icon.Slot.HOE.u(), VanillaTextures.Icon.Slot.HOE.v(),
                                VanillaTextures.Icon.Slot.HOE.width(), VanillaTextures.Icon.Slot.HOE.height(),
                                VanillaTextures.Icon.Slot.HOE.textureWidth(), VanillaTextures.Icon.Slot.HOE.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Icon.Slot.HORSE_ARMOR.id(),
                                85, 65,
                                VanillaTextures.Icon.Slot.HORSE_ARMOR.u(), VanillaTextures.Icon.Slot.HORSE_ARMOR.v(),
                                VanillaTextures.Icon.Slot.HORSE_ARMOR.width(), VanillaTextures.Icon.Slot.HORSE_ARMOR.height(),
                                VanillaTextures.Icon.Slot.HORSE_ARMOR.textureWidth(), VanillaTextures.Icon.Slot.HORSE_ARMOR.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Icon.Slot.INGOT.id(),
                                105, 65,
                                VanillaTextures.Icon.Slot.INGOT.u(), VanillaTextures.Icon.Slot.INGOT.v(),
                                VanillaTextures.Icon.Slot.INGOT.width(), VanillaTextures.Icon.Slot.INGOT.height(),
                                VanillaTextures.Icon.Slot.INGOT.textureWidth(), VanillaTextures.Icon.Slot.INGOT.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Icon.Slot.LAPIS_LAZULI.id(),
                                125, 65,
                                VanillaTextures.Icon.Slot.LAPIS_LAZULI.u(), VanillaTextures.Icon.Slot.LAPIS_LAZULI.v(),
                                VanillaTextures.Icon.Slot.LAPIS_LAZULI.width(), VanillaTextures.Icon.Slot.LAPIS_LAZULI.height(),
                                VanillaTextures.Icon.Slot.LAPIS_LAZULI.textureWidth(), VanillaTextures.Icon.Slot.LAPIS_LAZULI.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Icon.Slot.LEGGINGS.id(),
                                145, 65,
                                VanillaTextures.Icon.Slot.LEGGINGS.u(), VanillaTextures.Icon.Slot.LEGGINGS.v(),
                                VanillaTextures.Icon.Slot.LEGGINGS.width(), VanillaTextures.Icon.Slot.LEGGINGS.height(),
                                VanillaTextures.Icon.Slot.LEGGINGS.textureWidth(), VanillaTextures.Icon.Slot.LEGGINGS.textureHeight());



        ScreenHelper.drawTexture(context, VanillaTextures.Icon.Slot.LLAMA_ARMOR.id(),
                                5, 85,
                                VanillaTextures.Icon.Slot.LLAMA_ARMOR.u(), VanillaTextures.Icon.Slot.LLAMA_ARMOR.v(),
                                VanillaTextures.Icon.Slot.LLAMA_ARMOR.width(), VanillaTextures.Icon.Slot.LLAMA_ARMOR.height(),
                                VanillaTextures.Icon.Slot.LLAMA_ARMOR.textureWidth(), VanillaTextures.Icon.Slot.LLAMA_ARMOR.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Icon.Slot.PICKAXE.id(),
                                25, 85,
                                VanillaTextures.Icon.Slot.PICKAXE.u(), VanillaTextures.Icon.Slot.PICKAXE.v(),
                                VanillaTextures.Icon.Slot.PICKAXE.width(), VanillaTextures.Icon.Slot.PICKAXE.height(),
                                VanillaTextures.Icon.Slot.PICKAXE.textureWidth(), VanillaTextures.Icon.Slot.PICKAXE.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Icon.Slot.POTION.id(),
                                45, 85,
                                VanillaTextures.Icon.Slot.POTION.u(), VanillaTextures.Icon.Slot.POTION.v(),
                                VanillaTextures.Icon.Slot.POTION.width(), VanillaTextures.Icon.Slot.POTION.height(),
                                VanillaTextures.Icon.Slot.POTION.textureWidth(), VanillaTextures.Icon.Slot.POTION.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Icon.Slot.QUARTZ.id(),
                                65, 85,
                                VanillaTextures.Icon.Slot.QUARTZ.u(), VanillaTextures.Icon.Slot.QUARTZ.v(),
                                VanillaTextures.Icon.Slot.QUARTZ.width(), VanillaTextures.Icon.Slot.QUARTZ.height(),
                                VanillaTextures.Icon.Slot.QUARTZ.textureWidth(), VanillaTextures.Icon.Slot.QUARTZ.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Icon.Slot.REDSTONE_DUST.id(),
                                85, 85,
                                VanillaTextures.Icon.Slot.REDSTONE_DUST.u(), VanillaTextures.Icon.Slot.REDSTONE_DUST.v(),
                                VanillaTextures.Icon.Slot.REDSTONE_DUST.width(), VanillaTextures.Icon.Slot.REDSTONE_DUST.height(),
                                VanillaTextures.Icon.Slot.REDSTONE_DUST.textureWidth(), VanillaTextures.Icon.Slot.REDSTONE_DUST.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Icon.Slot.SADDLE.id(),
                                105, 85,
                                VanillaTextures.Icon.Slot.SADDLE.u(), VanillaTextures.Icon.Slot.SADDLE.v(),
                                VanillaTextures.Icon.Slot.SADDLE.width(), VanillaTextures.Icon.Slot.SADDLE.height(),
                                VanillaTextures.Icon.Slot.SADDLE.textureWidth(), VanillaTextures.Icon.Slot.SADDLE.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Icon.Slot.SHIELD.id(),
                                125, 85,
                                VanillaTextures.Icon.Slot.SHIELD.u(), VanillaTextures.Icon.Slot.SHIELD.v(),
                                VanillaTextures.Icon.Slot.SHIELD.width(), VanillaTextures.Icon.Slot.SHIELD.height(),
                                VanillaTextures.Icon.Slot.SHIELD.textureWidth(), VanillaTextures.Icon.Slot.SHIELD.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Icon.Slot.SHOVEL.id(),
                                145, 85,
                                VanillaTextures.Icon.Slot.SHOVEL.u(), VanillaTextures.Icon.Slot.SHOVEL.v(),
                                VanillaTextures.Icon.Slot.SHOVEL.width(), VanillaTextures.Icon.Slot.SHOVEL.height(),
                                VanillaTextures.Icon.Slot.SHOVEL.textureWidth(), VanillaTextures.Icon.Slot.SHOVEL.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Icon.Slot.SMITHING_TRIM_TEMPLATE.id(),
                                5, 105,
                                VanillaTextures.Icon.Slot.SMITHING_TRIM_TEMPLATE.u(), VanillaTextures.Icon.Slot.SMITHING_TRIM_TEMPLATE.v(),
                                VanillaTextures.Icon.Slot.SMITHING_TRIM_TEMPLATE.width(), VanillaTextures.Icon.Slot.SMITHING_TRIM_TEMPLATE.height(),
                                VanillaTextures.Icon.Slot.SMITHING_TRIM_TEMPLATE.textureWidth(), VanillaTextures.Icon.Slot.SMITHING_TRIM_TEMPLATE.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Icon.Slot.SMITHING_UPGRADE_TEMPLATE.id(),
                                25, 105,
                                VanillaTextures.Icon.Slot.SMITHING_UPGRADE_TEMPLATE.u(), VanillaTextures.Icon.Slot.SMITHING_UPGRADE_TEMPLATE.v(),
                                VanillaTextures.Icon.Slot.SMITHING_UPGRADE_TEMPLATE.width(), VanillaTextures.Icon.Slot.SMITHING_UPGRADE_TEMPLATE.height(),
                                VanillaTextures.Icon.Slot.SMITHING_UPGRADE_TEMPLATE.textureWidth(), VanillaTextures.Icon.Slot.SMITHING_UPGRADE_TEMPLATE.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Icon.Slot.SWORD.id(),
                                45, 105,
                                VanillaTextures.Icon.Slot.SWORD.u(), VanillaTextures.Icon.Slot.SWORD.v(),
                                VanillaTextures.Icon.Slot.SWORD.width(), VanillaTextures.Icon.Slot.SWORD.height(),
                                VanillaTextures.Icon.Slot.SWORD.textureWidth(), VanillaTextures.Icon.Slot.SWORD.textureHeight());

        //endregion

        ScreenHelper.drawTexture(context, VanillaTextures.Icon.Misc.SEARCH.id(),
                                65, 105,
                                VanillaTextures.Icon.Misc.SEARCH.u(), VanillaTextures.Icon.Misc.SEARCH.v(),
                                VanillaTextures.Icon.Misc.SEARCH.width(), VanillaTextures.Icon.Misc.SEARCH.height(),
                                VanillaTextures.Icon.Misc.SEARCH.textureWidth(), VanillaTextures.Icon.Misc.SEARCH.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Icon.Misc.UNSEEN_NOTIFICATION.id(),
                                85, 105,
                                VanillaTextures.Icon.Misc.UNSEEN_NOTIFICATION.u(), VanillaTextures.Icon.Misc.UNSEEN_NOTIFICATION.v(),
                                VanillaTextures.Icon.Misc.UNSEEN_NOTIFICATION.width(), VanillaTextures.Icon.Misc.UNSEEN_NOTIFICATION.height(),
                                VanillaTextures.Icon.Misc.UNSEEN_NOTIFICATION.textureWidth(), VanillaTextures.Icon.Misc.UNSEEN_NOTIFICATION.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Icon.Misc.DISABLED.id(),
                                105, 105,
                                VanillaTextures.Icon.Misc.DISABLED.u(), VanillaTextures.Icon.Misc.DISABLED.v(),
                                VanillaTextures.Icon.Misc.DISABLED.width(), VanillaTextures.Icon.Misc.DISABLED.height(),
                                VanillaTextures.Icon.Misc.DISABLED.textureWidth(), VanillaTextures.Icon.Misc.DISABLED.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Icon.Misc.ERROR.id(),
                                125, 105,
                                VanillaTextures.Icon.Misc.ERROR.u(), VanillaTextures.Icon.Misc.ERROR.v(),
                                VanillaTextures.Icon.Misc.ERROR.width(), VanillaTextures.Icon.Misc.ERROR.height(),
                                VanillaTextures.Icon.Misc.ERROR.textureWidth(), VanillaTextures.Icon.Misc.ERROR.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Icon.Misc.ERROR_HIGHLIGHTED_RED.id(),
                                135, 105,
                                VanillaTextures.Icon.Misc.ERROR_HIGHLIGHTED_RED.u(), VanillaTextures.Icon.Misc.ERROR_HIGHLIGHTED_RED.v(),
                                VanillaTextures.Icon.Misc.ERROR_HIGHLIGHTED_RED.width(), VanillaTextures.Icon.Misc.ERROR_HIGHLIGHTED_RED.height(),
                                VanillaTextures.Icon.Misc.ERROR_HIGHLIGHTED_RED.textureWidth(), VanillaTextures.Icon.Misc.ERROR_HIGHLIGHTED_RED.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Icon.Misc.ERROR_HIGHLIGHTED_ORANGE.id(),
                                145, 105,
                                VanillaTextures.Icon.Misc.ERROR_HIGHLIGHTED_ORANGE.u(), VanillaTextures.Icon.Misc.ERROR_HIGHLIGHTED_ORANGE.v(),
                                VanillaTextures.Icon.Misc.ERROR_HIGHLIGHTED_ORANGE.width(), VanillaTextures.Icon.Misc.ERROR_HIGHLIGHTED_ORANGE.height(),
                                VanillaTextures.Icon.Misc.ERROR_HIGHLIGHTED_ORANGE.textureWidth(), VanillaTextures.Icon.Misc.ERROR_HIGHLIGHTED_ORANGE.textureHeight());
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float deltaTicks)
    {
        super.render(context, mouseX, mouseY, deltaTicks);

        //ScreenHelper.drawTexture(context, TEXTURE, this.x + 83, this.y + 34, 184, 0, 16, 51); // DRAWING FLUID MARKERS
    }
}