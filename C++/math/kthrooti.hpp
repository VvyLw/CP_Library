#pragma once

#include <cstdint>
#include <limits>
#include <ranges>
#ifndef TEMPLATE
namespace man {
template <std::integral T, std::integral U> constexpr inline bool overflow_if_mul(const T a, const U b) noexcept { return (std::numeric_limits<T>::max()/a)<b; }
}
#endif
namespace man {
inline uint64_t kthrooti(const uint64_t n, const int k) {
    if(k == 1) {
		return n;
	}
	const auto chk = [&](const unsigned x) -> bool {
		uint64_t mul = 1;
		for([[maybe_unused]] const auto _: std::views::iota(0, k)) {
            if(man::overflow_if_mul(mul, x)) {
                return false;
            }
            mul *= x;
        }
		return mul <= n;
	};
	uint64_t ret = 0;
	for(const auto i: std::views::iota(0, 32) | std::views::reverse) {
		if(chk(ret | (1U << i))) {
			ret |= 1U << i;
		}
	}
	return ret;
}
}

/**
 * @brief k乗根(整数)
 */