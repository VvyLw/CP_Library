package library.core.io;

import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.function.IntUnaryOperator;
import java.util.function.LongUnaryOperator;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;

import library.ds.pair.FloatPair;
import library.ds.pair.IntPair;

/**
 * 入出力をまとめたクラス
 */
public final class IO implements AutoCloseable {
	private final MyScanner in;
	private final MyPrinter out, err;
	/**
	 * コンストラクタ
	 * @param in 標準入力
	 * @param out 標準出力
	 * @param err 標準エラー出力
	 * @param autoFlush flushの自動化
	 */
	public IO(final InputStream in, final OutputStream out, final OutputStream err, final boolean autoFlush) {
		this.in = new MyScanner(in);
		this.out = new MyPrinter(out, autoFlush);
		this.err = new MyPrinter(err, true);
	}
	/**
	 * @see MyScanner#ni
	 */
	public final int ni(){ return in.ni(); }
	/**
	 * @see MyScanner#nl
	 */
	public final long nl(){ return in.nl(); }
	/**
	 * @see MyScanner#nd
	 */
	public final double nd(){ return in.nd(); }
	/**
	 * @see MyScanner#nc
	 */
	public final char nc(){ return in.nc(); }
	/**
	 * @see MyScanner#ns
	 */
	public final String ns(){ return in.ns(); }
	/**
	 * @see MyScanner#nt
	 */
	public final char[] nt(){ return in.nt(); }
	/**
	 * @see MyScanner#nb
	 */
	public final BigInteger nb(){ return in.nb(); }
	/**
	 * @see MyScanner#pi
	 */
	public final IntPair pi(){ return in.pi(); }
	/**
	 * @see MyScanner#pf
	 */
	public final FloatPair pf(){ return in.pf(); }
	/**
	 * 大きさnのint型配列を入力する
	 * @param n 配列の大きさ
	 */
	public final int[] ni(final int n) {
		final int[] a = new int[n];
		Arrays.setAll(a, i -> ni());
		return a;
	}
	/**
	 * @param n
	 * @param f
	 * @return int型配列にfを施したもの
	 */
	public final int[] ni(final int n, final IntUnaryOperator f){ return Arrays.stream(ni(n)).map(f).toArray(); }
	/**
	 * 大きさnのlong型配列を入力する
	 * @param n 配列の大きさ
	 */
	public final long[] nl(final int n) {
		final long[] a = new long[n];
		Arrays.setAll(a, i -> nl());
		return a;
	}
	/**
	 * @param n
	 * @param f
	 * @return long型配列にfを施したもの
	 */
	public final long[] nl(final int n, final LongUnaryOperator f){ return Arrays.stream(nl(n)).map(f).toArray(); }
	/**
	 * 大きさnのdouble型配列を入力する
	 * @param n 配列の大きさ
	 */
	public final double[] nd(final int n) {
		final double[] a = new double[n];
		Arrays.setAll(a, i -> nd());
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
		Arrays.setAll(a, i -> ns());
		return a;
	}
	/**
	 * n個の文字列をtoCharArrayして返す
	 * @param n 配列の大きさ
	 */
	public final char[][] nt(final int n) {
		final char[][] a = new char[n][];
		Arrays.setAll(a, i -> nt());
		return a;
	}
	/**
	 * [maybe_unused]
	 * 大きさnの多倍長整数配列を入力する
	 * @param n 配列の大きさ
	 */
	public final BigInteger[] nb(final int n) {
		final BigInteger[] a = new BigInteger[n];
		Arrays.setAll(a, i -> nb());
		return a;
	}
	/**
	 * IntPair型の配列を入力する
	 * @param n
	 * @see IntPair
	 */
	public final IntPair[] pi(final int n) {
		final IntPair[] a = new IntPair[n];
		Arrays.setAll(a, i -> pi());
		return a;
	}
	/**
	 * @param n
	 * @param f
	 * @return IntPair配列にfを施したもの
	 */
	public final IntPair[] pi(final int n, final UnaryOperator<IntPair> f){ return Arrays.stream(pi(n)).map(f).toArray(IntPair[]::new); }
	/**
	 * FloatPair型の配列を入力する
	 * @param n
	 * @see FloatPair
	 */
	public final FloatPair[] pf(final int n) {
		final FloatPair[] a = new FloatPair[n];
		Arrays.setAll(a, i -> pf());
		return a;
	}
	/**
	 * h×wのint型の二次元配列を入力する
	 * @param h
	 * @param w
	 */
	public final int[][] ni(final int h, final int w) {
		final int[][] a = new int[h][w];
		Arrays.setAll(a, i -> ni(w));
		return a;
	}
	/**
	 * h×wのlong型の二次元配列を入力する
	 * @param h
	 * @param w
	 */
	public final long[][] nl(final int h, final int w) {
		final long[][] a = new long[h][w];
		Arrays.setAll(a, i -> nl(w));
		return a;
	}
	/**
	 * h×wのdouble型の二次元配列を入力する
	 * @param h
	 * @param w
	 */
	public final double[][] nd(final int h, final int w) {
		final double[][] a = new double[h][w];
		Arrays.setAll(a, i -> nd(w));
		return a;
	}
	/**
	 * h×wのchar型の二次元配列を入力する
	 * @param h
	 * @param w
	 */
	public final char[][] nc(final int h, final int w) {
		final char[][] a = new char[h][w];
		Arrays.setAll(a, i -> nc(w));
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
		Arrays.setAll(a, i -> ns(w));
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
		Arrays.setAll(a, i -> nb(w));
		return a;
	}
	/**
	 * @see MyScanner#line
	 */
	public final String line(){ return in.line(); }
	/**
	 * @param arg
	 * @see MyPrinter#print
	 */
	public final void print(final Object arg){ out.print(arg); }
	/**
	 * @param fmt
	 * @param args
	 * @see MyPrinter#printf
	 */
	public final void printf(final String fmt, final Object... args){ out.printf(fmt, args); }
	/**
	 * @see MyPrinter#out
	 */
	public final void out(){ out.out(); }
	/**
	 * @param head
	 * @param tail
	 * @see MyPrinter#out
	 */
	public final void out(final Object head, final Object... tail){ out.out(head, tail); }
	/**
	 * int型二次元配列を出力する
	 * @param args
	 */
	public final void out(final int[][] args){ IntStream.range(0, args.length).forEach(i -> out(args[i])); }
	/**
	 * long型二次元配列を出力する
	 * @param args
	 */
	public final void out(final long[][] args){ IntStream.range(0, args.length).forEach(i -> out(args[i])); }
	/**
	 * double型二次元配列を出力する
	 * @param args
	 */
	public final void out(final double[][] args){ IntStream.range(0, args.length).forEach(i -> out(args[i])); }
	/**
	 * boolean型二次元配列を出力する
	 * @param args
	 */
	public final void out(final boolean[][] args){ IntStream.range(0, args.length).forEach(i -> out(args[i])); }
	/**
	 * char型二次元配列を出力する
	 * @param args
	 */
	public final void out(final char[][] args){ IntStream.range(0, args.length).forEach(i -> out(args[i])); }
	/**
	 * Objectクラスの二次元配列を出力する
	 * @param args
	 */
	public final void out(final Object[][] args){ Arrays.stream(args).forEach(this::out); }
	/**
	 * outl(a, b, c)で, "a\nb\nc\n"の形式で出力される
	 * @param head
	 * @param tail
	 */
	public final void outl(final Object head, final Object... tail){ out.outl(head, tail); }
	/**
	 * デバッグ用
	 * @param head
	 * @param tail
	 * @see MyPrinter#out
	 */
	public final void dump(final Object head, final Object... tail){ err.out(head, tail); }
	/**
	 * デバッグ用
	 * @param a
	 */
	public final void dump(final int[][] args){ IntStream.range(0, args.length).forEach(i -> dump(args[i])); }
	/**
	 * デバッグ用
	 * @param a
	 */
	public final void dump(final long[][] args){ IntStream.range(0, args.length).forEach(i -> dump(args[i])); }
	/**
	 * デバッグ用
	 * @param a
	 */
	public final void dump(final double[][] args){ IntStream.range(0, args.length).forEach(i -> dump(args[i])); }
	/**
	 * デバッグ用
	 * @param a
	 */
	public final void dump(final boolean[][] args){ IntStream.range(0, args.length).forEach(i -> dump(args[i])); }
	/**
	 * デバッグ用
	 * @param a
	 */
	public final void dump(final char[][] args){ IntStream.range(0, args.length).forEach(i -> dump(args[i])); }
	/**
	 * デバッグ用
	 * @param a
	 */
	public final void dump(final Object[][] args){ IntStream.range(0, args.length).forEach(i -> dump(args[i])); }
	/**
	 * デバッグ用
	 * @param head
	 * @param tail
	 * @see MyPrinter#outl
	 */
	public final void dumpl(final Object head, final Object... tail){ err.outl(head, tail); }
	@Override
	public final void close() {
		out.flush();
		in.close();
		out.close();
		err.close();
	}
}