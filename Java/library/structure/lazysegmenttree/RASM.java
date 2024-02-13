package library.structure.lazysegmenttree;

import library.structure.pair.IntPair;

/**
 * Range Add Range Sum
 * 区間加算, 区間和
 */
public final class RASM extends LazySegmentTreePair {
	private final int n;
	private final IntPair[] b;
	RASM(final int[] a) {
		super(a.length, (x, y) -> x.mul(y), (x, y) -> IntPair.of(x.first.longValue() + x.second.longValue() * y, x.second.longValue()), (x, y) -> x + y, IntPair.of(0, 0), 0);
		n = a.length;
		b = new IntPair[n];
		for(int i = 0; i < n; ++i) {
			b[i] = IntPair.of(a[i], 1);
		}
		build(b);
	}
	RASM(final long[] a) {
		super(a.length, (x, y) -> x.mul(y), (x, y) -> IntPair.of(x.first.longValue() + x.second.longValue() * y, x.second.longValue()), (x, y) -> x + y, IntPair.of(0, 0), 0);
		n = a.length;
		b = new IntPair[n];
		for(int i = 0; i < n; ++i) {
			b[i] = IntPair.of(a[i], 1);
		}
		build(b);
	}
}