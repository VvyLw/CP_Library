#pragma once

#include <iostream>
#include <vector>
#include <utility>
#include <map>
#include <set>
#include <deque>
namespace IO {
inline std::ostream &operator<<(std::ostream &dest, const __int128_t &value) noexcept {
    std::ostream::sentry s(dest);
    constexpr char dig[] = "0123456789";
    if(s) {
        __uint128_t tmp = value < 0 ? -value : value;
        char buffer[128];
        char *d = std::end(buffer);
        do {
            --d;
            *d = dig[tmp % 10];
            tmp /= 10;
        } while(tmp != 0);
        if(value < 0) {
            --d;
            *d = '-';
        }
        const int len = std::end(buffer) - d;
        if(dest.rdbuf() -> sputn(d, len) != len) {
            dest.setstate(std::ios_base::badbit);
        }
    }
    return dest;
}
template <class T, class U> inline std::ostream& operator<<(std::ostream &os, const std::pair<T, U> &p) noexcept { os << p.first << ' ' << p.second; return os; }
template <class T, size_t N> inline std::ostream& operator<<(std::ostream &os, const std::array<T, N> &a) noexcept {
    if(!a.empty()) {
        os << a.front();
        for(auto i = a.begin(); ++i != a.end();) {
            os << ' ' << *i;
        }
    }
    return os;
}
template <class T> inline std::ostream& operator<<(std::ostream &os, const std::vector<T> &v) noexcept {
    if(!v.empty()) {
        os << v.front();
        for(auto i = v.begin(); ++i != v.end();) {
            os << ' ' << *i;
        }
    }
    return os;
}
template <class K, class V> inline std::ostream& operator<<(std::ostream &os, const std::map<K, V> &m) noexcept {
    if(!m.empty()) {
        os << m.begin()->first << ' ' << m.begin()->second;
        for(auto i = m.begin(); ++i != m.end();) {
            os << '\n' << i->first << ' ' << i->second;
        }
    }
    return os;
}
template <class T> inline std::ostream& operator<<(std::ostream &os, const std::set<T> &st) noexcept {
    if(!st.empty()) {
        os << *st.begin();
        for(auto i = st.begin(); ++i != st.end();) {
            os << ' ' << *i;
        }
    }
    return os;
}
template <class T> inline std::ostream& operator<<(std::ostream &os, const std::multiset<T> &ms) noexcept {
    if(!ms.empty()) {
        os << *ms.begin();
        for(auto i = ms.begin(); ++i != ms.end();) {
            os << ' ' << *i;
        }
    }
    return os;
}
template <class T> inline std::ostream& operator<<(std::ostream &os, const std::deque<T> &dq) noexcept {
    if(!dq.empty()) {
        os << dq.front();
        for(auto i = dq.begin(); ++i != dq.end();) {
            os << ' ' << *i;
        }
    }
    return os;
}
} // IO

namespace man {
inline void print() noexcept { std::cout << '\n'; }
template <class Head, class... Tail> inline void print(const Head& head, const Tail& ...tail) noexcept {
    std::cout << head;
    if constexpr(sizeof...(Tail) > 0) {
        std::cout << ' ';
        print(tail...);
    } else {
        std::cout << '\n';
    }
}
}

#if local
//https://gist.github.com/naskya/1e5e5cd269cfe16a76988378a60e2ca3
#include <C++/core/io/debug_print.hpp>
#else
#define dump(...) static_cast<void>(0)
#endif

/**
 * @brief 出力
 */