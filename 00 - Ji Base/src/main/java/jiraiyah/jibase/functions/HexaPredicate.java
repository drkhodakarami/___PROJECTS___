/***********************************************************************************
 * Copyright (c) 2025 Alireza Khodakarami (Jiraiyah)                               *
 * ------------------------------------------------------------------------------- *
 * MIT License                                                                     *
 * =============================================================================== *
 * Permission is hereby granted, free of charge, to any person obtaining a copy    *
 * of this software and associated documentation files (the "Software"), to deal   *
 * in the Software without restriction, including without limitation the rights    *
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell       *
 * copies of the Software, and to permit persons to whom the Software is           *
 * furnished to do so, subject to the following conditions:                        *
 * ------------------------------------------------------------------------------- *
 * The above copyright notice and this permission notice shall be included in all  *
 * copies or substantial portions of the Software.                                 *
 * ------------------------------------------------------------------------------- *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR      *
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,        *
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE     *
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER          *
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,   *
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE   *
 * SOFTWARE.                                                                       *
 ***********************************************************************************/

package jiraiyah.jibase.functions;

import jiraiyah.jibase.annotations.*;


/**
 * Represents a predicate (boolean-valued function) of six arguments.
 *
 * @param <T> the type of the first argument
 * @param <U> the type of the second argument
 * @param <V> the type of the third argument
 * @param <W> the type of the fourth argument
 * @param <X> the type of the fifth argument
 * @param <Y> the type of the sixth argument
 */
@SuppressWarnings("unused")
@Developer("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/drkhodakarami/___PROJECTS___")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")

@FunctionalInterface
public interface HexaPredicate<T, U, V, W, X, Y>
{
    /**
     * Evaluates this predicate on the given arguments.
     *
     * @param t the first argument
     * @param u the second argument
     * @param v the third argument
     * @param w the fourth argument
     * @param x the fifth argument
     * @param y the sixth argument
     * @return {@code true} if the arguments match this predicate, otherwise {@code false}
     */
    boolean test(T t, U u, V v, W w, X x, Y y);

    /**
     * Returns a composed predicate that represents a logical AND of this
     * predicate and another.
     *
     * @param other a predicate that will be logically-ANDed with this predicate
     * @return a composed predicate that represents the logical AND of this
     * predicate and the other predicate
     * @throws NullPointerException if other is null
     */
    default HexaPredicate<T, U, V, W, X, Y> and(HexaPredicate<? super T, ? super U, ? super V, ? super W, ? super X, ? super Y> other)
    {
        return (t, u, v, w, x, y) -> test(t, u, v, w, x, y) && other.test(t, u, v, w, x, y);
    }

    /**
     * Returns a composed predicate that represents a logical OR of this
     * predicate and another.
     *
     * @param other a predicate that will be logically-ORed with this predicate
     * @return a composed predicate that represents the logical OR of this
     * predicate and the other predicate
     * @throws NullPointerException if other is null
     */
    default HexaPredicate<T, U, V, W, X, Y> or(HexaPredicate<? super T, ? super U, ? super V, ? super W, ? super X, ? super Y> other)
    {
        return (t, u, v, w, x, y) -> test(t, u, v, w, x, y) || other.test(t, u, v, w, x, y);
    }

    /**
     * Returns a predicate that represents the logical negation of this
     * predicate.
     *
     * @return a predicate that represents the logical negation of this
     * predicate
     */
    default HexaPredicate<T, U, V, W, X, Y> negate()
    {
        return (t, u, v, w, x, y) -> !test(t, u, v, w, x, y);
    }
}