package jiraiyah.jinventory;

import jiraiyah.jibase.annotations.*;
import jiraiyah.jibase.interfaces.ISync;
import jiraiyah.jiralib.blockentity.UpdatableBE;
import net.minecraft.item.ItemStack;

import java.util.List;

@Developer("TurtyWurty")
@ModifiedBy("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/DaRealTurtyWurty/Industria")
@Discord("https://discord.turtywurty.dev/")
@Youtube("https://www.youtube.com/@TurtyWurty")

public class SyncedSimpleInventory extends RecipeSimpleInventory implements ISync
{
    private final UpdatableBE<?> blockEntity;
    private boolean isDirty = false;

    public SyncedSimpleInventory(UpdatableBE<?> blockEntity, int size)
    {
        super(size);
        this.blockEntity = blockEntity;
    }

    public SyncedSimpleInventory(UpdatableBE<?> blockEntity, ItemStack... items)
    {
        super(items);
        this.blockEntity = blockEntity;
    }

    @Override
    public void sync()
    {
        if(this.isDirty && this.blockEntity != null && this.blockEntity.hasWorld() && !this.blockEntity.getWorld().isClient)
        {
            this.isDirty = false;
            this.blockEntity.update();
        }
    }

    @Override
    public void markDirty()
    {
        super.markDirty();
        this.isDirty = true;
    }

    @Override
    public List<ISync> getSyncables()
    {
        return List.of(this);
    }

    public UpdatableBE<?> getBlockEntity()
    {
        return this.blockEntity;
    }
}