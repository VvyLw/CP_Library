import static java.lang.Math.*;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;
import java.util.function.LongPredicate;
import java.util.function.LongUnaryOperator;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class Main {
	public static void main(final String[] args) {
		final long begin = System.currentTimeMillis(), end;
		IntStream.range(0, VvyLw.MULTI ? VvyLw.io.ni() : 1).mapToObj(VvyLw::solve).filter(Objects::nonNull).forEach(VvyLw.io::out);
		end = System.currentTimeMillis();
		VvyLw.io.dump(end - begin + "ms");
		VvyLw.io.close();
	}
}

final class VvyLw extends Utility {
	static final IO io = new IO(System.in, System.out, System.err, false);
	static final Random rd = new Random();
	static final boolean MULTI = true;
	static final int INF = 1 << 30;
	static final long LINF = (1L << 61) - 1;
	static final double EPS = 1e-18;
	static final int MOD = 998244353;
	static final int M0D = (int) 1e9 + 7;
	static final int[] dx = {0, -1, 1, 0, 0, -1, -1, 1, 1};
	static final int[] dy = {0, 0, 0, -1, 1, -1, 1, -1, 1};
	static final Object solve(final int Huitloxopetl) {
		
		return null;
	}
}
class Utility {
	protected static final String yes(final boolean ok){ return ok ? "Yes" : "No"; }
	protected static final String no(final boolean ok){ return yes(!ok); }
	protected static final long sqr(final long x){ return x * x; }
	protected static final long cub(final long x){ return x * x * x; }
	protected static final int mod(long n, final int m) {
		n %= m;
		return (int) (n < 0 ? n + m : n);
	}
	protected static final long mod(long n, final long m) {
		n %= m;
		return n < 0 ? n + m : n;
	}
	protected static final double log(final double x, final long base){ return Math.log(x) / Math.log(base); }
	protected static final long intCeil(final long a, final long b){ return a == 0 ? 0 : (a - 1) / b + 1; }
	protected static final double intRound(final double a, final long b, final int c) {
		final long d = powi(10, c);
		return rint((a * d) / b) / d;
	}
	protected static final long powi(long a, int b) {
		long res = 1;
		while(b > 0) {
			if(b % 2 == 1) {
				res *= a;
			}
			a *= a;
			b >>= 1;
		}
		return res;
	}
	protected static final long modPow(long a, long b, final long m) {
		long res = 1;
		while(b > 0) {
			if(b % 2 == 1) {
				res *= a;
				res = mod(res, m);
			}
			a *= a;
			a = mod(a, m);
			b >>= 1;
		}
		return res;
	}
	protected static final long inv(long a, final long m) {
		long b = m, u = 1, v = 0;
		while(b > 0) {
			final long t = a / b;
			a -= t * b;
			a ^= b;
			b ^= a;
			a ^= b;
			u -= t * v;
			u ^= v;
			v ^= u;
			u ^= v;
		}
		return mod(u, m);
	}
	protected static final long lcm(final long a, final long b){ return a / gcd(a, b) * b; }
	protected static final long lcm(final int... a){ return Arrays.stream(a).asLongStream().reduce(1, (x, y) -> lcm(x, y)); }
	protected static final long lcm(final long... a){ return Arrays.stream(a).reduce(1, (x, y) -> lcm(x, y)); }
	protected static final long gcd(final long a, final long b){ return b > 0 ? gcd(b, a % b) : a; }
	protected static final int gcd(final int... a){ return Arrays.stream(a).reduce(0, (x, y) -> (int) gcd(x, y)); }
	protected static final long gcd(final long... a){ return Arrays.stream(a).reduce(0, (x, y) -> gcd(x, y)); }
	protected static final int min(final int... a){ return Arrays.stream(a).min().getAsInt(); }
	protected static final long min(final long... a){ return Arrays.stream(a).min().getAsLong(); }
	protected static final double min(final double... a){ return Arrays.stream(a).min().getAsDouble(); }
	protected static final int max(final int... a){ return Arrays.stream(a).max().getAsInt(); }
	protected static final long max(final long... a){ return Arrays.stream(a).max().getAsLong(); }
	protected static final double max(final double... a){ return Arrays.stream(a).max().getAsDouble(); }
	protected static final long sum(final int... a){ return Arrays.stream(a).asLongStream().sum(); }
	protected static final long sum(final long... a){ return Arrays.stream(a).sum(); }
	protected static final double sum(final double... a){ return Arrays.stream(a).sum(); }
	protected static final long prod(final int... a){ return Arrays.stream(a).asLongStream().reduce(1, (x, y) -> x * y); }
	protected static final long prod(final long... a){ return Arrays.stream(a).reduce(1, (x, y) -> x * y); }
	protected static final double prod(final double... a){ return Arrays.stream(a).reduce(1, (x, y) -> x * y); }
	protected static final double ave(final int... a){ return Arrays.stream(a).average().getAsDouble(); }
	protected static final double ave(final long... a){ return Arrays.stream(a).average().getAsDouble(); }
	protected static final double ave(final double... a){ return Arrays.stream(a).average().getAsDouble(); }
	protected static final double median(final int[] a) {
		assert isSorted(a);
		final int m = a.length / 2;
		return a.length % 2 != 0 ? a[m] : (a[m - 1] + a[m]) / 2.0;
	}
	protected static final double median(final long[] a) {
		assert isSorted(a);
		final int m = a.length / 2;
		return a.length % 2 != 0 ? a[m] : (a[m - 1] + a[m]) / 2.0;
	}
	protected static final double median(final double[] a) {
		assert isSorted(a);
		final int m = a.length / 2;
		return a.length % 2 != 0 ? a[m] : (a[m - 1] + a[m]) / 2;
	}
	protected static final long[] div(final long n) {
		final ArrayList<Long> d = new ArrayList<>();
		for(long i = 1; i * i <= n; ++i) {
			if(n % i == 0) {
				d.add(i);
				if(i * i != n) {
					d.add(n / i);
				}
			}
		}
		return d.stream().mapToLong(i -> i).sorted().toArray();
	}
	protected static final IntPair[] primeFactor(long n) {
		final ArrayList<IntPair> pf = new ArrayList<>();
		for(long i = 2; i * i <= n; ++i) {
			if(n % i != 0) {
				continue;
			}
			int cnt = 0;
			while(n % i == 0) {
				cnt++;
				n /= i;
			}
			pf.add(IntPair.of(i, cnt));
		}
		if(n != 1) {
			pf.add(IntPair.of(n, 1));
		}
		return pf.toArray(IntPair[]::new);
	}
	protected static final long eulerPhi(long n) {
		long res = n;
		for(long i = 2; i * i <= n; ++i) {
			if(n % i == 0) {
				res -= res / i;
				while(n % i == 0) {
					n /= i;
				}
			}
		}
		if(n > 1) {
			res -= res / n;
		}
		return res;
	}
	protected static final long sigma(final long n){ return n * (n + 1) / 2; }
	protected static final long sigma(final long a, final long b) {
		assert a <= b;
		return sigma(b) - sigma(a - 1);
	}
	protected static final long fact(int n) {
		long res = 1;
		while(n > 0) {
			res *= n--;
		}
		return res;
	}
	protected static final long fact(int n, final long mod) {
		long res = 1;
		while(n > 0) {
			res *= n--;
			res %= mod;
		}
		return res;
	}
	protected static final long perm(final int n, final int r) {
		int m = n;
		long res = 1;
		while(m > n - r) {
			res *= m--;
		}
		return res;
	}
	protected static final long perm(final int n, final int r, final long mod) {
		int m = n;
		long res = 1;
		while(m > n - r) {
			res *= m--;
			res %= mod; 
		}
		return res;
	}
	protected static final long binom(final int n, final int r) {
		if(r < 0 || n < r) {
			return 0;
		}
		int tmp = n;
		long res = 1;
		for(int i = 1; i <= min(n - r, r); ++i) {
			res *= tmp--;
			res /= i;
		}
		return res;
	}
	protected static final long binom(final int n, final int r, final long mod) {
		if(r < 0 || n < r) {
			return 0;
		}
		int tmp = n;
		long res = 1;
		for(int i = 1; i <= min(n - r, r); ++i) {
			res *= tmp--;
			res %= mod;
			res /= i;
			res %= mod;
		}
		return res;
	}
	protected static final boolean isInt(final double n){ return n == (long) floor(n); }
	protected static final boolean isSqr(final long n){ return isInt(sqrt(n)); }
	protected static final boolean isPrime(final long n) {
		if(n == 1) {
			return false;
		}
		for(long i = 2; i * i <= n; ++i) {
			if(n % i == 0) {
				return false;
			}
		}
		return true;
	}
	protected static final boolean scope(final int l, final int x, final int r){ return l <= x && x <= r; }
	protected static final boolean scope(final long l, final long x, final long r){ return l <= x && x <= r; }
	protected static final boolean scope(final double l, final double x, final double r){ return l <= x && x <= r; }
	protected static final boolean isBit(final long i, final long j){ return (i >> j & 1) == 1; }
	protected static final boolean nextPerm(final int[] a) {
		try {
			final int[] res = nextPermutation(a);
			System.arraycopy(res, 0, a, 0, a.length);
			return true;
		} catch(final NullPointerException e) {
			Arrays.sort(a);
			return false;
		}
	}
	protected static final boolean nextPerm(final long[] a) {
		try {
			final long[] res = nextPermutation(a);
			System.arraycopy(res, 0, a, 0, a.length);
			return true;
		} catch(final NullPointerException e) {
			Arrays.sort(a);
			return false;
		}
	}
	protected static final boolean nextPerm(final double[] a) {
		try {
			final double[] res = nextPermutation(a);
			System.arraycopy(res, 0, a, 0, a.length);
			return true;
		} catch(final NullPointerException e) {
			Arrays.sort(a);
			return false;
		}
	}
	protected static final boolean nextPerm(final char[] a) {
		try {
			final char[] res = nextPermutation(a);
			System.arraycopy(res, 0, a, 0, a.length);
			return true;
		} catch(final NullPointerException e) {
			Arrays.sort(a);
			return false;
		}
	}
	protected static final boolean prevPerm(final int[] a) {
		try {
			final int[] res = prevPermutation(a);
			System.arraycopy(res, 0, a, 0, a.length);
			return true;
		} catch(final NullPointerException e) {
			final int[] res = reverse(sorted(a));
			System.arraycopy(res, 0, a, 0, a.length);
			return false;
		}
	}
	protected static final boolean prevPerm(final long[] a) {
		try {
			final long[] res = prevPermutation(a);
			System.arraycopy(res, 0, a, 0, a.length);
			return true;
		} catch(final NullPointerException e) {
			final long[] res = reverse(sorted(a));
			System.arraycopy(res, 0, a, 0, a.length);
			return false;
		}
	}
	protected static final boolean prevPerm(final double[] a) {
		try {
			final double[] res = prevPermutation(a);
			System.arraycopy(res, 0, a, 0, a.length);
			return true;
		} catch(final NullPointerException e) {
			final double[] res = reverse(sorted(a));
			System.arraycopy(res, 0, a, 0, a.length);
			return false;
		}
	}
	protected static final boolean prevPerm(final char[] a) {
		try {
			final char[] res = prevPermutation(a);
			System.arraycopy(res, 0, a, 0, a.length);
			return true;
		} catch(final NullPointerException e) {
			final char[] res = reverse(sorted(a));
			System.arraycopy(res, 0, a, 0, a.length);
			return false;
		}
	}
	private static final int[] nextPermutation(final int[] a) {
		for(int i = a.length; --i > 0;) {
			if(a[i - 1] < a[i]) {
				final int j = find(a[i - 1], a, i, a.length - 1);
				swap(a, i - 1, j);
				Arrays.sort(a, i, a.length);
				return a;
			}
		}
		return null;
	}
	private static final long[] nextPermutation(final long[] a) {
		for(int i = a.length; --i > 0;) {
			if(a[i - 1] < a[i]) {
				final int j = find(a[i - 1], a, i, a.length - 1);
				swap(a, i - 1, j);
				Arrays.sort(a, i, a.length);
				return a;
			}
		}
		return null;
	}
	private static final double[] nextPermutation(final double[] a) {
		for(int i = a.length; --i > 0;) {
			if(a[i - 1] < a[i]) {
				final int j = find(a[i - 1], a, i, a.length - 1);
				swap(a, i - 1, j);
				Arrays.sort(a, i, a.length);
				return a;
			}
		}
		return null;
	}
	private static final char[] nextPermutation(final char[] a) {
		for(int i = a.length; --i > 0;) {
			if(a[i - 1] < a[i]) {
				final int j = find(a[i - 1], a, i, a.length - 1);
				swap(a, i - 1, j);
				Arrays.sort(a, i, a.length);
				return a;
			}
		}
		return null;
	}
	private static final int[] prevPermutation(final int[] a) {
		for(int i = a.length; --i > 0;) {
			if(a[i - 1] > a[i]) {
				final int j = findRev(a[i - 1], a, i, a.length - 1);
				swap(a, i - 1, j);
				Arrays.sort(a, i, a.length);
				reverse(a, i, a.length - 1);
				return a;
			}
		}
		return null;
	}
	private static final long[] prevPermutation(final long[] a) {
		for(int i = a.length; --i > 0;) {
			if(a[i - 1] > a[i]) {
				final int j = findRev(a[i - 1], a, i, a.length - 1);
				swap(a, i - 1, j);
				Arrays.sort(a, i, a.length);
				reverse(a, i, a.length - 1);
				return a;
			}
		}
		return null;
	}
	private static final double[] prevPermutation(final double[] a) {
		for(int i = a.length; --i > 0;) {
			if(a[i - 1] > a[i]) {
				final int j = findRev(a[i - 1], a, i, a.length - 1);
				swap(a, i - 1, j);
				Arrays.sort(a, i, a.length);
				reverse(a, i, a.length - 1);
				return a;
			}
		}
		return null;
	}
	private static final char[] prevPermutation(final char[] a) {
		for(int i = a.length; --i > 0;) {
			if(a[i - 1] > a[i]) {
				final int j = findRev(a[i - 1], a, i, a.length - 1);
				swap(a, i - 1, j);
				Arrays.sort(a, i, a.length);
				reverse(a, i, a.length - 1);
				return a;
			}
		}
		return null;
	}
	private static final int find(final int dest, final int[] a, final int s, final int e) {
		if(s == e) {
			return s;
		}
		final int m = (s + e + 1) / 2;
		return a[m] <= dest ? find(dest, a, s, m - 1) : find(dest, a, m, e);
	}
	private static final int find(final long dest, final long[] a, final int s, final int e) {
		if(s == e) {
			return s;
		}
		final int m = (s + e + 1) / 2;
		return a[m] <= dest ? find(dest, a, s, m - 1) : find(dest, a, m, e);
	}
	private static final int find(final double dest, final double[] a, final int s, final int e) {
		if(s == e) {
			return s;
		}
		final int m = (s + e + 1) / 2;
		return a[m] <= dest ? find(dest, a, s, m - 1) : find(dest, a, m, e);
	}
	private static final int find(final char dest, final char[] a, final int s, final int e) {
		if(s == e) {
			return s;
		}
		final int m = (s + e + 1) / 2;
		return a[m] <= dest ? find(dest, a, s, m - 1) : find(dest, a, m, e);
	}
	private static final int findRev(final int dest, final int[] a, final int s, final int e) {
		if(s == e) {
			return s;
		}
		final int m = (s + e + 1) / 2;
		return a[m] > dest ? findRev(dest, a, s, m - 1) : findRev(dest, a, m, e);
	}
	private static final int findRev(final long dest, final long[] a, final int s, final int e) {
		if(s == e) {
			return s;
		}
		final int m = (s + e + 1) / 2;
		return a[m] > dest ? findRev(dest, a, s, m - 1) : findRev(dest, a, m, e);
	}
	private static final int findRev(final double dest, final double[] a, final int s, final int e) {
		if(s == e) {
			return s;
		}
		final int m = (s + e + 1) / 2;
		return a[m] > dest ? findRev(dest, a, s, m - 1) : findRev(dest, a, m, e);
	}
	private static final int findRev(final char dest, final char[] a, final int s, final int e) {
		if(s == e) {
			return s;
		}
		final int m = (s + e + 1) / 2;
		return a[m] > dest ? findRev(dest, a, s, m - 1) : findRev(dest, a, m, e);
	}
	private static void reverse(final int[] arr, int start, int end) {
		while(start < end) {
			swap(arr, start, end);
			start++;
			end--;
		}
	}
	private static void reverse(final long[] arr, int start, int end) {
		while(start < end) {
			swap(arr, start, end);
			start++;
			end--;
		}
	}
	private static void reverse(final double[] arr, int start, int end) {
		while(start < end) {
			swap(arr, start, end);
			start++;
			end--;
		}
	}
	private static void reverse(final char[] arr, int start, int end) {
		while(start < end) {
			swap(arr, start, end);
			start++;
			end--;
		}
	}
	protected static final int find(final int[] a, final int x) {
		for(int i = 0; i < a.length; ++i) {
			if(a[i] == x) {
				return i;
			}
		}
		return -1;
	}
	protected static final int find(final long[] a, final long x) {
		for(int i = 0; i < a.length; ++i) {
			if(a[i] == x) {
				return i;
			}
		}
		return -1;
	}
	protected static final int find(final double[] a, final double x) {
		for(int i = 0; i < a.length; ++i) {
			if(a[i] == x) {
				return i;
			}
		}
		return -1;
	}
	protected static final int find(final char[] s, final char c) {
		for(int i = 0; i < s.length; ++i) {
			if(s[i] == c) {
				return i;
			}
		}
		return -1;
	}
	protected static final int find(final Object[] a, final Object x) {
		for(int i = 0; i < a.length; ++i) {
			if(a[i].equals(x)) {
				return i;
			}
		}
		return -1;
	}
	protected static final int findRev(final int[] a, final int x) {
		for(int i = a.length; --i >= 0;) {
			if(a[i] == x) {
				return i;
			}
		}
		return -1;
	}
	protected static final int findRev(final long[] a, final long x) {
		for(int i = a.length; --i >= 0;) {
			if(a[i] == x) {
				return i;
			}
		}
		return -1;
	}
	protected static final int findRev(final double[] a, final double x) {
		for(int i = a.length; --i >= 0;) {
			if(a[i] == x) {
				return i;
			}
		}
		return -1;
	}
	protected static final int findRev(final char[] s, final char c) {
		for(int i = s.length; --i >= 0;) {
			if(s[i] == c) {
				return i;
			}
		}
		return -1;
	}
	protected static final int findRev(final Object[] a, final Object x) {
		for(int i = a.length; --i >= 0;) {
			if(a[i].equals(x)) {
				return i;
			}
		}
		return -1;
	}
	protected static final boolean binarySearch(final int[] a, final int x){ return Arrays.binarySearch(a, x) >= 0; }
	protected static final boolean binarySearch(final long[] a, final long x){ return Arrays.binarySearch(a, x) >= 0; }
	protected static final <T extends Comparable<? super T>> boolean binarySearch(final T[] a, final T x){ return Arrays.binarySearch(a, x) >= 0; }
	protected static final <T extends Comparable<? super T>> boolean binarySearch(final List<T> a, final T x){ return Collections.binarySearch(a, x, null) >= 0; }
	protected static final int lowerBound(final int[] a, final int x){ return bins(a.length, -1, (IntPredicate) y -> a[y] >= x); }
	protected static final int lowerBound(final long[] a, final long x){ return bins(a.length, -1, (IntPredicate) y -> a[y] >= x); }
	protected static final <T extends Comparable<? super T>> int lowerBound(final T[] a, final T x){ return lowerBound(Arrays.asList(a), x); }
	protected static final <T extends Comparable<? super T>> int lowerBound(final List<T> a, final T x){ return ~Collections.binarySearch(a, x, (p, q) -> p.compareTo(q) >= 0 ? 1 : -1); }
	protected static final int upperBound(final int[] a, final int x){ return bins(a.length, -1, (IntPredicate) y -> a[y] > x); }
	protected static final int upperBound(final long[] a, final long x){ return bins(a.length, -1, (IntPredicate) y -> a[y] > x); }
	protected static final <T extends Comparable<? super T>> int upperBound(final T[] a, final T x){ return upperBound(Arrays.asList(a), x); }
	protected static final <T extends Comparable<? super T>> int upperBound(final List<T> a, final T x){ return ~Collections.binarySearch(a, x, (p, q) -> p.compareTo(q) > 0 ? 1 : -1); }
	protected static final String sorted(final String s){ return s.chars().sorted().mapToObj(Character::toString).collect(Collectors.joining()); }
	protected static final int[] sorted(final int[] a){ return Arrays.stream(a).sorted().toArray(); }
	protected static final long[] sorted(final long[] a){ return Arrays.stream(a).sorted().toArray(); }
	protected static final double[] sorted(final double[] a){ return Arrays.stream(a).sorted().toArray(); }
	protected static final char[] sorted(final char[] a){ return sorted(new String(a)).toCharArray(); }
	protected static final <T extends Comparable<? super T>> T[] sorted(final T[] a){ return Arrays.stream(a).sorted().toArray(n -> Arrays.copyOf(a, n)); }
	protected static final boolean isSorted(final String s){ return s.equals(sorted(s)); }
	protected static final boolean isSorted(final int[] a){ return Arrays.equals(a, sorted(a)); }
	protected static final boolean isSorted(final long[] a){ return Arrays.equals(a, sorted(a)); }
	protected static final boolean isSorted(final double[] a){ return Arrays.equals(a, sorted(a)); }
	protected static final boolean isSorted(final char[] a){ return Arrays.equals(a, sorted(a)); }
	protected static final <T extends Comparable<? super T>> boolean isSorted(final T[] a){ return Arrays.equals(a, sorted(a)); }
	protected static final String reverse(final String s){ return new StringBuilder(s).reverse().toString(); }
	protected static final int[] reverse(final int[] a) {
		final int n = a.length;
		final int[] b = new int[n];
		for(int i = 0; i <= n / 2; ++i) {
			b[i] = a[n - 1 - i];
			b[n - 1 - i] = a[i];
		}
		return b;
	}
	protected static final long[] reverse(final long[] a) {
		final int n = a.length;
		final long[] b = new long[n];
		for(int i = 0; i <= n / 2; ++i) {
			b[i] = a[n - 1 - i];
			b[n - 1 - i] = a[i];
		}
		return b;
	}
	protected static final double[] reverse(final double[] a) {
		final int n = a.length;
		final double[] b = new double[n];
		for(int i = 0; i <= n / 2; ++i) {
			b[i] = a[n - 1 - i];
			b[n - 1 - i] = a[i];
		}
		return b;
	}
	protected static final char[] reverse(final char[] a) {
		final int n = a.length;
		final char[] b = new char[n];
		for(int i = 0; i <= n / 2; ++i) {
			b[i] = a[n - 1 - i];
			b[n - 1 - i] = a[i];
		}
		return b;
	}
	protected static final Object[] reverse(final Object[] a) {
		final int n = a.length;
		final Object[] b = new Object[n];
		for(int i = 0; i <= n / 2; ++i) {
			b[i] = a[n - 1 - i];
			b[n - 1 - i] = a[i];
		}
		return b;
	}
	protected static final int[] rotate(final int[] a, final int id) {
		final int n = a.length, k = (int) mod(id, n);
		final int[] res = new int[n];
		System.arraycopy(a, k, res, 0, n - k);
		System.arraycopy(a, 0, res, n - k, k);
		return res;
	}
	protected static final long[] rotate(final long[] a, final int id) {
		final int n = a.length, k = (int) mod(id, n);
		final long[] res = new long[n];
		System.arraycopy(a, k, res, 0, n - k);
		System.arraycopy(a, 0, res, n - k, k);
		return res;
	}
	protected static final double[] rotate(final double[] a, final int id) {
		final int n = a.length, k = (int) mod(id, n);
		final double[] res = new double[n];
		System.arraycopy(a, k, res, 0, n - k);
		System.arraycopy(a, 0, res, n - k, k);
		return res;
	}
	protected static final char[] rotate(final char[] a, final int id) {
		final int n = a.length, k = (int) mod(id, n);
		final char[] res = new char[n];
		System.arraycopy(a, k, res, 0, n - k);
		System.arraycopy(a, 0, res, n - k, k);
		return res;
	}
	protected static final boolean[] rotate(final boolean[] a, final int id) {
		final int n = a.length, k = (int) mod(id, n);
		final boolean[] res = new boolean[n];
		System.arraycopy(a, k, res, 0, n - k);
		System.arraycopy(a, 0, res, n - k, k);
		return res;
	}
	protected static final Object[] rotate(final Object[] a, final int id) {
		final int n = a.length, k = (int) mod(id, n);
		final Object[] res = new Object[n];
		System.arraycopy(a, k, res, 0, n - k);
		System.arraycopy(a, 0, res, n - k, k);
		return res;
	}
	protected static final String rotate(final String s, final int id) {
		final List<Character> t = s.chars().mapToObj(i -> (char) i).collect(Collectors.toList());
		Collections.rotate(t, id);
		return t.stream().map(String::valueOf).collect(Collectors.joining());
	}
	protected static final int[][] rotateR(final int[][] a) {
		final int h = a.length, w = a[0].length;
		final int[][] b = new int[w][h];
		IntStream.range(0, h).forEach(i -> {
			Arrays.setAll(b[i], j -> a[j][i]);
		});
		IntStream.range(0, w).forEach(i -> b[i] = reverse(b[i]));
		return b;
	}
	protected static final long[][] rotateR(final long[][] a) {
		final int h = a.length, w = a[0].length;
		final long[][] b = new long[w][h];
		IntStream.range(0, h).forEach(i -> {
			Arrays.setAll(b[i], j -> a[j][i]);
		});
		IntStream.range(0, w).forEach(i -> b[i] = reverse(b[i]));
		return b;
	}
	protected static final double[][] rotateR(final double[][] a) {
		final int h = a.length, w = a[0].length;
		final double[][] b = new double[w][h];
		IntStream.range(0, h).forEach(i -> {
			Arrays.setAll(b[i], j -> a[j][i]);
		});
		IntStream.range(0, w).forEach(i -> b[i] = reverse(b[i]));
		return b;
	}
	protected static final char[][] rotateR(final char[][] a) {
		final int h = a.length, w = a[0].length;
		final char[][] b = new char[w][h];
		IntStream.range(0, h).forEach(i -> {
			IntStream.range(0, w).forEach(j -> b[j][i] = a[i][j]);
		});
		IntStream.range(0, w).forEach(i -> b[i] = reverse(b[i]));
		return b;
	}
	protected static final int[][] rotateL(final int[][] a) {
		final int h = a.length, w = a[0].length;
		final int[][] b = new int[w][h];
		IntStream.range(0, h).forEach(i -> {
			Arrays.setAll(b[i], j -> a[j][w - i - 1]);
		});
		return b;
	}
	protected static final long[][] rotateL(final long[][] a) {
		final int h = a.length, w = a[0].length;
		final long[][] b = new long[w][h];
		IntStream.range(0, h).forEach(i -> {
			Arrays.setAll(b[i], j -> a[j][w - i - 1]);
		});
		return b;
	}
	protected static final double[][] rotateL(final double[][] a) {
		final int h = a.length, w = a[0].length;
		final double[][] b = new double[w][h];
		IntStream.range(0, h).forEach(i -> {
			Arrays.setAll(b[i], j -> a[j][w - i - 1]);
		});
		return b;
	}
	protected static final char[][] rotateL(final char[][] a) {
		final int h = a.length, w = a[0].length;
		final char[][] b = new char[w][h];
		IntStream.range(0, h).forEach(i -> {
			IntStream.range(0, w).forEach(j -> b[w - j - 1][i] = a[i][j]);
		});
		return b;
	}
	protected static final void swap(final int[] a, final int i, final int j) {
		a[i] ^= a[j];
		a[j] ^= a[i];
		a[i] ^= a[j];
	}
	protected static final void swap(final long[] a, final int i, final int j) {
		a[i] ^= a[j];
		a[j] ^= a[i];
		a[i] ^= a[j];
	}
	protected static final void swap(final double[] a, final int i, final int j) {
		final double tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
	protected static final void swap(final char[] a, final int i, final int j) {
		a[i] ^= a[j];
		a[j] ^= a[i];
		a[i] ^= a[j];
	}
	protected static final void swap(final boolean[] a, final int i, final int j) {
		a[i] ^= a[j];
		a[j] ^= a[i];
		a[i] ^= a[j];
	}
	protected static final void swap(final Object[] a, final int i, final int j) {
		final Object tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
	protected static final void swap(final int[] a, final int[] b) {
		assert a.length == b.length;
		final int n = a.length;
		final int[] c = a.clone();
		System.arraycopy(b, 0, a, 0, n);
		System.arraycopy(c, 0, b, 0, n);
	}
	protected static final void swap(final long[] a, final long[] b) {
		assert a.length == b.length;
		final int n = a.length;
		final long[] c = a.clone();
		System.arraycopy(b, 0, a, 0, n);
		System.arraycopy(c, 0, b, 0, n);
	}
	protected static final void swap(final double[] a, final double[] b) {
		assert a.length == b.length;
		final int n = a.length;
		final double[] c = a.clone();
		System.arraycopy(b, 0, a, 0, n);
		System.arraycopy(c, 0, b, 0, n);
	}
	protected static final void swap(final char[] a, final char[] b) {
		assert a.length == b.length;
		final int n = a.length;
		final char[] c = a.clone();
		System.arraycopy(b, 0, a, 0, n);
		System.arraycopy(c, 0, b, 0, n);
	}
	protected static final void swap(final boolean[] a, final boolean[] b) {
		assert a.length == b.length;
		final int n = a.length;
		final boolean[] c = a.clone();
		System.arraycopy(b, 0, a, 0, n);
		System.arraycopy(c, 0, b, 0, n);
	}
	protected static final void swap(final Object[] a, final Object[] b) {
		assert a.length == b.length;
		final int n = a.length;
		final Object[] c = a.clone();
		System.arraycopy(b, 0, a, 0, n);
		System.arraycopy(c, 0, b, 0, n);
	}
	protected static final <F extends Comparable<? super F>, S extends Comparable<? super S>> Pair<S, F>[] swap(final Pair<F, S>[] p) {
		@SuppressWarnings("unchecked")
		final Pair<S, F>[] q = new Pair[p.length];
		Arrays.setAll(q, i -> p[i].swap());
		return q;
	}
	protected static final IntPair[] swap(final IntPair[] p) {
		final IntPair[] q = new IntPair[p.length];
		Arrays.setAll(q, i -> p[i].swap());
		return q;
	}
	protected static final FloatPair[] swap(final FloatPair[] p) {
		final FloatPair[] q = new FloatPair[p.length];
		Arrays.setAll(q, i -> p[i].swap());
		return q;
	}
	@SuppressWarnings("unchecked")
	protected static final <F extends Comparable<? super F>, S extends Comparable<? super S>> F[] first(final Pair<F, S>[] p){ return (F[]) Arrays.stream(p).map(i -> i.first).toArray(); }
	protected static final long[] first(final IntPair[] p){ return Arrays.stream(p).mapToLong(i -> i.first).toArray(); }
	protected static final double[] first(final FloatPair[] p){ return Arrays.stream(p).mapToDouble(i -> i.first).toArray(); }
	@SuppressWarnings("unchecked")
	protected static final <F extends Comparable<? super F>, S extends Comparable<? super S>> S[] second(final Pair<F, S>[] p){ return (S[]) Arrays.stream(p).map(i -> i.second).toArray(); }
	protected static final long[] second(final IntPair[] p){ return Arrays.stream(p).mapToLong(i -> i.second).toArray(); }
	protected static final double[] second(final FloatPair[] p){ return Arrays.stream(p).mapToDouble(i -> i.second).toArray(); }
	protected static final IntStream iota(final int n){ return IntStream.range(0, n); }
	protected static final IntStream iota(final int n, final int init){ return IntStream.range(0 + init, n + init); }
	protected static final Integer[] boxed(final int[] a){ return Arrays.stream(a).boxed().toArray(Integer[]::new); }
	protected static final Long[] boxed(final long[] a){ return Arrays.stream(a).boxed().toArray(Long[]::new); }
	protected static final Double[] boxed(final double[] a){ return Arrays.stream(a).boxed().toArray(Double[]::new); }
	protected static final int bins(int ok, int ng, final IntPredicate fn) {
		while(abs(ok - ng) > 1) {
			final int mid = (ok + ng) / 2;
			if(fn.test(mid)) {
				ok = mid;
			}
			else {
				ng = mid;
			}
		}
		return ok;
	}
	protected static final long bins(long ok, long ng, final LongPredicate fn) {
		while(abs(ok - ng) > 1) {
			final long mid = (ok + ng) / 2;
			if(fn.test(mid)) {
				ok = mid;
			}
			else {
				ng = mid;
			}
		}
		return ok;
	}
	protected static final double bins(double ok, double ng, final DoublePredicate fn) {
		while(abs(ok - ng) > VvyLw.EPS) {
			final double mid = (ok + ng) / 2;
			if(fn.test(mid)) {
				ok = mid;
			}
			else {
				ng = mid;
			}
		}
		return ok;
	}
	protected static final Map<Integer, Integer> counter(final int[] a) {
		final Map<Integer, Integer> res = new HashMap<>();
		for(final int i: a) {
			res.merge(i, 1, (x, y) -> x + y);
		}
		return res;
	}
	protected static final Map<Long, Integer> counter(final long[] a) {
		final Map<Long, Integer> res = new HashMap<>();
		for(final long i: a) {
			res.merge(i, 1, (x, y) -> x + y);
		}
		return res;
	}
	protected static final long innerProd(final IntPair... p){ return iota(p.length).mapToLong(i -> p[i].first.longValue() * p[i].second.longValue()).sum(); }
	protected static final double innerProd(final FloatPair... p){ return iota(p.length).mapToDouble(i -> p[i].first.doubleValue() * p[i].second.doubleValue()).sum(); }
	protected static final FloatPair intersection(final IntPair a, final long sec1, final IntPair b, final long sec2) {
		double m1, m2, b1, b2;
		if(a.second.longValue() == 0 && b.second.longValue() == 0) {
			return null;
		} else if(a.second.longValue() == 0) {
			m2 = -b.first.doubleValue() / b.second.longValue();
			b2 = -sec2 / b.second.doubleValue();
			final double x = -sec1 / a.first.doubleValue(), y = b2 + m2 * x; 
			return FloatPair.of(x, y);
		} else if(b.second.longValue() == 0) {
			m1 = -a.first.doubleValue() / a.second.longValue();
			b1 = -sec1 / a.second.doubleValue();
			final double x = -sec2 / b.first.doubleValue(), y = b1 + m1 * x;
			return FloatPair.of(x, y);
		}
		m1 = -a.first.doubleValue() / a.second.longValue();
		m2 = -b.first.doubleValue() / b.second.longValue();
		b1 = -sec1 / a.second.doubleValue();
		b2 = -sec2 / b.second.doubleValue();
		assert m1 != m2;
		final double x = (b1 - b2) / (m2 - m1), y = m1 * x + b1;
		return FloatPair.of(x, y);
	}
	protected static final FloatPair intersection(final FloatPair a, final double sec1, final FloatPair b, final double sec2) {
		double m1, m2, b1, b2;
		if(a.second.doubleValue() == 0 && b.second.doubleValue() == 0) {
			return null;
		} else if(a.second.doubleValue() == 0) {
			m2 = -b.first.doubleValue() / b.second.doubleValue();
			b2 = -sec2 / b.second.doubleValue();
			final double x = -sec1 / a.first.doubleValue(), y = b2 + m2 * x; 
			return FloatPair.of(x, y);
		} else if(b.second.doubleValue() == 0) {
			m1 = -a.first.doubleValue() / a.second.doubleValue();
			b1 = -sec1 / a.second.doubleValue();
			final double x = -sec2 / b.first.doubleValue(), y = b1 + m1 * x;
			return FloatPair.of(x, y);
		}
		m1 = -a.first.doubleValue() / a.second.doubleValue();
		m2 = -b.first.doubleValue() / b.second.doubleValue();
		b1 = -sec1 / a.second.doubleValue();
		b2 = -sec2 / b.second.doubleValue();
		assert m1 != m2;
		final double x = (b1 - b2) / (m2 - m1), y = m1 * x + b1;
		return FloatPair.of(x, y);
	}
	protected static final int[] corPress(final int[] a) {
		final int[] res = new int[a.length];
		final int[] x = Arrays.stream(a).sorted().distinct().toArray();
		Arrays.setAll(res, i -> lowerBound(x, a[i]));
		return res;
	}
	protected static final int[] corPress(final long[] a) {
		final int[] res = new int[a.length];
		final long[] x = Arrays.stream(a).sorted().distinct().toArray();
		Arrays.setAll(res, i -> lowerBound(x, a[i]));
		return res;
	}
	protected static final String runLenPress(final String s) {
		final int n = s.length();
		final StringBuilder sb = new StringBuilder();
		for(int l = 0; l < n;) {
			int r = l + 1;
			for(; r < n && s.charAt(l) == s.charAt(r); ++r){}
			sb.append(s.charAt(l));
			sb.append(r - l);
			l = r;
		}
		return sb.toString();
	}
	protected static final String runLenRev(final String s) {
		final int n = s.length();
		final StringBuilder sb = new StringBuilder();
		for(int l = 0; l < n;) {
			int r = l + 1;
			for(; r < n && scope('0', s.charAt(r), '9'); ++r){}
			sb.append(String.valueOf(s.charAt(l)).repeat(Integer.parseInt(s.substring(l + 1, r))));
			l = r;
		}
		return sb.toString();
	}
	protected static final int[] zAlgorithm(final String s) {
		final int n = s.length();
		int j = 0;
		final int[] pre = new int[n];
		for(int i = 0; ++i < n;) {
			if(i + pre[i - j] < j + pre[j]) {
				pre[i] = pre[i - j];
			}
			else {
				int k = max(0, j + pre[j] - i);
				while(i + k < n && s.charAt(k) == s.charAt(i + k)) {
					++k;
				}
				pre[i] = k;
				j = i;
			}
		}
		pre[0] = n;
		return pre;
	}
	protected static final int[] manacher(final String s_, final boolean calcEven) {
		int n = s_.length();
		final char[] s;
		if(calcEven) {
			s = new char[2 * n - 1];
			IntStream.range(0, n).forEach(i -> s[i] = s_.charAt(i));
			for(int i = n; --i >= 0;) {
				s[2 * i] = s_.charAt(i);
			}
			final char d = Collections.min(s_.chars().mapToObj(c -> (char) c).collect(Collectors.toList()));
			for(int i = 0; i < n - 1; ++i) {
				s[2 * i + 1] = d;
			}
		} else {
			s = new char[n];
			IntStream.range(0, n).forEach(i -> s[i] = s_.charAt(i));
		}
		n = s.length;
		final int[] rad = new int[n];
		for(int i = 0, j = 0; i < n;) {
			while(i - j >= 0 && i + j < n && s[i - j] == s[i + j]) {
				++j;
			}
			rad[i] = j;
			int k = 1;
			while(i - k >= 0 && i + k < n && k + rad[i - k] < j) {
				rad[i + k] = rad[i - k];
				++k;
			}
			i += k;
			j -= k;
		}
		if(calcEven) {
			for(int i = 0; i < n; ++i) {
				if(((i ^ rad[i]) & 1) == 0) {
					rad[i]--;
				}
			}
		} else {
			for(int x: rad) {
				x = 2 * x - 1;
			}
		}
		return rad;
	}
	protected static final long kthRoot(final long n, final int k) {
		if(k == 1) {
			return n;
		}
		final LongPredicate chk = x -> {
			long mul = 1;
			for(int j = 0; j < k; ++j) {
				try {
					mul = multiplyExact(mul, x);
				} catch(final ArithmeticException e) {
					return false;
				}
			}
			return mul <= n;
		};
		long ret = 0;
		for(int i = 32; --i >= 0;) {
			if(chk.test(ret | (1L << i))) {
				ret |= 1L << i;
			}
		}
		return ret;
	}
	protected static final long tetration(final long a, final long b, final long m) {
		if(m == 1) {
			return 0;
		}
		if(a == 0) {
			return (b & 1) == 0 ? 1 : 0;
		}
		if(b == 0) {
			return 1;
		}
		if(b == 1) {
			return a % m;
		}
		if(b == 2) {
			return modPow(a, a, m);
		}
		final long phi = eulerPhi(m);
		long tmp = tetration(a, b - 1, phi);
		if(tmp == 0) {
			tmp += phi;
		}
		return modPow(a, tmp, m);
	}
	protected static final long floorSum(final long n, final long m, long a, long b) {
		long ans = 0;
		if(a >= m) {
			ans += (n - 1) * n * (a / m) / 2;
			a %= m;
		}
		if(b >= m) {
			ans += n * (b / m);
			b %= m;
		}
		final long ym = (a * n + b) / m, xm = (ym * m - b);
		if(ym == 0) {
			return ans;
		}
		ans += (n - (xm + a - 1) / a) * ym;
		ans += floorSum(ym, a, m, (a - xm % a) % a);
		return ans;
	}
}

interface TriFunction<T, U, V, R> {
	R apply(final T a, final U b, final V c);
}
interface QuadFunction<A, B, C, D, R> {
	R apply(final A a, final B b, final C c, final D d);
}
interface TriConsumer<T, U, V> {
	void accept(final T a, final U b, final V c);
}
interface TriPredicate<T, U, V> {
	boolean test(final T a, final U b, final V c);
}
interface RecursiveFunction<T, R> {
	R apply(final RecursiveFunction<T, R> rec, final T n);
}
interface RecursiveBiFunction<T, U, R> {
	R apply(final RecursiveBiFunction<T, U, R> rec, final T n, final U m);
}
interface RecursiveTriFunction<T, U, V, R> {
	R apply(final RecursiveTriFunction<T, U, V, R> rec, final T p, final U q, final V r);
}
interface RecursiveUnaryOperator<T> {
	T apply(final RecursiveUnaryOperator<T> rec, final T n);
}
interface RecursiveBinaryOperator<T> {
	T apply(final RecursiveBinaryOperator<T> rec, final T a, final T b);
}
interface RecursiveConsumer<T> {
	void accept(final RecursiveConsumer<T> rec, final T x);
}
interface RecursiveBiConsumer<T, U> {
	void accept(final RecursiveBiConsumer<T, U> rec, final T x, final U y);
}
interface RecursiveTriConsumer<T, U, V> {
	void accept(final RecursiveTriConsumer<T, U, V> rec, final T x, final U y, final V z);
}
interface RecursivePredicate<T> {
	boolean test(final RecursivePredicate<T> rec, final T n);
}
interface RecursiveBiPredicate<T, U> {
	boolean test(final RecursiveBiPredicate<T, U> rec, final T x, final U y);
}
interface RecursiveTriPredicate<T, U, V> {
	boolean test(final RecursiveTriPredicate<T, U, V> rec, final T x, final U y, final V z);
}
interface RecursiveIntFunction<R> {
	R apply(final RecursiveIntFunction<R> rec, final int n);
}
interface RecursiveLongFunction<R> {
	R apply(final RecursiveLongFunction<R> rec, final long n);
}
interface RecursiveDoubleFunction<R> {
	R apply(final RecursiveDoubleFunction<R> rec, final double n);
}
interface RecursiveIntUnaryOperator {
	int apply(final RecursiveIntUnaryOperator rec, final int n);
}
interface RecursiveLongUnaryOperator {
	long apply(final RecursiveLongUnaryOperator rec, final long n);
}
interface RecursiveDoubleUnaryOperator {
	double apply(final RecursiveDoubleUnaryOperator rec, final double n);
}
interface RecursiveIntBinaryOperator {
	int apply(final RecursiveIntBinaryOperator rec, final int a, final int b);
}
interface RecursiveLongBinaryOperator {
	long apply(final RecursiveLongBinaryOperator rec, final long a, final long b);
}
interface RecursiveDoubleBinaryOperator {
	double apply(final RecursiveDoubleBinaryOperator rec, final double a, final double b);
}
interface RecursiveIntConsumer {
	void accept(final RecursiveIntConsumer rec, final int n);
}
interface RecursiveLongConsumer {
	void accept(final RecursiveLongConsumer rec, final long n);
}
interface RecursiveDoubleConsumer {
	void accept(final RecursiveDoubleConsumer rec, final double n);
}
interface RecursiveIntPredicate {
	boolean test(final RecursiveIntPredicate rec, final int n);
}
interface RecursiveLongPredicate {
	boolean test(final RecursiveLongPredicate rec, final long n);
}
interface RecursiveDoublePredicate {
	boolean test(final RecursiveDoublePredicate rec, final double n);
}

final class IO implements Closeable, AutoCloseable {
	private final MyScanner in;
	private final MyPrinter out, err;
	IO(final InputStream in, final OutputStream out, final OutputStream err, final boolean autoFlush) {
		this.in = new MyScanner(in);
		this.out = new MyPrinter(out, autoFlush);
		this.err = new MyPrinter(err, true);
	}
	final int ni(){ return in.ni(); }
	final long nl(){ return in.nl(); }
	final double nd(){ return in.nd(); }
	final char nc(){ return in.nc(); }
	final String ns(){ return in.ns(); }
	final char[] nt(){ return in.nt(); }
	final BigInteger nb(){ return in.nb(); }
	final IntPair pi(){ return in.pi(); }
	final FloatPair pf(){ return in.pf(); }
	final int[] ni(final int n) {
		final int[] a = new int[n];
		Arrays.setAll(a, i -> ni());
		return a;
	}
	final int[] ni(final int n, final IntUnaryOperator f){ return Arrays.stream(ni(n)).map(f).toArray(); }
	final long[] nl(final int n) {
		final long[] a = new long[n];
		Arrays.setAll(a, i -> nl());
		return a;
	}
	final long[] nl(final int n, final LongUnaryOperator f){ return Arrays.stream(nl(n)).map(f).toArray(); }
	final double[] nd(final int n) {
		final double[] a = new double[n];
		Arrays.setAll(a, i -> nd());
		return a;
	}
	final char[] nc(final int n) {
		final char[] a = new char[n];
		IntStream.range(0, n).forEach(i -> a[i] = nc());
		return a;
	}
	final String[] ns(final int n) {
		final String[] a = new String[n];
		Arrays.setAll(a, i -> ns());
		return a;
	}
	final char[][] nt(final int n) {
		final char[][] a = new char[n][];
		Arrays.setAll(a, i -> nt());
		return a;
	}
	final BigInteger[] nb(final int n) {
		final BigInteger[] a = new BigInteger[n];
		Arrays.setAll(a, i -> nb());
		return a;
	}
	final IntPair[] pi(final int n) {
		final IntPair[] a = new IntPair[n];
		Arrays.setAll(a, i -> pi());
		return a;
	}
	final IntPair[] pi(final int n, final UnaryOperator<IntPair> f){ return Arrays.stream(pi(n)).map(f).toArray(IntPair[]::new); }
	final FloatPair[] pf(final int n) {
		final FloatPair[] a = new FloatPair[n];
		Arrays.setAll(a, i -> pf());
		return a;
	}
	final int[][] ni(final int h, final int w) {
		final int[][] a = new int[h][w];
		Arrays.setAll(a, i -> ni(w));
		return a;
	}
	final long[][] nl(final int h, final int w) {
		final long[][] a = new long[h][w];
		Arrays.setAll(a, i -> nl(w));
		return a;
	}
	final double[][] nd(final int h, final int w) {
		final double[][] a = new double[h][w];
		Arrays.setAll(a, i -> nd(w));
		return a;
	}
	final char[][] nc(final int h, final int w) {
		final char[][] a = new char[h][w];
		Arrays.setAll(a, i -> nc(w));
		return a;
	}
	final String[][] ns(final int h, final int w) {
		final String[][] a = new String[h][w];
		Arrays.setAll(a, i -> ns(w));
		return a;
	}
	final BigInteger[][] nb(final int h, final int w) {
		final BigInteger[][] a = new BigInteger[h][w];
		Arrays.setAll(a, i -> nb(w));
		return a;
	}
	final String line(){ return in.line(); }
	final void print(final Object arg){ out.print(arg); }
	final void printf(final String fmt, final Object... args){ out.printf(fmt, args); }
	final void out(){ out.out(); }
	final void out(final Object head, final Object... tail){ out.out(head, tail); }
	final void out(final int[][] args){ IntStream.range(0, args.length).forEach(i -> out(args[i])); }
	final void out(final long[][] args){ IntStream.range(0, args.length).forEach(i -> out(args[i])); }
	final void out(final double[][] args){ IntStream.range(0, args.length).forEach(i -> out(args[i])); }
	final void out(final boolean[][] args){ IntStream.range(0, args.length).forEach(i -> out(args[i])); }
	final void out(final char[][] args){ IntStream.range(0, args.length).forEach(i -> out(args[i])); }
	final void out(final Object[][] args){ IntStream.range(0, args.length).forEach(i -> out(args[i])); }
	final void outl(final Object head, final Object... tail){ out.outl(head, tail); }
	final void dump(final Object head, final Object... tail){ err.out(head, tail); }
	final void dump(final int[][] args){ IntStream.range(0, args.length).forEach(i -> dump(args[i])); }
	final void dump(final long[][] args){ IntStream.range(0, args.length).forEach(i -> dump(args[i])); }
	final void dump(final double[][] args){ IntStream.range(0, args.length).forEach(i -> dump(args[i])); }
	final void dump(final boolean[][] args){ IntStream.range(0, args.length).forEach(i -> dump(args[i])); }
	final void dump(final char[][] args){ IntStream.range(0, args.length).forEach(i -> dump(args[i])); }
	final void dump(final Object[][] args){ IntStream.range(0, args.length).forEach(i -> dump(args[i])); }
	final void dumpl(final Object head, final Object... tail){ err.outl(head, tail); }
	@Override
	public final void close() {
		out.flush();
		in.close();
		out.close();
		err.close();
	}
	private final class MyScanner implements Closeable, AutoCloseable {
		private int pos, lim;
		private final byte[] buf;
		private final InputStream is;
		private boolean check;
		MyScanner(final InputStream is) {
			this.is = is;
			pos = lim = 0;
			buf = new byte[1 << 17];
			check = false;
		}
		private final boolean isPunct(final byte bt){ return !Utility.scope(33, bt, 126); }
		private final boolean isNum(final byte bt){ return Utility.scope('0', bt, '9'); }
		private final byte read() {
			if(pos == lim && lim != -1) {
				try {
					lim = is.read(buf);
					pos = 0;
				} catch(final IOException e) {
					e.printStackTrace();
				}
			}
			return buf[pos++];
		}
		private final byte next() {
			byte bt;
			if(check) {
				check = false;
				bt = buf[pos - 1];
				if(!isPunct(bt)) {
					return bt;
				}
			}
			while(isPunct(bt = read())){}
			return bt;
		}
		final int ni(){ return toIntExact(nl()); }
		final long nl() {
			byte c = next();
			final boolean neg = c == '-';
			if(neg) {
				c = next();
			}
			assert isNum(c);
			long res = c - '0';
			while(isNum(c = read())) {
				res = 10 * res + c - '0';
			}
			check = !isNum(c);
			return neg ? -res : res;
		}
		final double nd() {
			byte c = next();
			final boolean neg = c == '-';
			if(neg) {
				c = next();
			}
			assert isNum(c);
			double res = c - '0';
			while(isNum(c = read())) {
				res = 10 * res + c - '0';
			}
			if(c != '.') {
				check = true;
				return res;
			}
			int i;
			for(i = 0; isNum(c = read()); ++i) {
				res = res * 10 + c - '0';
			}
			res /= pow(10, i);
			check = true;
			return neg ? -res : res;
		}
		final char nc(){ return (char) next(); }
		final String ns() {
			final StringBuilder sb = new StringBuilder();
			byte c = next();
			while(!isPunct(c)) {
				sb.append((char) c);
				c = read();
			}
			return sb.toString();
		}
		final char[] nt(){ return ns().toCharArray(); }
		final BigInteger nb(){ return new BigInteger(ns()); }
		final IntPair pi(){ return IntPair.of(nl(), nl()); }
		final FloatPair pf(){ return FloatPair.of(nd(), nd()); }
		final String line() {
			final StringBuilder sb = new StringBuilder();
			byte c;
			while((c = read()) != '\n') {
				sb.append((char) c);
			}
			return sb.toString();
		}
		@Override
		public final void close() {
			try {
				is.close();
			} catch(final IOException e) {
				e.printStackTrace();
			}
		}
	}
	private final class MyPrinter implements Closeable, Flushable, AutoCloseable {
		private OutputStream os;
		private final boolean autoFlush;
		private final byte[] buf;
		private int pos;
		private final boolean debug;
		MyPrinter(final OutputStream os, final boolean autoFlush){
			this.os = os;
			this.autoFlush = autoFlush;
			buf = new byte[1 << 17];
			pos = 0;
			debug = os == System.err;
		}
		private final void write(final byte bt) {
			buf[pos++] = bt;
			if(pos == buf.length) {
				flush();
			}
		}
		private final void newLine() {
			write((byte) '\n');
			if(autoFlush) {
				flush();
			}
		}
		final void print(final Object arg) {
			if(arg instanceof final String s) {
				for(final char c: s.toCharArray()) {
					write((byte) c);
				}
			} else {
				final StringBuilder sb = new StringBuilder();
				if(arg instanceof final int[] a) {
					if(debug) {
						print(Arrays.toString(a));
						return;
					}
					if(a.length == 0) {
						return;
					}
					sb.append(a[0]);
					for(int i = 0; ++i < a.length;) {
						sb.append(" " + a[i]);
					}
				} else if(arg instanceof final long[] a) {
					if(debug) {
						print(Arrays.toString(a));
						return;
					}
					if(a.length == 0) {
						return;
					}
					sb.append(a[0]);
					for(int i = 0; ++i < a.length;) {
						sb.append(" " + a[i]);
					}
				} else if(arg instanceof final double[] a) {
					if(debug) {
						print(Arrays.toString(a));
						return;
					}
					if(a.length == 0) {
						return;
					}
					for(int i = 0; i < a.length; ++i) {
						sb.append(a[i]);
					}
				} else if(arg instanceof final boolean[] a) {
					if(debug) {
						print(Arrays.toString(a));
						return;
					}
					if(a.length == 0) {
						return;
					}
					sb.append(a[0]);
					for(int i = 0; ++i < a.length;) {
						sb.append(" " + a[i]);
					}
				} else if(arg instanceof final char[] a) {
					if(a.length == 0) {
						return;
					}
					sb.append(a[0]);
					for(int i = 0; ++i < a.length;) {
						sb.append(" " + a[i]);
					}
				} else if(arg instanceof final Object[] a) {
					if(debug) {
						print(Arrays.toString(a));
						return;
					}
					if(a.length == 0) {
						return;
					}
					print(a[0]);
					for(int i = 0; ++i < a.length;) {
						print(" ");
						print(a[i]);
					}
					return;
				} else {
					if(debug) {
						print(arg.toString());
						return;
					} else if(arg instanceof final Pair<?, ?> p) {
						sb.append(p.first + " " + p.second);
					} else if(arg instanceof final Collection<?> c) {
						int i = 0;
						for(final Object el: c) {
							print(el);
							if(++i != c.size()) {
								print(" ");
							}
							return;
						}
					} else if(sb.isEmpty()) {
						print(arg.toString());
						return;
					}
				}
				print(sb.toString());
			}
			if(autoFlush) {
				flush();
			}
		}
		final void printf(final String fmt, final Object... args){ print(new Formatter().format(fmt, args)); }
		final void out(){ newLine(); }
		final void out(final Object head, final Object... tail) {
			print(head);
			for(final Object el: tail) {
				print(" ");
				print(el);
			}
			newLine();
		}
		private final void p(final Object obj) {
			if(obj instanceof int[] a) {
				Arrays.stream(a).forEach(this::out);
			} else if(obj instanceof long[] a) {
				Arrays.stream(a).forEach(this::out);
			} else if(obj instanceof double[] a) {
				Arrays.stream(a).forEach(this::out);
			} else if(obj instanceof boolean[] a) {
				IntStream.range(0, a.length).mapToObj(i -> a[i]).forEach(this::out);
			} else if(obj instanceof char[] a) {
				IntStream.range(0, a.length).mapToObj(i -> a[i]).forEach(this::out);
			} else if(obj instanceof Object[] a) {
				Arrays.stream(a).forEach(this::out);
			} else if(obj instanceof Collection<?> a) {
				a.stream().forEach(this::out);
			} else {
				out(obj);
			}
		}
		final void outl(final Object head, final Object... tail) {
			p(head);
			for(final Object el: tail) {
				p(el);
			}
		}
		@Override
		public final void flush() {
			try {
				os.write(buf, 0, pos);
				pos = 0;
			} catch(final IOException e) {
				e.printStackTrace();
			}
		}
		@Override
		public final void close() {
			if(os == null) {
				return;
			}
			try {
				os.close();
				os = null;
			} catch(final IOException e) {
				e.printStackTrace();
			}
		}
	}
}

class Pair<F extends Comparable<? super F>, S extends Comparable<? super S>> implements Comparable<Pair<F, S>>, Cloneable {
	public F first;
	public S second;
	protected Pair(final F first, final S second) {
		this.first = first;
		this.second = second;
	}
	static final <F extends Comparable<? super F>, S extends Comparable<? super S>> Pair<F, S> of(final F a, final S b){ return new Pair<>(a, b); }
	Pair<S, F> swap(){ return Pair.of(second, first); }
	@Override
	public final boolean equals(final Object o) {
		if(this == o) {
			return true;
		}
		if(o == null || getClass() != o.getClass()) {
			return false;
		}
		final Pair<?, ?> p = (Pair<?, ?>) o;
		return first.equals(p.first) && second.equals(p.second);
	}
	@Override
	public final int hashCode(){ return Objects.hash(first, second); }
	@Override
	public final String toString(){ return "(" + first + ", " + second + ")"; }
	@SuppressWarnings("unchecked")
	@Override
	public final Pair<F, S> clone() {
		try {
			return (Pair<F, S>) super.clone();
		} catch(final CloneNotSupportedException e){
			e.printStackTrace();
		}
		throw new Error();
	}
	@Override
	public final int compareTo(final Pair<F, S> p) {
		if(first.compareTo(p.first) == 0) {
			return second.compareTo(p.second);
		}
		return first.compareTo(p.first);
	}
}
final class IntPair extends Pair<Long, Long> {
	private IntPair(final long first, final long second){ super(first, second); }
	static final IntPair ZERO = new IntPair(0, 0);
	static final IntPair ONE = new IntPair(1, 1);
	static final IntPair of(final long a, final long b){ return new IntPair(a, b); }
	@Override
	final IntPair swap(){ return new IntPair(second, first); }
	final IntPair add(final IntPair p){ return new IntPair(first + p.first, second + p.second); }
	final IntPair sub(final IntPair p){ return new IntPair(first - p.first, second - p.second); }
	final IntPair mul(final IntPair p){ return new IntPair(first * p.first, second * p.second); }
	final IntPair div(final IntPair p){ return new IntPair(first / p.first, second / p.second); }
	final IntPair mod(final IntPair p){ return new IntPair(first % p.first, second % p.second); }
	final IntPair rotate(){ return new IntPair(-second, first); } 
	final FloatPair rotate(final int ang) {
		final double rad = toRadians(Utility.mod(ang, 360));
		return FloatPair.of(first * cos(rad) - second * sin(rad), first * sin(rad) + second * cos(rad));
	}
	final long dot(final IntPair p){ return first * p.first + second * p.second; }
	final long cross(final IntPair p){ return rotate().dot(p); }
	final long sqr(){ return dot(this); }
	final double grad() { 
		try {
			return 1.0 * second / first;
		} catch(final ArithmeticException e) {
			e.printStackTrace();
		}
		throw new Error();
	}
	final double abs(){ return hypot(first, second); }
	final long lcm(){ return Utility.lcm(first, second); }
	final long gcd(){ return Utility.gcd(first, second); }
	final IntPair extgcd() {
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
final class FloatPair extends Pair<Double, Double> {
	private FloatPair(final double first, final double second){ super(first, second); }
	static final FloatPair of(final double a, final double b){ return new FloatPair(a, b); }
	@Override
	final FloatPair swap(){ return new FloatPair(second, first); }
	final FloatPair add(final FloatPair p){ return new FloatPair(first + p.first, second + p.second); }
	final FloatPair sub(final FloatPair p){ return new FloatPair(first - p.first, second - p.second); }
	final FloatPair mul(final FloatPair p){ return new FloatPair(first * p.first, second * p.second); }
	final FloatPair div(final FloatPair p){ return new FloatPair(first / p.first, second / p.second); }
	final FloatPair rotate(){ return new FloatPair(-second, first); } 
	final FloatPair rotate(final int ang) {
		final double rad = toRadians(Utility.mod(ang, 360));
		return FloatPair.of(first * cos(rad) - second * sin(rad), first * sin(rad) + second * cos(rad));
	}
	final double dot(final FloatPair p){ return first * p.first + second * p.second; }
	final double cross(final FloatPair p){ return rotate().dot(p); }
	final double sqr(){ return dot(this); }
	final double grad() { 
		try {
			return second / first;
		} catch(final ArithmeticException e) {
			e.printStackTrace();
		}
		throw new Error();
	}
	final double abs(){ return hypot(first, second); }
}