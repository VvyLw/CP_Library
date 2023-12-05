package extension;

import java.util.Arrays;
import java.util.stream.IntStream;

final class SuccinctIndexableDictionary {
	private final int blk;
	private final int[] bit, sum;
	SuccinctIndexableDictionary(final int len) {
		blk = (len + 31) >> 5;
		bit = new int[blk];
		sum = new int[blk];
	}
	final void set(final int k){ bit[k >> 5] |= 1 << (k & 31); }
	final void build() {
		sum[0] = 0;
		for(int i = 0; ++i < blk;) {
			sum[i] = sum[i - 1] + Integer.bitCount(bit[i - 1]);
		}
	}
	final boolean get(final int k){ return ((bit[k >> 5] >> (k & 31)) & 1) == 1; }
	final int rank(final int k){ return (sum[k >> 5] + Integer.bitCount(bit[k >> 5] & ((1 << (k & 31)) - 1))); }
	final int rank(final boolean val, final int k){ return val ? rank(k) : k - rank(k); }
}
final class WaveletMatrixBeta {
	private final int log;
	private final SuccinctIndexableDictionary[] matrix;
	private final int[] mid;
	WaveletMatrixBeta(long[] arr, final int log) {
		final int len = arr.length;
		this.log = log;
		matrix = new SuccinctIndexableDictionary[log];
		mid = new int[log];
		final long[] l = new long[len], r = new long[len];
		for(int level = log; --level >= 0;) {
			matrix[level] = new SuccinctIndexableDictionary(len + 1);
			int left = 0, right = 0;
			for(int i = 0; i < len; ++i) {
				if(((arr[i] >> level) & 1) == 1) {
					matrix[level].set(i);
					r[right++] = arr[i];
				} else {
					l[left++] = arr[i];
				}
			}
			mid[level] = left;
			matrix[level].build();
			final long[] tmp = new long[len];
			System.arraycopy(arr, 0, tmp, 0, len);
			System.arraycopy(l, 0, arr, 0, len);
			System.arraycopy(tmp, 0, l, 0, len);
			for(int i = 0; i < right; ++i) {
				arr[left + i] = r[i];
			}
		}
	}
	final NumPair succ(final boolean f, final int l, final int r, final int level){ return new NumPair(matrix[level].rank(f, l) + mid[level] * (f ? 1 : 0), matrix[level].rank(f, r) + mid[level] * (f ? 1 : 0)); }
	final long access(int k) {
		long ret = 0;
		for(int level = log; --level >= 0;) {
			final boolean f = matrix[level].get(k);
			if(f) {
				ret |= 1L << level;
			}
			k = matrix[level].rank(f, k) + mid[level] * (f ? 1 : 0);
		}	
		return ret;
	}
	final int rank(final long x, int r) {
		int l = 0;
		for(int level = log; --level >= 0;) {
			final var p = succ(((x >> level) & 1) == 1, l, r, level);
			l = p.first.intValue();
			r = p.second.intValue();
		}
		return r - l;
	}
	final long kthMin(int l, int r, int k) {
		if(Utility.scope(0, k, r - l - 1)) {
			throw new IndexOutOfBoundsException();
		}
		long ret = 0;
		for(int level = log; --level >= 0;) {
			final int cnt = matrix[level].rank(false, r) - matrix[level].rank(false, l);
			final boolean f = cnt <= k;
			if(f) {
				ret |= 1 << level;
				k -= cnt;
			}
			final var p = succ(f, l, r, level);
			l = p.first.intValue();
			r = p.second.intValue();
		}
		return ret;
	}
	final long kthMax(final int l, final int r, final int k){ return kthMin(l, r, r - l - k - 1); }
	final int rangeFreq(int l, int r, final long upper) {
		int ret = 0;
		for(int level = log; --level >= 0;) {
			final boolean f = ((upper >> level) & 1) == 1;
			if(f) {
				ret += matrix[level].rank(false, r) - matrix[level].rank(false, l);
			}
			final var p = succ(f, l, r, level); 
			l = p.first.intValue();
			r = p.second.intValue();
		}
		return ret;
	}
	final int rangeFreq(final int l, final int r, final long lower, final long upper){ return rangeFreq(l, r, upper) - rangeFreq(l, r, lower); }
	final long prevValue(final int l, final int r, final long upper) {
		final int cnt = rangeFreq(l, r, upper);
		return cnt == 0 ? -1 : kthMin(l, r, cnt - 1);
	}
	final long nextValue(final int l, final int r, final long lower) {
		final int cnt = rangeFreq(l, r, lower);
		return cnt == r - l ? -1 : kthMin(l, r, cnt);
	}
}
final class WaveletMatrix {
	private final WaveletMatrixBeta mat;
	private final long[] ys;
	WaveletMatrix(final long[] arr, final int log) {
		ys = Arrays.stream(arr).sorted().distinct().toArray();
		final long[] t = new long[arr.length];
		IntStream.range(0, arr.length).forEach(i -> t[i] = get(arr[i]));
		mat = new WaveletMatrixBeta(t, log);
	}
	private int lowerBound(final long[] arr, final long x) {
		final int id = Arrays.binarySearch(arr, x);
		return id < 0 ? -(id - 1) : id;
	}
	private final int get(final long x){ return lowerBound(ys, x); }
	final long access(final int k){ return ys[(int) mat.access(k)]; }
	final int rank(final long x, final int r) {
		final var pos = get(x);
		if(pos == ys.length || ys[pos] != x) {
			return 0;
		}
		return mat.rank(pos, r);
	}
	final long kthMin(final int l, final int r, final int k){ return ys[(int) mat.kthMin(l, r, k)]; }
	final long kthMax(final int l, final int r, final int k){ return ys[(int) mat.kthMax(l, r, k)]; }
	final int rangeFreq(final int l, final int r, final long upper){ return mat.rangeFreq(l, r, get(upper)); }
	final int rangeFreq(final int l, final int r, final long lower, final long upper){ return mat.rangeFreq(l, r, get(lower), get(upper)); }
	final long prevValue(final int l, final int r, final long upper) {
		final var ret = mat.prevValue(l, r, get(upper));
		return ret == -1 ? -1 : ys[(int) ret];
	}
	final long nextValue(final int l, final int r, final long lower) {
		final var ret = mat.nextValue(l, r, get(lower));
		return ret == -1 ? -1 : ys[(int) ret];
	}
}