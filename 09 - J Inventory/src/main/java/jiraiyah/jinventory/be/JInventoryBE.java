package jiraiyah.jinventory.be;

import jiraiyah.jibase.annotations.*;
import jiraiyah.jibase.constants.BEKeys;
import jiraiyah.jibase.enumerations.MappedDirection;
import jiraiyah.jibase.interfaces.IStorageProvider;
import jiraiyah.jibase.records.BlockPosPayload;
import jiraiyah.jinventory.base.InventoryConnector;
import jiraiyah.jinventory.interfaces.IContentDrop;
import jiraiyah.jinventory.storage.OutputInventory;
import jiraiyah.jiralib.block.JiBlock;
import jiraiyah.jiralib.blockentity.JiScreenBE;
import net.fabricmc.fabric.api.transfer.v1.item.InventoryStorage;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

@SuppressWarnings("unused")
@Developer("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/drkhodakarami/___PROJECTS___")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")
public abstract class JInventoryBE<T extends JInventoryBE<T, B>, B extends SimpleInventory> extends JiScreenBE<T, BlockPosPayload>
    implements IContentDrop<B>
{
    protected final InventoryConnector<B> inventory;

    public JInventoryBE(BlockEntityType<T> type, BlockPos pos, BlockState state)
    {
        super(type, pos, state);
        inventory = new InventoryConnector<>();
        this.properties.update()
                        .sync()
                        .waitEndTick();
    }

    @Override
    public BlockPosPayload getScreenOpeningData(ServerPlayerEntity serverPlayerEntity)
    {
        return new BlockPosPayload(this.pos);
    }

    @Override
    public InventoryConnector<B> getInventoryConnector()
    {
        return inventory;
    }

    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registries)
    {
        super.readNbt(nbt, registries);
        if(nbt.contains("jinventory." + BEKeys.HAS_INVENTORY))
            nbt.getList("jinventory." + BEKeys.HAS_INVENTORY)
               .ifPresent(nbtElements -> inventory.readNbt(nbtElements, registries));
    }

    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registries)
    {
        super.writeNbt(nbt, registries);
        nbt.put("jinventory" + BEKeys.HAS_INVENTORY, inventory.writeNbt(registries));
    }

    @Override
    public void onBlockReplaced(BlockPos pos, BlockState oldState)
    {
        if(world == null || !(world.getBlockState(pos).getBlock() instanceof JiBlock block))
            return;
        if(block.hasInventory())
        {
            if(!oldState.isOf(world.getBlockState(pos).getBlock()))
                this.dropContent(world, pos);
        }
    }

    public InventoryStorage getInventoryStorage(Direction direction)
    {
        if(world == null)
            return null;
        if(world.getBlockState(pos).getProperties().contains(Properties.FACING))
            return this.inventory.getStorageProvider(direction, world.getBlockState(pos).get(Properties.FACING));
        return this.inventory.getStorage(direction);
    }

    public InventoryStorage getInventoryStorage(MappedDirection direction)
    {
        return getInventoryStorage(MappedDirection.toDirection(direction));
    }
}