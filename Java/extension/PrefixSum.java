package extension;

import java.util.Arrays;
import java.util.function.LongBinaryOperator;
import java.util.stream.IntStream;

class InclusiveScan {
	protected final int n;
	protected final long[] s;
	InclusiveScan(final int[] a, final LongBinaryOperator op) {
		n = a.length;
		s = new long[n + 1];
		IntStream.rangeClosed(1, n).forEach(i -> s[i] = a[i - 1]);
		Arrays.parallelPrefix(s, op);
	}
	InclusiveScan(final long[] a, final LongBinaryOperator op) {
		n = a.length;
		s = new long[n + 1];
		IntStream.rangeClosed(1, n).forEach(i -> s[i] = a[i - 1]);
		Arrays.parallelPrefix(s, op);
	}
	protected long[] get(){ return s; }
	protected long query(final int l, final int r){ return s[r] - s[l]; }
}

final class PrefixSum extends InclusiveScan {
	PrefixSum(final int[] a){ super(a, (x, y) -> x + y); }
	PrefixSum(final long[] a){ super(a, (x, y) -> x + y); }
}