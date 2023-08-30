import os
fn si() string { return os.input('') }
fn ni() i64 { return si().i64() }
fn di() f64 { return si().f64() }
fn lsi() []string { return os.get_line().split(' ') }
fn lni() []i64 { return os.get_line().split(' ').map(it.i64()) }
fn ldi() []f64 { return os.get_line().split(' ').map(it.f64()) }
fn toascii(n i64) string { return u8(n).ascii_str() }
fn iota(n i64, dlt i64) []i64 { return []i64{len: int(n), init: index+dlt} }
pub fn main() void {
	
}