module mathe

import math{floor,sqrt}

pub fn is_int(n f64) bool { return n==floor(n) }
pub fn is_sqr(n i64) bool { return is_int(sqrt(n)) }
pub fn is_prime(n i64) bool {
	if n<=1 {
		return false
	}
	if n<=3 {
		return true
	}
	if n%2==0 || n%3==0 {
        return false
    }
	for i:=5; i*i<=n; i+=6 {
		if n%i==0 || n%(i+2)==0 {
			return false
		}
	}
	return true
}
pub fn div(n i64) []i64 {
	mut res:=[]i64{}
	for i:=1; i*i<=n; i++ {
		if n%i==0 {
			res<<i
			if i*i!=n { res<<n/i }
		}
	}
	res.sort()
	return res
}
pub fn prmfct(n i64) map[i64]int {
	mut res:=map[i64]int{}
	mut x:=n
	for i:=2; i*i<=x; i++ {
		if x%i!=0 { continue }
		for x%i==0 {
			res[i]++
			x/=i
		}
	}
	if x!=1 { res[x]++ }
	return res
}
pub fn perm(n i64, r i64) i64 {
	mut tmp:=n
	mut res:=i64(1)
	for tmp>n-r { res*=tmp-- }
	return res
}
pub fn binom(n i64, r i64) i64 {
	if r<0 || n<r { return 0 }
	mut tmp:=n
	mut res:=i64(1)
	for i in 1..r+1 {
		res*=tmp--
		res/=i
	}
	return res
}
pub fn radix_convert(n i64, radix u8) []u8 {
	if n==0 {
		return [u8(0)]
	}
	mut m:=n
	mut res:=[]u8{}
	for m>0 {
		res<<u8(m%radix)
		m/=radix
	}
	return res.reverse()
}