package library.core.io;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.stream.IntStream;

import library.core.Utility;
import library.structure.pair.FloatPair;
import library.structure.pair.IntPair;

/**
 * 入力クラス
 * Scannerより速い
 */
public final class MyScanner implements Closeable, AutoCloseable {
	private int pos, lim;
	private final byte[] buf;
	private final InputStream is;
	/**
	 * コンストラクタ
	 * @param is 標準入力(System.in)を入れる
	 */
	public MyScanner(final InputStream is) {
		this.is = is;
		pos = lim = 0;
		buf = new byte[1 << 17];
	}
	private final boolean isPunct(final byte bt){ return !Utility.scope(33, bt, 126); }
	private final boolean isNum(final byte bt){ return Utility.scope('0', bt, '9'); }
	private final byte read() {
		if(pos == lim && lim != -1) {
			try {
				lim = is.read(buf);
				pos = 0;
			} catch(final IOException e) {
				e.printStackTrace();
			}
		}
		return buf[pos++];
	}
	private final byte next() {
		byte bt;
		while(isPunct(bt = read())){}
		return bt;
	}
	/**
	 * nextInt
	 * int型を入力する
	 */
	public final int ni(){ return Math.toIntExact(nl()); }
	/**
	 * nextLong
	 * long型を入力する
	 */
	public final long nl() {
		byte c = next();
		final boolean neg = c == '-';
		if(neg) {
			c = read();
		}
		assert(isNum(c));
		long res = c - '0';
		while(isNum(c = read())) {
			res = 10 * res + c - '0';
		}
		return neg ? -res : res;
	}
	/**
	 * nextDouble
	 * double型を入力する
	 */
	public final double nd(){ return Double.parseDouble(ns()); }
	/**
	 * nextChar(Scannerにはない)
	 * char型を入力する
	 */
	public final char nc(){ return (char) next(); }
	/**
	 * nextString(Scannerで云うnext)
	 * 文字列を入力する
	 */
	public final String ns() {
		final StringBuilder sb = new StringBuilder();
		byte c = next();
		while(!isPunct(c)) {
			sb.append((char) c);
			c = read();
		}
		return sb.toString();
	}
	/**
	 * nextBigInteger
	 * 多倍長整数を入力する
	 */
	public final BigInteger nb(){ return new BigInteger(ns()); }
	/**
	 * 大きさnのint型配列を入力する
	 * @param n 配列の大きさ
	 */
	public final int[] ni(final int n) {
		final int[] a = new int[n];
		IntStream.range(0, n).forEach(i -> a[i] = ni());
		return a;
	}
	/**
	 * 大きさnのlong型配列を入力する
	 * @param n 配列の大きさ
	 */
	public final long[] nl(final int n) {
		final long[] a = new long[n];
		IntStream.range(0, n).forEach(i -> a[i] = nl());
		return a;
	}
	/**
	 * 大きさnのdouble型配列を入力する
	 * @param n 配列の大きさ
	 */
	public final double[] nd(final int n) {
		final double[] a = new double[n];
		IntStream.range(0, n).forEach(i -> a[i] = nd());
		return a;
	}
	/**
	 * [maybe_unused]
	 * 大きさnのchar型配列を入力する
	 * @param n 配列の大きさ
	 */
	public final char[] nc(final int n) {
		final char[] a = new char[n];
		IntStream.range(0, n).forEach(i -> a[i] = nc());
		return a;
	}
	/**
	 * 大きさnの文字列配列を入力する
	 * @param n 配列の大きさ
	 */
	public final String[] ns(final int n) {
		final String[] a = new String[n];
		IntStream.range(0, n).forEach(i -> a[i] = ns());
		return a;
	}
	/**
	 * [maybe_unused]
	 * 大きさnの多倍長整数配列を入力する
	 * @param n 配列の大きさ
	 */
	public final BigInteger[] nb(final int n) {
		final BigInteger[] a = new BigInteger[n];
		IntStream.range(0, n).forEach(i -> a[i] = nb());
		return a;
	}
	/**
	 * h×wのint型の二次元配列を入力する
	 * @param h
	 * @param w
	 */
	public final int[][] ni(final int h, final int w) {
		final int[][] a = new int[h][w];
		IntStream.range(0, h).forEach(i -> a[i] = ni(w));
		return a;
	}
	/**
	 * h×wのlong型の二次元配列を入力する
	 * @param h
	 * @param w
	 */
	public final long[][] nl(final int h, final int w) {
		final long[][] a = new long[h][w];
		IntStream.range(0, h).forEach(i -> a[i] = nl(w));
		return a;
	}
	/**
	 * h×wのdouble型の二次元配列を入力する
	 * @param h
	 * @param w
	 */
	public final double[][] nd(final int h, final int w) {
		final double[][] a = new double[h][w];
		IntStream.range(0, h).forEach(i -> a[i] = nd(w));
		return a;
	}
	/**
	 * h×wのchar型の二次元配列を入力する
	 * @param h
	 * @param w
	 */
	public final char[][] nc(final int h, final int w) {
		final char[][] a = new char[h][w];
		IntStream.range(0, h).forEach(i -> a[i] = nc(w));
		return a;
	}
	/**
	 * [maybe_unused]
	 * h×wの文字列の二次元配列を入力する
	 * @param h
	 * @param w
	 */
	public final String[][] ns(final int h, final int w) {
		final String[][] a = new String[h][w];
		IntStream.range(0, h).forEach(i -> a[i] = ns(w));
		return a;
	}
	/**
	 * [maybe_unused]
	 * h×wの多倍長整数の二次元配列を入力する
	 * @param h
	 * @param w
	 */
	public final BigInteger[][] nb(final int h, final int w) {
		final BigInteger[][] a = new BigInteger[h][w];
		IntStream.range(0, h).forEach(i -> a[i] = nb(w));
		return a;
	}
	/**
	 * [maybe_unused]
	 * 一行全部を入力する
	 */
	public final String line() {
		final StringBuilder sb = new StringBuilder();
		byte c;
		while((c = read()) != '\n') {
			sb.append((char) c);
		}
		return sb.toString();
	}
	/**
	 * IntPair型を入力する
	 * @see IntPair
	 */
	public final IntPair pi(){ return IntPair.of(nl(), nl()); }
	/**
	 * IntPair型の配列を入力する
	 * @param n
	 * @see IntPair
	 */
	public final IntPair[] pi(final int n) {
		final IntPair[] p = new IntPair[n];
		IntStream.range(0, n).forEach(i -> p[i] = pi());
		return p;
	}
	/**
	 * FloatPair型を入力する
	 * @see FloatPair
	 */
	public final FloatPair pf(){ return FloatPair.of(nd(), nd()); }
	/**
	 * FloatPair型の配列を入力する
	 * @param n
	 * @see FloatPair
	 */
	public final FloatPair[] pf(final int n) {
		final FloatPair[] p = new FloatPair[n];
		IntStream.range(0, n).forEach(i -> p[i] = pf());
		return p;
	}
	/**
	 * InputStreamを閉じる
	 */
	@Override
	public final void close() {
		try {
			is.close();
		} catch(final IOException e) {
			e.printStackTrace();
		}
	}
}