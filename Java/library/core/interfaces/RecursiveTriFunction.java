package library.core.interfaces;

/**
 * 再帰ラムダ式が書けるTriFunctionインターフェース
 * @param <T>
 * @param <U>
 * @param <V>
 * @param <R>
 * @see TriFunction
 */
public interface RecursiveTriFunction<T, U, V, R> {
	public R apply(final RecursiveTriFunction<T, U, V, R> rec, final T p, final U q, final V r);
}