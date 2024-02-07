pub struct Asum {
mut:
	acc []i64
}
pub fn asum(a []i64) Asum {
	mut s:=[i64(0)]
	for i,el in a { s<<s[i]+el }
	return Asum{ acc: s }
}
pub fn (a Asum) str() string { return '${a.acc}' }
pub fn (a Asum) query(l int, r int) i64 { return a.acc[r]-a.acc[l] }