import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.stream.IntStream;

class VvyLw extends MyFunction {
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
		final long n = sc.nl();
		final BigPrime bp = new BigPrime(n);
		final var ans = bp.primeFactor(n);
		o.print(ans.size());
		if(!ans.isEmpty()) {
			o.print(" ");
			o.out(ans);
		}
		else {
			o.out();
		}
	}
}
class Main extends VvyLw {
	public static void main(final String[] args) {
		int t = 1;
		t = sc.ni();
		while(t-- > 0) {
			solve();
		}
		o.flush();
		sc.close();
		o.close();
		e.close();
	}
}

class MyFunction {
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
	protected static ArrayList<Long> primeFactor(long n) {
		ArrayList<Long> pf = new ArrayList<>();
		for(long i = 2; i * i <= n; ++i) {
			if(n % i != 0) continue;
			while(n % i == 0) {
				pf.add(i);
				n /= i;
			}
		}
		if(n != 1) pf.add(n);
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
	protected static boolean nextPerm(ArrayList<Integer> a) {
		for(int i = a.size() - 1; i > 0; i--) {
			if(a.get(i - 1).compareTo(a.get(i)) < 0) {
				final int j = find(a.get(i - 1), a, i, a.size() - 1);
				Collections.swap(a, i - 1, j);
				Collections.sort(a.subList(i, a.size()));
				return true;
			}
		}
		return false;
	}
	private static <T extends Comparable<? super T>> int find(T dest, ArrayList<T> a, int s, int e) {
		if (s == e) return s;
		final int m = (s + e + 1) / 2;
		return a.get(m).compareTo(dest) <= 0 ? find(dest, a, s, m - 1):find(dest, a, m, e);
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
	protected static int[] rotate(final int[] a, final int id) {
		ArrayList<Integer> t = new ArrayList<>();
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
	protected static long lcm(final long a, final long b){ return a * b / gcd(a, b); }
	protected static long gcd(final long a, final long b){ return b > 0 ? gcd(b, a % b) : a; }
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
	void out(final char[] args){ IntStream.range(0, args.length).forEach(i -> pw.print(args[i] + (i + 1 < args.length ? " " : "\n"))); }
	void out(final Object[] args){ IntStream.range(0, args.length).forEach(i -> pw.print(args[i] + (i + 1 < args.length ? " " : "\n"))); }
	<T> void out(final List<T> args){ IntStream.range(0, args.size()).forEach(i -> pw.print(args.get(i) + (i + 1 < args.size() ? " " : "\n"))); }
	void outl(final Object head, final Object... tail) {
		out(head);
		Arrays.stream(tail).forEach(pw::println);
	}
	void outl(final int[] args){ Arrays.stream(args).forEach(pw::println); }
	void outl(final long[] args){ Arrays.stream(args).forEach(pw::println); }
	void outl(final double[] args){ Arrays.stream(args).forEach(pw::println); }
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

class NumPair extends Pair<Number, Number> {
	NumPair(final Number first, final Number second){ super(first, second); }
	NumPair rotate(){ return new NumPair(-second.doubleValue(), first.doubleValue()); } 
	NumPair rotate(final int ang) {
		final double rad = Math.PI * MyFunction.mod(ang, 360) / 180;
		return new NumPair(first.doubleValue() * Math.cos(rad) - second.doubleValue() * Math.sin(rad),
							first.doubleValue() * Math.sin(rad) + second.doubleValue() * Math.cos(rad));
	}
	long dot(final NumPair p){ return first.longValue() * p.first.longValue() + second.longValue() + p.second.longValue(); }
	long cross(final NumPair p){ return this.rotate().dot(p); }
	long square(){ return this.dot(this); }
	double grad() { 
		try {
			return second.doubleValue() / first.doubleValue();
		} catch(ArithmeticException e) {
			e.printStackTrace();
			return Double.NaN;
		}
	}
	double abs(){ return Math.hypot(first.doubleValue(), second.doubleValue()); }
	double lcm(){ return MyFunction.lcm(first.longValue(), second.longValue()); }
	double gcd(){ return MyFunction.gcd(first.longValue(), second.longValue()); }
	NumPair extgcd() {
		long x = 1, y = 0, t1 = 0, t2 = 0, t3 = 1, a = first.longValue(), b = second.longValue();
		while(b > 0) {
			t1=a / b;
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
		for(int i = 0; i < n; ++i) {
			res.add(new ArrayList<>());
		}
		for(int i = 0; i < n; ++i) {
			res.get(root(i)).add(i);
		}
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

class BigPrime {
	private long n;
	BigPrime(final long n){ this.n = n; }
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
	boolean isPrime() {
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
	private long find() {
		if(isPrime()) {
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
		final long x = find();
		if(x == n) return new ArrayList<>(Arrays.asList(x));
		ArrayList<Long> le = primeFactor(x);
		final ArrayList<Long> ri = primeFactor(n / x);
		le.addAll(ri);
		return le;
	}
}