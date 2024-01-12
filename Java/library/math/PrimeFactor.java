package library.math;

import java.util.TreeMap;

import library.core.Utility;

/**
 * n以下の整数に対して素因数分解可能なテーブルを作成するクラス
 */
public final class PrimeFactor {
	private final int[] spf;
	public PrimeFactor(final int n) {
		spf = Utility.iota(n + 1);
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
	/**
	 * @param n 整数
	 * @return nを素因数分解する
	 */
	public final TreeMap<Integer, Integer> get(int n) {
		final TreeMap<Integer, Integer> m = new TreeMap<>();
		while(n != 1) {
			m.merge(spf[n], 1, (a, b) -> (a + b));
			n /= spf[n];
		}
		return m;
	}
}
