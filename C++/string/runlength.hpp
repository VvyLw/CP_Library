#pragma once

#include <string>
std::string rle(const std::string &s) {
	const int n = s.size();
	std::string t;
	for(int l = 0; l < n;) {
		int r = l + 1;
		for(; r < n && s[l] == s[r]; ++r){}
		t += s[l];
		t += std::to_string(r - l);
		l = r;
	}
	return t;
}

std::string rle_rev(const std::string &s) {
	const int n = s.size();
	std::string t;
	for(int l = 0; l < n;) {
		int r = l + 1;
		for(; r < n && '0' <= s[r] && s[r] <= '9'; ++r){}
		t += std::string(std::stoi(s.substr(l + 1, r - l)), s[l]);
		l = r;
	}
	return t;
}