package library.ds.lazysegmenttree;

import java.util.Arrays;

/**
 * Range Update Range Max
 * 区間更新, 区間最大値
 */
public final class RUMX extends LazySegmentTree<Long, Long> {
	/**
	 * コンストラクタ
	 * @param a
	 */
	public RUMX(final int[] a){ super(Arrays.stream(a).asLongStream().boxed().toArray(Long[]::new), Long::max, (x, y) -> y, (x, y) -> y, Long.valueOf(Long.MIN_VALUE), Long.valueOf(Long.MIN_VALUE)); }
	/**
	 * コンストラクタ
	 * @param a
	 */
	public RUMX(final long[] a){ super(Arrays.stream(a).boxed().toArray(Long[]::new), Long::max, (x, y) -> y, (x, y) -> y, Long.valueOf(Long.MIN_VALUE), Long.valueOf(Long.MIN_VALUE)); }
}