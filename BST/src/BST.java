class Node {
	int value;
	Node left;
	Node right;
	Node(int value) {
		this.value = value;
	}
	void print() {
		String leftStr = left == null ? "null": String.valueOf(left.value);
		String rightStr = right == null ? "null": String.valueOf(right.value);
		System.out.println(String.format("%d [%s, %s]", value, leftStr, rightStr));
		if (left != null) left.print();
		if (right != null) right.print();
	}
}

public class BST {
	Node root;
	void insert(int value) {
		root = insert(root, value);
	}
	void remove(int value) {
		remove(root, value);
	}
	Node remove(Node root, int value) {
		if (root == null) return null;
		if (value < root.value) {
			root.left = remove(root.left, value);
			return root;
		} else if (value > root.value) {
			root.right = remove(root.right, value);
			return root;
		} else {
			if (root.left == null || root.right == null) {
				if (root.left == null && root.right == null) {
					return null;
				}
				if (root.left != null) return root.left;
				if (root.right != null) return root.right;
			} else {
				if (root.left.right == null) {
					root.value = root.left.value;
					root.left = remove(root.left, root.left.value);
				} else {
					Node p = root.left;
					while (p.right.right != null) {
						p = p.right;
					}
					root.value = p.right.value;
					p.right = remove(p.right, p.right.value);
				}
			}
		}
		return root;
		
	}
	Node insert(Node root, int value) {
		if (root == null) return new Node(value);
		if (value > root.value) {
			root.right = insert(root.right, value);
		}
		else if (value < root.value) {
			root.left = insert(root.left, value);
		}
		return root;
	}
	void print() {
		if (root == null) {
			System.out.println("null");
			return;
		}
		root.print();
	}
}
