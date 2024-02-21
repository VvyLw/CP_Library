package library.core;

import java.util.stream.IntStream;

/**
 *  Mainクラス。
 *  ここに変更は加えない。
 *  @author VvyLw
 */
final class Main {
	public static void main(final String[] args) {
		IntStream.range(0, VvyLw.MULTI ? VvyLw.io.ni() : 1).forEach(i -> VvyLw.solve());
		VvyLw.io.close();
	}
}