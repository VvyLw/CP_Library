package library.math;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.function.BiFunction;

//N > 1e18
final class BigPrime {
	protected final int bsf(final long x){ return Long.numberOfTrailingZeros(x); }
	private final BigInteger gcd(BigInteger a, BigInteger b) {
		a = a.abs();
		b = b.abs();
		if(a.equals(BigInteger.ZERO)) {
			return b;
		}
		if(b.equals(BigInteger.ZERO)) {
			return a;
		}
		final int shift = bsf(a.or(b).longValue());
		a = a.shiftRight(bsf(a.longValue()));
		do {
			b = b.shiftRight(bsf(b.longValue()));
			if(a.compareTo(b) > 0) {
				final BigInteger tmp = b;
				b = a;
				a = tmp;
			}
			b = b.subtract(a);
		} while(b.compareTo(BigInteger.ZERO) > 0);
		return a.shiftLeft(shift);
	}
	final boolean isPrime(final BigInteger n) {
		if(n.compareTo(BigInteger.ONE) <= 0) {
			return false;
		}
		if(n.equals(BigInteger.TWO)) {
			return true;
		}
		if(n.and(BigInteger.ONE).equals(BigInteger.valueOf(0))) {
			return false;
		}
		BigInteger d = n.subtract(BigInteger.ONE);
		while(d.and(BigInteger.ONE).equals(BigInteger.valueOf(0))) {
			d = d.shiftRight(1);
		}
		final long[] sample = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37};
		for(final long a: sample) {
			if(n.compareTo(BigInteger.valueOf(a)) <= 0) {
				break;
			}
			BigInteger t = d;
			BigInteger y = BigInteger.valueOf(a).modPow(t, n);
			while(!t.equals(n.subtract(BigInteger.ONE)) && !y.equals(BigInteger.ONE) && !y.equals(n.subtract(BigInteger.ONE))) {
				y = y.multiply(y).mod(n);
				t = t.shiftLeft(1);
			}
			if(!y.equals(n.subtract(BigInteger.ONE)) && t.and(BigInteger.ONE).equals(BigInteger.ZERO)) {
				return false;
			}
		}
		return true;
	}
	private final BigInteger find(final BigInteger n) {
		if(isPrime(n)) {
			return n;
		}
		if(n.and(BigInteger.ONE).equals(BigInteger.ZERO)) {
			return BigInteger.TWO;
		}
		int st = 0;
		final BiFunction<BigInteger, Integer, BigInteger> f = (x, y) -> { return x.multiply(x).add(BigInteger.valueOf(y)).mod(n); };
		while(true) {
			st++;
			BigInteger x = BigInteger.valueOf(st), y = f.apply(x, st);
			while(true) {
				final BigInteger p = gcd(y.subtract(x).add(n), n);
				if(p.equals(BigInteger.ZERO) || p.equals(n)) {
					break;
				}
				if(!p.equals(BigInteger.ONE)) {
					return p;
				}
				x = f.apply(x, st);
				y = f.apply(f.apply(y, st), st);
			}
		}
	}
	final ArrayList<BigInteger> primeFactor(final BigInteger n) {
		if(n.equals(BigInteger.ONE)) {
			return new ArrayList<>();
		}
		final BigInteger x = find(n);
		if(x.equals(n)) {
			return new ArrayList<>(Arrays.asList(x));
		}
		final ArrayList<BigInteger> l = primeFactor(x), r = primeFactor(n.divide(x));
		l.addAll(r);
		Collections.sort(l);
		return l;
	}
}