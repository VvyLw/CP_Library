package library.structure.unionfind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public final class UnionFind {
	private final int[] par;
	public UnionFind(final int n) {
		par = new int[n];
		Arrays.fill(par, -1);
	}
	public final int root(final int i){ return par[i] >= 0 ? par[i] = root(par[i]) : i; }
	public final int size(final int i){ return -par[root(i)]; }
	public final boolean unite(int i, int j) {
		i = root(i);
		j = root(j);
		if(i == j) return false;
		if(i > j) {
			i ^= j;
			j ^= i;
			i ^= j;
		}
		par[i] += par[j];
		par[j] = i;
		return true;
	}
	public final boolean same(final int i, final int j){ return root(i) == root(j); }
	public final ArrayList<ArrayList<Integer>> groups() {
		final int n = par.length;
		ArrayList<ArrayList<Integer>> res = new ArrayList<>(n);
		IntStream.range(0, n).forEach(i -> res.add(new ArrayList<>()));
		IntStream.range(0, n).forEach(i -> res.get(root(i)).add(i));
		res.removeIf(ArrayList::isEmpty);
		return res;
	}
	final boolean isBipartite() {
		final int n = par.length / 2;
		boolean ok = true;
		for(int i = 0; i < n; ++i) {
			ok &= root(i) != root(i + n);
		}
		return ok;
	}
}