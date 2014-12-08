
public class StdoutOutputStream<T> implements OutputStream<T> {

	@Override
	public void emit(T data) {
		System.out.println(data);
	}
}
