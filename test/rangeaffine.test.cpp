#define PROBLEM "https://judge.yosupo.jp/problem/range_affine_range_sum"
#include "math/Modint.hpp"
#include "structure/LazySegmentTree.hpp"
using Z = zwei<mint>;
int main() {
    int n, q;
    std::cin >> n >> q;
    LazySegTree<Z, Z> seg(n, [](const Z &a, const Z &b) -> Z { return Z(a.first + b.first, a.second + b.second); }, [](const Z &a, const Z &b) -> Z { return Z(a.first * b.first + a.second * b.second, a.second); }, [](const Z &a, const Z &b) -> Z { return Z(a.first * b.first, a.second * b.first + b.second); }, Z(0, 0), Z(1, 0));
	std::vector<Z> a(n);
    for(int i = 0; i < n; ++i) {
        int x;
        std::cin >> x;
        a[i] = Z(x, 1);
    }
    seg.build(a);
    while(q--) {
        int t, l, r;
        std::cin >> t >> l >> r;
        if(t == 0) {
            int p, q;
            std::cin >> p >> q;
            seg.apply(l, r, Z(p, q));
        } else {
            std::cout << seg.query(l, r) << '\n';
        }
    }
}

// verified but actually failed(slowest: 9.000372 sec.)