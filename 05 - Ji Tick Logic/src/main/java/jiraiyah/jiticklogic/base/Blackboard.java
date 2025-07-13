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

/**
 * A blackboard used to store and retrieve data in a key-value format.
 */
public class Blackboard
{
    /**
     * Map of type IDs to their corresponding codecs.
     */
    private static final Map<String, Codec<?>> TYPE_REGISTRY = new HashMap<>();

    /**
     * Map of classes to their corresponding type IDs.
     */
    private static final Map<Class<?>, String> CLASS_TO_ID = new HashMap<>();

    /**
     * The data stored in the blackboard.
     */
    private final Map<String, BlackboardEntry> data = new HashMap<>();

    /**
     * Codec for serializing and deserializing the blackboard.
     */
    public static final Codec<Blackboard> CODEC = Codec.unboundedMap(Codec.STRING, BlackboardEntry.CODEC)
            .xmap(Blackboard::fromMap, Blackboard::asMap);

    // Static initializer to register common data types.
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

    /**
     * Constructs a new Blackboard instance.
     */
    public Blackboard()
    {}

    /**
     * Puts a value in the blackboard with a given key and type.
     *
     * @param key   the key for the value
     * @param value the value to store
     * @throws IllegalArgumentException if the value's type is not supported
     */
    public void put(String key, Object value)
    {
        String typeId = getTypeId(value);
        if(typeId == null)
            throw new IllegalArgumentException("Blackboard: Unsupported type for value: " + value.getClass().getName());
        data.put(key, new BlackboardEntry(typeId, value));
    }

    /**
     * Retrieves a value from the blackboard with a given key and type.
     *
     * @param key   the key for the value
     * @param type  the class of the expected type
     * @param <T>   the type of the expected value
     * @return the value if found, otherwise null
     */
    @Nullable
    public <T> T get(String key, Class<T> type)
    {
        BlackboardEntry entry = data.get(key);

        if(entry == null || entry.value() == null)
            return null;

        if(!type.isInstance(entry.value()))
            return null;

        return type.cast(entry.value());
    }

    /**
     * Retrieves an integer value from the blackboard with a given key.
     *
     * @param key   the key for the value
     * @return the integer value, or 0 if not found
     */
    public int getInt(String key)
    {
        var value = get(key, Integer.class);
        return value == null ? 0 : value;
    }

    /**
     * Retrieves a float value from the blackboard with a given key.
     *
     * @param key   the key for the value
     * @return the float value, or 0.0f if not found
     */
    public float getFloat(String key)
    {
        var value = get(key, Float.class);
        return value == null ? 0.0f : value;
    }

    /**
     * Retrieves a double value from the blackboard with a given key.
     *
     * @param key   the key for the value
     * @return the double value, or 0 if not found
     */
    public double getDouble(String key)
    {
        var value = get(key, Double.class);
        return value == null ? 0 : value;
    }

    /**
     * Retrieves a long value from the blackboard with a given key.
     *
     * @param key   the key for the value
     * @return the long value, or 0 if not found
     */
    public long getLong(String key)
    {
        var value = get(key, Long.class);
        return value == null ? 0 : value;
    }

    /**
     * Retrieves a boolean value from the blackboard with a given key.
     *
     * @param key   the key for the value
     * @return the boolean value, or false if not found
     */
    public boolean getBoolean(String key)
    {
        var value = get(key, Boolean.class);
        return value != null && value;
    }

    /**
     * Retrieves a string value from the blackboard with a given key.
     *
     * @param key   the key for the value
     * @return the string value, or an empty string if not found
     */
    public String getString(String key)
    {
        var value = get(key, String.class);
        return value == null ? "" : value;
    }

    /**
     * Retrieves a BlockPos value from the blackboard with a given key.
     *
     * @param key   the key for the value
     * @return the BlockPos value, or null if not found
     */
    @Nullable
    public BlockPos getBlockPos(String key)
    {
        return get(key, BlockPos.class);
    }

