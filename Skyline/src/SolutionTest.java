import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;


public class SolutionTest {

	@Test
	public void test() {
		List<Block> blocks = new ArrayList<Block>();
		blocks.add(new Block(1, 5, 4));
		blocks.add(new Block(2, 8, 2));
		blocks.add(new Block(6, 10, 6));
		Solution s = new Solution();
		
		for (Point p: s.skyliner(blocks)) {
			System.out.println(p);
		}
	}

}
