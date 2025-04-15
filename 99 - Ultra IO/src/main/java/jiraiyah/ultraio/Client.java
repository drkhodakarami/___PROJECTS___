package jiraiyah.ultraio;

import jiraiyah.ultraio.registry.ModBlocks;
import jiraiyah.ultraio.registry.ModMessages;
import jiraiyah.ultraio.registry.ModModelPredicate;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

import static jiraiyah.ultraio.Main.LOGGER;

public class Client implements ClientModInitializer
{
    @Override
    public void onInitializeClient()
    {
        LOGGER.logClient();

        ModMessages.initS2CPackets();
        ModModelPredicate.init();

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CITRINE_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CITRINE_TRAP_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ENDERITE_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ENDERITE_TRAP_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RUBY_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RUBY_TRAP_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SAPPHIRE_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SAPPHIRE_TRAP_DOOR, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TESSERACT, RenderLayer.getTranslucent());
    }
}