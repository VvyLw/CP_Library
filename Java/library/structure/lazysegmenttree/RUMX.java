package library.structure.lazysegmenttree;

import static java.lang.Math.*;

/**
 * Range Update Range Max
 * 区間更新, 区間最大値
 */
public final class RUMX extends LazySegmentTree {
	public RUMX(final int[] a){ super(a, (x, y) -> max(x, y), (x, y) -> y, (x, y) -> y, Integer.MIN_VALUE, Integer.MIN_VALUE); }
	public RUMX(final long[] a){ super(a, (x, y) -> max(x, y), (x, y) -> y, (x, y) -> y, Long.MIN_VALUE, Long.MIN_VALUE); }
}