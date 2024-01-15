package library.core.interfaces;

/**
 * 引数を三つ持てるFunctionインターフェース
 * @param <T>
 * @param <U>
 * @param <V>
 * @param <W>
 */
public interface TriFunction<T, U, V, W> {
	public W apply(final T a, final U b, final V c);
}