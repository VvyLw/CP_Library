package library.structure.lazysegmenttree;

import java.util.Arrays;

/**
 * Range Update Range Max
 * 区間更新, 区間最大値
 */
public final class RUMX extends LazySegmentTree<Long, Long> {
	public RUMX(final int[] a){ super(Arrays.stream(a).asLongStream().boxed().toArray(Long[]::new), Long::max, (x, y) -> y, (x, y) -> y, Long.valueOf(Long.MIN_VALUE), Long.valueOf(Long.MIN_VALUE)); }
	public RUMX(final long[] a){ super(Arrays.stream(a).boxed().toArray(Long[]::new), Long::max, (x, y) -> y, (x, y) -> y, Long.valueOf(Long.MIN_VALUE), Long.valueOf(Long.MIN_VALUE)); }
}