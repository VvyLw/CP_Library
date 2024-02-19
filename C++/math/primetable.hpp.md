---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':warning:'
  attributes:
    document_title: Sieve of Eratosthenes
    links: []
  bundledCode: "Traceback (most recent call last):\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus.py\"\
    , line 187, in bundle\n    bundler.update(path)\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus_bundle.py\"\
    , line 401, in update\n    self.update(self._resolve(pathlib.Path(included), included_from=path))\n\
    \  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus_bundle.py\"\
    , line 260, in _resolve\n    raise BundleErrorAt(path, -1, \"no such header\"\
    )\nonlinejudge_verify.languages.cplusplus_bundle.BundleErrorAt: myvector.hpp:\
    \ line -1: no such header\n"
  code: "#pragma once\n\n#include \"myvector.hpp\"\nnamespace Heileden {\nstruct p_table\
    \ {\n    vectors::vb SoE;\n    p_table(const int n): SoE(n+1,1){\n        SoE[0]=SoE[1]=0;\n\
    \        for(int64_t i = 2; i <= n; ++i) {\n            if(!SoE[i]) continue;\n\
    \            for(int64_t j = i * i; j <= n; j += i) SoE[j] = 0;\n        }\n \
    \   }\n    vectors::vi get() {\n        vectors::vi p;\n        for(size_t i =\
    \ 2; i < SoE.size(); ++i) if(SoE[i]) p.emplace_back(i);\n        return p;\n \
    \   }\n};\n}\n\n/**\n * @brief Sieve of Eratosthenes\n */"
  dependsOn: []
  isVerificationFile: false
  path: C++/math/primetable.hpp
  requiredBy: []
  timestamp: '1970-01-01 00:00:00+00:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: C++/math/primetable.hpp
layout: document
redirect_from:
- /library/C++/math/primetable.hpp
- /library/C++/math/primetable.hpp.html
title: Sieve of Eratosthenes
---
