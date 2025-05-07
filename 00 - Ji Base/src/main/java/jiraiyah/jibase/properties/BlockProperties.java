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

package jiraiyah.jibase.properties;

import jiraiyah.jibase.annotations.*;
import jiraiyah.jibase.interfaces.IShapeFactory;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import org.apache.commons.lang3.function.TriFunction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiPredicate;

@Developer("TurtyWurty")
@ModifiedBy("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/DaRealTurtyWurty/Industria")
@Discord("https://discord.turtywurty.dev/")
@Youtube("https://www.youtube.com/@TurtyWurty")

public class BlockProperties
{
    private boolean placeFacingOpposite = true;
    private BlockPropertiesBE<?> blockEntityProperties;
    private boolean hasComparatorOutput = false;
    private TriFunction<BlockState, World, BlockPos, Integer> comparatorOutput = (state, world, pos) -> ScreenHandler.calculateComparatorOutput(world.getBlockEntity(pos));
    private BlockRenderType renderType = BlockRenderType.MODEL;
    private IShapeFactory shapeFactory = (state, world, pos, context) -> VoxelShapes.fullCube();
    private final StateProperties stateProperties = new StateProperties();
    private BiPredicate<WorldView, BlockPos> canExistAt = (world, pos) -> true;
    private final Map<Direction, VoxelShape> cachedDirectionalShapes = new HashMap<>();

    //region GETTERS
    public BlockPropertiesBE<?> blockEntityProperties()
    {
        return this.blockEntityProperties;
    }

    public boolean facingOpposite()
    {
        return this.placeFacingOpposite;
    }

    public boolean hasComparatorOutput()
    {
        return this.hasComparatorOutput;
    }

    public TriFunction<BlockState, World, BlockPos, Integer> comparatorOutput()
    {
        return this.comparatorOutput;
    }

    public BlockRenderType renderType()
    {
        return this.renderType;
    }

    public IShapeFactory shapeFactory()
    {
        return this.shapeFactory;
    }

    public StateProperties stateProperties()
    {
        return this.stateProperties;
    }

    public BiPredicate<WorldView, BlockPos> canExistAt()
    {
        return this.canExistAt;
    }

    public Map<Direction, VoxelShape> cachedDirectionalShapes()
    {
        return this.cachedDirectionalShapes;
    }
    //endregion

    //TODO: Remove hard coded string names for default mehtods and use property name instead
    //region SETTERS
    public BlockProperties hasHorizontalFacing()
    {
        return hasHorizontalFacing(true);
    }

    public BlockProperties hasHorizontalFacing(boolean hasHorizontalFacing)
    {
        if(stateProperties.containsProperty(Properties.FACING))
            throw new IllegalArgumentException("Cannot add horizontal facing property when facing property is already present");
        if (hasHorizontalFacing)
            this.stateProperties.addHorizontalFacing();

        return this;
    }

    public BlockProperties defaultDirection(Direction defaultDirection)
    {
        this.stateProperties.setDefaultValue("facing", defaultDirection);
        return this;
    }

    public BlockProperties hasFacing()
    {
        return hasFacing(true);
    }

    public BlockProperties hasFacing(boolean hasFacing)
    {
        if(stateProperties.containsProperty(Properties.HORIZONTAL_FACING))
            throw new IllegalArgumentException("Cannot add facing property when horizontal facing property is already present");
        if (hasFacing)
            this.stateProperties.addFacing();

        return this;
    }

    public BlockProperties hasAxisProperty()
    {
        return hasAxisProperty(true);
    }

    public BlockProperties hasAxisProperty(boolean hasAxisProperty)
    {
        if (hasAxisProperty)
            this.stateProperties.addAxis();

        return this;
    }

    public BlockProperties defaultAxis(Direction.Axis defaultAxis)
    {
        this.stateProperties.setDefaultValue("axis", defaultAxis);
        return this;
    }

