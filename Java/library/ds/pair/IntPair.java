package library.ds.pair;

import library.core.Utility;

/**
 * 整数型のPair特化クラス
 * 便利なメソッドもある
 */
public final class IntPair extends Pair<Long, Long> {
	/**
	 * コンストラクタ
	 * @param first
	 * @param second
	 */
	private IntPair(final long first, final long second){ super(first, second); }
	/**
	 * (0, 0)
	 */
	public static final IntPair ZERO = new IntPair(0, 0);
	/**
	 * (1, 1)
	 */
	public static final IntPair ONE = new IntPair(1, 1);
	/**
	 * IntPairを宣言するのに使う
	 * new IntPairと同等
	 * @param a first
	 * @param b second
	 */
	public static final IntPair of(final long a, final long b){ return new IntPair(a, b); }
	/**
	 * 元のIntPairをswapしたものを返す
	 * @return firstとsecondを入れ替えたIntPair
	 */
	@Override
	public final IntPair swap(){ return new IntPair(second, first); }
	/**
	 * Pair同士を加算する
	 * @param p
	 */
	public final IntPair add(final IntPair p){ return new IntPair(first + p.first, second + p.second); }
	/**
	 * Pair同士を減算する
	 * @param p
	 */
	public final IntPair sub(final IntPair p){ return new IntPair(first - p.first, second - p.second); }
	/**
	 * Pair同士を乗算する
	 * @param p
	 */
	public final IntPair mul(final IntPair p){ return new IntPair(first * p.first, second * p.second); }
	/**
	 * Pair同士を除算する
	 * @param p
	 */
	public final IntPair div(final IntPair p){ return new IntPair(first / p.first, second / p.second); }
	/**
	 * [maybe_unused] Pair同士の剰余演算
	 * @param p
	 */
	public final IntPair mod(final IntPair p){ return new IntPair(first % p.first, second % p.second); }
	/**
	 * IntPairを座標と見て90度回転させる
	 * rotate(90)より精確
	 */
	public final IntPair rotate(){ return new IntPair(-second, first); }
	/**
	 * IntPairを座標と見てang度回転させる
	 * @param ang
	 */
	public final FloatPair rotate(final int ang) {
		final double rad = Math.toRadians(Utility.mod(ang, 360));
		return FloatPair.of(first * Math.cos(rad) - second * Math.sin(rad), first * Math.sin(rad) + second * Math.cos(rad));
	}
	/**
	 * ドット積を返す
	 * @param p
	 * @return ドット積
	 */
	public final long dot(final IntPair p){ return first * p.first + second * p.second; }
	/**
	 * クロス積を返す
	 * @param p
	 * @return クロス積
	 */
	public final long cross(final IntPair p){ return rotate().dot(p); }
	/**
	 * 距離を返す
	 * @return IntPairを座標と見て距離
	 */
	public final long sqr(){ return dot(this); }
	/**
	 * second / firstを返す
	 * @return IntPairの勾配
	 */
	public final double grad() { 
		try {
			return 1.0 * second / first;
		} catch(final ArithmeticException e) {
			e.printStackTrace();
		}
		throw new Error();
	}
	/**
	 * ユークリッドノルムを返す
	 * @return IntPairのユークリッドノルム
	 */
	public final double abs(){ return Math.hypot(first, second); }
	/**
	 * 最小公倍数を返す
	 * @return IntPairの最小公倍数
	 */
	public final long lcm(){ return Utility.lcm(first, second); }
	/**
	 * 最大公約数を返す
	 * @return IntPairの最大公約数
	 */
	public final long gcd(){ return Utility.gcd(first, second); }
	/**
	 * 拡張ユークリッドの互除法
	 */
	public final IntPair extgcd() {
		long x = 1, y = 0, t1 = 0, t2 = 0, t3 = 1, a = first, b = second;
		while(b > 0) {
			t1 = a / b;
			a -= t1 * b;
			a ^= b;
			b ^= a;
			a ^= b;
			x -= t1 * t2;
			x ^= t2;
			t2 ^= x;
			x ^= t2;
			y -= t1 * t3;
			y ^= t3;
			t3 ^= y;
			y ^= t3;
		}
		return new IntPair(x, y);
	}
}