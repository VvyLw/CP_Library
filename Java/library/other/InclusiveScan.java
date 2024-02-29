package library.other;

import java.util.Arrays;
import java.util.function.LongBinaryOperator;

/**
 * C++のstd::inclusive_scanに相当するクラス
 * @see <a href="https://cpprefjp.github.io/reference/numeric/inclusive_scan.html">std::inclusive_scan</a>
 */
public class InclusiveScan {
	protected final int n;
	protected long[] s;
	protected InclusiveScan(final int n){ this.n = n; }
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
	 * @return InclusiveScanした後の配列
	 */
	public final long[] get(){ return s; }
}