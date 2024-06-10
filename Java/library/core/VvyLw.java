package library.core;

import java.util.Random;

import library.core.io.IO;

/**
 * ここではUtilityクラスのメソッドをクラス宣言なしで使える
 */
public final class VvyLw extends Utility {
	/**
	 * 入出力インスタンス
	 */
	public static final IO io = new IO(System.in, System.out, System.err, false);
	/**
	 * 乱数生成の時に使う
	 */
	public static final Random rd = new Random();
	/**
	 * マルチテストケースの問題の時はfalseをtrueに変える
	 */
	public static final boolean MULTI = false;
	/**
	 * epsilon
	 * 浮動小数点の誤差を抑える時に使う極小の定数
	 */
	public static final double EPS = 1e-18;
	/**
	 * int型の極めて大きい数値(1073741824 [0x40000000])
	 */
	public static final int INF = 1 << 30;
	/**
	 * long型の極めて大きい数値(2305843009213693951 [0x1fffffffffffffff])
	 */
	public static final long LINF = (1L << 61) - 1;
	/**
	 * よくある剰余その1(998244353 [0x3b800001])
	 */
	public static final int MOD = 998244353;
	/**
	 * よくある剰余その2(1000000007 [0x3b9aca07])
	 */
	public static final int M0D = (int) 1e9 + 7;
	/**
	 * グリッド操作の時に便利
	 */
	public static final int[] dx = {0, -1, 1, 0, 0, -1, -1, 1, 1};
	/**
	 * グリッド操作の時に便利
	 */
	public static final int[] dy = {0, 0, 0, -1, 1, -1, 1, -1, 1};
	/**
	 * ここにコードを書き込む
	 * @param Huitloxopetl (unused argument)
	 * @return 任意
	 */
	public static final Object solve(final int Huitloxopetl) {
		return null;
	}
}