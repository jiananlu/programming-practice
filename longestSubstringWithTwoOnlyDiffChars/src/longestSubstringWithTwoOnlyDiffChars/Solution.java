package longestSubstringWithTwoOnlyDiffChars;

public class Solution {
	public String solve1(String s) {
		if (s == null) return null;
		
		String longest = "";
		for (int i = 0; i < s.length(); i++) {
			char curr = s.charAt(i);
			Character other = null;
			int j = i+1;
			for (; j < s.length(); j++) {
				if (s.charAt(j) == curr) continue;
				if (other == null) other = s.charAt(j);
				else if (other != s.charAt(j)) {
					break;
				}
			}
			String str = s.substring(i, j);
			longest = str.length() > longest.length() ? str : longest;
			if (j == s.length()) break;
		}
		return longest;
	}
	
	public String solve(String s) {
		if (s == null || s.length() <= 1) return s;
		char curr = s.charAt(0);
		Character other = null;
		int b = 0, b1 = 0;
		String longest = "";
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == curr) continue;
			if (other == null || s.charAt(i) == other) {
				other = curr;
				curr = s.charAt(i);
				b1 = i;
				continue;
			}
			String st = s.substring(b, i);
			longest = st.length() > longest.length()? st: longest;
			b = b1;
			b1 = i;
			other = curr;
			curr = s.charAt(i);
			
		}
		return longest;
	}
}
