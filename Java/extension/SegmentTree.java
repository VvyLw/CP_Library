package extension;

import java.util.Arrays;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

class SegmentTree {
	private int n = 1, rank = 0, fini;
	private BinaryOperator<Long> op;
	private long e;
	private long[] dat;
	SegmentTree(final int fini, final BinaryOperator<Long> op, final long e) {
		this.fini = fini;
		this.op = op;
		this.e = e;
		while(this.fini > n) {
			n <<= 1;
			rank++;
		}
		dat = new long[2 * n];
		Arrays.fill(dat, e);
	}
	void update(int i, final long x) {
		i += n;
		dat[i] = x;
		do {
			i >>= 1;
			dat[i] = op.apply(dat[2 * i], dat[2 * i + 1]);
		} while(i > 0);
	}
	void add(int i, final long x) {
		i += n;
		dat[i] += x;
		do {
			i >>= 1;
			dat[i] = op.apply(dat[2 * i], dat[2 * i + 1]);
		} while(i > 0);
	}
	long query(int a, int b) {
		long l=e,r=e;
		for(a += n, b += n; a < b; a >>= 1, b >>= 1) {
			if(a % 2 == 1) {
				l = op.apply(l, dat[a++]);
			}
			if(b % 2 == 1) {
				r = op.apply(dat[--b], r);
			}
		}
		return op.apply(l,r);
	}
	int findLeft(int r, final Predicate<Long> fn) {
		if(r == 0) {
			return 0;
		}
		int h = 0, i = r + n;
		long val = e;
		for(; h <= rank; h++) {
			if(i >> (h & 1) > 0) {
				final long val2 = op.apply(val, dat[i >> (h ^ 1)]);
				if(fn.test(val2)){
					i -= 1 << h;
					if(i == n) {
						return 0;
					}
					val = val2;
				}
				else {
					break;
				}
			}
		}
		for(; h-- > 0;) {
			long val2 = op.apply(val, dat[(i >> h) - 1]);
			if(fn.test(val2)){
				i -= 1 << h;
				if(i == n) {
					return 0;
				}
				val = val2;
			}
		}
		return i - n;
	}
	int findRight(int l, final Predicate<Long> fn) {
		if(l == fini) {
			return fini;
		}
		int h = 0, i = l + n;
		long val = e;
		for(; h <= rank; h++) {
			if(i >> (h & 1) > 0){
				long val2 = op.apply(val, dat[i >> h]);
				if(fn.test(val2)){
					i += 1 << h;
					if(i == n * 2) {
						return fini;
					}
					val = val2;
				}
				else {
					break;
				}
			}
		}
		for(; h-- > 0;) {
			long val2 = op.apply(val, dat[i>>h]);
			if(fn.test(val2)) {
				i += 1 << h;
				if(i == n * 2) {
					return fini;
				}
				val = val2;
			}
		}
		return Math.min(i - n, fini);
	}
}