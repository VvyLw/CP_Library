#pragma once
#include <cstdint>

namespace man {
constexpr inline bool is_prime(const uint64_t n) noexcept {
	if(n <= 1) {
		return false;
	}
	if(n <= 3) {
		return true;
	}
	if(n % 2 ==0 || n % 3 == 0) {
		return false;
	}
	for(int64_t i = 5; i * i <= n; i += 6) {
		if(n % i == 0 || n % (i + 2) == 0) {
			return false;
		}
	}
	return true;
}
}