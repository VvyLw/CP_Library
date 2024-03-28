#pragma once

#include <vector>
#include <map>
#include <numeric>
namespace Heileden {
struct p_fact {
    std::vector<int64_t> spf;
    p_fact(const int n): spf(n + 1){
        std::iota(spf.begin(), spf.end(), 0);
        for(int64_t i = 2; i * i <= n; ++i) {
            if(spf[i] == i) {
                for(int64_t j = i * i; j <= n; j += i) {
                    if(spf[j]==j) {
                        spf[j]=i;
                    }
                }
            }
        }
    }
    std::map<int, int> get(int n) {
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