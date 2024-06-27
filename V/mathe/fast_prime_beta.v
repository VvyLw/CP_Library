module mathe

import math.bits{trailing_zeros_64}
import math.unsigned{uint128_from_64}

fn bsf__(n u64) u32 { return u32(trailing_zeros_64(n)) }
fn b_gcd__(x u64, y u64) u64 {
	mut a,mut b:=x,y
	if a==0 {
		return b
	}
	if b==0 {
		return a
	}
	shift:=bsf(a|b)
	a>>=bsf(a)
	for {
		b>>=bsf(b)
		if a>b {
			a,b=b,a
		}
		b-=a
		if b<=0 {
			break
		}
	}
	return a<<shift
}
fn f__(x u64, st u64, n u64) u64 { return ((uint128_from_64(x)*uint128_from_64(x)+uint128_from_64(st))%uint128_from_64(n)).str().u64() }
fn g__(n u64) u64 {
	if miller_rabin__(n) {
		return n
	}
	if n%2==0 {
		return 2
	}
	mut st:=u64(0)
	for {
		st++
		mut x:=st
		mut y:=f__(x,st,n)
		for {
			p:=b_gcd__(y-x+n,n)
			if p==0 || p==n {
				break
			}
			if p!=1 {
				return p
			}
			x,y=f__(x,st,n),f__(f__(y,st,n),st,n)
		}
	}
	return 0
}
fn mod_pow(a u64, b u64, mod u64) u64 {
	mut r:=u64(1)
    mut x,mut y:=uint128_from_64(a)%uint128_from_64(mod),b
    for y>0 {
        if y%2==1 {
			r=(x*uint128_from_64(r)).mod_64(mod)
		}
        x=(x*x)%uint128_from_64(mod)
        y>>=1
    }
    return r
}
pub fn miller_rabin__(n u64) bool {
	if n<=1 {
		return false
	}
	if n==2 {
		return true
	}
	if n%2==0 {
		return false
	}
	mut d:=n-1
	for d%2==0 {
		d/=2
	}
	sample:=[u32(2),3,5,7,11,13,17,19,23,29,31,37]
	for a in sample {
		if n<=a {
			break
		}
		mut t:=d
		mut y:=mod_pow(a,t,n)
		for t!=n-1 && y!=1 && y!=n-1 {
			y=mod_pow(y,2,n)
			t<<=1
		}
		if y!=n-1 && t%2==0 {
            return false
        }
	}
	return true
}
pub fn pollard_rho__(n u64) []u64 {
	if n==1 {
		return []
	}
	x:=g__(n)
	if x==n {
		return [x]
	}
	mut l:=pollard_rho__(x)
	r:=pollard_rho__(n/x)
	l<<r
	return l
}