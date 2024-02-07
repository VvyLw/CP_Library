package library.core.interfaces;

import java.util.function.LongUnaryOperator;

/**
 * 再帰ラムダが書けるLongUnaryOperatorインターフェース
 * @see LongUnaryOperator
 */
public interface RecursiveLongUnaryOperator {
	public long apply(final RecursiveLongUnaryOperator rec, final long n);
}
