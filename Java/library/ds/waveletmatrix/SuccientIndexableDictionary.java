package library.ds.waveletmatrix;

/**
 * 完備辞書
 * @see <a href="https://ei1333.github.io/library/structure/wavelet/succinct-indexable-dictionary.hpp">参考元</a>
 */
final class SuccinctIndexableDictionary {
	private final int blk;
	private final int[] bit, sum;
	SuccinctIndexableDictionary(final int len) {
		blk = (len + 31) >> 5;
		bit = new int[blk];
		sum = new int[blk];
	}
	final void set(final int k){ bit[k >> 5] |= 1 << (k & 31); }
	final void build() {
		sum[0] = 0;
		for(int i = 0; ++i < blk;) {
			sum[i] = sum[i - 1] + Integer.bitCount(bit[i - 1]);
		}
	}
	final boolean get(final int k){ return ((bit[k >> 5] >> (k & 31)) & 1) == 1; }
	final int rank(final int k){ return (sum[k >> 5] + Integer.bitCount(bit[k >> 5] & ((1 << (k & 31)) - 1))); }
	final int rank(final boolean val, final int k){ return val ? rank(k) : k - rank(k); }
}