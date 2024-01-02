package extension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

final class SuffixArray extends ArrayList<Integer> {
	private final String vs;
	SuffixArray(final String vs, final boolean compress) {
		this.vs = vs;
		int[] newVS = new int[vs.length() + 1];
		if(compress) {
			final List<Integer> xs = vs.chars().sorted().distinct().boxed().collect(Collectors.toList());
			for(int i = 0; i < vs.length(); ++i) {
				newVS[i] = Utility.lowerBound(xs, (int) vs.charAt(i)) + 1;
			}
		} else {
			final int d = vs.chars().min().getAsInt();
			for(int i = 0; i < vs.length(); ++i) {
				newVS[i] = vs.charAt(i) - d + 1;
			}
		}
		this.addAll(Arrays.stream(SAIS(newVS)).boxed().collect(Collectors.toList()));
	}
	private final int[] SAIS(final int[] s) {
		final int n = s.length;
		final int[] ret = new int[n];
		final boolean[] isS = new boolean[n], isLMS = new boolean[n];
		int m = 0;
		for(int i = n - 2; i >= 0; i--) {
			isS[i] = (s[i] > s[i + 1]) || (s[i] == s[i + 1] && isS[i + 1]);
			m += (isLMS[i + 1] = isS[i] && !isS[i + 1]) ? 1 : 0;
		}
		final Consumer<ArrayList<Integer>> inducedSort = (lms) -> {
			final int upper = Arrays.stream(s).max().getAsInt();
			int[] l = new int[upper + 2], r = new int[upper + 2];
			for(final int v: s) {
				++l[v + 1];
				++r[v];
			}
			Arrays.parallelPrefix(l, (x, y) -> x + y);
			Arrays.parallelPrefix(r, (x, y) -> x + y);
			Arrays.fill(ret, -1);
			for(int i = lms.size(); --i >= 0;) {
				ret[--r[s[lms.get(i)]]] = lms.get(i);
			}
			for(final int v: ret) {
				if(v >= 1 && isS[v - 1]) {
					ret[l[s[v - 1]]++] = v - 1;
				}
			}
			Arrays.fill(r, 0);
			for(final int v: s) {
				++r[v];
			}
			Arrays.parallelPrefix(r, (x, y) -> x + y);
			for(int k = ret.length - 1, i = ret[k]; k >= 1; i = ret[--k]) {
				if(i >= 1 && !isS[i - 1]) {
					ret[--r[s[i - 1]]] = i - 1;
				}
			}
		};
		final ArrayList<Integer> lms = new ArrayList<>(), newLMS = new ArrayList<>();
		for(int i = 0; ++i < n;) {
			if(isLMS[i]) {
				lms.add(i);
			}
		}
		inducedSort.accept(lms);
		for(int i = 0; i < n; ++i) {
			if(!isS[ret[i]] && ret[i] > 0 && isS[ret[i] - 1]) {
				newLMS.add(ret[i]);
			}
		}
		final BiPredicate<Integer, Integer> same = (a, b) -> {
			if(s[a++] != s[b++]) {
				return false;
			}
			while(true) {
				if(s[a] != s[b]) {
					return false;
				}
				if(isLMS[a] || isLMS[b]) {
					return isLMS[a] && isLMS[b];
				}
				a++;
				b++;
			}
		};
		int rank = 0;
		ret[n - 1] = 0;
		for(int i = 0; ++i < m;) {
			if(!same.test(newLMS.get(i - 1), newLMS.get(i))) {
				++rank;
			}
			ret[newLMS.get(i)] = rank;
		}
		if(rank + 1 < m) {
			int[] newS = new int[m];
			for(int i = 0; i < m; ++i) {
				newS[i] = ret[lms.get(i)];
			}
			final var lmsSA = SAIS(newS);
			IntStream.range(0, m).forEach(i -> newLMS.set(i, lms.get(lmsSA[i])));
		}
		inducedSort.accept(newLMS);
		return ret;
	}
	final boolean ltSubstr(final String t, int si, int ti) {
		final int sn = vs.length(), tn = t.length();
		while(si < sn && ti < tn) {
			if(vs.charAt(si) < t.charAt(ti)) {
				return true;
			}
			if(vs.charAt(si) > t.charAt(ti)) {
				return false;
			}
			++si;
			++ti;
		}
		return si >= sn && ti < tn;
	}
	final int lowerBound(final String t) {
		int ok = this.size(), ng = 0;
		while(ok - ng > 1) {
			final int mid = (ok + ng) / 2;
			if(ltSubstr(t, this.get(mid), 0)) {
				ng = mid;
			} else {
				ok = mid;
			}
		}
		return ok;
	}
	final Pair<Integer, Integer> equalRange(final String t) {
		final int low = lowerBound(t);
		int ng = low - 1, ok = this.size();
		final StringBuilder sb = new StringBuilder(t);
		sb.setCharAt(t.length() - 1, (char)(sb.charAt(sb.length() - 1) - 1));
		final String u = sb.toString();
		while(ok - ng > 1) {
			final int mid = (ok + ng) / 2;
			if(ltSubstr(u, this.get(mid), 0)) {
				ng = mid;
			} else {
				ok = mid;
			}
		}
		final int end = this.size() - 1;
		this.add(end, this.get(end) - 1);
		return Pair.of(low, ok);
	}
	final int[] lcpArray() {
		final int n = this.size() - 1;
		int[] lcp = new int[n + 1], rank = new int[n + 1];
		for(int i = 0; i <= n; ++i) {
			rank[this.get(i)] = i;
		}
		int h = 0;
		for(int i = 0; i <= n; ++i) {
			if(rank[i] < n) {
				final int j = this.get(rank[i] + 1);
				for(; j + h < n && i + h < n; ++h) {
					if(vs.charAt(j + h) != vs.charAt(i + h)) {
						break;
					}
				}
				lcp[rank[i] + 1] = h;
				if(h > 0) {
					h--;
				}
			}
		}
		return lcp;
	}
	@Override
	public final String toString() { 
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < this.size(); ++i) {
			sb.append(i + ":[" + this.get(i) + "]");
			for(int j = this.get(i); j < vs.length(); ++j) {
				sb.append(" " + vs.charAt(j));
			}
			if(i + 1 != this.size()) {
				sb.append("\n");
			}
		}
		return sb.toString();
	}
}
