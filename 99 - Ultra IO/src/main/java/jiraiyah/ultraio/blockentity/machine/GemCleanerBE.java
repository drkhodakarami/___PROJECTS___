package jiraiyah.ultraio.blockentity.machine;

//TODO: Add Fluid
//TODO: Add Energy
//TODO: Add Custom Recipe
//TODO: Add Custom Recipe Datagen

import jiraiyah.jibase.enumerations.MappedDirection;
import jiraiyah.jibase.utils.PosHelper;
import jiraiyah.jinventory.be.JInventoryBE;
import jiraiyah.jinventory.storage.OutputInventory;
import jiraiyah.jinventory.storage.SyncedInventory;
import jiraiyah.ultraio.blockentity.machine.ticklogic.GemCleanerTL;
import jiraiyah.ultraio.registry.ModBlockEntities;
import jiraiyah.ultraio.screen.handler.GemCleanerSH;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.fluid.base.SingleFluidStorage;
import net.fabricmc.fabric.api.transfer.v1.item.InventoryStorage;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.fluid.Fluids;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.state.property.Properties;
import net.minecraft.storage.ReadView;
import net.minecraft.storage.WriteView;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.Nullable;

import static jiraiyah.ultraio.Main.REFERENCE;

// Ideas :
// - It uses water
// - It will clean raw gem and give 3 gems per raw item
// - It will use different amount of water to clean different types of gems
// - It can accept upgrades for water / speed / energy
// - Default water capacity is 10 buckets
// - Default speed changes for gems but the smallest time is 10 seconds
// - Default energy capacity is 5k
public class GemCleanerBE extends JInventoryBE<GemCleanerBE, SimpleInventory>
{
    public static final int INVENTORY_SIZE = 7;

    public static final int OUTPUT_INVENTORY_INDEX = 0;
    public static final int INPUT_INVENTORY_INDEX = 1;
    public static final int UPGRADE_INPUT_INVENTORY_INDEX = 2;

    public static final int OUTPUT_SLOT = 0; // Output slot for cleaned gems
    public static final int EMPTY_BUCKET_SLOT = 1; // Slot for empty bucket storage

    public static final int GEM_INPUT_SLOT = 0; // Input slot for raw gems
    public static final int WATER_BUCKET_SLOT = 1; // Input slot for water buckets

    public static final int ENERGY_UPGRADE_SLOT = 0; // Input slot for energy upgrades
    public static final int SPEED_UPGRADE_SLOT = 1; // Input slot for speed upgrades
    public static final int FLUID_UPGRADE_SLOT = 2; // Input slot for fluid upgrades

    //private final SingleFluidStorage fluidStorage = SingleFluidStorage.withFixedCapacity(FluidConstants.BUCKET * 10, this::update);

    private final SingleFluidStorage fluidStorage = new SingleFluidStorage()
    {
        @Override
        protected long getCapacity(FluidVariant variant)
        {
            return FluidConstants.BUCKET * 10 + FluidConstants.BUCKET * GemCleanerBE.this.getFluidUpgradeCount();
        }

        @Override
        protected void onFinalCommit()
        {
            update();
        }

        @Override
        public FluidVariant getResource()
        {
            return FluidVariant.of(Fluids.WATER);
        }
    };

    public GemCleanerBE(BlockPos pos, BlockState state)
    {
        super(ModBlockEntities.GEM_CLEANER, pos, state);
        this.properties.setTickLogic(new GemCleanerTL());

        this.inventory.addStorage(this, 2, MappedDirection.DOWN, OutputInventory::new);
        this.inventory.addStorage(this, 2, MappedDirection.UP, SyncedInventory::new);
        this.inventory.addStorage(this, 3, MappedDirection.EAST, SyncedInventory::new);
    }

    @Override
    public Text getDisplayName()
    {
        return REFERENCE.translateContainer("gem.cleaner");
    }

    @Override
    public @Nullable ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player)
    {
        return new GemCleanerSH(syncId, playerInventory, this.inventory, this);//TODO: propertyDelegate
    }

    public SingleFluidStorage getFluidStorage(Direction direction)
    {
        return fluidStorage;
    }

    @Override
    protected void writeData(WriteView view)
    {
        super.writeData(view);
        this.fluidStorage.writeData(view);
    }

    @Override
    protected void readData(ReadView view)
    {
        super.readData(view);
        this.fluidStorage.readData(view);
    }

    private int getFluidUpgradeCount()
    {
        return 2;
    }

    public InventoryStorage getInventoryStorage(Direction direction) {
        if(this.world.getBlockState(this.pos).getProperties().contains(Properties.HORIZONTAL_FACING))
        {
            var facing = this.world.getBlockState(this.pos).get(Properties.HORIZONTAL_FACING);
            Direction side = PosHelper.relativeDirection(direction, facing);
        }
        if (this.world == null) {
            return null;
        } else {
            return this.world.getBlockState(this.pos).getProperties().contains(Properties.FACING)
                   ? this.getStorageProvider(direction, this.world.getBlockState(this.pos).get(Properties.FACING))
                    : this.world.getBlockState(this.pos).getProperties().contains(Properties.HORIZONTAL_FACING)
                        ? this.getStorageProvider(direction, this.world.getBlockState(this.pos).get(Properties.HORIZONTAL_FACING))
                        : this.inventory.getStorage(direction);
        }
    }

    public InventoryStorage getStorageProvider(Direction direction, Direction facing) {
        Direction side = relativeDirection(direction, facing);
        return this.inventory.getSidedMap().containsKey(MappedDirection.fromDirection(side)) ? (InventoryStorage)this.inventory.getStorage(side) : null;
    }

    public static Direction relativeDirection(@Nullable Direction direction, @Nullable Direction facing) {
        if (direction == null)
            return null;
        if (facing == null)
            return direction;

        Direction relative = direction;

        // If looking straight up or down, and the input direction is vertical,
        // return the direction as is
        if (direction.getAxis().isVertical() && facing.getAxis().isVertical()) {
            return direction;
        }

        // Handle vertical facings
        if (facing == Direction.UP)
            // When looking up, rotate once counterclockwise
            return direction.rotateYCounterclockwise();
        if (facing == Direction.DOWN)
            // When looking down, rotate once clockwise
            return direction.rotateYClockwise();
        // Calculate rotations based on facing direction
        switch (facing) {
            case SOUTH: // 180 degrees from north, need 2 rotations
                relative = relative.rotateYClockwise().rotateYClockwise();
                break;
            case EAST:  // 270 degrees from north, need 1 rotation counterclockwise
                relative = relative.rotateYCounterclockwise();
                break;
            case WEST:  // 90 degrees from north, need 1 rotation clockwise
                relative = relative.rotateYClockwise();
                break;
            case NORTH: // no rotation needed
            default:
                break;
        }

        return relative;
    }
}