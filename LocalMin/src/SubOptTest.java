
import org.junit.Test;


public class SubOptTest {

	@Test
	public void test() {
		int[] data = new int[]{0,6,2,0,0,7,8,11,21,4,9};
		int k = 4;
		helper(new SubOpt(), data, k);
		helper(new HeapSolution(), data, k);
		helper(new DequeSol(), data, k);
	}

	void helper(Solution s, int[]input, int k) {
		
		for (int i: s.localMin(input, k)) {
			System.out.print(i+ " ");
		}
		System.out.println();
	}
}
