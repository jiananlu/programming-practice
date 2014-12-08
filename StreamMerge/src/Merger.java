import java.util.*;

class StreamComparator<T> implements Comparator<InputStream<T>> {
	Comparator<T> comparator;
	
	public StreamComparator(Comparator<T> comparator) {
		this.comparator = comparator;
	}
	
	@Override
	public int compare(InputStream<T> o1, InputStream<T> o2) {
		return this.comparator.compare(o1.peek(), o2.peek());
	}
}

public class Merger<T> {
	public void merge(List<InputStream<T>> inputs, OutputStream<T> output, Comparator<T> comparator) {
		StreamComparator<T> streamComparator = new StreamComparator<T>(comparator);
		PriorityQueue<InputStream<T>> pq = new PriorityQueue<InputStream<T>>(inputs.size(), streamComparator);

		// add all input streams if it's not empty
		for (InputStream<T> input: inputs) {
			if (input.hasNext()) {
				pq.add(input);
			}
		}
		
		// merge and emit
		while (!pq.isEmpty()) {
			InputStream<T> input = pq.remove();
			output.emit(input.next());
			if (input.hasNext()) {
				pq.add(input);
			}
		}
	}
}
