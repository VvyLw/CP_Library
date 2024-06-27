package library.ds.deque;

import java.util.Arrays;
import java.util.Deque;
import java.util.NoSuchElementException;

/**
 * 整数特化のDeque
 * Iteratorはない
 * @see Deque
 */
public final class IntDeque {
	private int n, head, tail;
	private long[] buf;
	/**
	 * コンストラクタ
	 */
	public IntDeque(){ this(1 << 17); }
	private IntDeque(final int n) {
		this.n = n;
		head = tail = 0;
		buf = new long[n];
	}
	/**
	 * コンストラクタ
	 * @param a int型の配列
	 */
	public IntDeque(final int[] a) {
		this(a.length);
		Arrays.stream(a).forEach(this::add);
	}
	/**
	 * コンストラクタ
	 * @param a long型の配列
	 */
	public IntDeque(final long[] a) {
		this(a.length);
		Arrays.stream(a).forEach(this::add);
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
	private final void arraycopy(final int fromId, final long[] a, final int from, final int len) {
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
	private final void extend() {
		final long[] tmp = new long[n << 1];
		arraycopy(0, tmp, 0, size());
		buf = tmp;
		n = buf.length;
	}
	/**
	 * Dequeが空かどうか判定する
	 * @return Dequeが空かどうか
	 */
	public final boolean isEmpty(){ return size() == 0; }
	/**
	 * Dequeの大きさを返す
	 * @return Dequeのサイズ
	 */
	public final int size() {
		final int size = tail - head;
		return size < 0 ? size + n : size;
	}
	/**
	 * Dequeの先頭に要素を追加する
	 * @param x
	 */
	public final void addFirst(final long x) {
		head = prev(head);
		if(head == tail) {
			extend();
		}
		buf[head] = x;
	}
	/**
	 * Dequeの末尾に要素を追加する
	 * @param x
	 */
	public final void addLast(final long x) {
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
	 * @return 削除した要素
	 */
	public final long pollFirst() {
		if(head == tail) {
			throw new NoSuchElementException("Deque is empty");
		}
		final long ans = buf[head];
		head = next(head);
		return ans;
	}
	/**
	 * Dequeの末尾の要素を削除する
	 * @return 削除した要素
	 */
	public final long pollLast() {
		if(head == tail) {
			throw new NoSuchElementException("Deque is empty");
		}
		tail = prev(tail);
		return buf[tail];
	}
	/**
	 * Dequeの先頭の要素を返す
	 * @return Dequeの先頭の要素
	 */
	public final long peekFirst(){ return get(0); }
	/**
	 * Dequeの末尾の要素を返す
	 * @return Dequeの末尾の要素
	 */
	public final long peekLast(){ return get(n - 1); }
	/**
	 * Deque[i]を返す
	 * @param i インデックス
	 * @return Dequeのi番目に格納されている要素
	 * @apiNote ランダムアクセス
	 */
	public final long get(final int i){ return buf[index(i)]; }
	/**
	 * i番目に要素xを代入する
	 * @param i インデックス
	 * @param x 要素
	 */
	public final void set(final int i, final long x){ buf[index(i)] = x; }
	/**
	 * Dequeの末尾に要素を追加する
	 * @see #addLast
	 */
	public final void add(final long x){ addLast(x); }
	/**
	 * Dequeの先頭の要素を削除する
	 * @see #pollFirst
	 */
	public final long poll(){ return pollFirst(); }
	/**
	 * Dequeの先頭の要素を返す
	 * @see #peekFirst
	 */
	public final long peek(){ return peekFirst(); }
	/**
	 * Dequeのa番目とb番目にある要素を入れ替える
	 * @param a インデックス
	 * @param b インデックス
	 */
	public final void swap(final int a, final int b) {
		final int i = index(a);
		final int j = index(b);
		final long num = buf[i];
		buf[i] = buf[j];
		buf[j] = num;
	}
	/**
	 * Dequeを空にする
	 */
	public final void clear(){ head = tail = 0; }
	/**
	 * Dequeを配列に変換したものを返す
	 * @return 配列化したDeque
	 */
	public final long[] toArray() {
		final long[] array = new long[size()];
		arraycopy(0, array, 0, size());
		return array;
	}
	@Override
	public final String toString(){ return Arrays.toString(toArray()); }
}