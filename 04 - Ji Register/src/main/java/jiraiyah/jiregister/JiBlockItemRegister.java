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

package jiraiyah.jiregister;

import jiraiyah.jibase.annotations.*;
import jiraiyah.jibase.utils.BaseHelper;
import jiraiyah.jiregister.factory.IBlockItemFactory;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

@Developer("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/drkhodakarami/___PROJECTS___")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")

public class JiBlockItemRegister
{
    private final String modId;

    public JiBlockItemRegister(String modId)
    {
        this.modId = modId;
    }

    public BlockItem register(Block block)
    {
        String name = BaseHelper.getRegistryName(block);
        RegistryKey<Item> key = BaseHelper.getKey(this.modId, name, RegistryKeys.ITEM);
        return Registry.register(Registries.ITEM, key, new BlockItem(block,
                                                                     new Item.Settings()
                                                                             .useBlockPrefixedTranslationKey()
                                                                             .registryKey(key)));
    }

    public <R extends BlockItem> R register(Block block, IBlockItemFactory<Item.Settings, R> factory)
    {
        String name = BaseHelper.getRegistryName(block);
        RegistryKey<Item> key = BaseHelper.getKey(this.modId, name, RegistryKeys.ITEM);
        R item = factory.apply(block, new Item.Settings()
                                                .useBlockPrefixedTranslationKey()
                                                .registryKey(key));
        return Registry.register(Registries.ITEM, key, item);
    }

    public <R extends BlockItem> R register(Block block, Item.Settings settings, IBlockItemFactory<Item.Settings, R> factory)
    {
        String name = BaseHelper.getRegistryName(block);
        RegistryKey<Item> key = BaseHelper.getKey(this.modId, name, RegistryKeys.ITEM);
        R item = factory.apply(block, settings
                                        .useBlockPrefixedTranslationKey()
                                        .registryKey(key));
        return Registry.register(Registries.ITEM, key, item);
    }
}