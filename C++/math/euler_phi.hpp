#pragma once
namespace man {
template <std::integral T> constexpr inline T euler_phi(T n) noexcept {
	T ret = n;
	for(T i = 2; i * i <= n; ++i) {
	    if(n % i == 0) {
			ret -= ret / i;
			while(n % i == 0) {
				n /= i;
			}
		}
	}
	if(n > 1) {
		ret -= ret / n;
	}
	return ret;
}
}

/**
 * @brief Euler's Phi-function
 */