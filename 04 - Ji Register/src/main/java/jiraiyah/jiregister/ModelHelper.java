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
import jiraiyah.jibase.exceptions.Exceptions;
import jiraiyah.jiregister.interfaces.BlockStateModelGeneratorAccessor;
import net.minecraft.block.Block;
import net.minecraft.client.data.*;
import net.minecraft.client.render.model.json.WeightedVariant;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.Identifier;

/**
 * Provides utility methods for generating block state models.
 */
@SuppressWarnings("unused")
@Developer("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/drkhodakarami/___PROJECTS___")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")

public class ModelHelper
{
    /**
     * Private constructor to prevent instantiation.
     */
    public ModelHelper()
    {
        Exceptions.throwCtorAssertion();
    }

    // look into registerCooker from BlockStateModelGenerator
    // look into register() from BlockStateModelGenerator and it's Furnace registration

    /**
     * Registers an orientable variant block with boolean property.
     *
     * @param generator the block state model generator
     * @param block       the block to register
     * @param property    the boolean property used for determining the model state
     */
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

    /**
     * Registers a cube variant block with boolean property.
     *
     * @param generator the block state model generator
     * @param block       the block to register
     * @param property    the boolean property used for determining the model state
     */
    @ThanksTo(discordUsers = "Waveless")
    public static void registerCubeVariantBlock(BlockStateModelGenerator generator, Block block, BooleanProperty property)
    {
        WeightedVariant cubeOff = BlockStateModelGenerator.createWeightedVariant(TexturedModel.CUBE_ALL.upload(block, generator.modelCollector));
        WeightedVariant cubeOn = BlockStateModelGenerator.createWeightedVariant((generator.createSubModel(block, "_on", Models.CUBE_ALL, TextureMap::all)));
        BlockStateVariantMap<WeightedVariant> cubeStatus = BlockStateModelGenerator.createBooleanModelMap(property, cubeOn, cubeOff);
        generator.blockStateCollector.accept(VariantsBlockModelDefinitionCreator.of(block)
                                                                                .with(cubeStatus));
    }
}