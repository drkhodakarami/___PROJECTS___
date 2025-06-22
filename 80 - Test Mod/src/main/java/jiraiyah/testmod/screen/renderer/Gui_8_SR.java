package jiraiyah.testmod.screen.renderer;

import jiraiyah.jigui.client.constants.ContainerBaseTextures;
import jiraiyah.jigui.client.constants.VanillaTextures;
import jiraiyah.jigui.client.utils.ScreenHelper;
import jiraiyah.testmod.screen.handler.Gui_8_SH;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;

public class Gui_8_SR extends HandledScreen<Gui_8_SH>
{
    public Gui_8_SR(Gui_8_SH handler, PlayerInventory inventory, Text title)
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

        //region BANNER MARKERS
        ScreenHelper.drawTexture(context, VanillaTextures.Marker.Banner.BLACK.id(),
                                5, 5,
                                VanillaTextures.Marker.Banner.BLACK.u(), VanillaTextures.Marker.Banner.BLACK.v(),
                                VanillaTextures.Marker.Banner.BLACK.width(), VanillaTextures.Marker.Banner.BLACK.height(),
                                VanillaTextures.Marker.Banner.BLACK.textureWidth(), VanillaTextures.Marker.Banner.BLACK.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Marker.Banner.BLUE.id(),
                                15, 5,
                                VanillaTextures.Marker.Banner.BLUE.u(), VanillaTextures.Marker.Banner.BLUE.v(),
                                VanillaTextures.Marker.Banner.BLUE.width(), VanillaTextures.Marker.Banner.BLUE.height(),
                                VanillaTextures.Marker.Banner.BLUE.textureWidth(), VanillaTextures.Marker.Banner.BLUE.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Marker.Banner.BROWN.id(),
                                25, 5,
                                VanillaTextures.Marker.Banner.BROWN.u(), VanillaTextures.Marker.Banner.BROWN.v(),
                                VanillaTextures.Marker.Banner.BROWN.width(), VanillaTextures.Marker.Banner.BROWN.height(),
                                VanillaTextures.Marker.Banner.BROWN.textureWidth(), VanillaTextures.Marker.Banner.BROWN.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Marker.Banner.CYAN.id(),
                                35, 5,
                                VanillaTextures.Marker.Banner.CYAN.u(), VanillaTextures.Marker.Banner.CYAN.v(),
                                VanillaTextures.Marker.Banner.CYAN.width(), VanillaTextures.Marker.Banner.CYAN.height(),
                                VanillaTextures.Marker.Banner.CYAN.textureWidth(), VanillaTextures.Marker.Banner.CYAN.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Marker.Banner.GRAY.id(),
                                45, 5,
                                VanillaTextures.Marker.Banner.GRAY.u(), VanillaTextures.Marker.Banner.GRAY.v(),
                                VanillaTextures.Marker.Banner.GRAY.width(), VanillaTextures.Marker.Banner.GRAY.height(),
                                VanillaTextures.Marker.Banner.GRAY.textureWidth(), VanillaTextures.Marker.Banner.GRAY.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Marker.Banner.GREEN.id(),
                                55, 5,
                                VanillaTextures.Marker.Banner.GREEN.u(), VanillaTextures.Marker.Banner.GREEN.v(),
                                VanillaTextures.Marker.Banner.GREEN.width(), VanillaTextures.Marker.Banner.GREEN.height(),
                                VanillaTextures.Marker.Banner.GREEN.textureWidth(), VanillaTextures.Marker.Banner.GREEN.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Marker.Banner.LIGHT_BLUE.id(),
                                65, 5,
                                VanillaTextures.Marker.Banner.LIGHT_BLUE.u(), VanillaTextures.Marker.Banner.LIGHT_BLUE.v(),
                                VanillaTextures.Marker.Banner.LIGHT_BLUE.width(), VanillaTextures.Marker.Banner.LIGHT_BLUE.height(),
                                VanillaTextures.Marker.Banner.LIGHT_BLUE.textureWidth(), VanillaTextures.Marker.Banner.LIGHT_BLUE.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Marker.Banner.LIGHT_GRAY.id(),
                                75, 5,
                                VanillaTextures.Marker.Banner.LIGHT_GRAY.u(), VanillaTextures.Marker.Banner.LIGHT_GRAY.v(),
                                VanillaTextures.Marker.Banner.LIGHT_GRAY.width(), VanillaTextures.Marker.Banner.LIGHT_GRAY.height(),
                                VanillaTextures.Marker.Banner.LIGHT_GRAY.textureWidth(), VanillaTextures.Marker.Banner.LIGHT_GRAY.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Marker.Banner.LIME.id(),
                                85, 5,
                                VanillaTextures.Marker.Banner.LIME.u(), VanillaTextures.Marker.Banner.LIME.v(),
                                VanillaTextures.Marker.Banner.LIME.width(), VanillaTextures.Marker.Banner.LIME.height(),
                                VanillaTextures.Marker.Banner.LIME.textureWidth(), VanillaTextures.Marker.Banner.LIME.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Marker.Banner.MAGENTA.id(),
                                95, 5,
                                VanillaTextures.Marker.Banner.MAGENTA.u(), VanillaTextures.Marker.Banner.MAGENTA.v(),
                                VanillaTextures.Marker.Banner.MAGENTA.width(), VanillaTextures.Marker.Banner.MAGENTA.height(),
                                VanillaTextures.Marker.Banner.MAGENTA.textureWidth(), VanillaTextures.Marker.Banner.MAGENTA.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Marker.Banner.ORANGE.id(),
                                105, 5,
                                VanillaTextures.Marker.Banner.ORANGE.u(), VanillaTextures.Marker.Banner.ORANGE.v(),
                                VanillaTextures.Marker.Banner.ORANGE.width(), VanillaTextures.Marker.Banner.ORANGE.height(),
                                VanillaTextures.Marker.Banner.ORANGE.textureWidth(), VanillaTextures.Marker.Banner.ORANGE.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Marker.Banner.PINK.id(),
                                115, 5,
                                VanillaTextures.Marker.Banner.PINK.u(), VanillaTextures.Marker.Banner.PINK.v(),
                                VanillaTextures.Marker.Banner.PINK.width(), VanillaTextures.Marker.Banner.PINK.height(),
                                VanillaTextures.Marker.Banner.PINK.textureWidth(), VanillaTextures.Marker.Banner.PINK.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Marker.Banner.PURPLE.id(),
                                125, 5,
                                VanillaTextures.Marker.Banner.PURPLE.u(), VanillaTextures.Marker.Banner.PURPLE.v(),
                                VanillaTextures.Marker.Banner.PURPLE.width(), VanillaTextures.Marker.Banner.PURPLE.height(),
                                VanillaTextures.Marker.Banner.PURPLE.textureWidth(), VanillaTextures.Marker.Banner.PURPLE.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Marker.Banner.RED.id(),
                                135, 5,
                                VanillaTextures.Marker.Banner.RED.u(), VanillaTextures.Marker.Banner.RED.v(),
                                VanillaTextures.Marker.Banner.RED.width(), VanillaTextures.Marker.Banner.RED.height(),
                                VanillaTextures.Marker.Banner.RED.textureWidth(), VanillaTextures.Marker.Banner.RED.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Marker.Banner.WHITE.id(),
                                145, 5,
                                VanillaTextures.Marker.Banner.WHITE.u(), VanillaTextures.Marker.Banner.WHITE.v(),
                                VanillaTextures.Marker.Banner.WHITE.width(), VanillaTextures.Marker.Banner.WHITE.height(),
                                VanillaTextures.Marker.Banner.WHITE.textureWidth(), VanillaTextures.Marker.Banner.WHITE.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Marker.Banner.YELLOW.id(),
                                155, 5,
                                VanillaTextures.Marker.Banner.YELLOW.u(), VanillaTextures.Marker.Banner.YELLOW.v(),
                                VanillaTextures.Marker.Banner.YELLOW.width(), VanillaTextures.Marker.Banner.YELLOW.height(),
                                VanillaTextures.Marker.Banner.YELLOW.textureWidth(), VanillaTextures.Marker.Banner.YELLOW.textureHeight());
        //endregion

