import os { input }
import math { min, max, floor, sqrt, radians, cos, sin, hypot }
import math.big
import arrays as ar
import regex as re
import rand
import time
import datatypes { Queue }

pub fn solve()! {
	
}

const (
	mod998=998244353
	mod107=1000000007
	inf=1<<30
	linf=i64(u64(1)<<61)-1
	dx=[0,0,0,-1,1,-1,-1,1,1]
	dy=[0,-1,1,0,0,-1,1,-1,1]
)
type F1[T]=fn(T)bool
type F2[T]=fn(T,T)bool
fn si() string { return input('') }
fn ni() int { return si().int() }
fn di() f64 { return si().f64() }
fn bi() i64 { return si().i64() }
fn li() []string { return si().split('') }
fn lsi() []string { return si().split(' ') }
fn lni() []int { return lsi().map(it.int()) }
fn ldi() []f64 { return lsi().map(it.f64()) }
fn lbi() []i64 { return lsi().map(it.i64()) }
fn t2[T](ls []T) (T,T) { return ls[0],ls[1] }
fn t3[T](ls []T) (T,T,T) { return ls[0],ls[1],ls[2] }
fn t4[T](ls []T) (T,T,T,T) { return ls[0],ls[1],ls[2],ls[3] }
fn t5[T](ls []T) (T,T,T,T,T) { return ls[0],ls[1],ls[2],ls[3],ls[4] }
fn t6[T](ls []T) (T,T,T,T,T,T) { return ls[0],ls[1],ls[2],ls[3],ls[4],ls[5] }
fn aro[T](a []T) string { return a.map(it.str()).join(' ') }
fn flush[T](arg T) { println(arg) os.flush() }
fn fin[T](arg T) { println(arg) exit(0) }
fn dbg[T](arg T) { eprintln('-----------${arg}-----------') }
fn yn(ok bool, yes string, no string) string { return if ok{yes} else{no} }
fn yes(ok bool) string { return yn(ok, "Yes", "No") }
fn no(ok bool) string { return yes(!ok) }
fn toc(n i64) string { return u8(n).ascii_str() }
fn ord(s string) int { return s[0] }
fn chmin[T, U](mut a T, b U) bool { jdg:=a>b a=min(a,b) return jdg }
fn chmax[T, U](mut a T, b U) bool { jdg:=a<b a=max(a,b) return jdg }
fn symin(a ...i64) i64 { mut res:=max_i64 for el in a { res=min(res,el) } return res }
fn symax(a ...i64) i64 { mut res:=min_i64 for el in a { res=max(res,el) } return res }
fn sygcd(a []i64) i64 { mut g:=i64(0) for el in a { g=math.gcd(g,el) } return g }
fn sylcm(a []i64) i64 { mut l:=i64(1) for el in a { l=math.lcm(l,el) } return l }
fn mod(n i64, m int) i64 { k:=n%m return if k<0 { k+m } else { k } }
fn large(n i64) big.Integer { return big.integer_from_i64(n) }
fn stol(s string) !big.Integer { return big.integer_from_string(s)! }
fn iota(n int, dlt int) []int { return []int{len: n, init: index+dlt} }
fn unq[T](a []T) []T {
	mut res := []T{cap: a.len / 10}
	mut j := -1
	if a.len > 0 {
		j = 0
		res << a[0]
	}
	for idx, e in a {
		if a[j] == e {
			continue
		}
		j = idx
		res << e
	}
	return res
}
fn bs[T](a []T, x T) !int { return ar.binary_search(a,x)! }
fn a_find[T](a []T, filt F1[T]) ?T { return ar.find_first(a,filt) }
fn a_filter[T](a []T, filt F2[T]) []T { return ar.filter_indexed(a,filt) }
fn len(s string) int { return s.split('').len }
fn scope(a i64, x i64, b i64) bool { return a<=x && x<=b }
fn to_ten(s string, base int) !i64 { return s.parse_int(base,64)! }
fn rgxmt(s string, pat string) !bool { r:=re.regex_opt(pat)! return r.matches_string(s) }
fn rext(inf i64, sup i64) !i64 { return rand.i64_in_range(inf,sup)! }

