package library.math.prefixsum;

import java.util.Arrays;

import library.core.Utility;
import library.other.InclusiveScan;

/**
 * 累積和クラス
 * @see InclusiveScan
 */
public final class PrefixSum extends InclusiveScan {
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
	 * 主に累積和の差を求めるのに使う
	 * @param l
	 * @param r
	 * @return 半開区間[l, r)におけるs[l]とs[r]との差
	 */
	public final long query(final int l, final int r){ return s[r] - s[l]; }
}