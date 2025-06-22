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

package jiraiyah.jibase.utils;

import jiraiyah.jibase.annotations.*;
import jiraiyah.jibase.exceptions.Exceptions;
import net.minecraft.advancement.criterion.Criterion;
import net.minecraft.block.Block;
import net.minecraft.block.DecoratedPotPattern;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.component.ComponentType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.map.MapDecorationType;
import net.minecraft.potion.Potion;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.math.floatprovider.FloatProviderType;
import net.minecraft.util.math.intprovider.IntProviderType;
import net.minecraft.village.VillagerProfession;
import net.minecraft.village.VillagerType;
import net.minecraft.world.World;
import net.minecraft.world.chunk.ChunkStatus;
import org.jetbrains.annotations.NotNull;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.Objects;

@SuppressWarnings("unused")
@Developer("Jiraiyah")
@CreatedAt("2025-04-18")
@ModifiedAt("2025-04-23")
@Repository("https://github.com/drkhodakarami/___PROJECTS___")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")

public class BaseHelper
{
    public BaseHelper()
    {
        Exceptions.throwCtorAssertion();
    }

    public static Identifier identifier(String modID, @NotNull String path)
    {
        return Identifier.of(modID, path);
    }

    public static <T> RegistryKey<T> getKey(String modID, String name, RegistryKey<? extends Registry<T>> registryKey)
    {
        return RegistryKey.of(registryKey, identifier(modID, name));
    }

    public static @NotNull String hasTag(@NotNull TagKey<Item> tag)
    {
        return "has_" + tag.id().toString();
    }

    public static String getRegistryName(Fluid fluid)
    {
        return Registries.FLUID.getId(fluid).getPath();
    }

    public static String getRegistryName(Item item)
    {
        return Registries.ITEM.getId(item).getPath();
    }

    public static String getRegistryName(ItemStack item)
    {
        return Registries.ITEM.getId(item.getItem()).getPath();
    }

    public static String getRegistryName(Block block)
    {
        return Registries.BLOCK.getId(block).getPath();
    }

    public static String getRegistryName(EntityType<?> entityType)
    {
        return Registries.ENTITY_TYPE.getId(entityType).getPath();
    }

    public static String getRegistryName(Potion potion)
    {
        return Objects.requireNonNull(Registries.POTION.getId(potion)).getPath();
    }

    public static String getRegistryName(BlockEntityType<?> blockEntityType)
    {
        return Objects.requireNonNull(Registries.BLOCK_ENTITY_TYPE.getId(blockEntityType)).getPath();
    }

    public static String getRegistryName(Identifier identifier)
    {
        return Objects.requireNonNull(Registries.CUSTOM_STAT.getId(identifier)).getPath();
    }

    public static String getRegistryName(ChunkStatus chunkStatus)
    {
        return Registries.CHUNK_STATUS.getId(chunkStatus).getPath();
    }

    public static String getRegistryName(EntityAttribute entityAttribute)
    {
        return Objects.requireNonNull(Registries.ATTRIBUTE.getId(entityAttribute)).getPath();
    }

    public static String getRegistryName(ScreenHandlerType<?> screenHandlerType)
    {
        return Objects.requireNonNull(Registries.SCREEN_HANDLER.getId(screenHandlerType)).getPath();
    }

    public static String getRegistryName(RecipeType<?> recipeType)
    {
        return Objects.requireNonNull(Registries.RECIPE_TYPE.getId(recipeType)).getPath();
    }

    public static String getRegistryName(RecipeSerializer<?> recipeSerializer)
    {
        return Objects.requireNonNull(Registries.RECIPE_SERIALIZER.getId(recipeSerializer)).getPath();
    }

    public static String getRegistryName(VillagerType villagerType)
    {
        return Registries.VILLAGER_TYPE.getId(villagerType).getPath();
    }

    public static String getRegistryName(VillagerProfession villagerProfession)
    {
        return Registries.VILLAGER_PROFESSION.getId(villagerProfession).getPath();
    }

    public static String getRegistryName(FloatProviderType<?> floatProviderType)
    {
        return Objects.requireNonNull(Registries.FLOAT_PROVIDER_TYPE.getId(floatProviderType)).getPath();
    }

    public static String getRegistryName(IntProviderType<?> intProviderType)
    {
        return Objects.requireNonNull(Registries.INT_PROVIDER_TYPE.getId(intProviderType)).getPath();
    }

    public static String getRegistryName(DecoratedPotPattern decoratedPotPattern)
    {
        return Objects.requireNonNull(Registries.DECORATED_POT_PATTERN.getId(decoratedPotPattern)).getPath();
    }

    public static String getRegistryName(ItemGroup itemGroup)
    {
        return Objects.requireNonNull(Registries.ITEM_GROUP.getId(itemGroup)).getPath();
    }

    public static String getRegistryName(Criterion<?> criterion)
    {
        return Objects.requireNonNull(Registries.CRITERION.getId(criterion)).getPath();
    }

    public static String getRegistryName(ComponentType<?> componentType, boolean isEnchantment)
    {
        return isEnchantment
               ? Objects.requireNonNull(Registries.ENCHANTMENT_EFFECT_COMPONENT_TYPE.getId(componentType)).getPath()
               : Objects.requireNonNull(Registries.DATA_COMPONENT_TYPE.getId(componentType)).getPath();
    }

    public static String getRegistryName(MapDecorationType mapDecorationType)
    {
        return Objects.requireNonNull(Registries.MAP_DECORATION_TYPE.getId(mapDecorationType)).getPath();
    }

    public static String getRegistryName(RecipeBookCategory recipeBookCategory)
    {
        return Objects.requireNonNull(Registries.RECIPE_BOOK_CATEGORY.getId(recipeBookCategory)).getPath();
    }

    public static List<Item> getItemsWithTag(TagKey<Item> tagKey)
    {
        return Registries.ITEM.stream()
                              .filter(item -> Registries.ITEM.getEntry(item).isIn(tagKey))
                              .toList();
    }

    public static List<Block> getBlocksWithTag(TagKey<Block> tagKey)
    {
        return Registries.BLOCK.stream()
                               .filter(block -> Registries.BLOCK.getEntry(block).isIn(tagKey))
                               .toList();
    }

    public static List<BlockEntityType<?>> getBlockEntitiesWithTag(TagKey<BlockEntityType<?>> tagKey)
    {
        return Registries.BLOCK_ENTITY_TYPE.stream()
                                           .filter(blockEntityType -> Registries.BLOCK_ENTITY_TYPE.getEntry(blockEntityType).isIn(tagKey))
                                           .toList();
    }

    public static List<EntityType<?>> getEntitiesWithTag(TagKey<EntityType<?>> tagKey)
    {
        return Registries.ENTITY_TYPE.stream()
                                     .filter(entityType -> Registries.ENTITY_TYPE.getEntry(entityType).isIn(tagKey))
                                     .toList();
    }

    public static Identifier getDimensionId(World world)
    {
        return world.getRegistryKey().getValue();
    }

    public static String getDimensionName(World world)
    {
        return getDimensionId(world).toString();
    }

    public static String getDimensionNameClean(World world)
    {
        return getDimensionNameClean(getDimensionName(world));
    }

    public static String getDimensionNameClean(String dimensionName)
    {
        return dimensionName.substring(dimensionName.indexOf(':') + 1).replace('_', ' ');
    }
}