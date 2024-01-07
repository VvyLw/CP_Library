package library.structure.unionfind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * UnionFind
 */
public final class UnionFind {
	private final int[] par;
	/**
	 * コンストラクタ
	 * @param n サイズ
	 */
	public UnionFind(final int n) {
		par = new int[n];
		Arrays.fill(par, -1);
	}
	/**
	 * @param i
	 * @return iの根
	 */
	public final int root(final int i){ return par[i] >= 0 ? par[i] = root(par[i]) : i; }
	/**
	 * @param i
	 * @return iを含む連結成分のサイズ
	 */
	public final int size(final int i){ return -par[root(i)]; }
	/**
	 * iとjをマージする
	 * @param i
	 * @param j
	 * @return 未マージでtrue, マージ済でfalse
	 */
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
	/**
	 * iとjが同じ連結成分に所属しているかどうか判定する
	 * @param i
	 * @param j
	 */
	public final boolean same(final int i, final int j){ return root(i) == root(j); }
	/**
	 * グラフを連結成分に分け、その情報を返す
	 * @see <a href="https://atcoder.github.io/ac-library/production/document_ja/dsu.html">atcoder::dsu::groups</a>
	 */
	public final ArrayList<ArrayList<Integer>> groups() {
		final int n = par.length;
		ArrayList<ArrayList<Integer>> res = new ArrayList<>(n);
		IntStream.range(0, n).forEach(i -> res.add(new ArrayList<>()));
		IntStream.range(0, n).forEach(i -> res.get(root(i)).add(i));
		res.removeIf(ArrayList::isEmpty);
		return res;
	}
	/**
	 * 二分グラフかどうか判定する
	 */
	final boolean isBipartite() {
		assert(par.length % 2 == 0);
		final int n = par.length / 2;
		boolean ok = true;
		for(int i = 0; i < n; ++i) {
			ok &= root(i) != root(i + n);
		}
		return ok;
	}
}