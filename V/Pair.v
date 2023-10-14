struct Pair[T,U] {
	first T
	second U
}
fn (p Pair[T,U]) str() string { return '${p.first} ${p.second}' }
fn mp[T,U](p T, q U) Pair[T,U] {
	return Pair[T,U] {
		first: p
		second: q
	}
}
fn (p Pair[T,T])+(q Pair[T,T]) Pair[T,T] { return Pair[T,T]{p.first+p.second,q.first+q.second} }
fn (p Pair[T,T])-(q Pair[T,T]) Pair[T,T] { return Pair[T,T]{p.first-p.second,q.first-q.second} }
fn (p Pair[T,T])*(q Pair[T,T]) Pair[T,T] { return Pair[T,T]{p.first*p.second,q.first*q.second} }
fn (p Pair[T,T])/(q Pair[T,T]) Pair[T,T] { return Pair[T,T]{p.first/p.second,q.first/q.second} }
fn (p Pair[T,U])==(q Pair[T,U]) bool { return  p.first==q.first && p.second==q.second }
fn (p Pair[T,U])<(q Pair[T,U]) bool { if p.first==q.first{ return p.second<q.second } return p.first<q.first }
fn (p Pair[T,T]) rotate(ang int) Pair[f64, f64] {
	assert scope(0,ang,359)
	rad:=ma.radians(ang)
	return Pair[f64, f64]{p.first*ma.cos(rad)-p.second*ma.sin(rad), p.first*ma.sin(rad)+p.second*ma.cos(rad)}
}
fn (p Pair[T,T]) rtt90() Pair[T,T] { return Pair[T,T]{-p.second,p.first} }
fn (p Pair[T,T]) dot(q Pair[T,T]) T { return p.first*q.first+p.second*q.second }
fn (p Pair[T,T]) cross(q Pair[T,T]) T { return p.dot(p.rtt90,q) }
fn (p Pair[T,T]) square() T { return p.dot(p) }
fn (p Pair[T,T]) grad() f64 { assert p.first!=0 return f64(p.second)/p.first }
fn (p Pair[T,T]) abs() T { return ma.hypot(p.first,p.second) }
fn (p Pair[T,T]) lcm() T { return ma.lcm(p.first,p.second) }
fn (p Pair[T,T]) gcd() T { return ma.gcd(p.first,p.second) }
fn (p Pair[T,T]) extgcd() Pair[T,T] {
	mut x:=1 mut y:=0 mut t1:=0 mut t2:=0 mut t3:=1
	mut a:=p.first mut b:=p.second
	for b!=0 {
		t1=a/b a-=t1*b
		a,b=b,a
		x-=t1*t2
		x,t2=t2,x
		y-=t1*t3
		y,t3=t3,y
	}
	return Pair[T,T]{x,y}
}
fn (p Pair[T,T]) normalize() Pair[T,T] {
	if p==Pair[T,T]{} { return p }
	p/=p.gcd()
	if p<Pair[T,T]{} { p=-p }
	return p
}
fn (p Pair[T,U]) swap() Pair[U,T] { return Pair[U,T]{p.second,p.first} }
fn swap[T,U](p []Pair[T,U]) []Pair[U,T] {
	mut ret:=[]Pair[U,T]{}
	for el in p { ret<<mp(el.first,el.second) }
	return ret
}
fn first[T,U](p []Pair[T,U]) []T {
	mut ret:=[]T{}
	for el in p { ret<<el.first }
	return ret
}
fn second[T,U](p []Pair[T,U]) []U {
	mut ret:=[]U{}
	for el in p { ret<<el.second }
	return ret
}