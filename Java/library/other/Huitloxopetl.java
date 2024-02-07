package library.other;

import java.util.HashMap;
import java.util.Map;

import library.core.Utility;
import library.structure.FenwickTree;
import library.structure.unionfind.UnionFind;

/**
 * coreパッケージ以外の外部クラス(Pairを除くを使うメソッドが置いてある
 */
public final class Huitloxopetl {
	/**
	 * @param uf
	 * @return 二分グラフかどうか
	 * @implNote {@link UnionFind}が必要
	 */
	public final boolean isBipartite(final UnionFind uf) {
		assert uf.size() % 2 == 0;
		final int n = uf.size() / 2;
		boolean ok = true;
		for(int i = 0; i < n; ++i) {
			ok &= uf.root(i) != uf.root(i + n);
		}
		return ok;
	}
	/**
	 * @param a
	 * @return 転倒数
	 * @implNote {@link FenwickTree}が必要
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
	 * @implNote {@link FenwickTree}が必要
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