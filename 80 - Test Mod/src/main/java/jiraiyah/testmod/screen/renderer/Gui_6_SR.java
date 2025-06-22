package jiraiyah.testmod.screen.renderer;

import jiraiyah.jigui.client.constants.ContainerBaseTextures;
import jiraiyah.jigui.client.constants.VanillaTextures;
import jiraiyah.jigui.client.utils.ScreenHelper;
import jiraiyah.testmod.screen.handler.Gui_6_SH;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;

public class Gui_6_SR extends HandledScreen<Gui_6_SH>
{
    public Gui_6_SR(Gui_6_SH handler, PlayerInventory inventory, Text title)
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

        //region BUTTON
        ScreenHelper.drawTexture(context, VanillaTextures.Container.Button.NORMAL.id(),
                                5, 5,
                                VanillaTextures.Container.Button.NORMAL.u(), VanillaTextures.Container.Button.NORMAL.v(),
                                VanillaTextures.Container.Button.NORMAL.width(), VanillaTextures.Container.Button.NORMAL.height(),
                                VanillaTextures.Container.Button.NORMAL.textureWidth(), VanillaTextures.Container.Button.NORMAL.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Container.Button.HIGHLIGHTED.id(),
                                28, 5,
                                VanillaTextures.Container.Button.HIGHLIGHTED.u(), VanillaTextures.Container.Button.HIGHLIGHTED.v(),
                                VanillaTextures.Container.Button.HIGHLIGHTED.width(), VanillaTextures.Container.Button.HIGHLIGHTED.height(),
                                VanillaTextures.Container.Button.HIGHLIGHTED.textureWidth(), VanillaTextures.Container.Button.HIGHLIGHTED.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Container.Button.SELECTED.id(),
                                51, 5,
                                VanillaTextures.Container.Button.SELECTED.u(), VanillaTextures.Container.Button.SELECTED.v(),
                                VanillaTextures.Container.Button.SELECTED.width(), VanillaTextures.Container.Button.SELECTED.height(),
                                VanillaTextures.Container.Button.SELECTED.textureWidth(), VanillaTextures.Container.Button.SELECTED.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Container.Button.DISABLED.id(),
                                74, 5,
                                VanillaTextures.Container.Button.DISABLED.u(), VanillaTextures.Container.Button.DISABLED.v(),
                                VanillaTextures.Container.Button.DISABLED.width(), VanillaTextures.Container.Button.DISABLED.height(),
                                VanillaTextures.Container.Button.DISABLED.textureWidth(), VanillaTextures.Container.Button.DISABLED.textureHeight());
        //endregion