        //region TARGET MARKERS
        ScreenHelper.drawTexture(context, VanillaTextures.Marker.Target.BLUE_MARKER.id(),
                                5, 15,
                                VanillaTextures.Marker.Target.BLUE_MARKER.u(), VanillaTextures.Marker.Target.BLUE_MARKER.v(),
                                VanillaTextures.Marker.Target.BLUE_MARKER.width(), VanillaTextures.Marker.Target.BLUE_MARKER.height(),
                                VanillaTextures.Marker.Target.BLUE_MARKER.textureWidth(), VanillaTextures.Marker.Target.BLUE_MARKER.textureHeight());


        ScreenHelper.drawTexture(context, VanillaTextures.Marker.Target.RED_MARKER.id(),
                                15, 15,
                                VanillaTextures.Marker.Target.RED_MARKER.u(), VanillaTextures.Marker.Target.RED_MARKER.v(),
                                VanillaTextures.Marker.Target.RED_MARKER.width(), VanillaTextures.Marker.Target.RED_MARKER.height(),
                                VanillaTextures.Marker.Target.RED_MARKER.textureWidth(), VanillaTextures.Marker.Target.RED_MARKER.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Marker.Target.RED_X.id(),
                                25, 15,
                                VanillaTextures.Marker.Target.RED_X.u(), VanillaTextures.Marker.Target.RED_X.v(),
                                VanillaTextures.Marker.Target.RED_X.width(), VanillaTextures.Marker.Target.RED_X.height(),
                                VanillaTextures.Marker.Target.RED_X.textureWidth(), VanillaTextures.Marker.Target.RED_X.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Marker.Target.TARGET_POINT.id(),
                                35, 15,
                                VanillaTextures.Marker.Target.TARGET_POINT.u(), VanillaTextures.Marker.Target.TARGET_POINT.v(),
                                VanillaTextures.Marker.Target.TARGET_POINT.width(), VanillaTextures.Marker.Target.TARGET_POINT.height(),
                                VanillaTextures.Marker.Target.TARGET_POINT.textureWidth(), VanillaTextures.Marker.Target.TARGET_POINT.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Marker.Target.TARGET_X.id(),
                                45, 15,
                                VanillaTextures.Marker.Target.TARGET_X.u(), VanillaTextures.Marker.Target.TARGET_X.v(),
                                VanillaTextures.Marker.Target.TARGET_X.width(), VanillaTextures.Marker.Target.TARGET_X.height(),
                                VanillaTextures.Marker.Target.TARGET_X.textureWidth(), VanillaTextures.Marker.Target.TARGET_X.textureHeight());
        //endregion

        //region PLAYER MARKERS
        ScreenHelper.drawTexture(context, VanillaTextures.Marker.Player.PLAYER.id(),
                                55, 15,
                                VanillaTextures.Marker.Player.PLAYER.u(), VanillaTextures.Marker.Player.PLAYER.v(),
                                VanillaTextures.Marker.Player.PLAYER.width(), VanillaTextures.Marker.Player.PLAYER.height(),
                                VanillaTextures.Marker.Player.PLAYER.textureWidth(), VanillaTextures.Marker.Player.PLAYER.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Marker.Player.PLAYER_OFF_LIMITS.id(),
                                65, 15,
                                VanillaTextures.Marker.Player.PLAYER_OFF_LIMITS.u(), VanillaTextures.Marker.Player.PLAYER_OFF_LIMITS.v(),
                                VanillaTextures.Marker.Player.PLAYER_OFF_LIMITS.width(), VanillaTextures.Marker.Player.PLAYER_OFF_LIMITS.height(),
                                VanillaTextures.Marker.Player.PLAYER_OFF_LIMITS.textureWidth(), VanillaTextures.Marker.Player.PLAYER_OFF_LIMITS.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Marker.Player.PLAYER_OFF_MAP.id(),
                                75, 15,
                                VanillaTextures.Marker.Player.PLAYER_OFF_MAP.u(), VanillaTextures.Marker.Player.PLAYER_OFF_MAP.v(),
                                VanillaTextures.Marker.Player.PLAYER_OFF_MAP.width(), VanillaTextures.Marker.Player.PLAYER_OFF_MAP.height(),
                                VanillaTextures.Marker.Player.PLAYER_OFF_MAP.textureWidth(), VanillaTextures.Marker.Player.PLAYER_OFF_MAP.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Marker.Target.FRAME.id(),
                                85, 15,
                                VanillaTextures.Marker.Target.FRAME.u(), VanillaTextures.Marker.Target.FRAME.v(),
                                VanillaTextures.Marker.Target.FRAME.width(), VanillaTextures.Marker.Target.FRAME.height(),
                                VanillaTextures.Marker.Target.FRAME.textureWidth(), VanillaTextures.Marker.Target.FRAME.textureHeight());
        //endregion

