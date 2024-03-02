package library.core.io;

import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collection;
import java.util.function.DoubleUnaryOperator;
import java.util.function.IntUnaryOperator;
import java.util.function.LongUnaryOperator;
import java.util.stream.IntStream;

import library.ds.pair.FloatPair;
import library.ds.pair.IntPair;
import library.ds.pair.Pair;

/**
 * 入出力をまとめたクラス
 */
public final class IO implements Closeable, AutoCloseable {
	private final MyScanner in;
	private final MyPrinter out, err;
	private final boolean autoFlush;
	/**
	 * コンストラクタ
	 * @param in 標準入力
	 * @param out 標準出力
	 * @param err 標準エラー出力
	 * @param autoFlush flushの自動化
	 */
	public IO(final InputStream in, final OutputStream out, final OutputStream err, final boolean autoFlush) {
		this.in = new MyScanner(in);
		this.out = new MyPrinter(out, this.autoFlush = autoFlush);
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
		IntStream.range(0, n).forEach(i -> a[i] = ni());
		return a;
	}
	/**
	 * @param n
	 * @param f
	 * @return 大きさnのint型配列を入力し、fを施したものを返す
	 */
	public final int[] ni(final int n, final IntUnaryOperator f){ return Arrays.stream(ni(n)).map(f).toArray(); }
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
	 * @param n
	 * @param f
	 * @return 大きさnのlong型配列を入力し、fを施したものを返す
	 */
	public final long[] nl(final int n, final LongUnaryOperator f){ return Arrays.stream(nl(n)).map(f).toArray(); }
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
	 * @param n
	 * @param f
	 * @return 大きさnのdouble型配列を入力し、fを施したものを返す
	 */
	public final double[] nl(final int n, final DoubleUnaryOperator f){ return Arrays.stream(nd(n)).map(f).toArray(); }
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
	 * n個の文字列をtoCharArrayして返す
	 * @param n 配列の大きさ
	 */
	public final char[][] nt(final int n) {
		final char[][] a = new char[n][];
		IntStream.range(0, n).forEach(i -> a[i] = nt());
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
	 * @param <F>
	 * @param <S>
	 * @param p
	 * @see MyPrinter#out
	 */
	public final <F extends Comparable<? super F>, S extends Comparable<? super S>> void out(final Pair<F, S> p){ out.out(p); }
	/**
	 * @param <E>
	 * @see MyPrinter#out
	 */
	public final <E> void out(final Collection<E> a){ out.out(a); }
	/**
	 * @param head
	 * @param tail
	 * @see MyPrinter#out
	 */
	public final void out(final int[] head, final int[]...tail){ out.out(head, tail); }
	/**
	 * @param head
	 * @param tail
	 * @see MyPrinter#out
	 */
	public final void out(final long[] head, final long[]...tail){ out.out(head, tail); }
	/**
	 * @param head
	 * @param tail
	 * @see MyPrinter#out
	 */
	public final void out(final double[] head, final double[]...tail){ out.out(head, tail); }
	/**
	 * @param head
	 * @param tail
	 * @see MyPrinter#out
	 */
	public final void out(final boolean[] head, final boolean[]...tail){ out.out(head, tail); }
	/**
	 * @param head
	 * @param tail
	 * @see MyPrinter#out
	 */
	public final void out(final char[] head, final char[]...tail){ out.out(head, tail); }
	/**
	 * @param head
	 * @param tail
	 * @see MyPrinter#out
	 */
	public final void out(final Object[] head, final Object[]...tail){ out.out(head, tail); }
	/**
	 * Pairクラスの配列を出力する
	 * @param <F>
	 * @param <S>
	 * @param args 
	 */
	public final <F extends Comparable<? super F>, S extends Comparable<? super S>> void out(final Pair<F, S>[] args){ Arrays.stream(args).forEach(this::out); }
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
	public final void outl(final Object head, final Object... tail) {
		out(head);
		Arrays.stream(tail).forEach(this::out);
	}
	/**
	 * この出力を最後に処理を終了する
	 * @param head
	 * @param tail
	 * @see #out
	 */
	public final void fin(final Object head, final Object... tail) {
		out(head, tail);
		if(!autoFlush) {
			out.flush();
		}
		System.exit(0);
	}
	/**
	 * この出力を最後に処理を終了する
	 * @param <F> firstの型
	 * @param <S> secondの型
	 * @param arg
	 * @see #out
	 */
	public final <F extends Comparable<? super F>, S extends Comparable<? super S>> void fin(final Pair<F, S> arg) {
		out(arg);
		if(!autoFlush) {
			out.flush();
		}
		System.exit(0);
	}
	/**
	 * この出力を最後に処理を終了する
	 * @param <E>
	 * @param args
	 * @see #out
	 */
	public final <E> void fin(final Collection<E> args) {
		out(args);
		if(!autoFlush) {
			out.flush();
		}
		System.exit(0);
	}
	/**
	 * この出力を最後に処理を終了する
	 * @param args
	 * @see #out
	 */
	public final void fin(final int[] args) {
		out(args);
		if(!autoFlush) {
			out.flush();
		}
		System.exit(0);
	}
	/**
	 * この出力を最後に処理を終了する
	 * @param args
	 * @see #out
	 */
	public final void fin(final long[] args) {
		out(args);
		if(!autoFlush) {
			out.flush();
		}
		System.exit(0);
	}
	/**
	 * この出力を最後に処理を終了する
	 * @param args
	 * @see #out
	 */
	public final void fin(final double[] args) {
		out(args);
		if(!autoFlush) {
			out.flush();
		}
		System.exit(0);
	}
	/**
	 * この出力を最後に処理を終了する
	 * @param args
	 * @see #out
	 */
	public final void fin(final boolean[] args) {
		out(args);
		if(!autoFlush) {
			out.flush();
		}
		System.exit(0);
	}
	/**
	 * この出力を最後に処理を終了する
	 * @param args
	 * @see #out
	 */
	public final void fin(final char[] args) {
		out(args);
		if(!autoFlush) {
			out.flush();
		}
		System.exit(0);
	}
	/**
	 * この出力を最後に処理を終了する
	 * @param args
	 * @see #out
	 */
	public final void fin(final Object[] args) {
		out(args);
		if(!autoFlush) {
			out.flush();
		}
		System.exit(0);
	}
	/**
	 * この出力を最後に処理を終了する
	 * @param <F>
	 * @param <S>
	 * @param args
	 * @see #out
	 */
	public final <F extends Comparable<? super F>, S extends Comparable<? super S>> void fin(final Pair<F, S>[] args) {
		out(args);
		if(!autoFlush) {
			out.flush();
		}
		System.exit(0);
	}
	/**
	 * この出力を最後に処理を終了する
	 * @param args
	 * @see #out
	 */
	public final void fin(final int[][] args) {
		out(args);
		if(!autoFlush) {
			out.flush();
		}
		System.exit(0);
	}
	/**
	 * この出力を最後に処理を終了する
	 * @param args
	 * @see #out
	 */
	public final void fin(final long[][] args) {
		out(args);
		if(!autoFlush) {
			out.flush();
		}
		System.exit(0);
	}
	/**
	 * この出力を最後に処理を終了する
	 * @param args
	 * @see #out
	 */
	public final void fin(final double[][] args) {
		out(args);
		if(!autoFlush) {
			out.flush();
		}
		System.exit(0);
	}
	/**
	 * この出力を最後に処理を終了する
	 * @param args
	 * @see #out
	 */
	public final void fin(final boolean[][] args) {
		out(args);
		if(!autoFlush) {
			out.flush();
		}
		System.exit(0);
	}
	/**
	 * この出力を最後に処理を終了する
	 * @param args
	 * @see #out
	 */
	public final void fin(final char[][] args) {
		out(args);
		if(!autoFlush) {
			out.flush();
		}
		System.exit(0);
	}
	/**
	 * この出力を最後に処理を終了する
	 * @param args
	 * @see #out
	 */
	public final void fin(final Object[][] args) {
		out(args);
		if(!autoFlush) {
			out.flush();
		}
		System.exit(0);
	}
	/**
	 * この出力を最後に処理を終了する
	 * @param head
	 * @param tail
	 * @see #outl
	 */
	public final void ende(final Object head, final Object... tail ) {
		outl(head, tail);
		if(!autoFlush) {
			out.flush();
		}
		System.exit(0);
	}
	/**
	 * デバッグ用
	 * @param head
	 * @param tail
	 * @see MyPrinter#out
	 */
	public final void dump(final Object head, final Object... tail){ err.out(head, tail); }
	/**
	 * デバッグ用
	 * @param head
	 * @param tail
	 * @see MyPrinter#out
	 */
	public final void dump(final int[] head, final int[]...tail){ err.out(head, tail); }
	/**
	 * デバッグ用
	 * @param head
	 * @param tail
	 * @see MyPrinter#out
	 */
	public final void dump(final long[] head, final long[]...tail){ err.out(head, tail); }
	/**
	 * デバッグ用
	 * @param head
	 * @param tail
	 * @see MyPrinter#out
	 */
	public final void dump(final double[] head, final double[]...tail){ err.out(head, tail); }
	/**
	 * デバッグ用
	 * @param head
	 * @param tail
	 * @see MyPrinter#out
	 */
	public final void dump(final boolean[] head, final boolean[]...tail){ err.out(head, tail); }
	/**
	 * デバッグ用
	 * @param head
	 * @param tail
	 * @see MyPrinter#out
	 */
	public final void dump(final char[] head, final char[]...tail){ err.out(head, tail); }
	/**
	 * デバッグ用
	 * @param head
	 * @param tail
	 * @see MyPrinter#out
	 */
	public final void dump(final Object[] head, final Object[]...tail){ err.out(head, tail); }
	/**
	 * デバッグ用
	 * @param <F>
	 * @param <S>
	 * @param a
	 */
	public final <F extends Comparable<? super F>, S extends Comparable<? super S>> void dump(final Pair<F, S>[] args){ Arrays.stream(args).forEach(this::dump); }
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
	@Override
	public final void close() {
		out.flush();
		in.close();
		out.close();
		err.close();
	}
}