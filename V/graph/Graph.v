module graph

import os { input }
import datatypes { Queue, Stack }

pub struct Graph {
	undirected bool
mut:
	g [][]int
}
fn (gr Graph) str() string { return '${gr.g}' }
pub fn graph(n int, gp G_Param) Graph {
	return Graph {
		g: [][]int{len:n}
		undirected: gp.dir
	}
}
pub fn (mut gr Graph) add(a int, b int, gp G_Param) {
	x:=a-gp.idx
	y:=b-gp.idx
	gr.g[x]<<y
	if gp.dir{ gr.g[y]<<x }
}
pub fn (mut gr Graph) ing(m int, gp G_Param) {
	for _ in 0..m {
		l:=input('').split(' ').map(it.int())
		gr.add(l[0],l[1],gp)
	}
}
pub fn (gr Graph) all_dist(v int) ![]int {
	mut d:=[]int{len:gr.g.len,init:-1}
	mut q:=Queue[int]{}
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
pub fn (gr Graph) dist(a int, b int) !int { return gr.all_dist(a)![b] }
pub fn (gr Graph) t_sort() ![]int {
	n:=gr.g.len
	mut deg:=[]int{len:n}
	for i in 0..n {
		for ed in gr.g[i] {
			deg[ed]++
		}
	}
	mut sk:=Stack[int]{}
	for i in 0..n {
		if deg[i]==0 {
			sk.push(i)
		}
	}
	mut ord:=[]int{}
	for !sk.is_empty() {
		tmp:=sk.pop()!
		ord<<tmp
		for ed in gr.g[tmp] {
			deg[ed]--
			if deg[ed]==0 {
				sk.push(ed)
			}
		}
	}
	return if ord.len==n {ord} else {[]int{}}
}
@[params]
struct G_Param {
	idx int=1
	dir bool=true
}