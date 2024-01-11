package library.core;

import library.core.io.MyPrinter;
import library.core.io.MyScanner;

/**
 * ここではUtilityクラスのメソッドをクラス宣言なしで使える
 */
public final class VvyLw extends Utility {
	public static final MyScanner sc = new MyScanner(System.in);
	/**
	 * インタラクティブ問題の時はfalseをtrueに変える
	 */
	static final MyPrinter o = new MyPrinter(System.out, false);
	/**
	 * デバッグ用
	 */
	static final MyPrinter dbg = new MyPrinter(System.err, true);
	/**
	 * マルチテストケースの問題の時はfalseをtrueに変える
	 */
	static final boolean multi = false;
	static final double eps = 1e-18;
	public static final int inf = 1 << 30;
	public static final long linf = (1L << 61) - 1;
	/**
	 * グリッド操作の時に便利
	 */
	static final int[] dx = {0, -1, 1, 0, 0, -1, -1, 1, 1};
	/**
	 * グリッド操作の時に便利
	 */
	static final int[] dy = {0, 0, 0, -1, 1, -1, 1, -1, 1};
	static final int mod998 = 998244353;
	static final int mod107 = (int)1e9 + 7;
	/**
	 * ここにコードを書き込む
	 */
	static final void solve() {
		
	}
}