package library.structure.pair;

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
	public IntPair(final long first, final long second){ super(first, second); }
	/**
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
		return new FloatPair(first * Math.cos(rad) - second * Math.sin(rad), first * Math.sin(rad) + second * Math.cos(rad));
	}
	/**
	 * @param p
	 * @return ドット積
	 */
	public final long dot(final IntPair p){ return first * p.first + second * p.second; }
	/**
	 * @param p
	 * @return クロス積
	 */
	public final long cross(final IntPair p){ return rotate().dot(p); }
	/**
	 * @return IntPairを座標と見て距離
	 */
	public final long sqr(){ return dot(this); }
	/**
	 * @return IntPairの勾配
	 */
	public final double grad() { 
		try {
			return 1.0 * second / first;
		} catch(final ArithmeticException e) {
			e.printStackTrace();
		}
		return Double.NaN;
	}
	/**
	 * @return IntPairのユークリッドノルム
	 */
	public final double abs(){ return Math.hypot(first, second); }
	/**
	 * @return IntPairの最小公倍数
	 */
	public final long lcm(){ return Utility.lcm(first, second); }
	/**
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