    public BlockProperties hasEnabledProperty()
    {
        return hasEnabledProperty(true);
    }

    public BlockProperties hasEnabledProperty(boolean hasEnabledProperty)
    {
        if (hasEnabledProperty)
            this.stateProperties.addEnabled();

        return this;
    }

    public BlockProperties defaultEnabled(boolean defaultEnabled)
    {
        this.stateProperties.setDefaultValue("enabled", defaultEnabled);
        return this;
    }

    public BlockProperties hasLockedProperty()
    {
        return hasLockedProperty(true);
    }

    public BlockProperties hasLockedProperty(boolean hasLockedProperty)
    {
        if (hasLockedProperty)
            this.stateProperties.addLocked();

        return this;
    }

    public BlockProperties defaultLocked(boolean defaultLocked)
    {
        this.stateProperties.setDefaultValue("locked", defaultLocked);
        return this;
    }

    public BlockProperties hasPoweredProperty()
    {
        return hasPoweredProperty(true);
    }

    public BlockProperties hasPoweredProperty(boolean hasPoweredProperty)
    {
        if (hasPoweredProperty)
            this.stateProperties.addPowered();

        return this;
    }

    public BlockProperties defaultPowered(boolean defaultPowered)
    {
        this.stateProperties.setDefaultValue("powered", defaultPowered);
        return this;
    }

    public BlockProperties hasUnstableProperty()
    {
        return hasUnstableProperty(true);
    }

    public BlockProperties hasUnstableProperty(boolean hasPoweredProperty)
    {
        if (hasPoweredProperty)
            this.stateProperties.addUnstable();

        return this;
    }

    public BlockProperties defaultUnstable(boolean defaultUnstable)
    {
        this.stateProperties.setDefaultValue("unstable", defaultUnstable);
        return this;
    }

    public BlockProperties hasLitProperty()
    {
        return hasLitProperty(true);
    }

    public BlockProperties hasLitProperty(boolean hasLitProperty)
    {
        if (hasLitProperty)
            this.stateProperties.addLit();

        return this;
    }

    public BlockProperties defaultLit(boolean defaultLit)
    {
        this.stateProperties.setDefaultValue("lit", defaultLit);
        return this;
    }

    public BlockProperties hasWaterloggableProperty()
    {
        return hasWaterloggableProperty(true);
    }

    public BlockProperties hasWaterloggableProperty(boolean hasWaterloggableProperty)
    {
        if (hasWaterloggableProperty)
            this.stateProperties.addWaterlogged();

        return this;
    }

    public BlockProperties defaultWaterlogged(boolean defaultWaterlogged)
    {
        this.stateProperties.setDefaultValue("waterlogged", defaultWaterlogged);
        return this;
    }

    public BlockProperties notFacingOpposite()
    {
        return shouldFacingOpposite(false);
    }

    public BlockProperties shouldFacingOpposite(boolean placeFacingOpposite)
    {
        this.placeFacingOpposite = placeFacingOpposite;
        return this;
    }

    public BlockProperties blockEntityProperties(BlockPropertiesBE<?> blockEntityProperties)
    {
        this.blockEntityProperties = blockEntityProperties;
        return this;
    }

    public BlockProperties shouldComparatorOutput() {
        return shouldComparatorOutput(true);
    }

    public BlockProperties shouldComparatorOutput(boolean hasComparatorOutput)
    {
        this.hasComparatorOutput = hasComparatorOutput;
        return this;
    }

    public BlockProperties comparatorOutput(TriFunction<BlockState, World, BlockPos, Integer> comparatorOutput)
    {
        this.comparatorOutput = comparatorOutput;
        return this;
    }

    public BlockProperties hasBlockEntityRenderer()
    {
        return hasBlockEntityRenderer(true);
    }

    public BlockProperties hasBlockEntityRenderer(boolean isInvisible)
    {
        return isInvisible ? renderType(BlockRenderType.INVISIBLE) : renderType(BlockRenderType.MODEL);
    }

