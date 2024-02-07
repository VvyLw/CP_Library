import math as ma
pub struct Pair[T,U] {
	first T
	second U
}
fn (p Pair[T,U]) str() string { return '${p.first} ${p.second}' }
pub fn mp[T,U](p T, q U) Pair[T,U] {
	return Pair[T,U] {
		first: p
		second: q
	}
}
fn (p Pair[T,U])+(q Pair[T,U]) Pair[T,U] { return Pair[T,U]{p.first+p.second,q.first+q.second} }
fn (p Pair[T,U])-(q Pair[T,U]) Pair[T,U] { return Pair[T,U]{p.first-p.second,q.first-q.second} }
fn (p Pair[T,U])*(q Pair[T,U]) Pair[T,U] { return Pair[T,U]{p.first*p.second,q.first*q.second} }
fn (p Pair[T,U])/(q Pair[T,U]) Pair[T,U] { return Pair[T,U]{p.first/p.second,q.first/q.second} }
fn (p Pair[T,U])==(q Pair[T,U]) bool { return p.first==q.first && p.second==q.second }
fn (p Pair[T,U])<(q Pair[T,U]) bool { if p.first==q.first{ return p.second<q.second } return p.first<q.first }
pub fn (p Pair[T,U]) rotate(ang int) Pair[f64, f64] {
	assert scope(0,ang,359)
	rad:=ma.radians(ang)
	return Pair[f64, f64]{p.first*ma.cos(rad)-p.second*ma.sin(rad), p.first*ma.sin(rad)+p.second*ma.cos(rad)}
}
pub fn (p Pair[T,U]) rtt90() Pair[U,T] { return Pair[U,T]{-p.second,p.first} }
pub fn (p Pair[T,U]) dot(q Pair[T,U]) T { return p.first*q.first+p.second*q.second }
pub fn (p Pair[T,U]) square() T { return p.dot(p) }
pub fn (p Pair[T,U]) grad() f64 { assert p.first!=0 return f64(p.second)/p.first }
pub fn (p Pair[T,U]) abs() f64 { return ma.hypot(p.first,p.second) }
pub fn (p Pair[T,U]) lcm() i64 { return ma.lcm(p.first,p.second) }
pub fn (p Pair[T,U]) gcd() i64 { return ma.gcd(p.first,p.second) }
pub fn (p Pair[T,U]) swap() Pair[U,T] { return Pair[U,T]{p.second,p.first} }