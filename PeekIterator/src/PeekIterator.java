import java.util.Iterator;


public class PeekIterator<T> implements Iterator<T>{
	Iterator<T> iter;
	T value;
	
	public PeekIterator(Iterator<T> iter) {
		this.iter = iter;
		value = null;
		if (iter.hasNext()) {
			value = iter.next();
		}
	}
	
	public T peek() {
		return value;
	}
	
	public T next() {
		T t = value;
		value = null;
		if (iter.hasNext()) {
			value = iter.next();
		}
		return t;
	}
	
	public boolean hasNext() {
		return value != null;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}
}
