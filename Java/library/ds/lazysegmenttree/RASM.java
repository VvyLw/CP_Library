package library.ds.lazysegmenttree;

import library.ds.fenwicktree.RangeBIT;
import library.ds.pair.Zwei;

/**
 * Range Add Range Sum
 * 区間加算, 区間和
 * RangeBITを使うような問題で二分探索を求められた場合はこちら
 * @see RangeBIT
 */
public final class RASM extends LazySegmentTree<Zwei<Long>, Long> {
	private final int n;
	private final Zwei<Long>[] b;
	/**
	 * コンストラクタ
	 * @param a
	 */
	@SuppressWarnings("unchecked")
	public RASM(final int[] a) {
		super(a.length, (x, y) -> Zwei.of(x.first.longValue() + y.first.longValue(), x.second.longValue() + y.second.longValue()), (x, y) -> Zwei.of(x.first.longValue() + x.second.longValue() * y.longValue(), x.second.longValue()), Long::sum, Zwei.of(0L, 0L), Long.valueOf(0));
		n = a.length;
		b = new Zwei[n];
		for(int i = 0; i < n; ++i) {
			b[i] = Zwei.of((long) a[i], 1L);
		}
		build(b);
	}
	/**
	 * コンストラクタ
	 * @param a
	 */
	@SuppressWarnings("unchecked")
	public RASM(final long[] a) {
		super(a.length, (x, y) -> Zwei.of(x.first.longValue() + y.first.longValue(), x.second.longValue() + y.second.longValue()), (x, y) -> Zwei.of(x.first.longValue() + x.second.longValue() * y.longValue(), x.second.longValue()), Long::sum, Zwei.of(0L, 0L), Long.valueOf(0));
		n = a.length;
		b = new Zwei[n];
		for(int i = 0; i < n; ++i) {
			b[i] = Zwei.of(a[i], 1L);
		}
		build(b);
	}
}