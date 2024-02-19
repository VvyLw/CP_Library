#pragma once

#include <limits>
#ifndef TEMPLATE
typedef unsigned long long ul;
template <class T, class U> inline bool overflow_if_mul(const T a, const U b){ return (std::numeric_limits<T>::max()/a)<b; }
#endif
namespace Heileden {
inline ul kthrooti(const ul n, const int k) {
    if(k==1) {
		return n;
	}
	const auto chk=[&](const unsigned x) {
		ul mul=1;
		for(int i = 0; i < k; ++i) {
            if(overflow_if_mul(mul, x)) {
                return false;
            }
            mul*=x;
        }
		return mul<=n;
	};
	ul ret=0;
	for(int i = 32; --i >= 0;) {
		if(chk(ret|(1U<<i))) {
			ret|=1U<<i;
		}
	}
	return ret;
}
}

/**
 * @brief k乗根(整数)
 */