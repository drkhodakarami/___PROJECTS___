package jiraiyah.jibase.interfaces.client;

import jiraiyah.jibase.annotations.*;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.Item;
import net.minecraft.text.Text;

import java.util.List;

@Developer("TurtyWurty")
@ModifiedBy("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/DaRealTurtyWurty/Industria")
@Discord("https://discord.turtywurty.dev/")
@Youtube("https://www.youtube.com/@TurtyWurty")

public interface IIngredientRenderer<T>
{
    default void render(MatrixStack stack, T ingredient)
    {
        render(stack, 0, 0, ingredient);
    }

    default void render(MatrixStack stack, int x, int y, T ingredient)
    {}

    List<Text> tooltip(T ingredient, Item.TooltipContext tooltipContext, String modID);

    default TextRenderer fontRenderer(MinecraftClient client, T ingredient)
    {
        return client.textRenderer;
    }

    default int width()
    {
        return 16;
    }

    default int height()
    {
        return 16;
    }
}