        //region EFFECTS
        ScreenHelper.drawTexture(context, VanillaTextures.Effect.Background.LARGE.id(),
                                5, 30,
                                VanillaTextures.Effect.Background.LARGE.u(), VanillaTextures.Effect.Background.LARGE.v(),
                                VanillaTextures.Effect.Background.LARGE.width(), VanillaTextures.Effect.Background.LARGE.height(),
                                VanillaTextures.Effect.Background.LARGE.textureWidth(), VanillaTextures.Effect.Background.LARGE.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Effect.Background.SMALL.id(),
                                127, 30,
                                VanillaTextures.Effect.Background.SMALL.u(), VanillaTextures.Effect.Background.SMALL.v(),
                                VanillaTextures.Effect.Background.SMALL.width(), VanillaTextures.Effect.Background.SMALL.height(),
                                VanillaTextures.Effect.Background.SMALL.textureWidth(), VanillaTextures.Effect.Background.SMALL.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Effect.Icon.ABSORPTION.id(),
                                5, 65,
                                VanillaTextures.Effect.Icon.ABSORPTION.u(), VanillaTextures.Effect.Icon.ABSORPTION.v(),
                                VanillaTextures.Effect.Icon.ABSORPTION.width(), VanillaTextures.Effect.Icon.ABSORPTION.height(),
                                VanillaTextures.Effect.Icon.ABSORPTION.textureWidth(), VanillaTextures.Effect.Icon.ABSORPTION.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Effect.Icon.BAD_OMEN.id(),
                                25, 65,
                                VanillaTextures.Effect.Icon.BAD_OMEN.u(), VanillaTextures.Effect.Icon.BAD_OMEN.v(),
                                VanillaTextures.Effect.Icon.BAD_OMEN.width(), VanillaTextures.Effect.Icon.BAD_OMEN.height(),
                                VanillaTextures.Effect.Icon.BAD_OMEN.textureWidth(), VanillaTextures.Effect.Icon.BAD_OMEN.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Effect.Icon.BLINDNESS.id(),
                                45, 65,
                                VanillaTextures.Effect.Icon.BLINDNESS.u(), VanillaTextures.Effect.Icon.BLINDNESS.v(),
                                VanillaTextures.Effect.Icon.BLINDNESS.width(), VanillaTextures.Effect.Icon.BLINDNESS.height(),
                                VanillaTextures.Effect.Icon.BLINDNESS.textureWidth(), VanillaTextures.Effect.Icon.BLINDNESS.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Effect.Icon.CONDUIT_POWER.id(),
                                65, 65,
                                VanillaTextures.Effect.Icon.CONDUIT_POWER.u(), VanillaTextures.Effect.Icon.CONDUIT_POWER.v(),
                                VanillaTextures.Effect.Icon.CONDUIT_POWER.width(), VanillaTextures.Effect.Icon.CONDUIT_POWER.height(),
                                VanillaTextures.Effect.Icon.CONDUIT_POWER.textureWidth(), VanillaTextures.Effect.Icon.CONDUIT_POWER.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Effect.Icon.DARKNESS.id(),
                                85, 65,
                                VanillaTextures.Effect.Icon.DARKNESS.u(), VanillaTextures.Effect.Icon.DARKNESS.v(),
                                VanillaTextures.Effect.Icon.DARKNESS.width(), VanillaTextures.Effect.Icon.DARKNESS.height(),
                                VanillaTextures.Effect.Icon.DARKNESS.textureWidth(), VanillaTextures.Effect.Icon.DARKNESS.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Effect.Icon.DOLPHINS_GRACE.id(),
                                105, 65,
                                VanillaTextures.Effect.Icon.DOLPHINS_GRACE.u(), VanillaTextures.Effect.Icon.DOLPHINS_GRACE.v(),
                                VanillaTextures.Effect.Icon.DOLPHINS_GRACE.width(), VanillaTextures.Effect.Icon.DOLPHINS_GRACE.height(),
                                VanillaTextures.Effect.Icon.DOLPHINS_GRACE.textureWidth(), VanillaTextures.Effect.Icon.DOLPHINS_GRACE.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Effect.Icon.FIRE_RESISTANCE.id(),
                                125, 65,
                                VanillaTextures.Effect.Icon.FIRE_RESISTANCE.u(), VanillaTextures.Effect.Icon.FIRE_RESISTANCE.v(),
                                VanillaTextures.Effect.Icon.FIRE_RESISTANCE.width(), VanillaTextures.Effect.Icon.FIRE_RESISTANCE.height(),
                                VanillaTextures.Effect.Icon.FIRE_RESISTANCE.textureWidth(), VanillaTextures.Effect.Icon.FIRE_RESISTANCE.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Effect.Icon.GLOWING.id(),
                                145, 65,
                                VanillaTextures.Effect.Icon.GLOWING.u(), VanillaTextures.Effect.Icon.GLOWING.v(),
                                VanillaTextures.Effect.Icon.GLOWING.width(), VanillaTextures.Effect.Icon.GLOWING.height(),
                                VanillaTextures.Effect.Icon.GLOWING.textureWidth(), VanillaTextures.Effect.Icon.GLOWING.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Effect.Icon.HASTE.id(),
                                5, 85,
                                VanillaTextures.Effect.Icon.HASTE.u(), VanillaTextures.Effect.Icon.HASTE.v(),
                                VanillaTextures.Effect.Icon.HASTE.width(), VanillaTextures.Effect.Icon.HASTE.height(),
                                VanillaTextures.Effect.Icon.HASTE.textureWidth(), VanillaTextures.Effect.Icon.HASTE.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Effect.Icon.HEART_BOOST.id(),
                                25, 85,
                                VanillaTextures.Effect.Icon.HEART_BOOST.u(), VanillaTextures.Effect.Icon.HEART_BOOST.v(),
                                VanillaTextures.Effect.Icon.HEART_BOOST.width(), VanillaTextures.Effect.Icon.HEART_BOOST.height(),
                                VanillaTextures.Effect.Icon.HEART_BOOST.textureWidth(), VanillaTextures.Effect.Icon.HEART_BOOST.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Effect.Icon.HERO_OF_THE_VILLAGE.id(),
                                45, 85,
                                VanillaTextures.Effect.Icon.HERO_OF_THE_VILLAGE.u(), VanillaTextures.Effect.Icon.HERO_OF_THE_VILLAGE.v(),
                                VanillaTextures.Effect.Icon.HERO_OF_THE_VILLAGE.width(), VanillaTextures.Effect.Icon.HERO_OF_THE_VILLAGE.height(),
                                VanillaTextures.Effect.Icon.HERO_OF_THE_VILLAGE.textureWidth(), VanillaTextures.Effect.Icon.HERO_OF_THE_VILLAGE.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Effect.Icon.HUNGER.id(),
                                65, 85,
                                VanillaTextures.Effect.Icon.HUNGER.u(), VanillaTextures.Effect.Icon.HUNGER.v(),
                                VanillaTextures.Effect.Icon.HUNGER.width(), VanillaTextures.Effect.Icon.HUNGER.height(),
                                VanillaTextures.Effect.Icon.HUNGER.textureWidth(), VanillaTextures.Effect.Icon.HUNGER.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Effect.Icon.INFESTED.id(),
                                85, 85,
                                VanillaTextures.Effect.Icon.INFESTED.u(), VanillaTextures.Effect.Icon.INFESTED.v(),
                                VanillaTextures.Effect.Icon.INFESTED.width(), VanillaTextures.Effect.Icon.INFESTED.height(),
                                VanillaTextures.Effect.Icon.INFESTED.textureWidth(), VanillaTextures.Effect.Icon.INFESTED.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Effect.Icon.INSTANT_DAMAGE.id(),
                                105, 85,
                                VanillaTextures.Effect.Icon.INSTANT_DAMAGE.u(), VanillaTextures.Effect.Icon.INSTANT_DAMAGE.v(),
                                VanillaTextures.Effect.Icon.INSTANT_DAMAGE.width(), VanillaTextures.Effect.Icon.INSTANT_DAMAGE.height(),
                                VanillaTextures.Effect.Icon.INSTANT_DAMAGE.textureWidth(), VanillaTextures.Effect.Icon.INSTANT_DAMAGE.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Effect.Icon.INSTANT_HEALTH.id(),
                                125, 85,
                                VanillaTextures.Effect.Icon.INSTANT_HEALTH.u(), VanillaTextures.Effect.Icon.INSTANT_HEALTH.v(),
                                VanillaTextures.Effect.Icon.INSTANT_HEALTH.width(), VanillaTextures.Effect.Icon.INSTANT_HEALTH.height(),
                                VanillaTextures.Effect.Icon.INSTANT_HEALTH.textureWidth(), VanillaTextures.Effect.Icon.INSTANT_HEALTH.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Effect.Icon.INVISIBILITY.id(),
                                145, 85,
                                VanillaTextures.Effect.Icon.INVISIBILITY.u(), VanillaTextures.Effect.Icon.INVISIBILITY.v(),
                                VanillaTextures.Effect.Icon.INVISIBILITY.width(), VanillaTextures.Effect.Icon.INVISIBILITY.height(),
                                VanillaTextures.Effect.Icon.INVISIBILITY.textureWidth(), VanillaTextures.Effect.Icon.INVISIBILITY.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Effect.Icon.JUMP_BOOST.id(),
                                5, 105,
                                VanillaTextures.Effect.Icon.JUMP_BOOST.u(), VanillaTextures.Effect.Icon.JUMP_BOOST.v(),
                                VanillaTextures.Effect.Icon.JUMP_BOOST.width(), VanillaTextures.Effect.Icon.JUMP_BOOST.height(),
                                VanillaTextures.Effect.Icon.JUMP_BOOST.textureWidth(), VanillaTextures.Effect.Icon.JUMP_BOOST.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Effect.Icon.LEVITATION.id(),
                                25, 105,
                                VanillaTextures.Effect.Icon.LEVITATION.u(), VanillaTextures.Effect.Icon.LEVITATION.v(),
                                VanillaTextures.Effect.Icon.LEVITATION.width(), VanillaTextures.Effect.Icon.LEVITATION.height(),
                                VanillaTextures.Effect.Icon.LEVITATION.textureWidth(), VanillaTextures.Effect.Icon.LEVITATION.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Effect.Icon.LUCK.id(),
                                45, 105,
                                VanillaTextures.Effect.Icon.LUCK.u(), VanillaTextures.Effect.Icon.LUCK.v(),
                                VanillaTextures.Effect.Icon.LUCK.width(), VanillaTextures.Effect.Icon.LUCK.height(),
                                VanillaTextures.Effect.Icon.LUCK.textureWidth(), VanillaTextures.Effect.Icon.LUCK.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Effect.Icon.MINING_FATIGUE.id(),
                                65, 105,
                                VanillaTextures.Effect.Icon.MINING_FATIGUE.u(), VanillaTextures.Effect.Icon.MINING_FATIGUE.v(),
                                VanillaTextures.Effect.Icon.MINING_FATIGUE.width(), VanillaTextures.Effect.Icon.MINING_FATIGUE.height(),
                                VanillaTextures.Effect.Icon.MINING_FATIGUE.textureWidth(), VanillaTextures.Effect.Icon.MINING_FATIGUE.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Effect.Icon.NAUSEA.id(),
                                85, 105,
                                VanillaTextures.Effect.Icon.NAUSEA.u(), VanillaTextures.Effect.Icon.NAUSEA.v(),
                                VanillaTextures.Effect.Icon.NAUSEA.width(), VanillaTextures.Effect.Icon.NAUSEA.height(),
                                VanillaTextures.Effect.Icon.NAUSEA.textureWidth(), VanillaTextures.Effect.Icon.NAUSEA.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Effect.Icon.NIGHT_VISION.id(),
                                105, 105,
                                VanillaTextures.Effect.Icon.NIGHT_VISION.u(), VanillaTextures.Effect.Icon.NIGHT_VISION.v(),
                                VanillaTextures.Effect.Icon.NIGHT_VISION.width(), VanillaTextures.Effect.Icon.NIGHT_VISION.height(),
                                VanillaTextures.Effect.Icon.NIGHT_VISION.textureWidth(), VanillaTextures.Effect.Icon.NIGHT_VISION.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Effect.Icon.OOZING.id(),
                                125, 105,
                                VanillaTextures.Effect.Icon.OOZING.u(), VanillaTextures.Effect.Icon.OOZING.v(),
                                VanillaTextures.Effect.Icon.OOZING.width(), VanillaTextures.Effect.Icon.OOZING.height(),
                                VanillaTextures.Effect.Icon.OOZING.textureWidth(), VanillaTextures.Effect.Icon.OOZING.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Effect.Icon.POISON.id(),
                                145, 105,
                                VanillaTextures.Effect.Icon.POISON.u(), VanillaTextures.Effect.Icon.POISON.v(),
                                VanillaTextures.Effect.Icon.POISON.width(), VanillaTextures.Effect.Icon.POISON.height(),
                                VanillaTextures.Effect.Icon.POISON.textureWidth(), VanillaTextures.Effect.Icon.POISON.textureHeight());
        //endregion

