package solution;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void test() {
		Solution sol = new Solution();
		int[] input = new int[]{4, 2};
		int res = sol.largestRectangleArea(input);
		assertEquals(4, res);
	}

}
