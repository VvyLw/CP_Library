package library.structure.deque;

import java.util.Arrays;
import java.util.NoSuchElementException;

public final class IntDeque {
	private int n, head, tail;
	private long[] buf;
	public IntDeque(){ this(1 << 17); }
	private IntDeque(final int n) {
		this.n = n;
		head = tail = 0;
		buf = new long[n];
	}
	public IntDeque(final int[] a) {
		this(a.length);
		Arrays.stream(a).forEach(i -> add(i));
	}
	public IntDeque(final long[] a) {
		this(a.length);
		Arrays.stream(a).forEach(i -> add(i));
	}
	private final int next(final int index) {
		final int next = index + 1;
		return next == n ? 0 : next;
	}
	private final int prev(final int index) {
		final int prev = index - 1;
		return prev == -1 ? n - 1 : prev;
	}
	private final int index(final int i) {
		final int size = size();
		if(i >= size) {
			throw new IndexOutOfBoundsException("Index "+ i +" out of bounds for length " + size);
		}
		final int id = head + i;
		return n <= id ? id - n : id;
	}
	private final void arraycopy(final int fromIndex, final long[] array, final int from, final int length) {
		if(fromIndex + length > size()) {
			throw new IndexOutOfBoundsException("last source index " + (fromIndex + length) + " out of bounds for int[" + size() + "]");
		}
		final int h = index(fromIndex);
		if(h + length < n) {
			System.arraycopy(buf, h, array, from, length);
		} else {
			final int back = n - h;
			System.arraycopy(buf, h, array, from, back);
			System.arraycopy(buf, 0, array, from + back, length - back);
		}
	}
	private final void extend() {
		final long[] tmp = new long[n << 1];
		arraycopy(0, tmp, 0, size());
		buf = tmp;
		n = buf.length;
	}
	public final boolean isEmpty(){ return size() == 0; }
	public final int size() {
		final int size = tail - head;
		return size < 0 ? size + n : size;
	}
	public final void addFirst(final long x) {
		head = prev(head);
		if(head == tail) {
			extend();
		}
		buf[head] = x;
	}
	public final void addLast(final long x) {
		if(next(tail) == head) {
			extend();
		}
		buf[tail] = x;
		tail = next(tail);
	}
	public final void removeFirst() {
		if(head == tail) {
			throw new NoSuchElementException("Buffer is empty");
		}
		head = next(head);
	}
	public final void removeLast() {
		if(head == tail) {
			throw new NoSuchElementException("Buffer is empty");
		}
		tail = prev(tail);
	}
	public final long pollFirst() {
		if(head == tail) {
			throw new NoSuchElementException("Buffer is empty");
		}
		final long ans = buf[head];
		head = next(head);
		return ans;
	}
	public final long pollLast() {
		if(head == tail) {
			throw new NoSuchElementException("Buffer is empty");
		}
		tail = prev(tail);
		return buf[tail];
	}
	public final long peekFirst(){ return get(0); }
	public final long peekLast(){ return get(n - 1); }
	public final long get(final int i){ return buf[index(i)]; }
	public final void set(final int i, final long x){ buf[index(i)] = x; }
	public final void add(final long x){ addLast(x); }
	public final long poll(){ return pollFirst(); }
	public final long peek(){ return peekFirst(); }
	public final void swap(final int a, final int b) {
		final int i = index(a);
		final int j = index(b);
		final long num = buf[i];
		buf[i] = buf[j];
		buf[j] = num;
	}
	public final void clear(){ head = tail = 0; }
	public final long[] toArray(){ return Arrays.copyOf(buf, size()); }
	@Override
	public final String toString(){ return Arrays.toString(toArray()); }
}