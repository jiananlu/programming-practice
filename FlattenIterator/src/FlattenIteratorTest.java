import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;


public class FlattenIteratorTest {

	@Test
	public void test() {
		List<Iterator<Integer>> iterators = new ArrayList<Iterator<Integer>>();
		List<Integer> arr1 = new ArrayList<Integer>();
		arr1.add(1);
		arr1.add(3);
		arr1.add(5);
		List<Integer> arr2 = new ArrayList<Integer>();
		arr2.add(2);
		arr2.add(4);
		List<Integer> arr3 = new ArrayList<Integer>();
		iterators.add(arr1.iterator());
		iterators.add(arr2.iterator());
		iterators.add(arr3.iterator());
		
		FlattenIterator<Integer> iter = new FlattenIterator<Integer>(iterators);
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}

}
