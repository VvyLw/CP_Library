// inspired by kenkoooo(https://kenkoooo.hatenablog.com/entry/2016/11/30/163533)
#include <iostream>
using namespace std;
typedef __int128_t i128;
typedef __uint128_t u128;
ostream &operator<<(ostream &dest, i128 value) {
    ostream::sentry s(dest);
    if (s) {
        u128 tmp = value < 0 ? -value : value;
        char buffer[128];
        char *d = end(buffer);
        do {
            --d;
            *d = "0123456789"[tmp % 10];
            tmp /= 10;
        } while (tmp != 0);
        if (value < 0) {
            --d;
            *d = '-';
        }
        int len = end(buffer) - d;
        if (dest.rdbuf()->sputn(d, len) != len) {
            dest.setstate(ios_base::badbit);
        }
    }
    return dest;
}
inline i128 stoL(string &s) {
    i128 ret = 0;
    for(auto el: s) {
        if(isdigit(el)) ret = 10 * ret + el - '0';
    }
    if(s.front() == '-') ret = -ret;
    return ret;
}
