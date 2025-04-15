package jiraiyah.jiralib.util;

import jiraiyah.jiralib.interfaces.IShapeFactory;
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

public class BlockProperties
{
    private boolean placeFacingOpposite = true;
    private BlockBlockEntityProperties<?> blockEntityProperties;
    private boolean hasComparatorOutput = false;
    private TriFunction<BlockState, World, BlockPos, Integer> comparatorOutput = (state, world, pos) -> ScreenHandler.calculateComparatorOutput(world.getBlockEntity(pos));
    private BlockRenderType renderType = BlockRenderType.MODEL;
    private IShapeFactory shapeFactory = (state, world, pos, context) -> VoxelShapes.fullCube();
    private final StateProperties stateProperties = new StateProperties();
    private BiPredicate<WorldView, BlockPos> canExistAt = (world, pos) -> true;
    private final Map<Direction, VoxelShape> cachedDirectionalShapes = new HashMap<>();

    public BlockProperties hasHorizontalFacing() {
        return hasHorizontalFacing(true);
    }

    public BlockProperties hasHorizontalFacing(boolean hasHorizontalFacing) {
        if (hasHorizontalFacing) {
            this.stateProperties.addHorizontalFacing();
        }

        return this;
    }

    public BlockProperties defaultDirection(Direction defaultDirection) {
        this.stateProperties.setDefaultValue("facing", defaultDirection);
        return this;
    }

    public BlockProperties hasAxisProperty() {
        return hasAxisProperty(true);
    }

    public BlockProperties hasAxisProperty(boolean hasAxisProperty) {
        if (hasAxisProperty) {
            this.stateProperties.addAxis();
        }

        return this;
    }

    public BlockProperties defaultAxis(Direction.Axis defaultAxis) {
        this.stateProperties.setDefaultValue("axis", defaultAxis);
        return this;
    }

    public BlockProperties hasLitProperty() {
        return hasLitProperty(true);
    }

    public BlockProperties hasLitProperty(boolean hasLitProperty) {
        if (hasLitProperty) {
            this.stateProperties.addLit();
        }

        return this;
    }

    public BlockProperties defaultLit(boolean defaultLit) {
        this.stateProperties.setDefaultValue("lit", defaultLit);
        return this;
    }

    public BlockProperties hasWaterloggableProperty() {
        return hasWaterloggableProperty(true);
    }

    public BlockProperties hasWaterloggableProperty(boolean hasWaterloggableProperty) {
        if (hasWaterloggableProperty) {
            this.stateProperties.addWaterlogged();
        }

        return this;
    }

    public BlockProperties defaultWaterlogged(boolean defaultWaterlogged) {
        this.stateProperties.setDefaultValue("waterlogged", defaultWaterlogged);
        return this;
    }

    public <T extends Comparable<T>> BlockProperties addStateProperty(Property<T> property, T defaultValue) {
        this.stateProperties.addProperty(new StateProperty<>(property, defaultValue));
        return this;
    }

    public BlockProperties addBooleanStateProperty(String name, boolean defaultValue) {
        this.stateProperties.addProperty(new StateProperty<>(BooleanProperty.of(name), defaultValue));
        return this;
    }

    public <T extends Enum<T> & StringIdentifiable> BlockProperties addEnumStateProperty(String name, Class<T> clazz, T defaultValue) {
        this.stateProperties.addProperty(new StateProperty<>(EnumProperty.of(name, clazz), defaultValue));
        return this;
    }

    public <T extends Enum<T> & StringIdentifiable> BlockProperties addEnumStateProperty(String name, Class<T> clazz, T defaultValue, List<T> values) {
        this.stateProperties.addProperty(new StateProperty<>(EnumProperty.of(name, clazz, values), defaultValue));
        return this;
    }

    public BlockProperties notPlaceFacingOpposite() {
        return placeFacingOpposite(false);
    }

    public BlockProperties placeFacingOpposite(boolean placeFacingOpposite) {
        this.placeFacingOpposite = placeFacingOpposite;
        return this;
    }

    public BlockProperties blockEntityProperties(BlockBlockEntityProperties<?> blockEntityProperties) {
        this.blockEntityProperties = blockEntityProperties;
        return this;
    }

    public BlockProperties hasComparatorOutput() {
        return hasComparatorOutput(true);
    }

    public BlockProperties hasComparatorOutput(boolean hasComparatorOutput) {
        this.hasComparatorOutput = hasComparatorOutput;
        return this;
    }

    public BlockProperties comparatorOutput(TriFunction<BlockState, World, BlockPos, Integer> comparatorOutput) {
        this.comparatorOutput = comparatorOutput;
        return this;
    }

    public BlockProperties hasBlockEntityRenderer() {
        return renderType(BlockRenderType.INVISIBLE);
    }

    public BlockProperties renderType(BlockRenderType renderType) {
        this.renderType = renderType;
        return this;
    }

    public BlockProperties emptyShape() {
        return constantShape(VoxelShapes.empty());
    }

    public BlockProperties constantShape(VoxelShape shape) {
        return shapeFactory((state, world, pos, context) -> shape);
    }

    public BlockProperties shapeFactory(IShapeFactory shapeFactory) {
        this.shapeFactory = shapeFactory;
        return this;
    }

    public BlockProperties canExistAt(BiPredicate<WorldView, BlockPos> canExistAt) {
        this.canExistAt = canExistAt;
        return this;
    }

    public BlockProperties useRotatedShapes(VoxelShape shape) {
        if(!this.stateProperties.containsProperty(Properties.HORIZONTAL_FACING)) {
            hasHorizontalFacing();
        }

        if(this.cachedDirectionalShapes.isEmpty()) {
            runShapeCalculation(this.cachedDirectionalShapes, shape);
        }

        return shapeFactory((state, world, pos, context) -> this.cachedDirectionalShapes.get(state.get(Properties.HORIZONTAL_FACING)));
    }

    public static void runShapeCalculation(Map<Direction, VoxelShape> shapeCache, VoxelShape shape) {
        for (final Direction direction : Direction.values()) {
            shapeCache.put(direction, calculateShape(direction, shape));
        }
    }

    public static VoxelShape calculateShape(Direction to, VoxelShape shape) {
        final VoxelShape[] buffer = {shape, VoxelShapes.empty()};

        final int times = (to.getHorizontalQuarterTurns() - Direction.NORTH.getHorizontalQuarterTurns() + 4) % 4;
        for (int i = 0; i < times; i++) {
            buffer[0].forEachBox((minX, minY, minZ, maxX, maxY, maxZ) ->
                                         buffer[1] = VoxelShapes.union(buffer[1],
                                                                       VoxelShapes.cuboid(1 - maxZ, minY, minX, 1 - minZ, maxY, maxX)));
            buffer[0] = buffer[1];
            buffer[1] = VoxelShapes.empty();
        }

        return buffer[0];
    }

}