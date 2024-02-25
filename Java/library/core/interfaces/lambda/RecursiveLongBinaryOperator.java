package library.core.interfaces.lambda;

import java.util.function.LongBinaryOperator;

/**
 * 再帰ラムダが書けるLongBinaryOperatorインターフェース
 * @see LongBinaryOperator
 */
public interface RecursiveLongBinaryOperator {
	public long apply(final RecursiveLongBinaryOperator rec, final long a, final long b);
}