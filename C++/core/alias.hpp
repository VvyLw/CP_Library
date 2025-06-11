#pragma once

#ifndef ALIAS
#define ALIAS
#endif

#include <limits>
#include <numbers>
#include <queue>
#include <ext/pb_ds/assoc_container.hpp>
#include <ext/pb_ds/tree_policy.hpp>

namespace internal {
template <typename T> concept num = std::integral<T> || std::floating_point<T>;
}

constexpr int dx[] = {0, 0, 0, -1, 1, -1, -1, 1, 1};
constexpr int dy[] = {0, -1, 1, 0, 0, -1, 1, -1, 1};
constexpr int MOD = 0x3b800001;
constexpr int M0D = 1e9 + 7;
constexpr int INF = 1 << 30;
constexpr int64_t LINF = (1LL << 61) - 1;
constexpr long double DINF = std::numeric_limits<long double>::infinity();
template <internal::num T> constexpr T LIM = std::numeric_limits<T>::max();
constexpr long double PI = std::numbers::pi;
constexpr long double E = std::numbers::e;

typedef int64_t i64;
typedef long double ld;
typedef uint32_t u32;
typedef uint64_t u64;
typedef __int128_t i128;
typedef __uint128_t u128;
#ifdef MODINT
typedef man::Modint<MOD> mint;
typedef man::Modint<M0D> Mint;
#endif
template <size_t N> using ti = std::array<i64, N>;
typedef ti<3> tri;
template <class T> using pq = std::priority_queue<T>;
template <class T> using pqr = std::priority_queue<T, std::vector<T>, std::greater<T>>;
template <class T> using Tree = __gnu_pbds::tree<T, __gnu_pbds::null_type, std::less<T>, __gnu_pbds::rb_tree_tag, __gnu_pbds::tree_order_statistics_node_update>;
template <class T> using TREE = __gnu_pbds::tree<T, __gnu_pbds::null_type, std::greater<T>, __gnu_pbds::rb_tree_tag, __gnu_pbds::tree_order_statistics_node_update>;

/**
 * @brief エイリアス
 */