package library.core.interfaces;

import java.util.function.Function;

/**
 * 再帰ラムダ式が書けるFunctionインターフェース
 * @param <T>
 * @param <U>
 * @param <V>
 * @param <R>
 * @see Function
 */
public interface RecursiveTriFunction<T, U, V, R> {
	public R apply(final RecursiveTriFunction<T, U, V, R> rec, final T p, final U q, final V r);
}