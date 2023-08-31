import os { input }
//import math as ma
import arrays as ar
//import datatypes as dt
import regex as re
const (
	mod998=998244353
	mod107=1000000007
	inf=1<<30
	linf=1<<61
	dx=[0,0,0,-1,1,-1,-1,1,1]
	dy=[0,-1,1,0,0,-1,1,-1,1]
)
fn si() string { return input('') }
fn ni() int { return si().int() }
fn di() f64 { return si().f64() }
fn bi() i64 { return si().i64() }
fn lsi() []string { return si().split(' ') }
fn lni() []int { return si().split(' ').map(it.int()) }
fn ldi() []f64 { return si().split(' ').map(it.f64()) }
fn lbi() []i64 { return si().split(' ').map(it.i64()) }
fn dbg[T](x T) { eprintln(x) }
fn toascii(n i64) string { return u8(n).ascii_str() }
fn iota(n i64, dlt i64) []i64 { return []i64{len: int(n), init: index+dlt} }
fn sorted[T](a []T) []T { mut b:=a.clone() b.sort() return b }
fn resorted[T](a []T) []T { mut b:=a.clone() b.sort(a>b) return b }
fn mod(n int, m int) int { return (n+m)%m }
fn bs[T](a []T, x T) !int { return ar.binary_search(a,x)! }
fn rgxmt(s string, pat string) !bool { r:=re.regex_opt(pat)! return r.matches_string(s) }
struct Pair[T,U] {
	first T
	second U
}
pub fn main() {
	
}