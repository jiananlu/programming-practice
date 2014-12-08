import static org.junit.Assert.*;

import org.junit.Test;


public class SolutionTest {

	@Test
	public void test() {
		Solution sol = new Solution();
		int[] coins = new int[]{1, 3, 5, 10};
		assertEquals(1, sol.minCoins(coins, 1));
		assertEquals(2, sol.minCoins(coins, 2));
		assertEquals(1, sol.minCoins(coins, 3));
		assertEquals(2, sol.minCoins(coins, 4));
		assertEquals(1, sol.minCoins(coins, 5));
		assertEquals(2, sol.minCoins(coins, 6));
		assertEquals(3, sol.minCoins(coins, 7));
		assertEquals(2, sol.minCoins(coins, 8));
		assertEquals(3, sol.minCoins(coins, 9));
		assertEquals(1, sol.minCoins(coins, 10));
		assertEquals(2, sol.minCoins(coins, 11));
		assertEquals(3, sol.minCoins(coins, 12));
		assertEquals(21, sol.minCoins(coins, 187));
	}

}
