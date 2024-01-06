package library.structure;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class Deque<T> implements Iterable<T> {
	private int n, head, tail;
	private Object[] buf;
	public Deque(){ this(1 << 17); }
	public Deque(final int n) {
		this.n = n;
		head = tail = 0;
		buf = new Object[n];
	}
	public Deque(final T[] a) {
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
	private final void extend() {
		buf = Arrays.copyOf(buf, n << 1);
		n = buf.length;
	}
	public final boolean isEmpty(){ return size() == 0; }
	public final int size() {
		final int size = tail - head;
		return size < 0 ? size + n : size;
	}
	public final void addFirst(final T x) {
		head = prev(head);
		if(head == tail) {
			extend();
		}
		buf[head] = x;
	}
	public final void addLast(final T x) {
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
	@SuppressWarnings("unchecked")
	public final T pollFirst() {
		if(head == tail) {
			throw new NoSuchElementException("Buffer is empty");
		}
		final T ans = (T) buf[head];
		head = next(head);
		return ans;
	}
	@SuppressWarnings("unchecked")
	public final T pollLast() {
		if(head == tail) {
			throw new NoSuchElementException("Buffer is empty");
		}
		tail = prev(tail);
		return (T) buf[tail];
	}
	public final T peekFirst(){ return get(0); }
	public final T peekLast(){ return get(n - 1); }
	@SuppressWarnings("unchecked")
	public final T get(final int i){ return (T) buf[index(i)]; }
	public final void set(final int i, final T x){ buf[index(i)] = x; }
	public final void add(final T x){ addLast(x); }
	public final T poll(){ return pollFirst(); }
	public final T peek(){ return peekFirst(); }
	@SuppressWarnings("unchecked")
	public final void swap(final int a, final int b) {
		final int i = index(a);
		final int j = index(b);
		final T num = (T) buf[i];
		buf[i] = buf[j];
		buf[j] = num;
	}
	public final void clear(){ head = tail = 0; }
	@SuppressWarnings("unchecked")
	public final T[] toArray(){ return (T[]) Arrays.copyOf(buf, size()); }
	@Override
	public final String toString(){ return Arrays.toString(toArray()); }
	@Override
	public final Iterator<T> iterator(){ return new DequeIterator(); }
	private class DequeIterator implements Iterator<T> {
		private int now = head;
		private int rem = size();
		@Override
		public boolean hasNext(){ return rem > 0; }
		@Override
		public final T next() {
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			@SuppressWarnings("unchecked")
			final T res = (T) buf[now];
			now = (now + 1) % n;
			rem--;
			return res;
		}
		@Override
		public final void remove() {
			if(isEmpty()) {
				throw new IllegalStateException();
			}
			now = (now - 1 + n) % n;
			buf[now] = null;
			head = (head + 1) % n;
			rem++;
		}
	}
}