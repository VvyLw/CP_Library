package library.structure.lazysegmenttree;

import static java.lang.Math.*;

/**
 * Range Add Range Max
 * 区間加算, 区間最大値
 */
public final class RAMX extends LazySegmentTree {
	public RAMX(final int[] a, final int e){ super(a, (x, y) -> max(x, y), (x, y) -> x + y, (x, y) -> x + y, e, 0); }
	public RAMX(final long[] a, final long e){ super(a, (x, y) -> max(x, y), (x, y) -> x + y, (x, y) -> x + y, e, 0); }
}