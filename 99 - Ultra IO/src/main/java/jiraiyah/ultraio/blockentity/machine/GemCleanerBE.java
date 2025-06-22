package jiraiyah.ultraio.blockentity.machine;

//TODO: Add Fluid
//TODO: Add Energy
//TODO: Add Custom Recipe
//TODO: Add Custom Recipe Datagen

import jiraiyah.jibase.enumerations.MappedDirection;
import jiraiyah.jibase.records.BlockPosPayload;
import jiraiyah.jinventory.be.JInventoryBE;
import jiraiyah.jinventory.inventories.OutputInventory;
import jiraiyah.jinventory.inventories.PredicateInventory;
import jiraiyah.jinventory.inventories.SyncedInventory;
import jiraiyah.jiralib.blockentity.JiScreenBE;
import jiraiyah.ultraio.blockentity.machine.ticklogic.GemCleanerTL;
import jiraiyah.ultraio.registry.ModBlockEntities;
import jiraiyah.ultraio.registry.ModItems;
import jiraiyah.ultraio.screen.handler.GemCleanerSH;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.fluid.base.SingleFluidStorage;
import net.fabricmc.fabric.api.transfer.v1.item.InventoryStorage;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
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
            return FluidConstants.BUCKET * 10 + FluidConstants.BUCKET * GemCleanerBE.this.getFluidUpgrdeCount();
        }

        @Override
        protected void onFinalCommit()
        {
            update();
        }
    };

    public GemCleanerBE(BlockPos pos, BlockState state)
    {
        super(ModBlockEntities.GEM_CLEANER, pos, state);
        this.properties.setTickLogic(new GemCleanerTL());

        this.inventory.addInventory(this, 2, MappedDirection.DOWN, OutputInventory::new);
        this.inventory.addInventory(this, 2, MappedDirection.UP, SyncedInventory::new);
        this.inventory.addInventory(this, 3, MappedDirection.EAST, SyncedInventory::new);
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
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registries)
    {
        super.writeNbt(nbt, registries);
        this.fluidStorage.writeNbt(nbt, registries);
    }

    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registries)
    {
        super.readNbt(nbt, registries);
        this.fluidStorage.readNbt(nbt, registries);
    }

    private int getFluidUpgrdeCount()
    {
        return 2;
    }
}