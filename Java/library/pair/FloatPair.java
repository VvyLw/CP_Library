package library.pair;
import library.core.Utility;

public final class FloatPair extends Pair<Double, Double> {
	FloatPair(final double first, final double second){ super(first, second); }
	final FloatPair add(final FloatPair p){ return new FloatPair(first + p.first, second + p.second); }
	final FloatPair sub(final FloatPair p){ return new FloatPair(first - p.first, second - p.second); }
	final FloatPair mul(final FloatPair p){ return new FloatPair(first * p.first, second * p.second); }
	final FloatPair div(final FloatPair p){ return new FloatPair(first / p.first, second / p.second); }
	final FloatPair rotate(){ return new FloatPair(-second, first); } 
	final FloatPair rotate(final int ang) {
		final double rad = Math.toRadians(Utility.mod(ang, 360));
		return new FloatPair(first * Math.cos(rad) - second * Math.sin(rad), first * Math.sin(rad) + second * Math.cos(rad));
	}
	final double dot(final FloatPair p){ return first * p.first + second * p.second; }
	final double cross(final FloatPair p){ return rotate().dot(p); }
	final double sqr(){ return dot(this); }
	final double grad() { 
		try {
			return second / first;
		} catch(ArithmeticException e) {
			e.printStackTrace();
		}
		return Double.NaN;
	}
	final double abs(){ return Math.hypot(first, second); }
}