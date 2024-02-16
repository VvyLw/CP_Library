package library.structure.lazysegmenttree;

import library.structure.pair.IntPair;

/**
 * Range Update Range Sum
 * 区間更新, 区間和
 */
public final class RUSM extends LazySegmentTreePair {
	private final int n;
	private final IntPair[] b;
	public RUSM(final int[] a) {
		super(a.length, (x, y) -> x.add(y), (x, y) -> IntPair.of(x.second.longValue() * y, x.second.longValue()), (x, y) -> y, IntPair.of(0, 0), Integer.MIN_VALUE);
		n = a.length;
		b = new IntPair[n];
		for(int i = 0; i < n; ++i) {
			b[i] = IntPair.of(a[i], 1);
		}
		build(b);
	}
	public RUSM(final long[] a) {
		super(a.length, (x, y) -> x.add(y), (x, y) -> IntPair.of(x.second.longValue() * y, x.second.longValue()), (x, y) -> y, IntPair.of(0, 0), Long.MIN_VALUE);
		n = a.length;
		b = new IntPair[n];
		for(int i = 0; i < n; ++i) {
			b[i] = IntPair.of(a[i], 1);
		}
		build(b);
	}
}