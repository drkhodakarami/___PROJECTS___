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

package jiraiyah.testmod.datagen;

import jiraiyah.testmod.Main;
import jiraiyah.testmod.registry.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.text.MutableText;
import net.minecraft.text.TranslatableTextContent;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ModEnLanguageProvider extends FabricLanguageProvider
{
    public ModEnLanguageProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup)
    {
        super(dataOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder builder)
    {
        Main.LOGGER.logEnLanguageDatagen();

        builder.add(ModBlocks.GUI_1, "GUI Test 1");
        builder.add(ModBlocks.GUI_2, "GUI Test 2");
        builder.add(ModBlocks.GUI_3, "GUI Test 3");
        builder.add(ModBlocks.GUI_4, "GUI Test 4");
        builder.add(ModBlocks.GUI_5, "GUI Test 5");
        builder.add(ModBlocks.GUI_6, "GUI Test 6");
        builder.add(ModBlocks.GUI_7, "GUI Test 7");
        builder.add(ModBlocks.GUI_8, "GUI Test 8");
        builder.add(ModBlocks.GUI_9, "GUI Test 9");
    }

    private static void addText(@NotNull TranslationBuilder builder, @NotNull MutableText text, @NotNull String value)
    {
        builder.add(((TranslatableTextContent) text.getContent()).getKey(), value);
    }
}