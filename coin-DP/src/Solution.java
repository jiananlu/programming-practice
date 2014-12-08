public class Solution {
	public int minCoins(int[] coins, int sum) {
		int[] res = new int[sum+1];
		res[0] = 0;
		for (int i = 1; i <= sum; i++) {
			res[i] = Integer.MAX_VALUE;
			for (int v: coins) {
				if (v <= i) {
					if (res[i - v] < res[i]) {
						res[i] = res[i - v] + 1;
					}
				}
			}
		}
		return res[sum];
	}
}
