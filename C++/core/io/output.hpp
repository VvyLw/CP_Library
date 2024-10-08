#pragma once

#include <iostream>
#include <vector>
#include <utility>
#include <map>
#include <set>
#include <deque>
#ifndef TEMPLATE
using i128 = __int128_t;
using u128 = __uint128_t;
#endif
namespace IO {
inline std::ostream &operator<<(std::ostream &dest, const i128 &value) noexcept {
    std::ostream::sentry s(dest);
    if(s) {
        u128 tmp = value < 0 ? -value : value;
        char buffer[128];
        char *d = std::end(buffer);
        do {
            --d;
            *d = "0123456789"[tmp % 10];
            tmp /= 10;
        } while(tmp != 0);
        if(value < 0) {
            --d;
            *d = '-';
        }
        int len = std::end(buffer) - d;
        if(dest.rdbuf() -> sputn(d, len) != len) {
            dest.setstate(std::ios_base::badbit);
        }
    }
    return dest;
}
template <class T, class U> std::ostream& operator<<(std::ostream &os, const std::pair<T, U> &p){ os << p.first << ' ' << p.second; return os; }
template <class T, size_t N> std::ostream& operator<<(std::ostream &os, const std::array<T, N> &a){ if(a.size()){ os << a.front(); for(auto i=a.begin(); ++i!=a.end();){ os << ' ' << *i; } } return os; }
template <class T> std::ostream& operator<<(std::ostream &os, const std::vector<T> &v){ if(v.size()){ os << v.front(); for(auto i=v.begin(); ++i!=v.end();){ os << ' ' << *i; } } return os; }
template <class K, class V> std::ostream& operator<<(std::ostream &os, const std::map<K, V> &m){ if(m.size()){ os << m.begin()->first << ' ' << m.begin()->second; for(auto i=m.begin(); ++i!=m.end();){ os << '\n' << i->first << ' ' << i->second; } } return os; }
template <class T> std::ostream& operator<<(std::ostream &os, const std::set<T> &st){ if(st.size()){ os << *st.begin(); for(auto i=st.begin(); ++i!=st.end();){ os << ' ' << *i; } } return os; }
template <class T> std::ostream& operator<<(std::ostream &os, const std::multiset<T> &ms){ if(ms.size()){ os << *ms.begin(); for(auto i=ms.begin(); ++i!=ms.end();){ os << ' ' << *i; } } return os; }
template <class T> std::ostream& operator<<(std::ostream &os, const std::deque<T> &dq){ if(dq.size()){ os << dq.front(); for(auto i=dq.begin(); ++i!=dq.end();){ os << ' ' << *i; } } return os; }
inline void out(){ std::cout << '\n'; }
template <bool flush=false, class T> inline void out(const T& x){ std::cout << x << '\n'; if(flush) std::cout.flush(); }
template <bool flush=false, class Head, class... Tail> inline void out(const Head& head, const Tail&... tail){ std::cout << head << ' '; out<flush>(tail...); }
template <bool flush=false, class T> inline void vout(const T& v){ std::cout << v << '\n'; if(flush) std::cout.flush(); }
template <bool flush=false, class T> inline void vout(const std::vector<T>& v){ for(const auto &el: v) std::cout << el << '\n'; if(flush) std::cout.flush(); }
template <bool flush=false, class Head, class... Tail> inline void vout(const Head& head, const Tail&... tail){ std::cout << head << '\n'; vout<flush>(tail...); }

#define fin(...) do{ out(__VA_ARGS__); return; }while(false)
} // IO

#if local
//https://gist.github.com/naskya/1e5e5cd269cfe16a76988378a60e2ca3
#include <C++/core/io/debug_print.hpp>
#else
#define dump(...) static_cast<void>(0)
#endif

/**
 * @brief 出力
 */