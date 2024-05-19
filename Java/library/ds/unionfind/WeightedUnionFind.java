package library.ds.unionfind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

import library.core.interfaces.DSU;

/**
 * 重みつきUnionFind(PotentialつきUnionFind)
 * @see <a href="https://ei1333.github.io/library/structure/union-find/weighted-union-find.hpp">参考元</a>
 */
public final class WeightedUnionFind implements DSU {
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
	@Override
	public final int root(final int i) {
		if(par[i] < 0) {
			return i;
		}
		final int r = root(par[i]);
		weight[i] += weight[par[i]];
		return par[i] = r;
	}
	/**
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
	@Override
	public final int size(final int i){ return -par[root(i)]; }
	@Override
	public final int size(){ return par.length; }
	/**
	 * @deprecated インターフェースで仕方なく適当に実装
	 */
	@Override
	public final boolean unite(int i, int j){ return unite(i, j, 0) > 0; }
	@Override
	public final ArrayList<ArrayList<Integer>> groups() {
		final int n = par.length;
		final ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		IntStream.range(0, n).forEach(i -> res.add(new ArrayList<>()));
		IntStream.range(0, n).forEach(i -> res.get(root(i)).add(i));
		res.removeIf(ArrayList::isEmpty);
		return res;
	}
	@Override
	public final String toString(){ return groups().toString(); }
}