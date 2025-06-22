/***********************************************************************************
 * Copyright (c) 2025 Alireza Khodakarami (Jiraiyah)                               *
 * ------------------------------------------------------------------------------- *
 * MIT License                                                                     *
 * =============================================================================== *
 * Permission is hereby granted, free of charge, to any person obtaining a copy    *
 * of this software and associated documentation files (the "Software"), to deal   *
 * in the Software without restriction, including without limitation the rights    *
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell       *
 * copies of the Software, and to permit persons to whom the Software is           *
 * furnished to do so, subject to the following conditions:                        *
 * ------------------------------------------------------------------------------- *
 * The above copyright notice and this permission notice shall be included in all  *
 * copies or substantial portions of the Software.                                 *
 * ------------------------------------------------------------------------------- *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR      *
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,        *
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE     *
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER          *
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,   *
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE   *
 * SOFTWARE.                                                                       *
 ***********************************************************************************/

package jiraiyah.jigui.utils;

import jiraiyah.jibase.annotations.*;
import jiraiyah.jigui.constants.ContainerBaseTextures;
import jiraiyah.jigui.constants.GuiColors;
import jiraiyah.jigui.interfaces.IDrawContextAccessor;
import jiraiyah.jigui.records.TextureData;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.texture.Sprite;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

import java.util.function.Function;

@SuppressWarnings("unused")
@Developer("TurtyWurty")
@ModifiedBy("Jiraiyah")
@CreatedAt("2025-04-23")
@Repository("https://github.com/DaRealTurtyWurty/Industria")
@Discord("https://discord.turtywurty.dev/")
@Youtube("https://www.youtube.com/@TurtyWurty")

public class ScreenHelper
{
    public static void drawTexture(DrawContext context, TextureData texture, int x, int y)
    {
        drawTexture(context, texture.id(), x + texture.x(), y + texture.y(), texture.u(), texture.v(), texture.textureWidth(), texture.height(), texture.textureWidth(), texture.textureHeight());
    }

    public static void drawTexture(DrawContext context, Identifier texture, int x, int y, float u, float v, int width, int height)
    {
        drawTexture(context, texture, x, y, u, v, width, height, 256, 256);
    }

    public static void drawTexture(DrawContext context, Identifier texture, int x, int y, float u, float v, int width, int height, int color)
    {
        drawTexture(context, texture, x, y, u, v, width, height, 256, 256, color);
    }

    public static void drawTexture(DrawContext context, Identifier texture, int x, int y, float u, float v, int width, int height, int texWidth, int texHeight)
    {
        drawTexture(context, texture, x, y, u, v, width, height, texWidth, texHeight, -1);
    }

    public static void drawTexture(DrawContext context, Identifier texture, int x, int y, float u, float v, int width, int height, int texWidth, int texHeight, int color)
    {
        context.drawTexture(RenderLayer::getGuiTextured, texture, x, y, u, v, width, height, texWidth, texHeight, color);
    }

    public static void drawTexture(DrawContext context, Identifier texture, int x, int y, int width, int height)
    {
        drawTexture(context, texture, x, y, width, height, -1);
    }

    public static void drawTexture(DrawContext context, Identifier texture, int x, int y, int width, int height, int color)
    {
        context.drawGuiTexture(RenderLayer::getGuiTextured, texture, x, y, width, height, color);
    }

    public static void renderTiledSprite(DrawContext context, Function<Identifier, RenderLayer> renderLayers, Sprite sprite, int x, int y, int width, int height, int color)
    {
        int spriteWidth = 16;
        int spriteHeight = 16;

        int xCount = MathHelper.floor((float) width / spriteWidth);
        int yCount = MathHelper.floor((float) height / spriteHeight);
        int xRemainder = width % spriteWidth;
        int yRemainder = height % spriteHeight;

        Identifier atlasId = sprite.getAtlasId();
        float minU = sprite.getMinU();
        float minV = sprite.getMinV();

        for (int i = 0; i < xCount; i++)
        {
            for (int j = 0; j < yCount; j++)
            {
                int x1 = x + i * spriteWidth;
                int y1 = y + j * spriteHeight;
                int x2 = x1 + spriteWidth;
                int y2 = y1 + spriteHeight;
                float maxU = sprite.getMaxU();
                float maxV = sprite.getMaxV();

                ((IDrawContextAccessor)context).drawQuad(renderLayers, atlasId, x1, x2, y1, y2, minU, maxU, minV, maxV, color);
            }

            if (yRemainder > 0)
            {
                int x1 = x + i * spriteWidth;
                int y1 = y + yCount * spriteHeight;
                int x2 = x1 + spriteWidth;
                int y2 = y1 + yRemainder;
                float maxU = sprite.getMaxU();
                float maxV = minV + (sprite.getMaxV() - sprite.getMinV()) * ((float) yRemainder / spriteHeight);
                ((IDrawContextAccessor)context).drawQuad(renderLayers, atlasId, x1, x2, y1, y2, minU, maxU, minV, maxV, color);
            }
        }

        if (xRemainder > 0)
        {
            for (int j = 0; j < yCount; j++)
            {
                int x1 = x + xCount * spriteWidth;
                int y1 = y + j * spriteHeight;
                int x2 = x1 + xRemainder;
                int y2 = y1 + spriteHeight;
                float maxU = minU + (sprite.getMaxU() - sprite.getMinU()) * ((float) xRemainder / spriteWidth);
                float maxV = sprite.getMaxV();
                ((IDrawContextAccessor)context).drawQuad(renderLayers, atlasId, x1, x2, y1, y2, minU, maxU, minV, maxV, color);
            }

            if (yRemainder > 0)
            {
                int x1 = x + xCount * spriteWidth;
                int y1 = y + yCount * spriteHeight;
                int x2 = x1 + xRemainder;
                int y2 = y1 + yRemainder;
                float maxU = minU + (sprite.getMaxU() - sprite.getMinU()) * ((float) xRemainder / spriteWidth);
                float maxV = minV + (sprite.getMaxV() - sprite.getMinV()) * ((float) yRemainder / spriteHeight);
                ((IDrawContextAccessor)context).drawQuad(renderLayers, atlasId, x1, x2, y1, y2, minU, maxU, minV, maxV, color);
            }
        }
    }

