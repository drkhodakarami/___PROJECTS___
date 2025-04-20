package jiraiyah.jibase.interfaces;

import jiraiyah.jibase.annotations.*;
import net.minecraft.nbt.NbtElement;
import net.minecraft.registry.RegistryWrapper;

@Developer("TurtyWurty")
@ModifiedBy("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/DaRealTurtyWurty/Industria")
@Discord("https://discord.turtywurty.dev/")
@Youtube("https://www.youtube.com/@TurtyWurty")

public interface INBTSerializable<T extends NbtElement>
{
    T writeNbt(RegistryWrapper.WrapperLookup registryLookup);
    void readNbt(T nbt, RegistryWrapper.WrapperLookup registryLookup);
}