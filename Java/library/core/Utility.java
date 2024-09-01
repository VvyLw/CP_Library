package library.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import library.ds.pair.FloatPair;
import library.ds.pair.IntPair;
import library.ds.pair.Pair;

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
	 * 平方数を求める
	 * @param x
	 * @return xの平方数
	 */
	protected static final long sqr(final long x){ return x * x; }
	/**
	 * 立方数を求める
	 * @param x
	 * @return xの立方数
	 */
	protected static final long cub(final long x){ return x * x * x; }
	/**
	 * nが負の時でも正の剰余を求める
	 * 法がintの時, intで返す
	 * @param n
	 * @param m
	 */
	protected static final int mod(long n, final int m) {
		n %= m;
		return (int) (n < 0 ? n + m : n);
	}
	/**
	 * nが負の時でも正の剰余を求める
	 * @param n
	 * @param m
	 */
	public static final long mod(long n, final long m) {
		n %= m;
		return n < 0 ? n + m : n;
	}
	/**
	 * baseを底とするxの定数を求める
	 * @param x
	 * @param base
	 * @return baseを底とするxの対数
	 */
	public static final double log(final double x, final long base){ return Math.log(x) / Math.log(base); }
	/**
	 * a / bを小数点c桁で四捨五入して求める
	 * @param a
	 * @param b
	 * @param c
	 */
	protected static final double intRound(final double a, final long b, final int c) {
		final long d = powi(10, c);
		return Math.rint((a * d) / b) / d;
	}
	/**
	 * aのb乗を求める
	 * @param a
	 * @param b
	 * @return aのb乗
	 */
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
	/**
	 * aのb乗(mod m)を求める
	 * @param a
	 * @param b
	 * @param m
	 * @return aのb乗のmを法とした剰余
	 */
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
	/**
	 * inv a(mod m)を求める
	 * @param a
	 * @param m
	 * @return aの逆元のmを法とした剰余
	 */
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
	/**
	 * aとbの最小公倍数を求める
	 * @param a
	 * @param b
	 * @return aとbの最小公倍数
	 */
	public static final long lcm(final long a, final long b){ return a / gcd(a, b) * b; }
	/**
	 * 与えられたタプルの最小公倍数を求める
	 * e.g.) lcm(2, 3, 5) = 30
	 * @param a int型タプル あるいはint型配列
	 * @return aの最小公倍数
	 */
	public static final long lcm(final int... a){ return IntStream.of(a).asLongStream().reduce(1, (x, y) -> lcm(x, y)); }
	/**
	 * 与えられたタプルの最小公倍数を求める
	 * @param a long型タプル あるいはlong型配列
	 * @return aの最小公倍数
	 */
	public static final long lcm(final long... a){ return LongStream.of(a).reduce(1, (x, y) -> lcm(x, y)); }
	/**
	 * aとbの最大公約数を求める
	 * @param a
	 * @param b
	 * @return aとbの最大公約数
	 */
	public static final long gcd(final long a, final long b){ return b == 0 ? a : gcd(b, a % b); }
	/**
	 * 与えられたタプルの最大公約数を求める
	 * e.g.) gcd(12, 15, 24) = 3
	 * @param a int型タプル あるいはint型配列
	 * @return aの最大公約数
	 */
	public static final int gcd(final int... a){ return IntStream.of(a).reduce(0, (x, y) -> (int) gcd(x, y)); }
	/**
	 * 与えられたタプルの最大公約数を求める
	 * @param a long型タプル あるいはlong型配列
	 * @return aの最大公約数
	 */
	public static final long gcd(final long... a){ return LongStream.of(a).reduce(0, (x, y) -> gcd(x, y)); }
	/**
	 * 与えられたタプルの最小値を求める
	 * @param a int型タプル あるいはint型配列
	 * @return aの最小値
	 */
	public static final int min(final int... a){ return IntStream.of(a).min().getAsInt(); }
	/**
	 * 与えられたタプルの最小値を求める
	 * @param a long型タプル あるいはlong型配列
	 * @return aの最小値
	 */
	public static final long min(final long... a){ return LongStream.of(a).min().getAsLong(); }
	/**
	 * 与えられたタプルの最小値を求める
	 * @param a double型タプル あるいはdouble型配列
	 * @return aの最小値
	 */
	public static final double min(final double... a){ return DoubleStream.of(a).min().getAsDouble(); }
	/**
	 * 与えられたタプルの最大値を求める
	 * @param a int型タプル あるいはint型配列
	 * @return aの最大値
	 */
	public static final int max(final int... a){ return IntStream.of(a).max().getAsInt(); }
	/**
	 * 与えられたタプルの最大値を求める
	 * @param a long型タプル あるいはlong型配列
	 * @return aの最大値
	 */
	public static final long max(final long... a){ return LongStream.of(a).max().getAsLong(); }
	/**
	 * 与えられたタプルの最大値を求める
	 * @param a double型タプル あるいはdouble型配列
	 * @return aの最大値
	 */
	public static final double max(final double... a){ return DoubleStream.of(a).max().getAsDouble(); }
	/**
	 * 与えられたタプルの総和を求める
	 * @param a int型タプル あるいはint型配列
	 * @return aの総和
	 */
	public static final long sum(final int... a){ return IntStream.of(a).asLongStream().sum(); }
	/**
	 * 与えられたタプルの総和を求める
	 * @param a long型タプル あるいはlong型配列
	 * @return aの総和
	 */
	public static final long sum(final long... a){ return LongStream.of(a).sum(); }
	/**
	 * 与えられたタプルの総和を求める
	 * @param a double型タプル あるいはdouble型配列
	 * @return aの総和
	 */
	public static final double sum(final double... a){ return DoubleStream.of(a).sum(); }
	/**
	 * 与えられたタプルの総積を求める
	 * @param a int型タプル あるいはint型配列
	 * @return aの総積
	 */
	protected static final long prod(final int... a){ return IntStream.of(a).asLongStream().reduce(1, (x, y) -> x * y); }
	/**
	 * 与えられたタプルの総積を求める
	 * @param a long型タプル あるいはlong型配列
	 * @return aの総積
	 */
	protected static final long prod(final long... a){ return LongStream.of(a).reduce(1, (x, y) -> x * y); }
	/**
	 * 与えられたタプルの総積を求める
	 * @param a double型タプル あるいはdouble型配列
	 * @return aの総積
	 */
	protected static final double prod(final double... a){ return DoubleStream.of(a).reduce(1, (x, y) -> x * y); }
	/**
	 * 与えられたタプルの平均値を求める
	 * @param a int型タプル あるいはint型配列
	 * @return aの平均値
	 */
	protected static final double ave(final int... a){ return IntStream.of(a).average().getAsDouble(); }
	/**
	 * 与えられたタプルの平均値を求める
	 * @param a long型タプル あるいはlong型配列
	 * @return aの平均値
	 */
	protected static final double ave(final long... a){ return LongStream.of(a).average().getAsDouble(); }
	/**
	 * 与えられたタプルの平均値を求める
	 * @param a double型タプル あるいはdouble型配列
	 * @return aの平均値
	 */
	protected static final double ave(final double... a){ return DoubleStream.of(a).average().getAsDouble(); }
	/**
	 * ソート済配列の中央値を求める
	 * @param a ソート済のint型配列
	 * @return 中央値
	 */
	protected static final double median(final int[] a) {
		assert isSorted(a);
		final int m = a.length / 2;
		return a.length % 2 != 0 ? a[m] : (a[m - 1] + a[m]) / 2.0;
	}
	/**
	 * ソート済配列の中央値を求める
	 * @param a ソート済のlong型配列
	 * @return 中央値
	 */
	protected static final double median(final long[] a) {
		assert isSorted(a);
		final int m = a.length / 2;
		return a.length % 2 != 0 ? a[m] : (a[m - 1] + a[m]) / 2.0;
	}
	/**
	 * ソート済配列の中央値を求める
	 * @param a ソート済のdouble型配列
	 * @return 中央値
	 */
	protected static final double median(final double[] a) {
		assert isSorted(a);
		final int m = a.length / 2;
		return a.length % 2 != 0 ? a[m] : (a[m - 1] + a[m]) / 2;
	}
	/**
	 * nの約数を列挙
	 * @param n 整数
	 * @return nの約数の配列
	 */
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
	/**
	 * nを素因数分解
	 * e.g.) primeFactor(24) = [(2, 3), (3, 1)]
	 * @param n 整数
	 * @return nの素因数分解結果
	 */
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
	/**
	 * オイラーのΦ関数
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
	 * 1からnまでの総和を求める
	 * @param n
	 * @return 1からnまでの総和
	 */
	protected static final long sigma(final long n){ return n * (n + 1) / 2; }
	/**
	 * aからbまでの総和を求める
	 * @param a
	 * @param b
	 * @return aからbまでの総和
	 * @apiNote bはa以上
	 */
	protected static final long sigma(final long a, final long b) {
		assert a <= b;
		return sigma(b) - sigma(a - 1);
	}
	/**
	 * n!を求める
	 * @param n 整数
	 * @return nの階乗
	 */
	protected static final long fact(int n) {
		long res = 1;
		while(n > 0) {
			res *= n--;
		}
		return res;
	}
	/**
	 * modを法としたn!を求める
	 * @param n
	 * @param mod
	 * @return nの階乗のmodを法とする剰余
	 */
	protected static final long fact(int n, final long mod) {
		long res = 1;
		while(n > 0) {
			res *= n--;
			res %= mod;
		}
		return res;
	}
	/**
	 * nPrを求める
	 * @param n
	 * @param r
	 * @return 順列(nPr)
	 */
	protected static final long perm(final int n, final int r) {
		int m = n;
		long res = 1;
		while(m > n - r) {
			res *= m--;
		}
		return res;
	}
	/**
	 * modを法としたnPrを求める
	 * @param n
	 * @param r
	 * @param mod
	 * @return 順列のmodを法とする剰余
	 */
	protected static final long perm(final int n, final int r, final long mod) {
		int m = n;
		long res = 1;
		while(m > n - r) {
			res *= m--;
			res %= mod; 
		}
		return res;
	}
	/**
	 * nCrを求める
	 * @param n
	 * @param r
	 * @return 二項係数(nCr)
	 */
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
	/**
	 * modを法とするnCrを求める
	 * @param n
	 * @param r
	 * @param mod
	 * @return 二項係数のmodを法とする剰余
	 */
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
	/**
	 * nが整数かどうか判定
	 * @param n
	 * @return nが整数ならtrue, 整数でないならfalse
	 */
	protected static final boolean isInt(final double n){ return n == (long) Math.floor(n); }
	/**
	 * nが平方数かどうか判定
	 * @param n
	 * @return nが平方数ならtrue, 平方数でないならfalse
	 */
	protected static final boolean isSqr(final long n){ return isInt(Math.sqrt(n)); }
	/**
	 * nが素数かどうか判定
	 * @param n
	 * @return nが素数ならtrue, 1か合成数ならfalse
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
	 * xが閉区間[l, r]の中に収まるか判定する
	 * @param l
	 * @param x
	 * @param r
	 * @return l <= x <= r
	 */
	public static final boolean scope(final int l, final int x, final int r){ return l <= x && x <= r; }
	/**
	 * xが閉区間[l, r]の中に収まるか判定する
	 * @param l
	 * @param x
	 * @param r
	 * @return l <= x <= r
	 */
	public static final boolean scope(final long l, final long x, final long r){ return l <= x && x <= r; }
	/**
	 * xが閉区間[l, r]の中に収まるか判定する
	 * @param l
	 * @param x
	 * @param r
	 * @return l <= x <= r
	 */
	public static final boolean scope(final double l, final double x, final double r){ return l <= x && x <= r; }
	/**
	 * C++のstd::clampのようなメソッド
	 * @param l
	 * @param x
	 * @param r
	 * @see <a href="https://cpprefjp.github.io/reference/algorithm/clamp.html">std::clamp</a>
	 * @ AtCoderのJavaのアップデートが入ったら消す
	 */
	protected static final int clamp(final int l, final int x, final int r){ return x < l ? l : x > r ? r : x; }
	/**
	 * C++のstd::clampのようなメソッド
	 * @param l
	 * @param x
	 * @param r
	 * @see <a href="https://cpprefjp.github.io/reference/algorithm/clamp.html">std::clamp</a>
	 * @ AtCoderのJavaのアップデートが入ったら消す
	 */
	protected static final long clamp(final long l, final long x, final long r){ return x < l ? l : x > r ? r : x; }
	/**
	 * C++のstd::clampのようなメソッド
	 * @param l
	 * @param x
	 * @param r
	 * @see <a href="https://cpprefjp.github.io/reference/algorithm/clamp.html">std::clamp</a>
	 * @ AtCoderのJavaのアップデートが入ったら消す
	 */
	protected static final double clamp(final double l, final double x, final double r){ return x < l ? l : x > r ? r : x; }
	/**
	 * bit全探索などで使う(i >> jが奇数かどうか)
	 * @param i bit
	 * @param j target
	 */
	protected static final boolean isBit(final long i, final long j){ return (i >> j & 1) == 1; }
	/**
	 * C++のstd::next_permutationに相当するメソッド
	 * @param a
	 * @see <a href="https://cpprefjp.github.io/reference/algorithm/next_permutation.html">std::next_permutation</a>
	 */
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
	/**
	 * C++のstd::next_permutationに相当するメソッド
	 * @param a
	 * @see <a href="https://cpprefjp.github.io/reference/algorithm/next_permutation.html">std::next_permutation</a>
	 */
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
	/**
	 * C++のstd::next_permutationに相当するメソッド
	 * @param a
	 * @see <a href="https://cpprefjp.github.io/reference/algorithm/next_permutation.html">std::next_permutation</a>
	 */
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
	/**
	 * C++のstd::next_permutationに相当するメソッド
	 * @param a
	 * @see <a href="https://cpprefjp.github.io/reference/algorithm/next_permutation.html">std::next_permutation</a>
	 */
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
	/**
	 * C++のstd::prev_permutationに相当するメソッド
	 * @param a
	 * @see <a href="https://cpprefjp.github.io/reference/algorithm/prev_permutation.html">std::prev_permutation</a>
	 */
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
	/**
	 * C++のstd::prev_permutationに相当するメソッド
	 * @param a
	 * @see <a href="https://cpprefjp.github.io/reference/algorithm/prev_permutation.html">std::prev_permutation</a>
	 */
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
	/**
	 * C++のstd::prev_permutationに相当するメソッド
	 * @param a
	 * @see <a href="https://cpprefjp.github.io/reference/algorithm/prev_permutation.html">std::prev_permutation</a>
	 */
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
	/**
	 * C++のstd::prev_permutationに相当するメソッド
	 * @param a
	 * @see <a href="https://cpprefjp.github.io/reference/algorithm/prev_permutation.html">std::prev_permutation</a>
	 */
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
	 * @see <a href="https://cpprefjp.github.io/reference/string/basic_string/find.html">std::basic_string::find</a>
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
	 * @return ソート済配列の中に要素が含まれていればtrue
	 */
	public static final boolean binarySearch(final int[] a, final int x){ return Arrays.binarySearch(a, x) >= 0; }
	/**
	 * C++のstd::binarySearchに相当するメソッド
	 * @param a
	 * @param x
	 * @see <a href="https://cpprefjp.github.io/reference/algorithm/binary_search.html">std::binary_search</a>
	 * @return ソート済配列の中に要素が含まれていればtrue
	 */
	public static final boolean binarySearch(final long[] a, final long x){ return Arrays.binarySearch(a, x) >= 0; }
	/**
	 * C++のstd::binarySearchに相当するメソッド
	 * @param <T>
	 * @param a
	 * @param x
	 * @see <a href="https://cpprefjp.github.io/reference/algorithm/binary_search.html">std::binary_search</a>@return
	 * @return ソート済配列の中に要素が含まれていればtrue
	 */
	public static final <T extends Comparable<? super T>> boolean binarySearch(final T[] a, final T x){ return Arrays.binarySearch(a, x) >= 0; }
	/**
	 * C++のstd::binarySearchに相当するメソッド
	 * 遅い
	 * @param <T>
	 * @param a
	 * @param x
	 * @see <a href="https://cpprefjp.github.io/reference/algorithm/binary_search.html">std::binary_search</a>
	 * @return ソート済リストの中に要素が含まれていればtrue
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
	 * C++のstd::lower_boundに相当するメソッド
	 * @param a
	 * @param x
	 * @return その値以上の要素が初めて現れるインデックス(イテレータではない)
	 * @see <a href="https://cpprefjp.github.io/reference/algorithm/lower_bound.html">std::lower_bound</a>
	 */
	public static final int lowerBound(final long[] a, final long x){ return bins(a.length, -1, (IntPredicate) y -> a[y] >= x); }
	/**
	 * C++のstd::lower_boundに相当するメソッド
	 * @param <T>
	 * @param a
	 * @param x
	 * @return その値以上の要素が初めて現れるインデックス(イテレータではない)
	 * @see <a href="https://cpprefjp.github.io/reference/algorithm/lower_bound.html">std::lower_bound</a>
	 */
	public static final <T extends Comparable<? super T>> int lowerBound(final T[] a, final T x){ return lowerBound(Arrays.asList(a), x); }
	/**
	 * C++のstd::lower_boundに相当するメソッド
	 * 遅い
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
	 * C++のstd::upper_boundに相当するメソッド
	 * @param a
	 * @param x
	 * @return その値より大きい要素が初めて現れるインデックス(イテレータではない)
	 * @see <a href="https://cpprefjp.github.io/reference/algorithm/upper_bound.html">std::upper_bound</a>
	 */
	public static final int upperBound(final long[] a, final long x){ return bins(a.length, -1, (IntPredicate) y -> a[y] > x); }
	/**
	 * C++のstd::upper_boundに相当するメソッド
	 * @param a
	 * @param x
	 * @return その値より大きい要素が初めて現れるインデックス(イテレータではない)
	 * @see <a href="https://cpprefjp.github.io/reference/algorithm/upper_bound.html">std::upper_bound</a>
	 */
	public static final <T extends Comparable<? super T>> int upperBound(final T[] a, final T x){ return upperBound(Arrays.asList(a), x); }
	/**
	 * C++のstd::upper_boundに相当するメソッド
	 * 遅い
	 * @param a
	 * @param x
	 * @return その値より大きい要素が初めて現れるインデックス(イテレータではない)
	 * @see <a href="https://cpprefjp.github.io/reference/algorithm/upper_bound.html">std::upper_bound</a>
	 */
	public static final <T extends Comparable<? super T>> int upperBound(final List<T> a, final T x){ return ~Collections.binarySearch(a, x, (p, q) -> p.compareTo(q) > 0 ? 1 : -1); }
	/**
	 * Pythonのsortedに相当するメソッド
	 * @param s
	 * @return 昇順にソートした文字列
	 */
	public static final String sorted(final String s){ return s.chars().sorted().mapToObj(Character::toString).collect(Collectors.joining()); }
	/**
	 * Pythonのsortedに相当するメソッド
	 * @param a
	 * @return 昇順にソートしたint型配列
	 */
	public static final int[] sorted(final int[] a){ return Arrays.stream(a).sorted().toArray(); }
	/**
	 * Pythonのsortedに相当するメソッド
	 * @param a
	 * @return 昇順にソートしたlong型配列
	 */
	public static final long[] sorted(final long[] a){ return Arrays.stream(a).sorted().toArray(); }
	/**
	 * Pythonのsortedに相当するメソッド
	 * @param a
	 * @return 昇順にソートしたdouble型配列
	 */
	public static final double[] sorted(final double[] a){ return Arrays.stream(a).sorted().toArray(); }
	/**
	 * Pythonのsortedに相当するメソッド
	 * @param a
	 * @return 昇順にソートしたchar型配列
	 */
	public static final char[] sorted(final char[] a){ return sorted(new String(a)).toCharArray(); }
	/**
	 * Pythonのsortedに相当するメソッド
	 * @param <T> Comparableなクラス
	 * @param a
	 * @return 昇順にソートした総称型配列
	 */
	public static final <T extends Comparable<? super T>> T[] sorted(final T[] a){ return Arrays.stream(a).sorted().toArray(n -> Arrays.copyOf(a, n)); }
	/**
	 * C++のstd::is_sortedに相当するメソッド
	 * @param s
	 * @return 文字列がソートされているかどうか
	 * @see <a href="https://cpprefjp.github.io/reference/algorithm/is_sorted.html">std::is_sorted</a>
	 */
	protected static final boolean isSorted(final String s){ return s.equals(sorted(s)); }
	/**
	 * C++のstd::is_sortedに相当するメソッド
	 * @param a
	 * @return 配列がソートされているかどうか
	 * @see <a href="https://cpprefjp.github.io/reference/algorithm/is_sorted.html">std::is_sorted</a>
	 */
	protected static final boolean isSorted(final int[] a){ return Arrays.equals(a, sorted(a)); }
	/**
	 * C++のstd::is_sortedに相当するメソッド
	 * @param a
	 * @return 配列がソートされているかどうか
	 * @see <a href="https://cpprefjp.github.io/reference/algorithm/is_sorted.html">std::is_sorted</a>
	 */
	protected static final boolean isSorted(final long[] a){ return Arrays.equals(a, sorted(a)); }
	/**
	 * C++のstd::is_sortedに相当するメソッド
	 * @param a
	 * @return 配列がソートされているかどうか
	 * @see <a href="https://cpprefjp.github.io/reference/algorithm/is_sorted.html">std::is_sorted</a>
	 */
	protected static final boolean isSorted(final double[] a){ return Arrays.equals(a, sorted(a)); }
	/**
	 * C++のstd::is_sortedに相当するメソッド
	 * @param a
	 * @return 配列がソートされているかどうか
	 * @see <a href="https://cpprefjp.github.io/reference/algorithm/is_sorted.html">std::is_sorted</a>
	 */
	protected static final boolean isSorted(final char[] a){ return Arrays.equals(a, sorted(a)); }
	/**
	 * C++のstd::is_sortedに相当するメソッド
	 * @param <T> {@link Comparable}なクラス
	 * @param a
	 * @return 配列がソートされているかどうか
	 * @see <a href="https://cpprefjp.github.io/reference/algorithm/is_sorted.html">std::is_sorted</a>
	 */
	protected static final <T extends Comparable<? super T>> boolean isSorted(final T[] a){ return Arrays.equals(a, sorted(a)); }
	/**
	 * 文字列を逆順に並び替える
	 * @param s
	 * @return 逆順に並び替えた文字列
	 */
	protected static final String reverse(final String s){ return new StringBuilder(s).reverse().toString(); }
	/**
	 * 配列を逆順に並び替える
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
	 * 配列を逆順に並び替える
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
	 * 配列を逆順に並び替える
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
	 * 配列を逆順に並び替える
	 * @param a
	 * @return 逆順に並び替えたchar型配列
	 */
	protected static final char[] reverse(final char[] a) {
		final int n = a.length;
		final char[] b = new char[n];
		for(int i = 0; i <= n / 2; ++i) {
			b[i] = a[n - 1 - i];
			b[n - 1 - i] = a[i];
		}
		return b;
	}
	/**
	 * 配列を逆順に並び替える
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
	 * @param id 正の数の時、前にある値は後ろに移動し、負の数の時、後ろにある値は前に移動する
	 * @see <a href="https://cpprefjp.github.io/reference/algorithm/rotate.html">std::rotate</a>
	 */
	public static final int[] rotate(final int[] a, final int id) {
		final int n = a.length, k = (int) mod(id, n);
		final int[] res = new int[n];
		System.arraycopy(a, k, res, 0, n - k);
		System.arraycopy(a, 0, res, n - k, k);
		return res;
	}
	/**
	 * C++のstd::rotateに相当するメソッド
	 * @param a
	 * @param id 正の数の時、前にある値は後ろに移動し、負の数の時、後ろにある値は前に移動する
	 * @see <a href="https://cpprefjp.github.io/reference/algorithm/rotate.html">std::rotate</a>
	 */
	public static final long[] rotate(final long[] a, final int id) {
		final int n = a.length, k = (int) mod(id, n);
		final long[] res = new long[n];
		System.arraycopy(a, k, res, 0, n - k);
		System.arraycopy(a, 0, res, n - k, k);
		return res;
	}
	/**
	 * C++のstd::rotateに相当するメソッド
	 * @param a
	 * @param id 正の数の時、前にある値は後ろに移動し、負の数の時、後ろにある値は前に移動する
	 * @see <a href="https://cpprefjp.github.io/reference/algorithm/rotate.html">std::rotate</a>
	 */
	public static final double[] rotate(final double[] a, final int id) {
		final int n = a.length, k = (int) mod(id, n);
		final double[] res = new double[n];
		System.arraycopy(a, k, res, 0, n - k);
		System.arraycopy(a, 0, res, n - k, k);
		return res;
	}
	/**
	 * C++のstd::rotateに相当するメソッド
	 * @param a
	 * @param id 正の数の時、前にある値は後ろに移動し、負の数の時、後ろにある値は前に移動する
	 * @see <a href="https://cpprefjp.github.io/reference/algorithm/rotate.html">std::rotate</a>
	 */
	public static final char[] rotate(final char[] a, final int id) {
		final int n = a.length, k = (int) mod(id, n);
		final char[] res = new char[n];
		System.arraycopy(a, k, res, 0, n - k);
		System.arraycopy(a, 0, res, n - k, k);
		return res;
	}
	/**
	 * C++のstd::rotateに相当するメソッド
	 * @param a
	 * @param id 正の数の時、前にある値は後ろに移動し、負の数の時、後ろにある値は前に移動する
	 * @see <a href="https://cpprefjp.github.io/reference/algorithm/rotate.html">std::rotate</a>
	 */
	public static final boolean[] rotate(final boolean[] a, final int id) {
		final int n = a.length, k = (int) mod(id, n);
		final boolean[] res = new boolean[n];
		System.arraycopy(a, k, res, 0, n - k);
		System.arraycopy(a, 0, res, n - k, k);
		return res;
	}
	/**
	 * C++のstd::rotateに相当するメソッド
	 * @param a
	 * @param id 正の数の時、前にある値は後ろに移動し、負の数の時、後ろにある値は前に移動する
	 * @see <a href="https://cpprefjp.github.io/reference/algorithm/rotate.html">std::rotate</a>
	 */
	public static final Object[] rotate(final Object[] a, final int id) {
		final int n = a.length, k = (int) mod(id, n);
		final Object[] res = new Object[n];
		System.arraycopy(a, k, res, 0, n - k);
		System.arraycopy(a, 0, res, n - k, k);
		return res;
	}
	/**
	 * C++のstd::rotateに相当するメソッド
	 * @param s
	 * @param id 正の数の時、前にある値は後ろに移動し、負の数の時、後ろにある値は前に移動する
	 * @see <a href="https://cpprefjp.github.io/reference/algorithm/rotate.html">std::rotate</a>
	 */
	public static final String rotate(final String s, final int id) {
		final List<Character> t = s.chars().mapToObj(i -> (char) i).collect(Collectors.toList());
		Collections.rotate(t, -id);
		return t.stream().map(String::valueOf).collect(Collectors.joining());
	}
	/**
	 * 二次元配列を右回転させる
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
	 * 二次元配列を右回転させる
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
	 * 二次元配列を右回転させる
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
	 * 二次元配列を右回転させる
	 * @param a
	 * @return 二次元配列を右回転させたもの
	 */
	protected static final char[][] rotateR(final char[][] a) {
		final int h = a.length, w = a[0].length;
		final char[][] b = new char[w][h];
		IntStream.range(0, h).forEach(i -> {
			IntStream.range(0, w).forEach(j -> b[j][i] = a[i][j]);
		});
		IntStream.range(0, w).forEach(i -> b[i] = reverse(b[i]));
		return b;
	}
	/**
	 * 二次元配列を左回転させる
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
	 * 二次元配列を左回転させる
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
	 * 二次元配列を左回転させる
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
	 * 二次元配列を左回転させる
	 * @param a
	 * @return 二次元配列を左回転させたもの
	 */
	protected static final char[][] rotateL(final char[][] a) {
		final int h = a.length, w = a[0].length;
		final char[][] b = new char[w][h];
		IntStream.range(0, h).forEach(i -> {
			IntStream.range(0, w).forEach(j -> b[w - j - 1][i] = a[i][j]);
		});
		return b;
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
	 * Pairの配列に対して各要素をswapさせる
	 * @param <F>
	 * @param <S>
	 * @param p
	 * @return Pair配列の各Pairに対して{@link Pair#swap}をした配列
	 */
	public static final <F extends Comparable<? super F>, S extends Comparable<? super S>> Pair<S, F>[] swap(final Pair<F, S>[] p) {
		@SuppressWarnings("unchecked")
		final Pair<S, F>[] q = new Pair[p.length];
		Arrays.setAll(q, i -> p[i].swap());
		return q;
	}
	/**
	 * IntPairの配列に対して各要素をswapさせる
	 * @param p
	 * @return IntPair配列の各IntPairに対して{@link IntPair#swap}をした配列
	 */
	public static final IntPair[] swap(final IntPair[] p) {
		final IntPair[] q = new IntPair[p.length];
		Arrays.setAll(q, i -> p[i].swap());
		return q;
	}
	/**
	 * FloatPairの配列に対して各要素をswapさせる
	 * @param p
	 * @return FloatPair配列の各FloatPairに対して{@link FloatPair#swap}をした配列
	 */
	public static final FloatPair[] swap(final FloatPair[] p) {
		final FloatPair[] q = new FloatPair[p.length];
		Arrays.setAll(q, i -> p[i].swap());
		return q;
	}
	/**
	 * Pairの配列に対して各要素のfirstのみの配列を返す
	 * @param <F>
	 * @param <S>
	 * @param p
	 * @return Pairクラスの配列に対してfirstのみの要素を取り出した配列
	 */
	@SuppressWarnings("unchecked")
	protected static final <F extends Comparable<? super F>, S extends Comparable<? super S>> F[] first(final Pair<F, S>[] p){ return (F[]) Arrays.stream(p).map(i -> i.first).toArray(); }
	/**
	 * IntPairの配列に対して各要素のfirstのみの配列を返す
	 * @param p
	 * @return IntPairクラスの配列に対してfirstのみの要素を取り出した配列
	 */
	protected static final long[] first(final IntPair[] p){ return Arrays.stream(p).mapToLong(i -> i.first).toArray(); }
	/**
	 * FloatPairの配列に対して各要素のfirstのみの配列を返す
	 * @param p
	 * @return FloatPairクラスの配列に対してfirstのみの要素を取り出した配列
	 */
	protected static final double[] first(final FloatPair[] p){ return Arrays.stream(p).mapToDouble(i -> i.first).toArray(); }
	/**
	 * Pairの配列に対して各要素のsecondのみの配列を返す
	 * @param <F>
	 * @param <S>
	 * @param p
	 * @return Pairクラスの配列に対してsecondのみの要素を取り出した配列
	 */
	@SuppressWarnings("unchecked")
	protected static final <F extends Comparable<? super F>, S extends Comparable<? super S>> S[] second(final Pair<F, S>[] p){ return (S[]) Arrays.stream(p).map(i -> i.second).toArray(); }
	/**
	 * IntPairの配列に対して各要素のsecondのみの配列を返す
	 * @param p
	 * @return IntPairクラスの配列に対してsecondのみの要素を取り出した配列
	 */
	protected static final long[] second(final IntPair[] p){ return Arrays.stream(p).mapToLong(i -> i.second).toArray(); }
	/**
	 * FloatPairの配列に対して各要素のsecondのみの配列を返す
	 * @param p
	 * @return FloatPairクラスの配列に対してsecondのみの要素を取り出した配列
	 */
	protected static final double[] second(final FloatPair[] p){ return Arrays.stream(p).mapToDouble(i -> i.second).toArray(); }
	/**
	 * C++のstd::iotaに相当するメソッド
	 * IntStreamを返すため、配列化するにはtoArray()する必要がある
	 * @param n
	 * @return [0, 1, 2, ..., n - 1]のIntStream
	 * @see <a href="https://cpprefjp.github.io/reference/numeric/iota.html">std::iota</a>
	 * @see <a href="https://github.com/VvyLw/CP_Library/blob/main/C%2B%2B/template.hpp#L449">Lady_sANDy::iot</a>
	 */
	public static final IntStream iota(final int n){ return IntStream.range(0, n); }
	/**
	 * C++のstd::iotaに相当するメソッド
	 * IntStreamを返すため、配列化するにはtoArray()する必要がある
	 * @param n
	 * @param init
	 * @return [init, init + 1, init + 2, ..., init + n - 1]
	 * @see <a href="https://cpprefjp.github.io/reference/numeric/iota.html">std::iota</a>
	 * @see <a href="https://github.com/VvyLw/CP_Library/blob/main/C%2B%2B/template.hpp#L449">Lady_sANDy::iot</a>
	 */
	public static final IntStream iota(final int n, final int init){ return IntStream.range(0 + init, n + init); }
	/**
	 * int型配列をボクシングしてIntegerクラスの配列に変換する
	 * @param a
	 * @return int[] -> Integer[]
	 */
	protected static final Integer[] boxed(final int[] a){ return Arrays.stream(a).boxed().toArray(Integer[]::new); }
	/**
	 * long型配列をボクシングしてLongクラスの配列に変換する
	 * @param a
	 * @return long[] -> Long[]
	 */
	protected static final Long[] boxed(final long[] a){ return Arrays.stream(a).boxed().toArray(Long[]::new); }
	/**
	 * double型配列をボクシングしてDoubleクラスの配列に変換する
	 * @param a
	 * @return double[] -> Double[]
	 */
	protected static final Double[] boxed(final double[] a){ return Arrays.stream(a).boxed().toArray(Double[]::new); }
	/**
	 * めぐる式二分探索
	 * @param ok 答えになる可能性がある臨界値
	 * @param ng 答えになる可能性がない臨界値
	 * @param fn 条件
	 * @see #lowerBound
	 * @see #upperBound
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
	 * @param ok 答えになる可能性がある臨界値
	 * @param ng 答えになる可能性がない臨界値
	 * @param fn 条件
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
	 * @param ok 答えになる可能性がある臨界値
	 * @param ng 答えになる可能性がない臨界値
	 * @param fn 条件
	 * @see <a href="https://github.com/VvyLw/CP_Library/blob/main/C%2B%2B/template.hpp#L696">Heileden::bins</a>
	 */
	protected static final double bins(double ok, double ng, final DoublePredicate fn) {
		while(Math.abs(ok - ng) > VvyLw.EPS) {
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
	 * 配列内の数値を個数を数え上げる
	 * @param a
	 */
	protected static final Map<Integer, Integer> counter(final int[] a) {
		final Map<Integer, Integer> res = new HashMap<>();
		for(final int i: a) {
			res.merge(i, 1, (x, y) -> x + y);
		}
		return res;
	}
	/**
	 * 配列内の数値を個数を数え上げる
	 * @param a
	 */
	protected static final Map<Long, Integer> counter(final long[] a) {
		final Map<Long, Integer> res = new HashMap<>();
		for(final long i: a) {
			res.merge(i, 1, (x, y) -> x + y);
		}
		return res;
	}
	/**
	 * C++のstd::inner_productに相当するメソッド
	 * @param p
	 * @return 内積
	 * @see <a href="https://cpprefjp.github.io/reference/numeric/inner_product.html">std::inner_product</a>
	 */
	protected static final long innerProd(final IntPair... p){ return iota(p.length).mapToLong(i -> p[i].first.longValue() * p[i].second.longValue()).sum(); }
	/**
	 * C++のstd::inner_productに相当するメソッド
	 * @param p
	 * @return 内積
	 * @see <a href="https://cpprefjp.github.io/reference/numeric/inner_product.html">std::inner_product</a>
	 */
	protected static final double innerProd(final FloatPair... p){ return iota(p.length).mapToDouble(i -> p[i].first.doubleValue() * p[i].second.doubleValue()).sum(); }
	/**
	 * 直線a.first * x + a.second * y + sec1 = 0と直線b.first * x + b.second * y + sec2 = 0の交点を求める
	 * 連立一次方程式を解くのにも使える
	 * @param a
	 * @param sec1
	 * @param b
	 * @param sec2
	 * @return 直線a.first * x + a.second * y + sec1 = 0と直線b.first * x + b.second * y + sec2 = 0の交点
	 */
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
	/**
	 * 直線a.first * x + a.second * y + sec1 = 0と直線b.first * x + b.second * y + sec2 = 0の交点を求める
	 * 連立一次方程式を解くのにも使える
	 * @param a
	 * @param sec1
	 * @param b
	 * @param sec2
	 * @return 直線a.first * x + a.second * y + sec1 = 0と直線b.first * x + b.second * y + sec2 = 0の交点
	 */
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
	/**
	 * 座標圧縮
	 * @param a
	 */
	protected static final int[] corPress(final int[] a) {
		final int[] res = new int[a.length];
		final int[] x = Arrays.stream(a).sorted().distinct().toArray();
		Arrays.setAll(res, i -> lowerBound(x, a[i]));
		return res;
	}
	/**
	 * 座標圧縮
	 * @param a
	 */
	protected static final int[] corPress(final long[] a) {
		final int[] res = new int[a.length];
		final long[] x = Arrays.stream(a).sorted().distinct().toArray();
		Arrays.setAll(res, i -> lowerBound(x, a[i]));
		return res;
	}
	/**
	 * ランレングス圧縮
	 * @param a
	 * @return ランレングス圧縮
	 */
	protected static final IntPair[] runLenPress(final int[] a) {
		final List<IntPair> ret = new ArrayList<>();
		for(final int e: a) {
			if(ret.isEmpty() || ret.getLast().first.intValue() != e) {
				ret.add(IntPair.of(e, 1));
			} else {
				ret.getLast().second++;
			}
		}
		return ret.toArray(IntPair[]::new);
	}
	/**
	 * ランレングス圧縮
	 * @param a
	 * @return ランレングス圧縮
	 */
	protected static final IntPair[] runLenPress(final long[] a) {
		final List<IntPair> ret = new ArrayList<>();
		for(final long e: a) {
			if(ret.isEmpty() || ret.getLast().first.longValue() != e) {
				ret.add(IntPair.of(e, 1));
			} else {
				ret.getLast().second++;
			}
		}
		return ret.toArray(IntPair[]::new);
	}
	/**
	 * ランレングス圧縮
	 * @param s
	 * @return ランレングス圧縮
	 */
	@SuppressWarnings("unchecked")
	protected static final Pair<Character, Integer>[] runLenPress(final String s) {
		final List<Pair<Character, Integer>> ret = new ArrayList<>();
		for(final char c: s.toCharArray()) {
			if(ret.isEmpty() || ret.getLast().first != c) {
				ret.add(Pair.of(c, 1));
			} else {
				ret.getLast().second++;
			}
		}
		return ret.toArray(Pair[]::new);
	}
	/**
	 * ランレングス圧縮したint型配列の復元
	 * @param a
	 * @return ランレングス圧縮したものを戻す
	 * @apiNote 必ずlong型の配列で返す
	 */
	protected static final long[] runLenRev(final IntPair[] a) {
		final List<Long> ret = new ArrayList<>();
		for(final IntPair e: a) {
			for(int i = 0; i < e.second.intValue(); ++i) {
				ret.add(e.first.longValue());
			}
		}
		return ret.stream().mapToLong(e -> e).toArray();
	}
	/**
	 * ランレングス圧縮した文字列の復元
	 * @param a
	 * @return ランレングス圧縮したものを戻す
	 */
	protected static final String runLenRev(final Pair<Character, Integer>[] a) {
		final StringBuilder sb = new StringBuilder();
		for(final Pair<Character, Integer> p: a) {
			for(int i = 0; i < p.second.intValue(); ++i) {
				sb.append(p.first.charValue());
			}
		}
		return sb.toString();
	}
	/**
	 * Z-Algorithm
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
	 * Manacher Algorithm
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
	 * nのk乗根を求める
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
			return modPow(a, a, m);
		}
		final long phi = eulerPhi(m);
		long tmp = tetration(a, b - 1, phi);
		if(tmp == 0) {
			tmp += phi;
		}
		return modPow(a, tmp, m);
	}
	/**
	 * ∑_{i=0}^{n−1} floor((a*i+b)/m)を求める
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
}