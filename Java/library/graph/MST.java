package library.graph;

import java.util.ArrayList;

/**
 * 最小全域木クラス
 */
public final class MST {
	public final ArrayList<Edge> tree;
	public final long cost;
	/**
	 * コンストラクタ
	 * @param tree
	 * @param cost
	 */
	MST(final ArrayList<Edge> tree, final long cost) {
		this.tree = tree;
		this.cost = cost;
	}
}