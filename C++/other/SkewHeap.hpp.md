---
data:
  _extendedDependsOn: []
  _extendedRequiredBy:
  - icon: ':heavy_check_mark:'
    path: C++/graph/mst/directed.hpp
    title: Directed MST
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: test/directed.test.cpp
    title: test/directed.test.cpp
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    document_title: SkewHeap
    links:
    - https://ei1333.github.io/library/structure/heap/skew-heap.hpp
  bundledCode: "#line 2 \"C++/other/SkewHeap.hpp\"\n\n#pragma GCC diagnostic ignored\
    \ \"-Wreorder\"\n\n#include <cassert>\n#include <algorithm>\ntemplate <bool is_min\
    \ = true> struct SkewHeap {\n    struct Node {\n        long long key, lazy;\n\
    \        Node *l, *r;\n        int idx;\n        explicit Node(const long long\
    \ &key, const int idx): key(key), idx(idx), lazy(0), l(nullptr), r(nullptr){}\n\
    \    };\nprivate:\n    Node *alloc(const long long &key, int idx = -1) {\n   \
    \     return new Node(key, idx);\n    }\n    Node *propagate(Node *t) {\n    \
    \    if(t && t -> lazy != 0) {\n            if(t -> l) {\n                t ->\
    \ l -> lazy += t -> lazy;\n            }\n            if(t -> r) {\n         \
    \       t -> r -> lazy += t -> lazy;\n            }\n            t -> key += t\
    \ -> lazy;\n            t -> lazy = 0;\n        }\n        return t;\n    }\n\
    public:\n    SkewHeap(){}\n    Node *meld(Node *x, Node *y) {\n        propagate(x),\
    \ propagate(y);\n        if(!x || !y) {\n            return x ? x : y;\n     \
    \   }\n        if((x -> key < y -> key) ^ is_min) {\n            std::swap(x,\
    \ y);\n        }\n        x -> r = meld(y, x -> r);\n        std::swap(x -> l,\
    \ x -> r);\n        return x;\n    }\n    Node *push(Node *t, const long long\
    \ &key, int idx = -1){ return meld(t, alloc(key, idx)); }\n    Node *pop(Node\
    \ *t) {\n        assert(t);\n        return meld(t -> l, t -> r);\n    }\n   \
    \ Node *add(Node *t, const long long &lazy) {\n        if(t) {\n            t\
    \ -> lazy += lazy;\n            propagate(t);\n        }\n        return t;\n\
    \    }\n};\n\n/**\n * @brief SkewHeap\n * @see https://ei1333.github.io/library/structure/heap/skew-heap.hpp\n\
    \ */\n"
  code: "#pragma once\n\n#pragma GCC diagnostic ignored \"-Wreorder\"\n\n#include\
    \ <cassert>\n#include <algorithm>\ntemplate <bool is_min = true> struct SkewHeap\
    \ {\n    struct Node {\n        long long key, lazy;\n        Node *l, *r;\n \
    \       int idx;\n        explicit Node(const long long &key, const int idx):\
    \ key(key), idx(idx), lazy(0), l(nullptr), r(nullptr){}\n    };\nprivate:\n  \
    \  Node *alloc(const long long &key, int idx = -1) {\n        return new Node(key,\
    \ idx);\n    }\n    Node *propagate(Node *t) {\n        if(t && t -> lazy != 0)\
    \ {\n            if(t -> l) {\n                t -> l -> lazy += t -> lazy;\n\
    \            }\n            if(t -> r) {\n                t -> r -> lazy += t\
    \ -> lazy;\n            }\n            t -> key += t -> lazy;\n            t ->\
    \ lazy = 0;\n        }\n        return t;\n    }\npublic:\n    SkewHeap(){}\n\
    \    Node *meld(Node *x, Node *y) {\n        propagate(x), propagate(y);\n   \
    \     if(!x || !y) {\n            return x ? x : y;\n        }\n        if((x\
    \ -> key < y -> key) ^ is_min) {\n            std::swap(x, y);\n        }\n  \
    \      x -> r = meld(y, x -> r);\n        std::swap(x -> l, x -> r);\n       \
    \ return x;\n    }\n    Node *push(Node *t, const long long &key, int idx = -1){\
    \ return meld(t, alloc(key, idx)); }\n    Node *pop(Node *t) {\n        assert(t);\n\
    \        return meld(t -> l, t -> r);\n    }\n    Node *add(Node *t, const long\
    \ long &lazy) {\n        if(t) {\n            t -> lazy += lazy;\n           \
    \ propagate(t);\n        }\n        return t;\n    }\n};\n\n/**\n * @brief SkewHeap\n\
    \ * @see https://ei1333.github.io/library/structure/heap/skew-heap.hpp\n */"
  dependsOn: []
  isVerificationFile: false
  path: C++/other/SkewHeap.hpp
  requiredBy:
  - C++/graph/mst/directed.hpp
  timestamp: '2024-03-09 13:04:52+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - test/directed.test.cpp
documentation_of: C++/other/SkewHeap.hpp
layout: document
redirect_from:
- /library/C++/other/SkewHeap.hpp
- /library/C++/other/SkewHeap.hpp.html
title: SkewHeap
---
