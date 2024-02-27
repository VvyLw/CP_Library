package library.ds.lazysegmenttree;

import library.ds.pair.Zwei;

/**
 * Range Update Range Sum
 * 区間更新, 区間和
 */
public final class RUSM extends LazySegmentTree<Zwei<Long>, Long> {
	private final int n;
	private final Zwei<Long>[] b;
	@SuppressWarnings("unchecked")
	public RUSM(final int[] a) {
		super(a.length, (x, y) -> Zwei.of(x.first.longValue() + y.first.longValue(), x.second.longValue() + y.second.longValue()), (x, y) -> Zwei.of(x.second.longValue() * y.longValue(), x.second.longValue()), (x, y) -> y, Zwei.of(0L, 0L), Long.valueOf(Long.MIN_VALUE));
		n = a.length;
		b = new Zwei[n];
		for(int i = 0; i < n; ++i) {
			b[i] = Zwei.of((long) a[i], 1L);
		}
		build(b);
	}
	@SuppressWarnings("unchecked")
	public RUSM(final long[] a) {
		super(a.length, (x, y) -> Zwei.of(x.first.longValue() + y.first.longValue(), x.second.longValue() + y.second.longValue()), (x, y) -> Zwei.of(x.second.longValue() * y.longValue(), x.second.longValue()), (x, y) -> y, Zwei.of(0L, 0L), Long.valueOf(Long.MIN_VALUE));
		n = a.length;
		b = new Zwei[n];
		for(int i = 0; i < n; ++i) {
			b[i] = Zwei.of(a[i], 1L);
		}
		build(b);
	}
}