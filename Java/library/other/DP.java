package library.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import library.core.Utility;
import library.ds.pair.IntPair;

/**
 * DPを使った便利メソッドまとめ
 */
public final class DP {
	/**
	 * 01ナップザック
	 * 重さa_i, 価値v_iであるようなn個の品物があり、重さの和がw以下となるように選ぶときの価値の最大値を求める
	 * @param a
	 * @param v
	 * @param w
	 * @return dpの最大値
	 * @implNote O(NW)
	 */
	public static final long knapsack01(final int[] a, final long[] v, final int w) {
		final int n = a.length;
		final long[] dp = new long[w + 1];
		Arrays.fill(dp, Long.MIN_VALUE);
		dp[0] = 0;
		for(int i = 0; i < n; i++) {
			for(int j = w; j >= a[i]; j--) {
				if(dp[j - a[i]] != Long.MIN_VALUE) {
					if(dp[j - a[i]] + v[i] > dp[j]) {
						dp[j] = dp[j - a[i]] + v[i];
					}
				}
			}
		}
		return Utility.max(dp);
	}
	/**
	 * 01ナップザック
	 * 重さw_i, 価値v_iであるようなn個の品物があり、重さの和がw以下となるように選ぶときの価値の最大値を求める
	 * @param a
	 * @param v
	 * @param w
	 * @return dpの最大値
	 * @implNote O(N sum(v))
	 */
	public static final int knapsack01(final long[] a, final int[] v, final long w) {
		final int n = a.length;
		final int s = (int) Utility.sum(v);
		final long[] dp = new long[s + 1];
		Arrays.fill(dp, w + 1);
		dp[0] = 0;
		for(int i = 0; i < n; i++) {
			for(int j = s; j >= v[i]; j--) {
				dp[j] = Math.min(dp[j], dp[j - v[i]] + a[i]);
			}
		}
		int res = 0;
		for(int i = 0; i <= s; i++) {
			if(dp[i] <= w) {
				res = i;
			}
		}
		return res;
	}
	private static final long[] knapsack(final int[] a, final long[] v, final int[] m, final int w, final boolean less) {
		final int n = a.length;
		final long[] dp = new long[w + 1], deqv = new long[w + 1];
		Arrays.fill(dp, Long.MIN_VALUE);
		dp[0] = 0;
		final int[] deq = new int[w + 1];
		for(int i = 0; i < n; ++i) {
			if(a[i] == 0) {
				for(int j = 0; j <= w; ++j) {
					if(dp[j] != Long.MIN_VALUE && (less ? dp[j] + v[i] * m[i] < dp[j] : dp[j] + v[i] * m[i] > dp[j])) {
						dp[j] = dp[j] + v[i] * m[i];
					}
				}
			} else {
				for(int k = 0; k < a[i]; ++k) {
					int s = 0, t = 0;
					for(int j = 0; a[i] * j + k <= w; ++j) {
						if(dp[a[i] * j + k] != Long.MIN_VALUE) {
							final long val = dp[a[i] * j + k] - j * v[i];
							while(s < t && (less ? val < deqv[t - 1] : val > deqv[t - 1])) {
								t--;
							}
							deq[t] = j;
							deqv[t++] = val;
						}
						if(s < t) {
							dp[j * a[i] + k] = deqv[s] + j * v[i];
							if(deq[s] == j - m[i]) {
								s++;
							}
						}
					}
				}
			}
		}
		return dp;
	}
	/**
	 * 個数制限つきナップザック
	 * 重さw_i, 価値v_iであるようなn種類の品物があり、i番目の品物はm_i個まで選ぶことができる
	 * 重さの和がw以下となるように選ぶときの価値の最大値を求める
	 * @param a
	 * @param v
	 * @param m
	 * @param w
	 * @return dpの最大値
	 * @implNote O(NW)
	 */
	public static final long knapsack(final int[] a, final long[] v, final int[] m, final int w){ return Utility.max(knapsack(a, v, m, w, false)); }
	/**
	 * 個数制限つきナップザック
	 * 重さw_i, 価値v_iであるようなn種類の品物があり、i番目の品物はm_i個まで選ぶことができる
	 * 重さの和がw以下となるように選ぶときの価値の最大値を求める
	 * @param a
	 * @param v
	 * @param m
	 * @param w
	 * @return dpの最大値
	 * @implNote O((N max(v))^2)
	 */
	public static final long knapsack(final long[] a, final int[] v, final long[] m, final long w) {
		final int n = a.length;
		final int max = Utility.max(v);
		if(max == 0) {
			return 0;
		}
		final int[] ma = new int[n];
		final long[] mb = new long[n];
		for(int i = 0; i < n; i++) {
			ma[i] = (int) Math.min(m[i], max - 1);
			mb[i] = m[i] - ma[i];
		}
		int sum = 0;
		for(int i = 0; i < n; ++i) {
			sum += ma[i] * v[i];
		}
		final long[] dp = knapsack(v, a, ma, sum, true);
		final int[] id = Utility.iota(n).boxed().sorted((i, j) -> -Long.compare(v[i] * a[j], v[j] * a[i])).mapToInt(i -> i).toArray();
		long res = 0;
		for(int i = 0; i < dp.length; ++i) {
			if(dp[i] > w || dp[i] == Long.MIN_VALUE) {
				continue;
			}
			long rest = w - dp[i], cost = i;
			for(final int j: id) {
				final long get = Math.min(mb[j], rest / a[j]);
				if(get <= 0) {
					continue;
				}
				cost += get * v[j];
				rest -= get * a[j];
			}
			res = Math.max(res, cost);
		}
		return res;
	}
	/**
	 * 個数制限なしナップサック
	 * 重さw_i, 価値v_iであるようなn種類の品物があり、重さの和がw以下となるように選ぶときの価値の最大値を求める
	 * @param a
	 * @param v
	 * @param w
	 * @return dpの最大値
	 * @implNote O(NW)
	 */
	public static final long knapsack(final int[] a, final long[] v, final int w) {
		final int n = a.length;
		final long[] dp = new long[w + 1];
		Arrays.fill(dp, Long.MIN_VALUE);
		dp[0] = 0;
		for(int i = 0; i < n; i++) {
			for(int j = a[i]; j <= w; j++) {
				if(dp[j - a[i]] != Long.MIN_VALUE) {
					if(dp[j - a[i]] + v[i] > dp[j]) {
						dp[j] = dp[j - a[i]] + v[i];
					}
				}
			}
		}
		return Utility.max(dp);
	}
	/**
	 * @param a
	 * @return 最長増加部分列(Longest Increasing Subsequence)
	 * @see <a href="https://nyaannyaan.github.io/library/dp/longest-increasing-sequence.hpp">参考元</a>
	 * @implNote Java21より前のVerの場合、getLastをget(dp.size() - 1)に変える
	 */
	public static final int[] lis(final int[] a) {
		final int n = a.length;
		List<IntPair> dp = new ArrayList<IntPair>();
		final int[] p = new int[n];
		Arrays.fill(p, -1);
		for(int i = 0; i < n; ++i) {
			final int id = Utility.lowerBound(dp, IntPair.of(a[i], -i));
			if(id != 0) {
				p[i] = -dp.get(id - 1).second.intValue();
			}
			if(id == dp.size()) {
				dp.add(IntPair.of(a[i], -i));
			} else {
				dp.set(id, IntPair.of(a[i], -i));
			}
		}
		final List<Integer> res = new ArrayList<Integer>();
		for(int i = -dp.getLast().second.intValue(); i != -1; i = p[i]) {
			res.add(i);
		}
		Collections.reverse(res);
		return res.stream().mapToInt(i -> i).toArray();
	}
	/**
	 * @param a
	 * @return 最長増加部分列(Longest Increasing Subsequence)
	 * @see <a href="https://nyaannyaan.github.io/library/dp/longest-increasing-sequence.hpp">参考元</a>
	 * @implNote Java21より前のVerの場合、getLastをget(dp.size() - 1)に変える
	 */
	public static final int[] lis(final long[] a) {
		final int n = a.length;
		List<IntPair> dp = new ArrayList<IntPair>();
		final int[] p = new int[n];
		Arrays.fill(p, -1);
		for(int i = 0; i < n; ++i) {
			final int id = Utility.lowerBound(dp, IntPair.of(a[i], -i));
			if(id != 0) {
				p[i] = -dp.get(id - 1).second.intValue();
			}
			if(id == n) {
				dp.add(IntPair.of(a[i], -i));
			} else {
				dp.set(id, IntPair.of(a[i], -i));
			}
		}
		final List<Integer> res = new ArrayList<Integer>();
		for(int i = -dp.getLast().second.intValue(); i != -1; i = p[i]) {
			res.add(i);
		}
		Collections.reverse(res);
		return res.stream().mapToInt(i -> i).toArray();
	}
}