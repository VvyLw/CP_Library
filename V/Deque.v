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