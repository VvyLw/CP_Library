package library.core;

import library.core.io.IO;
import library.core.io.MyPrinter;
import library.core.io.MyScanner;

/**
 * ここではUtilityクラスのメソッドをクラス宣言なしで使える
 */
public final class VvyLw extends Utility {
	/**
	 * 入出力
	 */
	public static final IO io = new IO(new MyScanner(System.in), new MyPrinter(System.out, false), new MyPrinter(System.err, true));
	/**
	 * マルチテストケースの問題の時はfalseをtrueに変える
	 */
	static final boolean MULTI = false;
	static final double EPS = 1e-18;
	public static final int INF = 1 << 30;
	public static final long LINF = (1L << 61) - 1;
	static final int MOD = 998244353;
	static final int M0D = (int) 1e9 + 7;
	/**
	 * グリッド操作の時に便利
	 */
	static final int[] dx = {0, -1, 1, 0, 0, -1, -1, 1, 1};
	/**
	 * グリッド操作の時に便利
	 */
	static final int[] dy = {0, 0, 0, -1, 1, -1, 1, -1, 1};
	/**
	 * ここにコードを書き込む
	 */
	static final void solve() {
		
	}
}