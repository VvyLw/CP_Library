#pragma once

#include <vector>
#include <type_traits>
#include <ranges>
namespace man {
template <class T> requires std::ranges::random_access_range<T> constexpr inline auto rle(const T& a) noexcept {
	std::vector<std::pair<std::decay_t<decltype(a.front())>, int>> ret;
	for(const auto &e: a) {
		if(ret.empty() || ret.back().first != e) {
			ret.emplace_back(e, 1);
		} else {
			ret.back().second++;
		}
	}
	return ret;
}

template <class T> constexpr inline auto rle_rev(const std::vector<std::pair<T, int>> &a) noexcept {
	std::vector<T> ret;
	for(const auto &[f, s]: a) {
		for([[maybe_unused]] const auto _: std::views::iota(0, s)) {
			ret.emplace_back(f);
		}
	}
	if constexpr (std::is_same_v<T, char>) {
		return std::string(ret.cbegin(), ret.cend());
	} else {
		return ret;
	}
}
}

/**
 * @brief ランレングス圧縮
 */