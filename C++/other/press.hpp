#pragma once
#include <vector>
#include <concepts>

namespace man {
template <std::integral T> inline std::vector<T> press(const std::vector<T> &v) noexcept {
	std::vector<T> ret, cp = v;
	uniq(cp);
	for(const auto &el: v) {
		ret.emplace_back(std::ranges::lower_bound(cp, el) - cp.cbegin());
	}
	return ret;
}
template <std::integral T> inline std::vector<T> press(std::vector<T> &c1, std::vector<T> &c2) {
	std::vector<T> ret;
	const int n = std::ssize(c1);
	for(const auto i: std::views::iota(0, n)) {
		ret.emplace_back(c1[i]);
		ret.emplace_back(c2[i]);
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