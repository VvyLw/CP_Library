package library.ds.fenwicktree;

/**
 * Range Add Range Sum
 * 区間加算, 区間和
 */
public final class RangeBIT {
	private final int n;
	private final FenwickTree a, b;
	/**
	 * コンストラクタ
	 * @param n サイズ
	 */
	public RangeBIT(final int n) {
		this.n = n;
		a = new FenwickTree(n + 1);
		b = new FenwickTree(n + 1);
	}
	/**
	 * コンストラクタ
	 * @param arr
	 */
	public RangeBIT(final int[] arr) {
		this(arr.length);
		for(int i = 0; i < arr.length; ++i) {
			add(i, i, arr[i]);
		}
	}
	/**
	 * コンストラクタ
	 * @param arr
	 */
	public RangeBIT(final long[] arr) {
		this(arr.length);
		for(int i = 0; i < arr.length; ++i) {
			add(i, i, arr[i]);
		}
	}
	/**
	 * 半開区間[l, r)に要素を加算
	 * @param l
	 * @param r
	 * @param x
	 */
	public final void add(final int l, final int r, final long x) {
		a.add(l, x);
		a.add(r, -x);
		b.add(l, x * (1 - l));
		b.add(r, x * (r - 1));
	}
	/**
	 * @param i
	 * @return i番目の要素
	 */
	public final long get(final int i){ return sum(i, i + 1); }
	/**
	 * @param l
	 * @param r
	 * @return 半開区間[l, r)の和
	 */
	public final long sum(int l, int r) {
		l--;
		r--;
		return a.sum(r) * r + b.sum(r) - a.sum(l) * l - b.sum(l);
	}
	@Override
	public final String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append(get(0));
		for(int i = 0; ++i < n;) {
			sb.append(" " + get(i));
		}
		return sb.toString();
	}
}