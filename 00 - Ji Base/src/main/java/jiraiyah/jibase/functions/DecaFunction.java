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

import java.util.Objects;
import java.util.function.Function;

/**
 * Represents a functional interface that accepts ten arguments and produces a result.
 *
 * @param <A> the type of the first argument
 * @param <B> the type of the second argument
 * @param <C> the type of the third argument
 * @param <D> the type of the fourth argument
 * @param <E> the type of the fifth argument
 * @param <F> the type of the sixth argument
 * @param <T> the type of the seventh argument
 * @param <U> the type of the eighth argument
 * @param <V> the type of the ninth argument
 * @param <W> the type of the tenth argument
 * @param <R> the type of the result
 */
@SuppressWarnings("unused")
@Developer("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/drkhodakarami/___PROJECTS___")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")

@FunctionalInterface
public interface DecaFunction<A, B, C, D, E, F, T, U, V, W, R>
{
    /**
     * Returns a composed {@code DecaFunction} that first applies this function to its input, and then
     * applies the {@code after} function to the result.
     *
     * @param <X> the type of output of the {@code after} function, and of the new composed function
     * @param after the function to apply after this function is applied
     * @return a composed function that first applies this function and then applies the {@code after} function
     * @throws NullPointerException if after is null
     */
    default <X> DecaFunction<A, B, C, D, E, F, T, U, V, W, X> andThen(final Function<? super R, ? extends X> after) {
        Objects.requireNonNull(after);
        return (final A a, final B b, final C c, final D d, final E e, final F f, final T t, final U u, final V v, final W w) -> after.apply(apply(a, b, c, d, e, f, t, u, v, w));
    }

    /**
     * Applies this function to the given arguments.
     *
     * @param a the first argument
     * @param b the second argument
     * @param c the third argument
     * @param d the fourth argument
     * @param e the fifth argument
     * @param f the sixth argument
     * @param t the seventh argument
     * @param u the eighth argument
     * @param v the ninth argument
     * @param w the tenth argument
     * @return the result of applying this function to the given arguments
     */
    R apply(A a, B b, C c, D d, E e, F f, T t, U u, V v, W w);
}