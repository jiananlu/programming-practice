import static org.junit.Assert.*;

import org.junit.Test;


public class StringRearrangerTest {

	@Test
	public void test() {
		StringRearranger sr = new StringRearranger();
		assertEquals("abcaebca", sr.rearrange("caabacbe", 2));
		assertEquals(null, sr.rearrange("aaaccc", 2));
	}

}
