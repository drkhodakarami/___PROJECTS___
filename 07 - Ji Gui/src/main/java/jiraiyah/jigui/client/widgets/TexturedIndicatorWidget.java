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

package jiraiyah.jigui.client.widgets;

import jiraiyah.jibase.annotations.*;
import jiraiyah.jibase.client.utils.MouseHelper;
import jiraiyah.jibase.utils.StringHelper;
import jiraiyah.jigui.client.constants.DigitalIndicatorTextures;
import jiraiyah.jigui.client.records.TextureData;
import jiraiyah.jigui.client.utils.ScreenUtils;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.Drawable;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.client.gui.widget.Widget;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Supplier;

@Developer("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/drkhodakarami/___PROJECTS___")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")

public class TexturedIndicatorWidget implements Drawable, Widget
{
    private final int backgroundX, backgroundY, backgroundWidth, backgroundHeight;
    private final int indicatorX, indicatorY, indicatorWidth, indicatorHeight;

    private final int backgroundU, backgroundV, indicatorU, indicatorV;

    private int x, y;

    private final int backgroundSizeWidth, backgroundSizeHeight;
    private final int indicatorSizeWidth, indicatorSizeHeight;

    private final Supplier<Long> amountSupplier, capacitySupplier;

    private final Identifier backgroundTexture, indicatorTexture;

    private final String suffix;

    public TexturedIndicatorWidget(String suffix,
                                   int x, int y,
                                   int backgroundX, int backgroundY, int backgroundWidth, int backgroundHeight,
                                   int indicatorX, int indicatorY, int indicatorWidth, int indicatorHeight,
                                   int backgroundU, int backgroundV, int indicatorU, int indicatorV,
                                   int backgroundSizeWidth, int backgroundSizeHeight,
                                   int indicatorSizeWidth, int indicatorSizeHeight,
                                   Identifier backgroundTexture, Identifier indicatorTexture,
                                   Supplier<Long> amountSupplier, Supplier<Long> capacitySupplier)
    {
        this.suffix = suffix;
        this.backgroundX = backgroundX;
        this.backgroundY = backgroundY;
        this.backgroundWidth = backgroundWidth;
        this.backgroundHeight = backgroundHeight;
        this.indicatorX = indicatorX;
        this.indicatorY = indicatorY;
        this.indicatorWidth = indicatorWidth;
        this.indicatorHeight = indicatorHeight;
        this.backgroundTexture = backgroundTexture;
        this.indicatorTexture = indicatorTexture;
        this.backgroundU = backgroundU;
        this.backgroundV = backgroundV;
        this.indicatorU = indicatorU;
        this.indicatorV = indicatorV;
        this.amountSupplier = amountSupplier;
        this.capacitySupplier = capacitySupplier;
        this.backgroundSizeWidth = backgroundSizeWidth;
        this.backgroundSizeHeight = backgroundSizeHeight;
        this.indicatorSizeWidth = indicatorSizeWidth;
        this.indicatorSizeHeight = indicatorSizeHeight;
        this.x = x;
        this.y = y;
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float deltaTicks)
    {
        ScreenUtils.drawTexture(context, backgroundTexture,
                                x + backgroundX, y + backgroundY,
                                backgroundU, backgroundV,
                                backgroundWidth, backgroundHeight,
                                backgroundSizeWidth, backgroundSizeHeight);

        if(amountSupplier == null || capacitySupplier == null || amountSupplier.get() <= 0 || capacitySupplier.get() <= 0)
            return;

        long amount = amountSupplier.get();
        long capacity = capacitySupplier.get();
        int barHeight = Math.round((float) amount / capacity * indicatorHeight);

        ScreenUtils.drawTexture(context, indicatorTexture,
                                x + indicatorX, y + indicatorY - barHeight,
                                indicatorU, indicatorV,
                                indicatorWidth, barHeight,
                                indicatorSizeWidth, indicatorSizeHeight);

        if(MouseHelper.isMouseOver(mouseX, mouseY, x + indicatorX, y + indicatorY, indicatorWidth, indicatorHeight))
            drawTooltip(context, mouseX, mouseY);
    }

    @Override
    public void setX(int x)
    {
        this.x = x;
    }

    @Override
    public void setY(int y)
    {
        this.y = y;
    }

    @Override
    public int getX()
    {
        return x;
    }

    @Override
    public int getY()
    {
        return y;
    }

    @Override
    public int getWidth()
    {
        return backgroundWidth;
    }

    @Override
    public int getHeight()
    {
        return backgroundHeight;
    }

    @Override
    public void forEachChild(Consumer<ClickableWidget> consumer) {}

