package extension;

import java.util.Arrays;
import java.util.stream.IntStream;

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