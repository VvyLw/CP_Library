package library.structure;

import java.util.Arrays;
import java.util.function.BinaryOperator;

/**
 * 双対セグ木
 * @param <T>
 * @see <a href="https://ei1333.github.io/library/structure/segment-tree/dual-segment-tree.hpp">参考元</a>
 */
public final class DualSegmentTree<T> {
	private int sz, h;
	private final Object[] lazy;
	private final T id;
	private final BinaryOperator<T> ap;
	@SuppressWarnings("unchecked")
	private final void propagate(final int k) {
		if(lazy[k] != id) {
			lazy[2 * k] = ap.apply((T) lazy[2 * k], (T) lazy[k]);
			lazy[2 * k + 1] = ap.apply((T) lazy[2 * k + 1], (T) lazy[k]);
			lazy[k] = id;
		}
	}
	private final void thrust(final int k) {
		for(int i = h; i > 0; i--) {
			propagate(k >> i);
		}
	}
	/**
	 * コンストラクタ
	 * @param n サイズ
	 * @param ap
	 * @param id
	 */
	public DualSegmentTree(final int n, final BinaryOperator<T> ap, final T id) {
		this.ap = ap;
		this.id = id;
		sz = 1;
		h = 0;
		while(sz < n) {
			sz <<= 1;
			h++;
		}
		lazy = new Object[2 * sz];
		Arrays.fill(lazy, id);
	}
	/**
	 * 半開区間[l, r)に作用素xを適用
	 * @param a
	 * @param b
	 * @param x
	 */
	@SuppressWarnings("unchecked")
	final void apply(int a, int b, final T x) {
		thrust(a += sz);
		thrust(b += sz - 1);
		for(int l = a, r = b + 1; l < r; l >>= 1, r >>= 1) {
			if(l % 2 == 1) {
				lazy[l] = ap.apply((T) lazy[l], x);
				l++;
			}
			if(r % 2 == 1) {
				r--;
				lazy[r] = ap.apply((T) lazy[r], x);
			}
		}
	}
	/**
	 * @param k
	 * @return k番目の要素
	 */
	@SuppressWarnings("unchecked")
	final T get(int k) {
		thrust(k += sz);
		return (T) lazy[k];
	}
}