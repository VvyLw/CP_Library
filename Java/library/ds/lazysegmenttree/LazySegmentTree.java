package library.ds.lazysegmenttree;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

/**
 * 遅延セグ木
 * @see <a href="https://ei1333.github.io/library/structure/segment-tree/lazy-segment-tree.hpp">参考元</a>
 */
public class LazySegmentTree<T, U extends Comparable<? super U>> {
	private final int n;
	private int sz, h;
	private final Object[] data, lazy;
	private final BinaryOperator<T> f;
	private final BiFunction<T, U, T> map;
	private final BinaryOperator<U> comp;
	private final T e;
	private final U id;
	@SuppressWarnings("unchecked")
	private final void update(final int k){ data[k] = f.apply((T) data[2 * k], (T) data[2 * k + 1]); }
	@SuppressWarnings("unchecked")
	private final void allApply(final int k, final U x) {
		data[k] = map.apply((T) data[k], x);
		if(k < sz) {
			lazy[k] = comp.apply((U) lazy[k], x);
		}
	}
	@SuppressWarnings("unchecked")
	private final void propagate(final int k) {
		if(!lazy[k].equals(id)) {
			allApply(2 * k, (U) lazy[k]);
			allApply(2 * k + 1, (U) lazy[k]);
			lazy[k] = id;
		}
	}
	/**
	 * コンストラクタ
	 * @param n サイズ
	 * @param f 二項演算
	 * @param map mapping
	 * @param comp composition
	 * @param e 単位元
	 * @param id
	 */
	public LazySegmentTree(final int n, final BinaryOperator<T> f, final BiFunction<T, U, T> map, final BinaryOperator<U> comp, final T e, final U id) {
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
		data = new Object[2 * sz];
		Arrays.fill(data, e);
		lazy = new Object[2 * sz];
		Arrays.fill(lazy, id);
	}
	/**
	 * コンストラクタ
	 * @param a ボクシングさせた配列
	 * @param f
	 * @param map
	 * @param comp
	 * @param e
	 * @param id
	 */
	public LazySegmentTree(final T[] a, final BinaryOperator<T> f, final BiFunction<T, U, T> map, final BinaryOperator<U> comp, final T e, final U id) {
		this(a.length, f, map, comp, e, id);
		build(a);
	}
	/**
	 * 構築
	 * @param a
	 */
	public final void build(final T[] a) {
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
	public final void set(int k, final T x) {
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
	@SuppressWarnings("unchecked")
	public final T get(int k) {
		k += sz;
		for(int i = h; i > 0; i--) {
			propagate(k >> i);
		}
		return (T) data[k];
	}
	/**
	 * @param l
	 * @param r
	 * @return 半開区間[l, r)について二項演算した結果
	 */
	@SuppressWarnings("unchecked")
	public final T query(int l, int r) {
		if(l >= r) {
			return e;
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
		T l2 = e, r2 = e;
		for(; l < r; l >>= 1, r >>= 1) {
			if(l % 2 == 1) {
				l2 = f.apply(l2, (T) data[l++]);
			}
			if(r % 2 == 1) {
				r2 = f.apply((T) data[--r], r2);
			}
		}
		return f.apply(l2, r2);
	}
	/**
	 * @return 全体を二項演算した結果
	 */
	@SuppressWarnings("unchecked")
	public final T all(){ return (T) data[1]; }
	/**
	 * k番目の要素に作用素xを適用する
	 * @param k
	 * @param x
	 */
	@SuppressWarnings("unchecked")
	public final void apply(int k, final U x) {
		k += sz;
		for(int i = h; i > 0; i--) {
			propagate(k >> i);
		}
		data[k] = map.apply((T) data[k], x);
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
	public final void apply(int l, int r, final U x) {
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
	@SuppressWarnings("unchecked")
	public final int findFirst(int l, final Predicate<T> fn) {
		if(l >= n) {
			return n;
		}
		l += sz;
		for(int i = h; i > 0; i--) {
			propagate(l >> i);
		}
		T sum = e;
		do {
			while((l & 1) == 0) {
				l >>= 1;
			}
			if(fn.test(f.apply(sum, (T) data[l]))) {
				while(l < sz) {
					propagate(l);
					l <<= 1;
					final T nxt = f.apply(sum, (T) data[l]);
					if(!fn.test(nxt)) {
						sum = nxt;
						l++;
					}
				}
				return l + 1 - sz;
			}
			sum = f.apply(sum, (T) data[l++]);
		} while((l & -l) != l);
		return n;
	}
	/**
	 * @param r
	 * @param fn
	 * @return 半開区間[x, r)がfnを満たす最後の要素位置x
	 * if non-existence: −1
	 */
	@SuppressWarnings("unchecked")
	public final int findLast(int r, final Predicate<T> fn) {
		if(r <= 0) {
			return -1;
		}
		r += sz;
		for(int i = h; i > 0; i--) {
			propagate((r - 1) >> i);
		}
		T sum = e;
		do {
			r--;
			while(r > 1 && r % 2 == 1) {
				r >>= 1;
			}
			if(fn.test(f.apply((T) data[r], sum))) {
				while(r < sz) {
					propagate(r);
					r = (r << 1) + 1;
					final T nxt = f.apply((T) data[r], sum);
					if(!fn.test(nxt)) {
						sum = nxt;
						r--;
					}
				}
				return r - sz;
			}
			sum = f.apply((T) data[r], sum);
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
		for(int i = 0; ++i < n;) {
			sb.append(" " + get(i));
		}
		return sb.toString();
	}
}