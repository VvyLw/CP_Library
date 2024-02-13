package library.structure.lazysegmenttree;

import static java.lang.Math.*;

/**
 * Range Update Range Max
 * 区間更新, 区間最大値
 */
public final class RUMX extends LazySegmentTree {
	public RUMX(final int[] a, final long eid){ super(a, (x, y) -> max(x, y), (x, y) -> y, (x, y) -> y, eid, eid); }
	public RUMX(final long[] a, final long eid){ super(a, (x, y) -> max(x, y), (x, y) -> y, (x, y) -> y, eid, eid); }
}