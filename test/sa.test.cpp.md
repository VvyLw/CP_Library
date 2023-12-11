---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: C++/Strings.hpp
    title: C++/Strings.hpp
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: cpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    '*NOT_SPECIAL_COMMENTS*': ''
    PROBLEM: https://judge.yosupo.jp/problem/suffixarray
    links:
    - https://judge.yosupo.jp/problem/suffixarray
  bundledCode: "#line 1 \"test/sa.test.cpp\"\n#define PROBLEM \"https://judge.yosupo.jp/problem/suffixarray\"\
    \n#line 2 \"C++/Strings.hpp\"\n#include <iostream>\n#include <cassert>\n#include\
    \ <vector>\n#include <algorithm>\n#include <numeric>\n#include <chrono>\ntypedef\
    \ long long ll;\ntypedef unsigned long long ul;\ntypedef __uint128_t u128;\n\n\
    std::vector<int> manacher(std::string s, const bool calc_even = true) {\n    int\
    \ n = s.size();\n    if(calc_even) {\n        assert(n > 0);\n        s.resize(2\
    \ * n - 1);\n        for(int i = n; --i >= 0;) {\n            s[2 * i] = s[i];\n\
    \        }\n        const auto d = *std::min_element(s.begin(), s.end());\n  \
    \      for(int i = 0; i < n - 1; ++i) {\n            s[2 * i + 1] = d;\n     \
    \   }\n    }\n    n = s.size();\n    std::vector<int> rad(n);\n    for(int i =\
    \ 0, j = 0; i < n;) {\n        while(i - j >= 0 && i + j < n && s[i - j] == s[i\
    \ + j]) {\n            ++j;\n        }\n        rad[i] = j;\n        int k = 1;\n\
    \        while(i - k >= 0 && i + k < n && k + rad[i - k] < j) {\n            rad[i\
    \ + k] = rad[i - k];\n            ++k;\n        }\n        i += k, j -= k;\n \
    \   }\n    if(calc_even) {\n        for(int i = 0; i < n; ++i) {\n           \
    \ if(((i ^ rad[i]) & 1) == 0) {\n                rad[i]--;\n            }\n  \
    \      }\n    }\n    else {\n        for(auto &x: rad) x = 2 * x - 1;\n    }\n\
    \    return rad;\n}\n\nstd::vector<ll> zalg(const std::string &s) {\n    const\
    \ ll n = s.size();\n    ll j = 0;\n    std::vector<ll> pre(n);\n    for(ll i =\
    \ 1; i < n; ++i) {\n        if(i + pre[i - j] < j + pre[j]) pre[i] = pre[i - j];\n\
    \        else {\n            ll k = std::max(0LL, j + pre[j] - i);\n         \
    \   while(i + k < n && s[k] == s[i + k]) ++k;\n            pre[i] = k;\n     \
    \       j = i;\n        }\n    }\n    pre.front() = n;\n    return pre;\n}\n\n\
    // inspired by ei1333( https://ei1333.github.io/library/string/suffix-array.hpp\
    \ )\nstruct SuffixArray : std::vector<int> {\nprivate:\n    std::vector<int> sa_is(const\
    \ std::vector<int> &s) const {\n    const int n = s.size();\n    std::vector<int>\
    \ ret(n), is_s(n), is_lms(n);;\n    int m = 0;\n    for(int i = n - 2; i >= 0;\
    \ i--) {\n      is_s[i] = (s[i] > s[i + 1]) || (s[i] == s[i + 1] && is_s[i + 1]);\n\
    \      m += is_lms[i + 1] = is_s[i] && !is_s[i + 1];\n    }\n    const auto induced_sort\
    \ = [&](const std::vector<int> &lms) -> void {\n      const int upper = *std::max_element(s.begin(),\
    \ s.end());\n      std::vector<int> l(upper + 2), r(upper + 2);\n      for(const\
    \ auto &v: s) {\n        ++l[v + 1];\n        ++r[v];\n      }\n      std::partial_sum(l.begin(),\
    \ l.end(), l.begin());\n      std::partial_sum(r.begin(), r.end(), r.begin());\n\
    \      ret.assign(ret.size(), -1);\n      for(int i = std::ssize(lms); --i >=\
    \ 0;) {\n        ret[--r[s[lms[i]]]] = lms[i];\n      }\n      for(const auto\
    \ &v: ret) {\n        if(v >= 1 && is_s[v - 1]) {\n          ret[l[s[v - 1]]++]\
    \ = v - 1;\n        }\n      }\n      r.assign(r.size(), 0);\n      for(const\
    \ auto &v: s) {\n        ++r[v];\n      }\n      std::partial_sum(r.begin(), r.end(),\
    \ r.begin());\n      for(int k = std::ssize(ret) - 1, i = ret[k]; k >= 1; i =\
    \ ret[--k]) {\n        if(i >= 1 && !is_s[i - 1]) {\n          ret[--r[s[i - 1]]]\
    \ = i - 1;\n        }\n      }\n    };\n    std::vector<int> lms, new_lms;\n \
    \   lms.reserve(m);\n    for(int i = 0; ++i < n;) {\n      if(is_lms[i]) {\n \
    \       lms.emplace_back(i);\n      }\n    }\n    induced_sort(lms);\n    new_lms.reserve(m);\n\
    \    for(int i = 0; i < n; ++i) {\n      if(!is_s[ret[i]] && ret[i] > 0 && is_s[ret[i]\
    \ - 1]) {\n        new_lms.emplace_back(ret[i]);\n      }\n    }\n    const auto\
    \ same = [&](int a, int b) -> bool {\n      if(s[a++] != s[b++]) {\n        return\
    \ false;\n      }\n      while(1) {\n        if(s[a] != s[b]) {\n          return\
    \ false;\n        }\n        if(is_lms[a] || is_lms[b]) {\n          return is_lms[a]\
    \ && is_lms[b];\n        }\n        a++, b++;\n      }\n    };\n    int rank =\
    \ 0;\n    ret[n - 1] = 0;\n    for(int i = 0; ++i < m;) {\n      if(!same(new_lms[i\
    \ - 1], new_lms[i])) {\n        ++rank;\n      }\n      ret[new_lms[i]] = rank;\n\
    \    }\n    if(rank + 1 < m) {\n      std::vector<int> new_s(m);\n      for(int\
    \ i = 0; i < m; ++i) {\n        new_s[i] = ret[lms[i]];\n      }\n      const\
    \ auto lms_sa = sa_is(new_s);\n      for(int i = 0; i < m; ++i) {\n        new_lms[i]\
    \ = lms[lms_sa[i]];\n      }\n    }\n    induced_sort(new_lms);\n    return ret;\n\
    \  }\npublic:\n  std::string vs;\n  explicit SuffixArray(const std::string &vs,\
    \ bool compress = false): vs(vs) {\n    std::vector<int> new_vs(vs.size() + 1);\n\
    \    if(compress) {\n      std::string xs = vs;\n      std::sort(xs.begin(), xs.end());\n\
    \      xs.erase(std::unique(xs.begin(), xs.end()), xs.end());\n      for(size_t\
    \ i = 0; i < vs.size(); ++i) {\n        new_vs[i] = std::lower_bound(xs.begin(),\
    \ xs.end(), vs[i]) - xs.begin() + 1;\n      }\n    }\n    else {\n      const\
    \ auto d = *std::min_element(vs.begin(), vs.end());\n      for(size_t i = 0; i\
    \ < vs.size(); ++i) {\n        new_vs[i] = vs[i] - d + 1;\n      }\n    }\n  \
    \  const auto ret = sa_is(new_vs);\n    assign(ret.begin(), ret.end());\n  }\n\
    \  void output() const {\n    for(size_t i = 0; i < size(); ++i) {\n      std::cout\
    \ << i << \":[\" << (*this)[i] << \"]\";\n      for(size_t j = (*this)[i]; j <\
    \ vs.size(); ++j) {\n        std::cout << \" \" << vs[j];\n      }\n      std::cout\
    \ << \"\\n\";\n    }\n  }\n  bool lt_substr(const std::string &t, int si = 0,\
    \ int ti = 0) {\n    const int sn = vs.size(), tn = t.size();\n    while(si <\
    \ sn && ti < tn) {\n      if(vs[si] < t[ti]) {\n        return true;\n      }\n\
    \      if(vs[si] > t[ti]) {\n        return false;\n      }\n      ++si, ++ti;\n\
    \    }\n    return si >= sn && ti < tn;\n  }\n  int lower_bound(const std::string\
    \ &t) {\n    int ng = 0, ok = size();\n    while(ok - ng > 1) {\n      const int\
    \ mid = (ok + ng) / 2;\n      (lt_substr(t, (*this)[mid]) ? ng : ok) = mid;\n\
    \    }\n    return ok;\n  }\n  std::pair<int, int> equal_range(std::string t)\
    \ {\n    const int low = lower_bound(t);\n    int ng = low - 1, ok = size();\n\
    \    t.back()++;\n    while(ok - ng > 1) {\n      int mid = (ok + ng) / 2;\n \
    \     (lt_substr(t, (*this)[mid]) ? ng : ok) = mid;\n    }\n    t.back()--;\n\
    \    return {low, ok};\n  }\n  std::vector<int> lcp_array() const {\n    const\
    \ int n = size() - 1;\n    std::vector<int> lcp(n + 1), rank(n + 1);\n    for(int\
    \ i = 0; i <= n; ++i) {\n      rank[(*this)[i]] = i;\n    }\n    int h = 0;\n\
    \    for(int i = 0; i <= n; ++i) {\n      if(rank[i] < n) {\n        const int\
    \ j = (*this)[rank[i] + 1];\n        for(; j + h < n && i + h < n; ++h) {\n  \
    \        if(vs[j + h] != vs[i + h]) {\n            break;\n          }\n     \
    \   }\n        lcp[rank[i] + 1] = h;\n        if(h > 0) {\n          h--;\n  \
    \      }\n      }\n    }\n    return lcp;\n  }\n};\n\n// inspired by tatyam( https://github.com/tatyam-prime/kyopro_library/blob/master/RollingHash.cpp\
    \ )\nconst ul LINF = (1LL << 61) - 1, base = std::chrono::duration_cast<std::chrono::microseconds>(std::chrono::system_clock::now().time_since_epoch()).count()\
    \ % LINF;\ntemplate <ul mod> struct RollingHash {\nprivate:\n    std::vector<ul>\
    \ hashed, power;\n    static constexpr ul mask(const ll a){ return (1ULL << a)\
    \ - 1; }\n    inline ul mul(const ul a, const ul b) const {\n        u128 ans\
    \ = u128(a) * b;\n        ans = (ans >> 61) + (ans & mod);\n        if(ans >=\
    \ mod) ans -= mod;\n        return ans;\n    }\npublic:\n    RollingHash(const\
    \ std::string &s) {\n        const ll n = s.size();\n        hashed.resize(n +\
    \ 1);\n        power.resize(n + 1);\n        power[0] = 1;\n        for(ll i =\
    \ 0; i < n; ++i) {\n            power[i + 1] = mul(power[i], base);\n        \
    \    hashed[i + 1] = mul(hashed[i], base) + s[i];\n            if(hashed[i + 1]\
    \ >= mod) hashed[i + 1] -= mod;\n        }\n    }\n    ul get(const ll l, const\
    \ ll r) const {\n        ul ret = hashed[r] + mod - mul(hashed[l], power[r - l]);\n\
    \        if(ret >= mod) ret -= mod;\n        return ret;\n    }\n    ul connect(const\
    \ ul h1, const ul h2, const ll h2len) const {\n        ul ret = mul(h1, power[h2len])\
    \ + h2;\n        if(ret >= mod) ret -= mod;\n        return ret;\n    }\n    ll\
    \ LCP(const RollingHash &b, ll l1, ll r1, ll l2, ll r2) {\n        ll low = -1,\
    \ high = std::min(r1 - l1, r2 - l2) + 1;\n        while(high - low > 1) {\n  \
    \          const ll mid = (low + high) / 2;\n            if(get(l1, l1 + mid)\
    \ == b.get(l2, l2 + mid)) low = mid;\n            else high = mid;\n        }\n\
    \        return low;\n    }\n};\nusing RH = RollingHash<LINF>;\n#line 3 \"test/sa.test.cpp\"\
    \nint main() {\n    std::string s;\n    std::cin >> s;\n    SuffixArray sa(s);\n\
    \    sa.erase(sa.begin());\n    for(size_t i = 0; i < sa.size(); ++i) {\n    \
    \    std::cout << sa[i] << \" \\n\"[i + 1 == sa.size()];\n    }\n}\n"
  code: "#define PROBLEM \"https://judge.yosupo.jp/problem/suffixarray\"\n#include\
    \ \"C++/Strings.hpp\"\nint main() {\n    std::string s;\n    std::cin >> s;\n\
    \    SuffixArray sa(s);\n    sa.erase(sa.begin());\n    for(size_t i = 0; i <\
    \ sa.size(); ++i) {\n        std::cout << sa[i] << \" \\n\"[i + 1 == sa.size()];\n\
    \    }\n}"
  dependsOn:
  - C++/Strings.hpp
  isVerificationFile: true
  path: test/sa.test.cpp
  requiredBy: []
  timestamp: '2023-12-11 21:08:07+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: test/sa.test.cpp
layout: document
redirect_from:
- /verify/test/sa.test.cpp
- /verify/test/sa.test.cpp.html
title: test/sa.test.cpp
---
