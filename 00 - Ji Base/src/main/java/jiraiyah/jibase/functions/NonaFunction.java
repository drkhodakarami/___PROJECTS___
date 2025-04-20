package jiraiyah.jibase.functions;

import jiraiyah.jibase.annotations.*;

import java.util.Objects;
import java.util.function.Function;

@Developer("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/drkhodakarami/___PROJECTS___")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")

@FunctionalInterface
public interface NonaFunction<A, B, C, D, E, T, U, V, W, R>
{
    default <X> NonaFunction<A, B, C, D, E, T, U, V, W, X> andThen(final Function<? super R, ? extends X> after) {
        Objects.requireNonNull(after);
        return (final A a, final B b, final C c, final D d, final E e, final T t, final U u, final V v, final W w) -> after.apply(apply(a, b, c, d, e, t, u, v, w));
    }

    R apply(A a, B b, C c, D d, E e, T t, U u, V v, W w);
}