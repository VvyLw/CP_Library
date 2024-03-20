package library.math.prefixsum;

import java.util.Arrays;

import library.core.Utility;
import library.other.InclusiveScan;

/**
 * 累積和クラス
 * C++のstd::partial_sumのような側面とimos法による累積和の両方が可能
 * @see InclusiveScan
 */
public final class PrefixSum extends InclusiveScan {
	private long[] imos;
	private boolean built;
	/**
	 * コンストラクタ
	 * imos法を使った累積和はこっち
	 * @param n
	 */
	public PrefixSum(final int n) {
		super(n);
		imos = new long[n + 1];
		built = false;
	}
	/**
	 * コンストラクタ
	 * @param a
	 */
	public PrefixSum(final int[] a) {
		super(a, Long::sum);
		s = Utility.rotate(Arrays.copyOf(s, n + 1), -1);
	}
	/**
	 * コンストラクタ
	 * @param a
	 */
	public PrefixSum(final long[] a) {
		super(a, Long::sum);
		s = Utility.rotate(Arrays.copyOf(s, n + 1), -1);
	}
	/**
	 * @param l
	 * @param r
	 * @return 閉区間[l, r]の和
	 */
	public final long sum(final int l, final int r){ return s[r] - s[l]; }
	/**
	 * 半開区間[l, r)にxを加算する
	 * @param l
	 * @param r
	 * @param x
	 */
	public final void add(final int l, final int r, final long x) {
		if(built) {
			throw new UnsupportedOperationException("Prefix Sum has been built.");
		}
		imos[l] += x;
		imos[r] -= x;
	}
	/**
	 * 半開区間[l, r)に1を加算する
	 * @param l
	 * @param r
	 */
	public final void add(final int l, final int r){ add(l, r, 1); }
	/**
	 * 構築
	 * @return 累積和
	 */
	public final long[] build() {
		assert !built;
		Arrays.parallelPrefix(imos, Long::sum);
		built = true;
		return Arrays.copyOf(imos, n);
	}
}