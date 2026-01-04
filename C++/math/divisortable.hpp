#pragma once

#include "C++/math/primetable.hpp"
namespace man {
struct d_table {
private:
    std::vector<int> ret, cnt;
    p_table pt;
public:
    d_table(const int n): ret(n + 1), cnt(n + 1), pt(n){
        const auto is_prime = pt.SoE;
        const auto primes = pt.get();
        for(const auto i: std::views::iota(2, n + 1)) {
            if(is_prime[i]) {
                ret[i] = 2;
                cnt[i] = 1;
            }
            for(const auto &p: primes) {
                if(static_cast<long long>(i) * p > n) {
                    break;
                }
                if(i % p == 0) {
                    cnt[i * p] = cnt[i] + 1;
					ret[i * p] = ret[i] / (cnt[i] + 1) * (cnt[i * p] + 1);
					break;
				} else {
					cnt[i * p] = 1;
					ret[i * p] = ret[i] * 2;
				}
            }
        }
    }
    inline std::vector<int> get() noexcept { return ret; }
    inline int get(const int i) noexcept { return ret[i]; }
};
}

/**
 * @brief 約数の個数(線形篩)
 */