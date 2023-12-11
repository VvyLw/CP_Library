#pragma once

// inspired by natsugiri( https://natsugiri.hatenablog.com/entry/2016/10/10/035445 )
#include <vector>
#include <algorithm>
template <class T> struct depq {
private:
    std::vector<T> d;
    inline int parent(int k) const { return ((k >> 1) - 1) & ~1; }
    int down(int k) {
	    const int n = d.size();
	    if(k & 1) {
    	    while(2 * k + 1 < n) {
		        int c = 2 * k + 3;
		        if(n <= c || d[c - 2] < d[c]) {
                    c -= 2;
                }
		        if(c < n && d[c] < d[k]) {
                    std::swap(d[k], d[c]);
                    k = c;
                }
		        else {
                    break;
                }
	        }
	    } else {
    	    while(2 * k + 2 < n) {
    		    int c = 2 * k + 4;
		        if(n <= c || d[c] < d[c - 2]) {
                    c -= 2;
                }
		        if(c < n && d[k] < d[c]) {
                    std::swap(d[k], d[c]);
                    k = c;
                }
    		    else {
                    break;
                }
	        }
	    }
	    return k;
    }
    int up(int k, const int root = 1) {
	    if((k | 1) < std::ssize(d) && d[k & ~1] < d[k | 1]) {
    	    std::swap(d[k & ~1], d[k | 1]);
	        k ^= 1;
	    }
	    int p;
	    while(root < k && d[p = parent(k)] < d[k]) {
	        std::swap(d[p], d[k]);
	        k = p;
	    }
	    while(root < k && d[k] < d[p = parent(k) | 1]) {
	        std::swap(d[p], d[k]);
	        k = p;
	    }
	    return k;
    }
public:
    depq(const std::vector<T> &d_): d(d_) {
	    for(int i = d.size(); i--;) {
	        if(i & 1 && d[i - 1] < d[i]) {
                std::swap(d[i - 1], d[i]);
            }
	        up(down(i), i);
	    }
    }
    void push(const T &x) {
	    const int k = d.size();
    	d.emplace_back(x);
    	up(k);
    }
    T pop_min() {
        const auto res = get_min();
	    if(d.size() < 3) {
	        d.pop_back(); 
	    } else {
	        std::swap(d[1], d.back());
            d.pop_back();
	        up(down(1));
	    }
        return res;
    }
    T pop_max() {
        const auto res = get_max();
        if(d.size() < 2) { 
            d.pop_back();
        } else {
            std::swap(d[0], d.back());
            d.pop_back();
            up(down(0));
        }
        return res;
    }
    T get_min() const { return d.size() < 2 ? d[0] : d[1]; }
    T get_max() const { return d[0]; }
    int size() const { return d.size(); }
    bool empty() const { return d.empty(); }
};