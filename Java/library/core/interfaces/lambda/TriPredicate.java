package library.core.interfaces.lambda;

/**
 * 引数を三つ持てるPredicateインターフェース
 * @param <T>
 * @param <U>
 * @param <V>
 * @see Predicate
 */
public interface TriPredicate<T, U, V> {
	public boolean test(final T a, final U b, final V c);
}