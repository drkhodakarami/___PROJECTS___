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

import jiraiyah.jibase.interfaces.IBEFactory;
import jiraiyah.jibase.interfaces.IBETickerFactory;
import jiraiyah.jibase.interfaces.IShapeFactory;
import jiraiyah.jibase.interfaces.ITick;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
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
import java.util.function.Supplier;

public class BlockProperties<T extends BlockEntity>
{
    private boolean placeFacingOpposite;
    private boolean hasComparatorOutput;
    private TriFunction<BlockState, World, BlockPos, Integer> comparatorOutput;
    private BlockRenderType renderType;
    private IShapeFactory shapeFactory;
    private final StateProperties stateProperties;
    private BiPredicate<WorldView, BlockPos> canExistAt;
    private final Map<Direction, VoxelShape> cachedDirectionalShapes;

    private final Supplier<BlockEntityType<T>> blockEntityTypeSupplier;
    private boolean shouldTick;
    private final IBEFactory<T> blockEntityFactory;
    private final IBETickerFactory<T> blockEntityTicker;
    //private MultiblockProperties<T> multiblockProperties;
    private boolean rightClickToOpenGui = false;
    private boolean dropContentsOnBreak = false;

    public BlockProperties(Supplier<BlockEntityType<T>> blockEntityTypeSupplier)
    {
        placeFacingOpposite = true;
        hasComparatorOutput = false;
        comparatorOutput = (state, world, pos) -> ScreenHandler.calculateComparatorOutput(world.getBlockEntity(pos));
        renderType = BlockRenderType.MODEL;
        shapeFactory = (state, world, pos, context) -> VoxelShapes.fullCube();
        stateProperties = new StateProperties();
        canExistAt = (world, pos) -> true;
        cachedDirectionalShapes = new HashMap<>();

        this.blockEntityTypeSupplier = blockEntityTypeSupplier;
        shouldTick = false;
        rightClickToOpenGui = false;
        dropContentsOnBreak = false;

        if(blockEntityTypeSupplier != null && blockEntityTypeSupplier.get() == null)
        {
            this.blockEntityFactory = (pos, state) -> this.blockEntityTypeSupplier.get().instantiate(pos, state);
            this.blockEntityTicker = (world, state, type) -> ITick.createTicker(world);
        }
        else
        {
            this.blockEntityFactory = null;
            this.blockEntityTicker = null;
        }
    }

    //region GETTERS

    //region BLOCK

    public boolean hasComparatorOutput()
    {
        return this.hasComparatorOutput;
    }

    public boolean hasHorizontalFacing()
    {
        return this.stateProperties.containsProperty(Properties.HORIZONTAL_FACING);
    }

    public boolean hasFacing()
    {
        return this.stateProperties.containsProperty(Properties.FACING);
    }

    public boolean hasAxisProperty()
    {
        return this.stateProperties.containsProperty(Properties.AXIS);
    }

    public boolean hasEnabledProperty()
    {
        return this.stateProperties.containsProperty(Properties.ENABLED);
    }

    public boolean hasLockedProperty()
    {
        return this.stateProperties.containsProperty(Properties.LOCKED);
    }

    public boolean hasPoweredProperty()
    {
        return this.stateProperties.containsProperty(Properties.POWERED);
    }

    public boolean hasUnstableProperty()
    {
        return this.stateProperties.containsProperty(Properties.UNSTABLE);
    }

    public boolean hasLitProperty()
    {
        return this.stateProperties.containsProperty(Properties.LIT);
    }

    public boolean hasWaterloggedProperty()
    {
        return this.stateProperties.containsProperty(Properties.WATERLOGGED);
    }

    public boolean isFacingOpposite()
    {
        return this.placeFacingOpposite;
    }

    public TriFunction<BlockState, World, BlockPos, Integer> getComparatorOutput()
    {
        return this.comparatorOutput;
    }

    public BlockRenderType getRenderType()
    {
        return this.renderType;
    }

    public IShapeFactory getShapeFactory()
    {
        return this.shapeFactory;
    }

    public StateProperties getStateProperties()
    {
        return this.stateProperties;
    }

    public Map<Direction, VoxelShape> getCachedDirectionalShapes()
    {
        return this.cachedDirectionalShapes;
    }

    public BiPredicate<WorldView, BlockPos> canExistAt()
    {
        return this.canExistAt;
    }

    //endregion

    //region BLOCK ENTITY

    public Supplier<BlockEntityType<T>> getBETypeSupplier()
    {
        return this.blockEntityTypeSupplier;
    }

    public BlockEntityType<T> getBEType()
    {
        if(this.blockEntityTypeSupplier == null || this.blockEntityTypeSupplier.get() == null)
            return null;
        return this.blockEntityTypeSupplier.get();
    }

    public boolean isTickable()
    {
        return this.shouldTick;
    }

