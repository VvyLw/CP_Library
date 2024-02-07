package library.core.interfaces;

import java.util.function.Function;

/**
 * 再帰ラムダ式が書けるFunctionインターフェース
 * @param <T>
 * @param <R>
 * @see Function
 */
public interface RecursiveFunction<T, R> {
	public R apply(final RecursiveFunction<T, R> rec, final T n);
}