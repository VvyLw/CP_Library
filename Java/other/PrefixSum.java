package library.other;

import java.util.Arrays;

import library.core.Utility;

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