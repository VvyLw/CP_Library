module core

import os{input}
import math as ma{min,max}
import math.big
import arrays as ar
import regex as re
import rand

pub const (
	mod998=998244353
	mod107=1000000007
	inf=1<<30
	linf=i64(u64(1)<<61)-1
	dx=[0,0,0,-1,1,-1,-1,1,1]
	dy=[0,-1,1,0,0,-1,1,-1,1]
)
type F1[T]=fn(T)bool
type F2[T]=fn(T,T)bool
pub fn si() string { return input('') }
pub fn ni() int { return si().int() }
pub fn di() f64 { return si().f64() }
pub fn bi() i64 { return si().i64() }
pub fn li() []string { return sa(si()) }
pub fn lsi() []string { return si().split(' ') }
pub fn lni() []int { return lsi().map(it.int()) }
pub fn ldi() []f64 { return lsi().map(it.f64()) }
pub fn lbi() []i64 { return lsi().map(it.i64()) }
pub fn t2[T](ls []T) (T,T) { return ls[0],ls[1] }
pub fn t3[T](ls []T) (T,T,T) { return ls[0],ls[1],ls[2] }
pub fn t4[T](ls []T) (T,T,T,T) { return ls[0],ls[1],ls[2],ls[3] }
pub fn t5[T](ls []T) (T,T,T,T,T) { return ls[0],ls[1],ls[2],ls[3],ls[4] }
pub fn t6[T](ls []T) (T,T,T,T,T,T) { return ls[0],ls[1],ls[2],ls[3],ls[4],ls[5] }
pub fn t7[T](ls []T) (T,T,T,T,T,T,T) { return ls[0],ls[1],ls[2],ls[3],ls[4],ls[5],ls[6] }
pub fn aro[T](a []T) string { return a.map(it.str()).join(' ') }
pub fn flush[T](arg T) { println(arg) os.flush() }
pub fn yn(ok bool, yes string, no string) string { return if ok{yes} else{no} }
pub fn yes(ok bool) string { return yn(ok, "Yes", "No") }
pub fn no(ok bool) string { return yes(!ok) }
pub fn toc(n i64) string { return u8(n).ascii_str() }
pub fn ord(s string) int { return s[0] }
pub fn sa(s string) []string { return s.split('') }
pub fn sas(s []string) string { return s.join('') }
pub fn chmin[T, U](mut a T, b U) bool { jdg:=a>b a=min(a,b) return jdg }
pub fn chmax[T, U](mut a T, b U) bool { jdg:=a<b a=max(a,b) return jdg }
pub fn symin(a ...i64) i64 { mut res:=max_i64 for el in a { res=min(res,el) } return res }
pub fn symax(a ...i64) i64 { mut res:=min_i64 for el in a { res=max(res,el) } return res }
pub fn sygcd(a []i64) i64 { mut g:=i64(0) for el in a { g=ma.gcd(g,el) } return g }
pub fn sylcm(a []i64) i64 { mut l:=i64(1) for el in a { l=ma.lcm(l,el) } return l }
pub fn mod(n i64, m i64) i64 { k:=n%m return if k<0 { k+m } else { k } }
pub fn large(n i64) big.Integer { return big.integer_from_i64(n) }
pub fn stol(s string) !big.Integer { return big.integer_from_string(s)! }
pub fn iota(n int, dlt int) []int { return []int{len: n, init: index+dlt} }
pub fn unq[T](a []T) []T {
	mut res := []T{cap: a.len / 10}
	mut j := -1
	if a.len > 0 {
		j = 0
		res << a[0]
	}
	for idx, e in a {
		if a[j] == e {
			continue
		}
		j = idx
		res << e
	}
	return res
}
pub fn bs[T](a []T, b T) bool {
	_:=ar.binary_search(a,b) or { return false }
	return true
}
pub fn lb[T](a []T, b T) int {
	mut ok,mut ng:=a.len,-1
	for math.abs(ok-ng)>1 {
		mid:=(ok+ng)/2
		if a[mid]>=b {
			ok=mid
		} else {
			ng=mid
		}
	}
	return ok
}
pub fn ub[T](a []T, b T) int {
	mut ok,mut ng:=a.len,-1
	for math.abs(ok-ng)>1 {
		mid:=(ok+ng)/2
		if a[mid]>b {
			ok=mid
		} else {
			ng=mid
		}
	}
	return ok
}
pub fn scope(a i64, x i64, b i64) bool { return a<=x && x<=b }
pub fn to_ten(s string, base int) !i64 { return s.parse_int(base,64)! }
pub fn rgxmt(s string, pat string) !bool { r:=re.regex_opt(pat)! return r.matches_string(s) }
pub fn rext(inf i64, sup i64) !i64 { return rand.i64_in_range(inf,sup)! }