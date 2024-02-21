package library.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.IntStream;

import library.core.VvyLw;
import library.core.interfaces.RecursiveIntPredicate;

/**
 * グラフクラス
 */
public class Graph extends ArrayList<ArrayList<Edge>> {
	protected final boolean undirected;
	protected final int n, indexed;
	protected int id;
	protected final ArrayList<Edge> edge;
	/**
	 * コンストラクタ
	 * @param n 頂点の個数
	 * @param indexed ?-indexed
	 * 0-indexedなら0, 1-indexedなら1
	 * @param undirected 無向グラフかどうか
	 * 無向グラフならtrue, 有向グラフならfalse
	 */
	public Graph(final int n, final int indexed, final boolean undirected) {
		this.n = n;
		this.indexed = indexed;
		this.undirected = undirected;
		id = 0;
		edge = new ArrayList<>();
		IntStream.range(0, n).forEach(i -> add(new ArrayList<>()));
	}
	/**
	 * 辺を追加する
	 * @param a
	 * @param b
	 */
	public final void addEdge(int a, int b) {
		a -= indexed;
		b -= indexed;
		this.get(a).add(new Edge(a, b, id));
		edge.add(new Edge(a, b, id++));
		if(undirected) {
			this.get(b).add(new Edge(b, a, --id));
			edge.add(new Edge(b, a, id++));
		}
	}
	/**
	 * 辺をm個入力する
	 * @param m 辺の個数
	 */
	public void input(final int m){ IntStream.range(0, m).forEach(i -> addEdge(VvyLw.io.ni(), VvyLw.io.ni())); }
	/**
	 * @return 辺のリスト
	 */
	public final ArrayList<Edge> getEdge(){ return edge; }
	/**
	 * BFSをして頂点vから各頂点に対する距離を求める
	 * @param v
	 */
	public final int[] allDist(final int v) {
		final int[] d = new int[n];
		Arrays.fill(d, -1);
		final Queue<Integer> q = new ArrayDeque<>();
		d[v] = 0;
		q.add(v);
		while(!q.isEmpty()) {
			final int tmp = q.poll();
			for(final Edge el: this.get(tmp)) {
				if(d[el.to] != -1) {
					continue;
				}
				d[el.to] = d[tmp] + 1;
				q.add(el.to);
			}
		}
		return d;
	}
	/**
	 * @param u
	 * @param v
	 * @return 頂点uと頂点vとの距離
	 */
	public final int dist(final int u, final int v){ return allDist(u)[v]; }
	/**
	 * トポロジカルソート
	 */
	public final ArrayList<Integer> topologicalSort() {
		final int[] deg = new int[n];
		for(int i = 0; i < n; ++i) {
			for(final Edge ed: this.get(i)) {
				deg[ed.to]++;
			}
		}
		final Stack<Integer> sk = new Stack<>();
		for(int i = 0; i < n; ++i) {
			if(deg[i] == 0) {
				sk.add(i);
			}
		}
		final ArrayList<Integer> ord = new ArrayList<>();
		while(!sk.isEmpty()) {
			final int tmp = sk.pop();
			ord.add(tmp);
			for(final Edge ed: this.get(tmp)) {
				if(--deg[ed.to] == 0) {
					sk.add(ed.to);
				}
			}
		}
		return ord.size() == n ? ord : new ArrayList<>();
	}
	/**
	 * @return サイクル
	 * if non-existence: 空配列
	 * @implNote 有向グラフ
	 */
	public final Edge[] cycleDetector() {
		final int[] used = new int[n];
		final Edge[] pre = new Edge[n];
		final ArrayList<Edge> cycle = new ArrayList<>();
		final RecursiveIntPredicate dfs = (rec, i) -> {
			used[i] = 1;
			for(final Edge e: get(i)) {
				if(used[e.to] == 0) {
					pre[e.to] = e;
					if(rec.test(rec, e.to)) {
						return true;
					}
				} else if(used[e.to] == 1) {
					int now = i;
					while(now != e.to) {
						cycle.add(pre[now]);
						now = pre[now].src;
					}
					cycle.add(e);
					return true;
				}
			}
			used[i] = 2;
			return false;
		};
		for(int i = 0; i < n; ++i) {
			if(used[i] == 0 && dfs.test(dfs, i)) {
				Collections.reverse(cycle);
				return cycle.toArray(Edge[]::new);
			}
		}
		return new Edge[]{};
	}
}