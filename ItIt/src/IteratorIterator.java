import java.util.Iterator;


public class IteratorIterator<T> implements Iterator<T> {
	Iterator<Iterator<T>> itit = null;
	Iterator<T> currIt = null;
	
	IteratorIterator(Iterator<Iterator<T>> itit) {
		this.itit = itit;
		if (itit.hasNext()) {
			currIt = itit.next();
		} else {
			return;
		}
		while (!currIt.hasNext()) {
			if (itit.hasNext()) {
				currIt = itit.next();
			} else {
				break;
			}
		}
	}

	@Override
	public boolean hasNext() {
		if (currIt == null) return false;
		return currIt.hasNext();
	}

	@Override
	public T next() {
		if (currIt == null) {
			// or throw exception
			return null;
		}
		T res = currIt.next();
		while (!currIt.hasNext()) {
			if (itit.hasNext()) {
				currIt = itit.next();
			} else {
				break;
			}
		}
		return res;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}
}
