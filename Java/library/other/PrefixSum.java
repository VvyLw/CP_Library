package library.other;

import java.util.Arrays;

import library.core.Utility;

/**
 * 累積和クラス
 */
public final class PrefixSum extends InclusiveScan {
	/**
	 * コンストラクタ
	 * @param a
	 */
	public PrefixSum(final int[] a) {
		super(a, (x, y) -> x + y);
		s = Utility.rotate(Arrays.copyOf(s, n + 1), 1);
	}
	/**
	 * コンストラクタ
	 * @param a
	 */
	public PrefixSum(final long[] a) {
		super(a, (x, y) -> x + y);
		s = Utility.rotate(Arrays.copyOf(s, n + 1), 1);
	}
}