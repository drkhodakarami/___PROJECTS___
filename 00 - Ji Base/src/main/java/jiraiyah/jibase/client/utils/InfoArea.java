package jiraiyah.jibase.client.utils;

import jiraiyah.jibase.annotations.*;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.Rect2i;

@Developer("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/drkhodakarami/___PROJECTS___")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")

public class InfoArea extends DrawContext
{
    protected final Rect2i area;

    public InfoArea(MinecraftClient client, VertexConsumerProvider.Immediate vertexConsumers)
    {
        super(client, vertexConsumers);
        this.area = new Rect2i(0, 0, 0, 0);
    }

    public InfoArea(MinecraftClient client, VertexConsumerProvider.Immediate vertexConsumers, Rect2i area)
    {
        super(client, vertexConsumers);
        this.area = area;
    }

    public void draw(DrawContext context)
    {}

    public boolean isMouseOver(double mouseX, double mouseY)
    {
        return MouseHelper.isMouseOver(mouseX, mouseY, this.area);
    }
}