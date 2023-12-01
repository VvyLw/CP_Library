// inspired by maspy(https://github.com/maspypy/library/blob/main/ds/unionfind/unionfind.hpp)
#include <cassert>
#include <vector>
#include <algorithm>
#include <stack>
struct UnionFind {
private:
    std::vector<int> par;
public:
    UnionFind(const int n): par(n, -1){}
    int operator[](int i) {
        while(par[i] >= 0) {
            const int p = par[par[i]];
            if(p < 0) return par[i];
            i = par[i] = p;
        }
        return i;
    }
    bool unite(int x, int y) {
        x = (*this)[x], y = (*this)[y];
        if(x == y) return false;
        if(-par[x] < -par[y]) {
            std::swap(x, y);
        }
        par[x] += par[y], par[y] = x;
        return true;
    }
    int size(const int x) {
        return -par[(*this)[x]];
    }
#if __cplusplus >= 202101L
    std::vector<std::vector<int>> groups() {
        const int n = std::ssize(par);
        std::vector<std::vector<int>> res(n);
        for(int i = 0; i < n; ++i) {
            res[(*this)[i]].emplace_back(i);
        }
        const auto it = std::ranges::remove_if(res, [&](const std::vector<int> &v){ return v.empty(); });
        res.erase(it.begin(), it.end());
        return res;
    }
#else
    std::vector<std::vector<int>> groups() {
        const int n = par.size();
        std::vector<std::vector<int>> res(n);
        for(int i = 0; i < n; ++i) {
            res[(*this)[i]].emplace_back(i);
        }
        res.erase(std::remove_if(res.begin(), res.end(), [&](const std::vector<int> &v){ return v.empty(); }), res.end());
        return res;
    }
#endif
    bool is_bipartite() {
        const int n = par.size() / 2;
        bool ok = true;
        for(int i = 0; i < n; ++i) {
            ok &= (*this)[i] != (*this)[i + n];
        }
        return ok;
    }
};

// inspired by tatyam(https://github.com/tatyam-prime/kyopro_library/blob/master/UnionFind.cpp)
struct UFPotential {
private:
    std::vector<int> par;
    std::vector<long long> diff;
public:
    UFPotential(const int n): par(n, -1), diff(n){}
    int root(const int i) {
        if(par[i] < 0) {
            return i;
        }
        const int r = root(par[i]);
        diff[i] += diff[par[i]];
        return par[i] = r;
    }
    long long dist(const int i) {
        root(i);
        return diff[i];
    }
    long long dist(const int x, const int y){ return dist(y) - dist(x); }
    int unite(int x, int y, long long w) {
        w += dist(y, x);
        x = root(x), y = root(y);
        if(x == y) {
            return w == 0 ? 0 : -1;
        }
        if(par[x] > par[y]) {
            std::swap(x, y);
            w = -w;
        }
        par[x] += par[y];
        par[y] = x;
        diff[y] = w;
        return 1;
    }
    int operator[](const int i) noexcept { return root(i); }
};

// inspired by Luzhiled(https://ei1333.github.io/luzhiled/snippets/structure/union-find.html)
struct UFUndo {
private:
    std::vector<int> par;
	std::stack<std::pair<int, int>> his;
public:
	UFUndo(const int n): par(n, -1){}
    bool unite(int x, int y) {
		x = root(x);
		y = root(y);
		his.emplace(std::make_pair(x, par[x]));
		his.emplace(std::make_pair(y, par[y]));
		if(x == y) {
			return false;
		}
		if(par[x] > par[y]) {
			std::swap(x, y);
		}
		par[x] += par[y];
		par[y] = x;
		return true;
	}
    int root(int k) {
        if(par[k] < 0) {
            return k;
        }
        return root(par[k]);
    }
    int size(const int i){ return -par[root(i)]; }
    void undo() {
		par[his.top().first] = his.top().second;
        his.pop();
		par[his.top().first] = his.top().second;
        his.pop();
	}
    void snapshot() {
		while(his.size()) {
			his.pop();
		}
	}
	void rollback() {
		while(his.size()) {
			undo();
		}
	}
};