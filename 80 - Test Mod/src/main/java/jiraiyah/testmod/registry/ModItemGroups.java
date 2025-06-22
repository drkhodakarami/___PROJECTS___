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

package jiraiyah.testmod.registry;

import jiraiyah.jibase.exceptions.Exceptions;
import jiraiyah.jibase.utils.BaseHelper;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;

import static jiraiyah.testmod.Main.ModID;
import static jiraiyah.testmod.Main.LOGGER;

public class ModItemGroups
{
    public static final RegistryKey<ItemGroup> BLOCKS_KEY = BaseHelper.getKey(ModID, "test_item_group", RegistryKeys.ITEM_GROUP);

    public static final ItemGroup BLOCKS = Registry.register(Registries.ITEM_GROUP,
                                                             BLOCKS_KEY,
                                                             FabricItemGroup.builder().displayName(Text.literal("Test"))
                                                                            .icon(Items.AMETHYST_SHARD::getDefaultStack)
                                                                            .entries((displayContext, entries) ->
                                                                                     {
                                                                                         entries.add(ModBlocks.GUI_1);
                                                                                         entries.add(ModBlocks.GUI_2);
                                                                                         entries.add(ModBlocks.GUI_3);
                                                                                         entries.add(ModBlocks.GUI_4);
                                                                                         entries.add(ModBlocks.GUI_5);
                                                                                         entries.add(ModBlocks.GUI_6);
                                                                                         entries.add(ModBlocks.GUI_7);
                                                                                         entries.add(ModBlocks.GUI_8);
                                                                                         entries.add(ModBlocks.GUI_9);
                                                                                     }).build());

    public ModItemGroups()
    {
        Exceptions.throwCtorAssertion();
    }

    public static void init()
    {
        LOGGER.logItemGroupInit();
    }
}