package jiraiyah.jiregister;

import jiraiyah.jibase.annotations.*;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.input.RecipeInput;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

@Developer("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/drkhodakarami/___PROJECTS___")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")

public class JiRecipeRegister
{
    private final String modId;

    public JiRecipeRegister(String modId)
    {
        this.modId = modId;
    }

    public <R extends Recipe<D>, D extends RecipeInput> RecipeSerializer<R> register(String name, RecipeSerializer<R> serializer)
    {
        RegistryKey<RecipeSerializer<?>> key = RegistryHelper.getKey(this.modId, name, RegistryKeys.RECIPE_SERIALIZER);
        return Registry.register(Registries.RECIPE_SERIALIZER, key, serializer);
    }

    public <R extends Recipe<D>, D extends RecipeInput> RecipeType<R> register(String name, RecipeType<R> recipeType)
    {
        RegistryKey<RecipeType<?>> key = RegistryHelper.getKey(this.modId, name, RegistryKeys.RECIPE_TYPE);
        return Registry.register(Registries.RECIPE_TYPE, key, recipeType);
    }
}