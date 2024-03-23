#pragma once

#include <cassert>
#include <numeric>
#include "C++/core/myvector.hpp"
namespace Heileden {
struct psum {
private:
    int n;
    bool not_built;
    vectors::vi s;
public:
    psum(const vectors::vi& v): s{0} { std::partial_sum(v.cbegin(), v.cend(), std::back_inserter(s)); }
    psum(const int n): n(n), not_built(true), s(n + 1){}
    vectors::vi get() const { return s; }
    // [l, r]
    ll sum(const int l, const int r) const { return s[r] - s[l]; }
    void add(const int l, const int r, const ll x) {
		assert(not_built);
		s[l] += x;
		s[r] -= x;
	}
    vectors::vi build() {
		assert(not_built);
        vectors::vi res;
		std::partial_sum(s.cbegin(), s.cend(), std::back_inserter(res));
		not_built = false;
        res.resize(n);
		return res;
	}
};
}

/**
 * @brief 累積和
 */