package library.math.prefixsum;

/**
 * 二次元累積和
 * @see <a href="https://nyaannyaan.github.io/library/data-structure-2d/2d-cumulative-sum.hpp">参考元</a>
 */
public final class PrefixSum2D {
	private final int h, w;
	private final long[][] data;
	private boolean built;
	/**
	 * コンストラクタ
	 * @param h
	 * @param w
	 */
	public PrefixSum2D(final int h, final int w) {
		this.h = h + 3;
		this.w = w + 3;
		data = new long[this.h][this.w];
		built = false;
	}
	/**
	 * コンストラクタ
	 * @param a
	 */
	public PrefixSum2D(final int[][] a) {
		this(a.length, a[0].length);
		for(int i = 0; i < a.length; ++i) {
			for(int j = 0; j < a[i].length; ++j) {
				add(i, j, a[i][j]);
			}
		}
	}
	/**
	 * コンストラクタ
	 * @param a
	 */
	public PrefixSum2D(final long[][] a) {
		this(a.length, a[0].length);
		for(int i = 0; i < a.length; ++i) {
			for(int j = 0; j < a[i].length; ++j) {
				add(i, j, a[i][j]);
			}
		}
	}
	/**
	 * (i, j)番目にxを加算
	 * @param i
	 * @param j
	 * @param x
	 */
	public final void add(int i, int j, final long x) {
		if(built) {
			throw new UnsupportedOperationException("Prefix Sum 2D has been built.");
		}
		i++;
		j++;
		if(i >= h || j >= w) {
			return;
		}
		data[i][j] += x;
	}
	/**
	 * 半開区間[i1, i2), [j1, j2)にxを加算
	 * @param i1
	 * @param j1
	 * @param i2
	 * @param j2
	 * @param x
	 */
	public final void add(final int i1, final int j1, final int i2, final int j2, final long x) {
		add(i1, j1, x);
		add(i1, j2, -x);
		add(i2, j1, -x);
		add(i2, j2, x);
	}
	/**
	 * 構築
	 */
	public final void build() {
		assert !built;
		for(int i = 1; i < h; ++i) {
			for(int j = 1; j < w; ++j) {
				data[i][j] += data[i][j - 1] + data[i - 1][j] - data[i - 1][j - 1];
			}
		}
		built = true;
	}
	/**
	 * 半開区間[i1, i2), [j1, j2)の矩形和
	 * @param i1
	 * @param j1
	 * @param i2
	 * @param j2
	 * @return [i1, i2), [j1, j2)の矩形和
	 */
	public final long get(final int i1, final int j1, final int i2, final int j2) {
		if(!built) {
			throw new UnsupportedOperationException("Prefix Sum 2D hasn't been built.");
		}
		return data[i2][j2] - data[i1][j2] - data[i2][j1] + data[i1][j1];
	}
	/**
	 * PrefixSum2D[i][j]の要素を返す
	 * @param i
	 * @param j
	 * @return (i, j)の要素
	 */
	public final long get(final int i, final int j) {
		if(!built) {
			throw new UnsupportedOperationException("Prefix Sum 2D hasn't been built.");
		}
		return data[i + 1][j + 1];
	}
	@Override
	public final String toString() {
		final StringBuilder sb = new StringBuilder();
		for(int i = 0; i < h - 3; ++i) {
			sb.append(get(i, 0));
			for(int j = 0; ++j < w - 3;) {
				sb.append(" " + get(i, j));
			}
			if(i + 1 < h) {
				sb.append('\n');
			}
		}
		return sb.toString();
	}
}