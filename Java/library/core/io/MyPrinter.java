package library.core.io;

import java.io.Flushable;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collection;
import java.util.Formatter;
import java.util.stream.IntStream;

import library.ds.pair.Pair;

/**
 * 出力クラス
 * PrintWriterより速い
 */
public final class MyPrinter implements Flushable, AutoCloseable {
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
	protected MyPrinter(final OutputStream os, final boolean autoFlush){
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
	 * 色々出力してくれる
	 * @param arg
	 * @see PrintWriter#print
	 */
	protected final void print(final Object arg) {
		if(arg instanceof final String s) {
			for(final char c: s.toCharArray()) {
				write((byte) c);
			}
		} else {
			final StringBuilder sb = new StringBuilder();
			if(arg instanceof final int[] a) {
				if(debug) {
					print(Arrays.toString(a));
					return;
				}
				if(a.length == 0) {
					return;
				}
				sb.append(a[0]);
				for(int i = 0; ++i < a.length;) {
					sb.append(" " + a[i]);
				}
			} else if(arg instanceof final long[] a) {
				if(debug) {
					print(Arrays.toString(a));
					return;
				}
				if(a.length == 0) {
					return;
				}
				sb.append(a[0]);
				for(int i = 0; ++i < a.length;) {
					sb.append(" " + a[i]);
				}
			} else if(arg instanceof final double[] a) {
				if(debug) {
					print(Arrays.toString(a));
					return;
				}
				if(a.length == 0) {
					return;
				}
				sb.append(a[0]);
				for(int i = 0; ++i < a.length;) {
					sb.append(" " + a[i]);
				}
			} else if(arg instanceof final boolean[] a) {
				if(debug) {
					print(Arrays.toString(a));
					return;
				}
				if(a.length == 0) {
					return;
				}
				sb.append(a[0]);
				for(int i = 0; ++i < a.length;) {
					sb.append(" " + a[i]);
				}
			} else if(arg instanceof final char[] a) {
				if(a.length == 0) {
					return;
				}
				for(int i = 0; i < a.length; ++i) {
					sb.append(a[i]);
				}
			} else if(arg instanceof final Object[] a) {
				if(debug) {
					print(Arrays.toString(a));
					return;
				}
				if(a.length == 0) {
					return;
				}
				print(a[0]);
				for(int i = 0; ++i < a.length;) {
					print(" ");
					print(a[i]);
				}
				return;
			} else {
				if(debug) {
					print(arg.toString());
					return;
				} else if(arg instanceof final Pair<?, ?> p) {
					sb.append(p.first + " " + p.second);
				} else if(arg instanceof final Collection<?> c) {
					int i = 0;
					for(final Object el: c) {
						print(el);
						if(++i != c.size()) {
							print(" ");
						}
					}
					return;
				} else if(sb.isEmpty()) {
					print(arg.toString());
					return;
				}
			}
			print(sb.toString());
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
	protected final void printf(final String fmt, final Object... args) {
		print(new Formatter().format(fmt, args));
		if(autoFlush) {
			flush();
		}
	}
	/**
	 * 出力するためのメソッド
	 * 引数なしで改行を出力する
	 */
	protected final void out(){ newLine(); }
	/**
	 * out(a, b, c)で, "a b c"の形式で出力する
	 * @param head
	 * @param tail
	 */
	protected final void out(final Object head, final Object... tail) {
		print(head);
		for(final Object el: tail) {
			print(" " + el);
		}
		newLine();
	}
	/**
	 * switch文の書き方は現状yukicoderでしか動かないので、他のサイトではinstanceofで書いてある
	 * @param obj
	 */
	private final void p(final Object obj) {
		switch(obj) {
			case int[] a: Arrays.stream(a).forEach(this::out); break;
			case long[] a: Arrays.stream(a).forEach(this::out); break;
			case double[] a: Arrays.stream(a).forEach(this::out); break;
			case boolean[] a: IntStream.range(0, a.length).mapToObj(i -> a[i]).forEach(this::out); break;
			case char[] a: IntStream.range(0, a.length).mapToObj(i -> a[i]).forEach(this::out); break;
			case Object[] a: Arrays.stream(a).forEach(this::out); break;
			case Collection<?> a: a.stream().forEach(this::out); break;
			default: out(obj);
		}
	}
	/**
	 * 改行おきに出力する
	 * @param head
	 * @param tail
	 */
	protected final void outl(final Object head, final Object... tail) {
		p(head);
		for(final Object el: tail) {
			p(el);
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