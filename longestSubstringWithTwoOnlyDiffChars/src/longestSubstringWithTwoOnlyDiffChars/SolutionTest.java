package longestSubstringWithTwoOnlyDiffChars;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void test() {
		helper("ababcbcbaaabbdef");
		helper("a");
		helper("");
		helper(" ");
		helper("aa");
		helper("aaaaa");
		helper("aaaaabbbbb");
		helper("ababababa");
		helper("ababababac");
		helper("cababababa");
		helper("aaaaabbbbbccccc");
		helper("abc");
		helper(null);
	}
	
	void helper(String ss) {
		Solution s = new Solution();
		assertEquals(s.solve(ss), s.solve1(ss));
	}

}
