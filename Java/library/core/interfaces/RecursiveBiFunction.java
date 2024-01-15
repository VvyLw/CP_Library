package library.core.interfaces;

/**
 * 再帰ラムダ式が書けるFunctionインターフェース
 * @param <T>
 * @param <U>
 * @param <V>
 */
public interface RecursiveBiFunction<T, U, V> {
	public V apply(final RecursiveBiFunction<T, U, V> rec, final T n, final U m);
}