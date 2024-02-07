import math { floor, sqrt }
fn is_int(n f64) bool { return n==floor(n) }
fn is_sqr(n i64) bool { return is_int(sqrt(n)) }
fn is_prime(n i64) bool {
	if n==1 { return false }
	for i:=2; i*i<=n; i++ {
		if n%i==0 { return false }
	}
	return true
}
fn div(n i64) []i64 {
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
fn prmfct(n i64) map[i64]int {
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
fn perm(n i64, r i64) i64 {
	mut tmp:=n
	mut res:=i64(1)
	for tmp>n-r { res*=tmp-- }
	return res
}
fn binom(n i64, r i64) i64 {
	if r<0 || n<r { return 0 }
	mut tmp:=n
	mut res:=i64(1)
	for i in 1..r+1 {
		res*=tmp--
		res/=i
	}
	return res
}
pub fn radix_convert(n i64, radix i8) []int {
	if n==0 {
		return [0]
	}
	mut m:=n
	mut res:=[]int{}
	for m>0 {
		res<<int(m%radix)
		m/=radix
	}
	return res.reverse()
}