    /**
     * Retrieves a Vec3d value from the blackboard with a given key.
     *
     * @param key   the key for the value
     * @return the Vec3d value, or Vec3d.ZERO if not found
     */
    public Vec3d getVec3d(String key)
    {
        var value = get(key, Vec3d.class);
        return value == null ? Vec3d.ZERO : value;
    }

    /**
     * Retrieves a Vec3i value from the blackboard with a given key.
     *
     * @param key   the key for the value
     * @return the Vec3i value, or Vec3i.ZERO if not found
     */
    public Vec3i getVec3i(String key)
    {
        var value = get(key, Vec3i.class);
        return value == null ? Vec3i.ZERO : value;
    }

    /**
     * Retrieves a Vec2f value from the blackboard with a given key.
     *
     * @param key   the key for the value
     * @return the Vec2f value, or Vec2f.ZERO if not found
     */
    public Vec2f getVec2f(String key)
    {
        var value = get(key, Vec2f.class);
        return value == null ? Vec2f.ZERO : value;
    }

    /**
     * Removes a value from the blackboard with a given key.
     *
     * @param key the key for the value to remove
     */
    public void remove(String key)
    {
        data.remove(key);
    }

    /**
     * Clears all values from the blackboard.
     */
    public void clear()
    {
        data.clear();
    }

    /**
     * Returns an unmodifiable view of the blackboard's data.
     *
     * @return the data map
     */
    public Map<String, BlackboardEntry> getData()
    {
        return Collections.unmodifiableMap(data);
    }

    /**
     * Converts the blackboard to a map representation.
     *
     * @return the map representation of the blackboard
     */
    public Map<String, BlackboardEntry> asMap()
    {
        return data;
    }

    /**
     * Returns a string representation of the blackboard, showing its contents.
     *
     * @return a string representing the blackboard
     */
    @Override
    public String toString()
    {
        return "Blackboard {" + data + " }";
    }

    /**
     * Writes the blackboard to an NBT compound.
     *
     * @return the NBT compound representation of the blackboard
     */
    public NbtCompound writeData()
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

    /**
     * Reads a blackboard from an NBT compound.
     *
     * @param nbt the NBT compound representation of the blackboard
     * @return the Blackboard instance
     */
    public static Blackboard readData(NbtCompound nbt)
    {
        return CODEC.parse(NbtOps.INSTANCE, nbt)
                .result().orElseGet(Blackboard::new);
    }

    /**
     * Registers a type with its ID and codec.
     *
     * @param id      the type ID
     * @param clazz   the class of the type
     * @param codec   the codec for serializing and deserializing the type
     */
    public static <T> void registerType(String id, Class<T> clazz, Codec<T> codec)
    {
        TYPE_REGISTRY.put(id, codec);
        CLASS_TO_ID.put(clazz, id);
    }

    /**
     * Retrieves the type ID for a given value.
     *
     * @param value the value to retrieve the type ID for
     * @return the type ID, or null if not found
     */
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

    /**
     * Retrieves the codec for a given type ID.
     *
     * @param typeId the type ID to retrieve the codec for
     * @return the Codec instance, or throws an IllegalArgumentException if not found
     */
    @SuppressWarnings("unchecked")
    public static <T> Codec<T> getCodec(String typeId)
    {
        Codec<?> codec = TYPE_REGISTRY.get(typeId);
        if(codec == null)
            throw new IllegalArgumentException("Blackboard: Unknown type id: " + typeId);
        return (Codec<T>) codec;
    }

    /**
     * Converts a map to a Blackboard instance.
     *
     * @param map the map representation of the blackboard
     * @return the Blackboard instance
     */
    public static Blackboard fromMap(Map<String, BlackboardEntry> map)
    {
        Blackboard board = new Blackboard();
        board.data.putAll(map);
        return board;
    }
}