        //region BUILDING MARKERS
        ScreenHelper.drawTexture(context, VanillaTextures.Marker.Building.DESERT_VILLAGE.id(),
                                5, 25,
                                VanillaTextures.Marker.Building.DESERT_VILLAGE.u(), VanillaTextures.Marker.Building.DESERT_VILLAGE.v(),
                                VanillaTextures.Marker.Building.DESERT_VILLAGE.width(), VanillaTextures.Marker.Building.DESERT_VILLAGE.height(),
                                VanillaTextures.Marker.Building.DESERT_VILLAGE.textureWidth(), VanillaTextures.Marker.Building.DESERT_VILLAGE.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Marker.Building.JUNGLE_TEMPLE.id(),
                                15, 25,
                                VanillaTextures.Marker.Building.JUNGLE_TEMPLE.u(), VanillaTextures.Marker.Building.JUNGLE_TEMPLE.v(),
                                VanillaTextures.Marker.Building.JUNGLE_TEMPLE.width(), VanillaTextures.Marker.Building.JUNGLE_TEMPLE.height(),
                                VanillaTextures.Marker.Building.JUNGLE_TEMPLE.textureWidth(), VanillaTextures.Marker.Building.JUNGLE_TEMPLE.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Marker.Building.OCEAN_MONUMENT.id(),
                                25, 25,
                                VanillaTextures.Marker.Building.OCEAN_MONUMENT.u(), VanillaTextures.Marker.Building.OCEAN_MONUMENT.v(),
                                VanillaTextures.Marker.Building.OCEAN_MONUMENT.width(), VanillaTextures.Marker.Building.OCEAN_MONUMENT.height(),
                                VanillaTextures.Marker.Building.OCEAN_MONUMENT.textureWidth(), VanillaTextures.Marker.Building.OCEAN_MONUMENT.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Marker.Building.PLAINS_VILLAGE.id(),
                                35, 25,
                                VanillaTextures.Marker.Building.PLAINS_VILLAGE.u(), VanillaTextures.Marker.Building.PLAINS_VILLAGE.v(),
                                VanillaTextures.Marker.Building.PLAINS_VILLAGE.width(), VanillaTextures.Marker.Building.PLAINS_VILLAGE.height(),
                                VanillaTextures.Marker.Building.PLAINS_VILLAGE.textureWidth(), VanillaTextures.Marker.Building.PLAINS_VILLAGE.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Marker.Building.SAVANNA_VILLAGE.id(),
                                45, 25,
                                VanillaTextures.Marker.Building.SAVANNA_VILLAGE.u(), VanillaTextures.Marker.Building.SAVANNA_VILLAGE.v(),
                                VanillaTextures.Marker.Building.SAVANNA_VILLAGE.width(), VanillaTextures.Marker.Building.SAVANNA_VILLAGE.height(),
                                VanillaTextures.Marker.Building.SAVANNA_VILLAGE.textureWidth(), VanillaTextures.Marker.Building.SAVANNA_VILLAGE.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Marker.Building.SNOWY_VILLAGE.id(),
                                55, 25,
                                VanillaTextures.Marker.Building.SNOWY_VILLAGE.u(), VanillaTextures.Marker.Building.SNOWY_VILLAGE.v(),
                                VanillaTextures.Marker.Building.SNOWY_VILLAGE.width(), VanillaTextures.Marker.Building.SNOWY_VILLAGE.height(),
                                VanillaTextures.Marker.Building.SNOWY_VILLAGE.textureWidth(), VanillaTextures.Marker.Building.SNOWY_VILLAGE.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Marker.Building.SWAMP_HUT.id(),
                                65, 25,
                                VanillaTextures.Marker.Building.SWAMP_HUT.u(), VanillaTextures.Marker.Building.SWAMP_HUT.v(),
                                VanillaTextures.Marker.Building.SWAMP_HUT.width(), VanillaTextures.Marker.Building.SWAMP_HUT.height(),
                                VanillaTextures.Marker.Building.SWAMP_HUT.textureWidth(), VanillaTextures.Marker.Building.SWAMP_HUT.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Marker.Building.TAIGA_VILLAGE.id(),
                                75, 25,
                                VanillaTextures.Marker.Building.TAIGA_VILLAGE.u(), VanillaTextures.Marker.Building.TAIGA_VILLAGE.v(),
                                VanillaTextures.Marker.Building.TAIGA_VILLAGE.width(), VanillaTextures.Marker.Building.TAIGA_VILLAGE.height(),
                                VanillaTextures.Marker.Building.TAIGA_VILLAGE.textureWidth(), VanillaTextures.Marker.Building.TAIGA_VILLAGE.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Marker.Building.TRIAL_CHAMBER.id(),
                                85, 25,
                                VanillaTextures.Marker.Building.TRIAL_CHAMBER.u(), VanillaTextures.Marker.Building.TRIAL_CHAMBER.v(),
                                VanillaTextures.Marker.Building.TRIAL_CHAMBER.width(), VanillaTextures.Marker.Building.TRIAL_CHAMBER.height(),
                                VanillaTextures.Marker.Building.TRIAL_CHAMBER.textureWidth(), VanillaTextures.Marker.Building.TRIAL_CHAMBER.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Marker.Building.WOODLAND_MANSION.id(),
                                95, 25,
                                VanillaTextures.Marker.Building.WOODLAND_MANSION.u(), VanillaTextures.Marker.Building.WOODLAND_MANSION.v(),
                                VanillaTextures.Marker.Building.WOODLAND_MANSION.width(), VanillaTextures.Marker.Building.WOODLAND_MANSION.height(),
                                VanillaTextures.Marker.Building.WOODLAND_MANSION.textureWidth(), VanillaTextures.Marker.Building.WOODLAND_MANSION.textureHeight());
        //endregion

        //region HUD SCREEN
        ScreenHelper.drawTexture(context, VanillaTextures.HUD.Screen.Air.NORMAL.id(),
                                5, 35,
                                VanillaTextures.HUD.Screen.Air.NORMAL.u(), VanillaTextures.HUD.Screen.Air.NORMAL.v(),
                                VanillaTextures.HUD.Screen.Air.NORMAL.width(), VanillaTextures.HUD.Screen.Air.NORMAL.height(),
                                VanillaTextures.HUD.Screen.Air.NORMAL.textureWidth(), VanillaTextures.HUD.Screen.Air.NORMAL.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.HUD.Screen.Air.BURSTING.id(),
                                15, 35,
                                VanillaTextures.HUD.Screen.Air.BURSTING.u(), VanillaTextures.HUD.Screen.Air.BURSTING.v(),
                                VanillaTextures.HUD.Screen.Air.BURSTING.width(), VanillaTextures.HUD.Screen.Air.BURSTING.height(),
                                VanillaTextures.HUD.Screen.Air.BURSTING.textureWidth(), VanillaTextures.HUD.Screen.Air.BURSTING.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.HUD.Screen.Air.EMPTY.id(),
                                25, 35,
                                VanillaTextures.HUD.Screen.Air.EMPTY.u(), VanillaTextures.HUD.Screen.Air.EMPTY.v(),
                                VanillaTextures.HUD.Screen.Air.EMPTY.width(), VanillaTextures.HUD.Screen.Air.EMPTY.height(),
                                VanillaTextures.HUD.Screen.Air.EMPTY.textureWidth(), VanillaTextures.HUD.Screen.Air.EMPTY.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.HUD.Screen.Armor.FULL.id(),
                                35, 35,
                                VanillaTextures.HUD.Screen.Armor.FULL.u(), VanillaTextures.HUD.Screen.Armor.FULL.v(),
                                VanillaTextures.HUD.Screen.Armor.FULL.width(), VanillaTextures.HUD.Screen.Armor.FULL.height(),
                                VanillaTextures.HUD.Screen.Armor.FULL.textureWidth(), VanillaTextures.HUD.Screen.Armor.FULL.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.HUD.Screen.Armor.HALF.id(),
                                45, 35,
                                VanillaTextures.HUD.Screen.Armor.HALF.u(), VanillaTextures.HUD.Screen.Armor.HALF.v(),
                                VanillaTextures.HUD.Screen.Armor.HALF.width(), VanillaTextures.HUD.Screen.Armor.HALF.height(),
                                VanillaTextures.HUD.Screen.Armor.HALF.textureWidth(), VanillaTextures.HUD.Screen.Armor.HALF.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.HUD.Screen.Armor.EMPTY.id(),
                                55, 35,
                                VanillaTextures.HUD.Screen.Armor.EMPTY.u(), VanillaTextures.HUD.Screen.Armor.EMPTY.v(),
                                VanillaTextures.HUD.Screen.Armor.EMPTY.width(), VanillaTextures.HUD.Screen.Armor.EMPTY.height(),
                                VanillaTextures.HUD.Screen.Armor.EMPTY.textureWidth(), VanillaTextures.HUD.Screen.Armor.EMPTY.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.HUD.Screen.Crosshair.ICON.id(),
                                65, 35,
                                VanillaTextures.HUD.Screen.Crosshair.ICON.u(), VanillaTextures.HUD.Screen.Crosshair.ICON.v(),
                                VanillaTextures.HUD.Screen.Crosshair.ICON.width(), VanillaTextures.HUD.Screen.Crosshair.ICON.height(),
                                VanillaTextures.HUD.Screen.Crosshair.ICON.textureWidth(), VanillaTextures.HUD.Screen.Crosshair.ICON.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.HUD.Screen.Crosshair.ATTACK_BACKGROUND.id(),
                                85, 35,
                                VanillaTextures.HUD.Screen.Crosshair.ATTACK_BACKGROUND.u(), VanillaTextures.HUD.Screen.Crosshair.ATTACK_BACKGROUND.v(),
                                VanillaTextures.HUD.Screen.Crosshair.ATTACK_BACKGROUND.width(), VanillaTextures.HUD.Screen.Crosshair.ATTACK_BACKGROUND.height(),
                                VanillaTextures.HUD.Screen.Crosshair.ATTACK_BACKGROUND.textureWidth(), VanillaTextures.HUD.Screen.Crosshair.ATTACK_BACKGROUND.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.HUD.Screen.Crosshair.ATTACK_FULL.id(),
                                105, 35,
                                VanillaTextures.HUD.Screen.Crosshair.ATTACK_FULL.u(), VanillaTextures.HUD.Screen.Crosshair.ATTACK_FULL.v(),
                                VanillaTextures.HUD.Screen.Crosshair.ATTACK_FULL.width(), VanillaTextures.HUD.Screen.Crosshair.ATTACK_FULL.height(),
                                VanillaTextures.HUD.Screen.Crosshair.ATTACK_FULL.textureWidth(), VanillaTextures.HUD.Screen.Crosshair.ATTACK_FULL.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.HUD.Screen.Crosshair.ATTACK_PROGRESS.id(),
                                125, 35,
                                VanillaTextures.HUD.Screen.Crosshair.ATTACK_PROGRESS.u(), VanillaTextures.HUD.Screen.Crosshair.ATTACK_PROGRESS.v(),
                                VanillaTextures.HUD.Screen.Crosshair.ATTACK_PROGRESS.width(), VanillaTextures.HUD.Screen.Crosshair.ATTACK_PROGRESS.height(),
                                VanillaTextures.HUD.Screen.Crosshair.ATTACK_PROGRESS.textureWidth(), VanillaTextures.HUD.Screen.Crosshair.ATTACK_PROGRESS.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.HUD.Screen.Food.EMPTY.id(),
                                5, 50,
                                VanillaTextures.HUD.Screen.Food.EMPTY.u(), VanillaTextures.HUD.Screen.Food.EMPTY.v(),
                                VanillaTextures.HUD.Screen.Food.EMPTY.width(), VanillaTextures.HUD.Screen.Food.EMPTY.height(),
                                VanillaTextures.HUD.Screen.Food.EMPTY.textureWidth(), VanillaTextures.HUD.Screen.Food.EMPTY.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.HUD.Screen.Food.EMPTY_HUNGER.id(),
                                15, 50,
                                VanillaTextures.HUD.Screen.Food.EMPTY_HUNGER.u(), VanillaTextures.HUD.Screen.Food.EMPTY_HUNGER.v(),
                                VanillaTextures.HUD.Screen.Food.EMPTY_HUNGER.width(), VanillaTextures.HUD.Screen.Food.EMPTY_HUNGER.height(),
                                VanillaTextures.HUD.Screen.Food.EMPTY_HUNGER.textureWidth(), VanillaTextures.HUD.Screen.Food.EMPTY_HUNGER.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.HUD.Screen.Food.FULL.id(),
                                25, 50,
                                VanillaTextures.HUD.Screen.Food.FULL.u(), VanillaTextures.HUD.Screen.Food.FULL.v(),
                                VanillaTextures.HUD.Screen.Food.FULL.width(), VanillaTextures.HUD.Screen.Food.FULL.height(),
                                VanillaTextures.HUD.Screen.Food.FULL.textureWidth(), VanillaTextures.HUD.Screen.Food.FULL.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.HUD.Screen.Food.FULL_HUNGER.id(),
                                35, 50,
                                VanillaTextures.HUD.Screen.Food.FULL_HUNGER.u(), VanillaTextures.HUD.Screen.Food.FULL_HUNGER.v(),
                                VanillaTextures.HUD.Screen.Food.FULL_HUNGER.width(), VanillaTextures.HUD.Screen.Food.FULL_HUNGER.height(),
                                VanillaTextures.HUD.Screen.Food.FULL_HUNGER.textureWidth(), VanillaTextures.HUD.Screen.Food.FULL_HUNGER.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.HUD.Screen.Food.HALF.id(),
                                45, 50,
                                VanillaTextures.HUD.Screen.Food.HALF.u(), VanillaTextures.HUD.Screen.Food.HALF.v(),
                                VanillaTextures.HUD.Screen.Food.HALF.width(), VanillaTextures.HUD.Screen.Food.HALF.height(),
                                VanillaTextures.HUD.Screen.Food.HALF.textureWidth(), VanillaTextures.HUD.Screen.Food.HALF.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.HUD.Screen.Food.HALF_HUNGER.id(),
                                55, 50,
                                VanillaTextures.HUD.Screen.Food.HALF_HUNGER.u(), VanillaTextures.HUD.Screen.Food.HALF_HUNGER.v(),
                                VanillaTextures.HUD.Screen.Food.HALF_HUNGER.width(), VanillaTextures.HUD.Screen.Food.HALF_HUNGER.height(),
                                VanillaTextures.HUD.Screen.Food.HALF_HUNGER.textureWidth(), VanillaTextures.HUD.Screen.Food.HALF_HUNGER.textureHeight());
        //endregion

