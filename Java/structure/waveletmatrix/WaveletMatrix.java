package library.structure.waveletmatrix;

import java.util.Arrays;
import java.util.stream.IntStream;

import library.core.Utility;

/**
 * WaveletMatrix
 * @see <a href="https://ei1333.github.io/library/structure/wavelet/wavelet-matrix.hpp">参考元</a>
 */
public final class WaveletMatrix {
	private final WaveletMatrixBeta mat;
	private final long[] ys;
	/**
	 * コンストラクタ
	 * @param arr 配列
	 * @param log 基本16で良い
	 */
	public WaveletMatrix(final long[] arr, final int log) {
		ys = Arrays.stream(arr).sorted().distinct().toArray();
		final long[] t = new long[arr.length];
		IntStream.range(0, arr.length).forEach(i -> t[i] = get(arr[i]));
		mat = new WaveletMatrixBeta(t, log);
	}
	private final int get(final long x){ return Utility.lowerBound(ys, x); }
	/**
	 * @param k
	 * @return k番目の要素
	 */
	public final long access(final int k){ return ys[(int) mat.access(k)]; }
	/**
	 * @param x
	 * @param r
	 * @return 半開区間[0, r)に含まれるxの個数
	 */
	public final int rank(final long x, final int r) {
		final int pos = get(x);
		if(pos == ys.length || ys[pos] != x) {
			return 0;
		}
		return mat.rank(pos, r);
	}
	/**
	 * @param l
	 * @param r
	 * @param k
	 * @return 半開区間[l, r)に含まれる要素のうちk番目に小さい要素
	 */
	public final long kthMin(final int l, final int r, final int k){ return ys[(int) mat.kthMin(l, r, k)]; }
	/**
	 * @param l
	 * @param r
	 * @param k
	 * @return 半開区間[l, r)に含まれる要素のうちk番目に大きい要素
	 */
	public final long kthMax(final int l, final int r, final int k){ return ys[(int) mat.kthMax(l, r, k)]; }
	/**
	 * @param l
	 * @param r
	 * @param upper
	 * @return 半開区間[l, r)に含まれる要素のうち[0, upper)である要素数
	 */
	public final int rangeFreq(final int l, final int r, final long upper){ return mat.rangeFreq(l, r, get(upper)); }
	/**
	 * @param l
	 * @param r
	 * @param lower
	 * @param upper
	 * @return 半開区間[l, r)に含まれる要素のうち[lower, upper)である要素数
	 */
	public final int rangeFreq(final int l, final int r, final long lower, final long upper){ return mat.rangeFreq(l, r, get(lower), get(upper)); }
	/**
	 * @param l
	 * @param r
	 * @param upper
	 * @return 半開区間[l, r)に含まれる要素のうちupperの次に小さい要素
	 */
	public final long prev(final int l, final int r, final long upper) {
		final long ret = mat.prev(l, r, get(upper));
		return ret == -1 ? -1 : ys[(int) ret];
	}
	/**
	 * @param l
	 * @param r
	 * @param lower
	 * @return 半開区間[l, r)に含まれる要素のうちlowerの次に大きい要素
	 */
	public final long next(final int l, final int r, final long lower) {
		final long ret = mat.next(l, r, get(lower));
		return ret == -1 ? -1 : ys[(int) ret];
	}
}