    public BlockProperties renderType(BlockRenderType renderType)
    {
        this.renderType = renderType;
        return this;
    }

    public BlockProperties constantShape() {
        return constantShape(VoxelShapes.empty());
    }

    public BlockProperties constantShape(VoxelShape shape)
    {
        return shapeFactory((state, world, pos, context) -> shape);
    }

    public BlockProperties shapeFactory(IShapeFactory shapeFactory)
    {
        this.shapeFactory = shapeFactory;
        return this;
    }

    public BlockProperties canExistAt(BiPredicate<WorldView, BlockPos> canExistAt)
    {
        this.canExistAt = canExistAt;
        return this;
    }

    public BlockProperties useRotatedShapes(VoxelShape shape)
    {
        if(!this.stateProperties.containsProperty(Properties.HORIZONTAL_FACING))
            hasHorizontalFacing();

        if(this.cachedDirectionalShapes.isEmpty())
            runShapeCalculation(this.cachedDirectionalShapes, shape);

        return shapeFactory((state, world, pos, context) -> this.cachedDirectionalShapes.get(state.get(Properties.HORIZONTAL_FACING)));
    }
    //endregion

    //region HELPER METHODS
    public static void runShapeCalculation(Map<Direction, VoxelShape> shapeCache, VoxelShape shape)
    {
        for (final Direction direction : Direction.values()) {
            shapeCache.put(direction, calculateShape(direction, shape));
        }
    }

    public static VoxelShape calculateShape(Direction to, VoxelShape shape)
    {
        // Create an array of two VoxelShapes: one for the current shape and one for building the rotated shape.
        final VoxelShape[] buffer = {shape, VoxelShapes.empty()};

        // Calculate the number of 90-degree rotations needed to align the given 'to' direction with NORTH.
        // This uses the horizontal quarter-turns difference between the 'to' direction and NORTH.
        final int times = (to.getHorizontalQuarterTurns() - Direction.NORTH.getHorizontalQuarterTurns() + 4) % 4;
        // Loop to rotate the shape the required number of times (calculated above).
        for (int i = 0; i < times; i++) {
            // Iterate through each box (cuboid) in the current shape.
            buffer[0].forEachBox((minX, minY, minZ, maxX, maxY, maxZ) ->
                                         // For each box, calculate its rotated position and add it to the second shape (buffer[1]).
                                         buffer[1] = VoxelShapes.union(buffer[1],
                                                                        VoxelShapes.cuboid(1 - maxZ, minY, minX, 1 - minZ, maxY, maxX)));
            // After processing all boxes, update buffer[0] to be the newly rotated shape.
            buffer[0] = buffer[1];
            // Reset buffer[1] to an empty shape for the next rotation iteration.
            buffer[1] = VoxelShapes.empty();
        }
        // Return the final rotated shape after the loop.
        return buffer[0];
    }

    public <T extends Comparable<T>> BlockProperties addStateProperty(Property<T> property, T defaultValue)
    {
        this.stateProperties.addProperty(new StateProperty<>(property, defaultValue));
        return this;
    }

    public BlockProperties addBooleanStateProperty(String name, boolean defaultValue)
    {
        this.stateProperties.addProperty(new StateProperty<>(BooleanProperty.of(name), defaultValue));
        return this;
    }

    public <T extends Enum<T> & StringIdentifiable> BlockProperties addEnumStateProperty(String name, Class<T> clazz, T defaultValue)
    {
        this.stateProperties.addProperty(new StateProperty<>(EnumProperty.of(name, clazz), defaultValue));
        return this;
    }

    public <T extends Enum<T> & StringIdentifiable> BlockProperties addEnumStateProperty(String name, Class<T> clazz, T defaultValue, List<T> values)
    {
        this.stateProperties.addProperty(new StateProperty<>(EnumProperty.of(name, clazz, values), defaultValue));
        return this;
    }
    //endregion
}