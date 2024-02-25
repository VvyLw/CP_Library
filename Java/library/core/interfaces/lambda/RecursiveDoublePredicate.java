package library.core.interfaces.lambda;

import java.util.function.DoublePredicate;

/**
 * 再帰ラムダ式が書けるDoublePredicateインターフェース
 * @see DoublePredicate
 */
public interface RecursiveDoublePredicate {
	public boolean test(final RecursiveDoublePredicate rec, final double n);
}
