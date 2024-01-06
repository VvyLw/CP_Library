package library.structure.pair;
import library.core.Utility;

public final class FloatPair extends Pair<Double, Double> {
	FloatPair(final double first, final double second){ super(first, second); }
	public final FloatPair add(final FloatPair p){ return new FloatPair(first + p.first, second + p.second); }
	public final FloatPair sub(final FloatPair p){ return new FloatPair(first - p.first, second - p.second); }
	public final FloatPair mul(final FloatPair p){ return new FloatPair(first * p.first, second * p.second); }
	public final FloatPair div(final FloatPair p){ return new FloatPair(first / p.first, second / p.second); }
	public final FloatPair rotate(){ return new FloatPair(-second, first); } 
	public final FloatPair rotate(final int ang) {
		final double rad = Math.toRadians(Utility.mod(ang, 360));
		return new FloatPair(first * Math.cos(rad) - second * Math.sin(rad), first * Math.sin(rad) + second * Math.cos(rad));
	}
	public final double dot(final FloatPair p){ return first * p.first + second * p.second; }
	public final double cross(final FloatPair p){ return rotate().dot(p); }
	public final double sqr(){ return dot(this); }
	public final double grad() { 
		try {
			return second / first;
		} catch(ArithmeticException e) {
			e.printStackTrace();
		}
		return Double.NaN;
	}
	public final double abs(){ return Math.hypot(first, second); }
}