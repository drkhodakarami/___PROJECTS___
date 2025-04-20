package jiraiyah.jibase.functions;

import jiraiyah.jibase.annotations.*;

@Developer("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/drkhodakarami/___PROJECTS___")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")

@FunctionalInterface
public interface TetraPredicate<T, U, V, W>
{
    boolean test(T t, U u, V v, W w);

    default TetraPredicate<T, U, V, W> and(TetraPredicate<? super T, ? super U, ? super V, ? super W> other)
    {
        return (t, u, v, w) -> test(t, u, v, w) && other.test(t, u, v, w);
    }

    default TetraPredicate<T, U, V, W> or(TetraPredicate<? super T, ? super U, ? super V, ? super W> other)
    {
        return (t, u, v, w) -> test(t, u, v, w) || other.test(t, u, v, w);
    }

    default TetraPredicate<T, U, V, W> negate()
    {
        return (t, u, v, w) -> !test(t, u, v, w);
    }
}