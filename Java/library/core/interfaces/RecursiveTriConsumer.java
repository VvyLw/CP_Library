package library.core.interfaces;

import java.util.function.Consumer;

/**
 * 再帰ラムダ式が書けるConsumerインターフェース
 * @param <T>
 * @param <U>
 * @param <V>
 * @see Consumer
 */
public interface RecursiveTriConsumer<T, U, V> {
	public void accept(final RecursiveTriConsumer<T, U, V> rec, final T x, final U y, final V z);
}