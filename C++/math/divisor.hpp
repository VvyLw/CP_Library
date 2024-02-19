#pragma once

#include <algorithm>
#include "myvector.hpp"
#ifndef TEMPLATE
#endif
namespace Heileden {
template <class T> inline vectors::V<T> div(const T n) {
    vectors::V<T> d;
    for(long long i = 1; i * i <= n; ++i) {
        if(n%i==0) {
            d.emplace_back(i);
            if(i*i!=n) d.emplace_back(n/i);
        }
    }
    std::sort(d.begin(), d.end());
    return d;
}
}

/**
 * @brief 約数列挙
 */