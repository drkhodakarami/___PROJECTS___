package jiraiyah.jiregister;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;

public class JiScreenRegister
{
    private final String modId;

    public JiScreenRegister(String modId)
    {
        this.modId = modId;
    }

    public <R extends ScreenHandler, D extends CustomPayload> ExtendedScreenHandlerType<R, D>
            register(String name, ExtendedScreenHandlerType.ExtendedFactory<R, D> factory,
                     PacketCodec<? super RegistryByteBuf, D> codec)
    {
        RegistryKey<ScreenHandlerType<?>> key = RegistryHelper.getKey(this.modId, name, RegistryKeys.SCREEN_HANDLER);
        return Registry.register(Registries.SCREEN_HANDLER, key, new ExtendedScreenHandlerType<>(factory, codec));
    }
}