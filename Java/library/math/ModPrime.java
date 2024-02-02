package library.math;

public final class ModPrime {
	private final int len, mod;
	private final long[] f, rf;
	ModPrime(final int mod, final int sz) {
		this.mod = mod;
		len = Math.min(sz, mod);
		f = new long[len];
		rf = new long[len];
		init();
	}
	private final long inv(long x) {
		long res = 1, k = mod - 2;
		while(k > 0) {
			if(k % 2 == 1) {
				res = (res * x) % mod;
			}
			x = (x * x) % mod;
			k >>= 1;
		}
		return res;
	}
	private final void init() {
		f[0] = 1;
		for(int i = 0; ++i < len;) {
			f[i] = (f[i - 1] * i) % mod;
		}
		rf[len - 1] = inv(f[len - 1]);
		for(int i = len; --i > 0;) {
			rf[i - 1] = (rf[i] * i) % mod;
		}
	}
	final long C(final int n, final int k) {
		if(k < 0 || n < k) {
			return 0;
		}
		final long a = f[n], b = rf[n - k], c = rf[k], bc = (b * c) % mod;
		return (a * bc) % mod;
	}
	final long P(final int n, final int k) {
		if (k < 0 || n < k) {
			return 0;
		}
		final long a = f[n], b = rf[n - k];
		return (a * b) % mod;
	}
	final long H(final int n, final int k) {
		if (n == 0 && k == 0) {
			return 1;
		}
		return C(n + k - 1, k);
	}
}