package library.structure.lazysegmenttree;

import static java.lang.Math.*;

/**
 * Range Add Range Max
 * 区間加算, 区間最大値
 */
public final class RAMX extends LazySegmentTree {
	public RAMX(final int[] a){ super(a, (x, y) -> max(x, y), (x, y) -> x + y, (x, y) -> x + y, Integer.MIN_VALUE, 0); }
	public RAMX(final long[] a){ super(a, (x, y) -> max(x, y), (x, y) -> x + y, (x, y) -> x + y, Long.MIN_VALUE, 0); }
}