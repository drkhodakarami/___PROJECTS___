package jiraiyah.jibase.functions;

import jiraiyah.jibase.annotations.*;

import java.util.Objects;

@Developer("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/drkhodakarami/___PROJECTS___")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")

@FunctionalInterface
public interface HexaConsumer<T, U, V, W, R, E>
{
    void accept(T t, U u, V v, W w, R r, E e);

    default HexaConsumer<T, U, V, W, R, E> andThen(HexaConsumer<? super T, ? super U, ? super V, ? super W, ? super R, ? super E> after) {
        Objects.requireNonNull(after);

        return (t, u, v, w, r, e) -> {
            accept(t, u, v, w, r, e);
            after.accept(t, u, v, w, r, e);
        };
    }
}