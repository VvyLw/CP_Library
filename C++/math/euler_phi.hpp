#pragma once
template <class T> inline T euler_phi(T n) {
	T res = n;
	for(T i = 2; i * i <= n; ++i) {
	    if(n % i == 0) {
			res -= res / i;
			while(n % i == 0) {
				n /= i;
			}
		}
	}
	if(n > 1) {
		res -= res / n;
	}
	return res;
}

/**
 * @brief Euler's Phi-function
 */