package library.graph;

import java.util.Arrays;
import java.util.stream.IntStream;

public final class LowestCommonAncestor<G extends Graph> {
	private final int log;
	private final int[] dep, sum;
	private final G g;
	private final int[][] table;
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
	public final int dist(final int u, final int v){ return sum[u] + sum[v] - 2 * sum[query(u, v)]; }
}