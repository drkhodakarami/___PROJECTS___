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

package jiraiyah.ultraio.registry;

import jiraiyah.jibase.exceptions.Exceptions;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;

import static jiraiyah.ultraio.Main.LOGGER;
import static jiraiyah.ultraio.Main.REFERENCE;

public class ModToolMaterials
{
    public static ToolMaterial CITRINE = new ToolMaterial(BlockTags.INCORRECT_FOR_IRON_TOOL, 1000, 10.0f, 3.0f, 22, REFERENCE.REPAIRS_CITRINE_TOOL);
    public static ToolMaterial COPPER = new ToolMaterial(BlockTags.INCORRECT_FOR_IRON_TOOL, 500, 6.0f, 1.0f, 14, REFERENCE.REPAIRS_COPPER_TOOL);
    public static ToolMaterial ENDERITE = new ToolMaterial(REFERENCE.INCORRECT_FOR_ENDERITE_TOOL, 3000, 24.0f, 15.0f, 32, REFERENCE.REPAIRS_ENDERITE_TOOL);
    public static ToolMaterial RUBY = new ToolMaterial(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 2000, 12.0f, 4.0f, 22, REFERENCE.REPAIRS_RUBY_TOOL);
    public static ToolMaterial SAPPHIRE = new ToolMaterial(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 2000, 12.0f, 4.0f, 22, REFERENCE.REPAIRS_SAPPHIRE_TOOL);

    public ModToolMaterials()
    {
        Exceptions.throwCtorAssertion();
    }

    public static void init()
    {
        LOGGER.logToolMaterialInit();
    }
}