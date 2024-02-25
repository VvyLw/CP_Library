package library.core.interfaces.lambda;

import java.util.function.UnaryOperator;

/**
 * 再帰ラムダ式が書けるUnaryOperatorインターフェース
 * @param <T>
 * @see UnaryOperator
 */
public interface RecursiveUnaryOperator<T> {
	public T apply(final RecursiveUnaryOperator<T> rec, final T n);
}