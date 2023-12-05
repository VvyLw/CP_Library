package extension;

import java.util.Arrays;
import java.util.stream.IntStream;

class PrimeTable {
	private int n, size;
	private boolean[] sieve;
	PrimeTable(final int n) {
		this.n = n;
		sieve = new boolean[n + 1];
		Arrays.fill(sieve, true);
		sieve[0] = sieve[1] = false;
		for(long i = 2; i <= n; ++i) {
			if(!sieve[(int) i]) {
				continue;
			}
			for(long j = i * i; j <= n; j += i) {
				sieve[(int) j] = false;
			}
		}
		size = (int) IntStream.rangeClosed(0, n).filter(i -> sieve[i]).count();
	}
	boolean[] table(){ return sieve; }
	int[] get() {
		int j = 0;
		int[] p = new int[size];
		for(int i = 2; i <= n; ++i) {
			if(sieve[i]) {
				p[j++] = i; 
			}
		}
		return p;
	}
}