        //region HEART NORMAL
        ScreenHelper.drawTexture(context, VanillaTextures.HUD.Heart.Normal.Simple.ABSORBING_FULL.id(),
                                5, 60,
                                VanillaTextures.HUD.Heart.Normal.Simple.ABSORBING_FULL.u(), VanillaTextures.HUD.Heart.Normal.Simple.ABSORBING_FULL.v(),
                                VanillaTextures.HUD.Heart.Normal.Simple.ABSORBING_FULL.width(), VanillaTextures.HUD.Heart.Normal.Simple.ABSORBING_FULL.height(),
                                VanillaTextures.HUD.Heart.Normal.Simple.ABSORBING_FULL.textureWidth(), VanillaTextures.HUD.Heart.Normal.Simple.ABSORBING_FULL.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.HUD.Heart.Normal.Simple.ABSORBING_HALF.id(),
                                15, 60,
                                VanillaTextures.HUD.Heart.Normal.Simple.ABSORBING_HALF.u(), VanillaTextures.HUD.Heart.Normal.Simple.ABSORBING_HALF.v(),
                                VanillaTextures.HUD.Heart.Normal.Simple.ABSORBING_HALF.width(), VanillaTextures.HUD.Heart.Normal.Simple.ABSORBING_HALF.height(),
                                VanillaTextures.HUD.Heart.Normal.Simple.ABSORBING_HALF.textureWidth(), VanillaTextures.HUD.Heart.Normal.Simple.ABSORBING_HALF.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.HUD.Heart.Normal.Simple.CONTAINER.id(),
                                25, 60,
                                VanillaTextures.HUD.Heart.Normal.Simple.CONTAINER.u(), VanillaTextures.HUD.Heart.Normal.Simple.CONTAINER.v(),
                                VanillaTextures.HUD.Heart.Normal.Simple.CONTAINER.width(), VanillaTextures.HUD.Heart.Normal.Simple.CONTAINER.height(),
                                VanillaTextures.HUD.Heart.Normal.Simple.CONTAINER.textureWidth(), VanillaTextures.HUD.Heart.Normal.Simple.CONTAINER.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.HUD.Heart.Normal.Simple.FROZEN_FULL.id(),
                                35, 60,
                                VanillaTextures.HUD.Heart.Normal.Simple.FROZEN_FULL.u(), VanillaTextures.HUD.Heart.Normal.Simple.FROZEN_FULL.v(),
                                VanillaTextures.HUD.Heart.Normal.Simple.FROZEN_FULL.width(), VanillaTextures.HUD.Heart.Normal.Simple.FROZEN_FULL.height(),
                                VanillaTextures.HUD.Heart.Normal.Simple.FROZEN_FULL.textureWidth(), VanillaTextures.HUD.Heart.Normal.Simple.FROZEN_FULL.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.HUD.Heart.Normal.Simple.FROZEN_HALF.id(),
                                45, 60,
                                VanillaTextures.HUD.Heart.Normal.Simple.FROZEN_HALF.u(), VanillaTextures.HUD.Heart.Normal.Simple.FROZEN_HALF.v(),
                                VanillaTextures.HUD.Heart.Normal.Simple.FROZEN_HALF.width(), VanillaTextures.HUD.Heart.Normal.Simple.FROZEN_HALF.height(),
                                VanillaTextures.HUD.Heart.Normal.Simple.FROZEN_HALF.textureWidth(), VanillaTextures.HUD.Heart.Normal.Simple.FROZEN_HALF.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.HUD.Heart.Normal.Simple.FULL.id(),
                                55, 60,
                                VanillaTextures.HUD.Heart.Normal.Simple.FULL.u(), VanillaTextures.HUD.Heart.Normal.Simple.FULL.v(),
                                VanillaTextures.HUD.Heart.Normal.Simple.FULL.width(), VanillaTextures.HUD.Heart.Normal.Simple.FULL.height(),
                                VanillaTextures.HUD.Heart.Normal.Simple.FULL.textureWidth(), VanillaTextures.HUD.Heart.Normal.Simple.FULL.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.HUD.Heart.Normal.Simple.HALF.id(),
                                65, 60,
                                VanillaTextures.HUD.Heart.Normal.Simple.HALF.u(), VanillaTextures.HUD.Heart.Normal.Simple.HALF.v(),
                                VanillaTextures.HUD.Heart.Normal.Simple.HALF.width(), VanillaTextures.HUD.Heart.Normal.Simple.HALF.height(),
                                VanillaTextures.HUD.Heart.Normal.Simple.HALF.textureWidth(), VanillaTextures.HUD.Heart.Normal.Simple.HALF.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.HUD.Heart.Normal.Simple.POISONED_FULL.id(),
                                75, 60,
                                VanillaTextures.HUD.Heart.Normal.Simple.POISONED_FULL.u(), VanillaTextures.HUD.Heart.Normal.Simple.POISONED_FULL.v(),
                                VanillaTextures.HUD.Heart.Normal.Simple.POISONED_FULL.width(), VanillaTextures.HUD.Heart.Normal.Simple.POISONED_FULL.height(),
                                VanillaTextures.HUD.Heart.Normal.Simple.POISONED_FULL.textureWidth(), VanillaTextures.HUD.Heart.Normal.Simple.POISONED_FULL.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.HUD.Heart.Normal.Simple.POISONED_HALF.id(),
                                85, 60,
                                VanillaTextures.HUD.Heart.Normal.Simple.POISONED_HALF.u(), VanillaTextures.HUD.Heart.Normal.Simple.POISONED_HALF.v(),
                                VanillaTextures.HUD.Heart.Normal.Simple.POISONED_HALF.width(), VanillaTextures.HUD.Heart.Normal.Simple.POISONED_HALF.height(),
                                VanillaTextures.HUD.Heart.Normal.Simple.POISONED_HALF.textureWidth(), VanillaTextures.HUD.Heart.Normal.Simple.POISONED_HALF.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.HUD.Heart.Normal.Simple.WITHERED_FULL.id(),
                                95, 60,
                                VanillaTextures.HUD.Heart.Normal.Simple.WITHERED_FULL.u(), VanillaTextures.HUD.Heart.Normal.Simple.WITHERED_FULL.v(),
                                VanillaTextures.HUD.Heart.Normal.Simple.WITHERED_FULL.width(), VanillaTextures.HUD.Heart.Normal.Simple.WITHERED_FULL.height(),
                                VanillaTextures.HUD.Heart.Normal.Simple.WITHERED_FULL.textureWidth(), VanillaTextures.HUD.Heart.Normal.Simple.WITHERED_FULL.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.HUD.Heart.Normal.Simple.WITHERED_HALF.id(),
                                105, 60,
                                VanillaTextures.HUD.Heart.Normal.Simple.WITHERED_HALF.u(), VanillaTextures.HUD.Heart.Normal.Simple.WITHERED_HALF.v(),
                                VanillaTextures.HUD.Heart.Normal.Simple.WITHERED_HALF.width(), VanillaTextures.HUD.Heart.Normal.Simple.WITHERED_HALF.height(),
                                VanillaTextures.HUD.Heart.Normal.Simple.WITHERED_HALF.textureWidth(), VanillaTextures.HUD.Heart.Normal.Simple.WITHERED_HALF.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.HUD.Heart.Normal.Blinking.ABSORBING_FULL.id(),
                                5, 70,
                                VanillaTextures.HUD.Heart.Normal.Blinking.ABSORBING_FULL.u(), VanillaTextures.HUD.Heart.Normal.Blinking.ABSORBING_FULL.v(),
                                VanillaTextures.HUD.Heart.Normal.Blinking.ABSORBING_FULL.width(), VanillaTextures.HUD.Heart.Normal.Blinking.ABSORBING_FULL.height(),
                                VanillaTextures.HUD.Heart.Normal.Blinking.ABSORBING_FULL.textureWidth(), VanillaTextures.HUD.Heart.Normal.Blinking.ABSORBING_FULL.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.HUD.Heart.Normal.Blinking.ABSORBING_HALF.id(),
                                15, 70,
                                VanillaTextures.HUD.Heart.Normal.Blinking.ABSORBING_HALF.u(), VanillaTextures.HUD.Heart.Normal.Blinking.ABSORBING_HALF.v(),
                                VanillaTextures.HUD.Heart.Normal.Blinking.ABSORBING_HALF.width(), VanillaTextures.HUD.Heart.Normal.Blinking.ABSORBING_HALF.height(),
                                VanillaTextures.HUD.Heart.Normal.Blinking.ABSORBING_HALF.textureWidth(), VanillaTextures.HUD.Heart.Normal.Blinking.ABSORBING_HALF.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.HUD.Heart.Normal.Blinking.CONTAINER.id(),
                                25, 70,
                                VanillaTextures.HUD.Heart.Normal.Blinking.CONTAINER.u(), VanillaTextures.HUD.Heart.Normal.Blinking.CONTAINER.v(),
                                VanillaTextures.HUD.Heart.Normal.Blinking.CONTAINER.width(), VanillaTextures.HUD.Heart.Normal.Blinking.CONTAINER.height(),
                                VanillaTextures.HUD.Heart.Normal.Blinking.CONTAINER.textureWidth(), VanillaTextures.HUD.Heart.Normal.Blinking.CONTAINER.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.HUD.Heart.Normal.Blinking.FROZEN_FULL.id(),
                                35, 70,
                                VanillaTextures.HUD.Heart.Normal.Blinking.FROZEN_FULL.u(), VanillaTextures.HUD.Heart.Normal.Blinking.FROZEN_FULL.v(),
                                VanillaTextures.HUD.Heart.Normal.Blinking.FROZEN_FULL.width(), VanillaTextures.HUD.Heart.Normal.Blinking.FROZEN_FULL.height(),
                                VanillaTextures.HUD.Heart.Normal.Blinking.FROZEN_FULL.textureWidth(), VanillaTextures.HUD.Heart.Normal.Blinking.FROZEN_FULL.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.HUD.Heart.Normal.Blinking.FROZEN_HALF.id(),
                                45, 70,
                                VanillaTextures.HUD.Heart.Normal.Blinking.FROZEN_HALF.u(), VanillaTextures.HUD.Heart.Normal.Blinking.FROZEN_HALF.v(),
                                VanillaTextures.HUD.Heart.Normal.Blinking.FROZEN_HALF.width(), VanillaTextures.HUD.Heart.Normal.Blinking.FROZEN_HALF.height(),
                                VanillaTextures.HUD.Heart.Normal.Blinking.FROZEN_HALF.textureWidth(), VanillaTextures.HUD.Heart.Normal.Blinking.FROZEN_HALF.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.HUD.Heart.Normal.Blinking.FULL.id(),
                                55, 70,
                                VanillaTextures.HUD.Heart.Normal.Blinking.FULL.u(), VanillaTextures.HUD.Heart.Normal.Blinking.FULL.v(),
                                VanillaTextures.HUD.Heart.Normal.Blinking.FULL.width(), VanillaTextures.HUD.Heart.Normal.Blinking.FULL.height(),
                                VanillaTextures.HUD.Heart.Normal.Blinking.FULL.textureWidth(), VanillaTextures.HUD.Heart.Normal.Blinking.FULL.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.HUD.Heart.Normal.Blinking.HALF.id(),
                                65, 70,
                                VanillaTextures.HUD.Heart.Normal.Blinking.HALF.u(), VanillaTextures.HUD.Heart.Normal.Blinking.HALF.v(),
                                VanillaTextures.HUD.Heart.Normal.Blinking.HALF.width(), VanillaTextures.HUD.Heart.Normal.Blinking.HALF.height(),
                                VanillaTextures.HUD.Heart.Normal.Blinking.HALF.textureWidth(), VanillaTextures.HUD.Heart.Normal.Blinking.HALF.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.HUD.Heart.Normal.Blinking.POISONED_FULL.id(),
                                75, 70,
                                VanillaTextures.HUD.Heart.Normal.Blinking.POISONED_FULL.u(), VanillaTextures.HUD.Heart.Normal.Blinking.POISONED_FULL.v(),
                                VanillaTextures.HUD.Heart.Normal.Blinking.POISONED_FULL.width(), VanillaTextures.HUD.Heart.Normal.Blinking.POISONED_FULL.height(),
                                VanillaTextures.HUD.Heart.Normal.Blinking.POISONED_FULL.textureWidth(), VanillaTextures.HUD.Heart.Normal.Blinking.POISONED_FULL.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.HUD.Heart.Normal.Blinking.POISONED_HALF.id(),
                                85, 70,
                                VanillaTextures.HUD.Heart.Normal.Blinking.POISONED_HALF.u(), VanillaTextures.HUD.Heart.Normal.Blinking.POISONED_HALF.v(),
                                VanillaTextures.HUD.Heart.Normal.Blinking.POISONED_HALF.width(), VanillaTextures.HUD.Heart.Normal.Blinking.POISONED_HALF.height(),
                                VanillaTextures.HUD.Heart.Normal.Blinking.POISONED_HALF.textureWidth(), VanillaTextures.HUD.Heart.Normal.Blinking.POISONED_HALF.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.HUD.Heart.Normal.Blinking.WITHERED_FULL.id(),
                                95, 70,
                                VanillaTextures.HUD.Heart.Normal.Blinking.WITHERED_FULL.u(), VanillaTextures.HUD.Heart.Normal.Blinking.WITHERED_FULL.v(),
                                VanillaTextures.HUD.Heart.Normal.Blinking.WITHERED_FULL.width(), VanillaTextures.HUD.Heart.Normal.Blinking.WITHERED_FULL.height(),
                                VanillaTextures.HUD.Heart.Normal.Blinking.WITHERED_FULL.textureWidth(), VanillaTextures.HUD.Heart.Normal.Blinking.WITHERED_FULL.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.HUD.Heart.Normal.Blinking.WITHERED_HALF.id(),
                                105, 70,
                                VanillaTextures.HUD.Heart.Normal.Blinking.WITHERED_HALF.u(), VanillaTextures.HUD.Heart.Normal.Blinking.WITHERED_HALF.v(),
                                VanillaTextures.HUD.Heart.Normal.Blinking.WITHERED_HALF.width(), VanillaTextures.HUD.Heart.Normal.Blinking.WITHERED_HALF.height(),
                                VanillaTextures.HUD.Heart.Normal.Blinking.WITHERED_HALF.textureWidth(), VanillaTextures.HUD.Heart.Normal.Blinking.WITHERED_HALF.textureHeight());
        //endregion

