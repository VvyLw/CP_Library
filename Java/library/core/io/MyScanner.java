package library.core.io;

import static java.lang.Math.*;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;

import library.core.Utility;
import library.ds.pair.FloatPair;
import library.ds.pair.IntPair;

/**
 * 入力クラス
 * Scannerより速い
 */
public final class MyScanner implements Closeable, AutoCloseable {
	private int pos, lim;
	private final byte[] buf;
	private final InputStream is;
	private boolean check;
	/**
	 * コンストラクタ
	 * @param is 標準入力(System.in)を入れる
	 */
	public MyScanner(final InputStream is) {
		this.is = is;
		pos = lim = 0;
		buf = new byte[1 << 17];
		check = false;
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
		if(check) {
			check = false;
			bt = buf[pos - 1];
			if(!isPunct(bt)) {
				return bt;
			}
		}
		while(isPunct(bt = read())){}
		return bt;
	}
	/**
	 * nextInt
	 * int型を入力する
	 */
	public final int ni(){ return toIntExact(nl()); }
	/**
	 * nextLong
	 * long型を入力する
	 */
	public final long nl() {
		byte c = next();
		final boolean neg = c == '-';
		if(neg) {
			c = next();
		}
		assert isNum(c);
		long res = c - '0';
		while(isNum(c = read())) {
			res = 10 * res + c - '0';
		}
		check = !isNum(c);
		return neg ? -res : res;
	}
	/**
	 * nextDouble
	 * double型を入力する
	 */
	public final double nd() {
		byte c = next();
		final boolean neg = c == '-';
		if(neg) {
			c = next();
		}
		assert isNum(c);
		double res = c - '0';
		while(isNum(c = read())) {
			res = 10 * res + c - '0';
		}
		if(c != '.') {
			check = true;
			return res;
		}
		int i;
		for(i = 0; isNum(c = read()); ++i) {
			res = res * 10 + c - '0';
		}
		res /= pow(10, i);
		check = true;
		return neg ? -res : res;
	}
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
	 * 受け取った文字列をtoCharArrayにして返す
	 */
	public final char[] nt(){ return ns().toCharArray(); }
	/**
	 * nextBigInteger
	 * 多倍長整数を入力する
	 */
	public final BigInteger nb(){ return new BigInteger(ns()); }
	/**
	 * IntPair型を入力する
	 * @see IntPair
	 */
	public final IntPair pi(){ return IntPair.of(nl(), nl()); }
	/**
	 * FloatPair型を入力する
	 * @see FloatPair
	 */
	public final FloatPair pf(){ return FloatPair.of(nd(), nd()); }
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