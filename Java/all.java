import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
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
	protected static void solve() {
		final int n = sc.ni(), q = sc.ni();
		final var s = sc.nia(n);
		var depq = new DoubleEndedPriorityQueue<>(s);
		IntStream.range(0, q).forEach(i -> {
			final int t = sc.ni();
			if(t == 0) {
				depq.push(sc.ni());
			} else if(t == 1) {
				o.out(depq.popMin());
			} else {
				o.out(depq.popMax());
			}
		});
	}
}
class Main extends VvyLw {
	public static void main(final String[] args) {
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
	protected static String yes(final boolean ok){ return ok ? "Yes" : "No"; }
	protected static String no(final boolean ok){ return yes(!ok); }
	protected static long sqr(final long x){ return x * x; }
	protected static int mod(final long n, final int m){ return (int) ((n + m) % m); }
	protected static long intCeil(long a, long b){ return (long) Math.ceil((double)a / b); }
	protected static long intPow(long a, int b) {
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
	protected static long intPow(long a, long b, final int m) {
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
	protected static ArrayList<Long> div(final long n) {
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
	protected static ArrayList<Pair<Long, Integer>> primeFactor(long n) {
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
	protected static long binom(int a, final int b) {
		long res = 1;
		for(int i = 1; i <= b; ++i) {
			res *= a--;
			res /= i;
		}
		return res;
	}
	protected static boolean isInt(final double n){ long r = (long) Math.floor(n); return r == n; }
	protected static boolean isSqr(final long n){ return isInt(Math.sqrt(n)); }
	protected static boolean isPrime(final long n) {
		if(n == 1) return false;
		for(long i = 2; i * i <= n; ++i) {
			if(n % i == 0) return false;
		}
		return true;
	}
	protected static boolean nextPerm(ArrayList<? extends Number> a) {
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
	protected static String nextPerm(final String s) {
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
	protected static boolean prevPerm(ArrayList<? extends Number> a) {
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
	protected static String prevPerm(final String s) {
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
	private static int find(final long dest, final List<? extends Number> a, final int s, final int e) {
		if(s == e) {
			return s;
		}
		final int m = (s + e + 1) / 2;
		return a.get(m).longValue() <= dest ? find(dest, a, s, m - 1) : find(dest, a, m, e);
	}
	private static int find(final char dest, final List<Character> a, final int s, final int e) {
		if(s == e) {
			return s;
		}
		final int m = (s + e + 1) / 2;
		return a.get(m).compareTo(dest) <= 0 ? find(dest, a, s, m - 1) : find(dest, a, m, e);
	}
	private static int findRev(final long dest, final List<? extends Number> a, final int s, final int e) {
		if(s == e) {
			return s;
		}
		final int m = (s + e + 1) / 2;
		return a.get(m).longValue() > dest ? findRev(dest, a, s, m - 1) : findRev(dest, a, m, e);
	}
	private static int findRev(final char dest, final List<Character> a, final int s, final int e) {
		if(s == e) {
			return s;
		}
		final int m = (s + e + 1) / 2;
		return a.get(m).compareTo(dest) > 0 ? find(dest, a, s, m - 1) : find(dest, a, m, e);
	}
	protected static boolean binarySearch(final int[] a, final int x) {
		return Arrays.binarySearch(a, x) >= 0;
	}
	protected static boolean binarySearch(final long[] a, final long x) {
		return Arrays.binarySearch(a, x) >= 0;
	}
	protected static int lowerBound(final List<Integer> a, final int x) {
		return ~Collections.binarySearch(a, x, (p, q) -> p.compareTo(q) >= 0 ? 1 : -1);
	}
	protected static int lowerBound(final List<Long> a, final long x) {
		return ~Collections.binarySearch(a, x, (p, q) -> p.compareTo(q) >= 0 ? 1 : -1);
	}
	protected static int upperBound(final List<Integer>a, final int x) {
		return ~Collections.binarySearch(a, x, (p, q) -> p.compareTo(q) > 0 ? 1 : -1);
	}
	protected static int upperBound(final List<Long> a, final long x) {
		return ~Collections.binarySearch(a, x, (p, q) -> p.compareTo(q) > 0 ? 1 : -1);
	}
	protected static int[] reverse(final int[] a) {
		final int n = a.length;
		int[] b = new int[n];
		for(int i = 0; i <= n / 2; ++i) {
			b[i] = a[n - 1 - i];
			b[n - 1 - i] = a[i];
		}
		return b;
	}
	protected static long[] reverse(final long[] a) {
		final int n = a.length;
		long[] b = new long[n];
		for(int i = 0; i <= n / 2; ++i) {
			b[i] = a[n - 1 - i];
			b[n - 1 - i] = a[i];
		}
		return b;
	}
	protected static double[] reverse(final double[] a) {
		final int n = a.length;
		double[] b = new double[n];
		for(int i = 0; i <= n / 2; ++i) {
			b[i] = a[n - 1 - i];
			b[n - 1 - i] = a[i];
		}
		return b;
	}
	protected static Object[] reverse(final Object[] a) {
		final int n = a.length;
		Object[] b = new Object[n];
		for(int i = 0; i <= n / 2; ++i) {
			b[i] = a[n - 1 - i];
			b[n - 1 - i] = a[i];
		}
		return b;
	}
	protected static int[] rotate(final int[] a, final int id) {
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
	protected static long[] rotate(final long[] a, final int id) {
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
	protected static double[] rotate(final double[] a, final int id) {
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
	protected static String rotate(final String s, final int id) {
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
	protected static int[][] rotate(final int[][] a) {
		final int h = a.length, w = a[0].length;
		int[][] b = new int[w][h];
		IntStream.range(0, h).forEach(i -> {
			IntStream.range(0, w).forEach(j -> b[j][i] = a[i][j]);
		});
		IntStream.range(0, w).forEach(i -> b[i] = reverse(b[i]));
		return b;
	}
	protected static long[][] rotate(final long[][] a) {
		final int h = a.length, w = a[0].length;
		long[][] b = new long[w][h];
		IntStream.range(0, h).forEach(i -> {
			IntStream.range(0, w).forEach(j -> b[j][i] = a[i][j]);
		});
		IntStream.range(0, w).forEach(i -> b[i] = reverse(b[i]));
		return b;
	}
	protected static double[][] rotate(final double[][] a) {
		final int h = a.length, w = a[0].length;
		double[][] b = new double[w][h];
		IntStream.range(0, h).forEach(i -> {
			IntStream.range(0, w).forEach(j -> b[j][i] = a[i][j]);
		});
		IntStream.range(0, w).forEach(i -> b[i] = reverse(b[i]));
		return b;
	}
	protected static String[] rotate(final String[] s) {
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
	protected static long lcm(final long a, final long b){ return a * b / gcd(a, b); }
	protected static long gcd(final long a, final long b){ return b > 0 ? gcd(b, a % b) : a; }
	protected static long lcm(final long... a){ return Arrays.stream(a).reduce(1, (x, y) -> lcm(x, y)); }
	protected static long gcd(final long... a){ return Arrays.stream(a).reduce(0, (x, y) -> gcd(x, y)); }
	protected static long min(final long... a){ return Arrays.stream(a).reduce(Long.MAX_VALUE, (x, y) -> Math.min(x, y)); }
	protected static long max(final long... a){ return Arrays.stream(a).reduce(Long.MIN_VALUE, (x, y) -> Math.max(x, y)); }
	protected static <F, S> ArrayList<F> first(final List<Pair<F, S>> p) {
		ArrayList<F> f = new ArrayList<>();
		for(final var el: p) {
			f.add(el.first);
		}
		return f;
	}
	protected static <F, S> ArrayList<S> second(final List<Pair<F, S>> p) {
		ArrayList<S> s = new ArrayList<>();
		for(final var el: p) {
			s.add(el.second);
		}
		return s;
	}
	protected static int[] iota(final int n){ return IntStream.range(0, n).toArray(); }
	protected static int[] iota(final int n, final int init){ return IntStream.range(0 + init, n + init).toArray(); }
	protected static long bins(long ok, long ng, final Predicate<Long> fn) {
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
	protected static ArrayList<Integer> press(final ArrayList<Long> a) {
		ArrayList<Integer> res = new ArrayList<>();
		final var cp = a.stream().sorted().distinct().collect(Collectors.toList());
		for(final var el: a) {
			res.add(lowerBound(cp, el));
		}
		return res;
	}
	protected static int[] zAlgorithm(final String s) {
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
	protected static int[] manacher(final String s_, final boolean calcEven) {
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
	protected static long kthRoot(final long n, final int k) {
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

class MyScanner {
	private Scanner sc = new Scanner(System.in);
	int ni(){ return sc.nextInt(); }
	long nl(){ return sc.nextLong(); }
	double nd(){ return sc.nextDouble(); }
	String ns(){ return sc.next(); }
	int[] ni(final int n){
		int[] a = new int[n];
		IntStream.range(0, n).forEach(i -> a[i] = ni());
		return a;
	}
	long[] nl(final int n){
		long[] a = new long[n];
		IntStream.range(0, n).forEach(i -> a[i] = nl());
		return a;
	}
	double[] nd(final int n){
		double[] a = new double[n];
		IntStream.range(0, n).forEach(i -> a[i] = nd());
		return a;
	}
	String[] ns(final int n){
		String[] a = new String[n];
		IntStream.range(0, n).forEach(i -> a[i] = ns());
		return a;
	}
	ArrayList<Integer> nia(final int n) {
		var a = new ArrayList<Integer>(n);
		IntStream.range(0, n).forEach(i -> a.add(i, ni()));
		return a;
	}
	ArrayList<Long> nla(final int n) {
		var a = new ArrayList<Long>(n);
		IntStream.range(0, n).forEach(i -> a.add(i, nl()));
		return a;
	}
	ArrayList<Double> nda(final int n) {
		var a = new ArrayList<Double>(n);
		IntStream.range(0, n).forEach(i -> a.add(i, nd()));
		return a;
	}
	ArrayList<String> nsa(final int n) {
		var a = new ArrayList<String>(n);
		IntStream.range(0, n).forEach(i -> a.add(i, ns()));
		return a;
	}
	void close(){ sc.close(); }
}

class MyPrinter {
	private PrintWriter pw;
	MyPrinter(final OutputStream os, final boolean flush){ pw = new PrintWriter(os, flush); }
	void print(final Object arg){ pw.print(arg); }
	void out(){ pw.println(); }
	void out(final Object head, final Object... tail) {
		pw.print(head);
		for(final var el: tail) {
			pw.print(" " + el);
		}
		out();
	}
	<F, S> void out(final Pair<F, S> arg){ pw.println(arg.first + " " + arg.second); }
	void out(final int[] args){ IntStream.range(0, args.length).forEach(i -> pw.print(args[i] + (i + 1 < args.length ? " " : "\n"))); }
	void out(final long[] args){ IntStream.range(0, args.length).forEach(i -> pw.print(args[i] + (i + 1 < args.length ? " " : "\n"))); }
	void out(final double[] args){ IntStream.range(0, args.length).forEach(i -> pw.print(args[i] + (i + 1 < args.length ? " " : "\n"))); }
	void out(final boolean[] args){ IntStream.range(0, args.length).forEach(i -> pw.print(args[i] + (i + 1 < args.length ? " " : "\n"))); }
	void out(final char[] args){ IntStream.range(0, args.length).forEach(i -> pw.print(args[i] + (i + 1 < args.length ? " " : "\n"))); }
	void out(final Object[] args){ IntStream.range(0, args.length).forEach(i -> pw.print(args[i] + (i + 1 < args.length ? " " : "\n"))); }
	<T> void out(final List<T> args){ IntStream.range(0, args.size()).forEach(i -> pw.print(args.get(i) + (i + 1 < args.size() ? " " : "\n"))); }
	void outl(final Object head, final Object... tail) {
		out(head);
		Arrays.stream(tail).forEach(pw::println);
	}
	void outl(final int[] args){ Arrays.stream(args).forEach(pw::println); }
	void outl(final int[][] args){ IntStream.range(0, args.length).forEach(i -> out(args[i])); }
	void outl(final long[] args){ Arrays.stream(args).forEach(pw::println); }
	void outl(final long[][] args){ IntStream.range(0, args.length).forEach(i -> out(args[i])); }
	void outl(final double[] args){ Arrays.stream(args).forEach(pw::println); }
	void outl(final double[][] args){ IntStream.range(0, args.length).forEach(i -> out(args[i])); }
	void outl(final boolean[] args){ IntStream.range(0, args.length).forEach(i -> out(args[i])); }
	void outl(final boolean[][] args){ IntStream.range(0, args.length).forEach(i -> out(args[i])); }
	void outl(final char[] args){ IntStream.range(0, args.length).forEach(i -> out(args[i])); }
	void outl(final Object[] args){ Arrays.stream(args).forEach(pw::println); }
	<E> void outl(final Collection<E> args){ args.stream().forEach(pw::println); }
	void fin(final Object head, final Object... tail) {
		out(head, tail);
		flush();
		System.exit(0);
	}
	<T> void fin(final List<T> args) {
		out(args);
		flush();
		System.exit(0);
	}
	<E> void fine(final Collection<E> args) {
		outl(args);
		flush();
		System.exit(0);
	}
	void flush(){ pw.flush(); }
	void close(){ pw.close(); }
}

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

class UnionFind {
	private int[] par;
	UnionFind(final int n) {
		par = new int[n];
		Arrays.fill(par, -1);
	}
	int root(final int i){ return par[i] >= 0 ? par[i] = root(par[i]) : i; }
	int size(final int i){ return -par[root(i)]; }
	boolean unite(int i, int j) {
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
	boolean same(final int i, final int j){ return root(i) == root(j); }
	ArrayList<ArrayList<Integer>> groups() {
		final int n = par.length;
		ArrayList<ArrayList<Integer>> res = new ArrayList<>(n);
		IntStream.range(0, n).forEach(i -> res.add(new ArrayList<>()));
		IntStream.range(0, n).forEach(i -> res.get(root(i)).add(i));
		res.removeIf(ArrayList::isEmpty);
		return res;
	}
	boolean is_bipartite() {
		final int n = par.length / 2;
		boolean ok = true;
		for(int i = 0; i < n; ++i) {
			ok &= root(i) != root(i + n);
		}
		return ok;
	}
}

class WeightedUnionFind {
	private int[] par;
	private long[] weight;
	WeightedUnionFind(final int n) {
		par = new int[n];
		weight = new long[n];
		Arrays.fill(par, -1);
	}
	int root(final int i) {
		if(par[i] < 0) {
			return i;
		}
		final int r = root(par[i]);
		weight[i] += weight[par[i]];
		return par[i] = r;
	}
	long get(final int i) {
		root(i);
		return weight[i];
	}
	long diff(final int x, final int y){ return get(y) - get(x); }
	int unite(int x, int y, long w) {
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
	boolean same(final int x, final int y){ return root(x) == root(y); }
}

class UndoUnionFind {
	private int[] par;
	private Stack<Pair<Integer, Integer>> his;
	UndoUnionFind(final int n) {
	    par = new int[n];
	    Arrays.fill(par, -1);
	    his = new Stack<>();
	}
	boolean unite(int x, int y) {
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
	int root(final int i) {
		if(par[i] < 0) {
			return i;
		}
		return root(par[i]);
	}
	int size(final int i){ return -par[root(i)]; }
	void undo() {
		final Pair<Integer, Integer> pop1 = his.pop(), pop2 = his.pop();
		par[pop1.first] = pop1.second;
		par[pop2.first] = pop2.second;
	}
	void snapshot() {
		while(!his.empty()) {
			his.pop();
		}
	}
	void rollback() {
		while(!his.empty()) {
			undo();
		}
	}
}

class Edge {
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
	public boolean equals(final Object o) {
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
	public int hashCode() {
		int result = 17;
		result = 31 * result + src;
		result = 31 * result + to;
		result = 31 * result + (int) (cost ^ (cost >>> 32)); // XOR for long values
		return result;
	}
	@Override
	public String toString(){ return src + " " + to + " " + cost; }
}
class Graph extends ArrayList<ArrayList<Edge>> {
	protected boolean undirected;
	protected int n, indexed;
	Graph(final int n, final int indexed, final boolean undirected) {
		this.n = n;
		this.indexed = indexed;
		this.undirected = undirected;
		IntStream.range(0, n).forEach(i -> this.add(new ArrayList<>()));
	}
	void addEdge(int a, int b) {
		a -= indexed;
		b -= indexed;
		this.get(a).add(new Edge(b));
		if(undirected) {
			this.get(b).add(new Edge(a));
		}
	}
	protected int[] allDist(final int v) {
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
	protected int dist(final int u, final int v){ return allDist(u)[v]; }
}
class WeightedGraph extends Graph {
	WeightedGraph(final int n, final int indexed, final boolean undirected) {
		super(n, indexed, undirected);
	}
	void addEdge(int a, int b, final long cost) {
		a -= indexed;
		b -= indexed;
		this.get(a).add(new Edge(b, cost));
		if(undirected) {
			this.get(b).add(new Edge(a, cost));
		}
	}
	long[] dijkstra(final int v) {
		long[] cost = new long[n];
		Arrays.fill(cost, Long.MAX_VALUE);
		Queue<NumPair> dj = new PriorityQueue<>(Collections.reverseOrder());
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
	long[][] warshallFloyd() {
		long[][] cost = new long[n][n];
		IntStream.range(0, n).forEach(i -> Arrays.fill(cost[i], Long.MAX_VALUE));
		IntStream.range(0, n).forEach(i -> cost[i][i] = 0);
		for(int i = 0; i < n; ++i) {
			for(final var j: this.get(i)) {
				cost[i][j.to] = j.cost;
			}
		}
		for(int k = 0 ; k < n; ++k) {
			for(int i = 0; i < n; ++i) {
				for(int j = 0; j < n; ++j) {
					if(cost[i][j] > cost[i][k] + cost[k][j]) {
						cost[i][j] = cost[i][k] + cost[k][j];
					}
				}
			}
		}
		return cost;
	}
}
class Tree {
	private ArrayList<Edge> edge;
	private int n, indexed;
	Tree(final int n, final int indexed) {
		edge = new ArrayList<>(n);
		this.n = n;
		this.indexed = indexed;
	}
	void addEdge(final int a, final int b, final long cost){ edge.add(new Edge(a - indexed, b - indexed, cost)); }
	long kruskal() {
		Collections.sort(edge, Comparator.comparing(e -> e.cost));
		UnionFind uf = new UnionFind(n);
		long res = 0;
		for(final var ed: edge) {
			if(uf.unite(ed.src, ed.to)) {
				res += ed.cost;
			}
		}
		return res;
	}
}

class LowestCommonAncestor<G extends Graph> {
	private int log;
	int[] dep;
	private G g;
	int[][] table;
	LowestCommonAncestor(final G g) {
		this.g = g;
		final int n = g.size();
		dep = new int[n];
		log = Integer.toBinaryString(n).length();
		table = new int[log][n];
		IntStream.range(0, log).forEach(i -> Arrays.fill(table[i], -1));
		build();
	}
	private void dfs(final int idx, final int par, final int d) {
		table[0][idx] = par;
		dep[idx] = d;
		for(final var el: g.get(idx)) {
			if(el.to != par) {
				dfs(el.to, idx, d + 1);
			}
		}
	}
	private void build() {
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
	int query(int u, int v) {
		if(dep[u] > dep[v]) {
			u ^= v;
			v ^= u;
			u ^= v;
		}
		for(int i = log; --i >= 0;) {
			if(((dep[v] - dep[u]) >> i) % 2 == 1) {
				v = table[i][v];
			}
		}
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
	int dist(final int u, final int v){ return dep[u] + dep[v] - 2 * query(u, v); }
}

class PrimeTable {
	private int n;
	private boolean[] sieve;
	PrimeTable(final int n) {
		this.n = n;
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
	}
	boolean[] table(){ return sieve; }
	ArrayList<Integer> get() {
		ArrayList<Integer> p = new ArrayList<>();
		for(int i = 2; i <= n; ++i) {
			if(sieve[i]) {
				p.add(i);
			}
		}
		return p;
	}
}

class PrimeFactor {
	private int[] spf;
	PrimeFactor(final int n) {
		spf = IntStream.rangeClosed(0, n).toArray();
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
	TreeMap<Integer, Integer> get(int n) {
		TreeMap<Integer, Integer> m = new TreeMap<>();
		while(n != 1) {
			m.merge(spf[n], 1, (a, b) -> (a + b));
			n /= spf[n];
		}
		return m;
	}
}

class PrimeCounter {
	private int sq;
	private boolean[] p;
	private int[] psum;
	private ArrayList<Integer> ps;
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
	private long kthRooti(final long n, final int k){ return Utility.kthRoot(n, k); }
	private long p2(final long x, final long y) {
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
	private long phi(final long m, final long a) {
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
	long pi(final long n) {
		if(n <= sq) {
			return psum[(int) n];
		}
		final long m = kthRooti(n, 3);
		final long a = pi(m);
		return phi(n, a) + a - 1 - p2(n, m);
	}
}

// N <= 1e18;
class LongPrime {
	private int bsf(final long x){ return Long.numberOfTrailingZeros(x); }
	private long gcd(long a, long b) {
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
	boolean isPrime(final long n) {
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
	private long find(final long n) {
		if(isPrime(n)) {
			return n;
		}
		if(n % 2 == 0) {
			return 2;
		}
		long st = 0;
		final BiFunction<Long, Long, Long> f = (x, y) -> { return BigInteger.valueOf(x).multiply(BigInteger.valueOf(x)).add(BigInteger.valueOf(y)).mod(BigInteger.valueOf(n)).longValue(); };
		while(true) {
			st++;
			long x = st, y = f.apply(x, st);
			while(true) {
				final long p = gcd(y - x + n, n);
				if(p == 0 || p == n) {
					break;
				}
				if(p != 1) {
					return p;
				}
				x = f.apply(x, st);
				y = f.apply(f.apply(y, st), st);
			}
		}
	}
	ArrayList<Long> primeFactor(final long n) {
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
class BigPrime {
	protected int bsf(final long x){ return Long.numberOfTrailingZeros(x); }
	private BigInteger gcd(BigInteger a, BigInteger b) {
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
	boolean isPrime(final BigInteger n) {
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
	private BigInteger find(final BigInteger n) {
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
	ArrayList<BigInteger> primeFactor(final BigInteger n) {
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

class PrefixSum {
	private int n;
	private long[] s;
	PrefixSum(final int[] a) {
		n = a.length;
		s = new long[n + 1];
		IntStream.range(0, n).forEach(i -> s[i + 1] = s[i] + a[i]);
	}
	PrefixSum(final long[] a) {
		n = a.length;
		s = new long[n + 1];
		IntStream.range(0, n).forEach(i -> s[i + 1] = s[i] + a[i]);
	}
	long[] get(){ return s; }
	long query(final int l, final int r){ return s[r] - s[l]; }
}

class FenwickTree {
	private int n;
	private long[] data;
	FenwickTree(final int n) {
		this.n = n + 2;
		data = new long[this.n + 1];
	}
	long sum(int k) {
		if(k < 0) return 0;
		long ret = 0;
		for(++k; k > 0; k -= k & -k) {
			ret += data[k];
		}
		return ret;
	}
	long sum(final int l, final int r){ return sum(r) - sum(l - 1); }
	long get(final int k){ return sum(k) - sum(k - 1); }
	void add(int k, final long x) {
		for(++k; k < n; k += k & -k) {
			data[k] += x;
		}
	}
	void imos(final int l, final int r, long x) {
		add(l, x);
		add(r + 1, -x);
	}
	private int lg(final int n){ return 63 - Integer.numberOfLeadingZeros(n); }
	int lowerBound(long w) {
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
	int upper_bound(long w) {
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

class SegmentTree {
	private int n = 1, rank = 0, fini;
	private BinaryOperator<Long> op;
	private long e;
	private long[] dat;
	SegmentTree(final int fini, final BinaryOperator<Long> op, final long e) {
		this.fini = fini;
		this.op = op;
		this.e = e;
		while(this.fini > n) {
			n <<= 1;
			rank++;
		}
		dat = new long[2 * n];
		Arrays.fill(dat, e);
	}
	void update(int i, final long x) {
		i += n;
		dat[i] = x;
		do {
			i >>= 1;
			dat[i] = op.apply(dat[2 * i], dat[2 * i + 1]);
		} while(i > 0);
	}
	void add(int i, final long x) {
		i += n;
		dat[i] += x;
		do {
			i >>= 1;
			dat[i] = op.apply(dat[2 * i], dat[2 * i + 1]);
		} while(i > 0);
	}
	long query(int a, int b) {
		long l=e,r=e;
		for(a += n, b += n; a < b; a >>= 1, b >>= 1) {
			if(a % 2 == 1) {
				l = op.apply(l, dat[a++]);
			}
			if(b % 2 == 1) {
				r = op.apply(dat[--b], r);
			}
		}
		return op.apply(l,r);
	}
	int findLeft(int r, final Predicate<Long> fn) {
		if(r == 0) {
			return 0;
		}
		int h = 0, i = r + n;
		long val = e;
		for(; h <= rank; h++) {
			if(i >> (h & 1) > 0) {
				final long val2 = op.apply(val, dat[i >> (h ^ 1)]);
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
			long val2 = op.apply(val, dat[(i >> h) - 1]);
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
	int findRight(int l, final Predicate<Long> fn) {
		if(l == fini) {
			return fini;
		}
		int h = 0, i = l + n;
		long val = e;
		for(; h <= rank; h++) {
			if(i >> (h & 1) > 0){
				long val2 = op.apply(val, dat[i >> h]);
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
			long val2 = op.apply(val, dat[i>>h]);
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

class SparseTable {
	private long[][] st;
	private int[] lookup;
	private BinaryOperator<Long> op;
	SparseTable(final int[] a, final BinaryOperator<Long> op) {
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
				st[i][j] = op.apply(st[i - 1][j], st[i - 1][j + (1 << (i - 1))]);
			}
		}
		lookup = new int[a.length + 1];
		for(int i = 2; i < lookup.length; i++) {
			lookup[i] = lookup[i >> 1] + 1;
		}
	}
	SparseTable(final long[] a, final BinaryOperator<Long> op) {
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
				st[i][j] = op.apply(st[i - 1][j], st[i - 1][j + (1 << (i - 1))]);
			}
		}
		lookup = new int[a.length + 1];
		for(int i = 2; i < lookup.length; i++) {
			lookup[i] = lookup[i >> 1] + 1;
		}
	}
	long query(final int l, final int r) {
		final int b = lookup[r - l];
		return op.apply(st[b][l], st[b][r - (1 << b)]);
	}
	int minLeft(final int x, final Predicate<Long> fn) {
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
	int maxRight(final int x, final Predicate<Long> fn) {
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

class SuffixArray extends ArrayList<Integer> {
	private String vs;
	SuffixArray(final String vs, final boolean compress) {
		this.vs = vs;
		int[] newVS = new int[vs.length() + 1];
		if(compress) {
			final var xs = vs.chars().sorted().distinct().boxed().collect(Collectors.toList());
			for(int i = 0; i < vs.length(); ++i) {
				newVS[i] = Utility.lowerBound(xs, vs.charAt(i)) + 1;
			}
		} else {
			final int d = vs.chars().min().getAsInt();
			for(int i = 0; i < vs.length(); ++i) {
				newVS[i] = vs.charAt(i) - d + 1;
			}
		}
		this.addAll(Arrays.stream(SAIS(newVS)).boxed().collect(Collectors.toList()));
	}
	private int[] SAIS(final int[] s) {
		final int n = s.length;
		int[] ret = new int[n];
		boolean[] isS = new boolean[n], isLMS = new boolean[n];
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
		ArrayList<Integer> lms = new ArrayList<>(), newLMS = new ArrayList<>();
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
	boolean ltSubstr(final String t, int si, int ti) {
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
	int lowerBound(final String t) {
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
	Pair<Integer, Integer> equalRange(final String t) {
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
	int[] lcpArray() {
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
	public String toString() { 
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

class DoubleEndedPriorityQueue<T extends Number> {
	private Queue<NumPair> pq1;
	private Queue<NumPair> pq2;
	private int idx;
	private ArrayList<Boolean> used;
	DoubleEndedPriorityQueue(final ArrayList<T> depq) {
		final int n = depq.size();
		used = new ArrayList<>();
		IntStream.range(0, n).forEach(i -> used.add(true));
		idx = n;
		pq1 = new PriorityQueue<>(Collections.reverseOrder());
		pq2 = new PriorityQueue<>();
		IntStream.range(0, n).forEach(i -> {
			pq1.add(new NumPair(depq.get(i), i));
			pq2.add(new NumPair(depq.get(i), i));
		});
	}
	Number popMax() {
		while(!used.get(pq1.peek().second.intValue()) && used.get(pq1.peek().second.intValue()) != null) {
			pq1.poll();
		}
		final var res = pq1.poll();
		used.set(res.second.intValue(), false);
		return res.first;
	}
	Number popMin() {
		while(!used.get(pq2.peek().second.intValue()) && used.get(pq2.peek().second.intValue()) != null) {
			pq2.poll();
		}
		final var res = pq2.poll();
		used.set(res.second.intValue(), false);
		return res.first;
	}
	void push(final T x) {
		pq1.add(new NumPair(x, idx));
		pq2.add(new NumPair(x, idx));
		used.add(true);
		idx++;
	}
	Number getMax(){ return pq1.peek().first; }
	Number getMin(){ return pq2.peek().first; }
}