        //region HEART HARDCORE
        ScreenHelper.drawTexture(context, VanillaTextures.HUD.Heart.Hardcore.Simple.ABSORBING_FULL.id(),
                                5, 80,
                                VanillaTextures.HUD.Heart.Hardcore.Simple.ABSORBING_FULL.u(), VanillaTextures.HUD.Heart.Hardcore.Simple.ABSORBING_FULL.v(),
                                VanillaTextures.HUD.Heart.Hardcore.Simple.ABSORBING_FULL.width(), VanillaTextures.HUD.Heart.Hardcore.Simple.ABSORBING_FULL.height(),
                                VanillaTextures.HUD.Heart.Hardcore.Simple.ABSORBING_FULL.textureWidth(), VanillaTextures.HUD.Heart.Hardcore.Simple.ABSORBING_FULL.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.HUD.Heart.Hardcore.Simple.ABSORBING_HALF.id(),
                                15, 80,
                                VanillaTextures.HUD.Heart.Hardcore.Simple.ABSORBING_HALF.u(), VanillaTextures.HUD.Heart.Hardcore.Simple.ABSORBING_HALF.v(),
                                VanillaTextures.HUD.Heart.Hardcore.Simple.ABSORBING_HALF.width(), VanillaTextures.HUD.Heart.Hardcore.Simple.ABSORBING_HALF.height(),
                                VanillaTextures.HUD.Heart.Hardcore.Simple.ABSORBING_HALF.textureWidth(), VanillaTextures.HUD.Heart.Hardcore.Simple.ABSORBING_HALF.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.HUD.Heart.Hardcore.Simple.CONTAINER.id(),
                                25, 80,
                                VanillaTextures.HUD.Heart.Hardcore.Simple.CONTAINER.u(), VanillaTextures.HUD.Heart.Hardcore.Simple.CONTAINER.v(),
                                VanillaTextures.HUD.Heart.Hardcore.Simple.CONTAINER.width(), VanillaTextures.HUD.Heart.Hardcore.Simple.CONTAINER.height(),
                                VanillaTextures.HUD.Heart.Hardcore.Simple.CONTAINER.textureWidth(), VanillaTextures.HUD.Heart.Hardcore.Simple.CONTAINER.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.HUD.Heart.Hardcore.Simple.FROZEN_FULL.id(),
                                35, 80,
                                VanillaTextures.HUD.Heart.Hardcore.Simple.FROZEN_FULL.u(), VanillaTextures.HUD.Heart.Hardcore.Simple.FROZEN_FULL.v(),
                                VanillaTextures.HUD.Heart.Hardcore.Simple.FROZEN_FULL.width(), VanillaTextures.HUD.Heart.Hardcore.Simple.FROZEN_FULL.height(),
                                VanillaTextures.HUD.Heart.Hardcore.Simple.FROZEN_FULL.textureWidth(), VanillaTextures.HUD.Heart.Hardcore.Simple.FROZEN_FULL.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.HUD.Heart.Hardcore.Simple.FROZEN_HALF.id(),
                                45, 80,
                                VanillaTextures.HUD.Heart.Hardcore.Simple.FROZEN_HALF.u(), VanillaTextures.HUD.Heart.Hardcore.Simple.FROZEN_HALF.v(),
                                VanillaTextures.HUD.Heart.Hardcore.Simple.FROZEN_HALF.width(), VanillaTextures.HUD.Heart.Hardcore.Simple.FROZEN_HALF.height(),
                                VanillaTextures.HUD.Heart.Hardcore.Simple.FROZEN_HALF.textureWidth(), VanillaTextures.HUD.Heart.Hardcore.Simple.FROZEN_HALF.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.HUD.Heart.Hardcore.Simple.FULL.id(),
                                55, 80,
                                VanillaTextures.HUD.Heart.Hardcore.Simple.FULL.u(), VanillaTextures.HUD.Heart.Hardcore.Simple.FULL.v(),
                                VanillaTextures.HUD.Heart.Hardcore.Simple.FULL.width(), VanillaTextures.HUD.Heart.Hardcore.Simple.FULL.height(),
                                VanillaTextures.HUD.Heart.Hardcore.Simple.FULL.textureWidth(), VanillaTextures.HUD.Heart.Hardcore.Simple.FULL.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.HUD.Heart.Hardcore.Simple.HALF.id(),
                                65, 80,
                                VanillaTextures.HUD.Heart.Hardcore.Simple.HALF.u(), VanillaTextures.HUD.Heart.Hardcore.Simple.HALF.v(),
                                VanillaTextures.HUD.Heart.Hardcore.Simple.HALF.width(), VanillaTextures.HUD.Heart.Hardcore.Simple.HALF.height(),
                                VanillaTextures.HUD.Heart.Hardcore.Simple.HALF.textureWidth(), VanillaTextures.HUD.Heart.Hardcore.Simple.HALF.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.HUD.Heart.Hardcore.Simple.POISONED_FULL.id(),
                                75, 80,
                                VanillaTextures.HUD.Heart.Hardcore.Simple.POISONED_FULL.u(), VanillaTextures.HUD.Heart.Hardcore.Simple.POISONED_FULL.v(),
                                VanillaTextures.HUD.Heart.Hardcore.Simple.POISONED_FULL.width(), VanillaTextures.HUD.Heart.Hardcore.Simple.POISONED_FULL.height(),
                                VanillaTextures.HUD.Heart.Hardcore.Simple.POISONED_FULL.textureWidth(), VanillaTextures.HUD.Heart.Hardcore.Simple.POISONED_FULL.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.HUD.Heart.Hardcore.Simple.POISONED_HALF.id(),
                                85, 80,
                                VanillaTextures.HUD.Heart.Hardcore.Simple.POISONED_HALF.u(), VanillaTextures.HUD.Heart.Hardcore.Simple.POISONED_HALF.v(),
                                VanillaTextures.HUD.Heart.Hardcore.Simple.POISONED_HALF.width(), VanillaTextures.HUD.Heart.Hardcore.Simple.POISONED_HALF.height(),
                                VanillaTextures.HUD.Heart.Hardcore.Simple.POISONED_HALF.textureWidth(), VanillaTextures.HUD.Heart.Hardcore.Simple.POISONED_HALF.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.HUD.Heart.Hardcore.Simple.WITHERED_FULL.id(),
                                95, 80,
                                VanillaTextures.HUD.Heart.Hardcore.Simple.WITHERED_FULL.u(), VanillaTextures.HUD.Heart.Hardcore.Simple.WITHERED_FULL.v(),
                                VanillaTextures.HUD.Heart.Hardcore.Simple.WITHERED_FULL.width(), VanillaTextures.HUD.Heart.Hardcore.Simple.WITHERED_FULL.height(),
                                VanillaTextures.HUD.Heart.Hardcore.Simple.WITHERED_FULL.textureWidth(), VanillaTextures.HUD.Heart.Hardcore.Simple.WITHERED_FULL.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.HUD.Heart.Hardcore.Simple.WITHERED_HALF.id(),
                                105, 80,
                                VanillaTextures.HUD.Heart.Hardcore.Simple.WITHERED_HALF.u(), VanillaTextures.HUD.Heart.Hardcore.Simple.WITHERED_HALF.v(),
                                VanillaTextures.HUD.Heart.Hardcore.Simple.WITHERED_HALF.width(), VanillaTextures.HUD.Heart.Hardcore.Simple.WITHERED_HALF.height(),
                                VanillaTextures.HUD.Heart.Hardcore.Simple.WITHERED_HALF.textureWidth(), VanillaTextures.HUD.Heart.Hardcore.Simple.WITHERED_HALF.textureHeight());





