---
data:
  _extendedDependsOn:
  - icon: ':warning:'
    path: atcoder/internal_math.hpp
    title: atcoder/internal_math.hpp
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':warning:'
  attributes:
    links: []
  bundledCode: "#line 1 \"atcoder/math.hpp\"\n\n\n\n#include <algorithm>\n#include\
    \ <cassert>\n#include <tuple>\n#include <vector>\n#include <atcoder/internal_math>\n\
    \nnamespace atcoder {\n\nlong long pow_mod(long long x, long long n, int m) {\n\
    \    assert(0 <= n && 1 <= m);\n    if (m == 1) return 0;\n    internal::barrett\
    \ bt((unsigned int)(m));\n    unsigned int r = 1, y = (unsigned int)(internal::safe_mod(x,\
    \ m));\n    while (n) {\n        if (n & 1) r = bt.mul(r, y);\n        y = bt.mul(y,\
    \ y);\n        n >>= 1;\n    }\n    return r;\n}\n\nlong long inv_mod(long long\
    \ x, long long m) {\n    assert(1 <= m);\n    auto z = internal::inv_gcd(x, m);\n\
    \    assert(z.first == 1);\n    return z.second;\n}\n\n// (rem, mod)\nstd::pair<long\
    \ long, long long> crt(const std::vector<long long>& r,\n                    \
    \                const std::vector<long long>& m) {\n    assert(r.size() == m.size());\n\
    \    int n = int(r.size());\n    // Contracts: 0 <= r0 < m0\n    long long r0\
    \ = 0, m0 = 1;\n    for (int i = 0; i < n; i++) {\n        assert(1 <= m[i]);\n\
    \        long long r1 = internal::safe_mod(r[i], m[i]), m1 = m[i];\n        if\
    \ (m0 < m1) {\n            std::swap(r0, r1);\n            std::swap(m0, m1);\n\
    \        }\n        if (m0 % m1 == 0) {\n            if (r0 % m1 != r1) return\
    \ {0, 0};\n            continue;\n        }\n        // assume: m0 > m1, lcm(m0,\
    \ m1) >= 2 * max(m0, m1)\n\n        // (r0, m0), (r1, m1) -> (r2, m2 = lcm(m0,\
    \ m1));\n        // r2 % m0 = r0\n        // r2 % m1 = r1\n        // -> (r0 +\
    \ x*m0) % m1 = r1\n        // -> x*u0*g % (u1*g) = (r1 - r0) (u0*g = m0, u1*g\
    \ = m1)\n        // -> x = (r1 - r0) / g * inv(u0) (mod u1)\n\n        // im =\
    \ inv(u0) (mod u1) (0 <= im < u1)\n        long long g, im;\n        std::tie(g,\
    \ im) = internal::inv_gcd(m0, m1);\n\n        long long u1 = (m1 / g);\n     \
    \   // |r1 - r0| < (m0 + m1) <= lcm(m0, m1)\n        if ((r1 - r0) % g) return\
    \ {0, 0};\n\n        // u1 * u1 <= m1 * m1 / g / g <= m0 * m1 / g = lcm(m0, m1)\n\
    \        long long x = (r1 - r0) / g % u1 * im % u1;\n\n        // |r0| + |m0\
    \ * x|\n        // < m0 + m0 * (u1 - 1)\n        // = m0 + m0 * m1 / g - m0\n\
    \        // = lcm(m0, m1)\n        r0 += x * m0;\n        m0 *= u1;  // -> lcm(m0,\
    \ m1)\n        if (r0 < 0) r0 += m0;\n    }\n    return {r0, m0};\n}\n\nlong long\
    \ floor_sum(long long n, long long m, long long a, long long b) {\n    long long\
    \ ans = 0;\n    if (a >= m) {\n        ans += (n - 1) * n * (a / m) / 2;\n   \
    \     a %= m;\n    }\n    if (b >= m) {\n        ans += n * (b / m);\n       \
    \ b %= m;\n    }\n\n    long long y_max = (a * n + b) / m, x_max = (y_max * m\
    \ - b);\n    if (y_max == 0) return ans;\n    ans += (n - (x_max + a - 1) / a)\
    \ * y_max;\n    ans += floor_sum(y_max, a, m, (a - x_max % a) % a);\n    return\
    \ ans;\n}\n\n}  // namespace atcoder\n\n\n"
  code: "#ifndef ATCODER_MATH_HPP\n#define ATCODER_MATH_HPP 1\n\n#include <algorithm>\n\
    #include <cassert>\n#include <tuple>\n#include <vector>\n#include <atcoder/internal_math>\n\
    \nnamespace atcoder {\n\nlong long pow_mod(long long x, long long n, int m) {\n\
    \    assert(0 <= n && 1 <= m);\n    if (m == 1) return 0;\n    internal::barrett\
    \ bt((unsigned int)(m));\n    unsigned int r = 1, y = (unsigned int)(internal::safe_mod(x,\
    \ m));\n    while (n) {\n        if (n & 1) r = bt.mul(r, y);\n        y = bt.mul(y,\
    \ y);\n        n >>= 1;\n    }\n    return r;\n}\n\nlong long inv_mod(long long\
    \ x, long long m) {\n    assert(1 <= m);\n    auto z = internal::inv_gcd(x, m);\n\
    \    assert(z.first == 1);\n    return z.second;\n}\n\n// (rem, mod)\nstd::pair<long\
    \ long, long long> crt(const std::vector<long long>& r,\n                    \
    \                const std::vector<long long>& m) {\n    assert(r.size() == m.size());\n\
    \    int n = int(r.size());\n    // Contracts: 0 <= r0 < m0\n    long long r0\
    \ = 0, m0 = 1;\n    for (int i = 0; i < n; i++) {\n        assert(1 <= m[i]);\n\
    \        long long r1 = internal::safe_mod(r[i], m[i]), m1 = m[i];\n        if\
    \ (m0 < m1) {\n            std::swap(r0, r1);\n            std::swap(m0, m1);\n\
    \        }\n        if (m0 % m1 == 0) {\n            if (r0 % m1 != r1) return\
    \ {0, 0};\n            continue;\n        }\n        // assume: m0 > m1, lcm(m0,\
    \ m1) >= 2 * max(m0, m1)\n\n        // (r0, m0), (r1, m1) -> (r2, m2 = lcm(m0,\
    \ m1));\n        // r2 % m0 = r0\n        // r2 % m1 = r1\n        // -> (r0 +\
    \ x*m0) % m1 = r1\n        // -> x*u0*g % (u1*g) = (r1 - r0) (u0*g = m0, u1*g\
    \ = m1)\n        // -> x = (r1 - r0) / g * inv(u0) (mod u1)\n\n        // im =\
    \ inv(u0) (mod u1) (0 <= im < u1)\n        long long g, im;\n        std::tie(g,\
    \ im) = internal::inv_gcd(m0, m1);\n\n        long long u1 = (m1 / g);\n     \
    \   // |r1 - r0| < (m0 + m1) <= lcm(m0, m1)\n        if ((r1 - r0) % g) return\
    \ {0, 0};\n\n        // u1 * u1 <= m1 * m1 / g / g <= m0 * m1 / g = lcm(m0, m1)\n\
    \        long long x = (r1 - r0) / g % u1 * im % u1;\n\n        // |r0| + |m0\
    \ * x|\n        // < m0 + m0 * (u1 - 1)\n        // = m0 + m0 * m1 / g - m0\n\
    \        // = lcm(m0, m1)\n        r0 += x * m0;\n        m0 *= u1;  // -> lcm(m0,\
    \ m1)\n        if (r0 < 0) r0 += m0;\n    }\n    return {r0, m0};\n}\n\nlong long\
    \ floor_sum(long long n, long long m, long long a, long long b) {\n    long long\
    \ ans = 0;\n    if (a >= m) {\n        ans += (n - 1) * n * (a / m) / 2;\n   \
    \     a %= m;\n    }\n    if (b >= m) {\n        ans += n * (b / m);\n       \
    \ b %= m;\n    }\n\n    long long y_max = (a * n + b) / m, x_max = (y_max * m\
    \ - b);\n    if (y_max == 0) return ans;\n    ans += (n - (x_max + a - 1) / a)\
    \ * y_max;\n    ans += floor_sum(y_max, a, m, (a - x_max % a) % a);\n    return\
    \ ans;\n}\n\n}  // namespace atcoder\n\n#endif  // ATCODER_MATH_HPP\n"
  dependsOn:
  - atcoder/internal_math.hpp
  isVerificationFile: false
  path: atcoder/math.hpp
  requiredBy: []
  timestamp: '2023-08-28 16:35:37+09:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: atcoder/math.hpp
layout: document
redirect_from:
- /library/atcoder/math.hpp
- /library/atcoder/math.hpp.html
title: atcoder/math.hpp
---
