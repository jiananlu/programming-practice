import static org.junit.Assert.*;

import org.junit.Test;


public class SolutionTest {

	@Test
	public void test() {
		Solution s = new Solution();
		s.isInterleave("aacaac", "aacaaeaac", "aacaaeaaeaacaac");
	}

}
