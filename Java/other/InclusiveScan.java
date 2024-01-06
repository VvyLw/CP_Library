package library.other;

import java.util.Arrays;
import java.util.function.LongBinaryOperator;

class InclusiveScan {
	protected final int n;
	protected long[] s;
	InclusiveScan(final int[] a, final LongBinaryOperator op) {
		n = a.length;
		s = Arrays.stream(a).mapToLong(i -> i).toArray();
		Arrays.parallelPrefix(s, op);
	}
	InclusiveScan(final long[] a, final LongBinaryOperator op) {
		n = a.length;
		s = a.clone();
		Arrays.parallelPrefix(s, op);
	}
	protected long[] get(){ return s; }
	protected long query(final int l, final int r){ return s[r] - s[l]; }
}