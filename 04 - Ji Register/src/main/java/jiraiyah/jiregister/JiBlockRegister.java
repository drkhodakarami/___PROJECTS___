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
import net.minecraft.block.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

import java.util.function.Function;

@SuppressWarnings("unused")
@Developer("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/drkhodakarami/___PROJECTS___")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")

public class JiBlockRegister
{
    private final String modId;

    public JiBlockRegister(String modId)
    {
        this.modId = modId;
    }

    public Block register(String name)
    {
        return register(name, Block::new);
    }

    public Block register(String name, Block copyBlock)
    {
        return register(name, copyBlock, Block::new);
    }

    public Block register(String name, AbstractBlock.Settings settings)
    {
        return register(name, settings, Block::new);
    }

    public <R extends Block> R registerBlock(String name, R block)
    {
        RegistryKey<Block> key = BaseHelper.getKey(this.modId, name, RegistryKeys.BLOCK);
        return Registry.register(Registries.BLOCK, key, block);
    }

    public <R extends Block> R register(String name, Block copyBlock, Function<AbstractBlock.Settings, R> factory)
    {
        RegistryKey<Block> key = BaseHelper.getKey(this.modId, name, RegistryKeys.BLOCK);
        R block = factory.apply(AbstractBlock.Settings.copy(copyBlock).registryKey(key));
        return Registry.register(Registries.BLOCK, key, block);
    }

    public <R extends Block> R register(String name, AbstractBlock.Settings settings, Function<AbstractBlock.Settings, R> factory)
    {
        RegistryKey<Block> key = BaseHelper.getKey(this.modId, name, RegistryKeys.BLOCK);
        R block = factory.apply(settings.registryKey(key));
        return Registry.register(Registries.BLOCK, key, block);
    }

    public <R extends Block> R register(String name, Function<AbstractBlock.Settings, R> factory)
    {
        RegistryKey<Block> key = BaseHelper.getKey(this.modId, name, RegistryKeys.BLOCK);
        R block = factory.apply(AbstractBlock.Settings.create().registryKey(key));
        return Registry.register(Registries.BLOCK, key, block);
    }

    public StairsBlock registerStair(String name, Block stateBlock, Block copyBlock)
    {
        RegistryKey<Block> key = BaseHelper.getKey(this.modId, name, RegistryKeys.BLOCK);
        return registerBlock(name, new StairsBlock(stateBlock.getDefaultState(),
                                                   AbstractBlock.Settings.copy(copyBlock).registryKey(key)));
    }

    public SlabBlock registerSlab(String name, Block copyBlock)
    {
        RegistryKey<Block> key = BaseHelper.getKey(this.modId, name, RegistryKeys.BLOCK);
        return registerBlock(name, new SlabBlock(AbstractBlock.Settings.copy(copyBlock).registryKey(key)));
    }

    public ButtonBlock registerButton(String name, BlockSetType blockType, int pressureTicks, Block copyBlock)
    {
        RegistryKey<Block> key = BaseHelper.getKey(this.modId, name, RegistryKeys.BLOCK);
        return registerBlock(name, new ButtonBlock(blockType, pressureTicks,
                                                   AbstractBlock.Settings.copy(copyBlock).registryKey(key)));
    }

    public PressurePlateBlock registerPressurePlate(String name, BlockSetType blockType, Block copyBlock)
    {
        RegistryKey<Block> key = BaseHelper.getKey(this.modId, name, RegistryKeys.BLOCK);
        return registerBlock(name, new PressurePlateBlock(blockType,
                                                   AbstractBlock.Settings.copy(copyBlock).registryKey(key)));
    }

    public FenceBlock registerFence(String name, Block copyBlock)
    {
        RegistryKey<Block> key = BaseHelper.getKey(this.modId, name, RegistryKeys.BLOCK);
        return registerBlock(name, new FenceBlock(AbstractBlock.Settings.copy(copyBlock).registryKey(key)));
    }

    public FenceGateBlock registerFenceGate(String name, WoodType woodType, Block copyBlock)
    {
        RegistryKey<Block> key = BaseHelper.getKey(this.modId, name, RegistryKeys.BLOCK);
        return registerBlock(name, new FenceGateBlock(woodType, AbstractBlock.Settings.copy(copyBlock).registryKey(key)));
    }

    public WallBlock registerWall(String name, Block copyBlock)
    {
        RegistryKey<Block> key = BaseHelper.getKey(this.modId, name, RegistryKeys.BLOCK);
        return registerBlock(name, new WallBlock(AbstractBlock.Settings.copy(copyBlock).registryKey(key)));
    }

    public DoorBlock registerDoor(String name, BlockSetType blockType, Block copyBlock)
    {
        RegistryKey<Block> key = BaseHelper.getKey(this.modId, name, RegistryKeys.BLOCK);
        return registerBlock(name, new DoorBlock(blockType,
                                              AbstractBlock.Settings.copy(copyBlock).registryKey(key)));
    }

    public TrapdoorBlock registerTrapdoor(String name, BlockSetType blockType, Block copyBlock)
    {
        RegistryKey<Block> key = BaseHelper.getKey(this.modId, name, RegistryKeys.BLOCK);
        return registerBlock(name, new TrapdoorBlock(blockType,
                                                 AbstractBlock.Settings.copy(copyBlock).registryKey(key)));
    }
}