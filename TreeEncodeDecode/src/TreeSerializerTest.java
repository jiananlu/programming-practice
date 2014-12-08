
import java.util.*;

import org.junit.Test;


public class TreeSerializerTest {
	
	void printTree(Node root) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while (!q.isEmpty()) {
			Node p = q.remove();
			System.out.print(p.val+"->");
			for (Node n: p.children) {
				q.add(n);
			}
		}
	}

	@Test
	public void test() {
		TreeSerializer ts = new TreeSerializer();
		
		Node root = new Node(1);
		Node c1 = new Node(2), c2 = new Node(4);
		root.children.add(c1);
		root.children.add(c2);
		c1.children.add(new Node(3));
		c2.children.add(new Node(5));
		c2.children.add(new Node(6));
		printTree(root);
		System.out.println();
		String encoded = ts.encode(root);
		System.out.println(encoded);
		Node decoded = ts.decode(encoded);
		System.out.println();
		printTree(decoded);
		
	}

}
