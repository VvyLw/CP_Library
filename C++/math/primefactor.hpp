#pragma once

#include <vector>
#include <utility>
namespace Heileden {
template <class T> inline std::vector<std::pair<T, int>> prmfct(T n) {
    std::vector<std::pair<T, int>> res;
    for(int64_t i = 2; i * i <= n; ++i) {
        if(n % i != 0) {
            continue;
        }
        int tmp = 0;
        while(n % i == 0) {
            tmp++;
            n /= i;
        }
        res.emplace_back(i, tmp);
    }
    if(n != 1) {
        res.emplace_back(n, 1);
    }
    return res;
}
}

/**
 * @brief 素因数分解
 */