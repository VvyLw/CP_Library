#pragma once

#include <cassert>
#include <utility>
#include <tuple>
#include <cmath>
#include <numeric>
#include "C++/constance.hpp"
#include "C++/myvector.hpp"
namespace pairs {
template <class T, class U> using P = std::pair<T, U>;
template <class T> using PP = P<T,T>;
using pi = PP<ll>;
using pd = PP<ld>;
using pc = PP<char>;
using ps = PP<std::string>;
template <class T> constexpr PP<T> operator+(const PP<T>& a, const PP<T>& b) noexcept { return {a.first + b.first, a.second + b.second}; }
template <class T> constexpr PP<T> operator-(const PP<T>& a, const PP<T>& b) noexcept { return {a.first - b.first, a.second - b.second}; }
template <class T> constexpr PP<T> operator-(const PP<T>& a) noexcept { return {-a.first, -a.second}; }
template <class T, class U> constexpr PP<T> operator*(const PP<T>& a, const U& b) noexcept { return {a.first * b, a.second * b}; }
template <class T, class U> constexpr PP<T> operator/(const PP<T>& a, const U& b) noexcept { return {a.first / b, a.second / b}; }
template <class T> constexpr PP<T>& operator+=(PP<T>& a, const PP<T>& b) noexcept { return a = a + b; }
template <class T> constexpr PP<T>& operator-=(PP<T>& a, const PP<T>& b) noexcept { return a = a - b; }
template <class T, class U> constexpr PP<T>& operator*=(PP<T>& a, const U& b) noexcept { return a = a * b; }
template <class T, class U> PP<T>& operator/=(PP<T>& a, const U& b) noexcept { return a = a / b; }
template <class T> constexpr bool operator==(const PP<T> &p, const PP<T> &q) noexcept { return p.first==q.first && p.second==q.second; }
template <class T> constexpr bool operator!=(const PP<T> &p, const PP<T> &q) noexcept { return !(p==q); }
template <class T> constexpr bool operator<(const PP<T> &p, const PP<T> &q) noexcept { if(p.first==q.first) return p.second<q.second; return p.first<q.first; }
template <class T> constexpr bool operator<=(const PP<T> &p, const PP<T> &q) noexcept { if(p.first==q.first) return p.second<=q.second; return p.first<q.first; }
template <class T> constexpr bool operator>(const PP<T> &p, const PP<T> &q) noexcept { if(p.first==q.first) return p.second>q.second; return p.first>q.first; }
template <class T> constexpr bool operator>=(const PP<T> &p, const PP<T> &q) noexcept { if(p.first==q.first) return p.second>=q.second; return p.first>q.first; }
template <class T, class U> constexpr bool operator==(const P<T,U> &p, const P<T,U> &q) noexcept { return p.first==q.first && p.second==q.second; }
template <class T, class U> constexpr bool operator!=(const P<T,U> &p, const P<T,U> &q) noexcept { return !(p==q); }
template <class T, class U> constexpr bool operator<(const P<T,U> &p, const P<T,U> &q) noexcept { if(p.first==q.first) return p.second<q.second; return p.first<q.first; }
template <class T, class U> constexpr bool operator<=(const P<T,U> &p, const P<T,U> &q) noexcept { if(p.first==q.first) return p.second<=q.second; return p.first<q.first; }
template <class T, class U> constexpr bool operator>(const P<T,U> &p, const P<T,U> &q) noexcept { if(p.first==q.first) return p.second>q.second; return p.first>q.first; }
template <class T, class U> constexpr bool operator>=(const P<T,U> &p, const P<T,U> &q) noexcept { if(p.first==q.first) return p.second>=q.second; return p.first>q.first; }
template <class T> inline PP<T> rotate(const PP<T>& a){ return {-a.second, a.first}; } // 90 degree ccw
template <class T> inline pd rotate(const PP<T>& a, const int ang) {
    assert(0<=ang && ang<360);
    const ld rad=PI*ang/180;
    return {a.first*std::cos(rad)-a.second*std::sin(rad), a.first*std::sin(rad)+a.second*std::cos(rad)};
}
template <class T> inline T dot(const PP<T>& a, const PP<T>& b){ return a.first * b.first + a.second * b.second; }
template <class T> inline T cross(const PP<T>& a, const PP<T>& b){ return dot(rotate(a), b); }
template <class T> inline T square(const PP<T>& a){ return dot(a, a); }
template <class T> inline ld grad(const PP<T>& a){ assert(a.first); return 1.0L * a.second / a.first; }
template <class T> inline ld abs(const PP<T>& a){ return std::hypotl(a.first, a.second); }
template <class T> inline T lcm(const PP<T>& a){ return std::lcm(a.first, a.second); }
template <class T> inline T gcd(const PP<T>& a){ return std::gcd(a.first, a.second); }
template <class T> inline PP<T> extgcd(const PP<T> &p) {
    T x=1,y=0,t1=0,t2=0,t3=1,a,b;
    std::tie(a,b)=p;
    while(b) {
        t1=a/b,a-=t1*b;
        std::swap(a,b);
        x-=t1*t2;
        std::swap(x,t2);
        y-=t1*t3;
        std::swap(y,t3);
    }
    return {x,y};
}
template <class T> inline PP<T> normalize(PP<T> a) {
    if(a == PP<T>{}) return a;
    a /= gcd(a);
    if(a < PP<T>{}) a = -a;
    return a;
}
template <class T, class U> inline P<U,T> swap(const P<T,U> &p){ P<U,T> ret={p.second,p.first}; return ret; }
template <class T, class U> inline vectors::V<P<U,T>> swap(const vectors::V<P<T,U>> &vp) {
    vectors::V<P<U,T>> ret;
    for(const auto &el: vp) ret.emplace_back(swap(el));
    return ret;
}
template <class T, class U> inline vectors::V<T> first(const vectors::V<P<T,U>> &vp) {
    vectors::V<T> res;
    for(const auto &el: vp) res.emplace_back(el.first);
    return res;
}
template <class T, class U> inline vectors::V<U> second(const vectors::V<P<T,U>> &vp) {
    vectors::V<U> res;
    for(const auto &el: vp) res.emplace_back(el.second);
    return res;
}
} // pairs