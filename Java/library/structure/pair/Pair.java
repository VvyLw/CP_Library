package library.structure.pair;

/**
 * C++のstd::pairに相当するクラス
 * @param <F>
 * @param <S>
 */
public class Pair<F extends Comparable<? super F>, S extends Comparable<? super S>> implements Comparable<Pair<F, S>>, Cloneable {
	public F first;
	public S second;
	/**
	 * コンストラクタ
	 * @param first
	 * @param second
	 */
	protected Pair(final F first, final S second) {
		this.first = first;
		this.second = second;
	}
	/**
	 * Pairを宣言するのに使う
	 * new Pairと同等
	 * @param <F>
	 * @param <S>
	 * @param a first
	 * @param b second
	 */
	public static final <F extends Comparable<? super F>, S extends Comparable<? super S>> Pair<F, S> of(final F a, final S b){ return new Pair<>(a, b); }
	/**
	 * std::pairにはない
	 * @return firstとsecondを入れ替えたPair
	 */
	public Pair<S, F> swap(){ return Pair.of(second, first); }
	@Override
	public final boolean equals(final Object o) {
		if(this == o) {
			return true;
		}
		if(o == null || getClass() != o.getClass()) {
			return false;
		}
		final Pair<?, ?> p = (Pair<?, ?>) o;
		if(!first.equals(p.first)) {
			return false;
		}
		return second.equals(p.second);
	}
	@Override
	public final String toString(){ return "(" + first + ", " + second + ")"; }
	@SuppressWarnings("unchecked")
	@Override
	public final Pair<F, S> clone() {
		try {
			return (Pair<F, S>) super.clone();
		} catch(final CloneNotSupportedException e){
			e.printStackTrace();
		}
		throw new Error();
	}
	@Override
	public final int compareTo(final Pair<F, S> p) {
		if(first.compareTo(p.first) == 0) {
			return second.compareTo(p.second);
		}
		return first.compareTo(p.first);
	}
}