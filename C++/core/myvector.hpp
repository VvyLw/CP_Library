#pragma once

#include <vector>

#ifndef ALIAS
namespace internal {
template <typename T> concept num = std::integral<T> || std::floating_point<T>;
}
#endif

namespace man {
namespace vec {
template <class T> using V = std::vector<T>;
typedef V<long long> zhl;
typedef V<unsigned long long> uzhl;
typedef V<long double> dec;
typedef V<char> chr;
typedef V<std::string> str;
typedef V<bool> bol;
typedef V<zhl> zhl2;
typedef V<uzhl> uzhl2;
typedef V<dec> dec2;
typedef V<chr> chr2;
typedef V<str> str2;
typedef V<bol> bol2;
#ifdef EDGE
typedef V<man::edge> edg;
typedef V<edg> edg2;
#endif
template <class T, class U> inline V<U> ndiv(T&& n, U&& v) noexcept {
  return V<U>(std::forward<T>(n), std::forward<U>(v));
}
template <class T, class... Ts> inline decltype(auto) ndiv(T&& n, Ts&&... v) noexcept {
  return V<decltype(ndiv(std::forward<Ts>(v)...))>(std::forward<T>(n), ndiv(std::forward<Ts>(v)...));
}
template <internal::num T> constexpr V<T>& operator++(V<T>& v) noexcept { for(auto &el: v){ el++; } return v; }
template <internal::num T> constexpr V<T>& operator--(V<T>& v) noexcept { for(auto &el: v){ el--; } return v; }
template <internal::num T, internal::num U> constexpr V<T>& operator+=(V<T>& v, const U x) noexcept { for(auto &el: v){ el += x; } return v; }
template <internal::num T, internal::num U> constexpr V<T>& operator-=(V<T>& v, const U x) noexcept { for(auto &el: v){ el -= x; } return v; }
template <internal::num T, internal::num U> constexpr V<T>& operator*=(V<T>& v, const U x) noexcept { for(auto &el: v){ el *= x; } return v; }
template <internal::num T, internal::num U> constexpr V<T>& operator/=(V<T>& v, const U x) noexcept { for(auto &el: v){ el /= x; } return v; }
template <std::integral T, std::integral U> constexpr V<T>& operator%=(V<T>& v, const U x) noexcept { for(auto &el: v){ el %= x; } return v; }
template <internal::num T, internal::num U> constexpr V<T> operator+(const V<T>& v, const U x) noexcept { V<T> ret = v; ret += x; return ret; }
template <internal::num T, internal::num U> constexpr V<T> operator-(const V<T>& v, const U x) noexcept { V<T> ret = v; ret -= x; return ret; }
template <internal::num T, internal::num U> constexpr V<T> operator*(const V<T>& v, const U x) noexcept { V<T> ret = v; ret *= x; return ret; }
template <internal::num T, internal::num U> constexpr V<T> operator/(const V<T>& v, const U x) noexcept { V<T> ret = v; ret /= x; return ret; }
template <std::integral T, std::integral U> constexpr V<T> operator%(const V<T>& v, const U x) noexcept { V<T> ret = v; ret %= x; return ret; }
}
}