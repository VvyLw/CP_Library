package extension;

import java.util.ArrayList;
import java.util.Arrays;

class PrimeTable {
	private int n;
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
	}
	boolean[] table(){ return sieve; }
	ArrayList<Integer> get() {
		ArrayList<Integer> p = new ArrayList<>();
		for(int i = 2; i <= n; ++i) {
			if(sieve[i]) {
				p.add(i);
			}
		}
		return p;
	}
}