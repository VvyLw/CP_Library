package library.core.interfaces;

import java.util.function.DoubleBinaryOperator;

/**
 * 再帰ラムダが書けるDoubleBinaryOperatorインターフェース
 * @see DoubleBinaryOperator
 */
public interface RecursiveDoubleBinaryOperator {
	public double apply(final RecursiveDoubleBinaryOperator rec, final double a, final double b);
}