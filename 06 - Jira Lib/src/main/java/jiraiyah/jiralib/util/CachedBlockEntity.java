package jiraiyah.jiralib.util;

import jiraiyah.jibase.annotations.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.math.BlockPos;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

@Developer("TurtyWurty")
@ModifiedBy("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/DaRealTurtyWurty/Industria")
@Discord("https://discord.turtywurty.dev/")
@Youtube("https://www.youtube.com/@TurtyWurty")

public class CachedBlockEntity <T extends BlockEntity> implements BiFunction<PlayerInventory, BlockPos, T>
{
    private final Class<T> beClass;
    private final Map<BlockPos, T> cache = new HashMap<>();

    public CachedBlockEntity(Class<T> beClass)
    {
        this.beClass = beClass;
    }

    @Override
    public T apply(PlayerInventory playerInventory, BlockPos blockPos)
    {
        if(cache.containsKey(blockPos))
            return cache.get(blockPos);

        BlockEntity blockEntity = playerInventory.player.getWorld().getBlockEntity(blockPos);
        if(beClass.isInstance(blockEntity))
        {
            T castedBE = beClass.cast(blockEntity);
            cache.put(blockPos, castedBE);
            return castedBE;
        }
        else
            throw new IllegalArgumentException("Block entity at " + blockPos + " is not of type " + beClass.getSimpleName());
    }
}