    public IBEFactory<T> getBEFactory()
    {
        return this.blockEntityFactory;
    }

    public IBETickerFactory<T> getBETicker()
    {
        return this.blockEntityTicker;
    }

    public boolean hasGUI()
    {
        return this.rightClickToOpenGui;
    }

    public boolean hasInventory()
    {
        return this.dropContentsOnBreak;
    }

    //endregion

    //endregion

    //region SETTERS

    //region BLOCK

    public BlockProperties<T> addHorizontalFacing()
    {
        return setHorizontalFacing(true);
    }

    public BlockProperties<T> setHorizontalFacing(boolean flag)
    {
        if(stateProperties.containsProperty(Properties.FACING))
            throw new IllegalArgumentException("Cannot add horizontal facing property when facing property is already present");
        if (flag)
            this.stateProperties.addHorizontalFacing();

        return this;
    }

    public BlockProperties<T> setDefaultDirection(Direction defaultDirection)
    {
        this.stateProperties.setDefaultValue("facing", defaultDirection);
        return this;
    }

    public BlockProperties<T> addFacing()
    {
        return setFacing(true);
    }

    public BlockProperties<T> setFacing(boolean flag)
    {
        if(stateProperties.containsProperty(Properties.HORIZONTAL_FACING))
            throw new IllegalArgumentException("Cannot add facing property when horizontal facing property is already present");
        if (flag)
            this.stateProperties.addFacing();

        return this;
    }

    public BlockProperties<T> addAxisProperty()
    {
        return setAxisProperty(true);
    }

    public BlockProperties<T> setAxisProperty(boolean flag)
    {
        if (flag)
            this.stateProperties.addAxis();

        return this;
    }

    public BlockProperties<T> setDefaultAxis(Direction.Axis defaultAxis)
    {
        this.stateProperties.setDefaultValue("axis", defaultAxis);
        return this;
    }

    public BlockProperties<T> addEnabledProperty()
    {
        return setEnabledProperty(true);
    }

    public BlockProperties<T> setEnabledProperty(boolean flag)
    {
        if (flag)
            this.stateProperties.addEnabled();

        return this;
    }

    public BlockProperties<T> setDefaultEnabled(boolean flag)
    {
        this.stateProperties.setDefaultValue("enabled", flag);
        return this;
    }

    public BlockProperties<T> addLockedProperty()
    {
        return setLockedProperty(true);
    }

    public BlockProperties<T> setLockedProperty(boolean flag)
    {
        if (flag)
            this.stateProperties.addLocked();

        return this;
    }

    public BlockProperties<T> setDefaultLocked(boolean flag)
    {
        this.stateProperties.setDefaultValue("locked", flag);
        return this;
    }

    public BlockProperties<T> addPoweredProperty()
    {
        return setPoweredProperty(true);
    }

    public BlockProperties<T> setPoweredProperty(boolean flag)
    {
        if (flag)
            this.stateProperties.addPowered();

        return this;
    }

    public BlockProperties<T> setDefaultPowered(boolean flag)
    {
        this.stateProperties.setDefaultValue("powered", flag);
        return this;
    }

    public BlockProperties<T> addUnstableProperty()
    {
        return setUnstableProperty(true);
    }

    public BlockProperties<T> setUnstableProperty(boolean flag)
    {
        if (flag)
            this.stateProperties.addUnstable();

        return this;
    }

    public BlockProperties<T> setDefaultUnstable(boolean flag)
    {
        this.stateProperties.setDefaultValue("unstable", flag);
        return this;
    }

    public BlockProperties<T> addLitProperty()
    {
        return setLitProperty(true);
    }

    public BlockProperties<T> setLitProperty(boolean flag)
    {
        if (flag)
            this.stateProperties.addLit();

        return this;
    }

    public BlockProperties<T> setDefaultLit(boolean flag)
    {
        this.stateProperties.setDefaultValue("lit", flag);
        return this;
    }

    public BlockProperties<T> addWaterloggableProperty()
    {
        return setWaterloggableProperty(true);
    }

    public BlockProperties<T> setWaterloggableProperty(boolean flag)
    {
        if (flag)
            this.stateProperties.addWaterlogged();

        return this;
    }

    public BlockProperties<T> setDefaultWaterlogged(boolean flag)
    {
        this.stateProperties.setDefaultValue("waterlogged", flag);
        return this;
    }

    public BlockProperties<T> notFacingOpposite()
    {
        return setFacingOpposite(false);
    }

    public BlockProperties<T> facingOpposite()
    {
        return setFacingOpposite(true);
    }

    public BlockProperties<T> setFacingOpposite(boolean flag)
    {
        this.placeFacingOpposite = flag;
        return this;
    }

    public BlockProperties<T> addComparatorOutput() {
        return setComparatorOutput(true);
    }

