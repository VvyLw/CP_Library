#pragma once

#include "C++/math/euler_phi.hpp"
#ifndef TEMPLATE
namespace man {
template <std::integral T> constexpr inline T pow(T a, T b, const T mod = 0) noexcept {
	T ret = 1;
	if(mod != 0) {
		ret %= mod;
		a %= mod;
	}
	while(b > 0) {
		if(b & 1) {
			ret *= a;
		}
		if(mod != 0) {
			ret %= mod;
		}
		a *= a;
		if(mod) {
			a %= mod;
		}
		b >>= 1;
	}
	return ret;
}
}
#endif
namespace man {
template <std::integral T> constexpr inline T tetration(const T a, const T b, const T m) noexcept {
    if(m == 1) {
        return 0;
    }
    if(a == 0) {
        return (b & 1) ? 0 : 1;
    }
    if(b == 0) {
        return 1;
    }
    if(b == 1) {
        return a % m;
    }
    if(b == 2) {
        return pow(a, a, m);
    }
    const auto phi = euler_phi(m);
    auto tmp = tetration(a, b - 1, phi);
    if(!tmp) {
        tmp += phi;
    }
    return pow(a, tmp, m);
}
}

/**
 * @brief Tetration(a↑↑b)
 */