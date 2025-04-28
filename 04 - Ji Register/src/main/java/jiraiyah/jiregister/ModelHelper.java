package jiraiyah.jiregister;

import jiraiyah.jibase.annotations.*;
import jiraiyah.jiregister.interfaces.BlockStateModelGeneratorAccessor;
import net.minecraft.block.Block;
import net.minecraft.client.data.*;
import net.minecraft.client.render.model.json.WeightedVariant;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.Identifier;

@Developer("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/drkhodakarami/___PROJECTS___")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")

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
                                                                                .coordinate(((BlockStateModelGeneratorAccessor) generator).getNorthDefaultHorizontalRotationOperations()));
    }

    @ThanksTo(discordUsers = "Waveless")
    public static void registerCubeVariantBlock(BlockStateModelGenerator generator, Block block, BooleanProperty property)
    {
        //TODO: Overview this
        WeightedVariant cubeOff = BlockStateModelGenerator.createWeightedVariant(TexturedModel.CUBE_ALL.upload(block, generator.modelCollector));
        WeightedVariant cubeOn = BlockStateModelGenerator.createWeightedVariant((generator.createSubModel(block, "_on", Models.CUBE_ALL, TextureMap::all)));
        BlockStateVariantMap<WeightedVariant> cubeStatus = BlockStateModelGenerator.createBooleanModelMap(property, cubeOn, cubeOff);
        generator.blockStateCollector.accept(VariantsBlockModelDefinitionCreator.of(block)
                                                                                .with(cubeStatus));
    }
}