package library.structure.lazysegmenttree;

import library.structure.fenwicktree.RangeBIT;
import library.structure.pair.IntPair;

/**
 * Range Add Range Sum
 * 区間加算, 区間和
 * RangeBITを使うような問題で二分探索を求められた場合はこちら
 * @see RangeBIT
 */
public final class RASM extends LazySegmentTreePair {
	private final int n;
	private final IntPair[] b;
	RASM(final int[] a) {
		super(a.length, (x, y) -> x.add(y), (x, y) -> IntPair.of(x.first.longValue() + x.second.longValue() * y, x.second.longValue()), (x, y) -> x + y, IntPair.of(0, 0), 0);
		n = a.length;
		b = new IntPair[n];
		for(int i = 0; i < n; ++i) {
			b[i] = IntPair.of(a[i], 1);
		}
		build(b);
	}
	RASM(final long[] a) {
		super(a.length, (x, y) -> x.add(y), (x, y) -> IntPair.of(x.first.longValue() + x.second.longValue() * y, x.second.longValue()), (x, y) -> x + y, IntPair.of(0, 0), 0);
		n = a.length;
		b = new IntPair[n];
		for(int i = 0; i < n; ++i) {
			b[i] = IntPair.of(a[i], 1);
		}
		build(b);
	}
}