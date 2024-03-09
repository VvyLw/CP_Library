#pragma once

#include <limits>
#ifndef TEMPLATE
using ll = long long;
using ld = long double;
#endif
template <class T> using L = std::numeric_limits<T>;
constexpr int dx[] = {0, 0, 0, -1, 1, -1, -1, 1, 1};
constexpr int dy[] = {0, -1, 1, 0, 0, -1, 1, -1, 1};
constexpr int MOD = 0x3b800001;
constexpr int M0D = 1e9 + 7;
constexpr int INF = 1 << 30;
constexpr ll LINF = (1LL << 61) - 1;
constexpr ld DINF = L<ld>::infinity();
template <class T> constexpr T LIM = L<T>::max();
#if __cplusplus >= 202100L
#include <numbers>
constexpr ld PI = std::numbers::pi;
constexpr ld E = std::numbers::e;
#else
#include <cmath>
const ld PI = std::acos(-1);
const ld E = 2.718281828459045;
#endif

/**
 * @brief 定数
 */