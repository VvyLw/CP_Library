#pragma once

#include <numeric>
#include "myvector.hpp"
namespace Heileden {
struct psum {
private:
    vectors::vi s;
public:
    psum(const vectors::vi& v): s{0} { std::partial_sum(v.begin(), v.end(), std::back_inserter(s)); }
    vectors::vi get() const { return s; }
    // [l, r]
    ll query(const int l, const int r) const { return s[r]-s[l]; }
};
}

/**
 * @brief 累積和
 */