    public static void drawBackground(DrawContext context, int x, int y, int width, int height)
    {
        int startX, startY, endX, endY;

        //panel
        startX = x + 3;
        startY = y + 3;
        endX = startX + width - 6;
        endY = startY + height - 6;

        context.fill(startX, startY, endX, endY, GuiColors.Background.PANEL);

        //top border
        startX = x + 4;
        startY = y + 1;
        endX = startX + width - 7;
        endY = startY + 2;
        context.fill(startX, startY, endX, endY, GuiColors.Background.BORDER_HIGHLIGHT);

        startX = x + 4;
        startY = y;
        endX = startX + width - 7;
        endY = startY + 1;

        context.fill(startX, startY, endX, endY, 0xFF000000);

        //bottom border

        startX = x + 3;
        startY = y + height - 3;
        endX = startX + width - 6;
        endY = startY + 2;
        context.fill(startX, startY, endX, endY, GuiColors.Background.BORDER_SHADOW);

        startX = x + 3;
        startY = y + height - 1;
        endX = startX + width - 6;
        endY = startY + 1;

        context.fill(startX, startY, endX, endY, 0xFF000000);

        //right border

        startX = x + width - 3;
        startY = y + 2;
        endX = startX + 2;
        endY = startY + height - 6;
        context.fill(startX, startY, endX, endY, GuiColors.Background.BORDER_SHADOW);

        startX = x + width - 1;
        startY = y + 4;
        endX = startX + 1;
        endY = startY + height - 7;

        context.fill(startX, startY, endX, endY, 0xFF000000);

        //left border

        startX = x + 1;
        startY = y + 4;
        endX = startX + 2;
        endY = startY + height - 7;
        context.fill(startX, startY, endX, endY, GuiColors.Background.BORDER_HIGHLIGHT);

        startX = x;
        startY = y + 4;
        endX = startX + 1;
        endY = startY + height - 7;

        context.fill(startX, startY, endX, endY, 0xFF000000);

        //top left cornet
        ScreenHelper.drawTexture(context, ContainerBaseTextures.Background.Slice.TOP_LEFT.id(),
                                 x , y, 0, 0, 4, 4, 4, 4);

        //top right cornet
        ScreenHelper.drawTexture(context, ContainerBaseTextures.Background.Slice.TOP_RIGHT.id(),
                                x + width - 3, y, 0, 0, 4, 4, 4, 4);

        //bottom left cornet
        ScreenHelper.drawTexture(context, ContainerBaseTextures.Background.Slice.BOTTOM_LEFT.id(),
                                x - 1, y + height - 3, 0, 0, 4, 4, 4, 4);

        //bottom left cornet
        ScreenHelper.drawTexture(context, ContainerBaseTextures.Background.Slice.BOTTOM_RIGHT.id(),
                                x + width - 4, y + height - 4, 0, 0, 4, 4, 4, 4);
    }

    public static void drawPlayerInventory(DrawContext context, int x, int y)
    {
        drawTexture(context, ContainerBaseTextures.PLAYER_INVENTORY.id(),
                    x, y,
                    ContainerBaseTextures.PLAYER_INVENTORY.u(), ContainerBaseTextures.PLAYER_INVENTORY.v(),
                    ContainerBaseTextures.PLAYER_INVENTORY.width(), ContainerBaseTextures.PLAYER_INVENTORY.height(),
                    ContainerBaseTextures.PLAYER_INVENTORY.textureWidth(),
                    ContainerBaseTextures.PLAYER_INVENTORY.textureHeight());
    }
}