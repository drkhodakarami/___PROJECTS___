package jiraiyah.jibase.functions;

import jiraiyah.jibase.annotations.*;

@Developer("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/drkhodakarami/___PROJECTS___")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")

@FunctionalInterface
public interface OctaPredicate<T, U, V, W, X, Y, Z, A>
{
    boolean test(T t, U u, V v, W w, X x, Y y, Z z, A a);

    default OctaPredicate<T, U, V, W, X, Y, Z, A> and(OctaPredicate<? super T, ? super U, ? super V, ? super W, ? super X, ? super Y, ? super Z, ? super A> other)
    {
        return (t, u, v, w, x, y, z, a) -> test(t, u, v, w, x, y, z, a) && other.test(t, u, v, w, x, y, z, a);
    }

    default OctaPredicate<T, U, V, W, X, Y, Z, A> or(OctaPredicate<? super T, ? super U, ? super V, ? super W, ? super X, ? super Y, ? super Z, ? super A> other)
    {
        return (t, u, v, w, x, y, z, a) -> test(t, u, v, w, x, y, z, a) || other.test(t, u, v, w, x, y, z, a);
    }

    default OctaPredicate<T, U, V, W, X, Y, Z, A> negate()
    {
        return (t, u, v, w, x, y, z, a) -> !test(t, u, v, w, x, y, z, a);
    }
}