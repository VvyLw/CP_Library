package library.other;

import library.graph.Graph;

/**
 * なんですかこれは
 * 最小有向全域木を求める際に使うクラス
 * 中身はよくわかっていない
 * @see Graph#directed
 * @see <a href="https://ei1333.github.io/library/structure/heap/skew-heap.hpp">窃盗先</a>
 */
public final class SkewHeap {
	public static final class Node {
		public long key, lazy;
		Node l, r;
		public final int idx;
		Node(final long key, final int idx) {
			this.key = key;
			this.idx = idx;
			lazy = 0;
			l = null;
			r = null;
		}
	}
	private final boolean isMin;
	/**
	 * コンストラクタ
	 * @param isMin
	 */
	public SkewHeap(final boolean isMin){ this.isMin = isMin; }
	private final Node alloc(final long key, final int idx){ return new Node(key, idx); }
	private final Node propagate(final Node t) {
		if(t != null && t.lazy != 0) {
			if(t.l != null) {
				t.l.lazy += t.lazy;
			}
			if(t.r != null) {
				t.r.lazy += t.lazy;
			}
			t.key += t.lazy;
			t.lazy = 0;
		}
		return t;
	}
	public final Node meld(Node x, Node y) {
		propagate(x);
		propagate(y);
		if(x == null || y == null) {
			return x != null ? x : y;
		}
		if((x.key < y.key) ^ isMin) {
			final Node tmp = x;
			x = y;
			y = tmp;
		}
		x.r = meld(y, x.r);
		final Node tmp = x.l;
		x.l = x.r;
		x.r = tmp;
		return x;
	}
	public final Node push(final Node t, final long key, int idx){ return meld(t, alloc(key, idx)); }
	public final Node pop(final Node t) {
		if(t == null) {
			throw new NullPointerException();
		}
		return meld(t.l, t.r);
	}
	public final Node add(Node t, final long lazy) {
		if(t != null) {
			t.lazy += lazy;
			propagate(t);
		}
		return t;
	}
}