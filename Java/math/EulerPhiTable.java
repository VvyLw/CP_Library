package library.math;

import library.core.Utility;

public final class EulerPhiTable {
	private final int n;
	private final int[] euler;
	public EulerPhiTable(final int n) {
		this.n = n;
		euler = Utility.iota(n + 1);
		for(int i = 2; i <= n; ++i) {
			if(euler[i] == i) {
				for(int j = i; j <= n; j += i) {
					euler[j] = euler[j] / i * (i - 1);
				}
			}
		}
	}
	public final int[] get(){ return euler; }
	public final long[] acc() {
		long[] ret = new long[n + 1];
		ret[1] = 2;
		for(int i = 2; i <= n; ++i) {
			ret[i] = ret[i - 1] + euler[i];
		}
		return ret;
	}
}