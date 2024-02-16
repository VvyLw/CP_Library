package library.structure;

import java.util.Arrays;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

/**
 * セグメント木
 * @param <T>
 * @see <a href="https://github.com/tatyam-prime/kyopro_library/blob/master/SegmentTree.cpp">参考元</a>
 */
public final class SegmentTree<T> {
	private int n = 1, rank = 0, fini;
	private final BinaryOperator<T> op;
	private final T e;
	private final Object[] dat;
	/**
	 * コンストラクタ
	 * @param fini サイズ
	 * @param op 二項演算
	 * @param e 単位元
	 */
	public SegmentTree(final int fini, final BinaryOperator<T> op, final T e) {
		this.fini = fini;
		this.op = op;
		this.e = e;
		while(this.fini > n) {
			n <<= 1;
			rank++;
		}
		dat = new Object[2 * n];
		Arrays.fill(dat, e);
	}
	/**
	 * i番目の要素をxにする
	 * @param i
	 * @param x
	 */
	@SuppressWarnings("unchecked")
	public final void update(int i, final T x) {
		i += n;
		dat[i] = x;
		do {
			i >>= 1;
			dat[i] = op.apply((T) dat[2 * i], (T) dat[2 * i + 1]);
		} while(i > 0);
	}
	/**
	 * @param i
	 * @return i番目の要素
	 */
	public final T get(final int i){ return query(i, i + 1); }
	/**
	 * @param a
	 * @param b
	 * @return 半開区間[l, r)に対して二項演算した結果
	 */
	@SuppressWarnings("unchecked")
	public final T query(int a, int b) {
		T l = e, r = e;
		for(a += n, b += n; a < b; a >>= 1, b >>= 1) {
			if(a % 2 == 1) {
				l = op.apply(l, (T) dat[a++]);
			}
			if(b % 2 == 1) {
				r = op.apply((T) dat[--b], r);
			}
		}
		return op.apply(l, r);
	}
	/**
	 * 特定の条件を満たす最も左の位置を探す
	 * @param r
	 * @param fn
	 */
	@SuppressWarnings("unchecked")
	public final int findLeft(final int r, final Predicate<T> fn) {
		if(r == 0) {
			return 0;
		}
		int h = 0, i = r + n;
		T val = e;
		for(; h <= rank; h++) {
			if(i >> (h & 1) > 0) {
				final T val2 = op.apply(val, (T) dat[i >> (h ^ 1)]);
				if(fn.test(val2)){
					i -= 1 << h;
					if(i == n) {
						return 0;
					}
					val = val2;
				}
				else {
					break;
				}
			}
		}
		for(; h-- > 0;) {
			final T val2 = op.apply(val, (T) dat[(i >> h) - 1]);
			if(fn.test(val2)){
				i -= 1 << h;
				if(i == n) {
					return 0;
				}
				val = val2;
			}
		}
		return i - n;
	}
	/**
	 * 特定の条件を満たす最も右の位置を探す
	 * @param l
	 * @param fn
	 */
	@SuppressWarnings("unchecked")
	public final int findRight(final int l, final Predicate<T> fn) {
		if(l == fini) {
			return fini;
		}
		int h = 0, i = l + n;
		T val = e;
		for(; h <= rank; h++) {
			if(i >> (h & 1) > 0){
				final T val2 = op.apply(val, (T) dat[i >> h]);
				if(fn.test(val2)){
					i += 1 << h;
					if(i == n * 2) {
						return fini;
					}
					val = val2;
				}
				else {
					break;
				}
			}
		}
		for(; h-- > 0;) {
			final T val2 = op.apply(val, (T) dat[i>>h]);
			if(fn.test(val2)) {
				i += 1 << h;
				if(i == n * 2) {
					return fini;
				}
				val = val2;
			}
		}
		return Math.min(i - n, fini);
	}
	@Override
	public final String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append(get(0));
		for(int i = 0; ++i < fini;) {
			sb.append(" " + get(i));
		}
		return sb.toString();
	}
}