package jiraiyah.jibase.functions;

import jiraiyah.jibase.annotations.*;

@Developer("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/drkhodakarami/___PROJECTS___")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")

@FunctionalInterface
public interface PentaPredicate<T, U, V, W, X>
{
    boolean test(T t, U u, V v, W w, X x);

    default PentaPredicate<T, U, V, W, X> and(PentaPredicate<? super T, ? super U, ? super V, ? super W, ? super X> other)
    {
        return (t, u, v, w, x) -> test(t, u, v, w, x) && other.test(t, u, v, w, x);
    }

    default PentaPredicate<T, U, V, W, X> or(PentaPredicate<? super T, ? super U, ? super V, ? super W, ? super X> other)
    {
        return (t, u, v, w, x) -> test(t, u, v, w, x) || other.test(t, u, v, w, x);
    }

    default PentaPredicate<T, U, V, W, X> negate()
    {
        return (t, u, v, w, x) -> !test(t, u, v, w, x);
    }
}