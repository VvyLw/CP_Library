package library.core.interfaces;

import java.util.function.Consumer;

/**
 * 再帰ラムダ式が書けるConsumerインターフェース
 * @param <T>
 * @see Consumer
 */
public interface RecursiveConsumer<T> {
	public void accept(final RecursiveConsumer<T> rec, final T x);
}