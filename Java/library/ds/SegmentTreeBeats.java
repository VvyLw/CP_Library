package library.ds;

/**
 * SegmentTreeBeats!
 * @see <a href="https://nyaannyaan.github.io/library/segment-tree/segment-tree-beats.hpp">参考元</a>
 */
public class SegmentTreeBeats {
	private final long INF = (1L << 61) - 1;
	private final class Node {
		long sum = 0, g1 = 0, l1 = 0, g2 = -INF, gc = 1, l2 = INF, lc = 1, add = 0;
	}
	private final Node[] a;
	private int n, log;
	/**
	 * コンストラクタ
	 * @param n
	 */
	public SegmentTreeBeats(final int n){ this(new int[n]); }
	/**
	 * コンストラクタ
	 * @param a
	 */
	public SegmentTreeBeats(final int[] a) {
		final int m = a.length;
		n = 1;
		log = 0;
		while(n < m) {
			log++;
			n <<= 1;
		}
		this.a = new Node[2 * n];
		for(int i = 0; i < 2 * n; ++i) {
			this.a[i] = new Node();
		}
		for(int i = 0; i < m; ++i) {
			this.a[i + n].sum = this.a[i + n].g1 = this.a[i + n].l1 = a[i];
		}
		for(int i = n; --i >= 0;) {
			update(i);
		}
	}
	/**
	 * コンストラクタ
	 * @param a
	 */
	public SegmentTreeBeats(final long[] a) {
		final int m = a.length;
		n = 1;
		log = 0;
		while(n < m) {
			log++;
			n <<= 1;
		}
		this.a = new Node[2 * n];
		for(int i = 0; i < 2 * n; ++i) {
			this.a[i] = new Node();
		}
		for(int i = 0; i < m; ++i) {
			this.a[i + n].sum = this.a[i + n].g1 = this.a[i + n].l1 = a[i];
		}
		for(int i = n; --i >= 0;) {
			update(i);
		}
	}
	/**
	 * 半開区間[l, r)の要素をzとすると, z = min(x, z)をする
	 * @param l
	 * @param r
	 * @param x
	 */
	public final void chmin(final int l, final int r, final long x){ innerApply(1, l, r, x); }
	/**
	 * 半開区間[l, r)の要素をzとすると, z = max(x, z)をする
	 * @param l
	 * @param r
	 * @param x
	 */
	public final void chmax(final int l, final int r, final long x){ innerApply(2, l, r, x); }
	/**
	 * 半開区間[l, r)の要素をzとすると, z += xをする
	 * @param l
	 * @param r
	 * @param x
	 */
	public final void add(final int l, final int r, final long x){ innerApply(3, l, r, x); }
	/**
	 * 半開区間[l, r)の要素をzとすると, z = xをする
	 * @param l
	 * @param r
	 * @param x
	 */
	public final void update(final int l, final int r, final long x){ innerApply(4, l, r, x); }
	/**
	 * 半開区間[l, r)での最小値を求める
	 * @param l
	 * @param r
	 * @return min(a[l], a[l+1], ..., a[r - 1])
	 */
	public final long min(final int l, final int r){ return innerFold(1, l, r); }
	/**
	 * 半開区間[l, r)での最大値を求める
	 * @param l
	 * @param r
	 * @return max(a[l], a[l+1], ..., a[r - 1])
	 */
	public final long max(final int l, final int r){ return innerFold(2, l, r); }
	/**
	 * 半開区間[l, r)での総和を求める
	 * @param l
	 * @param r
	 * @return sum(a[l], a[l+1], ..., a[r - 1])
	 */
	public final long sum(final int l, final int r){ return innerFold(3, l, r); }
	private final void update(final int k) {
		final Node p = a[k], l = a[k * 2 + 0], r = a[k * 2 + 1];
		p.sum = l.sum + r.sum;
		if(l.g1 == r.g1) {
			p.g1 = l.g1;
			p.g2 = Math.max(l.g2, r.g2);
			p.gc = l.gc + r.gc;
		} else {
			final boolean f = l.g1 > r.g1;
			p.g1 = f ? l.g1 : r.g1;
			p.gc = f ? l.gc : r.gc;
			p.g2 = Math.max(f ? r.g1 : l.g1, f ? l.g2 : r.g2);
		}
		if(l.l1 == r.l1) {
			p.l1 = l.l1;
			p.l2 = Math.min(l.l2, r.l2);
			p.lc = l.lc + r.lc;
		} else {
			final boolean f = l.l1 < r.l1;
			p.l1 = f ? l.l1 : r.l1;
			p.lc = f ? l.lc : r.lc;
			p.l2 = Math.min(f ? r.l1 : l.l1, f ? l.l2 : r.l2);
		}
	}
	private final void pushAdd(final int k, final long x) {
		final Node p = a[k];
		p.sum += x << (log + Integer.numberOfLeadingZeros(k) - 31);
		p.g1 += x;
		p.l1 += x;
		if(p.g2 != -INF) {
			p.g2 += x;
		}
		if(p.l2 != INF) {
			p.l2 += x;
		}
		p.add += x;
	}
	private final void pushMin(final int k, final long x) {
		final Node p = a[k];
		p.sum += (x - p.g1) * p.gc;
		if(p.l1 == p.g1) {
			p.l1 = x;
		}
		if(p.l2 == p.g1) {
			p.l2 = x;
		}
		p.g1 = x;
	}
	private final void pushMax(final int k, final long x) {
		final Node p = a[k];
		p.sum += (x - p.l1) * p.lc;
		if(p.g1 == p.l1) {
			p.g1 = x;
		}
		if(p.g2 == p.l1) {
			p.g2 = x;
		}
		p.l1 = x;
	}
	private final void push(final int k) {
		final Node p = a[k];
		if(p.add != 0) {
			pushAdd(k * 2 + 0, p.add);
			pushAdd(k * 2 + 1, p.add);
			p.add = 0;
		}
		if(p.g1 < a[k * 2 + 0].g1) {
			pushMin(k * 2 + 0, p.g1);
		}
		if(p.l1 > a[k * 2 + 0].l1) {
			pushMax(k * 2 + 0, p.l1);
		}
		if(p.g1 < a[k * 2 + 1].g1) {
			pushMin(k * 2 + 1, p.g1);
		}
		if(p.l1 > a[k * 2 + 1].l1) {
			pushMax(k * 2 + 1, p.l1);
		}
	}
	private final void subtreeChmin(final int k, final long x) {
		if(a[k].g1 <= x) {
			return;
		}
		if(a[k].g2 < x) {
			pushMin(k, x);
			return;
		}
		push(k);
		subtreeChmin(k * 2 + 0, x);
		subtreeChmin(k * 2 + 1, x);
		update(k);
	}
	private final void subtreeChmax(final int k, final long x) {
		if(x <= a[k].l1) {
			return;
		}
		if(x < a[k].l2) {
			pushMax(k, x);
			return;
		}
		push(k);
		subtreeChmax(k * 2 + 0, x);
		subtreeChmax(k * 2 + 1, x);
		update(k);
	}
	private final void applyBeta(final int cmd, final int k, final long x) {
		if(cmd == 1) {
			subtreeChmin(k, x);
		}
		if(cmd == 2) {
			subtreeChmax(k, x);
		}
		if(cmd == 3) {
			pushAdd(k, x);
		}
		if(cmd == 4) {
			subtreeChmin(k, x);
			subtreeChmax(k, x);
		}
	}
	private final void innerApply(final int cmd, int l, int r, final long x) {
		if(l == r) {
			return;
		}
		l += n;
		r += n;
		for(int i = log; i >= 1; i--) {
			if(((l >> i) << i) != l) {
				push(l >> i);
			}
			if(((r >> i) << i) != r) {
				push((r - 1) >> i);
			}
		}
		{
			int l2 = l, r2 = r;
			while(l < r) {
				if(l % 2 == 1) {
					applyBeta(cmd, l++, x);
				}
				if(r % 2 == 1) {
					applyBeta(cmd, --r, x);
				}
				l >>= 1;
				r >>= 1;
			}
			l = l2;
			r = r2;
		}
		for(int i = 1; i <= log; ++i) {
			if(((l >> i) << i) != l) {
				update(l >> i);
			}
			if(((r >> i) << i) != r) {
				update((r - 1) >> i);
			}
		}
	}
	private final long op(final int cmd, final long a, final Node b){ return cmd == 1 ? Math.min(a, b.l1) : cmd == 2 ? Math.max(a, b.g1) : a + b.sum; }
	private final long e(final int cmd){ return cmd == 1 ? INF : cmd == 2 ? -INF : 0; }
	private final long innerFold(final int cmd, int l, int r) {
		if(l == r) {
			return e(cmd);
		}
		l += n;
		r += n;
		for(int i = log; i >= 1; i--) {
			if(((l >> i) << i) != l) {
				push(l >> i);
			}
			if(((r >> i) << i) != r) {
				push((r - 1) >> i);
			}
		}
		long lx = e(cmd), rx = e(cmd);
		while(l < r) {
			if(l % 2 == 1) {
				lx = op(cmd, lx, a[l++]);
			}
			if(r % 2 == 1) {
				rx = op(cmd, rx, a[--r]);
			}
			l >>= 1;
			r >>= 1;
		}
		if(cmd == 1) {
			lx = Math.min(lx, rx);
		}
		if(cmd == 2) {
			lx = Math.max(lx, rx);
		}
		if(cmd == 3) {
			lx += rx;
		}
		return lx;
	}
}