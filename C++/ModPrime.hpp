#include <iostream>
#include <array>
#ifndef TEMPLATE
template <class T> inline T sqr(const T x){ return x * x; }
template <class T> inline T Mod(T x, const T m) {
    x %= m;
    return x < 0 ? x + m : x;
}
#else
using namespace zia_qu;
#endif
template <int lim> struct ModPrime {
private:
    const int64_t mod;
    std::array<int64_t, lim> f{}, rf{};
    int64_t inv(int64_t x) {
        int64_t res = 1, k = mod - 2;
		while(k) {
			if(k & 1) {
				res = Mod(res * x, mod);
			}
			x = Mod(sqr(x), mod);
			k >>= 1;
		}
		return res;
    }
public:
    ModPrime(const int64_t mod_): mod(mod_) {
        f[0] = 1;
		rf[0] = inv(f[0]);
		for(int i = 0; ++i < lim;) {
			f[i] = Mod(f[i - 1] * i, mod);
			rf[i] = inv(f[i]);
		}
    }
    int64_t C(const int n, const int k) const {
		if(k < 0 || n < k) {
			return 0;
		}
		const int64_t a = f[n], b = rf[n - k], c = rf[k], bc = Mod(b * c, mod);
		return Mod(a * bc, mod);
	}
	int64_t P(const int n, const int k) const {
		if (k < 0 || n < k) {
			return 0;
		}
		const int64_t a = f[n], b = rf[n - k];
		return Mod(a * b, mod);
	}
	int64_t H(const int n, const int k) const {
		if (n == 0 && k == 0) {
			return 1;
		}
		return C(n + k - 1, k);
	}
};