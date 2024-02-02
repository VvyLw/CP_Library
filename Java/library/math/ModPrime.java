package library.math;

import library.core.Utility;

public final class ModPrime {
	private final int len;
	private final long mod;
	private final long[] f, rf;
	public ModPrime(final long mod, final int sz) {
		this.mod = mod;
		len = (int) Math.min(sz, mod);
		f = new long[len];
		rf = new long[len];
		init();
	}
	private final long inv(long x) {
		long res = 1, k = mod - 2;
		while(k > 0) {
			if(k % 2 == 1) {
				res = Utility.mod(res * x, mod);
			}
			x = Utility.sqr(x) % mod;
			k >>= 1;
		}
		return res;
	}
	private final void init() {
		f[0] = rf[0] = 1;
		for(int i = 0; ++i < len;) {
			f[i] = Utility.mod(f[i - 1] * i, mod);
			rf[i] = inv(f[i]);
		}
	}
	public final long C(final int n, final int k) {
		if(k < 0 || n < k) {
			return 0;
		}
		final long a = f[n], b = rf[n - k], c = rf[k], bc = (b * c) % mod;
		return Utility.mod(a * bc, mod);
	}
	public final long P(final int n, final int k) {
		if (k < 0 || n < k) {
			return 0;
		}
		final long a = f[n], b = rf[n - k];
		return Utility.mod(a * b, mod);
	}
	public final long H(final int n, final int k) {
		if (n == 0 && k == 0) {
			return 1;
		}
		return C(n + k - 1, k);
	}
}