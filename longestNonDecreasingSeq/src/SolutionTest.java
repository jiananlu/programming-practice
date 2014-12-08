import static org.junit.Assert.*;

import org.junit.Test;


public class SolutionTest {

	@Test
	public void test() {
		Solution s = new Solution();
		assertEquals(6, s.longestNonDecSeq(new int[]{1,2,5,2,8,6,3,6,9,7}));
		assertEquals(4, s.longestNonDecSeq(new int[]{3, 1, 5, 2, 7, 6, 9}));
	}

}
