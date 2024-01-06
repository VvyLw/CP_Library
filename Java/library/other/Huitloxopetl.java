package library.other;

import java.util.HashMap;
import java.util.Map;

import library.core.Utility;
import library.structure.FenwickTree;

final class Huitloxopetl {
	final long invNum(final int[] a) {
		final int[] b = Utility.sorted(a);
		final Map<Integer, Integer> id = new HashMap<>();
		for(int i = 0; i < a.length; ++i) {
			id.put(b[i], i);
		}
		final FenwickTree bit = new FenwickTree(a.length);
		long res = 0;
		for(int i = 0; i < a.length; ++i) {
			res += i - bit.sum(id.get(a[i]));
			bit.add(id.get(a[i]), 1);
		}
		return res;
	}
	final long invNum(final long[] a) {
		final long[] b = Utility.sorted(a);
		final Map<Long, Integer> id = new HashMap<>();
		for(int i = 0; i < a.length; ++i) {
			id.put(b[i], i);
		}
		final FenwickTree bit = new FenwickTree(a.length);
		long res = 0;
		for(int i = 0; i < a.length; ++i) {
			res += i - bit.sum(id.get(a[i]));
			bit.add(id.get(a[i]), 1);
		}
		return res;
	}
}