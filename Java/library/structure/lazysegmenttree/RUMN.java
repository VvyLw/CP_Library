package library.structure.lazysegmenttree;

import static java.lang.Math.*;

/**
 * Range Update Range Min
 * 区間更新, 区間最小値
 */
public final class RUMN extends LazySegmentTree {
	RUMN(final int[] a, final long eid){ super(a, (x, y) -> min(x, y), (x, y) -> y, (x, y) -> y, eid, eid); }
	RUMN(final long[] a, final long eid){ super(a, (x, y) -> min(x, y), (x, y) -> y, (x, y) -> y, eid, eid); }
}