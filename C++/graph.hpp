#pragma once

#include <iostream>
#include <vector>
#include <queue>
using namespace std;
template <class T, class U> bool chmin(T& a, const U& b){ if(a>b){ a=b; return 1; } return 0; }
struct edge {
    int to;
    long long cost;
    edge(int to_, long long cost_): to(to_), cost(cost_){}
    operator long long() const { return to; }
};
template <bool indirected=1> struct w_graph {
    vector<vector<edge>> g;
    w_graph(int n): g(n){}
    vector<edge>& operator[](int x){ return g[x]; }
    const vector<edge>& operator[](int x) const { return g[x]; }
    operator vector<vector<edge>>&(){ return g; }
    operator const vector<vector<edge>>&() const { return g; }
    auto begin() const { return g.cbegin(); }
    auto end() const { return g.cend(); }
    int size() const { return g.size(); }
    void add(int a, int b, long long cost, int indexed=1) {
        a-=indexed,b-=indexed;
        g[a].emplace_back(b, cost);
        if(indirected) g[b].emplace_back(a, cost);
    }
    void input(int m, int indexed=1) {
        for(int i = 0; i < m; ++i) {
            int a, b;
            long long c;
            cin >> a >> b >> c;
            add(a, b, c, indexed);
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
    vector<long long> dijikstra(int v) {
        vector<long long> cst(g.size(), 1LL << 60);
        priority_queue<pair<long long, int>, vector<pair<long long, int>>, greater<pair<long long, int>>> dj;
        cst[v]=0;
        dj.emplace(cst[v],v);
        while(dj.size()) {
            auto tmp=dj.top();
            dj.pop();
            if(cst[tmp.second]<tmp.first) continue;
            for(auto el: g[tmp.second]) if(chmin(cst[el],tmp.first+el.cost)) dj.emplace(cst[el],el);
        }
        return cst;
    }
};
template <bool indirected=1> struct graph {
    vector<vector<int>> g;
    graph(int n): g(n){}
    vector<int>& operator[](int x){ return g[x]; }
    const vector<int>& operator[](int x) const { return g[x]; }
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
