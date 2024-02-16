package library.structure.lazysegmenttree;

import static java.lang.Math.*;

/**
 * Range Update Range Min
 * 区間更新, 区間最小値
 */
public final class RUMN extends LazySegmentTree {
	public RUMN(final int[] a){ super(a, (x, y) -> min(x, y), (x, y) -> y, (x, y) -> y, Integer.MAX_VALUE, Integer.MAX_VALUE); }
	public RUMN(final long[] a){ super(a, (x, y) -> min(x, y), (x, y) -> y, (x, y) -> y, Long.MAX_VALUE, Long.MAX_VALUE); }
}