        //region PING
        ScreenHelper.drawTexture(context, VanillaTextures.Icon.Ping.PING_1.id(),
                                100, 5,
                                VanillaTextures.Icon.Ping.PING_1.u(), VanillaTextures.Icon.Ping.PING_1.v(),
                                VanillaTextures.Icon.Ping.PING_1.width(), VanillaTextures.Icon.Ping.PING_1.height(),
                                VanillaTextures.Icon.Ping.PING_1.textureWidth(), VanillaTextures.Icon.Ping.PING_1.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Icon.Ping.PING_2.id(),
                                112, 5,
                                VanillaTextures.Icon.Ping.PING_2.u(), VanillaTextures.Icon.Ping.PING_2.v(),
                                VanillaTextures.Icon.Ping.PING_2.width(), VanillaTextures.Icon.Ping.PING_2.height(),
                                VanillaTextures.Icon.Ping.PING_2.textureWidth(), VanillaTextures.Icon.Ping.PING_2.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Icon.Ping.PING_3.id(),
                                124, 5,
                                VanillaTextures.Icon.Ping.PING_3.u(), VanillaTextures.Icon.Ping.PING_3.v(),
                                VanillaTextures.Icon.Ping.PING_3.width(), VanillaTextures.Icon.Ping.PING_3.height(),
                                VanillaTextures.Icon.Ping.PING_3.textureWidth(), VanillaTextures.Icon.Ping.PING_3.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Icon.Ping.PING_4.id(),
                                136, 5,
                                VanillaTextures.Icon.Ping.PING_4.u(), VanillaTextures.Icon.Ping.PING_4.v(),
                                VanillaTextures.Icon.Ping.PING_4.width(), VanillaTextures.Icon.Ping.PING_4.height(),
                                VanillaTextures.Icon.Ping.PING_4.textureWidth(), VanillaTextures.Icon.Ping.PING_4.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Icon.Ping.PING_5.id(),
                                148, 5,
                                VanillaTextures.Icon.Ping.PING_5.u(), VanillaTextures.Icon.Ping.PING_5.v(),
                                VanillaTextures.Icon.Ping.PING_5.width(), VanillaTextures.Icon.Ping.PING_5.height(),
                                VanillaTextures.Icon.Ping.PING_5.textureWidth(), VanillaTextures.Icon.Ping.PING_5.textureHeight());



