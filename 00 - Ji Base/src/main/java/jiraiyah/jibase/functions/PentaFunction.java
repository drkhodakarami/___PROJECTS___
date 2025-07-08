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
 * Represents a function that accepts five arguments and produces a result.
 *
 * @param <A> the type of the first argument
 * @param <T> the type of the second argument
 * @param <U> the type of the third argument
 * @param <V> the type of the fourth argument
 * @param <W> the type of the fifth argument
 * @param <R> the type of the result produced by this function
 */
@SuppressWarnings("unused")
@Developer("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/drkhodakarami/___PROJECTS___")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")

@FunctionalInterface
public interface PentaFunction<A, T, U, V, W, R>
{
    /**
     * Returns a composed {@code PentaFunction} that first applies this function to
     * its input, and then applies the {@code after} function to the result.
     *
     * @param <X> the type of output of the {@code after} function, and of the new {@code PentaFunction}
     * @param after the function to apply after this function is applied
     * @return a composed {@code PentaFunction} that first applies this function to its input, and then applies the {@code after} function to the result
     * @throws NullPointerException if {@code after} is null
     */
    default <X> PentaFunction<A, T, U, V, W, X> andThen(final Function<? super R, ? extends X> after) {
        Objects.requireNonNull(after);
        return (final A a, final T t, final U u, final V v, final W w) -> after.apply(apply(a, t, u, v, w));
    }

    /**
     * Applies this function to the given arguments.
     *
     * @param a the first argument
     * @param t the second argument
     * @param u the third argument
     * @param v the fourth argument
     * @param w the fifth argument
     * @return the result of applying this function to the given arguments
     */
    R apply(A a, T t, U u, V v, W w);
}