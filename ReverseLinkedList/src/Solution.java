class Node {
	int val;
	Node next;
	Node(int val) {
		this.val = val;
	}
	
	static Node prepend(Node n, int val) {
		Node t = new Node(val);
		t.next = n;
		return t;
	}
}

public class Solution {
	public Node reverse(Node head) {
		Node p = head;
		Node res = null;
		while (p != null) {
			Node.prepend(res, p.val);
			p = p.next;
		}
		return res;
	}
	
	
}
