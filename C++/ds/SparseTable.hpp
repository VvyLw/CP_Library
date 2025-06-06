#pragma once

#include <vector>
#include <functional>
namespace man {
template <class T> struct SparseTable {
private:
    using F = std::function<T(T,T)>;
    std::vector<std::vector<T>> st;
    std::vector<T> lookup;
    F f;
public:
    SparseTable(const std::vector<T> &v, const F &f_) : f(f_) {
        int b = 0;
        while((1 << b) <= std::ssize(v)) {
            ++b;
        }
        st.assign(b, std::vector<T>(1 << b));
        for(const auto i: std::views::iota(0, std::ssize(v))) {
            st[0][i] = v[i];
        }
        for(const auto i: std::views::iota(1, b)) {
            for(int j = 0; j + (1 << i) <= (1 << b); j++) {
                st[i][j] = f(st[i - 1][j], st[i - 1][j + (1 << (i - 1))]);
            }
        }
        lookup.resize(std::ssize(v) + 1);
        for(const auto i: std::views::iota(2, std::ssize(lookup))) {
            lookup[i] = lookup[i >> 1] + 1;
        }
    }
    constexpr inline T query(const T l, const T r) noexcept {
        const int b = lookup[r - l];
        return f(st[b][l], st[b][r - (1 << b)]);
    }
    template <class Boolean = bool> constexpr inline int min_left(const int x, const Boolean &fn) noexcept {
        if(x == 0) {
            return 0;
        }
        int ok = x, ng = -1;
        while(std::abs(ok - ng) > 1) {
            const int mid = (ok + ng) / 2;
            (fn(query(mid, x) - 1) ? ok : ng) = mid;
        }
        return ok;
    }
    template <class Boolean = bool> constexpr inline int max_right(const int x, const Boolean &fn) noexcept {
        if(x == std::ssize(lookup) - 1) {
            return std::ssize(lookup) - 1;
        }
        int ok = x, ng = std::ssize(lookup);
        while(std::abs(ok - ng) > 1) {
            const int mid = (ok + ng) / 2;
            (fn(query(x, mid)) ? ok : ng) = mid;
        }
        return ok;
    }
};
}
/**
 * @brief Sparse Table
 * @see https://ei1333.github.io/luzhiled/snippets/structure/sparse-table.html
 */