    public BlockProperties<T> setComparatorOutput(boolean flag)
    {
        this.hasComparatorOutput = flag;
        return this;
    }

    public BlockProperties<T> setComparatorOutput(TriFunction<BlockState, World, BlockPos, Integer> comparatorOutput)
    {
        this.comparatorOutput = comparatorOutput;
        return this;
    }

    public BlockProperties<T> addInvisibleRenderer()
    {
        return setInvisibleRenderer(true);
    }

    public BlockProperties<T> setInvisibleRenderer(boolean flag)
    {
        return flag ? setRenderType(BlockRenderType.INVISIBLE) : setRenderType(BlockRenderType.MODEL);
    }

    public BlockProperties<T> setRenderType(BlockRenderType renderType)
    {
        this.renderType = renderType;
        return this;
    }

    public BlockProperties<T> addEmptyShape() {
        return setConstantShape(VoxelShapes.empty());
    }

    public BlockProperties<T> setConstantShape(VoxelShape shape)
    {
        return setShapeFactory((state, world, pos, context) -> shape);
    }

    public BlockProperties<T> setShapeFactory(IShapeFactory shapeFactory)
    {
        this.shapeFactory = shapeFactory;
        return this;
    }

    public BlockProperties<T> addRotatedShapes(VoxelShape shape)
    {
        if(!this.stateProperties.containsProperty(Properties.HORIZONTAL_FACING))
            addHorizontalFacing();

        if(this.cachedDirectionalShapes.isEmpty())
            runShapeCalculation(this.cachedDirectionalShapes, shape);

        return setShapeFactory((state, world, pos, context) -> this.cachedDirectionalShapes.get(state.get(Properties.HORIZONTAL_FACING)));
    }

    public BlockProperties<T> canExistAt(BiPredicate<WorldView, BlockPos> canExistAt)
    {
        this.canExistAt = canExistAt;
        return this;
    }

    //endregion

    //region BLOCK ENTITY

    public BlockProperties<T> tick()
    {
        if(blockEntityTypeSupplier == null || blockEntityTypeSupplier.get() == null)
            throw new IllegalArgumentException("BlockEntityType supplier cannot be null or return null when you want a ticking block entity!");
        return tick(true);
    }

    public BlockProperties<T> tick(boolean flag)
    {
        if(blockEntityTypeSupplier == null || blockEntityTypeSupplier.get() == null)
            throw new IllegalArgumentException("BlockEntityType supplier cannot be null or return null when you want a ticking block entity!");
        this.shouldTick = flag;
        return this;
    }

    public BlockProperties<T> addGui()
    {
        if(blockEntityTypeSupplier == null || blockEntityTypeSupplier.get() == null)
            throw new IllegalArgumentException("BlockEntityType supplier cannot be null or return null when you want a gui on block entity!");
        return addGui(true);
    }

    public BlockProperties<T> addGui(boolean flag)
    {
        if(blockEntityTypeSupplier == null || blockEntityTypeSupplier.get() == null)
            throw new IllegalArgumentException("BlockEntityType supplier cannot be null or return null when you want a gui on block entity!");
        this.rightClickToOpenGui = flag;
        return this;
    }

    public BlockProperties<T> addInventory()
    {
        if(blockEntityTypeSupplier == null || blockEntityTypeSupplier.get() == null)
            throw new IllegalArgumentException("BlockEntityType supplier cannot be null or return null when you want an inventory on block entity!");
        return addInventory(true);
    }

    public BlockProperties<T> addInventory(boolean flag)
    {
        if(blockEntityTypeSupplier == null || blockEntityTypeSupplier.get() == null)
            throw new IllegalArgumentException("BlockEntityType supplier cannot be null or return null when you want an inventory on block entity!");
        this.dropContentsOnBreak = flag;
        return this;
    }

    //endregion

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

    public <U extends Comparable<U>> BlockProperties<T> addStateProperty(Property<U> property, U defaultValue)
    {
        this.stateProperties.addProperty(new StateProperty<>(property, defaultValue));
        return this;
    }

    public BlockProperties<T> addBooleanStateProperty(String name, boolean defaultValue)
    {
        this.stateProperties.addProperty(new StateProperty<>(BooleanProperty.of(name), defaultValue));
        return this;
    }

    public <U extends Enum<U> & StringIdentifiable> BlockProperties<T> addEnumStateProperty(String name, Class<U> clazz, U defaultValue)
    {
        this.stateProperties.addProperty(new StateProperty<>(EnumProperty.of(name, clazz), defaultValue));
        return this;
    }

    public <U extends Enum<U> & StringIdentifiable> BlockProperties<T> addEnumStateProperty(String name, Class<U> clazz, U defaultValue, List<U> values)
    {
        this.stateProperties.addProperty(new StateProperty<>(EnumProperty.of(name, clazz, values), defaultValue));
        return this;
    }
    //endregion
}