        ScreenHelper.drawTexture(context, VanillaTextures.HUD.Heart.Hardcore.Blinking.ABSORBING_FULL.id(),
                                5, 90,
                                VanillaTextures.HUD.Heart.Hardcore.Blinking.ABSORBING_FULL.u(), VanillaTextures.HUD.Heart.Hardcore.Blinking.ABSORBING_FULL.v(),
                                VanillaTextures.HUD.Heart.Hardcore.Blinking.ABSORBING_FULL.width(), VanillaTextures.HUD.Heart.Hardcore.Blinking.ABSORBING_FULL.height(),
                                VanillaTextures.HUD.Heart.Hardcore.Blinking.ABSORBING_FULL.textureWidth(), VanillaTextures.HUD.Heart.Hardcore.Blinking.ABSORBING_FULL.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.HUD.Heart.Hardcore.Blinking.ABSORBING_HALF.id(),
                                15, 90,
                                VanillaTextures.HUD.Heart.Hardcore.Blinking.ABSORBING_HALF.u(), VanillaTextures.HUD.Heart.Hardcore.Blinking.ABSORBING_HALF.v(),
                                VanillaTextures.HUD.Heart.Hardcore.Blinking.ABSORBING_HALF.width(), VanillaTextures.HUD.Heart.Hardcore.Blinking.ABSORBING_HALF.height(),
                                VanillaTextures.HUD.Heart.Hardcore.Blinking.ABSORBING_HALF.textureWidth(), VanillaTextures.HUD.Heart.Hardcore.Blinking.ABSORBING_HALF.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.HUD.Heart.Hardcore.Blinking.CONTAINER.id(),
                                25, 90,
                                VanillaTextures.HUD.Heart.Hardcore.Blinking.CONTAINER.u(), VanillaTextures.HUD.Heart.Hardcore.Blinking.CONTAINER.v(),
                                VanillaTextures.HUD.Heart.Hardcore.Blinking.CONTAINER.width(), VanillaTextures.HUD.Heart.Hardcore.Blinking.CONTAINER.height(),
                                VanillaTextures.HUD.Heart.Hardcore.Blinking.CONTAINER.textureWidth(), VanillaTextures.HUD.Heart.Hardcore.Blinking.CONTAINER.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.HUD.Heart.Hardcore.Blinking.FROZEN_FULL.id(),
                                35, 90,
                                VanillaTextures.HUD.Heart.Hardcore.Blinking.FROZEN_FULL.u(), VanillaTextures.HUD.Heart.Hardcore.Blinking.FROZEN_FULL.v(),
                                VanillaTextures.HUD.Heart.Hardcore.Blinking.FROZEN_FULL.width(), VanillaTextures.HUD.Heart.Hardcore.Blinking.FROZEN_FULL.height(),
                                VanillaTextures.HUD.Heart.Hardcore.Blinking.FROZEN_FULL.textureWidth(), VanillaTextures.HUD.Heart.Hardcore.Blinking.FROZEN_FULL.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.HUD.Heart.Hardcore.Blinking.FROZEN_HALF.id(),
                                45, 90,
                                VanillaTextures.HUD.Heart.Hardcore.Blinking.FROZEN_HALF.u(), VanillaTextures.HUD.Heart.Hardcore.Blinking.FROZEN_HALF.v(),
                                VanillaTextures.HUD.Heart.Hardcore.Blinking.FROZEN_HALF.width(), VanillaTextures.HUD.Heart.Hardcore.Blinking.FROZEN_HALF.height(),
                                VanillaTextures.HUD.Heart.Hardcore.Blinking.FROZEN_HALF.textureWidth(), VanillaTextures.HUD.Heart.Hardcore.Blinking.FROZEN_HALF.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.HUD.Heart.Hardcore.Blinking.FULL.id(),
                                55, 90,
                                VanillaTextures.HUD.Heart.Hardcore.Blinking.FULL.u(), VanillaTextures.HUD.Heart.Hardcore.Blinking.FULL.v(),
                                VanillaTextures.HUD.Heart.Hardcore.Blinking.FULL.width(), VanillaTextures.HUD.Heart.Hardcore.Blinking.FULL.height(),
                                VanillaTextures.HUD.Heart.Hardcore.Blinking.FULL.textureWidth(), VanillaTextures.HUD.Heart.Hardcore.Blinking.FULL.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.HUD.Heart.Hardcore.Blinking.HALF.id(),
                                65, 90,
                                VanillaTextures.HUD.Heart.Hardcore.Blinking.HALF.u(), VanillaTextures.HUD.Heart.Hardcore.Blinking.HALF.v(),
                                VanillaTextures.HUD.Heart.Hardcore.Blinking.HALF.width(), VanillaTextures.HUD.Heart.Hardcore.Blinking.HALF.height(),
                                VanillaTextures.HUD.Heart.Hardcore.Blinking.HALF.textureWidth(), VanillaTextures.HUD.Heart.Hardcore.Blinking.HALF.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.HUD.Heart.Hardcore.Blinking.POISONED_FULL.id(),
                                75, 90,
                                VanillaTextures.HUD.Heart.Hardcore.Blinking.POISONED_FULL.u(), VanillaTextures.HUD.Heart.Hardcore.Blinking.POISONED_FULL.v(),
                                VanillaTextures.HUD.Heart.Hardcore.Blinking.POISONED_FULL.width(), VanillaTextures.HUD.Heart.Hardcore.Blinking.POISONED_FULL.height(),
                                VanillaTextures.HUD.Heart.Hardcore.Blinking.POISONED_FULL.textureWidth(), VanillaTextures.HUD.Heart.Hardcore.Blinking.POISONED_FULL.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.HUD.Heart.Hardcore.Blinking.POISONED_HALF.id(),
                                85, 90,
                                VanillaTextures.HUD.Heart.Hardcore.Blinking.POISONED_HALF.u(), VanillaTextures.HUD.Heart.Hardcore.Blinking.POISONED_HALF.v(),
                                VanillaTextures.HUD.Heart.Hardcore.Blinking.POISONED_HALF.width(), VanillaTextures.HUD.Heart.Hardcore.Blinking.POISONED_HALF.height(),
                                VanillaTextures.HUD.Heart.Hardcore.Blinking.POISONED_HALF.textureWidth(), VanillaTextures.HUD.Heart.Hardcore.Blinking.POISONED_HALF.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.HUD.Heart.Hardcore.Blinking.WITHERED_FULL.id(),
                                95, 90,
                                VanillaTextures.HUD.Heart.Hardcore.Blinking.WITHERED_FULL.u(), VanillaTextures.HUD.Heart.Hardcore.Blinking.WITHERED_FULL.v(),
                                VanillaTextures.HUD.Heart.Hardcore.Blinking.WITHERED_FULL.width(), VanillaTextures.HUD.Heart.Hardcore.Blinking.WITHERED_FULL.height(),
                                VanillaTextures.HUD.Heart.Hardcore.Blinking.WITHERED_FULL.textureWidth(), VanillaTextures.HUD.Heart.Hardcore.Blinking.WITHERED_FULL.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.HUD.Heart.Hardcore.Blinking.WITHERED_HALF.id(),
                                105, 90,
                                VanillaTextures.HUD.Heart.Hardcore.Blinking.WITHERED_HALF.u(), VanillaTextures.HUD.Heart.Hardcore.Blinking.WITHERED_HALF.v(),
                                VanillaTextures.HUD.Heart.Hardcore.Blinking.WITHERED_HALF.width(), VanillaTextures.HUD.Heart.Hardcore.Blinking.WITHERED_HALF.height(),
                                VanillaTextures.HUD.Heart.Hardcore.Blinking.WITHERED_HALF.textureWidth(), VanillaTextures.HUD.Heart.Hardcore.Blinking.WITHERED_HALF.textureHeight());
        //endregion

