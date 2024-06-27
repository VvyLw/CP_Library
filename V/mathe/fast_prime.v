module mathe

import math.big{integer_from_u32,integer_from_u64}
import math.bits{trailing_zeros_64}

fn bsf(n u64) u32 { return u32(trailing_zeros_64(n)) }
fn b_gcd(x u64, y u64) u64 {
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
fn f(x u64, st u32, n u64) u64 { return ((integer_from_u64(x)*integer_from_u64(x)+integer_from_u32(st))%integer_from_u64(n)).str().u64() }
fn g(n u64) !u64 {
	if miller_rabin(n)! {
		return n
	}
	if n%2==0 {
		return 2
	}
	mut st:=u32(0)
	for {
		st++
		mut x:=u64(st)
		mut y:=f(u64(x),st,n)
		for {
			p:=b_gcd(y-x+n,n)
			if p==0 || p==n {
				break
			}
			if p!=1 {
				return p
			}
			x,y=f(x,st,n),f(f(y,st,n),st,n)
		}
	}
	return 0
}
pub fn miller_rabin(n u64) !bool {
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
		mut y:=integer_from_u32(a).big_mod_pow(integer_from_u64(t),integer_from_u64(n))!.str().u64()
		for t!=n-1 && y!=1 && y!=n-1 {
			y=integer_from_u64(y).mod_pow(2,integer_from_u64(n)).str().u64()
			t<<=1
		}
		if y!=n-1 && t%2==0 {
            return false
        }
	}
	return true
}
pub fn pollard_rho(n u64) ![]u64 {
	if n==1 {
		return []
	}
	x:=g(n)!
	if x==n {
		return [x]
	}
	mut l:=pollard_rho(x)!
	r:=pollard_rho(n/x)!
	l<<r
	l.sort()
	return l
}

// AtCoderのVのVersionが上がるまで