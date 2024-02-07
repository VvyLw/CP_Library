package library.core.interfaces;

import java.util.function.Function;

/**
 * 引数を三つ持てるFunctionインターフェース
 * @param <T>
 * @param <U>
 * @param <V>
 * @param <R>
 * @see Function
 */
public interface TriFunction<T, U, V, R> {
	public R apply(final T a, final U b, final V c);
}