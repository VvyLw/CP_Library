---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: C++/math/Matrix.hpp
    title: "\u884C\u5217\u30E9\u30A4\u30D6\u30E9\u30EA"
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: cpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    '*NOT_SPECIAL_COMMENTS*': ''
    PROBLEM: https://yukicoder.me/problems/no/2441
    links:
    - https://yukicoder.me/problems/no/2441
  bundledCode: "#line 1 \"test/matrix.test.cpp\"\n#define PROBLEM \"https://yukicoder.me/problems/no/2441\"\
    \n#include <iostream>\n#line 2 \"C++/math/Matrix.hpp\"\n\n#include <ostream>\n\
    #include <cassert>\n#include <vector>\n#include <ranges>\nnamespace man {\ntemplate\
    \ <std::integral T> struct Matrix {\nprivate:\n    const int h, w;\n    std::vector<std::vector<T>>\
    \ mat;\npublic:\n    Matrix(const size_t n): h(n), w(n), mat(h, std::vector<T>(w)){}\n\
    \    Matrix(const size_t h, const size_t w): h(h), w(w), mat(h, std::vector<T>(w)){}\n\
    \    Matrix(const std::vector<std::vector<T>> &m): h(std::ssize(m)), w(std::ssize(m.front())),\
    \ mat(h, std::vector<T>(w)) {\n        for(const auto i: std::views::iota(0, h))\
    \ {\n            for(const auto j: std::views::iota(0, w)) {\n               \
    \ mat[i][j] = m[i][j];\n            }\n        }\n    }\n    static Matrix E(const\
    \ int n) {\n        Matrix m(n);\n        for(const auto i: std::views::iota(0,\
    \ n)) {\n            m[i][i] = 1;\n        }\n        return m;\n    }\n    std::vector<std::vector<T>>\
    \ get() const { return mat; }\n    inline const std::vector<T> &operator[](const\
    \ int i) const noexcept { return mat[i]; }\n    inline std::vector<T> &operator[](const\
    \ int i) noexcept { return mat[i]; }\n    constexpr inline Matrix &operator+=(const\
    \ Matrix &m) noexcept {\n        assert(h == m.h && m == m.w);\n        for(const\
    \ auto i: std::views::iota(0, h)) {\n            for(const auto j: std::views::iota(0,\
    \ w)) {\n                (*this)[i][j] += m[i][j];\n            }\n        } \
    \           \n        return *this;\n    }\n    constexpr inline Matrix &operator-=(const\
    \ Matrix &m) noexcept {\n        assert(h == m.h && m == m.w);\n        for(const\
    \ auto i: std::views::iota(0, h)) {\n            for(const auto j: std::views::iota(0,\
    \ w)) {\n                (*this)[i][j] -= m[i][j];\n            }\n        }\n\
    \        return *this;\n    }\n    constexpr inline Matrix &operator*=(const Matrix\
    \ &m) noexcept {\n        assert(w == m.h);\n        std::vector mt(h, std::vector<T>(m.w));\n\
    \        for(const auto i: std::views::iota(0, h)) {\n            for(const auto\
    \ j: std::views::iota(0, w)) {\n                for(const auto k: std::views::iota(0,\
    \ w)) {\n                    mt[i][j] += (*this)[i][k] * m[k][j];\n          \
    \      }\n            }\n        }\n        mat.swap(mt);\n        return *this;\n\
    \    }\n    constexpr inline Matrix &operator^=(long long k) noexcept {\n    \
    \    Matrix m = Matrix::E(h);\n        while(k > 0) {\n            if(k & 1) {\n\
    \                m *= *this;\n            }\n            *this *= *this;\n   \
    \         k >>= 1LL;\n        }\n        mat.swap(m.mat);\n        return *this;\n\
    \    }\n    constexpr inline bool operator==(const Matrix &m) const noexcept {\n\
    \        if(h != m.h || w != m.w) {\n            return false;\n        }\n  \
    \      for(const auto i: std::views::iota(0, h)) {\n            for(const auto\
    \ j: std::views::iota(0, w)) {\n                if((*this)[i][j] != m[i][j]) {\n\
    \                    return false;\n                }\n            }\n       \
    \ }\n        return true;\n    }\n    constexpr inline Matrix operator+(const\
    \ Matrix &m) const noexcept { return Matrix(*this) += m; }\n    constexpr inline\
    \ Matrix operator-(const Matrix &m) const noexcept { return Matrix(*this) -= m;\
    \ }\n    constexpr inline Matrix operator*(const Matrix &m) const noexcept { return\
    \ Matrix(*this) *= m; }\n    constexpr inline Matrix operator^(const long long\
    \ k) const noexcept { return Matrix(*this) ^= k; }\n    inline friend std::ostream\
    \ &operator<<(std::ostream &os, const Matrix &m) noexcept {\n        for(const\
    \ auto i: std::views::iota(0, m.h)) {\n            os << '[' << m[i][0];\n   \
    \         for(const auto j: std::views::iota(1, m.w)) {\n                os <<\
    \ ' ' << m[i][j];\n            }\n            os << ']';\n            if(i + 1\
    \ < m.h) {\n                os << '\\n';\n            }\n        }\n        return\
    \ os;\n    }\n};\n}\n/**\n * @brief \u884C\u5217\u30E9\u30A4\u30D6\u30E9\u30EA\
    \n * @see https://ei1333.github.io/luzhiled/snippets/math/matrix.html\n */\n#line\
    \ 4 \"test/matrix.test.cpp\"\nint main() {\n    int a, b, c, d;\n    std::cin\
    \ >> a >> b >> c >> d;\n    man::Matrix<int64_t> m(2);\n    m[0][0] = a;\n   \
    \ m[0][1] = b;\n    m[1][0] = c;\n    m[1][1] = d;\n    m ^= 3;\n    for(int i\
    \ = 0; i < 2; ++i) {\n        std::cout << m[i][0] << ' ' << m[i][1] << '\\n';\n\
    \    }\n}\n"
  code: "#define PROBLEM \"https://yukicoder.me/problems/no/2441\"\n#include <iostream>\n\
    #include \"C++/math/Matrix.hpp\"\nint main() {\n    int a, b, c, d;\n    std::cin\
    \ >> a >> b >> c >> d;\n    man::Matrix<int64_t> m(2);\n    m[0][0] = a;\n   \
    \ m[0][1] = b;\n    m[1][0] = c;\n    m[1][1] = d;\n    m ^= 3;\n    for(int i\
    \ = 0; i < 2; ++i) {\n        std::cout << m[i][0] << ' ' << m[i][1] << '\\n';\n\
    \    }\n}"
  dependsOn:
  - C++/math/Matrix.hpp
  isVerificationFile: true
  path: test/matrix.test.cpp
  requiredBy: []
  timestamp: '2025-06-14 01:07:36+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: test/matrix.test.cpp
layout: document
redirect_from:
- /verify/test/matrix.test.cpp
- /verify/test/matrix.test.cpp.html
title: test/matrix.test.cpp
---
