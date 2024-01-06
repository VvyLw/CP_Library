package library.math;

import java.util.ArrayList;

import library.core.Utility;

public final class PrimeCounter {
	private final int sq;
	private final boolean[] p;
	private final int[] psum;
	private final ArrayList<Integer> ps;
	public PrimeCounter(final long lim) {
		sq = (int) kthRooti(lim, 2);
		psum = new int[sq + 1];
		p = new PrimeTable(sq).table();
		for(int i = 1; i <= sq; ++i) {
			psum[i] = psum[i - 1] + (p[i] ? 1 : 0);
		}
		ps = new ArrayList<>();
		for(int i = 1; i <= sq; ++i) {
			if(p[i]) {
				ps.add(i);
			}
		}
	}
	private final long kthRooti(final long n, final int k){ return Utility.kthRoot(n, k); }
	private final long p2(final long x, final long y) {
		if(x < 4) {
			return 0;
		}
		final long a = pi(y);
		final long b = pi(kthRooti(x, 2));
		if(a >= b) {
			return 0;
		}
		long sum = (long) (a - 2) * (a + 1) / 2 - (b - 2) * (b + 1) / 2;
		for(long i = a; i < b; ++i) {
			sum += pi(x / ps.get((int) i));
		}
		return sum;
	}
	private final long phi(final long m, final long a) {
		if(m < 1) {
			return 0;
		}
		if(a > m) {
			return 1;
		}
		if(a < 1) {
			return m;
		}
		if(m <= (long) ps.get((int) (a - 1)) * ps.get((int) (a - 1))) {
			return pi(m) - a + 1;
		}
		if(m <= (long) ps.get((int) (a - 1)) * ps.get((int) (a - 1)) * ps.get((int) (a - 1)) && m <= sq) {
			final long sx = pi(kthRooti(m, 2));
			long ans = pi(m) - (long) (sx + a - 2) * (sx - a + 1) / 2;
			for(long i = a; i < sx; ++i) {
				ans += pi(m / ps.get((int) i));
			}
			return ans;
		}
		return phi(m, a - 1) - phi(m / ps.get((int) (a - 1)), a - 1);
	}
	public final long pi(final long n) {
		if(n <= sq) {
			return psum[(int) n];
		}
		final long m = kthRooti(n, 3);
		final long a = pi(m);
		return phi(n, a) + a - 1 - p2(n, m);
	}
}