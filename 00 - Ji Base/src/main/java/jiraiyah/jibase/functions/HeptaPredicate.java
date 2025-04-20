package jiraiyah.jibase.functions;

import jiraiyah.jibase.annotations.*;

@Developer("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/drkhodakarami/___PROJECTS___")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")

@FunctionalInterface
public interface HeptaPredicate<T, U, V, W, X, Y, Z>
{
    boolean test(T t, U u, V v, W w, X x, Y y, Z z);

    default HeptaPredicate<T, U, V, W, X, Y, Z> and(HeptaPredicate<? super T, ? super U, ? super V, ? super W, ? super X, ? super Y, ? super Z> other)
    {
        return (t, u, v, w, x, y, z) -> test(t, u, v, w, x, y, z) && other.test(t, u, v, w, x, y, z);
    }

    default HeptaPredicate<T, U, V, W, X, Y, Z> or(HeptaPredicate<? super T, ? super U, ? super V, ? super W, ? super X, ? super Y, ? super Z> other)
    {
        return (t, u, v, w, x, y, z) -> test(t, u, v, w, x, y, z) || other.test(t, u, v, w, x, y, z);
    }

    default HeptaPredicate<T, U, V, W, X, Y, Z> negate()
    {
        return (t, u, v, w, x, y, z) -> !test(t, u, v, w, x, y, z);
    }
}