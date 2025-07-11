#include <iostream>
#include <array>
#include <algorithm>
#include <ranges>
#ifndef TEMPLATE
namespace man {
template <class T> constexpr inline T sqr(const T x) noexcept { return x * x; }
template <class T> constexpr inline T mod(T x, const T m) noexcept {
    x %= m;
    return x < 0 ? x + m : x;
}
}
#endif
namespace man {
template <int lim> struct ModPrime {
private:
    const long long m;
	std::array<long long, lim> f{}, rf{};
	const int len = std::min(m, (long long) lim);
    constexpr inline long long inv(long long x) noexcept {
        long long ret = 1, k = m - 2;
		while(k > 0) {
			if(k & 1) {
				ret = mod(ret * x, m);
			}
			x = mod(sqr(x), m);
			k >>= 1;
		}
		return ret;
    }
public:
    ModPrime(const long long mod_): m(mod_) {
		f[0] = 1;
		for(const auto i: std::views::iota(1, len)) {
			f[i] = mod(f[i - 1] * i, m);
		}
		rf[len - 1] = inv(f[len - 1]);
		for(const auto i: std::views::iota(1, len) | std::views::reverse) {
			rf[i - 1] = mod(rf[i] * i, m);
		}
    }
    constexpr inline long long C(const int n, const int k) const noexcept {
		if(k < 0 || n < k) {
			return 0;
		}
		const long long a = f[n], b = rf[n - k], c = rf[k], bc = mod(b * c, m);
		return mod(a * bc, m);
	}
	constexpr inline long long P(const int n, const int k) const noexcept {
		if(k < 0 || n < k) {
			return 0;
		}
		const long long a = f[n], b = rf[n - k];
		return mod(a * b, m);
	}
	constexpr inline long long H(const int n, const int k) const noexcept {
		if(n == 0 && k == 0) {
			return 1;
		}
		return C(n + k - 1, k);
	}
};
}
/**
 * @brief ModPrime
 */