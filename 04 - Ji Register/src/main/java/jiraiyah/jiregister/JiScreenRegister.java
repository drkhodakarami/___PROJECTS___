package jiraiyah.jiregister;

import jiraiyah.jibase.annotations.*;
import jiraiyah.jibase.utils.BaseHelper;
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

@Developer("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/drkhodakarami/___PROJECTS___")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")

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
        RegistryKey<ScreenHandlerType<?>> key = BaseHelper.getKey(this.modId, name, RegistryKeys.SCREEN_HANDLER);
        return Registry.register(Registries.SCREEN_HANDLER, key, new ExtendedScreenHandlerType<>(factory, codec));
    }
}