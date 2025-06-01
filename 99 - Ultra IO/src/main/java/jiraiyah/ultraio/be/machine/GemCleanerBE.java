package jiraiyah.ultraio.be.machine;

//TODO: Add GUI
//TODO: Add Inventory
//TODO: Add Fluid
//TODO: Add Energy
//TODO: Add Custom Recipe
//TODO: Add Custom Recipe Datagen

import jiraiyah.jiralib.blockentity.ScreenSyncedBE;
import jiraiyah.jiralib.record.BlockPosPayload;
import jiraiyah.ultraio.be.machine.ticklogic.GemCleanerTL;
import jiraiyah.ultraio.registry.ModBlockEntities;
import jiraiyah.ultraio.screen.handler.GemCleanerScreenHandler;
import net.fabricmc.fabric.api.transfer.v1.item.InventoryStorage;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

import static jiraiyah.ultraio.Main.REFERENCE;

// Ideas :
// - It uses water
// - It will clean raw gem and give 3 gems per raw item
// - It will use different amount of water to clean different types of gems
// - It can accept upgrades for water / speed / energy
// - Default water capacity is 10 buckets
// - Default speed changes for gems but the smallest time is 10 seconds
// - Default energy capacity is 5k
public class GemCleanerBE extends ScreenSyncedBE<GemCleanerBE, BlockPosPayload>
{
    public static final int INVENTORY_SIZE = 7; // 6 input slots + 1 output slot

    public static final int GEM_INPUT_SLOT = 0; // Input slot for raw gems
    public static final int WATER_BUCKET_SLOT = 1; // Input slot for water buckets
    public static final int ENERGY_UPGRADE_SLOT = 2; // Input slot for energy upgrades
    public static final int SPEED_UPGRADE_SLOT = 3; // Input slot for speed upgrades
    public static final int FLUID_UPGRADE_SLOT = 4; // Input slot for fluid upgrades
    public static final int OUTPUT_SLOT = 5; // Output slot for cleaned gems
    public static final int EMPTY_BUCKET_SLOT = 6; // Slot for empty bucket storage

    private final SimpleInventory inventory = new SimpleInventory(INVENTORY_SIZE)
    {
        @Override
        public void markDirty()
        {
            //super.markDirty();
            update();
        }
    };

    private final InventoryStorage inventoryStorage = InventoryStorage.of(this.inventory, null);

    public GemCleanerBE(BlockPos pos, BlockState state)
    {
        super(ModBlockEntities.GEM_CLEANER, pos, state);
        this.properties.tickLogic(new GemCleanerTL());
    }

    @Override
    public BlockPosPayload getScreenOpeningData(ServerPlayerEntity serverPlayerEntity)
    {
        return new BlockPosPayload(this.pos);
    }

    @Override
    public Text getDisplayName()
    {
        return REFERENCE.translateContainer("gem.cleaner");
    }

    @Override
    public @Nullable ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player)
    {
        return new GemCleanerScreenHandler(syncId, playerInventory, this);//TODO: propertyDelegate
    }

    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registries)
    {
        super.readNbt(nbt, registries);
        if(nbt.contains(REFERENCE.hasInventoryKey()))
            nbt.getCompound(REFERENCE.hasInventoryKey())
               .ifPresent(compound -> Inventories.readNbt(compound, this.inventory.getHeldStacks(), registries));
    }

    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registries)
    {
        super.writeNbt(nbt, registries);
        var compound = new NbtCompound();
        Inventories.writeNbt(compound, this.inventory.getHeldStacks(), registries );
        nbt.put(REFERENCE.hasInventoryKey(), compound);
    }

    public SimpleInventory getInventory()
    {
        return this.inventory;
    }

    public InventoryStorage getInventoryStorage()
    {
        return this.inventoryStorage;
    }

    public InventoryStorage getInventoryProvider(Direction direction)
    {
        return this.inventoryStorage;
    }
}