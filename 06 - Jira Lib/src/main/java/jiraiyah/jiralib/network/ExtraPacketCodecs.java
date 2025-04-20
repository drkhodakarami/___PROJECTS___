package jiraiyah.jiralib.network;

import io.netty.buffer.ByteBuf;
import jiraiyah.jibase.annotations.*;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.registry.Registries;
import net.minecraft.util.collection.Weighted;
import net.minecraft.util.math.floatprovider.*;
import net.minecraft.util.math.intprovider.*;
import net.minecraft.util.collection.Pool;

import java.util.HashMap;
import java.util.Map;

@Developer("TurtyWurty")
@ModifiedBy("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/DaRealTurtyWurty/Industria")
@Discord("https://discord.turtywurty.dev/")
@Youtube("https://www.youtube.com/@TurtyWurty")

@SuppressWarnings("unchecked")
public class ExtraPacketCodecs
{
    private static final Map<IntProviderType<?>, PacketCodec<RegistryByteBuf, ? extends IntProvider>> INT_PROVIDER_CODECS = new HashMap<>();
    private static final Map<FloatProviderType<?>, PacketCodec<RegistryByteBuf, ? extends FloatProvider>> FLOAT_PROVIDER_CODECS = new HashMap<>();

    static
    {
        registerDefaults();
    }

    public static <T extends IntProvider> void registerIntProvider(IntProviderType<T> providerType, PacketCodec<RegistryByteBuf, T> codec)
    {
        INT_PROVIDER_CODECS.put(providerType, codec);
    }

    public static <T extends FloatProvider> void registerFloatProvider(FloatProviderType<T> providerType, PacketCodec<RegistryByteBuf, T> codec)
    {
        FLOAT_PROVIDER_CODECS.put(providerType, codec);
    }

    public static PacketCodec<RegistryByteBuf, ? extends IntProvider> getIntProviderCodec(IntProviderType<?> providerType)
    {
        return INT_PROVIDER_CODECS.get(providerType);
    }

    public static PacketCodec<RegistryByteBuf, ? extends FloatProvider> getFloatProviderCodec(FloatProviderType<?> providerType)
    {
        return FLOAT_PROVIDER_CODECS.get(providerType);
    }

    public static <T extends IntProvider> void encode(ByteBuf buf, T intProvider)
    {
        PacketCodec<RegistryByteBuf, T> codec = (PacketCodec<RegistryByteBuf, T>) getIntProviderCodec(intProvider.getType());
        codec.encode((RegistryByteBuf) buf, intProvider);
    }

    public static  <T extends IntProvider> T decode(ByteBuf buf, IntProviderType<T> providerType)
    {
        PacketCodec<RegistryByteBuf, T> codec = (PacketCodec<RegistryByteBuf, T>) getIntProviderCodec(providerType);
        return codec.decode((RegistryByteBuf) buf);
    }

    public static <T extends FloatProvider> void encode(ByteBuf buf, T floatProvider)
    {
        PacketCodec<RegistryByteBuf, T> codec = (PacketCodec<RegistryByteBuf, T>) getFloatProviderCodec(floatProvider.getType());
        codec.encode((RegistryByteBuf) buf, floatProvider);
    }

    public static  <T extends FloatProvider> T decode(ByteBuf buf, FloatProviderType<T> providerType)
    {
        PacketCodec<RegistryByteBuf, T> codec = (PacketCodec<RegistryByteBuf, T>) getFloatProviderCodec(providerType);
        return codec.decode((RegistryByteBuf) buf);
    }

