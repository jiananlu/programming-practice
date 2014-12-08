import static org.junit.Assert.*;

import org.junit.Test;


public class SolutionTest {

	@Test
	public void test() {
		Solution s = new Solution();
		System.out.println(s.findMedianSortedArrays(new int[]{1,3,4}, new int[]{2}));
	}

}
