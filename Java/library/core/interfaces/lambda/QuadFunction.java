package library.core.interfaces.lambda;

import java.util.function.Function;

/**
 * 引数を四つ持てるFunctionインターフェース
 * @param <A>
 * @param <B>
 * @param <C>
 * @param <D>
 * @param <R>
 * @see Function
 */
public interface QuadFunction<A, B, C, D, R> {
	public R apply(final A a, final B b, final C c, final D d);
}