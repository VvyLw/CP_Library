#pragma once

#include "math/euler_phi.hpp"
#ifndef TEMPLATE
namespace zia_qu {
template <class T> inline T pow(T a, T b, const T mod=0) {
	T res=1;
	if(mod) {
		res%=mod;
		a%=mod;
	}
	while(b>0) {
		if(b&1) res*=a;
		if(mod) res%=mod;
		a*=a;
		if(mod) a%=mod;
		b>>=1;
	}
	return res;
}
}
#endif
template <class T> inline T tetration(const T a, const T b, const T m) {
    if(m == 1) {
        return 0;
    }
    if(a == 0) {
        return (b & 1) ? 0 : 1;
    }
    if(b == 0) {
        return 1;
    }
    if(b == 1) {
        return a % m;
    }
    if(b == 2) {
        return zia_qu::pow(a, a, m);
    }
    const auto phi = euler_phi(m);
    auto tmp = tetration(a, b - 1, phi);
    if(!tmp) {
        tmp += phi;
    }
    return zia_qu::pow(a, tmp, m);
}

/**
 * @brief Tetration(a↑↑b)
 */