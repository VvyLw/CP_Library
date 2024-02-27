package library.ds.lazysegmenttree;

import java.util.Arrays;

/**
 * Range Add Range Min
 * 区間加算, 区間最小値
 */
public final class RAMN extends LazySegmentTree<Long, Long> {
	public RAMN(final int[] a){ super(Arrays.stream(a).asLongStream().boxed().toArray(Long[]::new), Long::min, Long::sum, Long::sum, Long.valueOf(Long.MAX_VALUE), Long.valueOf(0)); }
	public RAMN(final long[] a){ super(Arrays.stream(a).boxed().toArray(Long[]::new), Long::min, Long::sum, Long::sum, Long.valueOf(Long.MAX_VALUE), Long.valueOf(0)); }
}