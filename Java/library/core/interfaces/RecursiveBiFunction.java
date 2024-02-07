package library.core.interfaces;

import java.util.function.BiFunction;

/**
 * 再帰ラムダ式が書けるBiFunctionインターフェース
 * @param <T>
 * @param <U>
 * @param <R>
 * @see BiFunction
 */
public interface RecursiveBiFunction<T, U, R> {
	public R apply(final RecursiveBiFunction<T, U, R> rec, final T n, final U m);
}