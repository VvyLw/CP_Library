import java.util.HashMap;

final class Huitloxopetl {
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
}
