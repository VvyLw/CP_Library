package library.core;

import java.util.Objects;
import java.util.stream.IntStream;

/**
 *  Mainクラス
 *  ここに変更は加えない
 *  実行時間をローカルで計測可能
 *  @author VvyLw
 */
public final class Main {
	public static void main(final String[] args) {
		final long begin = System.currentTimeMillis(), end;
		IntStream.range(0, VvyLw.MULTI ? VvyLw.io.ni() : 1).mapToObj(VvyLw::solve).filter(Objects::nonNull).forEach(VvyLw.io::out);
		end = System.currentTimeMillis();
		VvyLw.io.dump(end - begin + "ms");
		VvyLw.io.close();
	}
}