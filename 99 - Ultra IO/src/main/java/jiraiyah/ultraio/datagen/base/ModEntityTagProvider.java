package jiraiyah.ultraio.datagen.base;

import jiraiyah.ultraio.Main;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.entity.EntityType;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

import static jiraiyah.ultraio.Main.REFERENCE;

public class ModEntityTagProvider extends FabricTagProvider.EntityTypeTagProvider
{
    public ModEntityTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture)
    {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup)
    {
        Main.LOGGER.logEntityTagDatagen();

        getOrCreateTagBuilder(REFERENCE.TUNER_BLACKLIST)
                .add(EntityType.ENDER_DRAGON);

        getOrCreateTagBuilder(REFERENCE.ENDERITE_SWORD_BLACKLIST)
                .add(EntityType.ENDER_DRAGON)
                .add(EntityType.WITHER)
                .add(EntityType.WARDEN);

        getOrCreateTagBuilder(REFERENCE.RUBY_SWORD_WHITELIST)
                .add(EntityType.CAMEL)
                .add(EntityType.CHICKEN)
                .add(EntityType.DONKEY)
                .add(EntityType.COW)
                .add(EntityType.FOX)
                .add(EntityType.GOAT)
                .add(EntityType.HORSE)
                .add(EntityType.LLAMA)
                .add(EntityType.MOOSHROOM)
                .add(EntityType.MULE)
                .add(EntityType.PANDA)
                .add(EntityType.PIG)
                .add(EntityType.POLAR_BEAR)
                .add(EntityType.RABBIT)
                .add(EntityType.SHEEP)
                .add(EntityType.SNIFFER)
                .add(EntityType.WOLF);
    }
}