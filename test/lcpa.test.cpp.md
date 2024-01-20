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
    PROBLEM: https://judge.yosupo.jp/problem/number_of_substrings
    links:
    - https://judge.yosupo.jp/problem/number_of_substrings
  bundledCode: "#line 1 \"test/lcpa.test.cpp\"\n#define PROBLEM \"https://judge.yosupo.jp/problem/number_of_substrings\"\
    \n#line 2 \"C++/Strings.hpp\"\n\n#include <iostream>\n#include <cassert>\n#include\
    \ <vector>\n#include <algorithm>\n#include <numeric>\n#include <chrono>\ntypedef\
    \ long long ll;\ntypedef unsigned long long ul;\ntypedef __uint128_t u128;\n\n\
    std::string rle(const std::string &s) {\n\tconst int n = s.size();\n\tstd::string\
    \ t;\n\tfor(int l = 0; l < n;) {\n\t\tint r = l + 1;\n\t\tfor(; r < n && s[l]\
    \ == s[r]; ++r){}\n\t\tt += s[l];\n\t\tt += std::to_string(r - l);\n\t\tl = r;\n\
    \t}\n\treturn t;\n}\n\nstd::string rle_rev(const std::string &s) {\n\tconst int\
    \ n = s.size();\n\tstd::string t;\n\tfor(int l = 0; l < n;) {\n\t\tint r = l +\
    \ 1;\n\t\tfor(; r < n && '0' <= s[r] && s[r] <= '9'; ++r){}\n\t\tt += std::string(std::stoi(s.substr(l\
    \ + 1, r - l)), s[l]);\n\t\tl = r;\n\t}\n\treturn t;\n}\n\nstd::vector<int> manacher(std::string\
    \ s, const bool calc_even = true) {\n    int n = s.size();\n    if(calc_even)\
    \ {\n        assert(n > 0);\n        s.resize(2 * n - 1);\n        for(int i =\
    \ n; --i >= 0;) {\n            s[2 * i] = s[i];\n        }\n        const auto\
    \ d = *std::min_element(s.begin(), s.end());\n        for(int i = 0; i < n - 1;\
    \ ++i) {\n            s[2 * i + 1] = d;\n        }\n    }\n    n = s.size();\n\
    \    std::vector<int> rad(n);\n    for(int i = 0, j = 0; i < n;) {\n        while(i\
    \ - j >= 0 && i + j < n && s[i - j] == s[i + j]) {\n            ++j;\n       \
    \ }\n        rad[i] = j;\n        int k = 1;\n        while(i - k >= 0 && i +\
    \ k < n && k + rad[i - k] < j) {\n            rad[i + k] = rad[i - k];\n     \
    \       ++k;\n        }\n        i += k, j -= k;\n    }\n    if(calc_even) {\n\
    \        for(int i = 0; i < n; ++i) {\n            if(((i ^ rad[i]) & 1) == 0)\
    \ {\n                rad[i]--;\n            }\n        }\n    }\n    else {\n\
    \        for(auto &x: rad) x = 2 * x - 1;\n    }\n    return rad;\n}\n\nstd::vector<ll>\
    \ zalg(const std::string &s) {\n    const ll n = s.size();\n    ll j = 0;\n  \
    \  std::vector<ll> pre(n);\n    for(ll i = 1; i < n; ++i) {\n        if(i + pre[i\
    \ - j] < j + pre[j]) pre[i] = pre[i - j];\n        else {\n            ll k =\
    \ std::max(0LL, j + pre[j] - i);\n            while(i + k < n && s[k] == s[i +\
    \ k]) ++k;\n            pre[i] = k;\n            j = i;\n        }\n    }\n  \
    \  pre.front() = n;\n    return pre;\n}\n\n// inspired by ei1333( https://ei1333.github.io/library/string/suffix-array.hpp\
    \ )\nstruct SuffixArray : std::vector<int> {\nprivate:\n    std::vector<int> sa_is(const\
    \ std::vector<int> &s) const {\n    \tconst int n = s.size();\n    \tstd::vector<int>\
    \ ret(n), is_s(n), is_lms(n);;\n    \tint m = 0;\n    \tfor(int i = n - 2; i >=\
    \ 0; i--) {\n      \t\tis_s[i] = (s[i] > s[i + 1]) || (s[i] == s[i + 1] && is_s[i\
    \ + 1]);\n      \t\tm += is_lms[i + 1] = is_s[i] && !is_s[i + 1];\n    \t}\n \
    \   \tconst auto induced_sort = [&](const std::vector<int> &lms) -> void {\n \
    \     \t\tconst int upper = *std::max_element(s.begin(), s.end());\n      \t\t\
    std::vector<int> l(upper + 2), r(upper + 2);\n\t\t\tfor(const auto &v: s) {\n\t\
    \t\t\t++l[v + 1];\n\t\t\t\t++r[v];\n\t\t\t}\n\t\t\tstd::partial_sum(l.begin(),\
    \ l.end(), l.begin());\n\t\t\tstd::partial_sum(r.begin(), r.end(), r.begin());\n\
    \t\t\tret.assign(ret.size(), -1);\n\t\t\tfor(int i = std::ssize(lms); --i >= 0;)\
    \ {\n\t\t\t\tret[--r[s[lms[i]]]] = lms[i];\n\t\t\t}\n\t\t\tfor(const auto &v:\
    \ ret) {\n\t\t\t\tif(v >= 1 && is_s[v - 1]) {\n\t\t\t\t\tret[l[s[v - 1]]++] =\
    \ v - 1;\n\t\t\t\t}\n\t\t\t}\n\t\t\tr.assign(r.size(), 0);\n\t\t\tfor(const auto\
    \ &v: s) {\n\t\t\t\t++r[v];\n\t\t\t}\n\t\t\tstd::partial_sum(r.begin(), r.end(),\
    \ r.begin());\n\t\t\tfor(int k = std::ssize(ret) - 1, i = ret[k]; k >= 1; i =\
    \ ret[--k]) {\n\t\t\t\tif(i >= 1 && !is_s[i - 1]) {\n\t\t\t\t\tret[--r[s[i - 1]]]\
    \ = i - 1;\n\t\t\t\t}\n\t\t\t}\n\t\t};\n\t\tstd::vector<int> lms, new_lms;\n\t\
    \tlms.reserve(m);\n\t\tfor(int i = 0; ++i < n;) {\n\t\t\tif(is_lms[i]) {\n\t\t\
    \t\tlms.emplace_back(i);\n\t\t\t}\n\t\t}\n\t\tinduced_sort(lms);\n\t\tnew_lms.reserve(m);\n\
    \t\tfor(int i = 0; i < n; ++i) {\n\t\t\tif(!is_s[ret[i]] && ret[i] > 0 && is_s[ret[i]\
    \ - 1]) {\n\t\t\t\tnew_lms.emplace_back(ret[i]);\n\t\t\t}\n\t\t}\n\t\tconst auto\
    \ same = [&](int a, int b) -> bool {\n\t\t\tif(s[a++] != s[b++]) {\n\t\t\t\treturn\
    \ false;\n\t\t\t}\n\t\t\twhile(1) {\n\t\t\t\tif(s[a] != s[b]) {\n\t\t\t\t\treturn\
    \ false;\n\t\t\t\t}\n\t\t\t\tif(is_lms[a] || is_lms[b]) {\n\t\t\t\t\treturn is_lms[a]\
    \ && is_lms[b];\n\t\t\t\t}\n\t\t\t\ta++, b++;\n\t\t\t}\n\t\t};\n\t\tint rank =\
    \ 0;\n\t\tret[n - 1] = 0;\n\t\tfor(int i = 0; ++i < m;) {\n\t\t\tif(!same(new_lms[i\
    \ - 1], new_lms[i])) {\n\t\t\t\t++rank;\n\t\t\t}\n\t\t\tret[new_lms[i]] = rank;\n\
    \t\t}\n\t\tif(rank + 1 < m) {\n\t\t\tstd::vector<int> new_s(m);\n\t\t\tfor(int\
    \ i = 0; i < m; ++i) {\n\t\t\t\tnew_s[i] = ret[lms[i]];\n\t\t\t}\n\t\t\tconst\
    \ auto lms_sa = sa_is(new_s);\n\t\t\tfor(int i = 0; i < m; ++i) {\n\t\t\t\tnew_lms[i]\
    \ = lms[lms_sa[i]];\n\t\t\t}\n\t\t}\n\t\tinduced_sort(new_lms);\n\t\treturn ret;\n\
    \t}\npublic:\n\tstd::string vs;\n\texplicit SuffixArray(const std::string &vs,\
    \ bool compress = false): vs(vs) {\n\t\tstd::vector<int> new_vs(vs.size() + 1);\n\
    \t\tif(compress) {\n\t\tstd::string xs = vs;\n\t\tstd::sort(xs.begin(), xs.end());\n\
    \t\txs.erase(std::unique(xs.begin(), xs.end()), xs.end());\n\t\tfor(size_t i =\
    \ 0; i < vs.size(); ++i) {\n\t\t\tnew_vs[i] = std::lower_bound(xs.begin(), xs.end(),\
    \ vs[i]) - xs.begin() + 1;\n\t\t}\n\t\t}\n\t\telse {\n\t\tconst auto d = *std::min_element(vs.begin(),\
    \ vs.end());\n\t\tfor(size_t i = 0; i < vs.size(); ++i) {\n\t\t\tnew_vs[i] = vs[i]\
    \ - d + 1;\n\t\t}\n\t\t}\n\t\tconst auto ret = sa_is(new_vs);\n\t\tassign(ret.begin(),\
    \ ret.end());\n\t}\n\tvoid output() const {\n\t\tfor(size_t i = 0; i < size();\
    \ ++i) {\n\t\tstd::cout << i << \":[\" << (*this)[i] << \"]\";\n\t\tfor(size_t\
    \ j = (*this)[i]; j < vs.size(); ++j) {\n\t\t\tstd::cout << \" \" << vs[j];\n\t\
    \t}\n\t\tstd::cout << \"\\n\";\n\t\t}\n\t}\n\tbool lt_substr(const std::string\
    \ &t, int si = 0, int ti = 0) {\n\t\tconst int sn = vs.size(), tn = t.size();\n\
    \t\twhile(si < sn && ti < tn) {\n\t\tif(vs[si] < t[ti]) {\n\t\t\treturn true;\n\
    \t\t}\n\t\tif(vs[si] > t[ti]) {\n\t\t\treturn false;\n\t\t}\n\t\t++si, ++ti;\n\
    \t\t}\n\t\treturn si >= sn && ti < tn;\n\t}\n\tint lower_bound(const std::string\
    \ &t) {\n\t\tint ng = 0, ok = size();\n\t\twhile(ok - ng > 1) {\n\t\tconst int\
    \ mid = (ok + ng) / 2;\n\t\t(lt_substr(t, (*this)[mid]) ? ng : ok) = mid;\n\t\t\
    }\n\t\treturn ok;\n\t}\n\tstd::pair<int, int> equal_range(std::string t) {\n\t\
    \tconst int low = lower_bound(t);\n\t\tint ng = low - 1, ok = size();\n\t\tt.back()++;\n\
    \t\twhile(ok - ng > 1) {\n\t\tint mid = (ok + ng) / 2;\n\t\t(lt_substr(t, (*this)[mid])\
    \ ? ng : ok) = mid;\n\t\t}\n\t\tt.back()--;\n\t\treturn {low, ok};\n\t}\n\tstd::vector<int>\
    \ lcp_array() const {\n\t\tconst int n = size() - 1;\n\t\tstd::vector<int> lcp(n\
    \ + 1), rank(n + 1);\n\t\tfor(int i = 0; i <= n; ++i) {\n\t\trank[(*this)[i]]\
    \ = i;\n\t\t}\n\t\tint h = 0;\n\t\tfor(int i = 0; i <= n; ++i) {\n\t\tif(rank[i]\
    \ < n) {\n\t\t\tconst int j = (*this)[rank[i] + 1];\n\t\t\tfor(; j + h < n &&\
    \ i + h < n; ++h) {\n\t\t\tif(vs[j + h] != vs[i + h]) {\n\t\t\t\tbreak;\n\t\t\t\
    }\n\t\t\t}\n\t\t\tlcp[rank[i] + 1] = h;\n\t\t\tif(h > 0) {\n\t\t\th--;\n\t\t\t\
    }\n\t\t}\n\t\t}\n\t\treturn lcp;\n\t}\n};\n\n// inspired by tatyam( https://github.com/tatyam-prime/kyopro_library/blob/master/RollingHash.cpp\
    \ )\n#ifndef TEMPLATE\nconst ul LINF = (1LL << 61) - 1;\n#endif\nconst ul base\
    \ = std::chrono::duration_cast<std::chrono::microseconds>(std::chrono::system_clock::now().time_since_epoch()).count()\
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
    \        return low;\n    }\n};\nusing RH = RollingHash<LINF>;\n#line 3 \"test/lcpa.test.cpp\"\
    \nint main() {\n    std::string s;\n    std::cin >> s;\n    SuffixArray sa(s);\n\
    \    const ll n = s.size();\n    const auto lcp = sa.lcp_array();\n    std::cout\
    \ << n * (n + 1) / 2 - std::accumulate(lcp.begin(), lcp.end(), 0LL) << '\\n';\n\
    }\n"
  code: "#define PROBLEM \"https://judge.yosupo.jp/problem/number_of_substrings\"\n\
    #include \"C++/Strings.hpp\"\nint main() {\n    std::string s;\n    std::cin >>\
    \ s;\n    SuffixArray sa(s);\n    const ll n = s.size();\n    const auto lcp =\
    \ sa.lcp_array();\n    std::cout << n * (n + 1) / 2 - std::accumulate(lcp.begin(),\
    \ lcp.end(), 0LL) << '\\n';\n}"
  dependsOn:
  - C++/Strings.hpp
  isVerificationFile: true
  path: test/lcpa.test.cpp
  requiredBy: []
  timestamp: '2024-01-20 23:48:40+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: test/lcpa.test.cpp
layout: document
redirect_from:
- /verify/test/lcpa.test.cpp
- /verify/test/lcpa.test.cpp.html
title: test/lcpa.test.cpp
---
