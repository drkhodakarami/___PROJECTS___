package jiraiyah.jiregister;

import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

public class LootTableHelper
{
    public static LootTable.Builder addOreDrops(FabricBlockLootTableProvider provider, RegistryWrapper.WrapperLookup registries,
                                                Block block, Item item, float min, float max)
    {
        RegistryWrapper.Impl<Enchantment> impl = registries.getOrThrow(RegistryKeys.ENCHANTMENT);
        return provider.dropsWithSilkTouch(block,
                                           (ItemEntry.builder(item)
                                                       .apply(SetCountLootFunction
                                                                  .builder(UniformLootNumberProvider.create(min, max))))
                                                       .apply(ApplyBonusLootFunction
                                                                  .oreDrops(impl.getOrThrow(Enchantments.FORTUNE))));
    }

    public static LootTable.Builder addOreDrops(FabricBlockLootTableProvider provider, RegistryWrapper.WrapperLookup registries,
                                                Block block, Item item)
    {
        return addOreDrops(provider, registries, block, item, 2.0f, 5.0f);
    }
}