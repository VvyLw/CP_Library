package library.math;

public final class DivisorTable {
	private final int[] ret;
	public DivisorTable(final int n) {
		ret = new int[n + 1];
		final int[] cnt = new int[n + 1];
		final var pt = new PrimeTable(n);
		final boolean[] isPrime = pt.table();
		final int[] primes = pt.get();
		for(int i = 2; i <= n; ++i) {
			if(isPrime[i]) {
				ret[i] = 2;
				cnt[i] = 1;
			}
			for(final int p: primes) {
				if((long) i * p > n) {
					break;
				}
				if(i % p == 0) {
					cnt[i * p] = cnt[i] + 1;
					ret[i * p] = ret[i] / (cnt[i] + 1) * (cnt[i * p] + 1);
					break;
				} else {
					cnt[i * p] = 1;
					ret[i * p] = ret[i] * 2;
				}
			}
		}
	}
	public final int[] getAll(){ return ret; }
	public final int get(final int i){ return ret[i]; }
}