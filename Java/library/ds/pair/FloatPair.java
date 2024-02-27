package library.ds.pair;
import library.core.Utility;

/**
 * 浮動小数特化のPairクラス
 * メソッドはIntPairにあるもののFloatPair版
 */
public final class FloatPair extends Pair<Double, Double> {
	/**
	 * コンストラクタ
	 * @param first
	 * @param second
	 */
	private FloatPair(final double first, final double second){ super(first, second); }
	public static final FloatPair of(final double a, final double b){ return new FloatPair(a, b); }
	/**
	 * @return firstとsecondを入れ替えたFloatPair
	 */
	@Override
	public final FloatPair swap(){ return new FloatPair(second, first); }
	/**
	 * FloatPair同士を加算する
	 * @param p
	 */
	public final FloatPair add(final FloatPair p){ return new FloatPair(first + p.first, second + p.second); }
	/**
	 * FloatPair同士を減算する
	 * @param p
	 */
	public final FloatPair sub(final FloatPair p){ return new FloatPair(first - p.first, second - p.second); }
	/**
	 * FloatPair同士を乗算する
	 * @param p
	 */
	public final FloatPair mul(final FloatPair p){ return new FloatPair(first * p.first, second * p.second); }
	/**
	 * FloatPair同士を除算する
	 * @param p
	 */
	public final FloatPair div(final FloatPair p){ return new FloatPair(first / p.first, second / p.second); }
	/**
	 * FloatPairを座標と見て90度回転させる
	 * rotate(90)より精確
	 */
	public final FloatPair rotate(){ return new FloatPair(-second, first); }
	/**
	 * FloatPairを座標と見てang度回転させる
	 * @param ang
	 */
	public final FloatPair rotate(final int ang) {
		final double rad = Math.toRadians(Utility.mod(ang, 360));
		return FloatPair.of(first * Math.cos(rad) - second * Math.sin(rad), first * Math.sin(rad) + second * Math.cos(rad));
	}
	/**
	 * @param p
	 * @return ドット積
	 */
	public final double dot(final FloatPair p){ return first * p.first + second * p.second; }
	/**
	 * @param p
	 * @return クロス積
	 */
	public final double cross(final FloatPair p){ return rotate().dot(p); }
	/**
	 * @return FloatPairを座標と見て距離
	 */
	public final double sqr(){ return dot(this); }
	/**
	 * @return FloatPairの勾配
	 */
	public final double grad() { 
		try {
			return second / first;
		} catch(final ArithmeticException e) {
			e.printStackTrace();
		}
		throw new Error();
	}
	/**
	 * @return FloatPairのユークリッドノルム
	 */
	public final double abs(){ return Math.hypot(first, second); }
}