package library.core.interfaces.lambda;

import java.util.function.DoubleFunction;

/**
 * 再帰ラムダが書けるDoubleFunctionインターフェース
 * @param <R>
 * @see DoubleFunction
 */
public interface RecursiveDoubleFunction<R> {
	public R apply(final RecursiveDoubleFunction<R> rec, final double n);
}