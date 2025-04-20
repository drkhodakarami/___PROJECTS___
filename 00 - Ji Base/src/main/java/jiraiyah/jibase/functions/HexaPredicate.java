package jiraiyah.jibase.functions;

import jiraiyah.jibase.annotations.*;

@Developer("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/drkhodakarami/___PROJECTS___")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")

@FunctionalInterface
public interface HexaPredicate<T, U, V, W, X, Y>
{
    boolean test(T t, U u, V v, W w, X x, Y y);

    default HexaPredicate<T, U, V, W, X, Y> and(HexaPredicate<? super T, ? super U, ? super V, ? super W, ? super X, ? super Y> other)
    {
        return (t, u, v, w, x, y) -> test(t, u, v, w, x, y) && other.test(t, u, v, w, x, y);
    }

    default HexaPredicate<T, U, V, W, X, Y> or(HexaPredicate<? super T, ? super U, ? super V, ? super W, ? super X, ? super Y> other)
    {
        return (t, u, v, w, x, y) -> test(t, u, v, w, x, y) || other.test(t, u, v, w, x, y);
    }

    default HexaPredicate<T, U, V, W, X, Y> negate()
    {
        return (t, u, v, w, x, y) -> !test(t, u, v, w, x, y);
    }
}