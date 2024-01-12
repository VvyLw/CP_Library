package library.math;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * n以下の整数について素数判定をするテーブルを作成するクラス
 * エラトステネスの篩
 */
public final class PrimeTable {
	private final int size;
	private final int[] p;
	private final boolean[] sieve;
	/**
	 * コンストラクタ
	 * @param n 整数
	 */
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
	/**
	 * @return n以下の素数判定の結果をリストアップした配列
	 */
	public final boolean[] table(){ return sieve; }
	/**
	 * @return n以下の素数をリストアップした配列
	 */
	public final int[] get(){ return p; }
}