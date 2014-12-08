package bst_next_value;

public class Solution {
	class Node {
		int val;
		Node left;
		Node right;
	}
	
	public int nextValue(Node root, int value) {
		Node p = root, parent = root;
		while(p!=null) {
			if (value == p.val) {
				if (p.right != null) return leftMost(p).val;
				else return parent.val;
			} else if (value < p.val) {
				parent = p;
				p = p.left;
			} else {
				p = p.right;
			}
		}
		return -1; // no next value found
	}
	
	Node leftMost(Node root) {
		Node p = root.right;
		while (p.left!=null) p = p.left;
		return p;
	}
}
