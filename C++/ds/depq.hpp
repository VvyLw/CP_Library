#pragma once

#include <vector>
#include <algorithm>
#include <ranges>
namespace man {
template <std::integral T> struct depq {
private:
    std::vector<T> d;
    constexpr inline int parent(int k) const noexcept { return ((k >> 1) - 1) & ~1; }
    constexpr inline int down(int k) noexcept {
	    const int n = std::ssize(d);
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
    constexpr inline int up(int k, const int root = 1) noexcept {
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
	    for(const auto i: std::views::iota(0, std::ssize(d)) | std::views::reverse) {
	        if(i & 1 && d[i - 1] < d[i]) {
                std::swap(d[i - 1], d[i]);
            }
	        up(down(i), i);
	    }
    }
    constexpr inline void push(const T &x) noexcept {
	    const int k = std::ssize(d);
    	d.emplace_back(x);
    	up(k);
    }
    constexpr inline T pop_min() noexcept {
        const auto res = get_min();
	    if(std::ssize(d) < 3) {
	        d.pop_back(); 
	    } else {
	        std::swap(d[1], d.back());
            d.pop_back();
	        up(down(1));
	    }
        return res;
    }
    constexpr inline T pop_max() noexcept {
        const auto res = get_max();
        if(std::ssize(d) < 2) { 
            d.pop_back();
        } else {
            std::swap(d.front(), d.back());
            d.pop_back();
            up(down(0));
        }
        return res;
    }
    constexpr inline T get_min() const noexcept { return std::ssize(d) < 2 ? d[0] : d[1]; }
    constexpr inline T get_max() const noexcept { return d.front(); }
    constexpr inline int size() const noexcept { return std::ssize(d); }
    constexpr inline bool empty() const noexcept { return d.empty(); }
};
}
/**
 * @brief Double-Ended Priority Queue(両端優先度付きキュー)
 * @see https://natsugiri.hatenablog.com/entry/2016/10/10/035445
 */