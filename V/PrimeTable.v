pub struct SoE {
mut:
	siege []bool
}
fn (pt SoE) str() string { return '${pt.siege}' }
pub fn p_table(n int) SoE {
	mut tmp:=[]bool{len:n+1,init:true}
	tmp[0]=false
	tmp[1]=false
	for i in 2..n+1 {
		if !tmp[i] { continue }
		for j:=i*i; j<=n; j+=i { tmp[j]=false }
	}
	return SoE{ siege: tmp }
}
pub fn (pt SoE) get() []int {
	mut res:=[]int{}
	for i in 2..pt.siege.len {
		if pt.siege[i] { res<<i }
	}
	return res
}