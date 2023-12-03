package extension;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.IntStream;

class MyScanner {
	private Scanner sc = new Scanner(System.in);
	int ni(){ return sc.nextInt(); }
	long nl(){ return sc.nextLong(); }
	double nd(){ return sc.nextDouble(); }
	String ns(){ return sc.next(); }
	int[] ni(final int n){
		int[] a = new int[n];
		IntStream.range(0, n).forEach(i -> a[i] = ni());
		return a;
	}
	long[] nl(final int n){
		long[] a = new long[n];
		IntStream.range(0, n).forEach(i -> a[i] = nl());
		return a;
	}
	double[] nd(final int n){
		double[] a = new double[n];
		IntStream.range(0, n).forEach(i -> a[i] = nd());
		return a;
	}
	String[] ns(final int n){
		String[] a = new String[n];
		IntStream.range(0, n).forEach(i -> a[i] = ns());
		return a;
	}
	ArrayList<Integer> nia(final int n) {
		var a = new ArrayList<Integer>(n);
		IntStream.range(0, n).forEach(i -> a.add(i, ni()));
		return a;
	}
	ArrayList<Long> nla(final int n) {
		var a = new ArrayList<Long>(n);
		IntStream.range(0, n).forEach(i -> a.add(i, nl()));
		return a;
	}
	ArrayList<Double> nda(final int n) {
		var a = new ArrayList<Double>(n);
		IntStream.range(0, n).forEach(i -> a.add(i, nd()));
		return a;
	}
	ArrayList<String> nsa(final int n) {
		var a = new ArrayList<String>(n);
		IntStream.range(0, n).forEach(i -> a.add(i, ns()));
		return a;
	}
	void close(){ sc.close(); }
}