package jiraiyah.jiralib.interfaces;

import net.minecraft.nbt.NbtElement;
import net.minecraft.registry.RegistryWrapper;

// Author: turtywurty
// https://github.com/DaRealTurtyWurty/Industria
public interface INBTSerializable<T extends NbtElement>
{
    T writeNbt(RegistryWrapper.WrapperLookup registryLookup);
    void readNbt(T nbt, RegistryWrapper.WrapperLookup registryLookup);
}