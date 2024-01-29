package library.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.IntStream;

import library.core.VvyLw;

/**
 * グラフクラス
 */
public class Graph extends ArrayList<ArrayList<Edge>> {
	protected final boolean undirected;
	protected final int n, indexed;
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
		this.get(a).add(new Edge(b));
		edge.add(new Edge(a, b, 0));
		if(undirected) {
			this.get(b).add(new Edge(a));
			edge.add(new Edge(b, a, 0));
		}
	}
	/**
	 * 辺をm個入力する
	 * @param m 辺の個数
	 */
	public void input(final int m){ IntStream.range(0, m).forEach(i -> addEdge(VvyLw.sc.ni(), VvyLw.sc.ni())); }
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
		return ord.size() == size() ? ord : new ArrayList<>();
	}
}