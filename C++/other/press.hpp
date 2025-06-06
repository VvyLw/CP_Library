#pragma once
#include <vector>

namespace man {
template <class T> inline std::vector<T> press(const std::vector<T> &v) noexcept {
	std::vector<T> ret, cp = v;
	uniq(cp);
	for(const auto &el: v) {
		ret.emplace_back(std::ranges::lower_bound(cp, el) - cp.cbegin());
	}
	return ret;
}
template <class T> inline std::vector<T> press(std::vector<T> &c1, std::vector<T> &c2) {
	std::vector<T> ret;
	const int n = c1.size();
	for(const auto i: std::views::iota(0, n)) {
		for(const auto d: std::views::iota(0, 1)) {
			T tc1 = c1[i] + d;
			T tc2 = c2[i] + d;
			ret.emplace_back(tc1);
			ret.emplace_back(tc2);
		}
	}
	uniq(ret);
	for(const auto i: std::views::iota(0, n)) {
		c1[i] = std::ranges::lower_bound(ret, c1[i]) - ret.cbegin();
		c2[i] = std::ranges::lower_bound(ret, c2[i]) - ret.cbegin();
	}
	return ret;
}
}
/**
 * @brief 座標圧縮
 */