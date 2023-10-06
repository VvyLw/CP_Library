struct Modint {
	num i64
	mod i64
}
fn (mint Modint) str() string { return '${mint.num}' }
fn mint(num_ i64, m Mod) Modint {
	return Modint{
		mod: m.mod_
		num: (num_+m.mod_)%m.mod_
	}
}
fn (a Modint)+(b Modint) Modint {
	assert a.mod==b.mod
	m:=a.mod
	mut x:=if a.num>=m{a.num-m} else{a.num}
	y:=if b.num>=m{b.num-m} else{b.num}
	x+=y
	return Modint{
		num: if x>=m{x-m} else{x}
		mod: m
	}
}
fn (a Modint)-(b Modint) Modint {
	assert a.mod==b.mod
	m:=a.mod
	mut x:=if a.num<b.num{a.num+m} else{a.num}
	y:=if b.num>=m{b.num-m} else{b.num}
	x-=y
	return Modint{
		num: if x<0{x+m} else{x}
		mod: m
	}
}
fn (a Modint)*(b Modint) Modint {
	assert a.mod==b.mod
	m:=a.mod
	mut x:=if a.num>=m{a.num-m} else{a.num}
	y:=if b.num>=m{b.num-m} else{b.num}
	x*=y
	return Modint{
		num: x%m
		mod: m
	}
}
fn (a Modint)/(b Modint) Modint {
	assert a.mod==b.mod
	return a*b.inv()
}
fn (a Modint) inv() Modint {
	assert a.num!=0
	mut n:=a.num
	mut m:=a.mod
	mut x, mut y:=i64(0),i64(1)
	mut s, mut t:=i64(1),i64(0)
	for m!=0 {
		q:=n/m
		n,m=m,n-q*m
		x,s=s-q*x,x
		y,t=t-q*y,y
	}
	if s<0{ s+=a.mod }
	return Modint{
		num: s
		mod: a.mod
	}
}
fn (a Modint) pow(x_ u64) Modint {
	mut res:=Modint{num: 1, mod: a.mod}
	mut base:=a
	mut x:=x_
	for x>0 {
		if x%2==1{ res=res*base }
		base*=base
		x>>=1
	}
	return res
}
[params]
struct Mod {
	mod_ i64=mod998
}