package library.structure;

/**
 * FenwickTree(Binary Indexed Tree[BIT])
 * @see <a href="https://nyaannyaan.github.io/library/data-structure/binary-indexed-tree.hpp">参考元</a>
 */
public final class FenwickTree {
	private final int n;
	private final long[] data;
	/**
	 * コンストラクタ
	 * @param n サイズ
	 */
	public FenwickTree(final int n) {
		this.n = n + 2;
		data = new long[this.n + 1];
	}
	/**
	 * @param k
	 * @return 閉区間[0, k]の和
	 */
	public final long sum(int k) {
		if(k < 0) return 0;
		long ret = 0;
		for(++k; k > 0; k -= k & -k) {
			ret += data[k];
		}
		return ret;
	}
	/**
	 * @param l
	 * @param r
	 * @return 閉区間[l, r]の和
	 */
	public final long sum(final int l, final int r){ return sum(r) - sum(l - 1); }
	/**
	 * @param k
	 * @return k番目の要素
	 */
	public final long get(final int k){ return sum(k) - sum(k - 1); }
	/**
	 * k番目に値を加算
	 * @param k
	 * @param x
	 */
	public final void add(int k, final long x) {
		for(++k; k < n; k += k & -k) {
			data[k] += x;
		}
	}
	/**
	 * 閉区間[l, r]に値を加算する
	 * @param l
	 * @param r
	 * @param x
	 */
	public final void imos(final int l, final int r, long x) {
		add(l, x);
		add(r + 1, -x);
	}
	private final int lg(final int n){ return 63 - Integer.numberOfLeadingZeros(n); }
	/**
	 * @implNote 要素は全て非負
	 * @param w
	 * @return [0, k]の区間和がw以上となるような最小のk
	 */
	public final int lowerBound(long w) {
		if(w <= 0) {
			return 0;
		}
		int x = 0;
		for(int k = 1 << lg(n); k > 0; k >>= 1) {
			if(x + k <= n - 1 && data[x + k] < w) {
				w -= data[x + k];
				x += k;
			}
		}
		return x;
	}
	/**
	 * @implNote 要素は全て非負
	 * @param w
	 * @return [0, k]の区間和がwよりも大きくなるような最小のk
	 */
	public final int upperBound(long w) {
		if(w < 0) {
			return 0;
		}
		int x = 0;
		for(int k = 1 << lg(n); k > 0; k >>= 1) {
			if(x + k <= n - 1 && data[x + k] <= w) {
				w -= data[x + k];
				x += k;
			}
		}
		return x;
	}
}