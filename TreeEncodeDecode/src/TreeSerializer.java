import java.util.*;


class Node {
	int val;
	List<Node> children = new ArrayList<Node>();
	Node(int val) {
		this.val = val;
	}
}

public class TreeSerializer {
	public String encode(Node root) {
		StringBuilder b = new StringBuilder();
		b.append("^");
		b.append(String.valueOf(root.val));
		for (Node n: root.children) {
			b.append(encode(n));
		}
		b.append("$");
		return b.toString();
	}
	
	public Node decode(String s) {
		Stack<Node> stack = new Stack<Node>();
		Node root = null;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '^') {
				StringBuilder b = new StringBuilder();
				int p = i+1;
				while (Character.isDigit(s.charAt(p))) b.append(s.charAt(p++));
				i = p-1;
				int value = Integer.parseInt(b.toString());
				Node node = new Node(value);
				if (stack.isEmpty()) {
					root = node;
				} else {
					stack.peek().children.add(node);
				}
				stack.push(node);
			}
			else if (s.charAt(i) == '$') {
				stack.pop();
			}
		}
		return root;
	}
	
}
