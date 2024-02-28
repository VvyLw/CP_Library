package library.ds;

import library.ds.deque.Deque;
import library.ds.pair.IntPair;

/**
 * Convex Hull Trick Add Monotone
 * 整数型にしか対応していない
 * @deprecated verifyしていない
 * @see <a href="https://ei1333.github.io/library/structure/convex-hull-trick/convex-hull-trick-add-monotone.hpp">参考元</a>
 */
public final class ConvexHullTrick {
	private final Deque<IntPair> h;
	private final boolean isMin;
	ConvexHullTrick(final boolean isMin) {
		this.isMin = isMin;
		h = new Deque<>();
	}
	private final boolean isEmpty(){ return h.isEmpty(); }
	final void clear(){ h.clear(); }
	final int size(){ return h.size(); }
	final Deque<IntPair> get(){ return h; }
	private final int sgn(final long x){ return x == 0 ? 0 : (x < 0 ? -1 : 1); }
	private final boolean check(final IntPair a, final IntPair b, final IntPair c) {
		if(b.second.longValue() == a.second.longValue() || c.second.longValue() == b.second.longValue()) {
			return sgn(b.first.longValue() - a.first.longValue()) * sgn(c.second.longValue() - b.second.longValue()) >= sgn(c.first.longValue() - b.first.longValue()) * sgn(b.second.longValue() - a.second.longValue());
		}
		return (b.second.longValue() - a.second.longValue()) / (a.first.longValue() - b.first.longValue()) >= (c.second.longValue() - b.second.longValue()) / (b.first.longValue() - c.first.longValue());
	}
	final void add(long a, long b) {
		if(!isMin) {
			a = -a;
			b = -b;
		}
		final IntPair line = IntPair.of(a, b);
		if(isEmpty()) {
			h.add(line);
			return;
		}
		if(h.peekFirst().first.longValue() <= a) {
			if(h.peekFirst().first.longValue() == a) {
				if(h.peekFirst().second.longValue() <= b) {
					return;
				}
				h.pollFirst();
			}
			while(h.size() >= 2 && check(line, h.peekFirst(), h.get(1))) {
				h.pollFirst();
			}
			h.add(line);
		} else {
			assert a <= h.peekLast().first.longValue();
			if(h.peekLast().first.longValue() == a) {
				if(h.peekLast().second.longValue() <= b) {
					return;
				}
				h.pollLast();
			}
			while(h.size() >= 2 && check(h.get(h.size() - 2), h.peekLast(), line)) {
				h.pollLast();
			}
			h.add(line);
		}
	}
	private final long get(final IntPair p, final long x){ return p.first.longValue() * x + p.second.longValue(); }
	final long query(final long x) {
		assert !isEmpty();
		int l = -1, r = h.size() - 1;
		while(l + 1 < r) {
			int m = (l + r) >> 1;
			if(get(h.get(m), x) >= get(h.get(m + 1), x)) {
				l = m;
			} else {
				r = m;
			}
		}
		return isMin ? get(h.get(r), x) : -get(h.get(r), x);
	}
	final long queryMonotoneInc(final long x) {
		assert !isEmpty();
		while(h.size() >= 2 && get(h.peekFirst(), x) >= get(h.get(1), x)) {
			h.pollFirst();
		}
		return isMin ? get(h.peekFirst(), x) : -get(h.peekFirst(), x);
	}
	final long queryMonotoneDec(final long x) {
		assert !isEmpty();
		while(h.size() >= 2 && get(h.peekLast(), x) >= get(h.get(h.size() - 2), x)) {
			h.pollLast();
		}
		return isMin ? get(h.peekLast(), x) : -get(h.peekLast(), x);
	}
}