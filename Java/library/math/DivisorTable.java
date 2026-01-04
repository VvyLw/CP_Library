package library.math;

/**
 * n以下の整数について約数の個数を数えるテーブルを作成するクラス
 * 線形篩
 */
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
	/**
	 * n以下の約数の個数をリストアップした配列を返す
	 * @return n以下の約数の個数をリストアップした配列
	 */
	public final int[] get(){ return ret; }
}