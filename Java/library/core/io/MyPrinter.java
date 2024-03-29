package library.core.io;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collection;
import java.util.Formatter;

import library.ds.pair.Pair;

/**
 * 出力クラス
 * PrintWriterより速い
 */
public final class MyPrinter implements Closeable, Flushable, AutoCloseable {
	private OutputStream os;
	private final boolean autoFlush;
	private final byte[] buf;
	private int pos;
	private final boolean debug;
	/**
	 * コンストラクタ
	 * @param os 標準出力(System.out)か標準エラー出力(System.err)か入れる
	 * 標準エラー出力の時、一部出力がtoStringされて表示される。
	 * @param autoFlush インタラクティブ問題の時はtrueにする
	 */
	public MyPrinter(final OutputStream os, final boolean autoFlush){
		this.os = os;
		this.autoFlush = autoFlush;
		buf = new byte[1 << 17];
		pos = 0;
		debug = os == System.err;
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
	/**
	 * {@link PrintWriter#print}と使い方は同じ
	 * @param arg
	 * @see PrintWriter#print
	 */
	public final void print(final Object arg) {
		if(arg instanceof final String s) {
			for(final char c: s.toCharArray()) {
				write((byte) c);
			}
		} else {
			print(String.valueOf(arg));
		}
		if(autoFlush) {
			flush();
		}
	}
	/**
	 * {@link PrintWriter#printf}と使い方は同じ
	 * @param fmt
	 * @param args
	 * @see PrintWriter#printf
	 */
	public final void printf(final String fmt, final Object... args) {
		print(new Formatter().format(fmt, args));
		if(autoFlush) {
			flush();
		}
	}
	/**
	 * 出力するためのメソッド
	 * 引数なしで改行を出力する
	 */
	public final void out(){ newLine(); }
	/**
	 * out(a, b, c)で, "a b c"の形式で出力する
	 * @param head
	 * @param tail
	 */
	public final void out(final Object head, final Object... tail) {
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
	public final <F extends Comparable<? super F>, S extends Comparable<? super S>> void out(final Pair<F, S> arg) {
		if(debug) {
			print(arg.toString());
		} else {
			print(arg.first + " " + arg.second);
		}
		newLine();
	}
	/**
	 * {@link Collection}を出力する
	 * @param args
	 */
	public final <E> void out(final Collection<E> args) {
		if(debug) {
			print(args.toString());
		} else {
			int i = 0;
			for(final var el: args) {
				print(el);
				if(++i != args.size()) {
					print(" ");
				}
			}
		}
		newLine();
	}
	private final void out(final int[] args) {
		if(debug) {
			print(Arrays.toString(args));
		} else if(args.length > 0) {
			print(args[0]);
			for(int i = 0; ++i < args.length;) {
				print(" " + args[i]);
			}
		}
		newLine();
	}
	/**
	 * int型の配列を空白おきで出力する
	 * @param head
	 * @param tail
	 */
	public final void out(final int[] head, final int[]... tail) {
		out(head);
		for(final int[] a: tail) {
			out(a);
		}
	}
	private final void out(final long[] args) {
		if(debug) {
			print(Arrays.toString(args));
		} else if(args.length > 0) {
			print(args[0]);
			for(int i = 0; ++i < args.length;) {
				print(" " + args[i]);
			}
		}
		newLine();
	}
	/**
	 * long型の配列を空白おきで出力する
	 * @param head
	 * @param tail
	 */
	public final void out(final long[] head, final long[]... tail) {
		out(head);
		for(final long[] a: tail) {
			out(a);
		}
	}
	private final void out(final double[] args) {
		if(debug) {
			print(Arrays.toString(args));
		} else if(args.length > 0) {
			print(args[0]);
			for(int i = 0; ++i < args.length;) {
				print(" " + args[i]);
			}
		}
		newLine();
	}
	/**
	 * double型の配列を空白おきで出力する
	 * @param head
	 * @param tail
	 */
	public final void out(final double[] head, final double[]... tail) {
		out(head);
		for(final double[] a: tail) {
			out(a);
		}
	}
	private final void out(final boolean[] args) {
		if(debug) {
			print(Arrays.toString(args));
		} else if(args.length > 0) {
			print(args[0]);
			for(int i = 0; ++i < args.length;) {
				print(" " + args[i]);
			}
		}
		newLine();
	}
	/**
	 * boolean型の配列を空白おきで出力する
	 * @param head
	 * @param tail
	 */
	public final void out(final boolean[] head, final boolean[]... tail) {
		out(head);
		for(final boolean[] a: tail) {
			out(a);
		}
	}
	private final void out(final char[] args) {
		if(args.length > 0) {
			print(args[0]);
			for(int i = 0; ++i < args.length;) {
				print(" " + args[i]);
			}
		}
		newLine();
	}
	/**
	 * char型の配列を空白おきで出力する
	 * @param head
	 * @param tail
	 */
	public final void out(final char[] head, final char[]... tail) {
		out(head);
		for(final char[] a: tail) {
			out(a);
		}
	}
	private final void out(final Object[] args) {
		if(debug) {
			print(Arrays.toString(args));
		} else if(args.length > 0) {
			print(args[0]);
			for(int i = 0; ++i < args.length;) {
				print(" " + args[i]);
			}
		}
		newLine();
	}
	/**
	 * Objectクラスの配列を空白おきで出力する
	 * @param head
	 * @param tail
	 */
	public final void out(final Object[] head, final Object[]... tail) {
		out(head);
		for(final Object[] a: tail) {
			out(a);
		}
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
		} catch(final IOException e) {
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
		} catch(final IOException e) {
			e.printStackTrace();
		}
	}
}