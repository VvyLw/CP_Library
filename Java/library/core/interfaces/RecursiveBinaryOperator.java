package library.core.interfaces;

import java.util.function.BinaryOperator;

/**
 * 再帰ラムダ式が書けるBinaryOperatorインターフェース
 * @param <T>
 * @see BinaryOperator
 */
public interface RecursiveBinaryOperator<T> {
	public T apply(final RecursiveBinaryOperator<T> rec, final T a, final T b);
}