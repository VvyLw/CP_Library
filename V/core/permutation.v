module core

pub fn next_permutation[T](mut a []T) bool {
	for i:=a.len-1; i>0; i-- {
		if a[i-1]<a[i] {
			j:=find(a[i-1],a,i,a.len-1)
			a[i-1],a[j]=a[j],a[i-1]
			a[i..a.len].sort(a<b)
			return true
		}
	}
	return false
}
pub fn prev_permutation[T](mut a []T) bool {
	for i:=a.len-1; i>0; i-- {
		if a[i-1]>a[i] {
			j:=find_rev(a[i-1],a,i,a.len-1)
			a[i-1],a[j]=a[j],a[i-1]
			a[i..a.len].sort(a>b)
			return true
		}
	}
	return false
}
fn find[T](dest T, a []T, s int, e int) int {
	if s==e {
		return s
	}
	m:=(s+e+1)/2
	return if a[m]<=dest { find(dest,a,s,m-1) } else { find(dest,a,m,e) }
}
fn find_rev[T](dest T, a []T, s int, e int) int {
	if s==e {
		return s
	}
	m:=(s+e+1)/2
	return if a[m]>dest { find_rev(dest,a,s,m-1) } else { find_rev(dest,a,m,e) }
}