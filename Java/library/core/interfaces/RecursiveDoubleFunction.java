package library.core.interfaces;

import java.util.function.DoubleFunction;

/**
 * 再帰ラムダが書けるDoubleFunctionインターフェース
 * @param <R>
 * @see DoubleFunction
 */
public interface RecursiveDoubleFunction<R> {
	public R apply(final RecursiveDoubleFunction<R> rec, final double n);
}