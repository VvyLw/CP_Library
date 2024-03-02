---
data:
  _extendedDependsOn:
  - icon: ':question:'
    path: C++/math/kthrooti.hpp
    title: "k\u4E57\u6839(\u6574\u6570)"
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: true
  _pathExtension: cpp
  _verificationStatusIcon: ':x:'
  attributes:
    '*NOT_SPECIAL_COMMENTS*': ''
    PROBLEM: https://judge.yosupo.jp/problem/kth_root_integer
    links:
    - https://judge.yosupo.jp/problem/kth_root_integer
  bundledCode: "#line 1 \"test/kthrooti.test.cpp\"\n#define PROBLEM \"https://judge.yosupo.jp/problem/kth_root_integer\"\
    \n#include <iostream>\n#line 2 \"C++/math/kthrooti.hpp\"\n\n#include <limits>\n\
    #ifndef TEMPLATE\ntypedef unsigned long long ul;\ntemplate <class T, class U>\
    \ inline bool overflow_if_mul(const T a, const U b){ return (std::numeric_limits<T>::max()/a)<b;\
    \ }\n#endif\nnamespace Heileden {\ninline ul kthrooti(const ul n, const int k)\
    \ {\n    if(k==1) {\n\t\treturn n;\n\t}\n\tconst auto chk=[&](const unsigned x)\
    \ {\n\t\tul mul=1;\n\t\tfor(int i = 0; i < k; ++i) {\n            if(overflow_if_mul(mul,\
    \ x)) {\n                return false;\n            }\n            mul*=x;\n \
    \       }\n\t\treturn mul<=n;\n\t};\n\tul ret=0;\n\tfor(int i = 32; --i >= 0;)\
    \ {\n\t\tif(chk(ret|(1U<<i))) {\n\t\t\tret|=1U<<i;\n\t\t}\n\t}\n\treturn ret;\n\
    }\n}\n\n/**\n * @brief k\u4E57\u6839(\u6574\u6570)\n */\n#line 4 \"test/kthrooti.test.cpp\"\
    \nvoid solve() {\n    ul a;\n    int k;\n    std::cin >> a >> k;\n    std::cout\
    \ << Heileden::kthrooti(a, k) << '\\n';\n}\nint main() {\n    std::cin.tie(nullptr)\
    \ -> sync_with_stdio(false);\n    int t;\n    std::cin >> t;\n    while(t--) {\n\
    \        solve();\n    }\n}\n"
  code: "#define PROBLEM \"https://judge.yosupo.jp/problem/kth_root_integer\"\n#include\
    \ <iostream>\n#include \"C++/math/kthrooti.hpp\"\nvoid solve() {\n    ul a;\n\
    \    int k;\n    std::cin >> a >> k;\n    std::cout << Heileden::kthrooti(a, k)\
    \ << '\\n';\n}\nint main() {\n    std::cin.tie(nullptr) -> sync_with_stdio(false);\n\
    \    int t;\n    std::cin >> t;\n    while(t--) {\n        solve();\n    }\n}"
  dependsOn:
  - C++/math/kthrooti.hpp
  isVerificationFile: true
  path: test/kthrooti.test.cpp
  requiredBy: []
  timestamp: '2024-03-02 19:57:59+09:00'
  verificationStatus: TEST_WRONG_ANSWER
  verifiedWith: []
documentation_of: test/kthrooti.test.cpp
layout: document
redirect_from:
- /verify/test/kthrooti.test.cpp
- /verify/test/kthrooti.test.cpp.html
title: test/kthrooti.test.cpp
---
