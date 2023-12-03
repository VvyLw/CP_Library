package extension;

import java.util.ArrayList;
import java.util.Collections;

class DoubleEndedPriorityQueue<T extends Number> {
	private ArrayList<T> d;
	DoubleEndedPriorityQueue(final ArrayList<T> d) {
		this.d = d;
		make_heap();
	}
	private void make_heap() {
		for(int i = d.size(); i-- > 0;) {
			if (i % 2 == 1 && d.get(i - 1).longValue() < d.get(i).longValue()) {
				Collections.swap(d, i - 1, i);
			}
			up(down(i), i);
		}
	}
	private int down(int k) {
		final int n = d.size();
		if(k % 2 == 1) {
			while(2 * k + 1 < n) {
				int c = 2 * k + 3;
				if(n <= c || d.get(c - 2).longValue() < d.get(c).longValue()) {
					 c -= 2;
				}
				if(c < n && d.get(c).longValue() < d.get(k).longValue()) {
					Collections.swap(d, k, c);
					k = c;
				}
				else {
					break;
				}
			}
		} else {
			while(2 * k + 2 < n) {
				int c = 2 * k + 4;
				if(n <= c || d.get(c).longValue() < d.get(c - 2).longValue()) {
					c -= 2;
				}
				if(c < n && d.get(k).longValue() < d.get(c).longValue()) {
					Collections.swap(d, k, c);
					k = c;
				}
				else {
					break;
				}
			}
		}
		return k;
	}
	private int up(int k, final int root) {
		if((k | 1) < d.size() && d.get(k & ~1).longValue() < d.get(k | 1).longValue()) {
			Collections.swap(d, k & ~1, k | 1);
			k ^= 1;
		}
		int p;
		while(root < k && d.get(p = parent(k)).longValue() < d.get(k).longValue()) {
			Collections.swap(d, p, k);
			k = p;
		}
		while(root < k && d.get(k).longValue() < d.get(p = parent(k) | 1).longValue()) {
			Collections.swap(d, p, k);
			k = p;
		}
		return k;
	}
	private int parent(final int k){ return ((k >> 1) - 1) & ~1; }
	private void popBack(final ArrayList<T> d){ d.remove(d.size() - 1); } 
	void push(final T x) {
		final int k = d.size();
		d.add(x);
		up(k, 1);
	}
	T popMin() {
		final var res = getMin();
		if(d.size() < 3) {
			popBack(d); 
		} else {
			Collections.swap(d, 1, d.size() - 1);
			popBack(d);
			up(down(1), 1);
		}
		return res;
	}
	T popMax() {
		final var res = getMax();
		if(d.size() < 2) { 
			popBack(d);
		} else {
			Collections.swap(d, 0, d.size() - 1);
			popBack(d);
			up(down(0), 1);
		}
		return res;
	}
	T getMin(){ return d.size() < 2 ? d.get(0) : d.get(1); }
	T getMax(){ return d.get(0); }
	int size(){ return d.size(); }
    boolean isEmpty(){ return d.isEmpty(); }
}