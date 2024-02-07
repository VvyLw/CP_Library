package library.core.interfaces;

import java.util.function.BiConsumer;

/**
 * 再帰ラムダ式が書けるBiConsumerインターフェース
 * @param <T>
 * @param <U>
 * @see BiConsumer
 */
public interface RecursiveBiConsumer<T, U> {
	public void accept(final RecursiveBiConsumer<T, U> rec, final T x, final U y);
}