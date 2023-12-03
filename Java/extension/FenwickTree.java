package extension;

class FenwickTree {
	private int n;
	private long[] data;
	FenwickTree(final int n) {
		this.n = n + 2;
		data = new long[this.n + 1];
	}
	long sum(int k) {
		if(k < 0) return 0;
		long ret = 0;
		for(++k; k > 0; k -= k & -k) {
			ret += data[k];
		}
		return ret;
	}
	long sum(final int l, final int r){ return sum(r) - sum(l - 1); }
	long get(final int k){ return sum(k) - sum(k - 1); }
	void add(int k, final long x) {
		for(++k; k < n; k += k & -k) {
			data[k] += x;
		}
	}
	void imos(final int l, final int r, long x) {
		add(l, x);
		add(r + 1, -x);
	}
	private int lg(final int n){ return 63 - Integer.numberOfLeadingZeros(n); }
	int lowerBound(long w) {
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
	int upper_bound(long w) {
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