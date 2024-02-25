package library.core.interfaces.lambda;

/**
 * 再帰ラムダ式が書けるTriConsumerインターフェース
 * @param <T>
 * @param <U>
 * @param <V>
 * @see TriConsumer
 */
public interface RecursiveTriConsumer<T, U, V> {
	public void accept(final RecursiveTriConsumer<T, U, V> rec, final T x, final U y, final V z);
}