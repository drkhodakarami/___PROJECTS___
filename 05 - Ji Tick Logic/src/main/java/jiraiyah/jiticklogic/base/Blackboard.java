/***********************************************************************************
 * Copyright (c) 2025 Alireza Khodakarami (Jiraiyah)                               *
 * ------------------------------------------------------------------------------- *
 * MIT License                                                                     *
 * =============================================================================== *
 * Permission is hereby granted, free of charge, to any person obtaining a copy    *
 * of this software and associated documentation files (the "Software"), to deal   *
 * in the Software without restriction, including without limitation the rights    *
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell       *
 * copies of the Software, and to permit persons to whom the Software is           *
 * furnished to do so, subject to the following conditions:                        *
 * ------------------------------------------------------------------------------- *
 * The above copyright notice and this permission notice shall be included in all  *
 * copies or substantial portions of the Software.                                 *
 * ------------------------------------------------------------------------------- *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR      *
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,        *
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE     *
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER          *
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,   *
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE   *
 * SOFTWARE.                                                                       *
 ***********************************************************************************/

package jiraiyah.jiticklogic.base;

import com.mojang.serialization.Codec;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtOps;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class Blackboard
{
    private static final Map<String, Codec<?>> TYPE_REGISTRY = new HashMap<>();
    private static final Map<Class<?>, String> CLASS_TO_ID = new HashMap<>();

    private final Map<String, BlackboardEntry> data = new HashMap<>();

    public static final Codec<Blackboard> CODEC = Codec.unboundedMap(Codec.STRING, BlackboardEntry.CODEC)
            .xmap(Blackboard::fromMap, Blackboard::asMap);

    static
    {
        registerType("int", Integer.class, Codec.INT);
        registerType("float", Float.class, Codec.FLOAT);
        registerType("double", Double.class, Codec.DOUBLE);
        registerType("long", Long.class, Codec.LONG);
        registerType("boolean", Boolean.class, Codec.BOOL);
        registerType("string", String.class, Codec.STRING);
        registerType("blockpos", BlockPos.class, BlockPos.CODEC);
        registerType("vec3d", Vec3d.class, Vec3d.CODEC);
        registerType("vec3i", Vec3i.class, Vec3i.CODEC);
        registerType("vec2f", Vec2f.class, Vec2f.CODEC);
    }

    public Blackboard()
    {}

    public void put(String key, Object value)
    {
        String typeId = getTypeId(value);
        if(typeId == null)
            throw new IllegalArgumentException("Blackboard: Unsupported type for value: " + value.getClass().getName());
        data.put(key, new BlackboardEntry(typeId, value));
    }

    @Nullable
    public <T> T get(String key, Class<T> type)
    {
        BlackboardEntry entry = data.get(key);

        if(entry == null || entry.value == null)
            return null;

        if(!type.isInstance(entry.value))
            return null;

        return type.cast(entry.value);
    }

    public int getInt(String key)
    {
        var value = get(key, Integer.class);
        return value == null ? 0 : value;
    }

    public float getFloat(String key)
    {
        var value = get(key, Float.class);
        return value == null ? 0.0f : value;
    }

    public double getDouble(String key)
    {
        var value = get(key, Double.class);
        return value == null ? 0 : value;
    }

    public long getLong(String key)
    {
        var value = get(key, Long.class);
        return value == null ? 0 : value;
    }

    public boolean getBoolean(String key)
    {
        var value = get(key, Boolean.class);
        return value != null && value;
    }

    public String getString(String key)
    {
        var value = get(key, String.class);
        return value == null ? "" : value;
    }

    @Nullable
    public BlockPos getBlockPos(String key)
    {
        return get(key, BlockPos.class);
    }

    public Vec3d getVec3d(String key)
    {
        var value = get(key, Vec3d.class);
        return value == null ? Vec3d.ZERO : value;
    }

    public Vec3i getVec3i(String key)
    {
        var value = get(key, Vec3i.class);
        return value == null ? Vec3i.ZERO : value;
    }

    public Vec2f getVec2f(String key)
    {
        var value = get(key, Vec2f.class);
        return value == null ? Vec2f.ZERO : value;
    }

    public void remove(String key)
    {
        data.remove(key);
    }

    public void clear()
    {
        data.clear();
    }

    public Map<String, BlackboardEntry> getData()
    {
        return Collections.unmodifiableMap(data);
    }

    public Map<String, BlackboardEntry> asMap()
    {
        return data;
    }

    @Override
    public String toString()
    {
        return "Blackboard {" + data + " }";
    }

    public NbtCompound writeNbt()
    {
        NbtCompound compound = new NbtCompound();

        CODEC.encodeStart(NbtOps.INSTANCE, this)
                .resultOrPartial(System.err::println)
                .ifPresent(dynamic ->
                           {
                               if(dynamic instanceof NbtCompound nbt)
                               {
                                   for(String key : nbt.getKeys())
                                       compound.put(key, nbt.get(key));
                               }
                           });

        return compound;
    }

    public static Blackboard readNbt(NbtCompound nbt)
    {
        return CODEC.parse(NbtOps.INSTANCE, nbt)
                .result().orElseGet(Blackboard::new);
    }

    public static <T> void registerType(String id, Class<T> clazz, Codec<T> codec)
    {
        TYPE_REGISTRY.put(id, codec);
        CLASS_TO_ID.put(clazz, id);
    }

    private static String getTypeId(Object value)
    {
        if(value == null)
            return null;

        String id = CLASS_TO_ID.get(value.getClass());

        if(id != null)
            return id;

        for (Map.Entry<Class<?>, String> entry : CLASS_TO_ID.entrySet())
            if(entry.getKey().isAssignableFrom(value.getClass()))
                return entry.getValue();

        return null;
    }

    @SuppressWarnings("unchecked")
    public static <T> Codec<T> getCodec(String typeId)
    {
        Codec<?> codec = TYPE_REGISTRY.get(typeId);
        if(codec == null)
            throw new IllegalArgumentException("Blackboard: Unknown type id: " + typeId);
        return (Codec<T>) codec;
    }

    public static Blackboard fromMap(Map<String, BlackboardEntry> map)
    {
        Blackboard board = new Blackboard();
        board.data.putAll(map);
        return board;
    }
}