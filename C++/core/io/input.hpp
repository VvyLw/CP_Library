#pragma once

#include <iostream>
#include <cassert>
#include <array>
#include <vector>
#include <deque>
#ifndef TEMPLATE
namespace man {
constexpr inline bool isdigit(const char c) noexcept { return std::isdigit(c); }
inline bool isdigit(const std::string &s) noexcept {
    bool ok = true, neg = s.front() == '-';
    for(const auto &el: s) {
        if(neg) {
            neg = false;
            continue;
        }
        ok &= isdigit(el);
    }
    return ok;
}
}
#endif
namespace IO {
inline std::istream& operator>>(std::istream &is, __int128_t &val) noexcept {
    std::string s;
    std::cin >> s;
    assert(man::isdigit(s));
    bool neg = s.front() == '-';
    val = 0;
    for(const auto &el: s) {
        if(neg) {
            neg = false;
            continue;
        }
        val = 10 * val + el - '0';
    }
    if(s.front()=='-') {
        val = -val;
    }
    return is;
}
template <class T, class U> inline std::istream& operator>>(std::istream &is, std::pair<T, U> &p) noexcept { is >> p.first >> p.second; return is; }
template <std::ranges::random_access_range T> requires (!std::same_as<std::remove_cvref_t<T>, std::string> && !std::same_as<std::remove_cvref_t<T>, std::string_view> && !std::is_array_v<std::remove_cvref_t<T>>) inline std::istream& operator>>(std::istream &is, T &v) noexcept { for(auto &el: v){ is >> el; } return is; }
template <class Head, class... Tail> inline bool input(Head &head, Tail &...tail) noexcept {
    if(!(std::cin >> head)) {
        return false;
    }
    if constexpr(sizeof...(Tail) > 0) {
        input(tail...);
    }
    return true;
}
} // IO

/**
 * @brief 入力
 */