import static org.junit.Assert.*;
import org.junit.Test;


public class SolutionTest {

	@Test
	public void test() {
		Solution s = new Solution();
		assertEquals(s.match("ab*cd", "abefcd"), true);
		assertEquals(s.match("abc", "abc"), true);
		assertEquals(s.match("abc", "abcd"), false);
		assertEquals(s.match("ab*ba", "aba"), false);
		assertEquals(s.match("*abc", "abc"), true);
		assertEquals(s.match("*abc", "abcac"), false);
		assertEquals(s.match("abc*", "abc"), true);
		assertEquals(s.match("abc*", "ababc"), false);
		assertEquals(s.match("*", "abc"), true);
		assertEquals(s.match("*abc", "!!!abc"), true);
		assertEquals(s.match("abc*", "abc*"), true);
	}

}
