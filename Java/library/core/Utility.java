package library.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import library.pair.Pair;

public class Utility {
	protected static final String yes(final boolean ok){ return ok ? "Yes" : "No"; }
	protected static final String no(final boolean ok){ return yes(!ok); }
	protected static final long sqr(final long x){ return x * x; }
	public static final int mod(final int n, final int m){ return (n + m) % m; }
	public static final int mod(final long n, final int m){ return (int) (n + m) % m; }
	public static final long mod(final long n, final long m){ return (n + m) % m; }
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
	public static final long lcm(final long a, final long b){ return a * b / gcd(a, b); }
	public static final long lcm(final int... a){ return Arrays.stream(a).mapToLong(i -> i).reduce(1, (x, y) -> lcm(x, y)); }
	public static final long lcm(final long... a){ return Arrays.stream(a).reduce(1, (x, y) -> lcm(x, y)); }
	public static final long gcd(final long a, final long b){ return b > 0 ? gcd(b, a % b) : a; }
	public static final int gcd(final int... a){ return Arrays.stream(a).reduce(0, (x, y) -> (int) gcd(x, y)); }
	public static final long gcd(final long... a){ return Arrays.stream(a).reduce(0, (x, y) -> gcd(x, y)); }
	public static final int min(final int... a){ return Arrays.stream(a).reduce(Integer.MAX_VALUE, (x, y) -> Math.min(x, y)); }
	public static final long min(final long... a){ return Arrays.stream(a).reduce(Long.MAX_VALUE, (x, y) -> Math.min(x, y)); }
	public static final int max(final int... a){ return Arrays.stream(a).reduce(Integer.MIN_VALUE, (x, y) -> Math.max(x, y)); }
	public static final long max(final long... a){ return Arrays.stream(a).reduce(Long.MIN_VALUE, (x, y) -> Math.max(x, y)); }
	protected static final ArrayList<Long> div(final long n) {
		final ArrayList<Long> d = new ArrayList<>();
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
		final ArrayList<Pair<Long, Integer>> pf = new ArrayList<>();
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
	protected static final long factor(int n) {
		long res = 1;
		while(n > 0) {
			res *= n--;
		}
		return res;
	}
	protected static final long factor(int n, final long mod) {
		long res = 1;
		while(n > 0) {
			res *= n--;
			res %= mod;
		}
		return res;
	}
	protected static final long perm(int n, final int r) {
		final int og = n;
		long res = 1;
		while(n > og - r) {
			res *= n--;
		}
		return res;
	}
	protected static final long perm(int n, final int r, final long mod) {
		final int og = n;
		long res = 1;
		while(n > og - r) {
			res *= n--;
			res %= mod; 
		}
		return res;
	}
	protected static final long binom(int n, final int r) {
		if(r < 0 || n < r) {
			return 0;
		}
		long res = 1;
		for(int i = 1; i <= r; ++i) {
			res *= n--;
			res /= i;
		}
		return res;
	}
	protected static final long binom(int n, final int r, final long mod) {
		if(r < 0 || n < r) {
			return 0;
		}
		long res = 1;
		for(int i = 1; i <= r; ++i) {
			res *= n--;
			res %= mod;
			res /= i;
			res %= mod;
		}
		return res;
	}
	protected static final boolean isInt(final double n){ long r = (long) Math.floor(n); return r == n; }
	protected static final boolean isSqr(final long n){ return isInt(Math.sqrt(n)); }
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
	public static final boolean scope(final int l, final int x, final int r){ return l <= x && x <= r; }
	public static final boolean scope(final long l, final long x, final long r){ return l <= x && x <= r; }
	public static final boolean scope(final double l, final double x, final double r){ return l <= x && x <= r; }
	protected static final int clamp(final int l, final int x, final int r){ return x < l ? l : x > r ? r : x; }
	protected static final long clamp(final long l, final long x, final long r){ return x < l ? l : x > r ? r : x; }
	protected static final double clamp(final double l, final double x, final double r){ return x < l ? l : x > r ? r : x; }
	protected static final int[] nextPerm(final int[] a) {
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
	protected static final long[] nextPerm(final long[] a) {
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
	protected static final double[] nextPerm(final double[] a) {
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
	protected static final String nextPerm(final String s) {
		final List<Character> a = s.chars().mapToObj(i -> (char) i).collect(Collectors.toList());
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
	protected static final int[] prevPerm(final int[] a) {
		for(int i = a.length; --i > 0;) {
			if(a[i - 1] > a[i]) {
				final int j = findRev(a[i - 1], a, i, a.length - 1);
				swap(a, i - 1, j);
				Arrays.sort(a, i, a.length);
				return reverse(a);
			}
		}
		return null;
	}
	protected static final long[] prevPerm(final long[] a) {
		for(int i = a.length; --i > 0;) {
			if(a[i - 1] > a[i]) {
				final int j = findRev(a[i - 1], a, i, a.length - 1);
				swap(a, i - 1, j);
				Arrays.sort(a, i, a.length);
				return reverse(a);
			}
		}
		return null;
	}
	protected static final double[] prevPerm(final double[] a) {
		for(int i = a.length; --i > 0;) {
			if(a[i - 1] > a[i]) {
				final int j = findRev(a[i - 1], a, i, a.length - 1);
				swap(a, i - 1, j);
				Arrays.sort(a, i, a.length);
				return reverse(a);
			}
		}
		return null;
	}
	protected static final String prevPerm(final String s) {
		final List<Character> a = s.chars().mapToObj(i -> (char)i).collect(Collectors.toList());
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
	protected static final int find(final String s, final char c) {
		for(int i = 0; i < s.length(); ++i) {
			if(s.charAt(i) == c) {
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
	protected static final int findRev(final String s, final char c) {
		for(int i = s.length(); --i >= 0;) {
			if(s.charAt(i) == c) {
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
	public static final boolean binarySearch(final int[] a, final int x){ return Arrays.binarySearch(a, x) >= 0; }
	public static final boolean binarySearch(final long[] a, final long x){ return Arrays.binarySearch(a, x) >= 0; }
	public static final <T extends Comparable<? super T>> boolean binarySearch(final T[] a, final T x){ return Arrays.binarySearch(a, x) >= 0; }
	public static final <T extends Comparable<? super T>> boolean binarySearch(final List<T> a, final T x){ return Collections.binarySearch(a, x, null) >= 0; }
	public static final int lowerBound(final int[] a, final int x){ return bins(a.length, -1, (IntPredicate) y -> a[y] >= x); }
	public static final int lowerBound(final long[] a, final long x){ return bins(a.length, -1, (IntPredicate) y -> a[y] >= x); }
	public static final <T extends Comparable<? super T>> int lowerBound(final T[] a, final T x){ return lowerBound(Arrays.asList(a), x); }
	public static final <T extends Comparable<? super T>> int lowerBound(final List<T> a, final T x){ return ~Collections.binarySearch(a, x, (p, q) -> p.compareTo(q) >= 0 ? 1 : -1); }
	public static final int upperBound(final int[] a, final int x){ return bins(a.length, -1, (IntPredicate) y -> a[y] > x); }
	public static final int upperBound(final long[] a, final long x){ return bins(a.length, -1, (IntPredicate) y -> a[y] > x); }
	public static final <T extends Comparable<? super T>> int upperBound(final T[] a, final T x){ return upperBound(Arrays.asList(a), x); }
	public static final <T extends Comparable<? super T>> int upperBound(final List<T> a, final T x){ return ~Collections.binarySearch(a, x, (p, q) -> p.compareTo(q) > 0 ? 1 : -1); }
	public static final String sorted(final String s){ return s.chars().sorted().mapToObj(Character::toString).collect(Collectors.joining()); }
	public static final int[] sorted(final int[] a){ return Arrays.stream(a).sorted().toArray(); }
	public static final long[] sorted(final long[] a){ return Arrays.stream(a).sorted().toArray(); }
	public static final double[] sorted(final double[] a){ return Arrays.stream(a).sorted().toArray(); }
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
	protected static final Object[] reverse(final Object[] a) {
		final int n = a.length;
		final Object[] b = new Object[n];
		for(int i = 0; i <= n / 2; ++i) {
			b[i] = a[n - 1 - i];
			b[n - 1 - i] = a[i];
		}
		return b;
	}
	public static final int[] rotate(final int[] a, final int id) {
		final List<Integer> t = Arrays.stream(a).boxed().collect(Collectors.toList());
		Collections.rotate(t, id);
		final int[] res = new int[a.length];
		for(int i = 0; i < a.length; ++i) {
			res[i] = t.get(i);
		}
		return res;
	}
	public static final long[] rotate(final long[] a, final int id) {
		final List<Long> t = Arrays.stream(a).boxed().collect(Collectors.toList());
		Collections.rotate(t, id);
		final long[] res = new long[a.length];
		for(int i = 0; i < a.length; ++i) {
			res[i] = t.get(i);
		}
		return res;
	}
	public static final double[] rotate(final double[] a, final int id) {
		final List<Double> t = Arrays.stream(a).boxed().collect(Collectors.toList());
		Collections.rotate(t, id);
		final double[] res = new double[a.length];
		for(int i = 0; i < a.length; ++i) {
			res[i] = t.get(i);
		}
		return res;
	}
	public static final String rotate(final String s, final int id) {
		final List<Character> t = s.chars().mapToObj(i -> (char) i).collect(Collectors.toList());
		Collections.rotate(t, id);
		return t.stream().map(i -> i.toString()).collect(Collectors.joining());
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
	protected static final String[] rotateR(final String[] s) {
		final int h = s.length, w = s[0].length();
		final char[][] t = new char[w][h];
		IntStream.range(0, h).forEach(i -> {
			IntStream.range(0, w).forEach(j -> t[j][i] = s[i].charAt(j));
		});
		IntStream.range(0, w).forEach(i -> t[i] = new StringBuilder(new String(t[i])).reverse().toString().toCharArray());
		final String[] res = new String[w];
		Arrays.setAll(res, i -> String.valueOf(t[i]));
		return res;
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
	protected static final String[] rotateL(final String[] s) {
		final int h = s.length, w = s[0].length();
		final char[][] t = new char[w][h];
		IntStream.range(0, h).forEach(i -> {
			IntStream.range(0, w).forEach(j -> t[w - j - 1][i] = s[i].charAt(j));
		});
		final String[] res = new String[w];
		Arrays.setAll(res, i -> String.valueOf(t[i]));
		return res;
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
	protected static final <F extends Comparable<? super F>, S extends Comparable<? super S>> List<F> first(final List<Pair<F, S>> p){ return p.stream().map(i -> i.first).collect(Collectors.toList()); }
	protected static final <F extends Comparable<? super F>, S extends Comparable<? super S>> List<S> second(final List<Pair<F, S>> p){ return p.stream().map(i -> i.second).collect(Collectors.toList()); }
	public static final int[] iota(final int n){ return IntStream.range(0, n).toArray(); }
	public static final int[] iota(final int n, final int init){ return IntStream.range(0 + init, n + init).toArray(); }
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
	protected static final int[] press(final int[] a) {
		final int[] res = new int[a.length];
		final int[] x = Arrays.stream(a).sorted().distinct().toArray();
		for(int i = 0; i < a.length; ++i) {
			res[i] = lowerBound(x, a[i]);
		}
		return res;
	}
	protected static final int[] press(final long[] a) {
		final int[] res = new int[a.length];
		final long[] x = Arrays.stream(a).sorted().distinct().toArray();
		for(int i = 0; i < a.length; ++i) {
			res[i] = lowerBound(x, a[i]);
		}
		return res;
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
	public static final long kthRoot(final long n, final int k) {
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
		final long phi = eulerPhi(m);
		long tmp = tetration(a, b - 1, phi);
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
	protected interface RecursiveFunction<T, U> {
		public U apply(final RecursiveFunction<T, U> rec, final T n);
	}
	protected interface RecursiveBiFunction<T, U, V> {
		public V apply(final RecursiveBiFunction<T, U, V> rec, final T n, final U m);
	}
	protected interface RecursiveTriFunction<T, U, V, W> {
		public W apply(final RecursiveTriFunction<T, U, V, W> rec, final T p, final U q, final V r);
	}
	protected interface RecursiveUnaryOperator<T> {
		public T apply(final RecursiveUnaryOperator<T> rec, final T n);
	}
	protected interface RecursiveBinaryOperator<T> {
		public T apply(final RecursiveBinaryOperator<T> rec, final T a, final T b);
	}
}