package library.core.interfaces;

import java.util.function.LongFunction;

/**
 * 再帰ラムダが書けるLongFunctionインターフェース
 * @param <R>
 * @see LongFunction
 */
public interface RecursiveLongFunction<R> {
	public R apply(final RecursiveLongFunction<R> rec, final long n);
}