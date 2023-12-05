package extension;

import java.util.TreeMap;
import java.util.stream.IntStream;

final class PrimeFactor {
	private final int[] spf;
	PrimeFactor(final int n) {
		spf = IntStream.rangeClosed(0, n).toArray();
		for(int i = 2; i * i <= n; ++i) {
			if(spf[i] == i) {
				for(int j = i * i; j <= n; j += i) {
					if(spf[j] == j) {
						spf[j] = i;
					}
				}
			}
		}
	}
	final TreeMap<Integer, Integer> get(int n) {
		final TreeMap<Integer, Integer> m = new TreeMap<>();
		while(n != 1) {
			m.merge(spf[n], 1, (a, b) -> (a + b));
			n /= spf[n];
		}
		return m;
	}
}