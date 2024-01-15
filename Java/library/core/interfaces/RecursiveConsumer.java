package library.core.interfaces;

/**
 * 再帰ラムダ式が書けるConsumerインターフェース
 * @param <T>
 */
public interface RecursiveConsumer<T> {
	public void accept(final RecursiveConsumer<T> rec, final T x);
}