package jiraiyah.jiregister;

import net.minecraft.block.Block;
import net.minecraft.client.data.*;
import net.minecraft.client.render.model.json.WeightedVariant;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;

import java.util.function.BiConsumer;

public class ModelHelper
{
    // look into registerCooker from BlockStateModelGenerator
    // look into register() from BlockStateModelGenerator and it's Furnace registration
    public static void registerOrientableVariantBlock(BlockStateModelGenerator generator, Block block, BooleanProperty property)
    {
        WeightedVariant blockOFF = BlockStateModelGenerator.createWeightedVariant(TexturedModel.ORIENTABLE.upload(block, generator.modelCollector));
        Identifier blockFront = TextureMap.getSubId(block, "_front_on");
        WeightedVariant blockON = BlockStateModelGenerator.createWeightedVariant(TexturedModel.ORIENTABLE.get(block)
                                                                                                      .textures(textureMap ->
                                                                                                                        textureMap.put(TextureKey.FRONT, blockFront))
                                                                                                      .upload(block, "_on", generator.modelCollector));
        generator.blockStateCollector.accept(VariantsBlockModelDefinitionCreator.of(block)
                                                        .with(BlockStateModelGenerator.createBooleanModelMap(property, blockON, blockOFF))
                                                        .coordinate(BlockStateModelGenerator.NORTH_DEFAULT_HORIZONTAL_ROTATION_OPERATIONS));
    }

    public static void registerCubeVariantBlock(BlockStateModelGenerator generator, net.minecraft.block.Block block, BooleanProperty property)
    {
        WeightedVariant cubeOff = BlockStateModelGenerator.createWeightedVariant(TexturedModel.CUBE_ALL.upload(block, generator.modelCollector));
        Identifier blockAll = TextureMap.getSubId(block, "_on");
        WeightedVariant cubeOn = BlockStateModelGenerator.createWeightedVariant(TexturedModel.ORIENTABLE.get(block)
                                                                                                        .textures(textureMap ->
                                                                                                                          textureMap.put(TextureKey.ALL, blockAll))
                                                                                                        .upload(block, "_on", generator.modelCollector));
        generator.blockStateCollector.accept(VariantsBlockModelDefinitionCreator.of(block)
                                                                       .with(BlockStateModelGenerator.createBooleanModelMap(property,
                                                                                                                                  cubeOn,
                                                                                                                                  cubeOff)));
    }

    private static Identifier identifier(String modID, String path)
    {
        return Identifier.of(modID, path);
    }
}