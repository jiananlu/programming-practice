
public class Solution {
	public String solve(String s1, String s2) {
		int[][] res = new int[s2.length()+1][s1.length()+1];
		int x = 0, y = 0;
		for (y = 1; y <= s2.length(); y++) {
			for (x = 1; x <= s1.length(); x++) {
				if (s1.charAt(x-1) == s2.charAt(y-1)) {
					res[y][x] = res[y-1][x-1] + 1;
				} else {
					res[y][x] = Math.max(res[y-1][x], res[y][x-1]);
				}
			}
		}
		x = s1.length(); y = s2.length();
		StringBuilder b = new StringBuilder();
		int p = res[y][x];
		while (x >= 0) {
			if (res[y][x] == p) x--;
			else {
				y--;
				p = res[y][x];
				b.insert(0, s1.charAt(x));
			}
		}
		return b.toString();
	}
}
