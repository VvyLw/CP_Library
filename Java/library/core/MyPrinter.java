package library.core;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Formatter;
import java.util.List;
import java.util.stream.IntStream;

import library.pair.Pair;

final class MyPrinter implements Closeable, Flushable, AutoCloseable {
	private OutputStream os;
	private final boolean autoFlush;
	private final byte[] buf;
	private int pos;
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
	final void printf(final String fmt, final Object... args){ print(new Formatter().format(fmt, args)); }
	private final void println(final Object arg) {
		print(arg);
		newLine();
	}
	final void out(){ newLine(); }
	final void out(final Object head, final Object... tail) {
		print(head);
		for(final var el: tail) {
			print(" " + el);
		}
		newLine();
	}
	final <F extends Comparable<? super F>, S extends Comparable<? super S>> void out(final Pair<F, S> arg){ println(arg.first + " " + arg.second); }
	final void out(final int[] args){ IntStream.range(0, args.length).forEach(i -> print(args[i] + (i + 1 < args.length ? " " : "\n"))); }
	final void out(final long[] args){ IntStream.range(0, args.length).forEach(i -> print(args[i] + (i + 1 < args.length ? " " : "\n"))); }
	final void out(final double[] args){ IntStream.range(0, args.length).forEach(i -> print(args[i] + (i + 1 < args.length ? " " : "\n"))); }
	final void out(final boolean[] args){ IntStream.range(0, args.length).forEach(i -> print(args[i] + (i + 1 < args.length ? " " : "\n"))); }
	final void out(final char[] args){ IntStream.range(0, args.length).forEach(i -> print(args[i] + (i + 1 < args.length ? " " : "\n"))); }
	final void out(final Object[] args){ IntStream.range(0, args.length).forEach(i -> print(args[i] + (i + 1 < args.length ? " " : "\n"))); }
	final <E> void out(final Collection<E> args) {
		int i = 0;
		for(final var el: args) {
			print(el + (++i == args.size() ? "\n" : " "));
		}
	}
	final void outl(final Object head, final Object... tail) {
		out(head);
		Arrays.stream(tail).forEach(this::println);
	}
	final void outl(final int[] args){ Arrays.stream(args).forEach(this::println); }
	final void outl(final int[][] args){ IntStream.range(0, args.length).forEach(i -> out(args[i])); }
	final void outl(final long[] args){ Arrays.stream(args).forEach(this::println); }
	final void outl(final long[][] args){ IntStream.range(0, args.length).forEach(i -> out(args[i])); }
	final void outl(final double[] args){ Arrays.stream(args).forEach(this::println); }
	final void outl(final double[][] args){ IntStream.range(0, args.length).forEach(i -> out(args[i])); }
	final void outl(final boolean[] args){ IntStream.range(0, args.length).forEach(i -> out(args[i])); }
	final void outl(final boolean[][] args){ IntStream.range(0, args.length).forEach(i -> out(args[i])); }
	final void outl(final char[] args){ IntStream.range(0, args.length).forEach(i -> out(args[i])); }
	final void outl(final Object[] args){ Arrays.stream(args).forEach(this::println); }
	final <E> void outl(final Collection<E> args){ args.stream().forEach(this::println); }
	final void fin(final Object head, final Object... tail) {
		out(head, tail);
		flush();
		System.exit(0);
	}
	final void fin(final int[] args) {
		out(args);
		flush();
		System.exit(0);
	}
	final void fin(final long[] args) {
		out(args);
		flush();
		System.exit(0);
	}
	final void fin(final double[] args) {
		out(args);
		flush();
		System.exit(0);
	}
	final void fin(final boolean[] args) {
		out(args);
		flush();
		System.exit(0);
	}
	final void fin(final char[] args) {
		out(args);
		flush();
		System.exit(0);
	}
	final void fin(final Object[] args) {
		out(args);
		flush();
		System.exit(0);
	}
	final <T> void fin(final List<T> args) {
		out(args);
		flush();
		System.exit(0);
	}
	final void ende(final int[] args) {
		outl(args);
		flush();
		System.exit(0);
	}
	final void ende(final long[] args) {
		outl(args);
		flush();
		System.exit(0);
	}
	final void ende(final double[] args) {
		outl(args);
		flush();
		System.exit(0);
	}
	final void ende(final boolean[] args) {
		outl(args);
		flush();
		System.exit(0);
	}
	final void ende(final char[] args) {
		outl(args);
		flush();
		System.exit(0);
	}
	final void ende(final Object[] args) {
		outl(args);
		flush();
		System.exit(0);
	}
	final <E> void ende(final Collection<E> args) {
		outl(args);
		flush();
		System.exit(0);
	}
	@Override
	public final void flush() {
		try {
			os.write(buf, 0, pos);
			pos = 0;
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
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