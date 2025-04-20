package jiraiyah.jibase.functions;

import jiraiyah.jibase.annotations.*;

import java.util.Objects;

@Developer("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/drkhodakarami/___PROJECTS___")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")

@FunctionalInterface
public interface PentaConsumer<T, U, V, W, R>
{
    void accept(T t, U u, V v, W w, R r);

    default PentaConsumer<T, U, V, W, R> andThen(PentaConsumer<? super T, ? super U, ? super V, ? super W, ? super R> after) {
        Objects.requireNonNull(after);

        return (t, u, v, w, r) -> {
            accept(t, u, v, w, r);
            after.accept(t, u, v, w, r);
        };
    }
}