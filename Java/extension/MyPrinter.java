package extension;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;

final class MyPrinter {
	private final PrintWriter pw;
	MyPrinter(final OutputStream os, final boolean flush){ pw = new PrintWriter(os, flush); }
	final void print(final Object arg){ pw.print(arg); }
	final void out(){ pw.println(); }
	final void out(final Object head, final Object... tail) {
		pw.print(head);
		for(final var el: tail) {
			pw.print(" " + el);
		}
		out();
	}
	final <F, S> void out(final Pair<F, S> arg){ pw.println(arg.first + " " + arg.second); }
	final void out(final int[] args){ IntStream.range(0, args.length).forEach(i -> pw.print(args[i] + (i + 1 < args.length ? " " : "\n"))); }
	final void out(final long[] args){ IntStream.range(0, args.length).forEach(i -> pw.print(args[i] + (i + 1 < args.length ? " " : "\n"))); }
	final void out(final double[] args){ IntStream.range(0, args.length).forEach(i -> pw.print(args[i] + (i + 1 < args.length ? " " : "\n"))); }
	final void out(final boolean[] args){ IntStream.range(0, args.length).forEach(i -> pw.print(args[i] + (i + 1 < args.length ? " " : "\n"))); }
	final void out(final char[] args){ IntStream.range(0, args.length).forEach(i -> pw.print(args[i] + (i + 1 < args.length ? " " : "\n"))); }
	final void out(final Object[] args){ IntStream.range(0, args.length).forEach(i -> pw.print(args[i] + (i + 1 < args.length ? " " : "\n"))); }
	final <T> void out(final List<T> args){ IntStream.range(0, args.size()).forEach(i -> pw.print(args.get(i) + (i + 1 < args.size() ? " " : "\n"))); }
	final void outl(final Object head, final Object... tail) {
		out(head);
		Arrays.stream(tail).forEach(pw::println);
	}
	final void outl(final int[] args){ Arrays.stream(args).forEach(pw::println); }
	final void outl(final int[][] args){ IntStream.range(0, args.length).forEach(i -> out(args[i])); }
	final void outl(final long[] args){ Arrays.stream(args).forEach(pw::println); }
	final void outl(final long[][] args){ IntStream.range(0, args.length).forEach(i -> out(args[i])); }
	final void outl(final double[] args){ Arrays.stream(args).forEach(pw::println); }
	final void outl(final double[][] args){ IntStream.range(0, args.length).forEach(i -> out(args[i])); }
	final void outl(final boolean[] args){ IntStream.range(0, args.length).forEach(i -> out(args[i])); }
	final void outl(final boolean[][] args){ IntStream.range(0, args.length).forEach(i -> out(args[i])); }
	final void outl(final char[] args){ IntStream.range(0, args.length).forEach(i -> out(args[i])); }
	final void outl(final Object[] args){ Arrays.stream(args).forEach(pw::println); }
	final <E> void outl(final Collection<E> args){ args.stream().forEach(pw::println); }
	final void fin(final Object head, final Object... tail) {
		out(head, tail);
		flush();
		System.exit(0);
	}
	final <T> void fin(final List<T> args) {
		out(args);
		flush();
		System.exit(0);
	}
	final <E> void fine(final Collection<E> args) {
		outl(args);
		flush();
		System.exit(0);
	}
	final void flush(){ pw.flush(); }
	final void close(){ pw.close(); }
}