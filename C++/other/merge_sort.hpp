#pragma once

#include <vector>
#include <limits>
template <class T> inline void merge(std::vector<T>& v, const int left, const int mid, const int right) {
    const int n1 = mid - left, n2 = right - mid;
    std::vector<T> l(n1 + 1), r(n2 + 1);
    for(int i = 0; i < n1; ++i) {
        l[i] = v[left + i];
    }
    for(int i = 0; i < n2; ++i) {
        r[i] = v[mid + i];
    }
    l[n1] = r[n2] = std::numeric_limits<T>::max();
    int i = 0, j = 0;
    for(int k = left; k < right; ++k) {
        if(l[i] <= r[j]) {
            v[k] = l[i++];
        } else {
            v[k] = r[j++];
        }
    }
}
template <class T> inline void merge_sort(std::vector<T> &v, const int l, const int r) {
    if(l + 1 < r) {
        const int mid = (l + r) / 2;
        merge_sort(v, l, mid);
        merge_sort(v, mid, r);
        merge(v, l, mid, r);
    }
}

/**
 * @brief マージソート
 * @docs docs/merge_sort.md
 */