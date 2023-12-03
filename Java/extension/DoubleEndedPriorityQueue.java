package extension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.IntStream;

class DoubleEndedPriorityQueue<T extends Number> {
	private Queue<NumPair> pq1;
	private Queue<NumPair> pq2;
	private int idx;
	private ArrayList<Boolean> used;
	DoubleEndedPriorityQueue(final ArrayList<T> depq) {
		final int n = depq.size();
		used = new ArrayList<>();
		IntStream.range(0, n).forEach(i -> used.add(true));
		idx = n;
		pq1 = new PriorityQueue<>(Collections.reverseOrder());
		pq2 = new PriorityQueue<>();
		IntStream.range(0, n).forEach(i -> {
			pq1.add(new NumPair(depq.get(i), i));
			pq2.add(new NumPair(depq.get(i), i));
		});
	}
	Number popMax() {
		while(!used.get(pq1.peek().second.intValue()) && used.get(pq1.peek().second.intValue()) != null) {
			pq1.poll();
		}
		final var res = pq1.poll();
		used.set(res.second.intValue(), false);
		return res.first;
	}
	Number popMin() {
		while(!used.get(pq2.peek().second.intValue()) && used.get(pq2.peek().second.intValue()) != null) {
			pq2.poll();
		}
		final var res = pq2.poll();
		used.set(res.second.intValue(), false);
		return res.first;
	}
	void push(final T x) {
		pq1.add(new NumPair(x, idx));
		pq2.add(new NumPair(x, idx));
		used.add(true);
		idx++;
	}
	Number getMax(){ return pq1.peek().first; }
	Number getMin(){ return pq2.peek().first; }
}