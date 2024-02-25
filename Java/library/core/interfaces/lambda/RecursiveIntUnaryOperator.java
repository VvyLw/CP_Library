package library.core.interfaces.lambda;

import java.util.function.IntUnaryOperator;

/**
 * 再帰ラムダが書けるIntUnaryOperatorインターフェース
 * @see IntUnaryOperator
 */
public interface RecursiveIntUnaryOperator {
	public int apply(final RecursiveIntUnaryOperator rec, final int n);
}