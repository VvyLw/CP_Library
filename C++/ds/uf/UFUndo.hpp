#pragma once

#include <vector>
#include <stack>
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
/**
 * @brief Undo可能UnionFind
 * @see https://ei1333.github.io/luzhiled/snippets/structure/union-find.html
 */