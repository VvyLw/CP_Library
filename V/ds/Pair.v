module ds

import math as ma{radians,cos,sin,hypot}

@[heap]
pub struct Pair[T,U] {
	first T
	second U
}
fn (p Pair[T,U]) str() string { return '(${p.first}, ${p.second})' }
pub fn mp[T,U](p T, q U) Pair[T,U] {
	return Pair[T,U] {
		first: p
		second: q
	}
}
fn (p Pair[T,U])+(q Pair[T,U]) Pair[T,U] {
	$if T in [$int,$float,$string] && U in [$int,$float,$string] {
		return mp(p.first+q.first,p.second+q.second)
	} $else {
		panic('T and U must be addable')
	}
}
fn (p Pair[T,U])-(q Pair[T,U]) Pair[T,U] {
	$if T in [$int,$float] && U in [$int,$float] {
		return mp(p.first-q.first,p.second-q.second)
	} $else {
		panic('T and U must be numeric')
	}
}
fn (p Pair[T,U])*(q Pair[T,U]) Pair[T,U] {
	$if T in [$int,$float] && U in [$int,$float] {
		return mp(p.first*q.first,p.second*q.second)
	} $else {
		panic('T and U must be numeric')
	}
}
fn (p Pair[T,U])/(q Pair[T,U]) Pair[T,U] {
	$if T in [$int,$float] && U in [$int,$float] {
		return mp(p.first/q.first,p.second/q.second)
	} $else {
		panic('T and U must be numeric')
	}
}
fn (p Pair[T,U])==(q Pair[T,U]) bool { return p.first==q.first && p.second==q.second }
fn (p Pair[T,U])<(q Pair[T,U]) bool { if p.first==q.first{ return p.second<q.second } return p.first<q.first }
pub fn (p Pair[T,U]) rotate(ang int) Pair[f64, f64] {
	assert 0<=ang && ang<360
	rad:=radians(ang)
	return Pair[f64, f64]{p.first*cos(rad)-p.second*sin(rad), p.first*sin(rad)+p.second*cos(rad)}
}
pub fn (p Pair[T,U]) rtt90() Pair[U,T] { return Pair[U,T]{-p.second,p.first} }
pub fn (p Pair[T,U]) dot(q Pair[T,U]) T { return p.first*q.first+p.second*q.second }
pub fn (p Pair[T,U]) square() T { return p.dot(p) }
pub fn (p Pair[T,U]) grad() f64 { assert p.first!=0 return f64(p.second)/p.first }
pub fn (p Pair[T,U]) abs() f64 { return hypot(p.first,p.second) }
pub fn (p Pair[T,U]) lcm() i64 { return ma.lcm(p.first,p.second) }
pub fn (p Pair[T,U]) gcd() i64 { return ma.gcd(p.first,p.second) }
pub fn (p Pair[T,U]) swap() Pair[U,T] { return Pair[U,T]{p.second,p.first} }