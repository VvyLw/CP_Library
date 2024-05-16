module ds

import math.bits{leading_zeros_32}
pub struct FenwickTree {
	n int
mut:
	data []i64
}
pub fn FenwickTree.new(n int) FenwickTree {
	return FenwickTree{
		n: n+2
		data: []i64{len:n+3}
	}
}
pub fn FenwickTree.new_a[T](a []T) FenwickTree {
	mut bit:=FenwickTree.new(a.len)
	for i,e in a {
		bit.add(i,i64(e))
	}
	return bit
}
fn (bit FenwickTree) str() string {
	mut a:=[]i64{len:bit.n-2}
	for i in 0..bit.n-2 {
		a[i]=bit.sum(i)
	}
	return '$a'
}
pub fn (bit FenwickTree) sum(k int) i64 {
	if k<0 {
		return 0
	}
	mut res:=i64(0)
	for i:=k+1; i>0; i-=i&-i {
		res+=bit.data[i]
	}
	return res
}
pub fn (bit FenwickTree) range_sum(l int, r int) i64 { return bit.sum(r)-bit.sum(l-1)}
pub fn (bit FenwickTree) get(i int) i64 { return bit.sum(i)-bit.sum(i-1) }
pub fn (mut bit FenwickTree) add(k int, x i64) {
	for i:=k+1; i<bit.n; i+=i&-i {
		bit.data[i]+=x
	}
}
pub fn (mut bit FenwickTree) imos(l int, r int, x i64) {
	bit.add(l, x)
	bit.add(r+1,-x)
}
fn lg(n int) int { return 31-leading_zeros_32(u32(n)) }
pub fn (bit FenwickTree) lower_bound(w i64) int {
	if w<=0 {
		return 0
	}
	mut x:=w
	mut i:=0
	for k:=1<<lg(bit.n); k>0; k>>=1 {
		if i+k<=bit.n-1 && bit.data[i+k]<x {
			x-=bit.data[i+k]
			i+=k
		}
	}
	return i
}
pub fn (bit FenwickTree) upper_bound(w i64) int {
	if w<0 {
		return 0
	}
	mut x:=w
	mut i:=0
	for k:=1<<lg(bit.n); k>0; k>>=1 {
		if i+k<=bit.n-1 && bit.data[i+k]<=x {
			x-=bit.data[i+k]
			i+=k
		}
	}
	return i
}
pub fn inv_num[T](a []T) i64 {
	n:=a.len
	mut b:=a.clone()
	b.sort(a<b)
	mut id:=map[T]int{}
	for i in 0..n {
		id[b[i]]=i
	}
	mut fw:=FenwickTree.new(n)
	mut res:=i64(0)
	for i in 0..n {
		res+=i-fw.sum(id[a[i]])
		fw.add(id[a[i]],1)
	}
	return res
}