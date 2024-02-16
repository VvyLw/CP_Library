package library.structure.lazysegmenttree;

import java.util.Arrays;

/**
 * Range Update Range Min
 * 区間更新, 区間最小値
 */
public final class RUMN extends LazySegmentTree<Long, Long> {
	public RUMN(final int[] a){ super(Arrays.stream(a).asLongStream().boxed().toArray(Long[]::new), Long::min, (x, y) -> y, (x, y) -> y, Long.valueOf(Long.MAX_VALUE), Long.valueOf(Long.MAX_VALUE)); }
	public RUMN(final long[] a){ super(Arrays.stream(a).boxed().toArray(Long[]::new), Long::min, (x, y) -> y, (x, y) -> y, Long.valueOf(Long.MAX_VALUE), Long.valueOf(Long.MAX_VALUE)); }
}