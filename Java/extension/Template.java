package extension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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
	protected static final void solve() {
		final int n = sc.ni(), q = sc.ni();
		final var a = sc.nl(n);
		final var wm = new WaveletMatrix(a, 18);
		IntStream.range(0, q).forEach(i -> {
			o.out(wm.kthSmallest(sc.ni(), sc.ni(), sc.ni()));
		});
	}
}
final class Main extends VvyLw {
	public static final void main(final String[] args) {
		int t = 1;
		//t = sc.ni();
		while(t-- > 0) {
			solve();
		}
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
	protected static final int mod(final long n, final int m){ return (int) ((n + m) % m); }
	protected static final long intCeil(long a, long b){ return (long) Math.ceil((double)a / b); }
	protected static final long intPow(long a, int b) {
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
	protected static final long intPow(long a, long b, final int m) {
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
	protected static final boolean nextPerm(ArrayList<? extends Number> a) {
		for(int i = a.size() - 1; i > 0; i--) {
			if(a.get(i - 1).longValue() < a.get(i).longValue()) {
				final int j = find(a.get(i - 1).longValue(), a, i, a.size() - 1);
				Collections.swap(a, i - 1, j);
				Collections.sort(a.subList(i, a.size()), (x, y) -> Long.compare(x.longValue(), y.longValue()));
				return true;
			}
		}
		return false;
	}
	protected static final String nextPerm(final String s) {
		var a = s.chars().mapToObj(i -> (char)i).collect(Collectors.toList());
		for(int i = a.size() - 1; i > 0; i--) {
			if(a.get(i - 1).compareTo(a.get(i)) < 0) {
				final int j = find(a.get(i - 1), a, i, a.size() - 1);
				Collections.swap(a, i - 1, j);
				Collections.sort(a.subList(i, a.size()));
				return a.stream().map(String::valueOf).collect(Collectors.joining());
			}
		}
		return null;
	}
	protected static final boolean prevPerm(ArrayList<? extends Number> a) {
		for(int i = a.size() - 1; i > 0; i--) {
			if(a.get(i - 1).longValue() > a.get(i).longValue()) {
				final int j = findRev(a.get(i - 1).longValue(), a, i, a.size() - 1);
				Collections.swap(a, i - 1, j);
				Collections.sort(a.subList(i, a.size()), Collections.reverseOrder());
				return true;
			}
		}
		return false;
	}
	protected static final String prevPerm(final String s) {
		var a = s.chars().mapToObj(i -> (char)i).collect(Collectors.toList());
		for(int i = a.size() - 1; i > 0; i--) {
			if(a.get(i - 1).compareTo(a.get(i)) > 0) {
				final int j = findRev(a.get(i - 1), a, i, a.size() - 1);
				Collections.swap(a, i - 1, j);
				Collections.sort(a.subList(i, a.size()), Collections.reverseOrder());
				return a.stream().map(String::valueOf).collect(Collectors.joining());
			}
		}
		return null;
	}
	private static final int find(final long dest, final List<? extends Number> a, final int s, final int e) {
		if(s == e) {
			return s;
		}
		final int m = (s + e + 1) / 2;
		return a.get(m).longValue() <= dest ? find(dest, a, s, m - 1) : find(dest, a, m, e);
	}
	private static final int find(final char dest, final List<Character> a, final int s, final int e) {
		if(s == e) {
			return s;
		}
		final int m = (s + e + 1) / 2;
		return a.get(m).compareTo(dest) <= 0 ? find(dest, a, s, m - 1) : find(dest, a, m, e);
	}
	private static final int findRev(final long dest, final List<? extends Number> a, final int s, final int e) {
		if(s == e) {
			return s;
		}
		final int m = (s + e + 1) / 2;
		return a.get(m).longValue() > dest ? findRev(dest, a, s, m - 1) : findRev(dest, a, m, e);
	}
	private static final int findRev(final char dest, final List<Character> a, final int s, final int e) {
		if(s == e) {
			return s;
		}
		final int m = (s + e + 1) / 2;
		return a.get(m).compareTo(dest) > 0 ? find(dest, a, s, m - 1) : find(dest, a, m, e);
	}
	protected static final boolean binarySearch(final int[] a, final int x) {
		return Arrays.binarySearch(a, x) >= 0;
	}
	protected static final boolean binarySearch(final long[] a, final long x) {
		return Arrays.binarySearch(a, x) >= 0;
	}
    protected static final boolean binarySearch(final Object[] a, final Object x) {
        return binarySearch(Arrays.stream(a).collect(Collectors.toList()), x);
    }
	protected static final int lowerBound(final int[] a, final int x) {
		return lowerBound(Arrays.stream(a).boxed().collect(Collectors.toList()), x);
	}
	protected static final int lowerBound(final long[] a, final long x) {
		return lowerBound(Arrays.stream(a).boxed().collect(Collectors.toList()), x);
	}
    protected static final <T extends Comparable<? super T>> int lowerBound(final T[] a, final T x) {
		return lowerBound(Arrays.asList(a), x);
	}
	protected static final int upperBound(final int[] a, final int x) {
		return upperBound(Arrays.stream(a).boxed().collect(Collectors.toList()), x);
	}
	protected static final int upperBound(final long[] a, final long x) {
		return upperBound(Arrays.stream(a).boxed().collect(Collectors.toList()), x);
	}
    protected static final <T extends Comparable<? super T>> int upperBound(final T[] a, final T x) {
		return upperBound(Arrays.asList(a), x);
	}
	protected static final <T> boolean binarySearch(final List<T> a, final T x) {
		return Collections.binarySearch(a, x, null) >= 0;
	}
	protected static final <T extends Comparable<? super T>> int lowerBound(final List<T> a, final T x) {
		return ~Collections.binarySearch(a, x, (p, q) -> p.compareTo(q) >= 0 ? 1 : -1);
	}
	protected static final <T extends Comparable<? super T>> int upperBound(final List<T> a, final T x) {
		return ~Collections.binarySearch(a, x, (p, q) -> p.compareTo(q) > 0 ? 1 : -1);
	}
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
		ArrayList<Integer> t = new ArrayList<>(a.length);
		for(final var el: a) {
			t.add(el);
		}
		Collections.rotate(t, id);
		int[] res = new int[t.size()];
		for(int i = 0; i < t.size(); ++i) {
			res[i] = t.get(i);
		}
		return res;
	}
	protected static final long[] rotate(final long[] a, final int id) {
		ArrayList<Long> t = new ArrayList<>(a.length);
		for(final var el: a) {
			t.add(el);
		}
		Collections.rotate(t, id);
		long[] res = new long[t.size()];
		for(int i = 0; i < t.size(); ++i) {
			res[i] = t.get(i);
		}
		return res;
	}
	protected static final double[] rotate(final double[] a, final int id) {
		ArrayList<Double> t = new ArrayList<>(a.length);
		for(final var el: a) {
			t.add(el);
		}
		Collections.rotate(t, id);
		double[] res = new double[t.size()];
		for(int i = 0; i < t.size(); ++i) {
			res[i] = t.get(i);
		}
		return res;
	}
	protected static final String rotate(final String s, final int id) {
		ArrayList<Character> t = new ArrayList<>();
		for(final char c: s.toCharArray()) {
			t.add(c);
		}
		Collections.rotate(t, id);
		StringBuilder sb = new StringBuilder();
		for(final var c: t) {
			sb.append(c);
		}
		return sb.toString(); 
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
	protected static final long lcm(final long a, final long b){ return a * b / gcd(a, b); }
	protected static final long gcd(final long a, final long b){ return b > 0 ? gcd(b, a % b) : a; }
	protected static final long lcm(final long... a){ return Arrays.stream(a).reduce(1, (x, y) -> lcm(x, y)); }
	protected static final long gcd(final long... a){ return Arrays.stream(a).reduce(0, (x, y) -> gcd(x, y)); }
	protected static final long min(final long... a){ return Arrays.stream(a).reduce(Long.MAX_VALUE, (x, y) -> Math.min(x, y)); }
	protected static final long max(final long... a){ return Arrays.stream(a).reduce(Long.MIN_VALUE, (x, y) -> Math.max(x, y)); }
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
	protected static final long bins(long ok, long ng, final Predicate<Long> fn) {
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
	protected static final ArrayList<Integer> press(final ArrayList<Long> a) {
		ArrayList<Integer> res = new ArrayList<>();
		final var cp = a.stream().sorted().distinct().collect(Collectors.toList());
		for(final var el: a) {
			res.add(lowerBound(cp, el));
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
		final Predicate<Long> chk = (x) -> {
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
}