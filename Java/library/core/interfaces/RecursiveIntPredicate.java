package library.core.interfaces;

import java.util.function.IntPredicate;

/**
 * 再帰ラムダ式が書けるIntPredicateインターフェース
 * @see IntPredicate
 */
public interface RecursiveIntPredicate {
	public boolean test(final RecursiveIntPredicate rec, final int n);
}