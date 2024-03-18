package library.core;

import java.util.stream.IntStream;

/**
 *  Mainクラス。
 *  ここに変更は加えない。
 *  実行時間をローカルで計測可能
 *  @author VvyLw
 */
final class Main {
	public static void main(final String[] args) {
		final long begin = System.currentTimeMillis(), end;
		IntStream.range(0, VvyLw.MULTI ? VvyLw.io.ni() : 1).forEach(i -> VvyLw.solve());
		end = System.currentTimeMillis();
		VvyLw.io.dump(end - begin + "ms");
		VvyLw.io.close();
	}
}