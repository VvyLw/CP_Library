package library.ds.deque;

import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * ランダムアクセスが可能なDeque
 * viralさんに感謝
 * @see <a href="https://github.com/viral8code/Primitive-Specialized-Library/blob/main/util/ArrayDeque/IntRingBuffer/IntRingBuffer.java">参考元</a>
 * @param <T> クラスを乗せる
 */
public final class MyDeque<T> implements Iterable<T> {
	private int n, head, tail;
	private Object[] buf;
	public MyDeque(){ this(1 << 17); }
	private MyDeque(final int n) {
		this.n = n;
		head = tail = 0;
		buf = new Object[n];
	}
	/**
	 * コンストラクタにint[]を乗せたい場合, 参考までに以下のように書くことができる
	 * new Deque<Integer>(Arrays.stream(a).boxed().toArray(Integer[]::new));
	 * @param a クラスTの配列
	 */
	public MyDeque(final T[] a) {
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
		assert i < size;
		final int id = head + i;
		return n <= id ? id - n : id;
	}
	private final void arraycopy(final int fromId, final T[] a, final int from, final int len) {
		assert fromId + len <= size();
		final int h = index(fromId);
		if(h + len < n) {
			System.arraycopy(buf, h, a, from, len);
		} else {
			final int back = n - h;
			System.arraycopy(buf, h, a, from, back);
			System.arraycopy(buf, 0, a, from + back, len - back);
		}
	}
	@SuppressWarnings("unchecked")
	private final void extend() {
		final Object[] tmp = new Object[n << 1];
		arraycopy(0, (T[]) tmp, 0, size());
		buf = tmp;
		n = buf.length;
	}
	/**
	 * Dequeが空かどうか判定する
	 * @return {@link Deque#size} == 0
	 */
	public final boolean isEmpty(){ return size() == 0; }
	/**
	 * @return Dequeの大きさ
	 */
	public final int size() {
		final int size = tail - head;
		return size < 0 ? size + n : size;
	}
	/**
	 * Dequeの先頭に要素を追加する
	 * @param x
	 */
	public final void addFirst(final T x) {
		if(prev(head) == tail) {
			extend();
		}
		head = prev(head);
		buf[head] = x;
	}
	/**
	 * Dequeの末尾に要素を追加する
	 * @param x
	 */
	public final void addLast(final T x) {
		if(next(tail) == head) {
			extend();
		}
		buf[tail] = x;
		tail = next(tail);
	}
	/**
	 * Dequeの先頭の要素を削除する
	 */
	public final void removeFirst() {
		if(head == tail) {
			throw new NoSuchElementException("Deque is empty");
		}
		head = next(head);
	}
	/**
	 * Dequeの末尾の要素を削除する
	 */
	public final void removeLast() {
		if(head == tail) {
			throw new NoSuchElementException("Deque is empty");
		}
		tail = prev(tail);
	}
	/**
	 * Dequeの先頭の要素を削除する
	 * @return Dequeの先頭にあった要素
	 */
	@SuppressWarnings("unchecked")
	public final T pollFirst() {
		if(head == tail) {
			throw new NoSuchElementException("Deque is empty");
		}
		final T ans = (T) buf[head];
		head = next(head);
		return ans;
	}
	/**
	 * Dequeの末尾の要素を削除する
	 * @return Dequeの末尾にあった要素
	 */
	@SuppressWarnings("unchecked")
	public final T pollLast() {
		if(head == tail) {
			throw new NoSuchElementException("Deque is empty");
		}
		tail = prev(tail);
		return (T) buf[tail];
	}
	/**
	 * @return Dequeの先頭にある要素
	 */
	public final T peekFirst(){ return get(0); }
	/**
	 * @return Dequeの末尾にある要素
	 */
	public final T peekLast(){ return get(n - 1); }
	/**
	 * ランダムアクセス
	 * @param i インデックス
	 * @return Dequeのi番目に格納されている要素
	 */
	@SuppressWarnings("unchecked")
	public final T get(final int i){ return (T) buf[index(i)]; }
	/**
	 * i番目に要素を代入する
	 * @param i インデックス
	 * @param x 要素
	 */
	public final void set(final int i, final T x){ buf[index(i)] = x; }
	/**
	 * @see #addLast
	 */
	public final void add(final T x){ addLast(x); }
	/**
	 * @see #pollFirst
	 */
	public final T poll(){ return pollFirst(); }
	/**
	 * @see #peekFirst
	 */
	public final T peek(){ return peekFirst(); }
	/**
	 * Dequeのa番目とb番目にある要素を入れ替える
	 * @param a インデックス
	 * @param b インデックス
	 */
	@SuppressWarnings("unchecked")
	public final void swap(final int a, final int b) {
		final int i = index(a), j = index(b);
		final T num = (T) buf[i];
		buf[i] = buf[j];
		buf[j] = num;
	}
	/**
	 * Dequeを空にする
	 */
	public final void clear(){ head = tail = 0; }
	/**
	 * @return 配列化したDeque
	 */
	@SuppressWarnings("unchecked")
	final T[] toArray() {
		final Object[] array = new Object[size()];
		arraycopy(0, (T[]) array, 0, size());
		return (T[]) array;
	}
	/**
	 * 出力するために必要
	 */
	@Override
	public final String toString(){ return Arrays.toString(toArray()); }
	/**
	 * イテレータ
	 */
	@Override
	public final Iterator<T> iterator(){ return new DequeIterator(); }
	/**
	 * イテレータの中身
	 */
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