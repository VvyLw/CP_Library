package library.core.io;

import java.io.Closeable;
import java.math.BigInteger;
import java.util.Collection;

import library.ds.pair.FloatPair;
import library.ds.pair.IntPair;
import library.ds.pair.Pair;

/**
 * 入出力をまとめたクラス
 */
public final class IO implements Closeable, AutoCloseable {
	private final MyScanner in;
	private final MyPrinter out, err;
	/**
	 * コンストラクタ
	 * @param in 標準入力
	 * @param out 標準出力
	 * @param err 標準エラー出力
	 */
	public IO(final MyScanner in, final MyPrinter out, final MyPrinter err) {
		this.in = in;
		this.out = out;
		this.err = err;
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
	 * @param n
	 * @see MyScanner#ni
	 */
	public final int[] ni(final int n){ return in.ni(n); }
	/**
	 * @param n
	 * @see MyScanner#nl
	 */
	public final long[] nl(final int n){ return in.nl(n); }
	/**
	 * @param n
	 * @see MyScanner#nd
	 */
	public final double[] nd(final int n){ return in.nd(n); }
	/**
	 * @param n
	 * @see MyScanner#nc
	 */
	public final char[] nc(final int n){ return in.nc(n); }
	/**
	 * @param n
	 * @see MyScanner#ns
	 */
	public final String[] ns(final int n){ return in.ns(n); }
	/**
	 * @param n
	 * @see MyScanner#nt
	 */
	public final char[][] nt(final int n){ return in.nt(n); }
	/**
	 * @param n
	 * @see MyScanner#nb
	 */
	public final BigInteger[] nb(final int n){ return in.nb(n); }
	/**
	 * @param n
	 * @see MyScanner#pi
	 */
	public final IntPair[] pi(final int n){ return in.pi(n); }
	/**
	 * @param n
	 * @see MyScanner#pf
	 */
	public final FloatPair[] pf(final int n){ return in.pf(n); }
	/**
	 * @param h
	 * @param w
	 * @see MyScanner#ni
	 */
	public final int[][] ni(final int h, final int w){ return in.ni(h, w); }
	/**
	 * @param h
	 * @param w
	 * @see MyScanner#nl
	 */
	public final long[][] nl(final int h, final int w){ return in.nl(h, w); }
	/**
	 * @param h
	 * @param w
	 * @see MyScanner#nd
	 */
	public final double[][] nd(final int h, final int w){ return in.nd(h, w); }
	/**
	 * @param h
	 * @param w
	 * @see MyScanner#nc
	 */
	public final char[][] nc(final int h, final int w){ return in.nc(h, w); }
	/**
	 * @param h
	 * @param w
	 * @see MyScanner#ns
	 */
	public final String[][] ns(final int h, final int w){ return in.ns(h, w); }
	/**
	 * @param h
	 * @param w
	 * @see MyScanner#nb
	 */
	public final BigInteger[][] nb(final int h, final int w){ return in.nb(h, w); }
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
	 * @param a
	 * @see MyPrinter#out
	 */
	public final void out(final int[] a){ out.out(a); }
	/**
	 * @param a
	 * @see MyPrinter#out
	 */
	public final void out(final long[] a){ out.out(a); }
	/**
	 * @param a
	 * @see MyPrinter#out
	 */
	public final void out(final double[] a){ out.out(a); }
	/**
	 * @param a
	 * @see MyPrinter#out
	 */
	public final void out(final boolean[] a){ out.out(a); }
	/**
	 * @param a
	 * @see MyPrinter#out
	 */
	public final void out(final char[] a){ out.out(a); }
	/**
	 * @param a
	 * @see MyPrinter#out
	 */
	public final void out(final Object[] a){ out.out(a); }
	/**
	 * @param <E>
	 * @see MyPrinter#out
	 */
	public final <E> void out(final Collection<E> a){ out.out(a); }
	/**
	 * @param head
	 * @param tail
	 * @see MyPrinter#outl
	 */
	public final void outl(final Object head, final Object... tail){ out.outl(head, tail); }
	/**
	 * @param a
	 * @see MyPrinter#outl
	 */
	public final void outl(final int[] a){ out.outl(a); }
	/**
	 * @param a
	 * @see MyPrinter#outl
	 */
	public final void outl(final int[][] a){ out.outl(a); }
	/**
	 * @param a
	 * @see MyPrinter#outl
	 */
	public final void outl(final long[] a){ out.outl(a); }
	/**
	 * @param a
	 * @see MyPrinter#outl
	 */
	public final void outl(final long[][] a){ out.outl(a); }
	/**
	 * @param a
	 * @see MyPrinter#outl
	 */
	public final void outl(final double[] a){ out.outl(a); }
	/**
	 * @param a
	 * @see MyPrinter#outl
	 */
	public final void outl(final double[][] a){ out.outl(a); }
	/**
	 * @param a
	 * @see MyPrinter#outl
	 */
	public final void outl(final boolean[] a){ out.outl(a); }
	/**
	 * @param a
	 * @see MyPrinter#outl
	 */
	public final void outl(final boolean[][] a){ out.outl(a); }
	/**
	 * @param a
	 * @see MyPrinter#outl
	 */
	public final void outl(final char[] a){ out.outl(a); }
	/**
	 * @param a
	 * @see MyPrinter#outl
	 */
	public final void outl(final char[][] a){ out.outl(a); }
	/**
	 * @param a
	 * @see MyPrinter#outl
	 */
	public final void outl(final Object[] a){ out.outl(a); }
	/**
	 * @param a
	 * @see MyPrinter#outl
	 */
	public final void outl(final Object[][] a){ out.outl(a); }
	/**
	 * @param <F>
	 * @param <S>
	 * @param a
	 * @see MyPrinter#outl
	 */
	public final <F extends Comparable<? super F>, S extends Comparable<? super S>> void outl(final Pair<F, S>[] a){ out.outl(a); }
	/**
	 * @param <E>
	 * @param a
	 * @see MyPrinter#outl
	 */
	public final <E> void outl(final Collection<E> a){ out.outl(a); }
	/**
	 * @param head
	 * @param tail
	 * @see MyPrinter#fin
	 */
	public final void fin(final Object head, final Object... tail){ out.fin(head, tail); }
	/**
	 * @param <F>
	 * @param <S>
	 * @param p
	 * @see MyPrinter#fin
	 */
	public final <F extends Comparable<? super F>, S extends Comparable<? super S>> void fin(final Pair<F, S> p){ out.fin(p); }
	/**
	 * @param a
	 * @see MyPrinter#fin
	 */
	public final void fin(final int[] a){ out.fin(a); }
	/**
	 * @param a
	 * @see MyPrinter#fin
	 */
	public final void fin(final long[] a){ out.fin(a); }
	/**
	 * @param a
	 * @see MyPrinter#fin
	 */
	public final void fin(final double[] a){ out.fin(a); }
	/**
	 * @param a
	 * @see MyPrinter#fin
	 */
	public final void fin(final boolean[] a){ out.fin(a); }
	/**
	 * @param a
	 * @see MyPrinter#fin
	 */
	public final void fin(final char[] a){ out.fin(a); }
	/**
	 * @param a
	 * @see MyPrinter#fin
	 */
	public final void fin(final Object[] a){ out.fin(a); }
	/**
	 * @param a
	 * @see MyPrinter#fin
	 */
	public final <E> void fin(final Collection<E> a){ out.fin(a); }
	/**
	 * @param head
	 * @param tail
	 * @see MyPrinter#ende
	 */
	public final void ende(final Object head, final Object... tail){ out.ende(head, tail); }
	/**
	 * @param a
	 * @see MyPrinter#ende
	 */
	public final void ende(final int[] a){ out.ende(a); }
	/**
	 * @param a
	 * @see MyPrinter#ende
	 */
	public final void ende(final int[][] a){ out.ende(a); }
	/**
	 * @param a
	 * @see MyPrinter#ende
	 */
	public final void ende(final long[] a){ out.ende(a); }
	/**
	 * @param a
	 * @see MyPrinter#ende
	 */
	public final void ende(final long[][] a){ out.ende(a); }
	/**
	 * @param a
	 * @see MyPrinter#ende
	 */
	public final void ende(final double[] a){ out.ende(a); }
	/**
	 * @param a
	 * @see MyPrinter#ende
	 */
	public final void ende(final double[][] a){ out.ende(a); }
	/**
	 * @param a
	 * @see MyPrinter#ende
	 */
	public final void ende(final boolean[] a){ out.ende(a); }
	/**
	 * @param a
	 * @see MyPrinter#ende
	 */
	public final void ende(final boolean[][] a){ out.ende(a); }
	/**
	 * @param a
	 * @see MyPrinter#ende
	 */
	public final void ende(final char[] a){ out.ende(a); }
	/**
	 * @param a
	 * @see MyPrinter#ende
	 */
	public final void ende(final char[][] a){ out.ende(a); }
	/**
	 * @param a
	 * @see MyPrinter#ende
	 */
	public final void ende(final Object[] a){ out.ende(a); }
	/**
	 * @param a
	 * @see MyPrinter#ende
	 */
	public final void ende(final Object[][] a){ out.ende(a); }
	/**
	 * @param <F>
	 * @param <S>
	 * @param a
	 * @see MyPrinter#ende
	 */
	public final <F extends Comparable<? super F>, S extends Comparable<? super S>> void ende(final Pair<F, S>[] a){ out.ende(a); }
	/**
	 * @param <E>
	 * @param a
	 * @see MyPrinter#ende
	 */
	public final <E> void ende(final Collection<E> a){ out.ende(a); }
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
	 * @see MyPrinter#out
	 */
	public final void dump(final int[] a){ err.out(a); }
	/**
	 * デバッグ用
	 * @param a
	 * @see MyPrinter#out
	 */
	public final void dump(final long[] a){ err.out(a); }
	/**
	 * デバッグ用
	 * @param a
	 * @see MyPrinter#out
	 */
	public final void dump(final double[] a){ err.out(a); }
	/**
	 * デバッグ用
	 * @param a
	 * @see MyPrinter#out
	 */
	public final void dump(final boolean[] a){ err.out(a); }
	/**
	 * デバッグ用
	 * @param a
	 * @see MyPrinter#out
	 */
	public final void dump(final char[] a){ err.out(a); }
	/**
	 * デバッグ用
	 * @param a
	 * @see MyPrinter#out
	 */
	public final void dump(final Object[] a){ err.out(a); }
	/**
	 * デバッグ用
	 * @param head
	 * @param tail
	 * @see MyPrinter#outl
	 */
	public final void debug(final Object head, final Object... tail){ err.outl(head, tail); }
	/**
	 * デバッグ用
	 * @param a
	 * @see MyPrinter#outl
	 */
	public final void debug(final int[] a){ err.outl(a); }
	/**
	 * デバッグ用
	 * @param a
	 * @see MyPrinter#outl
	 */
	public final void debug(final int[][] a){ err.outl(a); }
	/**
	 * デバッグ用
	 * @param a
	 * @see MyPrinter#outl
	 */
	public final void debug(final long[] a){ err.outl(a); }
	/**
	 * デバッグ用
	 * @param a
	 * @see MyPrinter#outl
	 */
	public final void debug(final long[][] a){ err.outl(a); }
	/**
	 * デバッグ用
	 * @param a
	 * @see MyPrinter#outl
	 */
	public final void debug(final double[] a){ err.outl(a); }
	/**
	 * デバッグ用
	 * @param a
	 * @see MyPrinter#outl
	 */
	public final void debug(final double[][] a){ err.outl(a); }
	/**
	 * デバッグ用
	 * @param a
	 * @see MyPrinter#outl
	 */
	public final void debug(final boolean[] a){ err.outl(a); }
	/**
	 * デバッグ用
	 * @param a
	 * @see MyPrinter#outl
	 */
	public final void debug(final boolean[][] a){ err.outl(a); }
	/**
	 * デバッグ用
	 * @param a
	 * @see MyPrinter#outl
	 */
	public final void debug(final char[] a){ err.outl(a); }
	/**
	 * デバッグ用
	 * @param a
	 * @see MyPrinter#outl
	 */
	public final void debug(final char[][] a){ err.outl(a); }
	/**
	 * デバッグ用
	 * @param a
	 * @see MyPrinter#outl
	 */
	public final void debug(final Object[] a){ err.outl(a); }
	/**
	 * デバッグ用
	 * @param a
	 * @see MyPrinter#outl
	 */
	public final void debug(final Object[][] a){ err.outl(a); }
	/**
	 * デバッグ用
	 * @param <F>
	 * @param <S>
	 * @param a
	 * @see MyPrinter#outl
	 */
	public final <F extends Comparable<? super F>, S extends Comparable<? super S>> void debug(final Pair<F, S>[] a){ err.outl(a); }
	@Override
	public final void close() {
		out.flush();
		in.close();
		out.close();
		err.close();
	}
}