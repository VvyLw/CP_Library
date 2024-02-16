package library.structure.lazysegmenttree;

import static java.lang.Math.*;

/**
 * Range Add Range Min
 * 区間加算, 区間最小値
 */
public final class RAMN extends LazySegmentTree {
	public RAMN(final int[] a){ super(a, (x, y) -> min(x, y), (x, y) -> x + y, (x, y) -> x + y, Integer.MAX_VALUE, 0); }
	public RAMN(final long[] a){ super(a, (x, y) -> min(x, y), (x, y) -> x + y, (x, y) -> x + y, Long.MAX_VALUE, 0); }
}