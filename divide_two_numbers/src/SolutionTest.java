import static org.junit.Assert.*;

import org.junit.Test;


public class SolutionTest {

	@Test
	public void test() {
		
		Solution s = new Solution();
		System.out.println(s.divide(2147483647, 1));
		System.out.println(-2147483648l/-1l);
	}

}
