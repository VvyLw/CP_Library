package library.graph;

import java.util.ArrayList;

public final class MST {
	public final ArrayList<Edge> tree;
	public final long cost;
	MST(final ArrayList<Edge> tree, final long cost) {
		this.tree = tree;
		this.cost = cost;
	}
}