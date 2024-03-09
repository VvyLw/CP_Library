#pragma once

#include <vector>

#ifndef TEMPLATE
typedef long long ll;
typedef unsigned long long ul;
typedef long double ld;
#endif
namespace vectors {
template <class T> using V = std::vector<T>;
using vi = V<ll>;
using vu = V<ul>;
using vd = V<ld>;
using vc = V<char>;
using vs = V<std::string>;
using vb = V<bool>;
using wi = V<vi>;
using wu = V<vu>;
using wd = V<vd>;
using wc = V<vc>;
using ws = V<vs>;
using wb = V<vb>;
template <class T, class U> inline V<U> ndiv(T&& n, U&& v) noexcept {
  return V<U>(std::forward<T>(n), std::forward<U>(v));
}
template <class T, class... Ts> inline decltype(auto) ndiv(T&& n, Ts&&... v) noexcept {
  return V<decltype(ndiv(std::forward<Ts>(v)...))>(std::forward<T>(n), ndiv(std::forward<Ts>(v)...));
}
template <class T> constexpr V<T>& operator++(V<T>& v) noexcept { for(auto &el: v) el++; return v; }
template <class T> constexpr V<T>& operator--(V<T>& v) noexcept { for(auto &el: v) el--; return v; }
template <class T, class U> constexpr V<T>& operator+=(V<T>& v, const U x) noexcept { for(auto &el: v) el+=x; return v; }
template <class T, class U> constexpr V<T>& operator-=(V<T>& v, const U x) noexcept { for(auto &el: v) el-=x; return v; }
template <class T, class U> constexpr V<T>& operator*=(V<T>& v, const U x) noexcept { for(auto &el: v) el*=x; return v; }
template <class T, class U> constexpr V<T>& operator/=(V<T>& v, const U x) noexcept { for(auto &el: v) el/=x; return v; }
template <class T, class U> constexpr V<T>& operator%=(V<T>& v, const U x) noexcept { for(auto &el: v) el%=x; return v; }
template <class T, class U> constexpr V<T> operator+(const V<T>& v, const U x) noexcept { V<T> res = v; res+=x; return res; }
template <class T, class U> constexpr V<T> operator-(const V<T>& v, const U x) noexcept { V<T> res = v; res-=x; return res; }
template <class T, class U> constexpr V<T> operator*(const V<T>& v, const U x) noexcept { V<T> res = v; res*=x; return res; }
template <class T, class U> constexpr V<T> operator/(const V<T>& v, const U x) noexcept { V<T> res = v; res/=x; return res; }
template <class T, class U> constexpr V<T> operator%(const V<T>& v, const U x) noexcept { V<T> res = v; res%=x; return res; }
} // vectors