package library.other;

import java.util.Arrays;
import java.util.function.LongBinaryOperator;

/**
 * C++のstd::inclusive_scanに相当するクラス
 */
public class InclusiveScan {
	protected final int n;
	protected long[] s;
	/**
	 * コンストラクタ
	 * @param a
	 * @param op 二項演算
	 */
	public InclusiveScan(final int[] a, final LongBinaryOperator op) {
		n = a.length;
		s = Arrays.stream(a).asLongStream().toArray();
		Arrays.parallelPrefix(s, op);
	}
	/**
	 * コンストラクタ
	 * @param a
	 * @param op 二項演算
	 */
	public InclusiveScan(final long[] a, final LongBinaryOperator op) {
		n = a.length;
		s = a.clone();
		Arrays.parallelPrefix(s, op);
	}
	/**
	 * @see <a href="https://cpprefjp.github.io/reference/numeric/inclusive_scan.html">std::inclusive_scan</a> 
	 */
	public long[] get(){ return s; }
	/**
	 * 主に累積和の差を求めるのに使う
	 * @param l
	 * @param r
	 * @return 半開区間[l, r)におけるs[l]とs[r]との差
	 * @see PrefixSum
	 */
	public long query(final int l, final int r){ return s[r] - s[l]; }
}