package library.other;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

import library.core.Utility;
import library.structure.FenwickTree;
import library.structure.pair.FloatPair;
import library.structure.pair.IntPair;
import library.structure.pair.Pair;

/**
 * coreパッケージ以外を使うメソッドを置いてあるクラス
 */
public final class Huitloxopetl {
	/**
	 * @param <F>
	 * @param <S>
	 * @param p
	 * @return Pair配列の各Pairに対して{@link Pair#swap}をした配列
	 */
	public final <F extends Comparable<? super F>, S extends Comparable<? super S>> Pair<S, F>[] swap(final Pair<F, S>[] p) {
		@SuppressWarnings("unchecked")
		final Pair<S, F>[] q = new Pair[p.length];
		IntStream.range(0, p.length).forEach(i -> q[i] = p[i].swap());
		return q;
	}
	/**
	 * @param p
	 * @return IntPair配列の各IntPairに対して{@link IntPair#swap}をした配列
	 */
	public final IntPair[] swap(final IntPair[] p) {
		final IntPair[] q = new IntPair[p.length];
		IntStream.range(0, p.length).forEach(i -> q[i] = p[i].swap());
		return q;
	}
	/**
	 * @param p
	 * @return FloatPair配列の各FloatPairに対して{@link FloatPair#swap}をした配列
	 */
	public final FloatPair[] swap(final FloatPair[] p) {
		final FloatPair[] q = new FloatPair[p.length];
		IntStream.range(0, p.length).forEach(i -> q[i] = p[i].swap());
		return q;
	}
	/**
	 * @param a
	 * @return 転倒数
	 */
	public final long invNum(final int[] a) {
		final int[] b = Utility.sorted(a);
		final Map<Integer, Integer> id = new HashMap<>();
		for(int i = 0; i < a.length; ++i) {
			id.put(b[i], i);
		}
		final FenwickTree bit = new FenwickTree(a.length);
		long res = 0;
		for(int i = 0; i < a.length; ++i) {
			res += i - bit.sum(id.get(a[i]));
			bit.add(id.get(a[i]), 1);
		}
		return res;
	}
	/**
	 * @param a
	 * @return 転倒数
	 */
	public final long invNum(final long[] a) {
		final long[] b = Utility.sorted(a);
		final Map<Long, Integer> id = new HashMap<>();
		for(int i = 0; i < a.length; ++i) {
			id.put(b[i], i);
		}
		final FenwickTree bit = new FenwickTree(a.length);
		long res = 0;
		for(int i = 0; i < a.length; ++i) {
			res += i - bit.sum(id.get(a[i]));
			bit.add(id.get(a[i]), 1);
		}
		return res;
	}
}