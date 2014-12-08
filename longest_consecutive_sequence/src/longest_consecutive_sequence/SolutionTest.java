package longest_consecutive_sequence;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void test() {
		Solution s = new Solution();
		assertEquals(14, s.longestConsecutive(new int[]{-6,6,-9,-7,0,3,4,-2,2,-1,9,-9,5,-3,6,1,5,-1,-2,9,-9,-4,-6,-5,6,-1,3}));
	}

}
