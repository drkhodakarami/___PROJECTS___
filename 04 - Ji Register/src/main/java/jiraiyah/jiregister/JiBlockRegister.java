package jiraiyah.jiregister;

import net.minecraft.block.*;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

import java.util.function.Function;

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
        RegistryKey<Block> key = RegistryHelper.getKey(this.modId, name, RegistryKeys.BLOCK);
        return Registry.register(Registries.BLOCK, key, block);
    }

    public <R extends Block> R register(String name, Block copyBlock, Function<AbstractBlock.Settings, R> factory)
    {
        RegistryKey<Block> key = RegistryHelper.getKey(this.modId, name, RegistryKeys.BLOCK);
        R block = factory.apply(AbstractBlock.Settings.copy(copyBlock).registryKey(key));
        return Registry.register(Registries.BLOCK, key, block);
    }

    public <R extends Block> R register(String name, AbstractBlock.Settings settings, Function<AbstractBlock.Settings, R> factory)
    {
        RegistryKey<Block> key = RegistryHelper.getKey(this.modId, name, RegistryKeys.BLOCK);
        R block = factory.apply(settings.registryKey(key));
        return Registry.register(Registries.BLOCK, key, block);
    }

    public <R extends Block> R register(String name, Function<AbstractBlock.Settings, R> factory)
    {
        RegistryKey<Block> key = RegistryHelper.getKey(this.modId, name, RegistryKeys.BLOCK);
        R block = factory.apply(AbstractBlock.Settings.create().registryKey(key));
        return Registry.register(Registries.BLOCK, key, block);
    }

    public StairsBlock registerStair(String name, Block stateBlock, Block copyBlock)
    {
        RegistryKey<Block> key = RegistryHelper.getKey(this.modId, name, RegistryKeys.BLOCK);
        return registerBlock(name, new StairsBlock(stateBlock.getDefaultState(),
                                                   AbstractBlock.Settings.copy(copyBlock).registryKey(key)));
    }

    public SlabBlock registerSlab(String name, Block copyBlock)
    {
        RegistryKey<Block> key = RegistryHelper.getKey(this.modId, name, RegistryKeys.BLOCK);
        return registerBlock(name, new SlabBlock(AbstractBlock.Settings.copy(copyBlock).registryKey(key)));
    }

    public ButtonBlock registerButton(String name, BlockSetType blockType, int pressureTicks, Block copyBlock)
    {
        RegistryKey<Block> key = RegistryHelper.getKey(this.modId, name, RegistryKeys.BLOCK);
        return registerBlock(name, new ButtonBlock(blockType, pressureTicks,
                                                   AbstractBlock.Settings.copy(copyBlock).registryKey(key)));
    }

    public PressurePlateBlock registerPressurePlate(String name, BlockSetType blockType, Block copyBlock)
    {
        RegistryKey<Block> key = RegistryHelper.getKey(this.modId, name, RegistryKeys.BLOCK);
        return registerBlock(name, new PressurePlateBlock(blockType,
                                                   AbstractBlock.Settings.copy(copyBlock).registryKey(key)));
    }

    public FenceBlock registerFence(String name, Block copyBlock)
    {
        RegistryKey<Block> key = RegistryHelper.getKey(this.modId, name, RegistryKeys.BLOCK);
        return registerBlock(name, new FenceBlock(AbstractBlock.Settings.copy(copyBlock).registryKey(key)));
    }

    public FenceGateBlock registerFence(String name, WoodType woodType, Block copyBlock)
    {
        RegistryKey<Block> key = RegistryHelper.getKey(this.modId, name, RegistryKeys.BLOCK);
        return registerBlock(name, new FenceGateBlock(woodType, AbstractBlock.Settings.copy(copyBlock).registryKey(key)));
    }

    public WallBlock registerWall(String name, Block copyBlock)
    {
        RegistryKey<Block> key = RegistryHelper.getKey(this.modId, name, RegistryKeys.BLOCK);
        return registerBlock(name, new WallBlock(AbstractBlock.Settings.copy(copyBlock).registryKey(key)));
    }

    public DoorBlock registerDoor(String name, BlockSetType blockType, Block copyBlock)
    {
        RegistryKey<Block> key = RegistryHelper.getKey(this.modId, name, RegistryKeys.BLOCK);
        return registerBlock(name, new DoorBlock(blockType,
                                              AbstractBlock.Settings.copy(copyBlock).registryKey(key)));
    }

    public TrapdoorBlock registerTrapDoor(String name, BlockSetType blockType, Block copyBlock)
    {
        RegistryKey<Block> key = RegistryHelper.getKey(this.modId, name, RegistryKeys.BLOCK);
        return registerBlock(name, new TrapdoorBlock(blockType,
                                                 AbstractBlock.Settings.copy(copyBlock).registryKey(key)));
    }
}