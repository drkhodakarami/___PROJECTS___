package jiraiyah.jiregister;

import jiraiyah.jibase.annotations.*;
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
        String name = Registries.BLOCK.getId(block).getPath();
        RegistryKey<Item> key = RegistryHelper.getKey(this.modId, name, RegistryKeys.ITEM);
        return Registry.register(Registries.ITEM, key, new BlockItem(block,
                                                                     new Item.Settings()
                                                                             .useBlockPrefixedTranslationKey()
                                                                             .registryKey(key)));
    }

    public <R extends BlockItem> R register(Block block, IBlockItemFactory<Item.Settings, R> factory)
    {
        String name = Registries.BLOCK.getId(block).getPath();
        RegistryKey<Item> key = RegistryHelper.getKey(this.modId, name, RegistryKeys.ITEM);
        R item = factory.apply(block, new Item.Settings()
                                                .useBlockPrefixedTranslationKey()
                                                .registryKey(key));
        return Registry.register(Registries.ITEM, key, item);
    }

    public <R extends BlockItem> R register(Block block, Item.Settings settings, IBlockItemFactory<Item.Settings, R> factory)
    {
        String name = Registries.BLOCK.getId(block).getPath();
        RegistryKey<Item> key = RegistryHelper.getKey(this.modId, name, RegistryKeys.ITEM);
        R item = factory.apply(block, settings
                                        .useBlockPrefixedTranslationKey()
                                        .registryKey(key));
        return Registry.register(Registries.ITEM, key, item);
    }
}