import java.util.*;
import org.junit.Test;


public class PeekIteratorTest {

	@Test
	public void test() {
		List<Integer> arr = new ArrayList<Integer>();
		arr.add(1);
		arr.add(2);
		arr.add(3);
		arr.add(4);
		
		PeekIterator<Integer> iter = new PeekIterator<Integer>(arr.iterator());
		System.out.println(iter.peek());
		System.out.println(iter.peek());
		System.out.println(iter.next());
		System.out.println(iter.peek());
		System.out.println(iter.next());
		System.out.println(iter.peek());
		System.out.println(iter.hasNext());
		System.out.println(iter.peek());
		System.out.println(iter.next());
		System.out.println(iter.peek());
		System.out.println(iter.peek());
		System.out.println(iter.next());
		System.out.println(iter.peek());
		System.out.println(iter.hasNext());
	}

}
