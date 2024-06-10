package library.graph;

import static java.lang.Math.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

import library.core.Utility;
import library.core.VvyLw;

/**
 * 強連結成分分解(Strongly Connected Components)
 * @see <a href="https://github.com/NASU41/AtCoderLibraryForJava/tree/master/SCC">参考元</a>
 */
public final class SCC {
	private final int n, indexed;
	private int m;
	private final ArrayList<Edge> edge;
	private final int[] start, ids;
	private int[][] groups;
	private boolean notBuilt;
	/**
	 * コンストラクタ
	 * 1-indexed
	 * @param n
	 */
	public SCC(final int n){ this(n, 1); }
	/**
	 * コンストラクタ
	 * 有向グラフを作る
	 * @param n サイズ
	 * @param indexed
	 */
	public SCC(final int n, final int indexed) {
		this.n = n;
		this.indexed = indexed;
		edge = new ArrayList<>();
		start = new int[n + 1];
		ids = new int[n];
		m = 0;
		notBuilt = true;
	}
	/**
	 * 辺を追加する
	 * @param from
	 * @param to
	 */
	public final void addEdge(int from, int to) {
		from -= indexed;
		to -= indexed;
		rangeCheck(from);
		rangeCheck(to);
		edge.add(new Edge(from, to, m++));
		start[from + 1]++;
	}
	/**
	 * 辺をm個入力する
	 * @param m
	 */
	public final void input(final int m){ IntStream.range(0, m).forEach(i -> addEdge(VvyLw.io.ni(), VvyLw.io.ni())); }
	/**
	 * 頂点iの強連結成分の頂点番号を返す
	 * @param i
	 * @return 頂点iの強連結成分の頂点番号
	 */
	public final int id(final int i) {
		if(notBuilt) {
			throw new UnsupportedOperationException("Graph hasn't been built.");
		}
		rangeCheck(i);
		return ids[i];
	}
	/**
	 * 構築
	 */
	public final void build() {
		for(int i = 1; i <= n; i++) {
			start[i] += start[i - 1];
		}
		final Edge[] ed = new Edge[m];
		final int[] count = new int[n + 1];
		System.arraycopy(start, 0, count, 0, n + 1);
		for(final Edge e: edge) {
			ed[count[e.src]++] = e;
		}
		int nowOrd = 0, groupNum = 0, k = 0, ptr = 0;
		final int[] par = new int[n], vis = new int[n], low = new int[n], ord = new int[n];
		Arrays.fill(ord, -1);
		final long[] stack = new long[n];
		for(int i = 0; i < n; i++) {
			if(ord[i] >= 0) {
				continue;
			}
			par[i] = -1;
			stack[ptr++] = 0L << 32 | i;
			while(ptr > 0) {
				long p = stack[--ptr];
				int u = (int) (p & 0xffff_ffffl);
				int j = (int) (p >>> 32);
				if(j == 0) {
					low[u] = ord[u] = nowOrd++;
					vis[k++] = u;
				}
				if(start[u] + j < count[u]) {
					int to = ed[start[u] + j].to;
					stack[ptr++] += 1l << 32;
					if(ord[to] == -1) {
						stack[ptr++] = 0l << 32 | to;
						par[to] = u;
					} else {
						low[u] = min(low[u], ord[to]);
					}
				} else {
					while(j --> 0) {
						final int to = ed[start[u] + j].to;
						if(par[to] == u) {
							low[u] = min(low[u], low[to]);
						}
					}
					if(low[u] == ord[u]) {
						while(true) {
							final int v = vis[--k];
							ord[v] = n;
							ids[v] = groupNum;
							if(v == u) {
								break;
							}
						}
						groupNum++;
					}
				}
			}
		}
		for(int i = 0; i < n; i++) {
			ids[i] = groupNum - 1 - ids[i];
		}        
		final int[] counts = new int[groupNum];
		for(final int x: ids) {
			counts[x]++;
		}
		groups = new int[groupNum][];
		for(int i = 0; i < groupNum; i++) {
			groups[i] = new int[counts[i]];
		}
		for(int i = 0; i < n; i++) {
			int cmp = ids[i];
			groups[cmp][--counts[cmp]] = i;
		}
		notBuilt = false;
	}
	/**
	 * 各強連結成分についてそれに属する頂点を返す
	 * @return 各強連結成分についてそれに属する頂点
	 */
	public final int[][] groups() {
		if(notBuilt) {
			throw new UnsupportedOperationException("Graph hasn't been built.");
		}
		return groups;
	}
	private final void rangeCheck(final int i) {
		if(!Utility.scope(0, i, n - 1)) {
			throw new IndexOutOfBoundsException(String.format("Index %d out of bounds for length %d", i, n));
		}
	}
}