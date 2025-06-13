#pragma once

namespace man {
constexpr inline bool is_prime(const unsigned long long n) noexcept {
	if(n <= 1) {
		return false;
	}
	if(n <= 3) {
		return true;
	}
	if(n % 2 ==0 || n % 3 == 0) {
		return false;
	}
	for(long long i = 5; i * i <= n; i += 6) {
		if(n % i == 0 || n % (i + 2) == 0) {
			return false;
		}
	}
	return true;
}
}