package library.core.interfaces;

import java.util.function.BiPredicate;

/**
 * 再帰ラムダ式が書けるBiPredicateインターフェース
 * @param <T>
 * @param <U>
 * @see BiPredicate
 */
public interface RecursiveBiPredicate<T, U> {
	public boolean test(final RecursiveBiPredicate<T, U> rec, final T x, final U y);
}