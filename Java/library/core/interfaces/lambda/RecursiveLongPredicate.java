package library.core.interfaces.lambda;

import java.util.function.LongPredicate;

/**
 * 再帰ラムダ式が書けるLongPredicateインターフェース
 * @see LongPredicate
 */
public interface RecursiveLongPredicate {
	public boolean test(final RecursiveLongPredicate rec, final long n);
}
