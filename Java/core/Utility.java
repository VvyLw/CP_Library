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

import library.structure.pair.FloatPair;
import library.structure.pair.IntPair;
import library.structure.pair.Pair;

/**
 * 便利なメソッド集
 * Pairクラス以外の外部クラス不使用
 */
public class Utility {
	/**
	 * 古のYESNOパターンやyesnoパターンの時は{@link String#toUpperCase}や{@link String#toLowerCase}を使うと良い
	 * @param ok boolean
	 * @return okがtrueなら"Yes" falseなら"No"
	 */
	protected static final String yes(final boolean ok){ return ok ? "Yes" : "No"; }
	/**
	 * {@link #yes}の逆
	 * @param ok boolean
	 * @return okがtrueなら"No" falseなら"Yes"
	 */
	protected static final String no(final boolean ok){ return yes(!ok); }
	/**
	 * @param x
	 * @return xの平方数
	 */
	protected static final long sqr(final long x){ return x * x; }
	/**
	 * nが負の時でも正の剰余を求める
	 * @param n int
	 * @param m int
	 */
	public static final long mod(long n, final long m) {
		n %= m;
		return n < 0 ? n + m : n;
	}
	/**
	 * a / bの商を小数点以下切り上げで求める
	 * @param a
	 * @param b
	 */
	protected static final long ceil(final long a, final long b){ return (a - 1) / b + 1; }
	/**
	 * a / bを小数点c桁で四捨五入して求める
	 * @param a
	 * @param b
	 * @param c
	 */
	protected static final double round(final double a, final long b, final int c) {
		final long d = pow(10, c);
		return Math.rint((a * d) / b) / d;
	}
	/**
	 * @param a
	 * @param b
	 * @return aのb乗
	 */
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
	/**
	 * @param a
	 * @param b
	 * @return aのb乗のmを法とした剰余
	 */
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
	/**
	 * @param a
	 * @param b
	 * @return aとbの最小公倍数
	 */
	public static final long lcm(final long a, final long b){ return a * b / gcd(a, b); }
	/**
	 * e.g.) lcm(2, 3, 5) = 30
	 * @param a int型タプル あるいはint型配列
	 * @return aの最小公倍数
	 */
	public static final long lcm(final int... a){ return Arrays.stream(a).mapToLong(i -> i).reduce(1, (x, y) -> lcm(x, y)); }
	/**
	 * @param a long型タプル あるいはlong型配列
	 * @return aの最小公倍数
	 */
	public static final long lcm(final long... a){ return Arrays.stream(a).reduce(1, (x, y) -> lcm(x, y)); }
	/**
	 * @param a
	 * @param b
	 * @return aとbの最大公約数
	 */
	public static final long gcd(final long a, final long b){ return b > 0 ? gcd(b, a % b) : a; }
	/**
	 * e.g.) gcd(12, 15, 24) = 3
	 * @param a int型タプル あるいはint型配列
	 * @return aの最大公約数
	 */
	public static final int gcd(final int... a){ return Arrays.stream(a).reduce(0, (x, y) -> (int) gcd(x, y)); }
	/**
	 * e.g.) gcd(12, 15, 24) = 3
	 * @param a long型タプル あるいはlong型配列
	 * @return aの最大公約数
	 */
	public static final long gcd(final long... a){ return Arrays.stream(a).reduce(0, (x, y) -> gcd(x, y)); }
	/**
	 * @param a int型タプル あるいはint型配列
	 * @return aの最小値
	 */
	public static final int min(final int... a){ return Arrays.stream(a).reduce(Integer.MAX_VALUE, (x, y) -> Math.min(x, y)); }
	/**
	 * @param a long型タプル あるいはlong型配列
	 * @return aの最小値
	 */
	public static final long min(final long... a){ return Arrays.stream(a).reduce(Long.MAX_VALUE, (x, y) -> Math.min(x, y)); }
	/**
	 * @param a int型タプル あるいはint型配列
	 * @return aの最大値
	 */
	public static final int max(final int... a){ return Arrays.stream(a).reduce(Integer.MIN_VALUE, (x, y) -> Math.max(x, y)); }
	/**
	 * @param a long型タプル あるいはlong型配列
	 * @return aの最大値
	 */
	public static final long max(final long... a){ return Arrays.stream(a).reduce(Long.MIN_VALUE, (x, y) -> Math.max(x, y)); }
	/**
	 * nの約数を列挙
	 * @param n 整数
	 */
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
	/**
	 * nを素因数分解
	 * e.g.) primeFactor(24) = [(2, 3), (3, 1)]
	 * @param n 整数
	 */
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
	/**
	 * @param n 整数
	 * @return 1からnまでの整数のうちnと互いに素なものの個数
	 */
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
	/**
	 * @param n 整数
	 * @return nの階乗
	 */
	protected static final long factor(int n) {
		long res = 1;
		while(n > 0) {
			res *= n--;
		}
		return res;
	}
	/**
	 * @param n
	 * @param mod
	 * @return nの階乗のmodを法とする剰余
	 */
	protected static final long factor(int n, final long mod) {
		long res = 1;
		while(n > 0) {
			res *= n--;
			res %= mod;
		}
		return res;
	}
	/**
	 * @param n
	 * @param r
	 * @return 順列(nPr)
	 */
	protected static final long perm(int n, final int r) {
		final int og = n;
		long res = 1;
		while(n > og - r) {
			res *= n--;
		}
		return res;
	}
	/**
	 * @param n
	 * @param r
	 * @param mod
	 * @return 順列のmodを法とする剰余
	 */
	protected static final long perm(int n, final int r, final long mod) {
		final int og = n;
		long res = 1;
		while(n > og - r) {
			res *= n--;
			res %= mod; 
		}
		return res;
	}
	/**
	 * @param n
	 * @param r
	 * @return 二項係数(nCr)
	 */
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
	/**
	 * @param n
	 * @param r
	 * @param mod
	 * @return 二項係数のmodを法とする剰余
	 */
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
	/**
	 * nが整数かどうか判定
	 * @param n
	 */
	protected static final boolean isInt(final double n){ long r = (long) Math.floor(n); return r == n; }
	/**
	 * nが平方数かどうか判定
	 * @param n
	 */
	protected static final boolean isSqr(final long n){ return isInt(Math.sqrt(n)); }
	/**
	 * nが素数かどうか判定
	 * @param n
	 */
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
	/**
	 * @param l
	 * @param x
	 * @param r
	 * @return l <= x <= r
	 */
	public static final boolean scope(final int l, final int x, final int r){ return l <= x && x <= r; }
	/**
	 * @param l
	 * @param x
	 * @param r
	 * @return l <= x <= r
	 */
	public static final boolean scope(final long l, final long x, final long r){ return l <= x && x <= r; }
	/**
	 * @param l
	 * @param x
	 * @param r
	 * @return l <= x <= r
	 */
	public static final boolean scope(final double l, final double x, final double r){ return l <= x && x <= r; }
	/**
	 * @param l
	 * @param x
	 * @param r
	 * @see <a href="https://cpprefjp.github.io/reference/algorithm/clamp.html">std::clamp</a>
	 */
	protected static final int clamp(final int l, final int x, final int r){ return x < l ? l : x > r ? r : x; }
	/**
	 * @param l
	 * @param x
	 * @param r
	 * @see <a href="https://cpprefjp.github.io/reference/algorithm/clamp.html">std::clamp</a>
	 */
	protected static final long clamp(final long l, final long x, final long r){ return x < l ? l : x > r ? r : x; }
	/**
	 * @param l
	 * @param x
	 * @param r
	 * @see <a href="https://cpprefjp.github.io/reference/algorithm/clamp.html">std::clamp</a>
	 */
	protected static final double clamp(final double l, final double x, final double r){ return x < l ? l : x > r ? r : x; }
	/**
	 * How to Use:
	 * do {
	 * 
	 * } while((a = nextPerm(a)) != null);
	 * @param a
	 * @see <a href="https://cpprefjp.github.io/reference/algorithm/next_permutation.html">std::next_permutation</a>
	 */
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
	/**
	 * @param a
	 * @see <a href="https://cpprefjp.github.io/reference/algorithm/next_permutation.html">std::next_permutation</a>
	 */
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
	/**
	 * @param a
	 * @see <a href="https://cpprefjp.github.io/reference/algorithm/next_permutation.html">std::next_permutation</a>
	 */
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
	/**
	 * @param s
	 * @see <a href="https://cpprefjp.github.io/reference/algorithm/next_permutation.html">std::next_permutation</a>
	 */
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
	/**
	 * How to Use:
	 * do {
	 * 
	 * } while((a = prevPerm(a)) != null);
	 * @param a
	 * @see <a href="https://cpprefjp.github.io/reference/algorithm/prev_permutation.html">std::prev_permutation</a>
	 */
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
	/**
	 * @param a
	 * @see <a href="https://cpprefjp.github.io/reference/algorithm/prev_permutation.html">std::prev_permutation</a>
	 */
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
	/**
	 * @param a
	 * @see <a href="https://cpprefjp.github.io/reference/algorithm/prev_permutation.html">std::prev_permutation</a>
	 */
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
	/**
	 * @param s
	 * @see <a href="https://cpprefjp.github.io/reference/algorithm/prev_permutation.html">std::prev_permutation</a>
	 */
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
	/**
	 * 配列aの中にxがあれば何番目にあるか
	 * 存在しない場合, -1を返す
	 * @param a
	 * @param x
	 * @see <a href="https://cpprefjp.github.io/reference/algorithm/find.html">std::find</a>
	 */
	protected static final int find(final int[] a, final int x) {
		for(int i = 0; i < a.length; ++i) {
			if(a[i] == x) {
				return i;
			}
		}
		return -1;
	}
	/**
	 * 配列aの中にxがあれば何番目にあるか
	 * 存在しない場合, -1を返す
	 * @param a
	 * @param x
	 * @see <a href="https://cpprefjp.github.io/reference/algorithm/find.html">std::find</a>
	 */
	protected static final int find(final long[] a, final long x) {
		for(int i = 0; i < a.length; ++i) {
			if(a[i] == x) {
				return i;
			}
		}
		return -1;
	}
	/**
	 * 配列aの中にxがあれば何番目にあるか
	 * 存在しない場合, -1を返す
	 * @param a
	 * @param x
	 * @see <a href="https://cpprefjp.github.io/reference/algorithm/find.html">std::find</a>
	 */
	protected static final int find(final double[] a, final double x) {
		for(int i = 0; i < a.length; ++i) {
			if(a[i] == x) {
				return i;
			}
		}
		return -1;
	}
	/**
	 * 配列sの中にcがあれば何番目にあるか
	 * 存在しない場合, -1を返す
	 * @param s
	 * @param c
	 * @see <a href="https://cpprefjp.github.io/reference/string/basic_string/find.html">std::basic_string::find</a>
	 */
	protected static final int find(final char[] s, final char c) {
		for(int i = 0; i < s.length; ++i) {
			if(s[i] == c) {
				return i;
			}
		}
		return -1;
	}
	/**
	 * 配列aの中にxがあれば何番目にあるか
	 * 存在しない場合, -1を返す
	 * @param a
	 * @param x
	 */
	protected static final int find(final Object[] a, final Object x) {
		for(int i = 0; i < a.length; ++i) {
			if(a[i].equals(x)) {
				return i;
			}
		}
		return -1;
	}
	/**
	 * 配列aの中にxがあれば後ろから何番目にあるか
	 * 存在しない場合, -1を返す
	 * @param a
	 * @param x
	 */
	protected static final int findRev(final int[] a, final int x) {
		for(int i = a.length; --i >= 0;) {
			if(a[i] == x) {
				return i;
			}
		}
		return -1;
	}
	/**
	 * 配列aの中にxがあれば後ろから何番目にあるか
	 * 存在しない場合, -1を返す
	 * @param a
	 * @param x
	 */
	protected static final int findRev(final long[] a, final long x) {
		for(int i = a.length; --i >= 0;) {
			if(a[i] == x) {
				return i;
			}
		}
		return -1;
	}
	/**
	 * 配列aの中にxがあれば後ろから何番目にあるか
	 * 存在しない場合, -1を返す
	 * @param a
	 * @param x
	 */
	protected static final int findRev(final double[] a, final double x) {
		for(int i = a.length; --i >= 0;) {
			if(a[i] == x) {
				return i;
			}
		}
		return -1;
	}
	/**
	 * 配列sの中にcがあれば後ろから何番目にあるか
	 * 存在しない場合, -1を返す
	 * @param s
	 * @param c
	 */
	protected static final int findRev(final char[] s, final char c) {
		for(int i = s.length; --i >= 0;) {
			if(s[i] == c) {
				return i;
			}
		}
		return -1;
	}
	/**
	 * 配列aの中にxがあれば後ろから何番目にあるか
	 * 存在しない場合, -1を返す
	 * @param a
	 * @param x
	 */
	protected static final int findRev(final Object[] a, final Object x) {
		for(int i = a.length; --i >= 0;) {
			if(a[i].equals(x)) {
				return i;
			}
		}
		return -1;
	}
	/**
	 * C++のstd::binarySearchに相当するメソッド
	 * @param a
	 * @param x
	 * @see <a href="https://cpprefjp.github.io/reference/algorithm/binary_search.html">std::binary_search</a>
	 */
	public static final boolean binarySearch(final int[] a, final int x){ return Arrays.binarySearch(a, x) >= 0; }
	/**
	 * @param a
	 * @param x
	 * @see <a href="https://cpprefjp.github.io/reference/algorithm/binary_search.html">std::binary_search</a>
	 */
	public static final boolean binarySearch(final long[] a, final long x){ return Arrays.binarySearch(a, x) >= 0; }
	/**
	 * @param <T>
	 * @param a
	 * @param x
	 * @see <a href="https://cpprefjp.github.io/reference/algorithm/binary_search.html">std::binary_search</a>@return
	 */
	public static final <T extends Comparable<? super T>> boolean binarySearch(final T[] a, final T x){ return Arrays.binarySearch(a, x) >= 0; }
	/**
	 * @param <T>
	 * @param a
	 * @param x
	 * @see <a href="https://cpprefjp.github.io/reference/algorithm/binary_search.html">std::binary_search</a>
	 */
	public static final <T extends Comparable<? super T>> boolean binarySearch(final List<T> a, final T x){ return Collections.binarySearch(a, x, null) >= 0; }
	/**
	 * C++のstd::lower_boundに相当するメソッド
	 * @param a
	 * @param x
	 * @return その値以上の要素が初めて現れるインデックス(イテレータではない)
	 * @see <a href="https://cpprefjp.github.io/reference/algorithm/lower_bound.html">std::lower_bound</a>
	 */
	public static final int lowerBound(final int[] a, final int x){ return bins(a.length, -1, (IntPredicate) y -> a[y] >= x); }
	/**
	 * @param a
	 * @param x
	 * @return その値以上の要素が初めて現れるインデックス(イテレータではない)
	 * @see <a href="https://cpprefjp.github.io/reference/algorithm/lower_bound.html">std::lower_bound</a>
	 */
	public static final int lowerBound(final long[] a, final long x){ return bins(a.length, -1, (IntPredicate) y -> a[y] >= x); }
	/**
	 * @param <T>
	 * @param a
	 * @param x
	 * @return その値以上の要素が初めて現れるインデックス(イテレータではない)
	 * @see <a href="https://cpprefjp.github.io/reference/algorithm/lower_bound.html">std::lower_bound</a>
	 */
	public static final <T extends Comparable<? super T>> int lowerBound(final T[] a, final T x){ return lowerBound(Arrays.asList(a), x); }
	/**
	 * @param <T>
	 * @param a
	 * @param x
	 * @return その値以上の要素が初めて現れるインデックス(イテレータではない)
	 * @see <a href="https://cpprefjp.github.io/reference/algorithm/lower_bound.html">std::lower_bound</a>
	 */
	public static final <T extends Comparable<? super T>> int lowerBound(final List<T> a, final T x){ return ~Collections.binarySearch(a, x, (p, q) -> p.compareTo(q) >= 0 ? 1 : -1); }
	/**
	 * C++のstd::upper_boundに相当するメソッド
	 * @param a
	 * @param x
	 * @return その値より大きい要素が初めて現れるインデックス(イテレータではない)
	 * @see <a href="https://cpprefjp.github.io/reference/algorithm/upper_bound.html">std::upper_bound</a>
	 */
	public static final int upperBound(final int[] a, final int x){ return bins(a.length, -1, (IntPredicate) y -> a[y] > x); }
	/**
	 * @param a
	 * @param x
	 * @return その値より大きい要素が初めて現れるインデックス(イテレータではない)
	 * @see <a href="https://cpprefjp.github.io/reference/algorithm/upper_bound.html">std::upper_bound</a>
	 */
	public static final int upperBound(final long[] a, final long x){ return bins(a.length, -1, (IntPredicate) y -> a[y] > x); }
	/**
	 * @param a
	 * @param x
	 * @return その値より大きい要素が初めて現れるインデックス(イテレータではない)
	 * @see <a href="https://cpprefjp.github.io/reference/algorithm/upper_bound.html">std::upper_bound</a>
	 */
	public static final <T extends Comparable<? super T>> int upperBound(final T[] a, final T x){ return upperBound(Arrays.asList(a), x); }
	/**
	 * @param a
	 * @param x
	 * @return その値より大きい要素が初めて現れるインデックス(イテレータではない)
	 * @see <a href="https://cpprefjp.github.io/reference/algorithm/upper_bound.html">std::upper_bound</a>
	 */
	public static final <T extends Comparable<? super T>> int upperBound(final List<T> a, final T x){ return ~Collections.binarySearch(a, x, (p, q) -> p.compareTo(q) > 0 ? 1 : -1); }
	/**
	 * @param s
	 * @return 昇順にソートした文字列
	 */
	public static final String sorted(final String s){ return s.chars().sorted().mapToObj(Character::toString).collect(Collectors.joining()); }
	/**
	 * @param a
	 * @return 昇順にソートしたint型配列
	 */
	public static final int[] sorted(final int[] a){ return Arrays.stream(a).sorted().toArray(); }
	/**
	 * @param a
	 * @return 昇順にソートしたlong型配列
	 */
	public static final long[] sorted(final long[] a){ return Arrays.stream(a).sorted().toArray(); }
	/**
	 * @param a
	 * @return 昇順にソートしたdouble型配列
	 */
	public static final double[] sorted(final double[] a){ return Arrays.stream(a).sorted().toArray(); }
	/**
	 * @param s
	 * @return 逆順に並び替えた文字列
	 */
	protected static final String reverse(final String s){ return new StringBuilder(s).reverse().toString(); }
	/**
	 * @param a
	 * @return 逆順に並び替えたint型配列
	 */
	protected static final int[] reverse(final int[] a) {
		final int n = a.length;
		final int[] b = new int[n];
		for(int i = 0; i <= n / 2; ++i) {
			b[i] = a[n - 1 - i];
			b[n - 1 - i] = a[i];
		}
		return b;
	}
	/**
	 * @param a
	 * @return 逆順に並び替えたlong型配列
	 */
	protected static final long[] reverse(final long[] a) {
		final int n = a.length;
		final long[] b = new long[n];
		for(int i = 0; i <= n / 2; ++i) {
			b[i] = a[n - 1 - i];
			b[n - 1 - i] = a[i];
		}
		return b;
	}
	/**
	 * @param a
	 * @return 逆順に並び替えたdouble型配列
	 */
	protected static final double[] reverse(final double[] a) {
		final int n = a.length;
		final double[] b = new double[n];
		for(int i = 0; i <= n / 2; ++i) {
			b[i] = a[n - 1 - i];
			b[n - 1 - i] = a[i];
		}
		return b;
	}
	/**
	 * @param a
	 * @return 逆順に並び替えたObjectクラスの配列
	 */
	protected static final Object[] reverse(final Object[] a) {
		final int n = a.length;
		final Object[] b = new Object[n];
		for(int i = 0; i <= n / 2; ++i) {
			b[i] = a[n - 1 - i];
			b[n - 1 - i] = a[i];
		}
		return b;
	}
	/**
	 * C++のstd::rotateに相当するメソッド
	 * @param a
	 * @param id
	 * @see <a href="https://cpprefjp.github.io/reference/algorithm/rotate.html">std::rotate</a>
	 */
	public static final int[] rotate(final int[] a, final int id) {
		final List<Integer> t = Arrays.stream(a).boxed().collect(Collectors.toList());
		Collections.rotate(t, id);
		return t.stream().mapToInt(i -> i).toArray();
	}
	/**
	 * @param a
	 * @param id
	 * @see <a href="https://cpprefjp.github.io/reference/algorithm/rotate.html">std::rotate</a>
	 */
	public static final long[] rotate(final long[] a, final int id) {
		final List<Long> t = Arrays.stream(a).boxed().collect(Collectors.toList());
		Collections.rotate(t, id);
		return t.stream().mapToLong(i -> i).toArray();
	}
	/**
	 * @param a
	 * @param id
	 * @see <a href="https://cpprefjp.github.io/reference/algorithm/rotate.html">std::rotate</a>
	 */
	public static final double[] rotate(final double[] a, final int id) {
		final List<Double> t = Arrays.stream(a).boxed().collect(Collectors.toList());
		Collections.rotate(t, id);
		return t.stream().mapToDouble(i -> i).toArray();
	}
	/**
	 * @param s
	 * @param id
	 * @see <a href="https://cpprefjp.github.io/reference/algorithm/rotate.html">std::rotate</a>
	 */
	public static final String rotate(final String s, final int id) {
		final List<Character> t = s.chars().mapToObj(i -> (char) i).collect(Collectors.toList());
		Collections.rotate(t, id);
		return t.stream().map(String::valueOf).collect(Collectors.joining());
	}
	/**
	 * @param a
	 * @return 二次元配列を右回転させたもの
	 */
	protected static final int[][] rotateR(final int[][] a) {
		final int h = a.length, w = a[0].length;
		final int[][] b = new int[w][h];
		IntStream.range(0, h).forEach(i -> {
			Arrays.setAll(b[i], j -> a[j][i]);
		});
		IntStream.range(0, w).forEach(i -> b[i] = reverse(b[i]));
		return b;
	}
	/**
	 * @param a
	 * @return 二次元配列を右回転させたもの
	 */
	protected static final long[][] rotateR(final long[][] a) {
		final int h = a.length, w = a[0].length;
		final long[][] b = new long[w][h];
		IntStream.range(0, h).forEach(i -> {
			Arrays.setAll(b[i], j -> a[j][i]);
		});
		IntStream.range(0, w).forEach(i -> b[i] = reverse(b[i]));
		return b;
	}
	/**
	 * @param a
	 * @return 二次元配列を右回転させたもの
	 */
	protected static final double[][] rotateR(final double[][] a) {
		final int h = a.length, w = a[0].length;
		final double[][] b = new double[w][h];
		IntStream.range(0, h).forEach(i -> {
			Arrays.setAll(b[i], j -> a[j][i]);
		});
		IntStream.range(0, w).forEach(i -> b[i] = reverse(b[i]));
		return b;
	}
	/**
	 * @param s
	 * @return 文字列配列をchar型二次元配列と見て右回転させたもの
	 */
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
	/**
	 * @param a
	 * @return 二次元配列を左回転させたもの
	 */
	protected static final int[][] rotateL(final int[][] a) {
		final int h = a.length, w = a[0].length;
		final int[][] b = new int[w][h];
		IntStream.range(0, h).forEach(i -> {
			Arrays.setAll(b[i], j -> a[j][w - i - 1]);
		});
		return b;
	}
	/**
	 * @param a
	 * @return 二次元配列を左回転させたもの
	 */
	protected static final long[][] rotateL(final long[][] a) {
		final int h = a.length, w = a[0].length;
		final long[][] b = new long[w][h];
		IntStream.range(0, h).forEach(i -> {
			Arrays.setAll(b[i], j -> a[j][w - i - 1]);
		});
		return b;
	}
	/**
	 * @param a
	 * @return 二次元配列を左回転させたもの
	 */
	protected static final double[][] rotateL(final double[][] a) {
		final int h = a.length, w = a[0].length;
		final double[][] b = new double[w][h];
		IntStream.range(0, h).forEach(i -> {
			Arrays.setAll(b[i], j -> a[j][w - i - 1]);
		});
		return b;
	}
	/**
	 * @param s
	 * @return 文字列配列をchar型二次元配列と見て左回転させたもの
	 */
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
	/**
	 * 配列のi番目とj番目を入れ替える
	 * @param a
	 * @param i
	 * @param j
	 * @see <a href="https://cpprefjp.github.io/reference/utility/swap.html">std::swap</a>
	 */
	public static final void swap(final int[] a, final int i, final int j) {
		a[i] ^= a[j];
		a[j] ^= a[i];
		a[i] ^= a[j];
	}
	/**
	 * 配列のi番目とj番目を入れ替える
	 * @param a
	 * @param i
	 * @param j
	 * @see <a href="https://cpprefjp.github.io/reference/utility/swap.html">std::swap</a>
	 */
	public static final void swap(final long[] a, final int i, final int j) {
		a[i] ^= a[j];
		a[j] ^= a[i];
		a[i] ^= a[j];
	}
	/**
	 * 配列のi番目とj番目を入れ替える
	 * @param a
	 * @param i
	 * @param j
	 * @see <a href="https://cpprefjp.github.io/reference/utility/swap.html">std::swap</a>
	 */
	public static final void swap(final double[] a, final int i, final int j) {
		final double tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
	/**
	 * 配列のi番目とj番目を入れ替える
	 * @param a
	 * @param i
	 * @param j
	 * @see <a href="https://cpprefjp.github.io/reference/utility/swap.html">std::swap</a>
	 */
	public static final void swap(final char[] a, final int i, final int j) {
		a[i] ^= a[j];
		a[j] ^= a[i];
		a[i] ^= a[j];
	}
	/**
	 * 配列のi番目とj番目を入れ替える
	 * @param a
	 * @param i
	 * @param j
	 * @see <a href="https://cpprefjp.github.io/reference/utility/swap.html">std::swap</a>
	 */
	public static final void swap(final boolean[] a, final int i, final int j) {
		a[i] ^= a[j];
		a[j] ^= a[i];
		a[i] ^= a[j];
	}
	/**
	 * 配列のi番目とj番目を入れ替える
	 * @param a
	 * @param i
	 * @param j
	 * @see <a href="https://cpprefjp.github.io/reference/utility/swap.html">std::swap</a>
	 */
	public static final void swap(final Object[] a, final int i, final int j) {
		final Object tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
	/**
	 * 二つの配列を入れ替える
	 * @param a
	 * @param b
	 * @see <a href="https://cpprefjp.github.io/reference/vector/vector/swap.html">std::vector::swap</a>
	 */
	public static final void swap(final int[] a, final int[] b) {
		assert a.length == b.length;
		final int n = a.length;
		final int[] c = a.clone();
		System.arraycopy(b, 0, a, 0, n);
		System.arraycopy(c, 0, b, 0, n);
	}
	/**
	 * 二つの配列を入れ替える
	 * @param a
	 * @param b
	 * @see <a href="https://cpprefjp.github.io/reference/vector/vector/swap.html">std::vector::swap</a>
	 */
	public static final void swap(final long[] a, final long[] b) {
		assert a.length == b.length;
		final int n = a.length;
		final long[] c = a.clone();
		System.arraycopy(b, 0, a, 0, n);
		System.arraycopy(c, 0, b, 0, n);
	}
	/**
	 * 二つの配列を入れ替える
	 * @param a
	 * @param b
	 * @see <a href="https://cpprefjp.github.io/reference/vector/vector/swap.html">std::vector::swap</a>
	 */
	public static final void swap(final double[] a, final double[] b) {
		assert a.length == b.length;
		final int n = a.length;
		final double[] c = a.clone();
		System.arraycopy(b, 0, a, 0, n);
		System.arraycopy(c, 0, b, 0, n);
	}
	/**
	 * 二つの配列を入れ替える
	 * @param a
	 * @param b
	 * @see <a href="https://cpprefjp.github.io/reference/vector/vector/swap.html">std::vector::swap</a>
	 */
	public static final void swap(final char[] a, final char[] b) {
		assert a.length == b.length;
		final int n = a.length;
		final char[] c = a.clone();
		System.arraycopy(b, 0, a, 0, n);
		System.arraycopy(c, 0, b, 0, n);
	}
	/**
	 * 二つの配列を入れ替える
	 * @param a
	 * @param b
	 * @see <a href="https://cpprefjp.github.io/reference/vector/vector/swap.html">std::vector::swap</a>
	 */
	public static final void swap(final boolean[] a, final boolean[] b) {
		assert a.length == b.length;
		final int n = a.length;
		final boolean[] c = a.clone();
		System.arraycopy(b, 0, a, 0, n);
		System.arraycopy(c, 0, b, 0, n);
	}
	/**
	 * 二つの配列を入れ替える
	 * @param a
	 * @param b
	 * @see <a href="https://cpprefjp.github.io/reference/vector/vector/swap.html">std::vector::swap</a>
	 */
	public static final void swap(final Object[] a, final Object[] b) {
		assert a.length == b.length;
		final int n = a.length;
		final Object[] c = a.clone();
		System.arraycopy(b, 0, a, 0, n);
		System.arraycopy(c, 0, b, 0, n);
	}
	/**
	 * @param <F>
	 * @param <S>
	 * @param p
	 * @return Pair配列の各Pairに対して{@link Pair#swap}をした配列
	 */
	public final <F extends Comparable<? super F>, S extends Comparable<? super S>> Pair<S, F>[] swap(final Pair<F, S>[] p) {
		@SuppressWarnings("unchecked")
		final Pair<S, F>[] q = new Pair[p.length];
		IntStream.range(0, p.length).forEach(i -> q[i] = p[i].swap());
		return q;
	}
	/**
	 * @param p
	 * @return IntPair配列の各IntPairに対して{@link IntPair#swap}をした配列
	 */
	public final IntPair[] swap(final IntPair[] p) {
		final IntPair[] q = new IntPair[p.length];
		IntStream.range(0, p.length).forEach(i -> q[i] = p[i].swap());
		return q;
	}
	/**
	 * @param p
	 * @return FloatPair配列の各FloatPairに対して{@link FloatPair#swap}をした配列
	 */
	public final FloatPair[] swap(final FloatPair[] p) {
		final FloatPair[] q = new FloatPair[p.length];
		IntStream.range(0, p.length).forEach(i -> q[i] = p[i].swap());
		return q;
	}
	/**
	 * @param <F>
	 * @param <S>
	 * @param p
	 * @return Pairクラスの配列に対してfirstのみの要素を取り出した配列
	 */
	@SuppressWarnings("unchecked")
	protected static final <F extends Comparable<? super F>, S extends Comparable<? super S>> F[] first(final Pair<F, S>[] p){ return (F[]) Arrays.stream(p).map(i -> i.first).toArray(); }
	/**
	 * @param <F>
	 * @param <S>
	 * @param p
	 * @return Pairクラスの配列に対してsecondのみの要素を取り出した配列
	 */
	@SuppressWarnings("unchecked")
	protected static final <F extends Comparable<? super F>, S extends Comparable<? super S>> S[] second(final Pair<F, S>[] p){ return (S[]) Arrays.stream(p).map(i -> i.second).toArray(); }
	/**
	 * C++のstd::iotaに相当するメソッド
	 * @param n
	 * @return [0, 1, 2, ..., n - 1]
	 * @see <a href="https://cpprefjp.github.io/reference/numeric/iota.html">std::iota</a>
	 * @see <a href="https://github.com/VvyLw/CP_Library/blob/main/C%2B%2B/template.hpp#L449">Lady_sANDy::iot</a>
	 */
	public static final int[] iota(final int n){ return IntStream.range(0, n).toArray(); }
	/**
	 * @param n
	 * @param init
	 * @return [init, init + 1, init + 2, ..., init + n - 1]
	 * @see <a href="https://cpprefjp.github.io/reference/numeric/iota.html">std::iota</a>
	 * @see <a href="https://github.com/VvyLw/CP_Library/blob/main/C%2B%2B/template.hpp#L449">Lady_sANDy::iot</a>
	 */
	public static final int[] iota(final int n, final int init){ return IntStream.range(0 + init, n + init).toArray(); }
	/**
	 * めぐる式二分探索
	 * @param ok
	 * @param ng
	 * @param fn
	 * @see <a href="https://github.com/VvyLw/CP_Library/blob/main/C%2B%2B/template.hpp#L696">Heileden::bins</a>
	 */
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
	/**
	 * めぐる式二分探索
	 * @param ok
	 * @param ng
	 * @param fn
	 * @see <a href="https://github.com/VvyLw/CP_Library/blob/main/C%2B%2B/template.hpp#L696">Heileden::bins</a>
	 */
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
	/**
	 * めぐる式二分探索
	 * @param ok
	 * @param ng
	 * @param fn
	 * @see <a href="https://github.com/VvyLw/CP_Library/blob/main/C%2B%2B/template.hpp#L696">Heileden::bins</a>
	 */
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
	/**
	 * 座標圧縮
	 * @param a
	 */
	protected static final int[] press(final int[] a) {
		final int[] res = new int[a.length];
		final int[] x = Arrays.stream(a).sorted().distinct().toArray();
		for(int i = 0; i < a.length; ++i) {
			res[i] = lowerBound(x, a[i]);
		}
		return res;
	}
	/**
	 * 座標圧縮
	 * @param a
	 */
	protected static final int[] press(final long[] a) {
		final int[] res = new int[a.length];
		final long[] x = Arrays.stream(a).sorted().distinct().toArray();
		for(int i = 0; i < a.length; ++i) {
			res[i] = lowerBound(x, a[i]);
		}
		return res;
	}
	/**
	 * @param s
	 * @see <a href="https://ei1333.github.io/library/string/z-algorithm.hpp">Z-Algorithm</a>
	 */
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
	/**
	 * @param s_
	 * @param calcEven
	 * @see <a href="https://ei1333.github.io/library/string/manacher.hpp">Manacher</a>
	 */
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
	/**
	 * @param n
	 * @param k
	 * @return nのk乗根
	 */
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
	/** 
	 * a↑↑bはa^a^a^...^a(aはb個ある)を表す
	 * @param a
	 * @param b
	 * @param m
	 * @return a↑↑b(mod m)
	 */
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
	/**
	 * @param n
	 * @param m
	 * @param a
	 * @param b
	 * @see <a href="https://atcoder.github.io/ac-library/production/document_ja/math.html">atcoder::math::floor_sum</a>
	 */
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
	/**
	 * 引数を三つ持てるFunctionインターフェース
	 * @param <T>
	 * @param <U>
	 * @param <V>
	 * @param <W>
	 */
	protected interface TriFunction<T, U, V, W> {
		public W apply(final T a, final U b, final V c);
	}
	/**
	 * 引数を四つ持てるFunctionインターフェース
	 * @param <A>
	 * @param <B>
	 * @param <C>
	 * @param <D>
	 * @param <E>
	 */
	protected interface QuadFunction<A, B, C, D, E> {
		public E apply(final A a, final B b, final C c, final D d);
	}
	/**
	 * 再帰ラムダ式が書けるFunctionインターフェース
	 * @param <T>
	 * @param <U>
	 */
	protected interface RecursiveFunction<T, U> {
		public U apply(final RecursiveFunction<T, U> rec, final T n);
	}
	/**
	 * 再帰ラムダ式が書けるFunctionインターフェース
	 * @param <T>
	 * @param <U>
	 * @param <V>
	 */
	protected interface RecursiveBiFunction<T, U, V> {
		public V apply(final RecursiveBiFunction<T, U, V> rec, final T n, final U m);
	}
	/**
	 * 再帰ラムダ式が書けるFunctionインターフェース
	 * @param <T>
	 * @param <U>
	 * @param <V>
	 * @param <W>
	 */
	protected interface RecursiveTriFunction<T, U, V, W> {
		public W apply(final RecursiveTriFunction<T, U, V, W> rec, final T p, final U q, final V r);
	}
	/**
	 * 再帰ラムダ式が書けるUnaryOperatorインターフェース
	 * @param <T>
	 */
	protected interface RecursiveUnaryOperator<T> {
		public T apply(final RecursiveUnaryOperator<T> rec, final T n);
	}
	/**
	 * 再帰ラムダ式が書けるBinaryOperatorインターフェース
	 * @param <T>
	 */
	protected interface RecursiveBinaryOperator<T> {
		public T apply(final RecursiveBinaryOperator<T> rec, final T a, final T b);
	}
	/**
	 * 再帰ラムダ式が書けるConsumerインターフェース
	 * @param <T>
	 */
	protected interface RecursiveConsumer<T> {
		public void accept(final RecursiveConsumer<T> rec, final T x);
	}
	/**
	 * 再帰ラムダ式が書けるConsumerインターフェース
	 * @param <T>
	 * @param <U>
	 */
	protected interface RecursiveBiConsumer<T, U> {
		public void accept(final RecursiveBiConsumer<T, U> rec, final T x, final U y);
	}
	/**
	 * 再帰ラムダ式が書けるConsumerインターフェース
	 * @param <T>
	 * @param <U>
	 * @param <V>
	 */
	protected interface RecursiveTriConsumer<T, U, V> {
		public void accept(final RecursiveTriConsumer<T, U, V> rec, final T x, final U y, final V z);
	}
}
