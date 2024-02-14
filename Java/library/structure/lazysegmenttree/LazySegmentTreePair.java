package library.structure.lazysegmenttree;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.LongBinaryOperator;
import java.util.function.LongPredicate;

import library.structure.pair.IntPair;

/**
 * 遅延セグ木
 * RUSMを使うのに必要
 * @see LazySegmentTree
 * @see RUSM
 */
public class LazySegmentTreePair {
	private int n, sz, h;
	private final IntPair[] data;
	private final long[] lazy;
	private final BinaryOperator<IntPair> f;
	private final BiFunction<IntPair, Long, IntPair> map;
	private final LongBinaryOperator comp;
	private final IntPair e;
	private final long id;
	private final void update(final int k){ data[k] = f.apply(data[2 * k], data[2 * k + 1]); }
	private final void allApply(final int k, final long x) {
		data[k] = map.apply(data[k], x);
		if(k < sz) {
			lazy[k] = comp.applyAsLong(lazy[k], x);
		}
	}
	private final void propagate(final int k) {
		if(lazy[k] != id) {
			allApply(2 * k, lazy[k]);
			allApply(2 * k + 1, lazy[k]);
			lazy[k] = id;
		}
	}
	/**
	 * コンストラクタ
	 * @param n
	 * @param f
	 * @param map
	 * @param comp
	 * @param e
	 * @param id
	 */
	public LazySegmentTreePair(final int n, final BinaryOperator<IntPair> f, final BiFunction<IntPair, Long, IntPair> map, final LongBinaryOperator comp, final IntPair e, final long id) {
		this.n = n;
		this.f = f;
		this.map = map;
		this.comp = comp;
		this.e = e;
		this.id = id;
		sz = 1;
		h = 0;
		while(sz < n) {
			sz <<= 1;
			h++;
		}
		data = new IntPair[2 * sz];
		Arrays.fill(data, e);
		lazy = new long[2 * sz];
		Arrays.fill(lazy, id);
	}
	/**
	 * コンストラクタ
	 * @param a
	 * @param f
	 * @param map
	 * @param comp
	 * @param e
	 * @param id
	 */
	public LazySegmentTreePair(final IntPair[] a, final BinaryOperator<IntPair> f, final BiFunction<IntPair, Long, IntPair> map, final LongBinaryOperator comp, final IntPair e, final long id) {
		this(a.length, f, map, comp, e, id);
		build(a);
	}
	/**
	 * 構築
	 * @param a
	 */
	public final void build(final IntPair[] a) {
		assert n == a.length;
		for(int k = 0; k < n; ++k) {
			data[k + sz] = a[k];
		}
		for(int k = sz; --k > 0;) {
			update(k);
		}
	}
	/**
	 * k番目の要素をxに更新する
	 * @param k
	 * @param x
	 */
	public final void set(int k, final IntPair x) {
		k += sz;
		for(int i = h; i > 0; i--) {
			propagate(k >> i);
		}
		data[k] = x;
		for(int i = 0; ++i <= h;) {
			update(k >> i);
		}
	}
	/**
	 * @param k
	 * @return k番目の要素
	 */
	public final long get(int k) {
		k += sz;
		for(int i = h; i > 0; i--) {
			propagate(k >> i);
		}
		return data[k].first.longValue();
	}
	/**
	 * @param l
	 * @param r
	 * @return 半開区間[l, r)について二項演算した結果
	 */
	public final long query(int l, int r) {
		if(l >= r) {
			return e.first.longValue();
		}
		l += sz;
		r += sz;
		for(int i = h; i > 0; i--) {
			if(((l >> i) << i) != l) {
				propagate(l >> i);
			}
			if(((r >> i) << i) != r) {
				propagate((r - 1) >> i);
			}
		}
		IntPair l2 = e, r2 = e;
		for(; l < r; l >>= 1, r >>= 1) {
			if(l % 2 == 1) {
				l2 = f.apply(l2, data[l++]);
			}
			if(r % 2 == 1) {
				r2 = f.apply(data[--r], r2);
			}
		}
		return f.apply(l2, r2).first.longValue();
	}
	/**
	 * @return 全体を二項演算した結果
	 */
	public final long all(){ return data[1].first.longValue(); }
	/**
	 * k番目の要素に作用素xを適用する
	 * @param k
	 * @param x
	 */
	public final void apply(int k, final long x) {
		k += sz;
		for(int i = h; i > 0; i--) {
			propagate(k >> i);
		}
		data[k] = map.apply(data[k], x);
		for(int i = 0; ++i <= h;) {
			update(k >> i);
		}
	}
	/**
	 * 半開区間[l, r)について作用素xを適用する
	 * @param l
	 * @param r
	 * @param x
	 */
	public final void apply(int l, int r, final long x) {
		if(l >= r) {
			return;
		}
		l += sz;
		r += sz;
		for(int i = h; i > 0; i--) {
			if(((l >> i) << i) != l) {
				propagate(l >> i);
			}
			if(((r >> i) << i) != r) {
				propagate((r - 1) >> i);
			}
		}
		int l2 = l, r2 = r;
		for(; l < r; l >>= 1, r >>= 1) {
			if(l % 2 == 1) {
				allApply(l++, x);
			}
			if(r % 2 == 1) {
				allApply(--r, x);
			}
		}
		l = l2;
		r = r2;
		for(int i = 0; ++i <= h;) {
			if(((l >> i) << i) != l) {
				update(l >> i);
			}
			if(((r >> i) << i) != r) {
				update((r - 1) >> i);
			}
		}
	}
	/**
	 * @param l
	 * @param fn
	 * @return 半開区間[l, x)がfnを満たす最初の要素位置x
	 * if non-existence: n
	 */
	public final int findFirst(int l, final LongPredicate fn) {
		if(l >= n) {
			return n;
		}
		l += sz;
		for(int i = h; i > 0; i--) {
			propagate(l >> i);
		}
		IntPair sum = e;
		do {
			while((l & 1) == 0) {
				l >>= 1;
			}
			if(fn.test(f.apply(sum, data[l]).first.longValue())) {
				while(l < sz) {
					propagate(l);
					l <<= 1;
					final IntPair nxt = f.apply(sum, data[l]);
					if(!fn.test(nxt.first.longValue())) {
						sum = nxt;
						l++;
					}
				}
				return l + 1 - sz;
			}
			sum = f.apply(sum, data[l++]);
		} while((l & -l) != l);
		return n;
	}
	/**
	 * @param r
	 * @param fn
	 * @return 半開区間[x, r)がfnを満たす最後の要素位置x
	 * if non-existence: −1
	 */
	public final int findLast(int r, final LongPredicate fn) {
		if(r <= 0) {
			return -1;
		}
		r += sz;
		for(int i = h; i > 0; i--) {
			propagate((r - 1) >> i);
		}
		IntPair sum = e;
		do {
			r--;
			while(r > 1 && r % 2 == 1) {
				r >>= 1;
			}
			if(fn.test(f.apply(data[r], sum).first.longValue())) {
				while(r < sz) {
					propagate(r);
					r = (r << 1) + 1;
					final IntPair nxt = f.apply(data[r], sum);
					if(!fn.test(nxt.first.longValue())) {
						sum = nxt;
						r--;
					}
				}
				return r - sz;
			}
			sum = f.apply(data[r], sum);
		} while((r & -r) != r);
		return -1;
	}
	/**
	 * 要素をリセットする
	 */
	public final void clear(){ Arrays.fill(data, e); }
	@Override
	public final String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append(get(0));
		for(int i = 0; ++i < n; ++i) {
			sb.append(' ');
			sb.append(get(i));
		}
		return sb.toString();
	}
}