package library.structure.unionfind;

import java.util.Arrays;

/**
 * 重みつきUnionFind(PotentialつきUnionFind)
 * @see <a href="https://ei1333.github.io/library/structure/union-find/weighted-union-find.hpp">参考元</a>
 */
public final class WeightedUnionFind {
	private final int[] par;
	private final long[] weight;
	/**
	 * コンストラクタ
	 * @param n サイズ
	 */
	public WeightedUnionFind(final int n) {
		par = new int[n];
		weight = new long[n];
		Arrays.fill(par, -1);
	}
	/**
	 * @param i
	 * @return iの根
	 */
	public final int root(final int i) {
		if(par[i] < 0) {
			return i;
		}
		final int r = root(par[i]);
		weight[i] += weight[par[i]];
		return par[i] = r;
	}
	/**
	 * 
	 * @param i
	 * @return iの根の重み
	 */
	public final long get(final int i) {
		root(i);
		return weight[i];
	}
	/**
	 * @param x
	 * @param y
	 * @return 重みの差
	 */
	public final long diff(final int x, final int y){ return get(y) - get(x); }
	/**
	 * xとyをマージする
	 * @param x
	 * @param y
	 * @param w
	 * @return 未マージなら1, マージ済で重みが0なら0, 重みがあれば-1
	 */
	public final int unite(int x, int y, long w) {
		w += diff(y, x);
		x = root(x);
		y = root(y);
		if(x == y) {
			return w == 0 ? 0 : -1;
		}
		if(par[x] > par[y]) {
			x ^= y;
			y ^= x;
			x ^= y;
			w = -w;
		}
		par[x] += par[y];
		par[y] = x;
		weight[y] = w;
		return 1;
	}
	/**
	 * xとyが同じ連結成分に所属しているかどうか判定する
	 * @param x
	 * @param y
	 */
	public final boolean same(final int x, final int y){ return root(x) == root(y); }
}