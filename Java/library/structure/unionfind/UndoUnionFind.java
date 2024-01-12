package library.structure.unionfind;

import java.util.Arrays;
import java.util.Stack;

import library.structure.pair.Pair;

/**
 * Undo可能なUnionFind
 * [注意] verifyしていない
 * @see <a href="https://ei1333.github.io/library/structure/union-find/union-find-undo.hpp">参考元</a>
 */
public final class UndoUnionFind {
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
	/**
	 * xとyをマージする
	 * @param x
	 * @param y
	 * @return 未マージでtrue, マージ済でfalse
	 */
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
	/**
	 * @param i
	 * @return iの根
	 */
	public final int root(final int i) {
		if(par[i] < 0) {
			return i;
		}
		return root(par[i]);
	}
	/**
	 * @param i
	 * @return iを含む連結成分のサイズ
	 */
	public final int size(final int i){ return -par[root(i)]; }
	/**
	 * 直前のuniteの操作を取り消す
	 */
	public final void undo() {
		final Pair<Integer, Integer> pop1 = his.pop(), pop2 = his.pop();
		par[pop1.first] = pop1.second;
		par[pop2.first] = pop2.second;
	}
	/**
	 * 現在のの状態を保存する
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
}