//package extension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;

class Huitloxopetl {
	final long invNum(final int[] a) {
		final var b = Utility.sorted(a);
		final var id = new int[a.length];
		for(int i = 0; i < a.length; ++i) {
			id[b[i]] = i;
		}
		final var bit = new FenwickTree(a.length);
		long res = 0;
		for(int i = 0; i < a.length; ++i) {
			res += i - bit.sum(id[a[i]]);
			bit.add(id[a[i]], 1);
		}
		return res;
	}
	final long invNum(final long[] a) {
		final var b = Utility.sorted(a);
		final var id = new HashMap<Long, Integer>();
		for(int i = 0; i < a.length; ++i) {
			id.put(b[i], i);
		}
		final var bit = new FenwickTree(a.length);
		long res = 0;
		for(int i = 0; i < a.length; ++i) {
			res += i - bit.sum(id.get(a[i]));
			bit.add(id.get(a[i]), 1);
		}
		return res;
	}
	final MST kruskal(final ArrayList<Edge> edge, final int n) {
		Collections.sort(edge, Comparator.comparing(e -> e.cost));
		final UnionFind uf = new UnionFind(n);
		final var e = new ArrayList<Edge>();
		long res = 0;
		for(final var ed: edge) {
			if(uf.unite(ed.src, ed.to)) {
				e.add(ed);
				res += ed.cost;
			}
		}
		return new MST(e, res);
	}
	// DO NOT USE
	final ArrayList<Edge> manhattan(int[] x, int[] y) {
		if(x.length != y.length) {
			throw new AssertionError("x.length != y.length");
		}
		final var res = new ArrayList<Edge>();
		int[] id = Utility.iota(x.length);
		for(int s = 0; s < 2; ++s) {
			for(int t = 0; t < 2; ++t) {
				id = Arrays.stream(id).boxed().sorted((i, j) -> Integer.compare(x[i] + y[i], x[j] + y[j])).mapToInt(i -> i).toArray();
				final var idx = new TreeMap<Integer, Integer>();
				for(final var i: id) {
					final var it = idx.tailMap(y[i]).entrySet().iterator();
					while(it.hasNext()) {
						final int j = it.next().getValue();
						System.err.println(j);
						if(x[i] - x[j] < y[i] - y[j]) {
							break;
						}
						res.add(new Edge(i, j, Math.abs(x[i] - x[j]) + Math.abs(y[i] - y[j])));
						it.remove();
					}
					idx.put(-y[i], i);
				}
				final var tmp = y;
				System.arraycopy(x, 0, y, 0, x.length);
				System.arraycopy(tmp, 0, x, 0, x.length);
			}
			for(int i = 0; i < x.length; ++i) {
				x[i] = -x[i];
			}
		}
		return res;
	}
	final ArrayList<Edge> manhattan(long[] x, long[] y) {
		if(x.length != y.length) {
			throw new AssertionError("x.length != y.length");
		}
		final var res = new ArrayList<Edge>();
		int[] id = Utility.iota(x.length);
		for(int s = 0; s < 2; ++s) {
			for(int t = 0; t < 2; ++t) {
				id = Arrays.stream(id).boxed().sorted((i, j) -> Long.compare(x[i] + y[i], x[j] + y[j])).mapToInt(i -> i).toArray();
				final var idx = new TreeMap<Long, Integer>();
				for(final var i: id) {
					final var it = idx.tailMap(y[i]).entrySet().iterator();
					while(it.hasNext()) {
						final int j = it.next().getValue();
						if(x[i] - x[j] < y[i] - y[j]) {
							break;
						}
						res.add(new Edge(i, j, Math.abs(x[i] - x[j]) + Math.abs(y[i] - y[j])));
						it.remove();
					}
					idx.put(-y[i], i);
				}
				final var tmp = y;
				System.arraycopy(x, 0, y, 0, x.length);
				System.arraycopy(tmp, 0, x, 0, x.length);
			}
			for(int i = 0; i < x.length; ++i) {
				x[i] = -x[i];
			}
		}
		return res;
	}
}