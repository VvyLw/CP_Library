package extension;

import java.util.function.LongBinaryOperator;
import java.util.function.LongPredicate;

final class SparseTable {
	private final long[][] st;
	private final int[] lookup;
	private final LongBinaryOperator op;
	SparseTable(final int[] a, final LongBinaryOperator op) {
		this.op = op;
		int b = 0;
		while((1 << b) <= a.length) {
			++b;
		}
		st = new long[b][1 << b];
		for(int i = 0; i < a.length; i++) {
			st[0][i] = a[i];
		}
		for(int i = 1; i < b; i++) {
			for(int j = 0; j + (1 << i) <= (1 << b); j++) {
				st[i][j] = op.applyAsLong(st[i - 1][j], st[i - 1][j + (1 << (i - 1))]);
			}
		}
		lookup = new int[a.length + 1];
		for(int i = 2; i < lookup.length; i++) {
			lookup[i] = lookup[i >> 1] + 1;
		}
	}
	SparseTable(final long[] a, final LongBinaryOperator op) {
		this.op = op;
		int b = 0;
		while((1 << b) <= a.length) {
			++b;
		}
		st = new long[b][1 << b];
		for(int i = 0; i < a.length; i++) {
			st[0][i] = a[i];
		}
		for(int i = 1; i < b; i++) {
			for(int j = 0; j + (1 << i) <= (1 << b); j++) {
				st[i][j] = op.applyAsLong(st[i - 1][j], st[i - 1][j + (1 << (i - 1))]);
			}
		}
		lookup = new int[a.length + 1];
		for(int i = 2; i < lookup.length; i++) {
			lookup[i] = lookup[i >> 1] + 1;
		}
	}
	final long query(final int l, final int r) {
		final int b = lookup[r - l];
		return op.applyAsLong(st[b][l], st[b][r - (1 << b)]);
	}
	final int minLeft(final int x, final LongPredicate fn) {
		if(x == 0) {
			return 0;
		}
		int ok = x, ng = -1;
		while(Math.abs(ok - ng) > 1) {
			final int mid = (ok + ng) / 2;
			if(fn.test(query(mid, x) - 1)) {
				ok = mid;
			}
			else {
				ng = mid;
			}
		}
		return ok;
	}
	final int maxRight(final int x, final LongPredicate fn) {
		if(x == lookup.length - 1) {
			return lookup.length - 1;
		}
		int ok = x, ng = lookup.length;
		while(Math.abs(ok - ng) > 1) {
			int mid = (ok + ng) / 2;
			if(fn.test(query(x, mid))) {
				ok = mid;
			}
			else {
				ng = mid;
			}
		}
		return ok;
	}
}