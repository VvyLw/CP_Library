package library.ds.unionfind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

import library.core.interfaces.DSU;

/**
 * UnionFind
 */
public class UnionFind implements DSU {
	protected final int[] par;
	/**
	 * コンストラクタ
	 * @param n サイズ
	 */
	public UnionFind(final int n) {
		par = new int[n];
		Arrays.fill(par, -1);
	}
	@Override
	public final int root(final int i){ return par[i] >= 0 ? par[i] = root(par[i]) : i; }
	@Override
	public final int size(final int i){ return -par[root(i)]; }
	@Override
	public final int size(){ return par.length; }
	@Override
	public boolean unite(int i, int j) {
		i = root(i);
		j = root(j);
		if(i == j) {
			return false;
		}
		if(i > j) {
			i ^= j;
			j ^= i;
			i ^= j;
		}
		par[i] += par[j];
		par[j] = i;
		return true;
	}
	@Override
	public final ArrayList<ArrayList<Integer>> groups() {
		final int n = par.length;
		ArrayList<ArrayList<Integer>> res = new ArrayList<>(n);
		IntStream.range(0, n).forEach(i -> res.add(new ArrayList<>()));
		IntStream.range(0, n).forEach(i -> res.get(root(i)).add(i));
		res.removeIf(ArrayList::isEmpty);
		return res;
	}
}