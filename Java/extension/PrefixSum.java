package extension;

import java.util.stream.IntStream;

class PrefixSum {
	private int n;
	private long[] s;
	PrefixSum(final int[] a) {
		n = a.length;
		s = new long[n + 1];
		IntStream.range(0, n).forEach(i -> s[i + 1] = s[i] + a[i]);
	}
	PrefixSum(final long[] a) {
		n = a.length;
		s = new long[n + 1];
		IntStream.range(0, n).forEach(i -> s[i + 1] = s[i] + a[i]);
	}
	long[] get(){ return s; }
	long query(final int l, final int r){ return s[r] - s[l]; }
}