        ScreenHelper.drawTexture(context, VanillaTextures.Icon.Ping.PINGING_1.id(),
                                100, 15,
                                VanillaTextures.Icon.Ping.PINGING_1.u(), VanillaTextures.Icon.Ping.PINGING_1.v(),
                                VanillaTextures.Icon.Ping.PINGING_1.width(), VanillaTextures.Icon.Ping.PINGING_1.height(),
                                VanillaTextures.Icon.Ping.PINGING_1.textureWidth(), VanillaTextures.Icon.Ping.PINGING_1.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Icon.Ping.PINGING_2.id(),
                                112, 15,
                                VanillaTextures.Icon.Ping.PINGING_2.u(), VanillaTextures.Icon.Ping.PINGING_2.v(),
                                VanillaTextures.Icon.Ping.PINGING_2.width(), VanillaTextures.Icon.Ping.PINGING_2.height(),
                                VanillaTextures.Icon.Ping.PINGING_2.textureWidth(), VanillaTextures.Icon.Ping.PINGING_2.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Icon.Ping.PINGING_3.id(),
                                124, 15,
                                VanillaTextures.Icon.Ping.PINGING_3.u(), VanillaTextures.Icon.Ping.PINGING_3.v(),
                                VanillaTextures.Icon.Ping.PINGING_3.width(), VanillaTextures.Icon.Ping.PINGING_3.height(),
                                VanillaTextures.Icon.Ping.PINGING_3.textureWidth(), VanillaTextures.Icon.Ping.PINGING_3.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Icon.Ping.PINGING_4.id(),
                                136, 15,
                                VanillaTextures.Icon.Ping.PINGING_4.u(), VanillaTextures.Icon.Ping.PINGING_4.v(),
                                VanillaTextures.Icon.Ping.PINGING_4.width(), VanillaTextures.Icon.Ping.PINGING_4.height(),
                                VanillaTextures.Icon.Ping.PINGING_4.textureWidth(), VanillaTextures.Icon.Ping.PINGING_4.textureHeight());

        ScreenHelper.drawTexture(context, VanillaTextures.Icon.Ping.PINGING_5.id(),
                                148, 15,
                                VanillaTextures.Icon.Ping.PINGING_5.u(), VanillaTextures.Icon.Ping.PINGING_5.v(),
                                VanillaTextures.Icon.Ping.PINGING_5.width(), VanillaTextures.Icon.Ping.PINGING_5.height(),
                                VanillaTextures.Icon.Ping.PINGING_5.textureWidth(), VanillaTextures.Icon.Ping.PINGING_5.textureHeight());
        //endregion
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float deltaTicks)
    {
        super.render(context, mouseX, mouseY, deltaTicks);

        //ScreenHelper.drawTexture(context, TEXTURE, this.x + 83, this.y + 34, 184, 0, 16, 51); // DRAWING FLUID MARKERS
    }
}