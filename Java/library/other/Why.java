package library.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.IntStream;

import library.core.Utility;
import library.ds.fenwicktree.FenwickTree;
import library.ds.unionfind.UnionFind;
import library.graph.Edge;

/**
 * coreパッケージ以外の外部クラス(Pairを除くを使うメソッドが置いてある)
 */
public final class Why {
	/**
	 * 与えられたグラフが二分グラフかどうか判定する
	 * @param uf
	 * @return 二分グラフかどうか
	 * @apiNote {@link UnionFind}が必要
	 */
	public static final boolean isBipartite(final UnionFind uf) {
		assert uf.size() % 2 == 0;
		final int n = uf.size() / 2;
		boolean ok = true;
		for(int i = 0; i < n; ++i) {
			ok &= !uf.same(i, i + n);
		}
		return ok;
	}
	/**
	 * 転倒数を求める
	 * @param a
	 * @return 転倒数
	 * @apiNote {@link FenwickTree}が必要
	 */
	public static final long invNum(final int[] a) {
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
	 * 転倒数を求める
	 * @param a
	 * @return 転倒数
	 * @apiNote {@link FenwickTree}が必要
	 */
	public static final long invNum(final long[] a) {
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
	/**
	 * @deprecated verifiedしていない
	 * 遅い
	 * @param x
	 * @param y
	 * @return manhattan MST
	 */
	public static final ArrayList<Edge> manhattan(int[] x, int[] y) {
		assert x.length == y.length;
		final int n = x.length;
		final var res = new ArrayList<Edge>();
		for(int s = 0; s < 2; ++s) {
			for(int t = 0; t < 2; ++t) {
				final var id = IntStream.range(0, n).boxed().sorted((i, j) -> Integer.compare(x[i] + y[i], x[j] + y[j])).mapToInt(i -> i).toArray();
				final var idx = new TreeMap<Integer, Integer>();
				for(final var i: id) {
					final var it = idx.tailMap(y[i]).entrySet().iterator();
					while(it.hasNext()) {
						final int j = it.next().getValue();
						if(x[i] - x[j] < y[i] - y[j]) {
							break;
						}
						res.add(new Edge(i, j, Math.abs(x[i] - x[j]) + Math.abs(y[i] - y[j])));
						it.remove();
					}
					idx.put(-y[i], i);
				}
				final var tmp = y.clone();
				System.arraycopy(x, 0, y, 0, n);
				System.arraycopy(tmp, 0, x, 0, n);
			}
			for(int i = 0; i < n; ++i) {
				x[i] = -x[i];
			}
		}
		return res;
	}
	/**
	 * @deprecated verifiedしていない
	 * 遅い
	 * @param x
	 * @param y
	 * @return manhattan MST
	 */
	public static final ArrayList<Edge> manhattan(long[] x, long[] y) {
		assert x.length == y.length;
		final int n = x.length;
		final var res = new ArrayList<Edge>();
		for(int s = 0; s < 2; ++s) {
			for(int t = 0; t < 2; ++t) {
				final var id = IntStream.range(0, n).boxed().sorted((i, j) -> Long.compare(x[i] + y[i], x[j] + y[j])).mapToInt(i -> i).toArray();
				final var idx = new TreeMap<Long, Integer>();
				for(final var i: id) {
					final var it = idx.tailMap(y[i]).entrySet().iterator();
					while(it.hasNext()) {
						final int j = it.next().getValue();
						if(x[i] - x[j] < y[i] - y[j]) {
							break;
						}
						res.add(new Edge(i, j, Math.abs(x[i] - x[j]) + Math.abs(y[i] - y[j]), -1));
						it.remove();
					}
					idx.put(-y[i], i);
				}
				final var tmp = y.clone();
				System.arraycopy(x, 0, y, 0, n);
				System.arraycopy(tmp, 0, x, 0, n);
			}
			for(int i = 0; i < n; ++i) {
				x[i] = -x[i];
			}
		}
		return res;
	}
}