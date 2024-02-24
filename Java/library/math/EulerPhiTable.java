package library.math;

import library.core.Utility;

/**
 * 1からnまでの整数のうちnと互いに素なものの個数を求めるテーブルを作成するクラス
 */
public final class EulerPhiTable {
	private final int[] euler;
	/**
	 * コンストラクタ
	 * @param n 整数
	 */
	public EulerPhiTable(final int n) {
		euler = Utility.iota(n + 1).toArray();
		for(int i = 2; i <= n; ++i) {
			if(euler[i] == i) {
				for(int j = i; j <= n; j += i) {
					euler[j] = euler[j] / i * (i - 1);
				}
			}
		}
	}
	/**
	 * @return 1からnまでの整数のうちnと互いに素なものの個数を求めるテーブル
	 */
	public final int[] get(){ return euler; }
}