    public static void registerDefaults()
    {
        registerIntProvider(IntProviderType.CONSTANT,
                            PacketCodec.ofStatic(
                                    (buf, intProvider) -> buf.writeInt(intProvider.getValue()),
                                    buf -> ConstantIntProvider.create(buf.readInt())
                            ));

        registerIntProvider(IntProviderType.UNIFORM,
                            PacketCodec.ofStatic(
                                    (buf, intProvider) ->
                                    {
                                        buf.writeInt(intProvider.getMin());
                                        buf.writeInt(intProvider.getMax());
                                    },
                                    buf -> UniformIntProvider.create(buf.readInt(), buf.readInt())
                            ));

        registerIntProvider(IntProviderType.BIASED_TO_BOTTOM,
                            PacketCodec.ofStatic(
                                    (buf, intProvider) ->
                                    {
                                        buf.writeInt(intProvider.getMin());
                                        buf.writeInt(intProvider.getMax());
                                    },
                                    buf -> BiasedToBottomIntProvider.create(buf.readInt(), buf.readInt())
                            ));

        registerIntProvider(IntProviderType.CLAMPED,
                            PacketCodec.ofStatic(
                                    (buf, intProvider) ->
                                    {
                                        IntProviderType<?> type = Registries.INT_PROVIDER_TYPE.get(buf.readIdentifier());
                                        PacketCodec<RegistryByteBuf, IntProvider> codec = (PacketCodec<RegistryByteBuf, IntProvider>) getIntProviderCodec(type);
                                        codec.encode(buf, intProvider.source);
                                        buf.writeInt(intProvider.getMin());
                                        buf.writeInt(intProvider.getMax());
                                    },
                                    buf -> ClampedIntProvider.create(
                                            getIntProviderCodec(IntProviderType.CONSTANT).decode(buf),
                                                buf.readInt(), buf.readInt())
                            ));

        registerIntProvider(IntProviderType.WEIGHTED_LIST,
                            PacketCodec.ofStatic(
                                    (buf, value) ->
                                    {
                                        PacketCodec<RegistryByteBuf, ? extends IntProvider> codec = getIntProviderCodec(value.getType());
                                        Pool<IntProvider> entries = value.weightedList;
                                        PacketCodec<RegistryByteBuf, Pool<IntProvider>> entriesCodec = weightedListCodec((PacketCodec<RegistryByteBuf, IntProvider>) codec);
                                        entriesCodec.encode(buf, entries);
                                    },
                                    buf ->
                                    {
                                        PacketCodec<RegistryByteBuf, ? extends IntProvider> codec = getIntProviderCodec(IntProviderType.CONSTANT);
                                        Pool<IntProvider> entries = weightedListCodec((PacketCodec<RegistryByteBuf, IntProvider>) codec).decode(buf);
                                        return new WeightedListIntProvider(entries);
                                    }
                            ));

        registerIntProvider(IntProviderType.CLAMPED_NORMAL,
                            PacketCodec.ofStatic(
                                    (buf, intProvider) ->
                                    {
                                        buf.writeFloat(intProvider.mean);
                                        buf.writeFloat(intProvider.deviation);
                                        buf.writeInt(intProvider.getMin());
                                        buf.writeInt(intProvider.getMax());
                                    },
                                    buf -> ClampedNormalIntProvider.of(buf.readFloat(),buf.readFloat(),
                                                                           buf.readInt(), buf.readInt())
                            ));

        registerFloatProvider(FloatProviderType.CONSTANT,
                              PacketCodec.ofStatic(
                                      (buf, floatProvider) -> buf.writeFloat(floatProvider.getValue()),
                                      buf -> ConstantFloatProvider.create(buf.readFloat())
                              ));

        registerFloatProvider(FloatProviderType.UNIFORM,
                              PacketCodec.ofStatic(
                                      (buf, floatProvider) ->
                                      {
                                          buf.writeFloat(floatProvider.getMin());
                                          buf.writeFloat(floatProvider.getMax());
                                      },
                                      buf -> UniformFloatProvider.create(buf.readFloat(), buf.readFloat())
                              ));

        registerFloatProvider(FloatProviderType.CLAMPED_NORMAL,
                            PacketCodec.ofStatic(
                                    (buf, floatProvider) ->
                                    {
                                        buf.writeFloat(floatProvider.mean);
                                        buf.writeFloat(floatProvider.deviation);
                                        buf.writeFloat(floatProvider.getMin());
                                        buf.writeFloat(floatProvider.getMax());
                                    },
                                    buf -> ClampedNormalFloatProvider.create(buf.readFloat(), buf.readFloat(),
                                                                         buf.readFloat(), buf.readFloat())
                            ));

        registerFloatProvider(FloatProviderType.TRAPEZOID,
                              PacketCodec.ofStatic(
                                      (buf, floatProvider) ->
                                      {
                                          buf.writeFloat(floatProvider.getMin());
                                          buf.writeFloat(floatProvider.getMax());
                                          buf.writeFloat(floatProvider.plateau);
                                      },
                                      buf -> TrapezoidFloatProvider.create(buf.readFloat(), buf.readFloat(),
                                                                               buf.readFloat())
                              ));
    }

    public static <B extends ByteBuf, E> PacketCodec<B, Pool<E>> weightedListCodec(PacketCodec<B, E> elementCodec) {
        return PacketCodec.<B, Weighted<E>, E, Integer>tuple(
                elementCodec, Weighted::value,
                PacketCodecs.VAR_INT, Weighted::weight,
                Weighted::new
        ).collect(PacketCodecs.toList()).xmap(Pool::new, Pool::getEntries);
    }
}