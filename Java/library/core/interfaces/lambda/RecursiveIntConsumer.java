package library.core.interfaces.lambda;

import java.util.function.IntConsumer;

/**
 * 再帰ラムダ式が書けるIntConsumerインターフェース
 * @see IntConsumer
 */
public interface RecursiveIntConsumer {
	public void accept(final RecursiveIntConsumer rec, final int n);
}