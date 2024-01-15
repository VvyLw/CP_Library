package library.core.interfaces;

/**
 * 再帰ラムダ式が書けるFunctionインターフェース
 * @param <T>
 * @param <U>
 */
public interface RecursiveFunction<T, U> {
	public U apply(final RecursiveFunction<T, U> rec, final T n);
}