package library.structure.waveletmatrix;

import java.util.Arrays;
import java.util.stream.IntStream;

import library.core.Utility;

public final class WaveletMatrix {
	private final WaveletMatrixBeta mat;
	private final long[] ys;
	public WaveletMatrix(final long[] arr, final int log) {
		ys = Arrays.stream(arr).sorted().distinct().toArray();
		final long[] t = new long[arr.length];
		IntStream.range(0, arr.length).forEach(i -> t[i] = get(arr[i]));
		mat = new WaveletMatrixBeta(t, log);
	}
	private final int get(final long x){ return Utility.lowerBound(ys, x); }
	public final long access(final int k){ return ys[(int) mat.access(k)]; }
	public final int rank(final long x, final int r) {
		final int pos = get(x);
		if(pos == ys.length || ys[pos] != x) {
			return 0;
		}
		return mat.rank(pos, r);
	}
	public final long kthMin(final int l, final int r, final int k){ return ys[(int) mat.kthMin(l, r, k)]; }
	public final long kthMax(final int l, final int r, final int k){ return ys[(int) mat.kthMax(l, r, k)]; }
	public final int rangeFreq(final int l, final int r, final long upper){ return mat.rangeFreq(l, r, get(upper)); }
	public final int rangeFreq(final int l, final int r, final long lower, final long upper){ return mat.rangeFreq(l, r, get(lower), get(upper)); }
	public final long prev(final int l, final int r, final long upper) {
		final long ret = mat.prev(l, r, get(upper));
		return ret == -1 ? -1 : ys[(int) ret];
	}
	public final long next(final int l, final int r, final long lower) {
		final long ret = mat.next(l, r, get(lower));
		return ret == -1 ? -1 : ys[(int) ret];
	}
}