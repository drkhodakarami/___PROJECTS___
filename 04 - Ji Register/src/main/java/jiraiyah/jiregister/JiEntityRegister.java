package jiraiyah.jiregister;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

public class JiEntityRegister
{
    private final String modId;

    public JiEntityRegister(String modId)
    {
        this.modId = modId;
    }

    public <R extends BlockEntity> BlockEntityType<R> register(String name, Block block, FabricBlockEntityTypeBuilder.Factory<R> factory)
    {
        RegistryKey<BlockEntityType<?>> key = RegistryHelper.getKey(this.modId, name, RegistryKeys.BLOCK_ENTITY_TYPE);
        BlockEntityType<R> beType = FabricBlockEntityTypeBuilder.create(factory, block).build();
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, key, beType);
    }

    public <R extends Entity> EntityType<R> register(String name, SpawnGroup spawnGroup, EntityType.EntityFactory<R> factory)
    {
        RegistryKey<EntityType<?>> key = RegistryHelper.getKey(this.modId, name, RegistryKeys.ENTITY_TYPE);
        EntityType<R> entityType = EntityType.Builder.create(factory, spawnGroup).build(key);
        return Registry.register(Registries.ENTITY_TYPE, key, entityType);
    }
}