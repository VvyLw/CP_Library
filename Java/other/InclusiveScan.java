package library.other;

import java.util.Arrays;
import java.util.function.LongBinaryOperator;

public class InclusiveScan {
	protected final int n;
	protected long[] s;
	public InclusiveScan(final int[] a, final LongBinaryOperator op) {
		n = a.length;
		s = Arrays.stream(a).mapToLong(i -> i).toArray();
		Arrays.parallelPrefix(s, op);
	}
	public InclusiveScan(final long[] a, final LongBinaryOperator op) {
		n = a.length;
		s = a.clone();
		Arrays.parallelPrefix(s, op);
	}
	public long[] get(){ return s; }
	public long query(final int l, final int r){ return s[r] - s[l]; }
}