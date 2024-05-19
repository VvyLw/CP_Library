package library.ds.unionfind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.stream.IntStream;
import library.core.interfaces.DSU;
import library.ds.pair.Pair;

/**
 * Undo可能なUnionFind
 * [注意] verifyしていない
 * @see <a href="https://ei1333.github.io/library/structure/union-find/union-find-undo.hpp">参考元</a>
 */
public final class UndoUnionFind implements DSU {
	private final int[] par;
	private final Stack<Pair<Integer, Integer>> his;
	/**
	 * コンストラクタ
	 * @param n サイズ
	 */
	public UndoUnionFind(final int n) {
	    par = new int[n];
	    Arrays.fill(par, -1);
	    his = new Stack<>();
	}
	@Override
	public final boolean unite(int x, int y) {
		x = root(x);
		y = root(y);
		his.add(Pair.of(x, par[x]));
		his.add(Pair.of(y, par[y]));
		if(x == y) {
			return false;
		}
		if(par[x] > par[y]) {
			x ^= y;
			y ^= x;
			x ^= y;
		}
		par[x] += par[y];
		par[y] = x;
		return true;
	}
	@Override
	public final int root(final int i) {
		if(par[i] < 0) {
			return i;
		}
		return root(par[i]);
	}
	@Override
	public final int size(final int i){ return -par[root(i)]; }
	@Override
	public final int size(){ return par.length; }
	public final ArrayList<ArrayList<Integer>> groups() {
		final int n = par.length;
		ArrayList<ArrayList<Integer>> res = new ArrayList<>(n);
		IntStream.range(0, n).forEach(i -> res.add(new ArrayList<>()));
		IntStream.range(0, n).forEach(i -> res.get(root(i)).add(i));
		res.removeIf(ArrayList::isEmpty);
		return res;
	}
	/**
	 * 直前のuniteの操作を取り消す
	 */
	public final void undo() {
		final Pair<Integer, Integer> pop1 = his.pop(), pop2 = his.pop();
		par[pop1.first] = pop1.second;
		par[pop2.first] = pop2.second;
	}
	/**
	 * 現在の状態を保存する
	 */
	public final void snapshot() {
		while(!his.empty()) {
			his.pop();
		}
	}
	/**
	 * UnionFindをロールバックする
	 */
	public final void rollback() {
		while(!his.empty()) {
			undo();
		}
	}
	@Override
	public final String toString(){ return groups().toString(); }
}