package flatten_bin_tree;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void test() {
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		root.left = left;
		Solution s = new Solution();
		s.flatten(root);
		TreeNode p = root;
		while (p!=null) {
			System.out.print(p.val+"->");
			p = p.right;
		}
	}

}
