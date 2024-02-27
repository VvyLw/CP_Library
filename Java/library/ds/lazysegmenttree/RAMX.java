package library.ds.lazysegmenttree;

import java.util.Arrays;

/**
 * Range Add Range Max
 * 区間加算, 区間最大値
 */
public final class RAMX extends LazySegmentTree<Long, Long> {
	public RAMX(final int[] a){ super(Arrays.stream(a).asLongStream().boxed().toArray(Long[]::new), Long::max, Long::sum, Long::sum, Long.valueOf(Long.MIN_VALUE), Long.valueOf(0)); }
	public RAMX(final long[] a){ super(Arrays.stream(a).boxed().toArray(Long[]::new), Long::max, Long::sum, Long::sum, Long.valueOf(Long.MIN_VALUE), Long.valueOf(0)); }
}