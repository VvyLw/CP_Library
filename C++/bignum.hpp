// inspired by kenkoooo(https://kenkoooo.hatenablog.com/entry/2016/11/30/163533)
#pragma once

#include <iostream>
typedef __int128_t i128;
typedef __uint128_t u128;
std::ostream &operator<<(std::ostream &dest, i128 value) {
    std::ostream::sentry s(dest);
    if(s) {
        u128 tmp = value < 0 ? -value : value;
        char buffer[128];
        char *d = std::end(buffer);
        do {
            --d;
            *d = "0123456789"[tmp % 10];
            tmp /= 10;
        } while(tmp);
        if(value < 0) {
            --d;
            *d = '-';
        }
        const int len = std::end(buffer) - d;
        if(dest.rdbuf()->sputn(d, len) != len) {
            dest.setstate(std::ios_base::badbit);
        }
    }
    return dest;
}
inline i128 stoL(const std::string &s) {
    i128 ret = 0;
    for(const auto &el: s) {
        if(isdigit(el)) ret = 10 * ret + el - '0';
    }
    if(s.front() == '-') ret = -ret;
    return ret;
}
