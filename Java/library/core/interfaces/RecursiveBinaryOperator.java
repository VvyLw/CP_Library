package library.core.interfaces;

/**
 * 再帰ラムダ式が書けるBinaryOperatorインターフェース
 * @param <T>
 */
public interface RecursiveBinaryOperator<T> {
	public T apply(final RecursiveBinaryOperator<T> rec, final T a, final T b);
}