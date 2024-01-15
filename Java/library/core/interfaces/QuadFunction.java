package library.core.interfaces;

/**
 * 引数を四つ持てるFunctionインターフェース
 * @param <A>
 * @param <B>
 * @param <C>
 * @param <D>
 * @param <E>
 */
public interface QuadFunction<A, B, C, D, E> {
	public E apply(final A a, final B b, final C c, final D d);
}