import java.util.*;


public class ArrayInputStream<T> implements InputStream<T> {
	List<T> inputs;
	int index = 0;
	
	public ArrayInputStream(List<T> inputs) {
		this.inputs = inputs;
	}
	
	@Override
	public T peek() {
		return inputs.get(index);
	}

	@Override
	public T next() {
		return inputs.get(index++);
	}

	@Override
	public boolean hasNext() {
		return index < inputs.size();
	}

}
