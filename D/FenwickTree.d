class FenwickTree(T) {
import core.bitop: bsr;
private:
    int n;
    T[] data;
public:
    this(const int sz) {
        n = sz + 2;
        data = new T[n];
    }
    this(const T[] a) {
        this(cast(int)a.length);
        foreach(i; 0..a.length) {
            add(cast(int)i, a[i]);
        }
    }
    T sum(int k) const {
		if(k < 0) {
			return 0;
		}
		T ret = 0;
		for(++k; k > 0; k -= k & -k) {
			ret += data[k];
		}
		return ret;
	}
    T sum(const int l, const int r) const { return sum(r) - sum(l - 1); }
    ref auto opIndex(const int i) const { return sum(i) - sum(i - 1); }
    void add(int k, const T x) {
		for(++k; k < n; k += k & -k) {
			data[k] += x;
		}
	}
    void add(const int l, const int r, const T x) {
		add(l, x);
		add(r + 1, -x);
	}
    int lowerBound(T w) {
		if(w <= 0) {
			return 0;
		}
		int x = 0;
		for(int k = 1 << bsr(n); k > 0; k >>= 1) {
			if(x + k <= n - 1 && data[x + k] < w) {
				w -= data[x + k];
				x += k;
			}
		}
		return x;
	}
    int upperBound(T w) {
		if(w < 0) {
			return 0;
		}
		int x = 0;
		for(int k = 1 << bsr(n); k > 0; k >>= 1) {
			if(x + k <= n - 1 && data[x + k] <= w) {
				w -= data[x + k];
				x += k;
			}
		}
		return x;
	}
}