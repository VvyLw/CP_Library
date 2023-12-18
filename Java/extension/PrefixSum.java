package extension;

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
final class PrefixSum extends InclusiveScan {
	PrefixSum(final int[] a) {
		super(a, (x, y) -> x + y);
		s = Utility.rotate(Arrays.copyOf(s, n + 1), 1);
	}
	PrefixSum(final long[] a) {
		super(a, (x, y) -> x + y);
		s = Utility.rotate(Arrays.copyOf(s, n + 1), 1);
	}
}