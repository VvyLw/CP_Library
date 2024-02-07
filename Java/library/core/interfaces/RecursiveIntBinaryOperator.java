package library.core.interfaces;

import java.util.function.IntBinaryOperator;

/**
 * 再帰ラムダが書けるIntBinaryOperatorインターフェース
 * @see IntBinaryOperator
 */
public interface RecursiveIntBinaryOperator {
	public int apply(final RecursiveIntBinaryOperator rec, final int a, final int b);
}