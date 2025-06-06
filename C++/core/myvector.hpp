#pragma once

#include <vector>

namespace man {
namespace vec {
template <class T> using V = std::vector<T>;
typedef V<int64_t> vi;
typedef V<uint64_t> vu;
typedef V<long double> vd;
typedef V<char> vc;
typedef V<std::string> vs;
typedef V<bool> vb;
typedef V<vi> wi;
typedef V<vu> wu;
typedef V<vd> wd;
typedef V<vc> wc;
typedef V<vs> ws;
typedef V<vb> wb;
#ifdef EDGE
typedef V<man::edge> ve;
typedef V<ve> we;
#endif
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
}
}