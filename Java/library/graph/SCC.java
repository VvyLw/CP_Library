package library.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

import library.core.interfaces.RecursiveBiConsumer;
import library.core.interfaces.RecursiveIntConsumer;

/**
 * 強連結成分分解(Strongly Connected Components)
 * 遅い(<a href="https://judge.yosupo.jp/problem/scc">verify用問題</a>のcase:large_cycle_00がTLE)
 * @deprecated {@link StackOverflowError}が起こる(<a href="https://onlinejudge.u-aizu.ac.jp/problems/GRL_3_C">発生した問題</a>)
 * @see <a href="https://ei1333.github.io/library/graph/connected-components/strongly-connected-components.hpp">参考元</a>
 */
public final class SCC {
	private final int[] comp;
	private final ArrayList<ArrayList<Integer>> group;
	private final Graph dag;
	/**
	 * コンストラクタ
	 * @param g
	 */
	public SCC(final Graph g) {
		final int n = g.size();
		final Graph rg = new Graph(n, 0, false);
		for(int i = 0; i < n; ++i) {
			for(final Edge e: g.get(i)) {
				rg.addEdge(e.to, e.src);
			}
		}
		final ArrayList<Integer> order = new ArrayList<>();
		final boolean[] used = new boolean[n];
		comp = new int[n];
		Arrays.fill(comp, -1);
		final RecursiveIntConsumer dfs = (rec, i) -> {
			if(used[i]) {
				return;
			}
			used[i] = true;
			for(final Edge e: g.get(i)) {
				rec.accept(rec, e.to);
			}
			order.add(i);
		};
		for(int i = 0; i < n; ++i) {
			dfs.accept(dfs, i);
		}
		Collections.reverse(order);
		int ptr = 0;
		final RecursiveBiConsumer<Integer, Integer> rdfs = (rec, i, cnt) -> {
			if(comp[i] != -1) {
				return;
			}
			comp[i] = cnt;
			for(final Edge e: rg.get(i)) {
				rec.accept(rec, e.to, cnt);
			}
		};
		for(final int i: order) {
			if(comp[i] == -1) {
				rdfs.accept(rdfs, i, ptr++);
			}
		}
		dag = new Graph(ptr, 0, false);
		for(int i = 0; i < n; ++i) {
			for(final Edge e: g.get(i)) {
				final int x = comp[e.src], y = comp[e.to];
				if(x == y) {
					continue;
				}
				dag.addEdge(x, y);
			}
		}
		group = new ArrayList<>();
		IntStream.range(0, ptr).forEach(i -> group.add(new ArrayList<>()));
		for(int i = 0; i < n; ++i) {
			group.get(comp[i]).add(i);
		}
	}
	/**
	 * @param i
	 * @return 各頂点が属する強連結成分のi番目の頂点番号
	 */
	public final int get(final int i){ return comp[i]; }
	/**
	 * @return 各強連結成分について属する頂点
	 */
	public final ArrayList<ArrayList<Integer>> groups(){ return group; }
	/**
	 * @return 縮約後の頂点と辺からなるDAG
	 */
	public final Graph DAG(){ return dag; }
}