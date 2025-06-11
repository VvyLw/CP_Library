#pragma once

#include <vector>

namespace man {
namespace vec {
template <class T> using V = std::vector<T>;
typedef V<int64_t> zhl;
typedef V<uint64_t> uzhl;
typedef V<long double> dec;
typedef V<char> chr;
typedef V<std::string> str;
typedef V<bool> bol;
typedef V<vi> zhl2;
typedef V<vu> uzhl2;
typedef V<vd> dec2;
typedef V<vc> chr2;
typedef V<vs> str2;
typedef V<vb> bol2;
#ifdef EDGE
typedef V<man::edge> edg;
typedef V<ve> edg2;
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