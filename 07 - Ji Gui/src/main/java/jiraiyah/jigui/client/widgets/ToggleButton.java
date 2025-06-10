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
import jiraiyah.jigui.client.constants.WidgetTextures;
import jiraiyah.jigui.client.utils.ScreenUtils;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.ColorHelper;

import java.util.function.BiConsumer;

@Developer("Jiraiyah")
@CreatedAt("2025-04-18")
@ModifiedAt("2025-04-23")
@Repository("https://github.com/drkhodakarami/___PROJECTS___")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")
public class ToggleButton extends ButtonWidget
{
    private  final BiConsumer<ToggleButton, Boolean> onPress;
    private  final Identifier onState;
    private  final Identifier offState;
    private  final Identifier onSelected;
    private  final Identifier offSelected;

    private boolean toggled;

    protected ToggleButton(int x, int y, int width, int height, boolean defaultToggled,
                           Identifier onState, Identifier offState, Identifier onSelected, Identifier offSelected,
                           BiConsumer<ToggleButton, Boolean> onPress, NarrationSupplier narrationSupplier)
    {
        super(x, y, width, height, Text.empty(), $ -> {}, narrationSupplier);

        this.onPress = onPress;
        this.toggled = defaultToggled;
        this.onState = onState;
        this.offState = offState;
        this.onSelected = onSelected;
        this.offSelected = offSelected;
    }

    @Override
    public void onPress()
    {
        toggle();
        this.onPress.accept(this, this.toggled);
    }

    public void toggle()
    {
        this.toggled = !this.toggled;
    }

    public void setToggled(boolean flag)
    {
        this.toggled = flag;
    }

    public boolean getToggled()
    {
        return this.toggled;
    }

    public Identifier getOnState()
    {
        return this.onState;
    }

    public Identifier getOffState()
    {
        return this.offState;
    }

    public Identifier getOnStateSelected()
    {
        return this.onSelected;
    }

    public Identifier getOffStateSelected()
    {
        return this.offSelected;
    }

    @Override
    protected void renderWidget(DrawContext context, int mouseX, int mouseY, float deltaTicks)
    {
        ScreenUtils.drawTexture(
                   context,
        this.toggled
                    ? (isHovered() ? this.onSelected : this.onState)
                    : (isHovered() ? this.offSelected : this.offState),
                getX(),
                getY(),
                0, 0,
                    getWidth(),
                    getHeight(),
         getWidth(),
        getHeight(),
            ColorHelper.getWhite(this.alpha));
    }

    public static class Builder
    {
        private int x, y, width, height;
        private boolean defaultToggled;
        private  Identifier onState;
        private  Identifier offState;
        private  Identifier onSelected;
        private  Identifier offSelected;

        private BiConsumer<ToggleButton, Boolean> onPress = (button, flag) -> {};
        private NarrationSupplier narrationSupplier = textSupplier -> Text.empty();

        public Builder()
        {}

        public Builder(int x, int y)
        {
            this(x, y, 0, 0);
        }

        public Builder(int x, int y, int width, int height)
        {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }

        public Builder addDefaultSize()
        {
            this.width = 32 ;
            this.height = 16;
            return this;
        }

        public Builder x(int x)
        {
            this.x = x;
            return this;
        }

        public Builder y(int y)
        {
            this.y = y;
            return this;
        }

        public Builder width(int width)
        {
            this.width = width;
            return this;
        }

        public Builder height(int height)
        {
            this.height = height;
            return this;
        }

        public Builder onPress(BiConsumer<ToggleButton, Boolean> onPress)
        {
            this.onPress = onPress;
            return this;
        }

        public Builder narrationSupplier(NarrationSupplier narrationSupplier)
        {
            this.narrationSupplier = narrationSupplier;
            return this;
        }

        public Builder toggleByDefault()
        {
            this.defaultToggled = true;
            return this;
        }

        public Builder toggledByDefault(boolean flag)
        {
            this.defaultToggled = flag;
            return this;
        }

        public Builder setOnState(Identifier id)
        {
            this.onState = id;
            return this;
        }

        public Builder setOffState(Identifier id)
        {
            this.offState = id;
            return this;
        }

        public Builder setOnSelected(Identifier id)
        {
            this.onSelected = id;
            return this;
        }

        public Builder setOffSelected(Identifier id)
        {
            this.offSelected = id;
            return this;
        }

        public Builder setDefaultTextures()
        {
            return this.setOnState(WidgetTextures.TOGGLE_ON)
                       .setOffState(WidgetTextures.TOGGLE_OFF)
                       .setOnSelected(WidgetTextures.TOGGLE_ON_SELECTED)
                       .setOffSelected(WidgetTextures.TOGGLE_OFF_SELECTED);
        }

        public Builder setColoredTextures()
        {
            return this.setOnState(WidgetTextures.TOGGLE_GREEN)
                       .setOffState(WidgetTextures.TOGGLE_RED)
                       .setOnSelected(WidgetTextures.TOGGLE_GREEN_SELECTED)
                       .setOffSelected(WidgetTextures.TOGGLE_RED_SELECTED);
        }

        public ToggleButton build()
        {
            return new ToggleButton(x, y, width, height, defaultToggled, onState, offState, onSelected, offSelected, onPress, narrationSupplier);
        }
    }
}