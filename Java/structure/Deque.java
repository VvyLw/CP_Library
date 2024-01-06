package library.structure;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class Deque<T> implements Iterable<T> {
	private int n, head, tail;
	private Object[] buf;
	Deque(){ this(1 << 17); }
	private Deque(final int n) {
		this.n = n;
		head = tail = 0;
		buf = new Object[n];
	}
	Deque(final T[] a) {
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
	private final void arraycopy(final int fromIndex, final T[] array, final int from, final int length) {
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
	@SuppressWarnings("unchecked")
	private final void extend() {
		final Object[] tmp = new Object[n << 1];
		arraycopy(0, (T[]) tmp, 0, size());
		buf = tmp;
		n = buf.length;
	}
	final boolean isEmpty(){ return size() == 0; }
	final int size() {
		final int size = tail - head;
		return size < 0 ? size + n : size;
	}
	final void addFirst(final T x) {
		if(prev(head) == tail) {
			extend();
		}
		head = prev(head);
		buf[head] = x;
	}
	final void addLast(final T x) {
		if(next(tail) == head) {
			extend();
		}
		buf[tail] = x;
		tail = next(tail);
	}
	final void removeFirst() {
		if(head == tail) {
			throw new NoSuchElementException("Buffer is empty");
		}
		head = next(head);
	}
	final void removeLast() {
		if(head == tail) {
			throw new NoSuchElementException("Buffer is empty");
		}
		tail = prev(tail);
	}
	@SuppressWarnings("unchecked")
	final T pollFirst() {
		if(head == tail) {
			throw new NoSuchElementException("Buffer is empty");
		}
		final T ans = (T) buf[head];
		head = next(head);
		return ans;
	}
	@SuppressWarnings("unchecked")
	final T pollLast() {
		if(head == tail) {
			throw new NoSuchElementException("Buffer is empty");
		}
		tail = prev(tail);
		return (T) buf[tail];
	}
	final T peekFirst(){ return get(0); }
	final T peekLast(){ return get(n - 1); }
	@SuppressWarnings("unchecked")
	final T get(final int i){ return (T) buf[index(i)]; }
	final void set(final int i, final T x){ buf[index(i)] = x; }
	final void add(final T x){ addLast(x); }
	final T poll(){ return pollFirst(); }
	final T peek(){ return peekFirst(); }
	@SuppressWarnings("unchecked")
	final void swap(final int a, final int b) {
		final int i = index(a);
		final int j = index(b);
		final T num = (T) buf[i];
		buf[i] = buf[j];
		buf[j] = num;
	}
	final void clear(){ head = tail = 0; }
	@SuppressWarnings("unchecked")
	final T[] toArray() {
		final Object[] array = new Object[size()];
		arraycopy(0, (T[]) array, 0, size());
		return (T[]) array;
	}
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