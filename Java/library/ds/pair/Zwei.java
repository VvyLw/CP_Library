package library.ds.pair;

import java.util.Objects;

import library.ds.lazysegmenttree.RASM;
import library.ds.lazysegmenttree.RUSM;

/**
 * RASM, RUSMの時に使う
 * Pairに似ているが出力がfirstの値のみになっている
 * @see Pair
 * @see RASM
 * @see RUSM
 * @param <T>
 */
public final class Zwei<T> implements Cloneable {
	public T first, second;
	private Zwei(final T first, final T second) {
		this.first = first;
		this.second = second;
	}
	public static final <T> Zwei<T> of(final T f, final T s){ return new Zwei<>(f, s); }
	@Override
	public final boolean equals(final Object o) {
		if(this == o) {
			return true;
		}
		if(o == null || getClass() != o.getClass()) {
			return false;
		}
		final Zwei<?> z = (Zwei<?>) o;
		return first.equals(z.first) && second.equals(z.second);
	}
	@Override
	public final int hashCode(){ return Objects.hash(first, second); }
	@Override
	public final String toString(){ return String.valueOf(first); }
	@SuppressWarnings("unchecked")
	@Override
	public final Zwei<T> clone() {
		try {
			return (Zwei<T>) super.clone();
		} catch(final CloneNotSupportedException e){
			e.printStackTrace();
		}
		throw new Error();
	}
}