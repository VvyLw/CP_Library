import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.DoublePredicate;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.LongBinaryOperator;
import java.util.function.LongPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class VvyLw extends Utility {
	protected static final MyScanner sc = new MyScanner();
	protected static final MyPrinter o = new MyPrinter(System.out, false);
	protected static final MyPrinter e = new MyPrinter(System.err, true);
	static final int[] dx = {0, -1, 1, 0, 0, -1, -1, 1, 1};
	static final int[] dy = {0, 0, 0, -1, 1, -1, 1, -1, 1};
	static final int inf = 1 << 30;
	static final long linf = (1L << 61) - 1;
	static final int mod998 = 998244353;
	static final int mod107 = (int)1e9 + 7;
	static final double eps = 1e-18;
	protected static final void solve() {
		
	}
}
final class Main extends VvyLw {
	public static void main(final String[] args) {
		final boolean multi = false;
		final int t = multi ? sc.ni() : 1;
		IntStream.range(0, t).forEach(i -> solve());
		o.flush();
		sc.close();
		o.close();
		e.close();
	}
}

class Utility {
	protected static final String yes(final boolean ok){ return ok ? "Yes" : "No"; }
	protected static final String no(final boolean ok){ return yes(!ok); }
	protected static final long sqr(final long x){ return x * x; }
	protected static final long mod(final long n, final long m){ return (n + m) % m; }
	protected static final long ceil(final long a, final long b){ return (a - 1) / b + 1; }
	protected static final double round(final double a, final long b, final int c) {
		final long d = pow(10, c);
		return Math.rint((a * d) / b) / d;
	}
	protected static final long pow(long a, int b) {
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
	protected static final long pow(long a, long b, final long m) {
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
	protected static final long lcm(final long a, final long b){ return a * b / gcd(a, b); }
	protected static final long lcm(final int... a){ return Arrays.stream(a).mapToLong(i -> i).reduce(1, (x, y) -> lcm(x, y)); }
	protected static final long lcm(final long... a){ return Arrays.stream(a).reduce(1, (x, y) -> lcm(x, y)); }
	protected static final long gcd(final long a, final long b){ return b > 0 ? gcd(b, a % b) : a; }
	protected static final int gcd(final int... a){ return Arrays.stream(a).reduce(0, (x, y) -> (int) gcd(x, y)); }
	protected static final long gcd(final long... a){ return Arrays.stream(a).reduce(0, (x, y) -> gcd(x, y)); }
	protected static final int min(final int... a){ return Arrays.stream(a).reduce(Integer.MAX_VALUE, (x, y) -> Math.min(x, y)); }
	protected static final long min(final long... a){ return Arrays.stream(a).reduce(Long.MAX_VALUE, (x, y) -> Math.min(x, y)); }
	protected static final int max(final int... a){ return Arrays.stream(a).reduce(Integer.MIN_VALUE, (x, y) -> Math.max(x, y)); }
	protected static final long max(final long... a){ return Arrays.stream(a).reduce(Long.MIN_VALUE, (x, y) -> Math.max(x, y)); }
	protected static final ArrayList<Long> div(final long n) {
		ArrayList<Long> d = new ArrayList<>();
		for(long i = 1; i * i <= n; ++i) {
			if(n % i == 0) {
				d.add(i);
				if(i * i != n) {
					d.add(n / i);
				}
			}
		}
		Collections.sort(d);
		return d;
	}
	protected static final ArrayList<Pair<Long, Integer>> primeFactor(long n) {
		ArrayList<Pair<Long, Integer>> pf = new ArrayList<>();
		for(long i = 2; i * i <= n; ++i) {
			if(n % i != 0) {
				continue;
			}
			int cnt = 0;
			while(n % i == 0) {
				cnt++;
				n /= i;
			}
			pf.add(Pair.of(i, cnt));
		}
		if(n != 1) {
			pf.add(Pair.of(n, 1));
		}
		return pf;
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
	protected static final long binom(int a, final int b) {
		long res = 1;
		for(int i = 1; i <= b; ++i) {
			res *= a--;
			res /= i;
		}
		return res;
	}
	protected static final boolean isInt(final double n){ long r = (long) Math.floor(n); return r == n; }
	protected static final boolean isSqr(final long n){ return isInt(Math.sqrt(n)); }
	protected static final boolean isPrime(final long n) {
		if(n == 1) return false;
		for(long i = 2; i * i <= n; ++i) {
			if(n % i == 0) return false;
		}
		return true;
	}
	protected static final boolean scope(final int l, final int x, final int r){ return l <= x && x <= r; }
	protected static final boolean scope(final long l, final long x, final long r){ return l <= x && x <= r; }
	protected static final boolean scope(final double l, final double x, final double r){ return l <= x && x <= r; }
	protected static final int clamp(final int l, final int x, final int r){ return x < l ? l : x > r ? r : x; }
	protected static final long clamp(final long l, final long x, final long r){ return x < l ? l : x > r ? r : x; }
	protected static final double clamp(final double l, final double x, final double r){ return x < l ? l : x > r ? r : x; }
	protected static final int[] nextPerm(int[] a) {
		for(int i = a.length; --i > 0;) {
			if(a[i - 1] < a[i]) {
				final int j = find(a[i - 1], a, i, a.length - 1);
				a[i - 1] ^= a[j];
				a[j] ^= a[i - 1];
				a[i - 1] ^= a[j];
				Arrays.sort(a, i, a.length);
				return a;
			}
		}
		return null;
	}
	protected static final long[] nextPerm(long[] a) {
		for(int i = a.length; --i > 0;) {
			if(a[i - 1] < a[i]) {
				final int j = find(a[i - 1], a, i, a.length - 1);
				a[i - 1] ^= a[j];
				a[j] ^= a[i - 1];
				a[i - 1] ^= a[j];
				Arrays.sort(a, i, a.length);
				return a;
			}
		}
		return null;
	}
	protected static final double[] nextPerm(double[] a) {
		for(int i = a.length; --i > 0;) {
			if(a[i - 1] < a[i]) {
				final int j = find(a[i - 1], a, i, a.length - 1);
				final var tmp = a[i - 1];
				a[i - 1] = a[j];
				a[j] = tmp;
				Arrays.sort(a, i, a.length);
				return a;
			}
		}
		return null;
	}
	protected static final String nextPerm(final String s) {
		var a = s.chars().mapToObj(i -> (char)i).collect(Collectors.toList());
		for(int i = a.size(); --i > 0;) {
			if(a.get(i - 1).compareTo(a.get(i)) < 0) {
				final int j = find(a.get(i - 1), a, i, a.size() - 1);
				Collections.swap(a, i - 1, j);
				Collections.sort(a.subList(i, a.size()));
				return a.stream().map(String::valueOf).collect(Collectors.joining());
			}
		}
		return null;
	}
	protected static final int[] prevPerm(int[] a) {
		for(int i = a.length; --i > 0;) {
			if(a[i - 1] > a[i]) {
				final int j = findRev(a[i - 1], a, i, a.length - 1);
				a[i - 1] ^= a[j];
				a[j] ^= a[i - 1];
				a[i - 1] ^= a[j];
				Arrays.sort(a, i, a.length);
				return reverse(a);
			}
		}
		return null;
	}
	protected static final long[] prevPerm(long[] a) {
		for(int i = a.length; --i > 0;) {
			if(a[i - 1] > a[i]) {
				final int j = findRev(a[i - 1], a, i, a.length - 1);
				a[i - 1] ^= a[j];
				a[j] ^= a[i - 1];
				a[i - 1] ^= a[j];
				Arrays.sort(a, i, a.length);
				return reverse(a);
			}
		}
		return null;
	}
	protected static final double[] prevPerm(double[] a) {
		for(int i = a.length; --i > 0;) {
			if(a[i - 1] > a[i]) {
				final int j = findRev(a[i - 1], a, i, a.length - 1);
				final var tmp = a[i - 1];
				a[i - 1] = a[j];
				a[j] = tmp;
				Arrays.sort(a, i, a.length);
				return reverse(a);
			}
		}
		return null;
	}
	protected static final String prevPerm(final String s) {
		var a = s.chars().mapToObj(i -> (char)i).collect(Collectors.toList());
		for(int i = a.size(); --i > 0;) {
			if(a.get(i - 1).compareTo(a.get(i)) > 0) {
				final int j = findRev(a.get(i - 1), a, i, a.size() - 1);
				Collections.swap(a, i - 1, j);
				Collections.sort(a.subList(i, a.size()), Collections.reverseOrder());
				return a.stream().map(String::valueOf).collect(Collectors.joining());
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
	private static final int find(final char dest, final List<Character> a, final int s, final int e) {
		if(s == e) {
			return s;
		}
		final int m = (s + e + 1) / 2;
		return a.get(m).compareTo(dest) <= 0 ? find(dest, a, s, m - 1) : find(dest, a, m, e);
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
	private static final int findRev(final char dest, final List<Character> a, final int s, final int e) {
		if(s == e) {
			return s;
		}
		final int m = (s + e + 1) / 2;
		return a.get(m).compareTo(dest) > 0 ? find(dest, a, s, m - 1) : find(dest, a, m, e);
	}
	protected static final boolean binarySearch(final int[] a, final int x){ return Arrays.binarySearch(a, x) >= 0; }
	protected static final boolean binarySearch(final long[] a, final long x){ return Arrays.binarySearch(a, x) >= 0; }
	protected static final boolean binarySearch(final Object[] a, final Object x){ return Arrays.binarySearch(a, x) >= 0; }
	protected static final boolean binarySearch(final List<Object> a, final Object x){ return Collections.binarySearch(a, x, null) >= 0; }
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
	protected static final String reverse(final String s){ return new StringBuilder(s).reverse().toString(); }
	protected static final int[] reverse(final int[] a) {
		final int n = a.length;
		int[] b = new int[n];
		for(int i = 0; i <= n / 2; ++i) {
			b[i] = a[n - 1 - i];
			b[n - 1 - i] = a[i];
		}
		return b;
	}
	protected static final long[] reverse(final long[] a) {
		final int n = a.length;
		long[] b = new long[n];
		for(int i = 0; i <= n / 2; ++i) {
			b[i] = a[n - 1 - i];
			b[n - 1 - i] = a[i];
		}
		return b;
	}
	protected static final double[] reverse(final double[] a) {
		final int n = a.length;
		double[] b = new double[n];
		for(int i = 0; i <= n / 2; ++i) {
			b[i] = a[n - 1 - i];
			b[n - 1 - i] = a[i];
		}
		return b;
	}
	protected static final Object[] reverse(final Object[] a) {
		final int n = a.length;
		Object[] b = new Object[n];
		for(int i = 0; i <= n / 2; ++i) {
			b[i] = a[n - 1 - i];
			b[n - 1 - i] = a[i];
		}
		return b;
	}
	protected static final int[] rotate(final int[] a, final int id) {
		final var t = Arrays.stream(a).boxed().collect(Collectors.toList());
		Collections.rotate(t, id);
		final int[] res = new int[a.length];
		for(int i = 0; i < a.length; ++i) {
			res[i] = t.get(i);
		}
		return res;
	}
	protected static final long[] rotate(final long[] a, final int id) {
		final var t = Arrays.stream(a).boxed().collect(Collectors.toList());
		Collections.rotate(t, id);
		final long[] res = new long[a.length];
		for(int i = 0; i < a.length; ++i) {
			res[i] = t.get(i);
		}
		return res;
	}
	protected static final double[] rotate(final double[] a, final int id) {
		final var t = Arrays.stream(a).boxed().collect(Collectors.toList());
		Collections.rotate(t, id);
		final double[] res = new double[a.length];
		for(int i = 0; i < a.length; ++i) {
			res[i] = t.get(i);
		}
		return res;
	}
	protected static final String rotate(final String s, final int id) {
		final var t = s.chars().mapToObj(i -> (char) i).collect(Collectors.toList());
		Collections.rotate(t, id);
		return t.stream().map(i -> i.toString()).collect(Collectors.joining());
	}
	protected static final int[][] rotate(final int[][] a) {
		final int h = a.length, w = a[0].length;
		int[][] b = new int[w][h];
		IntStream.range(0, h).forEach(i -> {
			IntStream.range(0, w).forEach(j -> b[j][i] = a[i][j]);
		});
		IntStream.range(0, w).forEach(i -> b[i] = reverse(b[i]));
		return b;
	}
	protected static final long[][] rotate(final long[][] a) {
		final int h = a.length, w = a[0].length;
		long[][] b = new long[w][h];
		IntStream.range(0, h).forEach(i -> {
			IntStream.range(0, w).forEach(j -> b[j][i] = a[i][j]);
		});
		IntStream.range(0, w).forEach(i -> b[i] = reverse(b[i]));
		return b;
	}
	protected static final double[][] rotate(final double[][] a) {
		final int h = a.length, w = a[0].length;
		double[][] b = new double[w][h];
		IntStream.range(0, h).forEach(i -> {
			IntStream.range(0, w).forEach(j -> b[j][i] = a[i][j]);
		});
		IntStream.range(0, w).forEach(i -> b[i] = reverse(b[i]));
		return b;
	}
	protected static final String[] rotate(final String[] s) {
		final int h = s.length, w = s[0].length();
		char[][] t = new char[w][h];
		IntStream.range(0, h).forEach(i -> {
			IntStream.range(0, w).forEach(j -> t[j][i] = s[i].charAt(j));
		});
		IntStream.range(0, w).forEach(i -> t[i] = new StringBuilder(new String(t[i])).reverse().toString().toCharArray());
		String[] res = new String[w];
		IntStream.range(0, w).forEach(i -> res[i] = new String(t[i]));
		return res;
	}
	protected static final <F, S> ArrayList<F> first(final List<Pair<F, S>> p) {
		ArrayList<F> f = new ArrayList<>();
		for(final var el: p) {
			f.add(el.first);
		}
		return f;
	}
	protected static final <F, S> ArrayList<S> second(final List<Pair<F, S>> p) {
		ArrayList<S> s = new ArrayList<>();
		for(final var el: p) {
			s.add(el.second);
		}
		return s;
	}
	protected static final int[] iota(final int n){ return IntStream.range(0, n).toArray(); }
	protected static final int[] iota(final int n, final int init){ return IntStream.range(0 + init, n + init).toArray(); }
	protected static final int bins(int ok, int ng, final IntPredicate fn) {
		while(Math.abs(ok - ng) > 1) {
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
		while(Math.abs(ok - ng) > 1) {
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
		while(Math.abs(ok - ng) > VvyLw.eps) {
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
	protected static final ArrayList<Integer> press(final int[] a) {
		ArrayList<Integer> res = new ArrayList<>();
		final var x = Arrays.stream(a).sorted().distinct().toArray();
		for(final var el: a) {
			res.add(lowerBound(x, el));
		}
		return res;
	}
	protected static final ArrayList<Integer> press(final long[] a) {
		ArrayList<Integer> res = new ArrayList<>();
		final var x = Arrays.stream(a).sorted().distinct().toArray();
		for(final var el: a) {
			res.add(lowerBound(x, el));
		}
		return res;
	}
	protected static final int[] zAlgorithm(final String s) {
		final int n = s.length();
		int j = 0;
		int[] pre = new int[n];
		for(int i = 0; ++i < n;) {
			if(i + pre[i - j] < j + pre[j]) {
				pre[i] = pre[i - j];
			}
			else {
				int k = Math.max(0, j + pre[j] - i);
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
		char[] s;
		if(calcEven) {
			s = new char[2 * n - 1];
			IntStream.range(0, n).forEach(i -> s[i] = s_.charAt(i));
			for(int i = n; --i >= 0;) {
				s[2 * i] = s_.charAt(i);
			}
			final var d = Collections.min(s_.chars().mapToObj(c -> (char) c).collect(Collectors.toList()));
			for(int i = 0; i < n - 1; ++i) {
				s[2 * i + 1] = d;
			}
		} else {
			s = new char[n];
			IntStream.range(0, n).forEach(i -> s[i] = s_.charAt(i));
		}
		n = s.length;
		int[] rad = new int[n];
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
			for(var x: rad) {
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
					mul = Math.multiplyExact(mul, x);
				} catch(ArithmeticException e) {
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
			return pow(a, a, m);
		}
		final var phi = eulerPhi(m);
		var tmp = tetration(a, b - 1, phi);
		if(tmp == 0) {
			tmp += phi;
		}
		return pow(a, tmp, m);
	}
	protected interface TriFunction<T, U, V, W> {
		public W apply(final T a, final U b, final V c);
	}
	protected interface QuadFunction<A, B, C, D, E> {
		public E apply(final A a, final B b, final C c, final D d);
	}
}

final class MyScanner {
	private final Scanner sc = new Scanner(System.in);
	final int ni(){ return sc.nextInt(); }
	final long nl(){ return sc.nextLong(); }
	final double nd(){ return sc.nextDouble(); }
	final String ns(){ return sc.next(); }
	final BigInteger nb(){ return sc.nextBigInteger(); }
	final int[] ni(final int n) {
		final int[] a = new int[n];
		IntStream.range(0, n).forEach(i -> a[i] = ni());
		return a;
	}
	final long[] nl(final int n) {
		final long[] a = new long[n];
		IntStream.range(0, n).forEach(i -> a[i] = nl());
		return a;
	}
	final double[] nd(final int n) {
		final double[] a = new double[n];
		IntStream.range(0, n).forEach(i -> a[i] = nd());
		return a;
	}
	final String[] ns(final int n) {
		final String[] a = new String[n];
		IntStream.range(0, n).forEach(i -> a[i] = ns());
		return a;
	}
	final BigInteger[] nb(final int n) {
		final BigInteger[] a = new BigInteger[n];
		IntStream.range(0, n).forEach(i -> a[i] = nb());
		return a;
	}
	final int[][] ni(final int h, final int w) {
		final int[][] a = new int[h][w];
		IntStream.range(0, h).forEach(i -> a[i] = ni(w));
		return a;
	}
	final long[][] nl(final int h, final int w) {
		final long[][] a = new long[h][w];
		IntStream.range(0, h).forEach(i -> a[i] = nl(w));
		return a;
	}
	final double[][] nd(final int h, final int w) {
		final double[][] a = new double[h][w];
		IntStream.range(0, h).forEach(i -> a[i] = nd(w));
		return a;
	}
	final String[][] ns(final int h, final int w) {
		final String[][] a = new String[h][w];
		IntStream.range(0, h).forEach(i -> a[i] = ns(w));
		return a;
	}
	final BigInteger[][] nb(final int h, final int w) {
		final BigInteger[][] a = new BigInteger[h][w];
		IntStream.range(0, h).forEach(i -> a[i] = nb(w));
		return a;
	}
	final void close(){ sc.close(); }
}

final class MyPrinter extends PrintWriter {
	MyPrinter(final OutputStream os, final boolean flush){ super(os, flush); }
	final void out(){ println(); }
	final void out(final Object head, final Object... tail) {
		print(head);
		for(final var el: tail) {
			print(" " + el);
		}
		out();
	}
	final <F, S> void out(final Pair<F, S> arg){ println(arg.first + " " + arg.second); }
	final void out(final int[] args){ IntStream.range(0, args.length).forEach(i -> print(args[i] + (i + 1 < args.length ? " " : "\n"))); }
	final void out(final long[] args){ IntStream.range(0, args.length).forEach(i -> print(args[i] + (i + 1 < args.length ? " " : "\n"))); }
	final void out(final double[] args){ IntStream.range(0, args.length).forEach(i -> print(args[i] + (i + 1 < args.length ? " " : "\n"))); }
	final void out(final boolean[] args){ IntStream.range(0, args.length).forEach(i -> print(args[i] + (i + 1 < args.length ? " " : "\n"))); }
	final void out(final char[] args){ IntStream.range(0, args.length).forEach(i -> print(args[i] + (i + 1 < args.length ? " " : "\n"))); }
	final void out(final Object[] args){ IntStream.range(0, args.length).forEach(i -> print(args[i] + (i + 1 < args.length ? " " : "\n"))); }
	final <T> void out(final List<T> args){ IntStream.range(0, args.size()).forEach(i -> print(args.get(i) + (i + 1 < args.size() ? " " : "\n"))); }
	final void outl(final Object head, final Object... tail) {
		out(head);
		Arrays.stream(tail).forEach(this::println);
	}
	final void outl(final int[] args){ Arrays.stream(args).forEach(this::println); }
	final void outl(final int[][] args){ IntStream.range(0, args.length).forEach(i -> out(args[i])); }
	final void outl(final long[] args){ Arrays.stream(args).forEach(this::println); }
	final void outl(final long[][] args){ IntStream.range(0, args.length).forEach(i -> out(args[i])); }
	final void outl(final double[] args){ Arrays.stream(args).forEach(this::println); }
	final void outl(final double[][] args){ IntStream.range(0, args.length).forEach(i -> out(args[i])); }
	final void outl(final boolean[] args){ IntStream.range(0, args.length).forEach(i -> out(args[i])); }
	final void outl(final boolean[][] args){ IntStream.range(0, args.length).forEach(i -> out(args[i])); }
	final void outl(final char[] args){ IntStream.range(0, args.length).forEach(i -> out(args[i])); }
	final void outl(final Object[] args){ Arrays.stream(args).forEach(this::println); }
	final <E> void outl(final Collection<E> args){ args.stream().forEach(this::println); }
	final void fin(final Object head, final Object... tail) {
		out(head, tail);
		flush();
		System.exit(0);
	}
	final void fin(final int[] args) {
		out(args);
		flush();
		System.exit(0);
	}
	final void fin(final long[] args) {
		out(args);
		flush();
		System.exit(0);
	}
	final void fin(final double[] args) {
		out(args);
		flush();
		System.exit(0);
	}
	final void fin(final boolean[] args) {
		out(args);
		flush();
		System.exit(0);
	}
	final void fin(final char[] args) {
		out(args);
		flush();
		System.exit(0);
	}
	final void fin(final Object[] args) {
		out(args);
		flush();
		System.exit(0);
	}
	final <T> void fin(final List<T> args) {
		out(args);
		flush();
		System.exit(0);
	}
	final void ende(final int[] args) {
		outl(args);
		flush();
		System.exit(0);
	}
	final void ende(final long[] args) {
		outl(args);
		flush();
		System.exit(0);
	}
	final void ende(final double[] args) {
		outl(args);
		flush();
		System.exit(0);
	}
	final void ende(final boolean[] args) {
		outl(args);
		flush();
		System.exit(0);
	}
	final void ende(final char[] args) {
		outl(args);
		flush();
		System.exit(0);
	}
	final void ende(final Object[] args) {
		outl(args);
		flush();
		System.exit(0);
	}
	final <E> void ende(final Collection<E> args) {
		outl(args);
		flush();
		System.exit(0);
	}
}

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

class Huitloxopetl {
	final long invNum(final int[] a) {
		final var b = Utility.sorted(a);
		final var id = new int[a.length];
		for(int i = 0; i < a.length; ++i) {
			id[b[i]] = i;
		}
		final var bit = new FenwickTree(a.length);
		long res = 0;
		for(int i = 0; i < a.length; ++i) {
			res += i - bit.sum(id[a[i]]);
			bit.add(id[a[i]], 1);
		}
		return res;
	}
	final long invNum(final long[] a) {
		final var b = Utility.sorted(a);
		final var id = new HashMap<Long, Integer>();
		for(int i = 0; i < a.length; ++i) {
			id.put(b[i], i);
		}
		final var bit = new FenwickTree(a.length);
		long res = 0;
		for(int i = 0; i < a.length; ++i) {
			res += i - bit.sum(id.get(a[i]));
			bit.add(id.get(a[i]), 1);
		}
		return res;
	}
}

final class UnionFind {
	private final int[] par;
	UnionFind(final int n) {
		par = new int[n];
		Arrays.fill(par, -1);
	}
	final int root(final int i){ return par[i] >= 0 ? par[i] = root(par[i]) : i; }
	final int size(final int i){ return -par[root(i)]; }
	final boolean unite(int i, int j) {
		i = root(i);
		j = root(j);
		if(i == j) return false;
		if(i > j) {
			i ^= j;
			j ^= i;
			i ^= j;
		}
		par[i] += par[j];
		par[j] = i;
		return true;
	}
	final boolean same(final int i, final int j){ return root(i) == root(j); }
	final ArrayList<ArrayList<Integer>> groups() {
		final int n = par.length;
		ArrayList<ArrayList<Integer>> res = new ArrayList<>(n);
		IntStream.range(0, n).forEach(i -> res.add(new ArrayList<>()));
		IntStream.range(0, n).forEach(i -> res.get(root(i)).add(i));
		res.removeIf(ArrayList::isEmpty);
		return res;
	}
	final boolean isBipartite() {
		final int n = par.length / 2;
		boolean ok = true;
		for(int i = 0; i < n; ++i) {
			ok &= root(i) != root(i + n);
		}
		return ok;
	}
}

final class WeightedUnionFind {
	private final int[] par;
	private final long[] weight;
	WeightedUnionFind(final int n) {
		par = new int[n];
		weight = new long[n];
		Arrays.fill(par, -1);
	}
	final int root(final int i) {
		if(par[i] < 0) {
			return i;
		}
		final int r = root(par[i]);
		weight[i] += weight[par[i]];
		return par[i] = r;
	}
	final long get(final int i) {
		root(i);
		return weight[i];
	}
	final long diff(final int x, final int y){ return get(y) - get(x); }
	final int unite(int x, int y, long w) {
		w += diff(y, x);
		x = root(x);
		y = root(y);
		if(x == y) {
			return w == 0 ? 0 : -1;
		}
		if(par[x] > par[y]) {
			x ^= y;
			y ^= x;
			x ^= y;
			w = -w;
		}
		par[x] += par[y];
		par[y] = x;
		weight[y] = w;
		return 1;
	}
	final boolean same(final int x, final int y){ return root(x) == root(y); }
}

final class UndoUnionFind {
	private final int[] par;
	private final Stack<Pair<Integer, Integer>> his;
	UndoUnionFind(final int n) {
	    par = new int[n];
	    Arrays.fill(par, -1);
	    his = new Stack<>();
	}
	final boolean unite(int x, int y) {
		x = root(x);
		y = root(y);
		his.add(Pair.of(x, par[x]));
		his.add(Pair.of(y, par[y]));
		if(x == y) {
			return false;
		}
		if(par[x] > par[y]) {
			x ^= y;
			y ^= x;
			x ^= y;
		}
		par[x] += par[y];
		par[y] = x;
		return true;
	}
	final int root(final int i) {
		if(par[i] < 0) {
			return i;
		}
		return root(par[i]);
	}
	final int size(final int i){ return -par[root(i)]; }
	final void undo() {
		final Pair<Integer, Integer> pop1 = his.pop(), pop2 = his.pop();
		par[pop1.first] = pop1.second;
		par[pop2.first] = pop2.second;
	}
	final void snapshot() {
		while(!his.empty()) {
			his.pop();
		}
	}
	final void rollback() {
		while(!his.empty()) {
			undo();
		}
	}
}

final class Edge {
	public int src;
	public int to;
	public long cost;
	Edge(final int to) {
		this.to = to;
	}
	Edge(final int to, final long cost) {
		this.to = to;
		this.cost = cost;
	}
	Edge(final int src, final int to, final long cost) {
		this.src = src;
		this.to = to;
		this.cost = cost;
	}
	@Override
	public final boolean equals(final Object o) {
		if(this == o) {
			return true;
		}
		if(o == null || getClass() != o.getClass()) {
			return false;
		}
		final Edge e = (Edge) o;
		if(src != e.src) {
			return false;
		}
		if(to != e.to) {
			return false;
		}
		return cost == e.cost;
	}
	@Override
	public final int hashCode() {
		int result = 17;
		result = 31 * result + src;
		result = 31 * result + to;
		result = 31 * result + (int) (cost ^ (cost >>> 32)); // XOR for long values
		return result;
	}
	@Override
	public final String toString(){ return "(" + src + ", " + to + ", " + cost + ")"; }
}
class Graph extends ArrayList<ArrayList<Edge>> {
	protected final boolean undirected;
	protected final int n, indexed;
	protected final ArrayList<Edge> edge;
	Graph(final int n, final int indexed, final boolean undirected) {
		this.n = n;
		this.indexed = indexed;
		this.undirected = undirected;
		edge = new ArrayList<>();
		IntStream.range(0, n).forEach(i -> this.add(new ArrayList<>()));
	}
	final void addEdge(int a, int b) {
		a -= indexed;
		b -= indexed;
		this.get(a).add(new Edge(b));
		edge.add(new Edge(a, b, 0));
		if(undirected) {
			this.get(b).add(new Edge(a));
			edge.add(new Edge(b, a, 0));
		}
	}
	protected final int[] allDist(final int v) {
		int[] d = new int[n];
		Arrays.fill(d, -1);
		Queue<Integer> q = new ArrayDeque<>();
		d[v] = 0;
		q.add(v);
		while(!q.isEmpty()) {
			final int tmp = q.poll();
			for(final var el: this.get(tmp)) {
				if(d[el.to] != -1) {
					continue;
				}
				d[el.to]=d[tmp]+1;
				q.add(el.to);
			}
		}
		return d;
	}
	protected final int dist(final int u, final int v){ return allDist(u)[v]; }
	protected final ArrayList<Integer> topologicalSort() {
		int[] deg = new int[n];
		for(int i = 0; i < n; ++i) {
			for(final var ed: this.get(i)) {
				deg[ed.to]++;
			}
		}
		final var sk = new Stack<Integer>();
		for(int i = 0; i < n; ++i) {
			if(deg[i] == 0) {
				sk.add(i);
			}
		}
		final var ord = new ArrayList<Integer>();
		while(!sk.isEmpty()) {
			final var tmp = sk.pop();
			ord.add(tmp);
			for(final var ed: this.get(tmp)) {
				if(--deg[ed.to] == 0) {
					sk.add(ed.to);
				}
			}
		}
		return ord.size() == size() ? ord : new ArrayList<>();
	}
}

final class MST {
	public final ArrayList<Edge> tree;
	public final long cost;
	MST(final ArrayList<Edge> tree, final long cost) {
		this.tree = tree;
		this.cost = cost;
	}
}
final class WeightedGraph extends Graph {
	WeightedGraph(final int n, final int indexed, final boolean undirected) {
		super(n, indexed, undirected);
	}
	final void addEdge(int a, int b, final long cost) {
		a -= indexed;
		b -= indexed;
		this.get(a).add(new Edge(b, cost));
		edge.add(new Edge(a, b, cost));
		if(undirected) {
			this.get(b).add(new Edge(a, cost));
			edge.add(new Edge(b, a, cost));
		}
	}
	final long[] dijkstra(final int v) {
		long[] cost = new long[n];
		Arrays.fill(cost, Long.MAX_VALUE);
		Queue<NumPair> dj = new PriorityQueue<>();
		cost[v] = 0;
		dj.add(new NumPair(cost[v], v));
		while(!dj.isEmpty()) {
			final var tmp = dj.poll();
			if(cost[tmp.second.intValue()] < tmp.first.longValue()) {
				continue;
			}
			for(final var el: this.get(tmp.second.intValue())) {
				if(cost[el.to] > tmp.first.longValue() + el.cost) {
					cost[el.to] = tmp.first.longValue() + el.cost;
					dj.add(new NumPair(cost[el.to], el.to));
				}
			}
		}
		return cost;
	}
	final long[] bellmanFord(final int v) {
		long[] cost = new long[n];
		Arrays.fill(cost, Long.MAX_VALUE);
		cost[v] = 0;
		for(int i = 0; i < edge.size() - 1; ++i) {
			for(final var e: edge) {
				if(cost[e.src] == Long.MAX_VALUE) {
					continue;
				}
				if(cost[e.to] > cost[e.src] + e.cost) {
					cost[e.to] = cost[e.src] + e.cost;
				}
			}
		}
		for(final var e: edge) {
			if(cost[e.src] == Long.MAX_VALUE) {
				continue;
			}
			if(cost[e.src] + e.cost < cost[e.to]) {
				return null;
			}
		}
		return cost;
	}
	final long[][] warshallFloyd() {
		long[][] cost = new long[n][n];
		IntStream.range(0, n).forEach(i -> Arrays.fill(cost[i], VvyLw.linf));
		IntStream.range(0, n).forEach(i -> cost[i][i] = 0);
		for(int i = 0; i < n; ++i) {
			for(final var j: this.get(i)) {
				cost[i][j.to] = j.cost;
			}
		}
		for(int k = 0; k < n; ++k) {
			for(int i = 0; i < n; ++i) {
				for(int j = 0; j < n; ++j) {
					if(cost[i][k] == VvyLw.linf || cost[k][j] == VvyLw.linf) {
						continue;
					}
					if(cost[i][j] > cost[i][k] + cost[k][j]) {
						cost[i][j] = cost[i][k] + cost[k][j];
					}
				}
			}
		}
		return cost;
	}
	final MST kruskal() {
		final UnionFind uf = new UnionFind(n);
		final var e = new ArrayList<Edge>();
		long res = 0;
		for(final var ed: edge.stream().sorted(Comparator.comparing(ed -> ed.cost)).collect(Collectors.toList())) {
			if(uf.unite(ed.src, ed.to)) {
				e.add(ed);
				res += ed.cost;
			}
		}
		return new MST(e, res);
	}
	final MST directed(final int v) {
		@SuppressWarnings("unchecked")
		final var ed = (ArrayList<Edge>) edge.clone();
		for(int i = 0; i < n; ++i) {
			if(i != v) {
				ed.add(new Edge(i, v, 0));
			}
		}
		int x = 0;
		int[] par = new int[2 * n], vis = new int[2 * n], link = new int[2 * n];
		Arrays.fill(par, -1);
		Arrays.fill(vis, -1);
		Arrays.fill(link, -1);
		final var heap = new SkewHeap(true);
		Node[] ins = new Node[2 * n];
		Arrays.fill(ins, null);
		for(int i = 0; i < ed.size(); i++) {
			final var e = ed.get(i);
			ins[e.to] = heap.push(ins[e.to], e.cost, i);
		}
		final var st = new ArrayList<Integer>();
		final Function<Integer, Integer> go = z -> {
			z = ed.get(ins[z].idx).src;
			while(link[z] != -1) {
				st.add(z);
				z = link[z];
			}
			for(final var p: st) {
				link[p] = z;
			}
			st.clear();
			return z;
		};
		for(int i = n; ins[x] != null; ++i) {
			while(vis[x] == -1) {
				vis[x] = 0;
				x = go.apply(x);
			}
			while(x != i) {
				final var w = ins[x].key;
				var z = heap.pop(ins[x]);
				z = heap.add(z, -w);
				ins[i] = heap.meld(ins[i], z);
				par[x] = i;
				link[x] = i;
				x = go.apply(x);
			}
			while(ins[x] != null && go.apply(x) == x) {
				ins[x] = heap.pop(ins[x]);
			}
		}
		for(int i = v; i != -1; i = par[i]) {
			vis[i] = 1;
		}
		long cost = 0;
		ArrayList<Edge> e = new ArrayList<>();
		for(int i = x; i >= 0; i--) {
			if(vis[i] == 1) {
				continue;
			}
			cost += ed.get(ins[i].idx).cost;
			e.add(ed.get(ins[i].idx));
			for(int j = ed.get(ins[i].idx).to; j != -1 && vis[j] == 0; j = par[j]) {
				vis[j] = 1;
			}
		}
		return new MST(e, cost);
	}
}
class Node {
	long key, lazy;
	Node l, r;
	int idx;
	Node(final long key, final int idx) {
		this.key = key;
		this.idx = idx;
		lazy = 0;
		l = null;
		r = null;
	}
}
class SkewHeap {
	private final boolean isMin;	
	SkewHeap(final boolean isMin){ this.isMin = isMin; }
	private final Node alloc(final long key, final int idx){ return new Node(key, idx); }
	private final Node propagate(final Node t) {
		if(t != null && t.lazy != 0) {
			if(t.l != null) {
				t.l.lazy += t.lazy;
			}
			if(t.r != null) {
				t.r.lazy += t.lazy;
			}
			t.key += t.lazy;
			t.lazy = 0;
		}
		return t;
	}
	final Node meld(Node x, Node y) {
		propagate(x);
		propagate(y);
		if(x == null || y == null) {
			return x != null ? x : y;
		}
		if((x.key < y.key) ^ isMin) {
			final var tmp = x;
			x = y;
			y = tmp;
		}
		x.r = meld(y, x.r);
		final var tmp = x.l;
		x.l = x.r;
		x.r = tmp;
		return x;
	}
	final Node push(final Node t, final long key, int idx){ return meld(t, alloc(key, idx)); }
	final Node pop(final Node t) {
		if(t == null) {
			throw new NullPointerException();
		}
		return meld(t.l, t.r);
	}
	final Node add(Node t, final long lazy) {
		if(t != null) {
			t.lazy += lazy;
			propagate(t);
		}
		return t;
	}
}

final class LowestCommonAncestor<G extends Graph> {
	private final int log;
	final int[] dep, sum;
	private final G g;
	final int[][] table;
	LowestCommonAncestor(final G g) {
		this.g = g;
		final int n = g.size();
		dep = new int[n];
		sum = new int[n];
		log = Integer.toBinaryString(n).length();
		table = new int[log][n];
		IntStream.range(0, log).forEach(i -> Arrays.fill(table[i], -1));
		build();
	}
	private final void dfs(final int idx, final int par, final int d) {
		table[0][idx] = par;
		dep[idx] = d;
		for(final var el: g.get(idx)) {
			if(el.to != par) {
				sum[el.to] = (int) (sum[idx] + el.cost); 
				dfs(el.to, idx, d + 1);
			}
		}
	}
	private final void build() {
		dfs(0, -1, 0);
		for(int k = 0; k < log - 1; ++k) {
			for(int i = 0; i < table[k].length; ++i) {
				if(table[k][i] == -1) {
					table[k + 1][i] = -1;
				} else {
					table[k + 1][i] = table[k][table[k][i]];
				}
			}
		}
	}
	final int query(int u, int v) {
		if(dep[u] > dep[v]) {
			u ^= v;
			v ^= u;
			u ^= v;
		}
		v = climb(v, dep[v] - dep[u]);
		if(u == v) {
			return u;
		}
		for(int i = log; --i >= 0;) {
			if(table[i][u] != table[i][v]) {
				u = table[i][u];
				v = table[i][v];
			}
		}
		return table[0][u];
	}
	final int climb(int u, final int k) {
		if(dep[u] < k) {
			return -1;
		}
		for(int i = log; --i >= 0;) {
			if(((k >> i) % 2) == 1) {
				u = table[i][u];
			}
		}
		return u;
	}
	final int dist(final int u, final int v){ return sum[u] + sum[v] - 2 * sum[query(u, v)]; }
}

final class PrimeTable {
	private final int size;
	private final int[] p;
	private final boolean[] sieve;
	PrimeTable(final int n) {
		sieve = new boolean[n + 1];
		Arrays.fill(sieve, true);
		sieve[0] = sieve[1] = false;
		for(long i = 2; i <= n; ++i) {
			if(!sieve[(int) i]) {
				continue;
			}
			for(long j = i * i; j <= n; j += i) {
				sieve[(int) j] = false;
			}
		}
		size = (int) IntStream.rangeClosed(0, n).filter(i -> sieve[i]).count();
		int j = 0;
		p = new int[size];
		for(int i = 2; i <= n; ++i) {
			if(sieve[i]) {
				p[j++] = i; 
			}
		}
	}
	final boolean[] table(){ return sieve; }
	final int[] get(){ return p; }
}

final class PrimeFactor {
	private final int[] spf;
	PrimeFactor(final int n) {
		spf = Utility.iota(n + 1);
		for(int i = 2; i * i <= n; ++i) {
			if(spf[i] == i) {
				for(int j = i * i; j <= n; j += i) {
					if(spf[j] == j) {
						spf[j] = i;
					}
				}
			}
		}
	}
	final TreeMap<Integer, Integer> get(int n) {
		final TreeMap<Integer, Integer> m = new TreeMap<>();
		while(n != 1) {
			m.merge(spf[n], 1, (a, b) -> (a + b));
			n /= spf[n];
		}
		return m;
	}
}

final class PrimeCounter {
	private final int sq;
	private final boolean[] p;
	private final int[] psum;
	private final ArrayList<Integer> ps;
	PrimeCounter(final long lim) {
		sq = (int) kthRooti(lim, 2);
		psum = new int[sq + 1];
		p = new PrimeTable(sq).table();
		for(int i = 1; i <= sq; ++i) {
			psum[i] = psum[i - 1] + (p[i] ? 1 : 0);
		}
		ps = new ArrayList<>();
		for(int i = 1; i <= sq; ++i) {
			if(p[i]) {
				ps.add(i);
			}
		}
	}
	private final long kthRooti(final long n, final int k){ return Utility.kthRoot(n, k); }
	private final long p2(final long x, final long y) {
		if(x < 4) {
			return 0;
		}
		final long a = pi(y);
		final long b = pi(kthRooti(x, 2));
		if(a >= b) {
			return 0;
		}
		long sum = (long) (a - 2) * (a + 1) / 2 - (b - 2) * (b + 1) / 2;
		for(long i = a; i < b; ++i) {
			sum += pi(x / ps.get((int) i));
		}
		return sum;
	}
	private final long phi(final long m, final long a) {
		if(m < 1) {
			return 0;
		}
		if(a > m) {
			return 1;
		}
		if(a < 1) {
			return m;
		}
		if(m <= (long) ps.get((int) (a - 1)) * ps.get((int) (a - 1))) {
			return pi(m) - a + 1;
		}
		if(m <= (long) ps.get((int) (a - 1)) * ps.get((int) (a - 1)) * ps.get((int) (a - 1)) && m <= sq) {
			final long sx = pi(kthRooti(m, 2));
			long ans = pi(m) - (long) (sx + a - 2) * (sx - a + 1) / 2;
			for(long i = a; i < sx; ++i) {
				ans += pi(m / ps.get((int) i));
			}
			return ans;
		}
		return phi(m, a - 1) - phi(m / ps.get((int) (a - 1)), a - 1);
	}
	final long pi(final long n) {
		if(n <= sq) {
			return psum[(int) n];
		}
		final long m = kthRooti(n, 3);
		final long a = pi(m);
		return phi(n, a) + a - 1 - p2(n, m);
	}
}

// N <= 1e18;
final class LongPrime {
	private final int bsf(final long x){ return Long.numberOfTrailingZeros(x); }
	private final long gcd(long a, long b) {
		a = Math.abs(a);
		b = Math.abs(b);
		if(a == 0) {
			return b;
		}
		if(b == 0) {
			return a;
		}
		final int shift = bsf(a|b);
		a >>= bsf(a);
		do {
			b >>= bsf(b);
			if(a > b) {
				a ^= b;
				b ^= a;
				a ^= b;
			}
			b -= a;
		} while(b > 0);
		return a << shift;
	}
	final boolean isPrime(final long n) {
		if(n <= 1) {
			return false;
		}
		if(n == 2) {
			return true;
		}
		if(n % 2 == 0) {
			return false;
		}
		long d = n - 1;
		while(d % 2 == 0) {
			d /= 2;
		}
		final long[] sample = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37};
		for(final long a: sample) {
			if(n <= a) {
				break;
			}
			long t = d;
			BigInteger y = BigInteger.valueOf(a).modPow(BigInteger.valueOf(t), BigInteger.valueOf(n));
			while(t != n - 1 && !y.equals(BigInteger.ONE) && !y.equals(BigInteger.valueOf(n).subtract(BigInteger.ONE))) {
				y = y.multiply(y).mod(BigInteger.valueOf(n));
				t <<= 1;
			}
			if(!y.equals(BigInteger.valueOf(n).subtract(BigInteger.ONE)) && t % 2 == 0) {
				return false;
			}
		}
		return true;
	}
	final private long find(final long n) {
		if(isPrime(n)) {
			return n;
		}
		if(n % 2 == 0) {
			return 2;
		}
		long st = 0;
		final LongBinaryOperator f = (x, y) -> { return BigInteger.valueOf(x).multiply(BigInteger.valueOf(x)).add(BigInteger.valueOf(y)).mod(BigInteger.valueOf(n)).longValue(); };
		while(true) {
			st++;
			long x = st, y = f.applyAsLong(x, st);
			while(true) {
				final long p = gcd(y - x + n, n);
				if(p == 0 || p == n) {
					break;
				}
				if(p != 1) {
					return p;
				}
				x = f.applyAsLong(x, st);
				y = f.applyAsLong(f.applyAsLong(y, st), st);
			}
		}
	}
	final ArrayList<Long> primeFactor(final long n) {
		if(n == 1) return new ArrayList<>();
		final long x = find(n);
		if(x == n) return new ArrayList<>(Arrays.asList(x));
		ArrayList<Long> l = primeFactor(x);
		final ArrayList<Long> r = primeFactor(n / x);
		l.addAll(r);
		Collections.sort(l);
		return l;
	}
}
// N > 1e18
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
				final var tmp = b;
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
		var l = primeFactor(x);
		final var r = primeFactor(n.divide(x));
		l.addAll(r);
		Collections.sort(l);
		return l;
	}
}

final class EulerPhiTable {
	private final int n;
	private final int[] euler;
	EulerPhiTable(final int n) {
		this.n = n;
		euler = Utility.iota(n + 1);
		for(int i = 2; i <= n; ++i) {
			if(euler[i] == i) {
				for(int j = i; j <= n; j += i) {
					euler[j] = euler[j] / i * (i - 1);
				}
			}
		}
	}
	final int[] get(){ return euler; }
	final long[] acc() {
		long[] ret = new long[n + 1];
		ret[1] = 2;
		for(int i = 2; i <= n; ++i) {
			ret[i] = ret[i - 1] + euler[i];
		}
		return ret;
	}
}

class InclusiveScan {
	protected final int n;
	protected long[] s;
	InclusiveScan(final int[] a, final LongBinaryOperator op) {
		n = a.length;
		s = Arrays.stream(a).mapToLong(i -> i).toArray();
		Arrays.parallelPrefix(s, op);
	}
	InclusiveScan(final long[] a, final LongBinaryOperator op) {
		n = a.length;
		s = a.clone();
		Arrays.parallelPrefix(s, op);
	}
	protected long[] get(){ return s; }
	protected long query(final int l, final int r){ return s[r] - s[l]; }
}
final class PrefixSum extends InclusiveScan {
	PrefixSum(final int[] a) {
		super(a, (x, y) -> x + y);
		s = Utility.rotate(Arrays.copyOf(s, n + 1), 1);
	}
	PrefixSum(final long[] a) {
		super(a, (x, y) -> x + y);
		s = Utility.rotate(Arrays.copyOf(s, n + 1), 1);
	}
}

final class FenwickTree {
	private final int n;
	private final long[] data;
	FenwickTree(final int n) {
		this.n = n + 2;
		data = new long[this.n + 1];
	}
	final long sum(int k) {
		if(k < 0) return 0;
		long ret = 0;
		for(++k; k > 0; k -= k & -k) {
			ret += data[k];
		}
		return ret;
	}
	final long sum(final int l, final int r){ return sum(r) - sum(l - 1); }
	final long get(final int k){ return sum(k) - sum(k - 1); }
	final void add(int k, final long x) {
		for(++k; k < n; k += k & -k) {
			data[k] += x;
		}
	}
	final void imos(final int l, final int r, long x) {
		add(l, x);
		add(r + 1, -x);
	}
	private final int lg(final int n){ return 63 - Integer.numberOfLeadingZeros(n); }
	final int lowerBound(long w) {
		if(w <= 0) {
			return 0;
		}
		int x = 0;
		for(int k = 1 << lg(n); k > 0; k >>= 1) {
			if(x + k <= n - 1 && data[x + k] < w) {
				w -= data[x + k];
				x += k;
			}
		}
		return x;
	}
	final int upperBound(long w) {
		if(w < 0) {
			return 0;
		}
		int x = 0;
		for(int k = 1 << lg(n); k > 0; k >>= 1) {
			if(x + k <= n - 1 && data[x + k] <= w) {
				w -= data[x + k];
				x += k;
			}
		}
		return x;
	}
}

final class SegmentTree<T extends Number> {
	private int n = 1, rank = 0, fini;
	private final BinaryOperator<T> op;
	private final T e;
	private final Object[] dat;
	SegmentTree(final int fini, final BinaryOperator<T> op, final T e) {
		this.fini = fini;
		this.op = op;
		this.e = e;
		while(this.fini > n) {
			n <<= 1;
			rank++;
		}
		dat = new Object[2 * n];
		Arrays.fill(dat, e);
	}
	@SuppressWarnings("unchecked")
	final void update(int i, final T x) {
		i += n;
		dat[i] = x;
		do {
			i >>= 1;
			dat[i] = op.apply((T) dat[2 * i], (T) dat[2 * i + 1]);
		} while(i > 0);
	}
	@SuppressWarnings("unchecked")
	final T query(int a, int b) {
		T l = e, r = e;
		for(a += n, b += n; a < b; a >>= 1, b >>= 1) {
			if(a % 2 == 1) {
				l = op.apply(l, (T) dat[a++]);
			}
			if(b % 2 == 1) {
				r = op.apply((T) dat[--b], r);
			}
		}
		return op.apply(l, r);
	}
	@SuppressWarnings("unchecked")
	final int findLeft(final int r, final Predicate<T> fn) {
		if(r == 0) {
			return 0;
		}
		int h = 0, i = r + n;
		T val = e;
		for(; h <= rank; h++) {
			if(i >> (h & 1) > 0) {
				final T val2 = op.apply(val, (T) dat[i >> (h ^ 1)]);
				if(fn.test(val2)){
					i -= 1 << h;
					if(i == n) {
						return 0;
					}
					val = val2;
				}
				else {
					break;
				}
			}
		}
		for(; h-- > 0;) {
			final T val2 = op.apply(val, (T) dat[(i >> h) - 1]);
			if(fn.test(val2)){
				i -= 1 << h;
				if(i == n) {
					return 0;
				}
				val = val2;
			}
		}
		return i - n;
	}
	@SuppressWarnings("unchecked")
	final int findRight(final int l, final Predicate<T> fn) {
		if(l == fini) {
			return fini;
		}
		int h = 0, i = l + n;
		T val = e;
		for(; h <= rank; h++) {
			if(i >> (h & 1) > 0){
				final T val2 = op.apply(val, (T) dat[i >> h]);
				if(fn.test(val2)){
					i += 1 << h;
					if(i == n * 2) {
						return fini;
					}
					val = val2;
				}
				else {
					break;
				}
			}
		}
		for(; h-- > 0;) {
			final T val2 = op.apply(val, (T) dat[i>>h]);
			if(fn.test(val2)) {
				i += 1 << h;
				if(i == n * 2) {
					return fini;
				}
				val = val2;
			}
		}
		return Math.min(i - n, fini);
	}
}

final class SparseTable {
	private final long[][] st;
	private final int[] lookup;
	private final LongBinaryOperator op;
	SparseTable(final int[] a, final LongBinaryOperator op) {
		this.op = op;
		int b = 0;
		while((1 << b) <= a.length) {
			++b;
		}
		st = new long[b][1 << b];
		for(int i = 0; i < a.length; i++) {
			st[0][i] = a[i];
		}
		for(int i = 1; i < b; i++) {
			for(int j = 0; j + (1 << i) <= (1 << b); j++) {
				st[i][j] = op.applyAsLong(st[i - 1][j], st[i - 1][j + (1 << (i - 1))]);
			}
		}
		lookup = new int[a.length + 1];
		for(int i = 2; i < lookup.length; i++) {
			lookup[i] = lookup[i >> 1] + 1;
		}
	}
	SparseTable(final long[] a, final LongBinaryOperator op) {
		this.op = op;
		int b = 0;
		while((1 << b) <= a.length) {
			++b;
		}
		st = new long[b][1 << b];
		for(int i = 0; i < a.length; i++) {
			st[0][i] = a[i];
		}
		for(int i = 1; i < b; i++) {
			for(int j = 0; j + (1 << i) <= (1 << b); j++) {
				st[i][j] = op.applyAsLong(st[i - 1][j], st[i - 1][j + (1 << (i - 1))]);
			}
		}
		lookup = new int[a.length + 1];
		for(int i = 2; i < lookup.length; i++) {
			lookup[i] = lookup[i >> 1] + 1;
		}
	}
	final long query(final int l, final int r) {
		final int b = lookup[r - l];
		return op.applyAsLong(st[b][l], st[b][r - (1 << b)]);
	}
	final int minLeft(final int x, final LongPredicate fn) {
		if(x == 0) {
			return 0;
		}
		int ok = x, ng = -1;
		while(Math.abs(ok - ng) > 1) {
			final int mid = (ok + ng) / 2;
			if(fn.test(query(mid, x) - 1)) {
				ok = mid;
			}
			else {
				ng = mid;
			}
		}
		return ok;
	}
	final int maxRight(final int x, final LongPredicate fn) {
		if(x == lookup.length - 1) {
			return lookup.length - 1;
		}
		int ok = x, ng = lookup.length;
		while(Math.abs(ok - ng) > 1) {
			int mid = (ok + ng) / 2;
			if(fn.test(query(x, mid))) {
				ok = mid;
			}
			else {
				ng = mid;
			}
		}
		return ok;
	}
}

final class SuffixArray extends ArrayList<Integer> {
	private final String vs;
	SuffixArray(final String vs, final boolean compress) {
		this.vs = vs;
		int[] newVS = new int[vs.length() + 1];
		if(compress) {
			final var xs = vs.chars().sorted().distinct().boxed().collect(Collectors.toList());
			for(int i = 0; i < vs.length(); ++i) {
				newVS[i] = Utility.lowerBound(xs, (int) vs.charAt(i)) + 1;
			}
		} else {
			final int d = vs.chars().min().getAsInt();
			for(int i = 0; i < vs.length(); ++i) {
				newVS[i] = vs.charAt(i) - d + 1;
			}
		}
		this.addAll(Arrays.stream(SAIS(newVS)).boxed().collect(Collectors.toList()));
	}
	private final int[] SAIS(final int[] s) {
		final int n = s.length;
		final int[] ret = new int[n];
		final boolean[] isS = new boolean[n], isLMS = new boolean[n];
		int m = 0;
		for(int i = n - 2; i >= 0; i--) {
			isS[i] = (s[i] > s[i + 1]) || (s[i] == s[i + 1] && isS[i + 1]);
			m += (isLMS[i + 1] = isS[i] && !isS[i + 1]) ? 1 : 0;
		}
		final Consumer<ArrayList<Integer>> inducedSort = (lms) -> {
			final int upper = Arrays.stream(s).max().getAsInt();
			int[] l = new int[upper + 2], r = new int[upper + 2];
			for(final var v: s) {
				++l[v + 1];
				++r[v];
			}
			Arrays.parallelPrefix(l, (x, y) -> x + y);
			Arrays.parallelPrefix(r, (x, y) -> x + y);
			Arrays.fill(ret, -1);
			for(int i = lms.size(); --i >= 0;) {
				ret[--r[s[lms.get(i)]]] = lms.get(i);
			}
			for(final var v: ret) {
				if(v >= 1 && isS[v - 1]) {
					ret[l[s[v - 1]]++] = v - 1;
				}
			}
			Arrays.fill(r, 0);
			for(final var v: s) {
				++r[v];
			}
			Arrays.parallelPrefix(r, (x, y) -> x + y);
			for(int k = ret.length - 1, i = ret[k]; k >= 1; i = ret[--k]) {
				if(i >= 1 && !isS[i - 1]) {
					ret[--r[s[i - 1]]] = i - 1;
				}
			}
		};
		final ArrayList<Integer> lms = new ArrayList<>(), newLMS = new ArrayList<>();
		for(int i = 0; ++i < n;) {
			if(isLMS[i]) {
				lms.add(i);
			}
		}
		inducedSort.accept(lms);
		for(int i = 0; i < n; ++i) {
			if(!isS[ret[i]] && ret[i] > 0 && isS[ret[i] - 1]) {
				newLMS.add(ret[i]);
			}
		}
		final BiPredicate<Integer, Integer> same = (a, b) -> {
			if(s[a++] != s[b++]) {
				return false;
			}
			while(true) {
				if(s[a] != s[b]) {
					return false;
				}
				if(isLMS[a] || isLMS[b]) {
					return isLMS[a] && isLMS[b];
				}
				a++;
				b++;
			}
		};
		int rank = 0;
		ret[n - 1] = 0;
		for(int i = 0; ++i < m;) {
			if(!same.test(newLMS.get(i - 1), newLMS.get(i))) {
				++rank;
			}
			ret[newLMS.get(i)] = rank;
		}
		if(rank + 1 < m) {
			int[] newS = new int[m];
			for(int i = 0; i < m; ++i) {
				newS[i] = ret[lms.get(i)];
			}
			final var lmsSA = SAIS(newS);
			IntStream.range(0, m).forEach(i -> newLMS.set(i, lms.get(lmsSA[i])));
		}
		inducedSort.accept(newLMS);
		return ret;
	}
	final boolean ltSubstr(final String t, int si, int ti) {
		final int sn = vs.length(), tn = t.length();
		while(si < sn && ti < tn) {
			if(vs.charAt(si) < t.charAt(ti)) {
				return true;
			}
			if(vs.charAt(si) > t.charAt(ti)) {
				return false;
			}
			++si;
			++ti;
		}
		return si >= sn && ti < tn;
	}
	final int lowerBound(final String t) {
		int ok = this.size(), ng = 0;
		while(ok - ng > 1) {
			final int mid = (ok + ng) / 2;
			if(ltSubstr(t, this.get(mid), 0)) {
				ng = mid;
			} else {
				ok = mid;
			}
		}
		return ok;
	}
	final Pair<Integer, Integer> equalRange(final String t) {
		final int low = lowerBound(t);
		int ng = low - 1, ok = this.size();
		var sb = new StringBuilder(t);
		sb.setCharAt(t.length() - 1, (char)(sb.charAt(sb.length() - 1) - 1));
		final String u = sb.toString();
		while(ok - ng > 1) {
			final int mid = (ok + ng) / 2;
			if(ltSubstr(u, this.get(mid), 0)) {
				ng = mid;
			} else {
				ok = mid;
			}
		}
		final int end = this.size() - 1;
		this.add(end, this.get(end) - 1);
		return Pair.of(low, ok);
	}
	final int[] lcpArray() {
		final int n = this.size() - 1;
		int[] lcp = new int[n + 1], rank = new int[n + 1];
		for(int i = 0; i <= n; ++i) {
			rank[this.get(i)] = i;
		}
		int h = 0;
		for(int i = 0; i <= n; ++i) {
			if(rank[i] < n) {
				final int j = this.get(rank[i] + 1);
				for(; j + h < n && i + h < n; ++h) {
					if(vs.charAt(j + h) != vs.charAt(i + h)) {
						break;
					}
				}
				lcp[rank[i] + 1] = h;
				if(h > 0) {
					h--;
				}
			}
		}
		return lcp;
	}
	@Override
	public final String toString() { 
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < this.size(); ++i) {
			sb.append(i + ":[" + this.get(i) + "]");
			for(int j = this.get(i); j < vs.length(); ++j) {
				sb.append(" " + vs.charAt(j));
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}

final class DoubleEndedPriorityQueue<T extends Number> {
	private final ArrayList<T> d;
	DoubleEndedPriorityQueue(final ArrayList<T> d) {
		this.d = d;
		makeHeap();
	}
	private final void makeHeap() {
		for(int i = d.size(); i-- > 0;) {
			if (i % 2 == 1 && d.get(i - 1).longValue() < d.get(i).longValue()) {
				Collections.swap(d, i - 1, i);
			}
			up(down(i), i);
		}
	}
	private final int down(int k) {
		final int n = d.size();
		if(k % 2 == 1) {
			while(2 * k + 1 < n) {
				int c = 2 * k + 3;
				if(n <= c || d.get(c - 2).longValue() < d.get(c).longValue()) {
					 c -= 2;
				}
				if(c < n && d.get(c).longValue() < d.get(k).longValue()) {
					Collections.swap(d, k, c);
					k = c;
				}
				else {
					break;
				}
			}
		} else {
			while(2 * k + 2 < n) {
				int c = 2 * k + 4;
				if(n <= c || d.get(c).longValue() < d.get(c - 2).longValue()) {
					c -= 2;
				}
				if(c < n && d.get(k).longValue() < d.get(c).longValue()) {
					Collections.swap(d, k, c);
					k = c;
				}
				else {
					break;
				}
			}
		}
		return k;
	}
	private final int up(int k, final int root) {
		if((k | 1) < d.size() && d.get(k & ~1).longValue() < d.get(k | 1).longValue()) {
			Collections.swap(d, k & ~1, k | 1);
			k ^= 1;
		}
		int p;
		while(root < k && d.get(p = parent(k)).longValue() < d.get(k).longValue()) {
			Collections.swap(d, p, k);
			k = p;
		}
		while(root < k && d.get(k).longValue() < d.get(p = parent(k) | 1).longValue()) {
			Collections.swap(d, p, k);
			k = p;
		}
		return k;
	}
	private final int parent(final int k){ return ((k >> 1) - 1) & ~1; }
	private final void popBack(final ArrayList<T> d){ d.remove(d.size() - 1); } 
	final void push(final T x) {
		final int k = d.size();
		d.add(x);
		up(k, 1);
	}
	final T popMin() {
		final var res = getMin();
		if(d.size() < 3) {
			popBack(d); 
		} else {
			Collections.swap(d, 1, d.size() - 1);
			popBack(d);
			up(down(1), 1);
		}
		return res;
	}
	final T popMax() {
		final var res = getMax();
		if(d.size() < 2) { 
			popBack(d);
		} else {
			Collections.swap(d, 0, d.size() - 1);
			popBack(d);
			up(down(0), 1);
		}
		return res;
	}
	final T getMin(){ return d.size() < 2 ? d.get(0) : d.get(1); }
	final T getMax(){ return d.get(0); }
	final int size(){ return d.size(); }
	final boolean isEmpty(){ return d.isEmpty(); }
}

final class SuccinctIndexableDictionary {
	private final int blk;
	private final int[] bit, sum;
	SuccinctIndexableDictionary(final int len) {
		blk = (len + 31) >> 5;
		bit = new int[blk];
		sum = new int[blk];
	}
	final void set(final int k){ bit[k >> 5] |= 1 << (k & 31); }
	final void build() {
		sum[0] = 0;
		for(int i = 0; ++i < blk;) {
			sum[i] = sum[i - 1] + Integer.bitCount(bit[i - 1]);
		}
	}
	final boolean get(final int k){ return ((bit[k >> 5] >> (k & 31)) & 1) == 1; }
	final int rank(final int k){ return (sum[k >> 5] + Integer.bitCount(bit[k >> 5] & ((1 << (k & 31)) - 1))); }
	final int rank(final boolean val, final int k){ return val ? rank(k) : k - rank(k); }
}
final class WaveletMatrixBeta {
	private final int log;
	private final SuccinctIndexableDictionary[] matrix;
	private final int[] mid;
	WaveletMatrixBeta(long[] arr, final int log) {
		final int len = arr.length;
		this.log = log;
		matrix = new SuccinctIndexableDictionary[log];
		mid = new int[log];
		final long[] l = new long[len], r = new long[len];
		for(int level = log; --level >= 0;) {
			matrix[level] = new SuccinctIndexableDictionary(len + 1);
			int left = 0, right = 0;
			for(int i = 0; i < len; ++i) {
				if(((arr[i] >> level) & 1) == 1) {
					matrix[level].set(i);
					r[right++] = arr[i];
				} else {
					l[left++] = arr[i];
				}
			}
			mid[level] = left;
			matrix[level].build();
			final long[] tmp = new long[len];
			System.arraycopy(arr, 0, tmp, 0, len);
			System.arraycopy(l, 0, arr, 0, len);
			System.arraycopy(tmp, 0, l, 0, len);
			for(int i = 0; i < right; ++i) {
				arr[left + i] = r[i];
			}
		}
	}
	private final NumPair succ(final boolean f, final int l, final int r, final int level){ return new NumPair(matrix[level].rank(f, l) + mid[level] * (f ? 1 : 0), matrix[level].rank(f, r) + mid[level] * (f ? 1 : 0)); }
	final long access(int k) {
		long ret = 0;
		for(int level = log; --level >= 0;) {
			final boolean f = matrix[level].get(k);
			if(f) {
				ret |= 1L << level;
			}
			k = matrix[level].rank(f, k) + mid[level] * (f ? 1 : 0);
		}	
		return ret;
	}
	final int rank(final long x, int r) {
		int l = 0;
		for(int level = log; --level >= 0;) {
			final var p = succ(((x >> level) & 1) == 1, l, r, level);
			l = p.first.intValue();
			r = p.second.intValue();
		}
		return r - l;
	}
	final long kthMin(int l, int r, int k) {
		if(!Utility.scope(0, k, r - l - 1)) {
			throw new IndexOutOfBoundsException();
		}
		long ret = 0;
		for(int level = log; --level >= 0;) {
			final int cnt = matrix[level].rank(false, r) - matrix[level].rank(false, l);
			final boolean f = cnt <= k;
			if(f) {
				ret |= 1 << level;
				k -= cnt;
			}
			final var p = succ(f, l, r, level);
			l = p.first.intValue();
			r = p.second.intValue();
		}
		return ret;
	}
	final long kthMax(final int l, final int r, final int k){ return kthMin(l, r, r - l - k - 1); }
	final int rangeFreq(int l, int r, final long upper) {
		int ret = 0;
		for(int level = log; --level >= 0;) {
			final boolean f = ((upper >> level) & 1) == 1;
			if(f) {
				ret += matrix[level].rank(false, r) - matrix[level].rank(false, l);
			}
			final var p = succ(f, l, r, level); 
			l = p.first.intValue();
			r = p.second.intValue();
		}
		return ret;
	}
	final int rangeFreq(final int l, final int r, final long lower, final long upper){ return rangeFreq(l, r, upper) - rangeFreq(l, r, lower); }
	final long prev(final int l, final int r, final long upper) {
		final int cnt = rangeFreq(l, r, upper);
		return cnt == 0 ? -1 : kthMin(l, r, cnt - 1);
	}
	final long next(final int l, final int r, final long lower) {
		final int cnt = rangeFreq(l, r, lower);
		return cnt == r - l ? -1 : kthMin(l, r, cnt);
	}
}
final class WaveletMatrix {
	private final WaveletMatrixBeta mat;
	private final long[] ys;
	WaveletMatrix(final long[] arr, final int log) {
		ys = Arrays.stream(arr).sorted().distinct().toArray();
		final long[] t = new long[arr.length];
		IntStream.range(0, arr.length).forEach(i -> t[i] = get(arr[i]));
		mat = new WaveletMatrixBeta(t, log);
	}
	private final int get(final long x){ return Utility.lowerBound(ys, x); }
	final long access(final int k){ return ys[(int) mat.access(k)]; }
	final int rank(final long x, final int r) {
		final var pos = get(x);
		if(pos == ys.length || ys[pos] != x) {
			return 0;
		}
		return mat.rank(pos, r);
	}
	final long kthMin(final int l, final int r, final int k){ return ys[(int) mat.kthMin(l, r, k)]; }
	final long kthMax(final int l, final int r, final int k){ return ys[(int) mat.kthMax(l, r, k)]; }
	final int rangeFreq(final int l, final int r, final long upper){ return mat.rangeFreq(l, r, get(upper)); }
	final int rangeFreq(final int l, final int r, final long lower, final long upper){ return mat.rangeFreq(l, r, get(lower), get(upper)); }
	final long prev(final int l, final int r, final long upper) {
		final var ret = mat.prev(l, r, get(upper));
		return ret == -1 ? -1 : ys[(int) ret];
	}
	final long next(final int l, final int r, final long lower) {
		final var ret = mat.next(l, r, get(lower));
		return ret == -1 ? -1 : ys[(int) ret];
	}
}