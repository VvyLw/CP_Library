package library.core.interfaces;

/**
 * 再帰ラムダ式が書けるTriPredicateインターフェース
 * @param <T>
 * @param <U>
 * @param <V>
 * @see TriPredicate
 */
public interface RecursiveTriPredicate<T, U, V> {
	public boolean test(final RecursiveTriPredicate<T, U, V> rec, final T x, final U y, final V z);
}