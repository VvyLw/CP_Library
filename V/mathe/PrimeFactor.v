module mathe

pub struct SPF {
mut:
	spf []int
}
fn (pf SPF) str() string { return '${pf.spf}' }
pub fn p_fact(n int) SPF {
	mut tmp:=[]int{len:n+1,init:index}
	for i:=2; i*i<=n; i++ {
		if tmp[i]==i {
			for j:=i*i; j<=n; j+=i {
				if tmp[j]==j { tmp[j]=i }
			}
		}
	}
	return SPF{ spf: tmp }
}
pub fn (pf SPF) get(n int) map[int]int {
	mut res:=map[int]int{}
	mut x:=n
	for x!=1 {
		res[pf.spf[x]]++
		x/=pf.spf[x]
	}
	return res
}