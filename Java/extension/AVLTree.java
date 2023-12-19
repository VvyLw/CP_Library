final class AVLTree<T extends Comparable<? super T>> {
	static final class Node<T extends Comparable<? super T>> {
		T val;
		@SuppressWarnings("unchecked")
		Node<T>[] ch = new Node[2];
		int dep, size;
		Node(final T val, Node<T> l, Node<T> r) {
			this.val = val;
			dep = size = 1;
			ch[0] = l;
			ch[1] = r;
		}
	}
	private Node<T> root;
	private final int depth(final Node<T> t){ return t == null ? 0 : t.dep; }
	private final int count(final Node<T> t){ return t == null ? 0 : t.size; }
	private final Node<T> update(final Node<T> t) {
		t.dep = Math.max(depth(t.ch[0]), depth(t.ch[1])) + 1;
		t.size = count(t.ch[0]) + count(t.ch[1]) + 1;
		return t;
	}
	private final Node<T> rotate(Node<T> t, final int b) {
		var s = t.ch[1 - b];
		t.ch[1 - b] = s.ch[b];
		s.ch[b] = t;
		t = update(t);
		s = update(s);
		return s;
	}
	private final Node<T> fetch(Node<T> t) {
		if(t == null) {
			return t;
		}
		if(depth(t.ch[0]) - depth(t.ch[1]) == 2) {
			if(depth(t.ch[0].ch[1]) > depth(t.ch[0].ch[0])) {
				t.ch[0] = rotate(t.ch[0], 0);
			}
			t = rotate(t, 1);
		}
		else if(depth(t.ch[0]) - depth(t.ch[1]) == -2) {
			if (depth(t.ch[1].ch[0]) > depth(t.ch[1].ch[1])) {
				t.ch[1] = rotate(t.ch[1], 1);
			}
			t = rotate(t, 0);
		}
		return t;
	}
	private final Node<T> insert(final Node<T> t, final int k, final T v) {
		if(t == null) {
			return new Node<T>(v, null, null);
		}
		final int c = count(t.ch[0]), b = (k > c) ? 1 : 0;
		t.ch[b] = insert(t.ch[b], k - (b == 1 ? (c + 1) : 0), v);
		update(t);
		return fetch(t);
	}
	private final Node<T> erase(final Node<T> t) {
		if(t == null || t.ch[0] == null && t.ch[1] == null) {
			return null;
		}
		if(t.ch[0] == null || t.ch[1] == null) {
			return t.ch[t.ch[0] == null ? 1 : 0];
		}
		return fetch(update(new Node<T>(find(t.ch[1], 0).val, t.ch[0], erase(t.ch[1], 0))));
	}
	private final Node<T> erase(Node<T> t, final int k) {
		if(t == null) {
			return null;
		}
		final int c = count(t.ch[0]);
		if(k < c) {
			t.ch[0] = erase(t.ch[0], k);
			t = update(t);
		}
		else if(k > c) {
			t.ch[1] = erase(t.ch[1], k - (c + 1));
			t = update(t);
		}
		else {
			t = erase(t);
		}
		return fetch(t);
	}
	private final Node<T> find(final Node<T> t, final int k) {
		if(t == null) {
			return t;
		}
		final int c = count(t.ch[0]);
		return k < c ? find(t.ch[0], k) : k == c ? t : find(t.ch[1], k - (c + 1));
	}
	private final int cnt(final Node<T> t, final T v) {
		if(t == null) {
			return 0;
		}
		if(t.val.compareTo(v) < 0) {
			return count(t.ch[0]) + 1 + cnt(t.ch[1], v);
		}
		if(t.val.equals(v)) {
			return count(t.ch[0]);
		}
		return cnt(t.ch[0], v);
	}
	AVLTree(){ root = null; }
	final void add(final T val){ root = insert(root, cnt(root, val), val); }
	final void remove(final int k){ root = erase(root, k); }
	final T get(final int k){ return find(root, k).val; }
	final int count(final T val){ return cnt(root, val); }
	final int size(){ return root.size; }
	@Override
	public final String toString() {
		final var sb = new StringBuilder();
		sb.append(get(0));
		for(int i = 0; ++i < root.size;) {
			sb.append(" ");
			sb.append(get(i));
		}
		return "[" + sb.toString() + "]";
	}
}