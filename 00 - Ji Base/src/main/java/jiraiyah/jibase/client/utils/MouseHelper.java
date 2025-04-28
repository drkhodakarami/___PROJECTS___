package jiraiyah.jibase.client.utils;

import jiraiyah.jibase.annotations.*;
import jiraiyah.jibase.exceptions.Exceptions;
import net.minecraft.client.util.math.Rect2i;

@Developer("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/drkhodakarami/___PROJECTS___")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")

public class MouseHelper
{
    public MouseHelper()
    {
        Exceptions.throwCtorAssertion();
    }

    public static boolean isMouseOver(double mouseX, double mouseY, int x, int y, int width, int height, int offsetX, int offsetY)
    {
        return mouseX >= x + offsetX &&
               mouseX <= x + offsetX + width &&
               mouseY >= y + offsetY &&
               mouseY <= y + offsetY + height;
    }

    public static boolean isMouseOver(double mouseX, double mouseY, int x, int y)
    {
        return isMouseOver(mouseX, mouseY, x, y, 16, 16, 0, 0);
    }

    public static boolean isMouseOver(double mouseX, double mouseY, int x, int y, int size)
    {
        return isMouseOver(mouseX, mouseY, x, y, size, size, 0, 0);
    }

    public static boolean isMouseOver(double mouseX, double mouseY, int x, int y, int width, int height)
    {
        return isMouseOver(mouseX, mouseY, x, y, width, height, 0, 0);
    }

    public static boolean isMouseOver(double mouseX, double mouseY, Rect2i rect)
    {
        return isMouseOver(mouseX, mouseY, rect.getX(), rect.getY(), rect.getWidth(), rect.getWidth());
    }
}