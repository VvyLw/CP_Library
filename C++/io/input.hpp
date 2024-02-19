#pragma once

#include <iostream>
#include <cassert>
#include <deque>
#include "C++/mypair.hpp"
#ifndef TEMPLATE
typedef unsigned long long ul;
typedef __int128_t i128;
namespace zia_qu {
inline bool isdigit(const char c){ return std::isdigit(c); }
inline bool isdigit(const std::string &s){ bool ok=1, neg=s.front()=='-'; for(const auto &el: s){ if(neg){ neg=0; continue; } ok&=isdigit(el); } return ok; }
}
#endif
namespace IO {
template <class T, class U> std::istream& operator>>(std::istream &is, pairs::P<T, U> &p){ is >> p.first >> p.second; return is; }
template <class T, size_t N> std::istream& operator>>(std::istream &is, std::array<T, N> &a){ for(auto &el: a) is >> el; return is; }
template <class T> std::istream& operator>>(std::istream &is, vectors::V<T> &v){ for(auto &el: v) is >> el; return is; }
template <class T> std::istream& operator>>(std::istream &is, std::deque<T> &dq){ for(auto &el: dq) is >> el; return is; }
template <class T> inline bool in(T& x){ std::cin >> x; return 1; }
template <class Head, class... Tail> inline bool in(Head& head, Tail&... tail){ in(head); in(tail...); return 1; }

inline i128 to_i128(const std::string &s) {
    assert(zia_qu::isdigit(s));
    bool neg=s.front()=='-';
    i128 ret = 0;
    for(const auto &el: s) {
        if(neg) {
            neg=0;
            continue;
        }
        ret = 10 * ret + el - '0';
    }
    if(s.front()=='-') ret=-ret;
    return ret;
}

#define INT(...) int __VA_ARGS__; in(__VA_ARGS__)
#define LL(...) ll __VA_ARGS__; in(__VA_ARGS__)
#define UL(...) ul __VA_ARGS__; in(__VA_ARGS__)
#define LD(...) ld __VA_ARGS__; in(__VA_ARGS__)
#define CHR(...) char __VA_ARGS__; in(__VA_ARGS__)
#define STR(...) std::string __VA_ARGS__; in(__VA_ARGS__)
#define VEC(type,name,size) vectors::V<type> name(size); in(name)
#define WEC(type,name,h,w) vectors::V<vectors::V<type>> name(h,vectors::V<type>(w)); in(name)
} // IO

/**
 * @brief 入力
 */