package extension;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;

class MyPrinter {
	private PrintWriter pw;
	MyPrinter(final OutputStream os, final boolean flush){ pw = new PrintWriter(os, flush); }
	void print(final Object arg){ pw.print(arg); }
	void out(){ pw.println(); }
	void out(final Object head, final Object... tail) {
		pw.print(head);
		for(final var el: tail) {
			pw.print(" " + el);
		}
		out();
	}
	<F, S> void out(final Pair<F, S> arg){ pw.println(arg.first + " " + arg.second); }
	void out(final int[] args){ IntStream.range(0, args.length).forEach(i -> pw.print(args[i] + (i + 1 < args.length ? " " : "\n"))); }
	void out(final long[] args){ IntStream.range(0, args.length).forEach(i -> pw.print(args[i] + (i + 1 < args.length ? " " : "\n"))); }
	void out(final double[] args){ IntStream.range(0, args.length).forEach(i -> pw.print(args[i] + (i + 1 < args.length ? " " : "\n"))); }
	void out(final boolean[] args){ IntStream.range(0, args.length).forEach(i -> pw.print(args[i] + (i + 1 < args.length ? " " : "\n"))); }
	void out(final char[] args){ IntStream.range(0, args.length).forEach(i -> pw.print(args[i] + (i + 1 < args.length ? " " : "\n"))); }
	void out(final Object[] args){ IntStream.range(0, args.length).forEach(i -> pw.print(args[i] + (i + 1 < args.length ? " " : "\n"))); }
	<T> void out(final List<T> args){ IntStream.range(0, args.size()).forEach(i -> pw.print(args.get(i) + (i + 1 < args.size() ? " " : "\n"))); }
	void outl(final Object head, final Object... tail) {
		out(head);
		Arrays.stream(tail).forEach(pw::println);
	}
	void outl(final int[] args){ Arrays.stream(args).forEach(pw::println); }
	void outl(final int[][] args){ IntStream.range(0, args.length).forEach(i -> out(args[i])); }
	void outl(final long[] args){ Arrays.stream(args).forEach(pw::println); }
	void outl(final long[][] args){ IntStream.range(0, args.length).forEach(i -> out(args[i])); }
	void outl(final double[] args){ Arrays.stream(args).forEach(pw::println); }
	void outl(final double[][] args){ IntStream.range(0, args.length).forEach(i -> out(args[i])); }
	void outl(final boolean[] args){ IntStream.range(0, args.length).forEach(i -> out(args[i])); }
	void outl(final boolean[][] args){ IntStream.range(0, args.length).forEach(i -> out(args[i])); }
	void outl(final char[] args){ IntStream.range(0, args.length).forEach(i -> out(args[i])); }
	void outl(final Object[] args){ Arrays.stream(args).forEach(pw::println); }
	<E> void outl(final Collection<E> args){ args.stream().forEach(pw::println); }
	void fin(final Object head, final Object... tail) {
		out(head, tail);
		flush();
		System.exit(0);
	}
	<T> void fin(final List<T> args) {
		out(args);
		flush();
		System.exit(0);
	}
	<E> void fine(final Collection<E> args) {
		outl(args);
		flush();
		System.exit(0);
	}
	void flush(){ pw.flush(); }
	void close(){ pw.close(); }
}