    protected  void drawTooltip(DrawContext context, int mouseX, int mouseY)
    {
        long amount = amountSupplier.get();
        long capacity = capacitySupplier.get();

        TextRenderer textRenderer = MinecraftClient.getInstance().textRenderer;

        String amountText = StringHelper.formatted(amount);
        String capacityText = StringHelper.formatted(capacity);

        String temp = !Objects.equals(suffix, "")
                        ? amountText + " / " + capacityText + " " + suffix
                        : amountText + " / " + capacityText;

        List<Text> texts = List.of(Text.literal(temp));

        context.drawTooltip(textRenderer, texts, mouseX, mouseY);
    }

    public static class Builder
    {
        private int backgroundX, backgroundY, backgroundWidth, backgroundHeight;
        private int indicatorX, indicatorY, indicatorWidth, indicatorHeight;

        private int backgroundU, backgroundV, indicatorU, indicatorV;

        private final int x, y;

        private int backgroundSizeWidth, backgroundSizeHeight;
        private int indicatorSizeWidth, indicatorSizeHeight;

        private Supplier<Long> amountSupplier = () -> null;
        private Supplier<Long> capacitySupplier = () -> null;

        private Identifier backgroundTexture, indicatorTexture;

        private String suffix = "";

        public Builder(int x, int y)
        {
            this.x = x;
            this.y = y;
        }

        public Builder suffix (String suffix)
        {
            this.suffix = suffix;
            return this;
        }

        public Builder backgroundTexture(TextureData data)
        {
            this.backgroundX = data.x();
            this.backgroundY = data.y();
            this.backgroundWidth = data.width();
            this.backgroundHeight = data.height();
            this.backgroundTexture = data.id();
            this.backgroundU = data.u();
            this.backgroundV = data.v();
            this.backgroundSizeWidth = data.textureWidth();
            this.backgroundSizeHeight = data.textureHeight();
            return this;
        }

        public Builder indicatorTexture(TextureData data)
        {
            this.indicatorX = data.x();
            this.indicatorY = data.y();
            this.indicatorWidth = data.width();
            this.indicatorHeight = data.height();
            this.indicatorTexture = data.id();
            this.indicatorU = data.u();
            this.indicatorV = data.v();
            this.indicatorSizeWidth = data.textureWidth();
            this.indicatorSizeHeight = data.textureHeight();
            return this;
        }

        public Builder textures(TextureData backgroundData, TextureData indicatorData)
        {
            return this.backgroundTexture(backgroundData).indicatorTexture(indicatorData);
        }

        public Builder backgroundRect(int x, int y, int width, int height)
        {
            this.backgroundX = x;
            this.backgroundY = y;
            this.backgroundWidth = width;
            this.backgroundHeight = height;
            return this;
        }

        public Builder indicatorRect(int x, int y, int width, int height)
        {
            this.indicatorX = x;
            this.indicatorY = y;
            this.indicatorWidth = width;
            this.indicatorHeight = height;
            return this;
        }

        public Builder backgroundTexture(Identifier texture, int u, int v, int width, int height)
        {
            this.backgroundTexture = texture;
            this.backgroundU = u;
            this.backgroundV = v;
            this.backgroundSizeWidth = width;
            this.backgroundSizeHeight = height;
            return this;
        }

        public Builder indicatorTexture(Identifier texture, int u, int v, int width, int height)
        {
            this.indicatorTexture = texture;
            this.indicatorU = u;
            this.indicatorV = v;
            this.indicatorSizeWidth = width;
            this.indicatorSizeHeight = height;
            return this;
        }

        public Builder amountSupplier(Supplier<Long> amountSupplier)
        {
            this.amountSupplier = amountSupplier;
            return this;
        }

        public Builder capacitySupplier(Supplier<Long> capacitySupplier)
        {
            this.capacitySupplier = capacitySupplier;
            return this;
        }

        public Builder isEnergy(boolean useSmallWidget)
        {
            if(useSmallWidget)
                return this.textures(DigitalIndicatorTextures.Small.BACKGROUND, DigitalIndicatorTextures.Small.Progress.RED);
            return this.textures(DigitalIndicatorTextures.Normal.Background.RED, DigitalIndicatorTextures.Normal.Progress.RED);
        }

        public Builder isEnergy()
        {
            return this.isEnergy(false);
        }

        public TexturedIndicatorWidget build()
        {
            return new TexturedIndicatorWidget(this.suffix,
                                               x, y,
                                               this.backgroundX, this.backgroundY, this.backgroundWidth, this.backgroundHeight,
                                               this.indicatorX, this.indicatorY, this.indicatorWidth, this.indicatorHeight,
                                               this.indicatorU, this.indicatorV, this.backgroundU, this.backgroundV,
                                               this.backgroundSizeWidth, this.backgroundSizeHeight,
                                               this.indicatorSizeWidth, this.indicatorSizeHeight,
                                               this.backgroundTexture, this.indicatorTexture,
                                               this.amountSupplier, this.capacitySupplier);
        }
    }
}