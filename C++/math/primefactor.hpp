#pragma once

#include "mypair.hpp"
#ifndef TEMPLATE
#define sqrp(i,a,b) for(long long i = (a); i * i <= (b); ++i)
#endif
namespace Heileden {
template <class T> inline vectors::V<pairs::PP<T>> prmfct(T n) {
    vectors::V<pairs::PP<T>> res;
    for(T i = 2; i * i <= n; ++i) {
        if(n%i!=0) continue;
        T tmp=0;
        while(n%i==0) {
            tmp++;
            n/=i;
        }
        res.emplace_back(i,tmp);
    }
    if(n!=1) res.emplace_back(n,1);
    return res;
}
}

/**
 * @brief 素因数分解
 */