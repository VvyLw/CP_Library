package library.structure.lazysegmenttree;

import library.structure.pair.IntPair;

/**
 * Range Update Range Sum
 * 区間更新, 区間和
 */
public final class RUSM extends LazySegmentTreePair {
	private final int n;
	private final IntPair[] b;
	RUSM(final int[] a, final int id) {
		super(a.length, (x, y) -> x.mul(y), (x, y) -> IntPair.of(x.first.longValue() + x.second.longValue() * y, x.second.longValue()), (x, y) -> x + y, IntPair.of(0, 0), id);
		n = a.length;
		b = new IntPair[n];
		for(int i = 0; i < n; ++i) {
			b[i] = IntPair.of(a[i], 1);
		}
		build(b);
	}
	RUSM(final long[] a, final long id) {
		super(a.length, (x, y) -> x.mul(y), (x, y) -> IntPair.of(x.second.longValue() * y, x.second.longValue()), (x, y) -> x + y, IntPair.of(0, 0), id);
		n = a.length;
		b = new IntPair[n];
		for(int i = 0; i < n; ++i) {
			b[i] = IntPair.of(a[i], 1);
		}
		build(b);
	}
}