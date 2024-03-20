#pragma once

#include <cassert>
#include <numeric>
#include "C++/core/myvector.hpp"
namespace Heileden {
struct psum {
private:
    int n;
    bool not_built;
    vectors::vi s, imos;
public:
    psum(const vectors::vi& v): s{0} { std::partial_sum(v.begin(), v.end(), std::back_inserter(s)); }
    psum(const int n): n(n), not_built(true), imos(n + 1){}
    vectors::vi get() const { return s; }
    // [l, r]
    ll sum(const int l, const int r) const { return s[r] - s[l]; }
    void add(const int l, const int r, const ll x = 1) {
		assert(not_built);
		imos[l] += x;
		imos[r] -= x;
	}
    vectors::vi build() {
		assert(not_built);
        vectors::vi res;
		std::partial_sum(imos.begin(), imos.end(), std::back_inserter(res));
		not_built = false;
        res.resize(n);
		return res;
	}
};
}

/**
 * @brief 累積和
 */