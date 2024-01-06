package library.structure.pair;

import library.core.Utility;

public final class IntPair extends Pair<Long, Long> {
	public IntPair(final long first, final long second){ super(first, second); }
	public final IntPair add(final IntPair p){ return new IntPair(first + p.first, second + p.second); }
	public final IntPair sub(final IntPair p){ return new IntPair(first - p.first, second - p.second); }
	public final IntPair mul(final IntPair p){ return new IntPair(first * p.first, second * p.second); }
	public final IntPair div(final IntPair p){ return new IntPair(first / p.first, second / p.second); }
	public final IntPair mod(final IntPair p){ return new IntPair(first % p.first, second % p.second); }
	public final IntPair rotate(){ return new IntPair(-second, first); } 
	public final FloatPair rotate(final int ang) {
		final double rad = Math.toRadians(Utility.mod(ang, 360));
		return new FloatPair(first * Math.cos(rad) - second * Math.sin(rad), first * Math.sin(rad) + second * Math.cos(rad));
	}
	public final long dot(final IntPair p){ return first * p.first + second * p.second; }
	public final long cross(final IntPair p){ return rotate().dot(p); }
	public final long sqr(){ return dot(this); }
	public final double grad() { 
		try {
			return 1.0 * second / first;
		} catch(ArithmeticException e) {
			e.printStackTrace();
		}
		return Double.NaN;
	}
	public final double abs(){ return Math.hypot(first, second); }
	public final long lcm(){ return Utility.lcm(first, second); }
	public final long gcd(){ return Utility.gcd(first, second); }
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