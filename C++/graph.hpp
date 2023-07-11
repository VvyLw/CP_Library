#include <iostream>
#include <vector>
#include <queue>
using namespace std;
template <bool indirected=1> struct graph {
    vector<vector<int>> g;
    graph(int n): g(n){}
    vector<int>& operator[](int x){ return g[x]; }
    const vector<int>& operator[](int at) const { return g[x]; }
    operator vector<vector<int>>&(){ return g; }
    operator const vector<vector<int>>&() const { return g; }
    auto begin() const { return g.cbegin(); }
    auto end() const { return g.cend(); }
    int size() const { return g.size(); }
    void add(int a, int b, int indexed=1) {
        a-=indexed,b-=indexed;
        g[a].emplace_back(b);
        if(indirected) g[b].emplace_back(a);
    }
    void input(int m, int indexed=1) {
        for(int i = 0; i < m; ++i) {
            int a, b;
            cin >> a >> b;
            add(a,b,indexed);
        }
    }
    vector<int> all_dist(int v) {
        vector<int> d(g.size(),-1);
        queue<int> q;
        d[v]=0;
        q.emplace(v);
            while(q.size()) {
            int tmp=q.front();
            q.pop();
            for(auto el: g[tmp]) {
                if(d[el]!=-1) continue;
                d[el]=d[tmp]+1;
                q.emplace(el);
            }
        }
        return d;
    }
    int dist(int u, int v) {
        auto d=all_dist(u);
        return d[v];
    }
};
