package extension;

import java.util.stream.IntStream;

final class PrefixSum {
	private final int n;
	private final long[] s;
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
	final long[] get(){ return s; }
	final long query(final int l, final int r){ return s[r] - s[l]; }
}