import static org.junit.Assert.*;

import org.junit.Test;


public class SolutionTest {

	@Test
	public void test() {
		Solution s = new Solution();
		for (int i = 1; i <= 20; i++) {
			System.out.println(s.getAllProducts(i));
		}
	}

}
