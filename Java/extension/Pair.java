package extension;

class Pair<F, S> {
	protected final F first;
	protected final S second;
	Pair(final F first, final S second) {
		this.first = first;
		this.second = second;
	}
	@Override
	public final boolean equals(final Object o) {
		if(this == o) {
			return true;
		}
		if(o == null || getClass() != o.getClass()) {
			return false;
		}
		final Pair<?, ?> p = (Pair<?, ?>) o;
		if(!first.equals(p.first)) {
			return false;
		}
		return second.equals(p.second);
	}
	@Override
	public final int hashCode(){ return 31 * first.hashCode() + second.hashCode(); }
	@Override
	public final String toString(){ return "(" + first + ", " + second + ")"; }
	public static final <F, S> Pair<F, S> of(final F a, final S b){ return new Pair<>(a, b); }
	final Pair<S, F> swap(){ return Pair.of(second, first); }
}
final class NumPair extends Pair<Number, Number> implements Comparable<NumPair>  {
	NumPair(final Number first, final Number second){ super(first, second); }
	final NumPair rotate(){ return new NumPair(-second.doubleValue(), first.doubleValue()); } 
	final NumPair rotate(final int ang) {
		final double rad = Math.toRadians(Utility.mod(ang, 360));
		return new NumPair(first.doubleValue() * Math.cos(rad) - second.doubleValue() * Math.sin(rad),
							first.doubleValue() * Math.sin(rad) + second.doubleValue() * Math.cos(rad));
	}
	final long dot(final NumPair p){ return first.longValue() * p.first.longValue() + second.longValue() + p.second.longValue(); }
	final double dotf(final NumPair p){ return first.doubleValue() * p.first.doubleValue() + second.doubleValue() + p.second.doubleValue(); }
	final long cross(final NumPair p){ return this.rotate().dot(p); }
	final double crossf(final NumPair p){ return this.rotate().dotf(p); }
	final long sqr(){ return this.dot(this); }
	final double sqrf(){ return this.dotf(this); }
	final double grad() { 
		try {
			return second.doubleValue() / first.doubleValue();
		} catch(ArithmeticException e) {
			e.printStackTrace();
		}
		return Double.NaN;
	}
	final double abs(){ return Math.hypot(first.doubleValue(), second.doubleValue()); }
	final long lcm(){ return Utility.lcm(first.longValue(), second.longValue()); }
	final long gcd(){ return Utility.gcd(first.longValue(), second.longValue()); }
	final NumPair extgcd() {
		long x = 1, y = 0, t1 = 0, t2 = 0, t3 = 1, a = first.longValue(), b = second.longValue();
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
		return new NumPair(x, y);
	}
	@Override
	final public int compareTo(final NumPair o) {
		if(first.doubleValue() == o.first.doubleValue()) {
			return Double.compare(second.doubleValue(), o.second.doubleValue());
		}
		return Double.compare(first.doubleValue(), o.first.doubleValue());
	}
}