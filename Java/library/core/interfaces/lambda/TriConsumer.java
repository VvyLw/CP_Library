package library.core.interfaces.lambda;

import java.util.function.Consumer;

/**
 * 引数を三つ持てるConsumerインターフェース
 * @param <T>
 * @param <U>
 * @param <V>
 * @see Consumer
 */
public interface TriConsumer<T, U, V> {
	public void accept(final T a, final U b, final V c);
}