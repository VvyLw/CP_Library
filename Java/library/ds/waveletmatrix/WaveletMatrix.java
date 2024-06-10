package library.ds.waveletmatrix;

import java.util.Arrays;

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
	 * @param arr
	 */
	public WaveletMatrix(final int[] arr){ this(arr, 20); }
	/**
	 * コンストラクタ
	 * @param arr
	 */
	public WaveletMatrix(final long[] arr){ this(arr, 20); }
	/**
	 * コンストラクタ
	 * @param arr
	 * @param log
	 */
	public WaveletMatrix(final int[] arr, final int log) {
		ys = Arrays.stream(arr).asLongStream().sorted().distinct().toArray();
		final long[] t = new long[arr.length];
		Arrays.setAll(t, i -> index(arr[i]));
		mat = new WaveletMatrixBeta(t, log);
	}
	/**
	 * コンストラクタ
	 * @param arr 配列
	 * @param log 基本20で良い
	 */
	public WaveletMatrix(final long[] arr, final int log) {
		ys = Arrays.stream(arr).sorted().distinct().toArray();
		final long[] t = new long[arr.length];
		Arrays.setAll(t, i -> index(arr[i]));
		mat = new WaveletMatrixBeta(t, log);
	}
	private final int index(final long x){ return Utility.lowerBound(ys, x); }
	/**
	 * WaveletMatrix[k]を返す
	 * @param k
	 * @return k番目の要素
	 */
	public final long get(final int k){ return ys[(int) mat.access(k)]; }
	/**
	 * 半開区間[0, r)に含まれるxの個数を返す
	 * @param r
	 * @param x
	 * @return 半開区間[0, r)に含まれるxの個数
	 */
	public final int rank(final int r, final long x) {
		final int pos = index(x);
		if(pos == ys.length || ys[pos] != x) {
			return 0;
		}
		return mat.rank(pos, r);
	}
	/**
	 * 半開区間[l, r)に含まれるxの個数を返す
	 * @param l
	 * @param r
	 * @param x
	 * @return 半開区間[l, r)に含まれるxの個数
	 */
	public final int rank(final int l, final int r, final long x){ return rank(r, x) - rank(l, x); }
	/**
	 * @param l
	 * @param r
	 * @param k
	 * @return 半開区間[l, r)に含まれる要素のうちk番目に小さい要素
	 */
	public final long kthMin(final int l, final int r, final int k){ return ys[(int) mat.kthMin(l, r, k)]; }
	/**
	 * 半開区間[l, r)に含まれる要素のうちk番目に大きい要素を返す
	 * @param l
	 * @param r
	 * @param k
	 * @return 半開区間[l, r)に含まれる要素のうちk番目に大きい要素
	 */
	public final long kthMax(final int l, final int r, final int k){ return ys[(int) mat.kthMax(l, r, k)]; }
	/**
	 * 半開区間[l, r)に含まれる要素のうち[0, upper)である要素数を返す
	 * @param l
	 * @param r
	 * @param upper
	 * @return 半開区間[l, r)に含まれる要素のうち[0, upper)である要素数
	 */
	public final int rangeFreq(final int l, final int r, final long upper){ return mat.rangeFreq(l, r, index(upper)); }
	/**
	 * 半開区間[l, r)に含まれる要素のうち[lower, upper)である要素数を返す
	 * @param l
	 * @param r
	 * @param lower
	 * @param upper
	 * @return 半開区間[l, r)に含まれる要素のうち[lower, upper)である要素数
	 */
	public final int rangeFreq(final int l, final int r, final long lower, final long upper){ return mat.rangeFreq(l, r, index(lower), index(upper)); }
	/**
	 * 半開区間[l, r)に含まれる要素のうちupperの次に小さい要素を返す
	 * @param l
	 * @param r
	 * @param upper
	 * @return 半開区間[l, r)に含まれる要素のうちupperの次に小さい要素
	 */
	public final long prev(final int l, final int r, final long upper) {
		final long ret = mat.prev(l, r, index(upper));
		return ret == -1 ? -1 : ys[(int) ret];
	}
	/**
	 * 半開区間[l, r)に含まれる要素のうちlowerの次に大きい要素を返す
	 * @param l
	 * @param r
	 * @param lower
	 * @return 半開区間[l, r)に含まれる要素のうちlowerの次に大きい要素
	 */
	public final long next(final int l, final int r, final long lower) {
		final long ret = mat.next(l, r, index(lower));
		return ret == -1 ? -1 : ys[(int) ret];
	}
}