---
data:
  _extendedDependsOn:
  - icon: ':warning:'
    path: atcoder/internal_scc.hpp
    title: atcoder/internal_scc.hpp
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':warning:'
  attributes:
    links: []
  bundledCode: "#line 1 \"atcoder/twosat.hpp\"\n\n\n\n#include <atcoder/internal_scc>\n\
    #include <cassert>\n#include <vector>\n\nnamespace atcoder {\n\n// Reference:\n\
    // B. Aspvall, M. Plass, and R. Tarjan,\n// A Linear-Time Algorithm for Testing\
    \ the Truth of Certain Quantified Boolean\n// Formulas\nstruct two_sat {\n  public:\n\
    \    two_sat() : _n(0), scc(0) {}\n    two_sat(int n) : _n(n), _answer(n), scc(2\
    \ * n) {}\n\n    void add_clause(int i, bool f, int j, bool g) {\n        assert(0\
    \ <= i && i < _n);\n        assert(0 <= j && j < _n);\n        scc.add_edge(2\
    \ * i + (f ? 0 : 1), 2 * j + (g ? 1 : 0));\n        scc.add_edge(2 * j + (g ?\
    \ 0 : 1), 2 * i + (f ? 1 : 0));\n    }\n    bool satisfiable() {\n        auto\
    \ id = scc.scc_ids().second;\n        for (int i = 0; i < _n; i++) {\n       \
    \     if (id[2 * i] == id[2 * i + 1]) return false;\n            _answer[i] =\
    \ id[2 * i] < id[2 * i + 1];\n        }\n        return true;\n    }\n    std::vector<bool>\
    \ answer() { return _answer; }\n\n  private:\n    int _n;\n    std::vector<bool>\
    \ _answer;\n    internal::scc_graph scc;\n};\n\n}  // namespace atcoder\n\n\n"
  code: "#ifndef ATCODER_TWOSAT_HPP\n#define ATCODER_TWOSAT_HPP 1\n\n#include <atcoder/internal_scc>\n\
    #include <cassert>\n#include <vector>\n\nnamespace atcoder {\n\n// Reference:\n\
    // B. Aspvall, M. Plass, and R. Tarjan,\n// A Linear-Time Algorithm for Testing\
    \ the Truth of Certain Quantified Boolean\n// Formulas\nstruct two_sat {\n  public:\n\
    \    two_sat() : _n(0), scc(0) {}\n    two_sat(int n) : _n(n), _answer(n), scc(2\
    \ * n) {}\n\n    void add_clause(int i, bool f, int j, bool g) {\n        assert(0\
    \ <= i && i < _n);\n        assert(0 <= j && j < _n);\n        scc.add_edge(2\
    \ * i + (f ? 0 : 1), 2 * j + (g ? 1 : 0));\n        scc.add_edge(2 * j + (g ?\
    \ 0 : 1), 2 * i + (f ? 1 : 0));\n    }\n    bool satisfiable() {\n        auto\
    \ id = scc.scc_ids().second;\n        for (int i = 0; i < _n; i++) {\n       \
    \     if (id[2 * i] == id[2 * i + 1]) return false;\n            _answer[i] =\
    \ id[2 * i] < id[2 * i + 1];\n        }\n        return true;\n    }\n    std::vector<bool>\
    \ answer() { return _answer; }\n\n  private:\n    int _n;\n    std::vector<bool>\
    \ _answer;\n    internal::scc_graph scc;\n};\n\n}  // namespace atcoder\n\n#endif\
    \  // ATCODER_TWOSAT_HPP\n"
  dependsOn:
  - atcoder/internal_scc.hpp
  isVerificationFile: false
  path: atcoder/twosat.hpp
  requiredBy: []
  timestamp: '2023-08-28 16:35:37+09:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: atcoder/twosat.hpp
layout: document
redirect_from:
- /library/atcoder/twosat.hpp
- /library/atcoder/twosat.hpp.html
title: atcoder/twosat.hpp
---
