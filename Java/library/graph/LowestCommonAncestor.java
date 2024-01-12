package library.graph;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 最小共通祖先を求めるクラス
 * [注意] verifyをしていない
 * @param <G> Graph, あるいはWeightedGraphクラスを入れる
 */
public final class LowestCommonAncestor<G extends Graph> {
	private final int log;
	private final int[] dep, sum;
	private final G g;
	private final int[][] table;
	/**
	 * コンストラクタ
	 * @param g グラフ
	 */
	public LowestCommonAncestor(final G g) {
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
		for(final Edge el: g.get(idx)) {
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
	/**
	 * 頂点uと頂点vとの最小共通祖先を求める
	 * @param u
	 * @param v
	 * @return
	 */
	public final int query(int u, int v) {
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
	/**
	 * @param u
	 * @param k
	 * @return 頂点uからk個親に遡った頂点
	 */
	public final int climb(int u, final int k) {
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
	/**
	 * @param u
	 * @param v
	 * @return 頂点uと頂点vとのパスの辺の本数
	 */
	public final int dist(final int u, final int v){ return sum[u] + sum[v] - 2 * sum[query(u, v)]; }
}