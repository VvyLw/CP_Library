package library.core.interfaces.lambda;

import java.util.function.LongConsumer;

/**
 * 再帰ラムダ式が書けるLongConsumerインターフェース
 * @see LongConsumer
 */
public interface RecursiveLongConsumer {
	public void accept(final RecursiveLongConsumer rec, final long n);
}