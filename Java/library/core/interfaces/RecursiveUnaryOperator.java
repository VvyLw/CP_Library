package library.core.interfaces;

/**
 * 再帰ラムダ式が書けるUnaryOperatorインターフェース
 * @param <T>
 */
public interface RecursiveUnaryOperator<T> {
	public T apply(final RecursiveUnaryOperator<T> rec, final T n);
}