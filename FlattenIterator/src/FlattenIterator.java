import java.util.*;

public class FlattenIterator<T> {
	private Queue<Iterator<T>> queue = new LinkedList<Iterator<T>>();
	public FlattenIterator(List<Iterator<T>> iterators) {
		if (iterators == null) return;
		for (Iterator<T> iter: iterators) {
			if (!iter.hasNext()) continue;
			queue.add(iter);
		}
	}
	public boolean hasNext() {
		return !queue.isEmpty();
	}
	
	public T next() {
		Iterator<T> iter = queue.remove();
		T v = iter.next();
		if (iter.hasNext()) {
			queue.add(iter);
		}
		return v;
	}
}
