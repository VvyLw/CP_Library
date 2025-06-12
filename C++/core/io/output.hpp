#pragma once

#include <iostream>
#include <array>
#include <map>
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
template <class K, class V> inline std::ostream& operator<<(std::ostream &os, const std::map<K, V> &m) noexcept {
    if(!m.empty()) {
        os << m.begin()->first << ' ' << m.begin()->second;
        for(auto i = m.begin(); ++i != m.end();) {
            os << '\n' << i->first << ' ' << i->second;
        }
    }
    return os;
}
template <std::ranges::range T> requires (!std::same_as<std::remove_cvref_t<T>, std::string> && !std::same_as<std::remove_cvref_t<T>, std::string_view> && !std::is_array_v<std::remove_cvref_t<T>>) inline std::ostream& operator<<(std::ostream &os, const T &v) noexcept {
    if(!v.empty()) {
        os << *v.cbegin();
        for(auto i = v.cbegin(); ++i != v.cend();) {
            os << ' ' << *i;
        }
    }
    return os;
}
enum Flash { non_flush, flush };
template <Flash f = non_flush, class Head, class... Tail> inline void print(const Head& head, const Tail& ...tail) noexcept {
    std::cout << head;
    if constexpr(sizeof...(Tail) > 0) {
        std::cout << ' ';
        print<f>(tail...);
    } else {
        if constexpr(f == flush) {
            std::cout.flush();
        }
    }
}
inline void println() noexcept { std::cout << '\n'; }
template <Flash f = non_flush, class Head, class... Tail> inline void println(const Head& head, const Tail& ...tail) noexcept { print<f>(head, tail...); std::cout << '\n'; }
} // IO

using enum IO::Flash;

#if local
//https://gist.github.com/naskya/1e5e5cd269cfe16a76988378a60e2ca3
#include <C++/core/io/debug_print.hpp>
#else
#define dump(...) static_cast<void>(0)
#endif

/**
 * @brief 出力
 */