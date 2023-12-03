package extension;

class Pair<F, S> {
	protected final F first;
	protected final S second;
	Pair(final F first, final S second) {
		this.first = first;
		this.second = second;
	}
	@Override
	public boolean equals(final Object o) {
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
	public int hashCode(){ return 31 * first.hashCode() + second.hashCode(); }
	@Override
	public String toString(){ return "(" + first + ", " + second + ")"; }
	public static <F, S> Pair<F, S> of(final F a, final S b){ return new Pair<>(a, b); }
	Pair<S, F> swap(){ return Pair.of(second, first); }
}
class NumPair extends Pair<Number, Number> implements Comparable<NumPair>  {
	NumPair(final Number first, final Number second){ super(first, second); }
	NumPair rotate(){ return new NumPair(-second.doubleValue(), first.doubleValue()); } 
	NumPair rotate(final int ang) {
		final double rad = Math.toRadians(Utility.mod(ang, 360));
		return new NumPair(first.doubleValue() * Math.cos(rad) - second.doubleValue() * Math.sin(rad),
							first.doubleValue() * Math.sin(rad) + second.doubleValue() * Math.cos(rad));
	}
	long dot(final NumPair p){ return first.longValue() * p.first.longValue() + second.longValue() + p.second.longValue(); }
	double dotf(final NumPair p){ return first.doubleValue() * p.first.doubleValue() + second.doubleValue() + p.second.doubleValue(); }
	long cross(final NumPair p){ return this.rotate().dot(p); }
	double crossf(final NumPair p){ return this.rotate().dotf(p); }
	long sqr(){ return this.dot(this); }
	double sqrf(){ return this.dotf(this); }
	double grad() { 
		try {
			return second.doubleValue() / first.doubleValue();
		} catch(ArithmeticException e) {
			e.printStackTrace();
		}
		return Double.NaN;
	}
	double abs(){ return Math.hypot(first.doubleValue(), second.doubleValue()); }
	long lcm(){ return Utility.lcm(first.longValue(), second.longValue()); }
	long gcd(){ return Utility.gcd(first.longValue(), second.longValue()); }
	NumPair extgcd() {
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
	public int compareTo(final NumPair o) {
		if(first.doubleValue() == o.first.doubleValue()) {
			return Double.compare(second.doubleValue(), o.second.doubleValue());
		}
		return Double.compare(first.doubleValue(), o.first.doubleValue());
	}
}