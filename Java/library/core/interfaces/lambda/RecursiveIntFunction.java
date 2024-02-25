package library.core.interfaces.lambda;

import java.util.function.IntFunction;

/**
 * 再帰ラムダが書けるIntFunctionインターフェース
 * @param <R>
 * @see IntFunction
 */
public interface RecursiveIntFunction<R> {
	public R apply(final RecursiveIntFunction<R> rec, final int n);
}