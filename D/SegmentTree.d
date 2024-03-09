final class SegmentTree(T) {
import std.algorithm: min;
private:
	int n = 1, rank = 0, fini;
	alias F = T delegate(T, T);
	alias G = bool delegate(T);
	F f;
	T e;
	T[] dat;
public:
	this(const int fini, const F f, const T e) {
		this.fini = fini;
		this.f = f;
		this.e = e;
		while(fini > n) {
			n <<= 1;
			rank++;
		}
		dat = new T[n << 1];
		dat[] = e;
	}
	this(const T[] a, const F f, const T e) {
		this(cast(int)a.length, f, e);
		foreach(i; 0..cast(int)a.length) {
			update(i, a[i]);
		}
	}
	void update(int i, const T x) {
		i += n;
		dat[i] = x;
		do {
			i >>= 1;
			dat[i] = f(dat[2 * i], dat[2 * i + 1]);
		} while(i > 0);
	}
	ref auto opIndex(const int i){ return query(i, i + 1); }
	T query(int a, int b) {
		T l = e, r = e;
		for(a += n, b += n; a < b; a >>= 1, b >>= 1) {
			if(a & 1) {
				l = f(l, dat[a++]);
			}
			if(b & 1) {
				r = f(dat[--b], r);
			}
		}
		return f(l, r);
	}
	T all() const { return dat[1]; }
	int findLeft(const int r, const G fn) {
		if(r == 0) {
			return 0;
		}
		int h = 0, i = r + n;
		auto val = e;
		for(; h <= rank; h++) {
			if(i >> (h & 1) > 0) {
				const val2 = f(val, dat[i >> (h ^ 1)]);
				if(fn(val2)){
					i -= 1 << h;
					if(i == n) {
						return 0;
					}
					val = val2;
				} else {
					break;
				}
			}
		}
		for(; h-- > 0;) {
			const val2 = f(val, dat[(i >> h) - 1]);
			if(fn(val2)){
				i -= 1 << h;
				if(i == n) {
					return 0;
				}
				val = val2;
			}
		}
		return i - n;
	}
	int findRight(const int l, const G fn) {
		if(l == fini) {
			return fini;
		}
		int h = 0, i = l + n;
		auto val = e;
		for(; h <= rank; h++) {
			if(i >> (h & 1) > 0){
				const val2 = f(val, dat[i >> h]);
				if(fn(val2)){
					i += 1 << h;
					if(i == n * 2) {
						return fini;
					}
					val = val2;
				} else {
					break;
				}
			}
		}
		for(; h-- > 0;) {
			const val2 = f(val, dat[i>>h]);
			if(fn(val2)) {
				i += 1 << h;
				if(i == n * 2) {
					return fini;
				}
				val = val2;
			}
		}
		return min(i - n, fini);
	}
}