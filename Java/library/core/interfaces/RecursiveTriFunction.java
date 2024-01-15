package library.core.interfaces;

/**
 * 再帰ラムダ式が書けるFunctionインターフェース
 * @param <T>
 * @param <U>
 * @param <V>
 * @param <W>
 */
public interface RecursiveTriFunction<T, U, V, W> {
	public W apply(final RecursiveTriFunction<T, U, V, W> rec, final T p, final U q, final V r);
}