        //region VEHICLE HEART
        ScreenHelper.drawTexture(context, VanillaTextures.HUD.Heart.Vehicle.VEHICLE_CONTAINER.id(),
                                5, 100,
                                VanillaTextures.HUD.Heart.Vehicle.VEHICLE_CONTAINER.u(), VanillaTextures.HUD.Heart.Vehicle.VEHICLE_CONTAINER.v(),
                                VanillaTextures.HUD.Heart.Vehicle.VEHICLE_CONTAINER.width(), VanillaTextures.HUD.Heart.Vehicle.VEHICLE_CONTAINER.height(),
                                VanillaTextures.HUD.Heart.Vehicle.VEHICLE_CONTAINER.textureWidth(), VanillaTextures.HUD.Heart.Vehicle.VEHICLE_CONTAINER.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.HUD.Heart.Vehicle.VEHICLE_FULL.id(),
                                15, 100,
                                VanillaTextures.HUD.Heart.Vehicle.VEHICLE_FULL.u(), VanillaTextures.HUD.Heart.Vehicle.VEHICLE_FULL.v(),
                                VanillaTextures.HUD.Heart.Vehicle.VEHICLE_FULL.width(), VanillaTextures.HUD.Heart.Vehicle.VEHICLE_FULL.height(),
                                VanillaTextures.HUD.Heart.Vehicle.VEHICLE_FULL.textureWidth(), VanillaTextures.HUD.Heart.Vehicle.VEHICLE_FULL.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.HUD.Heart.Vehicle.VEHICLE_HALF.id(),
                                25, 100,
                                VanillaTextures.HUD.Heart.Vehicle.VEHICLE_HALF.u(), VanillaTextures.HUD.Heart.Vehicle.VEHICLE_HALF.v(),
                                VanillaTextures.HUD.Heart.Vehicle.VEHICLE_HALF.width(), VanillaTextures.HUD.Heart.Vehicle.VEHICLE_HALF.height(),
                                VanillaTextures.HUD.Heart.Vehicle.VEHICLE_HALF.textureWidth(), VanillaTextures.HUD.Heart.Vehicle.VEHICLE_HALF.textureHeight());
        //endregion

