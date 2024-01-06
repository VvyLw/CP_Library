package library.graph;

final class SkewHeap {
	static final class Node {
		long key, lazy;
		Node l, r;
		final int idx;
		Node(final long key, final int idx) {
			this.key = key;
			this.idx = idx;
			lazy = 0;
			l = null;
			r = null;
		}
	}
	private final boolean isMin;
	SkewHeap(final boolean isMin){ this.isMin = isMin; }
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
	final Node meld(Node x, Node y) {
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
	final Node push(final Node t, final long key, int idx){ return meld(t, alloc(key, idx)); }
	final Node pop(final Node t) {
		if(t == null) {
			throw new NullPointerException();
		}
		return meld(t.l, t.r);
	}
	final Node add(Node t, final long lazy) {
		if(t != null) {
			t.lazy += lazy;
			propagate(t);
		}
		return t;
	}
}