pub fn main() {
	mut tm:=time.StopWatch{}
	tm.start()
	mut t:=1
	//t=ni()
	for t-->0 { solve()! }
	tm.stop()
	eprintln(tm.elapsed())
}

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

pub struct Pair[T,U] {
	first T
	second U
}
fn (p Pair[T,U]) str() string { return '(${p.first}, ${p.second})' }
pub fn mp[T,U](p T, q U) Pair[T,U] {
	return Pair[T,U] {
		first: p
		second: q
	}
}
fn (p Pair[T,U])+(q Pair[T,U]) Pair[T,U] { return Pair[T,U]{p.first+p.second,q.first+q.second} }
fn (p Pair[T,U])-(q Pair[T,U]) Pair[T,U] { return Pair[T,U]{p.first-p.second,q.first-q.second} }
fn (p Pair[T,U])*(q Pair[T,U]) Pair[T,U] { return Pair[T,U]{p.first*p.second,q.first*q.second} }
fn (p Pair[T,U])/(q Pair[T,U]) Pair[T,U] { return Pair[T,U]{p.first/p.second,q.first/q.second} }
fn (p Pair[T,U])==(q Pair[T,U]) bool { return p.first==q.first && p.second==q.second }
fn (p Pair[T,U])<(q Pair[T,U]) bool { if p.first==q.first{ return p.second<q.second } return p.first<q.first }
pub fn (p Pair[T,U]) rotate(ang int) Pair[f64, f64] {
	assert 0<=ang && ang<360
	rad:=radians(ang)
	return Pair[f64, f64]{p.first*cos(rad)-p.second*sin(rad), p.first*sin(rad)+p.second*cos(rad)}
}
pub fn (p Pair[T,U]) rtt90() Pair[U,T] { return Pair[U,T]{-p.second,p.first} }
pub fn (p Pair[T,U]) dot(q Pair[T,U]) T { return p.first*q.first+p.second*q.second }
pub fn (p Pair[T,U]) square() T { return p.dot(p) }
pub fn (p Pair[T,U]) grad() f64 { assert p.first!=0 return f64(p.second)/p.first }
pub fn (p Pair[T,U]) abs() f64 { return hypot(p.first,p.second) }
pub fn (p Pair[T,U]) lcm() i64 { return math.lcm(p.first,p.second) }
pub fn (p Pair[T,U]) gcd() i64 { return math.gcd(p.first,p.second) }
pub fn (p Pair[T,U]) swap() Pair[U,T] { return Pair[U,T]{p.second,p.first} }

@[params]
struct G_Param {
	idx int=1
	dir bool=true
}
struct Graph {
	undirected bool
mut:
	g [][]i64
}
fn (gr Graph) str() string { return '${gr.g}' }
fn graph(n int, gp G_Param) Graph{
	return Graph{
		g: [][]i64{len:n}
		undirected: gp.dir
	}
}
fn (mut gr Graph) add(a i64, b i64, gp G_Param) {
	x:=a-gp.idx
	y:=b-gp.idx
	gr.g[x]<<y
	if gp.dir{ gr.g[y]<<x }
}
fn (mut gr Graph) ing(m int, gp G_Param) {
	for _ in 0..m {
		l:=input('').split(' ').map(it.i64())
		gr.add(l[0],l[1],gp)
	}
}
fn (gr Graph) all_dist(v int) ![]int {
	mut d:=[]int{len:gr.g.len,init:-1}
	mut q:=Queue[i64]{}
	d[v]=0
	q.push(v)
	for !q.is_empty() {
		tmp:=q.pop()!
		for el in gr.g[tmp] {
			if d[el]!=-1 { continue }
			d[el]=d[tmp]+1
			q.push(el)
		}
	}
	return d
	}
	fn (gr Graph) dist(a int, b int) !int {
	d:=gr.all_dist(a)!
	return d[b]
}

