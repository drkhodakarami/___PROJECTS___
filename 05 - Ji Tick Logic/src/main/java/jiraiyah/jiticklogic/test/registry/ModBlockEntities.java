package jiraiyah.jiticklogic.test.registry;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

import static jiraiyah.jiticklogic.test.Main.LOGGER;
import static jiraiyah.jiticklogic.test.Main.REFERENCE;

public class ModBlockEntities
{
    //public static BlockEntityType<WaterPumpGooBE> WATER_PUMP_GOO;

    public ModBlockEntities()
    {
        throw new AssertionError("This class should not be instantiated");
    }

    public static void init()
    {
        LOGGER.logBlockEntityInit();

        //WATER_PUMP_GOO = register("water_pump_goo", ModBlocks.WATER_PUMP_GOO, WaterPumpGooBE::new);
    }

    private static <R extends BlockEntity> BlockEntityType<R> register(String name, Block block, FabricBlockEntityTypeBuilder.Factory<R> factory)
    {
        RegistryKey<BlockEntityType<?>> key = getKey(name, RegistryKeys.BLOCK_ENTITY_TYPE);
        BlockEntityType<R> beType = FabricBlockEntityTypeBuilder.create(factory, block).build();
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, key, beType);
    }

    private static <T> RegistryKey<T> getKey(String name, RegistryKey<? extends Registry<T>> registryKey)
    {
        return RegistryKey.of(registryKey, REFERENCE.identifier(name));
    }
}