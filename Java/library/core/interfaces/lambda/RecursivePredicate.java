package library.core.interfaces.lambda;

/**
 * 再帰ラムダ式が書けるPredicateインターフェース
 * @param <T>
 * @see Predicate
 */
public interface RecursivePredicate<T> {
	public boolean test(final RecursivePredicate<T> rec, final T n);
}