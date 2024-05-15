module ds

import math{min}
import strings{new_builder}

pub struct SegmentTree[T] {
	fini int
	op fn(T,T) T @[required]
	e T
mut:
	n int
	rank int
	dat []T
}
fn (seg SegmentTree[T]) str() string {
	mut sb:=new_builder(0)
	sb.write_string("[${seg.get(0)}")
	for i in 1..seg.fini {
		sb.write_string(", ${seg.get(i)}")
	}
	sb.write_string("]")
	return sb.str()
}
pub fn SegmentTree.new[T](fini int, op fn(T,T) T, e T) SegmentTree[T] {
	mut m:=1
	mut rk:=0
	for fini>m {
		m<<=1
		rk++
	}
	return SegmentTree[T] {
		n: m
		rank: rk
		fini: fini
		op: op
		e: e
		dat: []T{len:2*m, init:e}
	}
}
pub fn SegmentTree.new_a[T](a []T, op fn(T,T) T, e T) SegmentTree[T] {
	mut seg:=SegmentTree.new(a.len,op,e)
	for i,el in a {
		seg.update(i,el)
	}
	return seg
}
pub fn (mut seg SegmentTree[T]) update(id int, x T) {
	mut i:=id+seg.n
	seg.dat[i]=x
	for {
		i>>=1
		seg.dat[i]=seg.op(seg.dat[2*i],seg.dat[2*i+1])
		if i<=0 {
			break
		}
	}
}
pub fn (seg SegmentTree[T]) get(i int) T { return seg.query(i,i+1) }
pub fn (seg SegmentTree[T]) query(lf int, rt int) T {
	mut a:=seg.e
	mut b:=seg.e
	mut l:=lf+seg.n
	mut r:=rt+seg.n
	for l<r {
		if l%2==1 {
			a=seg.op(a,seg.dat[l])
			l++
		}
		if r%2==1 {
			r--
			b=seg.op(seg.dat[r],b)
		}
		l>>=1
		r>>=1
	}
	return seg.op(a,b)
}
pub fn (seg SegmentTree[T]) all() T { return seg.dat[1] }
pub fn (seg SegmentTree[T]) find_left(r int, f fn(T) bool) int {
	if r==0 {
		return 0
	}
	mut h:=0
	mut i:=r+seg.n
	mut val:=seg.e
	for h<=seg.rank {
		if (i>>h)&1!=0 {
			val2:=seg.op(val,seg.dat[i>>(h^1)])
			if f(val2) {
				i-=1<<h
				if i==seg.n {
					return 0
				}
				val=val2
			} else {
				break
			}
		}
		h++
	}
	for h-->0 {
		val2:=seg.op(val,seg.dat[(i>>h)-1])
		if f(val2) {
			i-=1<<h
			if i==seg.n {
				return 0
			}
			val=val2
		}
	}
	return i-seg.n
}
pub fn (seg SegmentTree[T]) find_right(l int, f fn(T) bool) int {
	if l==seg.fini {
		return seg.fini
	}
	mut h:=0
	mut i:=l+seg.n
	mut val:=seg.e
	for h<=seg.rank {
		if (i>>h)&1!=0 {
			val2:=seg.op(val,seg.dat[i>>h])
			if f(val2) {
				i+=1<<h
				if i==2*seg.n {
					return seg.fini
				}
				val=val2
			} else {
				break
			}
		}
		h++
	}
	for h-->0 {
		val2:=seg.op(val,seg.dat[i>>h])
		if f(val2) {
			i+=1<<h
			if i==2*seg.n {
				return seg.fini
			}
			val=val2
		}
	}
	return min(i-seg.n,seg.fini)
}