        ScreenHelper.drawTexture(context, VanillaTextures.HUD.Screen.Hotbar.ATTACK_BACKGROUND.id(),
                                5, 110,
                                VanillaTextures.HUD.Screen.Hotbar.ATTACK_BACKGROUND.u(), VanillaTextures.HUD.Screen.Hotbar.ATTACK_BACKGROUND.v(),
                                VanillaTextures.HUD.Screen.Hotbar.ATTACK_BACKGROUND.width(), VanillaTextures.HUD.Screen.Hotbar.ATTACK_BACKGROUND.height(),
                                VanillaTextures.HUD.Screen.Hotbar.ATTACK_BACKGROUND.textureWidth(), VanillaTextures.HUD.Screen.Hotbar.ATTACK_BACKGROUND.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.HUD.Screen.Hotbar.ATTACK_PROGRESS.id(),
                                25, 110,
                                VanillaTextures.HUD.Screen.Hotbar.ATTACK_PROGRESS.u(), VanillaTextures.HUD.Screen.Hotbar.ATTACK_PROGRESS.v(),
                                VanillaTextures.HUD.Screen.Hotbar.ATTACK_PROGRESS.width(), VanillaTextures.HUD.Screen.Hotbar.ATTACK_PROGRESS.height(),
                                VanillaTextures.HUD.Screen.Hotbar.ATTACK_PROGRESS.textureWidth(), VanillaTextures.HUD.Screen.Hotbar.ATTACK_PROGRESS.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.HUD.Screen.Hotbar.OFFHAND_LEFT.id(),
                                45, 110,
                                VanillaTextures.HUD.Screen.Hotbar.OFFHAND_LEFT.u(), VanillaTextures.HUD.Screen.Hotbar.OFFHAND_LEFT.v(),
                                VanillaTextures.HUD.Screen.Hotbar.OFFHAND_LEFT.width(), VanillaTextures.HUD.Screen.Hotbar.OFFHAND_LEFT.height(),
                                VanillaTextures.HUD.Screen.Hotbar.OFFHAND_LEFT.textureWidth(), VanillaTextures.HUD.Screen.Hotbar.OFFHAND_LEFT.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.HUD.Screen.Hotbar.SELECTION.id(),
                                69, 110,
                                VanillaTextures.HUD.Screen.Hotbar.SELECTION.u(), VanillaTextures.HUD.Screen.Hotbar.SELECTION.v(),
                                VanillaTextures.HUD.Screen.Hotbar.SELECTION.width(), VanillaTextures.HUD.Screen.Hotbar.SELECTION.height(),
                                VanillaTextures.HUD.Screen.Hotbar.SELECTION.textureWidth(), VanillaTextures.HUD.Screen.Hotbar.SELECTION.textureHeight());
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float deltaTicks)
    {
        super.render(context, mouseX, mouseY, deltaTicks);

        //ScreenHelper.drawTexture(context, TEXTURE, this.x + 83, this.y + 34, 184, 0, 16, 51); // DRAWING FLUID MARKERS
    }
}