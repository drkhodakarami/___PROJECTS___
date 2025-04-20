package jiraiyah.jibase.functions;

import jiraiyah.jibase.annotations.*;

import java.util.Objects;

@Developer("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/drkhodakarami/___PROJECTS___")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")

@FunctionalInterface
public interface DecaConsumer<T, U, V, W, R, E, A, Z, X, M>
{
    void accept(T t, U u, V v, W w, R r, E e, A a, Z z, X x, M m);

    default DecaConsumer<T, U, V, W, R, E, A, Z, X, M> andThen(DecaConsumer<? super T, ? super U, ? super V, ? super W, ? super R, ? super E, ? super A, ? super Z, ? super X, ? super M> after) {
        Objects.requireNonNull(after);

        return (t, u, v, w, r, e, a, z, x, m) -> {
            accept(t, u, v, w, r, e, a, z, x, m);
            after.accept(t, u, v, w, r, e, a, z, x, m);
        };
    }
}