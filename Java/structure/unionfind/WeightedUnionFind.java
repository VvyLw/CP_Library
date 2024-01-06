package library.structure.unionfind;

import java.util.Arrays;

public final class WeightedUnionFind {
	private final int[] par;
	private final long[] weight;
	public WeightedUnionFind(final int n) {
		par = new int[n];
		weight = new long[n];
		Arrays.fill(par, -1);
	}
	public final int root(final int i) {
		if(par[i] < 0) {
			return i;
		}
		final int r = root(par[i]);
		weight[i] += weight[par[i]];
		return par[i] = r;
	}
	public final long get(final int i) {
		root(i);
		return weight[i];
	}
	public final long diff(final int x, final int y){ return get(y) - get(x); }
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
	public final boolean same(final int x, final int y){ return root(x) == root(y); }
}