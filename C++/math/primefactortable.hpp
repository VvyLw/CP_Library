#pragma once

#include <vector>
#include <map>
#include <numeric>
namespace man {
struct p_fact {
    std::vector<long long> spf;
    p_fact(const int n): spf(n + 1){
        std::iota(spf.begin(), spf.end(), 0);
        for(long long i = 2; i * i <= n; ++i) {
            if(spf[i] == i) {
                for(long long j = i * i; j <= n; j += i) {
                    if(spf[j] == j) {
                        spf[j] = i;
                    }
                }
            }
        }
    }
    inline std::map<int, int> get(int n) noexcept {
        std::map<int, int> m;
        while(n != 1) {
            m[spf[n]]++;
            n /= spf[n];
        }
        return m;
    }
};
}

/**
 * @brief 素因数分解テーブル
 */