pub struct UnionFind {
mut:
	par []int
}
pub fn new_uf(n int) UnionFind {
	return UnionFind{
		par: []int{len:n,init:-1}
	}
}
pub fn (mut uf UnionFind) root(i int) int { 
	if uf.par[i]<0{ return i }
	uf.par[i]=uf.root(uf.par[i])
	return uf.par[i]
}
pub fn (mut uf UnionFind) same(i int, j int) bool { return uf.root(i)==uf.root(j) }
pub fn (mut uf UnionFind) size(i int) int { return -uf.par[uf.root(i)] }
pub fn (mut uf UnionFind) unite(i int, j int) bool {
	a:=uf.root(i)
	b:=uf.root(j)
	if a==b { return false }
	if uf.par[a]>uf.par[b] { uf.par[a],uf.par[b]=uf.par[b],uf.par[a] }
	uf.par[a]+=uf.par[b]
	uf.par[b]=a
	return true
}
pub fn (mut uf UnionFind) groups() [][]int {
	n:=uf.par.len
	mut res:=[][]int{len:n,init:[]int{}}
	for i in 0..n { res[uf.root(i)]<<i }
	return res.filter(it.len!=0)
}

pub struct Deque[T] {
mut:
	len int
	head int
	tail int
	buf []T
}
fn new_dq[T](n int) Deque[T] {
	return Deque[T] {
		len: n
		head: 0
		tail: 0
		buf: []T{len:n}
	}
}
fn (dq Deque[T]) str() string { return '${dq.buf[0..dq.size()]}' }
fn (dq Deque[T]) next(i int) int {
	next:=i+1
	return if next==dq.len { 0 } else { next }
}
fn (dq Deque[T]) prev(i int) int {
	prev:=i-1
	return if prev==-1 { dq.len-1 } else { prev }
}
fn (dq Deque[T]) index(i int) int {
	size:=dq.size()
	assert i<size
	id:=dq.head+i
	return if dq.len<=id { id-dq.len } else { id }
}
fn (dq Deque[T]) arraycopy(from_id int, mut a []T, from int, len int) {
	assert from_id+len<=dq.size()
	h:=dq.index(from_id)
	if h+len<dq.len {
		for i in from..len {
			a[i]=dq.buf[i+h]
		}
	} else {
		back:=dq.len-h
		for i in from..back {
			a[i]=dq.buf[i+h]
		}
		for i in from+back..len-back {
			a[i]=dq.buf[i]
		}
	}
}
fn (mut dq Deque[T]) extend() {
	mut tmp:=[]T{len:dq.len*2}
	dq.arraycopy(0,mut tmp,0,dq.size())
	dq.buf=tmp
	dq.len=dq.buf.len
}
pub fn (dq Deque[T]) is_empty() bool { return dq.size()==0 }
pub fn (dq Deque[T]) size() int {
	size:=dq.tail-dq.head
	return if size<0 { size+dq.len } else { size }
}
pub fn (mut dq Deque[T]) push_front(x T) {
	if dq.prev(dq.head)==dq.tail {
		dq.extend()
	}
	dq.head=dq.prev(dq.head)
	dq.buf[dq.head]=x
}
pub fn (mut dq Deque[T]) push_back(x T) {
	if dq.next(dq.tail)==dq.head {
		dq.extend()
	}
	dq.buf[dq.tail]=x
	dq.tail=dq.next(dq.tail)
}
pub fn (mut dq Deque[T]) pop_front() !T {
	if dq.head==dq.tail {
		return error('Deque is empty')
	}
	res:=dq.buf[dq.head]
	dq.head=dq.next(dq.head)
	return res
}
pub fn (mut dq Deque[T]) pop_back() !T {
	if dq.head==dq.tail {
		return error('Deque is empty')
	}
	dq.tail=dq.prev(dq.tail)
	return dq.buf[dq.tail]
}
pub fn (dq Deque[T]) front() T { return dq.get(0) }
pub fn (dq Deque[T]) back() T { return dq.get(dq.len-1) }
pub fn (dq Deque[T]) get(i int) T { return dq.buf[dq.index(i)] }
pub fn (mut dq Deque[T]) set(i int, x T){ dq.buf[dq.index(i)]=x }
pub fn (mut dq Deque[T]) swap(a int, b int) {
	i:=dq.index(a)
	j:=dq.index(b)
	dq.buf[i],dq.buf[j]=dq.buf[j],dq.buf[i]
}
pub fn (mut dq Deque[T]) clear() {
	dq.head=0
	dq.tail=0
}