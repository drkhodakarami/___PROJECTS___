package jiraiyah.jibase.functions;

import jiraiyah.jibase.annotations.*;

@Developer("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/drkhodakarami/___PROJECTS___")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")

@FunctionalInterface
public interface DecaPredicate<T, U, V, W, X, Y, Z, A, M, N>
{
    boolean test(T t, U u, V v, W w, X x, Y y, Z z, A a, M m, N n);

    default DecaPredicate<T, U, V, W, X, Y, Z, A, M, N> and(DecaPredicate<? super T, ? super U, ? super V, ? super W, ? super X, ? super Y, ? super Z, ? super A, ? super M, ? super N> other)
    {
        return (t, u, v, w, x, y, z, a, m, n) -> test(t, u, v, w, x, y, z, a, m, n) && other.test(t, u, v, w, x, y, z, a, m, n);
    }

    default DecaPredicate<T, U, V, W, X, Y, Z, A, M, N> or(DecaPredicate<? super T, ? super U, ? super V, ? super W, ? super X, ? super Y, ? super Z, ? super A, ? super M, ? super N> other)
    {
        return (t, u, v, w, x, y, z, a, m, n) -> test(t, u, v, w, x, y, z, a, m, n) || other.test(t, u, v, w, x, y, z, a, m, n);
    }

    default DecaPredicate<T, U, V, W, X, Y, Z, A, M, N> negate()
    {
        return (t, u, v, w, x, y, z, a, m, n) -> !this.test(t, u, v, w, x, y, z, a, m, n);
    }
}