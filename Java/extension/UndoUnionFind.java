package extension;

import java.util.Arrays;
import java.util.Stack;

class UndoUnionFind {
	private int[] par;
	private Stack<Pair<Integer, Integer>> his;
	UndoUnionFind(final int n) {
	    par = new int[n];
	    Arrays.fill(par, -1);
	    his = new Stack<>();
	}
	boolean unite(int x, int y) {
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
	int root(final int i) {
		if(par[i] < 0) {
			return i;
		}
		return root(par[i]);
	}
	int size(final int i){ return -par[root(i)]; }
	void undo() {
		final Pair<Integer, Integer> pop1 = his.pop(), pop2 = his.pop();
		par[pop1.first] = pop1.second;
		par[pop2.first] = pop2.second;
	}
	void snapshot() {
		while(!his.empty()) {
			his.pop();
		}
	}
	void rollback() {
		while(!his.empty()) {
			undo();
		}
	}
}