package library.ds;

import java.util.ArrayList;
import java.util.Collections;

/**
 * DoubleEndedPriorityQueue
 * 両端からアクセスできるHeapQueue
 * @param <T>
 */
public final class DoubleEndedPriorityQueue<T extends Number> {
	private final ArrayList<T> d;
	/**
	 * コンストラクタ
	 * @param d
	 */
	public DoubleEndedPriorityQueue(final ArrayList<T> d) {
		this.d = d;
		makeHeap();
	}
	private final void makeHeap() {
		for(int i = d.size(); i-- > 0;) {
			if (i % 2 == 1 && d.get(i - 1).longValue() < d.get(i).longValue()) {
				Collections.swap(d, i - 1, i);
			}
			up(down(i), i);
		}
	}
	private final int down(int k) {
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
	private final int up(int k, final int root) {
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
	private final int parent(final int k){ return ((k >> 1) - 1) & ~1; }
	private final void popBack(final ArrayList<T> d){ d.remove(d.size() - 1); } 
	/**
	 * 要素を追加する
	 * @param x
	 */
	public final void push(final T x) {
		final int k = d.size();
		d.add(x);
		up(k, 1);
	}
	/**
	 * 最小値を削除する
	 * @return 削除した最小値
	 */
	public final T popMin() {
		final T res = getMin();
		if(d.size() < 3) {
			popBack(d); 
		} else {
			Collections.swap(d, 1, d.size() - 1);
			popBack(d);
			up(down(1), 1);
		}
		return res;
	}
	/**
	 * 最大値を削除する
	 * @return 削除した最大値
	 */
	public final T popMax() {
		final T res = getMax();
		if(d.size() < 2) { 
			popBack(d);
		} else {
			Collections.swap(d, 0, d.size() - 1);
			popBack(d);
			up(down(0), 1);
		}
		return res;
	}
	/**
	 * @return 最小値
	 */
	public final T getMin(){ return d.size() < 2 ? d.get(0) : d.get(1); }
	/**
	 * @return 最大値
	 */
	public final T getMax(){ return d.get(0); }
	/**
	 * @return PriorityQueueのサイズ
	 */
	public final int size(){ return d.size(); }
	/**
	 * PriorityQueueが空かどうか判定する
	 */
	public final boolean isEmpty(){ return d.isEmpty(); }
}