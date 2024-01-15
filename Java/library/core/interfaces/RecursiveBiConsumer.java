package library.core.interfaces;

/**
 * 再帰ラムダ式が書けるConsumerインターフェース
 * @param <T>
 * @param <U>
 */
public interface RecursiveBiConsumer<T, U> {
	public void accept(final RecursiveBiConsumer<T, U> rec, final T x, final U y);
}