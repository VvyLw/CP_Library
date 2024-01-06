package library.math;

import java.util.Arrays;
import java.util.stream.IntStream;

public final class PrimeTable {
	private final int size;
	private final int[] p;
	private final boolean[] sieve;
	public PrimeTable(final int n) {
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
		int j = 0;
		p = new int[size];
		for(int i = 2; i <= n; ++i) {
			if(sieve[i]) {
				p[j++] = i; 
			}
		}
	}
	public final boolean[] table(){ return sieve; }
	public final int[] get(){ return p; }
}