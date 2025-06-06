#pragma once

#include <vector>
#include <utility>
namespace man {
template <class T> inline std::vector<std::pair<T, int>> prmfct(T n) noexcept {
    std::vector<std::pair<T, int>> ret;
    for(int64_t i = 2; i * i <= n; ++i) {
        if(n % i != 0) {
            continue;
        }
        int tmp = 0;
        while(n % i == 0) {
            tmp++;
            n /= i;
        }
        ret.emplace_back(i, tmp);
    }
    if(n != 1) {
        ret.emplace_back(n, 1);
    }
    return ret;
}
}

/**
 * @brief 素因数分解
 */