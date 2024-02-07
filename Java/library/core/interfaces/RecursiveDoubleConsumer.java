package library.core.interfaces;

import java.util.function.DoubleConsumer;

/**
 * 再帰ラムダ式が書けるDoubleConsumerインターフェース
 * @see DoubleConsumer
 */
public interface RecursiveDoubleConsumer {
	public void accept(final RecursiveIntConsumer rec, final int n);
}