package library.math;

import java.util.Arrays;
import java.util.stream.IntStream;

import library.core.Utility;

/**
 * 行列
 * @see <a href="https://ei1333.github.io/luzhiled/snippets/math/matrix.html">参考元</a>
 */
public final class Matrix implements Cloneable {
	private final int h, w;
	private final long[][] mat;
	/**
	 * コンストラクタ(正方行列)
	 * @param n
	 */
	public Matrix(final int n){ this(n, n); }
	/**
	 * コンストラクタ(H×W行列)
	 * @param h
	 * @param w
	 */
	public Matrix(final int h, final int w) {
		this.h = h;
		this.w = w;
		mat = new long[h][w];
	}
	/**
	 * コンストラクタ
	 * @param m
	 */
	public Matrix(final int[][] m) {
		this(m.length, m[0].length);
		IntStream.range(0, h).forEach(i -> Arrays.setAll(mat[i], j -> m[i][j]));
	}
	/**
	 * コンストラクタ
	 * @param m
	 */
	public Matrix(final long[][] m) {
		this(m.length, m[0].length);
		IntStream.range(0, h).forEach(i -> Arrays.setAll(mat[i], j -> m[i][j]));
	}
	/**
	 * 単位行列
	 * @param n
	 */
	public static final Matrix E(final int n) {
		final Matrix m = new Matrix(n);
		IntStream.range(0, n).forEach(i -> m.set(i, i, 1));
		return m;
	}
	/**
	 * i行目の要素全てを返す
	 * @param i
	 * @return i行目の要素全て
	 */
	public final long[] getH(final int i){ return mat[i]; }
	/**
	 * i列目の要素全てを返す
	 * @param i
	 * @return i列目の要素全て
	 */
	public final long[] getW(final int i){ return IntStream.range(0, h).mapToLong(j -> mat[j][i]).toArray(); }
	/**
	 * 行列そのものを返す
	 * @return 行列
	 */
	public final long[][] get(){ return mat; }
	/**
	 * Matrix[i][j]を返す
	 * @param i
	 * @param j
	 * @return 行列のi行j列目の要素
	 */
	public final long get(final int i, final int j){ return mat[i][j]; }
	/**
	 * i行j列目に要素を設定する
	 * @param i
	 * @param j
	 * @param x
	 */
	public final void set(final int i, final int j, final long x){ mat[i][j] = x; }
	/**
	 * 加算
	 * @param m
	 */
	public final Matrix add(final Matrix m) {
		assert h == m.h && w == m.w;
		final Matrix mt = new Matrix(h, w);
		for(int i = 0; i < h; ++i) {
			for(int j = 0; j < w; ++j) {
				mt.set(i, j, mat[i][j] + m.get(i, j));
			}
		}
		return mt;
	}
	/**
	 * 任意mod加算
	 * @param m
	 * @param mod
	 */
	public final Matrix add(final Matrix m, final long mod) {
		assert h == m.h && w == m.w;
		final Matrix mt = new Matrix(h, w);
		for(int i = 0; i < h; ++i) {
			for(int j = 0; j < w; ++j) {
				mt.set(i, j, Utility.mod(mat[i][j] + m.get(i, j), mod));
			}
		}
		return mt;
	}
	/**
	 * 減算
	 * @param m
	 */
	public final Matrix sub(final Matrix m) {
		assert h == m.h && w == m.w;
		final Matrix mt = new Matrix(h, w);
		for(int i = 0; i < h; ++i) {
			for(int j = 0; j < w; ++j) {
				mt.set(i, j, mat[i][j] - m.get(i, j));
			}
		}
		return mt;
	}
	/**
	 * 任意mod減算
	 * @param m
	 * @param mod
	 */
	public final Matrix sub(final Matrix m, final long mod) {
		assert h == m.h && w == m.w;
		final Matrix mt = new Matrix(h, w);
		for(int i = 0; i < h; ++i) {
			for(int j = 0; j < w; ++j) {
				mt.set(i, j, Utility.mod(mat[i][j] - m.get(i, j), mod));
			}
		}
		return mt;
	}
	/**
	 * 乗算
	 * @param m
	 */
	public final Matrix mul(final Matrix m) {
		assert w == m.h;
		final Matrix mt = new Matrix(h, m.w);
		for(int i = 0; i < h; ++i) {
			for(int j = 0; j < m.w; ++j) {
				for(int k = 0; k < w; ++k) {
					mt.set(i, j, mt.get(i, j) + mat[i][k] * m.get(k, j));
				}
			}
		}
		return mt;
	}
	/**
	 * 任意mod乗算
	 * @param m
	 * @param mod
	 */
	public final Matrix mul(final Matrix m, final long mod) {
		assert w == m.h;
		final Matrix mt = new Matrix(h, m.w);
		for(int i = 0; i < h; ++i) {
			for(int j = 0; j < m.w; ++j) {
				for(int k = 0; k < w; ++k) {
					mt.set(i, j, Utility.mod(mt.get(i, j) + mat[i][k] * m.get(k, j), mod));
				}
			}
		}
		return mt;
	}
	/**
	 * 冪算
	 * @param k
	 */
	public final Matrix pow(int k) {
		Matrix n = clone();
		Matrix m = Matrix.E(h);
		while(k > 0) {
			if(k % 2 == 1) {
				m = m.mul(this);
			}
			n = n.mul(n);
			k >>= 1;
		}
		return n;
	}
	/**
	 * 任意mod冪算
	 * @param m
	 * @param mod
	 */
	public final Matrix pow(long k, final long mod) {
		Matrix n = clone();
		Matrix m = Matrix.E(h);
		while(k > 0) {
			if(k % 2 == 1) {
				m = m.mul(this, mod);
			}
			n = n.mul(n, mod);
			k >>= 1L;
		}
		return n;
	}
	@Override
	public final boolean equals(final Object o) {
		if(this == o) {
			return true;
		}
		if(o == null || getClass() != o.getClass()) {
			return false;
		}
		final Matrix m = (Matrix) o;
		if(h != m.h || w != m.w) {
			return false;
		}
		for(int i = 0; i < h; ++i) {
			for(int j = 0; j < w; ++j) {
				if(mat[i][j] != m.get(i, j)) {
					return false;
				}
			}
		}
		return true;
	}
	@Override
	public final Matrix clone() {
		final Matrix m = new Matrix(h, w);
		for(int i = 0; i < h; ++i) {
			m.mat[i] = Arrays.copyOf(mat[i], w);
		}
		return m;
	}
	@Override
	public final String toString() {
		final StringBuilder sb = new StringBuilder();
		final int interval = String.valueOf(IntStream.range(0, h).mapToLong(i -> IntStream.range(0, w).mapToLong(j -> mat[i][j]).max().getAsLong()).max().getAsLong()).length() + 1;
		for(int i = 0; i < h; ++i) {
			sb.append("[");
			for(int j = 0; j < w; ++j) {
				sb.append(String.format("%" + interval + "d", mat[i][j]));
				if(j + 1 == w) {
					sb.append("]");
				}
			}
			if(i + 1 != h) {
				sb.append("\n");
			}
		}
		return sb.toString();
	}
}