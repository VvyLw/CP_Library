package library.core;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.stream.IntStream;

public final class MyScanner implements Closeable, AutoCloseable {
	private int pos, lim;
	private final byte[] buf;
	private final InputStream is;
	MyScanner(final InputStream is) {
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
			} catch(IOException e) {
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
	public final int ni(){ return Math.toIntExact(nl()); }
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
	public final double nd(){ return Double.parseDouble(ns()); }
	public final char nc(){ return (char) next(); }
	public final String ns() {
		final StringBuilder sb = new StringBuilder();
		byte c = next();
		while(!isPunct(c)) {
			sb.append((char) c);
			c = read();
		}
		return sb.toString();
	}
	public final BigInteger nb(){ return new BigInteger(ns()); }
	public final int[] ni(final int n) {
		final int[] a = new int[n];
		IntStream.range(0, n).forEach(i -> a[i] = ni());
		return a;
	}
	public final long[] nl(final int n) {
		final long[] a = new long[n];
		IntStream.range(0, n).forEach(i -> a[i] = nl());
		return a;
	}
	public final double[] nd(final int n) {
		final double[] a = new double[n];
		IntStream.range(0, n).forEach(i -> a[i] = nd());
		return a;
	}
	public final char[] nc(final int n) {
		final char[] a = new char[n];
		IntStream.range(0, n).forEach(i -> a[i] = nc());
		return a;
	}
	public final String[] ns(final int n) {
		final String[] a = new String[n];
		IntStream.range(0, n).forEach(i -> a[i] = ns());
		return a;
	}
	public final BigInteger[] nb(final int n) {
		final BigInteger[] a = new BigInteger[n];
		IntStream.range(0, n).forEach(i -> a[i] = nb());
		return a;
	}
	public final int[][] ni(final int h, final int w) {
		final int[][] a = new int[h][w];
		IntStream.range(0, h).forEach(i -> a[i] = ni(w));
		return a;
	}
	public final long[][] nl(final int h, final int w) {
		final long[][] a = new long[h][w];
		IntStream.range(0, h).forEach(i -> a[i] = nl(w));
		return a;
	}
	public final double[][] nd(final int h, final int w) {
		final double[][] a = new double[h][w];
		IntStream.range(0, h).forEach(i -> a[i] = nd(w));
		return a;
	}
	public final char[][] nc(final int h, final int w) {
		final char[][] a = new char[h][w];
		IntStream.range(0, h).forEach(i -> a[i] = nc(w));
		return a;
	}
	public final String[][] ns(final int h, final int w) {
		final String[][] a = new String[h][w];
		IntStream.range(0, h).forEach(i -> a[i] = ns(w));
		return a;
	}
	public final BigInteger[][] nb(final int h, final int w) {
		final BigInteger[][] a = new BigInteger[h][w];
		IntStream.range(0, h).forEach(i -> a[i] = nb(w));
		return a;
	}
	public final String line() {
		final StringBuilder sb = new StringBuilder();
		byte c;
		while((c = read()) != '\n') {
			sb.append(c);
		}
		return sb.toString();
	}
	@Override
	public final void close() {
		try {
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}