package library.core.interfaces;

import java.util.function.DoubleUnaryOperator;

/**
 * 再帰ラムダが書けるDoubleUnaryOperatorインターフェース
 * @see DoubleUnaryOperator
 */
public interface RecursiveDoubleUnaryOperator {
	public double apply(final RecursiveDoubleUnaryOperator rec, final double n);
}