package library.core;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collection;
import java.util.Formatter;
import java.util.List;
import java.util.stream.IntStream;

import library.structure.pair.Pair;

/**
 * 出力クラス
 * PrintWriterより速い
 */
final class MyPrinter implements Closeable, Flushable, AutoCloseable {
	private OutputStream os;
	private final boolean autoFlush;
	private final byte[] buf;
	private int pos;
	/**
	 * コンストラクタ
	 * @param os 標準出力(System.out)か標準エラー出力(System.err)か入れる
	 * @param autoFlush インタラクティブ問題の時はtrueにする
	 */
	MyPrinter(final OutputStream os, final boolean autoFlush){
		this.os = os;
		this.autoFlush = autoFlush;
		buf = new byte[1 << 17];
		pos = 0;
	}
	private final void write(final byte bt) {
		buf[pos++] = bt;
		if(pos == buf.length) {
			flush();
		}
	}
	private final void newLine() {
		write((byte) '\n');
		if(autoFlush) {
			flush();
		}
	}
	final void print(final Object arg) {
		if(arg instanceof String s) {
			for(final char c: s.toCharArray()) {
				write((byte) c);
			}
		} else {
			print(String.valueOf(arg));
		}
	}
	/**
	 * PrintWriterのprintfと使い方は同じ
	 * @see PrintWriter#printf
	 */
	final void printf(final String fmt, final Object... args){ print(new Formatter().format(fmt, args)); }
	private final void println(final Object arg) {
		print(arg);
		newLine();
	}
	/**
	 * 出力するためのメソッド
	 * 引数なしで改行を出力する
	 */
	final void out(){ newLine(); }
	/**
	 * out(a, b, c)で, "a b c"の形式で出力する
	 * @param head
	 * @param tail
	 */
	final void out(final Object head, final Object... tail) {
		print(head);
		for(final var el: tail) {
			print(" " + el);
		}
		newLine();
	}
	/**
	 * {@link Pair}を出力する
	 * デバッグ時は{@link Pair#toString}を推奨
	 * @param <F> firstの型
	 * @param <S> secondの型
	 */
	final <F extends Comparable<? super F>, S extends Comparable<? super S>> void out(final Pair<F, S> arg){ println(arg.first + " " + arg.second); }
	/**
	 * int型の配列を空白おきで出力する
	 */
	final void out(final int[] args){ IntStream.range(0, args.length).forEach(i -> print(args[i] + (i + 1 < args.length ? " " : "\n"))); }
	/**
	 * long型の配列を空白おきで出力する
	 */
	final void out(final long[] args){ IntStream.range(0, args.length).forEach(i -> print(args[i] + (i + 1 < args.length ? " " : "\n"))); }
	/**
	 * double型の配列を空白おきで出力する
	 */
	final void out(final double[] args){ IntStream.range(0, args.length).forEach(i -> print(args[i] + (i + 1 < args.length ? " " : "\n"))); }
	/**
	 * boolean型の配列を空白おきで出力する
	 */
	final void out(final boolean[] args){ IntStream.range(0, args.length).forEach(i -> print(args[i] + (i + 1 < args.length ? " " : "\n"))); }
	/**
	 * char型の配列を空白おきで出力する
	 */
	final void out(final char[] args){ IntStream.range(0, args.length).forEach(i -> print(args[i] + (i + 1 < args.length ? " " : "\n"))); }
	/**
	 * {@link Object}クラスの配列を空白おきで出力する
	 */
	final void out(final Object[] args){ IntStream.range(0, args.length).forEach(i -> print(args[i] + (i + 1 < args.length ? " " : "\n"))); }
	/**
	 * {@link Collection}を出力する
	 */
	final <E> void out(final Collection<E> args) {
		int i = 0;
		for(final var el: args) {
			print(el + (++i == args.size() ? "\n" : " "));
		}
	}
	/**
	 * outl(a, b, c)で, "a\nb\nc\n"の形式で出力される
	 */
	final void outl(final Object head, final Object... tail) {
		out(head);
		Arrays.stream(tail).forEach(this::println);
	}
	/**
	 * {@link #out}の改行おき出力版
	 */
	final void outl(final int[] args){ Arrays.stream(args).forEach(this::println); }
	/**
	 * {@link #out}をargs.length回呼び出す
	 */
	final void outl(final int[][] args){ IntStream.range(0, args.length).forEach(i -> out(args[i])); }
	/**
	 * {@link #out}の改行おき出力版
	 */
	final void outl(final long[] args){ Arrays.stream(args).forEach(this::println); }
	/**
	 * {@link #out}をargs.length回呼び出す
	 */
	final void outl(final long[][] args){ IntStream.range(0, args.length).forEach(i -> out(args[i])); }
	/**
	 * {@link #out}の改行おき出力版
	 */
	final void outl(final double[] args){ Arrays.stream(args).forEach(this::println); }
	/**
	 * {@link #out}をargs.length回呼び出す
	 */
	final void outl(final double[][] args){ IntStream.range(0, args.length).forEach(i -> out(args[i])); }
	/**
	 * {@link #out}の改行おき出力版
	 */
	final void outl(final boolean[] args){ IntStream.range(0, args.length).forEach(i -> out(args[i])); }
	/**
	 * {@link #out}をargs.length回呼び出す
	 */
	final void outl(final boolean[][] args){ IntStream.range(0, args.length).forEach(i -> out(args[i])); }
	/**
	 * {@link #out}の改行おき出力版
	 */
	final void outl(final char[] args){ IntStream.range(0, args.length).forEach(i -> out(args[i])); }
	/**
	 * {@link #out}をargs.length回呼び出す
	 */
	final void outl(final char[][] args){ IntStream.range(0, args.length).forEach(i -> out(args[i])); }
	/**
	 * {@link #out}の改行おき出力版
	 */
	final void outl(final Object[] args){ Arrays.stream(args).forEach(this::println); }
	/**
	 * {@link #out}をargs.length回呼び出す
	 */
	final void outl(final Object[][] args){ Arrays.stream(args).forEach(this::out); }
	/**
	 * {@link #out}の改行おき出力版
	 */
	final <E> void outl(final Collection<E> args){ args.stream().forEach(this::println); }
	/**
	 * この出力を最後に処理を終了する
	 * @see #out
	 */
	final void fin(final Object head, final Object... tail) {
		out(head, tail);
		flush();
		System.exit(0);
	}
	/**
	 * この出力を最後に処理を終了する
	 * @see #out
	 */
	final void fin(final int[] args) {
		out(args);
		flush();
		System.exit(0);
	}
	/**
	 * この出力を最後に処理を終了する
	 * @see #out
	 */
	final void fin(final long[] args) {
		out(args);
		flush();
		System.exit(0);
	}
	/**
	 * この出力を最後に処理を終了する
	 * @see #out
	 */
	final void fin(final double[] args) {
		out(args);
		flush();
		System.exit(0);
	}
	/**
	 * この出力を最後に処理を終了する
	 * @see #out
	 */
	final void fin(final boolean[] args) {
		out(args);
		flush();
		System.exit(0);
	}
	/**
	 * この出力を最後に処理を終了する
	 * @see #out
	 */
	final void fin(final char[] args) {
		out(args);
		flush();
		System.exit(0);
	}
	/**
	 * この出力を最後に処理を終了する
	 * @see #out
	 */
	final void fin(final Object[] args) {
		out(args);
		flush();
		System.exit(0);
	}
	/**
	 * この出力を最後に処理を終了する
	 * @see #out
	 */
	final <T> void fin(final List<T> args) {
		out(args);
		flush();
		System.exit(0);
	}
	/**
	 * この出力を最後に処理を終了する
	 * @see #outl
	 */
	final void ende(final int[] args) {
		outl(args);
		flush();
		System.exit(0);
	}
	/**
	 * この出力を最後に処理を終了する
	 * @see #outl
	 */
	final void ende(final long[] args) {
		outl(args);
		flush();
		System.exit(0);
	}
	/**
	 * この出力を最後に処理を終了する
	 * @see #outl
	 */
	final void ende(final double[] args) {
		outl(args);
		flush();
		System.exit(0);
	}
	/**
	 * この出力を最後に処理を終了する
	 * @see #outl
	 */
	final void ende(final boolean[] args) {
		outl(args);
		flush();
		System.exit(0);
	}
	/**
	 * この出力を最後に処理を終了する
	 * @see #outl
	 */
	final void ende(final char[] args) {
		outl(args);
		flush();
		System.exit(0);
	}
	/**
	 * この出力を最後に処理を終了する
	 * @see #outl
	 */
	final void ende(final Object[] args) {
		outl(args);
		flush();
		System.exit(0);
	}
	/**
	 * この出力を最後に処理を終了する
	 * @see #outl
	 */
	final <E> void ende(final Collection<E> args) {
		outl(args);
		flush();
		System.exit(0);
	}
	/**
	 * 出力をflushする
	 * @see PrintWriter#flush
	 */
	@Override
	public final void flush() {
		try {
			os.write(buf, 0, pos);
			pos = 0;
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * OutputStreamを閉じる
	 * @see PrintWriter#close
	 */
	@Override
	public final void close() {
		if(os == null) {
			return;
		}
		try {
			os.close();
			os = null;
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}